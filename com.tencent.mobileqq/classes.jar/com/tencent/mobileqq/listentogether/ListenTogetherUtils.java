package com.tencent.mobileqq.listentogether;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ListenTogetherUtils
{
  static SimpleDateFormat a = new SimpleDateFormat("mm:ss");
  
  public static int a(String paramString1, String paramString2)
  {
    int i = -1;
    try
    {
      paramString2 = ((TroopManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString2);
      if (paramString2 != null)
      {
        if (paramString2.isTroopOwner(paramString1)) {
          return 0;
        }
        boolean bool = paramString2.isTroopAdmin(paramString1);
        if (bool) {
          return 1;
        }
        i = 2;
      }
      return i;
    }
    catch (Throwable paramString1) {}
    return -1;
  }
  
  public static String a()
  {
    String str2 = ThemeUtil.getCurrentThemeId();
    String str1 = str2;
    if (!"3064".equals(str2))
    {
      str1 = str2;
      if (!"3063".equals(str2))
      {
        str1 = str2;
        if (!"3066".equals(str2))
        {
          str1 = str2;
          if (!"3065".equals(str2))
          {
            if ("3067".equals(str2)) {
              return str2;
            }
            str1 = "";
          }
        }
      }
    }
    return str1;
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 2)
    {
      if (paramInt3 == 3) {
        return HardCodeUtil.a(2131693643);
      }
      if (paramInt3 == 2) {
        return HardCodeUtil.a(2131693654);
      }
      if (paramInt3 == 1) {
        return HardCodeUtil.a(2131693670);
      }
      return HardCodeUtil.a(2131693664);
    }
    StringBuilder localStringBuilder;
    if (paramInt2 > 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(HardCodeUtil.a(2131693662));
      return localStringBuilder.toString();
    }
    if (paramInt2 == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(HardCodeUtil.a(2131693680));
      return localStringBuilder.toString();
    }
    return HardCodeUtil.a(2131693664);
  }
  
  public static final String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    return a.format(Long.valueOf(l));
  }
  
  @Nullable
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    Object localObject;
    if ((!"0".equals(paramString2)) && (!"10000".equals(paramString2)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramInt == 2) {
        paramQQAppInterface = ContactUtils.a(paramQQAppInterface, paramString2);
      } else if (paramInt == 1) {
        paramQQAppInterface = ContactUtils.b(paramQQAppInterface, paramString1, paramString2);
      } else {
        paramQQAppInterface = "";
      }
      localObject = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject = paramString2;
      }
    }
    else
    {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getNickName, uin=");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append(",sessionType=");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface.append(", frdUin=");
      paramQQAppInterface.append(paramString2);
      QLog.d("ListenTogetherUtils", 2, paramQQAppInterface.toString());
    }
    return localObject;
  }
  
  public static String a(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo == null) {
      return "";
    }
    String str1 = paramMusicInfo.b.trim();
    String str2 = str1;
    if (paramMusicInfo.a != null)
    {
      int i = 0;
      int j = 1;
      while (i < paramMusicInfo.a.size())
      {
        str2 = (String)paramMusicInfo.a.get(i);
        if (!TextUtils.isEmpty(str2))
        {
          StringBuilder localStringBuilder;
          if (j != 0)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str1);
            localStringBuilder.append("—");
            localStringBuilder.append(str2.trim());
            str1 = localStringBuilder.toString();
            j = 0;
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str1);
            localStringBuilder.append("/");
            localStringBuilder.append(str2.trim());
            str1 = localStringBuilder.toString();
          }
        }
        i += 1;
      }
      str2 = str1;
    }
    return str2;
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(QzoneConfig.getInstance().getConfig("H5Url", "YQHMusicPersonalPlayerUrl", "https://zb.vip.qq.com/v2/musicTheme"), "uin", paramString), "uinType", String.valueOf(paramInt)), "type", "2"), "_wv", "5123"));
    paramActivity.startActivity(localIntent);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A5C2", 1, 0, "", "", VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()), "");
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    boolean bool = true;
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    if (paramInt != 1) {
      bool = false;
    }
    a(bool, "clk_join_bar", paramString);
    a(paramContext, paramInt, paramString, 2, true, null);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a((QQAppInterface)localObject);
    boolean bool2 = localListenTogetherManager.b(paramInt1, paramString1);
    boolean bool3 = localListenTogetherManager.a(paramInt1, paramString1);
    boolean bool1 = false;
    QLog.d("ListenTogetherUtils", 1, new Object[] { "onJoinClick sessionType=", Integer.valueOf(paramInt1), ",uin=", MobileQQ.getShortUinStr(paramString1), ",joinFrom=", Integer.valueOf(paramInt2), ",reopenIfNeed=", Boolean.valueOf(paramBoolean), ",songId=", paramString2, ",meJoined=", Boolean.valueOf(bool2), ",isOpened=", Boolean.valueOf(bool3) });
    if ((!bool2) && (!bool3))
    {
      if (paramBoolean)
      {
        localObject = DialogUtil.a(paramContext, 230);
        paramString2 = new ListenTogetherUtils.1(paramInt1, paramString1, paramString2, paramInt2);
        ((QQCustomDialog)localObject).setTitle(2131693656);
        ((QQCustomDialog)localObject).setTitleMutiLine();
        ((QQCustomDialog)localObject).setMessage(null);
        ((QQCustomDialog)localObject).setNegativeButton(HardCodeUtil.a(2131706255), paramString2);
        ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131693644), paramString2);
        ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
        if (!((BaseActivity)paramContext).isFinishing())
        {
          ((QQCustomDialog)localObject).show();
          if (paramInt2 == 1) {
            paramContext = "exp_openframe";
          } else {
            paramContext = "exp_joinbar";
          }
          paramBoolean = bool1;
          if (paramInt1 == 1) {
            paramBoolean = true;
          }
          a(paramBoolean, paramContext, paramString1);
        }
      }
    }
    else {
      ListenTogetherManager.a((QQAppInterface)localObject).a((BaseActivity)paramContext, paramInt1, paramString1);
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, int paramInt, String paramString)
  {
    if (paramBaseChatPie.a() != null)
    {
      if (paramBaseChatPie.a().getIntent() == null) {
        return;
      }
      Object localObject = paramBaseChatPie.a().getIntent();
      boolean bool1 = false;
      if (!((Intent)localObject).getBooleanExtra("key_from_listen_together_notify_msg", false)) {
        return;
      }
      ListenTogetherManager.a(paramBaseChatPie.a);
      if (paramInt == 1) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      boolean bool2 = b(paramBaseChatPie, paramInt, paramString);
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogetherUtils", 2, String.format("checkEnterAioByListenTogetherNotifyMsg sessionType=%d uin=%s isOpen=%b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(bool2) }));
      }
      if (bool2)
      {
        localObject = DialogUtil.a(paramBaseChatPie.a(), 230);
        ListenTogetherUtils.2 local2 = new ListenTogetherUtils.2(paramBaseChatPie, paramInt, paramString);
        ((QQCustomDialog)localObject).setTitle(2131693655);
        ((QQCustomDialog)localObject).setMessage(null);
        ((QQCustomDialog)localObject).setNegativeButton(HardCodeUtil.a(2131706255), local2);
        ((QQCustomDialog)localObject).setPositiveButton(HardCodeUtil.a(2131707064), local2);
        ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
        if (!paramBaseChatPie.a().isFinishing())
        {
          ((QQCustomDialog)localObject).show();
          if (paramInt == 1) {
            bool1 = true;
          }
          a(bool1, "exp_joinframe", paramString);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentUin(), 0).edit().putBoolean("sp_key_listen_together_has_show_guide", true).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString)
  {
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://web.qun.qq.com/qunmusic/listener", "uin", paramString), "uinType", String.valueOf(paramInt)), "_wwv", "128"), "_wv", "2"));
    paramActivity.startActivity(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramContext != null) && (paramQQAppInterface != null))
    {
      if (paramInt1 == 1)
      {
        Object localObject = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
        boolean bool;
        if (localObject != null) {
          bool = ((TroopInfo)localObject).isAdmin();
        } else {
          bool = false;
        }
        if (!bool)
        {
          localObject = ListenTogetherManager.a(paramQQAppInterface).a(paramInt1, paramString);
          if ((localObject != null) && (((ListenTogetherSession)localObject).h != 3))
          {
            b(paramQQAppInterface, paramContext, paramInt1, paramString, paramInt2);
            return;
          }
          QQToast.a(BaseApplication.getContext(), 2131693659, 0).a();
          return;
        }
        b(paramQQAppInterface, paramContext, paramInt1, paramString, paramInt2);
        return;
      }
      if (paramInt1 == 2) {
        b(paramQQAppInterface, paramContext, paramInt1, paramString, paramInt2);
      }
      return;
    }
    QLog.d("ListenTogetherUtils", 1, "gotoListenTogetherSettingPage return");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean2) {
      str = paramQQAppInterface.getCurrentUin();
    } else {
      str = "qq_listen_together_pref";
    }
    paramQQAppInterface.getApplication().getSharedPreferences(str, 0).edit().putBoolean(paramString, paramBoolean1).apply();
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    String str;
    if (paramBoolean) {
      str = "Grp_AIO";
    } else {
      str = "c2c_AIO";
    }
    if (!paramBoolean) {
      paramString2 = "0";
    }
    ReportController.b(null, "dc00899", str, "", "music_tab", paramString1, 0, 0, paramString2, "0", "", "");
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_YQHPersnoalPlayerEnbled", 1) != 0;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentUin(), 0).getBoolean("sp_key_listen_together_has_show_guide", false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if ((paramQQAppInterface != null) && (paramMessage != null))
    {
      if (paramMessage.msgtype != -5008) {
        return false;
      }
      paramQQAppInterface = paramQQAppInterface.getMessageFacade();
      String str = null;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
        if ((paramQQAppInterface instanceof MessageForArkApp))
        {
          paramQQAppInterface = (MessageForArkApp)paramQQAppInterface;
          break label66;
        }
      }
      paramQQAppInterface = null;
      label66:
      boolean bool2;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.ark_app_message != null) && ("com.tencent.together".equals(paramQQAppInterface.ark_app_message.appName)) && ("invite".equals(paramQQAppInterface.ark_app_message.appView)))
      {
        boolean bool1;
        try
        {
          JSONObject localJSONObject = new JSONObject(paramQQAppInterface.ark_app_message.metaList);
          paramQQAppInterface = str;
          if (localJSONObject.has("invite")) {
            paramQQAppInterface = localJSONObject.getJSONObject("invite");
          }
          str = "";
          if (paramQQAppInterface != null) {
            str = paramQQAppInterface.optString("type", "");
          }
          bool1 = str.equals("listen");
        }
        catch (Throwable paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherUtils", 1, "handleListenTogetherIntentFromArkMsg", paramQQAppInterface);
          }
          bool1 = false;
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i("ListenTogetherUtils", 2, String.format("checkIsTogetherOpenArkMsg uinType=%d uin=%s isListenTogether=%b", new Object[] { Integer.valueOf(paramMessage.istroop), MobileQQ.getShortUinStr(paramMessage.frienduin), Boolean.valueOf(bool1) }));
          return bool1;
        }
      }
      else
      {
        bool2 = false;
      }
      return bool2;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage, Intent paramIntent)
  {
    if ((paramQQAppInterface != null) && (paramMessage != null) && (paramMessage.msgtype == -5008))
    {
      boolean bool = a(paramQQAppInterface, paramMessage);
      if (bool) {
        paramIntent.putExtra("key_from_listen_together_notify_msg", bool);
      }
      return bool;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean2) {
      str = paramQQAppInterface.getCurrentUin();
    } else {
      str = "qq_listen_together_pref";
    }
    return paramQQAppInterface.getApplication().getSharedPreferences(str, 0).getBoolean(paramString, paramBoolean1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if (TogetherControlManager.a(paramQQAppInterface).a(paramContext, 1, paramString, paramInt2)) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    String str1 = URLUtil.a("https://web.qun.qq.com/qunmusic/index", "uin", paramString);
    Object localObject2 = (ListenTogetherManager)paramQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
    ((ListenTogetherManager)localObject2).d();
    boolean bool = ((ListenTogetherManager)localObject2).c(paramInt1, paramString);
    String str2 = a();
    Object localObject1 = str1;
    if (!TextUtils.isEmpty(str2)) {
      localObject1 = URLUtil.a(str1, "themeId", str2);
    }
    str2 = URLUtil.a((String)localObject1, "uinType", String.valueOf(paramInt1));
    str1 = "1";
    if (bool) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    str2 = URLUtil.a(URLUtil.a(URLUtil.a(str2, "showlrc", (String)localObject1), "_wv", "2"), "_wwv", "128");
    if (((ListenTogetherManager)localObject2).b(paramInt1, paramString)) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localObject2 = URLUtil.a(URLUtil.a(str2, "isJoin", (String)localObject1), "from", String.valueOf(paramInt2));
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("is_not_first_join_listen_together_");
    ((StringBuilder)localObject1).append(paramInt1);
    if (a(paramQQAppInterface, ((StringBuilder)localObject1).toString(), false, false)) {
      localObject1 = str1;
    } else {
      localObject1 = "0";
    }
    localIntent.putExtra("url", URLUtil.a((String)localObject2, "isNew", (String)localObject1));
    paramContext.startActivity(localIntent);
    ListenTogetherManager.a(paramQQAppInterface).a(paramContext, paramInt1, paramString);
  }
  
  private static boolean b(BaseChatPie paramBaseChatPie, int paramInt, String paramString)
  {
    boolean bool = ListenTogetherManager.a(paramBaseChatPie.a()).a(paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherUtils", 2, String.format("checkEnterAioByListenTogetherNotifyMsg sessionType=%d uin=%s isOpen=%b", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(bool) }));
    }
    if (!bool) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131693659, 1).b(paramBaseChatPie.a());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherUtils
 * JD-Core Version:    0.7.0.1
 */