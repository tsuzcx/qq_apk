import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport.2;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class pqc
{
  public static int a;
  public static long a;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("jumpType", 0);
        return i;
      }
      catch (JSONException paramString)
      {
        QLog.e("RIJKanDianTabReport", 1, "getReportLoadModeFromLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  public static String a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        paramString = new BigInteger(paramString);
        QLog.d("RIJKanDianTabReport", 2, new Object[] { "convertArticleID bigInteger long value = ", Long.valueOf(paramString.longValue()) });
        return "" + paramString.longValue();
        paramString = "0";
      }
      return "0";
    }
    catch (Exception paramString)
    {
      QLog.d("RIJKanDianTabReport", 1, new Object[] { "convertArticleID e = ", paramString.toString() });
    }
  }
  
  public static void a()
  {
    if (!ReadinjoyTabFrame.d_()) {
      a(false);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new RIJKanDianTabReport.2(paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (!bmhv.l()) {
      return;
    }
    a(paramQQAppInterface);
    ThreadManager.executeOnSubThread(new RIJKanDianTabReport.1(paramRedTypeInfo, paramQQAppInterface));
  }
  
  public static void a(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        if (pnn.a() == null) {
          break label257;
        }
        if (!bmhv.l()) {
          return;
        }
        Object localObject = (KandianMergeManager)pnn.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        JSONObject localJSONObject = pqf.a();
        if ((!((KandianMergeManager)localObject).a()) && (!((KandianMergeManager)localObject).i()))
        {
          i = 1;
          if (i != 3) {
            break label241;
          }
          localObject = ((KandianMergeManager)localObject).f() + "";
          localJSONObject.put("tab_status", i);
          localJSONObject.put("kandian_mode_new", omx.a());
          if (i == 3) {
            localJSONObject.put("reddot_num", localObject);
          }
          a(true, localJSONObject);
          if (jdField_a_of_type_Int != 0) {
            break label247;
          }
          i = 0;
          localJSONObject.put("button_state", i);
          localJSONObject.put("os", 1);
          localJSONObject.put("version", omx.jdField_a_of_type_JavaLangString);
          if (!ReadinjoyTabFrame.d_()) {
            break label252;
          }
          i = 1;
          localJSONObject.put("isInKandian", i);
          pqd.a.a(localJSONObject);
          if (oqy.a != null) {
            localJSONObject.put("channel_id", oqy.a.mChannelCoverId);
          }
          olh.a(null, "CliOper", "", null, "0X80081C3", "0X80081C3", 0, 1, null, a(prp.a.c), prp.a.b, localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      if (localJSONException.f() > 0)
      {
        i = 3;
        continue;
        label241:
        String str = "0";
        continue;
        label247:
        i = 1;
        continue;
        label252:
        i = 0;
      }
      else
      {
        label257:
        i = 2;
      }
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int j = 1;
    Object localObject1 = (QQAppInterface)pnn.a();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = ((QQAppInterface)localObject1).getMessageFacade();
      } while (localObject1 == null);
      localObject2 = ((QQMessageFacade)localObject1).getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    } while (localObject2 == null);
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localObject2;
      if (((MessageForStructing)localObject1).structingMsg == null) {
        ((MessageForStructing)localObject1).parse();
      }
    }
    for (;;)
    {
      int i;
      if (!paramBoolean)
      {
        i = 1;
        label80:
        if (((MessageRecord)localObject2).isread) {
          break label209;
        }
      }
      for (;;)
      {
        for (;;)
        {
          if ((i | j) == 0) {
            break label212;
          }
          String str = ((MessageRecord)localObject2).senderuin;
          try
          {
            localObject2 = new JSONObject(((MessageRecord)localObject2).extStr);
            if (((JSONObject)localObject2).has("kdUin")) {
              str = ((JSONObject)localObject2).getString("kdUin");
            }
            paramJSONObject.put("feeds_source", str);
            if ((localObject1 == null) || (((MessageForStructing)localObject1).structingMsg == null)) {
              break;
            }
            paramJSONObject.put("load_mode", a(((MessageForStructing)localObject1).structingMsg.mExtraData));
            paramJSONObject.put("push_type", b(((MessageForStructing)localObject1).structingMsg.mExtraData));
            return;
          }
          catch (Exception paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return;
          }
        }
        i = 0;
        break label80;
        label209:
        j = 0;
      }
      label212:
      break;
      localObject1 = null;
    }
  }
  
  public static int b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("contentType", 0);
        return i;
      }
      catch (JSONException paramString)
      {
        QLog.e("RIJKanDianTabReport", 1, "getReportPushTypeFromeLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  private static void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo != null) {}
    try
    {
      paramRedTypeInfo = pqf.a();
      paramRedTypeInfo.put("kandian_mode", pqu.a());
      paramRedTypeInfo.put("tab_source", pqf.a());
      olh.a(null, "CliOper", "", null, "0X80081C6", "0X80081C6", 0, 1, null, null, null, paramRedTypeInfo.toString(), false);
      return;
    }
    catch (Exception paramRedTypeInfo)
    {
      paramRedTypeInfo.printStackTrace();
    }
  }
  
  private static void b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", prp.a.jdField_a_of_type_Int);
        localJSONObject.put("algorithm_id", prp.a.jdField_a_of_type_JavaLangString);
        localJSONObject.put("strategy_id", prp.a.b);
        localJSONObject.put("time", System.currentTimeMillis());
        if (prp.a.jdField_a_of_type_Int == 6)
        {
          localJSONObject.put("id", paramString1);
          localJSONObject.put("social_uin", paramString2);
        }
        if (pqf.a())
        {
          i = 1;
          localJSONObject.put("message_status", i);
          if (bmhv.C(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label329;
          }
          i = 1;
          localJSONObject.put("reddot_style", i);
          localJSONObject.put("tab_status", paramInt);
          localJSONObject.put("kandian_mode_new", omx.a());
          if (paramInt == 3) {
            localJSONObject.put("reddot_num", paramString3);
          }
          olh.a(null, "CliOper", "", paramString4, "0X80091DC", "0X80091DC", 0, 0, "0", a(prp.a.c), prp.a.b, localJSONObject.toString(), false);
          if (bmhv.n()) {
            pqb.a(20, a(prp.a.c), prp.a.b, prp.a.jdField_a_of_type_JavaLangString, paramString4, prp.a.jdField_a_of_type_Int);
          }
          ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b();
          if (prp.a.jdField_a_of_type_Int == 6)
          {
            QLog.d("RIJKanDianTabReport", 1, "feedsPreload, social num red point, do not preload.");
            return;
          }
          QLog.d("RIJKanDianTabReport", 1, "feedsPreload, small red point exposed.");
          qkq.a().a(true);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.d("RIJKanDianTabReport", 1, "red point expose, e = ", paramString1);
        return;
      }
      int i = 0;
      continue;
      label329:
      i = 0;
    }
  }
  
  private static boolean b()
  {
    if (prp.a.jdField_a_of_type_Int == 1) {
      return true;
    }
    prp.a(String.valueOf(System.currentTimeMillis()));
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L;
    return false;
  }
  
  private static String d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt == 5)
    {
      paramQQAppInterface = ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
      if (paramQQAppInterface != null) {
        return String.valueOf(paramQQAppInterface.mMsgType);
      }
    }
    return "";
  }
  
  private static String e(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt == 5)
    {
      paramQQAppInterface = ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
      if (paramQQAppInterface != null) {
        return String.valueOf(paramQQAppInterface.mUin);
      }
    }
    return "";
  }
  
  /* Error */
  private static String f(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_1
    //   2: getfield 428	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   5: iconst_1
    //   6: ixor
    //   7: putfield 428	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   10: aload_1
    //   11: getfield 282	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   14: invokestatic 21	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +136 -> 153
    //   20: new 23	org/json/JSONObject
    //   23: dup
    //   24: aload_1
    //   25: getfield 282	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   28: invokespecial 27	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: aload_2
    //   33: ldc_w 430
    //   36: invokestatic 435	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   39: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   42: pop
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 235	org/json/JSONObject:toString	()Ljava/lang/String;
    //   48: putfield 282	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   51: aload_1
    //   52: getfield 279	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   55: astore_3
    //   56: new 23	org/json/JSONObject
    //   59: dup
    //   60: aload_1
    //   61: getfield 282	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   64: invokespecial 27	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   67: astore 4
    //   69: aload_3
    //   70: astore_2
    //   71: aload 4
    //   73: ldc_w 284
    //   76: invokevirtual 288	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   79: ifeq +12 -> 91
    //   82: aload 4
    //   84: ldc_w 284
    //   87: invokevirtual 291	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_2
    //   91: aload_0
    //   92: invokevirtual 250	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   95: aload_1
    //   96: getfield 438	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   99: aload_1
    //   100: getfield 441	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   103: aload_1
    //   104: getfield 444	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   107: ldc_w 445
    //   110: aload_1
    //   111: getfield 428	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   114: invokestatic 450	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokevirtual 454	com/tencent/imcore/message/QQMessageFacade:updateMsgFieldByUniseq	(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Object;)V
    //   120: aload_0
    //   121: invokevirtual 250	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   124: aload_1
    //   125: getfield 438	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   128: aload_1
    //   129: getfield 441	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   132: aload_1
    //   133: getfield 444	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   136: ldc_w 455
    //   139: aload_1
    //   140: getfield 282	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   143: invokevirtual 454	com/tencent/imcore/message/QQMessageFacade:updateMsgFieldByUniseq	(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Object;)V
    //   146: aload_0
    //   147: aload_1
    //   148: invokestatic 458	prp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   151: aload_2
    //   152: areturn
    //   153: new 23	org/json/JSONObject
    //   156: dup
    //   157: invokespecial 326	org/json/JSONObject:<init>	()V
    //   160: astore_2
    //   161: goto -129 -> 32
    //   164: astore_3
    //   165: ldc 75
    //   167: astore_2
    //   168: aload_3
    //   169: invokevirtual 307	java/lang/Exception:printStackTrace	()V
    //   172: goto -81 -> 91
    //   175: astore 4
    //   177: aload_3
    //   178: astore_2
    //   179: aload 4
    //   181: astore_3
    //   182: goto -14 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramQQAppInterface	QQAppInterface
    //   0	185	1	paramMessageRecord	MessageRecord
    //   31	148	2	localObject1	Object
    //   55	15	3	str	String
    //   164	14	3	localException1	Exception
    //   181	1	3	localObject2	Object
    //   67	16	4	localJSONObject	JSONObject
    //   175	5	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   10	32	164	java/lang/Exception
    //   32	56	164	java/lang/Exception
    //   153	161	164	java/lang/Exception
    //   56	69	175	java/lang/Exception
    //   71	91	175	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqc
 * JD-Core Version:    0.7.0.1
 */