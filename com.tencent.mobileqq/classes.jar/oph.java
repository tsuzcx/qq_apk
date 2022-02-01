import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;

public class oph
{
  private static String a(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString2)) {
      return paramString1;
    }
    paramString1 = opg.a(paramString1, opg.a(paramString2), false);
    QLog.i("Ecshop_JumpUtil", 2, paramString1);
    return paramString1;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tab_id", paramInt);
    localIntent.putExtra("jump_url", paramString);
    try
    {
      bool = opg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      localIntent.putExtra("req_qgg_title", bool);
      localIntent.putExtra("req_qgg_hide_tab", false);
      localIntent.putExtra("big_brother_source_key", uuc.b("3046055438"));
      localIntent.setFlags(603979776);
      PublicFragmentActivityForTool.b(paramContext, localIntent, EcshopNewPageFragment.class);
      if (((paramContext instanceof Activity)) && (!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool)) && (!(paramContext instanceof UniteSearchActivity)))
      {
        ((Activity)paramContext).finish();
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        boolean bool = true;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      Intent localIntent = new Intent(paramContext, ChatActivity.class);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("req_qgg_hide_tab", paramBoolean);
      localIntent.putExtra("leftViewText", paramContext.getString(2131690676));
      localIntent.setFlags(4194304);
      paramContext.startActivity(localIntent);
    } while (!(paramContext instanceof Activity));
    paramString1 = (Activity)paramContext;
    if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof PublicFragmentActivityForTool))) {
      paramString1.finish();
    }
    paramString1.overridePendingTransition(0, 0);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    QLog.i("Ecshop_JumpUtil", 2, "---jumpByTabIdInner---" + paramInt);
    if (paramInt == 0) {
      a(paramContext, "3046055438", paramString1, true);
    }
    Object localObject;
    String str;
    do
    {
      return;
      localObject = opd.a();
      if (localObject == null) {
        break label172;
      }
      localObject = ((opa)localObject).a(paramInt);
      if (localObject == null)
      {
        a(paramContext, "3046055438", paramString1, true);
        return;
      }
      str = opk.a(((opc)localObject).b, paramString3);
      if ((!StringUtil.isEmpty(str)) && ((str.startsWith("http")) || (str.startsWith("https")) || (MiniAppLauncher.isMiniAppUrl(str)))) {
        break;
      }
    } while (((opc)localObject).a != 1);
    a(paramContext, "3046055438", paramString1, paramBoolean);
    return;
    if (MiniAppLauncher.isMiniAppUrl(str))
    {
      MiniAppLauncher.startMiniApp(paramContext, str, 1035, null);
      return;
    }
    a(paramQQAppInterface, paramContext, paramInt, str, paramBoolean, paramString2, paramString3);
    return;
    label172:
    a(paramContext, "3046055438", paramString1, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str4 = "";
    String str1 = str4;
    String str2 = str4;
    int i;
    label70:
    label242:
    label249:
    String str3;
    try
    {
      if (bhfc.a(paramQQAppInterface.getMessageFacade().getAIOList("3046055438", 1008)))
      {
        str1 = str4;
        str2 = str4;
        a(paramQQAppInterface, paramContext, null, "jumpTab", "", 2);
        paramContext = "";
        i = paramQQAppInterface.getConversationFacade().a("3046055438", 1008);
        if (i <= 0) {
          break label242;
        }
        str1 = "1";
        opk.a(paramQQAppInterface, "gouwu.aio.click", str1, NetConnInfoCenter.getServerTimeMillis() + "", paramContext);
        if (i <= 0) {
          break label249;
        }
      }
      for (str1 = "1";; str1 = "0")
      {
        opk.b(paramQQAppInterface, "gouwu_aio_click", str1, NetConnInfoCenter.getServerTimeMillis() + "", paramContext);
        return;
        str1 = str4;
        str2 = str4;
        MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab("3046055438", 1008);
        if (localMessageRecord == null)
        {
          str1 = str4;
          str2 = str4;
          a(paramContext, "3046055438", paramContext.getResources().getString(2131691810), true);
          paramContext = "";
          break;
        }
        str1 = str4;
        str2 = str4;
        str4 = opg.a(localMessageRecord);
        str1 = str4;
        str2 = str4;
        b(paramQQAppInterface, paramContext, localMessageRecord, opf.b(paramQQAppInterface, opg.b(localMessageRecord)), "", opg.c(localMessageRecord));
        paramContext = str4;
        break;
        str1 = "0";
        break label70;
      }
      label371:
      paramContext = "1";
    }
    catch (Throwable localThrowable)
    {
      str3 = str1;
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691810), true);
      i = paramQQAppInterface.getConversationFacade().a("3046055438", 1008);
      if (i > 0)
      {
        paramContext = "1";
        opk.a(paramQQAppInterface, "gouwu.aio.click", paramContext, NetConnInfoCenter.getServerTimeMillis() + "", str1);
        if (i <= 0) {
          break label371;
        }
      }
      for (paramContext = "1";; paramContext = "0")
      {
        opk.b(paramQQAppInterface, "gouwu_aio_click", paramContext, NetConnInfoCenter.getServerTimeMillis() + "", str1);
        return;
        paramContext = "0";
        break;
      }
    }
    finally
    {
      i = paramQQAppInterface.getConversationFacade().a("3046055438", 1008);
      if (i <= 0) {
        break label468;
      }
    }
    opk.a(paramQQAppInterface, "gouwu.aio.click", paramContext, NetConnInfoCenter.getServerTimeMillis() + "", str3);
    if (i > 0) {}
    for (paramContext = "1";; paramContext = "0")
    {
      opk.b(paramQQAppInterface, "gouwu_aio_click", paramContext, NetConnInfoCenter.getServerTimeMillis() + "", str3);
      throw localObject;
      label468:
      paramContext = "0";
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    if ("fypbtn".equals(paramString3))
    {
      a(paramContext, paramInt, paramString1);
      return;
    }
    paramString3 = new Intent();
    paramString3.putExtra("tab_id", paramInt);
    String str = opg.b();
    paramInt = paramQQAppInterface.getConversationFacade().a("3046055438", 1008);
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_JumpUtil", 2, "<<<<<<unReadPointCnt<<<<<<" + paramInt);
    }
    if (paramInt == 0) {
      if ((!StringUtil.isEmpty(str)) && (!StringUtil.isEmpty(opg.a())))
      {
        paramQQAppInterface = new HashMap();
        paramQQAppInterface.put("prompt_id", str);
        paramQQAppInterface = opg.a(paramString1, paramQQAppInterface, false);
      }
    }
    for (;;)
    {
      paramString3.putExtra("jump_url", paramQQAppInterface);
      QLog.i("Ecshop_JumpUtil", 2, paramQQAppInterface);
      try
      {
        bool = opg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
        paramString3.putExtra("req_qgg_title", bool);
        paramString3.putExtra("req_qgg_hide_tab", paramBoolean);
        paramString3.putExtra("big_brother_source_key", uuc.b("3046055438"));
        paramString3.setFlags(603979776);
        PublicFragmentActivityForTool.b(paramContext, paramString3, EcshopNewPageFragment.class);
        return;
        paramQQAppInterface = a(paramString1, paramString2);
        continue;
        paramQQAppInterface = a(paramString1, paramString2);
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          paramQQAppInterface.printStackTrace();
          boolean bool = true;
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, int paramInt)
  {
    opg.a(paramMessageRecord.uniseq, paramInt + 1);
    paramMessageRecord = new Intent(paramContext, ChatActivity.class);
    paramMessageRecord.putExtra("uin", "3046055438");
    paramMessageRecord.putExtra("uintype", 1008);
    paramMessageRecord.putExtra("uinname", paramContext.getResources().getString(2131691810));
    paramMessageRecord.putExtra("leftViewText", paramContext.getString(2131690676));
    paramMessageRecord.putExtra("jump_minusonescreen_view", true);
    paramContext.startActivity(paramMessageRecord);
    opk.a(paramQQAppInterface, "gouwu.fyp.show", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
    opk.b(paramQQAppInterface, "gouwu_fyp_show", "", NetConnInfoCenter.getServerTimeMillis() + "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2)
  {
    int i = opg.a(paramMessageRecord.uniseq);
    if (i >= opg.a(paramQQAppInterface, paramString1))
    {
      a(paramQQAppInterface, paramContext, paramString1, paramMessageRecord, paramString2);
      return;
    }
    a(paramQQAppInterface, paramContext, paramMessageRecord, i);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = true;
    paramString1 = "";
    for (;;)
    {
      try
      {
        int i = opg.b(paramMessageRecord);
        QLog.e("Ecshop_JumpUtil", 1, paramMessageRecord, new Object[0]);
      }
      catch (Exception paramMessageRecord)
      {
        try
        {
          paramMessageRecord = opg.c(paramMessageRecord);
          paramString1 = paramMessageRecord;
          if (QLog.isColorLevel())
          {
            paramString1 = paramMessageRecord;
            QLog.i("Ecshop_JumpUtil", 2, "hideTabId: " + i + " params: " + paramMessageRecord);
          }
          if (i != 1) {
            break label113;
          }
          a(paramQQAppInterface, paramInt, paramContext, paramContext.getResources().getString(2131691810), bool, paramMessageRecord, paramString2);
          return;
        }
        catch (Exception paramMessageRecord)
        {
          break label97;
        }
        paramMessageRecord = paramMessageRecord;
        i = 0;
      }
      label97:
      paramMessageRecord = paramString1;
      continue;
      label113:
      bool = false;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, MessageRecord paramMessageRecord, String paramString2)
  {
    paramString1 = opf.a(paramQQAppInterface, paramString1, "redirectScheme");
    if (StringUtil.isEmpty(paramString1))
    {
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691810), true);
      return;
    }
    String str;
    try
    {
      paramString1 = opk.a(URLDecoder.decode(paramString1, "UTF-8"), paramString2);
      str = opf.a(paramString1);
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_JumpUtil", 2, "<<<<jumpByRedirectScheme<<<<decodedScheme: " + paramString1 + " <<<<<redirectHost: " + str);
      }
      if ((paramString1.startsWith("http")) || (paramString1.startsWith("https")))
      {
        paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramQQAppInterface.putExtra("url", paramString1);
        paramQQAppInterface.putExtra("big_brother_source_key", uuc.b("3046055438"));
        if (!(paramContext instanceof Activity)) {
          paramQQAppInterface.addFlags(268435456);
        }
        paramContext.startActivity(paramQQAppInterface);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      a(paramContext, "3046055438", paramContext.getResources().getString(2131691810), true);
      return;
    }
    try
    {
      i = Integer.parseInt(opf.a(paramString1, "tabId"));
      b(paramQQAppInterface, paramContext, paramMessageRecord, str, paramString2, i);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        QLog.e("Ecshop_JumpUtil", 2, new Object[] { Integer.valueOf(1) });
        int i = 1;
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_JumpUtil", 2, "jumpByHost>>>>>>" + paramString1);
    }
    if ("jumpTab".equals(paramString1))
    {
      a(paramQQAppInterface, paramContext, paramMessageRecord, paramString1, paramString2, paramInt);
      return;
    }
    if ("jumpPreview".equals(paramString1))
    {
      a(paramQQAppInterface, paramContext, paramMessageRecord, paramString1, "fypgo");
      return;
    }
    a(paramContext, "3046055438", paramContext.getResources().getString(2131691810), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oph
 * JD-Core Version:    0.7.0.1
 */