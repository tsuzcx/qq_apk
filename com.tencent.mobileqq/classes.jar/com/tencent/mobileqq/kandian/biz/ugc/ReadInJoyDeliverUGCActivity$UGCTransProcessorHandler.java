package com.tencent.mobileqq.kandian.biz.ugc;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.impl.RIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.repo.handler.RIJPublishTrendsHandler;
import com.tencent.mobileqq.kandian.repo.ugc.DeliverData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ReadInJoyDeliverUGCActivity$UGCTransProcessorHandler
  extends TransProcessorHandler
{
  boolean a = false;
  
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
    if ((paramInt < ReadInJoyDeliverUGCActivity.d(this.b)) && (!paramFileMsg.fileUrl.equals(ReadInJoyDeliverUGCActivity.y(this.b).d()[paramInt])) && (!paramFileMsg.fileMd5.equals(ReadInJoyDeliverUGCActivity.y(this.b).e()[paramInt])))
    {
      List localList = ReadInJoyDeliverUGCActivity.b(this.b).b();
      Object localObject = localList.get(paramInt);
      localObject = ReadInJoyDeliverUGCActivity.b(this.b, localObject);
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
    if (ReadInJoyDeliverUGCActivity.a(this.b).equals(paramList.get(paramInt2))) {
      return true;
    }
    if (paramInt2 == paramInt1)
    {
      ReadInJoyDeliverUGCActivity.y(this.b).a(paramInt2, paramFileMsg.fileUrl);
      ReadInJoyDeliverUGCActivity.y(this.b).b(paramInt2, paramFileMsg.fileMd5);
      ReadInJoyDeliverUGCActivity.D(this.b);
      if (QLog.isColorLevel())
      {
        paramFileMsg = new StringBuilder();
        paramFileMsg.append("finishUp");
        paramFileMsg.append(paramInt2);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, paramFileMsg.toString());
      }
    }
    else if (paramString.equals(ReadInJoyDeliverUGCActivity.b(this.b, paramList.get(paramInt2))))
    {
      ReadInJoyDeliverUGCActivity.y(this.b).a(paramInt2, paramFileMsg.fileUrl);
      ReadInJoyDeliverUGCActivity.y(this.b).b(paramInt2, paramFileMsg.fileMd5);
      ReadInJoyDeliverUGCActivity.D(this.b);
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
    if (this.a)
    {
      int i = (int)paramFileMsg.uniseq;
      ReadInJoyDeliverUGCActivity.C(this.b).f(i, NetConnInfoCenter.getServerTimeMillis());
      PublicAccountReportUtils.a(this.b.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.C(this.b).d()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.C(this.b).c()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.C(this.b).b()[i] - ReadInJoyDeliverUGCActivity.C(this.b).a()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.C(this.b).e()[i] - ReadInJoyDeliverUGCActivity.C(this.b).f()[i]));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send error or cancel!");
      }
      this.b.p();
      paramFileMsg = this.b;
      paramFileMsg.a(1, paramFileMsg.getString(2131915349));
      this.b.m();
      ReadInJoyDeliverUGCActivity.c(this.b, 1002);
    }
  }
  
  private void c(FileMsg paramFileMsg)
  {
    if (this.a)
    {
      int i = (int)paramFileMsg.uniseq;
      ReadInJoyDeliverUGCActivity.C(this.b).f(i, NetConnInfoCenter.getServerTimeMillis());
      PublicAccountReportUtils.a(this.b.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.C(this.b).d()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.C(this.b).c()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.C(this.b).b()[i] - ReadInJoyDeliverUGCActivity.C(this.b).a()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.C(this.b).e()[i] - ReadInJoyDeliverUGCActivity.C(this.b).f()[i]));
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send finished!");
      d(paramFileMsg);
      a(paramFileMsg, i);
      if ((ReadInJoyDeliverUGCActivity.p(this.b) == ReadInJoyDeliverUGCActivity.d(this.b)) && (!ReadInJoyDeliverUGCActivity.B(this.b)))
      {
        ReadInJoyDeliverUGCActivity.e(this.b, true);
        new RIJPublishTrendsHandler().a(this.b.k(), ReadInJoyDeliverUGCActivity.n(this.b), ReadInJoyDeliverUGCActivity.p(this.b), ReadInJoyDeliverUGCActivity.y(this.b), ReadInJoyDeliverUGCActivity.e(this.b), this.b.T, this.b.b);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "allFinishUp");
      }
    }
  }
  
  private void d(FileMsg paramFileMsg)
  {
    try
    {
      ReadInJoyDeliverUGCActivity.s(this.b).put("picCount", 1);
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramFileMsg.fileUrl);
      localJSONObject.put("md5", paramFileMsg.fileMd5);
      localJSONArray.put(localJSONObject);
      ReadInJoyDeliverUGCActivity.s(this.b).put("picList", localJSONArray);
      paramFileMsg = new StringBuilder();
      paramFileMsg.append("mTransProcessorHandler resultJson=");
      paramFileMsg.append(RIJDeliverUGCUtils.INSTANCE.replaceUrlInLog(ReadInJoyDeliverUGCActivity.s(this.b).toString()));
      QLog.d("ReadInJoyDeliverUGCActivity", 2, paramFileMsg.toString());
      return;
    }
    catch (Exception paramFileMsg)
    {
      label123:
      break label123;
    }
    QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler resultJson=log error");
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (ReadInJoyDeliverUGCActivity.a(this.b, localFileMsg)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */