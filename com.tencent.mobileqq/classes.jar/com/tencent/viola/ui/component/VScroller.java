package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.view.VFooterLayout;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.VScrollView;
import com.tencent.viola.ui.view.VScrollView.OnScrollListener;
import com.tencent.viola.ui.view.VScrollView.VScrollViewListener;
import com.tencent.viola.ui.view.refresh.VRefreshContentView.ContentViewProvider;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VScroller
  extends VComponentContainer<VScrollView>
  implements VScrollView.OnScrollListener
{
  public static final String SCROLLER_EVENT_FINISH = "loadFinish";
  public static final String SCROLLER_EVENT_LOADMORE = "loadMore";
  public static final String SCROLLER_EVENT_SCROLL = "scroll";
  public static final String SCROLLER_EVENT_SCROLLEND = "scrollEnd";
  public static final String SCROLLER_EVENT_SCROLL_CREATED = "scrollCreated";
  public static final String TAG = "VScroller";
  private Map<String, String> mAppearanceComponents = new HashMap();
  private boolean mIsOverFlow = false;
  private VRefreshViewGroup mRealParentView;
  private VScrollView.VScrollViewListener mScrollEventListener = new VScroller.1(this);
  
  public VScroller(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
    ViolaSDKManager.getInstance().postOnUiThread(new VScroller.2(this));
  }
  
  private void createRealParentView()
  {
    if ((this.mRealParentView == null) && ((getContext() != null) || ((getInstance() != null) && (getInstance().getActivity() != null))))
    {
      if (getContext() != null) {
        this.mRealParentView = new VRefreshViewGroup(getContext());
      } else {
        this.mRealParentView = new VRefreshViewGroup(getInstance().getActivity());
      }
      if (this.mIsOverFlow)
      {
        this.mRealParentView.setClipToPadding(false);
        this.mRealParentView.setClipChildren(false);
        if (this.mHost != null)
        {
          ((VScrollView)this.mHost).setClipToPadding(false);
          ((VScrollView)this.mHost).setClipChildren(false);
        }
      }
      else
      {
        this.mRealParentView.setClipToPadding(true);
        this.mRealParentView.setClipChildren(true);
        if (this.mHost != null)
        {
          ((VScrollView)this.mHost).setClipToPadding(true);
          ((VScrollView)this.mHost).setClipChildren(true);
        }
      }
    }
  }
  
  private void dealAddScrollerChild(View paramView)
  {
    if (getRealView().getChildAt(0) == null)
    {
      FrameLayout localFrameLayout = new FrameLayout(getRealView().getContext());
      localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView(paramView);
      getRealView().addView(localFrameLayout);
      return;
    }
    ((FrameLayout)getRealView().getChildAt(0)).addView(paramView);
  }
  
  private void dealAddScrollerChild(View paramView, int paramInt)
  {
    if (getRealView().getChildAt(0) == null)
    {
      FrameLayout localFrameLayout = new FrameLayout(getRealView().getContext());
      localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      localFrameLayout.addView(paramView, paramInt);
      getRealView().addView(localFrameLayout);
      return;
    }
    ((FrameLayout)getRealView().getChildAt(0)).addView(paramView, paramInt);
  }
  
  private void scrollfireEvent(String paramString, DomObject paramDomObject)
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    paramDomObject = paramDomObject.getRef();
    if (paramDomObject != null) {
      localJSONArray.put(paramDomObject);
    }
    localJSONArray.put(paramString);
    paramDomObject = new StringBuilder();
    paramDomObject.append("mScrollEventListener callData :");
    paramDomObject.append(localJSONArray.toString());
    ViolaLogUtils.d("VScroller", paramDomObject.toString());
    fireEvent(paramString, localJSONArray, localJSONObject);
  }
  
  private void scrollfireEvent(String paramString, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    fireEvent(paramString, paramJSONArray, paramJSONObject);
  }
  
  public void addEvent(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1845399899: 
      if (paramString.equals("loadMore")) {
        i = 0;
      }
      break;
    case 1487101787: 
      if (paramString.equals("scrollCreated")) {
        i = 3;
      }
      break;
    case 417766094: 
      if (paramString.equals("scrollEnd")) {
        i = 2;
      }
      break;
    case -907680051: 
      if (paramString.equals("scroll")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3))
    {
      super.addEvent(paramString);
      return;
    }
    this.mAppendEvents.add(paramString);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
  public void addSubView(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      if (getRealView() == null) {
        return;
      }
      int i = paramInt;
      if (paramInt >= getRealView().getChildCount()) {
        i = -1;
      }
      if (i == -1)
      {
        if ((paramView instanceof VRefreshLayout))
        {
          setHeadView(paramView);
          return;
        }
        if ((paramView instanceof VFooterLayout))
        {
          setFooterView(paramView);
          return;
        }
        dealAddScrollerChild(paramView);
        setContentView((VRefreshContentView.ContentViewProvider)getHostView());
        return;
      }
      if ((paramView instanceof VRefreshLayout))
      {
        setHeadView(paramView);
        return;
      }
      if ((paramView instanceof VFooterLayout))
      {
        setFooterView(paramView);
        return;
      }
      dealAddScrollerChild(paramView, i);
      setContentView((VRefreshContentView.ContentViewProvider)getHostView());
    }
  }
  
  public void addSubViewOnIntercept(ViewGroup paramViewGroup, int paramInt)
  {
    ViolaUtils.addViewParentToView(paramViewGroup, getHostView(), paramInt);
  }
  
  public void createViewImpl()
  {
    super.createViewImpl();
    if (this.mHost != null)
    {
      ((VScrollView)this.mHost).setClipToPadding(true);
      ((VScrollView)this.mHost).setClipChildren(true);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mAppendEvents.size() > 0) {
      this.mAppendEvents.clear();
    }
    VRefreshViewGroup localVRefreshViewGroup = this.mRealParentView;
    if (localVRefreshViewGroup != null) {
      localVRefreshViewGroup.onDestroy();
    }
  }
  
  public ViewGroup.LayoutParams getChildLayoutParams(VComponent paramVComponent, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    ViewGroup.LayoutParams localLayoutParams;
    if (paramView != null) {
      localLayoutParams = paramView.getLayoutParams();
    } else {
      localLayoutParams = null;
    }
    if (localLayoutParams == null)
    {
      paramView = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      if ((paramVComponent instanceof VFooter)) {
        paramInt5 = 0;
      }
      ((FrameLayout.LayoutParams)paramView).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
      return paramView;
    }
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    if (((paramView.getParent() instanceof FrameLayout)) && ((paramView.getParent().getParent() instanceof VScrollView)) && ((paramView.getParent().getParent().getParent() instanceof VRefreshViewGroup)))
    {
      paramInt1 = ((VRefreshViewGroup)paramView.getParent().getParent().getParent()).getHeaderViewHeight();
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(paramInt3, paramInt5 - paramInt1, paramInt4, paramInt6);
      return localLayoutParams;
    }
    if ((paramVComponent instanceof VFooter)) {
      paramInt5 = 0;
    }
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
    }
    return localLayoutParams;
  }
  
  @JSMethod(uiThread=true)
  public void getPosition(String paramString)
  {
    Object localObject = (ScrollView)getHostView();
    float f1 = ((ScrollView)localObject).getScrollX();
    float f2 = ((ScrollView)localObject).getScrollY();
    float f3 = ((ScrollView)localObject).getWidth();
    float f4 = ((ScrollView)localObject).getHeight();
    JSONObject localJSONObject = new JSONObject();
    localObject = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(f1));
      localStringBuilder.append("dp");
      localJSONObject.put("x", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(f2));
      localStringBuilder.append("dp");
      localJSONObject.put("y", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(f3));
      localStringBuilder.append("dp");
      localJSONObject.put("width", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(f4));
      localStringBuilder.append("dp");
      localJSONObject.put("height", localStringBuilder.toString());
      ((JSONObject)localObject).put("frame", localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localJSONArray, localObject, true);
  }
  
  protected VScrollView initComponentHostView(@NonNull Context paramContext)
  {
    createRealParentView();
    paramContext = new VScrollView(paramContext);
    paramContext.bindComponent(this);
    paramContext.addScrollViewListener(this.mScrollEventListener);
    return paramContext;
  }
  
  public boolean isInterceptAddView()
  {
    return true;
  }
  
  @JSMethod(uiThread=false)
  public void loadMoreFinish(Object paramObject)
  {
    ((VScrollView)getHostView()).loadMoreFinish(Boolean.valueOf(false));
    ViolaLogUtils.d("VScroller", "loadMoreFinish :预下载回调成功");
  }
  
  public void onScroll(int paramInt1, int paramInt2) {}
  
  public void onScrollStateChanged(ScrollView paramScrollView, int paramInt, boolean paramBoolean)
  {
    paramScrollView = ViolaSDKManager.getInstance().getReportDelegate();
    if (paramScrollView != null) {
      paramScrollView.dropFrameMonitor(paramInt, ViolaEnvironment.LIST_KANDIAN_VIOLA);
    }
  }
  
  public void remove(VComponent paramVComponent, boolean paramBoolean)
  {
    if ((paramVComponent != null) && (this.mChildren != null))
    {
      if (this.mChildren.size() == 0) {
        return;
      }
      this.mChildren.remove(paramVComponent);
      if ((getRealView() != null) && ((getRealView().getChildAt(0) instanceof ViewGroup))) {
        ((ViewGroup)getRealView().getChildAt(0)).removeView(paramVComponent.getHostView());
      }
      if (paramBoolean) {
        paramVComponent.destroy();
      }
    }
  }
  
  @JSMethod(uiThread=true)
  public void scrollToTop(Boolean paramBoolean)
  {
    if ((getHostView() instanceof VScrollView))
    {
      VRefreshViewGroup localVRefreshViewGroup = this.mRealParentView;
      if (localVRefreshViewGroup != null) {
        localVRefreshViewGroup.scrollerToTop(false, paramBoolean.booleanValue());
      }
    }
  }
  
  @VComponentProp(name="bouncesEnable")
  public void setBouncesEnable(Boolean paramBoolean)
  {
    VRefreshViewGroup localVRefreshViewGroup = this.mRealParentView;
    if (localVRefreshViewGroup != null)
    {
      localVRefreshViewGroup.setAllowHeaderSliding(paramBoolean.booleanValue());
      this.mRealParentView.setAllowFooterSliding(paramBoolean.booleanValue());
    }
  }
  
  public void setContentView(VRefreshContentView.ContentViewProvider paramContentViewProvider)
  {
    if (this.mRealParentView == null) {
      createRealParentView();
    }
    this.mRealParentView.setContentViewProvider(paramContentViewProvider);
    ((VScrollView)getHostView()).setOnScrollListener(this);
    ((VScrollView)getHostView()).addParentTouchLifeCycle(this.mRealParentView);
    ((VScrollView)getHostView()).setOverScrollMode(2);
  }
  
  public void setFooterView(View paramView)
  {
    if (this.mRealParentView == null) {
      createRealParentView();
    }
    this.mRealParentView.setFooterView(paramView);
  }
  
  public void setHeadView(View paramView)
  {
    if (this.mRealParentView == null) {
      createRealParentView();
    }
    this.mRealParentView.setHeaderView(paramView);
  }
  
  public void setHostLayoutParams(VScrollView paramVScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.mHost == null) {
      return;
    }
    if (this.mParent == null)
    {
      paramVScrollView = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramVScrollView.setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
    }
    else
    {
      if ((((VScrollView)this.mHost).getParent() instanceof VRefreshViewGroup))
      {
        Object localObject;
        if (((VRefreshViewGroup)((VScrollView)this.mHost).getParent()).getLayoutParams() == null)
        {
          localObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
          ((FrameLayout.LayoutParams)localObject).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
          ((VRefreshViewGroup)((VScrollView)this.mHost).getParent()).setViewGroupLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        else
        {
          localObject = ((VRefreshViewGroup)((VScrollView)this.mHost).getParent()).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = paramInt2;
          ((ViewGroup.LayoutParams)localObject).width = paramInt1;
          if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams)localObject).setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
          }
        }
        paramVScrollView = this.mParent.getChildLayoutParams(this, paramVScrollView, paramInt1, paramInt2, 0, 0, 0, 0);
      }
      else
      {
        paramVScrollView = this.mParent.getChildLayoutParams(this, paramVScrollView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      }
      setContentHeight(paramInt2);
      setContentWidth(paramInt1);
    }
    if (paramVScrollView != null) {
      ((VScrollView)this.mHost).setLayoutParams(paramVScrollView);
    }
  }
  
  @VComponentProp(name="preloadDistance")
  public void setPreDistance(int paramInt)
  {
    ((VScrollView)getHostView()).setPreloadDistance((int)FlexConvertUtils.converPxByViewportToRealPx(Integer.valueOf(paramInt), 750));
  }
  
  public boolean setProperty(String paramString, Object paramObject)
  {
    if (ViolaUtils.getString(paramObject, null) != null)
    {
      int i = -1;
      int j = paramString.hashCode();
      if (j != 529642498)
      {
        if ((j == 1287124693) && (paramString.equals("backgroundColor"))) {
          i = 1;
        }
      }
      else if (paramString.equals("overflow")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i == 1)
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
      }
      else
      {
        paramString = ViolaUtils.getString(paramObject, null);
        if (!TextUtils.isEmpty(paramString))
        {
          if (paramString.equals("visible")) {
            this.mIsOverFlow = true;
          } else if (paramString.equals("hidden")) {
            this.mIsOverFlow = false;
          }
          setReadParentOverFlow(paramString);
        }
        return true;
      }
    }
    return super.setProperty(paramString, paramObject);
  }
  
  public void setReadParentOverFlow(String paramString)
  {
    if (this.mRealParentView != null) {
      if (paramString.equals("visible"))
      {
        this.mRealParentView.setClipToPadding(false);
        this.mRealParentView.setClipChildren(false);
        if (this.mHost != null)
        {
          ((VScrollView)this.mHost).setClipToPadding(false);
          ((VScrollView)this.mHost).setClipChildren(false);
        }
      }
      else if (paramString.equals("hidden"))
      {
        this.mRealParentView.setClipToPadding(true);
        this.mRealParentView.setClipChildren(true);
        if (this.mHost != null)
        {
          ((VScrollView)this.mHost).setClipToPadding(true);
          ((VScrollView)this.mHost).setClipChildren(true);
        }
      }
    }
  }
  
  @VComponentProp(name="showScrollerIndicator", nativeReturnMethod="isVerticalScrollBarEnabled")
  public void setScrollIndicator(Boolean paramBoolean)
  {
    if (paramBoolean != null) {
      ((VScrollView)getHostView()).setShowScrollerIndicator(paramBoolean.booleanValue());
    }
  }
  
  @VComponentProp(name="scrollMinOffset")
  public void setScrollMinOffset(int paramInt)
  {
    ((VScrollView)getHostView()).setMinOffset((int)FlexConvertUtils.converPxByViewportToRealPx(Integer.valueOf(paramInt), 750));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.VScroller
 * JD-Core Version:    0.7.0.1
 */