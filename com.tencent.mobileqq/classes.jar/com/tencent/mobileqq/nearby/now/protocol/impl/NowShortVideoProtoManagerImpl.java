package com.tencent.mobileqq.nearby.now.protocol.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager.Callback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailReq;
import com.tencent.pb.now.LbsShare.LocationReq;
import com.tencent.pb.now.ilive_feeds_like.FeedsLikeReq;
import com.tencent.pb.now.ilive_feeds_like.FeedsUnLikeReq;
import com.tencent.pb.now.ilive_feeds_source.CollectFeedsDataReq;
import com.tencent.pb.now.ilive_new_anchor_follow_interface.FollowActionReq;
import com.tencent.pb.now.ilive_short_video_label.GetShortVideoVideoLabelReq;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;

public class NowShortVideoProtoManagerImpl
  implements INowShortVideoProtoManager
{
  public static final int ACTION_FOLLOW = 1;
  public static final int ACTION_UNFOLLOW = 2;
  public static final short CMD_CS_ADD_SHORT_VIDEO_FEEDS = 24608;
  public static final short CMD_CS_APPLY_SHORT_VIDEO = 24592;
  AppInterface mApp = null;
  
  private boolean configCommonFileds(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.mApp.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.mApp.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.mApp.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("8.7.0");
      paramReqBody.original_id.set(this.mApp.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public void feedsLike(String paramString, INowShortVideoProtoManager.Callback paramCallback, Bundle paramBundle)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (configCommonFileds(localReqBody))
    {
      localReqBody.cmd.set(24640);
      localReqBody.subcmd.set(1);
      ilive_feeds_like.FeedsLikeReq localFeedsLikeReq = new ilive_feeds_like.FeedsLikeReq();
      localFeedsLikeReq.id.set(ByteStringMicro.copyFromUtf8(paramString));
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localFeedsLikeReq.toByteArray()));
      ProtoUtils.a(this.mApp, new NowShortVideoProtoManagerImpl.1(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, paramBundle, 0L);
    }
  }
  
  public void feedsUnLike(String paramString, INowShortVideoProtoManager.Callback paramCallback, Bundle paramBundle)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (configCommonFileds(localReqBody))
    {
      localReqBody.cmd.set(24640);
      localReqBody.subcmd.set(2);
      ilive_feeds_like.FeedsUnLikeReq localFeedsUnLikeReq = new ilive_feeds_like.FeedsUnLikeReq();
      localFeedsUnLikeReq.id.set(ByteStringMicro.copyFromUtf8(paramString));
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localFeedsUnLikeReq.toByteArray()));
      ProtoUtils.a(this.mApp, new NowShortVideoProtoManagerImpl.3(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, paramBundle, 0L);
    }
  }
  
  public void follow(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean, INowShortVideoProtoManager.Callback paramCallback)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (configCommonFileds(localReqBody))
    {
      localReqBody.cmd.set(536);
      localReqBody.subcmd.set(64);
      ilive_new_anchor_follow_interface.FollowActionReq localFollowActionReq = new ilive_new_anchor_follow_interface.FollowActionReq();
      localFollowActionReq.anchor_uin.set(paramLong1);
      localFollowActionReq.client_type.set(401);
      localFollowActionReq.source.set(paramInt2);
      PBUInt32Field localPBUInt32Field = localFollowActionReq.action;
      if (paramBoolean) {
        paramInt2 = 1;
      } else {
        paramInt2 = 2;
      }
      localPBUInt32Field.set(paramInt2);
      localFollowActionReq.anchor_nowid.set(paramLong2);
      localFollowActionReq.id_type.set(paramInt1);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localFollowActionReq.toByteArray()));
      ProtoUtils.a(this.mApp, new NowShortVideoProtoManagerImpl.5(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
  
  public void getLbsShareInfo(Object paramObject, INowShortVideoProtoManager.Callback paramCallback)
  {
    paramObject = (LbsShare.LocationReq)paramObject;
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (configCommonFileds(localReqBody))
    {
      localReqBody.cmd.set(21296);
      localReqBody.subcmd.set(1);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(paramObject.toByteArray()));
      ProtoUtils.a(this.mApp, new NowShortVideoProtoManagerImpl.7(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
  
  public void getMediaDetailInfo(String paramString, INowShortVideoProtoManager.Callback paramCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mQueryString = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("getMediaDetailInfo", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new oidb_0xada.ReqBody();
    if (configCommonFileds((oidb_0xada.ReqBody)localObject1))
    {
      ((oidb_0xada.ReqBody)localObject1).cmd.set(30577);
      Object localObject2 = ((oidb_0xada.ReqBody)localObject1).subcmd;
      int i = 1;
      ((PBUInt32Field)localObject2).set(1);
      localObject2 = new FeedsProtocol.GetMediaDetailReq();
      ((FeedsProtocol.GetMediaDetailReq)localObject2).querystring.set(ByteStringMicro.copyFrom(paramString.getBytes()));
      ((oidb_0xada.ReqBody)localObject1).busi_buf.set(ByteStringMicro.copyFrom(((FeedsProtocol.GetMediaDetailReq)localObject2).toByteArray()));
      localObject2 = (INearbyCardManager)this.mApp.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      PBUInt32Field localPBUInt32Field = ((oidb_0xada.ReqBody)localObject1).buss_id;
      if (((INearbyCardManager)localObject2).a() > 0L) {
        i = 0;
      }
      localPBUInt32Field.set(i);
      ProtoUtils.a(this.mApp, new NowShortVideoProtoManagerImpl.4(this, paramString, paramCallback), ((oidb_0xada.ReqBody)localObject1).toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
  
  public void getShortLabel(long paramLong, String paramString, INowShortVideoProtoManager.Callback paramCallback)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (configCommonFileds(localReqBody))
    {
      localReqBody.cmd.set(30481);
      localReqBody.subcmd.set(1);
      ilive_short_video_label.GetShortVideoVideoLabelReq localGetShortVideoVideoLabelReq = new ilive_short_video_label.GetShortVideoVideoLabelReq();
      if (!TextUtils.isEmpty(paramString)) {
        localGetShortVideoVideoLabelReq.feed_id.set(ByteStringMicro.copyFromUtf8(paramString));
      }
      localGetShortVideoVideoLabelReq.uid.set(paramLong);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetShortVideoVideoLabelReq.toByteArray()));
      ProtoUtils.a(this.mApp, new NowShortVideoProtoManagerImpl.6(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
  
  public NowShortVideoProtoManagerImpl init(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    return this;
  }
  
  public void reportPlay(String paramString, INowShortVideoProtoManager.Callback paramCallback)
  {
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (configCommonFileds(localReqBody))
    {
      localReqBody.cmd.set(24640);
      localReqBody.subcmd.set(3);
      ilive_feeds_source.CollectFeedsDataReq localCollectFeedsDataReq = new ilive_feeds_source.CollectFeedsDataReq();
      localCollectFeedsDataReq.client_type.set(2);
      localCollectFeedsDataReq.feeds_id.set(ByteStringMicro.copyFromUtf8(paramString));
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localCollectFeedsDataReq.toByteArray()));
      ProtoUtils.a(this.mApp, new NowShortVideoProtoManagerImpl.2(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.protocol.impl.NowShortVideoProtoManagerImpl
 * JD-Core Version:    0.7.0.1
 */