package com.tencent.mobileqq.kandian.biz.comment.data;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.CommentAdParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.RIJImageTypeOptHelper;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils.CommentAdUtilParams;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.AccountLevelInfo;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.MediaData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.UserIdentityIcon;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData.RepliedCommentData;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentAegisHelper;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJPerformanceReporter;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyMedalInfo;
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
import com.tencent.mobileqq.utils.Base64Util;
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
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ActivityLevel;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AdRspInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ArticleInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AtData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Banner;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Comment;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ExtraInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.HerfData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Label;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.LinkData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MedalInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MediaData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RepliedCommentInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqAdvertisePara;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqBody;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqParam;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RptData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RspBody;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.TextData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.UserIdentityIcon;
import tencent.im.oidb.cmd0xdc8.oidb_cmd0xdc8.ReqBody;

public class ReadInJoyCommentPBModule
  extends ReadInJoyEngineModule
{
  private ReadInJoyCommentObserver a = null;
  
  public ReadInJoyCommentPBModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private static RIJCommentAdUtils.CommentAdUtilParams a(RIJRequestDataForComment paramRIJRequestDataForComment, int paramInt)
  {
    RIJCommentAdUtils.CommentAdUtilParams localCommentAdUtilParams = new RIJCommentAdUtils.CommentAdUtilParams();
    localCommentAdUtilParams.a = 1;
    localCommentAdUtilParams.b = RIJCommentAdUtils.a(paramRIJRequestDataForComment.a, paramInt);
    localCommentAdUtilParams.d = paramRIJRequestDataForComment;
    return localCommentAdUtilParams;
  }
  
  @Nullable
  private static BaseCommentData.CommentRptData a(oidb_cmd0xc46.RptData paramRptData)
  {
    if (paramRptData.text_data.has())
    {
      paramRptData = (oidb_cmd0xc46.TextData)paramRptData.text_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.a = 0;
        localCommentRptData.b = RIJPBFieldUtils.a(paramRptData.content, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  private CommentData a(oidb_cmd0xc46.Comment paramComment)
  {
    if ((paramComment != null) && (paramComment.comment_id.has()))
    {
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
          SubCommentData localSubCommentData = b((oidb_cmd0xc46.Comment)localIterator.next());
          if (localSubCommentData != null) {
            localCommentData.subCommentList.add(localSubCommentData);
          }
        }
      }
      boolean bool1 = paramComment.is_anchor.has();
      boolean bool2 = true;
      if (bool1)
      {
        if (paramComment.is_anchor.get() == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localCommentData.isAnchor = bool1;
      }
      if (paramComment.is_delete.has())
      {
        if (paramComment.is_delete.get() == 1) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        localCommentData.isDelete = bool1;
      }
      if (paramComment.rpt_medal_info_list.has()) {
        localCommentData.medalInfo = a(false, paramComment.rpt_medal_info_list.get(), localCommentData.uin);
      }
      paramComment = new StringBuilder();
      paramComment.append("convertCommentData | ");
      paramComment.append(localCommentData.toString());
      QLog.d("ReadInJoyCommentPBModule", 2, paramComment.toString());
      return localCommentData;
    }
    return null;
  }
  
  private ReadInJoyMedalInfo a(boolean paramBoolean, List<oidb_cmd0xc46.MedalInfo> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0xc46.MedalInfo localMedalInfo = (oidb_cmd0xc46.MedalInfo)paramList.next();
        ReadInJoyMedalInfo localReadInJoyMedalInfo = new ReadInJoyMedalInfo();
        if (localMedalInfo.is_jump.has()) {
          localReadInJoyMedalInfo.e = localMedalInfo.is_jump.get();
        }
        if (localMedalInfo.jump_url.has()) {
          localReadInJoyMedalInfo.f = localMedalInfo.jump_url.get().toStringUtf8();
        }
        if (localMedalInfo.medal_type.has()) {
          localReadInJoyMedalInfo.d = localMedalInfo.medal_type.get();
        }
        if (localMedalInfo.medal_id.has()) {
          localReadInJoyMedalInfo.a = localMedalInfo.medal_id.get();
        }
        if (localMedalInfo.medal_name.has()) {
          localReadInJoyMedalInfo.b = localMedalInfo.medal_name.get().toStringUtf8();
        }
        if (localMedalInfo.medal_url.has()) {
          localReadInJoyMedalInfo.c = localMedalInfo.medal_url.get().toStringUtf8();
        }
        if (localMedalInfo.pic_width.has()) {
          localReadInJoyMedalInfo.g = localMedalInfo.pic_width.get();
        }
        if (localMedalInfo.pic_height.has()) {
          localReadInJoyMedalInfo.h = localMedalInfo.pic_height.get();
        }
        localReadInJoyMedalInfo.j = "3";
        if (paramBoolean) {
          localReadInJoyMedalInfo.k = "7";
        } else {
          localReadInJoyMedalInfo.k = "6";
        }
        localReadInJoyMedalInfo.m = paramString;
        localArrayList.add(localReadInJoyMedalInfo);
      }
    }
    paramList = null;
    if (!localArrayList.isEmpty()) {
      paramList = (ReadInJoyMedalInfo)localArrayList.get(0);
    }
    return paramList;
  }
  
  private List<CommentData> a(List<oidb_cmd0xc46.Comment> paramList)
  {
    if (paramList.isEmpty()) {
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
        if (((CommentData)localObject).isAd)
        {
          if (RIJCommentAdUtils.a()) {
            localArrayList.add(localObject);
          }
        }
        else {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xc46.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleCommonCommentList | retCode ");
    paramFromServiceMsg.append(j);
    QLog.d("ReadInJoyCommentPBModule", 1, paramFromServiceMsg.toString());
    paramFromServiceMsg = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    paramObject = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    ReadInJoyCommentPBModule.ResponseExtraInfo localResponseExtraInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    localResponseExtraInfo.f = new ReadInJoyCommentPBModule.Label();
    if (j == 0)
    {
      boolean bool;
      if (RIJPBFieldUtils.a(((oidb_cmd0xc46.RspBody)localObject).next, 0) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramObject.d = bool;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleCommonCommentList | hasNextPage ");
      localStringBuilder.append(((oidb_cmd0xc46.RspBody)localObject).next.get());
      QLog.d("ReadInJoyCommentPBModule", 2, localStringBuilder.toString());
      paramObject.e = RIJPBFieldUtils.a(((oidb_cmd0xc46.RspBody)localObject).page_cookie, "");
      if (((oidb_cmd0xc46.RspBody)localObject).extra_info.has())
      {
        if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).hot_next, 0) == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramFromServiceMsg.d = bool;
        paramFromServiceMsg.e = RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).hot_page_cookie, "");
        localResponseExtraInfo.b = RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).hidden_comment_count, 0);
        localResponseExtraInfo.c = RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).show_mask, 0);
        if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).jump_kva_schema.has()) {
          try
          {
            localResponseExtraInfo.d = new String(Base64Util.decode(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).jump_kva_schema.get(), 0), "utf-8");
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).is_pgc_author, 0) == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localResponseExtraInfo.e = bool;
        if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).is_show_label, 0) == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localResponseExtraInfo.g = bool;
        if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).default_input.has()) {
          localResponseExtraInfo.h = ((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).default_input.get();
        }
        a((oidb_cmd0xc46.RspBody)localObject, localResponseExtraInfo);
      }
      if (((oidb_cmd0xc46.RspBody)localObject).hot_comment_list.has()) {
        paramFromServiceMsg.a = a(((oidb_cmd0xc46.RspBody)localObject).hot_comment_list.get());
      }
      if (((oidb_cmd0xc46.RspBody)localObject).comment_list.has()) {
        paramObject.a = a(((oidb_cmd0xc46.RspBody)localObject).comment_list.get());
      }
      if (((oidb_cmd0xc46.RspBody)localObject).article_info.has())
      {
        oidb_cmd0xc46.ArticleInfo localArticleInfo = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject).article_info.get();
        localResponseExtraInfo.a = RIJPBFieldUtils.a(localArticleInfo.comment_count, 0L);
        if ((paramToServiceMsg.getAttribute("anchor_request") != null) && (localArticleInfo.has_anchor.has()))
        {
          if (localArticleInfo.has_anchor.get() == 0) {
            this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.1(this));
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("has_anchor: ");
          paramToServiceMsg.append(localArticleInfo.has_anchor.get());
          QLog.d("ReadInJoyCommentPBModule", 1, paramToServiceMsg.toString());
        }
        else
        {
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
        }
      }
    }
    paramToServiceMsg = null;
    if (((oidb_cmd0xc46.RspBody)localObject).banner.has())
    {
      localObject = (oidb_cmd0xc46.Banner)((oidb_cmd0xc46.RspBody)localObject).banner.get();
      paramToServiceMsg = new CommentData();
      paramToServiceMsg.commentId = String.valueOf(((oidb_cmd0xc46.Banner)localObject).config_id.get());
      paramToServiceMsg.commentContent = ((oidb_cmd0xc46.Banner)localObject).title.get();
      paramToServiceMsg.activityJumpUrl = ((oidb_cmd0xc46.Banner)localObject).jump_url.get();
      paramToServiceMsg.isBanner = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleCommonCommentList | banner configid ：");
      ((StringBuilder)localObject).append(paramToServiceMsg.commentId);
      ((StringBuilder)localObject).append("; title :");
      ((StringBuilder)localObject).append(paramToServiceMsg.commentContent);
      ((StringBuilder)localObject).append("; url ");
      ((StringBuilder)localObject).append(paramToServiceMsg.activityJumpUrl);
      QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleCommonCommentList | retCode ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" | hasNewNextPage ");
    ((StringBuilder)localObject).append(paramObject.d);
    ((StringBuilder)localObject).append(" | hasHotNextPage+");
    ((StringBuilder)localObject).append(paramFromServiceMsg.d);
    ((StringBuilder)localObject).append(" | newPageCookie ");
    ((StringBuilder)localObject).append(paramObject.e);
    ((StringBuilder)localObject).append("; hotPageCookie ");
    ((StringBuilder)localObject).append(paramFromServiceMsg.e);
    ((StringBuilder)localObject).append("| articleCommentCnt ");
    ((StringBuilder)localObject).append(localResponseExtraInfo.a);
    ((StringBuilder)localObject).append(" | hotCommentListSize ");
    int i;
    if (paramFromServiceMsg.a != null) {
      i = paramFromServiceMsg.a.size();
    } else {
      i = 0;
    }
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" | newCommentListSize ");
    if (paramObject.a != null) {
      i = paramObject.a.size();
    } else {
      i = 0;
    }
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" ; extraInfo : ");
    ((StringBuilder)localObject).append(localResponseExtraInfo);
    QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject).toString());
    if (paramFromServiceMsg.a()) {
      paramFromServiceMsg.a.add(0, paramToServiceMsg);
    }
    if (paramObject.a()) {
      paramObject.a.add(0, paramToServiceMsg);
    }
    this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.2(this, j, paramFromServiceMsg, paramObject, localResponseExtraInfo));
  }
  
  private static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        ImageRequest localImageRequest = new ImageRequest();
        localImageRequest.e = true;
        localImageRequest.c = ViewUtils.dpToPx(37.0F);
        localImageRequest.b = ViewUtils.dpToPx(37.0F);
        localImageRequest.g = 1;
        RIJImageTypeOptHelper.a.a(localImageRequest, paramString);
        ImageManager.get().loadImage(localImageRequest, new ReadInJoyCommentPBModule.12(paramString));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("ReadInJoyCommentPBModule", 2, paramString.getMessage());
      }
    }
  }
  
  private void a(oidb_cmd0xc46.ReqBody paramReqBody, CommonCommentData paramCommonCommentData)
  {
    if (paramCommonCommentData == null) {
      return;
    }
    if (paramCommonCommentData.getFeedsType() != -1) {
      paramReqBody.feeds_type.set(paramCommonCommentData.getFeedsType());
    }
    if (!TextUtils.isEmpty(paramCommonCommentData.getFeedsId())) {
      paramReqBody.feeds_id.set(paramCommonCommentData.getFeedsId());
    }
  }
  
  private static void a(oidb_cmd0xc46.RptData paramRptData, BaseCommentData paramBaseCommentData)
  {
    int i = RIJPBFieldUtils.a(paramRptData.data_type, 0);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            ReadInJoyHelper.a("ReadInJoyCommentPBModule", new IllegalArgumentException("未处理的case"));
            paramRptData = null;
          }
          else
          {
            paramRptData = b(paramRptData);
          }
        }
        else {
          paramRptData = c(paramRptData);
        }
      }
      else {
        paramRptData = d(paramRptData);
      }
    }
    else {
      paramRptData = a(paramRptData);
    }
    if (paramRptData != null) {
      paramBaseCommentData.commentRptDataList.add(paramRptData);
    }
  }
  
  private void a(oidb_cmd0xc46.RspBody paramRspBody, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo)
  {
    if (((oidb_cmd0xc46.ExtraInfo)paramRspBody.extra_info.get()).label.has())
    {
      paramRspBody = ((oidb_cmd0xc46.ExtraInfo)paramRspBody.extra_info.get()).label;
      ReadInJoyCommentPBModule.Label localLabel = paramResponseExtraInfo.f;
      PBUInt32Field localPBUInt32Field = paramRspBody.show_delete;
      boolean bool2 = false;
      if (RIJPBFieldUtils.a(localPBUInt32Field, 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localLabel.a = bool1;
      localLabel = paramResponseExtraInfo.f;
      if (RIJPBFieldUtils.a(paramRspBody.show_top, 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localLabel.c = bool1;
      localLabel = paramResponseExtraInfo.f;
      if (RIJPBFieldUtils.a(paramRspBody.show_sink, 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localLabel.b = bool1;
      localLabel = paramResponseExtraInfo.f;
      if (RIJPBFieldUtils.a(paramRspBody.show_block, 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localLabel.d = bool1;
      paramResponseExtraInfo = paramResponseExtraInfo.f;
      boolean bool1 = bool2;
      if (RIJPBFieldUtils.a(paramRspBody.show_arbitration, 0) == 1) {
        bool1 = true;
      }
      paramResponseExtraInfo.e = bool1;
    }
  }
  
  @Nullable
  private static BaseCommentData.CommentRptData b(oidb_cmd0xc46.RptData paramRptData)
  {
    if (paramRptData.herf_data.has())
    {
      paramRptData = (oidb_cmd0xc46.HerfData)paramRptData.herf_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.a = 3;
        localCommentRptData.b = RIJPBFieldUtils.a(paramRptData.content, "");
        localCommentRptData.d = RIJPBFieldUtils.a(paramRptData.url, "");
        localCommentRptData.e = RIJPBFieldUtils.a(paramRptData.topic_id, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  private SubCommentData b(oidb_cmd0xc46.Comment paramComment)
  {
    if ((paramComment != null) && (paramComment.comment_id.has()))
    {
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
      boolean bool1 = paramComment.is_anchor.has();
      boolean bool2 = false;
      if (bool1)
      {
        if (paramComment.is_anchor.get() == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localSubCommentData.isAnchor = bool1;
      }
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
      if (paramComment.replied_comment.has()) {
        localSubCommentData.repliedCommentData = a((oidb_cmd0xc46.RepliedCommentInfo)paramComment.replied_comment.get());
      }
      paramComment = new StringBuilder();
      paramComment.append("convertSubCommentData | ");
      paramComment.append(localSubCommentData.toString());
      QLog.d("ReadInJoyCommentPBModule", 2, paramComment.toString());
      return localSubCommentData;
    }
    return null;
  }
  
  private List<SubCommentData> b(List<oidb_cmd0xc46.Comment> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (oidb_cmd0xc46.Comment)paramList.next();
        if (localObject != null)
        {
          localObject = b((oidb_cmd0xc46.Comment)localObject);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  private void b(@NotNull BaseCommentData paramBaseCommentData, @NotNull oidb_cmd0xc46.Comment paramComment)
  {
    if ((paramComment.is_multi_media.has()) && (paramComment.is_multi_media.get() == 1))
    {
      QLog.d("ReadInJoyCommentPBModule", 1, "comment type is multi media");
      if (paramComment.rpt_media_data_list.has()) {
        paramComment = paramComment.rpt_media_data_list.get();
      } else {
        paramComment = null;
      }
      if ((paramComment != null) && (paramComment.size() > 0))
      {
        int j = paramComment.size();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("comment media size : ");
        ((StringBuilder)localObject).append(j);
        QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject).toString());
        paramBaseCommentData.mediaDataList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          localObject = (oidb_cmd0xc46.MediaData)paramComment.get(i);
          BaseCommentData.MediaData localMediaData = new BaseCommentData.MediaData();
          localMediaData.a = ((oidb_cmd0xc46.MediaData)localObject).text.get();
          localMediaData.i = ((oidb_cmd0xc46.MediaData)localObject).media_type.get();
          localMediaData.c = ((oidb_cmd0xc46.MediaData)localObject).pic_width.get();
          localMediaData.d = ((oidb_cmd0xc46.MediaData)localObject).pic_length.get();
          localMediaData.b = ((oidb_cmd0xc46.MediaData)localObject).pic_url.get();
          localMediaData.j = ((oidb_cmd0xc46.MediaData)localObject).thumbnail_url.get();
          localMediaData.g = ((oidb_cmd0xc46.MediaData)localObject).video_url.get();
          localMediaData.h = ((oidb_cmd0xc46.MediaData)localObject).video_duration.get();
          localMediaData.e = ((oidb_cmd0xc46.MediaData)localObject).sound_url.get();
          localMediaData.f = ((oidb_cmd0xc46.MediaData)localObject).sound_duration.get();
          paramBaseCommentData.mediaDataList.add(localMediaData);
          i += 1;
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xc46.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleFamilyCommentList | retCode ");
    paramFromServiceMsg.append(i);
    QLog.d("ReadInJoyCommentPBModule", 1, paramFromServiceMsg.toString());
    paramFromServiceMsg = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    paramObject = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    if (i == 0)
    {
      Object localObject2;
      if (((oidb_cmd0xc46.RspBody)localObject1).next.has())
      {
        boolean bool;
        if (((oidb_cmd0xc46.RspBody)localObject1).next.get() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramFromServiceMsg.d = bool;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleFamilyCommentList | hasNextPage ");
        ((StringBuilder)localObject2).append(((oidb_cmd0xc46.RspBody)localObject1).next.get());
        QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject2).toString());
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).page_cookie.has()) {
        paramFromServiceMsg.e = ((oidb_cmd0xc46.RspBody)localObject1).page_cookie.get().toStringUtf8();
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).comment_list.has()) {
        paramFromServiceMsg.a = a(((oidb_cmd0xc46.RspBody)localObject1).comment_list.get());
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).article_info.has())
      {
        localObject2 = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject1).article_info.get();
        if (((oidb_cmd0xc46.ArticleInfo)localObject2).comment_count.has()) {
          paramObject.a = ((oidb_cmd0xc46.ArticleInfo)localObject2).comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") != null) && (((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.has()))
        {
          if (((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get() == 0) {
            this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.3(this));
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("has_anchor: ");
          paramToServiceMsg.append(((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get());
          QLog.d("ReadInJoyCommentPBModule", 1, paramToServiceMsg.toString());
        }
        else
        {
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
        }
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).banner.has())
      {
        localObject1 = (oidb_cmd0xc46.Banner)((oidb_cmd0xc46.RspBody)localObject1).banner.get();
        paramToServiceMsg = new CommentData();
        paramToServiceMsg.commentId = String.valueOf(((oidb_cmd0xc46.Banner)localObject1).config_id.get());
        paramToServiceMsg.commentContent = ((oidb_cmd0xc46.Banner)localObject1).title.get();
        paramToServiceMsg.activityJumpUrl = ((oidb_cmd0xc46.Banner)localObject1).jump_url.get();
        paramToServiceMsg.isBanner = true;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("family comment banner configid ：");
        ((StringBuilder)localObject1).append(paramToServiceMsg.commentId);
        ((StringBuilder)localObject1).append("; title :");
        ((StringBuilder)localObject1).append(paramToServiceMsg.commentContent);
        ((StringBuilder)localObject1).append("; url");
        ((StringBuilder)localObject1).append(paramToServiceMsg.activityPicUrl);
        QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject1).toString());
        break label510;
      }
    }
    paramToServiceMsg = null;
    label510:
    this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.4(this, i, paramFromServiceMsg, paramObject, paramToServiceMsg));
  }
  
  @Nullable
  private static BaseCommentData.CommentRptData c(oidb_cmd0xc46.RptData paramRptData)
  {
    if (paramRptData.herf_data.has())
    {
      paramRptData = (oidb_cmd0xc46.HerfData)paramRptData.herf_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.a = 2;
        localCommentRptData.b = RIJPBFieldUtils.a(paramRptData.content, "");
        localCommentRptData.d = RIJPBFieldUtils.a(paramRptData.url, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  private static void c(@NotNull BaseCommentData paramBaseCommentData, @NotNull oidb_cmd0xc46.Comment paramComment)
  {
    if (c(paramComment))
    {
      paramBaseCommentData.isAd = true;
      paramComment = RIJCommentAdUtils.a(paramComment.ad_rsp_info.data.get().toByteArray());
      if (!paramComment.isEmpty())
      {
        paramComment = (AdvertisementInfo)paramComment.get(0);
        paramBaseCommentData.advertisementInfo = paramComment;
        if ((paramComment != null) && (paramComment.mCommentAdParams != null))
        {
          paramBaseCommentData = paramComment.mCommentAdParams;
          if (paramBaseCommentData.f > 0) {
            RIJCommentAdUtils.b = paramBaseCommentData.f;
          }
          if (paramBaseCommentData.e > 0) {
            RIJCommentAdUtils.a = paramBaseCommentData.e;
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xc46.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleNewCommentList | retCode ");
    paramFromServiceMsg.append(i);
    QLog.d("ReadInJoyCommentPBModule", 1, paramFromServiceMsg.toString());
    paramFromServiceMsg = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    paramObject = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    if (i == 0)
    {
      Object localObject2;
      if (((oidb_cmd0xc46.RspBody)localObject1).next.has())
      {
        boolean bool;
        if (((oidb_cmd0xc46.RspBody)localObject1).next.get() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramFromServiceMsg.d = bool;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleNewCommentList | hasNextPage ");
        ((StringBuilder)localObject2).append(((oidb_cmd0xc46.RspBody)localObject1).next.get());
        QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject2).toString());
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).page_cookie.has()) {
        paramFromServiceMsg.e = ((oidb_cmd0xc46.RspBody)localObject1).page_cookie.get().toStringUtf8();
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).comment_list.has()) {
        paramFromServiceMsg.a = a(((oidb_cmd0xc46.RspBody)localObject1).comment_list.get());
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).article_info.has())
      {
        localObject2 = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject1).article_info.get();
        if (((oidb_cmd0xc46.ArticleInfo)localObject2).comment_count.has()) {
          paramObject.a = ((oidb_cmd0xc46.ArticleInfo)localObject2).comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") != null) && (((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.has()))
        {
          if (((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get() == 0) {
            this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.5(this));
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("has_anchor: ");
          paramToServiceMsg.append(((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get());
          QLog.d("ReadInJoyCommentPBModule", 1, paramToServiceMsg.toString());
        }
        else
        {
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
        }
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).banner.has())
      {
        localObject1 = (oidb_cmd0xc46.Banner)((oidb_cmd0xc46.RspBody)localObject1).banner.get();
        paramToServiceMsg = new CommentData();
        paramToServiceMsg.commentId = String.valueOf(((oidb_cmd0xc46.Banner)localObject1).config_id.get());
        paramToServiceMsg.commentContent = ((oidb_cmd0xc46.Banner)localObject1).title.get();
        paramToServiceMsg.activityJumpUrl = ((oidb_cmd0xc46.Banner)localObject1).jump_url.get();
        paramToServiceMsg.isBanner = true;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("new comment banner configid ：");
        ((StringBuilder)localObject1).append(paramToServiceMsg.commentId);
        ((StringBuilder)localObject1).append("; title :");
        ((StringBuilder)localObject1).append(paramToServiceMsg.commentContent);
        ((StringBuilder)localObject1).append("; url");
        ((StringBuilder)localObject1).append(paramToServiceMsg.activityPicUrl);
        QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject1).toString());
        break label510;
      }
    }
    paramToServiceMsg = null;
    label510:
    this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.6(this, i, paramFromServiceMsg, paramObject, paramToServiceMsg));
  }
  
  private static boolean c(oidb_cmd0xc46.Comment paramComment)
  {
    PBUInt32Field localPBUInt32Field = paramComment.is_ad;
    boolean bool2 = false;
    int i;
    if (RIJPBFieldUtils.a(localPBUInt32Field, 0) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (paramComment.ad_rsp_info.has())
      {
        bool1 = bool2;
        if (paramComment.ad_rsp_info.data.has()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  private static BaseCommentData.CommentRptData d(oidb_cmd0xc46.RptData paramRptData)
  {
    if (paramRptData.at_data.has())
    {
      paramRptData = (oidb_cmd0xc46.AtData)paramRptData.at_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.a = 1;
        localCommentRptData.b = RIJPBFieldUtils.a(paramRptData.content, "");
        localCommentRptData.c = RIJPBFieldUtils.a(paramRptData.uid, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xc46.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleHotCommentList | retCode ");
    paramFromServiceMsg.append(i);
    QLog.d("ReadInJoyCommentPBModule", 1, paramFromServiceMsg.toString());
    paramFromServiceMsg = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    paramObject = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    if (i == 0)
    {
      Object localObject2;
      if (((oidb_cmd0xc46.RspBody)localObject1).next.has())
      {
        boolean bool;
        if (((oidb_cmd0xc46.RspBody)localObject1).next.get() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramFromServiceMsg.d = bool;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleHotCommentList | hasNextPage ");
        ((StringBuilder)localObject2).append(((oidb_cmd0xc46.RspBody)localObject1).next.get());
        QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject2).toString());
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).page_cookie.has()) {
        paramFromServiceMsg.e = ((oidb_cmd0xc46.RspBody)localObject1).page_cookie.get().toStringUtf8();
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).hot_comment_list.has()) {
        paramFromServiceMsg.a = a(((oidb_cmd0xc46.RspBody)localObject1).hot_comment_list.get());
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).article_info.has())
      {
        localObject2 = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject1).article_info.get();
        if (((oidb_cmd0xc46.ArticleInfo)localObject2).comment_count.has()) {
          paramObject.a = ((oidb_cmd0xc46.ArticleInfo)localObject2).comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") != null) && (((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.has()))
        {
          if (((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get() == 0) {
            this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.7(this));
          }
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("has_anchor: ");
          paramToServiceMsg.append(((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get());
          QLog.d("ReadInJoyCommentPBModule", 1, paramToServiceMsg.toString());
        }
        else
        {
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
        }
      }
      if (((oidb_cmd0xc46.RspBody)localObject1).banner.has())
      {
        localObject1 = (oidb_cmd0xc46.Banner)((oidb_cmd0xc46.RspBody)localObject1).banner.get();
        paramToServiceMsg = new CommentData();
        paramToServiceMsg.commentId = String.valueOf(((oidb_cmd0xc46.Banner)localObject1).config_id.get());
        paramToServiceMsg.commentContent = ((oidb_cmd0xc46.Banner)localObject1).title.get();
        paramToServiceMsg.activityJumpUrl = ((oidb_cmd0xc46.Banner)localObject1).jump_url.get();
        paramToServiceMsg.isBanner = true;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("hot comment banner configid ：");
        ((StringBuilder)localObject1).append(paramToServiceMsg.commentId);
        ((StringBuilder)localObject1).append("; title :");
        ((StringBuilder)localObject1).append(paramToServiceMsg.commentContent);
        ((StringBuilder)localObject1).append("; url");
        ((StringBuilder)localObject1).append(paramToServiceMsg.activityPicUrl);
        QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject1).toString());
        break label510;
      }
    }
    paramToServiceMsg = null;
    label510:
    this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.8(this, i, paramFromServiceMsg, paramObject, paramToServiceMsg));
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xc46.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handleSubCommentList | retCode ");
    paramFromServiceMsg.append(i);
    QLog.d("ReadInJoyCommentPBModule", 1, paramFromServiceMsg.toString());
    paramFromServiceMsg = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    paramObject = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    if (i == 0)
    {
      StringBuilder localStringBuilder;
      if (((oidb_cmd0xc46.RspBody)localObject).next.has())
      {
        boolean bool;
        if (((oidb_cmd0xc46.RspBody)localObject).next.get() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramFromServiceMsg.d = bool;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleSubCommentList | hasNextPage ");
        localStringBuilder.append(((oidb_cmd0xc46.RspBody)localObject).next.get());
        QLog.d("ReadInJoyCommentPBModule", 1, localStringBuilder.toString());
      }
      if (((oidb_cmd0xc46.RspBody)localObject).page_cookie.has()) {
        paramFromServiceMsg.e = ((oidb_cmd0xc46.RspBody)localObject).page_cookie.get().toStringUtf8();
      }
      if (((oidb_cmd0xc46.RspBody)localObject).comment_list.has()) {
        paramFromServiceMsg.b = b(((oidb_cmd0xc46.RspBody)localObject).comment_list.get());
      } else {
        paramFromServiceMsg.b = new ArrayList();
      }
      if (((oidb_cmd0xc46.RspBody)localObject).first_comment_detail.has()) {
        paramFromServiceMsg.c = a((oidb_cmd0xc46.Comment)((oidb_cmd0xc46.RspBody)localObject).first_comment_detail.get());
      }
      if (((oidb_cmd0xc46.RspBody)localObject).article_info.has())
      {
        localObject = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject).article_info.get();
        if ((paramToServiceMsg.getAttribute("anchor_request") != null) && (((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.has()))
        {
          if (((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.get() == 0) {
            this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.9(this));
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("has_anchor: ");
          localStringBuilder.append(((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.get());
          QLog.d("ReadInJoyCommentPBModule", 1, localStringBuilder.toString());
        }
        else
        {
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
        }
      }
    }
    else
    {
      paramFromServiceMsg.b = new ArrayList();
      this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.10(this, i));
    }
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("parent_comment_id");
    this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.11(this, i, paramFromServiceMsg, paramToServiceMsg, paramObject));
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xc46.RspBody());
    int k = ((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue();
    long l;
    if (paramToServiceMsg.extraData != null) {
      l = System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey");
    } else {
      l = 0L;
    }
    paramFromServiceMsg = RIJPerformanceReporter.a();
    int i;
    if (k == 4) {
      i = 1;
    } else {
      i = 0;
    }
    paramFromServiceMsg.a(i, j, l);
    ReadinjoyReportUtils.a(j, paramToServiceMsg, 5, null);
    if (ReadInJoyUtils.b() == null) {
      return;
    }
    paramFromServiceMsg = new HashMap();
    paramFromServiceMsg.put("retCode", String.valueOf(j));
    paramFromServiceMsg.put("request_comment_type", String.valueOf(k));
    paramObject = StatisticCollector.getInstance(ReadInJoyUtils.b().getApplication());
    boolean bool;
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramObject.collectPerformance(null, "actKandian0xc46Result", bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), 0L, paramFromServiceMsg, null);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("report0xc46Result | actKandian0xc46Result | retCode ： ");
    paramToServiceMsg.append(j);
    paramToServiceMsg.append("| request_comment_type : ");
    paramToServiceMsg.append(k);
    QLog.d("ReadInJoyCommentPBModule", 1, paramToServiceMsg.toString());
  }
  
  private void f(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    paramBaseCommentData.commentLinkDataList = new ArrayList();
    if (paramComment.link_data.has())
    {
      paramBaseCommentData.commentLinkDataList = new ArrayList();
      paramComment = paramComment.link_data.get();
      if (paramComment != null)
      {
        paramComment = paramComment.iterator();
        while (paramComment.hasNext())
        {
          oidb_cmd0xc46.LinkData localLinkData = (oidb_cmd0xc46.LinkData)paramComment.next();
          if (localLinkData != null)
          {
            BaseCommentData.CommentLinkData localCommentLinkData = new BaseCommentData.CommentLinkData();
            localCommentLinkData.iconUrl = RIJPBFieldUtils.a(localLinkData.icon, "");
            localCommentLinkData.linkUrl = RIJPBFieldUtils.a(localLinkData.url, "");
            localCommentLinkData.type = RIJPBFieldUtils.a(localLinkData.type, 0);
            localCommentLinkData.wording = RIJPBFieldUtils.a(localLinkData.wording, "");
            paramBaseCommentData.commentLinkDataList.add(localCommentLinkData);
          }
        }
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xc46.RspBody());
    if (i != 0)
    {
      paramObject = new StringBuilder();
      paramObject.append("errorCode:");
      paramObject.append(i);
      paramObject.append(" reqCommentType:");
      paramObject.append(paramToServiceMsg.getAttributes().get("service_type"));
      paramObject.append(" errorMsg:");
      paramObject.append(paramFromServiceMsg.getBusinessFailMsg());
      RIJCommentAegisHelper.a(paramObject.toString(), "ReadInJoyCommentPBModule");
    }
  }
  
  private static void g(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if (!paramComment.rpt_data.has()) {
      return;
    }
    paramBaseCommentData.commentRptDataList = new ArrayList();
    paramComment = paramComment.rpt_data.get();
    if (paramComment == null) {
      return;
    }
    paramComment = paramComment.iterator();
    while (paramComment.hasNext())
    {
      oidb_cmd0xc46.RptData localRptData = (oidb_cmd0xc46.RptData)paramComment.next();
      if (localRptData != null) {
        a(localRptData, paramBaseCommentData);
      }
    }
  }
  
  @VisibleForTesting
  SubCommentData.RepliedCommentData a(oidb_cmd0xc46.RepliedCommentInfo paramRepliedCommentInfo)
  {
    SubCommentData.RepliedCommentData localRepliedCommentData = new SubCommentData.RepliedCommentData();
    if (paramRepliedCommentInfo.replied_user_id.has()) {
      localRepliedCommentData.f = paramRepliedCommentInfo.replied_user_id.get();
    }
    if (paramRepliedCommentInfo.replied_user_nick_name.has()) {
      localRepliedCommentData.e = paramRepliedCommentInfo.replied_user_nick_name.get();
    }
    if (paramRepliedCommentInfo.replied_comment_content.has()) {
      localRepliedCommentData.b = paramRepliedCommentInfo.replied_comment_content.get();
    }
    if (paramRepliedCommentInfo.replied_comment_is_delete.has()) {
      localRepliedCommentData.c = paramRepliedCommentInfo.replied_comment_is_delete.get();
    }
    if (paramRepliedCommentInfo.replied_user_homepage.has()) {
      localRepliedCommentData.d = paramRepliedCommentInfo.replied_user_homepage.get();
    }
    if (paramRepliedCommentInfo.replied_comment_id.has()) {
      localRepliedCommentData.a = paramRepliedCommentInfo.replied_comment_id.get();
    }
    return localRepliedCommentData;
  }
  
  public void a(ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    this.a = paramReadInJoyCommentObserver;
    paramReadInJoyCommentObserver = new StringBuilder();
    paramReadInJoyCommentObserver.append("setCommentObserver: mCommentObserver=");
    paramReadInJoyCommentObserver.append(this.a);
    QLog.d("ReadInJoyCommentPBModule", 1, paramReadInJoyCommentObserver.toString());
  }
  
  public void a(RIJRequestDataForComment paramRIJRequestDataForComment)
  {
    if (TextUtils.isEmpty(paramRIJRequestDataForComment.a))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestCommonCommentList | articleId is null");
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("requestCommonCommentList | articleId : ");
    ((StringBuilder)localObject1).append(paramRIJRequestDataForComment.a);
    ((StringBuilder)localObject1).append(" contentSrc : ");
    ((StringBuilder)localObject1).append(paramRIJRequestDataForComment.d);
    ((StringBuilder)localObject1).append("; mainCommentId : ");
    ((StringBuilder)localObject1).append(paramRIJRequestDataForComment.e);
    ((StringBuilder)localObject1).append(" ; pageCookie : ");
    ((StringBuilder)localObject1).append(paramRIJRequestDataForComment.b);
    ((StringBuilder)localObject1).append("; commonCommentData ");
    ((StringBuilder)localObject1).append(paramRIJRequestDataForComment.f);
    QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new oidb_cmd0xc46.ReqBody();
    Object localObject2 = new oidb_cmd0xc46.ReqParam();
    ((oidb_cmd0xc46.ReqParam)localObject2).with_style_data.set(1);
    ((oidb_cmd0xc46.ReqParam)localObject2).with_sub_comments.set(1);
    ((oidb_cmd0xc46.ReqParam)localObject2).with_author_reply.set(1);
    ((oidb_cmd0xc46.ReqParam)localObject2).req_advertise_para.set(RIJCommentAdUtils.a(a(paramRIJRequestDataForComment, 1)));
    ((oidb_cmd0xc46.ReqBody)localObject1).req_param.set((MessageMicro)localObject2);
    ((oidb_cmd0xc46.ReqBody)localObject1).rowkey.set(paramRIJRequestDataForComment.a);
    ((oidb_cmd0xc46.ReqBody)localObject1).page_cookie.set(ByteStringMicro.copyFromUtf8(paramRIJRequestDataForComment.b));
    ((oidb_cmd0xc46.ReqBody)localObject1).page_size.set(paramRIJRequestDataForComment.c);
    ((oidb_cmd0xc46.ReqBody)localObject1).content_src.set(ReadInJoyCommentHelper.a(paramRIJRequestDataForComment.d));
    ((oidb_cmd0xc46.ReqBody)localObject1).with_activity_data.set(1);
    a((oidb_cmd0xc46.ReqBody)localObject1, paramRIJRequestDataForComment.f);
    int i = 0;
    if (!TextUtils.isEmpty(paramRIJRequestDataForComment.e))
    {
      ((oidb_cmd0xc46.ReqBody)localObject1).anchor_id.set(paramRIJRequestDataForComment.e);
      i = 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("requestCommonCommentList | articleId : ");
    ((StringBuilder)localObject2).append(paramRIJRequestDataForComment.a);
    ((StringBuilder)localObject2).append(" contentSrc : ");
    ((StringBuilder)localObject2).append(paramRIJRequestDataForComment.d);
    ((StringBuilder)localObject2).append("; mainCommentId : ");
    ((StringBuilder)localObject2).append(paramRIJRequestDataForComment.e);
    ((StringBuilder)localObject2).append(" ; pageCookie : ");
    ((StringBuilder)localObject2).append(paramRIJRequestDataForComment.b);
    QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject2).toString());
    paramRIJRequestDataForComment = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 5, ((oidb_cmd0xc46.ReqBody)localObject1).toByteArray());
    paramRIJRequestDataForComment.addAttribute("service_type", Integer.valueOf(5));
    if (i != 0) {
      paramRIJRequestDataForComment.addAttribute("anchor_request", Integer.valueOf(1));
    }
    sendPbReq(paramRIJRequestDataForComment);
  }
  
  @VisibleForTesting
  void a(BaseCommentData paramBaseCommentData, oidb_cmd0xc46.Comment paramComment)
  {
    paramComment = paramComment.is_show_follow_button;
    boolean bool = true;
    paramBaseCommentData.shouldShowFollowButton = a(paramComment, 1);
    if ((!paramBaseCommentData.shouldShowFollowButton) || (paramBaseCommentData.isFollowing)) {
      bool = false;
    }
    paramBaseCommentData.isFollowButtonShown = bool;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 != null) && (paramString4 != null) && (paramString3 != null))
    {
      if (paramString2 == null) {
        return;
      }
      oidb_cmd0xdc8.ReqBody localReqBody = new oidb_cmd0xdc8.ReqBody();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start request 0xdc8  rowKey :");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" parentCommentId :");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" subCommentId : ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" commentId :");
      localStringBuilder.append(paramString4);
      QLog.d("ReadInJoyCommentPBModule", 1, localStringBuilder.toString());
      localReqBody.str_rowkey.set(paramString1);
      localReqBody.str_first_comment_id.set(paramString2);
      localReqBody.str_sub_comment_id.set(paramString3);
      localReqBody.str_comment_id.set(paramString4);
      localReqBody.int32_flag.set(1);
      paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xdc8", 3528, 1, localReqBody.toByteArray());
      if (paramString1 != null)
      {
        sendPbReq(paramString1);
        paramString2 = new StringBuilder();
        paramString2.append("0xdc8 request :");
        paramString2.append(paramString1.toString());
        QLog.d("ReadInJoyCommentPBModule", 1, paramString2.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestSubCommentList | articleId is null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestSubCommentList | subPageCookie : ");
    ((StringBuilder)localObject).append(paramString4);
    QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xc46.ReqBody();
    ((oidb_cmd0xc46.ReqBody)localObject).rowkey.set(paramString1);
    ((oidb_cmd0xc46.ReqBody)localObject).comment_id.set(paramString2);
    ((oidb_cmd0xc46.ReqBody)localObject).page_cookie.set(ByteStringMicro.copyFromUtf8(paramString4));
    ((oidb_cmd0xc46.ReqBody)localObject).page_size.set(paramInt1);
    ((oidb_cmd0xc46.ReqBody)localObject).content_src.set(ReadInJoyCommentHelper.a(paramInt2));
    ((oidb_cmd0xc46.ReqBody)localObject).with_activity_data.set(1);
    a((oidb_cmd0xc46.ReqBody)localObject, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      ((oidb_cmd0xc46.ReqBody)localObject).with_first_comment_detail.set(1);
      ((oidb_cmd0xc46.ReqBody)localObject).anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 4, ((oidb_cmd0xc46.ReqBody)localObject).toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(4));
    paramString1.addAttribute("parent_comment_id", paramString2);
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    sendPbReq(paramString1);
  }
  
  public void a(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if (paramComment != null)
    {
      if (paramBaseCommentData == null) {
        return;
      }
      paramBaseCommentData.commentId = RIJPBFieldUtils.a(paramComment.comment_id, "");
      paramBaseCommentData.uin = RIJPBFieldUtils.a(paramComment.author_id, "");
      paramBaseCommentData.commentTime = RIJPBFieldUtils.a(paramComment.create_time);
      paramBaseCommentData.commentContent = RIJPBFieldUtils.a(paramComment.content, "");
      g(paramComment, paramBaseCommentData);
      paramBaseCommentData.likeCnt = RIJPBFieldUtils.a(paramComment.like_num, 0);
      paramBaseCommentData.like = RIJPBFieldUtils.a(paramComment.like, 0);
      paramBaseCommentData.disLike = RIJPBFieldUtils.a(paramComment.dislike, 0);
      paramBaseCommentData.anonymous = RIJPBFieldUtils.a(paramComment.anonymous, 0);
      paramBaseCommentData.authorSelection = RIJPBFieldUtils.a(paramComment.author_selection, 0);
      paramBaseCommentData.rank = RIJPBFieldUtils.a(paramComment.rank, 0);
      paramBaseCommentData.level = RIJPBFieldUtils.a(paramComment.level);
      paramBaseCommentData.authorComment = RIJPBFieldUtils.a(paramComment.author_comment, "");
      paramBaseCommentData.nickName = RIJPBFieldUtils.a(paramComment.nick_name, "");
      paramBaseCommentData.isAuthorLike = a(paramComment.author_like, 1);
      paramBaseCommentData.isFollowing = a(paramComment.follow_status, 1);
      paramBaseCommentData.avatar = RIJPBFieldUtils.a(paramComment.avatar, "");
      a(paramBaseCommentData.avatar);
      paramBaseCommentData.myself = RIJPBFieldUtils.a(paramComment.myself, 0);
      paramBaseCommentData.homepage = RIJPBFieldUtils.a(paramComment.homepage, "");
      paramBaseCommentData.awesome = RIJPBFieldUtils.a(paramComment.awesome);
      paramBaseCommentData.rowKey = RIJPBFieldUtils.a(paramComment.rowkey, "");
      paramBaseCommentData.contentSrc = RIJPBFieldUtils.a(paramComment.content_source, 0);
      paramBaseCommentData.passthrough = RIJPBFieldUtils.a(paramComment.passthrough, "");
      paramBaseCommentData.isActivity = RIJPBFieldUtils.a(paramComment.is_activity);
      paramBaseCommentData.activityPicUrl = RIJPBFieldUtils.a(paramComment.pic_url, "");
      paramBaseCommentData.activityJumpUrl = RIJPBFieldUtils.a(paramComment.jump_url, "");
      paramBaseCommentData.isStar = RIJPBFieldUtils.a(paramComment.is_star);
      paramBaseCommentData.isApproved = RIJPBFieldUtils.a(paramComment.is_approved);
      d(paramComment, paramBaseCommentData);
      c(paramComment, paramBaseCommentData);
      paramBaseCommentData.createSrc = RIJPBFieldUtils.a(paramComment.create_source, 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create_source : ");
      localStringBuilder.append(paramComment.create_source.get());
      QLog.d("ReadInJoyCommentPBModule", 1, localStringBuilder.toString());
      paramBaseCommentData.isAuthorReply = RIJPBFieldUtils.a(paramComment.is_author_reply);
      paramBaseCommentData.userTitle = RIJPBFieldUtils.a(paramComment.user_title, "");
      paramBaseCommentData.ksHomePage = RIJPBFieldUtils.a(paramComment.ks_homepage, "");
      b(paramComment, paramBaseCommentData);
      e(paramComment, paramBaseCommentData);
      b(paramBaseCommentData, paramComment);
      c(paramBaseCommentData, paramComment);
      paramBaseCommentData.styleData = RIJPBFieldUtils.a(paramComment.style_data, "");
      paramBaseCommentData.isAuthorSticky = a(paramComment.comment_author_top, 1);
      paramBaseCommentData.isAuthorBottom = a(paramComment.comment_author_top, 3);
      paramBaseCommentData.avatarPendantUrl = RIJPBFieldUtils.a(paramComment.avatar_pendant, "");
      f(paramComment, paramBaseCommentData);
      paramBaseCommentData.shareUrl = paramComment.share_url.get();
      paramBaseCommentData.commentApp = RIJPBFieldUtils.a(paramComment.comment_app, 0);
      a(paramBaseCommentData, paramComment);
      if (QLog.isColorLevel())
      {
        paramComment = new StringBuilder();
        paramComment.append("[convertBaseCommentData] uin = ");
        paramComment.append(paramBaseCommentData.uin);
        paramComment.append(", avatarPendantUrl = ");
        paramComment.append(paramBaseCommentData.avatarPendantUrl);
        QLog.i("ReadInJoyCommentPBModule", 1, paramComment.toString());
      }
      paramComment = new StringBuilder();
      paramComment.append("comment style_data ");
      paramComment.append(paramBaseCommentData.styleData);
      QLog.d("ReadInJoyCommentPBModule", 1, paramComment.toString());
      paramComment = new StringBuilder();
      paramComment.append("convertBaseCommentData | ");
      paramComment.append(paramBaseCommentData.toString());
      QLog.d("ReadInJoyCommentPBModule", 2, paramComment.toString());
    }
  }
  
  @VisibleForTesting
  boolean a(PBUInt32Field paramPBUInt32Field, int paramInt)
  {
    return RIJPBFieldUtils.a(paramPBUInt32Field) == paramInt;
  }
  
  public void b(RIJRequestDataForComment paramRIJRequestDataForComment)
  {
    if (TextUtils.isEmpty(paramRIJRequestDataForComment.a))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestFamliyCommentList | articleId is null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestFamliyCommentList | articleId : ");
    ((StringBuilder)localObject).append(paramRIJRequestDataForComment.a);
    ((StringBuilder)localObject).append(" contentSrc : ");
    ((StringBuilder)localObject).append(paramRIJRequestDataForComment.d);
    ((StringBuilder)localObject).append(" ; pageCookie : ");
    ((StringBuilder)localObject).append(paramRIJRequestDataForComment.b);
    QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xc46.ReqBody();
    oidb_cmd0xc46.ReqParam localReqParam = new oidb_cmd0xc46.ReqParam();
    localReqParam.with_sub_comments.set(1);
    localReqParam.with_author_reply.set(1);
    localReqParam.with_style_data.set(1);
    ((oidb_cmd0xc46.ReqBody)localObject).req_param.set(localReqParam);
    ((oidb_cmd0xc46.ReqBody)localObject).rowkey.set(paramRIJRequestDataForComment.a);
    ((oidb_cmd0xc46.ReqBody)localObject).page_cookie.set(ByteStringMicro.copyFromUtf8(paramRIJRequestDataForComment.b));
    ((oidb_cmd0xc46.ReqBody)localObject).page_size.set(paramRIJRequestDataForComment.c);
    ((oidb_cmd0xc46.ReqBody)localObject).content_src.set(ReadInJoyCommentHelper.a(paramRIJRequestDataForComment.d));
    ((oidb_cmd0xc46.ReqBody)localObject).with_activity_data.set(1);
    a((oidb_cmd0xc46.ReqBody)localObject, paramRIJRequestDataForComment.f);
    paramRIJRequestDataForComment = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 6, ((oidb_cmd0xc46.ReqBody)localObject).toByteArray());
    paramRIJRequestDataForComment.addAttribute("service_type", Integer.valueOf(6));
    sendPbReq(paramRIJRequestDataForComment);
  }
  
  @VisibleForTesting
  void b(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if (paramComment.activity.has()) {
      paramBaseCommentData.activityCfgID = RIJPBFieldUtils.a(paramComment.activity.config_id);
    }
  }
  
  public void c(RIJRequestDataForComment paramRIJRequestDataForComment)
  {
    if (TextUtils.isEmpty(paramRIJRequestDataForComment.a))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestNewCommentList | articleId is null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestNewCommentList | newCookie : ");
    ((StringBuilder)localObject).append(paramRIJRequestDataForComment.b);
    QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xc46.ReqBody();
    ((oidb_cmd0xc46.ReqBody)localObject).rowkey.set(paramRIJRequestDataForComment.a);
    ((oidb_cmd0xc46.ReqBody)localObject).page_cookie.set(ByteStringMicro.copyFromUtf8(paramRIJRequestDataForComment.b));
    ((oidb_cmd0xc46.ReqBody)localObject).page_size.set(paramRIJRequestDataForComment.c);
    ((oidb_cmd0xc46.ReqBody)localObject).content_src.set(ReadInJoyCommentHelper.a(paramRIJRequestDataForComment.d));
    ((oidb_cmd0xc46.ReqBody)localObject).with_activity_data.set(1);
    oidb_cmd0xc46.ReqParam localReqParam = new oidb_cmd0xc46.ReqParam();
    localReqParam.with_sub_comments.set(1);
    localReqParam.with_author_reply.set(1);
    localReqParam.with_style_data.set(1);
    localReqParam.req_advertise_para.set(RIJCommentAdUtils.a(a(paramRIJRequestDataForComment, 2)));
    ((oidb_cmd0xc46.ReqBody)localObject).req_param.set(localReqParam);
    a((oidb_cmd0xc46.ReqBody)localObject, paramRIJRequestDataForComment.f);
    int i = 0;
    if (!TextUtils.isEmpty(paramRIJRequestDataForComment.e))
    {
      ((oidb_cmd0xc46.ReqBody)localObject).anchor_id.set(paramRIJRequestDataForComment.e);
      i = 1;
    }
    paramRIJRequestDataForComment = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 2, ((oidb_cmd0xc46.ReqBody)localObject).toByteArray());
    paramRIJRequestDataForComment.addAttribute("service_type", Integer.valueOf(2));
    if (i != 0) {
      paramRIJRequestDataForComment.addAttribute("anchor_request", Integer.valueOf(1));
    }
    sendPbReq(paramRIJRequestDataForComment);
  }
  
  @VisibleForTesting
  void c(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if (paramComment.user_identity_icon.has())
    {
      paramBaseCommentData.userIdentityIcon = new BaseCommentData.UserIdentityIcon();
      paramBaseCommentData.userIdentityIcon.a = RIJPBFieldUtils.a(paramComment.user_identity_icon.identity_type);
      paramBaseCommentData.userIdentityIcon.b = RIJPBFieldUtils.a(paramComment.user_identity_icon.icon_url, "");
      paramBaseCommentData.userIdentityIcon.c = RIJPBFieldUtils.a(paramComment.user_identity_icon.summary, "");
    }
  }
  
  public void d(RIJRequestDataForComment paramRIJRequestDataForComment)
  {
    if (TextUtils.isEmpty(paramRIJRequestDataForComment.a))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestHotCommentList | articleId is null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestHotCommentList | hotPageCookie : ");
    ((StringBuilder)localObject).append(paramRIJRequestDataForComment.b);
    QLog.d("ReadInJoyCommentPBModule", 1, ((StringBuilder)localObject).toString());
    localObject = new oidb_cmd0xc46.ReqBody();
    ((oidb_cmd0xc46.ReqBody)localObject).rowkey.set(paramRIJRequestDataForComment.a);
    ((oidb_cmd0xc46.ReqBody)localObject).page_cookie.set(ByteStringMicro.copyFromUtf8(paramRIJRequestDataForComment.b));
    ((oidb_cmd0xc46.ReqBody)localObject).page_size.set(paramRIJRequestDataForComment.c);
    ((oidb_cmd0xc46.ReqBody)localObject).content_src.set(ReadInJoyCommentHelper.a(paramRIJRequestDataForComment.d));
    ((oidb_cmd0xc46.ReqBody)localObject).with_activity_data.set(1);
    oidb_cmd0xc46.ReqParam localReqParam = new oidb_cmd0xc46.ReqParam();
    localReqParam.with_sub_comments.set(1);
    localReqParam.with_author_reply.set(1);
    localReqParam.with_style_data.set(1);
    localReqParam.req_advertise_para.set(RIJCommentAdUtils.a(a(paramRIJRequestDataForComment, 3)));
    ((oidb_cmd0xc46.ReqBody)localObject).req_param.set(localReqParam);
    a((oidb_cmd0xc46.ReqBody)localObject, paramRIJRequestDataForComment.f);
    int i = 0;
    if (!TextUtils.isEmpty(paramRIJRequestDataForComment.e))
    {
      ((oidb_cmd0xc46.ReqBody)localObject).anchor_id.set(paramRIJRequestDataForComment.e);
      i = 1;
    }
    paramRIJRequestDataForComment = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 3, ((oidb_cmd0xc46.ReqBody)localObject).toByteArray());
    paramRIJRequestDataForComment.addAttribute("service_type", Integer.valueOf(3));
    if (i != 0) {
      paramRIJRequestDataForComment.addAttribute("anchor_request", Integer.valueOf(1));
    }
    sendPbReq(paramRIJRequestDataForComment);
  }
  
  @VisibleForTesting
  void d(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if (paramComment.account_level_info.has())
    {
      paramBaseCommentData.accountLevelInfo = new BaseCommentData.AccountLevelInfo();
      paramBaseCommentData.accountLevelInfo.a = RIJPBFieldUtils.a(paramComment.account_level_info.uint32_account_cc_level);
      paramBaseCommentData.accountLevelInfo.b = RIJPBFieldUtils.a(paramComment.account_level_info.account_cc_level_icon_s, "");
    }
    if (paramComment.activity_level.has()) {
      paramBaseCommentData.activityLevel = ((oidb_cmd0xc46.ActivityLevel)paramComment.activity_level.get());
    }
  }
  
  @VisibleForTesting
  void e(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if (paramComment.jump_schema.has()) {}
    try
    {
      paramBaseCommentData.flowGuidePtsData = new String(Base64Util.decode(paramComment.jump_schema.get(), 0), "utf-8");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("flowGuidePtsData : ");
      localStringBuilder.append(paramBaseCommentData.flowGuidePtsData);
      QLog.d("ReadInJoyCommentPBModule", 1, localStringBuilder.toString());
      return;
    }
    catch (Exception paramBaseCommentData)
    {
      label71:
      break label71;
    }
    paramBaseCommentData = new StringBuilder();
    paramBaseCommentData.append("parseJumpSchema() parse with Exception");
    paramBaseCommentData.append(paramComment.jump_schema.get());
    QLog.d("ReadInJoyCommentPBModule", 1, paramBaseCommentData.toString());
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc46"))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 1) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 4) {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 3) {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 2) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 5) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 6) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdc8"))
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle 0xdc8 : ");
      paramToServiceMsg.append(paramFromServiceMsg.toString());
      QLog.d("ReadInJoyCommentPBModule", 1, paramToServiceMsg.toString());
    }
  }
  
  public void unInitialize()
  {
    this.a = null;
    QLog.d("ReadInJoyCommentPBModule", 1, "unInitialize");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule
 * JD-Core Version:    0.7.0.1
 */