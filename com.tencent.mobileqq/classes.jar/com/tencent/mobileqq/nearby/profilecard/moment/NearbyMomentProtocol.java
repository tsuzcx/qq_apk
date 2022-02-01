package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.protocol.CsTask;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.pb.now.ilive_feeds_read.ReadNearUserFeedsReq;
import com.tencent.pb.now.ilive_feeds_write.DelFeedReq;
import com.tencent.pb.now.ilive_feeds_write.DelFeedStuct;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class NearbyMomentProtocol
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, NearbyMomentProtocol.GetMomentListCallback paramGetMomentListCallback)
  {
    ilive_feeds_read.ReadNearUserFeedsReq localReadNearUserFeedsReq = new ilive_feeds_read.ReadNearUserFeedsReq();
    localReadNearUserFeedsReq.pos.set(paramInt2);
    localReadNearUserFeedsReq.num.set(paramInt3);
    localReadNearUserFeedsReq.id_type.set(paramInt1);
    localReadNearUserFeedsReq.bus_id.set(paramLong2);
    localReadNearUserFeedsReq.tinyid.set(paramLong1);
    Object localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
    if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
    {
      localObject = ((SosoLbsInfo)localObject).mLocation;
      localReadNearUserFeedsReq.lat.set(ByteStringMicro.copyFromUtf8(String.valueOf(((SosoLocation)localObject).mLat02)));
      localReadNearUserFeedsReq.lng.set(ByteStringMicro.copyFromUtf8(String.valueOf(((SosoLocation)localObject).mLon02)));
      if (QLog.isColorLevel()) {
        QLog.i("NearbyMomentProtocol", 2, "getMomentList, req.lat=" + ((SosoLocation)localObject).mLat02 + ",req.lng=" + ((SosoLocation)localObject).mLon02);
      }
    }
    new CsTask(paramQQAppInterface).a(971).b(1).a(new NearbyMomentProtocol.2(paramInt2, paramGetMomentListCallback)).a(new NearbyMomentProtocol.1(paramGetMomentListCallback, paramInt2)).a(localReadNearUserFeedsReq.toByteArray());
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
    new CsTask(paramQQAppInterface).a(22528).b(5).a(new NearbyMomentProtocol.4(paramDeleteFeedCallback, paramString)).a(new NearbyMomentProtocol.3(paramDeleteFeedCallback, paramString)).a(localDelFeedReq.toByteArray());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, NearbyMomentProtocol.LikeCallback paramLikeCallback)
  {
    new NowShortVideoProtoManager(paramQQAppInterface).a(paramString, new NearbyMomentProtocol.5(paramLikeCallback), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, NearbyMomentProtocol.UnLikeCallback paramUnLikeCallback)
  {
    new NowShortVideoProtoManager(paramQQAppInterface).b(paramString, new NearbyMomentProtocol.6(paramUnLikeCallback), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol
 * JD-Core Version:    0.7.0.1
 */