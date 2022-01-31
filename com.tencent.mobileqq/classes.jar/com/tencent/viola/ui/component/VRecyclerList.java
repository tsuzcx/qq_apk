package com.tencent.viola.ui.component;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.util.ArraySet;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.compatible.VComponentCompat;
import com.tencent.viola.compatible.VListCompat;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaInstance.ViolaPageListener;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter.CellEventListener;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter.DiffItemAnimListener;
import com.tencent.viola.ui.adapter.VRecyclerViewAdapter.VH;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectCell;
import com.tencent.viola.ui.dom.DomObjectWaterfallList;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.VFooterLayout;
import com.tencent.viola.ui.view.VFrameLayout;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator;
import com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator.DefaultAnimatorListener;
import com.tencent.viola.ui.view.list.RecycleLayoutManager;
import com.tencent.viola.ui.view.list.RecycleViewItemDecoration;
import com.tencent.viola.ui.view.list.VRecyclerView;
import com.tencent.viola.ui.view.list.VRecyclerView.OnGestureListener;
import com.tencent.viola.ui.view.overscroll.OverScrollHelper;
import com.tencent.viola.ui.view.refresh.VRefreshContentView.ContentViewProvider;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VRecyclerList
  extends VComponentContainer<VRecyclerView>
  implements VRecyclerViewAdapter.CellEventListener, VRecyclerViewAdapter.DiffItemAnimListener, DefaultRecycleItemAnimator.DefaultAnimatorListener, VRecyclerView.OnGestureListener
{
  private static final String TAG = "VRecyclerList";
  private static RecyclerView.RecycledViewPool mHorizontalRecycledViewPool;
  private boolean isCaluteSnapOffset = false;
  private VRecyclerViewAdapter mAdapter;
  private Set<String> mCellAppearSet = new ArraySet();
  private int mColumn = 1;
  private DefaultRecycleItemAnimator mDefaultRecycleItemAnimator;
  private boolean mDiffAnimEnable = false;
  private boolean mIsOverFlow = false;
  private boolean mIsSetInset = false;
  private boolean mNeedNotifyDataChange;
  public int mOrientation = 1;
  private VRefreshViewGroup mRealParentView;
  private RecycleViewItemDecoration mRecycleViewItemDecoration;
  private int mSnapOffset = 0;
  private VRecyclerList.RVUpdateOps updateOps = new VRecyclerList.RVUpdateOps(this);
  
  public VRecyclerList(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void calAndSetContentSize()
  {
    int j = 0;
    DomObject localDomObject1 = getDomObject();
    if (localDomObject1 == null) {}
    boolean bool;
    int k;
    int i;
    DomObject localDomObject2;
    do
    {
      return;
      int m = localDomObject1.getDomChildCount();
      bool = isVertical();
      k = 0;
      i = 0;
      if (k >= m) {
        break;
      }
      localDomObject2 = localDomObject1.getChild(k);
    } while (localDomObject2 == null);
    if (bool) {
      i = (int)(i + localDomObject2.getLayoutHeight());
    }
    for (;;)
    {
      k += 1;
      break;
      j = (int)(j + localDomObject2.getLayoutWidth());
    }
    if (bool) {
      j = (int)localDomObject1.getLayoutWidth();
    }
    for (;;)
    {
      super.setContentWidth(j);
      super.setContentHeight(i);
      return;
      i = (int)localDomObject1.getLayoutHeight();
    }
  }
  
  private float calFinalDistance(float paramFloat, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return 0.0F;
        if (paramString.equals("start"))
        {
          i = 0;
          continue;
          if (paramString.equals("center"))
          {
            i = 1;
            continue;
            if (paramString.equals("end")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return Math.abs(paramFloat) - Math.abs(paramInt1) + paramInt2;
    return Math.abs(paramFloat) - Math.abs(paramInt1) + paramInt2 - paramInt3 * 0.5F + paramInt4 * 0.5F;
    return Math.abs(paramFloat) - Math.abs(paramInt1) + paramInt2 - paramInt3 + paramInt4;
  }
  
  private float compatWithPagerSnap(float paramFloat)
  {
    VRecyclerView localVRecyclerView = (VRecyclerView)getHostView();
    if (localVRecyclerView == null) {}
    while (localVRecyclerView.getFirstVisibleItemPosition() != 0) {
      return paramFloat;
    }
    return paramFloat + localVRecyclerView.getSnapOffset();
  }
  
  private void createRealParentView()
  {
    if ((this.mRealParentView == null) && ((getContext() != null) || ((getInstance() != null) && (getInstance().getActivity() != null))))
    {
      if (getContext() != null) {
        this.mRealParentView = new VRefreshViewGroup(getContext());
      }
    }
    else {
      return;
    }
    this.mRealParentView = new VRefreshViewGroup(getInstance().getActivity());
  }
  
  private VRecyclerView createRecyclerView(Context paramContext)
  {
    try
    {
      int i = paramContext.getResources().getIdentifier("viola_recycler_list", "layout", paramContext.getPackageName());
      VRecyclerView localVRecyclerView2 = (VRecyclerView)LayoutInflater.from(paramContext).inflate(i, null);
      VRecyclerView localVRecyclerView1 = localVRecyclerView2;
      if (localVRecyclerView2 == null) {
        localVRecyclerView1 = createRecyclerViewOnFallback(paramContext);
      }
      return localVRecyclerView1;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.d("VRecyclerList", "inflate recyclerView error!");
    }
    return createRecyclerViewOnFallback(paramContext);
  }
  
  private VRecyclerView createRecyclerViewOnFallback(Context paramContext)
  {
    return new VRecyclerView(paramContext);
  }
  
  private void dealChildMarginWith(DomObject paramDomObject, FrameLayout.LayoutParams paramLayoutParams)
  {
    int i = getDomObject().indexOf(paramDomObject);
    if (!this.isCaluteSnapOffset)
    {
      if (getDomObject().getAttributes().containsKey("stickyOffset")) {
        this.mSnapOffset = ((int)FlexConvertUtils.converPxByViewportToRealPx(getDomObject().getAttributes().get("stickyOffset"), 750));
      }
      this.isCaluteSnapOffset = true;
    }
    if (this.mSnapOffset != 0)
    {
      if (i != 0) {
        break label82;
      }
      paramLayoutParams.setMargins(0, this.mSnapOffset, 0, 0);
    }
    label82:
    do
    {
      return;
      if ((i == 1) && (((VRecyclerViewAdapter)((VRecyclerView)getHostView()).getAdapter()).isRecycleHasHeader()))
      {
        paramLayoutParams.setMargins(0, this.mSnapOffset, 0, 0);
        return;
      }
      if (i == getDomObject().getChildCount() - 1)
      {
        paramLayoutParams.setMargins(0, 0, 0, FlexConvertUtils.getScreenHeight() - this.mSnapOffset * 4);
        return;
      }
    } while ((i != getDomObject().getChildCount() - 2) || (!((VRecyclerViewAdapter)((VRecyclerView)getHostView()).getAdapter()).isRecycleHasFooter()));
    paramLayoutParams.setMargins(0, 0, 0, FlexConvertUtils.getScreenHeight() - this.mSnapOffset * 4);
  }
  
  private RecyclerView.LayoutManager findLayoutManager(Context paramContext, RecyclerView paramRecyclerView)
  {
    DomObject localDomObject = getDomObject();
    if (localDomObject != null)
    {
      if ("waterfall-list".equals(localDomObject.getType()))
      {
        paramContext = new RecycleLayoutManager(this.mColumn, this.mOrientation);
        paramContext.setRecycleView(paramRecyclerView);
        paramRecyclerView = (DomObjectWaterfallList)localDomObject;
        paramContext.setColumn(paramRecyclerView.getColumn());
        paramContext.setCellWidth(paramRecyclerView.getCellWidth());
        paramContext.setParentWidth(paramRecyclerView.getDomParent().getLayoutWidth());
        paramContext.setItemPortraitInterval(paramRecyclerView.getLineSpacing());
        paramContext.setItemTransverseInterval(paramRecyclerView.getItemSpacing());
        paramContext.setInsetArry(paramRecyclerView.getInsetArry());
        paramContext.setAdapter(this.mAdapter);
        paramContext.setReverseLayout(false);
        return paramContext;
      }
      if ("horizontal".equals(ViolaUtils.getString(localDomObject.getAttributes().get("direction"), null))) {
        this.mOrientation = 0;
      }
      return new LinearLayoutManager(paramContext, this.mOrientation, false);
    }
    return new LinearLayoutManager(paramContext);
  }
  
  private JSONObject listFireBaseInfo(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    try
    {
      localJSONObject2.put("width", FlexConvertUtils.px2dip(getContentWidth()) + "dp");
      localJSONObject2.put("height", FlexConvertUtils.px2dip(getContentHeight()) + "dp");
      localJSONObject1.put("contentSize", localJSONObject2);
      localJSONObject3.put("x", FlexConvertUtils.px2dip(paramInt1) + "dp");
      localJSONObject3.put("y", FlexConvertUtils.px2dip(paramInt2) + "dp");
      localJSONObject1.put("contentOffset", localJSONObject3);
      localJSONObject1.put("frame", getFrameInfo());
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VRecyclerList", "listFireBaseInfo error :" + localException.getMessage());
    }
    return localJSONObject1;
  }
  
  private void listFireScrollEvent(String paramString, int paramInt1, int paramInt2)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    fireEvent(paramString, getFireEventArgs(paramString), listFireBaseInfo(paramInt1, paramInt2));
  }
  
  private void listFireTouchEvent(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    JSONObject localJSONObject = listFireBaseInfo(paramInt1, paramInt2);
    try
    {
      float f1 = getInstance().getMatchWindowsX();
      float f2 = getInstance().getMatchWindowsY();
      localJSONObject.put("pageX", FlexConvertUtils.px2dip(paramFloat1 - f1) + "dp");
      localJSONObject.put("pageY", FlexConvertUtils.px2dip(paramFloat2 - f2) + "dp");
      label114:
      fireEvent(paramString, getFireEventArgs(paramString), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label114;
    }
  }
  
  private void scrollByDistance(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mOrientation == 0)
    {
      paramInt2 = Math.abs(paramInt4) - Math.abs(paramInt1);
      paramInt1 = 0;
    }
    while (paramInt3 > 0)
    {
      ((VRecyclerView)getHostView()).smoothScrollBy(paramInt2, paramInt1);
      return;
      paramInt1 = Math.abs(paramInt4) - Math.abs(paramInt2);
      paramInt2 = 0;
    }
    ((VRecyclerView)getHostView()).scrollBy(paramInt2, paramInt1);
  }
  
  private void scrollByRef(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    int i = 1;
    float f2 = 0.0F;
    String str = getInstance().getInstanceId();
    DomObject localDomObject = ViolaUtils.findDomObject(str, paramString1);
    if (localDomObject == null) {
      return;
    }
    if (this.mOrientation == 1)
    {
      if (i == 0) {
        break label110;
      }
      f2 = calFinalDistance(compatWithPagerSnap(ViolaUtils.getLayoutYInList(str, paramString1)), paramInt3, paramInt1, paramString2, ((VRecyclerView)getHostView()).getHeight(), (int)localDomObject.getLayoutHeight());
    }
    label110:
    for (float f1 = 0.0F;; f1 = calFinalDistance(ViolaUtils.getLayoutXInList(str, paramString1), paramInt2, paramInt1, paramString2, ((VRecyclerView)getHostView()).getWidth(), (int)localDomObject.getLayoutWidth()))
    {
      if (paramInt4 <= 0) {
        break label145;
      }
      ((VRecyclerView)getHostView()).smoothScrollBy((int)f1, (int)f2);
      return;
      i = 0;
      break;
    }
    label145:
    ((VRecyclerView)getHostView()).scrollBy((int)f1, (int)f2);
  }
  
  private void setContentView(VRefreshContentView.ContentViewProvider paramContentViewProvider)
  {
    if (this.mRealParentView == null) {
      return;
    }
    this.mRealParentView.addInFirst(((VRecyclerView)getHostView()).getRefreshMoveOberver());
    this.mRealParentView.setContentViewProvider(paramContentViewProvider);
  }
  
  private void setFooterView(VFooterLayout paramVFooterLayout)
  {
    if (this.mRealParentView == null) {}
    do
    {
      return;
      this.mRealParentView.setFooterView(paramVFooterLayout);
    } while (!isCompatMode());
    paramVFooterLayout.setListener((VListCompat)getCompator());
  }
  
  private void setHeadView(VRefreshLayout paramVRefreshLayout)
  {
    if (this.mRealParentView == null) {}
    do
    {
      return;
      this.mRealParentView.add(paramVRefreshLayout.getRefreshMoveOberver());
      this.mRealParentView.setHeaderView(paramVRefreshLayout);
    } while (!isCompatMode());
    paramVRefreshLayout.addOnHeaderStateChangeListener((VListCompat)getCompator());
  }
  
  private void setReadParentOverFlow(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject;
    boolean bool1;
    if (this.mRealParentView != null)
    {
      localObject = this.mRealParentView;
      if (paramBoolean) {
        break label95;
      }
      bool1 = true;
      ((VRefreshViewGroup)localObject).setClipToPadding(bool1);
      localObject = this.mRealParentView;
      if (paramBoolean) {
        break label100;
      }
      bool1 = true;
      label39:
      ((VRefreshViewGroup)localObject).setClipChildren(bool1);
      if (this.mHost != null)
      {
        localObject = (VRecyclerView)this.mHost;
        if (paramBoolean) {
          break label105;
        }
        bool1 = true;
        label67:
        ((VRecyclerView)localObject).setClipToPadding(bool1);
        localObject = (VRecyclerView)this.mHost;
        if (paramBoolean) {
          break label110;
        }
      }
    }
    label95:
    label100:
    label105:
    label110:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((VRecyclerView)localObject).setClipChildren(paramBoolean);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label39;
      bool1 = false;
      break label67;
    }
  }
  
  private void tryScrollEvent(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramVRecyclerView == null) {}
    for (;;)
    {
      return;
      int m = paramVRecyclerView.getChildCount();
      int i = 0;
      while (i < m)
      {
        Object localObject1 = paramVRecyclerView.getChildViewHolder(paramVRecyclerView.getChildAt(i));
        if ((localObject1 instanceof VRecyclerViewAdapter.VH))
        {
          localObject1 = (VRecyclerViewAdapter.VH)localObject1;
          if ((((VRecyclerViewAdapter.VH)localObject1).mVCell != null) && ((((VRecyclerViewAdapter.VH)localObject1).mVCell.getDomObject() instanceof DomObjectCell)))
          {
            Object localObject2 = ((DomObjectCell)((VRecyclerViewAdapter.VH)localObject1).mVCell.getDomObject()).getScrollEventList();
            localObject1 = getInstance().getInstanceId();
            if (localObject2 != null)
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                VComponent localVComponent = ViolaUtils.findComponent((String)localObject1, (String)((Iterator)localObject2).next());
                if (localVComponent != null)
                {
                  boolean bool;
                  label152:
                  int j;
                  if (this.mOrientation == 1)
                  {
                    bool = true;
                    if (!bool) {
                      break label192;
                    }
                    j = paramInt2;
                    label160:
                    if (!bool) {
                      break label198;
                    }
                  }
                  label192:
                  label198:
                  for (int k = paramVRecyclerView.getContentOffsetY();; k = paramVRecyclerView.getContentOffsetX())
                  {
                    localVComponent.onScroll(paramVRecyclerView, bool, j, k);
                    break;
                    bool = false;
                    break label152;
                    j = paramInt1;
                    break label160;
                  }
                }
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void addEvent(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        super.addEvent(paramString);
        return;
        if (paramString.equals("loadMore"))
        {
          i = 0;
          continue;
          if (paramString.equals("touchDown"))
          {
            i = 1;
            continue;
            if (paramString.equals("touchUp"))
            {
              i = 2;
              continue;
              if (paramString.equals("scroll"))
              {
                i = 3;
                continue;
                if (paramString.equals("scrollEnd"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("dragBegin"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("dragEnd")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    this.mAppendEvents.add(paramString);
  }
  
  public void addSubView(View paramView, int paramInt) {}
  
  public void addSubViewOnIntercept(ViewGroup paramViewGroup, int paramInt)
  {
    ViolaUtils.addViewParentToView(paramViewGroup, getHostView(), paramInt);
  }
  
  public void bindData()
  {
    super.bindData();
    if (this.mNeedNotifyDataChange) {
      this.mAdapter.notifyWhenRecyclerListReuse(this.mDomObj.mDomChildren);
    }
    this.mNeedNotifyDataChange = false;
  }
  
  @JSMethod
  public void callExposureReport()
  {
    if (isCompatMode()) {
      ((VListCompat)getCompator()).callExposureReport();
    }
  }
  
  public void createChildViewAt(int paramInt)
  {
    Object localObject = rearrangeIndexAndGetChild(paramInt);
    if (((Pair)localObject).first != null)
    {
      localObject = (VComponent)((Pair)localObject).first;
      ((VComponent)localObject).createView();
      if ((((VComponent)localObject).getRealView() instanceof VRefreshLayout)) {
        setHeadView((VRefreshLayout)((VComponent)localObject).getRealView());
      }
      setContentView((VRefreshContentView.ContentViewProvider)getHostView());
      if ((((VComponent)localObject).getRealView() instanceof VFooterLayout)) {
        setFooterView((VFooterLayout)((VComponent)localObject).getRealView());
      }
    }
  }
  
  public <T extends VComponentCompat> T createCompator()
  {
    return new VListCompat(this, this.mDomObj);
  }
  
  public void createViewImpl()
  {
    createRealParentView();
    this.mHost = initComponentHostView(this.mContext);
    updateLifeCycle("created");
    int j = getChildCount();
    if (j == 0) {
      setContentView((VRefreshContentView.ContentViewProvider)getHostView());
    }
    for (;;)
    {
      if (j == 0) {
        calAndSetContentSize();
      }
      if ((this.mHost != null) && (!this.mIsOverFlow) && (!this.mIsSetInset))
      {
        ((VRecyclerView)this.mHost).setClipToPadding(true);
        ((VRecyclerView)this.mHost).setClipChildren(true);
      }
      return;
      int i = 0;
      while (i < j)
      {
        createChildViewAt(i);
        i += 1;
      }
    }
  }
  
  public void customFireEvent(String paramString1, String paramString2)
  {
    JSONArray localJSONArray = new JSONArray();
    if (!TextUtils.isEmpty(paramString2)) {
      localJSONArray.put(paramString2);
    }
    localJSONArray.put(paramString1);
    fireEvent(paramString1, localJSONArray, new JSONObject());
  }
  
  public void destroy()
  {
    super.destroy();
    if ((getInstance() != null) && (!TextUtils.isEmpty(getRef())) && (getRef().equals(getInstance().getMasterListRef()))) {
      getInstance().setMasterListRef(null);
    }
    if (this.mRealParentView != null) {
      this.mRealParentView.onDestroy();
    }
    if ((this.mOrientation == 0) && (mHorizontalRecycledViewPool != null))
    {
      mHorizontalRecycledViewPool.clear();
      mHorizontalRecycledViewPool = null;
    }
    if (this.mDefaultRecycleItemAnimator != null) {
      this.mDefaultRecycleItemAnimator.destroy();
    }
  }
  
  public ViewGroup.LayoutParams getChildLayoutParams(VComponent paramVComponent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramVComponent instanceof VCell))
    {
      paramView = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      dealChildMarginWith(paramVComponent.getDomObject(), paramView);
      return paramView;
    }
    paramView = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    if ((paramVComponent instanceof VFooter)) {
      paramInt5 = 0;
    }
    paramView.setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
    return paramView;
  }
  
  public int getFirstVisiableItemPosition()
  {
    if (getHostView() != null) {
      return ((VRecyclerView)getHostView()).getFirstVisibleItemPosition();
    }
    return 0;
  }
  
  public VRefreshViewGroup getRealParentView()
  {
    return this.mRealParentView;
  }
  
  protected VRecyclerView initComponentHostView(@NonNull Context paramContext)
  {
    VRecyclerView localVRecyclerView = createRecyclerView(paramContext);
    this.mAdapter = new VRecyclerViewAdapter(this);
    this.mAdapter.setCellEventListener(this);
    this.mAdapter.setDiffItemAnimListener(this);
    this.mAdapter.setHasStableIds(true);
    localVRecyclerView.bindComponent(this);
    localVRecyclerView.setOverScrollMode(2);
    localVRecyclerView.setDescendantFocusability(393216);
    localVRecyclerView.setGestureListener(this);
    localVRecyclerView.setItemAnimator(null);
    initWaterFall(localVRecyclerView);
    localVRecyclerView.setLayoutManager(findLayoutManager(paramContext, localVRecyclerView));
    if (this.mOrientation == 0)
    {
      if (mHorizontalRecycledViewPool == null) {
        mHorizontalRecycledViewPool = new RecyclerView.RecycledViewPool();
      }
      localVRecyclerView.setRecycledViewPool(mHorizontalRecycledViewPool);
      OverScrollHelper.setUpOverScroll(localVRecyclerView, 1, localVRecyclerView);
      localVRecyclerView.setHorizontalScrollBarEnabled(false);
    }
    for (;;)
    {
      localVRecyclerView.setAdapter(this.mAdapter);
      if ((getInstance() != null) && (TextUtils.isEmpty(getInstance().getMasterListRef()))) {
        getInstance().setMasterListRef(getRef());
      }
      return localVRecyclerView;
      if (this.mOrientation == 1) {
        localVRecyclerView.setItemViewCacheSize(3);
      }
    }
  }
  
  public void initWaterFall(RecyclerView paramRecyclerView)
  {
    if ((getDomObject() instanceof DomObjectWaterfallList))
    {
      this.mRecycleViewItemDecoration = new RecycleViewItemDecoration();
      this.mRecycleViewItemDecoration.setAdapter(this.mAdapter);
      Object localObject = (DomObjectWaterfallList)getDomObject();
      this.mColumn = ((DomObjectWaterfallList)localObject).getColumn();
      this.mRecycleViewItemDecoration.setColumn(this.mColumn);
      this.mRecycleViewItemDecoration.setItemPortraitInterval(((DomObjectWaterfallList)localObject).getLineSpacing());
      this.mRecycleViewItemDecoration.setItemTransverseInterval(((DomObjectWaterfallList)localObject).getItemSpacing());
      localObject = ((DomObjectWaterfallList)localObject).getInsetArry();
      paramRecyclerView.setPadding(localObject[3], localObject[0], localObject[1], localObject[2]);
      paramRecyclerView.setClipToPadding(false);
      this.mIsSetInset = true;
      paramRecyclerView.addItemDecoration(this.mRecycleViewItemDecoration);
    }
  }
  
  public boolean isDiffItemAnimEnable()
  {
    return this.mDiffAnimEnable;
  }
  
  public boolean isInterceptAddView()
  {
    return this.mOrientation == 1;
  }
  
  public boolean isReuse()
  {
    return this.mOrientation == 0;
  }
  
  public boolean isVertical()
  {
    return this.mOrientation == 1;
  }
  
  public void judgeIfNeedAppearEvent(VCell paramVCell)
  {
    if ((paramVCell != null) && (paramVCell.getHostView() != null) && (paramVCell.getDomObject() != null) && (((VFrameLayout)paramVCell.getHostView()).getParent() != null))
    {
      DomObject localDomObject = paramVCell.getDomObject();
      try
      {
        if ((((DomObjectCell)localDomObject).isRegisterDidAppear()) && (this.mOrientation != 0) && (getHostView() != null) && (((VRecyclerView)getHostView()).indexOfChild((View)((VFrameLayout)paramVCell.getHostView()).getParent()) != -1))
        {
          VRecyclerView localVRecyclerView = (VRecyclerView)getHostView();
          if (("refresh".equals(getDomObject().getChild(0).getType())) || ("kdrefresh".equals(getDomObject().getChild(0).getType()))) {}
          for (int i = getDomObject().getChildPosition(localDomObject) - 1;; i = getDomObject().getChildPosition(localDomObject))
          {
            localVRecyclerView.traverseDomObjectCell(i, ((View)((VFrameLayout)paramVCell.getHostView()).getParent()).getY(), true, true);
            return;
          }
        }
        return;
      }
      catch (Exception paramVCell)
      {
        ViolaLogUtils.e("VRecyclerList", "judgeIfNeedAppearEvent error:" + paramVCell.getMessage());
      }
    }
  }
  
  @JSMethod(uiThread=false)
  public void loadMoreFinish(Object paramObject)
  {
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new VRecyclerList.1(this), 300L);
  }
  
  public void notifyChange(int paramInt, String paramString)
  {
    calAndSetContentSize();
  }
  
  public void notifyItemInsert(DomObject paramDomObject, int paramInt)
  {
    calAndSetContentSize();
    this.updateOps.add(paramDomObject, paramInt);
  }
  
  public void notifyItemRemove(DomObject paramDomObject)
  {
    calAndSetContentSize();
    this.updateOps.remove(paramDomObject);
  }
  
  public void onActivityDestroy()
  {
    if ((this.mOrientation == 0) && (mHorizontalRecycledViewPool != null))
    {
      mHorizontalRecycledViewPool.clear();
      mHorizontalRecycledViewPool = null;
    }
  }
  
  public void onAnimFinish()
  {
    if ((getHostView() != null) && (((VRecyclerView)getHostView()).getItemAnimator() != null)) {
      ((VRecyclerView)getHostView()).setItemAnimator(null);
    }
    this.mDiffAnimEnable = false;
  }
  
  public void onCellAppear(VRecyclerViewAdapter.VH paramVH)
  {
    if ((paramVH == null) || (paramVH.mVCell == null) || (paramVH.mVCell.getDomObject() == null)) {
      return;
    }
    Object localObject = paramVH.mVCell.getDomObject();
    if ((!this.mCellAppearSet.contains(((DomObject)localObject).getRef())) && (((DomObject)localObject).getEvents().contains("appear")))
    {
      customFireEvent("appear", ((DomObject)localObject).getRef());
      this.mCellAppearSet.add(((DomObject)localObject).getRef());
      ViolaLogUtils.d("VRecyclerList", "appear position: " + paramVH.position + ", ref: " + ((DomObject)localObject).getRef());
    }
    for (;;)
    {
      try
      {
        if ((((DomObjectCell)localObject).isRegisterDidAppear()) && (this.mOrientation != 0) && (getHostView() != null) && (paramVH.itemView.getY() >= 0.0F))
        {
          localObject = (VRecyclerView)getHostView();
          int i = paramVH.position;
          if ((paramVH.itemView.getY() == 0.0F) || (paramVH.itemView.getY() % paramVH.mVCell.getDomObject().getLayoutHeight() == 0.0F))
          {
            f = paramVH.mVCell.getDomObject().getLayoutY() - this.mRealParentView.getHeaderViewHeight();
            ((VRecyclerView)localObject).traverseDomObjectCell(i, f, true, false);
          }
        }
        else
        {
          if (this.mOrientation != 1) {
            break;
          }
          tryScrollEvent((VRecyclerView)getHostView(), 0, 0);
          return;
        }
      }
      catch (Exception paramVH)
      {
        ViolaLogUtils.e("VRecyclerList", "onCellAppear error:" + paramVH.getMessage());
        return;
      }
      float f = paramVH.itemView.getY();
    }
  }
  
  public void onCellDisappear(VRecyclerViewAdapter.VH paramVH)
  {
    if ((paramVH == null) || (paramVH.mVCell == null) || (paramVH.mVCell.getDomObject() == null)) {}
    DomObject localDomObject;
    do
    {
      return;
      localDomObject = paramVH.mVCell.getDomObject();
      this.mCellAppearSet.remove(localDomObject.getRef());
      if (localDomObject.getEvents().contains("disappear"))
      {
        customFireEvent("disappear", localDomObject.getRef());
        ViolaLogUtils.d("VRecyclerList", "disAppear position: " + paramVH.position + ", ref: " + localDomObject.getRef());
      }
    } while (getInstance() == null);
    ((DomObjectCell)localDomObject).resetComponentState(getInstance().getInstanceId());
  }
  
  public void onDispatchTouchEvent(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((getInstance() != null) && (getInstance().getViolaPageListener() != null)) {
      getInstance().getViolaPageListener().onDispatchTouchEvent(getRef(), paramInt1, paramMotionEvent, paramInt2);
    }
  }
  
  public void onLoadMore(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2)
  {
    listFireScrollEvent("loadMore", paramInt1, paramInt2);
  }
  
  public void onScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool = true;
    ViolaInstance.ViolaPageListener localViolaPageListener;
    String str;
    if ((getInstance() != null) && (getInstance().getViolaPageListener() != null))
    {
      localViolaPageListener = getInstance().getViolaPageListener();
      str = getRef();
      if (this.mOrientation != 1) {
        break label62;
      }
    }
    for (;;)
    {
      localViolaPageListener.onScroll(str, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, bool);
      return;
      label62:
      bool = false;
    }
  }
  
  public void onScroll(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mOrientation == 1) {
      tryScrollEvent(paramVRecyclerView, paramInt3, paramInt4);
    }
    if (isCompatMode()) {
      ((VListCompat)getCompator()).onScroll();
    }
    listFireScrollEvent("scroll", paramInt1, paramInt2);
    onRichGestureScroll(paramInt1, paramInt2);
  }
  
  public void onScrollEnd(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2)
  {
    listFireScrollEvent("scrollEnd", paramInt1, paramInt2);
  }
  
  public void onScrollStateChanged(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2)
  {
    if (isCompatMode()) {
      ((VListCompat)getCompator()).onScrollStateChanged(paramInt1);
    }
    String str;
    if ((getInstance() != null) && (getInstance().getViolaPageListener() != null) && (this.mOrientation == 1))
    {
      paramVRecyclerView = getInstance().getViolaPageListener();
      str = getRef();
      if (this.mOrientation != 1) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      paramVRecyclerView.onScrollStateChanged(str, paramInt1, paramInt2, bool);
      paramVRecyclerView = ViolaSDKManager.getInstance().getReportDelegate();
      if (paramVRecyclerView != null) {
        paramVRecyclerView.dropFrameMonitor(paramInt1, ViolaEnvironment.LIST_KANDIAN_VIOLA);
      }
      return;
    }
  }
  
  public void onStickItemChange(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("index", paramInt);
      localJSONObject.put("ref", paramString);
      label26:
      fireEvent("stickItemChange", getFireEventArgs("stickItemChange"), localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      break label26;
    }
  }
  
  public void onTouchDown(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    listFireTouchEvent("touchDown", paramInt1, paramInt2, paramFloat1, paramFloat2);
  }
  
  public void onTouchUp(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    listFireTouchEvent("touchUp", paramInt1, paramInt2, paramFloat1, paramFloat2);
  }
  
  public void remove(VComponent paramVComponent, boolean paramBoolean)
  {
    if ((paramVComponent == null) || (this.mChildren == null) || (this.mChildren.size() == 0)) {}
    do
    {
      return;
      this.mChildren.remove(paramVComponent);
    } while (!paramBoolean);
    paramVComponent.destroy();
  }
  
  @JSMethod(uiThread=true)
  public void scrollToPosition(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      try
      {
        int j = paramJSONObject.optInt("duration", 200);
        int k = ((VRecyclerView)getHostView()).getContentOffsetY();
        int m = ((VRecyclerView)getHostView()).getContentOffsetX();
        if (!TextUtils.isEmpty(paramJSONObject.optString("distance")))
        {
          scrollByDistance(m, k, j, (int)FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.getString("distance"), getDomObject().getViewPortWidth()));
          scrollToPositionFire(paramString, j);
          return;
        }
        if (!TextUtils.isEmpty(paramJSONObject.optString("ref")))
        {
          String str = paramJSONObject.getString("ref");
          int i = 0;
          if (!TextUtils.isEmpty(paramJSONObject.optString("offset"))) {
            i = (int)FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.getString("offset"), getDomObject().getViewPortWidth());
          }
          scrollByRef(str, i, m, k, j, paramJSONObject.optString("align", "start"));
          scrollToPositionFire(paramString, j);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ViolaLogUtils.e("VRecyclerList", "scrollToPosition error:" + paramJSONObject.getMessage());
      }
    }
  }
  
  public void scrollToPositionFire(String paramString, int paramInt)
  {
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new VRecyclerList.2(this, paramString), paramInt + 200);
  }
  
  public void scrollToTop()
  {
    if (getHostView() != null) {
      ((VRecyclerView)getHostView()).scrollToTop(false);
    }
  }
  
  @JSMethod(uiThread=true)
  public void scrollToTop(Boolean paramBoolean)
  {
    boolean bool;
    if (paramBoolean == null)
    {
      bool = false;
      if (this.mRealParentView == null) {
        break label31;
      }
      this.mRealParentView.scrollerToTop(false, bool);
    }
    label31:
    while (getHostView() == null)
    {
      return;
      bool = paramBoolean.booleanValue();
      break;
    }
    ((VRecyclerView)getHostView()).scrollToTop(bool);
  }
  
  @VComponentProp(name="bounceDistance")
  public void setBounceDistance(int paramInt) {}
  
  @VComponentProp(name="bouncesEnable")
  public void setBouncesEnable(Boolean paramBoolean)
  {
    if (paramBoolean == null) {}
    for (boolean bool = false;; bool = paramBoolean.booleanValue())
    {
      if (this.mRealParentView != null)
      {
        this.mRealParentView.setAllowHeaderSliding(bool);
        this.mRealParentView.setAllowFooterSliding(bool);
      }
      return;
    }
  }
  
  public void setHostLayoutParams(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.mHost == null) {
      return;
    }
    if (this.mParent == null)
    {
      paramVRecyclerView = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramVRecyclerView.setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
    }
    for (;;)
    {
      if (paramVRecyclerView != null) {
        ((VRecyclerView)this.mHost).setLayoutParams(paramVRecyclerView);
      }
      calAndSetContentSize();
      return;
      if ((((VRecyclerView)this.mHost).getParent() instanceof VRefreshViewGroup))
      {
        Object localObject;
        if (((VRefreshViewGroup)((VRecyclerView)this.mHost).getParent()).getLayoutParams() == null)
        {
          localObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
          ((FrameLayout.LayoutParams)localObject).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
          ((VRefreshViewGroup)((VRecyclerView)this.mHost).getParent()).setViewGroupLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        for (;;)
        {
          paramVRecyclerView = this.mParent.getChildLayoutParams(this, paramVRecyclerView, paramInt1, paramInt2, 0, 0, 0, 0);
          break;
          localObject = ((VRefreshViewGroup)((VRecyclerView)this.mHost).getParent()).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = paramInt2;
          ((ViewGroup.LayoutParams)localObject).width = paramInt1;
          if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams)localObject).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
          }
        }
      }
      paramVRecyclerView = this.mParent.getChildLayoutParams(this, paramVRecyclerView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
  }
  
  public void setNeedNotify(boolean paramBoolean)
  {
    this.mNeedNotifyDataChange = paramBoolean;
  }
  
  @VComponentProp(name="preloadDistance")
  public void setPreloadDistance(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    String str = paramObject.toString().trim();
    if (str.endsWith("dp")) {
      try
      {
        str = str.substring(0, str.indexOf("dp"));
        ((VRecyclerView)getHostView()).setPreloadDistance(FlexConvertUtils.dip2px(Integer.valueOf(str).intValue()));
        return;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VRecyclerList", "setPreloadDistance error! value is " + paramObject + " error message is:" + localException.getMessage());
        return;
      }
    }
    ((VRecyclerView)getHostView()).setPreloadDistance(Integer.valueOf(localException).intValue());
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    boolean bool2 = true;
    int i;
    if (ViolaUtils.getString(paramObject, null) != null)
    {
      i = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
    }
    String str;
    do
    {
      boolean bool1 = super.setProperty(paramString, paramObject);
      do
      {
        do
        {
          return bool1;
          if (!paramString.equals("overflow")) {
            break;
          }
          i = 0;
          break;
          if (!paramString.equals("backgroundColor")) {
            break;
          }
          i = 1;
          break;
          paramString = ViolaUtils.getString(paramObject, null);
          bool1 = bool2;
        } while (TextUtils.isEmpty(paramString));
        bool1 = bool2;
      } while (this.mIsSetInset);
      if (paramString.equals("visible")) {
        this.mIsOverFlow = true;
      }
      for (;;)
      {
        setReadParentOverFlow(this.mIsOverFlow);
        return true;
        if (paramString.equals("hidden")) {
          this.mIsOverFlow = false;
        }
      }
      str = ViolaUtils.getString(paramObject, null);
    } while (TextUtils.isEmpty(str));
    if ((this.mRealParentView != null) && (!str.equals("transparent")))
    {
      i = ViolaUtils.getColor(str);
      this.mRealParentView.setBackgroundColor(i);
    }
    return super.setProperty(paramString, paramObject);
  }
  
  @VComponentProp(name="showScrollerIndicator")
  public void setScrollIndicator(Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      if (this.mOrientation == 1) {
        ((VRecyclerView)getHostView()).setVerticalScrollBarEnabled(paramBoolean.booleanValue());
      }
    }
    else {
      return;
    }
    ((VRecyclerView)getHostView()).setHorizontalScrollBarEnabled(paramBoolean.booleanValue());
  }
  
  @VComponentProp(name="scrollMinOffset")
  public void setScrollMinOffset(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    String str = paramObject.toString().trim();
    if (str.endsWith("dp")) {}
    for (;;)
    {
      try
      {
        i = FlexConvertUtils.dip2px(Integer.valueOf(str.substring(0, str.indexOf("dp"))).intValue());
        ((VRecyclerView)getHostView()).setScrollMinOffset(i);
        return;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VRecyclerList", "setPreloadDistance error! value is " + paramObject + " error message is:" + localException.getMessage());
        i = 0;
        continue;
      }
      int i = Integer.valueOf(localException).intValue();
    }
  }
  
  @JSMethod(uiThread=true)
  public void startDiffAnim()
  {
    this.mDiffAnimEnable = true;
  }
  
  public void startDiffItemAnim()
  {
    if ((getHostView() != null) && (!(((VRecyclerView)getHostView()).getItemAnimator() instanceof DefaultItemAnimator)))
    {
      if (this.mDefaultRecycleItemAnimator == null)
      {
        this.mDefaultRecycleItemAnimator = new DefaultRecycleItemAnimator();
        this.mDefaultRecycleItemAnimator.setDefaultAnimatorListener(this);
      }
      ((VRecyclerView)getHostView()).setItemAnimator(this.mDefaultRecycleItemAnimator);
    }
  }
  
  @JSMethod(uiThread=true)
  public void stopDiffAnim()
  {
    this.mDiffAnimEnable = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList
 * JD-Core Version:    0.7.0.1
 */