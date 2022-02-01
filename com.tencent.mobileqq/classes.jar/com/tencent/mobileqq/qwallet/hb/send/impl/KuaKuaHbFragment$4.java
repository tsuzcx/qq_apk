package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView;

class KuaKuaHbFragment$4
  implements View.OnClickListener
{
  KuaKuaHbFragment$4(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      KuaKuaHbFragment.c(this.a).setVisibility(0);
      this.a.p = ((TextView)paramView).getText().toString();
      KuaKuaHbFragment.d(this.a).setText(this.a.p);
      KuaKuaHbFragment.b(this.a).setText("");
      paramView = this.a;
      paramView.c(paramView.p);
      KuaKuaHbFragment.a(this.a).setIsShow(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.KuaKuaHbFragment.4
 * JD-Core Version:    0.7.0.1
 */