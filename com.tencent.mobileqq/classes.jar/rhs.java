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

public class rhs
{
  public int a;
  public long a;
  public String a;
  public ArrayList<rht> a;
  public rgv a;
  public rgy a;
  public int b;
  public String b;
  public ArrayList<rhu> b;
  public String c;
  public ArrayList<SocializeFeedsInfo.UGCVoiceInfo> c;
  
  public rhs()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private static rhs b(SocializeFeedsInfo paramSocializeFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    rhs localrhs = new rhs();
    if (paramUGCFeedsInfo.enum_ugc_feeds_card_type.has()) {
      localrhs.jdField_a_of_type_Int = paramUGCFeedsInfo.enum_ugc_feeds_card_type.get();
    }
    if (paramUGCFeedsInfo.uint64_cuin.has()) {
      localrhs.jdField_a_of_type_Long = paramUGCFeedsInfo.uint64_cuin.get();
    }
    if (paramUGCFeedsInfo.enum_ugc_feeds_src.has()) {
      localrhs.jdField_b_of_type_Int = paramUGCFeedsInfo.enum_ugc_feeds_src.get();
    }
    if (paramUGCFeedsInfo.bytes_ugc_comments.has()) {
      localrhs.jdField_a_of_type_JavaLangString = paramUGCFeedsInfo.bytes_ugc_comments.get().toStringUtf8();
    }
    if ((paramUGCFeedsInfo.msg_at_multi_level.has()) && (paramUGCFeedsInfo.msg_at_multi_level.get() != null)) {
      localrhs.jdField_a_of_type_Rgy = paramSocializeFeedsInfo.a(paramUGCFeedsInfo.msg_at_multi_level);
    }
    if (paramUGCFeedsInfo.account_profile.has()) {
      localrhs.jdField_a_of_type_Rgv = rgv.a((feeds_info.AccountProfile)paramUGCFeedsInfo.account_profile.get());
    }
    Object localObject1;
    Object localObject2;
    if (paramUGCFeedsInfo.msg_ugc_pic_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_pic_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCPicInfo)paramSocializeFeedsInfo.next();
        localObject2 = new rht();
        if (((articlesummary.UGCPicInfo)localObject1).bytes_pic_md5.has()) {
          ((rht)localObject2).jdField_a_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject1).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.UGCPicInfo)localObject1).bytes_pic_url.has()) {
          ((rht)localObject2).jdField_b_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject1).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCPicInfo)localObject1).uint32_pic_height.has()) {
          ((rht)localObject2).jdField_b_of_type_Int = ((articlesummary.UGCPicInfo)localObject1).uint32_pic_height.get();
        }
        if (((articlesummary.UGCPicInfo)localObject1).uint32_pic_width.has()) {
          ((rht)localObject2).jdField_a_of_type_Int = ((articlesummary.UGCPicInfo)localObject1).uint32_pic_width.get();
        }
        if (((articlesummary.UGCPicInfo)localObject1).bytes_thumbnail_url.has()) {
          ((rht)localObject2).jdField_c_of_type_JavaLangString = ((articlesummary.UGCPicInfo)localObject1).bytes_thumbnail_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCPicInfo)localObject1).is_animation.has()) {
          ((rht)localObject2).jdField_c_of_type_Int = ((articlesummary.UGCPicInfo)localObject1).is_animation.get();
        }
        localrhs.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_video_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_video_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVideoInfo)paramSocializeFeedsInfo.next();
        localObject2 = new rhu();
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_pic_md5.has()) {
          ((rhu)localObject2).jdField_c_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_pic_md5.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_pic_url.has()) {
          ((rhu)localObject2).jdField_d_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_title.has()) {
          ((rhu)localObject2).jdField_e_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_title.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_uuid.has()) {
          ((rhu)localObject2).jdField_f_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_uuid.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_video_md5.has()) {
          ((rhu)localObject2).jdField_a_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_video_md5.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_video_url.has()) {
          ((rhu)localObject2).jdField_b_of_type_JavaLangString = ((articlesummary.UGCVideoInfo)localObject1).bytes_video_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_share_url.has()) {
          ((rhu)localObject2).h = ((articlesummary.UGCVideoInfo)localObject1).bytes_share_url.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_vid.has()) {
          ((rhu)localObject2).i = ((articlesummary.UGCVideoInfo)localObject1).bytes_vid.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).bytes_uniq_id.has()) {
          ((rhu)localObject2).g = ((articlesummary.UGCVideoInfo)localObject1).bytes_uniq_id.get().toStringUtf8();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_busi_type.has()) {
          ((rhu)localObject2).jdField_f_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_busi_type.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_create_time.has()) {
          ((rhu)localObject2).jdField_e_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_create_time.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint64_duration.has()) {
          ((rhu)localObject2).jdField_a_of_type_Long = ((articlesummary.UGCVideoInfo)localObject1).uint64_duration.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_video_width.has()) {
          ((rhu)localObject2).jdField_a_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_video_width.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_video_height.has()) {
          ((rhu)localObject2).jdField_b_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_video_height.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_pic_width.has()) {
          ((rhu)localObject2).jdField_c_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_pic_width.get();
        }
        if (((articlesummary.UGCVideoInfo)localObject1).uint32_pic_height.has()) {
          ((rhu)localObject2).jdField_d_of_type_Int = ((articlesummary.UGCVideoInfo)localObject1).uint32_pic_height.get();
        }
        localrhs.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
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
        localrhs.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.bytes_jump_url.has()) {
      localrhs.jdField_c_of_type_JavaLangString = paramUGCFeedsInfo.bytes_jump_url.get().toStringUtf8();
    }
    return localrhs;
  }
  
  private static articlesummary.UGCFeedsInfo b(rhs paramrhs)
  {
    articlesummary.UGCFeedsInfo localUGCFeedsInfo = new articlesummary.UGCFeedsInfo();
    localUGCFeedsInfo.enum_ugc_feeds_card_type.set(paramrhs.jdField_a_of_type_Int);
    localUGCFeedsInfo.enum_ugc_feeds_src.set(paramrhs.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(paramrhs.jdField_a_of_type_JavaLangString)) {
      localUGCFeedsInfo.bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(paramrhs.jdField_a_of_type_JavaLangString));
    }
    if (paramrhs.jdField_a_of_type_Rgy != null) {
      localUGCFeedsInfo.msg_at_multi_level.set(paramrhs.jdField_a_of_type_Rgy.a());
    }
    localUGCFeedsInfo.uint64_cuin.set(paramrhs.jdField_a_of_type_Long);
    ArrayList localArrayList;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    if ((paramrhs.jdField_a_of_type_JavaUtilArrayList != null) && (paramrhs.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      localIterator = paramrhs.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (rht)localIterator.next();
        localObject2 = new articlesummary.UGCPicInfo();
        ((articlesummary.UGCPicInfo)localObject2).uint32_pic_width.set(((rht)localObject1).jdField_a_of_type_Int);
        ((articlesummary.UGCPicInfo)localObject2).uint32_pic_height.set(((rht)localObject1).jdField_b_of_type_Int);
        if (!TextUtils.isEmpty(((rht)localObject1).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.UGCPicInfo)localObject2).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((rht)localObject1).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rht)localObject1).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCPicInfo)localObject2).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((rht)localObject1).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rht)localObject1).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.UGCPicInfo)localObject2).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((rht)localObject1).jdField_c_of_type_JavaLangString));
        }
        ((articlesummary.UGCPicInfo)localObject2).is_animation.set(((rht)localObject1).jdField_c_of_type_Int);
        localArrayList.add(localObject2);
      }
      localUGCFeedsInfo.msg_ugc_pic_info_list.set(localArrayList);
    }
    if ((paramrhs.jdField_b_of_type_JavaUtilArrayList != null) && (paramrhs.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      localIterator = paramrhs.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (rhu)localIterator.next();
        localObject2 = new articlesummary.UGCVideoInfo();
        ((articlesummary.UGCVideoInfo)localObject2).uint64_duration.set(((rhu)localObject1).jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(((rhu)localObject1).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((rhu)localObject1).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rhu)localObject1).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((rhu)localObject1).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rhu)localObject1).jdField_f_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_uuid.set(ByteStringMicro.copyFromUtf8(((rhu)localObject1).jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rhu)localObject1).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((rhu)localObject1).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rhu)localObject1).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((rhu)localObject1).jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rhu)localObject1).jdField_e_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_title.set(ByteStringMicro.copyFromUtf8(((rhu)localObject1).jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rhu)localObject1).g)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(((rhu)localObject1).g));
        }
        if (!TextUtils.isEmpty(((rhu)localObject1).h)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_share_url.set(ByteStringMicro.copyFromUtf8(((rhu)localObject1).h));
        }
        if (!TextUtils.isEmpty(((rhu)localObject1).i)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_vid.set(ByteStringMicro.copyFromUtf8(((rhu)localObject1).i));
        }
        ((articlesummary.UGCVideoInfo)localObject2).uint32_create_time.set(((rhu)localObject1).jdField_e_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_busi_type.set(((rhu)localObject1).jdField_f_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_pic_height.set(((rhu)localObject1).jdField_d_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_pic_width.set(((rhu)localObject1).jdField_c_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_video_height.set(((rhu)localObject1).jdField_b_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_video_width.set(((rhu)localObject1).jdField_a_of_type_Int);
        localArrayList.add(localObject2);
      }
      localUGCFeedsInfo.msg_ugc_video_info_list.set(localArrayList);
    }
    if ((paramrhs.jdField_c_of_type_JavaUtilArrayList != null) && (paramrhs.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      localIterator = paramrhs.jdField_c_of_type_JavaUtilArrayList.iterator();
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
    if (paramrhs.jdField_a_of_type_Rgv != null) {
      localUGCFeedsInfo.account_profile.set(paramrhs.jdField_a_of_type_Rgv.a());
    }
    if (!TextUtils.isEmpty(paramrhs.jdField_c_of_type_JavaLangString)) {
      localUGCFeedsInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramrhs.jdField_c_of_type_JavaLangString));
    }
    return localUGCFeedsInfo;
  }
  
  public String toString()
  {
    return "UGCFeedsInfo{ugcFeedsCardType=" + this.jdField_a_of_type_Int + ", ugcPicInfos=" + this.jdField_a_of_type_JavaUtilArrayList + ", ugcVideoInfos=" + this.jdField_b_of_type_JavaUtilArrayList + ", ugcVoiceInfos=" + this.jdField_c_of_type_JavaUtilArrayList + ", cuin=" + this.jdField_a_of_type_Long + ", ugcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", nickName='" + this.jdField_b_of_type_JavaLangString + '\'' + ", ugcAtComments=" + this.jdField_a_of_type_Rgy + ", ugcFeedsSrc=" + this.jdField_b_of_type_Int + ", jumpUrl='" + this.jdField_c_of_type_JavaLangString + '\'' + ", accountProfileInfo=" + this.jdField_a_of_type_Rgv + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhs
 * JD-Core Version:    0.7.0.1
 */