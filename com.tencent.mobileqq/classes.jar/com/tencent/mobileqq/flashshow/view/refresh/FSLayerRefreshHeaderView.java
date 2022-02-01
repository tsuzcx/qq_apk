package com.tencent.mobileqq.flashshow.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.view.FSPageTurnContainer.OnRefreshLoadViewStatusListener;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class FSLayerRefreshHeaderView
  extends FSBaseWidgetView
  implements IRefreshView
{
  private static final String d = FSHardCodeUtil.a(2131889536);
  private static final String e = FSHardCodeUtil.a(2131889534);
  private TextView a;
  private FSPageTurnContainer.OnRefreshLoadViewStatusListener b;
  private ChrysanthemumLoadingView c;
  
  public FSLayerRefreshHeaderView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSLayerRefreshHeaderView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(PullRefreshLayout paramPullRefreshLayout)
  {
    this.a.setText(d);
    this.a.setVisibility(8);
    this.c.setVisibility(8);
    invalidate();
    paramPullRefreshLayout = this.b;
    if (paramPullRefreshLayout != null) {
      paramPullRefreshLayout.a(false);
    }
    QLog.d("FSLayerRefreshHeaderView", 1, "onStart");
  }
  
  public void a(PullRefreshLayout paramPullRefreshLayout, float paramFloat)
  {
    if (paramFloat >= 1.0F) {
      this.a.setText(e);
    } else {
      this.a.setText(d);
    }
    if (paramFloat < 0.5D)
    {
      setVisibility(8);
    }
    else
    {
      this.a.setAlpha((paramFloat - 0.5F) * 2.0F);
      setVisibility(0);
      this.a.setVisibility(0);
    }
    invalidate();
    paramPullRefreshLayout = this.b;
    if (paramPullRefreshLayout != null) {
      paramPullRefreshLayout.a(false, paramFloat);
    }
  }
  
  public void a(PullRefreshLayout paramPullRefreshLayout, boolean paramBoolean)
  {
    FSThreadUtils.a(new FSLayerRefreshHeaderView.1(this), 300L);
  }
  
  public void b(PullRefreshLayout paramPullRefreshLayout)
  {
    this.a.setVisibility(8);
    this.c.setVisibility(0);
    this.c.a();
    invalidate();
    paramPullRefreshLayout = this.b;
    if (paramPullRefreshLayout != null) {
      paramPullRefreshLayout.c(false);
    }
    QLog.d("FSLayerRefreshHeaderView", 1, "onRefresh");
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131624811;
  }
  
  public View getRefreshView()
  {
    return this;
  }
  
  public int getStartRefreshDistance()
  {
    return ViewUtils.dpToPx(48.0F);
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131448568));
    this.c = ((ChrysanthemumLoadingView)paramView.findViewById(2131437664));
  }
  
  public void setOnRefreshViewStatusListener(FSPageTurnContainer.OnRefreshLoadViewStatusListener paramOnRefreshLoadViewStatusListener)
  {
    this.b = paramOnRefreshLoadViewStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.refresh.FSLayerRefreshHeaderView
 * JD-Core Version:    0.7.0.1
 */