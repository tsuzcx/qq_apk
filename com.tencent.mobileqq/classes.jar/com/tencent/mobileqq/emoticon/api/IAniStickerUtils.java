package com.tencent.mobileqq.emoticon.api;

import android.content.Context;
import android.widget.PopupWindow;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.emoticon.IAniStickerAIOOperation;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAniStickerUtils
  extends QRouteApi
{
  public static final int ANI_STICKER_TYPE_EMOJI = 1;
  
  public abstract boolean checkIsNeedShowAniStickerPreGuide();
  
  public abstract IAniStickerAIOOperation createAniStickerAIOOperation(int paramInt, Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo);
  
  public abstract PopupWindow createAniStickerPreGuideView(Context paramContext);
  
  public abstract Size getAniStickerPreGuideViewSize();
  
  public abstract void notifyAniStickerPreGuideShow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.IAniStickerUtils
 * JD-Core Version:    0.7.0.1
 */