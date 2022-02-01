package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.db.struct.VisibleSetParam;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AccountProfileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.feeds_info.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.feeds_info.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCPicInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleSetParam;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfo;

public class RIJCommentInLikeFeedUgcDeliverHandler
  extends RIJCommentInLikeFeedHandler
{
  public RIJCommentInLikeFeedUgcDeliverHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    Object localObject = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l = ((oidb_cmd0x83e.RspBody)localObject).uint64_feeds_id.get();
    paramFromServiceMsg = ((oidb_cmd0x83e.RspBody)localObject).bytes_rowkey.get().toStringUtf8();
    int j = ((oidb_cmd0x83e.RspBody)localObject).uint32_ugc_status.get();
    paramObject = ((oidb_cmd0x83e.RspBody)localObject).bytes_default_comments.get().toStringUtf8();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0x83eDeliverUGCAction result=");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(", feedsId=");
      paramToServiceMsg.append(l);
      paramToServiceMsg.append(", rowkey=");
      paramToServiceMsg.append(paramFromServiceMsg);
      paramToServiceMsg.append(", status=");
      paramToServiceMsg.append(j);
      paramToServiceMsg.append(", comment=");
      paramToServiceMsg.append(paramObject);
      QLog.d("RIJCommentInLikeFeedUgcDeliverHandler", 1, paramToServiceMsg.toString());
    }
    paramToServiceMsg = BaseApplication.getContext().getString(2131915349);
    if (((oidb_cmd0x83e.RspBody)localObject).bytes_result_desc.has())
    {
      paramToServiceMsg = ((oidb_cmd0x83e.RspBody)localObject).bytes_result_desc.get().toStringUtf8();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle0x83eDeliverUGCAction | resp errorMsg ： ");
      ((StringBuilder)localObject).append(paramToServiceMsg);
      QLog.d("RIJCommentInLikeFeedUgcDeliverHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.b.post(new RIJCommentInLikeFeedUgcDeliverHandler.1(this, i, l, paramFromServiceMsg, j, paramObject, paramToServiceMsg));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String paramString5, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, AccountProfileInfo paramAccountProfileInfo, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestDeliverUGC uin=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", topicId=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", adtag=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(paramList);
      ((StringBuilder)localObject).append(", comment=");
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append(", pic=, width=");
      ((StringBuilder)localObject).append(paramArrayOfInt1);
      ((StringBuilder)localObject).append(", height=");
      ((StringBuilder)localObject).append(paramArrayOfInt2);
      ((StringBuilder)localObject).append(", md5=");
      ((StringBuilder)localObject).append(paramArrayOfString2);
      ((StringBuilder)localObject).append(", isGif=is from dian dian = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("location = ");
      if (paramTroopBarPOI != null) {
        paramString2 = String.format("(name:%s,lat:%s,long:%s)", new Object[] { paramTroopBarPOI.c, Integer.valueOf(paramTroopBarPOI.f), Integer.valueOf(paramTroopBarPOI.d) });
      } else {
        paramString2 = "null";
      }
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("visibleSetParam: ");
      ((StringBuilder)localObject).append(paramVisibleSetParam);
      QLog.d("RIJCommentInLikeFeedUgcDeliverHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramString2 = new oidb_cmd0x83e.ReqBody();
    long l;
    try
    {
      l = Long.parseLong(paramString1);
    }
    catch (Exception paramString1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestDeliverUGC: ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.e("RIJCommentInLikeFeedUgcDeliverHandler", 2, ((StringBuilder)localObject).toString());
      l = 0L;
    }
    paramString2.uint64_uin.set(l);
    paramString2.uint32_operation.set(5);
    if (!TextUtils.isEmpty(paramString4)) {
      paramString2.bytes_comment.set(ByteStringMicro.copyFromUtf8(paramString4));
    } else {
      paramString2.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramString2.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(paramString3));
    } else {
      paramString2.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(""));
    }
    paramString2.bool_is_master.set(true);
    Object localObject = new oidb_cmd0x83e.FeedsInfo();
    if (paramInt1 == 12) {
      ((oidb_cmd0x83e.FeedsInfo)localObject).feeds_type.set(4);
    } else if (paramInt1 == 13) {
      ((oidb_cmd0x83e.FeedsInfo)localObject).feeds_type.set(5);
    } else if (paramInt1 == 21) {
      ((oidb_cmd0x83e.FeedsInfo)localObject).feeds_type.set(25);
    }
    if (paramBoolean) {
      paramString2.enum_ugc_src.set(1);
    }
    paramString3 = new oidb_cmd0x83e.SocializeFeedsInfo();
    paramString1 = new feeds_info.SocializeFeedsInfoUser();
    paramString1.uint64_uin.set(l);
    paramString1.enum_uin_type.set(0);
    paramString3.msg_master_uin.set(paramString1);
    if (!TextUtils.isEmpty(paramString4)) {
      paramString3.bytes_comments.set(ByteStringMicro.copyFromUtf8(paramString4));
    } else {
      paramString3.bytes_comments.set(ByteStringMicro.copyFromUtf8(""));
    }
    if (paramVisibleSetParam != null)
    {
      paramString1 = new feeds_info.VisibleSetParam();
      paramString1.uint32_visible_type.set(paramVisibleSetParam.a());
      paramString1.rpt_uint64_uin.addAll(paramVisibleSetParam.b());
      paramString4 = new feeds_info.VisibleInfo();
      paramString4.visible_param.set(paramString1);
      paramString3.visible_info.set(paramString4);
    }
    paramString4 = new feeds_info.UGCFeedsInfo();
    int i;
    if (paramArrayList != null)
    {
      paramVisibleSetParam = new feeds_info.BiuMultiLevel();
      i = paramArrayList.size() - 1;
      paramString1 = paramString2;
      paramString2 = paramString3;
      while (i >= 0)
      {
        paramString3 = (BiuCommentInfo)paramArrayList.get(i);
        feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
        try
        {
          localPBUInt64Field = localBiuOneLevelItem.uint64_uin;
        }
        catch (Exception localException1)
        {
          PBUInt64Field localPBUInt64Field;
          Long localLong;
          label703:
          label706:
          break label706;
        }
        try
        {
          localLong = paramString3.mUin;
        }
        catch (Exception localException2)
        {
          break label703;
        }
        try
        {
          localPBUInt64Field.set(localLong.longValue());
        }
        catch (Exception localException3)
        {
          break label706;
        }
        localBiuOneLevelItem.uint64_uin.set(0L);
        localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(paramString3.mBiuComment));
        localBiuOneLevelItem.op_type.set(paramString3.mOpType);
        if (paramString3.jumpInfo != null)
        {
          localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
          localBiuOneLevelItem.msg_jump_info.uint64_id.set(paramString3.jumpInfo.getId());
          localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(paramString3.jumpInfo.getWording()));
          localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramString3.jumpInfo.getJumpUrl()));
        }
        if (paramString3.ugcVoiceInfo != null)
        {
          localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
          localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramString3.ugcVoiceInfo.voiceUrl));
          localBiuOneLevelItem.msg_voice_info.uint32_duration.set(paramString3.ugcVoiceInfo.duration);
          localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(paramString3.ugcVoiceInfo.fileSize);
        }
        paramVisibleSetParam.rpt_biu_mutli_level.add(localBiuOneLevelItem);
        i -= 1;
      }
      paramString4.msg_at_multi_level.set(paramVisibleSetParam);
    }
    else
    {
      paramString1 = paramString2;
      paramString2 = paramString3;
    }
    if (paramInt2 > 0)
    {
      paramString3 = new ArrayList();
      i = 0;
      while (i < paramInt2)
      {
        paramArrayList = new feeds_info.UGCPicInfo();
        paramArrayList.uint32_pic_width.set(paramArrayOfInt1[i]);
        paramArrayList.uint32_pic_height.set(paramArrayOfInt2[i]);
        paramArrayList.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(paramArrayOfString2[i]));
        paramArrayList.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(paramArrayOfString1[i]));
        if (((Integer)paramList.get(i)).intValue() == 2) {
          paramArrayList.bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(paramArrayOfString1[i]));
        }
        paramVisibleSetParam = paramArrayList.is_animation;
        int j;
        if (((Integer)paramList.get(i)).intValue() == 2) {
          j = 1;
        } else {
          j = 0;
        }
        paramVisibleSetParam.set(j);
        paramVisibleSetParam = paramArrayList.uint32_pic_type;
        if (((Integer)paramList.get(i)).intValue() == 2) {
          j = 2;
        } else {
          j = 1;
        }
        paramVisibleSetParam.set(j);
        paramArrayList.bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(paramString5));
        paramString3.add(paramArrayList);
        i += 1;
      }
      paramString4.msg_ugc_pic_info_list.set(paramString3);
    }
    paramString4.uint32_ugc_feeds_type.set(paramInt3);
    if ((paramInt1 == 21) && (paramAccountProfileInfo != null))
    {
      paramString3 = new feeds_info.AccountProfile();
      paramString3.bytes_desc.set(ByteStringMicro.copyFromUtf8(paramAccountProfileInfo.e));
      paramString3.bytes_nick.set(ByteStringMicro.copyFromUtf8(paramAccountProfileInfo.c));
      paramString3.bytes_profile_photo_url.set(ByteStringMicro.copyFromUtf8(paramAccountProfileInfo.d));
      paramString3.uint64_uin.set(paramAccountProfileInfo.a);
      paramString3.uint32_account_type.set(paramAccountProfileInfo.b);
      paramString4.account_profile.set(paramString3);
      paramString4.enum_ugc_feeds_src.set(6);
    }
    paramString2.msg_ugc_topic_feeds_info.set(paramString4);
    if (paramTroopBarPOI != null)
    {
      paramString3 = new feeds_info.LocationInfo();
      paramString3.bytes_name.set(ByteStringMicro.copyFromUtf8(paramTroopBarPOI.c));
      paramString3.uint32_longitude.set(paramTroopBarPOI.d);
      paramString3.uint32_latitude.set(paramTroopBarPOI.f);
      paramString2.location_info.set(paramString3);
    }
    ((oidb_cmd0x83e.FeedsInfo)localObject).msg_social_feeds_info.set(paramString2);
    paramString1.msg_feeds_info.set((MessageMicro)localObject);
    paramString2 = new StringBuilder();
    paramString2.append(String.valueOf(RIJQQAppInterfaceUtil.d()));
    paramString2.append(System.currentTimeMillis());
    paramString2 = paramString2.toString();
    paramString1.bytes_req_seq.set(ByteStringMicro.copyFromUtf8(paramString2));
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, paramString1.toByteArray());
    paramString1.addAttribute("ugc_deliver", Integer.valueOf(1));
    this.a.sendPbReqWithAutoRetry(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedUgcDeliverHandler
 * JD-Core Version:    0.7.0.1
 */