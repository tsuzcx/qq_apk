package com.tencent.mobileqq.emoticon.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.api.IAniStickerTempApi;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.together.writetogether.WTUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherConfig;

public class AniStickerTempApiImpl
  implements IAniStickerTempApi
{
  public void addFavoriteForAniSticker(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, MessageForAniSticker paramMessageForAniSticker)
  {
    String str = paramMessageForAniSticker.getSummaryMsg();
    TextItemBuilder.a((QQAppInterface)paramBaseQQAppInterface, (Activity)paramContext, paramMessageForAniSticker, str);
  }
  
  public void checkAndAddTogetherWriteMenu(BaseQQAppInterface paramBaseQQAppInterface, BaseSessionInfo paramBaseSessionInfo, Context paramContext, MessageForAniSticker paramMessageForAniSticker, QQCustomMenu paramQQCustomMenu)
  {
    if (!(paramContext instanceof BaseActivity)) {
      return;
    }
    Object localObject = ((BaseActivity)paramContext).getChatFragment();
    if (localObject == null) {
      return;
    }
    localObject = ((ChatFragment)localObject).k();
    if (localObject == null) {
      return;
    }
    localObject = (WriteTogetherHelper)((BaseChatPie)localObject).q(74);
    int i;
    if ((localObject != null) && (((WriteTogetherHelper)localObject).d())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(paramBaseQQAppInterface, paramBaseSessionInfo.b)) && (i != 0) && (paramMessageForAniSticker != null) && (paramQQCustomMenu != null) && (paramContext != null) && (WTUtils.a((SessionInfo)paramBaseSessionInfo))) {
      paramQQCustomMenu.a(2131450309, paramContext.getString(2131918127), 0);
    }
  }
  
  public void copySysEmoAniStickerText(MessageForAniSticker paramMessageForAniSticker, String paramString, Context paramContext) {}
  
  public void delMsg(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, MessageForAniSticker paramMessageForAniSticker)
  {
    ChatActivityFacade.b(paramContext, (QQAppInterface)paramBaseQQAppInterface, paramMessageForAniSticker);
  }
  
  public void forwardMsg(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, MessageForAniSticker paramMessageForAniSticker, BaseSessionInfo paramBaseSessionInfo)
  {
    paramBaseQQAppInterface = new Bundle();
    paramBaseQQAppInterface.putInt("forward_type", 48);
    String str = paramMessageForAniSticker.getSummaryMsg();
    int i = QQSysFaceUtil.convertToLocal(paramMessageForAniSticker.sevrId);
    paramBaseQQAppInterface.putString("forward_text", str);
    paramBaseQQAppInterface.putInt("forward_extra", i);
    paramBaseQQAppInterface.putInt("forward_source_uin_type", paramBaseSessionInfo.a);
    paramBaseQQAppInterface.putString("forward_source_uin", paramMessageForAniSticker.frienduin);
    paramMessageForAniSticker = new Intent();
    paramMessageForAniSticker.putExtras(paramBaseQQAppInterface);
    paramMessageForAniSticker.putExtra("direct_send_if_dataline_forward", true);
    ForwardBaseOption.a((Activity)paramContext, paramMessageForAniSticker, 21);
  }
  
  public boolean isSupportRevokeMsgByTroopOwnerOrMgr(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    return TroopUtils.a((QQAppInterface)paramBaseQQAppInterface, paramMessageRecord, paramString);
  }
  
  public void launchWriteTogether(MessageForAniSticker paramMessageForAniSticker, Context paramContext)
  {
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = ((BaseActivity)paramContext).getChatFragment().k();
      if (paramContext != null)
      {
        paramContext = (WriteTogetherHelper)paramContext.q(74);
        if (paramContext != null) {
          paramContext.b(QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(paramMessageForAniSticker.sevrId)), 3);
        }
      }
    }
  }
  
  public void openTextPreview(View paramView, BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, BaseSessionInfo paramBaseSessionInfo)
  {
    Object localObject = (BaseActivity)paramView.getContext();
    if (localObject != null) {
      localObject = ((BaseActivity)localObject).getChatFragment();
    } else {
      localObject = null;
    }
    if (localObject == null)
    {
      ChatActivityUtils.a((QQAppInterface)paramBaseQQAppInterface, paramView, paramActivity);
      return;
    }
    ChatActivityUtils.a((QQAppInterface)paramBaseQQAppInterface, paramView, paramActivity, paramBaseSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.AniStickerTempApiImpl
 * JD-Core Version:    0.7.0.1
 */