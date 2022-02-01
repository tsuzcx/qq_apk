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

public class rfj
{
  public int a;
  public long a;
  public String a;
  public ArrayList<rfk> a;
  public rem a;
  public rep a;
  public int b;
  public String b;
  public ArrayList<rfl> b;
  public String c;
  public ArrayList<SocializeFeedsInfo.UGCVoiceInfo> c;
  
  public rfj()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private static rfj b(SocializeFeedsInfo paramSocializeFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    rfj localrfj = new rfj();
    localrfj.jdField_a_of_type_Int = qlg.a(paramUGCFeedsInfo.enum_ugc_feeds_card_type, 0);
    localrfj.jdField_a_of_type_Long = qlg.a(paramUGCFeedsInfo.uint64_cuin, 0L);
    localrfj.jdField_b_of_type_Int = qlg.a(paramUGCFeedsInfo.enum_ugc_feeds_src, 0);
    localrfj.jdField_a_of_type_JavaLangString = qlg.a(paramUGCFeedsInfo.bytes_ugc_comments);
    if ((paramUGCFeedsInfo.msg_at_multi_level.has()) && (paramUGCFeedsInfo.msg_at_multi_level.get() != null)) {
      localrfj.jdField_a_of_type_Rep = paramSocializeFeedsInfo.a(paramUGCFeedsInfo.msg_at_multi_level);
    }
    if (paramUGCFeedsInfo.account_profile.has()) {
      localrfj.jdField_a_of_type_Rem = rem.a((feeds_info.AccountProfile)paramUGCFeedsInfo.account_profile.get());
    }
    Object localObject1;
    Object localObject2;
    if (paramUGCFeedsInfo.msg_ugc_pic_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_pic_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCPicInfo)paramSocializeFeedsInfo.next();
        localObject2 = new rfk();
        ((rfk)localObject2).jdField_a_of_type_JavaLangString = qlg.a(((articlesummary.UGCPicInfo)localObject1).bytes_pic_md5);
        ((rfk)localObject2).jdField_b_of_type_JavaLangString = qlg.a(((articlesummary.UGCPicInfo)localObject1).bytes_pic_url);
        ((rfk)localObject2).jdField_b_of_type_Int = qlg.a(((articlesummary.UGCPicInfo)localObject1).uint32_pic_height);
        ((rfk)localObject2).jdField_a_of_type_Int = qlg.a(((articlesummary.UGCPicInfo)localObject1).uint32_pic_width);
        ((rfk)localObject2).jdField_c_of_type_JavaLangString = qlg.a(((articlesummary.UGCPicInfo)localObject1).bytes_thumbnail_url);
        ((rfk)localObject2).jdField_c_of_type_Int = qlg.a(((articlesummary.UGCPicInfo)localObject1).is_animation);
        localrfj.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_video_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_video_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVideoInfo)paramSocializeFeedsInfo.next();
        localObject2 = new rfl();
        ((rfl)localObject2).jdField_c_of_type_JavaLangString = qlg.a(((articlesummary.UGCVideoInfo)localObject1).bytes_pic_md5);
        ((rfl)localObject2).jdField_d_of_type_JavaLangString = qlg.a(((articlesummary.UGCVideoInfo)localObject1).bytes_pic_url);
        ((rfl)localObject2).jdField_e_of_type_JavaLangString = qlg.a(((articlesummary.UGCVideoInfo)localObject1).bytes_title);
        ((rfl)localObject2).jdField_f_of_type_JavaLangString = qlg.a(((articlesummary.UGCVideoInfo)localObject1).bytes_uuid);
        ((rfl)localObject2).jdField_a_of_type_JavaLangString = qlg.a(((articlesummary.UGCVideoInfo)localObject1).bytes_video_md5);
        ((rfl)localObject2).jdField_b_of_type_JavaLangString = qlg.a(((articlesummary.UGCVideoInfo)localObject1).bytes_video_url);
        ((rfl)localObject2).h = qlg.a(((articlesummary.UGCVideoInfo)localObject1).bytes_share_url);
        ((rfl)localObject2).i = qlg.a(((articlesummary.UGCVideoInfo)localObject1).bytes_vid);
        ((rfl)localObject2).g = qlg.a(((articlesummary.UGCVideoInfo)localObject1).bytes_uniq_id);
        ((rfl)localObject2).jdField_f_of_type_Int = qlg.a(((articlesummary.UGCVideoInfo)localObject1).uint32_busi_type);
        ((rfl)localObject2).jdField_e_of_type_Int = qlg.a(((articlesummary.UGCVideoInfo)localObject1).uint32_create_time);
        ((rfl)localObject2).jdField_a_of_type_Long = qlg.a(((articlesummary.UGCVideoInfo)localObject1).uint64_duration);
        ((rfl)localObject2).jdField_a_of_type_Int = qlg.a(((articlesummary.UGCVideoInfo)localObject1).uint32_video_width);
        ((rfl)localObject2).jdField_b_of_type_Int = qlg.a(((articlesummary.UGCVideoInfo)localObject1).uint32_video_height);
        ((rfl)localObject2).jdField_c_of_type_Int = qlg.a(((articlesummary.UGCVideoInfo)localObject1).uint32_pic_width);
        ((rfl)localObject2).jdField_d_of_type_Int = qlg.a(((articlesummary.UGCVideoInfo)localObject1).uint32_pic_height);
        localrfj.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
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
        localrfj.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    localrfj.jdField_c_of_type_JavaLangString = qlg.a(paramUGCFeedsInfo.bytes_jump_url);
    return localrfj;
  }
  
  private static articlesummary.UGCFeedsInfo b(rfj paramrfj)
  {
    articlesummary.UGCFeedsInfo localUGCFeedsInfo = new articlesummary.UGCFeedsInfo();
    localUGCFeedsInfo.enum_ugc_feeds_card_type.set(paramrfj.jdField_a_of_type_Int);
    localUGCFeedsInfo.enum_ugc_feeds_src.set(paramrfj.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(paramrfj.jdField_a_of_type_JavaLangString)) {
      localUGCFeedsInfo.bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(paramrfj.jdField_a_of_type_JavaLangString));
    }
    if (paramrfj.jdField_a_of_type_Rep != null) {
      localUGCFeedsInfo.msg_at_multi_level.set(paramrfj.jdField_a_of_type_Rep.a());
    }
    localUGCFeedsInfo.uint64_cuin.set(paramrfj.jdField_a_of_type_Long);
    ArrayList localArrayList;
    Iterator localIterator;
    Object localObject1;
    Object localObject2;
    if ((paramrfj.jdField_a_of_type_JavaUtilArrayList != null) && (paramrfj.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      localIterator = paramrfj.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (rfk)localIterator.next();
        localObject2 = new articlesummary.UGCPicInfo();
        ((articlesummary.UGCPicInfo)localObject2).uint32_pic_width.set(((rfk)localObject1).jdField_a_of_type_Int);
        ((articlesummary.UGCPicInfo)localObject2).uint32_pic_height.set(((rfk)localObject1).jdField_b_of_type_Int);
        if (!TextUtils.isEmpty(((rfk)localObject1).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.UGCPicInfo)localObject2).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((rfk)localObject1).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rfk)localObject1).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCPicInfo)localObject2).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((rfk)localObject1).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rfk)localObject1).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.UGCPicInfo)localObject2).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((rfk)localObject1).jdField_c_of_type_JavaLangString));
        }
        ((articlesummary.UGCPicInfo)localObject2).is_animation.set(((rfk)localObject1).jdField_c_of_type_Int);
        localArrayList.add(localObject2);
      }
      localUGCFeedsInfo.msg_ugc_pic_info_list.set(localArrayList);
    }
    if ((paramrfj.jdField_b_of_type_JavaUtilArrayList != null) && (paramrfj.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      localIterator = paramrfj.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (rfl)localIterator.next();
        localObject2 = new articlesummary.UGCVideoInfo();
        ((articlesummary.UGCVideoInfo)localObject2).uint64_duration.set(((rfl)localObject1).jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(((rfl)localObject1).jdField_b_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((rfl)localObject1).jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rfl)localObject1).jdField_a_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((rfl)localObject1).jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rfl)localObject1).jdField_f_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_uuid.set(ByteStringMicro.copyFromUtf8(((rfl)localObject1).jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rfl)localObject1).jdField_c_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((rfl)localObject1).jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rfl)localObject1).jdField_d_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((rfl)localObject1).jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rfl)localObject1).jdField_e_of_type_JavaLangString)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_title.set(ByteStringMicro.copyFromUtf8(((rfl)localObject1).jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(((rfl)localObject1).g)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(((rfl)localObject1).g));
        }
        if (!TextUtils.isEmpty(((rfl)localObject1).h)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_share_url.set(ByteStringMicro.copyFromUtf8(((rfl)localObject1).h));
        }
        if (!TextUtils.isEmpty(((rfl)localObject1).i)) {
          ((articlesummary.UGCVideoInfo)localObject2).bytes_vid.set(ByteStringMicro.copyFromUtf8(((rfl)localObject1).i));
        }
        ((articlesummary.UGCVideoInfo)localObject2).uint32_create_time.set(((rfl)localObject1).jdField_e_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_busi_type.set(((rfl)localObject1).jdField_f_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_pic_height.set(((rfl)localObject1).jdField_d_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_pic_width.set(((rfl)localObject1).jdField_c_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_video_height.set(((rfl)localObject1).jdField_b_of_type_Int);
        ((articlesummary.UGCVideoInfo)localObject2).uint32_video_width.set(((rfl)localObject1).jdField_a_of_type_Int);
        localArrayList.add(localObject2);
      }
      localUGCFeedsInfo.msg_ugc_video_info_list.set(localArrayList);
    }
    if ((paramrfj.jdField_c_of_type_JavaUtilArrayList != null) && (paramrfj.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      localIterator = paramrfj.jdField_c_of_type_JavaUtilArrayList.iterator();
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
    if (paramrfj.jdField_a_of_type_Rem != null) {
      localUGCFeedsInfo.account_profile.set(paramrfj.jdField_a_of_type_Rem.a());
    }
    if (!TextUtils.isEmpty(paramrfj.jdField_c_of_type_JavaLangString)) {
      localUGCFeedsInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramrfj.jdField_c_of_type_JavaLangString));
    }
    return localUGCFeedsInfo;
  }
  
  public String toString()
  {
    return "UGCFeedsInfo{ugcFeedsCardType=" + this.jdField_a_of_type_Int + ", ugcPicInfos=" + this.jdField_a_of_type_JavaUtilArrayList + ", ugcVideoInfos=" + this.jdField_b_of_type_JavaUtilArrayList + ", ugcVoiceInfos=" + this.jdField_c_of_type_JavaUtilArrayList + ", cuin=" + this.jdField_a_of_type_Long + ", ugcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", nickName='" + this.jdField_b_of_type_JavaLangString + '\'' + ", ugcAtComments=" + this.jdField_a_of_type_Rep + ", ugcFeedsSrc=" + this.jdField_b_of_type_Int + ", jumpUrl='" + this.jdField_c_of_type_JavaLangString + '\'' + ", accountProfileInfo=" + this.jdField_a_of_type_Rem + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfj
 * JD-Core Version:    0.7.0.1
 */