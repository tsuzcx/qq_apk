import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class prp
{
  public static int a;
  public static String a;
  public static final rpn a;
  public static int b;
  
  static
  {
    jdField_a_of_type_Rpn = new rpn();
    b = -1;
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface == null) {
      paramQQAppInterface = null;
    }
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        return paramQQAppInterface;
        localMessageRecord = paramQQAppInterface.getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
        if (localMessageRecord == null) {
          return null;
        }
        paramQQAppInterface = localMessageRecord;
      } while (jdField_a_of_type_Rpn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null);
      paramQQAppInterface = localMessageRecord;
    } while (jdField_a_of_type_Rpn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time < localMessageRecord.time);
    return jdField_a_of_type_Rpn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public static String a(int paramInt)
  {
    String str;
    if (paramInt == qez.a()) {
      str = jdField_a_of_type_Int + "";
    }
    for (;;)
    {
      try
      {
        Integer.parseInt(str);
        return str;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        AIOUtils.catchedExceptionInRelease("RIJKanDianFolderStatus", "fs is not number", localNumberFormatException);
      }
      switch (paramInt)
      {
      default: 
        if (plm.c(paramInt)) {
          str = pin.a();
        }
        break;
      case 0: 
        str = jdField_a_of_type_Int + "";
        break;
      case 70: 
        str = piq.a();
        if (pqf.a() == 6)
        {
          str = jdField_a_of_type_Int + "";
          continue;
          str = jdField_a_of_type_Int + "";
        }
        break;
      }
    }
    return "1";
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return jdField_a_of_type_Rpn.jdField_b_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wording", paramString);
      localJSONObject.put("folder_status", jdField_a_of_type_Int);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static JSONObject a(rpx paramrpx)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", jdField_a_of_type_Int);
        localJSONObject.put("kandian_mode", String.valueOf(pqu.a()));
        localJSONObject.put("tab_source", pqf.a());
        i = -1;
        switch (paramrpx.jdField_a_of_type_Int)
        {
        default: 
          localJSONObject.put("use_type", i);
          if (i == 2)
          {
            l = paramrpx.jdField_b_of_type_Long;
            localJSONObject.put("type_id", l);
            localJSONObject.put("algorithm_id", paramrpx.e);
            return localJSONObject;
          }
          long l = paramrpx.f;
          continue;
          continue;
        }
      }
      catch (JSONException paramrpx)
      {
        paramrpx.printStackTrace();
        return localJSONObject;
      }
      int i = 2;
      continue;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  public static void a()
  {
    j = 0;
    try
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label163;
      }
      localObject = ((QQAppInterface)localObject).getMessageFacade();
      if (localObject == null) {
        break label163;
      }
      localObject = ((QQMessageFacade)localObject).getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((MessageRecord)localObject).extInt != 1)
        {
          if (((MessageRecord)localObject).extInt != 3) {
            break label197;
          }
          i = j;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          boolean bool;
          jdField_a_of_type_Int = Integer.parseInt(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
          if (QLog.isColorLevel()) {
            QLog.d("RIJKanDianFolderStatus", 2, "update mergefolder status " + jdField_a_of_type_Int);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RIJKanDianFolderStatus", 2, "current mergefolder status is " + jdField_a_of_type_Int);
          }
          return;
          if (((MessageRecord)localObject).extInt != 2)
          {
            i = j;
            if (((MessageRecord)localObject).extInt != 4) {
              continue;
            }
            continue;
            if (i == 0)
            {
              jdField_a_of_type_Int = 3;
              continue;
              localException1 = localException1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("RIJKanDianFolderStatus", 2, "obtainMergeKandianFolderStatus except " + localException1.toString());
              continue;
            }
            if (i != 1) {
              continue;
            }
            jdField_a_of_type_Int = 2;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
          int i = 1;
        }
      }
    }
    if ((localObject != null) && (((MessageRecord)localObject).isread))
    {
      jdField_a_of_type_Int = 1;
      if ((localObject instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)localObject;
        if (((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue != null)
        {
          bool = TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
          if (bool) {}
        }
      }
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_Rpn.jdField_a_of_type_Int = jdField_a_of_type_Int;
    SPEventReportSwitch.a(paramInt);
    QLog.d("RIJKanDianFolderStatus", 1, new Object[] { "update fs : ", Integer.valueOf(paramInt) });
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface.getMessageFacade();
    if (localObject == null) {
      return;
    }
    MessageRecord localMessageRecord = ((QQMessageFacade)localObject).getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    localObject = localMessageRecord;
    if (jdField_a_of_type_Rpn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      if (localMessageRecord != null)
      {
        localObject = localMessageRecord;
        if (localMessageRecord.time > jdField_a_of_type_Rpn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time) {}
      }
      else
      {
        localObject = jdField_a_of_type_Rpn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      }
    }
    a(paramQQAppInterface, (MessageRecord)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    b = -1;
    Object localObject3 = (KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    paramQQAppInterface = "";
    Object localObject1 = "";
    Object localObject2 = "";
    int i;
    if (paramMessageRecord != null)
    {
      if (!paramMessageRecord.isread) {
        break label152;
      }
      i = 1;
    }
    for (;;)
    {
      a(i);
      jdField_a_of_type_Rpn.jdField_a_of_type_Int = i;
      jdField_a_of_type_Rpn.jdField_a_of_type_JavaLangString = ((String)localObject1);
      jdField_a_of_type_Rpn.jdField_b_of_type_JavaLangString = paramQQAppInterface;
      jdField_a_of_type_Rpn.c = ((String)localObject2);
      if ((!TextUtils.isEmpty(paramMessageRecord.extStr)) && (!paramMessageRecord.isread)) {}
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              paramQQAppInterface = new JSONObject(paramMessageRecord.extStr);
              jdField_a_of_type_Rpn.jdField_a_of_type_Long = paramQQAppInterface.optLong("sp_last_kadnian_red_pnt_exposure_time_key", 0L);
              long l = paramQQAppInterface.optLong("sp_last_locksc_kadnian_red_pnt_exposure_time_key", -1L);
              if (l > 0L) {
                jdField_a_of_type_Rpn.jdField_a_of_type_Long = l;
              }
            }
            catch (Exception paramQQAppInterface)
            {
              label152:
              Object localObject6;
              Object localObject5;
              MessageForStructing localMessageForStructing;
              Object localObject4;
              paramQQAppInterface.printStackTrace();
              continue;
            }
            jdField_a_of_type_Rpn.jdField_b_of_type_Long = paramMessageRecord.time;
            return;
            if ((paramMessageRecord.extInt != 1) && (paramMessageRecord.extInt != 3)) {
              continue;
            }
            if ((localObject3 != null) && (((KandianMergeManager)localObject3).a(paramMessageRecord) == 1))
            {
              i = 5;
              break;
            }
            localObject6 = paramQQAppInterface;
            localObject5 = localObject1;
            localObject3 = localObject2;
            if ((paramMessageRecord instanceof MessageForStructing))
            {
              localMessageForStructing = (MessageForStructing)paramMessageRecord;
              localMessageForStructing.parse();
              localObject6 = paramQQAppInterface;
              localObject5 = localObject1;
              localObject3 = localObject2;
              if (localMessageForStructing.structingMsg != null)
              {
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mStrategyIds)) {
                  paramQQAppInterface = localMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
                }
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mAlgorithmIds)) {
                  localObject1 = localMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
                }
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mArticleIds)) {
                  localObject2 = localMessageForStructing.structingMsg.mArticleIds.split("\\|")[0];
                }
                localObject6 = paramQQAppInterface;
                localObject5 = localObject1;
                localObject3 = localObject2;
                if (!TextUtils.isEmpty(localMessageForStructing.structingMsg.reportEventFolderStatusValue)) {
                  try
                  {
                    i = Integer.parseInt(localMessageForStructing.structingMsg.reportEventFolderStatusValue);
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                    localObject4 = localObject2;
                    localObject5 = localObject1;
                    localObject6 = paramQQAppInterface;
                  }
                }
              }
            }
          }
          i = 3;
          paramQQAppInterface = (QQAppInterface)localObject6;
          localObject1 = localObject5;
          localObject2 = localObject4;
          break;
          if ((paramMessageRecord.extInt == 2) || (paramMessageRecord.extInt == 4))
          {
            i = 2;
            break;
          }
          if (paramMessageRecord.extInt == 5)
          {
            i = 6;
            break;
          }
          if (paramMessageRecord.extInt != 6) {
            break label576;
          }
          localObject5 = paramQQAppInterface;
          localObject4 = localObject1;
          try
          {
            localObject6 = new JSONObject(paramMessageRecord.extStr);
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            i = ((JSONObject)localObject6).getInt("folder_status");
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            paramQQAppInterface = ((JSONObject)localObject6).getString("strategy_id");
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            localObject1 = ((JSONObject)localObject6).getString("algorithm_id");
            localObject5 = paramQQAppInterface;
            localObject4 = localObject1;
            localObject6 = ((JSONObject)localObject6).getString("article_id");
            localObject2 = localObject6;
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            i = 10;
            paramQQAppInterface = (QQAppInterface)localObject5;
            localObject1 = localObject4;
          }
        }
        break;
        jdField_a_of_type_Rpn.jdField_a_of_type_Long = 0L;
      }
      label576:
      i = 0;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_Rpn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (!paramMessageRecord.isread) && ((paramMessageRecord.extInt == 1) || (paramMessageRecord.extInt == 2) || (paramMessageRecord.extInt == 5) || (paramMessageRecord.extInt == 6)) && ((paramMessageRecord.extLong & 0x1) != 0);
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Rpn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      jdField_a_of_type_Rpn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isread = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prp
 * JD-Core Version:    0.7.0.1
 */