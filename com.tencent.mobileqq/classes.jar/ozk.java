import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KandianSubscribeReportUtils.1;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ozk
{
  private static Map<String, String> a = new HashMap();
  
  static
  {
    b();
  }
  
  public static String a()
  {
    String str2 = (String)a.get("folder_status");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    else
    {
      str1 = "1";
    }
    return str1;
  }
  
  private static String a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForStructing))) {}
    do
    {
      return null;
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      paramMessageRecord.parse();
    } while ((paramMessageRecord.structingMsg == null) || (TextUtils.isEmpty(paramMessageRecord.structingMsg.mExtraData)));
    try
    {
      paramMessageRecord = new JSONObject(paramMessageRecord.structingMsg.mExtraData).optString("uin", "");
      return paramMessageRecord;
    }
    catch (JSONException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return null;
  }
  
  public static Map<String, String> a()
  {
    return a;
  }
  
  public static void a()
  {
    Object localObject = (QQAppInterface)pay.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQAppInterface)localObject).getMessageFacade().getLastMsgForMsgTab(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    } while ((localObject == null) || (((MessageRecord)localObject).isread) || (((MessageRecord)localObject).extLong != 1));
    ThreadManager.post(new KandianSubscribeReportUtils.1((MessageRecord)localObject), 8, null, false);
    a("0X80093FF", (MessageRecord)localObject);
    b();
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    a("0X8009400", paramMessageRecord);
  }
  
  private static void a(String paramString, MessageRecord paramMessageRecord)
  {
    int k = 1;
    String str3 = a(paramMessageRecord);
    String str4 = ugf.a(AppConstants.KANDIAN_SUBSCRIBE_UIN) + "";
    Object localObject3 = KandianRedDotInfo.createRedDotFromMessageRecord(paramMessageRecord, "kandian_dt_red_dot_info");
    Object localObject1;
    String str1;
    Object localObject4;
    String str2;
    if (localObject3 != null) {
      if ((((KandianRedDotInfo)localObject3).articleIDList != null) && (!((KandianRedDotInfo)localObject3).articleIDList.isEmpty()))
      {
        localObject1 = ((KandianRedDotInfo)localObject3).articleIDList.get(0) + "";
        str1 = ((KandianRedDotInfo)localObject3).strategyID + "";
        localObject4 = ((KandianRedDotInfo)localObject3).forderStatus;
        str2 = ((KandianRedDotInfo)localObject3).algorithmID + "";
        localObject3 = localObject1;
        localObject1 = localObject4;
      }
    }
    for (;;)
    {
      localObject4 = localObject1;
      if ("0X8009400".equals(paramString))
      {
        localObject4 = localObject1;
        if (paramMessageRecord.isread) {
          localObject4 = "0";
        }
      }
      int i;
      if (ugf.b(AppConstants.KANDIAN_SUBSCRIBE_UIN) > 0)
      {
        i = 1;
        label200:
        if (!"1".equals(paramMessageRecord.getExtInfoFromExtStr("public_account_msg_unread_flag"))) {
          break label325;
        }
      }
      label325:
      for (int j = 0;; j = 1)
      {
        paramMessageRecord = new JSONObject();
        try
        {
          paramMessageRecord.put("folder_status", localObject4);
          paramMessageRecord.put("message_status", i);
          paramMessageRecord.put("algorithm_id", str2);
          paramMessageRecord.put("reddot_style", j);
          paramMessageRecord.put("os", "1");
          i = k;
          if (TextUtils.isEmpty(str3)) {
            i = 0;
          }
          paramMessageRecord.put("avatar", i);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        odq.a(null, "CliOper", "", str3, paramString, paramString, 0, 0, str4, (String)localObject3, str1, paramMessageRecord.toString(), false);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label200;
      }
      str2 = null;
      Object localObject2 = null;
      str1 = null;
      localObject3 = null;
    }
  }
  
  private static Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("folder_status", "1");
    localHashMap.put("algorithm_id", "0");
    localHashMap.put("strategy_id", "0");
    localHashMap.put("action_data", "");
    Object localObject = (QQAppInterface)pay.a();
    if (localObject == null) {
      return localHashMap;
    }
    localObject = ((QQAppInterface)localObject).getMessageFacade();
    if (localObject == null) {
      return localHashMap;
    }
    localObject = ((QQMessageFacade)localObject).getLastMsgForMsgTab(AppConstants.KANDIAN_SUBSCRIBE_UIN, 1008);
    if (localObject == null) {
      return localHashMap;
    }
    if (((MessageRecord)localObject).isread) {
      return localHashMap;
    }
    if ((localObject instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)localObject;
      if (!((MessageForStructing)localObject).mIsParsed) {
        ((MessageForStructing)localObject).parse();
      }
      if (((MessageForStructing)localObject).structingMsg == null) {
        return localHashMap;
      }
      localHashMap.put("folder_status", ((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
      localHashMap.put("algorithm_id", ((MessageForStructing)localObject).structingMsg.mAlgorithmIds);
      localHashMap.put("strategy_id", ((MessageForStructing)localObject).structingMsg.mStrategyIds);
      localHashMap.put("action_data", ((MessageForStructing)localObject).structingMsg.mMsgAction);
    }
    return localHashMap;
  }
  
  public static void b()
  {
    Map localMap = b();
    if (localMap != null)
    {
      a = localMap;
      QLog.d(ozk.class.getSimpleName(), 2, "update kandian subscribe red pnt info success ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ozk
 * JD-Core Version:    0.7.0.1
 */