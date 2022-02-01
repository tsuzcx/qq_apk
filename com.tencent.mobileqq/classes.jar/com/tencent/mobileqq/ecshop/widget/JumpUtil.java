package com.tencent.mobileqq.ecshop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.chat.api.IChatActivityApi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.abtest.ABTestInfo;
import com.tencent.mobileqq.ecshop.abtest.ABTestUtil;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean.TabConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.ecshop.conf.QQShopFakeUrlHelper;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class JumpUtil
{
  private static boolean a = false;
  private static String b = "big";
  
  private static int a(List<MessageRecord> paramList, int paramInt)
  {
    int j = 0;
    int i = 0;
    int m = j;
    if (paramInt != 0)
    {
      IEcshopMessageApi localIEcshopMessageApi = (IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class);
      m = j;
      if (!ListUtils.a(paramList))
      {
        j = paramList.size() - 1;
        int k = 0;
        for (;;)
        {
          m = i;
          if (j < 0) {
            break;
          }
          m = i;
          if ("102".equals(localIEcshopMessageApi.getLastMsgType((MessageRecord)paramList.get(j)))) {
            m = i + 1;
          }
          k += 1;
          if (k >= paramInt) {
            return m;
          }
          j -= 1;
          i = m;
        }
      }
    }
    return m;
  }
  
  private static int a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      int i = b();
      float f;
      if ("small".equals(paramString)) {
        f = 57.0F;
      } else {
        f = 124.0F;
      }
      int j = ViewUtils.dip2px(f);
      return DisplayUtil.b(MobileQQ.sMobileQQ, i + j);
    }
    return 0;
  }
  
  public static Intent a(Intent paramIntent, String paramString, int paramInt)
  {
    return paramIntent;
  }
  
  private static EcshopConfBean.TabConfBean a(EcshopConfBean paramEcshopConfBean, int paramInt)
  {
    if (paramEcshopConfBean.k.isEmpty()) {
      return null;
    }
    paramEcshopConfBean = paramEcshopConfBean.k.iterator();
    while (paramEcshopConfBean.hasNext())
    {
      EcshopConfBean.TabConfBean localTabConfBean = (EcshopConfBean.TabConfBean)paramEcshopConfBean.next();
      if (localTabConfBean.b == paramInt) {
        return localTabConfBean;
      }
    }
    return null;
  }
  
  private static HashMap<String, String> a(String paramString)
  {
    int i = ((IConversationFacade)AppUtils.a().getRuntimeService(IConversationFacade.class, "")).getUnreadCount("3046055438", 1008);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<<<<<<unReadPointCnt<<<<<<");
      ((StringBuilder)localObject).append(i);
      QLog.i("Ecshop_JumpUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 0)
    {
      localObject = EcshopUtils.b();
      if ((!StringUtil.isEmpty((String)localObject)) && (!StringUtil.isEmpty(EcshopUtils.a())))
      {
        paramString = new HashMap();
        paramString.put("prompt_id", localObject);
        return paramString;
      }
    }
    return EcshopUtils.d(paramString);
  }
  
  public static void a()
  {
    ABTestInfo localABTestInfo = ABTestUtil.b("expQQShopPageStyleV2");
    if (localABTestInfo != null)
    {
      a = "hippy".equals(localABTestInfo.a("pageStyle", "tab"));
      b = localABTestInfo.a("adStyle", "big");
    }
  }
  
  public static void a(@NonNull Context paramContext)
  {
    a(paramContext, "");
  }
  
  private static void a(@NonNull Context paramContext, int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    Bundle localBundle = new Bundle();
    SerializableMap localSerializableMap = new SerializableMap();
    paramString2 = a(paramString2);
    localSerializableMap.wrapMap(paramString2);
    localBundle.putString("errorUrl", EcshopUtils.a(paramString1, paramString2, false));
    localBundle.putString("domain", "qianbao.qq.com");
    localBundle.putString("bundleName", "qqshop");
    localBundle.putSerializable("qqshopParams", localSerializableMap);
    paramString1 = new Intent();
    paramString1.putExtra("params", localBundle);
    paramString1.putExtra("req_qgg_title", EcshopUtils.c());
    paramString1.putExtra("req_qgg_hide_tab", paramBoolean);
    paramString1.putExtra("tab_id", paramInt);
    paramString1.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
    paramString1.setFlags(603979776);
    paramString1.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.start(paramContext, paramString1, QQShopPAHippyFragment.class);
  }
  
  private static void a(@NonNull Context paramContext, int paramInt, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tab_id", paramInt);
    paramString2 = a(paramString2);
    paramString2.putAll(EcshopUtils.d(paramString3));
    if (EcshopUtils.a("3046055438")) {
      paramString2.put("isFollowed", "1");
    } else {
      paramString2.put("isFollowed", "0");
    }
    localIntent.putExtra("jump_url", EcshopUtils.a(paramString1, paramString2, false));
    localIntent.putExtra("req_qgg_title", EcshopUtils.c());
    localIntent.putExtra("req_qgg_hide_tab", paramBoolean);
    localIntent.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
    localIntent.setFlags(603979776);
    QPublicFragmentActivityForTool.a(paramContext, localIntent, EcshopNewPageFragment.class);
  }
  
  public static void a(@NonNull Context paramContext, String paramString)
  {
    a();
    int i = ((IConversationFacade)AppUtils.a().getRuntimeService(IConversationFacade.class, "")).getUnreadCount("3046055438", 1008);
    if (a) {
      a(paramContext, paramString, i);
    } else {
      b(paramContext, paramString);
    }
    String str = d();
    paramString = "1";
    if (i > 0) {
      paramContext = "1";
    } else {
      paramContext = "0";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NetConnInfoCenter.getServerTimeMillis());
    localStringBuilder.append("");
    ReportUtil.a("gouwu.aio.click", paramContext, localStringBuilder.toString(), str);
    if (i > 0) {
      paramContext = paramString;
    } else {
      paramContext = "0";
    }
    paramString = new StringBuilder();
    paramString.append(NetConnInfoCenter.getServerTimeMillis());
    paramString.append("");
    ReportUtil.b("gouwu_aio_click", paramContext, paramString.toString(), str);
  }
  
  public static void a(@NonNull Context paramContext, String paramString, int paramInt)
  {
    b(paramContext, paramString, paramInt);
  }
  
  private static void a(@NonNull Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ((IChatActivityApi)QRoute.api(IChatActivityApi.class)).getChatActivityClass());
    localIntent.putExtra("uin", "3046055438");
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uinname", paramContext.getResources().getString(2131888821));
    localIntent.putExtra("req_qgg_hide_tab", paramBoolean);
    localIntent.putExtra("leftViewText", paramContext.getString(2131887625));
    localIntent.setFlags(4194304);
    paramContext.startActivity(localIntent);
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 != 0) && ((paramInt2 != 0) || (paramInt3 != 0));
  }
  
  private static boolean a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramInt == 2) {
      return false;
    }
    return (paramInt == 0) || (!"102".equals(((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(paramMessageRecord)));
  }
  
  private static boolean a(int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    return ("102".equals(((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(paramMessageRecord))) && (paramInt2 != 0) && (paramInt1 == 0);
  }
  
  /* Error */
  private static boolean a(@NonNull Context paramContext, MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 402	com/tencent/mobileqq/ecshop/utils/EcshopUtils:e	(Lcom/tencent/mobileqq/data/MessageRecord;)I
    //   4: istore 4
    //   6: aload_1
    //   7: invokestatic 404	com/tencent/mobileqq/ecshop/utils/EcshopUtils:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   10: astore 8
    //   12: iload 4
    //   14: istore 5
    //   16: aload 8
    //   18: astore_1
    //   19: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +101 -> 123
    //   25: new 142	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   32: astore_1
    //   33: aload_1
    //   34: ldc_w 406
    //   37: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_1
    //   42: iload 4
    //   44: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: ldc_w 408
    //   52: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_1
    //   57: aload 8
    //   59: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 154
    //   65: iconst_2
    //   66: aload_1
    //   67: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 162	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: iload 4
    //   75: istore 5
    //   77: aload 8
    //   79: astore_1
    //   80: goto +43 -> 123
    //   83: astore 7
    //   85: aload 8
    //   87: astore_1
    //   88: goto +19 -> 107
    //   91: astore 7
    //   93: ldc 123
    //   95: astore_1
    //   96: goto +11 -> 107
    //   99: astore 7
    //   101: ldc 123
    //   103: astore_1
    //   104: iconst_0
    //   105: istore 4
    //   107: ldc 154
    //   109: iconst_1
    //   110: aload 7
    //   112: iconst_0
    //   113: anewarray 4	java/lang/Object
    //   116: invokestatic 411	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   119: iload 4
    //   121: istore 5
    //   123: iload 5
    //   125: iconst_1
    //   126: if_icmpne +9 -> 135
    //   129: iconst_1
    //   130: istore 6
    //   132: goto +6 -> 138
    //   135: iconst_0
    //   136: istore 6
    //   138: new 142	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   145: astore 7
    //   147: aload 7
    //   149: ldc_w 413
    //   152: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 7
    //   158: iload_2
    //   159: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc 154
    //   165: iconst_2
    //   166: aload 7
    //   168: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 162	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: invokestatic 418	com/tencent/mobileqq/ecshop/conf/EcshopConfProcessor:a	()Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean;
    //   177: astore 7
    //   179: iload_2
    //   180: ifeq +152 -> 332
    //   183: aload 7
    //   185: ifnull +147 -> 332
    //   188: aload 7
    //   190: iload_2
    //   191: invokestatic 420	com/tencent/mobileqq/ecshop/widget/JumpUtil:a	(Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean;I)Lcom/tencent/mobileqq/ecshop/conf/EcshopConfBean$TabConfBean;
    //   194: astore 8
    //   196: aload 8
    //   198: ifnull +134 -> 332
    //   201: aload 8
    //   203: getfield 422	com/tencent/mobileqq/ecshop/conf/EcshopConfBean$TabConfBean:d	Ljava/lang/String;
    //   206: ldc 123
    //   208: invokestatic 423	com/tencent/mobileqq/ecshop/report/ReportUtil:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   211: astore 7
    //   213: aload 8
    //   215: getfield 425	com/tencent/mobileqq/ecshop/conf/EcshopConfBean$TabConfBean:i	I
    //   218: istore 4
    //   220: iload 4
    //   222: ifeq +89 -> 311
    //   225: iload 4
    //   227: iconst_1
    //   228: if_icmpeq +66 -> 294
    //   231: iload 4
    //   233: iconst_2
    //   234: if_icmpeq +23 -> 257
    //   237: iload 4
    //   239: iconst_3
    //   240: if_icmpeq +5 -> 245
    //   243: iconst_0
    //   244: ireturn
    //   245: aload_0
    //   246: iload_2
    //   247: aload 7
    //   249: iload 6
    //   251: aload_1
    //   252: invokestatic 427	com/tencent/mobileqq/ecshop/widget/JumpUtil:a	(Landroid/content/Context;ILjava/lang/String;ZLjava/lang/String;)V
    //   255: iconst_1
    //   256: ireturn
    //   257: ldc_w 429
    //   260: invokestatic 26	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   263: checkcast 429	com/tencent/mobileqq/mini/api/IMiniAppService
    //   266: astore_1
    //   267: aload_1
    //   268: aload 7
    //   270: invokeinterface 432 2 0
    //   275: ifeq +57 -> 332
    //   278: aload_1
    //   279: aload_0
    //   280: aload 7
    //   282: sipush 1035
    //   285: aconst_null
    //   286: invokeinterface 436 5 0
    //   291: pop
    //   292: iconst_1
    //   293: ireturn
    //   294: aload 8
    //   296: getfield 113	com/tencent/mobileqq/ecshop/conf/EcshopConfBean$TabConfBean:b	I
    //   299: iconst_1
    //   300: if_icmpne +32 -> 332
    //   303: aload_0
    //   304: iload 6
    //   306: invokestatic 438	com/tencent/mobileqq/ecshop/widget/JumpUtil:a	(Landroid/content/Context;Z)V
    //   309: iconst_1
    //   310: ireturn
    //   311: aload 7
    //   313: invokestatic 443	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   316: ifne +16 -> 332
    //   319: aload_0
    //   320: iload_2
    //   321: aload 7
    //   323: iload 6
    //   325: aload_1
    //   326: aload_3
    //   327: invokestatic 445	com/tencent/mobileqq/ecshop/widget/JumpUtil:a	(Landroid/content/Context;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V
    //   330: iconst_1
    //   331: ireturn
    //   332: iconst_0
    //   333: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramContext	Context
    //   0	334	1	paramMessageRecord	MessageRecord
    //   0	334	2	paramInt	int
    //   0	334	3	paramString	String
    //   4	237	4	i	int
    //   14	113	5	j	int
    //   130	194	6	bool	boolean
    //   83	1	7	localException1	Exception
    //   91	1	7	localException2	Exception
    //   99	12	7	localException3	Exception
    //   145	177	7	localObject1	Object
    //   10	285	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	73	83	java/lang/Exception
    //   6	12	91	java/lang/Exception
    //   0	6	99	java/lang/Exception
  }
  
  private static boolean a(List<MessageRecord> paramList)
  {
    paramList = paramList.iterator();
    int i;
    MessageRecord localMessageRecord;
    do
    {
      boolean bool = paramList.hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      localMessageRecord = (MessageRecord)paramList.next();
      try
      {
        int j = Integer.parseInt(((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(localMessageRecord));
        i = j;
      }
      catch (Exception localException)
      {
        QLog.e("Ecshop_JumpUtil", 1, localException, new Object[0]);
      }
    } while ((localMessageRecord == null) || (EcshopUtils.d(localMessageRecord) == 1) || (i >= 102));
    return true;
    return false;
  }
  
  private static int b()
  {
    return (int)(c() * 0.56F);
  }
  
  public static void b(@NonNull Context paramContext)
  {
    a(paramContext, true);
  }
  
  public static void b(@NonNull Context paramContext, String paramString)
  {
    boolean bool2 = false;
    try
    {
      boolean bool1;
      if (ListUtils.a(e()))
      {
        bool1 = a(paramContext, null, 2, paramString);
      }
      else
      {
        MessageRecord localMessageRecord = f();
        bool1 = bool2;
        if (localMessageRecord != null)
        {
          String str = QQShopFakeUrlHelper.b(EcshopUtils.a(localMessageRecord));
          int i = EcshopUtils.f(localMessageRecord);
          bool1 = bool2;
          if ("jumpTab".equals(str)) {
            bool1 = a(paramContext, localMessageRecord, i, paramString);
          }
        }
      }
      if (bool1) {
        break label88;
      }
      b(paramContext);
      return;
    }
    catch (Throwable paramString)
    {
      label84:
      label88:
      break label84;
    }
    b(paramContext);
  }
  
  private static void b(@NonNull Context paramContext, String paramString, int paramInt)
  {
    Object localObject1 = f();
    Object localObject3 = EcshopUtils.b((MessageRecord)localObject1);
    Object localObject2 = EcshopUtils.c((MessageRecord)localObject1);
    int i;
    int j;
    if (localObject2 != null)
    {
      i = ((JSONObject)localObject2).optInt("direct_type", 0);
      j = ((JSONObject)localObject2).optInt("is_always_direct", 0);
    }
    else
    {
      j = 0;
      i = 0;
    }
    boolean bool = a(i, j, paramInt);
    localObject2 = e();
    Bundle localBundle = new Bundle();
    SerializableMap localSerializableMap = new SerializableMap();
    localObject3 = a((String)localObject3);
    ((HashMap)localObject3).putAll(EcshopUtils.d(paramString));
    ((HashMap)localObject3).put("tabInfo", ReportUtil.b());
    ((HashMap)localObject3).put("shopMsgHeight", String.valueOf(a(a((List)localObject2), b)));
    if (bool) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    ((HashMap)localObject3).put("needDirectJump", paramString);
    localSerializableMap.wrapMap((HashMap)localObject3);
    paramString = EcshopConfProcessor.a();
    if (paramString != null) {
      localBundle.putString("errorUrl", EcshopUtils.a(paramString.i, (Map)localObject3, false));
    }
    localBundle.putString("bundleName", "qqshop");
    localBundle.putString("domain", "qianbao.qq.com");
    localBundle.putSerializable("qqshopParams", localSerializableMap);
    paramString = new Intent();
    paramString.putExtra("params", localBundle);
    paramString.putExtra("req_qgg_title", EcshopUtils.c());
    if (a(i, (MessageRecord)localObject1)) {
      paramString.putExtra("red_point_num", a((List)localObject2, paramInt));
    }
    paramString.putExtra("need_show_bubble", a(i, (MessageRecord)localObject1, paramInt));
    paramString.putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
    paramString.setFlags(603979776);
    paramInt = 1;
    paramString.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.start(paramContext, paramString, QQShopPAHippyFragment2.class);
    if (bool)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          b(paramContext);
          break label458;
        }
      }
      else
      {
        paramString = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getMessageLandingUrl((MessageRecord)localObject1);
        if (!TextUtils.isEmpty(paramString))
        {
          localObject1 = new Intent(paramContext, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramString);
          ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject1).putExtra("big_brother_source_key", ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId("3046055438"));
          paramContext.startActivity((Intent)localObject1);
          break label458;
        }
      }
      paramInt = 0;
      label458:
      if (((paramContext instanceof Activity)) && (paramInt != 0)) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
    }
  }
  
  private static int c()
  {
    return MobileQQ.sMobileQQ.getResources().getDisplayMetrics().widthPixels - ViewUtils.dip2px(30.0F);
  }
  
  private static String d()
  {
    MessageRecord localMessageRecord = f();
    if (localMessageRecord != null) {
      return ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgType(localMessageRecord);
    }
    return "";
  }
  
  private static List<MessageRecord> e()
  {
    return ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getAIOList("3046055438", 1008);
  }
  
  private static MessageRecord f()
  {
    return ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab("3046055438", 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.JumpUtil
 * JD-Core Version:    0.7.0.1
 */