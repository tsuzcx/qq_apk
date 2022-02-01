package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.RspBody;

class ReadInJoyDeliverUGCActivity$17
  extends ProtoUtils.TroopProtocolObserver
{
  ReadInJoyDeliverUGCActivity$17(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = this.a;
    paramBundle.e = true;
    if (ReadInJoyDeliverUGCActivity.a(paramBundle) != null) {
      ReadInJoyDeliverUGCActivity.a(this.a).removeCallbacksAndMessages(null);
    }
    this.a.l();
    ReadInJoyDeliverUGCActivity.b(this.a, paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = this.a;
      paramBundle.a(2, paramBundle.getString(2131717881));
      paramBundle = this.a;
      paramBundle.d = -1;
      ReadInJoyDeliverUGCActivity.c(paramBundle, true);
      paramBundle = new oidb_cmd0xf8b.RspBody();
      paramInt = 0;
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        ReadInJoyDeliverUGCActivity.a(this.a).put("rowkey", paramBundle.rowkey.get().toStringUtf8());
        int i = ReadInJoyDeliverUGCActivity.c(this.a);
        if (i == 12) {
          ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 4);
        } else if (ReadInJoyDeliverUGCActivity.c(this.a) == 13) {
          ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 5);
        } else {
          ReadInJoyDeliverUGCActivity.a(this.a).put("feedsType", 4);
        }
      }
      catch (JSONException paramArrayOfByte) {}catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      QLog.d("ReadInJoyDeliverUGCActivity", 2, paramArrayOfByte, new Object[0]);
      if (!ReadInJoyDeliverUGCActivity.b(this.a)) {
        ReadInJoyLogicEngine.a().b(true);
      }
      if (ReadInJoyDeliverUGCActivity.c(this.a))
      {
        paramArrayOfByte = new JSONObject();
        try
        {
          if (ReadInJoyDeliverUGCActivity.d(this.a)) {
            paramInt = 70;
          }
          paramArrayOfByte.put("channel_id", paramInt);
          paramArrayOfByte.put("rowkey", "0");
          paramArrayOfByte.put("topicid", ReadInJoyDeliverUGCActivity.c(this.a));
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800982D", "0X800982D", 0, 0, "", "1", "", paramArrayOfByte.toString(), false);
      }
      if (this.a.jdField_a_of_type_Long != -1L) {
        this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoUgcReadInJoyDraftboxModule.a(this.a.jdField_a_of_type_Long);
      }
      ReadInJoyDeliverUGCActivity.e(this.a);
      this.a.finish();
      return;
    }
    if (paramInt == 33)
    {
      paramArrayOfByte = this.a;
      paramArrayOfByte.a(1, paramArrayOfByte.getResources().getString(2131717876));
      return;
    }
    paramArrayOfByte = this.a;
    paramArrayOfByte.a(1, paramArrayOfByte.getResources().getString(2131717876));
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.17
 * JD-Core Version:    0.7.0.1
 */