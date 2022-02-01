import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
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

public class rps
{
  public int a;
  public long a;
  public UrlJumpInfo a;
  public String a;
  public List<rpt> a;
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
  
  public rps()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 6;
  }
  
  public static rps a(articlesummary.NewPackInfo paramNewPackInfo)
  {
    try
    {
      rps localrps = new rps();
      localrps.jdField_a_of_type_Int = paramNewPackInfo.pack_type.get();
      localrps.jdField_a_of_type_JavaLangString = paramNewPackInfo.bytes_top_icon_url.get().toStringUtf8();
      localrps.jdField_b_of_type_JavaLangString = paramNewPackInfo.bytes_top_title.get().toStringUtf8();
      localrps.jdField_c_of_type_JavaLangString = paramNewPackInfo.bytes_more_tips.get().toStringUtf8();
      localrps.jdField_d_of_type_JavaLangString = paramNewPackInfo.bytes_more_href.get().toStringUtf8();
      localrps.jdField_e_of_type_JavaLangString = paramNewPackInfo.bytes_sub_head_icon_url.get().toStringUtf8();
      localrps.jdField_b_of_type_Int = paramNewPackInfo.uin32_head_type.get();
      localrps.jdField_c_of_type_Int = paramNewPackInfo.uint32_video_size_type.get();
      localrps.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_head_url_jump_info.get());
      localrps.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_right_more_url_jump_info.get());
      localrps.jdField_d_of_type_Int = paramNewPackInfo.uint32_column_id.get();
      localrps.jdField_e_of_type_Int = paramNewPackInfo.uint32_follow_status.get();
      if (paramNewPackInfo.rpt_pack_article_list.has())
      {
        localrps.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramNewPackInfo = paramNewPackInfo.rpt_pack_article_list.get().iterator();
        while (paramNewPackInfo.hasNext())
        {
          articlesummary.PackArticleInfo localPackArticleInfo = (articlesummary.PackArticleInfo)paramNewPackInfo.next();
          rpt localrpt = new rpt();
          localrpt.jdField_a_of_type_Long = qdv.a(localPackArticleInfo.uint64_article_id);
          localrpt.jdField_a_of_type_JavaLangString = qdv.a(localPackArticleInfo.bytes_article_title);
          localrpt.jdField_b_of_type_JavaLangString = qdv.a(localPackArticleInfo.bytes_article_summary);
          localrpt.jdField_c_of_type_JavaLangString = qdv.a(localPackArticleInfo.bytes_first_page_pic_url);
          localrpt.jdField_d_of_type_JavaLangString = qdv.a(localPackArticleInfo.bytes_article_content_url);
          localrpt.jdField_e_of_type_JavaLangString = qdv.a(localPackArticleInfo.bytes_subscribe_id);
          localrpt.jdField_f_of_type_JavaLangString = qdv.a(localPackArticleInfo.bytes_subscribe_name);
          localrpt.i = qdv.a(localPackArticleInfo.bytes_cell_style_id);
          localrpt.jdField_e_of_type_Int = qdv.a(localPackArticleInfo.uint32_is_first_page_use_gif);
          localrpt.jdField_g_of_type_Int = qdv.a(localPackArticleInfo.uint32_video_comment_count);
          localrpt.k = qdv.a(localPackArticleInfo.bytes_report_common_data);
          localrpt.jdField_b_of_type_Long = qdv.a(localPackArticleInfo.uint64_algorithm_id);
          localrpt.jdField_a_of_type_Int = qdv.a(localPackArticleInfo.uint32_strategy_id);
          localrpt.jdField_g_of_type_JavaLangString = qdv.a(localPackArticleInfo.bytes_inner_uniq_id);
          localrpt.jdField_c_of_type_Int = qdv.a(localPackArticleInfo.uint32_is_gallery);
          localrpt.jdField_d_of_type_Int = qdv.a(localPackArticleInfo.uint32_picture_number);
          localrpt.h = qdv.a(localPackArticleInfo.bytes_button_wording, "");
          a(localPackArticleInfo, localrpt);
          b(localPackArticleInfo, localrpt);
          c(localPackArticleInfo, localrpt);
          d(localPackArticleInfo, localrpt);
          e(localPackArticleInfo, localrpt);
          localrps.jdField_a_of_type_JavaUtilList.add(localrpt);
        }
      }
      return localrps;
    }
    catch (Exception paramNewPackInfo)
    {
      QLog.e("NewPolymericInfo", 1, "parseInfoFromNewPackInfo error. e = " + paramNewPackInfo.toString());
      return null;
    }
  }
  
  @VisibleForTesting
  static void a(articlesummary.PackArticleInfo paramPackArticleInfo, rpt paramrpt)
  {
    if (paramPackArticleInfo.uint32_video_play_count.has())
    {
      paramrpt.jdField_f_of_type_Int = paramPackArticleInfo.uint32_video_play_count.get();
      paramrpt.j = six.c(paramrpt.jdField_f_of_type_Int);
    }
  }
  
  @VisibleForTesting
  static void b(articlesummary.PackArticleInfo paramPackArticleInfo, rpt paramrpt)
  {
    if (paramPackArticleInfo.msg_pack_feeds_info.has())
    {
      paramrpt.jdField_c_of_type_Long = qdv.a(paramPackArticleInfo.msg_pack_feeds_info.uint64_feeds_id);
      paramrpt.jdField_b_of_type_Int = qdv.a(paramPackArticleInfo.msg_pack_feeds_info.uint32_feeds_type);
    }
  }
  
  @VisibleForTesting
  static void c(articlesummary.PackArticleInfo paramPackArticleInfo, rpt paramrpt)
  {
    if (paramPackArticleInfo.msg_pack_topic_list_info.has())
    {
      rpv localrpv = new rpv();
      localrpv.jdField_a_of_type_Int = qdv.a(paramPackArticleInfo.msg_pack_topic_list_info.uint32_join_count);
      localrpv.jdField_a_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_topic_list_info.bytes_join_wording, "");
      localrpv.jdField_b_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_topic_list_info.bytes_topic_name, "");
      localrpv.jdField_b_of_type_Int = qdv.a(paramPackArticleInfo.msg_pack_topic_list_info.uint32_topic_id);
      localrpv.jdField_c_of_type_Int = qdv.a(paramPackArticleInfo.msg_pack_topic_list_info.uint32_adtag);
      paramrpt.jdField_a_of_type_Rpv = localrpv;
    }
  }
  
  @VisibleForTesting
  static void d(articlesummary.PackArticleInfo paramPackArticleInfo, rpt paramrpt)
  {
    if (paramPackArticleInfo.msg_pack_question_answer_info.has())
    {
      rpu localrpu = new rpu();
      localrpu.jdField_a_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_question_answer_info.bytes_question_rowkey, "");
      localrpu.jdField_b_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_question_answer_info.bytes_question_desc, "");
      paramrpt.jdField_a_of_type_Rpu = localrpu;
    }
  }
  
  @VisibleForTesting
  static void e(articlesummary.PackArticleInfo paramPackArticleInfo, rpt paramrpt)
  {
    if (paramPackArticleInfo.msg_pack_video_info.has())
    {
      rpw localrpw = new rpw();
      localrpw.jdField_a_of_type_Int = qdv.a(paramPackArticleInfo.msg_pack_video_info.uint32_busi_type);
      localrpw.jdField_a_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_video_info.bytes_vid);
      localrpw.jdField_b_of_type_Int = qdv.a(paramPackArticleInfo.msg_pack_video_info.uint32_width);
      localrpw.jdField_c_of_type_Int = qdv.a(paramPackArticleInfo.msg_pack_video_info.uint32_height);
      localrpw.jdField_d_of_type_Int = qdv.a(paramPackArticleInfo.msg_pack_video_info.uint32_duration);
      localrpw.jdField_a_of_type_Long = qdv.a(paramPackArticleInfo.msg_pack_video_info.uint64_file_size);
      localrpw.jdField_b_of_type_Long = qdv.a(paramPackArticleInfo.msg_pack_video_info.uint64_third_uin);
      localrpw.jdField_b_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_video_info.bytes_video_url);
      localrpw.jdField_c_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_video_info.bytes_share_url);
      localrpw.jdField_d_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_uin_name);
      localrpw.jdField_e_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_name);
      localrpw.jdField_f_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_icon);
      localrpw.jdField_g_of_type_JavaLangString = qdv.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_action);
      paramrpt.jdField_a_of_type_Rpw = localrpw;
    }
  }
  
  @VisibleForTesting
  void a(rpt paramrpt, articlesummary.PackArticleInfo paramPackArticleInfo)
  {
    articlesummary.PackFeedsInfo localPackFeedsInfo = new articlesummary.PackFeedsInfo();
    localPackFeedsInfo.uint64_feeds_id.set(paramrpt.jdField_c_of_type_Long);
    localPackFeedsInfo.uint32_feeds_type.set(paramrpt.jdField_b_of_type_Int);
    paramPackArticleInfo.msg_pack_feeds_info.set(localPackFeedsInfo);
  }
  
  void a(articlesummary.NewPackInfo paramNewPackInfo)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        rpt localrpt = (rpt)localIterator.next();
        articlesummary.PackArticleInfo localPackArticleInfo = new articlesummary.PackArticleInfo();
        localPackArticleInfo.uint64_article_id.set(localrpt.jdField_a_of_type_Long);
        qxl.a(localPackArticleInfo.bytes_article_title, localrpt.jdField_a_of_type_JavaLangString);
        qxl.a(localPackArticleInfo.bytes_article_summary, localrpt.jdField_b_of_type_JavaLangString);
        qxl.a(localPackArticleInfo.bytes_first_page_pic_url, localrpt.jdField_c_of_type_JavaLangString);
        qxl.a(localPackArticleInfo.bytes_article_content_url, localrpt.jdField_d_of_type_JavaLangString);
        qxl.a(localPackArticleInfo.bytes_subscribe_id, localrpt.jdField_e_of_type_JavaLangString);
        qxl.a(localPackArticleInfo.bytes_subscribe_name, localrpt.jdField_f_of_type_JavaLangString);
        qxl.a(localPackArticleInfo.bytes_cell_style_id, localrpt.i);
        localPackArticleInfo.uint64_algorithm_id.set(localrpt.jdField_b_of_type_Long);
        localPackArticleInfo.uint32_strategy_id.set(localrpt.jdField_a_of_type_Int);
        qxl.a(localPackArticleInfo.bytes_inner_uniq_id, localrpt.jdField_g_of_type_JavaLangString);
        localPackArticleInfo.uint32_video_play_count.set(localrpt.jdField_f_of_type_Int);
        localPackArticleInfo.uint32_video_comment_count.set(localrpt.jdField_g_of_type_Int);
        qxl.a(localPackArticleInfo.bytes_report_common_data, localrpt.k);
        localPackArticleInfo.uint32_is_gallery.set(localrpt.jdField_c_of_type_Int);
        localPackArticleInfo.uint32_picture_number.set(localrpt.jdField_d_of_type_Int);
        qxl.a(localPackArticleInfo.bytes_button_wording, localrpt.h);
        a(localrpt, localPackArticleInfo);
        b(localrpt, localPackArticleInfo);
        c(localrpt, localPackArticleInfo);
        d(localrpt, localPackArticleInfo);
        localArrayList.add(localPackArticleInfo);
      }
      paramNewPackInfo.rpt_pack_article_list.set(localArrayList);
    }
  }
  
  public byte[] a()
  {
    articlesummary.NewPackInfo localNewPackInfo = new articlesummary.NewPackInfo();
    localNewPackInfo.pack_type.set(this.jdField_a_of_type_Int);
    qxl.a(localNewPackInfo.bytes_top_icon_url, this.jdField_a_of_type_JavaLangString);
    qxl.a(localNewPackInfo.bytes_top_title, this.jdField_b_of_type_JavaLangString);
    qxl.a(localNewPackInfo.bytes_more_tips, this.jdField_c_of_type_JavaLangString);
    qxl.a(localNewPackInfo.bytes_more_href, this.jdField_d_of_type_JavaLangString);
    qxl.a(localNewPackInfo.bytes_sub_head_icon_url, this.jdField_e_of_type_JavaLangString);
    localNewPackInfo.uin32_head_type.set(this.jdField_b_of_type_Int);
    localNewPackInfo.uint32_video_size_type.set(this.jdField_c_of_type_Int);
    localNewPackInfo.uint32_column_id.set(this.jdField_d_of_type_Int);
    if (this.jdField_e_of_type_Int != 0) {
      localNewPackInfo.uint32_follow_status.set(this.jdField_e_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
      localNewPackInfo.msg_head_url_jump_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.a());
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
      localNewPackInfo.msg_right_more_url_jump_info.set(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.a());
    }
    a(localNewPackInfo);
    return localNewPackInfo.toByteArray();
  }
  
  @VisibleForTesting
  void b(rpt paramrpt, articlesummary.PackArticleInfo paramPackArticleInfo)
  {
    if (paramrpt.jdField_a_of_type_Rpv != null)
    {
      articlesummary.PackTopicExtraInfo localPackTopicExtraInfo = new articlesummary.PackTopicExtraInfo();
      qxl.a(localPackTopicExtraInfo.bytes_join_wording, paramrpt.jdField_a_of_type_Rpv.jdField_a_of_type_JavaLangString);
      qxl.a(localPackTopicExtraInfo.bytes_topic_name, paramrpt.jdField_a_of_type_Rpv.jdField_b_of_type_JavaLangString);
      localPackTopicExtraInfo.uint32_join_count.set(paramrpt.jdField_a_of_type_Rpv.jdField_a_of_type_Int);
      localPackTopicExtraInfo.uint32_topic_id.set(paramrpt.jdField_a_of_type_Rpv.jdField_b_of_type_Int);
      localPackTopicExtraInfo.uint32_adtag.set(paramrpt.jdField_a_of_type_Rpv.jdField_c_of_type_Int);
      paramPackArticleInfo.msg_pack_topic_list_info.set(localPackTopicExtraInfo);
    }
  }
  
  @VisibleForTesting
  void c(rpt paramrpt, articlesummary.PackArticleInfo paramPackArticleInfo)
  {
    if (paramrpt.jdField_a_of_type_Rpu != null)
    {
      articlesummary.PackQuestionAnswerExtraInfo localPackQuestionAnswerExtraInfo = new articlesummary.PackQuestionAnswerExtraInfo();
      qxl.a(localPackQuestionAnswerExtraInfo.bytes_question_rowkey, paramrpt.jdField_a_of_type_Rpu.jdField_a_of_type_JavaLangString);
      qxl.a(localPackQuestionAnswerExtraInfo.bytes_question_desc, paramrpt.jdField_a_of_type_Rpu.jdField_b_of_type_JavaLangString);
      paramPackArticleInfo.msg_pack_question_answer_info.set(localPackQuestionAnswerExtraInfo);
    }
  }
  
  @VisibleForTesting
  void d(rpt paramrpt, articlesummary.PackArticleInfo paramPackArticleInfo)
  {
    if (paramrpt.jdField_a_of_type_Rpw != null)
    {
      articlesummary.PackVideoInfo localPackVideoInfo = new articlesummary.PackVideoInfo();
      localPackVideoInfo.uint32_busi_type.set(paramrpt.jdField_a_of_type_Rpw.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramrpt.jdField_a_of_type_Rpw.jdField_a_of_type_JavaLangString)) {
        localPackVideoInfo.bytes_vid.set(ByteStringMicro.copyFromUtf8(paramrpt.jdField_a_of_type_Rpw.jdField_a_of_type_JavaLangString));
      }
      localPackVideoInfo.uint32_width.set(paramrpt.jdField_a_of_type_Rpw.jdField_b_of_type_Int);
      localPackVideoInfo.uint32_height.set(paramrpt.jdField_a_of_type_Rpw.jdField_c_of_type_Int);
      localPackVideoInfo.uint32_duration.set(paramrpt.jdField_a_of_type_Rpw.jdField_d_of_type_Int);
      localPackVideoInfo.uint64_file_size.set(paramrpt.jdField_a_of_type_Rpw.jdField_a_of_type_Long);
      qxl.a(localPackVideoInfo.bytes_video_url, paramrpt.jdField_a_of_type_Rpw.jdField_b_of_type_JavaLangString);
      qxl.a(localPackVideoInfo.bytes_share_url, paramrpt.jdField_a_of_type_Rpw.jdField_c_of_type_JavaLangString);
      localPackVideoInfo.uint64_third_uin.set(paramrpt.jdField_a_of_type_Rpw.jdField_b_of_type_Long);
      qxl.a(localPackVideoInfo.bytes_third_uin_name, paramrpt.jdField_a_of_type_Rpw.jdField_d_of_type_JavaLangString);
      qxl.a(localPackVideoInfo.bytes_third_name, paramrpt.jdField_a_of_type_Rpw.jdField_e_of_type_JavaLangString);
      qxl.a(localPackVideoInfo.bytes_third_icon, paramrpt.jdField_a_of_type_Rpw.jdField_f_of_type_JavaLangString);
      qxl.a(localPackVideoInfo.bytes_third_action, paramrpt.jdField_a_of_type_Rpw.jdField_g_of_type_JavaLangString);
      paramPackArticleInfo.msg_pack_video_info.set(localPackVideoInfo);
    }
  }
  
  public String toString()
  {
    String str = "NewpolymericInfo uin = " + this.jdField_a_of_type_Long + " polymericType = " + this.jdField_a_of_type_Int + "\n";
    Object localObject = str;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = str;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          rpt localrpt = (rpt)((Iterator)localObject).next();
          str = str + localrpt;
        }
        localObject = str;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rps
 * JD-Core Version:    0.7.0.1
 */