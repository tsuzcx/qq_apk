package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.db.struct.VisibleSetParam;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.feeds_info.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.feeds_info.TagInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVideoInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleSetParam;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfo;

public class RIJCommentInLikeFeedMasterDeliverHandler
  extends RIJCommentInLikeFeedHandler
{
  public RIJCommentInLikeFeedMasterDeliverHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    Object localObject = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l = ((oidb_cmd0x83e.RspBody)localObject).uint64_feeds_id.get();
    paramObject = ((oidb_cmd0x83e.RspBody)localObject).bytes_rowkey.get().toStringUtf8();
    int j = ((oidb_cmd0x83e.RspBody)localObject).uint32_ugc_status.get();
    String str = ((oidb_cmd0x83e.RspBody)localObject).bytes_default_comments.get().toStringUtf8();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0x83eDeliverUpMasterAction result=");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(", feedsId=");
      paramFromServiceMsg.append(l);
      paramFromServiceMsg.append(", rowkey=");
      paramFromServiceMsg.append(paramObject);
      paramFromServiceMsg.append(", status=");
      paramFromServiceMsg.append(j);
      paramFromServiceMsg.append(", comment=");
      paramFromServiceMsg.append(str);
      QLog.d("RIJCommentInLikeFeedMasterDeliverHandler", 1, paramFromServiceMsg.toString());
    }
    paramFromServiceMsg = BaseApplication.getContext().getString(2131915349);
    if (((oidb_cmd0x83e.RspBody)localObject).bytes_result_desc.has())
    {
      paramFromServiceMsg = ((oidb_cmd0x83e.RspBody)localObject).bytes_result_desc.get().toStringUtf8();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle0x83eDeliverUpMasterAction | resp errorMsg ： ");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      QLog.d("RIJCommentInLikeFeedMasterDeliverHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.b.post(new RIJCommentInLikeFeedMasterDeliverHandler.1(this, paramToServiceMsg, i, l, paramObject, j, str, paramFromServiceMsg));
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("requestDeliverUpMasterVideo uin=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", comment=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", bundle=");
      ((StringBuilder)localObject1).append(paramBundle.toString());
      QLog.d("RIJCommentInLikeFeedMasterDeliverHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new oidb_cmd0x83e.ReqBody();
    long l;
    try
    {
      l = Long.parseLong(paramString1);
    }
    catch (Exception paramString1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestDeliverUpMasterVideo: ");
      ((StringBuilder)localObject2).append(paramString1);
      QLog.e("RIJCommentInLikeFeedMasterDeliverHandler", 2, ((StringBuilder)localObject2).toString());
      l = 0L;
    }
    ((oidb_cmd0x83e.ReqBody)localObject1).uint64_uin.set(l);
    ((oidb_cmd0x83e.ReqBody)localObject1).uint32_operation.set(5);
    if (!TextUtils.isEmpty(paramString2)) {
      ((oidb_cmd0x83e.ReqBody)localObject1).bytes_comment.set(ByteStringMicro.copyFromUtf8(paramString2));
    } else {
      ((oidb_cmd0x83e.ReqBody)localObject1).bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
    }
    ((oidb_cmd0x83e.ReqBody)localObject1).bool_is_master.set(true);
    Object localObject2 = new oidb_cmd0x83e.FeedsInfo();
    int i = paramBundle.getInt("arg_ad_tag");
    if (i == 12) {
      ((oidb_cmd0x83e.FeedsInfo)localObject2).feeds_type.set(4);
    } else if (i == 13) {
      ((oidb_cmd0x83e.FeedsInfo)localObject2).feeds_type.set(5);
    }
    paramString1 = paramBundle.getString("arg_ugc_edit_cookie");
    if (!TextUtils.isEmpty(paramString1)) {
      ((oidb_cmd0x83e.ReqBody)localObject1).bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(paramString1));
    } else {
      ((oidb_cmd0x83e.ReqBody)localObject1).bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(""));
    }
    if (paramBoolean2) {
      ((oidb_cmd0x83e.ReqBody)localObject1).enum_ugc_src.set(1);
    }
    paramString1 = new oidb_cmd0x83e.SocializeFeedsInfo();
    Object localObject3 = new feeds_info.SocializeFeedsInfoUser();
    ((feeds_info.SocializeFeedsInfoUser)localObject3).uint64_uin.set(l);
    ((feeds_info.SocializeFeedsInfoUser)localObject3).enum_uin_type.set(0);
    paramString1.msg_master_uin.set((MessageMicro)localObject3);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.bytes_comments.set(ByteStringMicro.copyFromUtf8(paramString2));
    } else {
      paramString1.bytes_comments.set(ByteStringMicro.copyFromUtf8(""));
    }
    if (paramVisibleSetParam != null)
    {
      paramString2 = new feeds_info.VisibleSetParam();
      paramString2.uint32_visible_type.set(paramVisibleSetParam.a());
      paramString2.rpt_uint64_uin.addAll(paramVisibleSetParam.b());
      paramVisibleSetParam = new feeds_info.VisibleInfo();
      paramVisibleSetParam.visible_param.set(paramString2);
      paramString1.visible_info.set(paramVisibleSetParam);
    }
    paramVisibleSetParam = new feeds_info.UGCFeedsInfo();
    localObject3 = paramBundle.getParcelableArrayList("arg_ugc_tag_list");
    paramString2 = paramString1;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        paramString2 = paramString1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramString2 = (TagInfo)((Iterator)localObject3).next();
        localObject4 = new feeds_info.TagInfo();
        ((feeds_info.TagInfo)localObject4).uint64_tag_id.set(paramString2.a());
        ((feeds_info.TagInfo)localObject4).bytes_tag_name.set(ByteStringMicro.copyFromUtf8(paramString2.b()));
        ((feeds_info.TagInfo)localObject4).double_tag_score.set(paramString2.c());
        ((feeds_info.TagInfo)localObject4).uint64_channel.set(paramString2.d());
        paramVisibleSetParam.rpt_msg_tag_info_list.add((MessageMicro)localObject4);
      }
    }
    if (paramArrayList != null)
    {
      paramString1 = new feeds_info.BiuMultiLevel();
      i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        localObject3 = (BiuCommentInfo)paramArrayList.get(i);
        localObject4 = new feeds_info.BiuOneLevelItem();
        try
        {
          ((feeds_info.BiuOneLevelItem)localObject4).uint64_uin.set(Long.valueOf(((BiuCommentInfo)localObject3).mUin.longValue()).longValue());
        }
        catch (Exception localException)
        {
          label650:
          break label650;
        }
        ((feeds_info.BiuOneLevelItem)localObject4).uint64_uin.set(0L);
        ((feeds_info.BiuOneLevelItem)localObject4).bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(((BiuCommentInfo)localObject3).mBiuComment));
        ((feeds_info.BiuOneLevelItem)localObject4).op_type.set(((BiuCommentInfo)localObject3).mOpType);
        if (((BiuCommentInfo)localObject3).jumpInfo != null)
        {
          ((feeds_info.BiuOneLevelItem)localObject4).msg_jump_info.set(new feeds_info.JumpInfo());
          ((feeds_info.BiuOneLevelItem)localObject4).msg_jump_info.uint64_id.set(((BiuCommentInfo)localObject3).jumpInfo.getId());
          ((feeds_info.BiuOneLevelItem)localObject4).msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(((BiuCommentInfo)localObject3).jumpInfo.getWording()));
          ((feeds_info.BiuOneLevelItem)localObject4).msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(((BiuCommentInfo)localObject3).jumpInfo.getJumpUrl()));
        }
        if (((BiuCommentInfo)localObject3).ugcVoiceInfo != null)
        {
          ((feeds_info.BiuOneLevelItem)localObject4).msg_voice_info.set(new feeds_info.UGCVoiceInfo());
          ((feeds_info.BiuOneLevelItem)localObject4).msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(((BiuCommentInfo)localObject3).ugcVoiceInfo.voiceUrl));
          ((feeds_info.BiuOneLevelItem)localObject4).msg_voice_info.uint32_duration.set(((BiuCommentInfo)localObject3).ugcVoiceInfo.duration);
          ((feeds_info.BiuOneLevelItem)localObject4).msg_voice_info.uint32_file_size.set(((BiuCommentInfo)localObject3).ugcVoiceInfo.fileSize);
        }
        paramString1.rpt_biu_mutli_level.add((MessageMicro)localObject4);
        i -= 1;
      }
      paramVisibleSetParam.msg_at_multi_level.set(paramString1);
    }
    else
    {
      if (paramBoolean1) {
        paramVisibleSetParam.enum_ugc_feeds_src.set(1);
      } else {
        paramVisibleSetParam.enum_ugc_feeds_src.set(0);
      }
      localObject3 = new feeds_info.UGCVideoInfo();
      ((feeds_info.UGCVideoInfo)localObject3).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_cover_url", "")));
      ((feeds_info.UGCVideoInfo)localObject3).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_cover_md5", "")));
      ((feeds_info.UGCVideoInfo)localObject3).bytes_video_url.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_url", "")));
      paramArrayList = paramBundle.getString("arg_video_md5", "");
      paramString1 = paramArrayList;
      if (TextUtils.isEmpty(paramArrayList))
      {
        paramArrayList = paramBundle.getString("arg_video_url", "");
        paramString1 = paramArrayList;
        if (TextUtils.isEmpty(paramArrayList)) {
          paramString1 = "12345";
        }
      }
      ((feeds_info.UGCVideoInfo)localObject3).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(paramString1));
      ((feeds_info.UGCVideoInfo)localObject3).bytes_title.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_title", "")));
      ((feeds_info.UGCVideoInfo)localObject3).bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_uuid", "")));
      ((feeds_info.UGCVideoInfo)localObject3).uint64_duration.set(paramBundle.getLong("arg_video_duration"));
      ((feeds_info.UGCVideoInfo)localObject3).uint32_pic_width.set(paramBundle.getInt("arg_video_cover_width"));
      ((feeds_info.UGCVideoInfo)localObject3).uint32_pic_height.set(paramBundle.getInt("arg_video_cover_height"));
      ((feeds_info.UGCVideoInfo)localObject3).uint32_video_width.set(paramBundle.getInt("arg_video_width"));
      ((feeds_info.UGCVideoInfo)localObject3).uint32_video_height.set(paramBundle.getInt("arg_video_height"));
      ((feeds_info.UGCVideoInfo)localObject3).bytes_video_format.set(ByteStringMicro.copyFromUtf8("mp4"));
      paramString1 = new ArrayList();
      paramString1.add(localObject3);
      paramVisibleSetParam.msg_ugc_video_info_list.set(paramString1);
      paramString2.msg_ugc_topic_feeds_info.set(paramVisibleSetParam);
      if (paramTroopBarPOI != null)
      {
        paramString1 = new feeds_info.LocationInfo();
        paramString1.bytes_name.set(ByteStringMicro.copyFromUtf8(paramTroopBarPOI.c));
        paramString1.uint32_longitude.set(paramTroopBarPOI.d);
        paramString1.uint32_latitude.set(paramTroopBarPOI.f);
        paramString2.location_info.set(paramString1);
      }
      ((oidb_cmd0x83e.FeedsInfo)localObject2).msg_social_feeds_info.set(paramString2);
      ((oidb_cmd0x83e.ReqBody)localObject1).msg_feeds_info.set((MessageMicro)localObject2);
      paramString1 = new StringBuilder();
      paramString1.append(String.valueOf(RIJQQAppInterfaceUtil.d()));
      paramString1.append(System.currentTimeMillis());
      paramString1 = paramString1.toString();
      ((oidb_cmd0x83e.ReqBody)localObject1).bytes_req_seq.set(ByteStringMicro.copyFromUtf8(paramString1));
      paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, ((oidb_cmd0x83e.ReqBody)localObject1).toByteArray());
      paramString1.addAttribute("up_master_deliver", Integer.valueOf(1));
      paramString1.addAttribute("up_master_deliver_uuid", paramBundle.getString("up_master_deliver_uuid"));
      this.a.sendPbReqWithAutoRetry(paramString1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedMasterDeliverHandler
 * JD-Core Version:    0.7.0.1
 */