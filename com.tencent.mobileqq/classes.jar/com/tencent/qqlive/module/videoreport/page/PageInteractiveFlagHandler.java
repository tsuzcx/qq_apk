package com.tencent.qqlive.module.videoreport.page;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ReflectUtils;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

class PageInteractiveFlagHandler
  extends DefaultEventListener
{
  private boolean mIsBeforeNeedMark = false;
  private final PageManager mPageManager;
  private final Map<View, Set<View>> mPagePathViewsMap = new WeakHashMap();
  private final Rect mRect = new Rect();
  
  private PageInteractiveFlagHandler(PageManager paramPageManager)
  {
    this.mPageManager = paramPageManager;
  }
  
  @NonNull
  private Set<View> buildPagePathViews(@NonNull View paramView)
  {
    Set localSet = BaseUtils.newWeakHashSet();
    while ((paramView instanceof View))
    {
      paramView = (View)paramView;
      localSet.add(paramView);
      paramView = paramView.getParent();
    }
    return localSet;
  }
  
  static PageInteractiveFlagHandler create(PageManager paramPageManager)
  {
    paramPageManager = new PageInteractiveFlagHandler(paramPageManager);
    EventCollector.getInstance().registerEventListener(paramPageManager);
    return paramPageManager;
  }
  
  @NonNull
  private Set<View> getPagePathViews(@NonNull View paramView)
  {
    Set localSet2 = (Set)this.mPagePathViewsMap.get(paramView);
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = buildPagePathViews(paramView);
      this.mPagePathViewsMap.put(paramView, localSet1);
    }
    return localSet1;
  }
  
  private Object getTouchTarget(View paramView)
  {
    if (!(paramView instanceof ViewGroup)) {
      return Boolean.valueOf(false);
    }
    return ReflectUtils.getField(ViewGroup.class, "mFirstTouchTarget", paramView);
  }
  
  private boolean isTouchedInCurPage(MotionEvent paramMotionEvent, View paramView1, View paramView2)
  {
    if (!paramView2.getGlobalVisibleRect(this.mRect)) {
      return false;
    }
    if (!this.mRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return false;
    }
    paramMotionEvent = getPagePathViews(paramView2);
    if (paramMotionEvent.isEmpty()) {
      return false;
    }
    return isTouchedInCurPage(paramView1, paramView2, paramMotionEvent);
  }
  
  private boolean isTouchedInCurPage(View paramView1, View paramView2, Set<View> paramSet)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    if (!paramSet.contains(paramView1)) {
      return false;
    }
    Object localObject = getTouchTarget(paramView1);
    paramView1 = localObject;
    if (localObject == null) {
      return false;
    }
    while (paramView1 != null)
    {
      localObject = ReflectUtils.getField("child", paramView1);
      if (((localObject instanceof View)) && (isTouchedInCurPage((View)localObject, paramView2, paramSet))) {
        return true;
      }
      paramView1 = ReflectUtils.getField("next", paramView1);
    }
    return false;
  }
  
  private void markInteractiveFlagToPage(PageInfo paramPageInfo)
  {
    DataRWProxy.setInnerParam(paramPageInfo.getPage(), "page_interactive_flag", Boolean.valueOf(true));
  }
  
  private boolean needMarkInteractiveFlag(Window paramWindow, MotionEvent paramMotionEvent, boolean paramBoolean, PageInfo paramPageInfo)
  {
    if (paramMotionEvent.getAction() == 0) {
      return false;
    }
    if (!paramBoolean)
    {
      if (paramPageInfo == null) {
        return false;
      }
      Object localObject = paramPageInfo.getPage();
      paramPageInfo = paramPageInfo.getPageView();
      if (localObject != null)
      {
        if (paramPageInfo == null) {
          return false;
        }
        localObject = DataRWProxy.getInnerParam(localObject, "page_interactive_flag");
        if (((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue())) {
          return false;
        }
        if (paramWindow == null) {
          paramWindow = null;
        } else {
          paramWindow = paramWindow.getDecorView();
        }
        localObject = paramPageInfo.getRootView();
        if (paramWindow != null)
        {
          if (paramWindow != localObject) {
            return false;
          }
          return isTouchedInCurPage(paramMotionEvent, paramWindow, paramPageInfo);
        }
      }
    }
    return false;
  }
  
  public void onDispatchTouchEvent(Object paramObject, Window paramWindow, MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.mIsBeforeNeedMark = needMarkInteractiveFlag(paramWindow, paramMotionEvent, this.mPageManager.isLastPageIsDisappear(), this.mPageManager.getCurrentPageInfo());
      return;
    }
    if ((paramBoolean1) && (this.mIsBeforeNeedMark)) {
      markInteractiveFlagToPage(this.mPageManager.getCurrentPageInfo());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageInteractiveFlagHandler
 * JD-Core Version:    0.7.0.1
 */