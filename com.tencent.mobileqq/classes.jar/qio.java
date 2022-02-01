import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedUgcDeliverHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.troop.data.TroopBarPOI;
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

public class qio
  extends qil
{
  public qio(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    long l = localRspBody.uint64_feeds_id.get();
    paramFromServiceMsg = localRspBody.bytes_rowkey.get().toStringUtf8();
    int j = localRspBody.uint32_ugc_status.get();
    paramObject = localRspBody.bytes_default_comments.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentInLikeFeedUgcDeliverHandler", 1, "handle0x83eDeliverUGCAction result=" + i + ", feedsId=" + l + ", rowkey=" + paramFromServiceMsg + ", status=" + j + ", comment=" + paramObject);
    }
    paramToServiceMsg = BaseApplication.getContext().getString(2131717709);
    if (localRspBody.bytes_result_desc.has())
    {
      paramToServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      QLog.d("RIJCommentInLikeFeedUgcDeliverHandler", 2, "handle0x83eDeliverUGCAction | resp errorMsg ： " + paramToServiceMsg);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJCommentInLikeFeedUgcDeliverHandler.1(this, i, l, paramFromServiceMsg, j, paramObject, paramToServiceMsg));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String paramString5, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, rqt paramrqt, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("requestDeliverUGC uin=").append(paramString1).append(", topicId=").append(paramString2).append(", adtag=").append(paramInt1).append(", type=").append(paramList).append(", comment=").append(paramString4).append(", pic=, width=").append(paramArrayOfInt1).append(", height=").append(paramArrayOfInt2).append(", md5=").append(paramArrayOfString2).append(", isGif=is from dian dian = ").append(paramBoolean).append("location = ");
      if (paramTroopBarPOI == null) {
        break label722;
      }
      paramString2 = String.format("(name:%s,lat:%s,long:%s)", new Object[] { paramTroopBarPOI.c, Integer.valueOf(paramTroopBarPOI.b), Integer.valueOf(paramTroopBarPOI.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      QLog.d("RIJCommentInLikeFeedUgcDeliverHandler", 2, paramString2 + "visibleSetParam: " + paramVisibleSetParam);
      paramString2 = new oidb_cmd0x83e.ReqBody();
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(paramString1);
        l1 = l2;
        paramString2.uint64_uin.set(l1);
        paramString2.uint32_operation.set(5);
        if (!TextUtils.isEmpty(paramString4))
        {
          paramString2.bytes_comment.set(ByteStringMicro.copyFromUtf8(paramString4));
          if (TextUtils.isEmpty(paramString3)) {
            break label775;
          }
          paramString2.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(paramString3));
          paramString2.bool_is_master.set(true);
          paramString1 = new oidb_cmd0x83e.FeedsInfo();
          if (paramInt1 != 12) {
            break label791;
          }
          paramString1.feeds_type.set(4);
          if (paramBoolean) {
            paramString2.enum_ugc_src.set(1);
          }
          paramString3 = new oidb_cmd0x83e.SocializeFeedsInfo();
          localObject = new feeds_info.SocializeFeedsInfoUser();
          ((feeds_info.SocializeFeedsInfoUser)localObject).uint64_uin.set(l1);
          ((feeds_info.SocializeFeedsInfoUser)localObject).enum_uin_type.set(0);
          paramString3.msg_master_uin.set((MessageMicro)localObject);
          if (TextUtils.isEmpty(paramString4)) {
            break label828;
          }
          paramString3.bytes_comments.set(ByteStringMicro.copyFromUtf8(paramString4));
          if (paramVisibleSetParam != null)
          {
            paramString4 = new feeds_info.VisibleSetParam();
            paramString4.uint32_visible_type.set(paramVisibleSetParam.a());
            paramString4.rpt_uint64_uin.addAll(paramVisibleSetParam.a());
            paramVisibleSetParam = new feeds_info.VisibleInfo();
            paramVisibleSetParam.visible_param.set(paramString4);
            paramString3.visible_info.set(paramVisibleSetParam);
          }
          paramString4 = new feeds_info.UGCFeedsInfo();
          if (paramArrayList == null) {
            break label868;
          }
          paramVisibleSetParam = new feeds_info.BiuMultiLevel();
          i = paramArrayList.size() - 1;
          if (i < 0) {
            break label858;
          }
          localObject = (SocializeFeedsInfo.BiuCommentInfo)paramArrayList.get(i);
          localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
        }
      }
      catch (Exception paramString1)
      {
        int i;
        try
        {
          for (;;)
          {
            localBiuOneLevelItem.uint64_uin.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).mUin.longValue());
            localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.BiuCommentInfo)localObject).mBiuComment));
            localBiuOneLevelItem.op_type.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).mOpType);
            if (((SocializeFeedsInfo.BiuCommentInfo)localObject).jumpInfo != null)
            {
              localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
              localBiuOneLevelItem.msg_jump_info.uint64_id.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).jumpInfo.getId());
              localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.BiuCommentInfo)localObject).jumpInfo.getWording()));
              localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.BiuCommentInfo)localObject).jumpInfo.getJumpUrl()));
            }
            if (((SocializeFeedsInfo.BiuCommentInfo)localObject).ugcVoiceInfo != null)
            {
              localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
              localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.BiuCommentInfo)localObject).ugcVoiceInfo.voiceUrl));
              localBiuOneLevelItem.msg_voice_info.uint32_duration.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).ugcVoiceInfo.duration);
              localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(((SocializeFeedsInfo.BiuCommentInfo)localObject).ugcVoiceInfo.fileSize);
            }
            paramVisibleSetParam.rpt_biu_mutli_level.add(localBiuOneLevelItem);
            i -= 1;
            continue;
            label722:
            paramString2 = "null";
            break;
            paramString1 = paramString1;
            QLog.e("RIJCommentInLikeFeedUgcDeliverHandler", 2, "requestDeliverUGC: " + paramString1);
            continue;
            paramString2.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
            continue;
            label775:
            paramString2.bytes_extra_json_params.set(ByteStringMicro.copyFromUtf8(""));
            continue;
            label791:
            if (paramInt1 == 13) {
              paramString1.feeds_type.set(5);
            } else if (paramInt1 == 21) {
              paramString1.feeds_type.set(25);
            }
          }
          label828:
          paramString3.bytes_comments.set(ByteStringMicro.copyFromUtf8(""));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            feeds_info.BiuOneLevelItem localBiuOneLevelItem;
            localBiuOneLevelItem.uint64_uin.set(0L);
          }
        }
        label858:
        paramString4.msg_at_multi_level.set(paramVisibleSetParam);
        label868:
        if (paramInt2 > 0)
        {
          paramArrayList = new ArrayList();
          i = 0;
          if (i < paramInt2)
          {
            paramVisibleSetParam = new feeds_info.UGCPicInfo();
            paramVisibleSetParam.uint32_pic_width.set(paramArrayOfInt1[i]);
            paramVisibleSetParam.uint32_pic_height.set(paramArrayOfInt2[i]);
            paramVisibleSetParam.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(paramArrayOfString2[i]));
            paramVisibleSetParam.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(paramArrayOfString1[i]));
            if (((Integer)paramList.get(i)).intValue() == 2) {
              paramVisibleSetParam.bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(paramArrayOfString1[i]));
            }
            localObject = paramVisibleSetParam.is_animation;
            if (((Integer)paramList.get(i)).intValue() == 2)
            {
              j = 1;
              label1023:
              ((PBUInt32Field)localObject).set(j);
              localObject = paramVisibleSetParam.uint32_pic_type;
              if (((Integer)paramList.get(i)).intValue() != 2) {
                break label1102;
              }
            }
            for (int j = 2;; j = 1)
            {
              ((PBUInt32Field)localObject).set(j);
              paramVisibleSetParam.bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(paramString5));
              paramArrayList.add(paramVisibleSetParam);
              i += 1;
              break;
              j = 0;
              break label1023;
            }
          }
          paramString4.msg_ugc_pic_info_list.set(paramArrayList);
        }
        label1102:
        paramString4.uint32_ugc_feeds_type.set(paramInt3);
        if ((paramInt1 == 21) && (paramrqt != null))
        {
          paramList = new feeds_info.AccountProfile();
          paramList.bytes_desc.set(ByteStringMicro.copyFromUtf8(paramrqt.c));
          paramList.bytes_nick.set(ByteStringMicro.copyFromUtf8(paramrqt.jdField_a_of_type_JavaLangString));
          paramList.bytes_profile_photo_url.set(ByteStringMicro.copyFromUtf8(paramrqt.b));
          paramList.uint64_uin.set(paramrqt.jdField_a_of_type_Long);
          paramList.uint32_account_type.set(paramrqt.jdField_a_of_type_Int);
          paramString4.account_profile.set(paramList);
          paramString4.enum_ugc_feeds_src.set(6);
        }
        paramString3.msg_ugc_topic_feeds_info.set(paramString4);
        if (paramTroopBarPOI != null)
        {
          paramList = new feeds_info.LocationInfo();
          paramList.bytes_name.set(ByteStringMicro.copyFromUtf8(paramTroopBarPOI.c));
          paramList.uint32_longitude.set(paramTroopBarPOI.jdField_a_of_type_Int);
          paramList.uint32_latitude.set(paramTroopBarPOI.b);
          paramString3.location_info.set(paramList);
        }
        paramString1.msg_social_feeds_info.set(paramString3);
        paramString2.msg_feeds_info.set(paramString1);
        paramString1 = String.valueOf(pkh.a()) + System.currentTimeMillis();
        paramString2.bytes_req_seq.set(ByteStringMicro.copyFromUtf8(paramString1));
        paramString1 = qxp.a("OidbSvc.0x83e", 2110, 0, paramString2.toByteArray());
        paramString1.addAttribute("ugc_deliver", Integer.valueOf(1));
        this.jdField_a_of_type_Qep.b(paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qio
 * JD-Core Version:    0.7.0.1
 */