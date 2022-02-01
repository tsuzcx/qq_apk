package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.ugc.DeliverData;
import com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
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
    paramBundle.v = true;
    if (ReadInJoyDeliverUGCActivity.r(paramBundle) != null) {
      ReadInJoyDeliverUGCActivity.r(this.a).removeCallbacksAndMessages(null);
    }
    this.a.p();
    ReadInJoyDeliverUGCActivity.c(this.a, paramInt);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      paramBundle = this.a;
      paramBundle.a(2, paramBundle.getString(2131915354));
      paramBundle = this.a;
      paramBundle.x = -1;
      ReadInJoyDeliverUGCActivity.c(paramBundle, true);
      paramBundle = new oidb_cmd0xf8b.RspBody();
      int i = 0;
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramBundle = paramBundle.rowkey.get().toStringUtf8();
        try
        {
          ReadInJoyDeliverUGCActivity.s(this.a).put("rowkey", paramBundle);
          int j = this.a.J;
          if (j == 12) {
            ReadInJoyDeliverUGCActivity.s(this.a).put("feedsType", 4);
          } else if (this.a.J == 13) {
            ReadInJoyDeliverUGCActivity.s(this.a).put("feedsType", 5);
          } else {
            ReadInJoyDeliverUGCActivity.s(this.a).put("feedsType", 4);
          }
        }
        catch (JSONException paramArrayOfByte)
        {
          break label220;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          break label220;
        }
        paramBundle = "";
      }
      catch (JSONException paramArrayOfByte) {}catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      label220:
      QLog.d("ReadInJoyDeliverUGCActivity", 2, paramArrayOfByte, new Object[0]);
      if (!ReadInJoyDeliverUGCActivity.t(this.a)) {
        ReadInJoyLogicEngine.a().b(true);
      }
      if (ReadInJoyDeliverUGCActivity.u(this.a))
      {
        paramArrayOfByte = new JSONObject();
        try
        {
          if (ReadInJoyDeliverUGCActivity.v(this.a)) {
            i = 70;
          }
          paramArrayOfByte.put("channel_id", i);
          paramArrayOfByte.put("rowkey", "0");
          paramArrayOfByte.put("topicid", this.a.G);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800982D", "0X800982D", 0, 0, "", "1", "", paramArrayOfByte.toString(), false);
      }
      if (this.a.W != -1L) {
        this.a.V.c(this.a.W);
      }
      ReadInJoyDeliverUGCActivity.w(this.a);
      ReadInJoyDeliverUGCActivity.x(this.a);
      this.a.finish();
    }
    else
    {
      if (paramInt == 33)
      {
        paramArrayOfByte = this.a;
        paramArrayOfByte.a(1, paramArrayOfByte.getResources().getString(2131915349));
      }
      else
      {
        paramArrayOfByte = this.a;
        paramArrayOfByte.a(1, paramArrayOfByte.getResources().getString(2131915349));
        this.a.m();
      }
      paramBundle = "";
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(paramInt, "", this.a.K, RIJEntryViewUtils.a(paramInt, 2, false, ReadInJoyDeliverUGCActivity.n(this.a), Arrays.asList(ReadInJoyDeliverUGCActivity.y(this.a).d()), ReadInJoyDeliverUGCActivity.y(this.a), ReadInJoyDeliverUGCActivity.o(this.a), this.a.T, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.17
 * JD-Core Version:    0.7.0.1
 */