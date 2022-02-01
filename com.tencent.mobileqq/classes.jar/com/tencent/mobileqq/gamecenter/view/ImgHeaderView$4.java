package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImgHeaderView$4
  implements View.OnClickListener
{
  ImgHeaderView$4(ImgHeaderView paramImgHeaderView, Context paramContext, QQGameMsgInfo paramQQGameMsgInfo, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    ImgHeaderView.a(this.e, this.a, this.b.paMsgid, this.b.gameAppId, this.c, this.b, this.d);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ImgHeaderView.4
 * JD-Core Version:    0.7.0.1
 */