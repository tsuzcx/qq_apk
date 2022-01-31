package com.tencent.mobileqq.structmsg;

import aimc;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import tencent.im.babyq.babyq_cookie.BabyQCookie;

public class StructMsgClickHandler
  implements StructMsgOnClickListener
{
  private static ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public Context a;
  public QQAppInterface a;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  
  public StructMsgClickHandler(QQAppInterface paramQQAppInterface, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    if ((paramQQAppInterface == null) && (FragmentActivity.class.isInstance(this.jdField_a_of_type_AndroidContentContext)))
    {
      paramQQAppInterface = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (paramQQAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface.a().a();
      }
    }
  }
  
  public StructMsgClickHandler(QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord)
  {
    this(paramQQAppInterface, paramView);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  private static void a(Context paramContext, String paramString)
  {
    if ((jdField_a_of_type_ComTencentWidgetActionSheet == null) || (!jdField_a_of_type_ComTencentWidgetActionSheet.getContext().equals(paramContext)))
    {
      jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(paramContext);
      jdField_a_of_type_ComTencentWidgetActionSheet.a(2131435108, 1);
      jdField_a_of_type_ComTencentWidgetActionSheet.a(2131435109, 1);
      jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433029);
      jdField_a_of_type_ComTencentWidgetActionSheet.a(String.format(paramContext.getString(2131435129), new Object[] { paramString }));
      jdField_a_of_type_ComTencentWidgetActionSheet.a(new aimc(paramString, paramContext));
    }
    if (!jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
                  ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
                  ((Intent)localObject).putExtra("url", paramString);
                  ((Intent)localObject).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
                  ((Intent)localObject).putExtra("articalChannelId", 1);
                  PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (Intent)localObject, paramString);
                  this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
                  bool1 = bool2;
                } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null);
                bool1 = bool2;
              } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend());
              bool1 = bool2;
            } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 0);
            bool1 = bool2;
          } while (!Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin));
          bool1 = bool2;
        } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie")));
        paramString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
        bool1 = bool2;
      } while (paramString == null);
      Object localObject = new babyq_cookie.BabyQCookie();
      try
      {
        ((babyq_cookie.BabyQCookie)localObject).mergeFrom(paramString);
        switch (((babyq_cookie.BabyQCookie)localObject).uint32_type.get())
        {
        case 204: 
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("babyq_game_strategy");
          return true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        bool1 = bool2;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "babbyq -> sendSpecialMessage:" + paramString.getStackTrace());
    return true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("babyq_game_gift");
    return true;
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localChatFragment != null)
      {
        int i = localChatFragment.a().b();
        if (i == 1008)
        {
          localIntent.putExtra("puin", localChatFragment.a().a());
          localIntent.putExtra("uin_type", i);
          localIntent.putExtra("msg_id", String.valueOf(paramLong));
          localIntent.putExtra("switch_msg_btn", PublicAccountUtil.a());
          localIntent.putExtra("articalChannelId", 1);
          localIntent.putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
        }
      }
    }
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      localObject = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if (((FragmentActivity)localObject).getChatFragment() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
      paramString1 = paramString2;
    }
    int i = ((FragmentActivity)localObject).getChatFragment().a().b();
    paramString2 = ((FragmentActivity)localObject).getChatFragment().a().b();
    Object localObject = ((FragmentActivity)localObject).getChatFragment().a().a();
    Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), null);
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("forward_type", -1);
    localIntent.putExtra("forward_text", paramString1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString2 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if (paramString2.getChatFragment() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
      paramString1 = paramString2;
    }
    paramString2 = paramString2.getChatFragment().a().a();
    PublicAccountManager.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, null, paramInt, paramLong, 2);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        int i = paramString2.indexOf("://");
        Object localObject = "";
        if (i == -1)
        {
          paramString3 = paramString2;
          paramString2 = (String)localObject;
          label39:
          localObject = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
        }
        try
        {
          if (((PackageManager)localObject).getPackageInfo(paramString3, 1) != null)
          {
            localObject = ((PackageManager)localObject).getLaunchIntentForPackage(paramString3);
            if (localObject != null)
            {
              if (!TextUtils.isEmpty(paramString2)) {
                ((Intent)localObject).setData(Uri.parse(paramString2));
              }
              StartAppCheckHandler.a("structmsg", "", paramString3, "1", "structmsgClick", this.jdField_a_of_type_AndroidContentContext.getClass().getName());
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
              return true;
              paramString2 = paramString3;
              continue;
              paramString3 = paramString2.substring(0, i);
              paramString2 = paramString2.substring(i + 3);
              break label39;
            }
            return false;
          }
        }
        catch (Exception paramString2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramString2.getMessage());
          }
        }
      }
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramString2.putExtra("key_isReadModeEnabled", true);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("fromAio", true);
      PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramString2, paramString1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramString4, 0L);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructMsgClickHandler doAction action = " + paramString1 + ", url = " + paramString2 + ", actionData = " + paramString3 + ", actionDataA = " + paramString4);
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localChatFragment != null)
      {
        String str = localChatFragment.a().a();
        int i = localChatFragment.a().b();
        if ((paramString1 != null) && (!paramString1.equals("")) && (i == 1008)) {
          PublicAccountManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        }
      }
    }
    if ("web".equals(paramString1))
    {
      if (paramLong > 0L) {}
      for (boolean bool1 = a(paramString2, paramLong);; bool1 = a(paramString2))
      {
        boolean bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramLong > 0L) {
            bool2 = a(paramString2, null, 2, paramLong);
          }
        }
        return bool2;
      }
    }
    if ("app".equals(paramString1)) {
      return a(paramString2, paramString3, paramString4);
    }
    if ("plugin".equals(paramString1))
    {
      if ((TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString2))) {
        return c(paramString2, null);
      }
      return c(paramString3, paramString4);
    }
    if ("auto".equals(paramString1)) {
      return b(paramString2);
    }
    if ("replyMsg".equals(paramString1)) {
      return a(paramString3, paramString4);
    }
    if ("replyCmd".equals(paramString1))
    {
      if (paramLong == 0L) {
        return b(paramString3, paramString4);
      }
      return a(paramString3, null, 1, paramLong);
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (paramString.startsWith("tel:"))
    {
      paramString = paramString.substring("tel:".length());
      a(this.jdField_a_of_type_AndroidContentContext, paramString);
    }
    for (;;)
    {
      return true;
      try
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("com.android.browser.application_id", this.jdField_a_of_type_AndroidContentContext.getPackageName());
        this.jdField_a_of_type_AndroidContentContext.startActivity(paramString);
      }
      catch (Exception paramString) {}
      if (QLog.isColorLevel()) {
        QLog.d("HyperTextMsg", 2, paramString.getMessage());
      }
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      paramString2 = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
      if (paramString2.getChatFragment() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
      paramString1 = paramString2;
    }
    paramString2 = paramString2.getChatFragment().a().a();
    PublicAccountManager.a().a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, null, 1, 0L, 2);
    return true;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructMsgClickHandler clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.equals(paramString1, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent")) {
        break label66;
      }
    }
    label66:
    do
    {
      for (;;)
      {
        return true;
        paramString1 = paramString2;
        break;
        try
        {
          paramString1 = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
          if (paramString1 != null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              paramString1.a("msg_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq));
            }
            paramString1.b();
            if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 0) && (Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
            {
              paramString1 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
              if (paramString1 != null)
              {
                paramString2 = new babyq_cookie.BabyQCookie();
                paramString2.mergeFrom(paramString1);
                if (paramString2.uint32_type.get() == 207)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b("baqyq_mayknow_people");
                  return true;
                }
              }
            }
          }
        }
        catch (Exception paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, paramString1.getMessage(), paramString1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgClickHandler
 * JD-Core Version:    0.7.0.1
 */