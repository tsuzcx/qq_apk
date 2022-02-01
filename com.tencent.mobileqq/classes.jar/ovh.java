import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
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
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
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
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AdRspInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ArticleInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Banner;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Comment;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ExtraInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Label;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MedalInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MediaData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqAdvertisePara;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqBody;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqParam;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RspBody;
import tencent.im.oidb.cmd0xdc8.oidb_cmd0xdc8.ReqBody;

public class ovh
  extends pqj
{
  private osl a;
  
  public ovh(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qfo paramqfo, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqfo, paramHandler);
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
        break label237;
      }
    }
    label237:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCommentData.isDelete = bool1;
      if (paramComment.rpt_medal_info_list.has()) {
        localCommentData.medalInfo = a(false, paramComment.rpt_medal_info_list.get(), localCommentData.uin);
      }
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
        break label239;
      }
    }
    label239:
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
  
  private oih a(boolean paramBoolean, List<oidb_cmd0xc46.MedalInfo> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        oidb_cmd0xc46.MedalInfo localMedalInfo = (oidb_cmd0xc46.MedalInfo)paramList.next();
        oih localoih = new oih();
        if (localMedalInfo.is_jump.has()) {
          localoih.jdField_b_of_type_Int = localMedalInfo.is_jump.get();
        }
        if (localMedalInfo.jump_url.has()) {
          localoih.jdField_c_of_type_JavaLangString = localMedalInfo.jump_url.get().toStringUtf8();
        }
        if (localMedalInfo.medal_type.has()) {
          localoih.jdField_a_of_type_Int = localMedalInfo.medal_type.get();
        }
        if (localMedalInfo.medal_id.has()) {
          localoih.jdField_a_of_type_Long = localMedalInfo.medal_id.get();
        }
        if (localMedalInfo.medal_name.has()) {
          localoih.jdField_a_of_type_JavaLangString = localMedalInfo.medal_name.get().toStringUtf8();
        }
        if (localMedalInfo.medal_url.has()) {
          localoih.jdField_b_of_type_JavaLangString = localMedalInfo.medal_url.get().toStringUtf8();
        }
        if (localMedalInfo.pic_width.has()) {
          localoih.jdField_c_of_type_Int = localMedalInfo.pic_width.get();
        }
        if (localMedalInfo.pic_height.has()) {
          localoih.jdField_d_of_type_Int = localMedalInfo.pic_height.get();
        }
        localoih.jdField_e_of_type_JavaLangString = "3";
        if (paramBoolean) {}
        for (localoih.f = "7";; localoih.f = "6")
        {
          localoih.h = paramString;
          localArrayList.add(localoih);
          break;
        }
      }
    }
    paramList = null;
    if (!localArrayList.isEmpty()) {
      paramList = (oih)localArrayList.get(0);
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
          oto localoto = new oto();
          localoto.jdField_a_of_type_JavaLangString = localMediaData.text.get();
          localoto.jdField_e_of_type_Int = localMediaData.media_type.get();
          localoto.jdField_a_of_type_Int = localMediaData.pic_width.get();
          localoto.jdField_b_of_type_Int = localMediaData.pic_length.get();
          localoto.jdField_b_of_type_JavaLangString = localMediaData.pic_url.get();
          localoto.jdField_e_of_type_JavaLangString = localMediaData.thumbnail_url.get();
          localoto.jdField_d_of_type_JavaLangString = localMediaData.video_url.get();
          localoto.jdField_d_of_type_Int = localMediaData.video_duration.get();
          localoto.jdField_c_of_type_JavaLangString = localMediaData.sound_url.get();
          localoto.jdField_c_of_type_Int = localMediaData.sound_duration.get();
          paramBaseCommentData.mediaDataList.add(localoto);
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
      suo localsuo = new suo();
      localsuo.jdField_b_of_type_Boolean = true;
      localsuo.jdField_b_of_type_Int = bhtq.b(37.0F);
      localsuo.jdField_a_of_type_Int = bhtq.b(37.0F);
      localsuo.jdField_c_of_type_Int = 1;
      pnk.a.a(localsuo, paramString);
      sun.a().a(localsuo, new ovi(paramString));
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
  
  private void b(@NotNull BaseCommentData paramBaseCommentData, @NotNull oidb_cmd0xc46.Comment paramComment)
  {
    boolean bool = true;
    if (qfm.a(paramComment.is_ad, 0) == 1)
    {
      paramBaseCommentData.isAd = bool;
      if ((paramBaseCommentData.isAd) && (paramComment.ad_rsp_info.has()) && (paramComment.ad_rsp_info.data.has()))
      {
        paramComment = tpk.a(paramComment.ad_rsp_info.data.get().toByteArray());
        if (paramComment.size() > 0)
        {
          paramBaseCommentData.advertisementInfo = ((AdvertisementInfo)paramComment.get(0));
          if ((paramBaseCommentData.advertisementInfo != null) && (paramBaseCommentData.advertisementInfo.mCommentAdParams != null)) {
            break label108;
          }
        }
      }
    }
    label108:
    do
    {
      return;
      bool = false;
      break;
      if (paramBaseCommentData.advertisementInfo.mCommentAdParams.jdField_c_of_type_Int > 0) {
        tpk.jdField_b_of_type_Int = paramBaseCommentData.advertisementInfo.mCommentAdParams.jdField_c_of_type_Int;
      }
    } while (paramBaseCommentData.advertisementInfo.mCommentAdParams.jdField_b_of_type_Int <= 0);
    tpk.jdField_a_of_type_Int = paramBaseCommentData.advertisementInfo.mCommentAdParams.jdField_b_of_type_Int;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xc46.RspBody();
    int j = qfq.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleCommonCommentList | retCode " + j);
    paramFromServiceMsg = new ovk();
    paramObject = new ovk();
    ovl localovl = new ovl();
    localovl.jdField_a_of_type_Ovj = new ovj();
    boolean bool;
    if (j == 0)
    {
      if (qfm.a(((oidb_cmd0xc46.RspBody)localObject1).next, 0) != 1) {
        break label1044;
      }
      bool = true;
    }
    for (;;)
    {
      paramObject.jdField_a_of_type_Boolean = bool;
      QLog.d("ReadInJoyCommentPBModule", 2, "handleCommonCommentList | hasNextPage " + ((oidb_cmd0xc46.RspBody)localObject1).next.get());
      paramObject.jdField_a_of_type_JavaLangString = qfm.a(((oidb_cmd0xc46.RspBody)localObject1).page_cookie, "");
      if (((oidb_cmd0xc46.RspBody)localObject1).extra_info.has())
      {
        if (qfm.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).hot_next, 0) != 1) {
          break label1050;
        }
        bool = true;
        paramFromServiceMsg.jdField_a_of_type_Boolean = bool;
        paramFromServiceMsg.jdField_a_of_type_JavaLangString = qfm.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).hot_page_cookie, "");
        localovl.b = qfm.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).hidden_comment_count, 0);
        localovl.jdField_a_of_type_Int = qfm.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).show_mask, 0);
        if (!((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).jump_kva_schema.has()) {}
      }
      try
      {
        localovl.jdField_a_of_type_JavaLangString = new String(bhkv.decode(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).jump_kva_schema.get(), 0), "utf-8");
        if (qfm.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).is_pgc_author, 0) == 1)
        {
          bool = true;
          localovl.jdField_a_of_type_Boolean = bool;
          Object localObject2;
          if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.has())
          {
            localObject2 = localovl.jdField_a_of_type_Ovj;
            if (qfm.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_delete, 0) != 1) {
              break label1072;
            }
            bool = true;
            ((ovj)localObject2).jdField_a_of_type_Boolean = bool;
            localObject2 = localovl.jdField_a_of_type_Ovj;
            if (qfm.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_top, 0) != 1) {
              break label1078;
            }
            bool = true;
            ((ovj)localObject2).c = bool;
            localObject2 = localovl.jdField_a_of_type_Ovj;
            if (qfm.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_sink, 0) != 1) {
              break label1084;
            }
            bool = true;
            ((ovj)localObject2).jdField_b_of_type_Boolean = bool;
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
            localovl.jdField_a_of_type_Long = qfm.a(((oidb_cmd0xc46.ArticleInfo)localObject2).comment_count, 0L);
            if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.has())) {
              break label1090;
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
          localObject1 = new StringBuilder().append("handleCommonCommentList | retCode ").append(j).append(" | hasNewNextPage ").append(paramObject.jdField_a_of_type_Boolean).append(" | hasHotNextPage+").append(paramFromServiceMsg.jdField_a_of_type_Boolean).append(" | newPageCookie ").append(paramObject.jdField_a_of_type_JavaLangString).append("; hotPageCookie ").append(paramFromServiceMsg.jdField_a_of_type_JavaLangString).append("| articleCommentCnt ").append(localovl.jdField_a_of_type_Long).append(" | hotCommentListSize ");
          if (paramFromServiceMsg.jdField_a_of_type_JavaUtilList == null) {
            break label1103;
          }
          i = paramFromServiceMsg.jdField_a_of_type_JavaUtilList.size();
          localObject1 = ((StringBuilder)localObject1).append(i).append(" | newCommentListSize ");
          if (paramObject.jdField_a_of_type_JavaUtilList == null) {
            break label1109;
          }
          i = paramObject.jdField_a_of_type_JavaUtilList.size();
          QLog.d("ReadInJoyCommentPBModule", 1, i + " ; extraInfo : " + localovl);
          if (paramFromServiceMsg.a()) {
            paramFromServiceMsg.jdField_a_of_type_JavaUtilList.add(0, paramToServiceMsg);
          }
          if (paramObject.a()) {
            paramObject.jdField_a_of_type_JavaUtilList.add(0, paramToServiceMsg);
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.2(this, j, paramFromServiceMsg, paramObject, localovl));
          return;
          label1044:
          bool = false;
          continue;
          label1050:
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
          label1072:
          bool = false;
          continue;
          label1078:
          bool = false;
          continue;
          label1084:
          bool = false;
          continue;
          label1090:
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
          continue;
          label1103:
          int i = 0;
          continue;
          label1109:
          i = 0;
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = qfq.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleFamilyCommentList | retCode " + i);
    ovk localovk = new ovk();
    ovl localovl = new ovl();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label473;
        }
        bool = true;
        localovk.jdField_a_of_type_Boolean = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleFamilyCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        localovk.jdField_a_of_type_JavaLangString = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.comment_list.has()) {
        localovk.jdField_a_of_type_JavaUtilList = a(localRspBody.comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localovl.jdField_a_of_type_Long = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label479;
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
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.4(this, i, localovk, localovl, paramFromServiceMsg));
      return;
      label473:
      bool = false;
      break;
      label479:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = qfq.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleNewCommentList | retCode " + i);
    ovk localovk = new ovk();
    ovl localovl = new ovl();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label473;
        }
        bool = true;
        localovk.jdField_a_of_type_Boolean = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleNewCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        localovk.jdField_a_of_type_JavaLangString = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.comment_list.has()) {
        localovk.jdField_a_of_type_JavaUtilList = a(localRspBody.comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localovl.jdField_a_of_type_Long = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label479;
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
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.6(this, i, localovk, localovl, paramFromServiceMsg));
      return;
      label473:
      bool = false;
      break;
      label479:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = qfq.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleHotCommentList | retCode " + i);
    ovk localovk = new ovk();
    ovl localovl = new ovl();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label473;
        }
        bool = true;
        localovk.jdField_a_of_type_Boolean = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleHotCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        localovk.jdField_a_of_type_JavaLangString = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.hot_comment_list.has()) {
        localovk.jdField_a_of_type_JavaUtilList = a(localRspBody.hot_comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localovl.jdField_a_of_type_Long = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label479;
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
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.8(this, i, localovk, localovl, paramFromServiceMsg));
      return;
      label473:
      bool = false;
      break;
      label479:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xc46.RspBody();
    int i = qfq.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleSubCommentList | retCode " + i);
    paramFromServiceMsg = new ovk();
    paramObject = new ovl();
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
          break label331;
        }
        paramFromServiceMsg.b = b(((oidb_cmd0xc46.RspBody)localObject).comment_list.get());
        label186:
        if (((oidb_cmd0xc46.RspBody)localObject).article_info.has())
        {
          localObject = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject).article_info.get();
          if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.has())) {
            break label345;
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
      label331:
      paramFromServiceMsg.b = new ArrayList();
      break label186;
      label345:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
      continue;
      paramFromServiceMsg.b = new ArrayList();
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.10(this, i));
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = qfq.a(paramFromServiceMsg, paramObject, new oidb_cmd0xc46.RspBody());
    int j = ((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue();
    ubg.a(i, paramToServiceMsg, 5, null);
    if (ozs.a() == null) {
      return;
    }
    paramFromServiceMsg = new HashMap();
    paramFromServiceMsg.put("retCode", String.valueOf(i));
    paramFromServiceMsg.put("request_comment_type", String.valueOf(j));
    paramObject = bdmc.a(ozs.a().getApplication());
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramObject.a(null, "actKandian0xc46Result", bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), 0L, paramFromServiceMsg, null);
      QLog.d("ReadInJoyCommentPBModule", 1, "report0xc46Result | actKandian0xc46Result | retCode ： " + i + "| request_comment_type : " + j);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Osl = null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc46"))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() != 1) {
        break label91;
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdc8")) {
        QLog.d("ReadInJoyCommentPBModule", 1, "handle 0xdc8 : " + paramFromServiceMsg.toString());
      }
      return;
      label91:
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
    paramString1 = qfq.a("OidbSvc.0xc46", 3142, 6, localReqBody.toByteArray());
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
    localReqParam.req_advertise_para.set(tpk.a(1, tpk.a(paramString1, 1), paramInt1, null));
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
    paramString1 = qfq.a("OidbSvc.0xc46", 3142, 5, localReqBody.toByteArray());
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
      paramString1 = qfq.a("OidbSvc.0xdc8", 3528, 1, localReqBody.toByteArray());
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
    paramString1 = qfq.a("OidbSvc.0xc46", 3142, 4, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(4));
    paramString1.addAttribute("parent_comment_id", paramString2);
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
  
  public void a(osl paramosl)
  {
    this.jdField_a_of_type_Osl = paramosl;
  }
  
  public void a(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    boolean bool2 = false;
    if ((paramComment == null) || (paramBaseCommentData == null)) {
      return;
    }
    paramBaseCommentData.commentId = qfm.a(paramComment.comment_id, "");
    paramBaseCommentData.uin = qfm.a(paramComment.author_id, "");
    paramBaseCommentData.commentTime = qfm.a(paramComment.create_time);
    paramBaseCommentData.commentContent = qfm.a(paramComment.content, "");
    paramBaseCommentData.likeCnt = qfm.a(paramComment.like_num, 0);
    paramBaseCommentData.like = qfm.a(paramComment.like, 0);
    paramBaseCommentData.disLike = qfm.a(paramComment.dislike, 0);
    paramBaseCommentData.anonymous = qfm.a(paramComment.anonymous, 0);
    paramBaseCommentData.authorSelection = qfm.a(paramComment.author_selection, 0);
    paramBaseCommentData.rank = qfm.a(paramComment.rank, 0);
    paramBaseCommentData.level = qfm.a(paramComment.level);
    paramBaseCommentData.authorComment = qfm.a(paramComment.author_comment, "");
    paramBaseCommentData.nickName = qfm.a(paramComment.nick_name, "");
    boolean bool1;
    if (qfm.a(paramComment.author_like) == 1) {
      bool1 = true;
    }
    for (;;)
    {
      paramBaseCommentData.isAuthorLike = bool1;
      if (qfm.a(paramComment.follow_status) == 1)
      {
        bool1 = true;
        paramBaseCommentData.isFollowing = bool1;
        paramBaseCommentData.avatar = qfm.a(paramComment.avatar, "");
        a(paramBaseCommentData.avatar);
        paramBaseCommentData.myself = qfm.a(paramComment.myself, 0);
        paramBaseCommentData.homepage = qfm.a(paramComment.homepage, "");
        paramBaseCommentData.awesome = qfm.a(paramComment.awesome);
        paramBaseCommentData.rowKey = qfm.a(paramComment.rowkey, "");
        paramBaseCommentData.contentSrc = qfm.a(paramComment.content_source, 0);
        paramBaseCommentData.passthrough = qfm.a(paramComment.passthrough, "");
        paramBaseCommentData.isActivity = qfm.a(paramComment.is_activity);
        paramBaseCommentData.activityPicUrl = qfm.a(paramComment.pic_url, "");
        paramBaseCommentData.activityJumpUrl = qfm.a(paramComment.jump_url, "");
        paramBaseCommentData.isStar = qfm.a(paramComment.is_star);
        paramBaseCommentData.isApproved = qfm.a(paramComment.is_approved);
        if (paramComment.account_level_info.has())
        {
          paramBaseCommentData.accountLevelInfo = new otn();
          paramBaseCommentData.accountLevelInfo.jdField_a_of_type_Int = qfm.a(paramComment.account_level_info.uint32_account_cc_level);
          paramBaseCommentData.accountLevelInfo.jdField_a_of_type_JavaLangString = qfm.a(paramComment.account_level_info.account_cc_level_icon_s, "");
        }
        paramBaseCommentData.createSrc = qfm.a(paramComment.create_source, 0);
        QLog.d("ReadInJoyCommentPBModule", 1, "create_source : " + paramComment.create_source.get());
        paramBaseCommentData.isAuthorReply = qfm.a(paramComment.is_author_reply);
        paramBaseCommentData.userTitle = qfm.a(paramComment.user_title, "");
        paramBaseCommentData.ksHomePage = qfm.a(paramComment.ks_homepage, "");
        if (paramComment.activity.has()) {
          paramBaseCommentData.activityCfgID = qfm.a(paramComment.activity.config_id);
        }
        if (!paramComment.jump_schema.has()) {}
      }
      try
      {
        paramBaseCommentData.flowGuidePtsData = new String(bhkv.decode(paramComment.jump_schema.get(), 0), "utf-8");
        QLog.d("ReadInJoyCommentPBModule", 1, "flowGuidePtsData : " + paramBaseCommentData.flowGuidePtsData);
        label602:
        a(paramBaseCommentData, paramComment);
        b(paramBaseCommentData, paramComment);
        paramBaseCommentData.styleData = qfm.a(paramComment.style_data, "");
        bool1 = bool2;
        if (qfm.a(paramComment.comment_author_top) == 1) {
          bool1 = true;
        }
        paramBaseCommentData.isAuthorSticky = bool1;
        paramBaseCommentData.avatarPendantUrl = qfm.a(paramComment.avatar_pendant, "");
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyCommentPBModule", 1, "[convertBaseCommentData] uin = " + paramBaseCommentData.uin + ", avatarPendantUrl = " + paramBaseCommentData.avatarPendantUrl);
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "comment style_data " + paramBaseCommentData.styleData);
        return;
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (Exception localException)
      {
        break label602;
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
    paramString2 = new oidb_cmd0xc46.ReqParam();
    paramString2.with_sub_comments.set(1);
    paramString2.with_author_reply.set(1);
    paramString2.with_style_data.set(1);
    paramString2.req_advertise_para.set(tpk.a(1, tpk.a(paramString1, 2), paramInt1, null));
    localReqBody.req_param.set(paramString2);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = qfq.a("OidbSvc.0xc46", 3142, 2, localReqBody.toByteArray());
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
    paramString2 = new oidb_cmd0xc46.ReqParam();
    paramString2.with_sub_comments.set(1);
    paramString2.with_author_reply.set(1);
    paramString2.with_style_data.set(1);
    paramString2.req_advertise_para.set(tpk.a(1, tpk.a(paramString1, 3), paramInt1, null));
    localReqBody.req_param.set(paramString2);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = qfq.a("OidbSvc.0xc46", 3142, 3, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(3));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovh
 * JD-Core Version:    0.7.0.1
 */