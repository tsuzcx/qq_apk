package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import org.json.JSONObject;
import tencent.im.babyq.babyq_cookie.BabyQCookie;

public class StructMsgClickHandler
  implements StructMsgOnClickListener
{
  private static ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
      jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(paramContext);
      jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131691678, 1);
      jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131691372, 1);
      jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(String.format(paramContext.getString(2131694584), new Object[] { paramString }));
      jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new StructMsgClickHandler.1(paramString, paramContext));
    }
    if (!jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
    ((Intent)localObject).putExtra("articalChannelId", 1);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (Intent)localObject, paramString);
    if (((Intent)localObject).getComponent() != null)
    {
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 0) && (Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
      {
        paramString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
        if (paramString != null) {
          localObject = new babyq_cookie.BabyQCookie();
        }
      }
    }
    for (;;)
    {
      try
      {
        ((babyq_cookie.BabyQCookie)localObject).mergeFrom(paramString);
        int i = ((babyq_cookie.BabyQCookie)localObject).uint32_type.get();
        switch (i)
        {
        }
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("StructMsg", 2, "babbyq -> sendSpecialMessage:" + paramString.getStackTrace());
        continue;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b("babyq_game_gift");
        continue;
      }
      return true;
      paramString = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/pubaccount/browser");
      paramString.extra().putAll(((Intent)localObject).getExtras());
      QRoute.startUri(paramString, null);
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b("babyq_game_strategy");
    }
  }
  
  public boolean a(String paramString, long paramLong, Object... paramVarArgs)
  {
    if (MiniAppLauncher.isMiniAppScheme(paramString))
    {
      MiniAppLauncher.launchMiniAppByScheme(this.jdField_a_of_type_AndroidContentContext, paramString, 1211);
      return true;
    }
    Object localObject = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if (((IMiniAppService)localObject).isMiniAppUrl(paramString))
    {
      ((IMiniAppService)localObject).startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramString, 1043, null);
      return true;
    }
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("url", paramString);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        int i = ((ChatFragment)localObject).a().b();
        if (i == 1008)
        {
          String str = ((ChatFragment)localObject).a().b();
          localIntent.putExtra("puin", str);
          localIntent.putExtra("uin_type", i);
          localIntent.putExtra("msg_id", String.valueOf(paramLong));
          localIntent.putExtra("switch_msg_btn", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).shouldUseWebviewSwitchFunction());
          localIntent.putExtra("articalChannelId", 1);
          localIntent.putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
          localIntent.putExtra("fromOneCLickCLose", true);
          localObject = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(str);
          if ((!EcshopAdHandler.a(str)) || (paramVarArgs == null) || (paramVarArgs.length <= 0) || (!(paramVarArgs[0] instanceof Boolean)) || (!((Boolean)paramVarArgs[0]).booleanValue())) {
            break label403;
          }
        }
      }
    }
    label403:
    for (paramVarArgs = "biz_src_ads";; paramVarArgs = (Object[])localObject)
    {
      localIntent.putExtra("big_brother_source_key", paramVarArgs);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localIntent, paramString);
      if (localIntent.getComponent() != null) {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      for (;;)
      {
        return true;
        paramString = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/pubaccount/browser");
        paramString.extra().putAll(localIntent.getExtras());
        QRoute.startUri(paramString, null);
      }
    }
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
    paramString2 = ((FragmentActivity)localObject).getChatFragment().a().c();
    Object localObject = ((FragmentActivity)localObject).getChatFragment().a().b();
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
    paramString2 = paramString2.getChatFragment().a().b();
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).sendMenuEventequest(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, null, paramInt, paramLong, 2);
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
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramString2, paramString1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramString4, 0L, new Object[0]);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject1;
    MessageForStructing localMessageForStructing;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("StructMsgClickHandler doAction action = ").append(paramString1).append(", url = ").append(paramString2).append(", actionData = ").append(paramString3).append(", actionDataA = ").append(paramString4);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject1 = ", args = " + paramVarArgs[0];
        QLog.d("StructMsg", 2, (String)localObject1);
      }
    }
    else
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
      {
        localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject1 != null)
        {
          localObject2 = ((ChatFragment)localObject1).a().b();
          int i = ((ChatFragment)localObject1).a().b();
          if ((paramString1 != null) && (!paramString1.equals("")) && (i == 1008)) {
            ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).addPublicAccountToRu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
          }
          if (((((ChatFragment)localObject1).a() instanceof PublicAccountChatPie)) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing)))
          {
            localMessageForStructing = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
            localObject1 = "";
            if (localMessageForStructing.mExJsonObject != null) {
              localObject1 = localMessageForStructing.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
            }
            if (!(localMessageForStructing.structingMsg instanceof StructMsgForHypertext)) {
              break label350;
            }
            PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, 0, 2, paramLong, (String)localObject1);
          }
        }
      }
      label280:
      if (!"web".equals(paramString1)) {
        break label429;
      }
      if (paramLong <= 0L) {
        break label419;
      }
    }
    label419:
    for (boolean bool1 = a(paramString2, paramLong, paramVarArgs);; bool1 = a(paramString2))
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
      localObject1 = "";
      break;
      label350:
      if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
        break label280;
      }
      if ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare))
      {
        PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, 0, 1, paramLong, (String)localObject1);
        break label280;
      }
      if (!(localMessageForStructing.structingMsg instanceof StructMsgForAudioShare)) {
        break label280;
      }
      PublicAccountEventReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2, 0, 5, paramLong, (String)localObject1);
      break label280;
    }
    label429:
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
    paramString2 = paramString2.getChatFragment().a().b();
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).sendMenuEventequest(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1, false, 0.0D, 0.0D, null, 1, 0L, 2);
    return true;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructMsgClickHandler clickPluginMsg  actionData = " + paramString1 + ", actionDataA = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.equals(paramString1, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent")) {
        break label67;
      }
    }
    label67:
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
            paramString1.a();
            if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 0) && (Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"))))
            {
              paramString1 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("guide_msg_cookie"));
              if (paramString1 != null)
              {
                paramString2 = new babyq_cookie.BabyQCookie();
                paramString2.mergeFrom(paramString1);
                if (paramString2.uint32_type.get() == 207)
                {
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b("baqyq_mayknow_people");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgClickHandler
 * JD-Core Version:    0.7.0.1
 */