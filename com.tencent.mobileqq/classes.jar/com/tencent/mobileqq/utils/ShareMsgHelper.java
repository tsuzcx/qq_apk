package com.tencent.mobileqq.utils;

import ajrx;
import ajry;
import ajrz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class ShareMsgHelper
  implements AppConstants
{
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg)
  {
    String str = null;
    switch (paramInt)
    {
    default: 
      paramQQAppInterface = str;
    }
    for (;;)
    {
      return paramQQAppInterface;
      try
      {
        str = paramQQAppInterface.getCurrentAccountUin();
        int i = MobileQQService.a;
        MobileQQService.a = i + 1;
        paramString = MessageRecordFactory.a(paramQQAppInterface, str, paramString, str, paramInt, i, paramAbsStructMsg);
        paramQQAppInterface.a().a(paramString, 0);
        paramQQAppInterface = paramString;
      }
      finally {}
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    ThreadManager.post(new ajrx(paramQQAppInterface, paramString, paramInt, paramAbsStructMsg, paramBusinessObserver), 8, null, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, AbsStructMsg paramAbsStructMsg, BusinessObserver paramBusinessObserver)
  {
    ThreadManager.post(new ajry(paramQQAppInterface, paramString1, paramString2, paramInt, paramAbsStructMsg, paramBusinessObserver), 8, null, false);
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
    Intent localIntent = paramIntent;
    if (paramIntent == null)
    {
      localIntent = new Intent();
      localIntent.putExtra("key_flag_from_plugin", true);
      localIntent.setClass(paramContext, ForwardRecentActivity.class);
    }
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtra("forward_type", paramInt1);
    localIntent.putExtra("pluginName", paramString1);
    localIntent.putExtra("req_type", paramInt2);
    localIntent.putExtra("detail_url", paramString7);
    localIntent.putExtra("image_url_remote", paramString3);
    localIntent.putExtra("source_url", paramString19);
    if (paramLong != -1L) {
      localIntent.putExtra("req_share_id", paramLong);
    }
    localIntent.putExtra("pubUin", paramString2);
    localIntent.putExtra("struct_uin", paramString2);
    if ((paramContext instanceof SwiftWebViewFragmentSupporter))
    {
      paramString2 = ((SwiftWebViewFragmentSupporter)paramContext).b();
      if (paramString2 != null)
      {
        localIntent.putExtra("strurt_msgid", paramString2.j);
        localIntent.putExtra("emoInputType", 1);
        localIntent.putExtra("forward _key_nojump", true);
      }
    }
    if (paramInt2 == 44) {
      localIntent.putExtra("forward _key_nojump", true);
    }
    paramString2 = paramString4;
    if (paramString4 != null)
    {
      paramString2 = paramString4;
      if (paramString4.length() > 45) {
        paramString2 = paramString4.substring(0, 45) + "…";
      }
    }
    localIntent.putExtra("title", paramString2);
    paramString2 = paramString5;
    if (paramString5 != null)
    {
      paramString2 = paramString5;
      if (paramString5.length() > 60) {
        paramString2 = paramString5.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("desc", paramString2);
    localIntent.putExtra("forward_thumb", paramString18);
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
    if ("struct_favorite".equals(paramString1))
    {
      localIntent.putExtra("k_favorites", false);
      localIntent.putExtra("forward _key_nojump", true);
    }
    paramString1 = StructMsgFactory.a(localIntent.getExtras());
    if (paramString1 != null)
    {
      localIntent.putExtra("stuctmsg_bytes", paramString1.getBytes());
      if ((paramInt3 >= 0) && ((paramContext instanceof Activity))) {
        ((Activity)paramContext).startActivityForResult(localIntent, paramInt3);
      }
      for (;;)
      {
        return true;
        if ((1001 == paramInt1) && ((paramContext instanceof SwiftWebViewFragmentSupporter)))
        {
          paramString1 = ((SwiftWebViewFragmentSupporter)paramContext).b();
          if (paramString1 != null)
          {
            localIntent.putExtra("strurt_msgid", paramString1.j);
            localIntent.putExtra("struct_uin", paramString1.i);
            localIntent.putExtra("struct_url", paramString1.g);
            localIntent.putExtra("from_web", true);
            if ((paramString1.k != null) && (!"".equals(paramString1.k))) {
              localIntent.putExtra("source_puin", paramString1.k);
            }
          }
        }
        paramContext.startActivity(localIntent);
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, boolean paramBoolean)
  {
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
    paramString1 = paramString4;
    if (paramString4 != null)
    {
      paramString1 = paramString4;
      if (paramString4.length() > 45) {
        paramString1 = paramString4.substring(0, 45) + "…";
      }
    }
    localIntent.putExtra("title", paramString1);
    paramString1 = paramString5;
    if (paramString5 != null)
    {
      paramString1 = paramString5;
      if (paramString5.length() > 60) {
        paramString1 = paramString5.substring(0, 60) + "…";
      }
    }
    localIntent.putExtra("desc", paramString1);
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
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramBusinessObserver = paramQQAppInterface.getCurrentAccountUin();
        i = MobileQQService.a;
        MobileQQService.a = i + 1;
        long l = i;
        if (paramAbsStructMsg.mMsgServiceID == 80)
        {
          if (TextUtils.isEmpty(paramString2)) {
            paramString2 = paramBusinessObserver;
          }
          for (;;)
          {
            paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
            if (paramAbsStructMsg.mMsgServiceID != 41) {
              break;
            }
            paramQQAppInterface.a().b(paramString2, null);
            return;
          }
        }
        if (paramAbsStructMsg.mMsgServiceID == 118)
        {
          if (TextUtils.isEmpty(paramString2)) {
            paramString2 = paramBusinessObserver;
          }
          for (;;)
          {
            paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
            break;
          }
        }
        if (TextUtils.isEmpty(paramString2)) {
          paramString2 = paramBusinessObserver;
        }
        for (;;)
        {
          paramString2 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramString2, paramInt, l, paramAbsStructMsg);
          break;
        }
        if (paramAbsStructMsg.mMsgServiceID == 100)
        {
          paramAbsStructMsg.mMsgServiceID = 1;
          paramString1 = MessageRecordFactory.a(paramQQAppInterface, paramBusinessObserver, paramString1, paramBusinessObserver, paramInt, l, paramAbsStructMsg);
          paramQQAppInterface.a().a(paramString1, new ajrz());
          return;
        }
        paramQQAppInterface.a().a(paramString2, null);
        return;
      } while (paramAbsStructMsg == null);
      if (paramAbsStructMsg.mMsgServiceID == 1)
      {
        paramString2 = paramQQAppInterface.getCurrentAccountUin();
        i = MobileQQService.a;
        MobileQQService.a = i + 1;
        paramString1 = MessageRecordFactory.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, i, paramAbsStructMsg);
        paramQQAppInterface.a().a(paramString1, null);
        return;
      }
    } while (paramAbsStructMsg.mMsgServiceID != 41);
    paramString2 = paramQQAppInterface.getCurrentAccountUin();
    int i = MobileQQService.a;
    MobileQQService.a = i + 1;
    paramString1 = MessageRecordFactory.a(paramQQAppInterface, paramString2, paramString1, paramString2, paramInt, i, paramAbsStructMsg);
    paramQQAppInterface.a().b(paramString1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareMsgHelper
 * JD-Core Version:    0.7.0.1
 */