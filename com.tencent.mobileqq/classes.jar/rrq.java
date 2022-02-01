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

public class rrq
{
  public int a;
  public long a;
  public String a;
  public ArrayList<rrr> a;
  public rqt a;
  public rqw a;
  public int b;
  public String b;
  public ArrayList<rrs> b;
  public String c;
  public ArrayList<SocializeFeedsInfo.UGCVoiceInfo> c;
  
  public rrq()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  static void a(rrq paramrrq, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    if ((paramrrq.jdField_c_of_type_JavaUtilArrayList != null) && (paramrrq.jdField_c_of_type_JavaUtilArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramrrq = paramrrq.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (paramrrq.hasNext())
      {
        SocializeFeedsInfo.UGCVoiceInfo localUGCVoiceInfo = (SocializeFeedsInfo.UGCVoiceInfo)paramrrq.next();
        articlesummary.UGCVoiceInfo localUGCVoiceInfo1 = new articlesummary.UGCVoiceInfo();
        localUGCVoiceInfo1.uint32_duration.set(localUGCVoiceInfo.duration);
        localUGCVoiceInfo1.uint32_file_size.set(localUGCVoiceInfo.fileSize);
        if (!TextUtils.isEmpty(localUGCVoiceInfo.voiceUrl)) {
          localUGCVoiceInfo1.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localUGCVoiceInfo.voiceUrl));
        }
        localArrayList.add(localUGCVoiceInfo1);
      }
      paramUGCFeedsInfo.msg_ugc_voice_info_list.set(localArrayList);
    }
  }
  
  private static rrq b(SocializeFeedsInfo paramSocializeFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    rrq localrrq = new rrq();
    localrrq.jdField_a_of_type_Int = qxl.a(paramUGCFeedsInfo.enum_ugc_feeds_card_type, 0);
    localrrq.jdField_a_of_type_Long = qxl.a(paramUGCFeedsInfo.uint64_cuin, 0L);
    localrrq.jdField_b_of_type_Int = qxl.a(paramUGCFeedsInfo.enum_ugc_feeds_src, 0);
    localrrq.jdField_a_of_type_JavaLangString = qxl.a(paramUGCFeedsInfo.bytes_ugc_comments);
    if ((paramUGCFeedsInfo.msg_at_multi_level.has()) && (paramUGCFeedsInfo.msg_at_multi_level.get() != null)) {
      localrrq.jdField_a_of_type_Rqw = paramSocializeFeedsInfo.a(paramUGCFeedsInfo.msg_at_multi_level);
    }
    if (paramUGCFeedsInfo.account_profile.has()) {
      localrrq.jdField_a_of_type_Rqt = rqt.a((feeds_info.AccountProfile)paramUGCFeedsInfo.account_profile.get());
    }
    Object localObject1;
    Object localObject2;
    if (paramUGCFeedsInfo.msg_ugc_pic_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_pic_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCPicInfo)paramSocializeFeedsInfo.next();
        localObject2 = new rrr();
        ((rrr)localObject2).jdField_a_of_type_JavaLangString = qxl.a(((articlesummary.UGCPicInfo)localObject1).bytes_pic_md5);
        ((rrr)localObject2).jdField_b_of_type_JavaLangString = qxl.a(((articlesummary.UGCPicInfo)localObject1).bytes_pic_url);
        ((rrr)localObject2).jdField_b_of_type_Int = qxl.a(((articlesummary.UGCPicInfo)localObject1).uint32_pic_height);
        ((rrr)localObject2).jdField_a_of_type_Int = qxl.a(((articlesummary.UGCPicInfo)localObject1).uint32_pic_width);
        ((rrr)localObject2).jdField_c_of_type_JavaLangString = qxl.a(((articlesummary.UGCPicInfo)localObject1).bytes_thumbnail_url);
        ((rrr)localObject2).jdField_c_of_type_Int = qxl.a(((articlesummary.UGCPicInfo)localObject1).is_animation);
        localrrq.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_video_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_video_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVideoInfo)paramSocializeFeedsInfo.next();
        localObject2 = new rrs();
        ((rrs)localObject2).jdField_c_of_type_JavaLangString = qxl.a(((articlesummary.UGCVideoInfo)localObject1).bytes_pic_md5);
        ((rrs)localObject2).jdField_d_of_type_JavaLangString = qxl.a(((articlesummary.UGCVideoInfo)localObject1).bytes_pic_url);
        ((rrs)localObject2).jdField_e_of_type_JavaLangString = qxl.a(((articlesummary.UGCVideoInfo)localObject1).bytes_title);
        ((rrs)localObject2).jdField_f_of_type_JavaLangString = qxl.a(((articlesummary.UGCVideoInfo)localObject1).bytes_uuid);
        ((rrs)localObject2).jdField_a_of_type_JavaLangString = qxl.a(((articlesummary.UGCVideoInfo)localObject1).bytes_video_md5);
        ((rrs)localObject2).jdField_b_of_type_JavaLangString = qxl.a(((articlesummary.UGCVideoInfo)localObject1).bytes_video_url);
        ((rrs)localObject2).h = qxl.a(((articlesummary.UGCVideoInfo)localObject1).bytes_share_url);
        ((rrs)localObject2).i = qxl.a(((articlesummary.UGCVideoInfo)localObject1).bytes_vid);
        ((rrs)localObject2).g = qxl.a(((articlesummary.UGCVideoInfo)localObject1).bytes_uniq_id);
        ((rrs)localObject2).jdField_f_of_type_Int = qxl.a(((articlesummary.UGCVideoInfo)localObject1).uint32_busi_type);
        ((rrs)localObject2).jdField_e_of_type_Int = qxl.a(((articlesummary.UGCVideoInfo)localObject1).uint32_create_time);
        ((rrs)localObject2).jdField_a_of_type_Long = qxl.a(((articlesummary.UGCVideoInfo)localObject1).uint64_duration);
        ((rrs)localObject2).jdField_a_of_type_Int = qxl.a(((articlesummary.UGCVideoInfo)localObject1).uint32_video_width);
        ((rrs)localObject2).jdField_b_of_type_Int = qxl.a(((articlesummary.UGCVideoInfo)localObject1).uint32_video_height);
        ((rrs)localObject2).jdField_c_of_type_Int = qxl.a(((articlesummary.UGCVideoInfo)localObject1).uint32_pic_width);
        ((rrs)localObject2).jdField_d_of_type_Int = qxl.a(((articlesummary.UGCVideoInfo)localObject1).uint32_pic_height);
        localrrq.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_voice_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_voice_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVoiceInfo)paramSocializeFeedsInfo.next();
        localObject2 = new SocializeFeedsInfo.UGCVoiceInfo();
        ((SocializeFeedsInfo.UGCVoiceInfo)localObject2).voiceUrl = ((articlesummary.UGCVoiceInfo)localObject1).bytes_voice_url.get().toStringUtf8();
        ((SocializeFeedsInfo.UGCVoiceInfo)localObject2).duration = ((articlesummary.UGCVoiceInfo)localObject1).uint32_duration.get();
        ((SocializeFeedsInfo.UGCVoiceInfo)localObject2).fileSize = ((articlesummary.UGCVoiceInfo)localObject1).uint32_file_size.get();
        localrrq.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    localrrq.jdField_c_of_type_JavaLangString = qxl.a(paramUGCFeedsInfo.bytes_jump_url);
    return localrrq;
  }
  
  private static articlesummary.UGCFeedsInfo b(rrq paramrrq)
  {
    articlesummary.UGCFeedsInfo localUGCFeedsInfo = new articlesummary.UGCFeedsInfo();
    d(paramrrq, localUGCFeedsInfo);
    c(paramrrq, localUGCFeedsInfo);
    b(paramrrq, localUGCFeedsInfo);
    a(paramrrq, localUGCFeedsInfo);
    return localUGCFeedsInfo;
  }
  
  static void b(rrq paramrrq, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    if ((paramrrq.jdField_b_of_type_JavaUtilArrayList != null) && (paramrrq.jdField_b_of_type_JavaUtilArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramrrq = paramrrq.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramrrq.hasNext())
      {
        rrs localrrs = (rrs)paramrrq.next();
        articlesummary.UGCVideoInfo localUGCVideoInfo = new articlesummary.UGCVideoInfo();
        localUGCVideoInfo.uint64_duration.set(localrrs.jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(localrrs.jdField_b_of_type_JavaLangString)) {
          localUGCVideoInfo.bytes_video_url.set(ByteStringMicro.copyFromUtf8(localrrs.jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrrs.jdField_a_of_type_JavaLangString)) {
          localUGCVideoInfo.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(localrrs.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrrs.jdField_f_of_type_JavaLangString)) {
          localUGCVideoInfo.bytes_uuid.set(ByteStringMicro.copyFromUtf8(localrrs.jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrrs.jdField_c_of_type_JavaLangString)) {
          localUGCVideoInfo.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(localrrs.jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrrs.jdField_d_of_type_JavaLangString)) {
          localUGCVideoInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localrrs.jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrrs.jdField_e_of_type_JavaLangString)) {
          localUGCVideoInfo.bytes_title.set(ByteStringMicro.copyFromUtf8(localrrs.jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrrs.g)) {
          localUGCVideoInfo.bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(localrrs.g));
        }
        if (!TextUtils.isEmpty(localrrs.h)) {
          localUGCVideoInfo.bytes_share_url.set(ByteStringMicro.copyFromUtf8(localrrs.h));
        }
        if (!TextUtils.isEmpty(localrrs.i)) {
          localUGCVideoInfo.bytes_vid.set(ByteStringMicro.copyFromUtf8(localrrs.i));
        }
        localUGCVideoInfo.uint32_create_time.set(localrrs.jdField_e_of_type_Int);
        localUGCVideoInfo.uint32_busi_type.set(localrrs.jdField_f_of_type_Int);
        localUGCVideoInfo.uint32_pic_height.set(localrrs.jdField_d_of_type_Int);
        localUGCVideoInfo.uint32_pic_width.set(localrrs.jdField_c_of_type_Int);
        localUGCVideoInfo.uint32_video_height.set(localrrs.jdField_b_of_type_Int);
        localUGCVideoInfo.uint32_video_width.set(localrrs.jdField_a_of_type_Int);
        localArrayList.add(localUGCVideoInfo);
      }
      paramUGCFeedsInfo.msg_ugc_video_info_list.set(localArrayList);
    }
  }
  
  static void c(rrq paramrrq, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    if ((paramrrq.jdField_a_of_type_JavaUtilArrayList != null) && (paramrrq.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramrrq = paramrrq.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramrrq.hasNext())
      {
        rrr localrrr = (rrr)paramrrq.next();
        articlesummary.UGCPicInfo localUGCPicInfo = new articlesummary.UGCPicInfo();
        localUGCPicInfo.uint32_pic_width.set(localrrr.jdField_a_of_type_Int);
        localUGCPicInfo.uint32_pic_height.set(localrrr.jdField_b_of_type_Int);
        if (!TextUtils.isEmpty(localrrr.jdField_b_of_type_JavaLangString)) {
          localUGCPicInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localrrr.jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrrr.jdField_a_of_type_JavaLangString)) {
          localUGCPicInfo.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(localrrr.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrrr.jdField_c_of_type_JavaLangString)) {
          localUGCPicInfo.bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(localrrr.jdField_c_of_type_JavaLangString));
        }
        localUGCPicInfo.is_animation.set(localrrr.jdField_c_of_type_Int);
        localArrayList.add(localUGCPicInfo);
      }
      paramUGCFeedsInfo.msg_ugc_pic_info_list.set(localArrayList);
    }
  }
  
  private static void d(rrq paramrrq, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    paramUGCFeedsInfo.enum_ugc_feeds_card_type.set(paramrrq.jdField_a_of_type_Int);
    paramUGCFeedsInfo.enum_ugc_feeds_src.set(paramrrq.jdField_b_of_type_Int);
    paramUGCFeedsInfo.uint64_cuin.set(paramrrq.jdField_a_of_type_Long);
    if (!TextUtils.isEmpty(paramrrq.jdField_a_of_type_JavaLangString)) {
      paramUGCFeedsInfo.bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(paramrrq.jdField_a_of_type_JavaLangString));
    }
    if (paramrrq.jdField_a_of_type_Rqw != null) {
      paramUGCFeedsInfo.msg_at_multi_level.set(paramrrq.jdField_a_of_type_Rqw.a());
    }
    if (paramrrq.jdField_a_of_type_Rqt != null) {
      paramUGCFeedsInfo.account_profile.set(paramrrq.jdField_a_of_type_Rqt.a());
    }
    if (!TextUtils.isEmpty(paramrrq.jdField_c_of_type_JavaLangString)) {
      paramUGCFeedsInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramrrq.jdField_c_of_type_JavaLangString));
    }
  }
  
  public String toString()
  {
    return "UGCFeedsInfo{ugcFeedsCardType=" + this.jdField_a_of_type_Int + ", ugcPicInfos=" + this.jdField_a_of_type_JavaUtilArrayList + ", ugcVideoInfos=" + this.jdField_b_of_type_JavaUtilArrayList + ", ugcVoiceInfos=" + this.jdField_c_of_type_JavaUtilArrayList + ", cuin=" + this.jdField_a_of_type_Long + ", ugcComments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", nickName='" + this.jdField_b_of_type_JavaLangString + '\'' + ", ugcAtComments=" + this.jdField_a_of_type_Rqw + ", ugcFeedsSrc=" + this.jdField_b_of_type_Int + ", jumpUrl='" + this.jdField_c_of_type_JavaLangString + '\'' + ", accountProfileInfo=" + this.jdField_a_of_type_Rqt + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrq
 * JD-Core Version:    0.7.0.1
 */