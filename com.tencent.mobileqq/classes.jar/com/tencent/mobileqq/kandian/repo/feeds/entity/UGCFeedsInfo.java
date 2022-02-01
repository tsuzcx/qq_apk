package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.handler.UGCVoiceInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
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

public class UGCFeedsInfo
{
  public int a;
  public long a;
  public AccountProfileInfo a;
  public BiuInfo a;
  public String a;
  public ArrayList<UGCPicInfo> a;
  public int b;
  public String b;
  public ArrayList<UGCVideoInfo> b;
  public String c;
  public ArrayList<UGCVoiceInfo> c;
  
  public UGCFeedsInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static articlesummary.UGCFeedsInfo a(UGCFeedsInfo paramUGCFeedsInfo)
  {
    articlesummary.UGCFeedsInfo localUGCFeedsInfo = new articlesummary.UGCFeedsInfo();
    d(paramUGCFeedsInfo, localUGCFeedsInfo);
    c(paramUGCFeedsInfo, localUGCFeedsInfo);
    b(paramUGCFeedsInfo, localUGCFeedsInfo);
    a(paramUGCFeedsInfo, localUGCFeedsInfo);
    return localUGCFeedsInfo;
  }
  
  public static void a(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    ArrayList localArrayList = paramUGCFeedsInfo.jdField_c_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      paramUGCFeedsInfo = paramUGCFeedsInfo.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (paramUGCFeedsInfo.hasNext())
      {
        UGCVoiceInfo localUGCVoiceInfo = (UGCVoiceInfo)paramUGCFeedsInfo.next();
        articlesummary.UGCVoiceInfo localUGCVoiceInfo1 = new articlesummary.UGCVoiceInfo();
        localUGCVoiceInfo1.uint32_duration.set(localUGCVoiceInfo.duration);
        localUGCVoiceInfo1.uint32_file_size.set(localUGCVoiceInfo.fileSize);
        if (!TextUtils.isEmpty(localUGCVoiceInfo.voiceUrl)) {
          localUGCVoiceInfo1.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localUGCVoiceInfo.voiceUrl));
        }
        localArrayList.add(localUGCVoiceInfo1);
      }
      paramUGCFeedsInfo1.msg_ugc_voice_info_list.set(localArrayList);
    }
  }
  
  public static void b(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    ArrayList localArrayList = paramUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      paramUGCFeedsInfo = paramUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramUGCFeedsInfo.hasNext())
      {
        UGCVideoInfo localUGCVideoInfo = (UGCVideoInfo)paramUGCFeedsInfo.next();
        articlesummary.UGCVideoInfo localUGCVideoInfo1 = new articlesummary.UGCVideoInfo();
        localUGCVideoInfo1.uint64_duration.set(localUGCVideoInfo.jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_b_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_video_url.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_a_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_f_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_uuid.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_c_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_d_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.jdField_e_of_type_JavaLangString)) {
          localUGCVideoInfo1.bytes_title.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.g)) {
          localUGCVideoInfo1.bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.g));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.h)) {
          localUGCVideoInfo1.bytes_share_url.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.h));
        }
        if (!TextUtils.isEmpty(localUGCVideoInfo.i)) {
          localUGCVideoInfo1.bytes_vid.set(ByteStringMicro.copyFromUtf8(localUGCVideoInfo.i));
        }
        localUGCVideoInfo1.uint32_create_time.set(localUGCVideoInfo.jdField_e_of_type_Int);
        localUGCVideoInfo1.uint32_busi_type.set(localUGCVideoInfo.jdField_f_of_type_Int);
        localUGCVideoInfo1.uint32_pic_height.set(localUGCVideoInfo.jdField_d_of_type_Int);
        localUGCVideoInfo1.uint32_pic_width.set(localUGCVideoInfo.jdField_c_of_type_Int);
        localUGCVideoInfo1.uint32_video_height.set(localUGCVideoInfo.jdField_b_of_type_Int);
        localUGCVideoInfo1.uint32_video_width.set(localUGCVideoInfo.jdField_a_of_type_Int);
        localArrayList.add(localUGCVideoInfo1);
      }
      paramUGCFeedsInfo1.msg_ugc_video_info_list.set(localArrayList);
    }
  }
  
  private static void c(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    ArrayList localArrayList = paramUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = new ArrayList();
      paramUGCFeedsInfo = paramUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramUGCFeedsInfo.hasNext())
      {
        UGCPicInfo localUGCPicInfo = (UGCPicInfo)paramUGCFeedsInfo.next();
        articlesummary.UGCPicInfo localUGCPicInfo1 = new articlesummary.UGCPicInfo();
        localUGCPicInfo1.uint32_pic_width.set(localUGCPicInfo.jdField_a_of_type_Int);
        localUGCPicInfo1.uint32_pic_height.set(localUGCPicInfo.jdField_b_of_type_Int);
        if (!TextUtils.isEmpty(localUGCPicInfo.jdField_b_of_type_JavaLangString)) {
          localUGCPicInfo1.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(localUGCPicInfo.jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCPicInfo.jdField_a_of_type_JavaLangString)) {
          localUGCPicInfo1.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(localUGCPicInfo.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localUGCPicInfo.jdField_c_of_type_JavaLangString)) {
          localUGCPicInfo1.bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(localUGCPicInfo.jdField_c_of_type_JavaLangString));
        }
        localUGCPicInfo1.is_animation.set(localUGCPicInfo.jdField_c_of_type_Int);
        localArrayList.add(localUGCPicInfo1);
      }
      paramUGCFeedsInfo1.msg_ugc_pic_info_list.set(localArrayList);
    }
  }
  
  private static void d(UGCFeedsInfo paramUGCFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo1)
  {
    paramUGCFeedsInfo1.enum_ugc_feeds_card_type.set(paramUGCFeedsInfo.jdField_a_of_type_Int);
    paramUGCFeedsInfo1.enum_ugc_feeds_src.set(paramUGCFeedsInfo.jdField_b_of_type_Int);
    paramUGCFeedsInfo1.uint64_cuin.set(paramUGCFeedsInfo.jdField_a_of_type_Long);
    if (!TextUtils.isEmpty(paramUGCFeedsInfo.jdField_a_of_type_JavaLangString)) {
      paramUGCFeedsInfo1.bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(paramUGCFeedsInfo.jdField_a_of_type_JavaLangString));
    }
    if (paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) {
      paramUGCFeedsInfo1.msg_at_multi_level.set(paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a());
    }
    if (paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAccountProfileInfo != null) {
      paramUGCFeedsInfo1.account_profile.set(paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAccountProfileInfo.a());
    }
    if (!TextUtils.isEmpty(paramUGCFeedsInfo.jdField_c_of_type_JavaLangString)) {
      paramUGCFeedsInfo1.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(paramUGCFeedsInfo.jdField_c_of_type_JavaLangString));
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UGCFeedsInfo{ugcFeedsCardType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", ugcPicInfos=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append(", ugcVideoInfos=");
    localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList);
    localStringBuilder.append(", ugcVoiceInfos=");
    localStringBuilder.append(this.jdField_c_of_type_JavaUtilArrayList);
    localStringBuilder.append(", cuin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", ugcComments='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ugcAtComments=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo);
    localStringBuilder.append(", ugcFeedsSrc=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", accountProfileInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAccountProfileInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo
 * JD-Core Version:    0.7.0.1
 */