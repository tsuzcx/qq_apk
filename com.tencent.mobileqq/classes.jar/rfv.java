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

public class rfv
{
  public int a;
  public long a;
  public UrlJumpInfo a;
  public String a;
  public List<rfw> a;
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
  
  public rfv()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 6;
  }
  
  public static rfv a(articlesummary.NewPackInfo paramNewPackInfo)
  {
    try
    {
      rfv localrfv = new rfv();
      localrfv.jdField_a_of_type_Int = paramNewPackInfo.pack_type.get();
      localrfv.jdField_a_of_type_JavaLangString = paramNewPackInfo.bytes_top_icon_url.get().toStringUtf8();
      localrfv.jdField_b_of_type_JavaLangString = paramNewPackInfo.bytes_top_title.get().toStringUtf8();
      localrfv.jdField_c_of_type_JavaLangString = paramNewPackInfo.bytes_more_tips.get().toStringUtf8();
      localrfv.jdField_d_of_type_JavaLangString = paramNewPackInfo.bytes_more_href.get().toStringUtf8();
      localrfv.jdField_e_of_type_JavaLangString = paramNewPackInfo.bytes_sub_head_icon_url.get().toStringUtf8();
      localrfv.jdField_b_of_type_Int = paramNewPackInfo.uin32_head_type.get();
      localrfv.jdField_c_of_type_Int = paramNewPackInfo.uint32_video_size_type.get();
      localrfv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_head_url_jump_info.get());
      localrfv.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_right_more_url_jump_info.get());
      localrfv.jdField_d_of_type_Int = paramNewPackInfo.uint32_column_id.get();
      localrfv.jdField_e_of_type_Int = paramNewPackInfo.uint32_follow_status.get();
      if (paramNewPackInfo.rpt_pack_article_list.has())
      {
        localrfv.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramNewPackInfo = paramNewPackInfo.rpt_pack_article_list.get().iterator();
        while (paramNewPackInfo.hasNext())
        {
          articlesummary.PackArticleInfo localPackArticleInfo = (articlesummary.PackArticleInfo)paramNewPackInfo.next();
          rfw localrfw = new rfw();
          localrfw.jdField_a_of_type_Long = pvd.a(localPackArticleInfo.uint64_article_id);
          if (localPackArticleInfo.bytes_article_title.has()) {
            localrfw.jdField_a_of_type_JavaLangString = localPackArticleInfo.bytes_article_title.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_article_summary.has()) {
            localrfw.jdField_b_of_type_JavaLangString = localPackArticleInfo.bytes_article_summary.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_first_page_pic_url.has()) {
            localrfw.jdField_c_of_type_JavaLangString = localPackArticleInfo.bytes_first_page_pic_url.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_article_content_url.has()) {
            localrfw.jdField_d_of_type_JavaLangString = localPackArticleInfo.bytes_article_content_url.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_subscribe_id.has()) {
            localrfw.jdField_e_of_type_JavaLangString = localPackArticleInfo.bytes_subscribe_id.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_subscribe_name.has()) {
            localrfw.jdField_f_of_type_JavaLangString = localPackArticleInfo.bytes_subscribe_name.get().toStringUtf8();
          }
          if (localPackArticleInfo.bytes_cell_style_id.has()) {
            localrfw.i = localPackArticleInfo.bytes_cell_style_id.get().toStringUtf8();
          }
          if (localPackArticleInfo.uint32_is_first_page_use_gif.has()) {
            localrfw.jdField_e_of_type_Int = localPackArticleInfo.uint32_is_first_page_use_gif.get();
          }
          if (localPackArticleInfo.uint32_video_comment_count.has()) {
            localrfw.jdField_g_of_type_Int = localPackArticleInfo.uint32_video_comment_count.get();
          }
          if (localPackArticleInfo.uint32_video_play_count.has())
          {
            localrfw.jdField_f_of_type_Int = localPackArticleInfo.uint32_video_play_count.get();
            localrfw.j = ryx.c(localrfw.jdField_f_of_type_Int);
          }
          if (localPackArticleInfo.bytes_report_common_data.has()) {
            localrfw.k = localPackArticleInfo.bytes_report_common_data.get().toStringUtf8();
          }
          localrfw.jdField_b_of_type_Long = pvd.a(localPackArticleInfo.uint64_algorithm_id);
          localrfw.jdField_a_of_type_Int = pvd.a(localPackArticleInfo.uint32_strategy_id);
          if (localPackArticleInfo.bytes_inner_uniq_id.has()) {
            localrfw.jdField_g_of_type_JavaLangString = localPackArticleInfo.bytes_inner_uniq_id.get().toStringUtf8();
          }
          localrfw.jdField_c_of_type_Int = pvd.a(localPackArticleInfo.uint32_is_gallery);
          localrfw.jdField_d_of_type_Int = pvd.a(localPackArticleInfo.uint32_picture_number);
          localrfw.h = localPackArticleInfo.bytes_button_wording.get().toStringUtf8();
          if (localPackArticleInfo.msg_pack_feeds_info.has())
          {
            localrfw.jdField_c_of_type_Long = pvd.a(localPackArticleInfo.msg_pack_feeds_info.uint64_feeds_id);
            localrfw.jdField_b_of_type_Int = pvd.a(localPackArticleInfo.msg_pack_feeds_info.uint32_feeds_type);
          }
          Object localObject;
          if (localPackArticleInfo.msg_pack_topic_list_info.has())
          {
            localObject = new rfy();
            ((rfy)localObject).jdField_a_of_type_Int = pvd.a(localPackArticleInfo.msg_pack_topic_list_info.uint32_join_count);
            ((rfy)localObject).jdField_a_of_type_JavaLangString = localPackArticleInfo.msg_pack_topic_list_info.bytes_join_wording.get().toStringUtf8();
            ((rfy)localObject).jdField_b_of_type_JavaLangString = localPackArticleInfo.msg_pack_topic_list_info.bytes_topic_name.get().toStringUtf8();
            ((rfy)localObject).jdField_b_of_type_Int = pvd.a(localPackArticleInfo.msg_pack_topic_list_info.uint32_topic_id);
            ((rfy)localObject).jdField_c_of_type_Int = pvd.a(localPackArticleInfo.msg_pack_topic_list_info.uint32_adtag);
            localrfw.jdField_a_of_type_Rfy = ((rfy)localObject);
          }
          if (localPackArticleInfo.msg_pack_question_answer_info.has())
          {
            localObject = new rfx();
            ((rfx)localObject).jdField_a_of_type_JavaLangString = localPackArticleInfo.msg_pack_question_answer_info.bytes_question_rowkey.get().toStringUtf8();
            ((rfx)localObject).jdField_b_of_type_JavaLangString = localPackArticleInfo.msg_pack_question_answer_info.bytes_question_desc.get().toStringUtf8();
            localrfw.jdField_a_of_type_Rfx = ((rfx)localObject);
          }
          if (localPackArticleInfo.msg_pack_video_info.has())
          {
            localObject = new rfz();
            ((rfz)localObject).jdField_a_of_type_Int = pvd.a(localPackArticleInfo.msg_pack_video_info.uint32_busi_type);
            if (localPackArticleInfo.msg_pack_video_info.bytes_vid.has()) {
              ((rfz)localObject).jdField_a_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_vid.get().toStringUtf8();
            }
            ((rfz)localObject).jdField_a_of_type_Int = pvd.a(localPackArticleInfo.msg_pack_video_info.uint32_busi_type);
            ((rfz)localObject).jdField_b_of_type_Int = pvd.a(localPackArticleInfo.msg_pack_video_info.uint32_width);
            ((rfz)localObject).jdField_c_of_type_Int = pvd.a(localPackArticleInfo.msg_pack_video_info.uint32_height);
            ((rfz)localObject).jdField_d_of_type_Int = pvd.a(localPackArticleInfo.msg_pack_video_info.uint32_duration);
            ((rfz)localObject).jdField_a_of_type_Long = pvd.a(localPackArticleInfo.msg_pack_video_info.uint64_file_size);
            ((rfz)localObject).jdField_b_of_type_Long = pvd.a(localPackArticleInfo.msg_pack_video_info.uint64_third_uin);
            if (localPackArticleInfo.msg_pack_video_info.bytes_video_url.has()) {
              ((rfz)localObject).jdField_b_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_video_url.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_share_url.has()) {
              ((rfz)localObject).jdField_c_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_share_url.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_uin_name.has()) {
              ((rfz)localObject).jdField_d_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_third_uin_name.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_name.has()) {
              ((rfz)localObject).jdField_e_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_third_name.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_icon.has()) {
              ((rfz)localObject).jdField_f_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_third_icon.get().toStringUtf8();
            }
            if (localPackArticleInfo.msg_pack_video_info.bytes_third_action.has()) {
              ((rfz)localObject).jdField_g_of_type_JavaLangString = localPackArticleInfo.msg_pack_video_info.bytes_third_action.get().toStringUtf8();
            }
            localrfw.jdField_a_of_type_Rfz = ((rfz)localObject);
          }
          localrfv.jdField_a_of_type_JavaUtilList.add(localrfw);
        }
      }
      return localrfv;
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
        rfw localrfw = (rfw)localIterator.next();
        articlesummary.PackArticleInfo localPackArticleInfo = new articlesummary.PackArticleInfo();
        localPackArticleInfo.uint64_article_id.set(localrfw.jdField_a_of_type_Long);
        if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_article_title.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrfw.jdField_b_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_article_summary.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrfw.jdField_c_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_first_page_pic_url.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_c_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrfw.jdField_d_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_article_content_url.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_d_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrfw.jdField_e_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_e_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrfw.jdField_f_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_subscribe_name.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_f_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(localrfw.i)) {
          localPackArticleInfo.bytes_cell_style_id.set(ByteStringMicro.copyFromUtf8(localrfw.i));
        }
        localPackArticleInfo.uint64_algorithm_id.set(localrfw.jdField_b_of_type_Long);
        localPackArticleInfo.uint32_strategy_id.set(localrfw.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(localrfw.jdField_g_of_type_JavaLangString)) {
          localPackArticleInfo.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_g_of_type_JavaLangString));
        }
        localPackArticleInfo.uint32_video_play_count.set(localrfw.jdField_f_of_type_Int);
        localPackArticleInfo.uint32_video_comment_count.set(localrfw.jdField_g_of_type_Int);
        if (!TextUtils.isEmpty(localrfw.k)) {
          localPackArticleInfo.bytes_report_common_data.set(ByteStringMicro.copyFromUtf8(localrfw.k));
        }
        localPackArticleInfo.uint32_is_gallery.set(localrfw.jdField_c_of_type_Int);
        localPackArticleInfo.uint32_picture_number.set(localrfw.jdField_d_of_type_Int);
        Object localObject1 = new articlesummary.PackFeedsInfo();
        ((articlesummary.PackFeedsInfo)localObject1).uint64_feeds_id.set(localrfw.jdField_c_of_type_Long);
        ((articlesummary.PackFeedsInfo)localObject1).uint32_feeds_type.set(localrfw.jdField_b_of_type_Int);
        Object localObject2;
        if (localrfw.jdField_a_of_type_Rfy != null)
        {
          localObject2 = new articlesummary.PackTopicExtraInfo();
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfy.jdField_a_of_type_JavaLangString)) {
            ((articlesummary.PackTopicExtraInfo)localObject2).bytes_join_wording.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfy.jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfy.jdField_b_of_type_JavaLangString)) {
            ((articlesummary.PackTopicExtraInfo)localObject2).bytes_topic_name.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfy.jdField_b_of_type_JavaLangString));
          }
          ((articlesummary.PackTopicExtraInfo)localObject2).uint32_join_count.set(localrfw.jdField_a_of_type_Rfy.jdField_a_of_type_Int);
          ((articlesummary.PackTopicExtraInfo)localObject2).uint32_topic_id.set(localrfw.jdField_a_of_type_Rfy.jdField_b_of_type_Int);
          ((articlesummary.PackTopicExtraInfo)localObject2).uint32_adtag.set(localrfw.jdField_a_of_type_Rfy.jdField_c_of_type_Int);
          localPackArticleInfo.msg_pack_topic_list_info.set((MessageMicro)localObject2);
        }
        if (localrfw.jdField_a_of_type_Rfx != null)
        {
          localObject2 = new articlesummary.PackQuestionAnswerExtraInfo();
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfx.jdField_a_of_type_JavaLangString)) {
            ((articlesummary.PackQuestionAnswerExtraInfo)localObject2).bytes_question_rowkey.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfx.jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfx.jdField_b_of_type_JavaLangString)) {
            ((articlesummary.PackQuestionAnswerExtraInfo)localObject2).bytes_question_desc.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfx.jdField_b_of_type_JavaLangString));
          }
          localPackArticleInfo.msg_pack_question_answer_info.set((MessageMicro)localObject2);
        }
        localPackArticleInfo.bytes_button_wording.set(ByteStringMicro.copyFromUtf8(localrfw.h));
        localPackArticleInfo.msg_pack_feeds_info.set((MessageMicro)localObject1);
        if (localrfw.jdField_a_of_type_Rfz != null)
        {
          localObject1 = new articlesummary.PackVideoInfo();
          ((articlesummary.PackVideoInfo)localObject1).uint32_busi_type.set(localrfw.jdField_a_of_type_Rfz.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfz.jdField_a_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_vid.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfz.jdField_a_of_type_JavaLangString));
          }
          ((articlesummary.PackVideoInfo)localObject1).uint32_width.set(localrfw.jdField_a_of_type_Rfz.jdField_b_of_type_Int);
          ((articlesummary.PackVideoInfo)localObject1).uint32_height.set(localrfw.jdField_a_of_type_Rfz.jdField_c_of_type_Int);
          ((articlesummary.PackVideoInfo)localObject1).uint32_duration.set(localrfw.jdField_a_of_type_Rfz.jdField_d_of_type_Int);
          ((articlesummary.PackVideoInfo)localObject1).uint64_file_size.set(localrfw.jdField_a_of_type_Rfz.jdField_a_of_type_Long);
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfz.jdField_b_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_video_url.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfz.jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfz.jdField_c_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_share_url.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfz.jdField_c_of_type_JavaLangString));
          }
          ((articlesummary.PackVideoInfo)localObject1).uint64_third_uin.set(localrfw.jdField_a_of_type_Rfz.jdField_b_of_type_Long);
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfz.jdField_d_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_uin_name.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfz.jdField_d_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfz.jdField_e_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_name.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfz.jdField_e_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfz.jdField_f_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_icon.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfz.jdField_f_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(localrfw.jdField_a_of_type_Rfz.jdField_g_of_type_JavaLangString)) {
            ((articlesummary.PackVideoInfo)localObject1).bytes_third_action.set(ByteStringMicro.copyFromUtf8(localrfw.jdField_a_of_type_Rfz.jdField_g_of_type_JavaLangString));
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
          rfw localrfw = (rfw)((Iterator)localObject).next();
          str = str + localrfw;
        }
        localObject = str;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfv
 * JD-Core Version:    0.7.0.1
 */