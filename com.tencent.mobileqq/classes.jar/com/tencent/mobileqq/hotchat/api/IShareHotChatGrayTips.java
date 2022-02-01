package com.tencent.mobileqq.hotchat.api;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IShareHotChatGrayTips
  extends QRouteApi
{
  public abstract SpannableString getHighlightMsgText(AppInterface paramAppInterface, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.api.IShareHotChatGrayTips
 * JD-Core Version:    0.7.0.1
 */