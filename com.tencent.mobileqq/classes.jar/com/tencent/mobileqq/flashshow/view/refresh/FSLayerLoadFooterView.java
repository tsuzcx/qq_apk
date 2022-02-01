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
import com.tencent.qphone.base.util.QLog;

public class FSLayerLoadFooterView
  extends FSBaseWidgetView
  implements IRefreshView
{
  private ChrysanthemumLoadingView a;
  private FSPageTurnContainer.OnRefreshLoadViewStatusListener b;
  private TextView c;
  
  public FSLayerLoadFooterView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSLayerLoadFooterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSLayerLoadFooterView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean c(PullRefreshLayout paramPullRefreshLayout)
  {
    if (paramPullRefreshLayout != null)
    {
      if (paramPullRefreshLayout.d()) {
        return false;
      }
      QLog.d("FSLayerLoadFooterView", 1, "checkSetIsFinishStatus  has no more data");
      this.c.setText(FSHardCodeUtil.a(2131889530));
      this.c.setVisibility(0);
      this.a.b();
      this.a.setVisibility(8);
      invalidate();
      return true;
    }
    return false;
  }
  
  public void a(PullRefreshLayout paramPullRefreshLayout)
  {
    QLog.d("FSLayerLoadFooterView", 1, "onStart");
    if (c(paramPullRefreshLayout)) {
      return;
    }
    paramPullRefreshLayout = this.b;
    if (paramPullRefreshLayout != null) {
      paramPullRefreshLayout.a(true);
    }
  }
  
  public void a(PullRefreshLayout paramPullRefreshLayout, float paramFloat)
  {
    if (c(paramPullRefreshLayout)) {
      return;
    }
    paramPullRefreshLayout = this.b;
    if (paramPullRefreshLayout != null) {
      paramPullRefreshLayout.a(true, paramFloat);
    }
  }
  
  public void a(PullRefreshLayout paramPullRefreshLayout, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onComplete  hasMoreData = ");
    localStringBuilder.append(paramBoolean);
    QLog.d("FSLayerLoadFooterView", 1, localStringBuilder.toString());
    FSThreadUtils.a(new FSLayerLoadFooterView.1(this, paramPullRefreshLayout), 300L);
    paramPullRefreshLayout = this.b;
    if (paramPullRefreshLayout != null) {
      paramPullRefreshLayout.b(true);
    }
  }
  
  public void b(PullRefreshLayout paramPullRefreshLayout)
  {
    QLog.d("FSLayerLoadFooterView", 1, "onRefresh");
    if (c(paramPullRefreshLayout)) {
      return;
    }
    this.a.setVisibility(0);
    this.a.a();
    this.c.setVisibility(8);
    invalidate();
    paramPullRefreshLayout = this.b;
    if (paramPullRefreshLayout != null) {
      paramPullRefreshLayout.c(true);
    }
  }
  
  protected void bindData(Object paramObject, int paramInt) {}
  
  public int getLayoutId()
  {
    return 2131624810;
  }
  
  public View getRefreshView()
  {
    return this;
  }
  
  public int getStartRefreshDistance()
  {
    return 0;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((ChrysanthemumLoadingView)paramView.findViewById(2131437664));
    this.c = ((TextView)paramView.findViewById(2131448568));
  }
  
  public void setOnRefreshViewStatusListener(FSPageTurnContainer.OnRefreshLoadViewStatusListener paramOnRefreshLoadViewStatusListener)
  {
    this.b = paramOnRefreshLoadViewStatusListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.refresh.FSLayerLoadFooterView
 * JD-Core Version:    0.7.0.1
 */