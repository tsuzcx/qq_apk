package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.utils.EcshopFromUtils;
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
  private static ActionSheet a;
  QQAppInterface b;
  Context c;
  private MessageRecord d;
  
  public StructMsgClickHandler(QQAppInterface paramQQAppInterface, View paramView)
  {
    this.b = paramQQAppInterface;
    this.c = paramView.getContext();
    if ((paramQQAppInterface == null) && (BaseActivity.class.isInstance(this.c)))
    {
      paramQQAppInterface = ((BaseActivity)this.c).getChatFragment();
      if (paramQQAppInterface != null) {
        this.b = paramQQAppInterface.k().i();
      }
    }
  }
  
  public StructMsgClickHandler(QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord)
  {
    this(paramQQAppInterface, paramView);
    this.d = paramMessageRecord;
  }
  
  private static void a(Context paramContext, String paramString)
  {
    ActionSheet localActionSheet = a;
    if ((localActionSheet == null) || (!localActionSheet.getContext().equals(paramContext)))
    {
      a = ActionSheet.create(paramContext);
      a.addButton(2131888562, 1);
      a.addButton(2131888244, 1);
      a.addCancelButton(2131887648);
      a.setMainTitle(String.format(paramContext.getString(2131892236), new Object[] { paramString }));
      a.setOnButtonClickListener(new StructMsgClickHandler.1(paramString, paramContext));
    }
    if (!a.isShowing()) {
      a.show();
    }
  }
  
  public boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject).putExtra("url", paramString);
      ((Intent)localObject).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
      ((Intent)localObject).putExtra("articalChannelId", 1);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.d, (Intent)localObject, paramString);
      if (((Intent)localObject).getComponent() != null)
      {
        this.c.startActivity((Intent)localObject);
      }
      else
      {
        paramString = new ActivityURIRequest(this.c, "/pubaccount/browser");
        paramString.extra().putAll(((Intent)localObject).getExtras());
        QRoute.startUri(paramString, null);
      }
      paramString = this.d;
      if ((paramString != null) && (!paramString.isSend()) && (this.d.istroop == 0) && (Utils.c(this.d.frienduin)) && (!TextUtils.isEmpty(this.d.getExtInfoFromExtStr("guide_msg_cookie"))))
      {
        paramString = Utils.h(this.d.getExtInfoFromExtStr("guide_msg_cookie"));
        if (paramString != null)
        {
          localObject = new babyq_cookie.BabyQCookie();
          try
          {
            ((babyq_cookie.BabyQCookie)localObject).mergeFrom(paramString);
            int i = ((babyq_cookie.BabyQCookie)localObject).uint32_type.get();
            if (i != 204)
            {
              if (i != 205) {
                return true;
              }
              this.b.getMessageFacade().d("babyq_game_gift");
              return true;
            }
            this.b.getMessageFacade().d("babyq_game_strategy");
            return true;
          }
          catch (InvalidProtocolBufferMicroException paramString)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("babbyq -> sendSpecialMessage:");
              ((StringBuilder)localObject).append(paramString.getStackTrace());
              QLog.d("StructMsg", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong, Object... paramVarArgs)
  {
    if (MiniAppLauncher.isMiniAppScheme(paramString))
    {
      MiniAppLauncher.launchMiniAppByScheme(this.c, paramString, 1211);
      return true;
    }
    Object localObject = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if (((IMiniAppService)localObject).isMiniAppUrl(paramString))
    {
      ((IMiniAppService)localObject).startMiniApp(this.c, paramString, 1043, null);
      return true;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
        return false;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", paramString);
      localObject = this.c;
      if ((localObject instanceof BaseActivity))
      {
        localObject = ((BaseActivity)localObject).getChatFragment();
        if (localObject != null)
        {
          int i = ((ChatFragment)localObject).k().F();
          if (i == 1008)
          {
            String str2 = ((ChatFragment)localObject).k().ae();
            localIntent.putExtra("puin", str2);
            localIntent.putExtra("uin_type", i);
            localIntent.putExtra("msg_id", String.valueOf(paramLong));
            localIntent.putExtra("switch_msg_btn", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).shouldUseWebviewSwitchFunction());
            localIntent.putExtra("articalChannelId", 1);
            localIntent.putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
            localIntent.putExtra("fromOneCLickCLose", true);
            String str1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(str2);
            localObject = str1;
            if (EcshopFromUtils.a(str2))
            {
              localObject = str1;
              if (paramVarArgs != null)
              {
                localObject = str1;
                if (paramVarArgs.length > 0)
                {
                  localObject = str1;
                  if ((paramVarArgs[0] instanceof Boolean))
                  {
                    localObject = str1;
                    if (((Boolean)paramVarArgs[0]).booleanValue()) {
                      localObject = "biz_src_ads";
                    }
                  }
                }
              }
            }
            localIntent.putExtra("big_brother_source_key", (String)localObject);
          }
        }
      }
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.d, localIntent, paramString);
      if (localIntent.getComponent() != null)
      {
        this.c.startActivity(localIntent);
        return true;
      }
      paramString = new ActivityURIRequest(this.c, "/pubaccount/browser");
      paramString.extra().putAll(localIntent.getExtras());
      QRoute.startUri(paramString, null);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    Object localObject = (BaseActivity)this.c;
    if (((BaseActivity)localObject).getChatFragment() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
    }
    int i = ((BaseActivity)localObject).getChatFragment().k().F();
    paramString2 = ((BaseActivity)localObject).getChatFragment().k().af();
    localObject = ((BaseActivity)localObject).getChatFragment().k().ae();
    Intent localIntent = AIOUtils.a(new Intent(this.c, SplashActivity.class), null);
    localIntent.putExtra("uin", (String)localObject);
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("forward_type", -1);
    localIntent.putExtra("forward_text", paramString1);
    this.c.startActivity(localIntent);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    paramString2 = (BaseActivity)this.c;
    if (paramString2.getChatFragment() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
    }
    paramString2 = paramString2.getChatFragment().k().ae();
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).sendMenuEventequest(this.c, this.b, paramString2, paramString1, false, 0.0D, 0.0D, null, paramInt, paramLong, 2);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2 = paramString3;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      int i = paramString2.indexOf("://");
      if (i == -1)
      {
        localObject = "";
        paramString3 = paramString2;
        paramString2 = (String)localObject;
      }
      else
      {
        paramString3 = paramString2.substring(0, i);
        paramString2 = paramString2.substring(i + 3);
      }
      Object localObject = this.c.getPackageManager();
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
            StartAppCheckHandler.a("structmsg", "", paramString3, "1", "structmsgClick", this.c.getClass().getName());
            this.c.startActivity((Intent)localObject);
            return true;
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
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new Intent(this.c, QQBrowserActivity.class);
      paramString2.putExtra("key_isReadModeEnabled", true);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("fromAio", true);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(this.d, paramString2, paramString1);
      this.c.startActivity(paramString2);
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
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = false;
    String str = "";
    Object localObject2;
    if (bool2)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("StructMsgClickHandler doAction action = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(", url = ");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(", actionData = ");
      ((StringBuilder)localObject2).append(paramString3);
      ((StringBuilder)localObject2).append(", actionDataA = ");
      ((StringBuilder)localObject2).append(paramString4);
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(", args = ");
        ((StringBuilder)localObject1).append(paramVarArgs[0]);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("StructMsg", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.c;
    if ((localObject1 instanceof BaseActivity))
    {
      localObject1 = ((BaseActivity)localObject1).getChatFragment();
      if (localObject1 != null)
      {
        localObject2 = ((ChatFragment)localObject1).k().ae();
        int i = ((ChatFragment)localObject1).k().F();
        if ((paramString1 != null) && (!paramString1.equals("")) && (i == 1008)) {
          ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).addPublicAccountToRu(this.b, (String)localObject2);
        }
        if ((((ChatFragment)localObject1).k() instanceof PublicAccountChatPie))
        {
          localObject1 = this.d;
          if ((localObject1 instanceof MessageForStructing))
          {
            MessageForStructing localMessageForStructing = (MessageForStructing)localObject1;
            localObject1 = str;
            if (localMessageForStructing.mExJsonObject != null) {
              localObject1 = localMessageForStructing.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
            }
            if ((localMessageForStructing.structingMsg instanceof StructMsgForHypertext)) {
              PublicAccountEventReport.a(this.b, (String)localObject2, 0, 2, paramLong, (String)localObject1);
            } else if (!(localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
              if ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare)) {
                PublicAccountEventReport.a(this.b, (String)localObject2, 0, 1, paramLong, (String)localObject1);
              } else if ((localMessageForStructing.structingMsg instanceof StructMsgForAudioShare)) {
                PublicAccountEventReport.a(this.b, (String)localObject2, 0, 5, paramLong, (String)localObject1);
              }
            }
          }
        }
      }
    }
    if ("web".equals(paramString1))
    {
      if (paramLong > 0L) {
        bool1 = a(paramString2, paramLong, paramVarArgs);
      } else {
        bool1 = a(paramString2);
      }
      bool2 = bool1;
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (paramLong > 0L) {
          return a(paramString2, null, 2, paramLong);
        }
      }
    }
    else
    {
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
        bool1 = a(paramString3, null, 1, paramLong);
      }
    }
    return bool1;
  }
  
  public boolean b(String paramString)
  {
    if (paramString.startsWith("tel:"))
    {
      paramString = paramString.substring(4);
      a(this.c, paramString);
    }
    else
    {
      try
      {
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramString.putExtra("com.android.browser.application_id", this.c.getPackageName());
        this.c.startActivity(paramString);
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HyperTextMsg", 2, paramString.getMessage());
        }
      }
    }
    return true;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    paramString2 = (BaseActivity)this.c;
    if (paramString2.getChatFragment() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("StructMsg", 2, "chatfragment is null");
      }
      return true;
    }
    paramString2 = paramString2.getChatFragment().k().ae();
    ((IPublicAccountManager)QRoute.api(IPublicAccountManager.class)).sendMenuEventequest(this.c, this.b, paramString2, paramString1, false, 0.0D, 0.0D, null, 1, 0L, 2);
    return true;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StructMsgClickHandler clickPluginMsg  actionData = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", actionDataA = ");
      localStringBuilder.append(paramString2);
      QLog.d("StructMsg", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    if (TextUtils.equals(paramString1, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent")) {
      return true;
    }
    try
    {
      paramString1 = JumpParser.a(this.b, this.c, paramString1);
      if (paramString1 != null)
      {
        if (this.d != null) {
          paramString1.a("msg_uniseq", String.valueOf(this.d.uniseq));
        }
        paramString1.a();
        if ((this.d != null) && (!this.d.isSend()) && (this.d.istroop == 0) && (Utils.c(this.d.frienduin)) && (!TextUtils.isEmpty(this.d.getExtInfoFromExtStr("guide_msg_cookie"))))
        {
          paramString1 = Utils.h(this.d.getExtInfoFromExtStr("guide_msg_cookie"));
          if (paramString1 != null)
          {
            paramString2 = new babyq_cookie.BabyQCookie();
            paramString2.mergeFrom(paramString1);
            if (paramString2.uint32_type.get() == 207)
            {
              this.b.getMessageFacade().d("baqyq_mayknow_people");
              return true;
            }
          }
        }
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, paramString1.getMessage(), paramString1);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgClickHandler
 * JD-Core Version:    0.7.0.1
 */