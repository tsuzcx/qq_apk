package com.tencent.pts.ui.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeScrollView;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner;
import java.util.ArrayList;
import java.util.List;

public class PTSScrollView
  extends HorizontalScrollView
  implements IView
{
  public final String TAG = "PTSScrollView";
  private FrameLayout container;
  private List<Integer> currentVisibleChildIndexList = new ArrayList();
  private List<Integer> lastVisibleChildIndexList = new ArrayList();
  private PTSViewDecorationUtil.RoundedCorner mRoundedCorner;
  private PTSNodeScrollView node;
  private Rect scrollRect = new Rect();
  
  public PTSScrollView(PTSNodeScrollView paramPTSNodeScrollView)
  {
    super(paramPTSNodeScrollView.getContext());
    this.node = paramPTSNodeScrollView;
    this.container = new FrameLayout(paramPTSNodeScrollView.getContext());
    this.container.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(this.container);
    setHorizontalScrollBarEnabled(false);
    this.mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
  }
  
  private void clearLastVisibleChildIndexList()
  {
    this.lastVisibleChildIndexList.clear();
  }
  
  private void triggerItemViewExposureImp()
  {
    PTSThreadUtil.runOnUIThread(new PTSScrollView.1(this));
  }
  
  public void addChild(View paramView)
  {
    FrameLayout localFrameLayout = this.container;
    if ((localFrameLayout != null) && (paramView != null))
    {
      localFrameLayout.addView(paramView);
      return;
    }
    PTSLog.e("PTSScrollView", "[addChild] failed, container or view is null.");
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = this.mRoundedCorner.getSaveCount(paramCanvas);
    super.draw(paramCanvas);
    this.mRoundedCorner.drawCorner(paramCanvas, i);
    this.mRoundedCorner.drawBorder(paramCanvas);
    triggerItemViewExposureImp();
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    this.mRoundedCorner.onBindNodeInfo(paramPTSNodeInfo);
    clearLastVisibleChildIndexList();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    clearLastVisibleChildIndexList();
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      clearLastVisibleChildIndexList();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      clearLastVisibleChildIndexList();
      return;
    }
    triggerItemViewExposureImp();
  }
  
  public void removeChild(View paramView)
  {
    FrameLayout localFrameLayout = this.container;
    if ((localFrameLayout != null) && (paramView != null))
    {
      localFrameLayout.removeView(paramView);
      return;
    }
    PTSLog.e("PTSScrollView", "[removeChild] failed, container or view is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSScrollView
 * JD-Core Version:    0.7.0.1
 */