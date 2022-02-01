package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.open.agent.util.SSOLog;

class BaseAuthorityAccountView$1
  implements View.OnLayoutChangeListener
{
  BaseAuthorityAccountView$1(BaseAuthorityAccountView paramBaseAuthorityAccountView, RelativeLayout paramRelativeLayout) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramView.getHeight();
    paramInt2 = this.a.getHeight();
    paramView = new StringBuilder();
    paramView.append("onLayoutChange height=");
    paramView.append(paramInt1);
    paramView.append(", contentHeight=");
    paramView.append(paramInt2);
    SSOLog.a("BaseAuthorityAccountView", new Object[] { paramView.toString() });
    paramView = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    if (paramView == null) {
      paramView = new RelativeLayout.LayoutParams(-1, -2);
    } else {
      paramView.height = -2;
    }
    paramView.addRule(12);
    this.a.setLayoutParams(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.1
 * JD-Core Version:    0.7.0.1
 */