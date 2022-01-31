import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.RedPntInfoForReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import cooperation.readinjoy.ReadInJoyHelper;
import org.json.JSONException;
import org.json.JSONObject;

public final class lkq
  implements Runnable
{
  public lkq(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int i;
    String str4;
    label26:
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo == null)
    {
      i = 1;
      if (i != 3) {
        break label73;
      }
      str4 = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_content.get();
      localObject2 = "";
      if (ReadInJoyHelper.g()) {
        break label781;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject1 != null) {
        break label80;
      }
    }
    label781:
    label825:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo.red_type.get() == 5)
      {
        i = 3;
        break;
      }
      i = 2;
      break;
      label73:
      str4 = "0";
      break label26;
      label80:
      localObject2 = ((QQMessageFacade)localObject1).b(AppConstants.as, 7220);
      if (localObject2 != null)
      {
        if ((ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time >= ((MessageRecord)localObject2).time)) {
          localObject2 = ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        }
        for (;;)
        {
          if ((((MessageRecord)localObject2).isread) || ((((MessageRecord)localObject2).extInt != 1) && (((MessageRecord)localObject2).extInt != 2) && (((MessageRecord)localObject2).extInt != 5) && (((MessageRecord)localObject2).extInt != 6)) || ((((MessageRecord)localObject2).extLong & 0x1) == 0)) {
            break label825;
          }
          ((MessageRecord)localObject2).extLong ^= 0x1;
          try
          {
            if (TextUtils.isEmpty(((MessageRecord)localObject2).extStr)) {
              break label748;
            }
            localObject1 = new JSONObject(((MessageRecord)localObject2).extStr);
            label223:
            ((JSONObject)localObject1).put("sp_last_kadnian_red_pnt_exposure_time_key", NetConnInfoCenter.getServerTime());
            ((MessageRecord)localObject2).extStr = ((JSONObject)localObject1).toString();
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject2).extLong));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, "extStr", ((MessageRecord)localObject2).extStr);
          ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
          String str3;
          if (((MessageRecord)localObject2).extInt == 5)
          {
            localObject1 = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a();
            if (localObject1 != null)
            {
              str3 = String.valueOf(((KandianOx210MsgInfo)localObject1).b);
              localObject1 = String.valueOf(((KandianOx210MsgInfo)localObject1).e);
            }
          }
          for (;;)
          {
            Object localObject4 = ((MessageRecord)localObject2).senderuin;
            try
            {
              JSONObject localJSONObject2 = new JSONObject(((MessageRecord)localObject2).extStr);
              localObject2 = localObject4;
              if (localJSONObject2.has("kdUin")) {
                localObject2 = localJSONObject2.getString("kdUin");
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                localException3.printStackTrace();
                localObject3 = localObject4;
              }
            }
            if (ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int == 1) {
              break;
            }
            ReadInJoyUtils.b(String.valueOf(System.currentTimeMillis()));
            ReadInJoyUtils.jdField_a_of_type_Long = System.currentTimeMillis() / 1000L;
            for (;;)
            {
              try
              {
                localObject4 = new JSONObject();
                ((JSONObject)localObject4).put("folder_status", ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int);
                ((JSONObject)localObject4).put("algorithm_id", ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_JavaLangString);
                ((JSONObject)localObject4).put("strategy_id", ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.b);
                ((JSONObject)localObject4).put("time", System.currentTimeMillis());
                if (ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int == 6)
                {
                  ((JSONObject)localObject4).put("id", str3);
                  ((JSONObject)localObject4).put("social_uin", localObject1);
                }
                if (!ReadInJoyUtils.c()) {
                  continue;
                }
                j = 1;
                ((JSONObject)localObject4).put("message_status", j);
                if (ReadInJoyHelper.K(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
                  continue;
                }
                j = 1;
                ((JSONObject)localObject4).put("reddot_style", j);
                ((JSONObject)localObject4).put("tab_status", i);
                ((JSONObject)localObject4).put("kandian_mode_new", VideoReporter.a());
                if (i == 3) {
                  ((JSONObject)localObject4).put("reddot_num", str4);
                }
                PublicAccountReportUtils.a(null, "CliOper", "", (String)localObject2, "0X80091DC", "0X80091DC", 0, 0, "0", ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.c, ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.b, ((JSONObject)localObject4).toString(), false);
                if (ReadInJoyHelper.h()) {
                  ReadInJoyUtils.a(20, ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.c, ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.b, ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_JavaLangString, (String)localObject2, ReadInJoyUtils.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int);
                }
              }
              catch (JSONException localJSONException)
              {
                int j;
                label748:
                JSONObject localJSONObject1;
                Object localObject3;
                String str1;
                localJSONException.printStackTrace();
                continue;
              }
              if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$RedTypeInfo == null) {
                break;
              }
              try
              {
                localObject1 = ReadInJoyUtils.a();
                ((JSONObject)localObject1).put("kandian_mode", ReadInJoyUtils.e());
                ((JSONObject)localObject1).put("tab_source", ReadInJoyUtils.d());
                PublicAccountReportUtils.a(null, "CliOper", "", null, "0X80081C6", "0X80081C6", 0, 1, null, null, null, ((JSONObject)localObject1).toString(), false);
                return;
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                return;
              }
              localJSONObject1 = new JSONObject();
              break label223;
              if (i == 1) {
                break;
              }
              str1 = "";
              str3 = "";
              continue;
              j = 0;
              continue;
              j = 0;
            }
            String str2 = "";
            str3 = "";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkq
 * JD-Core Version:    0.7.0.1
 */