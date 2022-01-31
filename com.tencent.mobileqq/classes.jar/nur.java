import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class nur
{
  private static int a(AppInterface paramAppInterface, String paramString)
  {
    try
    {
      int i = paramAppInterface.getApp().getSharedPreferences("ecshop_pref", 0).getInt(paramString, 0);
      return i;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("EcshopUtils", 1, "[getValueFromSP] fail.", paramAppInterface);
    }
    return 0;
  }
  
  public static azus a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        if ((paramMessageRecord.mStructMsgItemLists != null) && (paramMessageRecord.mStructMsgItemLists.size() > 0))
        {
          paramMessageRecord = (azus)paramMessageRecord.mStructMsgItemLists.get(0);
          if (paramMessageRecord != null)
          {
            int i = paramMessageRecord.g;
            QLog.i("EcshopUtils", 2, "---tabId---" + i + " isHidden: " + paramMessageRecord.h);
          }
          return paramMessageRecord;
        }
      }
    }
    return null;
  }
  
  public static AppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if (!(localObject instanceof AppInterface)) {
          break label53;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label53:
    return null;
  }
  
  /* Error */
  public static JSONObject a(MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 122
    //   4: ifeq +88 -> 92
    //   7: aload_0
    //   8: checkcast 122	com/tencent/mobileqq/data/MessageForArkApp
    //   11: astore_1
    //   12: aload_1
    //   13: getfield 126	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +76 -> 94
    //   21: aload_0
    //   22: getfield 132	com/tencent/mobileqq/data/ArkAppMessage:mSourceAd	Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: invokestatic 137	bdnn:a	(Ljava/lang/String;)Z
    //   30: ifne +62 -> 92
    //   33: new 139	org/json/JSONObject
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 142	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_0
    //   42: aload_0
    //   43: ldc 144
    //   45: aload_1
    //   46: getfield 147	com/tencent/mobileqq/data/MessageForArkApp:msg	Ljava/lang/String;
    //   49: invokevirtual 151	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   52: pop
    //   53: aload_0
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: ldc 30
    //   60: iconst_1
    //   61: new 70	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   68: ldc 153
    //   70: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokestatic 157	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   77: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: goto -31 -> 58
    //   92: aconst_null
    //   93: areturn
    //   94: ldc 161
    //   96: astore_0
    //   97: goto -71 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramMessageRecord	MessageRecord
    //   11	35	1	localMessageForArkApp	com.tencent.mobileqq.data.MessageForArkApp
    //   55	19	1	localException1	Exception
    //   88	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   26	42	55	java/lang/Exception
    //   42	53	88	java/lang/Exception
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QLog.i("EcshopUtils", 2, "[saveRedpoingClickTag]  taksId: " + paramInt2);
    if (localQQAppInterface != null) {
      a(localQQAppInterface, "redpoint_click_" + paramInt1 + "_" + localQQAppInterface.getCurrentAccountUin(), paramInt2);
    }
  }
  
  private static void a(int paramInt, Context paramContext, String paramString1, String paramString2)
  {
    QLog.i("EcshopUtils", 2, "---jumpByTabId---" + paramInt);
    if (paramInt == 0) {
      a(paramContext, paramString1, paramString2);
    }
    Object localObject;
    String str;
    do
    {
      return;
      localObject = nvc.a();
      if (localObject == null) {
        break label153;
      }
      localObject = ((nva)localObject).a(paramInt);
      if (localObject == null)
      {
        a(paramContext, paramString1, paramString2);
        return;
      }
      str = ((nvb)localObject).b;
      if ((!bdnn.a(str)) && ((str.startsWith("http")) || (str.startsWith("https")) || (MiniAppLauncher.isMiniAppUrl(str)))) {
        break;
      }
    } while (((nvb)localObject).a != 1);
    a(paramContext, paramString1, paramString2);
    return;
    if (MiniAppLauncher.isMiniAppUrl(str))
    {
      MiniAppLauncher.startMiniApp(paramContext, str, 1035, null);
      return;
    }
    a(paramContext, paramInt, str);
    return;
    label153:
    a(paramContext, paramString1, paramString2);
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      nvb localnvb;
      if ((nvd.a()) && (nvd.b()))
      {
        localnvb = nvc.a().a(paramInt);
        if (localnvb == null) {}
      }
      try
      {
        nvk.a().a(localnvb.b, paramBoolean);
        return;
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("EcshopUtils", 1, QLog.getStackTraceString(localThrowable1));
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("EcshopUtils", 1, QLog.getStackTraceString(localThrowable2));
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tab_id", paramInt);
    localIntent.putExtra("jump_url", paramString);
    localIntent.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
    localIntent.setFlags(603979776);
    PublicFragmentActivityForTool.b(paramContext, localIntent, EcshopNewPageFragment.class);
    if (((paramContext instanceof Activity)) && (!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool)))
    {
      ((Activity)paramContext).finish();
      ((Activity)paramContext).overridePendingTransition(0, 0);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      if ((paramContext instanceof AccountDetailActivity))
      {
        ((AccountDetailActivity)paramContext).finish();
        return;
      }
      Intent localIntent = new Intent(paramContext, ChatActivity.class);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("leftViewText", paramContext.getString(2131690623));
      localIntent.setFlags(4194304);
      paramContext.startActivity(localIntent);
    } while (!(paramContext instanceof Activity));
    paramString1 = (Activity)paramContext;
    if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool))) {
      paramString1.finish();
    }
    paramString1.overridePendingTransition(0, 0);
  }
  
  private static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    try
    {
      paramAppInterface.getApp().getSharedPreferences("ecshop_pref", 0).edit().putInt(paramString, paramInt).apply();
      return;
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("EcshopUtils", 1, "[saveValueToSP] fail.", paramAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    Object localObject1 = "1";
    label263:
    label279:
    label287:
    for (;;)
    {
      Object localObject2;
      try
      {
        if (!nvd.a()) {
          break label254;
        }
        localObject1 = paramQQAppInterface.a().a("3046055438", 1008);
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label240;
        }
        localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
        localObject2 = a((MessageRecord)localObject1);
        if (localObject2 == null)
        {
          localObject2 = a((MessageRecord)localObject1);
          if (localObject2 == null)
          {
            a(paramContext, paramString1, paramString2);
            localObject1 = "1";
            break label287;
            if (paramQQAppInterface.a().a("3046055438", 1008) <= 0) {
              break label263;
            }
            localObject2 = "1";
            label121:
            a(paramQQAppInterface, "gouwu.aio.click", (String)localObject2, NetConnInfoCenter.getServerTimeMillis() + "", (String)localObject1);
            return;
          }
          if (!"100".equals(((JSONObject)localObject2).optString("action_type"))) {
            break label279;
          }
          localObject1 = "2";
          a(((JSONObject)localObject2).optInt("tab_id", 1), paramContext, paramString1, paramString2);
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("EcshopUtils", 1, QLog.getStackTraceString(paramQQAppInterface));
        a(paramContext, paramString1, paramString2);
        return;
      }
      if (((azus)localObject2).c == 100) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        a(((azus)localObject2).g, paramContext, paramString1, paramString2);
        break label287;
        label240:
        a(paramContext, paramString1, paramString2);
        localObject1 = "1";
        break label287;
        label254:
        a(paramContext, paramString1, paramString2);
        break;
        localObject2 = "0";
        break label121;
      }
      localObject1 = "1";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      Object localObject = paramQQAppInterface.a().a("3046055438", 1008);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
        azus localazus = a((MessageRecord)localObject);
        if (localazus != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("EcshopUtils", 2, "mGdtActionType " + localazus.c);
          }
          if ((localazus.c == 100) && ((localazus.a instanceof StructMsgForGeneralShare)))
          {
            a(localazus.g, false);
            a(paramQQAppInterface, paramString, ((StructMsgForGeneralShare)localazus.a).mContentTitle, NetConnInfoCenter.getServerTimeMillis() + "", "");
          }
        }
        else
        {
          localObject = a((MessageRecord)localObject);
          if ((localObject != null) && ("100".equals(((JSONObject)localObject).optString("action_type"))))
          {
            a(((JSONObject)localObject).optInt("tab_id"), false);
            a(paramQQAppInterface, paramString, ((JSONObject)localObject).optString("aio_desc_name"), NetConnInfoCenter.getServerTimeMillis() + "", "");
            return;
          }
        }
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("EcshopUtils", 1, QLog.getStackTraceString(paramQQAppInterface));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopUtils", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
    }
    try
    {
      azqs.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", paramString2, paramString1, 0, 0, paramString4, paramString3, "android", "8.3.5");
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("EcshopUtils", 1, QLog.getStackTraceString(paramQQAppInterface));
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        paramInt1 = a(localQQAppInterface, "redpoint_click_" + paramInt1 + "_" + localQQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.i("EcshopUtils", 2, "[getRedpointClickTag] cachedTaskId: " + paramInt1 + " taskId: " + paramInt2);
        }
        return paramInt1 == paramInt2;
      }
    }
    catch (Exception localException)
    {
      QLog.e("EcshopUtils", 1, "[getRedpointClickTag] fail.", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nur
 * JD-Core Version:    0.7.0.1
 */