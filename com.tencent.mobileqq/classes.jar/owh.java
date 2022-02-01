import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.1;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.10;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.11;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.2;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.3;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.4;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.5;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.6;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.7;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.8;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.9;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AccountLevelInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Activity;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ArticleInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Banner;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Comment;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ExtraInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Label;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.LinkData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MedalInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MediaData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqBody;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqParam;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RspBody;
import tencent.im.oidb.cmd0xdc8.oidb_cmd0xdc8.ReqBody;

public class owh
  extends pwd
{
  private otk a;
  
  public owh(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qli paramqli, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqli, paramHandler);
  }
  
  private CommentData a(oidb_cmd0xc46.Comment paramComment)
  {
    boolean bool2 = true;
    if ((paramComment == null) || (!paramComment.comment_id.has())) {
      return null;
    }
    CommentData localCommentData = new CommentData();
    a(paramComment, localCommentData);
    if (paramComment.sub_comments_total.has()) {
      localCommentData.subCommentNum = paramComment.sub_comments_total.get();
    }
    if (paramComment.sub_comments.has())
    {
      localCommentData.subCommentList = new ArrayList();
      Iterator localIterator = paramComment.sub_comments.get().iterator();
      while (localIterator.hasNext())
      {
        SubCommentData localSubCommentData = a((oidb_cmd0xc46.Comment)localIterator.next());
        if (localSubCommentData != null) {
          localCommentData.subCommentList.add(localSubCommentData);
        }
      }
    }
    if (paramComment.is_anchor.has())
    {
      if (paramComment.is_anchor.get() == 1)
      {
        bool1 = true;
        localCommentData.isAnchor = bool1;
      }
    }
    else if (paramComment.is_delete.has()) {
      if (paramComment.is_delete.get() != 1) {
        break label266;
      }
    }
    label266:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCommentData.isDelete = bool1;
      if (paramComment.rpt_medal_info_list.has()) {
        localCommentData.medalInfo = a(false, paramComment.rpt_medal_info_list.get(), localCommentData.uin);
      }
      QLog.d("ReadInJoyCommentPBModule", 2, "convertCommentData | " + localCommentData.toString());
      return localCommentData;
      bool1 = false;
      break;
    }
  }
  
  private SubCommentData a(oidb_cmd0xc46.Comment paramComment)
  {
    boolean bool2 = false;
    if ((paramComment == null) || (!paramComment.comment_id.has())) {
      return null;
    }
    SubCommentData localSubCommentData = new SubCommentData();
    a(paramComment, localSubCommentData);
    if (paramComment.first_comment_id.has()) {
      localSubCommentData.parentCommentId = paramComment.first_comment_id.get();
    }
    if (paramComment.replied_user_id.has()) {
      localSubCommentData.repliedUserUin = paramComment.replied_user_id.get();
    }
    if (paramComment.replied_user_nick_name.has()) {
      localSubCommentData.repliedUserNickname = paramComment.replied_user_nick_name.get();
    }
    if (paramComment.replied_user_homepage.has()) {
      localSubCommentData.repliedUserHomePage = paramComment.replied_user_homepage.get();
    }
    if (paramComment.has_target.has()) {
      localSubCommentData.hasTarget = paramComment.has_target.get();
    }
    if (paramComment.is_anchor.has()) {
      if (paramComment.is_anchor.get() != 1) {
        break label268;
      }
    }
    label268:
    for (boolean bool1 = true;; bool1 = false)
    {
      localSubCommentData.isAnchor = bool1;
      if (paramComment.is_delete.has())
      {
        bool1 = bool2;
        if (paramComment.is_delete.get() == 1) {
          bool1 = true;
        }
        localSubCommentData.isDelete = bool1;
      }
      if (paramComment.rpt_medal_info_list.has()) {
        localSubCommentData.medalInfo = a(true, paramComment.rpt_medal_info_list.get(), localSubCommentData.uin);
      }
      QLog.d("ReadInJoyCommentPBModule", 2, "convertSubCommentData | " + localSubCommentData.toString());
      return localSubCommentData;
    }
  }
  
  private List<CommentData> a(List<oidb_cmd0xc46.Comment> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (oidb_cmd0xc46.Comment)paramList.next();
      if (localObject != null)
      {
        localObject = a((oidb_cmd0xc46.Comment)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private oju a(boolean paramBoolean, List<oidb_cmd0xc46.MedalInfo> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        oidb_cmd0xc46.MedalInfo localMedalInfo = (oidb_cmd0xc46.MedalInfo)paramList.next();
        oju localoju = new oju();
        if (localMedalInfo.is_jump.has()) {
          localoju.jdField_b_of_type_Int = localMedalInfo.is_jump.get();
        }
        if (localMedalInfo.jump_url.has()) {
          localoju.jdField_c_of_type_JavaLangString = localMedalInfo.jump_url.get().toStringUtf8();
        }
        if (localMedalInfo.medal_type.has()) {
          localoju.jdField_a_of_type_Int = localMedalInfo.medal_type.get();
        }
        if (localMedalInfo.medal_id.has()) {
          localoju.jdField_a_of_type_Long = localMedalInfo.medal_id.get();
        }
        if (localMedalInfo.medal_name.has()) {
          localoju.jdField_a_of_type_JavaLangString = localMedalInfo.medal_name.get().toStringUtf8();
        }
        if (localMedalInfo.medal_url.has()) {
          localoju.jdField_b_of_type_JavaLangString = localMedalInfo.medal_url.get().toStringUtf8();
        }
        if (localMedalInfo.pic_width.has()) {
          localoju.jdField_c_of_type_Int = localMedalInfo.pic_width.get();
        }
        if (localMedalInfo.pic_height.has()) {
          localoju.jdField_d_of_type_Int = localMedalInfo.pic_height.get();
        }
        localoju.jdField_e_of_type_JavaLangString = "3";
        if (paramBoolean) {}
        for (localoju.f = "7";; localoju.f = "6")
        {
          localoju.h = paramString;
          localArrayList.add(localoju);
          break;
        }
      }
    }
    paramList = null;
    if (!localArrayList.isEmpty()) {
      paramList = (oju)localArrayList.get(0);
    }
    return paramList;
  }
  
  private void a(@NotNull BaseCommentData paramBaseCommentData, @NotNull oidb_cmd0xc46.Comment paramComment)
  {
    if ((paramComment.is_multi_media.has()) && (paramComment.is_multi_media.get() == 1))
    {
      QLog.d("ReadInJoyCommentPBModule", 1, "comment type is multi media");
      if (paramComment.rpt_media_data_list.has()) {}
      for (paramComment = paramComment.rpt_media_data_list.get(); (paramComment != null) && (paramComment.size() > 0); paramComment = null)
      {
        int j = paramComment.size();
        QLog.d("ReadInJoyCommentPBModule", 1, "comment media size : " + j);
        paramBaseCommentData.mediaDataList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          oidb_cmd0xc46.MediaData localMediaData = (oidb_cmd0xc46.MediaData)paramComment.get(i);
          oun localoun = new oun();
          localoun.jdField_a_of_type_JavaLangString = localMediaData.text.get();
          localoun.jdField_e_of_type_Int = localMediaData.media_type.get();
          localoun.jdField_a_of_type_Int = localMediaData.pic_width.get();
          localoun.jdField_b_of_type_Int = localMediaData.pic_length.get();
          localoun.jdField_b_of_type_JavaLangString = localMediaData.pic_url.get();
          localoun.jdField_e_of_type_JavaLangString = localMediaData.thumbnail_url.get();
          localoun.jdField_d_of_type_JavaLangString = localMediaData.video_url.get();
          localoun.jdField_d_of_type_Int = localMediaData.video_duration.get();
          localoun.jdField_c_of_type_JavaLangString = localMediaData.sound_url.get();
          localoun.jdField_c_of_type_Int = localMediaData.sound_duration.get();
          paramBaseCommentData.mediaDataList.add(localoun);
          i += 1;
        }
      }
    }
  }
  
  private static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      syo localsyo = new syo();
      localsyo.jdField_b_of_type_Boolean = true;
      localsyo.jdField_b_of_type_Int = ViewUtils.dpToPx(37.0F);
      localsyo.jdField_a_of_type_Int = ViewUtils.dpToPx(37.0F);
      localsyo.jdField_c_of_type_Int = 1;
      psq.a.a(localsyo, paramString);
      syn.a().a(localsyo, new owi(paramString));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ReadInJoyCommentPBModule", 2, paramString.getMessage());
    }
  }
  
  private void a(oidb_cmd0xc46.ReqBody paramReqBody, CommonCommentData paramCommonCommentData)
  {
    if (paramCommonCommentData == null) {}
    do
    {
      return;
      if (paramCommonCommentData.getFeedsType() != -1) {
        paramReqBody.feeds_type.set(paramCommonCommentData.getFeedsType());
      }
    } while (TextUtils.isEmpty(paramCommonCommentData.getFeedsId()));
    paramReqBody.feeds_id.set(paramCommonCommentData.getFeedsId());
  }
  
  private List<SubCommentData> b(List<oidb_cmd0xc46.Comment> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (oidb_cmd0xc46.Comment)paramList.next();
      if (localObject != null)
      {
        localObject = a((oidb_cmd0xc46.Comment)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xc46.RspBody();
    int j = qlk.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleCommonCommentList | retCode " + j);
    paramFromServiceMsg = new owk();
    paramObject = new owk();
    owl localowl = new owl();
    localowl.jdField_a_of_type_Owj = new owj();
    boolean bool;
    if (j == 0)
    {
      if (qlg.a(((oidb_cmd0xc46.RspBody)localObject1).next, 0) != 1) {
        break label1039;
      }
      bool = true;
    }
    for (;;)
    {
      paramObject.jdField_a_of_type_Boolean = bool;
      QLog.d("ReadInJoyCommentPBModule", 2, "handleCommonCommentList | hasNextPage " + ((oidb_cmd0xc46.RspBody)localObject1).next.get());
      paramObject.jdField_a_of_type_JavaLangString = qlg.a(((oidb_cmd0xc46.RspBody)localObject1).page_cookie, "");
      if (((oidb_cmd0xc46.RspBody)localObject1).extra_info.has())
      {
        if (qlg.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).hot_next, 0) != 1) {
          break label1045;
        }
        bool = true;
        paramFromServiceMsg.jdField_a_of_type_Boolean = bool;
        paramFromServiceMsg.jdField_a_of_type_JavaLangString = qlg.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).hot_page_cookie, "");
        localowl.b = qlg.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).hidden_comment_count, 0);
        localowl.jdField_a_of_type_Int = qlg.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).show_mask, 0);
        if (!((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).jump_kva_schema.has()) {}
      }
      try
      {
        localowl.jdField_a_of_type_JavaLangString = new String(bfuc.decode(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).jump_kva_schema.get(), 0), "utf-8");
        if (qlg.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).is_pgc_author, 0) == 1)
        {
          bool = true;
          localowl.jdField_a_of_type_Boolean = bool;
          Object localObject2;
          if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.has())
          {
            localObject2 = localowl.jdField_a_of_type_Owj;
            if (qlg.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_delete, 0) != 1) {
              break label1067;
            }
            bool = true;
            ((owj)localObject2).jdField_a_of_type_Boolean = bool;
            localObject2 = localowl.jdField_a_of_type_Owj;
            if (qlg.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_top, 0) != 1) {
              break label1073;
            }
            bool = true;
            ((owj)localObject2).c = bool;
            localObject2 = localowl.jdField_a_of_type_Owj;
            if (qlg.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_sink, 0) != 1) {
              break label1079;
            }
            bool = true;
            ((owj)localObject2).jdField_b_of_type_Boolean = bool;
          }
          if (((oidb_cmd0xc46.RspBody)localObject1).hot_comment_list.has()) {
            paramFromServiceMsg.jdField_a_of_type_JavaUtilList = a(((oidb_cmd0xc46.RspBody)localObject1).hot_comment_list.get());
          }
          if (((oidb_cmd0xc46.RspBody)localObject1).comment_list.has()) {
            paramObject.jdField_a_of_type_JavaUtilList = a(((oidb_cmd0xc46.RspBody)localObject1).comment_list.get());
          }
          if (((oidb_cmd0xc46.RspBody)localObject1).article_info.has())
          {
            localObject2 = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject1).article_info.get();
            localowl.jdField_a_of_type_Long = qlg.a(((oidb_cmd0xc46.ArticleInfo)localObject2).comment_count, 0L);
            if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.has())) {
              break label1085;
            }
            if (((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get() == 0) {
              this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.1(this));
            }
            QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + ((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get());
          }
          paramToServiceMsg = null;
          if (((oidb_cmd0xc46.RspBody)localObject1).banner.has())
          {
            localObject1 = (oidb_cmd0xc46.Banner)((oidb_cmd0xc46.RspBody)localObject1).banner.get();
            paramToServiceMsg = new CommentData();
            paramToServiceMsg.commentId = String.valueOf(((oidb_cmd0xc46.Banner)localObject1).config_id.get());
            paramToServiceMsg.commentContent = ((oidb_cmd0xc46.Banner)localObject1).title.get();
            paramToServiceMsg.activityJumpUrl = ((oidb_cmd0xc46.Banner)localObject1).jump_url.get();
            paramToServiceMsg.isBanner = true;
            QLog.d("ReadInJoyCommentPBModule", 1, "handleCommonCommentList | banner configid ：" + paramToServiceMsg.commentId + "; title :" + paramToServiceMsg.commentContent + "; url " + paramToServiceMsg.activityJumpUrl);
          }
          localObject1 = new StringBuilder().append("handleCommonCommentList | retCode ").append(j).append(" | hasNewNextPage ").append(paramObject.jdField_a_of_type_Boolean).append(" | hasHotNextPage+").append(paramFromServiceMsg.jdField_a_of_type_Boolean).append(" | newPageCookie ").append(paramObject.jdField_a_of_type_JavaLangString).append("; hotPageCookie ").append(paramFromServiceMsg.jdField_a_of_type_JavaLangString).append("| articleCommentCnt ").append(localowl.jdField_a_of_type_Long).append(" | hotCommentListSize ");
          if (paramFromServiceMsg.jdField_a_of_type_JavaUtilList == null) {
            break label1097;
          }
          i = paramFromServiceMsg.jdField_a_of_type_JavaUtilList.size();
          localObject1 = ((StringBuilder)localObject1).append(i).append(" | newCommentListSize ");
          if (paramObject.jdField_a_of_type_JavaUtilList == null) {
            break label1103;
          }
          i = paramObject.jdField_a_of_type_JavaUtilList.size();
          QLog.d("ReadInJoyCommentPBModule", 1, i + " ; extraInfo : " + localowl);
          if (paramFromServiceMsg.a()) {
            paramFromServiceMsg.jdField_a_of_type_JavaUtilList.add(0, paramToServiceMsg);
          }
          if (paramObject.a()) {
            paramObject.jdField_a_of_type_JavaUtilList.add(0, paramToServiceMsg);
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.2(this, j, paramFromServiceMsg, paramObject, localowl));
          return;
          label1039:
          bool = false;
          continue;
          label1045:
          bool = false;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          continue;
          bool = false;
          continue;
          label1067:
          bool = false;
          continue;
          label1073:
          bool = false;
          continue;
          label1079:
          bool = false;
          continue;
          label1085:
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
          continue;
          label1097:
          int i = 0;
          continue;
          label1103:
          i = 0;
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = qlk.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleFamilyCommentList | retCode " + i);
    owk localowk = new owk();
    owl localowl = new owl();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label469;
        }
        bool = true;
        localowk.jdField_a_of_type_Boolean = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleFamilyCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        localowk.jdField_a_of_type_JavaLangString = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.comment_list.has()) {
        localowk.jdField_a_of_type_JavaUtilList = a(localRspBody.comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localowl.jdField_a_of_type_Long = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label475;
        }
        if (paramFromServiceMsg.has_anchor.get() == 0) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.3(this));
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + paramFromServiceMsg.has_anchor.get());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (localRspBody.banner.has())
      {
        paramToServiceMsg = (oidb_cmd0xc46.Banner)localRspBody.banner.get();
        paramFromServiceMsg = new CommentData();
        paramFromServiceMsg.commentId = String.valueOf(paramToServiceMsg.config_id.get());
        paramFromServiceMsg.commentContent = paramToServiceMsg.title.get();
        paramFromServiceMsg.activityJumpUrl = paramToServiceMsg.jump_url.get();
        paramFromServiceMsg.isBanner = true;
        QLog.d("ReadInJoyCommentPBModule", 1, "family comment banner configid ：" + paramFromServiceMsg.commentId + "; title :" + paramFromServiceMsg.commentContent + "; url" + paramFromServiceMsg.activityPicUrl);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.4(this, i, localowk, localowl, paramFromServiceMsg));
      return;
      label469:
      bool = false;
      break;
      label475:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = qlk.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleNewCommentList | retCode " + i);
    owk localowk = new owk();
    owl localowl = new owl();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label469;
        }
        bool = true;
        localowk.jdField_a_of_type_Boolean = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleNewCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        localowk.jdField_a_of_type_JavaLangString = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.comment_list.has()) {
        localowk.jdField_a_of_type_JavaUtilList = a(localRspBody.comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localowl.jdField_a_of_type_Long = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label475;
        }
        if (paramFromServiceMsg.has_anchor.get() == 0) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.5(this));
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + paramFromServiceMsg.has_anchor.get());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (localRspBody.banner.has())
      {
        paramToServiceMsg = (oidb_cmd0xc46.Banner)localRspBody.banner.get();
        paramFromServiceMsg = new CommentData();
        paramFromServiceMsg.commentId = String.valueOf(paramToServiceMsg.config_id.get());
        paramFromServiceMsg.commentContent = paramToServiceMsg.title.get();
        paramFromServiceMsg.activityJumpUrl = paramToServiceMsg.jump_url.get();
        paramFromServiceMsg.isBanner = true;
        QLog.d("ReadInJoyCommentPBModule", 1, "new comment banner configid ：" + paramFromServiceMsg.commentId + "; title :" + paramFromServiceMsg.commentContent + "; url" + paramFromServiceMsg.activityPicUrl);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.6(this, i, localowk, localowl, paramFromServiceMsg));
      return;
      label469:
      bool = false;
      break;
      label475:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = qlk.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleHotCommentList | retCode " + i);
    owk localowk = new owk();
    owl localowl = new owl();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label469;
        }
        bool = true;
        localowk.jdField_a_of_type_Boolean = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleHotCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        localowk.jdField_a_of_type_JavaLangString = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.hot_comment_list.has()) {
        localowk.jdField_a_of_type_JavaUtilList = a(localRspBody.hot_comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localowl.jdField_a_of_type_Long = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label475;
        }
        if (paramFromServiceMsg.has_anchor.get() == 0) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.7(this));
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + paramFromServiceMsg.has_anchor.get());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (localRspBody.banner.has())
      {
        paramToServiceMsg = (oidb_cmd0xc46.Banner)localRspBody.banner.get();
        paramFromServiceMsg = new CommentData();
        paramFromServiceMsg.commentId = String.valueOf(paramToServiceMsg.config_id.get());
        paramFromServiceMsg.commentContent = paramToServiceMsg.title.get();
        paramFromServiceMsg.activityJumpUrl = paramToServiceMsg.jump_url.get();
        paramFromServiceMsg.isBanner = true;
        QLog.d("ReadInJoyCommentPBModule", 1, "hot comment banner configid ：" + paramFromServiceMsg.commentId + "; title :" + paramFromServiceMsg.commentContent + "; url" + paramFromServiceMsg.activityPicUrl);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.8(this, i, localowk, localowl, paramFromServiceMsg));
      return;
      label469:
      bool = false;
      break;
      label475:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xc46.RspBody();
    int i = qlk.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleSubCommentList | retCode " + i);
    paramFromServiceMsg = new owk();
    paramObject = new owl();
    boolean bool;
    if (i == 0) {
      if (((oidb_cmd0xc46.RspBody)localObject).next.has())
      {
        if (((oidb_cmd0xc46.RspBody)localObject).next.get() == 1)
        {
          bool = true;
          paramFromServiceMsg.jdField_a_of_type_Boolean = bool;
          QLog.d("ReadInJoyCommentPBModule", 1, "handleSubCommentList | hasNextPage " + ((oidb_cmd0xc46.RspBody)localObject).next.get());
        }
      }
      else
      {
        if (((oidb_cmd0xc46.RspBody)localObject).page_cookie.has()) {
          paramFromServiceMsg.jdField_a_of_type_JavaLangString = ((oidb_cmd0xc46.RspBody)localObject).page_cookie.get().toStringUtf8();
        }
        if (!((oidb_cmd0xc46.RspBody)localObject).comment_list.has()) {
          break label328;
        }
        paramFromServiceMsg.b = b(((oidb_cmd0xc46.RspBody)localObject).comment_list.get());
        label184:
        if (((oidb_cmd0xc46.RspBody)localObject).article_info.has())
        {
          localObject = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject).article_info.get();
          if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.has())) {
            break label342;
          }
          if (((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.get() == 0) {
            this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.9(this));
          }
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + ((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.get());
        }
      }
    }
    for (;;)
    {
      paramToServiceMsg = (String)paramToServiceMsg.getAttribute("parent_comment_id");
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.11(this, i, paramFromServiceMsg, paramToServiceMsg, paramObject));
      return;
      bool = false;
      break;
      label328:
      paramFromServiceMsg.b = new ArrayList();
      break label184;
      label342:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
      continue;
      paramFromServiceMsg.b = new ArrayList();
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.10(this, i));
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = qlk.a(paramFromServiceMsg, paramObject, new oidb_cmd0xc46.RspBody());
    int j = ((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue();
    uhv.a(i, paramToServiceMsg, 5, null);
    if (pay.a() == null) {
      return;
    }
    paramFromServiceMsg = new HashMap();
    paramFromServiceMsg.put("retCode", String.valueOf(i));
    paramFromServiceMsg.put("request_comment_type", String.valueOf(j));
    paramObject = StatisticCollector.getInstance(pay.a().getApplication());
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramObject.collectPerformance(null, "actKandian0xc46Result", bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), 0L, paramFromServiceMsg, null);
      QLog.d("ReadInJoyCommentPBModule", 1, "report0xc46Result | actKandian0xc46Result | retCode ： " + i + "| request_comment_type : " + j);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Otk = null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc46"))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() != 1) {
        break label90;
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdc8")) {
        QLog.d("ReadInJoyCommentPBModule", 1, "handle 0xdc8 : " + paramFromServiceMsg.toString());
      }
      return;
      label90:
      if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 4) {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 3) {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 2) {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 5) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 6) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestFamliyCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestFamliyCommentList | articleId : " + paramString1 + " contentSrc : " + paramInt2 + " ; pageCookie : " + paramString2);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    oidb_cmd0xc46.ReqParam localReqParam = new oidb_cmd0xc46.ReqParam();
    localReqParam.with_sub_comments.set(1);
    localReqParam.with_author_reply.set(1);
    localReqParam.with_style_data.set(1);
    localReqBody.req_param.set(localReqParam);
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    a(localReqBody, paramCommonCommentData);
    paramString1 = qlk.a("OidbSvc.0xc46", 3142, 6, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(6));
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestCommonCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestCommonCommentList | articleId : " + paramString1 + " contentSrc : " + paramInt2 + "; mainCommentId : " + paramString3 + " ; pageCookie : " + paramString2 + "; commonCommentData " + paramCommonCommentData);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    oidb_cmd0xc46.ReqParam localReqParam = new oidb_cmd0xc46.ReqParam();
    localReqParam.with_style_data.set(1);
    localReqParam.with_sub_comments.set(1);
    localReqParam.with_author_reply.set(1);
    localReqBody.req_param.set(localReqParam);
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestCommonCommentList | articleId : " + paramString1 + " contentSrc : " + paramInt2 + "; mainCommentId : " + paramString3 + " ; pageCookie : " + paramString2);
    paramString1 = qlk.a("OidbSvc.0xc46", 3142, 5, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(5));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString4 == null) || (paramString3 == null) || (paramString2 == null)) {}
    do
    {
      return;
      oidb_cmd0xdc8.ReqBody localReqBody = new oidb_cmd0xdc8.ReqBody();
      QLog.d("ReadInJoyCommentPBModule", 1, "start request 0xdc8  rowKey :" + paramString1 + " parentCommentId :" + paramString2 + " subCommentId : " + paramString3 + " commentId :" + paramString4);
      localReqBody.str_rowkey.set(paramString1);
      localReqBody.str_first_comment_id.set(paramString2);
      localReqBody.str_sub_comment_id.set(paramString3);
      localReqBody.str_comment_id.set(paramString4);
      localReqBody.int32_flag.set(1);
      paramString1 = qlk.a("OidbSvc.0xdc8", 3528, 1, localReqBody.toByteArray());
    } while (paramString1 == null);
    a(paramString1);
    QLog.d("ReadInJoyCommentPBModule", 1, "0xdc8 request :" + paramString1.toString());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestSubCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestSubCommentList | subPageCookie : " + paramString4);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.comment_id.set(paramString2);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString4));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.with_first_comment_detail.set(1);
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = qlk.a("OidbSvc.0xc46", 3142, 4, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(4));
    paramString1.addAttribute("parent_comment_id", paramString2);
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
  
  public void a(otk paramotk)
  {
    this.jdField_a_of_type_Otk = paramotk;
  }
  
  public void a(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if ((paramComment == null) || (paramBaseCommentData == null)) {
      return;
    }
    paramBaseCommentData.commentId = qlg.a(paramComment.comment_id, "");
    paramBaseCommentData.uin = qlg.a(paramComment.author_id, "");
    paramBaseCommentData.commentTime = qlg.a(paramComment.create_time);
    paramBaseCommentData.commentContent = qlg.a(paramComment.content, "");
    paramBaseCommentData.likeCnt = qlg.a(paramComment.like_num, 0);
    paramBaseCommentData.like = qlg.a(paramComment.like, 0);
    paramBaseCommentData.disLike = qlg.a(paramComment.dislike, 0);
    paramBaseCommentData.anonymous = qlg.a(paramComment.anonymous, 0);
    paramBaseCommentData.authorSelection = qlg.a(paramComment.author_selection, 0);
    paramBaseCommentData.rank = qlg.a(paramComment.rank, 0);
    paramBaseCommentData.level = qlg.a(paramComment.level);
    paramBaseCommentData.authorComment = qlg.a(paramComment.author_comment, "");
    paramBaseCommentData.nickName = qlg.a(paramComment.nick_name, "");
    boolean bool;
    if (qlg.a(paramComment.author_like) == 1) {
      bool = true;
    }
    for (;;)
    {
      paramBaseCommentData.isAuthorLike = bool;
      if (qlg.a(paramComment.follow_status) == 1)
      {
        bool = true;
        label204:
        paramBaseCommentData.isFollowing = bool;
        paramBaseCommentData.avatar = qlg.a(paramComment.avatar, "");
        a(paramBaseCommentData.avatar);
        paramBaseCommentData.myself = qlg.a(paramComment.myself, 0);
        paramBaseCommentData.homepage = qlg.a(paramComment.homepage, "");
        paramBaseCommentData.awesome = qlg.a(paramComment.awesome);
        paramBaseCommentData.rowKey = qlg.a(paramComment.rowkey, "");
        paramBaseCommentData.contentSrc = qlg.a(paramComment.content_source, 0);
        paramBaseCommentData.passthrough = qlg.a(paramComment.passthrough, "");
        paramBaseCommentData.isActivity = qlg.a(paramComment.is_activity);
        paramBaseCommentData.activityPicUrl = qlg.a(paramComment.pic_url, "");
        paramBaseCommentData.activityJumpUrl = qlg.a(paramComment.jump_url, "");
        paramBaseCommentData.isStar = qlg.a(paramComment.is_star);
        paramBaseCommentData.isApproved = qlg.a(paramComment.is_approved);
        if (paramComment.account_level_info.has())
        {
          paramBaseCommentData.accountLevelInfo = new oum();
          paramBaseCommentData.accountLevelInfo.jdField_a_of_type_Int = qlg.a(paramComment.account_level_info.uint32_account_cc_level);
          paramBaseCommentData.accountLevelInfo.jdField_a_of_type_JavaLangString = qlg.a(paramComment.account_level_info.account_cc_level_icon_s, "");
        }
        paramBaseCommentData.createSrc = qlg.a(paramComment.create_source, 0);
        QLog.d("ReadInJoyCommentPBModule", 1, "create_source : " + paramComment.create_source.get());
        paramBaseCommentData.isAuthorReply = qlg.a(paramComment.is_author_reply);
        paramBaseCommentData.userTitle = qlg.a(paramComment.user_title, "");
        paramBaseCommentData.ksHomePage = qlg.a(paramComment.ks_homepage, "");
        if (paramComment.activity.has()) {
          paramBaseCommentData.activityCfgID = qlg.a(paramComment.activity.config_id);
        }
        if (!paramComment.jump_schema.has()) {}
      }
      try
      {
        paramBaseCommentData.flowGuidePtsData = new String(bfuc.decode(paramComment.jump_schema.get(), 0), "utf-8");
        QLog.d("ReadInJoyCommentPBModule", 1, "flowGuidePtsData : " + paramBaseCommentData.flowGuidePtsData);
        label597:
        a(paramBaseCommentData, paramComment);
        paramBaseCommentData.styleData = qlg.a(paramComment.style_data, "");
        if (qlg.a(paramComment.comment_author_top) == 1) {}
        for (bool = true;; bool = false)
        {
          paramBaseCommentData.isAuthorSticky = bool;
          paramBaseCommentData.avatarPendantUrl = qlg.a(paramComment.avatar_pendant, "");
          paramBaseCommentData.commentLinkDataList = new ArrayList();
          if (!paramComment.link_data.has()) {
            break label826;
          }
          paramBaseCommentData.commentLinkDataList = new ArrayList();
          paramComment = paramComment.link_data.get();
          if (paramComment == null) {
            break label826;
          }
          paramComment = paramComment.iterator();
          while (paramComment.hasNext())
          {
            oidb_cmd0xc46.LinkData localLinkData = (oidb_cmd0xc46.LinkData)paramComment.next();
            if (localLinkData != null)
            {
              BaseCommentData.CommentLinkData localCommentLinkData = new BaseCommentData.CommentLinkData();
              localCommentLinkData.iconUrl = qlg.a(localLinkData.icon, "");
              localCommentLinkData.linkUrl = qlg.a(localLinkData.url, "");
              localCommentLinkData.type = qlg.a(localLinkData.type, 0);
              localCommentLinkData.wording = qlg.a(localLinkData.wording, "");
              paramBaseCommentData.commentLinkDataList.add(localCommentLinkData);
            }
          }
          bool = false;
          break;
          bool = false;
          break label204;
        }
        label826:
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyCommentPBModule", 1, "[convertBaseCommentData] uin = " + paramBaseCommentData.uin + ", avatarPendantUrl = " + paramBaseCommentData.avatarPendantUrl);
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "comment style_data " + paramBaseCommentData.styleData);
        QLog.d("ReadInJoyCommentPBModule", 2, "convertBaseCommentData | " + paramBaseCommentData.toString());
        return;
      }
      catch (Exception localException)
      {
        break label597;
      }
    }
  }
  
  public void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestNewCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestNewCommentList | newCookie : " + paramString2);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    paramString1 = new oidb_cmd0xc46.ReqParam();
    paramString1.with_sub_comments.set(1);
    paramString1.with_author_reply.set(1);
    paramString1.with_style_data.set(1);
    localReqBody.req_param.set(paramString1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = qlk.a("OidbSvc.0xc46", 3142, 2, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(2));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
  
  public void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestHotCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestHotCommentList | hotPageCookie : " + paramString2);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    paramString1 = new oidb_cmd0xc46.ReqParam();
    paramString1.with_sub_comments.set(1);
    paramString1.with_author_reply.set(1);
    paramString1.with_style_data.set(1);
    localReqBody.req_param.set(paramString1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = qlk.a("OidbSvc.0xc46", 3142, 3, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(3));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owh
 * JD-Core Version:    0.7.0.1
 */