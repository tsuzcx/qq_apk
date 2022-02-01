package com.tencent.mobileqq.kandian.glue.pts.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyAdVideoCompleteGuide.Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLayoutImpl;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText.Builder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IReadInJoyAdSmallImgCell;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentAvatarView.Builder;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentContentView.Builder;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentLikeView.Builder;
import com.tencent.mobileqq.kandian.biz.comment.ui.CommentRichTextView.Builder;
import com.tencent.mobileqq.kandian.biz.comment.ui.ExposeReplyCommentView.Builder;
import com.tencent.mobileqq.kandian.biz.comment.ui.PTSCommentLinkView.Builder;
import com.tencent.mobileqq.kandian.biz.common.DividerConfigUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyGalleryBigCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoySingleTopicCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoySmallImgCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoySmallVideoCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyGalleryTripleCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyNoneImgCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyPgcMultiCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyTopicRecommendPgcBigCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyTopicRecommendPgcMultiCell;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyTopicRecommendPgcSmallCell;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.item.AccountCardItem;
import com.tencent.mobileqq.kandian.biz.pts.item.AnswerProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.BigImageProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.BigImageVideoProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.BiuAnswerProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.BiuPgcProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.BiuUgcProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.ColumnTwoVideoProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.CommentBiuProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.DoubleShortVideoProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.DoubleVideoProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.GalleryProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.KandianTenProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.LiveDoubleVideoProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.LiveSingleVideoProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.MultiVideoColumnProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.NewPolymericMultiVideoProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.NoteCardProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.PackProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.PgcProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.item.QuestionAnswerCardProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.QuestionCardProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.SmallImageProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.TripleProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.UgcProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.WechatSimpleVideoProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.FluencyLogUtil;
import com.tencent.mobileqq.kandian.biz.pts.util.LogUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteItemViewUtil;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteItemViewUtil.Companion;
import com.tencent.mobileqq.kandian.biz.pts.util.ProteusPreloadManager;
import com.tencent.mobileqq.kandian.biz.pts.util.ProteusSettingUtil;
import com.tencent.mobileqq.kandian.biz.pts.view.ArticleCommentView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.AvatarView;
import com.tencent.mobileqq.kandian.biz.pts.view.AvatarView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.BiuCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.BiuCommentView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.CornerTextImageView;
import com.tencent.mobileqq.kandian.biz.pts.view.CornerTextImageView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.GridImageView;
import com.tencent.mobileqq.kandian.biz.pts.view.GridImageView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ProteusTickerView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyAdLocationView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyAwesomeCommentView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyBiuButton.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyCoordinateView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyFriendsBiu.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyGifView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLikeButton.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLottieView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyShareView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyVideoView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyApngImageView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyAsynImageIcon.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyImageView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyProgressView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyTextView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.SummaryView;
import com.tencent.mobileqq.kandian.biz.pts.view.SummaryView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.UsersCommentsView.Builder;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer.Builder;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianOverDrawOptimizeAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.ReadInJoySrtHandler;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusSupportUtil
{
  private static double jdField_a_of_type_Double = 0.0D;
  private static int jdField_a_of_type_Int;
  private static final ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private static final Map<Integer, ProteusItem> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      a(3, new TripleProteusItem());
      a(72, new AnswerProteusItem());
      a(73, new BiuAnswerProteusItem());
      a(74, new QuestionCardProteusItem());
      a(90, new QuestionAnswerCardProteusItem());
      a(91, new QuestionAnswerCardProteusItem());
      a(75, new QuestionCardProteusItem());
      a(21, new UgcProteusItem());
      a(22, new UgcProteusItem());
      a(36, new UgcProteusItem());
      a(23, new UgcProteusItem());
      a(120, new UgcProteusItem());
      a(80, new UgcProteusItem());
      a(34, new PgcProteusItem());
      a(16, new PgcProteusItem());
      a(17, new PgcProteusItem());
      a(19, new PgcProteusItem());
      a(18, new PgcProteusItem());
      a(20, new PgcProteusItem());
      a(65, new PgcProteusItem());
      a(64, new PgcProteusItem());
      a(48, new PgcProteusItem());
      a(25, new BiuUgcProteusItem());
      a(24, new BiuUgcProteusItem());
      a(26, new BiuUgcProteusItem());
      a(107, new UgcProteusItem());
      a(108, new BiuUgcProteusItem());
      a(37, new BiuUgcProteusItem());
      a(81, new BiuUgcProteusItem());
      a(35, new BiuPgcProteusItem());
      a(12, new BiuPgcProteusItem());
      a(10, new BiuPgcProteusItem());
      a(11, new BiuPgcProteusItem());
      a(28, new BiuPgcProteusItem());
      a(27, new BiuPgcProteusItem());
      a(49, new BiuPgcProteusItem());
      a(62, new BiuPgcProteusItem());
      a(63, new BiuPgcProteusItem());
      a(33, new BiuPgcProteusItem());
      a(31, new PgcProteusItem());
      a(32, new PgcProteusItem());
      a(79, new PackProteusItem());
      a(76, new PackProteusItem());
      a(77, new PackProteusItem());
      a(78, new PackProteusItem());
      a(83, new PgcProteusItem());
      a(84, new PgcProteusItem());
      a(85, new PgcProteusItem());
      a(86, new PgcProteusItem());
      a(89, new AccountCardItem());
      a(92, new BiuUgcProteusItem());
      a(94, new BiuPgcProteusItem());
      a(95, new BiuPgcProteusItem());
      a(101, new GalleryProteusItem());
      a(102, new GalleryProteusItem());
      a(103, new GalleryProteusItem());
      a(109, new PgcShortContentProteusItem());
      a(110, new PgcShortContentProteusItem());
      a(111, new PgcShortContentProteusItem());
      a(132, new PgcShortContentProteusItem());
      a(133, new PgcShortContentProteusItem());
      a(134, new PgcShortContentProteusItem());
      a(112, new BiuPgcProteusItem());
      a(113, new BiuPgcProteusItem());
      a(114, new BiuPgcProteusItem());
      a(126, new BigImageVideoProteusItem());
      a(2, new BigImageProteusItem());
      a(1, new SmallImageProteusItem());
      a(121, new DoubleShortVideoProteusItem());
      a(124, new MultiVideoColumnProteusItem());
      a(125, new MultiVideoColumnProteusItem());
      a(129, new LiveSingleVideoProteusItem());
      a(130, new LiveDoubleVideoProteusItem());
      a(131, new NewPolymericMultiVideoProteusItem());
      a(46, new DoubleVideoProteusItem());
      a(123, new NoteCardProteusItem());
      a(135, new KandianTenProteusItem());
      a(137, new CommentBiuProteusItem());
      a(139, new CommentBiuProteusItem());
      a(138, new CommentBiuProteusItem());
      a(142, new ColumnTwoVideoProteusItem());
      a(147, new WechatSimpleVideoProteusItem());
      a();
    }
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(5));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(47));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(60));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(39));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(66));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(50));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(51));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(52));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(53));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(96));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(103));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(102));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(101));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(104));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(105));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(106));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(116));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(121));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(126));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(115));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(124));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(125));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(127));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(140));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(141));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(129));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(130));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(136));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(46));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(142));
    jdField_a_of_type_Int = 0;
  }
  
  private static double a(TemplateBean paramTemplateBean)
  {
    TraceUtils.traceBegin("getProteusSeparatorMarginLeftPx");
    if ((jdField_a_of_type_Double > 0.0D) && (paramTemplateBean != null))
    {
      TemplateFactory localTemplateFactory = TemplateFactory.a("default_feeds", false);
      if ((localTemplateFactory != null) && (!localTemplateFactory.a(paramTemplateBean)))
      {
        TraceUtils.traceEnd();
        return jdField_a_of_type_Double;
      }
    }
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {
      try
      {
        paramTemplateBean = paramTemplateBean.getViewBean().findViewById("id_separator");
        if (paramTemplateBean != null) {
          jdField_a_of_type_Double = Float.valueOf((String)paramTemplateBean.valueBean.normalValue.get("margin_left")).floatValue();
        }
      }
      catch (Exception paramTemplateBean)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorMarginLeft exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TemplateFactory", 2, new Object[] { "sProteusSeparatorMarginLeft = ", Double.valueOf(jdField_a_of_type_Double) });
    }
    TraceUtils.traceEnd();
    return jdField_a_of_type_Double;
  }
  
  private static int a(TemplateBean paramTemplateBean)
  {
    TraceUtils.traceBegin("getProteusSeparatorHeightPx");
    if ((jdField_a_of_type_Int > 0) && (paramTemplateBean != null))
    {
      localTemplateFactory = TemplateFactory.a("default_feeds", false);
      if ((localTemplateFactory != null) && (!localTemplateFactory.a(paramTemplateBean)))
      {
        TraceUtils.traceEnd();
        paramTemplateBean = new StringBuilder();
        paramTemplateBean.append("[getProteusSeparatorHeightPx] SeparatorHeight : ");
        paramTemplateBean.append(jdField_a_of_type_Int);
        FluencyLogUtil.a("ProteusSupportUtil", paramTemplateBean.toString());
        return jdField_a_of_type_Int;
      }
    }
    TemplateFactory localTemplateFactory = TemplateFactory.a("default_feeds", false);
    paramTemplateBean = null;
    if (localTemplateFactory != null) {
      paramTemplateBean = localTemplateFactory.getTemplate("ReadInjoy_triple_img_cell");
    }
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {
      try
      {
        paramTemplateBean = paramTemplateBean.getViewBean().findViewById("id_separator");
        if (paramTemplateBean != null)
        {
          paramTemplateBean = (SizeValue)paramTemplateBean.valueBean.normalValue.get("height");
          if (paramTemplateBean != null) {
            jdField_a_of_type_Int = paramTemplateBean.getLayoutSize();
          }
        }
        else
        {
          jdField_a_of_type_Int = Utils.dp2px(0.5D);
        }
        FluencyLogUtil.a("ProteusSupportUtil", "[getProteusSeparatorHeightPx] getSeparatorHeightPx");
      }
      catch (Exception paramTemplateBean)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorHeight exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TemplateFactory", 2, new Object[] { "sProteusSeparatorHeight = ", Integer.valueOf(jdField_a_of_type_Int) });
    }
    TraceUtils.traceEnd();
    return jdField_a_of_type_Int;
  }
  
  public static TemplateBean a(VafContext paramVafContext, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TemplateBean localTemplateBean = null;
    Object localObject5 = null;
    Object localObject1 = null;
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    Object localObject4;
    if (paramVafContext == null)
    {
      paramVafContext = TemplateFactory.a("default_feeds", false);
      localObject4 = paramVafContext;
      if (paramVafContext == null) {
        return null;
      }
    }
    else
    {
      localObject4 = (TemplateFactory)paramVafContext.getTemplateFactory();
    }
    if (QLog.isColorLevel())
    {
      paramVafContext = new StringBuilder();
      paramVafContext.append("getTemplateBean : ");
      paramVafContext.append(paramAbsBaseArticleInfo);
      paramVafContext.append(" adapterViewType : ");
      paramVafContext.append(paramInt);
      QLog.d("ProteusSupportUtil", 2, paramVafContext.toString());
    }
    Object localObject2 = localTemplateBean;
    Object localObject3 = localObject5;
    for (;;)
    {
      try
      {
        if (paramAbsBaseArticleInfo.mProteusTemplateBean != null)
        {
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          if (!((TemplateFactory)localObject4).a(paramAbsBaseArticleInfo.mProteusTemplateBean))
          {
            localObject2 = localTemplateBean;
            localObject3 = localObject5;
            return paramAbsBaseArticleInfo.mProteusTemplateBean;
          }
        }
        localObject2 = localTemplateBean;
        localObject3 = localObject5;
        ProteusItem localProteusItem = (ProteusItem)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        if (localProteusItem != null)
        {
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = localProteusItem.a(paramInt, paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInjoyNoneImgCell.a(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInjoyTopicRecommendPgcMultiCell.a(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInjoyTopicRecommendPgcSmallCell.a(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInjoyTopicRecommendPgcBigCell.a(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ((IReadInJoyAdSmallImgCell)QRoute.api(IReadInJoyAdSmallImgCell.class)).getDataJson(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInjoyGalleryTripleCell.a(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInJoyGalleryBigCell.a(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInjoyPgcMultiCell.a(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInJoySingleTopicCell.a(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInJoySmallVideoCell.a(paramAbsBaseArticleInfo);
          continue;
          localObject2 = localTemplateBean;
          localObject3 = localObject5;
          paramVafContext = ReadInJoySmallImgCell.a(paramAbsBaseArticleInfo);
          if (localProteusItem != null)
          {
            localObject2 = localTemplateBean;
            localObject3 = localObject5;
            localTemplateBean = localProteusItem.a(paramInt, paramVafContext);
            localObject2 = localTemplateBean;
          }
          else
          {
            localObject2 = null;
          }
          if (localObject2 == null)
          {
            if (localObject4 != null) {
              try
              {
                localObject1 = ((TemplateFactory)localObject4).getTemplateBean(paramVafContext);
              }
              catch (Exception paramVafContext)
              {
                continue;
              }
              catch (JSONException paramVafContext)
              {
                localObject3 = localObject2;
                continue;
              }
            }
          }
          else {
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo.mProteusTemplateBean = ((TemplateBean)localObject1);
          localObject2 = localObject1;
          localObject3 = localObject1;
          localObject4 = new StringBuilder();
          localObject2 = localObject1;
          localObject3 = localObject1;
          ((StringBuilder)localObject4).append("ProteusFamily : ");
          if (paramVafContext == null) {
            break label775;
          }
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo = new StringBuilder();
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo.append(paramVafContext.getString("style_ID"));
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo.append(": ");
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo.append(paramVafContext.toString());
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo.append("\n");
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.toString();
          localObject2 = localObject1;
          localObject3 = localObject1;
          ((StringBuilder)localObject4).append(paramAbsBaseArticleInfo);
          localObject2 = localObject1;
          localObject3 = localObject1;
          QLog.d("ProteusSupportUtil", 2, ((StringBuilder)localObject4).toString());
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo = new StringBuilder();
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo.append("Proteus JsonObject: ");
          localObject2 = localObject1;
          localObject3 = localObject1;
          paramAbsBaseArticleInfo.append(paramVafContext);
          localObject2 = localObject1;
          localObject3 = localObject1;
          QLog.d("ProteusSupportUtil", 1, paramAbsBaseArticleInfo.toString());
          return localObject1;
        }
      }
      catch (Exception paramVafContext)
      {
        QLog.e("ProteusSupportUtil", 1, "getTemplateBean: ", paramVafContext);
        return localObject2;
      }
      catch (JSONException paramVafContext)
      {
        QLog.e("ProteusSupportUtil", 1, "getTemplateBean: fail to cast article info to jsonObject", paramVafContext);
        return localObject3;
      }
      if (paramInt != 1) {
        if (paramInt != 5) {
          if (paramInt != 29) {
            if (paramInt != 34) {
              if (paramInt != 47) {
                if ((paramInt != 60) && (paramInt != 96)) {
                  if (paramInt != 104)
                  {
                    switch (paramInt)
                    {
                    }
                    continue;
                    label775:
                    paramAbsBaseArticleInfo = "";
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (LogUtils.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getView] ");
      ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo);
      ((StringBuilder)localObject1).append(" adapterViewType: ");
      ((StringBuilder)localObject1).append(paramInt);
      LogUtils.a("ProteusSupportUtil", ((StringBuilder)localObject1).toString());
    }
    long l1 = System.currentTimeMillis();
    TraceUtils.traceBegin("ProteusSupportUtil.getView");
    TraceUtils.traceBegin("ProteusSupportUtil#getView#getTemplateBean");
    TemplateBean localTemplateBean = a(paramVafContext, paramInt, paramAbsBaseArticleInfo);
    TraceUtils.traceEnd();
    int i = 1;
    Object localObject3 = null;
    Object localObject2;
    if (localTemplateBean != null)
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("[");
      paramAbsBaseArticleInfo.append(localTemplateBean.getStyleName());
      paramAbsBaseArticleInfo.append("]");
      localObject2 = paramAbsBaseArticleInfo.toString();
      paramAbsBaseArticleInfo = null;
    }
    else
    {
      FluencyLogUtil.a("ProteusSupportUtil", "[getView]  new proteusItemView ");
      localObject1 = new ProteusItemView(paramVafContext.getContext());
      ((ProteusItemView)localObject1).setVisibility(8);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getView] 未找到样式,请确认是否下发该卡片的样式:");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo);
      ((StringBuilder)localObject2).append(" adapterViewType: ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("  ");
      ((StringBuilder)localObject2).append(paramVafContext.getTemplateFactory());
      QLog.i("ProteusSupportUtil", 1, ((StringBuilder)localObject2).toString());
      localObject2 = "";
      paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject1;
    }
    Object localObject1 = localObject3;
    if ((paramVafContext.getTemplateFactory() instanceof TemplateFactory))
    {
      localObject1 = localObject3;
      if (localTemplateBean != null) {
        localObject1 = ProteusPreloadManager.a.a(((TemplateFactory)paramVafContext.getTemplateFactory()).b(), localTemplateBean.getStyleName());
      }
    }
    localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("#inflate");
      TraceUtils.traceBegin(((StringBuilder)localObject1).toString());
      localObject3 = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      FluencyLogUtil.a("ProteusSupportUtil", "[getView] inflate");
      TraceUtils.traceEnd();
    }
    if (localObject3 != null)
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append((String)localObject2);
      paramAbsBaseArticleInfo.append("#setBackgroundDrawable");
      TraceUtils.traceBegin(paramAbsBaseArticleInfo.toString());
      if ((RIJKanDianOverDrawOptimizeAladdinConfig.a()) && (ReadInJoyHelper.m())) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      paramAbsBaseArticleInfo = paramVafContext.getContext().getResources();
      if (paramInt != 0) {
        paramInt = 2130841772;
      } else {
        paramInt = 2130841773;
      }
      ((Container)localObject3).setBackgroundDrawable(paramAbsBaseArticleInfo.getDrawable(paramInt));
      paramAbsBaseArticleInfo = new ProteusItemView(paramVafContext.getContext());
      paramAbsBaseArticleInfo.a((Container)localObject3);
      TraceUtils.traceEnd();
      FluencyLogUtil.a("ProteusSupportUtil", "[getView]  add Container ");
    }
    if ((QLog.isColorLevel()) && (localObject3 != null)) {
      LogUtils.a((View)localObject3, "ProteusSupportUtil");
    }
    long l2 = System.currentTimeMillis();
    localObject1 = (IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class);
    if (localTemplateBean != null) {
      paramVafContext = localTemplateBean.getStyleName();
    } else {
      paramVafContext = "templateBean is null";
    }
    ((IReadInJoyPTSCostHelper)localObject1).printCost("ProteusSupportUtil", paramVafContext, "ProteusSupportUtil.getView", l2 - l1);
    TraceUtils.traceEnd();
    return paramAbsBaseArticleInfo;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = UGRuleManager.c(paramAbsBaseArticleInfo);
    String str = null;
    if (!bool)
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema is not ugCard");
      return null;
    }
    int i = ReadInJoySrtHandler.jdField_a_of_type_Int;
    ReadInJoySrtHandler localReadInJoySrtHandler = ReadInJoySrtHandler.a();
    bool = localReadInJoySrtHandler.a(paramAbsBaseArticleInfo, true, i);
    if (bool)
    {
      str = localReadInJoySrtHandler.a(paramAbsBaseArticleInfo, i, null, null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UGRuleManager getUGSchema ugUrl is ");
      localStringBuilder.append(str);
      QLog.d("ProteusSupportUtil", 1, localStringBuilder.toString());
    }
    localReadInJoySrtHandler.a(paramAbsBaseArticleInfo, bool, true, i);
    return str;
  }
  
  private static void a()
  {
    Object localObject = ((IRIJAdService)QRoute.api(IRIJAdService.class)).getProteusItems();
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        a(((Integer)localEntry.getKey()).intValue(), (ProteusItem)localEntry.getValue());
      }
    }
  }
  
  private static void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    TraceUtils.traceBegin("ProteusSupportUtil.bindView");
    if (paramContainer == null)
    {
      TraceUtils.traceEnd();
      return;
    }
    FluencyLogUtil.a("ProteusSupportUtil", "[bindView]");
    Object localObject = (ProteusItem)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      ((ProteusItem)localObject).a(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2);
      TraceUtils.traceEnd();
    }
    else
    {
      paramContainer = paramContainer.getVirtualView();
      if (paramInt1 != 10)
      {
        if (paramInt1 != 34)
        {
          switch (paramInt1)
          {
          default: 
            break;
          }
        }
        else
        {
          localObject = (AvatarView)paramContainer.findViewBaseByName("id_info_avator");
          if (localObject != null) {
            ((AvatarView)localObject).a(paramIReadInJoyModel);
          }
          localObject = (SummaryView)paramContainer.findViewBaseByName("id_summary");
          if (localObject != null) {
            ((SummaryView)localObject).a(paramIReadInJoyModel);
          }
          localObject = (BiuCommentView)paramContainer.findViewBaseByName("id_biu_comment");
          if (localObject != null) {
            ((BiuCommentView)localObject).a(paramIReadInJoyModel);
          }
          paramContainer = (GridImageView)paramContainer.findViewBaseByName("id_multi_image");
          if (paramContainer != null) {
            paramContainer.a(paramIReadInJoyModel.a());
          }
        }
      }
      else
      {
        localObject = (AvatarView)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((AvatarView)localObject).a(paramIReadInJoyModel);
        }
        localObject = (SummaryView)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((SummaryView)localObject).a(paramIReadInJoyModel);
        }
        localObject = (BiuCommentView)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((BiuCommentView)localObject).a(paramIReadInJoyModel);
        }
        paramContainer = (CornerTextImageView)paramContainer.findViewBaseByName("id_corner_text_image");
        if (paramContainer != null) {
          paramContainer.a(paramIReadInJoyModel);
        }
      }
    }
    TraceUtils.traceEnd();
  }
  
  private static void a(int paramInt, ProteusItem paramProteusItem)
  {
    if (paramProteusItem != null)
    {
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramProteusItem);
      return;
    }
    throw new NullPointerException();
  }
  
  public static void a(int paramInt, ProteusItemView paramProteusItemView, VafContext paramVafContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Container localContainer = paramProteusItemView.a();
    ViewFactory.findClickableViewListener(localContainer.getVirtualView(), new ProteusSupportUtil.2(paramInt, localContainer, paramIReadInJoyModel, paramAbsBaseArticleInfo, paramVafContext, paramProteusItemView, paramIFaceDecoder, paramReadInJoyBaseAdapter));
  }
  
  public static void a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    a(paramTemplateBean, paramViewBase, "click_T");
  }
  
  public static void a(TemplateBean paramTemplateBean, ViewBase paramViewBase, String paramString)
  {
    if (paramTemplateBean != null)
    {
      if (paramViewBase == null) {
        return;
      }
      RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
      String str = (String)paramTemplateBean.getDataAttribute(paramViewBase.getName(), paramString);
      if (str == null)
      {
        QLog.d("ProteusSupportUtil", 2, "reportDataAttrInfo bigT is null");
        return;
      }
      paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getName());
      if (paramTemplateBean != null)
      {
        paramTemplateBean = paramTemplateBean.entrySet().iterator();
        while (paramTemplateBean.hasNext())
        {
          Object localObject = (Map.Entry)paramTemplateBean.next();
          paramViewBase = (String)((Map.Entry)localObject).getKey();
          localObject = ((Map.Entry)localObject).getValue();
          if (!TextUtils.equals(paramViewBase, paramString)) {
            localReportR5Builder.addStringNotThrow(paramViewBase, localObject.toString());
          }
        }
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", str, str, 0, 0, "", "", "", localReportR5Builder.build(), false);
    }
  }
  
  public static void a(ViewBean paramViewBean)
  {
    if (paramViewBean == null) {
      return;
    }
    paramViewBean = paramViewBean.getDynamicValue("setProteusReportInfo:");
    if ((paramViewBean instanceof JSONObject)) {
      try
      {
        JSONObject localJSONObject = (JSONObject)paramViewBean;
        paramViewBean = localJSONObject.getString("click_T");
        localJSONObject = localJSONObject.getJSONObject("info");
        RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localReportR5Builder.addStringNotThrow(str, localJSONObject.get(str).toString());
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramViewBean, paramViewBean, 0, 0, "", "", "", localReportR5Builder.build(), false);
        return;
      }
      catch (Exception paramViewBean)
      {
        QLog.d("ProteusSupportUtil", 1, paramViewBean, new Object[] { "" });
      }
    }
  }
  
  public static void a(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    if (paramTemplateBean2 == null)
    {
      QLog.d("ProteusSupportUtil", 1, new Object[] { "[bindDynamicValueWithoutRecursion", "newTemplateBean == null", "return" });
      return;
    }
    TraceUtils.traceBegin("ProteusSupportUtil.bindDynamicValueWithoutRecursion");
    long l = System.currentTimeMillis();
    Map localMap1 = paramContainer.getViewIdMapping();
    Map localMap2 = paramTemplateBean2.getViewDataBinding();
    HashSet localHashSet = new HashSet();
    if (paramTemplateBean1 != null) {
      paramContainer = paramTemplateBean1.getViewDataBinding();
    } else {
      paramContainer = null;
    }
    if (localMap1 != null) {
      localHashSet.addAll(localMap1.keySet());
    }
    localHashSet.removeAll(localMap2.keySet());
    StringBuilder localStringBuilder = new StringBuilder("bindDynamicValueWithoutRecursion: ");
    Iterator localIterator = localMap2.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ViewBean localViewBean = (ViewBean)localMap2.get(str);
      if (paramContainer != null) {
        paramTemplateBean1 = (ViewBean)paramContainer.get(str);
      } else {
        paramTemplateBean1 = null;
      }
      ViewBase localViewBase;
      if (localMap1 != null) {
        localViewBase = (ViewBase)localMap1.get(str);
      } else {
        localViewBase = null;
      }
      TraceUtils.traceBegin("bindDynamicValueWithoutRecursion.bindDynamicVal.check");
      int i;
      if ((str != null) && (localViewBase != null) && (localViewBean != null) && ((paramTemplateBean1 == null) || (!localViewBean.valueBean.dynamicValue.equals(paramTemplateBean1.valueBean.dynamicValue)))) {
        i = 1;
      } else {
        i = 0;
      }
      TraceUtils.traceEnd();
      if (i != 0)
      {
        localViewBean.setVisible(true);
        localViewBase.bindDynamicValue(localViewBean);
        TraceUtils.traceEnd();
        localStringBuilder.append("[bindNewValue] bind dynamicValue: ");
        localStringBuilder.append(localViewBean.valueBean.dynamicValue);
        localStringBuilder.append(" viewId = ");
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      else if ((QLog.isColorLevel()) && (localViewBean != null))
      {
        localStringBuilder.append("skip: ");
        localStringBuilder.append(localViewBean.valueBean.dynamicValue);
        localStringBuilder.append(" viewId = ");
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
      }
      if (localViewBase != null) {
        localViewBase.setVisibility(0);
      }
      TraceUtils.traceEnd();
    }
    QLog.i("ProteusSupportUtil", 1, localStringBuilder.toString());
    paramContainer = localHashSet.iterator();
    while (paramContainer.hasNext())
    {
      paramTemplateBean1 = (ViewBase)localMap1.get((String)paramContainer.next());
      if (paramTemplateBean1 != null) {
        paramTemplateBean1.setVisibility(8);
      }
    }
    if (QLog.isColorLevel())
    {
      paramContainer = new StringBuilder();
      paramContainer.append("bindDynamicValueWithoutRecursion_____ ");
      paramContainer.append(paramTemplateBean2.getStyleName());
      paramContainer.append(" cost ");
      paramContainer.append(System.currentTimeMillis() - l);
      paramContainer.append("ms");
      QLog.d("ProteusSupportUtil", 2, paramContainer.toString());
    }
    TraceUtils.traceEnd();
  }
  
  public static void a(Container paramContainer, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new ProteusSupportUtil.1(paramVafContext, paramTemplateBean));
  }
  
  public static void a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel, TemplateBean paramTemplateBean)
  {
    if (DividerConfigUtils.a(paramContainer, paramIReadInJoyModel)) {
      return;
    }
    ViewBase localViewBase1 = paramContainer.getVirtualView();
    ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_separator");
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
    if ((localAbsBaseArticleInfo != null) && (localViewBase2 != null))
    {
      Layout.Params localParams = localViewBase2.getComLayoutParams();
      int k = localParams.mLayoutHeight;
      int j = Utils.dp2px(5.0D);
      Utils.dp2px(6.0D);
      int i = paramIReadInJoyModel.d();
      int m = paramIReadInJoyModel.e();
      if (localAbsBaseArticleInfo.mChannelID == 70L)
      {
        TraceUtils.traceBegin("configDivider.FollowFeeds");
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
        i = Utils.dp2px(5.0D);
        TraceUtils.traceEnd();
      }
      else if (DailyModeConfigHandler.c((int)localAbsBaseArticleInfo.mChannelID))
      {
        TraceUtils.traceBegin("configDivider.DailyFeeds");
        paramIReadInJoyModel = paramIReadInJoyModel.b();
        if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mProteusTemplateBean != null) && (paramIReadInJoyModel.mProteusTemplateBean.getDataAttribute(null, "position_jump") != null)) {
          j = 1;
        } else {
          j = 0;
        }
        if (localAbsBaseArticleInfo.mProteusTemplateBean != null)
        {
          if (localAbsBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null, "position_jump") != null) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else {
          i = 0;
        }
        if (i != j)
        {
          localParams.mLayoutMarginLeft = 0;
          localParams.mLayoutMarginRight = 0;
          localParams.mLayoutWidth = -1;
          i = Utils.dp2px(5.0D);
        }
        for (;;)
        {
          break;
          i = b(paramTemplateBean);
          if (i == a(paramTemplateBean))
          {
            i = a(paramTemplateBean);
            j = Utils.dp2px(a(paramTemplateBean));
            localParams.mLayoutMarginRight = j;
            localParams.mLayoutMarginLeft = j;
            localParams.mLayoutWidth = -1;
          }
        }
        TraceUtils.traceEnd();
      }
      else if ((i != 29) && (i != 30) && (m != 29) && (m != 30))
      {
        if ((!a(paramIReadInJoyModel.b())) && (!a(paramIReadInJoyModel)))
        {
          if (a(i, m, paramIReadInJoyModel.b()))
          {
            TraceUtils.traceBegin("configDivider.normal");
            TraceUtils.traceBegin("configDivider.normal.getProteusSeparatorHeightPx");
            i = a(paramTemplateBean);
            TraceUtils.traceEnd();
            TraceUtils.traceBegin("configDivider.normal.getProteusSeparatorMarginLeftPx");
            double d = a(paramTemplateBean);
            TraceUtils.traceEnd();
            j = Utils.dp2px(d);
            localParams.mLayoutMarginRight = j;
            localParams.mLayoutMarginLeft = j;
            localParams.mLayoutWidth = -1;
            TraceUtils.traceEnd();
          }
          else
          {
            localParams.mLayoutMarginLeft = 0;
            localParams.mLayoutMarginRight = 0;
            localParams.mLayoutWidth = -1;
            i = j;
            if (!b(m))
            {
              a(paramIReadInJoyModel, localViewBase2);
              i = j;
            }
          }
        }
        else
        {
          localParams.mLayoutMarginLeft = 0;
          localParams.mLayoutMarginRight = 0;
          localParams.mLayoutWidth = -1;
          i = 0;
        }
      }
      else
      {
        i = a(paramTemplateBean);
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      localParams.mLayoutHeight = i;
      localViewBase2.setComLayoutParams(localParams);
      paramIReadInJoyModel = localViewBase1.getComLayoutParams();
      if (paramIReadInJoyModel.mLayoutHeight >= 0) {
        paramIReadInJoyModel.mLayoutHeight += i - k;
      }
      paramIReadInJoyModel = localViewBase1.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(paramIReadInJoyModel.mLayoutWidth, paramIReadInJoyModel.mLayoutHeight));
      return;
    }
    QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
  }
  
  private static void a(VafContext paramVafContext)
  {
    Object localObject = ((IRIJAdService)QRoute.api(IRIJAdService.class)).getProteusBuilders();
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        paramVafContext.getViewFactory().registerViewBuilder((String)localEntry.getKey(), (ViewBase.IBuilder)localEntry.getValue());
      }
    }
  }
  
  public static void a(VafContext paramVafContext, String paramString)
  {
    paramVafContext.setTemplateFactory(TemplateFactory.a(paramString, true));
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeButton", new ReadInJoyLikeButton.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAvatarView", new AvatarView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVariableImageContentView", new GridImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySummaryView", new SummaryView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCommentView", new ArticleCommentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuCommentView", new BiuCommentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("CornerTextImageView", new CornerTextImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyMiddleBodyView", new ReadInJoyMiddleBodyView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyUsersCommentView", new UsersCommentsView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyFriendsBiu", new ReadInJoyFriendsBiu.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyQARichView", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuButton", new ReadInJoyBiuButton.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCoordinateView", new ReadInJoyCoordinateView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySocializeRecommendFollowView", new ReadInJoySocializeRecommendFollowView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("UILabel", new ReadInjoyTextView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageView", new ReadInjoyImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("UIImageView", new ReadInjoyImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageIcon", new ReadInjoyAsynImageIcon.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusCollectionView", new RvPolymericContainer.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdVideoGuide", new ReadInJoyAdVideoCompleteGuide.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("PTSAvatarView", new CommentAvatarView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("QQAvatarView", new CommentAvatarView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentRichTextView", new CommentRichTextView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJRichTextView", new CommentContentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentLikeButton", new CommentLikeView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyExposeReplyCommentView", new ExposeReplyCommentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAwesomeCommentView", new ReadInJoyAwesomeCommentView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdLocationView", new ReadInJoyAdLocationView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusTickerView", new ProteusTickerView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyShareView", new ReadInJoyShareView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyApngImageView", new ReadInjoyApngImageView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyProgressView", new ReadInjoyProgressView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("RIJCommentLinksView", new PTSCommentLinkView.Builder());
    b();
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVideoView", new ReadInJoyVideoView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyGifView", new ReadInJoyGifView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusMarqueeLabel", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLinkClickableLabel", new ReadInjoyTextView.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLottieView", new ReadInJoyLottieView.Builder());
    a(paramVafContext);
  }
  
  public static void a(ViewBase paramViewBase, ViewBean paramViewBean)
  {
    if (paramViewBase != null)
    {
      paramViewBase.bindDynamicValue(paramViewBean);
      if ((paramViewBase instanceof Layout))
      {
        paramViewBase = ((Layout)paramViewBase).getSubViews();
        if ((paramViewBase != null) && (paramViewBean.children != null))
        {
          List localList = Arrays.asList(paramViewBean.children);
          int j = paramViewBase.size();
          if (localList.size() == j)
          {
            int i = 0;
            while (i < j)
            {
              a((ViewBase)paramViewBase.get(i), (ViewBean)localList.get(i));
              i += 1;
            }
          }
          if (QLog.isColorLevel())
          {
            paramViewBase = new StringBuilder();
            paramViewBase.append("bindDataImpl: fail to bind data for ");
            paramViewBase.append(paramViewBean.viewId);
            paramViewBase.append("due to ViewBean - ViewBase count mismatch");
            QLog.d("ProteusSupportUtil", 2, paramViewBase.toString());
          }
        }
      }
      FluencyLogUtil.a("ProteusSupportUtil", "[bindDynamicValue]");
    }
  }
  
  public static void a(IProteusItemView paramIProteusItemView, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, VafContext paramVafContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel, int paramInt2, String paramString)
  {
    Object localObject;
    if (LogUtils.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[bindData]  adapterViewType: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", data : ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
      LogUtils.a("ProteusSupportUtil", ((StringBuilder)localObject).toString());
    }
    TraceUtils.traceBegin("ProteusSupportUtil.bindData");
    long l1 = System.currentTimeMillis();
    if ((paramIProteusItemView != null) && (paramIProteusItemView.a() != null))
    {
      b(paramVafContext, paramString);
      localObject = paramIProteusItemView.a();
      TemplateBean localTemplateBean = a(paramVafContext, paramInt1, paramAbsBaseArticleInfo);
      if ((!a(paramIProteusItemView.a(), paramInt1)) && ((localObject == null) || (localTemplateBean == null) || (localTemplateBean.getId() == ((TemplateBean)localObject).getId())))
      {
        paramString = (String)localObject;
        if (localObject != null)
        {
          paramString = (String)localObject;
          if (localTemplateBean != null)
          {
            paramString = (String)localObject;
            if (((TemplateBean)localObject).getStyleName() != null)
            {
              paramString = (String)localObject;
              if (localTemplateBean.getStyleName() != null)
              {
                paramString = (String)localObject;
                if (localTemplateBean.getStyleName().equals(((TemplateBean)localObject).getStyleName())) {}
              }
            }
          }
        }
      }
      else
      {
        int j = -1;
        int i;
        if (localTemplateBean != null) {
          i = localTemplateBean.getId();
        } else {
          i = -1;
        }
        if (localObject != null) {
          j = ((TemplateBean)localObject).getId();
        }
        paramString = new StringBuilder();
        paramString.append("[bindData] trigger re-inflation, adapterViewType: ");
        paramString.append(paramInt1);
        paramString.append(" new id: ");
        paramString.append(i);
        paramString.append(" old id: ");
        paramString.append(j);
        QLog.i("ProteusSupportUtil", 1, paramString.toString());
        paramString = new StringBuilder();
        paramString.append("[bindData] trigger re-inflation, adapterViewType: ");
        paramString.append(paramInt1);
        paramString.append(" new id: ");
        paramString.append(i);
        paramString.append(" old id: ");
        paramString.append(j);
        FluencyLogUtil.a("ProteusSupportUtil", paramString.toString());
        paramString = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
        if (paramString != null)
        {
          paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841773));
          paramIProteusItemView.c();
          paramIProteusItemView.a(paramString);
          LogUtils.a(paramString.getVirtualView(), "ProteusSupportUtil");
          LogUtils.a(paramString, "ProteusSupportUtil");
        }
        paramAbsBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
        b();
        paramString = null;
      }
      localObject = paramIProteusItemView.a();
      paramIProteusItemView.setTemplateBean(localTemplateBean);
      paramIProteusItemView.setModel(paramIReadInJoyModel, paramReadInJoyBaseAdapter.a().a());
      TraceUtils.traceBegin("ProteusSupportUtil.bindDataImpl");
      if (localTemplateBean != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[bindData] bind data for ");
        localStringBuilder.append(localTemplateBean.getStyleName());
        QLog.i("ProteusSupportUtil", 1, localStringBuilder.toString());
        a((Container)localObject, paramString, localTemplateBean);
      }
      else
      {
        QLog.d("ProteusSupportUtil", 2, "[bindData] newTemplateBean is null");
      }
      TraceUtils.traceEnd();
      a(paramInt1, (Container)localObject, paramIReadInJoyModel, paramInt2);
      a(paramInt1, (ProteusItemView)paramIProteusItemView, paramVafContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramAbsBaseArticleInfo);
      TraceUtils.traceBegin("ProteusSupportUtil.configDivider");
      a(paramIReadInJoyModel, paramVafContext);
      a((Container)localObject, paramIReadInJoyModel, localTemplateBean);
      TraceUtils.traceEnd();
      long l2 = System.currentTimeMillis();
      paramAbsBaseArticleInfo = (IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class);
      if (localTemplateBean != null) {
        paramIProteusItemView = localTemplateBean.getStyleName();
      } else {
        paramIProteusItemView = "";
      }
      paramAbsBaseArticleInfo.printCost("ProteusSupportUtil", paramIProteusItemView, " ProteusSupportUtil.bindData", l2 - l1);
      TraceUtils.traceEnd();
      return;
    }
    TraceUtils.traceEnd();
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(null, RIJBaseItemViewType.a(paramAbsBaseArticleInfo), paramAbsBaseArticleInfo);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo))
    {
      if (paramTemplateBean == null) {
        return;
      }
      String str = ReadinjoyReportUtils.b(paramAbsBaseArticleInfo.mChannelID);
      HashMap localHashMap = new HashMap();
      Map localMap = paramTemplateBean.getDataAttribute(null);
      paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
      if (localMap != null) {
        localHashMap.putAll(localMap);
      }
      if (paramTemplateBean != null) {
        localHashMap.putAll(paramTemplateBean);
      }
      ProteusReportUtil.a(paramAbsBaseArticleInfo, str, str, (int)paramAbsBaseArticleInfo.mChannelID, localHashMap);
      ProteusReportUtil.a(paramTemplateBean);
      ReadInJoyHelper.a(paramAbsBaseArticleInfo);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramViewBase != null))
    {
      if (paramTemplateBean == null) {
        return;
      }
      paramViewBase = paramTemplateBean.getDataAttribute(paramViewBase.getViewId()).get("rowkey");
      if ((paramViewBase instanceof String))
      {
        paramViewBase = (String)paramViewBase;
        if (!TextUtils.isEmpty(paramViewBase)) {
          paramAbsBaseArticleInfo.viewRowkey = paramViewBase;
        }
      }
    }
  }
  
  private static void a(IReadInJoyModel paramIReadInJoyModel, VafContext paramVafContext)
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)paramIReadInJoyModel.a();
    if (localReadInJoyBaseAdapter != null)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = localReadInJoyBaseAdapter.a(paramIReadInJoyModel.g() + 1);
      if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mProteusTemplateBean == null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("next.mProteusTemplateBean == null ");
        localStringBuilder.append(localAbsBaseArticleInfo);
        QLog.d("ProteusSupportUtil", 2, localStringBuilder.toString());
        if ((localReadInJoyBaseAdapter.a() != null) && (localReadInJoyBaseAdapter.a().a(paramIReadInJoyModel.e())))
        {
          localAbsBaseArticleInfo.mProteusTemplateBean = localReadInJoyBaseAdapter.a().a(localAbsBaseArticleInfo);
          return;
        }
        localAbsBaseArticleInfo.mProteusTemplateBean = a(paramVafContext, paramIReadInJoyModel.e(), localAbsBaseArticleInfo);
      }
    }
  }
  
  private static void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    if ((paramIReadInJoyModel != null) && (paramViewBase != null) && (paramViewBase.getNativeView() != null))
    {
      paramIReadInJoyModel = paramIReadInJoyModel.b();
      if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mProteusTemplateBean != null))
      {
        paramIReadInJoyModel = (ViewBean)paramIReadInJoyModel.mProteusTemplateBean.getViewDataBinding().get("id_separator");
        if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.valueBean != null) && (paramIReadInJoyModel.valueBean.normalValue != null))
        {
          paramIReadInJoyModel = paramIReadInJoyModel.valueBean.normalValue.get("setBackgroundColorString:");
          if ((paramIReadInJoyModel instanceof String)) {
            try
            {
              paramViewBase.getNativeView().setBackgroundColor(Color.parseColor((String)paramIReadInJoyModel));
              return;
            }
            catch (Exception paramIReadInJoyModel)
            {
              QLog.d("ProteusSupportUtil", 1, paramIReadInJoyModel.getMessage());
            }
          }
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (!ProteusSettingUtil.a()) {
      return false;
    }
    if ((paramInt != 0) && (paramInt != 5) && (paramInt != 29) && (paramInt != 47) && (paramInt != 60) && (paramInt != 96) && (paramInt != 90) && (paramInt != 91) && (paramInt != 124) && (paramInt != 125) && (paramInt != 129) && (paramInt != 130)) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdProteusView(paramInt)) {
            return false;
          }
          return jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
        }
        break;
      }
    }
    return true;
  }
  
  public static boolean a(int paramInt1, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TraceUtils.traceBegin("configDivider.isDividerNormal");
    boolean bool;
    if ((b(paramInt1)) && ((b(paramInt2)) || (PTSLiteItemViewUtil.a.a(paramAbsBaseArticleInfo, paramInt2) == 0))) {
      bool = true;
    } else {
      bool = false;
    }
    TraceUtils.traceEnd();
    return bool;
  }
  
  private static boolean a(Container paramContainer, int paramInt)
  {
    if (Aladdin.getConfig(330).getIntegerFromString("isAllowLayoutErrorCheck", 0) != 1) {
      return false;
    }
    if (paramContainer != null) {}
    label299:
    for (;;)
    {
      try
      {
        int j = paramContainer.getChildCount();
        int i = 0;
        if (i < j)
        {
          Object localObject2 = paramContainer.getChildAt(i);
          if (!(localObject2 instanceof NativeLayoutImpl)) {
            break label299;
          }
          localObject1 = (NativeLayoutImpl)localObject2;
          if ((((NativeLayoutImpl)localObject1).getChildCount() != 0) || (((NativeLayoutImpl)localObject1).getBackgroundColor() != 0)) {
            break label299;
          }
          IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
          if (((NativeLayoutImpl)localObject1).getContentDescription() != null)
          {
            localObject1 = ((NativeLayoutImpl)localObject1).getContentDescription().toString();
            localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(localQQAppInterface, "CliOper", "", "", "0X8009AC1", "0X8009AC1", 0, 0, "", "", "", (String)localObject1, false);
            if (QLog.isColorLevel())
            {
              LogUtils.a(paramContainer.getVirtualView(), "ProteusSupportUtil");
              LogUtils.a(paramContainer, "ProteusSupportUtil");
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[nativeLayoutImplError] empty native layout ");
            ((StringBuilder)localObject1).append(paramInt);
            QLog.e("ProteusSupportUtil", 1, ((StringBuilder)localObject1).toString());
            if ((QLog.isColorLevel()) && ((localObject2 instanceof ViewGroup)))
            {
              localObject1 = (ViewGroup)localObject2;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("ChildCount ");
              ((StringBuilder)localObject2).append(((ViewGroup)localObject1).getChildCount());
              QLog.e("ProteusSupportUtil", 1, ((StringBuilder)localObject2).toString());
            }
            i += 1;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramContainer)
      {
        QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] ", paramContainer);
      }
      Object localObject1 = "";
    }
  }
  
  public static boolean a(VafContext paramVafContext, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return a(paramVafContext, paramInt, paramAbsBaseArticleInfo) != null;
  }
  
  public static boolean a(VafContext paramVafContext, String paramString)
  {
    paramString = TemplateFactory.a(paramString, true);
    if (paramVafContext.getTemplateFactory() == null)
    {
      paramVafContext.setTemplateFactory(paramString);
      return true;
    }
    if ((paramString != null) && (paramString.getTemplateId() != paramVafContext.getTemplateFactory().getTemplateId()))
    {
      paramVafContext.setTemplateFactory(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TraceUtils.traceBegin("configDivider.isNextCardFlowGuideTwoOrThree");
    boolean bool1 = false;
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData)))
    {
      if (paramAbsBaseArticleInfo.mFeedType != 29)
      {
        TraceUtils.traceEnd();
        return false;
      }
      try
      {
        paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
        Iterator localIterator = paramAbsBaseArticleInfo.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject = paramAbsBaseArticleInfo.opt(str);
          if ("guide_card_type".equals(str))
          {
            QLog.d("ProteusSupportUtil", 1, new Object[] { "isNextCardFlowGuideTwoOrThree, guide_card_type = ", localObject });
            TraceUtils.traceEnd();
            if (!"2".equals(String.valueOf(localObject)))
            {
              boolean bool2 = "3".equals(String.valueOf(localObject));
              if (!bool2) {}
            }
            else
            {
              bool1 = true;
            }
            return bool1;
          }
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardFlowGuideTwoOrThree, e = ", paramAbsBaseArticleInfo);
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardFlowGuideTwoOrThree JSONException, e = ", paramAbsBaseArticleInfo);
      }
    }
    TraceUtils.traceEnd();
    return false;
  }
  
  private static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ViewBase paramViewBase, VafContext paramVafContext)
  {
    boolean bool = paramAbsBaseArticleInfo instanceof AdvertisementInfo;
    if ((paramViewBase == null) || (paramVafContext == null) || (paramVafContext.getContext() == null) || (paramAbsBaseArticleInfo == null)) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(IReadInJoyModel paramIReadInJoyModel)
  {
    boolean bool = false;
    if (paramIReadInJoyModel != null) {
      try
      {
        int i = paramIReadInJoyModel.e();
        if ((i == 66) || (i == 39))
        {
          paramIReadInJoyModel = paramIReadInJoyModel.b();
          if ((paramIReadInJoyModel != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramIReadInJoyModel)))
          {
            paramIReadInJoyModel = ((AdvertisementInfo)paramIReadInJoyModel).mAdExtInfo;
            if (paramIReadInJoyModel != null)
            {
              i = new JSONObject(paramIReadInJoyModel).optInt("is_video_new");
              if (i == 1) {
                bool = true;
              }
              return bool;
            }
          }
        }
      }
      catch (Exception paramIReadInJoyModel)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardAdBigImgOrAdVideo JSONException, e = ", paramIReadInJoyModel);
      }
    }
    return false;
  }
  
  private static int b(TemplateBean paramTemplateBean)
  {
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {
      try
      {
        paramTemplateBean = (SizeValue)paramTemplateBean.getViewBean().findViewById("id_separator").valueBean.normalValue.get("height");
        FluencyLogUtil.a("ProteusSupportUtil", "[getSepatatorHeight] getSepatatorHeight");
        int i = paramTemplateBean.getLayoutSize();
        return i;
      }
      catch (Exception paramTemplateBean)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorHeight exception.");
      }
    }
    return 0;
  }
  
  private static void b()
  {
    FluencyLogUtil.a("ProteusSupportUtil", "resetProteusSeparatorHeightPx ");
    QLog.d("TemplateFactory", 4, "resetProteusSeparatorHeightPx");
    jdField_a_of_type_Int = 0;
  }
  
  private static void b(VafContext paramVafContext, String paramString)
  {
    paramString = TemplateFactory.a(paramString, false);
    if ((paramString != null) && (paramVafContext.getTemplateFactory() != paramString)) {
      paramVafContext.setTemplateFactory(paramString);
    }
  }
  
  public static boolean b(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt))) {
      return true;
    }
    return paramInt >= 151;
  }
  
  @Deprecated
  private static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, ViewBase paramViewBase, VafContext paramVafContext)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo != null) {
      if (paramInt != 1007)
      {
        bool1 = bool2;
        if (paramInt == 1036) {
          break label235;
        }
        if (paramInt != 1071)
        {
          if (paramInt != 1106)
          {
            bool1 = bool2;
            if (paramInt == 1175) {
              break label235;
            }
            bool1 = bool2;
            if (paramInt == 1176) {
              break label235;
            }
            if ((paramInt != 1200) && (paramInt != 1201)) {
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  }
                  break;
                }
                break;
              case 1045: 
                return ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(paramAbsBaseArticleInfo);
              }
            }
          }
          return a(paramAbsBaseArticleInfo, paramViewBase, paramVafContext);
        }
        else
        {
          return ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo);
        }
      }
      else if (!RIJFeedsType.j(paramAbsBaseArticleInfo))
      {
        bool1 = bool2;
        if (!RIJFeedsType.k(paramAbsBaseArticleInfo)) {
          break label235;
        }
      }
    }
    boolean bool1 = true;
    label235:
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil
 * JD-Core Version:    0.7.0.1
 */