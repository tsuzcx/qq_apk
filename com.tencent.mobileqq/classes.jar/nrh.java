import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class nrh
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
  
  public static axup a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        if ((paramMessageRecord.mStructMsgItemLists != null) && (paramMessageRecord.mStructMsgItemLists.size() > 0))
        {
          paramMessageRecord = (axup)paramMessageRecord.mStructMsgItemLists.get(0);
          if (paramMessageRecord != null)
          {
            int i = paramMessageRecord.g;
            if (QLog.isColorLevel()) {
              QLog.i("EcshopUtils", 2, "---tabId---" + i + " isHidden: " + paramMessageRecord.h);
            }
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
  
  public static JSONObject a(MessageRecord paramMessageRecord)
  {
    MessageRecord localMessageRecord = null;
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if (paramMessageRecord == null) {
        break label82;
      }
    }
    label82:
    for (paramMessageRecord = paramMessageRecord.mSourceAd;; paramMessageRecord = "") {
      for (;;)
      {
        try
        {
          if (!bbkk.a(paramMessageRecord))
          {
            paramMessageRecord = new JSONObject(paramMessageRecord);
            localMessageRecord = paramMessageRecord;
            return localMessageRecord;
          }
        }
        catch (Exception paramMessageRecord)
        {
          QLog.e("EcshopUtils", 1, "[getSourceAdFromArk] " + QLog.getStackTraceString(paramMessageRecord));
          return null;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (QLog.isColorLevel()) {
      QLog.i("EcshopUtils", 2, "[saveRedpoingClickTag]  taksId: " + paramInt2);
    }
    if (localQQAppInterface != null) {
      a(localQQAppInterface, "redpoint_click_" + paramInt1 + "_" + localQQAppInterface.getCurrentAccountUin(), paramInt2);
    }
  }
  
  private static void a(int paramInt, Context paramContext, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      a(paramContext, paramString1, paramString2);
      return;
    }
    Object localObject = nrs.a();
    if (localObject != null)
    {
      localObject = ((nrq)localObject).a(paramInt);
      if (localObject == null)
      {
        a(paramContext, paramString1, paramString2);
        return;
      }
      localObject = ((nrr)localObject).b;
      if (bbkk.a((String)localObject))
      {
        a(paramContext, paramString1, paramString2);
        return;
      }
      a(paramContext, paramInt, (String)localObject);
      return;
    }
    a(paramContext, paramString1, paramString2);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tab_id", paramInt);
    localIntent.putExtra("jump_url", paramString);
    localIntent.putExtra("big_brother_source_key", "biz_src_gzh_qqgw");
    PublicFragmentActivityForTool.b(paramContext, localIntent, EcshopNewPageFragment.class);
    if (((paramContext instanceof Activity)) && (!(paramContext instanceof SplashActivity))) {
      ((Activity)paramContext).finish();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EcshopUtils", 2, "gotoAIO context: " + paramContext + " | uin: " + paramString1);
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      Intent localIntent = new Intent(paramContext, ChatActivity.class);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("leftViewText", paramContext.getString(2131690572));
      localIntent.setFlags(67108864);
      paramContext.startActivity(localIntent);
    } while ((!(paramContext instanceof Activity)) || ((paramContext instanceof SplashActivity)));
    paramContext = (Activity)paramContext;
    paramContext.finish();
    paramContext.overridePendingTransition(0, 0);
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
    Object localObject = paramQQAppInterface.a().a("3046055438", 1008);
    axup localaxup;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
      localaxup = a((MessageRecord)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("EcshopUtils", 2, "absStructMsgElement: " + localaxup);
      }
      if (localaxup == null)
      {
        localObject = a((MessageRecord)localObject);
        if (localObject == null)
        {
          a(paramContext, paramString1, paramString2);
          int i = paramQQAppInterface.a().a("3046055438", 1008);
          QLog.i("EcshopUtils", 2, "[jump] uin: " + paramString1 + " name: " + paramString2 + " unReadPointCnt: " + i);
          if (i <= 0) {
            break label257;
          }
        }
      }
    }
    label257:
    for (paramContext = "1";; paramContext = "0")
    {
      a(paramQQAppInterface, "gouwu.aio.click", paramContext, NetConnInfoCenter.getServerTimeMillis() + "", "");
      return;
      a(((JSONObject)localObject).optInt("tab_id", 1), paramContext, paramString1, paramString2);
      break;
      a(localaxup.g, paramContext, paramString1, paramString2);
      break;
      a(paramContext, paramString1, paramString2);
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopUtils", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s", new Object[] { paramString1, paramString2, paramString3, paramString4 }));
    }
    axqy.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", paramString2, paramString1, 0, 0, paramString4, paramString3, "android", "8.3.0");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrh
 * JD-Core Version:    0.7.0.1
 */