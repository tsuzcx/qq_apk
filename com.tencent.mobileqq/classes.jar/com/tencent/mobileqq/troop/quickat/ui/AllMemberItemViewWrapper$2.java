package com.tencent.mobileqq.troop.quickat.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AllMemberItemViewWrapper$2
  implements View.OnClickListener
{
  AllMemberItemViewWrapper$2(AllMemberItemViewWrapper paramAllMemberItemViewWrapper) {}
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(VasH5PayUtil.e, HardCodeUtil.a(2131700445));
    localBundle.putString(VasH5PayUtil.f, "CJCLUBT");
    localBundle.putString(VasH5PayUtil.d, "1450000516");
    localBundle.putInt(VasH5PayUtil.b, 3);
    String str = VasH5PayUtil.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://h5.vip.qq.com/p/pay/index?_wv=524289&_fv=0&aid=");
    localStringBuilder.append("mvip.pt.vipsite.tqtips_chengyuan");
    localBundle.putString(str, localStringBuilder.toString());
    localBundle.putString(VasH5PayUtil.g, "svip");
    localBundle.putString(VasH5PayUtil.a, AllMemberItemViewWrapper.a(this.a).getCurrentAccountUin());
    VasH5PayUtil.a(AllMemberItemViewWrapper.a(this.a), localBundle);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.2
 * JD-Core Version:    0.7.0.1
 */