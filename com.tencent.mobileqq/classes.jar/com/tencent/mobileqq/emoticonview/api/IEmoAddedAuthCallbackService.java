package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IEmoAddedAuthCallbackService
  extends QRouteApi
{
  public abstract UpCallBack createEmoAddedAuthCallback(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, Object paramObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService
 * JD-Core Version:    0.7.0.1
 */