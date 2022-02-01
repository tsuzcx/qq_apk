package com.tencent.mobileqq.profilecard.vas.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VasProfileWZRYView$1
  implements View.OnClickListener
{
  VasProfileWZRYView$1(VasProfileWZRYView paramVasProfileWZRYView, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onClick(View paramView)
  {
    String str = IndividuationUrlHelper.a("gameHonourAddHonour");
    VasWebviewUtil.b(VasProfileWZRYView.access$000(this.this$0), str, -1L, null, false, -1);
    VasWebviewUtil.a("", "card_gameking", "clk_into", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(this.val$cardInfo.card.lCurrentBgId), String.valueOf(this.val$cardInfo.card.lCurrentStyleId));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView.1
 * JD-Core Version:    0.7.0.1
 */