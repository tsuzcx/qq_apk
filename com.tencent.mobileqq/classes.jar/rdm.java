import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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

public class rdm
{
  public int a;
  public long a;
  public UrlJumpInfo a;
  public String a;
  public List<rdn> a;
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
  
  public rdm()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 6;
  }
  
  public static rdm a(articlesummary.NewPackInfo paramNewPackInfo)
  {
    try
    {
      rdm localrdm = new rdm();
      localrdm.jdField_a_of_type_Int = paramNewPackInfo.pack_type.get();
      localrdm.jdField_a_of_type_JavaLangString = paramNewPackInfo.bytes_top_icon_url.get().toStringUtf8();
      localrdm.jdField_b_of_type_JavaLangString = paramNewPackInfo.bytes_top_title.get().toStringUtf8();
      localrdm.jdField_c_of_type_JavaLangString = paramNewPackInfo.bytes_more_tips.get().toStringUtf8();
      localrdm.jdField_d_of_type_JavaLangString = paramNewPackInfo.bytes_more_href.get().toStringUtf8();
      localrdm.jdField_e_of_type_JavaLangString = paramNewPackInfo.bytes_sub_head_icon_url.get().toStringUtf8();
      localrdm.jdField_b_of_type_Int = paramNewPackInfo.uin32_head_type.get();
      localrdm.jdField_c_of_type_Int = paramNewPackInfo.uint32_video_size_type.get();
      localrdm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_head_url_jump_info.get());
      localrdm.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_right_more_url_jump_info.get());
      localrdm.jdField_d_of_type_Int = paramNewPackInfo.uint32_column_id.get();
      localrdm.jdField_e_of_type_Int = paramNewPackInfo.uint32_follow_status.get();
      if (paramNewPackInfo.rpt_pack_article_list.has())
      {
        localrdm.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramNewPackInfo = paramNewPackInfo.rpt_pack_article_list.get().iterator();
        while (paramNewPackInfo.hasNext())
        {
          articlesummary.PackArticleInfo localPackArticleInfo = (articlesummary.PackArticleInfo)paramNewPackInfo.next();
          rdn localrdn = new rdn();
          localrdn.jdField_a_of_type_Long = psy.a(localPackArticleInfo.uint64_article_id);
          if (localPackArticleInfo.bytes_article_title.has()) {
            localrdn.jdField_a_of_type_JavaLangString = localPackArticleInfo.bytes_article_title.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_article_summary.has()) {
            localrdn.jdField_b_of_type_JavaLangString = localPackArticleInfo.bytes_article_summary.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_first_page_pic_url.has()) {
            localrdn.jdField_c_of_type_JavaLangString = localPackArticleInfo.bytes_first_page_pic_url.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_article_content_url.has()) {
            localrdn.jdField_d_of_type_JavaLangString = localPackArticleInfo.bytes_article_content_url.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_subscribe_id.has()) {
            localrdn.jdField_e_of_type_JavaLangString = localPackArticleInfo.bytes_subscribe_id.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_subscribe_name.has()) {
            localrdn.jdField_f_of_type_JavaLangString = localPackArticleInfo.bytes_subscribe_name.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_cell_style_id.has()) {
            localrdn.i = localPackArticleInfo.bytes_cell_style_id.get().toStringUtf8();
          }
          if (localPackArticleInfo.uint32_is_first_page_use_gif.has()) {
            localrdn.jdField_e_of_type_Int = localPackArticleInfo.uint32_is_first_page_use_gif.get();
          }
          if (localPackArticleInfo.uint32_video_comment_count.has()) {
            localrdn.jdField_g_of_type_Int = localPackArticleInfo.uint32_video_comment_count.get();
          }
          if (localPackArticleInfo.uint32_video_play_count.has())
          {
            localrdn.jdField_f_of_type_Int = localPackArticleInfo.uint32_video_play_count.get();
            localrdn.j = rwv.c(localrdn.jdField_f_of_type_Int);
          }
          if (localPackArticleInfo.bytes_report_common_data.has()) {
            localrdn.k = localPackArticleInfo.bytes_report_common_data.get().toStringUtf8();
          }
          localrdn.jdField_b_of_type_Long = psy.a(localPackArticleInfo.uint64_algorithm_id);
          localrdn.jdField_a_of_type_Int = psy.a(localPackArticleInfo.uint32_strategy_id);
          if (localPackArticleInfo.bytes_inner_uniq_id.has()) {
            localrdn.jdField_g_of_type_JavaLangString = localPackArticleInfo.bytes_inner_uniq_id.get().toStringUtf8();
          }
          localrdn.jdField_c_of_type_Int = psy.a(localPackArticleInfo.uint32_is_gallery);
          localrdn.jdField_d_of_type_Int = psy.a(localPackArticleInfo.uint32_picture_number);
          localrdn.h = localPackArticleInfo.bytes_button_wording.get().toStringUtf8();
          if (localPackArticleInfo.msg_pack_feeds_info.has())
          {
            localrdn.jdField_c_of_type_Long = psy.a(localPackArticleInfo.msg_pack_feeds_info.uint64_feeds_id);
            localrdn.jdField_b_of_type_Int = psy.a(localPackArticleInfo.msg_pack_feeds_info.uint32_feeds_type);
          }
          Object localObject;
          if (localPackArticleInfo.msg_pack_topic_list_info.has())
          {
            localObject = new rdp();
            ((rdp)localObject).jdField_a_of_type_Int = psy.a(localPackArticleInfo.msg_pack_topic_list_info.uint32_join_count);
            ((rdp)localObject).jdField_a_of_type_JavaLangString = localPackArticleInfo.msg_pack_topic_list_info.bytes_join_wording.get().toStringUtf8();
            ((rdp)localObject).jdField_b_of_type_JavaLangString = localPackArticleInfo.msg_pack_topic_list_info.bytes_topic_name.get().toStringUtf8();
            ((rdp)localObject).jdField_b_of_type_Int = psy.a(localPackArticleInfo.msg_pack_topic_list_info.uint32_topic_id);
            ((rdp)localObject).jdField_c_of_type_Int = psy.a(localPackArticleInfo.msg_pack_topic_list_info.uint32_adtag);
            localrdn.jdField_a_of_type_Rdp = ((rdp)localObject);
          }
          if (localPackArticleInfo.msg_pack_question_answer_info.has())
          {
            localObject = new rdo();
            ((rdo)localObject).jdField_a_of_type_JavaLangString = localPackArticleInfo.msg_pack_question_answer_info.bytes_question_rowkey.get().toStringUtf8();
            ((rdo)localObject).jdField_b_of_type_JavaLangString = localPackArticleInfo.msg_pack_question_answer_info.bytes_question_desc.get().toStringUtf8();
            localrdn.jdField_a_of_type_Rdo = ((rdo)localObject);
          }
          if (localPackArticleInfo.msg_pack_video_info.has())
          {
            localObject = new rdq();
            ((rdq)localObject).jdField_a_of_type_Int = psy.a(localPackArticleInfo.msg_pack_video_info.uint32_busi_type);
            if (localPackArticleInfo.msg_pack_video_info.bytes_vid.has()) {
              ((rdq)localObject).jdField_a_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_vid.get().toStringUtf8();
            }
            ((rdq)localObject).jdField_a_of_type_Int = psy.a(localPackArticleInfo.msg_pack_video_info.uint32_busi_type);
            ((rdq)localObject).jdField_b_of_type_Int = psy.a(localPackArticleInfo.msg_pack_video_info.uint32_width);
            ((rdq)localObject).jdField_c_of_type_Int = psy.a(localPackArticleInfo.msg_pack_video_info.uint32_height);
            ((rdq)localObject).jdField_d_of_type_Int = psy.a(localPackArticleInfo.msg_pack_video_info.uint32_duration);
            ((rdq)localObject).jdField_a_of_type_Long = psy.a(localPackArticleInfo.msg_pack_video_info.uint64_file_size);
            ((rdq)localObject).jdField_b_of_type_Long = psy.a(localPackArticleInfo.msg_pack_video_info.uint64_third_uin);
            if (localPackArticleInfo.msg_pack_video_info.bytes_video_url.has()) {
              ((rdq)localObject).jdField_b_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_video_url.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_share_url.has()) {
              ((rdq)localObject).jdField_c_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_share_url.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_uin_name.has()) {
              ((rdq)localObject).jdField_d_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_third_uin_name.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_name.has()) {
              ((rdq)localObject).jdField_e_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_third_name.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_icon.has()) {
              ((rdq)localObject).jdField_f_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_third_icon.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_action.has()) {
              ((rdq)localObject).jdField_g_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_third_action.get().toStringUtf8();
            }
            localrdn.jdField_a_of_type_Rdq = ((rdq)localObject);
          }
          localrdm.jdField_a_of_type_JavaUtilList.add(localrdn);
        }
      }
      return localrdm;
    }
    catch (Exception paramNewPackInfo)
    {
      return null;
    }
  }
  
  public byte[] a()
  {
    articlesummary.NewPackInfo localNewPackInfo = new articlesummary.NewPackInfo();
    localNewPackInfo.pack_type.set(this.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localNewPackInfo.bytes_top_icon_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localNewPackInfo.bytes_top_title.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      localNewPackInfo.bytes_more_tips.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      localNewPackInfo.bytes_more_href.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localNewPackInfo.bytes_sub_head_icon_url.set(ByteStringMicro.copyFromUtf8(this.jdField_e_of_type_JavaLangString));
    }
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
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        rdn localrdn = (rdn)localIterator.next();
        articlesummary.PackArticleInfo localPackArticleInfo = new articlesummary.PackArticleInfo();
        localPackArticleInfo.uint64_article_id.set(localrdn.jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_article_title.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrdn.jdField_b_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_article_summary.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrdn.jdField_c_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_first_page_pic_url.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrdn.jdField_d_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_article_content_url.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrdn.jdField_e_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrdn.jdField_f_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_subscribe_name.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrdn.i)) {
          localPackArticleInfo.bytes_cell_style_id.set(ByteStringMicro.copyFromUtf8(localrdn.i));
        }
        localPackArticleInfo.uint64_algorithm_id.set(localrdn.jdField_b_of_type_Long);
        localPackArticleInfo.uint32_strategy_id.set(localrdn.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(localrdn.jdField_g_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_g_of_type_JavaLangString));
        }
        localPackArticleInfo.uint32_video_play_count.set(localrdn.jdField_f_of_type_Int);
        localPackArticleInfo.uint32_video_comment_count.set(localrdn.jdField_g_of_type_Int);
        if (!TextUtils.isEmpty(localrdn.k)) {
          localPackArticleInfo.bytes_report_common_data.set(ByteStringMicro.copyFromUtf8(localrdn.k));
        }
        localPackArticleInfo.uint32_is_gallery.set(localrdn.jdField_c_of_type_Int);
        localPackArticleInfo.uint32_picture_number.set(localrdn.jdField_d_of_type_Int);
        Object localObject1 = new articlesummary.PackFeedsInfo();
        ((articlesummary.PackFeedsInfo)localObject1).uint64_feeds_id.set(localrdn.jdField_c_of_type_Long);
        ((articlesummary.PackFeedsInfo)localObject1).uint32_feeds_type.set(localrdn.jdField_b_of_type_Int);
        Object localObject2;
        if (localrdn.jdField_a_of_type_Rdp != null)
        {
          localObject2 = new articlesummary.PackTopicExtraInfo();
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdp.jdField_a_of_type_JavaLangString)) {
            ((articlesummary.PackTopicExtraInfo)localObject2).bytes_join_wording.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdp.jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdp.jdField_b_of_type_JavaLangString)) {
            ((articlesummary.PackTopicExtraInfo)localObject2).bytes_topic_name.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdp.jdField_b_of_type_JavaLangString));
          }
          ((articlesummary.PackTopicExtraInfo)localObject2).uint32_join_count.set(localrdn.jdField_a_of_type_Rdp.jdField_a_of_type_Int);
          ((articlesummary.PackTopicExtraInfo)localObject2).uint32_topic_id.set(localrdn.jdField_a_of_type_Rdp.jdField_b_of_type_Int);
          ((articlesummary.PackTopicExtraInfo)localObject2).uint32_adtag.set(localrdn.jdField_a_of_type_Rdp.jdField_c_of_type_Int);
          localPackArticleInfo.msg_pack_topic_list_info.set((MessageMicro)localObject2);
        }
        if (localrdn.jdField_a_of_type_Rdo != null)
        {
          localObject2 = new articlesummary.PackQuestionAnswerExtraInfo();
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdo.jdField_a_of_type_JavaLangString)) {
            ((articlesummary.PackQuestionAnswerExtraInfo)localObject2).bytes_question_rowkey.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdo.jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdo.jdField_b_of_type_JavaLangString)) {
            ((articlesummary.PackQuestionAnswerExtraInfo)localObject2).bytes_question_desc.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdo.jdField_b_of_type_JavaLangString));
          }
          localPackArticleInfo.msg_pack_question_answer_info.set((MessageMicro)localObject2);
        }
        localPackArticleInfo.bytes_button_wording.set(ByteStringMicro.copyFromUtf8(localrdn.h));
        localPackArticleInfo.msg_pack_feeds_info.set((MessageMicro)localObject1);
        if (localrdn.jdField_a_of_type_Rdq != null)
        {
          localObject1 = new articlesummary.PackVideoInfo();
          ((articlesummary.PackVideoInfo)localObject1).uint32_busi_type.set(localrdn.jdField_a_of_type_Rdq.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdq.jdField_a_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_vid.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdq.jdField_a_of_type_JavaLangString));
          }
          ((articlesummary.PackVideoInfo)localObject1).uint32_width.set(localrdn.jdField_a_of_type_Rdq.jdField_b_of_type_Int);
          ((articlesummary.PackVideoInfo)localObject1).uint32_height.set(localrdn.jdField_a_of_type_Rdq.jdField_c_of_type_Int);
          ((articlesummary.PackVideoInfo)localObject1).uint32_duration.set(localrdn.jdField_a_of_type_Rdq.jdField_d_of_type_Int);
          ((articlesummary.PackVideoInfo)localObject1).uint64_file_size.set(localrdn.jdField_a_of_type_Rdq.jdField_a_of_type_Long);
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdq.jdField_b_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_video_url.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdq.jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdq.jdField_c_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_share_url.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdq.jdField_c_of_type_JavaLangString));
          }
          ((articlesummary.PackVideoInfo)localObject1).uint64_third_uin.set(localrdn.jdField_a_of_type_Rdq.jdField_b_of_type_Long);
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdq.jdField_d_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_uin_name.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdq.jdField_d_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdq.jdField_e_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_name.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdq.jdField_e_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdq.jdField_f_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_icon.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdq.jdField_f_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrdn.jdField_a_of_type_Rdq.jdField_g_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_action.set(ByteStringMicro.copyFromUtf8(localrdn.jdField_a_of_type_Rdq.jdField_g_of_type_JavaLangString));
          }
          localPackArticleInfo.msg_pack_video_info.set((MessageMicro)localObject1);
        }
        localArrayList.add(localPackArticleInfo);
      }
      localNewPackInfo.rpt_pack_article_list.set(localArrayList);
    }
    return localNewPackInfo.toByteArray();
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
          rdn localrdn = (rdn)((Iterator)localObject).next();
          str = str + localrdn;
        }
        localObject = str;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdm
 * JD-Core Version:    0.7.0.1
 */