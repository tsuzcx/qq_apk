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
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
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
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    do
    {
      DomObject localDomObject;
      for (;;)
      {
        if (!paramList.hasNext()) {
          return;
        }
        localDomObject = (DomObject)paramList.next();
        if (!ViolaUtils.isRefresh(localDomObject)) {
          break;
        }
        this.mHasHeader = true;
      }
      if ("footer-refresh".equals(localDomObject.getType())) {
        this.mHasFooter = true;
      }
    } while ((!this.mHasHeader) || (!this.mHasFooter));
  }
  
  private void doNotifyItemDeleteWithAnim(int paramInt)
  {
    Object localObject = getDoAnimView(paramInt);
    if ((localObject != null) && (((View)localObject).getTop() < 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNotifyItemDeleteWithAnim  startSpecialRemoveAnimation start,index:");
      localStringBuilder.append(paramInt);
      ViolaLogUtils.d("VRecyclerViewAdapter", localStringBuilder.toString());
      DefaultRecycleItemAnimator.startSpecialRemoveAnimation((View)localObject, new VRecyclerViewAdapter.2(this, paramInt));
      return;
    }
    if (paramInt != -1) {
      this.mDataList.remove(paramInt);
    }
    this.mDiffItemAnimListener.startDiffItemAnim();
    if (this.mHasHeader) {
      notifyItemRemoved(paramInt - 1);
    } else {
      notifyItemRemoved(paramInt);
    }
    int i = paramInt - 1;
    if ((i != this.mDataList.size() - 1) && (this.mHasHeader)) {
      notifyItemRangeChanged(i, 0);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doNotifyItemDeleteWithAnim  startSystemRemoveAnimation finish,index:");
    ((StringBuilder)localObject).append(paramInt);
    ViolaLogUtils.d("VRecyclerViewAdapter", ((StringBuilder)localObject).toString());
  }
  
  private void doNotifyItemInsertWithAnim(int paramInt)
  {
    int i;
    if (this.mHasHeader) {
      i = paramInt - 1;
    } else {
      i = paramInt;
    }
    if ((this.mRecyclerList.getHostView() != null) && (i >= this.mRecyclerList.getFirstVisiableItemPosition()) && (i <= ((VRecyclerView)this.mRecyclerList.getHostView()).getLastVisibleItemPosition())) {
      this.mDiffItemAnimListener.startDiffItemAnim();
    } else {
      this.mRecyclerList.onAnimFinish();
    }
    if (this.mHasHeader) {
      notifyItemInserted(paramInt - 1);
    } else {
      notifyItemInserted(paramInt);
    }
    if (((this.mHasHeader) && (paramInt == 1)) || ((!this.mHasHeader) && (paramInt == 0) && (this.mDiffItemAnimListener.getFirstVisiableItemPosition() == 0))) {
      this.mDiffItemAnimListener.scrollToTop();
    }
  }
  
  private void fixBg(View paramView)
  {
    if (paramView != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        paramView.setBackgroundColor(0);
        return;
      }
      paramView.setBackgroundDrawable(new ColorDrawable(0));
    }
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
    VRecyclerViewAdapter.DiffItemAnimListener localDiffItemAnimListener = this.mDiffItemAnimListener;
    return (localDiffItemAnimListener != null) && (localDiffItemAnimListener.isDiffItemAnimEnable());
  }
  
  private void internalNotifyItemInsert(int paramInt)
  {
    VRecyclerList localVRecyclerList = this.mRecyclerList;
    if ((localVRecyclerList != null) && (localVRecyclerList.disableAutoScroll()))
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
    if (ViolaUtils.isBindDataOpmOpen())
    {
      bindData(paramVCell);
      return;
    }
    paramVCell.applyLayout();
    paramVCell.applyEvents();
    paramVCell.bindData();
  }
  
  private void onCreateAndSetRealView(VRecyclerViewAdapter.VH paramVH, DomObject paramDomObject)
  {
    if (paramVH != null)
    {
      if (paramDomObject == null) {
        return;
      }
      paramVH.mVCell = onCreateVCell(paramDomObject);
      if (paramVH.mVCell != null) {
        ((ViewGroup)paramVH.itemView).addView(paramVH.mVCell.getRealView());
      }
    }
  }
  
  private VCell onCreateVCell(DomObject paramDomObject)
  {
    VCell localVCell = null;
    if (paramDomObject == null) {
      return null;
    }
    paramDomObject.lazy(false);
    Object localObject = MethodAbsAdd.generateComponentTree(this.mDomActionContext, paramDomObject, this.mRecyclerList);
    if ((localObject instanceof VCell))
    {
      localVCell = (VCell)localObject;
      localVCell.lazy(false);
      paramDomObject = localVCell;
      if (localVCell.getHostView() == null)
      {
        localVCell.createView();
        return localVCell;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cell dom is not vcell, domType: ");
      ((StringBuilder)localObject).append(paramDomObject.getType());
      ViolaLogUtils.e("VRecyclerViewAdapter", ((StringBuilder)localObject).toString());
      paramDomObject = localVCell;
    }
    return paramDomObject;
  }
  
  private void setRealLastSize(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.mLastDataSize = 0;
      return;
    }
    this.mLastDataSize = paramInt;
    if (this.mHasHeader) {
      this.mLastDataSize -= 1;
    }
    if (this.mHasFooter) {
      this.mLastDataSize -= 1;
    }
  }
  
  public void bindCell(VCell paramVCell)
  {
    if (paramVCell == null) {
      return;
    }
    bindData(paramVCell);
  }
  
  public void bindData(VComponent paramVComponent)
  {
    if (paramVComponent == null) {
      return;
    }
    paramVComponent.applyLayoutWithoutRecurse();
    paramVComponent.applyEventsWithoutRecurse();
    paramVComponent.bindDataWithoutRecurse();
    if ((paramVComponent instanceof VComponentContainer))
    {
      paramVComponent = (VComponentContainer)paramVComponent;
      int j = paramVComponent.getChildCount();
      int i = 0;
      while (i < j)
      {
        bindData(paramVComponent.getChild(i));
        i += 1;
      }
    }
  }
  
  public int findItemIndex(DomObject paramDomObject)
  {
    List localList = this.mDataList;
    if (localList != null)
    {
      if (paramDomObject == null) {
        return -1;
      }
      int i = localList.indexOf(paramDomObject);
      if (i >= 0) {
        return getRealPosition(i);
      }
    }
    return -1;
  }
  
  public DomObject getItem(int paramInt)
  {
    paramInt = getRealPosition(paramInt);
    List localList = this.mDataList;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (DomObject)this.mDataList.get(paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    List localList = this.mDataList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      int j = this.mDataList.size();
      int i = j;
      if (this.mHasHeader) {
        i = j - 1;
      }
      j = i;
      if (this.mHasFooter) {
        j = i - 1;
      }
      return j;
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.mDataList == null) {
      return -1L;
    }
    paramInt = getRealPosition(paramInt);
    if (paramInt >= 0)
    {
      if (paramInt > this.mDataList.size() - 1) {
        return -1L;
      }
      return Long.parseLong(((DomObject)this.mDataList.get(paramInt)).getRef());
    }
    return -1L;
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
    if (!this.mDataList.contains(paramDomObject)) {
      if ((paramInt >= 0) && (paramInt <= this.mDataList.size()))
      {
        this.mDataList.add(paramInt, paramDomObject);
        if (ifNeedDoItemAnim()) {
          doNotifyItemInsertWithAnim(paramInt);
        } else {
          internalNotifyItemInsert(paramInt);
        }
      }
      else if (paramInt == -1)
      {
        this.mDataList.add(paramDomObject);
        if (ifNeedDoItemAnim()) {
          doNotifyItemInsertWithAnim(this.mDataList.size());
        } else {
          internalNotifyItemInsert(this.mDataList.size());
        }
      }
    }
    paramDomObject = new StringBuilder();
    paramDomObject.append("insert, dataSize: ");
    paramDomObject.append(this.mDataList.size());
    paramDomObject.append(", index: ");
    paramDomObject.append(paramInt);
    paramDomObject.append(", hasHeader: ");
    paramDomObject.append(this.mHasHeader);
    ViolaLogUtils.d("VRecyclerViewAdapter", paramDomObject.toString());
  }
  
  public void notifyItemRemove(DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      return;
    }
    int i = this.mDataList.indexOf(paramDomObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyRemove, position: ");
    localStringBuilder.append(i);
    ViolaLogUtils.d("VRecyclerViewAdapter", localStringBuilder.toString());
    if (ifNeedDoItemAnim())
    {
      doNotifyItemDeleteWithAnim(i);
      return;
    }
    if (i != -1)
    {
      this.mDataList.remove(paramDomObject);
      notifyItemRemoved(i);
    }
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
    }
    else
    {
      if (paramVH.mVCell == null)
      {
        onCreateAndSetRealView(paramVH, localDomObject);
        onBindCell(paramVH.mVCell);
      }
      else if (paramVH.mVCell.getRef().equals(localDomObject.getRef()))
      {
        if (((DomObjectCell)paramVH.mVCell.getDomObject()).needRefresh) {
          onBindCell(paramVH.mVCell);
        }
      }
      else
      {
        boolean bool;
        if (this.mCurrentVisPos.get(paramVH.position, -1) != -1) {
          bool = true;
        } else {
          bool = false;
        }
        DomDiffUtils.diffComponent(paramVH.mVCell, localDomObject, this.mDomActionContext, new VRecyclerViewAdapter.1(this, paramVH), bool);
        paramVH.mVCell.bindDomobj(localDomObject);
        paramVH.mVCell.needFresh(false);
        ((DomObjectCell)localDomObject).needRefresh = false;
        onBindCell(paramVH.mVCell);
      }
      this.mCurrentVisPos.put(paramInt, paramInt);
      paramVH.position = paramInt;
      if (!ViolaUtils.isBindDataOpmOpen()) {
        fixBg(paramVH.itemView);
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramVH, paramInt, getItemId(paramInt));
  }
  
  public VRecyclerViewAdapter.VH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = new RecyclerView.LayoutParams(-2, -2);
    paramViewGroup = new FrameLayout(paramViewGroup.getContext());
    paramViewGroup.setLayoutParams(localLayoutParams);
    if (ViolaUtils.isBindDataOpmOpen()) {
      fixBg(paramViewGroup);
    }
    ViolaLogUtils.d("VRecyclerViewAdapter", "onCreateViewHolder");
    return new VRecyclerViewAdapter.VH(this, paramViewGroup);
  }
  
  public void onViewAttachedToWindow(VRecyclerViewAdapter.VH paramVH)
  {
    VRecyclerViewAdapter.CellEventListener localCellEventListener = this.mCellEventListener;
    if (localCellEventListener != null) {
      localCellEventListener.onCellAppear(paramVH);
    }
  }
  
  public void onViewDetachedFromWindow(VRecyclerViewAdapter.VH paramVH)
  {
    VRecyclerViewAdapter.CellEventListener localCellEventListener = this.mCellEventListener;
    if (localCellEventListener != null) {
      localCellEventListener.onCellDisappear(paramVH);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.adapter.VRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */