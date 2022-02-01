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
  public boolean a = true;
  public boolean b = false;
  public long c;
  public int d = 6;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public int j;
  public int k;
  public UrlJumpInfo l;
  public UrlJumpInfo m;
  public int n;
  public int o;
  public List<NewPolymericInfo.PackArticleInfo> p;
  
  public static NewPolymericInfo a(articlesummary.NewPackInfo paramNewPackInfo)
  {
    try
    {
      localObject = new NewPolymericInfo();
      ((NewPolymericInfo)localObject).d = paramNewPackInfo.pack_type.get();
      ((NewPolymericInfo)localObject).e = paramNewPackInfo.bytes_top_icon_url.get().toStringUtf8();
      ((NewPolymericInfo)localObject).f = paramNewPackInfo.bytes_top_title.get().toStringUtf8();
      ((NewPolymericInfo)localObject).g = paramNewPackInfo.bytes_more_tips.get().toStringUtf8();
      ((NewPolymericInfo)localObject).h = paramNewPackInfo.bytes_more_href.get().toStringUtf8();
      ((NewPolymericInfo)localObject).i = paramNewPackInfo.bytes_sub_head_icon_url.get().toStringUtf8();
      ((NewPolymericInfo)localObject).j = paramNewPackInfo.uin32_head_type.get();
      ((NewPolymericInfo)localObject).k = paramNewPackInfo.uint32_video_size_type.get();
      ((NewPolymericInfo)localObject).l = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_head_url_jump_info.get());
      ((NewPolymericInfo)localObject).m = UrlJumpInfo.a((articlesummary.UrlJumpInfo)paramNewPackInfo.msg_right_more_url_jump_info.get());
      ((NewPolymericInfo)localObject).n = paramNewPackInfo.uint32_column_id.get();
      ((NewPolymericInfo)localObject).o = paramNewPackInfo.uint32_follow_status.get();
      if (paramNewPackInfo.rpt_pack_article_list.has())
      {
        ((NewPolymericInfo)localObject).p = new ArrayList();
        paramNewPackInfo = paramNewPackInfo.rpt_pack_article_list.get().iterator();
        while (paramNewPackInfo.hasNext())
        {
          articlesummary.PackArticleInfo localPackArticleInfo = (articlesummary.PackArticleInfo)paramNewPackInfo.next();
          NewPolymericInfo.PackArticleInfo localPackArticleInfo1 = new NewPolymericInfo.PackArticleInfo();
          localPackArticleInfo1.a = PBFieldUtils.a(localPackArticleInfo.uint64_article_id);
          localPackArticleInfo1.b = PBFieldUtils.a(localPackArticleInfo.bytes_article_title);
          localPackArticleInfo1.c = PBFieldUtils.a(localPackArticleInfo.bytes_article_summary);
          localPackArticleInfo1.d = PBFieldUtils.a(localPackArticleInfo.bytes_first_page_pic_url);
          localPackArticleInfo1.e = PBFieldUtils.a(localPackArticleInfo.bytes_article_content_url);
          localPackArticleInfo1.f = PBFieldUtils.a(localPackArticleInfo.bytes_subscribe_id);
          localPackArticleInfo1.g = PBFieldUtils.a(localPackArticleInfo.bytes_subscribe_name);
          localPackArticleInfo1.t = PBFieldUtils.a(localPackArticleInfo.bytes_cell_style_id);
          localPackArticleInfo1.u = PBFieldUtils.a(localPackArticleInfo.uint32_is_first_page_use_gif);
          localPackArticleInfo1.x = PBFieldUtils.a(localPackArticleInfo.uint32_video_comment_count);
          localPackArticleInfo1.y = PBFieldUtils.a(localPackArticleInfo.bytes_report_common_data);
          localPackArticleInfo1.i = PBFieldUtils.a(localPackArticleInfo.uint64_algorithm_id);
          localPackArticleInfo1.h = PBFieldUtils.a(localPackArticleInfo.uint32_strategy_id);
          localPackArticleInfo1.l = PBFieldUtils.a(localPackArticleInfo.bytes_inner_uniq_id);
          localPackArticleInfo1.m = PBFieldUtils.a(localPackArticleInfo.uint32_is_gallery);
          localPackArticleInfo1.n = PBFieldUtils.a(localPackArticleInfo.uint32_picture_number);
          localPackArticleInfo1.r = PBFieldUtils.a(localPackArticleInfo.bytes_button_wording, "");
          a(localPackArticleInfo, localPackArticleInfo1);
          b(localPackArticleInfo, localPackArticleInfo1);
          c(localPackArticleInfo, localPackArticleInfo1);
          d(localPackArticleInfo, localPackArticleInfo1);
          e(localPackArticleInfo, localPackArticleInfo1);
          ((NewPolymericInfo)localObject).p.add(localPackArticleInfo1);
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
      paramPackArticleInfo1.v = paramPackArticleInfo.uint32_video_play_count.get();
      paramPackArticleInfo1.w = VideoFeedsUtil.a(paramPackArticleInfo1.v);
    }
  }
  
  @VisibleForTesting
  public static void b(articlesummary.PackArticleInfo paramPackArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.msg_pack_feeds_info.has())
    {
      paramPackArticleInfo1.j = PBFieldUtils.a(paramPackArticleInfo.msg_pack_feeds_info.uint64_feeds_id);
      paramPackArticleInfo1.k = PBFieldUtils.a(paramPackArticleInfo.msg_pack_feeds_info.uint32_feeds_type);
    }
  }
  
  @VisibleForTesting
  public static void c(articlesummary.PackArticleInfo paramPackArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.msg_pack_topic_list_info.has())
    {
      NewPolymericInfo.PackTopicExtraInfo localPackTopicExtraInfo = new NewPolymericInfo.PackTopicExtraInfo();
      localPackTopicExtraInfo.a = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.uint32_join_count);
      localPackTopicExtraInfo.b = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.bytes_join_wording, "");
      localPackTopicExtraInfo.c = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.bytes_topic_name, "");
      localPackTopicExtraInfo.d = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.uint32_topic_id);
      localPackTopicExtraInfo.e = PBFieldUtils.a(paramPackArticleInfo.msg_pack_topic_list_info.uint32_adtag);
      paramPackArticleInfo1.p = localPackTopicExtraInfo;
    }
  }
  
  @VisibleForTesting
  public static void d(articlesummary.PackArticleInfo paramPackArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.msg_pack_question_answer_info.has())
    {
      NewPolymericInfo.PackQuestionAnswerExtraInfo localPackQuestionAnswerExtraInfo = new NewPolymericInfo.PackQuestionAnswerExtraInfo();
      localPackQuestionAnswerExtraInfo.a = PBFieldUtils.a(paramPackArticleInfo.msg_pack_question_answer_info.bytes_question_rowkey, "");
      localPackQuestionAnswerExtraInfo.b = PBFieldUtils.a(paramPackArticleInfo.msg_pack_question_answer_info.bytes_question_desc, "");
      paramPackArticleInfo1.q = localPackQuestionAnswerExtraInfo;
    }
  }
  
  @VisibleForTesting
  public static void e(articlesummary.PackArticleInfo paramPackArticleInfo, NewPolymericInfo.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.msg_pack_video_info.has())
    {
      NewPolymericInfo.PackVideoInfo localPackVideoInfo = new NewPolymericInfo.PackVideoInfo();
      localPackVideoInfo.a = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint32_busi_type);
      localPackVideoInfo.b = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_vid);
      localPackVideoInfo.c = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint32_width);
      localPackVideoInfo.d = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint32_height);
      localPackVideoInfo.e = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint32_duration);
      localPackVideoInfo.f = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint64_file_size);
      localPackVideoInfo.i = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.uint64_third_uin);
      localPackVideoInfo.g = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_video_url);
      localPackVideoInfo.h = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_share_url);
      localPackVideoInfo.j = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_uin_name);
      localPackVideoInfo.k = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_name);
      localPackVideoInfo.l = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_icon);
      localPackVideoInfo.m = PBFieldUtils.a(paramPackArticleInfo.msg_pack_video_info.bytes_third_action);
      paramPackArticleInfo1.o = localPackVideoInfo;
    }
  }
  
  @VisibleForTesting
  public void a(NewPolymericInfo.PackArticleInfo paramPackArticleInfo, articlesummary.PackArticleInfo paramPackArticleInfo1)
  {
    articlesummary.PackFeedsInfo localPackFeedsInfo = new articlesummary.PackFeedsInfo();
    localPackFeedsInfo.uint64_feeds_id.set(paramPackArticleInfo.j);
    localPackFeedsInfo.uint32_feeds_type.set(paramPackArticleInfo.k);
    paramPackArticleInfo1.msg_pack_feeds_info.set(localPackFeedsInfo);
  }
  
  public byte[] a()
  {
    articlesummary.NewPackInfo localNewPackInfo = new articlesummary.NewPackInfo();
    localNewPackInfo.pack_type.set(this.d);
    RIJPBFieldUtils.b(localNewPackInfo.bytes_top_icon_url, this.e);
    RIJPBFieldUtils.b(localNewPackInfo.bytes_top_title, this.f);
    RIJPBFieldUtils.b(localNewPackInfo.bytes_more_tips, this.g);
    RIJPBFieldUtils.b(localNewPackInfo.bytes_more_href, this.h);
    RIJPBFieldUtils.b(localNewPackInfo.bytes_sub_head_icon_url, this.i);
    localNewPackInfo.uin32_head_type.set(this.j);
    localNewPackInfo.uint32_video_size_type.set(this.k);
    localNewPackInfo.uint32_column_id.set(this.n);
    if (this.o != 0) {
      localNewPackInfo.uint32_follow_status.set(this.o);
    }
    if (this.l != null) {
      localNewPackInfo.msg_head_url_jump_info.set(this.l.a());
    }
    if (this.m != null) {
      localNewPackInfo.msg_right_more_url_jump_info.set(this.m.a());
    }
    b(localNewPackInfo);
    return localNewPackInfo.toByteArray();
  }
  
  @VisibleForTesting
  public void b(NewPolymericInfo.PackArticleInfo paramPackArticleInfo, articlesummary.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.p != null)
    {
      articlesummary.PackTopicExtraInfo localPackTopicExtraInfo = new articlesummary.PackTopicExtraInfo();
      RIJPBFieldUtils.b(localPackTopicExtraInfo.bytes_join_wording, paramPackArticleInfo.p.b);
      RIJPBFieldUtils.b(localPackTopicExtraInfo.bytes_topic_name, paramPackArticleInfo.p.c);
      localPackTopicExtraInfo.uint32_join_count.set(paramPackArticleInfo.p.a);
      localPackTopicExtraInfo.uint32_topic_id.set(paramPackArticleInfo.p.d);
      localPackTopicExtraInfo.uint32_adtag.set(paramPackArticleInfo.p.e);
      paramPackArticleInfo1.msg_pack_topic_list_info.set(localPackTopicExtraInfo);
    }
  }
  
  public void b(articlesummary.NewPackInfo paramNewPackInfo)
  {
    if (this.p != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)localIterator.next();
        articlesummary.PackArticleInfo localPackArticleInfo1 = new articlesummary.PackArticleInfo();
        localPackArticleInfo1.uint64_article_id.set(localPackArticleInfo.a);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_article_title, localPackArticleInfo.b);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_article_summary, localPackArticleInfo.c);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_first_page_pic_url, localPackArticleInfo.d);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_article_content_url, localPackArticleInfo.e);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_subscribe_id, localPackArticleInfo.f);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_subscribe_name, localPackArticleInfo.g);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_cell_style_id, localPackArticleInfo.t);
        localPackArticleInfo1.uint64_algorithm_id.set(localPackArticleInfo.i);
        localPackArticleInfo1.uint32_strategy_id.set(localPackArticleInfo.h);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_inner_uniq_id, localPackArticleInfo.l);
        localPackArticleInfo1.uint32_video_play_count.set(localPackArticleInfo.v);
        localPackArticleInfo1.uint32_video_comment_count.set(localPackArticleInfo.x);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_report_common_data, localPackArticleInfo.y);
        localPackArticleInfo1.uint32_is_gallery.set(localPackArticleInfo.m);
        localPackArticleInfo1.uint32_picture_number.set(localPackArticleInfo.n);
        RIJPBFieldUtils.b(localPackArticleInfo1.bytes_button_wording, localPackArticleInfo.r);
        a(localPackArticleInfo, localPackArticleInfo1);
        b(localPackArticleInfo, localPackArticleInfo1);
        c(localPackArticleInfo, localPackArticleInfo1);
        d(localPackArticleInfo, localPackArticleInfo1);
        localArrayList.add(localPackArticleInfo1);
      }
      paramNewPackInfo.rpt_pack_article_list.set(localArrayList);
    }
  }
  
  @VisibleForTesting
  public void c(NewPolymericInfo.PackArticleInfo paramPackArticleInfo, articlesummary.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.q != null)
    {
      articlesummary.PackQuestionAnswerExtraInfo localPackQuestionAnswerExtraInfo = new articlesummary.PackQuestionAnswerExtraInfo();
      RIJPBFieldUtils.b(localPackQuestionAnswerExtraInfo.bytes_question_rowkey, paramPackArticleInfo.q.a);
      RIJPBFieldUtils.b(localPackQuestionAnswerExtraInfo.bytes_question_desc, paramPackArticleInfo.q.b);
      paramPackArticleInfo1.msg_pack_question_answer_info.set(localPackQuestionAnswerExtraInfo);
    }
  }
  
  @VisibleForTesting
  public void d(NewPolymericInfo.PackArticleInfo paramPackArticleInfo, articlesummary.PackArticleInfo paramPackArticleInfo1)
  {
    if (paramPackArticleInfo.o != null)
    {
      articlesummary.PackVideoInfo localPackVideoInfo = new articlesummary.PackVideoInfo();
      localPackVideoInfo.uint32_busi_type.set(paramPackArticleInfo.o.a);
      if (!TextUtils.isEmpty(paramPackArticleInfo.o.b)) {
        localPackVideoInfo.bytes_vid.set(ByteStringMicro.copyFromUtf8(paramPackArticleInfo.o.b));
      }
      localPackVideoInfo.uint32_width.set(paramPackArticleInfo.o.c);
      localPackVideoInfo.uint32_height.set(paramPackArticleInfo.o.d);
      localPackVideoInfo.uint32_duration.set(paramPackArticleInfo.o.e);
      localPackVideoInfo.uint64_file_size.set(paramPackArticleInfo.o.f);
      RIJPBFieldUtils.b(localPackVideoInfo.bytes_video_url, paramPackArticleInfo.o.g);
      RIJPBFieldUtils.b(localPackVideoInfo.bytes_share_url, paramPackArticleInfo.o.h);
      localPackVideoInfo.uint64_third_uin.set(paramPackArticleInfo.o.i);
      RIJPBFieldUtils.b(localPackVideoInfo.bytes_third_uin_name, paramPackArticleInfo.o.j);
      RIJPBFieldUtils.b(localPackVideoInfo.bytes_third_name, paramPackArticleInfo.o.k);
      RIJPBFieldUtils.b(localPackVideoInfo.bytes_third_icon, paramPackArticleInfo.o.l);
      RIJPBFieldUtils.b(localPackVideoInfo.bytes_third_action, paramPackArticleInfo.o.m);
      paramPackArticleInfo1.msg_pack_video_info.set(localPackVideoInfo);
    }
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("NewpolymericInfo uin = ");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append(" polymericType = ");
    ((StringBuilder)localObject1).append(this.d);
    ((StringBuilder)localObject1).append("\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = this.p;
    Object localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = localObject1;
      if (!((List)localObject3).isEmpty())
      {
        localObject3 = this.p.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo
 * JD-Core Version:    0.7.0.1
 */