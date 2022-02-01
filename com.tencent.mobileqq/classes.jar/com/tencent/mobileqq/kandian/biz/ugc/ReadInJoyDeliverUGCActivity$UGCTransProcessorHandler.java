package com.tencent.mobileqq.kandian.biz.ugc;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.repo.handler.RIJPublishTrendsHandler;
import com.tencent.mobileqq.kandian.repo.ugc.DeliverData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ReadInJoyDeliverUGCActivity$UGCTransProcessorHandler
  extends TransProcessorHandler
{
  boolean jdField_a_of_type_Boolean = false;
  
  public ReadInJoyDeliverUGCActivity$UGCTransProcessorHandler(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(FileMsg paramFileMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage: FileMsg.STATUS_SEND_CANCEL.\nfilePath: ");
      localStringBuilder.append(paramFileMsg.filePath);
      localStringBuilder.append("\nfileMd5: ");
      localStringBuilder.append(paramFileMsg.fileMd5);
      localStringBuilder.append("\nfileUrl: ");
      localStringBuilder.append(paramFileMsg.fileUrl);
      localStringBuilder.append("\n");
      QLog.d("ReadInJoyDeliverUGCActivity", 2, localStringBuilder.toString());
    }
  }
  
  private void a(FileMsg paramFileMsg, int paramInt)
  {
    if ((paramInt < ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity)) && (!paramFileMsg.fileUrl.equals(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).a()[paramInt])) && (!paramFileMsg.fileMd5.equals(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).b()[paramInt])))
    {
      List localList = ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).a();
      Object localObject = localList.get(paramInt);
      localObject = ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity, localObject);
      int i = paramInt;
      while (i < localList.size())
      {
        if (a(paramFileMsg, paramInt, localList, (String)localObject, i)) {
          return;
        }
        i += 1;
      }
    }
  }
  
  private boolean a(FileMsg paramFileMsg, int paramInt1, List paramList, String paramString, int paramInt2)
  {
    if (ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).equals(paramList.get(paramInt2))) {
      return true;
    }
    if (paramInt2 == paramInt1)
    {
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).a(paramInt2, paramFileMsg.fileUrl);
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).b(paramInt2, paramFileMsg.fileMd5);
      ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity);
      if (QLog.isColorLevel())
      {
        paramFileMsg = new StringBuilder();
        paramFileMsg.append("finishUp");
        paramFileMsg.append(paramInt2);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, paramFileMsg.toString());
      }
    }
    else if (paramString.equals(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity, paramList.get(paramInt2))))
    {
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).a(paramInt2, paramFileMsg.fileUrl);
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).b(paramInt2, paramFileMsg.fileMd5);
      ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity);
      if (QLog.isColorLevel())
      {
        paramFileMsg = new StringBuilder();
        paramFileMsg.append("finishUp");
        paramFileMsg.append(paramInt2);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, paramFileMsg.toString());
      }
    }
    return false;
  }
  
  private void b(FileMsg paramFileMsg)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = (int)paramFileMsg.uniseq;
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).f(i, NetConnInfoCenter.getServerTimeMillis());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).d()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).c()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).b()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).a()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).e()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).f()[i]));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send error or cancel!");
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity.l();
      paramFileMsg = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity;
      paramFileMsg.a(1, paramFileMsg.getString(2131717876));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity.i();
      ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity, 1002);
    }
  }
  
  private void c(FileMsg paramFileMsg)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = (int)paramFileMsg.uniseq;
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).f(i, NetConnInfoCenter.getServerTimeMillis());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).d()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).c()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).b()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).a()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).e()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).f()[i]));
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send finished!");
      d(paramFileMsg);
      a(paramFileMsg, i);
      if ((ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity) == ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity)) && (!ReadInJoyDeliverUGCActivity.f(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity)))
      {
        ReadInJoyDeliverUGCActivity.e(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity, true);
        new RIJPublishTrendsHandler().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity.c(), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity), this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "allFinishUp");
      }
    }
  }
  
  private void d(FileMsg paramFileMsg)
  {
    try
    {
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).put("picCount", 1);
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramFileMsg.fileUrl);
      localJSONObject.put("md5", paramFileMsg.fileMd5);
      localJSONArray.put(localJSONObject);
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).put("picList", localJSONArray);
      paramFileMsg = new StringBuilder();
      paramFileMsg.append("mTransProcessorHandler resultJson=");
      paramFileMsg.append(((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).replaceUrlInLog(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity).toString()));
      QLog.d("ReadInJoyDeliverUGCActivity", 2, paramFileMsg.toString());
      return;
    }
    catch (Exception paramFileMsg)
    {
      label131:
      break label131;
    }
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler resultJson=log error");
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyDeliverUGCActivity, localFileMsg)) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1005: 
      b(localFileMsg);
      return;
    case 1004: 
      a(localFileMsg);
      return;
    }
    c(localFileMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */