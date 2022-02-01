package com.tencent.viola.ui.adapter;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.MethodAbsAdd;
import com.tencent.viola.ui.component.VCell;
import com.tencent.viola.ui.component.VRecyclerList;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.diff.DomDiffUtils;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectCell;
import com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VRecyclerViewAdapter
  extends RecyclerView.Adapter<VRecyclerViewAdapter.VH>
{
  public static final String TAG = "VRecyclerViewAdapter";
  private VRecyclerViewAdapter.CellEventListener mCellEventListener;
  private SparseIntArray mCurrentVisPos = new SparseIntArray();
  private List<DomObject> mDataList = new ArrayList();
  private VRecyclerViewAdapter.DiffItemAnimListener mDiffItemAnimListener;
  private DOMActionContext mDomActionContext;
  private boolean mHasFooter;
  private boolean mHasHeader;
  private int mLastDataSize;
  private VRecyclerList mRecyclerList;
  
  public VRecyclerViewAdapter(VRecyclerList paramVRecyclerList)
  {
    String str = paramVRecyclerList.getInstance().getInstanceId();
    this.mDomActionContext = ViolaSDKManager.getInstance().getDomManager().getDomContext(str);
    this.mRecyclerList = paramVRecyclerList;
    if (this.mRecyclerList.getDomObject() != null)
    {
      this.mDataList.addAll(this.mRecyclerList.getDomObject().mDomChildren);
      detectFooterOrHeader(this.mDataList);
      setRealLastSize(this.mDataList.size());
    }
  }
  
  private void detectFooterOrHeader(List<DomObject> paramList)
  {
    if (paramList == null) {}
    label46:
    do
    {
      return;
      DomObject localDomObject;
      for (;;)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localDomObject = (DomObject)paramList.next();
          if (!ViolaUtils.isRefresh(localDomObject)) {
            break label46;
          }
          this.mHasHeader = true;
        }
      }
      if ("footer-refresh".equals(localDomObject.getType())) {
        this.mHasFooter = true;
      }
    } while ((!this.mHasHeader) || (!this.mHasFooter));
  }
  
  private void doNotifyItemDeleteWithAnim(int paramInt)
  {
    View localView = getDoAnimView(paramInt);
    if ((localView != null) && (localView.getTop() < 0))
    {
      ViolaLogUtils.d("VRecyclerViewAdapter", "doNotifyItemDeleteWithAnim  startSpecialRemoveAnimation start,index:" + paramInt);
      DefaultRecycleItemAnimator.startSpecialRemoveAnimation(localView, new VRecyclerViewAdapter.2(this, paramInt));
      return;
    }
    if (paramInt != -1) {
      this.mDataList.remove(paramInt);
    }
    this.mDiffItemAnimListener.startDiffItemAnim();
    if (this.mHasHeader) {
      notifyItemRemoved(paramInt - 1);
    }
    for (;;)
    {
      if ((paramInt - 1 != this.mDataList.size() - 1) && (this.mHasHeader)) {
        notifyItemRangeChanged(paramInt - 1, 0);
      }
      ViolaLogUtils.d("VRecyclerViewAdapter", "doNotifyItemDeleteWithAnim  startSystemRemoveAnimation finish,index:" + paramInt);
      return;
      notifyItemRemoved(paramInt);
    }
  }
  
  private void doNotifyItemInsertWithAnim(int paramInt)
  {
    int i;
    if (this.mHasHeader)
    {
      i = paramInt - 1;
      if ((this.mRecyclerList.getHostView() == null) || (i < this.mRecyclerList.getFirstVisiableItemPosition()) || (i > ((VRecyclerView)this.mRecyclerList.getHostView()).getLastVisibleItemPosition())) {
        break label122;
      }
      this.mDiffItemAnimListener.startDiffItemAnim();
      label58:
      if (!this.mHasHeader) {
        break label132;
      }
      notifyItemInserted(paramInt - 1);
    }
    for (;;)
    {
      if (((this.mHasHeader) && (paramInt == 1)) || ((!this.mHasHeader) && (paramInt == 0) && (this.mDiffItemAnimListener.getFirstVisiableItemPosition() == 0))) {
        this.mDiffItemAnimListener.scrollToTop();
      }
      return;
      i = paramInt;
      break;
      label122:
      this.mRecyclerList.onAnimFinish();
      break label58;
      label132:
      notifyItemInserted(paramInt);
    }
  }
  
  private void fixBg(View paramView)
  {
    if (paramView != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        paramView.setBackgroundColor(0);
      }
    }
    else {
      return;
    }
    paramView.setBackgroundDrawable(new ColorDrawable(0));
  }
  
  private View getDoAnimView(int paramInt)
  {
    VRecyclerView localVRecyclerView = (VRecyclerView)this.mRecyclerList.getHostView();
    if (localVRecyclerView == null) {
      return null;
    }
    int i = paramInt;
    if (this.mHasHeader) {
      i = paramInt - 1;
    }
    paramInt = localVRecyclerView.getFirstVisibleItemPosition();
    if ((i >= paramInt) && (i <= localVRecyclerView.getLastVisibleItemPosition())) {
      return localVRecyclerView.getChildAt(i - paramInt);
    }
    return null;
  }
  
  private int getRealPosition(int paramInt)
  {
    int i = paramInt;
    if (this.mHasHeader) {
      i = paramInt + 1;
    }
    return i;
  }
  
  private boolean ifNeedDoItemAnim()
  {
    return (this.mDiffItemAnimListener != null) && (this.mDiffItemAnimListener.isDiffItemAnimEnable());
  }
  
  private void internalNotifyItemInsert(int paramInt)
  {
    if ((this.mRecyclerList != null) && (this.mRecyclerList.disableAutoScroll()))
    {
      notifyItemChanged(paramInt);
      return;
    }
    notifyItemInserted(paramInt);
  }
  
  private void onBindCell(VCell paramVCell)
  {
    if (paramVCell == null) {
      return;
    }
    paramVCell.applyLayout();
    paramVCell.applyEvents();
    paramVCell.bindData();
  }
  
  private void onCreateAndSetRealView(VRecyclerViewAdapter.VH paramVH, DomObject paramDomObject)
  {
    if ((paramVH == null) || (paramDomObject == null)) {}
    do
    {
      return;
      paramVH.mVCell = onCreateVCell(paramDomObject);
    } while (paramVH.mVCell == null);
    ((ViewGroup)paramVH.itemView).addView(paramVH.mVCell.getRealView());
  }
  
  private VCell onCreateVCell(DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      paramDomObject = null;
    }
    VCell localVCell;
    do
    {
      do
      {
        return paramDomObject;
        paramDomObject.lazy(false);
        localVCell = (VCell)MethodAbsAdd.generateComponentTree(this.mDomActionContext, paramDomObject, this.mRecyclerList);
        paramDomObject = localVCell;
      } while (localVCell == null);
      localVCell.lazy(false);
      paramDomObject = localVCell;
    } while (localVCell.getHostView() != null);
    localVCell.createView();
    return localVCell;
  }
  
  private void setRealLastSize(int paramInt)
  {
    if (paramInt <= 0) {
      this.mLastDataSize = 0;
    }
    do
    {
      return;
      this.mLastDataSize = paramInt;
      if (this.mHasHeader) {
        this.mLastDataSize -= 1;
      }
    } while (!this.mHasFooter);
    this.mLastDataSize -= 1;
  }
  
  public DomObject getItem(int paramInt)
  {
    paramInt = getRealPosition(paramInt);
    if ((this.mDataList == null) || (paramInt < 0) || (paramInt >= this.mDataList.size())) {
      return null;
    }
    return (DomObject)this.mDataList.get(paramInt);
  }
  
  public int getItemCount()
  {
    int j;
    if ((this.mDataList == null) || (this.mDataList.isEmpty())) {
      j = 0;
    }
    int i;
    do
    {
      return j;
      j = this.mDataList.size();
      i = j;
      if (this.mHasHeader) {
        i = j - 1;
      }
      j = i;
    } while (!this.mHasFooter);
    return i - 1;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.mDataList == null) {}
    do
    {
      return -1L;
      paramInt = getRealPosition(paramInt);
    } while ((paramInt < 0) || (paramInt > this.mDataList.size() - 1));
    return Long.parseLong(((DomObject)this.mDataList.get(paramInt)).getRef());
  }
  
  public int getItemViewType(int paramInt)
  {
    DomObject localDomObject = getItem(paramInt);
    if ((localDomObject instanceof DomObjectCell)) {
      ((DomObjectCell)localDomObject).getCellType();
    }
    return 0;
  }
  
  public boolean isRecycleHasFooter()
  {
    return this.mHasFooter;
  }
  
  public boolean isRecycleHasHeader()
  {
    return this.mHasHeader;
  }
  
  public void notifyItemInsert(DomObject paramDomObject, int paramInt)
  {
    if (paramDomObject == null) {
      return;
    }
    if (!this.mDataList.contains(paramDomObject))
    {
      if ((paramInt < 0) || (paramInt > this.mDataList.size())) {
        break label123;
      }
      this.mDataList.add(paramInt, paramDomObject);
      if (!ifNeedDoItemAnim()) {
        break label115;
      }
      doNotifyItemInsertWithAnim(paramInt);
    }
    for (;;)
    {
      ViolaLogUtils.d("VRecyclerViewAdapter", "insert, dataSize: " + this.mDataList.size() + ", index: " + paramInt + ", hasHeader: " + this.mHasHeader);
      return;
      label115:
      internalNotifyItemInsert(paramInt);
      continue;
      label123:
      if (paramInt == -1)
      {
        this.mDataList.add(paramDomObject);
        if (ifNeedDoItemAnim()) {
          doNotifyItemInsertWithAnim(this.mDataList.size());
        } else {
          internalNotifyItemInsert(this.mDataList.size());
        }
      }
    }
  }
  
  public void notifyItemRemove(DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      return;
    }
    int i = this.mDataList.indexOf(paramDomObject);
    ViolaLogUtils.d("VRecyclerViewAdapter", "notifyRemove, position: " + i);
    if (ifNeedDoItemAnim())
    {
      doNotifyItemDeleteWithAnim(i);
      return;
    }
    if (i != -1) {
      this.mDataList.remove(paramDomObject);
    }
    notifyItemRemoved(i);
  }
  
  public void notifyWhenRecyclerListReuse(List<DomObject> paramList)
  {
    if (paramList == null) {
      return;
    }
    detectFooterOrHeader(paramList);
    setRealLastSize(paramList.size());
    this.mDataList.clear();
    this.mDataList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(VRecyclerViewAdapter.VH paramVH, int paramInt)
  {
    DomObject localDomObject = getItem(paramInt);
    if (localDomObject == null)
    {
      ViolaLogUtils.d("VRecyclerViewAdapter", "onBindViewHolder: dom is null, may be position is invalid!");
      EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, paramInt, getItemId(paramInt));
      return;
    }
    if (paramVH.mVCell == null)
    {
      onCreateAndSetRealView(paramVH, localDomObject);
      onBindCell(paramVH.mVCell);
    }
    for (;;)
    {
      this.mCurrentVisPos.put(paramInt, paramInt);
      paramVH.position = paramInt;
      fixBg(paramVH.itemView);
      break;
      if (!paramVH.mVCell.getRef().equals(localDomObject.getRef())) {
        break label126;
      }
      if (((DomObjectCell)paramVH.mVCell.getDomObject()).needRefresh) {
        onBindCell(paramVH.mVCell);
      }
    }
    label126:
    if (this.mCurrentVisPos.get(paramVH.position, -1) != -1) {}
    for (boolean bool = true;; bool = false)
    {
      DomDiffUtils.diffComponent(paramVH.mVCell, localDomObject, this.mDomActionContext, new VRecyclerViewAdapter.1(this, paramVH), bool);
      paramVH.mVCell.bindDomobj(localDomObject);
      paramVH.mVCell.needFresh(false);
      ((DomObjectCell)localDomObject).needRefresh = false;
      onBindCell(paramVH.mVCell);
      break;
    }
  }
  
  public VRecyclerViewAdapter.VH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    paramViewGroup = new FrameLayout(paramViewGroup.getContext());
    paramViewGroup.setLayoutParams(localLayoutParams);
    ViolaLogUtils.d("VRecyclerViewAdapter", "onCreateViewHolder");
    return new VRecyclerViewAdapter.VH(this, paramViewGroup);
  }
  
  public void onViewAttachedToWindow(VRecyclerViewAdapter.VH paramVH)
  {
    if (this.mCellEventListener != null) {
      this.mCellEventListener.onCellAppear(paramVH);
    }
  }
  
  public void onViewDetachedFromWindow(VRecyclerViewAdapter.VH paramVH)
  {
    if (this.mCellEventListener != null) {
      this.mCellEventListener.onCellDisappear(paramVH);
    }
    this.mCurrentVisPos.delete(paramVH.position);
  }
  
  public void setCellEventListener(VRecyclerViewAdapter.CellEventListener paramCellEventListener)
  {
    this.mCellEventListener = paramCellEventListener;
  }
  
  public void setDiffItemAnimListener(VRecyclerViewAdapter.DiffItemAnimListener paramDiffItemAnimListener)
  {
    this.mDiffItemAnimListener = paramDiffItemAnimListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.adapter.VRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */