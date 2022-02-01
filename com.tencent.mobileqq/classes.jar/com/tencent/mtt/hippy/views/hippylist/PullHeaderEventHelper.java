package com.tencent.mtt.hippy.views.hippylist;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mtt.a.a.a.b.a;
import com.tencent.mtt.a.a.a.b.b;
import com.tencent.mtt.a.a.a.b.c;
import com.tencent.mtt.a.a.a.b.e;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.utils.PixelUtil;

public class PullHeaderEventHelper
  implements b, c, e
{
  public static final String EVENT_TYPE_HEADER_PULLING = "onHeaderPulling";
  public static final String EVENT_TYPE_HEADER_RELEASED = "onHeaderReleased";
  private LinearLayout.LayoutParams contentLayoutParams;
  private LinearLayout headerContainer;
  private a headerRefreshHelper;
  private HippyRecyclerView recyclerView;
  private final i renderNode;
  private View renderNodeView;
  
  PullHeaderEventHelper(HippyRecyclerView paramHippyRecyclerView, i parami)
  {
    this.recyclerView = paramHippyRecyclerView;
    this.renderNode = parami;
    this.headerContainer = new LinearLayout(paramHippyRecyclerView.getContext());
    this.headerRefreshHelper = new a();
    this.headerRefreshHelper.a(this);
    this.headerRefreshHelper.a(this);
    this.headerRefreshHelper.a(this);
    paramHippyRecyclerView.setOnTouchListener(this.headerRefreshHelper);
  }
  
  public int getContentHeight()
  {
    return this.renderNode.getHeight();
  }
  
  public View getView()
  {
    return this.headerContainer;
  }
  
  public void onFolded() {}
  
  public void onHeaderHeightChanged(int paramInt)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushDouble("contentOffset", PixelUtil.px2dp(paramInt));
    sendPullHeaderEvent("onHeaderPulling", localHippyMap);
  }
  
  public void onHeaderRefresh()
  {
    this.headerRefreshHelper.d();
  }
  
  public void onHeaderRefreshFinish()
  {
    this.headerRefreshHelper.a();
  }
  
  public void onHeaderRefreshing(int paramInt)
  {
    sendPullHeaderEvent("onHeaderReleased", new HippyMap());
  }
  
  public void onRefreshing() {}
  
  public void onStartDrag() {}
  
  public void requestLayout()
  {
    this.recyclerView.dispatchLayout();
  }
  
  protected void sendPullHeaderEvent(String paramString, HippyMap paramHippyMap)
  {
    new HippyViewEvent(paramString).send(this.renderNodeView, paramHippyMap);
  }
  
  public void setRenderNodeView(View paramView)
  {
    if (this.renderNodeView != paramView)
    {
      this.renderNodeView = paramView;
      this.headerContainer.removeAllViews();
      this.contentLayoutParams = new LinearLayout.LayoutParams(-1, this.renderNode.getHeight());
      LinearLayout.LayoutParams localLayoutParams = this.contentLayoutParams;
      localLayoutParams.gravity = 80;
      this.headerContainer.addView(paramView, localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.hippylist.PullHeaderEventHelper
 * JD-Core Version:    0.7.0.1
 */