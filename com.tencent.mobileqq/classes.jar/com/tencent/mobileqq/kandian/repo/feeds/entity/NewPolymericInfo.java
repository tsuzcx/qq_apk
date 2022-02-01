package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.kandian.base.ktx.PBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.video.VideoFeedsUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.NewPackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackArticleInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackQuestionAnswerExtraInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackTopicExtraInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;

public class NewPolymericInfo
{
  public int a;
  public long a;
  public UrlJumpInfo a;
  public String a;
  public List<NewPolymericInfo.PackArticleInfo> a;
  public boolean a;
  public int b;
  public UrlJumpInfo b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  
  public NewPolymericInfo()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 6;
  }
  
  public static NewPolymericInfo a(articlesummary.NewPackInfo paramNewPackInfo)
  {
    try
    {
      localObject = new NewPolymericInfo();
      ((NewPolymericInfo)localObject).jdField_a_of_type_Int = paramNewPackInfo.pack_type.get();
      ((NewPolymericInfo)localObject).jdField_a_of_type_JavaLangString = paramNewPackInfo.bytes_top_icon_url.get().toStringUtf8();
      ((NewPolymericInfo)localObject).jdField_b_of_type_JavaLangString = paramNewPackInfo.bytes_top_title.get().toStringUtf8();
      ((NewPolymericInfo)localObject).jdField_c_of_type_JavaLangString = paramNewPackInfo.bytes_more_tips.get().toStringUtf8();
      ((NewPolymericInfo)localObject).jdField_d_of_type_JavaLangString = paramNewPackInfo.bytes_more_href.get().toStringUtf8();
      ((NewPolymericInfo)localObject).jdField_e_of_type_JavaLangString = paramNewPackInfo.bytes_sub_head_icon_url.get().toStringUtf8();
      ((NewPolymericInfo)localObject).jdField_b_of_type_Int = paramNewPackInfo.uin32_head_type.get();
      ((NewPolymericInfo)localObject).jdField_c_of_type_Int = paramNewPackInfo.uint32_video_size_type.get();
      ((NewPolymericInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_head_url_jump_info.get());
      ((NewPolymericInfo)localObject).jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_right_more_url_jump_info.get());
      ((NewPolymericInfo)localObject).jdField_d_of_type_Int = paramNewPackInfo.uint32_column_id.get();
      ((NewPolymericInfo)localObject).jdField_e_of_type_Int = paramNewPackInfo.uint32_follow_status.get();
      if (paramNewPackInfo.rpt_pack_article_list.has())
      {
        ((NewPolymericInfo)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
        paramNewPackInfo = paramNewPackInfo.rpt_pack_article_list.get().iterator();
        while (paramNewPackInfo.hasNext())
        {
          articlesummary.PackArticleInfo localPackArticleInfo = (articlesummary.PackArticleInfo)paramNewPackInfo.next();
          NewPolymericInfo.PackArticleInfo localPackArticleInfo1 = new NewPolymericInfo.PackArticleInfo();
          localPackArticleInfo1.jdField_a_of_type_Long = PBFieldUtils.a(localPackArticleInfo.uint64_article_id);
          localPackArticleInfo1.jdField_a_of_type_JavaLangString = PBFieldUtils.a(localPackArticleInfo.bytes_article_title);
          localPackArticleInfo1.jdField_b_of_type_JavaLangString = PBFieldUtils.a(localPackArticleInfo.bytes_article_summary);
          localPackArticleInfo1.jdField_c_of_type_JavaLangString = PBFieldUtils.a(localPackArticleInfo.bytes_first_page_pic_url);
          localPackArticleInfo1.jdField_d_of_type_JavaLangString = PBFieldUtils.a(localPackArticleInfo.bytes_article_content_url);
          localPackArticleInfo1.jdField_e_of_type_JavaLangString = PBFieldUtils.a(localPackArticleInfo.bytes_subscribe_id);
          localPackArticleInfo1.jdField_f_of_type_JavaLangString = PBFieldUtils.a(localPackArticleInfo.bytes_subscribe_name);
          localPackArticleInfo1.i = PBFieldUtils.a(localPackArticleInfo.bytes_cell_style_id);
          localPackArticleInfo1.jdField_e_of_type_Int = PBFieldUtils.a(localPackArticleInfo.uint32_is_first_page_use_gif);
          localPackArticleInfo1.jdField_g_of_type_Int = PBFieldUtils.a(localPackArticleInfo.uint32_video_comment_count);
          localPackArticleInfo1.k = PBFieldUtils.a(localPackArticleInfo.bytes_report_common_data);
          localPackArticleInfo1.jdField_b_of_type_Long = PBFieldUtils.a(localPackArticleInfo.uint64_algorithm_id);
          localPackArticleInfo1.jdField_a_of_type_Int = PBFieldUtils.a(localPackArticleInfo.uint32_strategy_id);
          localPackArticleInfo1.jdField_g_of_type_JavaLangString = PBFieldUtils.a(localPackArticleInfo.bytes_inner_uniq_id);
          localPackArticleInfo1.jdField_c_of_type_Int = PBFieldUtils.a(localPackArticleInfo.uint32_is_gallery);
          localPackArticleInfo1.jdField_d_of_type_Int = PBFieldUtils.a(localPackArticleInfo.uint32_picture_number);
          localPackArticleInfo1.h = PBFieldUtils.a(localPackArticleInfo.bytes_button_wording, "");
          a(localPackArticleInfo, localPackArticleInfo1);
          b(localPackArticleInfo, localPackArticleInfo1);
          c(localPackArticleInfo, localPackArticleInfo1);
          d(localPackArticleInfo, localPackArticleInfo1);
          e(localPackArticleInfo, localPackArticleInfo1);
          ((NewPolymericInfo)localObject).jdField_a_of_type_JavaUtilList.add(localPackArticleInfo1);
        }
      }
      return localObject;
    }
    catch (Exception paramNewPackInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseInfoFromNewPackInfo error. e = ");
      ((StringBuilder)localObject).append(paramNewPackInfo.toString());
      QLog.e("NewPolymericInfo", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  @VisibleForTesting
  public static void a(articlesummary.PackArticleInfo paramPackArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.uint32_video_play_count.has())
    {
      paramPackArticleInfo1.jdField_f_of_type_Int = paramPackArticleInfo.uint32_video_play_count.get();
      paramPackArticleInfo1.j = VideoFeedsUtil.a(paramPackArticleInfo1.jdField_f_of_type_Int);
    }
  }
  
  @VisibleForTesting
  public static void b(articlesummary.PackArticleInfo paramPackArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.msg_pack_feeds_info.has())
    {
      paramPackArticleInfo1.jdField_c_of_type_Long = PBFieldUtils.a(paramPackArticleInfo.msg_pack_feeds_info.uint64_feeds_id);
      paramPackArticleInfo1.jdField_b_of_type_Int = PBFieldUtils.a(paramPackArticleInfo.msg_pack_feeds_info.uint32_feeds_type);
    }
  }
  
  @VisibleForTesting
  public static void c(articlesummary.PackArticleInfo paramPackArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.msg_pack_topic_list_info.has())
    {
      NewPolymericInfo.PackTopicExtraInfo localPackTopicExtraInfo = new NewPolymericInfo.PackTopicExtraInfo();
      localPackTopicExtraInfo.jdField_a_of_type_Int = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.uint32_join_count);
      localPackTopicExtraInfo.jdField_a_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.bytes_join_wording, "");
      localPackTopicExtraInfo.jdField_b_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.bytes_topic_name, "");
      localPackTopicExtraInfo.jdField_b_of_type_Int = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.uint32_topic_id);
      localPackTopicExtraInfo.jdField_c_of_type_Int = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.uint32_adtag);
      paramPackArticleInfo1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo = localPackTopicExtraInfo;
    }
  }
  
  @VisibleForTesting
  public static void d(articlesummary.PackArticleInfo paramPackArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.msg_pack_question_answer_info.has())
    {
      NewPolymericInfo.PackQuestionAnswerExtraInfo localPackQuestionAnswerExtraInfo = new NewPolymericInfo.PackQuestionAnswerExtraInfo();
      localPackQuestionAnswerExtraInfo.jdField_a_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_question_answer_info.bytes_question_rowkey, "");
      localPackQuestionAnswerExtraInfo.jdField_b_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_question_answer_info.bytes_question_desc, "");
      paramPackArticleInfo1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo = localPackQuestionAnswerExtraInfo;
    }
  }
  
  @VisibleForTesting
  public static void e(articlesummary.PackArticleInfo paramPackArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.msg_pack_video_info.has())
    {
      NewPolymericInfo.PackVideoInfo localPackVideoInfo = new NewPolymericInfo.PackVideoInfo();
      localPackVideoInfo.jdField_a_of_type_Int = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint32_busi_type);
      localPackVideoInfo.jdField_a_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_vid);
      localPackVideoInfo.jdField_b_of_type_Int = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint32_width);
      localPackVideoInfo.jdField_c_of_type_Int = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint32_height);
      localPackVideoInfo.jdField_d_of_type_Int = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint32_duration);
      localPackVideoInfo.jdField_a_of_type_Long = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint64_file_size);
      localPackVideoInfo.jdField_b_of_type_Long = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint64_third_uin);
      localPackVideoInfo.jdField_b_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_video_url);
      localPackVideoInfo.jdField_c_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_share_url);
      localPackVideoInfo.jdField_d_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_uin_name);
      localPackVideoInfo.jdField_e_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_name);
      localPackVideoInfo.jdField_f_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_icon);
      localPackVideoInfo.jdField_g_of_type_JavaLangString = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_action);
      paramPackArticleInfo1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo = localPackVideoInfo;
    }
  }
  
  @VisibleForTesting
  public void a(NewPolymericInfo.PackArticleInfo paramPackArticleInfo, articlesummary.PackArticleInfo paramPackArticleInfo1)
  {
    articlesummary.PackFeedsInfo localPackFeedsInfo = new articlesummary.PackFeedsInfo();
    localPackFeedsInfo.uint64_feeds_id.set(paramPackArticleInfo.jdField_c_of_type_Long);
    localPackFeedsInfo.uint32_feeds_type.set(paramPackArticleInfo.jdField_b_of_type_Int);
    paramPackArticleInfo1.msg_pack_feeds_info.set(localPackFeedsInfo);
  }
  
  public void a(articlesummary.NewPackInfo paramNewPackInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)localIterator.next();
        articlesummary.PackArticleInfo localPackArticleInfo1 = new articlesummary.PackArticleInfo();
        localPackArticleInfo1.uint64_article_id.set(localPackArticleInfo.jdField_a_of_type_Long);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_article_title, localPackArticleInfo.jdField_a_of_type_JavaLangString);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_article_summary, localPackArticleInfo.jdField_b_of_type_JavaLangString);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_first_page_pic_url, localPackArticleInfo.jdField_c_of_type_JavaLangString);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_article_content_url, localPackArticleInfo.jdField_d_of_type_JavaLangString);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_subscribe_id, localPackArticleInfo.jdField_e_of_type_JavaLangString);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_subscribe_name, localPackArticleInfo.jdField_f_of_type_JavaLangString);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_cell_style_id, localPackArticleInfo.i);
        localPackArticleInfo1.uint64_algorithm_id.set(localPackArticleInfo.jdField_b_of_type_Long);
        localPackArticleInfo1.uint32_strategy_id.set(localPackArticleInfo.jdField_a_of_type_Int);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_inner_uniq_id, localPackArticleInfo.jdField_g_of_type_JavaLangString);
        localPackArticleInfo1.uint32_video_play_count.set(localPackArticleInfo.jdField_f_of_type_Int);
        localPackArticleInfo1.uint32_video_comment_count.set(localPackArticleInfo.jdField_g_of_type_Int);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_report_common_data, localPackArticleInfo.k);
        localPackArticleInfo1.uint32_is_gallery.set(localPackArticleInfo.jdField_c_of_type_Int);
        localPackArticleInfo1.uint32_picture_number.set(localPackArticleInfo.jdField_d_of_type_Int);
        RIJPBFieldUtils.a(localPackArticleInfo1.bytes_button_wording, localPackArticleInfo.h);
        a(localPackArticleInfo, localPackArticleInfo1);
        b(localPackArticleInfo, localPackArticleInfo1);
        c(localPackArticleInfo, localPackArticleInfo1);
        d(localPackArticleInfo, localPackArticleInfo1);
        localArrayList.add(localPackArticleInfo1);
      }
      paramNewPackInfo.rpt_pack_article_list.set(localArrayList);
    }
  }
  
  public byte[] a()
  {
    articlesummary.NewPackInfo localNewPackInfo = new articlesummary.NewPackInfo();
    localNewPackInfo.pack_type.set(this.jdField_a_of_type_Int);
    RIJPBFieldUtils.a(localNewPackInfo.bytes_top_icon_url, this.jdField_a_of_type_JavaLangString);
    RIJPBFieldUtils.a(localNewPackInfo.bytes_top_title, this.jdField_b_of_type_JavaLangString);
    RIJPBFieldUtils.a(localNewPackInfo.bytes_more_tips, this.jdField_c_of_type_JavaLangString);
    RIJPBFieldUtils.a(localNewPackInfo.bytes_more_href, this.jdField_d_of_type_JavaLangString);
    RIJPBFieldUtils.a(localNewPackInfo.bytes_sub_head_icon_url, this.jdField_e_of_type_JavaLangString);
    localNewPackInfo.uin32_head_type.set(this.jdField_b_of_type_Int);
    localNewPackInfo.uint32_video_size_type.set(this.jdField_c_of_type_Int);
    localNewPackInfo.uint32_column_id.set(this.jdField_d_of_type_Int);
    if (this.jdField_e_of_type_Int != 0) {
      localNewPackInfo.uint32_follow_status.set(this.jdField_e_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null) {
      localNewPackInfo.msg_head_url_jump_info.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.a());
    }
    if (this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo != null) {
      localNewPackInfo.msg_right_more_url_jump_info.set(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.a());
    }
    a(localNewPackInfo);
    return localNewPackInfo.toByteArray();
  }
  
  @VisibleForTesting
  public void b(NewPolymericInfo.PackArticleInfo paramPackArticleInfo, articlesummary.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo != null)
    {
      articlesummary.PackTopicExtraInfo localPackTopicExtraInfo = new articlesummary.PackTopicExtraInfo();
      RIJPBFieldUtils.a(localPackTopicExtraInfo.bytes_join_wording, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_a_of_type_JavaLangString);
      RIJPBFieldUtils.a(localPackTopicExtraInfo.bytes_topic_name, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_b_of_type_JavaLangString);
      localPackTopicExtraInfo.uint32_join_count.set(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_a_of_type_Int);
      localPackTopicExtraInfo.uint32_topic_id.set(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_b_of_type_Int);
      localPackTopicExtraInfo.uint32_adtag.set(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.jdField_c_of_type_Int);
      paramPackArticleInfo1.msg_pack_topic_list_info.set(localPackTopicExtraInfo);
    }
  }
  
  @VisibleForTesting
  public void c(NewPolymericInfo.PackArticleInfo paramPackArticleInfo, articlesummary.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo != null)
    {
      articlesummary.PackQuestionAnswerExtraInfo localPackQuestionAnswerExtraInfo = new articlesummary.PackQuestionAnswerExtraInfo();
      RIJPBFieldUtils.a(localPackQuestionAnswerExtraInfo.bytes_question_rowkey, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo.jdField_a_of_type_JavaLangString);
      RIJPBFieldUtils.a(localPackQuestionAnswerExtraInfo.bytes_question_desc, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo.jdField_b_of_type_JavaLangString);
      paramPackArticleInfo1.msg_pack_question_answer_info.set(localPackQuestionAnswerExtraInfo);
    }
  }
  
  @VisibleForTesting
  public void d(NewPolymericInfo.PackArticleInfo paramPackArticleInfo, articlesummary.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo != null)
    {
      articlesummary.PackVideoInfo localPackVideoInfo = new articlesummary.PackVideoInfo();
      localPackVideoInfo.uint32_busi_type.set(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString)) {
        localPackVideoInfo.bytes_vid.set(ByteStringMicro.copyFromUtf8(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_JavaLangString));
      }
      localPackVideoInfo.uint32_width.set(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_b_of_type_Int);
      localPackVideoInfo.uint32_height.set(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_c_of_type_Int);
      localPackVideoInfo.uint32_duration.set(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_d_of_type_Int);
      localPackVideoInfo.uint64_file_size.set(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_a_of_type_Long);
      RIJPBFieldUtils.a(localPackVideoInfo.bytes_video_url, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_b_of_type_JavaLangString);
      RIJPBFieldUtils.a(localPackVideoInfo.bytes_share_url, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_c_of_type_JavaLangString);
      localPackVideoInfo.uint64_third_uin.set(paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_b_of_type_Long);
      RIJPBFieldUtils.a(localPackVideoInfo.bytes_third_uin_name, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_d_of_type_JavaLangString);
      RIJPBFieldUtils.a(localPackVideoInfo.bytes_third_name, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_e_of_type_JavaLangString);
      RIJPBFieldUtils.a(localPackVideoInfo.bytes_third_icon, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_f_of_type_JavaLangString);
      RIJPBFieldUtils.a(localPackVideoInfo.bytes_third_action, paramPackArticleInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.jdField_g_of_type_JavaLangString);
      paramPackArticleInfo1.msg_pack_video_info.set(localPackVideoInfo);
    }
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("NewpolymericInfo uin = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject1).append(" polymericType = ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append("\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = this.jdField_a_of_type_JavaUtilList;
    Object localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = localObject1;
      if (!((List)localObject3).isEmpty())
      {
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (NewPolymericInfo.PackArticleInfo)((Iterator)localObject3).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(localObject2);
          localObject1 = localStringBuilder.toString();
        }
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo
 * JD-Core Version:    0.7.0.1
 */