package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;

public class TroopBusinessUtil
{
  public static final String a = "com.tencent.mobileqq.troop.utils.TroopBusinessUtil";
  
  public static TroopBusinessUtil.TroopBusinessMessage a(MessageRecord paramMessageRecord)
  {
    TroopBusinessUtil.TroopBusinessMessage localTroopBusinessMessage;
    if ((paramMessageRecord != null) && ("1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_msg_has"))))
    {
      localTroopBusinessMessage = new TroopBusinessUtil.TroopBusinessMessage();
      localTroopBusinessMessage.a = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_flag"));
      localTroopBusinessMessage.b = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_url");
      localTroopBusinessMessage.c = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_click_url");
      localTroopBusinessMessage.d = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
      localTroopBusinessMessage.f = paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_name");
      try
      {
        localTroopBusinessMessage.e = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_nick_color"));
        localTroopBusinessMessage.g = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_color"));
        localTroopBusinessMessage.h = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_bg_color"));
      }
      catch (Exception localException)
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("the color string cannot parse to int. ");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
    else
    {
      localTroopBusinessMessage = null;
    }
    if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend")))) {
      TianShuManager.getInstance().cacheTraceInfo(paramMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend"));
    }
    return localTroopBusinessMessage;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, TroopBusinessUtil.TroopBusinessMessage paramTroopBusinessMessage)
  {
    try
    {
      if (!TextUtils.isEmpty(paramTroopBusinessMessage.c))
      {
        if (paramTroopBusinessMessage.c.startsWith("http"))
        {
          paramAppInterface = new Intent(paramContext, QQBrowserActivity.class);
          paramAppInterface.putExtra("url", paramTroopBusinessMessage.c);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramAppInterface, paramTroopBusinessMessage.c);
          paramContext.startActivity(paramAppInterface);
          return;
        }
        if (paramTroopBusinessMessage.c.startsWith("mqqapi"))
        {
          if ((paramAppInterface instanceof QQAppInterface))
          {
            JumpParser.a((QQAppInterface)paramAppInterface, paramContext, paramTroopBusinessMessage.c).a();
            return;
          }
          paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramTroopBusinessMessage.c)));
          return;
        }
      }
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, TroopBusinessUtil.TroopBusinessMessage paramTroopBusinessMessage)
  {
    if (paramTroopBusinessMessage != null)
    {
      if (paramMessageRecord == null) {
        return;
      }
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_has", "1");
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_flag", String.valueOf(paramTroopBusinessMessage.a));
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_url", paramTroopBusinessMessage.b);
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_click_url", paramTroopBusinessMessage.c);
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", paramTroopBusinessMessage.d);
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(paramTroopBusinessMessage.e));
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_name", paramTroopBusinessMessage.f);
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_color", String.valueOf(paramTroopBusinessMessage.g));
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_bg_color", String.valueOf(paramTroopBusinessMessage.h));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBusinessUtil
 * JD-Core Version:    0.7.0.1
 */