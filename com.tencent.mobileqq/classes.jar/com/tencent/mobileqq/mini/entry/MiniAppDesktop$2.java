package com.tencent.mobileqq.mini.entry;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopLayout;
import com.tencent.qphone.base.util.QLog;

class MiniAppDesktop$2
  implements View.OnLayoutChangeListener
{
  MiniAppDesktop$2(MiniAppDesktop paramMiniAppDesktop) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt4 != paramInt8)
    {
      paramView = new StringBuilder();
      paramView.append("navigation bar change. rootView Height = ");
      paramView.append(MiniAppDesktop.access$100(this.this$0).getHeight());
      paramView.append(", mode = ");
      paramView.append(MiniAppDesktop.access$200(this.this$0));
      QLog.d("MiniAppDesktop", 1, paramView.toString());
      MiniAppDesktop.access$300(this.this$0).checkContentViewLayoutChanged(MiniAppDesktop.access$100(this.this$0).getHeight());
      if (MiniAppDesktop.access$200(this.this$0) != 3) {
        return;
      }
      MiniAppDesktop.access$300(this.this$0).postDelayed(new MiniAppDesktop.2.1(this), 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDesktop.2
 * JD-Core Version:    0.7.0.1
 */