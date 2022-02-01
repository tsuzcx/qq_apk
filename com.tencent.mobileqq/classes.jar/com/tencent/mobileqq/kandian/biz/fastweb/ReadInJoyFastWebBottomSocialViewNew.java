package com.tencent.mobileqq.kandian.biz.fastweb;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CommentReportR5Builder;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils.Companion;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebDislikeUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.RIJCoinAnimationUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.RIJUniteReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Callback;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Companion;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.RIJRewardData;
import com.tencent.mobileqq.kandian.biz.share.KandianFavoriteBroadcastReceiver;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentGuideConfigHandler;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class ReadInJoyFastWebBottomSocialViewNew
  extends FrameLayout
{
  public static final String a;
  public static final String b;
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TemplateBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private Share jdField_a_of_type_ComTencentBizWebviewpluginShare;
  ReadInJoyAtlasManager.AtlasCallback jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallback = new ReadInJoyFastWebBottomSocialViewNew.6(this);
  private GuidePopuppWindow jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow;
  private ReadInJoyFastWebBottomSocialViewNew.DoShareClick jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew$DoShareClick = null;
  private ReadInJoyFastWebBottomSocialViewNew.OnOpenCommentEditListener jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew$OnOpenCommentEditListener;
  RIJVideoRewardCoinManager.Callback jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Callback = new ReadInJoyFastWebBottomSocialViewNew.9(this);
  private RIJVideoRewardCoinManager jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver;
  private IUserLevelCallBack jdField_a_of_type_ComTencentMobileqqKandianRepoAccountIUserLevelCallBack;
  private final ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyFastWebBottomSocialViewNew.11(this);
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private FastWebArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712780);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131712960);
  }
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return "3";
    }
    return "1";
  }
  
  private void a(int paramInt, Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    f(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    paramAbsBaseArticleInfo = RIJUserLevelModule.getInstance();
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo.doActionsByUserLevel(paramContext, paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianRepoAccountIUserLevelCallBack);
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
    ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "native_article");
  }
  
  private void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew$OnOpenCommentEditListener;
    if (((localObject == null) || (!((ReadInJoyFastWebBottomSocialViewNew.OnOpenCommentEditListener)localObject).a())) && ((paramContext instanceof Activity))) {
      ReadInJoyCommentUtils.a((Activity)paramContext, paramAbsBaseArticleInfo, null, 4, "", null, false, null, -1);
    }
    localObject = new ReadInJoyCommentUtils.CommentReportR5Builder(paramAbsBaseArticleInfo, null).a(1).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(RIJQQAppInterfaceUtil.a(), ReadInJoyCommentUtils.a(paramAbsBaseArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(paramAbsBaseArticleInfo.mArticleID), String.valueOf(paramAbsBaseArticleInfo.mStrategyId), paramAbsBaseArticleInfo.innerUniqueID, (String)localObject, false);
    int i = (int)paramAbsBaseArticleInfo.mChannelID;
    if (paramFastWebArticleInfo.a()) {
      paramFastWebArticleInfo = "2";
    } else {
      paramFastWebArticleInfo = "1";
    }
    ReportUtil.a(paramAbsBaseArticleInfo, "0X8008990", RIJTransMergeKanDianReport.a(paramContext, paramAbsBaseArticleInfo, i, paramFastWebArticleInfo).toString());
  }
  
  private void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
    }
    if ((paramContext != null) && (paramFastWebArticleInfo != null))
    {
      int i = BiuBehaviour.b();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      a(bool, paramContext, paramFastWebArticleInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      i = (int)((AbsBaseArticleInfo)localObject).mChannelID;
      if (paramFastWebArticleInfo.a()) {
        paramContext = "2";
      } else {
        paramContext = "1";
      }
      ReportUtil.a((AbsBaseArticleInfo)localObject, "0X8008991", RIJTransMergeKanDianReport.a(localContext, (AbsBaseArticleInfo)localObject, i, paramContext, 0).toString());
    }
  }
  
  private void a(ViewBase paramViewBase)
  {
    FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X8009A5A", a());
  }
  
  private void a(ViewBase paramViewBase, int paramInt)
  {
    paramViewBase = FastWebPTSUtils.b(paramViewBase, paramInt);
    if ((paramViewBase instanceof TextView)) {
      ((TextView)paramViewBase).setText(FastWebPTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_e_of_type_Int, HardCodeUtil.a(2131718309)));
    }
    if (paramInt == 6)
    {
      setData(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      return;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FastWebActivity)) {
      f();
    }
  }
  
  private void a(ViewBase paramViewBase, Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramViewBase == null) {
      return;
    }
    paramViewBase = paramViewBase.findViewBaseByName("id_biu");
    if (paramViewBase != null)
    {
      paramViewBase = paramViewBase.getNativeView();
      if (paramViewBase != null) {
        paramViewBase.setOnLongClickListener(new ReadInJoyFastWebBottomSocialViewNew.8(this, paramContext, paramFastWebArticleInfo));
      }
    }
  }
  
  private void a(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    a(FastWebPTSUtils.a(paramViewBase, paramInt), paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramInt);
  }
  
  private void a(UserLevelInfo paramUserLevelInfo, Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramUserLevelInfo == null) {
      return;
    }
    int i = paramUserLevelInfo.currentOpType;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        h(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
        return;
      }
      j(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
      return;
    }
    g(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallback);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.fav");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver, (IntentFilter)localObject);
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(paramAbsBaseArticleInfo.innerUniqueID);
    ReadInJoyAtlasManager.getInstance().getAtlasFavoriteStatus((List)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallback);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    int i;
    if (this.jdField_c_of_type_Int == 5) {
      i = 2;
    } else if (paramFastWebArticleInfo.jdField_c_of_type_Boolean) {
      i = 1;
    } else {
      i = 3;
    }
    RIJUniteReportUtils.a.a("0X800BAFF", paramAbsBaseArticleInfo, paramInt, "click_type", Integer.valueOf(i));
  }
  
  private void a(ProteusItemData paramProteusItemData, Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (!a()) {
      return;
    }
    ViewBase localViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView();
    ViewFactory.findClickableViewListener(localViewBase, new ReadInJoyFastWebBottomSocialViewNew.1(this, paramProteusItemData, paramContext));
    a(localViewBase, paramContext, paramFastWebArticleInfo);
  }
  
  private void a(ProteusItemData paramProteusItemData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramProteusItemData != null)
    {
      if (paramProteusItemData.c == null) {
        return;
      }
      if (paramProteusItemData.c.has("like_normalstate_image")) {
        FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X80099DA", a());
      }
      if (paramProteusItemData.c.has("coin_img_status"))
      {
        paramProteusItemData = RIJVideoRewardCoinManager.a;
        String str = paramFastWebArticleInfo.j;
        int i;
        if (paramFastWebArticleInfo.jdField_e_of_type_Boolean) {
          i = 3;
        } else {
          i = 1;
        }
        paramProteusItemData.a("0X800B2EA", new RIJVideoRewardCoinManager.RIJRewardData(str, i), 7);
      }
      FastWebDislikeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramFastWebArticleInfo, 1);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.bindData(paramJSONObject);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean.getViewBean());
      return;
    }
    catch (Exception paramJSONObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refresh error!  msg=");
      localStringBuilder.append(paramJSONObject);
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, localStringBuilder.toString());
    }
  }
  
  private void a(boolean paramBoolean, Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    RIJSocialBottomUtils.a.a(18, 0, paramBoolean, paramContext, 2002, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(new ReadInJoyFastWebBottomSocialViewNew.7(this, paramBoolean, paramString));
  }
  
  private void a(boolean paramBoolean, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      FastWebPTSUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, paramBoolean, this.jdField_b_of_type_AndroidViewView, RIJVideoRewardCoinManager.a.a(paramInt1));
      RIJCoinAnimationUtils.a.a(this.jdField_b_of_type_AndroidViewView, "https://pub.idqqimg.com/pc/misc/files/20210202/54fa2ff5d2124007bcd6a11c95ce1f08.png", 1);
      QQToast.a(BaseApplicationImpl.getContext(), 2, paramString, 0).a();
      a(null, paramInt2);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramString, 0).a();
  }
  
  private boolean a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
    Object localObject1 = "";
    boolean bool;
    if (localObject2 == null)
    {
      bool = false;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("mContentView is null!");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      bool = true;
    }
    if (!bool)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isParamsValidity error!  msg=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, ((StringBuilder)localObject2).toString());
    }
    return bool;
  }
  
  private boolean a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    if (!(paramContext instanceof Activity)) {
      return false;
    }
    paramContext = (Activity)paramContext;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow = new GuidePopuppWindow(paramContext, paramAbsBaseArticleInfo);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(paramAbsBaseArticleInfo.innerUniqueID)) && (CommentGuideConfigHandler.b()))
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = ((ViewStub)paramContext.findViewById(2131376073)).inflate();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(new ReadInJoyFastWebBottomSocialViewNew.4(this, paramOnGuideDismissListener));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(paramAbsBaseArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(paramContext.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void b(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager == null)
    {
      if (!(paramContext instanceof Activity)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager = new RIJVideoRewardCoinManager((Activity)paramContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager$Callback);
    }
  }
  
  private void b(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramContext instanceof FastWebActivity))
    {
      ((FastWebActivity)paramContext).a(false, true);
    }
    else if (this.jdField_a_of_type_Boolean)
    {
      ReadInJoyFastWebBottomSocialViewNew.DoShareClick localDoShareClick = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew$DoShareClick;
      if (localDoShareClick != null) {
        localDoShareClick.a(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
      }
    }
    FastWebDislikeUtils.a(paramAbsBaseArticleInfo, "0X8009A5B", a());
  }
  
  private void c() {}
  
  private void c(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (1 == this.jdField_b_of_type_Int)
    {
      QQToast.a(paramContext, 1, 2131717791, 0).a();
      return;
    }
    g(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  private void d() {}
  
  private void d(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    h(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  private void e() {}
  
  private void e(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    a(2, paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  private void f()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(new ReadInJoyFastWebBottomSocialViewNew.10(this));
  }
  
  private void f(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoAccountIUserLevelCallBack == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoAccountIUserLevelCallBack = new ReadInJoyFastWebBottomSocialViewNew.2(this, paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    }
  }
  
  private void g(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramContext != null) && (paramAbsBaseArticleInfo != null))
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        RIJSocialBottomUtils.a.a(paramContext, paramAbsBaseArticleInfo, true);
        return;
      }
      if (a(paramContext, paramAbsBaseArticleInfo, new ReadInJoyFastWebBottomSocialViewNew.3(this, paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo))) {
        return;
      }
      a(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    }
  }
  
  private void h(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null)
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 2, "like click event failed");
      return;
    }
    if (paramFastWebArticleInfo.jdField_a_of_type_Boolean)
    {
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = false;
      paramFastWebArticleInfo.jdField_a_of_type_Int -= 1;
      ReportUtil.b(paramAbsBaseArticleInfo, "0X8009765", a());
    }
    else
    {
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = true;
      paramFastWebArticleInfo.jdField_a_of_type_Int += 1;
      ReportUtil.b(paramAbsBaseArticleInfo, "0X8009764", a());
    }
    d();
    i(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    a(paramFastWebArticleInfo.jdField_a_of_type_Int);
    ReadInJoyLogicEngineEventDispatcher.a().e();
    ReadInJoyLogicEngine.a().a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramFastWebArticleInfo);
    if ((paramAbsBaseArticleInfo != null) && (paramFastWebArticleInfo.jdField_a_of_type_Boolean)) {
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(paramAbsBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_LOVE, 0, 0, 0), 5);
    }
    paramContext = RIJUniteReportUtils.a;
    int i;
    if (paramFastWebArticleInfo.jdField_a_of_type_Boolean) {
      i = 1;
    } else {
      i = 3;
    }
    paramContext.a(paramAbsBaseArticleInfo, 1, i);
  }
  
  private void i(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    setData(paramContext, paramFastWebArticleInfo, paramAbsBaseArticleInfo);
  }
  
  private void j(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
    }
    if ((paramAbsBaseArticleInfo != null) && (paramContext != null))
    {
      TimeSliceHelper.c(paramAbsBaseArticleInfo.innerUniqueID);
      int i = BiuBehaviour.a();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      a(bool, paramContext, paramFastWebArticleInfo);
      i = (int)paramAbsBaseArticleInfo.mChannelID;
      if (paramFastWebArticleInfo.a()) {
        paramFastWebArticleInfo = "2";
      } else {
        paramFastWebArticleInfo = "1";
      }
      ReportUtil.a(paramAbsBaseArticleInfo, "0X8008991", RIJTransMergeKanDianReport.a(paramContext, paramAbsBaseArticleInfo, i, paramFastWebArticleInfo, 0).toString());
    }
  }
  
  private void k(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if ((paramContext instanceof FastWebActivity))
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "enter scroll");
      ((FastWebActivity)paramContext).c();
      int i = (int)paramAbsBaseArticleInfo.mChannelID;
      if (paramFastWebArticleInfo.a()) {
        paramFastWebArticleInfo = "2";
      } else {
        paramFastWebArticleInfo = "1";
      }
      ReportUtil.a(paramAbsBaseArticleInfo, "0X8008990", RIJTransMergeKanDianReport.a(paramContext, paramAbsBaseArticleInfo, i, paramFastWebArticleInfo).toString());
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      RIJSocialBottomUtils.a.a(paramContext, paramAbsBaseArticleInfo, false);
      return;
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("scroll to history location failed cuz activity or articleinfo is null");
    paramAbsBaseArticleInfo.append(paramContext);
    if (paramAbsBaseArticleInfo.toString() == null) {
      paramContext = "activity is null";
    } else {
      paramContext = "";
    }
    QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, paramContext);
  }
  
  public Map<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("source_from", a());
    return localHashMap;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject != null)
    {
      KandianFavoriteBroadcastReceiver localKandianFavoriteBroadcastReceiver = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver;
      if (localKandianFavoriteBroadcastReceiver != null) {
        ((Context)localObject).unregisterReceiver(localKandianFavoriteBroadcastReceiver);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew$DoShareClick = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager;
    if (localObject != null) {
      ((RIJVideoRewardCoinManager)localObject).j();
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong)
  {
    ReadInJoyLogicEngineEventDispatcher.a().e();
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      return;
    }
    Share localShare = this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
    if (localShare != null) {
      localShare.destroy();
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(ReadInJoyUtils.a(), paramActivity);
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl, 9, false);
  }
  
  public void a(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramContext, paramFastWebArticleInfo, paramAbsBaseArticleInfo, 0);
  }
  
  public void a(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    setData(paramContext, paramFastWebArticleInfo, paramAbsBaseArticleInfo);
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    RIJVideoRewardCoinManager.Companion localCompanion = RIJVideoRewardCoinManager.a;
    String str = paramFastWebArticleInfo.j;
    int i;
    if (paramFastWebArticleInfo.jdField_e_of_type_Boolean) {
      i = 3;
    } else {
      i = 1;
    }
    localCompanion.a("0X800B2EB", new RIJVideoRewardCoinManager.RIJRewardData(str, i), paramInt);
    this.jdField_b_of_type_AndroidViewView = paramView;
    FastWebPTSUtils.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager, paramInt);
  }
  
  public void a(ReadInJoyFastWebBottomSocialViewNew.DoShareClick paramDoShareClick)
  {
    if (paramDoShareClick != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew$DoShareClick = paramDoShareClick;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    e();
  }
  
  public void setData(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ProteusItemData localProteusItemData;
    boolean bool;
    if ((paramContext != null) && (paramFastWebArticleInfo != null) && (paramAbsBaseArticleInfo != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo = paramFastWebArticleInfo;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      localProteusItemData = FastWebPTSDataConverter.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null) {
        a(paramContext);
      }
      bool = paramFastWebArticleInfo.c();
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Int == -1) || ((bool ^ true) != this.jdField_a_of_type_Int))
        {
          removeAllViews();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = localProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean);
          addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
          if (!paramFastWebArticleInfo.c()) {
            break label264;
          }
          i = 0;
          this.jdField_a_of_type_Int = i;
          setBackgroundColor(-1);
          a(localProteusItemData, paramFastWebArticleInfo);
          b(paramContext);
          ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setData error!  msg=");
        localStringBuilder.append(localException);
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, localStringBuilder.toString());
      }
      if (!a()) {
        return;
      }
      a(localProteusItemData.c);
      a(localProteusItemData, paramContext, paramFastWebArticleInfo);
      a(paramAbsBaseArticleInfo);
      setVisibility(0);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView());
      return;
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setData error!  params is null!");
      return;
      label264:
      int i = 1;
    }
  }
  
  public void setData(FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    setData(this.jdField_a_of_type_AndroidContentContext, paramFastWebArticleInfo, paramAbsBaseArticleInfo);
  }
  
  public void setFavoriteArticle(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    a(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramInt);
  }
  
  public void setIsWebBottomView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnOpenCommentEditListener(ReadInJoyFastWebBottomSocialViewNew.OnOpenCommentEditListener paramOnOpenCommentEditListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebReadInJoyFastWebBottomSocialViewNew$OnOpenCommentEditListener = paramOnOpenCommentEditListener;
  }
  
  public void setProteusContext(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew
 * JD-Core Version:    0.7.0.1
 */