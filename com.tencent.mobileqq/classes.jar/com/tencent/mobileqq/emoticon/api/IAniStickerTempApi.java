package com.tencent.mobileqq.emoticon.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

@QAPI(process={"all"})
public abstract interface IAniStickerTempApi
  extends QRouteApi
{
  public abstract void addFavoriteForAniSticker(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, MessageForAniSticker paramMessageForAniSticker);
  
  public abstract void checkAndAddTogetherWriteMenu(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, Context paramContext, MessageForAniSticker paramMessageForAniSticker, QQCustomMenu paramQQCustomMenu);
  
  public abstract void copySysEmoAniStickerText(MessageForAniSticker paramMessageForAniSticker, String paramString, Context paramContext);
  
  public abstract void delMsg(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, MessageForAniSticker paramMessageForAniSticker);
  
  public abstract void forwardMsg(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, MessageForAniSticker paramMessageForAniSticker, BaseSessionInfo paramBaseSessionInfo);
  
  public abstract boolean isSupportRevokeMsgByTroopOwnerOrMgr(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString);
  
  public abstract void launchWriteTogether(MessageForAniSticker paramMessageForAniSticker, Context paramContext);
  
  public abstract void openTextPreview(View paramView, BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.IAniStickerTempApi
 * JD-Core Version:    0.7.0.1
 */