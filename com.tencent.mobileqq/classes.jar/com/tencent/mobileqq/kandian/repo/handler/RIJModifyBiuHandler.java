package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.feeds_info.FeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVoiceInfo;
import tencent.im.oidb.cmd0xc5b.cmd0xc5b.ReqBody;
import tencent.im.oidb.cmd0xc5b.cmd0xc5b.RspBody;

public class RIJModifyBiuHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJModifyBiuHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(long paramLong1, long paramLong2, BiuInfo paramBiuInfo, String paramString)
  {
    cmd0xc5b.ReqBody localReqBody = new cmd0xc5b.ReqBody();
    localReqBody.uint64_feeds_id.set(paramLong2);
    feeds_info.BiuMultiLevel localBiuMultiLevel = new feeds_info.BiuMultiLevel();
    if (paramBiuInfo.b != null) {
      localBiuMultiLevel.uint64_origin_feeds_id.set(paramBiuInfo.b.longValue());
    }
    if (paramBiuInfo.c != null) {
      localBiuMultiLevel.uint64_origin_feeds_type.set(paramBiuInfo.c.longValue());
    }
    paramBiuInfo = paramBiuInfo.a.iterator();
    while (paramBiuInfo.hasNext())
    {
      BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)paramBiuInfo.next();
      feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(localBiuCommentInfo.mBiuComment);
      localBiuOneLevelItem.bytes_biu_comments.set(localByteStringMicro);
      localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.mBiuTime);
      localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.mFeedId.longValue());
      localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.mUin.longValue());
      localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.mFeedsType);
      localBiuOneLevelItem.op_type.set(localBiuCommentInfo.mOpType);
      if (localBiuCommentInfo.jumpInfo != null)
      {
        localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
        localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.jumpInfo.getId());
        localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jumpInfo.getWording()));
        localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jumpInfo.getJumpUrl()));
      }
      if (localBiuCommentInfo.ugcVoiceInfo != null)
      {
        localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
        localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.ugcVoiceInfo.voiceUrl));
        localBiuOneLevelItem.msg_voice_info.uint32_duration.set(localBiuCommentInfo.ugcVoiceInfo.duration);
        localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(localBiuCommentInfo.ugcVoiceInfo.fileSize);
      }
      localBiuMultiLevel.rpt_biu_mutli_level.add(localBiuOneLevelItem);
    }
    paramBiuInfo = new feeds_info.BiuOneLevelItem();
    paramBiuInfo.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(paramString));
    paramBiuInfo.op_type.set(0);
    paramBiuInfo.feeds_type.set(1);
    paramBiuInfo.uint64_feeds_id.set(paramLong2);
    paramBiuInfo.uint64_uin.set(paramLong1);
    localBiuMultiLevel.rpt_biu_mutli_level.add(paramBiuInfo);
    paramBiuInfo = new feeds_info.FeedsInfo();
    paramString = new feeds_info.SocializeFeedsInfo();
    paramString.msg_biu_mutli_level.set(localBiuMultiLevel);
    paramString.msg_biu_mutli_level.set(localBiuMultiLevel);
    paramBiuInfo.msg_social_feeds_info.set(paramString);
    localReqBody.msg_feeds_info.set(paramBiuInfo);
    paramBiuInfo = ReadInJoyOidbHelper.a("OidbSvc.0xc5b_2", 3163, 2, localReqBody.toByteArray());
    this.a.sendPbReqWithAutoRetry(paramBiuInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new cmd0xc5b.RspBody());
    paramToServiceMsg = BaseApplication.getContext().getString(2131893014);
    this.b.post(new RIJModifyBiuHandler.1(this, i, paramToServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJModifyBiuHandler
 * JD-Core Version:    0.7.0.1
 */