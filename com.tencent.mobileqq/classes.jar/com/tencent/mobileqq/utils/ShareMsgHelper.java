package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.FightReporter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ShareMsgHelper
  implements AppConstants
{
  public static Intent a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, Intent paramIntent, int paramInt3, String paramString19, long paramLong)
  {
    String str2 = paramString4;
    String str1 = paramString5;
    if (paramIntent == null)
    {
      paramIntent = new Intent();
      paramIntent.putExtra("key_flag_from_plugin", true);
      paramIntent.setClass(paramContext, ForwardRecentActivity.class);
    }
    paramIntent.putExtra("isFromShare", true);
    paramIntent.putExtra("forward_type", paramInt1);
    paramIntent.putExtra("pluginName", paramString1);
    paramIntent.putExtra("req_type", paramInt2);
    paramIntent.putExtra("detail_url", paramString7);
    paramIntent.putExtra("image_url_remote", paramString3);
    paramIntent.putExtra("source_url", paramString19);
    if (paramLong != -1L) {
      paramIntent.putExtra("req_share_id", paramLong);
    }
    paramIntent.putExtra("pubUin", paramString2);
    paramIntent.putExtra("struct_uin", paramString2);
    boolean bool = paramContext instanceof SwiftWebViewFragmentSupporter;
    if (bool)
    {
      paramString2 = ((SwiftWebViewFragmentSupporter)paramContext).getCurrentWebViewFragment();
      if (paramString2 != null)
      {
        paramIntent.putExtra("strurt_msgid", ((SwiftBrowserShareMenuHandler)paramString2.getComponentProvider().a(4)).b);
        paramIntent.putExtra("emoInputType", 1);
        paramIntent.putExtra("forward _key_nojump", true);
      }
    }
    if ((paramInt2 == 44) || (paramInt2 == 1) || (paramInt2 == 95)) {
      paramIntent.putExtra("forward _key_nojump", true);
    }
    paramString2 = str2;
    if (str2 != null)
    {
      paramString2 = str2;
      if (paramString4.length() > 45)
      {
        paramString2 = new StringBuilder();
        paramString2.append(str2.substring(0, 45));
        paramString2.append("…");
        paramString2 = paramString2.toString();
      }
    }
    paramIntent.putExtra("title", paramString2);
    paramString2 = str1;
    if (str1 != null)
    {
      paramString2 = str1;
      if (paramString5.length() > 60)
      {
        paramString2 = new StringBuilder();
        paramString2.append(str1.substring(0, 60));
        paramString2.append("…");
        paramString2 = paramString2.toString();
      }
    }
    paramIntent.putExtra("desc", paramString2);
    paramIntent.putExtra("forward_thumb", paramString18);
    paramIntent.putExtra("struct_share_key_content_action", paramString8);
    paramIntent.putExtra("struct_share_key_content_a_action_DATA", paramString10);
    paramIntent.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    paramIntent.putExtra("struct_share_key_content_action_DATA", paramString9);
    paramIntent.putExtra("req_share_id", -1L);
    paramIntent.putExtra("struct_share_key_source_action", paramString12);
    paramIntent.putExtra("struct_share_key_source_action_data", paramString13);
    paramIntent.putExtra("struct_share_key_source_a_action_data", paramString14);
    paramIntent.putExtra("struct_share_key_source_i_action_data", paramString15);
    paramIntent.putExtra("struct_share_key_source_icon", paramString16);
    paramIntent.putExtra("app_name", paramString17);
    paramIntent.putExtra("brief_key", paramString6);
    if ("struct_favorite".equals(paramString1))
    {
      paramIntent.putExtra("k_favorites", false);
      paramIntent.putExtra("forward _key_nojump", true);
    }
    paramString1 = StructMsgFactory.a(paramIntent.getExtras());
    if (paramString1 != null)
    {
      paramIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
      if ((paramInt3 >= 0) && ((paramContext instanceof Activity))) {
        return paramIntent;
      }
      if (((1001 == paramInt1) || (38 == paramInt1)) && (bool))
      {
        paramContext = ((SwiftWebViewFragmentSupporter)paramContext).getCurrentWebViewFragment();
        if (paramContext != null)
        {
          paramString1 = (SwiftBrowserShareMenuHandler)paramContext.getComponentProvider().a(4);
          paramIntent.putExtra("strurt_msgid", paramString1.b);
          paramIntent.putExtra("struct_uin", paramString1.a);
          paramIntent.putExtra("struct_url", paramContext.getUrl());
          paramIntent.putExtra("from_web", true);
          if ((paramString1.c != null) && (!"".equals(paramString1.c))) {
            paramIntent.putExtra("source_puin", paramString1.c);
          }
        }
      }
      return paramIntent;
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg)
  {
    String str = null;
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000)) {
      paramQQAppInterface = str;
    }
    try
    {
      str = paramQQAppInterface.getCurrentAccountUin();
      int i = MobileQQService.seq;
      MobileQQService.seq = i + 1;
      paramString = MessageRecordFactory.a(paramQQAppInterface, str, paramString, str, paramInt, i, paramAbsStructMsg);
      ForwardOrderManager.a().a(paramString.uniseq, 0L, paramAbsStructMsg.forwardID);
      paramQQAppInterface.getMessageFacade().a(paramString, 0);
      paramQQAppInterface = paramString;
      return paramQQAppInterface;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    if (paramAbsStructMsg != null) {
      FightReporter.a(paramAbsStructMsg);
    }
    ThreadManager.post(new ShareMsgHelper.1(paramQQAppInterface, paramString, paramInt, paramAbsStructMsg, paramBusinessObserver), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver, String paramString2, String paramString3)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 1000) && (paramInt != 1001) && (paramInt != 1004) && (paramInt != 1006) && (paramInt != 1010) && (paramInt != 1024) && (paramInt != 3000) && (paramInt != 10002) && (paramInt != 10004) && (paramInt != 10008) && (paramInt != 10010)) {
      return;
    }
    Object localObject = paramQQAppInterface.getCurrentAccountUin();
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l = i;
    if (TextUtils.isEmpty(paramString1)) {
      paramBusinessObserver = (BusinessObserver)localObject;
    } else {
      paramBusinessObserver = paramString1;
    }
    paramAbsStructMsg = MessageRecordFactory.a(paramQQAppInterface, (String)localObject, paramString1, paramBusinessObserver, paramInt, l, paramAbsStructMsg);
    paramBusinessObserver = TeamWorkConstants.i;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendDocsStructingMsg. disUin = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", disUinType = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", seq = ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(", shmsgseq = ");
    ((StringBuilder)localObject).append(paramAbsStructMsg.shmsgseq);
    ((StringBuilder)localObject).append(", time = ");
    ((StringBuilder)localObject).append(paramAbsStructMsg.time);
    QLog.i(paramBusinessObserver, 1, ((StringBuilder)localObject).toString());
    paramQQAppInterface.getMessageFacade().a(paramAbsStructMsg, null);
    if ((paramInt == 0) || (paramInt == 1)) {
      ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).addTeamWorkGrayTips(paramQQAppInterface, paramString1, paramInt, paramAbsStructMsg.shmsgseq, paramAbsStructMsg.time + 1L, paramString2, paramString3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    if (paramAbsStructMsg != null) {
      FightReporter.a(paramAbsStructMsg);
    }
    ThreadManager.getSubThreadHandler().post(new ShareMsgHelper.2(paramQQAppInterface, paramString1, paramString2, paramInt, paramAbsStructMsg, paramBusinessObserver));
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, Intent paramIntent, int paramInt3)
  {
    return a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, "", paramIntent, paramInt3, null, -1L);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18)
  {
    return a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, "", null, -1, paramString18, -1L);
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, Intent paramIntent, int paramInt3, String paramString19, long paramLong)
  {
    paramString1 = a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramString17, paramString18, paramIntent, paramInt3, paramString19, paramLong);
    if (paramString1 != null)
    {
      if ((paramInt3 >= 0) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).startActivityForResult(paramString1, paramInt3);
      } else {
        paramContext.startActivity(paramString1);
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, boolean paramBoolean)
  {
    String str = paramString4;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("k_back", false);
    localIntent.setClass(paramContext, ForwardRecentActivity.class);
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", paramInt1);
    localIntent.putExtra("pluginName", paramString1);
    localIntent.putExtra("req_type", paramInt2);
    localIntent.putExtra("detail_url", paramString7);
    localIntent.putExtra("image_url_remote", paramString3);
    localIntent.putExtra("source_url", paramString18);
    localIntent.putExtra("pubUin", paramString2);
    localIntent.putExtra("struct_uin", paramString2);
    paramString1 = str;
    if (str != null)
    {
      paramString1 = str;
      if (paramString4.length() > 45)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString4.substring(0, 45));
        paramString1.append("…");
        paramString1 = paramString1.toString();
      }
    }
    localIntent.putExtra("title", paramString1);
    if ((paramString5 != null) && (paramString5.length() > 60))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString5.substring(0, 60));
      paramString1.append("…");
      paramString5 = paramString1.toString();
    }
    localIntent.putExtra("desc", paramString5);
    localIntent.putExtra("forward_thumb", "");
    localIntent.putExtra("struct_share_key_content_action", paramString8);
    localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString10);
    localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString11);
    localIntent.putExtra("struct_share_key_content_action_DATA", paramString9);
    localIntent.putExtra("req_share_id", -1L);
    localIntent.putExtra("struct_share_key_source_action", paramString12);
    localIntent.putExtra("struct_share_key_source_action_data", paramString13);
    localIntent.putExtra("struct_share_key_source_a_action_data", paramString14);
    localIntent.putExtra("struct_share_key_source_i_action_data", paramString15);
    localIntent.putExtra("struct_share_key_source_icon", paramString16);
    localIntent.putExtra("app_name", paramString17);
    localIntent.putExtra("brief_key", paramString6);
    localIntent.putExtra("compatible_text", paramString19);
    localIntent.putExtra("flag", 2);
    if (paramBoolean) {
      localIntent.putExtra("icon_need_round", "1");
    }
    localIntent.putExtra("emoInputType", 2);
    paramString1 = StructMsgFactory.a(localIntent.getExtras());
    if (paramString1 != null)
    {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
      paramContext.startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 1000) && (paramInt != 1001) && (paramInt != 1010) && (paramInt != 1024) && (paramInt != 3000) && (paramInt != 10002) && (paramInt != 10004) && (paramInt != 10008) && (paramInt != 10010)) {}
    int i;
    switch (paramInt)
    {
    default: 
    case 1005: 
      if (paramAbsStructMsg == null) {
        return;
      }
      if (paramAbsStructMsg.mMsgServiceID == 1)
      {
        paramString2 = paramQQAppInterface.getCurrentAccountUin();
        i = MobileQQService.seq;
        MobileQQService.seq = i + 1;
        paramString1 = MessageRecordFactory.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, i, paramAbsStructMsg);
        paramQQAppInterface.getMessageFacade().a(paramString1, null);
        return;
      }
      if (paramAbsStructMsg.mMsgServiceID == 41)
      {
        paramString2 = paramQQAppInterface.getCurrentAccountUin();
        i = MobileQQService.seq;
        MobileQQService.seq = i + 1;
        paramString1 = MessageRecordFactory.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, i, paramAbsStructMsg);
        paramQQAppInterface.getMessageFacade().b(paramString1, null);
        return;
      }
      break;
    case 1004: 
    case 1006: 
      paramBusinessObserver = paramQQAppInterface.getCurrentAccountUin();
      i = MobileQQService.seq;
      MobileQQService.seq = i + 1;
      long l = i;
      i = paramAbsStructMsg.forwardID;
      if (paramAbsStructMsg.mMsgServiceID == 80)
      {
        if (TextUtils.isEmpty(paramString2)) {
          paramString2 = paramBusinessObserver;
        }
        paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
      }
      for (;;)
      {
        break;
        if (paramAbsStructMsg.mMsgServiceID == 118)
        {
          if (TextUtils.isEmpty(paramString2)) {
            paramString2 = paramBusinessObserver;
          }
          paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
        }
        else
        {
          if (TextUtils.isEmpty(paramString2)) {
            paramString2 = paramBusinessObserver;
          }
          paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
        }
      }
      if (paramAbsStructMsg.mMsgServiceID == 41)
      {
        ForwardOrderManager.a().a(paramString2.uniseq, paramAbsStructMsg.parentUniseq, i);
        paramQQAppInterface.getMessageFacade().b(paramString2, null);
        return;
      }
      if (paramAbsStructMsg.mMsgServiceID == 100)
      {
        paramAbsStructMsg.mMsgServiceID = 1;
        paramString1 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramBusinessObserver, paramInt, l, paramAbsStructMsg);
        ForwardOrderManager.a().a(paramString1.uniseq, paramAbsStructMsg.parentUniseq, i);
        paramQQAppInterface.getMessageFacade().a(paramString1, new ShareMsgHelper.3());
        return;
      }
      ForwardOrderManager.a().a(paramString2.uniseq, paramAbsStructMsg.parentUniseq, i);
      paramQQAppInterface.getMessageFacade().a(paramString2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareMsgHelper
 * JD-Core Version:    0.7.0.1
 */