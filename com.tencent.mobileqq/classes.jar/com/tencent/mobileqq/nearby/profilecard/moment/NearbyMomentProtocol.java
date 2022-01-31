package com.tencent.mobileqq.nearby.profilecard.moment;

import afpt;
import afpu;
import afpv;
import afpw;
import afpx;
import afpy;
import afpz;
import afqa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.nearby.now.protocol.CsTask;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.ilive_feeds_read.ReadNearUserFeedsReq;
import com.tencent.pb.now.ilive_feeds_write.DelFeedReq;
import com.tencent.pb.now.ilive_feeds_write.DelFeedStuct;
import com.tencent.pb.now.ilive_report.ReportReq;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class NearbyMomentProtocol
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, NearbyMomentProtocol.GetMomentListCallback paramGetMomentListCallback)
  {
    ilive_feeds_read.ReadNearUserFeedsReq localReadNearUserFeedsReq = new ilive_feeds_read.ReadNearUserFeedsReq();
    try
    {
      localReadNearUserFeedsReq.uin.set(Long.valueOf(paramString).longValue());
      localReadNearUserFeedsReq.pos.set(paramInt1);
      localReadNearUserFeedsReq.num.set(paramInt2);
      paramString = SosoInterface.b();
      if ((paramString != null) && (paramString.a != null))
      {
        paramString = paramString.a;
        localReadNearUserFeedsReq.lat.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramString.a)));
        localReadNearUserFeedsReq.lng.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramString.b)));
        if (QLog.isColorLevel()) {
          QLog.i("NearbyMomentProtocol", 2, "getMomentList, req.lat=" + paramString.a + ",req.lng=" + paramString.b);
        }
      }
      new CsTask(paramQQAppInterface).a(24624).b(10).a(new afpu(paramInt1, paramGetMomentListCallback)).a(new afpt(paramGetMomentListCallback, paramInt1)).a(localReadNearUserFeedsReq.toByteArray());
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      QLog.i("NearbyMomentProtocol", 1, "getNearbyMomentsList, transfer uin error, uin=" + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, NearbyMomentProtocol.DeleteFeedCallback paramDeleteFeedCallback)
  {
    ilive_feeds_write.DelFeedReq localDelFeedReq = new ilive_feeds_write.DelFeedReq();
    ilive_feeds_write.DelFeedStuct localDelFeedStuct = new ilive_feeds_write.DelFeedStuct();
    localDelFeedStuct.feed_id.set(ByteStringMicro.copyFromUtf8(paramString));
    localDelFeedStuct.timestamp.set(paramLong);
    localDelFeedStuct.feed_type.set(paramInt);
    localDelFeedReq.del_type.set(2);
    localDelFeedReq.select_all.set(0);
    localDelFeedReq.del_st.get().add(localDelFeedStuct);
    localDelFeedReq.uid.set(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue());
    new CsTask(paramQQAppInterface).a(22528).b(5).a(new afpw(paramDeleteFeedCallback, paramString)).a(new afpv(paramDeleteFeedCallback, paramString)).a(localDelFeedReq.toByteArray());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, NearbyMomentProtocol.LikeCallback paramLikeCallback)
  {
    new NowShortVideoProtoManager(paramQQAppInterface).a(paramString, new afpx(paramLikeCallback), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, NearbyMomentProtocol.UnLikeCallback paramUnLikeCallback)
  {
    new NowShortVideoProtoManager(paramQQAppInterface).b(paramString, new afpy(paramUnLikeCallback), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, NearbyMomentProtocol.ReportCallback paramReportCallback)
  {
    ilive_report.ReportReq localReportReq = new ilive_report.ReportReq();
    localReportReq.reporter_uin.set(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue());
    localReportReq.reportee_uin.set(Long.valueOf(paramString3).longValue());
    localReportReq.feedid.set(paramString1);
    localReportReq.client.set(8);
    localReportReq.text.set(paramString2);
    new CsTask(paramQQAppInterface).a(24661).b(1).a(new afqa(paramReportCallback)).a(new afpz(paramReportCallback)).a(localReportReq.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol
 * JD-Core Version:    0.7.0.1
 */