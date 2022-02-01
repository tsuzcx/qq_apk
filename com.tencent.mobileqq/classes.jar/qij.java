import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedBiuAtlasHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.common.app.AppInterface;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.feeds_info.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.feeds_info.UGCVoiceInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfo;

public class qij
  extends qil
{
  public qij(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    QLog.d("RIJCommentInLikeFeedBiuAtlasHandler", 1, "start request0x83eDeliverAtlasAction");
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramString1));
    localReqBody.enum_biu_src.set(paramInt);
    localReqBody.uint32_operation.set(4);
    localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
    oidb_cmd0x83e.FeedsInfo localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
    oidb_cmd0x83e.SocializeFeedsInfo localSocializeFeedsInfo = new oidb_cmd0x83e.SocializeFeedsInfo();
    paramString1 = new feeds_info.SocializeFeedsInfoUser();
    paramString1.uint64_uin.set(paramLong);
    localSocializeFeedsInfo.msg_master_uin.set(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
    localSocializeFeedsInfo.bytes_comments.set(paramString1);
    if (paramArrayList != null)
    {
      paramString2 = new rqw();
      paramInt = paramArrayList.size() - 1;
      while (paramInt > 0)
      {
        paramString2.a.add(paramArrayList.get(paramInt));
        paramInt -= 1;
      }
      paramString1 = new feeds_info.BiuMultiLevel();
      paramString2 = paramString2.a.iterator();
      while (paramString2.hasNext())
      {
        paramArrayList = (SocializeFeedsInfo.BiuCommentInfo)paramString2.next();
        feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
        ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramArrayList.mBiuComment);
        localBiuOneLevelItem.bytes_biu_comments.set(localByteStringMicro);
        localBiuOneLevelItem.uint32_biu_time.set(paramArrayList.mBiuTime);
        localBiuOneLevelItem.uint64_feeds_id.set(paramArrayList.mFeedId.longValue());
        localBiuOneLevelItem.uint64_uin.set(paramArrayList.mUin.longValue());
        localBiuOneLevelItem.feeds_type.set(paramArrayList.mFeedsType);
        localBiuOneLevelItem.op_type.set(paramArrayList.mOpType);
        if (paramArrayList.jumpInfo != null)
        {
          localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
          localBiuOneLevelItem.msg_jump_info.uint64_id.set(paramArrayList.jumpInfo.getId());
          localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(paramArrayList.jumpInfo.getWording()));
          localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramArrayList.jumpInfo.getJumpUrl()));
        }
        if (paramArrayList.ugcVoiceInfo != null)
        {
          localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
          localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(paramArrayList.ugcVoiceInfo.voiceUrl));
          localBiuOneLevelItem.msg_voice_info.uint32_duration.set(paramArrayList.ugcVoiceInfo.duration);
          localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(paramArrayList.ugcVoiceInfo.fileSize);
        }
        paramString1.rpt_biu_mutli_level.add(localBiuOneLevelItem);
      }
      localSocializeFeedsInfo.msg_biu_mutli_level.set(paramString1);
    }
    localFeedsInfo.msg_social_feeds_info.set(localSocializeFeedsInfo);
    localReqBody.msg_feeds_info.set(localFeedsInfo);
    paramString1 = localReqBody.uint32_is_one_touch_biu;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString1.set(paramInt);
      paramString1 = qxp.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      paramString1.addAttribute("biu_deliver", Integer.valueOf(2));
      this.jdField_a_of_type_Qep.a(paramString1);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentInLikeFeedBiuAtlasHandler", 1, "handle0x83eBiuAtlasDeliverAction result:" + i);
    }
    paramToServiceMsg = BaseApplication.getContext().getString(2131717694);
    if (localRspBody.bytes_result_desc.has())
    {
      paramToServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      QLog.d("RIJCommentInLikeFeedBiuAtlasHandler", 2, "handle0x83eBiuAtlasDeliverAction | resp errorMsg ： " + paramToServiceMsg);
    }
    long l = localRspBody.uint64_feeds_id.get();
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJCommentInLikeFeedBiuAtlasHandler.1(this, l, i, paramToServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qij
 * JD-Core Version:    0.7.0.1
 */