package com.tencent.mobileqq.kandian.biz.pts.item;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJJsonUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.util.AccountShowUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.VideoFeedsUtil;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class DoubleVideoProteusItem
  implements ProteusItem
{
  private Boolean a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, AbsBaseArticleInfo paramAbsBaseArticleInfo3, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      switch (paramInt1)
      {
      default: 
        return Boolean.valueOf(false);
      case 1167: 
      case 1168: 
        a(paramIReadInJoyModel, paramViewBase, paramInt1, paramAbsBaseArticleInfo2, paramAbsBaseArticleInfo3);
        return Boolean.valueOf(true);
      }
      b(paramIReadInJoyModel, paramViewBase, paramInt1, paramAbsBaseArticleInfo2, paramAbsBaseArticleInfo3);
      return Boolean.valueOf(true);
    case 1133: 
      a(paramIReadInJoyModel, paramViewBase, paramAbsBaseArticleInfo1);
      return Boolean.valueOf(true);
    case 1132: 
      a(paramViewBase, paramAbsBaseArticleInfo3);
      a(paramIReadInJoyModel, paramViewBase, paramAbsBaseArticleInfo2, paramAbsBaseArticleInfo3, paramInt2);
      return Boolean.valueOf(true);
    }
    b(paramViewBase, paramAbsBaseArticleInfo2);
    a(paramIReadInJoyModel, paramViewBase, paramAbsBaseArticleInfo2, paramInt2);
    return Boolean.valueOf(true);
  }
  
  private String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.getVideoCoverURL() != null)) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.getVideoCoverURL().getFile();
    } else {
      paramAbsBaseArticleInfo = "";
    }
    Object localObject = paramAbsBaseArticleInfo;
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      localObject = paramString;
    }
    if (QLog.isColorLevel())
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("[getOriginVideoUrl] originVideoUrl = ");
      paramAbsBaseArticleInfo.append((String)localObject);
      QLog.i("DoubleVideoProteusItem", 2, paramAbsBaseArticleInfo.toString());
    }
    return localObject;
  }
  
  private Map<String, Object> a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramTemplateBean != null) && (paramViewBase != null)) {
      return paramTemplateBean.getDataAttribute(paramViewBase.getName());
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (("id_right_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_right_item_gif_imageview".equals(paramViewBase.getViewId())))
    {
      VideoReport.setElementExposePolicy(paramViewBase.getNativeView(), ExposurePolicy.REPORT_FIRST);
      VideoReport.setElementEndExposePolicy(paramViewBase.getNativeView(), EndExposurePolicy.REPORT_ALL);
      VideoReport.setElementId(paramViewBase.getNativeView(), "card");
      View localView = paramViewBase.getNativeView();
      RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().a(Long.valueOf(paramAbsBaseArticleInfo.mChannelID));
      String str;
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) {
        str = "null";
      } else {
        str = paramAbsBaseArticleInfo.innerUniqueID;
      }
      VideoReport.setElementParams(localView, localRIJDtParamBuilder.e(str).c());
      VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), paramAbsBaseArticleInfo.innerUniqueID);
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      if (paramAbsBaseArticleInfo.subscriptLocation != 0)
      {
        QLog.d("DoubleVideoProteusItem", 2, "bindRightSubscriptInfo | wrong position");
        return;
      }
      RIJJsonUtils.a(paramJSONObject, "right_mark_text", paramAbsBaseArticleInfo.subscriptWording);
      RIJJsonUtils.a(paramJSONObject, "right_mark_color", paramAbsBaseArticleInfo.subscriptWordingColor);
      RIJJsonUtils.a(paramJSONObject, "right_mark_backgroundcolor", paramAbsBaseArticleInfo.subscriptBgColor);
      paramJSONObject.put("right_corner_mark", paramAbsBaseArticleInfo.subscriptType);
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramBoolean) {
        a("right_", paramAbsBaseArticleInfo, paramJSONObject);
      }
      Object localObject;
      if ((paramAbsBaseArticleInfo.richTitleInfoList != null) && (paramAbsBaseArticleInfo.richTitleInfoList.size() > 0))
      {
        Util.a(paramAbsBaseArticleInfo, paramJSONObject, "right_rich_text_line", "right_rich_text_info", true);
      }
      else
      {
        paramJSONObject.put("right_article_title", paramAbsBaseArticleInfo.mTitle);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ReadInJoyHelper.F());
        ((StringBuilder)localObject).append("");
        paramJSONObject.put("right_title_num", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ReadInJoyHelper.F());
        ((StringBuilder)localObject).append("");
        paramJSONObject.put("title_num", ((StringBuilder)localObject).toString());
      }
      if ((paramAbsBaseArticleInfo.isUseGif) && (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramAbsBaseArticleInfo.isShowGif = paramBoolean;
      if (paramAbsBaseArticleInfo.isShowGif)
      {
        paramJSONObject.put("right_cover_gif", paramAbsBaseArticleInfo.gifCoverUrl);
        paramJSONObject.put("right_cover_url", paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
      }
      else
      {
        localObject = a(paramAbsBaseArticleInfo, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
        paramJSONObject.put("right_cover_image_url", localObject);
        FluencyOptUtils.a.a((String)localObject);
      }
      if ((paramAbsBaseArticleInfo.isAccountShown) && (paramAbsBaseArticleInfo.mPartnerAccountInfo != null))
      {
        long l = paramAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("");
        paramJSONObject.put("right_account_uin", ((StringBuilder)localObject).toString());
        localObject = RIJPBFieldUtils.d(paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject.put("right_account_small_icon_url", localObject);
        }
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mVideoArticleSubsColor))
      {
        paramJSONObject.put("right_item_subscript_text", paramAbsBaseArticleInfo.mVideoArticleSubsText);
        String str = paramAbsBaseArticleInfo.mVideoArticleSubsColor;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "#00a5e0";
        }
        paramJSONObject.put("right_item_subscript_bg_color", localObject);
      }
      a(paramAbsBaseArticleInfo, paramJSONObject);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.smallGameData))
      {
        paramJSONObject.put("right_comment_count", ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getFormatNum(paramAbsBaseArticleInfo.mCommentCount, HardCodeUtil.a(2131900284)));
        paramJSONObject.put("right_play_count", HardCodeUtil.a(2131898073));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("play_icon", "readinjoy_ad_small_game");
        paramJSONObject.put("id_right_play_icon", localObject);
      }
      paramAbsBaseArticleInfo.isTwoItem = true;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mJsonVideoList))
      {
        localObject = VideoFeedsHelper.a(paramAbsBaseArticleInfo.getVideoDuration() * 1000);
        if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          paramJSONObject.put("right_time", ((StringBuilder)localObject).toString());
        }
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeName)) {
        paramJSONObject.put("right_author", RIJStringUtils.a(paramAbsBaseArticleInfo.mSubscribeName));
      }
      Util.a(paramAbsBaseArticleInfo, paramJSONObject, "right_");
    }
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.1(this, paramInt, paramIReadInJoyModel, paramAbsBaseArticleInfo1, paramAbsBaseArticleInfo2));
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.3(this, paramAbsBaseArticleInfo, paramIReadInJoyModel));
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.5(this, paramIReadInJoyModel, paramInt, paramAbsBaseArticleInfo));
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, int paramInt)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.4(this, paramIReadInJoyModel, paramInt, paramAbsBaseArticleInfo2, paramAbsBaseArticleInfo1));
  }
  
  private void a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder;
    if (paramAbsBaseArticleInfo.getCommentCount() > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("comment_count");
      paramJSONObject.put(localStringBuilder.toString(), VideoFeedsUtil.b(paramAbsBaseArticleInfo.getCommentCount()));
    }
    if (paramAbsBaseArticleInfo.mVideoPlayCount > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("play_count");
      paramJSONObject.put(localStringBuilder.toString(), VideoFeedsUtil.b(paramAbsBaseArticleInfo.mVideoPlayCount));
    }
    paramJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
    paramJSONObject.put("comment_icon", "comment_icon_white");
  }
  
  private void b(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (("id_left_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_left_item_gif_imageview".equals(paramViewBase.getViewId())))
    {
      VideoReport.setElementExposePolicy(paramViewBase.getNativeView(), ExposurePolicy.REPORT_FIRST);
      VideoReport.setElementEndExposePolicy(paramViewBase.getNativeView(), EndExposurePolicy.REPORT_ALL);
      VideoReport.setElementId(paramViewBase.getNativeView(), "card");
      View localView = paramViewBase.getNativeView();
      RIJDtParamBuilder localRIJDtParamBuilder = new RIJDtParamBuilder().a(Long.valueOf(paramAbsBaseArticleInfo.mChannelID));
      String str;
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) {
        str = "null";
      } else {
        str = paramAbsBaseArticleInfo.innerUniqueID;
      }
      VideoReport.setElementParams(localView, localRIJDtParamBuilder.e(str).c());
      VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), paramAbsBaseArticleInfo.innerUniqueID);
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideo(paramAbsBaseArticleInfo1)) {
      return;
    }
    try
    {
      paramJSONObject.remove("play_icon");
      paramJSONObject.remove("comment_icon");
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("play_icon", "ReadInJoy/video_play_icon.png");
      paramJSONObject.put("id_left_play_icon", localObject);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("comment_icon", "comment_icon_white");
      paramJSONObject.put("id_left_comment_icon", localJSONObject);
      new JSONObject().put("play_icon", "ReadInJoy/video_play_icon.png");
      paramJSONObject.put("id_right_play_icon", localObject);
      new JSONObject().put("comment_icon", "comment_icon_white");
      paramJSONObject.put("id_right_comment_icon", localJSONObject);
      boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideoSingle(paramAbsBaseArticleInfo1);
      if (bool)
      {
        paramAbsBaseArticleInfo1 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getFormatNum(paramAbsBaseArticleInfo1.mCommentCount, HardCodeUtil.a(2131900284));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131898073));
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo1);
        paramJSONObject.put("left_play_count", ((StringBuilder)localObject).toString());
        paramAbsBaseArticleInfo1 = new JSONObject();
        paramAbsBaseArticleInfo1.put("play_icon", "readinjoy_ad_small_game");
        paramJSONObject.put("id_left_play_icon", paramAbsBaseArticleInfo1);
        paramJSONObject.remove("id_left_comment_icon");
        paramJSONObject.remove("left_comment_count");
      }
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameDoubleVideoSingle(paramAbsBaseArticleInfo2))
      {
        paramAbsBaseArticleInfo1 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getFormatNum(paramAbsBaseArticleInfo2.mCommentCount, HardCodeUtil.a(2131900284));
        paramAbsBaseArticleInfo2 = new StringBuilder();
        paramAbsBaseArticleInfo2.append(HardCodeUtil.a(2131898073));
        paramAbsBaseArticleInfo2.append(" ");
        paramAbsBaseArticleInfo2.append(paramAbsBaseArticleInfo1);
        paramJSONObject.put("right_play_count", paramAbsBaseArticleInfo2.toString());
        paramAbsBaseArticleInfo1 = new JSONObject();
        paramAbsBaseArticleInfo1.put("play_icon", "readinjoy_ad_small_game");
        paramJSONObject.put("id_right_play_icon", paramAbsBaseArticleInfo1);
        paramJSONObject.remove("id_right_comment_icon");
        paramJSONObject.remove("right_comment_count");
        return;
      }
    }
    catch (Exception paramAbsBaseArticleInfo1)
    {
      paramAbsBaseArticleInfo2 = new StringBuilder();
      paramAbsBaseArticleInfo2.append("small game json error");
      paramAbsBaseArticleInfo2.append(paramAbsBaseArticleInfo1.getMessage());
      QLog.d("DoubleVideoProteusItem", 2, paramAbsBaseArticleInfo2.toString());
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      if (paramAbsBaseArticleInfo.subscriptLocation != 0)
      {
        QLog.d("DoubleVideoProteusItem", 2, "bindLeftSubscriptInfo | wrong position");
        return;
      }
      RIJJsonUtils.a(paramJSONObject, "left_mark_text", paramAbsBaseArticleInfo.subscriptWording);
      RIJJsonUtils.a(paramJSONObject, "left_mark_color", paramAbsBaseArticleInfo.subscriptWordingColor);
      RIJJsonUtils.a(paramJSONObject, "left_mark_backgroundcolor", paramAbsBaseArticleInfo.subscriptBgColor);
      paramJSONObject.put("left_corner_mark", paramAbsBaseArticleInfo.subscriptType);
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramBoolean) {
        a("left_", paramAbsBaseArticleInfo, paramJSONObject);
      }
      Object localObject;
      if ((paramAbsBaseArticleInfo.richTitleInfoList != null) && (paramAbsBaseArticleInfo.richTitleInfoList.size() > 0))
      {
        Util.a(paramAbsBaseArticleInfo, paramJSONObject, "left_rich_text_line", "left_rich_text_info", true);
      }
      else
      {
        paramJSONObject.put("left_article_title", paramAbsBaseArticleInfo.mTitle);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ReadInJoyHelper.F());
        ((StringBuilder)localObject).append("");
        paramJSONObject.put("left_title_num", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ReadInJoyHelper.F());
        ((StringBuilder)localObject).append("");
        paramJSONObject.put("title_num", ((StringBuilder)localObject).toString());
      }
      if ((paramAbsBaseArticleInfo.isUseGif) && (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramAbsBaseArticleInfo.isShowGif = paramBoolean;
      if (paramAbsBaseArticleInfo.isShowGif)
      {
        paramJSONObject.put("left_cover_gif", paramAbsBaseArticleInfo.gifCoverUrl);
        paramJSONObject.put("left_cover_url", paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
      }
      else
      {
        localObject = a(paramAbsBaseArticleInfo, paramAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
        paramJSONObject.put("left_cover_image_url", localObject);
        FluencyOptUtils.a.a((String)localObject);
      }
      if ((paramAbsBaseArticleInfo.isAccountShown) && (paramAbsBaseArticleInfo.mPartnerAccountInfo != null))
      {
        long l = paramAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("");
        paramJSONObject.put("left_account_uin", ((StringBuilder)localObject).toString());
        localObject = RIJPBFieldUtils.d(paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject.put("left_account_small_icon_url", localObject);
        }
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mVideoArticleSubsColor))
      {
        paramJSONObject.put("left_item_subscript_text", paramAbsBaseArticleInfo.mVideoArticleSubsText);
        String str = paramAbsBaseArticleInfo.mVideoArticleSubsColor;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "#00a5e0";
        }
        paramJSONObject.put("left_item_subscript_bg_color", localObject);
      }
      b(paramAbsBaseArticleInfo, paramJSONObject);
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.smallGameData))
      {
        paramJSONObject.put("left_comment_count", ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getFormatNum(paramAbsBaseArticleInfo.mCommentCount, HardCodeUtil.a(2131900284)));
        paramJSONObject.put("left_play_count", HardCodeUtil.a(2131898073));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("play_icon", "readinjoy_ad_small_game");
        paramJSONObject.put("id_left_play_icon", localObject);
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mJsonVideoList))
      {
        localObject = VideoFeedsHelper.a(paramAbsBaseArticleInfo.getVideoDuration() * 1000);
        if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          paramJSONObject.put("left_time", ((StringBuilder)localObject).toString());
        }
      }
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeName)) {
        paramJSONObject.put("left_author", RIJStringUtils.a(paramAbsBaseArticleInfo.mSubscribeName));
      }
      Util.a(paramAbsBaseArticleInfo, paramJSONObject, "left_");
    }
  }
  
  private void b(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.2(this, paramInt, paramIReadInJoyModel, paramAbsBaseArticleInfo1, paramAbsBaseArticleInfo2));
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSubArticleList != null) && (paramAbsBaseArticleInfo.mSubArticleList.size() > 0)) {
      localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0);
    } else {
      localAbsBaseArticleInfo = null;
    }
    JSONObject localJSONObject = new JSONObject();
    boolean bool = ReadInJoyHelper.G();
    for (;;)
    {
      try
      {
        b(paramAbsBaseArticleInfo, localJSONObject, bool);
        a(localAbsBaseArticleInfo, localJSONObject, bool);
        a(paramAbsBaseArticleInfo, localAbsBaseArticleInfo, localJSONObject);
        b(paramAbsBaseArticleInfo, localAbsBaseArticleInfo, localJSONObject);
        String str = "";
        if ((paramAbsBaseArticleInfo == null) || (paramAbsBaseArticleInfo.multiVideoColumnInfo == null)) {
          break label215;
        }
        localObject = Integer.valueOf(paramAbsBaseArticleInfo.multiVideoColumnInfo.a);
        localJSONObject.put("column_id_1", localObject);
        localObject = str;
        if (localAbsBaseArticleInfo != null)
        {
          localObject = str;
          if (localAbsBaseArticleInfo.multiVideoColumnInfo != null) {
            localObject = Integer.valueOf(localAbsBaseArticleInfo.multiVideoColumnInfo.a);
          }
        }
        localJSONObject.put("column_id_2", localObject);
        localJSONObject.put("style_ID", "ReadInjoy_double_video_cell");
      }
      catch (Exception localException)
      {
        QLog.d("DoubleVideoProteusItem", 2, localException.getMessage());
      }
      Util.a(localJSONObject, paramAbsBaseArticleInfo);
      return localJSONObject;
      label215:
      Object localObject = "";
    }
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo2 = paramIReadInJoyModel.k();
    if (localAbsBaseArticleInfo2 != null)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo1;
      if ((localAbsBaseArticleInfo2 != null) && (localAbsBaseArticleInfo2.mSubArticleList != null) && (localAbsBaseArticleInfo2.mSubArticleList.size() > 0)) {
        localAbsBaseArticleInfo1 = (AbsBaseArticleInfo)localAbsBaseArticleInfo2.mSubArticleList.get(0);
      } else {
        localAbsBaseArticleInfo1 = null;
      }
      if ((localAbsBaseArticleInfo2 != null) && (localAbsBaseArticleInfo2.isAccountShown)) {
        AccountShowUtils.a(paramContainer, paramIReadInJoyModel, "id_left_account_name");
      }
      if ((localAbsBaseArticleInfo1 != null) && (localAbsBaseArticleInfo1.isAccountShown)) {
        AccountShowUtils.a(paramContainer, paramIReadInJoyModel, "id_right_account_name");
      }
      if (paramContainer != null)
      {
        MultiVideoHelper.a(localAbsBaseArticleInfo2, BaseActivity.sTopActivity);
        MultiVideoHelper.a(localAbsBaseArticleInfo1, BaseActivity.sTopActivity);
      }
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, JSONObject paramJSONObject)
  {
    if ((paramAbsBaseArticleInfo1 != null) && (paramAbsBaseArticleInfo1.columnEntrances != null) && (!paramAbsBaseArticleInfo1.columnEntrances.isEmpty()) && (paramAbsBaseArticleInfo2 != null) && (paramAbsBaseArticleInfo2.columnEntrances != null) && (!paramAbsBaseArticleInfo2.columnEntrances.isEmpty()))
    {
      VideoColumnInfo localVideoColumnInfo = (VideoColumnInfo)paramAbsBaseArticleInfo1.columnEntrances.get(0);
      paramAbsBaseArticleInfo2 = (VideoColumnInfo)paramAbsBaseArticleInfo2.columnEntrances.get(0);
      if ((localVideoColumnInfo != null) && (paramAbsBaseArticleInfo2 != null))
      {
        if ((localVideoColumnInfo.b != 0) && (localVideoColumnInfo.b == paramAbsBaseArticleInfo2.b))
        {
          Util.ao(paramAbsBaseArticleInfo1, paramJSONObject);
          return;
        }
        if (localVideoColumnInfo.b != 0)
        {
          paramJSONObject.put("column_tips_left", "栏目");
          paramJSONObject.put("column_name_left", localVideoColumnInfo.c);
          paramJSONObject.put("readinjoy_column_icon_left", "readinjoy_column_icon_white");
        }
        if (paramAbsBaseArticleInfo2.b != 0)
        {
          paramJSONObject.put("column_tips_right", "栏目");
          paramJSONObject.put("column_name_right", paramAbsBaseArticleInfo2.c);
          paramJSONObject.put("readinjoy_column_icon_right", "readinjoy_column_icon_white");
        }
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSubArticleList != null) && (localAbsBaseArticleInfo.mSubArticleList.size() > 0)) {
      paramContainer = (AbsBaseArticleInfo)localAbsBaseArticleInfo.mSubArticleList.get(0);
    } else {
      paramContainer = null;
    }
    if (localAbsBaseArticleInfo != null)
    {
      if (paramContainer == null) {
        return false;
      }
      if (localAbsBaseArticleInfo.mProteusTemplateBean != null) {
        paramContainer.mProteusTemplateBean = localAbsBaseArticleInfo.mProteusTemplateBean;
      }
      return a(paramIReadInJoyModel, paramViewBase, i, localAbsBaseArticleInfo, localAbsBaseArticleInfo, paramContainer, paramInt).booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.DoubleVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */