package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView.OnVisibilityChangeListener;

class KuaKuaHbFragment$6
  implements ChooseItemView.OnVisibilityChangeListener
{
  KuaKuaHbFragment$6(KuaKuaHbFragment paramKuaKuaHbFragment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.a.findViewById(R.id.aw).setVisibility(8);
      this.a.a.findViewById(R.id.cb).setVisibility(8);
      KuaKuaHbFragment.e(this.a).setVisibility(8);
      return;
    }
    this.a.a.findViewById(R.id.aw).setVisibility(0);
    this.a.a.findViewById(R.id.cb).setVisibility(0);
    KuaKuaHbFragment.e(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.KuaKuaHbFragment.6
 * JD-Core Version:    0.7.0.1
 */