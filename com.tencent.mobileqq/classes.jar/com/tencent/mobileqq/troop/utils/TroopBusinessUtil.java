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
      localTroopBusinessMessage.jdField_a_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_flag"));
      localTroopBusinessMessage.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_url");
      localTroopBusinessMessage.jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_click_url");
      localTroopBusinessMessage.jdField_c_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
      localTroopBusinessMessage.jdField_d_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_name");
      try
      {
        localTroopBusinessMessage.jdField_b_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_nick_color"));
        localTroopBusinessMessage.jdField_c_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_color"));
        localTroopBusinessMessage.jdField_d_of_type_Int = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_bg_color"));
      }
      catch (Exception localException)
      {
        String str = jdField_a_of_type_JavaLangString;
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
      if (!TextUtils.isEmpty(paramTroopBusinessMessage.jdField_b_of_type_JavaLangString))
      {
        if (paramTroopBusinessMessage.jdField_b_of_type_JavaLangString.startsWith("http"))
        {
          paramAppInterface = new Intent(paramContext, QQBrowserActivity.class);
          paramAppInterface.putExtra("url", paramTroopBusinessMessage.jdField_b_of_type_JavaLangString);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramAppInterface, paramTroopBusinessMessage.jdField_b_of_type_JavaLangString);
          paramContext.startActivity(paramAppInterface);
          return;
        }
        if (paramTroopBusinessMessage.jdField_b_of_type_JavaLangString.startsWith("mqqapi"))
        {
          if ((paramAppInterface instanceof QQAppInterface))
          {
            JumpParser.a((QQAppInterface)paramAppInterface, paramContext, paramTroopBusinessMessage.jdField_b_of_type_JavaLangString).a();
            return;
          }
          paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(paramTroopBusinessMessage.jdField_b_of_type_JavaLangString)));
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
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_flag", String.valueOf(paramTroopBusinessMessage.jdField_a_of_type_Int));
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_url", paramTroopBusinessMessage.jdField_a_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_click_url", paramTroopBusinessMessage.jdField_b_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", paramTroopBusinessMessage.jdField_c_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(paramTroopBusinessMessage.jdField_b_of_type_Int));
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_name", paramTroopBusinessMessage.jdField_d_of_type_JavaLangString);
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_color", String.valueOf(paramTroopBusinessMessage.jdField_c_of_type_Int));
      paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_bg_color", String.valueOf(paramTroopBusinessMessage.jdField_d_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBusinessUtil
 * JD-Core Version:    0.7.0.1
 */