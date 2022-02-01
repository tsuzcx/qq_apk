package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ShareWebPageInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendFeedsTitle;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.NowLiveInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.feeds_info.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCPicInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCVideoInfo;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendFeedsTitle;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCPicInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVideoInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVoiceInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfo;

public class RIJCommentInLikeFeedMultiBiuHandler
  extends RIJCommentInLikeFeedHandler
{
  public RIJCommentInLikeFeedMultiBiuHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  private feeds_info.BiuMultiLevel a(BiuInfo paramBiuInfo, ByteStringMicro paramByteStringMicro)
  {
    paramByteStringMicro = new feeds_info.BiuMultiLevel();
    if (paramBiuInfo.b != null) {
      paramByteStringMicro.uint64_origin_feeds_id.set(paramBiuInfo.b.longValue());
    }
    if (paramBiuInfo.c != null) {
      paramByteStringMicro.uint64_origin_feeds_type.set(paramBiuInfo.c.longValue());
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
      paramByteStringMicro.rpt_biu_mutli_level.add(localBiuOneLevelItem);
    }
    return paramByteStringMicro;
  }
  
  private oidb_cmd0x83e.FeedsInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    oidb_cmd0x83e.FeedsInfo localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
    localFeedsInfo.feeds_type.set(paramInt);
    if ((!RIJFeedsType.p(paramAbsBaseArticleInfo)) && (!RIJFeedsType.q(paramAbsBaseArticleInfo)) && (!RIJFeedsType.s(paramAbsBaseArticleInfo)) && (!RIJFeedsType.t(paramAbsBaseArticleInfo))) {
      localFeedsInfo.uint32_business_id.set((int)paramAbsBaseArticleInfo.businessId);
    } else if ((paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.size() > 0)) {
      localFeedsInfo.uint32_business_id.set(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.get(0)).a);
    }
    localFeedsInfo.msg_social_feeds_info.set(paramSocializeFeedsInfo);
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.businessName)) {
      localFeedsInfo.bytes_business_name.set(ByteStringMicro.copyFromUtf8(paramAbsBaseArticleInfo.businessName));
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.businessUrl)) {
      localFeedsInfo.bytes_business_url.set(ByteStringMicro.copyFromUtf8(paramAbsBaseArticleInfo.businessUrl));
    }
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.businessNamePrefix)) {
      localFeedsInfo.bytes_business_name_prefix.set(ByteStringMicro.copyFromUtf8(paramAbsBaseArticleInfo.businessNamePrefix));
    }
    return localFeedsInfo;
  }
  
  private void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.E != null))
    {
      feeds_info.ShareWebPageInfo localShareWebPageInfo = new feeds_info.ShareWebPageInfo();
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.E;
      RIJPBFieldUtils.b(localShareWebPageInfo.bytes_source, paramAbsBaseArticleInfo.d);
      RIJPBFieldUtils.b(localShareWebPageInfo.bytes_title, paramAbsBaseArticleInfo.b);
      RIJPBFieldUtils.b(localShareWebPageInfo.bytes_pic_url, paramAbsBaseArticleInfo.c);
      RIJPBFieldUtils.b(localShareWebPageInfo.bytes_web_url, paramAbsBaseArticleInfo.a);
      paramSocializeFeedsInfo.share_web_page_info.set(localShareWebPageInfo);
    }
  }
  
  private void b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.F != null)) {
      paramSocializeFeedsInfo.now_live_info.set(paramAbsBaseArticleInfo.mSocialFeedInfo.F.a());
    }
  }
  
  private void c(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo.s != null) && (RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)))
    {
      Object localObject1 = paramAbsBaseArticleInfo.mSocialFeedInfo.s;
      paramAbsBaseArticleInfo = new feeds_info.UGCFeedsInfo();
      RIJPBFieldUtils.b(paramAbsBaseArticleInfo.bytes_ugc_comments, ((UGCFeedsInfo)localObject1).f);
      paramAbsBaseArticleInfo.enum_ugc_feeds_card_type.set(((UGCFeedsInfo)localObject1).a);
      paramAbsBaseArticleInfo.uint64_cuin.set(((UGCFeedsInfo)localObject1).e);
      Object localObject2 = ((UGCFeedsInfo)localObject1).b.iterator();
      Object localObject3;
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (UGCPicInfo)((Iterator)localObject2).next();
        localObject4 = new feeds_info.UGCPicInfo();
        ((feeds_info.UGCPicInfo)localObject4).is_animation.set(((UGCPicInfo)localObject3).f);
        ((feeds_info.UGCPicInfo)localObject4).uint32_pic_height.set(((UGCPicInfo)localObject3).b);
        ((feeds_info.UGCPicInfo)localObject4).uint32_pic_width.set(((UGCPicInfo)localObject3).a);
        RIJPBFieldUtils.b(((feeds_info.UGCPicInfo)localObject4).bytes_pic_md5, ((UGCPicInfo)localObject3).c);
        RIJPBFieldUtils.b(((feeds_info.UGCPicInfo)localObject4).bytes_pic_url, ((UGCPicInfo)localObject3).d);
        RIJPBFieldUtils.b(((feeds_info.UGCPicInfo)localObject4).bytes_thumbnail_url, ((UGCPicInfo)localObject3).e);
        paramAbsBaseArticleInfo.msg_ugc_pic_info_list.add((MessageMicro)localObject4);
      }
      localObject2 = ((UGCFeedsInfo)localObject1).d.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (UGCVoiceInfo)((Iterator)localObject2).next();
        localObject4 = new feeds_info.UGCVoiceInfo();
        RIJPBFieldUtils.b(((feeds_info.UGCVoiceInfo)localObject4).bytes_voice_url, ((UGCVoiceInfo)localObject3).voiceUrl);
        ((feeds_info.UGCVoiceInfo)localObject4).uint32_duration.set(((UGCVoiceInfo)localObject3).duration);
        ((feeds_info.UGCVoiceInfo)localObject4).uint32_file_size.set(((UGCVoiceInfo)localObject3).fileSize);
        paramAbsBaseArticleInfo.msg_ugc_voice_info_list.add((MessageMicro)localObject4);
      }
      localObject1 = ((UGCFeedsInfo)localObject1).c.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UGCVideoInfo)((Iterator)localObject1).next();
        localObject3 = new feeds_info.UGCVideoInfo();
        ((feeds_info.UGCVideoInfo)localObject3).uint32_pic_height.set(((UGCVideoInfo)localObject2).k);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_pic_width.set(((UGCVideoInfo)localObject2).j);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_video_height.set(((UGCVideoInfo)localObject2).i);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_video_width.set(((UGCVideoInfo)localObject2).h);
        ((feeds_info.UGCVideoInfo)localObject3).uint64_duration.set(((UGCVideoInfo)localObject2).g);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_create_time.set(((UGCVideoInfo)localObject2).m);
        ((feeds_info.UGCVideoInfo)localObject3).uint32_busi_type.set(((UGCVideoInfo)localObject2).o);
        RIJPBFieldUtils.b(((feeds_info.UGCVideoInfo)localObject3).bytes_pic_md5, ((UGCVideoInfo)localObject2).c);
        RIJPBFieldUtils.b(((feeds_info.UGCVideoInfo)localObject3).bytes_pic_url, ((UGCVideoInfo)localObject2).d);
        RIJPBFieldUtils.b(((feeds_info.UGCVideoInfo)localObject3).bytes_video_md5, ((UGCVideoInfo)localObject2).a);
        RIJPBFieldUtils.b(((feeds_info.UGCVideoInfo)localObject3).bytes_video_url, ((UGCVideoInfo)localObject2).b);
        RIJPBFieldUtils.b(((feeds_info.UGCVideoInfo)localObject3).bytes_title, ((UGCVideoInfo)localObject2).e);
        RIJPBFieldUtils.b(((feeds_info.UGCVideoInfo)localObject3).bytes_uuid, ((UGCVideoInfo)localObject2).f);
        RIJPBFieldUtils.b(((feeds_info.UGCVideoInfo)localObject3).bytes_vid, ((UGCVideoInfo)localObject2).p);
        RIJPBFieldUtils.b(((feeds_info.UGCVideoInfo)localObject3).bytes_share_url, ((UGCVideoInfo)localObject2).n);
        RIJPBFieldUtils.b(((feeds_info.UGCVideoInfo)localObject3).bytes_uniq_id, ((UGCVideoInfo)localObject2).l);
        paramAbsBaseArticleInfo.msg_ugc_video_info_list.add((MessageMicro)localObject3);
      }
      paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(paramAbsBaseArticleInfo);
    }
  }
  
  private void d(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.t;
      feeds_info.PGCFeedsInfo localPGCFeedsInfo = new feeds_info.PGCFeedsInfo();
      Iterator localIterator = paramAbsBaseArticleInfo.a.iterator();
      Object localObject1;
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject1 = (PGCPicInfo)localIterator.next();
        localObject2 = new feeds_info.PGCPicInfo();
        RIJPBFieldUtils.b(((feeds_info.PGCPicInfo)localObject2).bytes_pic_md5, ((PGCPicInfo)localObject1).c);
        RIJPBFieldUtils.b(((feeds_info.PGCPicInfo)localObject2).bytes_pic_url, ((PGCPicInfo)localObject1).d);
        RIJPBFieldUtils.b(((feeds_info.PGCPicInfo)localObject2).bytes_thumbnail_url, ((PGCPicInfo)localObject1).e);
        ((feeds_info.PGCPicInfo)localObject2).is_animation.set(((PGCPicInfo)localObject1).f);
        ((feeds_info.PGCPicInfo)localObject2).uint32_pic_height.set(((PGCPicInfo)localObject1).b);
        ((feeds_info.PGCPicInfo)localObject2).uint32_pic_width.set(((PGCPicInfo)localObject1).a);
        localPGCFeedsInfo.msg_pgc_pic_info_list.add((MessageMicro)localObject2);
      }
      localIterator = paramAbsBaseArticleInfo.b.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (PGCVideoInfo)localIterator.next();
        localObject2 = new feeds_info.PGCVideoInfo();
        RIJPBFieldUtils.b(((feeds_info.PGCVideoInfo)localObject2).bytes_pic_md5, ((PGCVideoInfo)localObject1).c);
        RIJPBFieldUtils.b(((feeds_info.PGCVideoInfo)localObject2).bytes_pic_url, ((PGCVideoInfo)localObject1).d);
        RIJPBFieldUtils.b(((feeds_info.PGCVideoInfo)localObject2).bytes_video_md5, ((PGCVideoInfo)localObject1).a);
        RIJPBFieldUtils.b(((feeds_info.PGCVideoInfo)localObject2).bytes_video_url, ((PGCVideoInfo)localObject1).b);
        localPGCFeedsInfo.msg_pgc_video_info_list.add((MessageMicro)localObject2);
      }
      RIJPBFieldUtils.b(localPGCFeedsInfo.bytes_pgc_comments, paramAbsBaseArticleInfo.c);
      paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(localPGCFeedsInfo);
    }
  }
  
  private void e(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull oidb_cmd0x83e.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo.v != null) && (RIJItemViewTypeUtils.s(paramAbsBaseArticleInfo)))
    {
      feeds_info.TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = new feeds_info.TopicRecommendFeedsInfo();
      localTopicRecommendFeedsInfo.uint32_feeds_style.set(paramAbsBaseArticleInfo.mSocialFeedInfo.v.b);
      localTopicRecommendFeedsInfo.uint64_feeds_id.set(paramAbsBaseArticleInfo.mSocialFeedInfo.v.a);
      Object localObject = new ArrayList();
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.v.g != null)
      {
        Iterator localIterator = paramAbsBaseArticleInfo.mSocialFeedInfo.v.g.iterator();
        while (localIterator.hasNext())
        {
          TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)localIterator.next();
          feeds_info.TopicRecommendInfo localTopicRecommendInfo1 = new feeds_info.TopicRecommendInfo();
          localTopicRecommendInfo1.uint32_number_of_participants.set(localTopicRecommendInfo.e);
          RIJPBFieldUtils.b(localTopicRecommendInfo1.bytes_business_name, localTopicRecommendInfo.b);
          RIJPBFieldUtils.b(localTopicRecommendInfo1.bytes_business_name_prefix, localTopicRecommendInfo.d);
          RIJPBFieldUtils.b(localTopicRecommendInfo1.bytes_business_url, localTopicRecommendInfo.c);
          RIJPBFieldUtils.b(localTopicRecommendInfo1.bytes_pic_url, localTopicRecommendInfo.f);
          localTopicRecommendInfo1.uint32_business_id.set(localTopicRecommendInfo.a);
          ((List)localObject).add(localTopicRecommendInfo1);
        }
      }
      localTopicRecommendFeedsInfo.msg_topic_recommend_info.set((List)localObject);
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.v.e != null)
      {
        localObject = new feeds_info.TopicRecommendFeedsTitle();
        RIJPBFieldUtils.b(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_url, paramAbsBaseArticleInfo.mSocialFeedInfo.v.e.b);
        RIJPBFieldUtils.b(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_title_content, paramAbsBaseArticleInfo.mSocialFeedInfo.v.e.a);
        localTopicRecommendFeedsInfo.msg_left_title.set((MessageMicro)localObject);
      }
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.v.f != null)
      {
        localObject = new feeds_info.TopicRecommendFeedsTitle();
        RIJPBFieldUtils.b(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_url, paramAbsBaseArticleInfo.mSocialFeedInfo.v.f.b);
        RIJPBFieldUtils.b(((feeds_info.TopicRecommendFeedsTitle)localObject).bytes_title_content, paramAbsBaseArticleInfo.mSocialFeedInfo.v.f.a);
        localTopicRecommendFeedsInfo.msg_right_title.set((MessageMicro)localObject);
      }
      RIJPBFieldUtils.b(localTopicRecommendFeedsInfo.bytes_subscribe_id, paramAbsBaseArticleInfo.mSocialFeedInfo.v.d);
      localTopicRecommendFeedsInfo.uint64_uin.set(paramAbsBaseArticleInfo.mSocialFeedInfo.v.c);
      RIJPBFieldUtils.b(localTopicRecommendFeedsInfo.bytes_comments, paramAbsBaseArticleInfo.mSocialFeedInfo.v.h);
      paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(localTopicRecommendFeedsInfo);
    }
  }
  
  public void a(long paramLong1, long paramLong2, BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0x83eBiuDeliverAction result:");
      paramFromServiceMsg.append(i);
      QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 1, paramFromServiceMsg.toString());
    }
    if (i == 0)
    {
      l = ((Long)paramToServiceMsg.getAttribute("BaseArticleSeq")).longValue();
      paramToServiceMsg = this.a.i().a(Integer.valueOf(0), Long.valueOf(l));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.mSocialFeedInfo != null))
      {
        QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 2, new Object[] { "handle0x83eBiuDeliverAction, channel_id = ", Integer.valueOf(0), " articleId = ", Long.valueOf(paramToServiceMsg.mArticleID), " before biu count = ", Integer.valueOf(paramToServiceMsg.mSocialFeedInfo.l) });
        paramFromServiceMsg = paramToServiceMsg.mSocialFeedInfo;
        paramFromServiceMsg.l += 1;
        paramToServiceMsg.invalidateProteusTemplateBean();
        this.a.updateEntity(paramToServiceMsg);
      }
      paramToServiceMsg = this.a.i().a(Integer.valueOf(70), Long.valueOf(l));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.mSocialFeedInfo != null))
      {
        QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 2, new Object[] { "handle0x83eBiuDeliverAction, channel_id = ", Integer.valueOf(70), " articleId = ", Long.valueOf(paramToServiceMsg.mArticleID), " before biu count = ", Integer.valueOf(paramToServiceMsg.mSocialFeedInfo.l) });
        paramFromServiceMsg = paramToServiceMsg.mSocialFeedInfo;
        paramFromServiceMsg.l += 1;
        paramToServiceMsg.invalidateProteusTemplateBean();
        this.a.updateEntity(paramToServiceMsg);
      }
    }
    paramToServiceMsg = BaseApplication.getContext().getString(2131915331);
    if (localRspBody.bytes_result_desc.has())
    {
      paramToServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0x83eBiuDeliverAction | resp errorMsg ： ");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("RIJCommentInLikeFeedMultiBiuHandler", 2, paramFromServiceMsg.toString());
    }
    long l = localRspBody.uint64_feeds_id.get();
    this.b.post(new RIJCommentInLikeFeedMultiBiuHandler.1(this, l, i, paramToServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedMultiBiuHandler
 * JD-Core Version:    0.7.0.1
 */