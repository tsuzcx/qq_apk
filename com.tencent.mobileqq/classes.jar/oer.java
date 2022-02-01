import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils.1;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;

public class oer
{
  public static int a(long paramLong)
  {
    int i = 0;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      i = oew.a(localAppRuntime, "open_minus_view_cnt_" + paramLong + "_" + a(localAppRuntime));
    }
    return i;
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return 0;
      paramMessageRecord = d(paramMessageRecord);
      if (!bgsp.a(paramMessageRecord)) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("native_ext");
          if (paramMessageRecord != null)
          {
            QLog.i("Ecshop_EcshopUtils", 2, "qggExtJson: " + paramMessageRecord.toString());
            int i = paramMessageRecord.optInt("hide_tabbar", 0);
            return i;
          }
        }
        catch (JSONException paramMessageRecord)
        {
          QLog.e("Ecshop_EcshopUtils", 2, paramMessageRecord, new Object[0]);
        }
      }
    }
    return 0;
  }
  
  public static bcvs a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((paramMessageRecord instanceof StructMsgForGeneralShare))
      {
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        if ((paramMessageRecord.mStructMsgItemLists != null) && (paramMessageRecord.mStructMsgItemLists.size() > 0)) {
          return (bcvs)paramMessageRecord.mStructMsgItemLists.get(0);
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
  
  public static ChatMessage a(List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        Object localObject = a(localChatMessage);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Ecshop_EcshopUtils", 2, "mGdtActionType " + ((bcvs)localObject).c);
          }
          if ((((bcvs)localObject).c == 100) || (!(((bcvs)localObject).a instanceof StructMsgForGeneralShare))) {}
        }
        else
        {
          do
          {
            return localChatMessage;
            localObject = a(localChatMessage);
          } while ((localObject != null) && (!String.valueOf(100).equals(((JSONObject)localObject).optString("action_type"))));
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public static String a()
  {
    String str = "";
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      str = oew.a(localAppRuntime, "qgg_msg_summary_" + a(localAppRuntime));
    }
    return str;
  }
  
  public static String a(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE).format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String a(Context paramContext, Date paramDate)
  {
    int i = 0;
    String str1 = paramContext.getString(2131717462);
    String str2 = paramContext.getString(2131717460);
    String str3 = paramContext.getString(2131717464);
    String str4 = paramContext.getString(2131717465);
    String str5 = paramContext.getString(2131717463);
    String str6 = paramContext.getString(2131717457);
    paramContext = paramContext.getString(2131717461);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int j = localCalendar.get(7) - 1;
    if (j < 0) {}
    for (;;)
    {
      return new String[] { str1, str2, str3, str4, str5, str6, paramContext }[i];
      i = j;
    }
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    bcvs localbcvs = a(paramMessageRecord);
    if (localbcvs != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopUtils", 2, "mGdtActionType " + localbcvs.c);
      }
      if (localbcvs.c == 0) {
        return "";
      }
      return String.valueOf(localbcvs.c);
    }
    paramMessageRecord = a(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("action_type");
  }
  
  public static String a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (bgsp.a(paramString)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str1 = (String)paramMap.get(str2);
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_EcshopUtils", 2, "appendKV2Schema key: " + str2 + " value: " + str1);
        }
        paramString = str1;
        if (paramBoolean) {}
        try
        {
          paramString = URLEncoder.encode(str1);
          if (localStringBuffer.toString().lastIndexOf("?") == -1)
          {
            localStringBuffer.append("?");
            localStringBuffer.append(String.format("%s=%s", new Object[] { str2, paramString }));
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            QLog.i("Ecshop_EcshopUtils", 2, "error encode key: " + str2 + " value: " + str1);
            paramString = str1;
            continue;
            localStringBuffer.append("&");
          }
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    String str = "";
    if ((paramAppRuntime instanceof QQAppInterface)) {
      str = ((QQAppInterface)paramAppRuntime).c();
    }
    while (!(paramAppRuntime instanceof ToolAppRuntime)) {
      return str;
    }
    paramAppRuntime = (ToolAppRuntime)paramAppRuntime;
    return paramAppRuntime.getLongAccountUin() + "";
  }
  
  public static ArrayList<odx> a(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new odx().a((qq_ad.QQAdGetRsp.RedPointInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static Map<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashMap();
    }
    Object localObject = bmsg.a(paramString);
    if (localObject == null) {
      return new HashMap();
    }
    paramString = new HashMap(((Map)localObject).size());
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localEntry != null) {
        paramString.put(localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return paramString;
  }
  
  /* Error */
  public static JSONObject a(MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 345
    //   4: ifeq +90 -> 94
    //   7: aload_0
    //   8: checkcast 345	com/tencent/mobileqq/data/MessageForArkApp
    //   11: astore_1
    //   12: aload_1
    //   13: getfield 349	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +78 -> 96
    //   21: aload_0
    //   22: getfield 355	com/tencent/mobileqq/data/ArkAppMessage:mSourceAd	Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: invokestatic 58	bgsp:a	(Ljava/lang/String;)Z
    //   30: ifne +64 -> 94
    //   33: new 60	org/json/JSONObject
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 63	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: astore_0
    //   42: aload_0
    //   43: ldc_w 357
    //   46: aload_1
    //   47: getfield 360	com/tencent/mobileqq/data/MessageForArkApp:msg	Ljava/lang/String;
    //   50: invokevirtual 363	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   53: pop
    //   54: aload_0
    //   55: areturn
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_0
    //   59: ldc 71
    //   61: iconst_1
    //   62: new 18	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 365
    //   72: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokestatic 369	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   79: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 371	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: areturn
    //   90: astore_1
    //   91: goto -32 -> 59
    //   94: aconst_null
    //   95: areturn
    //   96: ldc 176
    //   98: astore_0
    //   99: goto -73 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramMessageRecord	MessageRecord
    //   11	36	1	localMessageForArkApp	com.tencent.mobileqq.data.MessageForArkApp
    //   56	20	1	localException1	Exception
    //   90	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   26	42	56	java/lang/Exception
    //   42	54	90	java/lang/Exception
  }
  
  public static void a(int paramInt, boolean paramBoolean) {}
  
  public static void a(long paramLong)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      oew.a(localAppRuntime, "open_minus_view_cnt_" + paramLong + "_" + a(localAppRuntime));
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      oew.a(localAppRuntime, "open_minus_view_cnt_" + paramLong + "_" + a(localAppRuntime), paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.excute(new EcshopUtils.1(paramQQAppInterface), 16, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    try
    {
      if ((a(paramQQAppInterface)) && (!bgsp.a(a())))
      {
        paramMsgSummary.suffix = "";
        paramMsgSummary.strContent = a();
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("Ecshop_EcshopUtils", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopUtils", 2, "qggSummary: " + paramString);
    }
    if (!bgsp.a(paramString)) {
      b(paramString);
    }
    while (BaseApplicationImpl.getApplication() == null) {
      return;
    }
    b(BaseApplicationImpl.getApplication().getString(2131691678));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = paramQQAppInterface.a().b("3046055438", 1008);
      if (paramQQAppInterface == null) {
        return false;
      }
      int i = a(paramQQAppInterface.uniseq);
      int j = oen.a().b;
      if (i >= j) {
        return true;
      }
    }
    catch (Throwable paramQQAppInterface) {}
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return String.valueOf(100).equals(paramString);
  }
  
  public static int b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return 1;
      paramMessageRecord = d(paramMessageRecord);
      if (!bgsp.a(paramMessageRecord)) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord).optJSONObject("native_ext");
          if (paramMessageRecord != null)
          {
            int i = paramMessageRecord.optInt("tab_id", 1);
            return i;
          }
        }
        catch (JSONException paramMessageRecord)
        {
          QLog.e("Ecshop_EcshopUtils", 2, paramMessageRecord, new Object[0]);
        }
      }
    }
    return 1;
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    paramMessageRecord = d(paramMessageRecord);
    if (bgsp.a(paramMessageRecord)) {
      return "";
    }
    try
    {
      paramMessageRecord = new JSONObject(paramMessageRecord).optString("page_type");
      return paramMessageRecord;
    }
    catch (JSONException paramMessageRecord)
    {
      QLog.e("Ecshop_EcshopUtils", 2, paramMessageRecord, new Object[0]);
    }
    return "";
  }
  
  private static void b(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      oew.a(localAppRuntime, "qgg_msg_summary_" + a(localAppRuntime), paramString);
    }
  }
  
  public static boolean b(String paramString)
  {
    return String.valueOf(1).equals(paramString);
  }
  
  public static int c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return 0;
      paramMessageRecord = d(paramMessageRecord);
    } while (bgsp.a(paramMessageRecord));
    try
    {
      int i = new JSONObject(paramMessageRecord).optInt("is_hidden");
      return i;
    }
    catch (JSONException paramMessageRecord)
    {
      QLog.e("Ecshop_EcshopUtils", 2, paramMessageRecord, new Object[0]);
    }
    return 0;
  }
  
  public static String c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    paramMessageRecord = d(paramMessageRecord);
    if (bgsp.a(paramMessageRecord)) {
      return "";
    }
    try
    {
      paramMessageRecord = new JSONObject(paramMessageRecord).optString("web_ext");
      return paramMessageRecord;
    }
    catch (JSONException paramMessageRecord)
    {
      QLog.e("Ecshop_EcshopUtils", 2, paramMessageRecord, new Object[0]);
    }
    return "";
  }
  
  private static String d(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    bcvs localbcvs = a(paramMessageRecord);
    if (localbcvs != null)
    {
      if (localbcvs.W == null) {
        return "";
      }
      return localbcvs.W;
    }
    paramMessageRecord = a(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("qgg_ext");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oer
 * JD-Core Version:    0.7.0.1
 */