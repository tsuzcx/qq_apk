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
  private boolean mSnapOffsetUsable = true;
  private boolean mUpdateCheckEnable = false;
  private VRecyclerList.RVUpdateOps updateOps = new VRecyclerList.RVUpdateOps(this);
  
  public VRecyclerList(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void calAndSetContentSize()
  {
    DomObject localDomObject1 = getDomObject();
    if (localDomObject1 == null) {
      return;
    }
    int m = localDomObject1.getDomChildCount();
    boolean bool = isVertical();
    int k = 0;
    int i = 0;
    int j = 0;
    while (k < m)
    {
      DomObject localDomObject2 = localDomObject1.getChild(k);
      if (localDomObject2 == null) {
        return;
      }
      if (bool) {
        j = (int)(j + localDomObject2.getLayoutHeight());
      } else {
        i = (int)(i + localDomObject2.getLayoutWidth());
      }
      k += 1;
    }
    if (bool) {
      i = (int)localDomObject1.getLayoutWidth();
    } else {
      j = (int)localDomObject1.getLayoutHeight();
    }
    super.setContentWidth(i);
    super.setContentHeight(j);
  }
  
  private float calFinalDistance(float paramFloat, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    int i = paramString.hashCode();
    if (i != -1364013995)
    {
      if (i != 100571)
      {
        if ((i == 109757538) && (paramString.equals("start")))
        {
          i = 0;
          break label82;
        }
      }
      else if (paramString.equals("end"))
      {
        i = 2;
        break label82;
      }
    }
    else if (paramString.equals("center"))
    {
      i = 1;
      break label82;
    }
    i = -1;
    label82:
    float f;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2) {
          return 0.0F;
        }
        paramFloat = Math.abs(paramFloat) - Math.abs(paramInt1) + paramInt2 - paramInt3;
        f = paramInt4;
      }
    }
    for (;;)
    {
      return paramFloat + f;
      paramFloat = Math.abs(paramFloat) - Math.abs(paramInt1) + paramInt2 - paramInt3 * 0.5F;
      f = paramInt4 * 0.5F;
      continue;
      paramFloat = Math.abs(paramFloat) - Math.abs(paramInt1);
      f = paramInt2;
    }
  }
  
  private float compatWithPagerSnap(float paramFloat)
  {
    VRecyclerView localVRecyclerView = (VRecyclerView)getHostView();
    if (localVRecyclerView == null) {
      return paramFloat;
    }
    float f = paramFloat;
    if (localVRecyclerView.getFirstVisibleItemPosition() == 0)
    {
      f = paramFloat;
      if (this.mSnapOffsetUsable) {
        f = paramFloat + localVRecyclerView.getSnapOffset();
      }
    }
    return f;
  }
  
  private void createRealParentView()
  {
    if ((this.mRealParentView == null) && ((getContext() != null) || ((getInstance() != null) && (getInstance().getActivity() != null))))
    {
      if (getContext() != null)
      {
        this.mRealParentView = new VRefreshViewGroup(getContext());
        return;
      }
      this.mRealParentView = new VRefreshViewGroup(getInstance().getActivity());
    }
  }
  
  private VRecyclerView createRecyclerView(Context paramContext)
  {
    try
    {
      int i = paramContext.getResources().getIdentifier("viola_recycler_list", "layout", paramContext.getPackageName());
      VRecyclerView localVRecyclerView2 = (VRecyclerView)LayoutInflater.from(paramContext).inflate(i, null);
      localVRecyclerView1 = localVRecyclerView2;
      if (localVRecyclerView2 != null) {
        break label59;
      }
      localVRecyclerView1 = createRecyclerViewOnFallback(paramContext);
      return localVRecyclerView1;
    }
    catch (Exception localException)
    {
      VRecyclerView localVRecyclerView1;
      label46:
      label59:
      break label46;
    }
    ViolaLogUtils.d("VRecyclerList", "inflate recyclerView error!");
    localVRecyclerView1 = createRecyclerViewOnFallback(paramContext);
    return localVRecyclerView1;
  }
  
  private VRecyclerView createRecyclerViewOnFallback(Context paramContext)
  {
    return new VRecyclerView(paramContext);
  }
  
  private float cutDistanceWhenExistKdRefresh(float paramFloat)
  {
    if ((this.mDomObj == null) && (this.mDomObj.getDomChildCount() <= 0)) {
      return paramFloat;
    }
    DomObject localDomObject = this.mDomObj.getChild(0);
    if (localDomObject == null) {
      return paramFloat;
    }
    float f = paramFloat;
    if ("kdrefresh".equals(localDomObject.getType())) {
      f = paramFloat - localDomObject.getLayoutHeight() - localDomObject.getMarginVertical();
    }
    return f;
  }
  
  private void dealChildMarginWith(DomObject paramDomObject, FrameLayout.LayoutParams paramLayoutParams)
  {
    if (!isVertical()) {
      return;
    }
    int i = getDomObject().indexOf(paramDomObject);
    if (!this.isCaluteSnapOffset)
    {
      if (getDomObject().getAttributes().containsKey("stickyOffset")) {
        this.mSnapOffset = ((int)FlexConvertUtils.converPxByViewportToRealPx(getDomObject().getAttributes().get("stickyOffset"), 750));
      }
      if (getDomObject().getAttributes().containsKey("stickyOffsetUsable")) {
        this.mSnapOffsetUsable = ((Boolean)getDomObject().getAttributes().get("stickyOffsetUsable")).booleanValue();
      }
      this.isCaluteSnapOffset = true;
    }
    int j = this.mSnapOffset;
    if ((j != 0) && (this.mSnapOffsetUsable))
    {
      if (i == 0)
      {
        paramLayoutParams.setMargins(0, j, 0, 0);
        return;
      }
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
      if ((i == getDomObject().getChildCount() - 2) && (((VRecyclerViewAdapter)((VRecyclerView)getHostView()).getAdapter()).isRecycleHasFooter())) {
        paramLayoutParams.setMargins(0, 0, 0, FlexConvertUtils.getScreenHeight() - this.mSnapOffset * 4);
      }
    }
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
      return new LinearLayoutManager(paramContext, this.mOrientation, isReverse());
    }
    return new LinearLayoutManager(paramContext);
  }
  
  private void initContentOffsetIfNeed(VRecyclerView paramVRecyclerView)
  {
    float f = FlexConvertUtils.getFloatByViewport(this.mDomObj.getAttributes().get("initContentOffset"), this.mDomObj.getViewPortWidth());
    if (f == 0.0F) {
      return;
    }
    paramVRecyclerView.addOnLayoutChangeListener(new VRecyclerList.1(this, paramVRecyclerView, f));
  }
  
  private JSONObject listFireBaseInfo(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(getContentWidth()));
      localStringBuilder.append("dp");
      ((JSONObject)localObject).put("width", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(getContentHeight()));
      localStringBuilder.append("dp");
      ((JSONObject)localObject).put("height", localStringBuilder.toString());
      localJSONObject1.put("contentSize", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FlexConvertUtils.px2dip(paramInt1));
      ((StringBuilder)localObject).append("dp");
      localJSONObject2.put("x", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FlexConvertUtils.px2dip(paramInt2));
      ((StringBuilder)localObject).append("dp");
      localJSONObject2.put("y", ((StringBuilder)localObject).toString());
      localJSONObject1.put("contentOffset", localJSONObject2);
      localJSONObject1.put("frame", getFrameInfo());
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("listFireBaseInfo error :");
      ((StringBuilder)localObject).append(localException.getMessage());
      ViolaLogUtils.e("VRecyclerList", ((StringBuilder)localObject).toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(paramFloat1 - f1));
      localStringBuilder.append("dp");
      localJSONObject.put("pageX", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(paramFloat2 - f2));
      localStringBuilder.append("dp");
      localJSONObject.put("pageY", localStringBuilder.toString());
      label134:
      fireEvent(paramString, getFireEventArgs(paramString), localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label134;
    }
  }
  
  private void scrollByDistance(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.mOrientation;
    int i = 0;
    if (j == 0)
    {
      paramInt2 = Math.abs(paramInt4) - Math.abs(paramInt1);
      paramInt1 = i;
    }
    else
    {
      paramInt1 = Math.abs(paramInt4) - Math.abs(paramInt2);
      paramInt2 = 0;
    }
    if (paramInt3 > 0)
    {
      ((VRecyclerView)getHostView()).smoothScrollBy(paramInt2, paramInt1);
      return;
    }
    ((VRecyclerView)getHostView()).scrollBy(paramInt2, paramInt1);
  }
  
  private void scrollByRef(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    String str = getInstance().getInstanceId();
    DomObject localDomObject = ViolaUtils.findDomObject(str, paramString1);
    if (localDomObject == null) {
      return;
    }
    int j = this.mOrientation;
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    float f2 = 0.0F;
    float f1;
    if (i != 0)
    {
      f2 = calFinalDistance(compatWithPagerSnap(cutDistanceWhenExistKdRefresh(ViolaUtils.getLayoutYInList(str, paramString1))), paramInt3, paramInt1, paramString2, ((VRecyclerView)getHostView()).getHeight(), (int)localDomObject.getLayoutHeight());
      f1 = 0.0F;
    }
    else
    {
      f1 = calFinalDistance(cutDistanceWhenExistKdRefresh(ViolaUtils.getLayoutXInList(str, paramString1)), paramInt2, paramInt1, paramString2, ((VRecyclerView)getHostView()).getWidth(), (int)localDomObject.getLayoutWidth());
    }
    if (paramInt4 > 0)
    {
      ((VRecyclerView)getHostView()).smoothScrollBy((int)f1, (int)f2);
      return;
    }
    ((VRecyclerView)getHostView()).scrollBy((int)f1, (int)f2);
  }
  
  private void setContentView(VRefreshContentView.ContentViewProvider paramContentViewProvider)
  {
    VRefreshViewGroup localVRefreshViewGroup = this.mRealParentView;
    if (localVRefreshViewGroup == null) {
      return;
    }
    localVRefreshViewGroup.addInFirst(((VRecyclerView)getHostView()).getRefreshMoveOberver());
    this.mRealParentView.setContentViewProvider(paramContentViewProvider);
  }
  
  private void setFooterView(VFooterLayout paramVFooterLayout)
  {
    VRefreshViewGroup localVRefreshViewGroup = this.mRealParentView;
    if (localVRefreshViewGroup == null) {
      return;
    }
    localVRefreshViewGroup.setFooterView(paramVFooterLayout);
    if (isCompatMode()) {
      paramVFooterLayout.setListener((VListCompat)getCompator());
    }
  }
  
  private void setHeadView(VRefreshLayout paramVRefreshLayout)
  {
    VRefreshViewGroup localVRefreshViewGroup = this.mRealParentView;
    if (localVRefreshViewGroup == null) {
      return;
    }
    localVRefreshViewGroup.add(paramVRefreshLayout.getRefreshMoveOberver());
    this.mRealParentView.setHeaderView(paramVRefreshLayout);
    if (isCompatMode()) {
      paramVRefreshLayout.addOnHeaderStateChangeListener((VListCompat)getCompator());
    }
  }
  
  private void setReadParentOverFlow(boolean paramBoolean)
  {
    VRefreshViewGroup localVRefreshViewGroup = this.mRealParentView;
    if (localVRefreshViewGroup != null)
    {
      localVRefreshViewGroup.setClipToPadding(paramBoolean ^ true);
      this.mRealParentView.setClipChildren(paramBoolean ^ true);
      if (this.mHost != null)
      {
        ((VRecyclerView)this.mHost).setClipToPadding(paramBoolean ^ true);
        ((VRecyclerView)this.mHost).setClipChildren(paramBoolean ^ true);
      }
    }
  }
  
  private void tryScrollEvent(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2)
  {
    if (paramVRecyclerView == null) {
      return;
    }
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
                int j = this.mOrientation;
                boolean bool = true;
                if (j != 1) {
                  bool = false;
                }
                if (bool) {
                  j = paramInt2;
                } else {
                  j = paramInt1;
                }
                int k;
                if (bool) {
                  k = paramVRecyclerView.getContentOffsetY();
                } else {
                  k = paramVRecyclerView.getContentOffsetX();
                }
                localVComponent.onScroll(paramVRecyclerView, bool, j, k);
              }
            }
          }
        }
      }
      i += 1;
    }
  }
  
  public void addEvent(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1912497927: 
      if (paramString.equals("dragEnd")) {
        i = 6;
      }
      break;
    case 1845399899: 
      if (paramString.equals("loadMore")) {
        i = 0;
      }
      break;
    case 417766094: 
      if (paramString.equals("scrollEnd")) {
        i = 4;
      }
      break;
    case 363315329: 
      if (paramString.equals("touchDown")) {
        i = 1;
      }
      break;
    case -338527275: 
      if (paramString.equals("dragBegin")) {
        i = 5;
      }
      break;
    case -907680051: 
      if (paramString.equals("scroll")) {
        i = 3;
      }
      break;
    case -1134815686: 
      if (paramString.equals("touchUp")) {
        i = 2;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      super.addEvent(paramString);
      return;
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
  
  protected <T extends VComponentCompat> T createCompator()
  {
    return new VListCompat(this, this.mDomObj);
  }
  
  public void createViewImpl()
  {
    createRealParentView();
    this.mHost = initComponentHostView(this.mContext);
    updateLifeCycle("created");
    int j = getChildCount();
    if (j == 0)
    {
      setContentView((VRefreshContentView.ContentViewProvider)getHostView());
    }
    else
    {
      int i = 0;
      while (i < j)
      {
        createChildViewAt(i);
        i += 1;
      }
    }
    if (j == 0) {
      calAndSetContentSize();
    }
    if ((this.mHost != null) && (!this.mIsOverFlow) && (!this.mIsSetInset))
    {
      ((VRecyclerView)this.mHost).setClipToPadding(true);
      ((VRecyclerView)this.mHost).setClipChildren(true);
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
    Object localObject = this.mRealParentView;
    if (localObject != null) {
      ((VRefreshViewGroup)localObject).onDestroy();
    }
    if (this.mOrientation == 0)
    {
      localObject = mHorizontalRecycledViewPool;
      if (localObject != null)
      {
        ((RecyclerView.RecycledViewPool)localObject).clear();
        mHorizontalRecycledViewPool = null;
      }
    }
    localObject = this.mDefaultRecycleItemAnimator;
    if (localObject != null) {
      ((DefaultRecycleItemAnimator)localObject).destroy();
    }
  }
  
  public boolean disableAutoScroll()
  {
    return (this.mDomObj != null) && (ViolaUtils.getBoolean(this.mDomObj.getAttributes().get("disableAutoScroll")));
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
    int i = this.mOrientation;
    if (i == 0)
    {
      if (mHorizontalRecycledViewPool == null) {
        mHorizontalRecycledViewPool = new RecyclerView.RecycledViewPool();
      }
      localVRecyclerView.setRecycledViewPool(mHorizontalRecycledViewPool);
      OverScrollHelper.setUpOverScroll(localVRecyclerView, 1, localVRecyclerView);
      localVRecyclerView.setHorizontalScrollBarEnabled(false);
    }
    else if (i == 1)
    {
      localVRecyclerView.setItemViewCacheSize(3);
    }
    localVRecyclerView.setAdapter(this.mAdapter);
    if ((getInstance() != null) && (TextUtils.isEmpty(getInstance().getMasterListRef()))) {
      getInstance().setMasterListRef(getRef());
    }
    initContentOffsetIfNeed(localVRecyclerView);
    return localVRecyclerView;
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
  
  public boolean isReverse()
  {
    return ViolaUtils.getBoolean(getDomObject().getAttributes().get("reverse"));
  }
  
  public boolean isUpdateCheckEnable()
  {
    return this.mUpdateCheckEnable;
  }
  
  public boolean isVertical()
  {
    return this.mOrientation == 1;
  }
  
  public void judgeIfNeedAppearEvent(VCell paramVCell)
  {
    if ((paramVCell != null) && (paramVCell.getHostView() != null) && (paramVCell.getDomObject() != null) && (((VFrameLayout)paramVCell.getHostView()).getParent() != null))
    {
      Object localObject = paramVCell.getDomObject();
      try
      {
        if ((((DomObjectCell)localObject).isRegisterDidAppear()) && (getHostView() != null) && (((VRecyclerView)getHostView()).indexOfChild((View)((VFrameLayout)paramVCell.getHostView()).getParent()) != -1))
        {
          VRecyclerView localVRecyclerView = (VRecyclerView)getHostView();
          int i;
          if (ViolaUtils.isRefresh(getDomObject().getChild(0))) {
            i = getDomObject().getChildPosition((DomObject)localObject) - 1;
          } else {
            i = getDomObject().getChildPosition((DomObject)localObject);
          }
          localVRecyclerView.traverseDomObjectCell(i, (View)((VFrameLayout)paramVCell.getHostView()).getParent(), true, true);
          return;
        }
      }
      catch (Exception paramVCell)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("judgeIfNeedAppearEvent error:");
        ((StringBuilder)localObject).append(paramVCell.getMessage());
        ViolaLogUtils.e("VRecyclerList", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @JSMethod(uiThread=false)
  public void loadMoreFinish(Object paramObject)
  {
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new VRecyclerList.2(this), 300L);
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
    if (this.mOrientation == 0)
    {
      RecyclerView.RecycledViewPool localRecycledViewPool = mHorizontalRecycledViewPool;
      if (localRecycledViewPool != null)
      {
        localRecycledViewPool.clear();
        mHorizontalRecycledViewPool = null;
      }
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
    if ((paramVH != null) && (paramVH.mVCell != null))
    {
      if (paramVH.mVCell.getDomObject() == null) {
        return;
      }
      Object localObject = paramVH.mVCell.getDomObject();
      if ((!this.mCellAppearSet.contains(((DomObject)localObject).getRef())) && (((DomObject)localObject).getEvents().contains("appear")))
      {
        customFireEvent("appear", ((DomObject)localObject).getRef());
        this.mCellAppearSet.add(((DomObject)localObject).getRef());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("appear position: ");
        localStringBuilder.append(paramVH.position);
        localStringBuilder.append(", ref: ");
        localStringBuilder.append(((DomObject)localObject).getRef());
        ViolaLogUtils.d("VRecyclerList", localStringBuilder.toString());
      }
      try
      {
        if ((((DomObjectCell)localObject).isRegisterDidAppear()) && (getHostView() != null)) {
          if ((this.mOrientation != 0) && (paramVH.itemView.getY() == 0.0F)) {
            ((VRecyclerView)getHostView()).traverseDomObjectCell(paramVH.position, paramVH.mVCell.getDomObject().getLayoutY() - this.mRealParentView.getHeaderViewHeight(), true, false);
          } else if ((this.mOrientation == 0) && (paramVH.itemView.getX() == 0.0F)) {
            ((VRecyclerView)getHostView()).traverseDomObjectCell(paramVH.position, paramVH.mVCell.getDomObject().getLayoutX() - this.mRealParentView.getHeaderViewWidth(), true, false);
          }
        }
        if (this.mOrientation == 1)
        {
          tryScrollEvent((VRecyclerView)getHostView(), 0, 0);
          return;
        }
      }
      catch (Exception paramVH)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCellAppear error:");
        ((StringBuilder)localObject).append(paramVH.getMessage());
        ViolaLogUtils.e("VRecyclerList", ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onCellDisappear(VRecyclerViewAdapter.VH paramVH)
  {
    if ((paramVH != null) && (paramVH.mVCell != null))
    {
      if (paramVH.mVCell.getDomObject() == null) {
        return;
      }
      Object localObject = paramVH.mVCell.getDomObject();
      this.mCellAppearSet.remove(((DomObject)localObject).getRef());
      if (((DomObject)localObject).getEvents().contains("disappear"))
      {
        customFireEvent("disappear", ((DomObject)localObject).getRef());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("disAppear position: ");
        localStringBuilder.append(paramVH.position);
        localStringBuilder.append(", ref: ");
        localStringBuilder.append(((DomObject)localObject).getRef());
        ViolaLogUtils.d("VRecyclerList", localStringBuilder.toString());
      }
      if ((getInstance() != null) && (getHostView() != null))
      {
        paramVH = (DomObjectCell)localObject;
        localObject = getInstance().getInstanceId();
        boolean bool2 = ((VRecyclerView)getHostView()).isScrollDown();
        boolean bool1;
        if ((((VRecyclerView)getHostView()).isFlying()) && (((VRecyclerView)getHostView()).isListScroll())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramVH.resetComponentState((String)localObject, bool2, bool1);
      }
    }
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
    if ((getInstance() != null) && (getInstance().getViolaPageListener() != null))
    {
      ViolaInstance.ViolaPageListener localViolaPageListener = getInstance().getViolaPageListener();
      String str = getRef();
      boolean bool;
      if (this.mOrientation == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localViolaPageListener.onScroll(str, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, bool);
    }
  }
  
  public void onScroll(VRecyclerView paramVRecyclerView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (this.mOrientation == 1) {
      tryScrollEvent(paramVRecyclerView, paramInt3, paramInt4);
    }
    onRichGestureScroll(paramInt1, paramInt2);
    if (isCompatMode())
    {
      paramVRecyclerView = (VListCompat)getCompator();
      if (paramBoolean) {
        paramVRecyclerView.onOverScroll(paramInt1, paramInt2);
      } else {
        paramVRecyclerView.onScroll();
      }
    }
    listFireScrollEvent("scroll", paramInt1, paramInt2);
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
    if ((getInstance() != null) && (getInstance().getViolaPageListener() != null))
    {
      int i = this.mOrientation;
      boolean bool = true;
      if (i == 1)
      {
        paramVRecyclerView = getInstance().getViolaPageListener();
        String str = getRef();
        if (this.mOrientation != 1) {
          bool = false;
        }
        paramVRecyclerView.onScrollStateChanged(str, paramInt1, paramInt2, bool);
      }
    }
    paramVRecyclerView = ViolaSDKManager.getInstance().getReportDelegate();
    if (paramVRecyclerView != null) {
      paramVRecyclerView.dropFrameMonitor(paramInt1, ViolaEnvironment.LIST_KANDIAN_VIOLA);
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
    if ((paramVComponent != null) && (this.mChildren != null))
    {
      if (this.mChildren.size() == 0) {
        return;
      }
      this.mChildren.remove(paramVComponent);
      if (paramBoolean) {
        paramVComponent.destroy();
      }
    }
  }
  
  public void scrollByDistance(int paramInt)
  {
    VRecyclerView localVRecyclerView = (VRecyclerView)getHostView();
    if (localVRecyclerView == null) {
      return;
    }
    scrollByDistance(localVRecyclerView.getContentOffsetX(), localVRecyclerView.getContentOffsetY(), 0, paramInt);
  }
  
  @JSMethod(uiThread=true)
  public void scrollToPosition(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
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
          if (TextUtils.isEmpty(paramJSONObject.optString("offset"))) {
            break label212;
          }
          i = (int)FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject.getString("offset"), getDomObject().getViewPortWidth());
          scrollByRef(str, i, m, k, j, paramJSONObject.optString("align", "start"));
          scrollToPositionFire(paramString, j);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramString = new StringBuilder();
        paramString.append("scrollToPosition error:");
        paramString.append(paramJSONObject.getMessage());
        ViolaLogUtils.e("VRecyclerList", paramString.toString());
      }
      return;
      label212:
      int i = 0;
    }
  }
  
  public void scrollToPositionFire(String paramString, int paramInt)
  {
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new VRecyclerList.3(this, paramString), paramInt + 200);
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
    if (paramBoolean == null) {
      bool = false;
    } else {
      bool = paramBoolean.booleanValue();
    }
    paramBoolean = this.mRealParentView;
    if (paramBoolean != null)
    {
      paramBoolean.scrollerToTop(false, bool);
      return;
    }
    if (getHostView() != null) {
      ((VRecyclerView)getHostView()).scrollToTop(bool);
    }
  }
  
  @VComponentProp(name="bounceDistance")
  public void setBounceDistance(int paramInt) {}
  
  @VComponentProp(name="bouncesEnable")
  public void setBouncesEnable(Boolean paramBoolean)
  {
    boolean bool;
    if (paramBoolean == null) {
      bool = false;
    } else {
      bool = paramBoolean.booleanValue();
    }
    paramBoolean = this.mRealParentView;
    if (paramBoolean != null)
    {
      paramBoolean.setAllowHeaderSliding(bool);
      this.mRealParentView.setAllowFooterSliding(bool);
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
    else if ((((VRecyclerView)this.mHost).getParent() instanceof VRefreshViewGroup))
    {
      Object localObject;
      if (((VRefreshViewGroup)((VRecyclerView)this.mHost).getParent()).getLayoutParams() == null)
      {
        localObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
        ((FrameLayout.LayoutParams)localObject).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
        ((VRefreshViewGroup)((VRecyclerView)this.mHost).getParent()).setViewGroupLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else
      {
        localObject = ((VRefreshViewGroup)((VRecyclerView)this.mHost).getParent()).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = paramInt2;
        ((ViewGroup.LayoutParams)localObject).width = paramInt1;
        if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
        }
      }
      paramVRecyclerView = this.mParent.getChildLayoutParams(this, paramVRecyclerView, paramInt1, paramInt2, 0, 0, 0, 0);
    }
    else
    {
      paramVRecyclerView = this.mParent.getChildLayoutParams(this, paramVRecyclerView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    if (paramVRecyclerView != null) {
      ((VRecyclerView)this.mHost).setLayoutParams(paramVRecyclerView);
    }
    calAndSetContentSize();
  }
  
  @VComponentProp(name="setIsCompatibleLeftPan")
  public void setIsCompatibleLeftPan(Boolean paramBoolean)
  {
    VRefreshViewGroup localVRefreshViewGroup = this.mRealParentView;
    if (localVRefreshViewGroup != null) {
      localVRefreshViewGroup.setIsCompatibleLeftPan(paramBoolean.booleanValue());
    }
  }
  
  @VComponentProp(name="keepPosition")
  public void setKeepPosition(float paramFloat)
  {
    if ((int)ViolaUtils.getFloat(Float.valueOf(paramFloat), Float.valueOf(0.0F)) <= 0) {
      VRecyclerList.RVUpdateOps.access$002(this.updateOps, null);
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPreloadDistance error! value is ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(" error message is:");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e("VRecyclerList", localStringBuilder.toString());
        return;
      }
    }
    ((VRecyclerView)getHostView()).setPreloadDistance(Integer.valueOf(localException).intValue());
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    if (ViolaUtils.getString(paramObject, null) != null)
    {
      int i = -1;
      int j = paramString.hashCode();
      if (j != 529642498)
      {
        if (j != 1043840622)
        {
          if ((j == 1287124693) && (paramString.equals("backgroundColor"))) {
            i = 1;
          }
        }
        else if (paramString.equals("adsorptionOffsetIndex")) {
          i = 2;
        }
      }
      else if (paramString.equals("overflow")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            break label245;
          }
        }
        else
        {
          String str = ViolaUtils.getString(paramObject, null);
          if (!TextUtils.isEmpty(str))
          {
            if ((this.mRealParentView != null) && (!str.equals("transparent")))
            {
              i = ViolaUtils.getColor(str);
              this.mRealParentView.setBackgroundColor(i);
            }
            return super.setProperty(paramString, paramObject);
          }
        }
        i = ViolaUtils.getInt(paramObject, 0);
        if (getHostView() != null) {
          ((VRecyclerView)getHostView()).setPlaceHeaderCount(i);
        }
        return true;
      }
      else
      {
        paramString = ViolaUtils.getString(paramObject, null);
        if ((!TextUtils.isEmpty(paramString)) && (!this.mIsSetInset))
        {
          if (paramString.equals("visible")) {
            this.mIsOverFlow = true;
          } else if (paramString.equals("hidden")) {
            this.mIsOverFlow = false;
          }
          setReadParentOverFlow(this.mIsOverFlow);
        }
        return true;
      }
    }
    label245:
    return super.setProperty(paramString, paramObject);
  }
  
  @VComponentProp(name="showScrollerIndicator")
  public void setScrollIndicator(Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      if (this.mOrientation == 1)
      {
        ((VRecyclerView)getHostView()).setVerticalScrollBarEnabled(paramBoolean.booleanValue());
        return;
      }
      ((VRecyclerView)getHostView()).setHorizontalScrollBarEnabled(paramBoolean.booleanValue());
    }
  }
  
  @VComponentProp(name="scrollMinOffset")
  public void setScrollMinOffset(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    String str = paramObject.toString().trim();
    boolean bool = str.endsWith("dp");
    int i = 0;
    if (bool) {
      try
      {
        int j = FlexConvertUtils.dip2px(Integer.valueOf(str.substring(0, str.indexOf("dp"))).intValue());
        i = j;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setPreloadDistance error! value is ");
        localStringBuilder.append(paramObject);
        localStringBuilder.append(" error message is:");
        localStringBuilder.append(localException.getMessage());
        ViolaLogUtils.e("VRecyclerList", localStringBuilder.toString());
      }
    } else {
      i = Integer.valueOf(localException).intValue();
    }
    ((VRecyclerView)getHostView()).setScrollMinOffset(i);
  }
  
  @VComponentProp(name="setUpdateCheckEnable ")
  public void setUpdateCheckEnable(Boolean paramBoolean)
  {
    this.mUpdateCheckEnable = paramBoolean.booleanValue();
  }
  
  @JSMethod(uiThread=true)
  public void snapToTargetPosition(int paramInt)
  {
    if (getHostView() != null) {
      ((VRecyclerView)getHostView()).snapToTargetPosition(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRecyclerList
 * JD-Core Version:    0.7.0.1
 */