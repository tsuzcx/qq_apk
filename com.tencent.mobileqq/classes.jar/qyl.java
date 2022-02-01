import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;

public class qyl
{
  public int a;
  public long a;
  public String a;
  public ArrayList<qym> a;
  public qxo a;
  public qxr a;
  public int b;
  public String b;
  public ArrayList<qyn> b;
  public String c;
  public ArrayList<SocializeFeedsInfo.UGCVoiceInfo> c;
  
  public qyl()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private static qyl b(SocializeFeedsInfo paramSocializeFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    qyl localqyl = new qyl();
    if (paramUGCFeedsInfo.enum_ugc_feeds_card_type.has()) {
      localqyl.jdField_a_of_type_Int = paramUGCFeedsInfo.enum_ugc_feeds_card_type.get();
    }
    if (paramUGCFeedsInfo.uint64_cuin.has()) {
      localqyl.jdField_a_of_type_Long = paramUGCFeedsInfo.uint64_cuin.get();
    }
    if (paramUGCFeedsInfo.enum_ugc_feeds_src.has()) {
      localqyl.jdField_b_of_type_Int = paramUGCFeedsInfo.enum_ugc_feeds_src.get();
    }
    if (paramUGCFeedsInfo.bytes_ugc_comments.has()) {
      localqyl.jdField_a_of_type_JavaLangString = paramUGCFeedsInfo.bytes_ugc_comments.get().toStringUtf8();
    }
    if ((paramUGCFeedsInfo.msg_at_multi_level.has()) && (paramUGCFeedsInfo.msg_at_multi_level.get() != null)) {
      localqyl.jdField_a_of_type_Qxr = paramSocializeFeedsInfo.a(paramUGCFeedsInfo.msg_at_multi_level);
    }
    if (paramUGCFeedsInfo.account_profile.has()) {
      localqyl.jdField_a_of_type_Qxo = qxo.a((feeds_info.AccountProfile)paramUGCFeedsInfo.account_profile.get());
    }
    Object localObject1;
    Object localObject2;
    if (paramUGCFeedsInfo.msg_ugc_pic_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_pic_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCPicInfo)paramSocializeFeedsInfo.next();
        localObject2 = new qym();
        if (((articlesummary.UGCPicInfo)localObject1).bytes_pic_md5.has()) {
          ((qym)localObject2).jdField_a_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject1).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.UGCPicInfo)localObject1).bytes_pic_url.has()) {
          ((qym)localObject2).jdField_b_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject1).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCPicInfo)localObject1).uint32_pic_height.has()) {
          ((qym)localObject2).jdField_b_of_type_Int = ((articlesummary.UGCPicInfo)localObject1).uint32_pic_height.get();
        }
        if (((articlesummary.UGCPicInfo)localObject1).uint32_pic_width.has()) {
          ((qym)localObject2).jdField_a_of_type_Int = ((articlesummary.UGCPicInfo)localObject1).uint32_pic_width.get();
        }
        if (((articlesummary.UGCPicInfo)localObject1).bytes_thumbnail_url.has()) {
          ((qym)localObject2).jdField_c_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject1).bytes_thumbnail_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCPicInfo)localObject1).is_animation.has()) {
          ((qym)localObject2).jdField_c_of_type_Int = ((articlesummary.UGCPicInfo)localObject1).is_animation.get();
        }
        localqyl.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_video_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_video_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVideoInfo)paramSocializeFeedsInfo.next();
        localObject2 = new qyn();
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_pic_md5.has()) {
          ((qyn)localObject2).jdField_c_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_pic_url.has()) {
          ((qyn)localObject2).jdField_d_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_title.has()) {
          ((qyn)localObject2).jdField_e_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_title.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_uuid.has()) {
          ((qyn)localObject2).jdField_f_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_uuid.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_video_md5.has()) {
          ((qyn)localObject2).jdField_a_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_video_md5.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_video_url.has()) {
          ((qyn)localObject2).jdField_b_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_video_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_share_url.has()) {
          ((qyn)localObject2).h = ((articlesummary.UGCVideoInfo)localObject1).bytes_share_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_vid.has()) {
          ((qyn)localObject2).i = ((articlesummary.UGCVideoInfo)localObject1).bytes_vid.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_uniq_id.has()) {
          ((qyn)localObject2).g = ((articlesummary.UGCVideoInfo)localObject1).bytes_uniq_id.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_busi_type.has()) {
          ((qyn)localObject2).jdField_f_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_busi_type.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_create_time.has()) {
          ((qyn)localObject2).jdField_e_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_create_time.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint64_duration.has()) {
          ((qyn)localObject2).jdField_a_of_type_Long = ((articlesummary.UGCVideoInfo)localObject1).uint64_duration.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_video_width.has()) {
          ((qyn)localObject2).jdField_a_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_video_width.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_video_height.has()) {
          ((qyn)localObject2).jdField_b_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_video_height.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_pic_width.has()) {
          ((qyn)localObject2).jdField_c_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_pic_width.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_pic_height.has()) {
          ((qyn)localObject2).jdField_d_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_pic_height.get();
        }
        localqyl.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_voice_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_voice_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVoiceInfo)paramSocializeFeedsInfo.next();
        localObject2 = new SocializeFeedsInfo.UGCVoiceInfo();
        ((SocializeFeedsInfo.UGCVoiceInfo)localObject2).jdField_a_of_type_JavaLangString = ((articlesummary.UGCVoiceInfo)localObject1).bytes_voice_url.get().toStringUtf8();
        ((SocializeFeedsInfo.UGCVoiceInfo)localObject2).jdField_a_of_type_Int = ((articlesummary.UGCVoiceInfo)localObject1).uint32_duration.get();
        ((SocializeFeedsInfo.UGCVoiceInfo)localObject2).jdField_b_of_type_Int = ((articlesummary.UGCVoiceInfo)localObject1).uint32_file_size.get();
        localqyl.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.bytes_jump_url.has()) {
      localqyl.jdField_c_of_type_JavaLangString = paramUGCFeedsInfo.bytes_jump_url.get().toStringUtf8();
    }
    return localqyl;
  }
  
  private static articlesummary.UGCFeedsInfo b(qyl paramqyl)
  {
    articlesummary.UGCFeedsInfo localUGCFeedsInfo = new articlesummary.UGCFeedsInfo();
    localUGCFeedsInfo.enum_ugc_feeds_card_type.set(paramqyl.jdField_a_of_type_Int);
    localUGCFeedsInfo.enum_ugc_feeds_src.set(paramqyl.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(paramqyl.jdField_a_of_type_JavaLangString)) {
      localUGCFeedsInfo.bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(paramqyl.jdField_a_of_type_JavaLangString));
    }
    if (paramqyl.jdField_a_of_type_Qxr != null) {
      localUGCFeedsInfo.msg_at_multi_level.set(paramqyl.jdField_a_of_type_Qxr.a());
    }
    localUGCFeedsInfo.uint64_cuin.set(paramqyl.jdField_a_of_type_Long);
    ArrayList localArrayList;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    if ((paramqyl.jdField_a_of_type_JavaUtilArrayList != null) && (paramqyl.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      localIterator = paramqyl.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (qym)localIterator.next();
        localObject2 = new articlesummary.UGCPicInfo();
        ((articlesummary.UGCPicInfo)localObject2).uint32_pic_width.set(((qym)localObject1).jdField_a_of_type_Int);
        ((articlesummary.UGCPicInfo)localObject2).uint32_pic_height.set(((qym)localObject1).jdField_b_of_type_Int);
        if (!TextUtils.isEmpty(((qym)localObject1).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.UGCPicInfo)localObject2).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((qym)localObject1).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qym)localObject1).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCPicInfo)localObject2).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((qym)localObject1).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qym)localObject1).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.UGCPicInfo)localObject2).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((qym)localObject1).jdField_c_of_type_JavaLangString));
        }
        ((articlesummary.UGCPicInfo)localObject2).is_animation.set(((qym)localObject1).jdField_c_of_type_Int);
        localArrayList.add(localObject2);
      }
      localUGCFeedsInfo.msg_ugc_pic_info_list.set(localArrayList);
    }
    if ((paramqyl.jdField_b_of_type_JavaUtilArrayList != null) && (paramqyl.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      localIterator = paramqyl.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (qyn)localIterator.next();
        localObject2 = new articlesummary.UGCVideoInfo();
        ((articlesummary.UGCVideoInfo)localObject2).uint64_duration.set(((qyn)localObject1).jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(((qyn)localObject1).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((qyn)localObject1).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qyn)localObject1).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((qyn)localObject1).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qyn)localObject1).jdField_f_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_uuid.set(ByteStringMicro.copyFromUtf8(((qyn)localObject1).jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qyn)localObject1).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((qyn)localObject1).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qyn)localObject1).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((qyn)localObject1).jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qyn)localObject1).jdField_e_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_title.set(ByteStringMicro.copyFromUtf8(((qyn)localObject1).jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((qyn)localObject1).g)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(((qyn)localObject1).g));
        }
        if (!TextUtils.isEmpty(((qyn)localObject1).h)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_share_url.set(ByteStringMicro.copyFromUtf8(((qyn)localObject1).h));
        }
        if (!TextUtils.isEmpty(((qyn)localObject1).i)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_vid.set(ByteStringMicro.copyFromUtf8(((qyn)localObject1).i));
        }
        ((articlesummary.UGCVideoInfo)localObject2).uint32_create_time.set(((qyn)localObject1).jdField_e_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_busi_type.set(((qyn)localObject1).jdField_f_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_pic_height.set(((qyn)localObject1).jdField_d_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_pic_width.set(((qyn)localObject1).jdField_c_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_video_height.set(((qyn)localObject1).jdField_b_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_video_width.set(((qyn)localObject1).jdField_a_of_type_Int);
        localArrayList.add(localObject2);
      }
      localUGCFeedsInfo.msg_ugc_video_info_list.set(localArrayList);
    }
    if ((paramqyl.jdField_c_of_type_JavaUtilArrayList != null) && (paramqyl.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      localIterator = paramqyl.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (SocializeFeedsInfo.UGCVoiceInfo)localIterator.next();
        localObject2 = new articlesummary.UGCVoiceInfo();
        ((articlesummary.UGCVoiceInfo)localObject2).uint32_duration.set(((SocializeFeedsInfo.UGCVoiceInfo)localObject1).jdField_a_of_type_Int);
        ((articlesummary.UGCVoiceInfo)localObject2).uint32_file_size.set(((SocializeFeedsInfo.UGCVoiceInfo)localObject1).jdField_b_of_type_Int);
        if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVoiceInfo)localObject1).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCVoiceInfo)localObject2).bytes_voice_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVoiceInfo)localObject1).jdField_a_of_type_JavaLangString));
        }
        localArrayList.add(localObject2);
      }
      localUGCFeedsInfo.msg_ugc_voice_info_list.set(localArrayList);
    }
    if (paramqyl.jdField_a_of_type_Qxo != null) {
      localUGCFeedsInfo.account_profile.set(paramqyl.jdField_a_of_type_Qxo.a());
    }
    if (!TextUtils.isEmpty(paramqyl.jdField_c_of_type_JavaLangString)) {
      localUGCFeedsInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramqyl.jdField_c_of_type_JavaLangString));
    }
    return localUGCFeedsInfo;
  }
  
  public String toString()
  {
    return "UGCFeedsInfo{ugcFeedsCardType=" + this.jdField_a_of_type_Int + ", ugcPicInfos=" + this.jdField_a_of_type_JavaUtilArrayList + ", ugcVideoInfos=" + this.jdField_b_of_type_JavaUtilArrayList + ", ugcVoiceInfos=" + this.jdField_c_of_type_JavaUtilArrayList + ", cuin=" + this.jdField_a_of_type_Long + ", ugcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", nickName='" + this.jdField_b_of_type_JavaLangString + '\'' + ", ugcAtComments=" + this.jdField_a_of_type_Qxr + ", ugcFeedsSrc=" + this.jdField_b_of_type_Int + ", jumpUrl='" + this.jdField_c_of_type_JavaLangString + '\'' + ", accountProfileInfo=" + this.jdField_a_of_type_Qxo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyl
 * JD-Core Version:    0.7.0.1
 */