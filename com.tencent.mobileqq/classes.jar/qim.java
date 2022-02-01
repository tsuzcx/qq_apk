import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedMasterDeliverHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.troop.data.TroopBarPOI;
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

public class qim
  extends qil
{
  public qim(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    long l = localRspBody.uint64_feeds_id.get();
    paramObject = localRspBody.bytes_rowkey.get().toStringUtf8();
    int j = localRspBody.uint32_ugc_status.get();
    String str = localRspBody.bytes_default_comments.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentInLikeFeedMasterDeliverHandler", 1, "handle0x83eDeliverUpMasterAction result=" + i + ", feedsId=" + l + ", rowkey=" + paramObject + ", status=" + j + ", comment=" + str);
    }
    paramFromServiceMsg = BaseApplication.getContext().getString(2131717709);
    if (localRspBody.bytes_result_desc.has())
    {
      paramFromServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      QLog.d("RIJCommentInLikeFeedMasterDeliverHandler", 2, "handle0x83eDeliverUpMasterAction | resp errorMsg ： " + paramFromServiceMsg);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJCommentInLikeFeedMasterDeliverHandler.1(this, paramToServiceMsg, i, l, paramObject, j, str, paramFromServiceMsg));
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentInLikeFeedMasterDeliverHandler", 2, "requestDeliverUpMasterVideo uin=" + paramString1 + ", comment=" + paramString2 + ", bundle=" + paramBundle.toString());
    }
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      Object localObject;
      for (;;)
      {
        QLog.e("RIJCommentInLikeFeedMasterDeliverHandler", 2, "requestDeliverUpMasterVideo: " + paramString1);
        continue;
        localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
        continue;
        if (i == 13)
        {
          localFeedsInfo.feeds_type.set(5);
          continue;
          localReqBody.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(""));
          continue;
          localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(""));
        }
      }
      if (paramArrayList == null) {
        break label835;
      }
      paramString1 = new feeds_info.BiuMultiLevel();
      int i = paramArrayList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          paramString2 = (SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(i);
          localObject = new feeds_info.BiuOneLevelItem();
          try
          {
            ((feeds_info.BiuOneLevelItem)localObject).uint64_uin.set(Long.valueOf(paramString2.mUin.longValue()).longValue());
            ((feeds_info.BiuOneLevelItem)localObject).bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(paramString2.mBiuComment));
            ((feeds_info.BiuOneLevelItem)localObject).op_type.set(paramString2.mOpType);
            if (paramString2.jumpInfo != null)
            {
              ((feeds_info.BiuOneLevelItem)localObject).msg_jump_info.set(new feeds_info.JumpInfo());
              ((feeds_info.BiuOneLevelItem)localObject).msg_jump_info.uint64_id.set(paramString2.jumpInfo.getId());
              ((feeds_info.BiuOneLevelItem)localObject).msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(paramString2.jumpInfo.getWording()));
              ((feeds_info.BiuOneLevelItem)localObject).msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramString2.jumpInfo.getJumpUrl()));
            }
            if (paramString2.ugcVoiceInfo != null)
            {
              ((feeds_info.BiuOneLevelItem)localObject).msg_voice_info.set(new feeds_info.UGCVoiceInfo());
              ((feeds_info.BiuOneLevelItem)localObject).msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramString2.ugcVoiceInfo.voiceUrl));
              ((feeds_info.BiuOneLevelItem)localObject).msg_voice_info.uint32_duration.set(paramString2.ugcVoiceInfo.duration);
              ((feeds_info.BiuOneLevelItem)localObject).msg_voice_info.uint32_file_size.set(paramString2.ugcVoiceInfo.fileSize);
            }
            paramString1.rpt_biu_mutli_level.add((MessageMicro)localObject);
            i -= 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ((feeds_info.BiuOneLevelItem)localObject).uint64_uin.set(0L);
            }
          }
        }
      }
      paramVisibleSetParam.msg_at_multi_level.set(paramString1);
      if (!paramBoolean1) {
        break label1313;
      }
    }
    localReqBody.uint64_uin.set(l1);
    localReqBody.uint32_operation.set(5);
    oidb_cmd0x83e.FeedsInfo localFeedsInfo;
    oidb_cmd0x83e.SocializeFeedsInfo localSocializeFeedsInfo;
    if (!TextUtils.isEmpty(paramString2))
    {
      localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(paramString2));
      localReqBody.bool_is_master.set(true);
      localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
      i = paramBundle.getInt("arg_ad_tag");
      if (i != 12) {
        break label485;
      }
      localFeedsInfo.feeds_type.set(4);
      paramString1 = paramBundle.getString("arg_ugc_edit_cookie");
      if (TextUtils.isEmpty(paramString1)) {
        break label504;
      }
      localReqBody.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(paramString1));
      if (paramBoolean2) {
        localReqBody.enum_ugc_src.set(1);
      }
      localSocializeFeedsInfo = new oidb_cmd0x83e.SocializeFeedsInfo();
      paramString1 = new feeds_info.SocializeFeedsInfoUser();
      paramString1.uint64_uin.set(l1);
      paramString1.enum_uin_type.set(0);
      localSocializeFeedsInfo.msg_master_uin.set(paramString1);
      if (TextUtils.isEmpty(paramString2)) {
        break label521;
      }
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(paramString2));
      if (paramVisibleSetParam != null)
      {
        paramString1 = new feeds_info.VisibleSetParam();
        paramString1.uint32_visible_type.set(paramVisibleSetParam.a());
        paramString1.rpt_uint64_uin.addAll(paramVisibleSetParam.a());
        paramString2 = new feeds_info.VisibleInfo();
        paramString2.visible_param.set(paramString1);
        localSocializeFeedsInfo.visible_info.set(paramString2);
      }
      paramVisibleSetParam = new feeds_info.UGCFeedsInfo();
      paramString1 = paramBundle.getParcelableArrayList("arg_ugc_tag_list");
      if (paramString1 == null) {
        break label538;
      }
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (TagInfo)paramString1.next();
        localObject = new feeds_info.TagInfo();
        ((feeds_info.TagInfo)localObject).uint64_tag_id.set(paramString2.a());
        ((feeds_info.TagInfo)localObject).bytes_tag_name.set(ByteStringMicro.copyFromUtf8(paramString2.a()));
        ((feeds_info.TagInfo)localObject).double_tag_score.set(paramString2.a());
        ((feeds_info.TagInfo)localObject).uint64_channel.set(paramString2.b());
        paramVisibleSetParam.rpt_msg_tag_info_list.add((MessageMicro)localObject);
      }
    }
    label485:
    label504:
    paramVisibleSetParam.enum_ugc_feeds_src.set(1);
    for (;;)
    {
      label521:
      label538:
      label835:
      paramArrayList = new feeds_info.UGCVideoInfo();
      paramArrayList.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_cover_url", "")));
      paramArrayList.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_cover_md5", "")));
      paramArrayList.bytes_video_url.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_url", "")));
      paramString2 = paramBundle.getString("arg_video_md5", "");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = paramBundle.getString("arg_video_url", "");
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "12345";
        }
      }
      paramArrayList.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(paramString1));
      paramArrayList.bytes_title.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_title", "")));
      paramArrayList.bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_uuid", "")));
      paramArrayList.uint64_duration.set(paramBundle.getLong("arg_video_duration"));
      paramArrayList.uint32_pic_width.set(paramBundle.getInt("arg_video_cover_width"));
      paramArrayList.uint32_pic_height.set(paramBundle.getInt("arg_video_cover_height"));
      paramArrayList.uint32_video_width.set(paramBundle.getInt("arg_video_width"));
      paramArrayList.uint32_video_height.set(paramBundle.getInt("arg_video_height"));
      paramArrayList.bytes_video_format.set(ByteStringMicro.copyFromUtf8("mp4"));
      paramString1 = new ArrayList();
      paramString1.add(paramArrayList);
      paramVisibleSetParam.msg_ugc_video_info_list.set(paramString1);
      localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(paramVisibleSetParam);
      if (paramTroopBarPOI != null)
      {
        paramString1 = new feeds_info.LocationInfo();
        paramString1.bytes_name.set(ByteStringMicro.copyFromUtf8(paramTroopBarPOI.c));
        paramString1.uint32_longitude.set(paramTroopBarPOI.a);
        paramString1.uint32_latitude.set(paramTroopBarPOI.b);
        localSocializeFeedsInfo.location_info.set(paramString1);
      }
      localFeedsInfo.msg_social_feeds_info.set(localSocializeFeedsInfo);
      localReqBody.msg_feeds_info.set(localFeedsInfo);
      paramString1 = String.valueOf(pkh.a()) + System.currentTimeMillis();
      localReqBody.bytes_req_seq.set(ByteStringMicro.copyFromUtf8(paramString1));
      paramString1 = qxp.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      paramString1.addAttribute("up_master_deliver", Integer.valueOf(1));
      paramString1.addAttribute("up_master_deliver_uuid", paramBundle.getString("up_master_deliver_uuid"));
      this.jdField_a_of_type_Qep.b(paramString1);
      return;
      label1313:
      paramVisibleSetParam.enum_ugc_feeds_src.set(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qim
 * JD-Core Version:    0.7.0.1
 */