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
import com.tencent.mobileqq.kandian.biz.comment.bean.CommentComponentArgs;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils;
import com.tencent.mobileqq.kandian.biz.common.RIJSocialBottomUtils.Companion;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebDislikeUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.RIJCoinAnimationUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.RIJUniteReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
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
  public static final String a = HardCodeUtil.a(2131910353);
  public static final String b = HardCodeUtil.a(2131910526);
  private boolean A;
  private final ReadInJoyObserver B = new ReadInJoyFastWebBottomSocialViewNew.11(this);
  ReadInJoyAtlasManager.AtlasCallback c = new ReadInJoyFastWebBottomSocialViewNew.6(this);
  RIJVideoRewardCoinManager.Callback d = new ReadInJoyFastWebBottomSocialViewNew.9(this);
  private VafContext e;
  private Container f;
  private TemplateBean g;
  private GuidePopuppWindow h;
  private View i;
  private BubblePopupWindow j;
  private int k = -1;
  private int l = 0;
  private boolean m = false;
  private IUserLevelCallBack n;
  private ReadInJoyFastWebBottomSocialViewNew.OnOpenCommentEditListener o;
  private ReadInJoyFastWebBottomSocialViewNew.DoShareClick p = null;
  private RIJVideoRewardCoinManager q;
  private View r;
  private int s = 0;
  private boolean t = false;
  private Share u;
  private KandianFavoriteBroadcastReceiver v;
  private HashMap<String, ArrayList<String>> w = new HashMap();
  private AbsBaseArticleInfo x;
  private FastWebArticleInfo y;
  private Context z;
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ReadInJoyFastWebBottomSocialViewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt, Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    f(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    paramAbsBaseArticleInfo = RIJUserLevelModule.getInstance();
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo.doActionsByUserLevel(paramContext, paramInt, this.n);
    }
  }
  
  private void a(Context paramContext)
  {
    this.e = new ReadInjoyContext();
    this.e.setContext(paramContext);
    ProteusSupportUtil.a(this.e, "native_article");
  }
  
  private void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    Object localObject = this.o;
    if (((localObject == null) || (!((ReadInJoyFastWebBottomSocialViewNew.OnOpenCommentEditListener)localObject).a())) && ((paramContext instanceof Activity)))
    {
      localObject = new CommentComponentArgs().a(paramAbsBaseArticleInfo).a(4).a("");
      ReadInJoyCommentUtils.a((Activity)paramContext, (CommentComponentArgs)localObject);
    }
    localObject = new ReadInJoyCommentUtils.CommentReportR5Builder(paramAbsBaseArticleInfo, null).a(1).a();
    PublicAccountReportUtils.a(RIJQQAppInterfaceUtil.a(), ReadInJoyCommentUtils.a(paramAbsBaseArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(paramAbsBaseArticleInfo.mArticleID), String.valueOf(paramAbsBaseArticleInfo.mStrategyId), paramAbsBaseArticleInfo.innerUniqueID, (String)localObject, false);
    int i1 = (int)paramAbsBaseArticleInfo.mChannelID;
    if (paramFastWebArticleInfo.a()) {
      paramFastWebArticleInfo = "2";
    } else {
      paramFastWebArticleInfo = "1";
    }
    ReportUtil.a(paramAbsBaseArticleInfo, "0X8008990", RIJTransMergeKanDianReport.a(paramContext, paramAbsBaseArticleInfo, i1, paramFastWebArticleInfo).toString());
  }
  
  private void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    Object localObject = this.j;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
      this.j.dismiss();
    }
    if ((paramContext != null) && (paramFastWebArticleInfo != null))
    {
      int i1 = BiuBehaviour.b();
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      a(bool, paramContext, paramFastWebArticleInfo);
      localObject = this.x;
      Context localContext = this.z;
      i1 = (int)((AbsBaseArticleInfo)localObject).mChannelID;
      if (paramFastWebArticleInfo.a()) {
        paramContext = "2";
      } else {
        paramContext = "1";
      }
      ReportUtil.a((AbsBaseArticleInfo)localObject, "0X8008991", RIJTransMergeKanDianReport.a(localContext, (AbsBaseArticleInfo)localObject, i1, paramContext, 0).toString());
    }
  }
  
  private void a(ViewBase paramViewBase)
  {
    FastWebDislikeUtils.a(this.x, "0X8009A5A", getReportParams());
  }
  
  private void a(ViewBase paramViewBase, int paramInt)
  {
    paramViewBase = FastWebPTSUtils.b(paramViewBase, paramInt);
    if ((paramViewBase instanceof TextView)) {
      ((TextView)paramViewBase).setText(FastWebPTSUtils.a(this.y.M, HardCodeUtil.a(2131915801)));
    }
    if (paramInt == 6)
    {
      setData(this.y, this.x);
      return;
    }
    if ((this.z instanceof FastWebActivity)) {
      g();
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
    int i1 = paramUserLevelInfo.currentOpType;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
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
    if (this.v == null)
    {
      this.v = new KandianFavoriteBroadcastReceiver(this.c);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.fav");
      this.z.registerReceiver(this.v, (IntentFilter)localObject);
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(paramAbsBaseArticleInfo.innerUniqueID);
    ReadInJoyAtlasManager.getInstance().getAtlasFavoriteStatus((List)localObject, this.c);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    int i1;
    if (this.s == 5) {
      i1 = 2;
    } else if (paramFastWebArticleInfo.z) {
      i1 = 1;
    } else {
      i1 = 3;
    }
    RIJUniteReportUtils.a.a("0X800BAFF", paramAbsBaseArticleInfo, paramInt, "click_type", Integer.valueOf(i1));
  }
  
  private void a(ProteusItemData paramProteusItemData, Context paramContext, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (!d()) {
      return;
    }
    ViewBase localViewBase = this.f.getVirtualView();
    ViewFactory.findClickableViewListener(localViewBase, new ReadInJoyFastWebBottomSocialViewNew.1(this, paramProteusItemData, paramContext));
    a(localViewBase, paramContext, paramFastWebArticleInfo);
  }
  
  private void a(ProteusItemData paramProteusItemData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramProteusItemData != null)
    {
      if (paramProteusItemData.bb == null) {
        return;
      }
      if (paramProteusItemData.bb.has("like_normalstate_image")) {
        FastWebDislikeUtils.a(this.x, "0X80099DA", getReportParams());
      }
      if (paramProteusItemData.bb.has("coin_img_status"))
      {
        paramProteusItemData = RIJVideoRewardCoinManager.a;
        String str = paramFastWebArticleInfo.q;
        int i1;
        if (paramFastWebArticleInfo.N) {
          i1 = 3;
        } else {
          i1 = 1;
        }
        paramProteusItemData.a("0X800B2EA", new RIJVideoRewardCoinManager.RIJRewardData(str, i1), 7);
      }
      FastWebDislikeUtils.a(this.x, paramFastWebArticleInfo, 1);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    try
    {
      this.g.bindData(paramJSONObject);
      ProteusSupportUtil.a(this.f.getVirtualView(), this.g.getViewBean());
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
    RIJSocialBottomUtils.a.a(18, 0, paramBoolean, paramContext, 2002, this.x, paramFastWebArticleInfo);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(new ReadInJoyFastWebBottomSocialViewNew.7(this, paramBoolean, paramString));
  }
  
  private void a(boolean paramBoolean, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      FastWebPTSUtils.a(this.y, paramBoolean, this.r, RIJVideoRewardCoinManager.a.a(paramInt1));
      RIJCoinAnimationUtils.a.a(this.r, "https://pub.idqqimg.com/pc/misc/files/20210202/54fa2ff5d2124007bcd6a11c95ce1f08.png", 1);
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, paramString, 0).show();
      a(null, paramInt2);
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 1, paramString, 0).show();
  }
  
  private boolean a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    if (!(paramContext instanceof Activity)) {
      return false;
    }
    paramContext = (Activity)paramContext;
    if (this.h == null) {
      this.h = new GuidePopuppWindow(paramContext, paramAbsBaseArticleInfo);
    }
    if ((!this.h.a(paramAbsBaseArticleInfo.innerUniqueID)) && (CommentGuideConfigHandler.b()))
    {
      if (this.i == null) {
        this.i = ((ViewStub)paramContext.findViewById(2131444273)).inflate();
      }
      this.h.a(new ReadInJoyFastWebBottomSocialViewNew.4(this, paramOnGuideDismissListener));
      this.i.setVisibility(0);
      this.h.a(paramAbsBaseArticleInfo);
      this.h.a(paramContext.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void b(Context paramContext)
  {
    if (this.q == null)
    {
      if (!(paramContext instanceof Activity)) {
        return;
      }
      this.q = new RIJVideoRewardCoinManager((Activity)paramContext, this.d);
    }
  }
  
  private void b(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramContext instanceof FastWebActivity))
    {
      ((FastWebActivity)paramContext).a(false, true);
    }
    else if (this.m)
    {
      ReadInJoyFastWebBottomSocialViewNew.DoShareClick localDoShareClick = this.p;
      if (localDoShareClick != null) {
        localDoShareClick.a(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
      }
    }
    FastWebDislikeUtils.a(paramAbsBaseArticleInfo, "0X8009A5B", getReportParams());
  }
  
  private void c() {}
  
  private void c(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (1 == this.l)
    {
      QQToast.makeText(paramContext, 1, 2131915266, 0).show();
      return;
    }
    g(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  private void d(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    h(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  private boolean d()
  {
    Object localObject2 = this.f;
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
  
  private void e() {}
  
  private void e(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    a(2, paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  private void f() {}
  
  private void f(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.n == null) {
      this.n = new ReadInJoyFastWebBottomSocialViewNew.2(this, paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    }
  }
  
  private void g()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(new ReadInJoyFastWebBottomSocialViewNew.10(this));
  }
  
  private void g(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramContext != null) && (paramAbsBaseArticleInfo != null))
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      if (this.m)
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
  
  private String getSourceFrom()
  {
    if (this.m) {
      return "3";
    }
    return "1";
  }
  
  private void h(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null)
    {
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 2, "like click event failed");
      return;
    }
    if (paramFastWebArticleInfo.h)
    {
      paramFastWebArticleInfo.h = false;
      paramFastWebArticleInfo.f -= 1;
      ReportUtil.b(paramAbsBaseArticleInfo, "0X8009765", getSourceFrom());
    }
    else
    {
      paramFastWebArticleInfo.h = true;
      paramFastWebArticleInfo.f += 1;
      ReportUtil.b(paramAbsBaseArticleInfo, "0X8009764", getSourceFrom());
    }
    e();
    i(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    a(paramFastWebArticleInfo.f);
    ReadInJoyLogicEngineEventDispatcher.a().e();
    ReadInJoyLogicEngine.a().a(RIJQQAppInterfaceUtil.c(), paramFastWebArticleInfo.h, paramFastWebArticleInfo);
    if ((paramAbsBaseArticleInfo != null) && (paramFastWebArticleInfo.h)) {
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(paramAbsBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_LOVE, 0, 0, 0), 5);
    }
    paramContext = RIJUniteReportUtils.a;
    int i1;
    if (paramFastWebArticleInfo.h) {
      i1 = 1;
    } else {
      i1 = 3;
    }
    paramContext.a(paramAbsBaseArticleInfo, 1, i1);
  }
  
  private void i(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    setData(paramContext, paramFastWebArticleInfo, paramAbsBaseArticleInfo);
  }
  
  private void j(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    BubblePopupWindow localBubblePopupWindow = this.j;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      this.j.dismiss();
    }
    if ((paramAbsBaseArticleInfo != null) && (paramContext != null))
    {
      TimeSliceHelper.d(paramAbsBaseArticleInfo.innerUniqueID);
      int i1 = BiuBehaviour.a();
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      a(bool, paramContext, paramFastWebArticleInfo);
      i1 = (int)paramAbsBaseArticleInfo.mChannelID;
      if (paramFastWebArticleInfo.a()) {
        paramFastWebArticleInfo = "2";
      } else {
        paramFastWebArticleInfo = "1";
      }
      ReportUtil.a(paramAbsBaseArticleInfo, "0X8008991", RIJTransMergeKanDianReport.a(paramContext, paramAbsBaseArticleInfo, i1, paramFastWebArticleInfo, 0).toString());
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
      ((FastWebActivity)paramContext).d();
      int i1 = (int)paramAbsBaseArticleInfo.mChannelID;
      if (paramFastWebArticleInfo.a()) {
        paramFastWebArticleInfo = "2";
      } else {
        paramFastWebArticleInfo = "1";
      }
      ReportUtil.a(paramAbsBaseArticleInfo, "0X8008990", RIJTransMergeKanDianReport.a(paramContext, paramAbsBaseArticleInfo, i1, paramFastWebArticleInfo).toString());
      return;
    }
    if (this.m)
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
  
  public void a()
  {
    Object localObject = this.z;
    if (localObject != null)
    {
      KandianFavoriteBroadcastReceiver localKandianFavoriteBroadcastReceiver = this.v;
      if (localKandianFavoriteBroadcastReceiver != null) {
        ((Context)localObject).unregisterReceiver(localKandianFavoriteBroadcastReceiver);
      }
    }
    this.p = null;
    localObject = this.q;
    if (localObject != null) {
      ((RIJVideoRewardCoinManager)localObject).i();
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.B);
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong)
  {
    ReadInJoyLogicEngineEventDispatcher.a().e();
  }
  
  public void a(Activity paramActivity)
  {
    if (this.x == null) {
      return;
    }
    Share localShare = this.u;
    if (localShare != null) {
      localShare.destroy();
    }
    this.u = new Share(ReadInJoyUtils.b(), paramActivity);
    this.u.a(this.x);
    this.u.a(this.x.mArticleContentUrl, 9, false);
  }
  
  public void a(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramContext, paramFastWebArticleInfo, paramAbsBaseArticleInfo, 0);
  }
  
  public void a(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.l = paramInt;
    setData(paramContext, paramFastWebArticleInfo, paramAbsBaseArticleInfo);
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    RIJVideoRewardCoinManager.Companion localCompanion = RIJVideoRewardCoinManager.a;
    String str = paramFastWebArticleInfo.q;
    int i1;
    if (paramFastWebArticleInfo.N) {
      i1 = 3;
    } else {
      i1 = 1;
    }
    localCompanion.a("0X800B2EB", new RIJVideoRewardCoinManager.RIJRewardData(str, i1), paramInt);
    this.r = paramView;
    FastWebPTSUtils.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo, this.q, paramInt);
  }
  
  public void a(ReadInJoyFastWebBottomSocialViewNew.DoShareClick paramDoShareClick)
  {
    if (paramDoShareClick != null) {
      this.p = paramDoShareClick;
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public Map<String, Object> getReportParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("source_from", getSourceFrom());
    return localHashMap;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    f();
  }
  
  public void setData(Context paramContext, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ProteusItemData localProteusItemData;
    boolean bool;
    if ((paramContext != null) && (paramFastWebArticleInfo != null) && (paramAbsBaseArticleInfo != null))
    {
      this.x = paramAbsBaseArticleInfo;
      this.y = paramFastWebArticleInfo;
      this.z = paramContext;
      localProteusItemData = FastWebPTSDataConverter.a(paramAbsBaseArticleInfo, paramFastWebArticleInfo);
      if (this.e == null) {
        a(paramContext);
      }
      bool = paramFastWebArticleInfo.c();
    }
    for (;;)
    {
      try
      {
        if ((this.k == -1) || ((bool ^ true) != this.k))
        {
          removeAllViews();
          this.g = localProteusItemData.bd;
          this.f = this.e.getViewFactory().inflate(this.e, this.g);
          addView(this.f);
          if (!paramFastWebArticleInfo.c()) {
            break label264;
          }
          i1 = 0;
          this.k = i1;
          setBackgroundColor(-1);
          a(localProteusItemData, paramFastWebArticleInfo);
          b(paramContext);
          ReadInJoyLogicEngineEventDispatcher.a().a(this.B);
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setData error!  msg=");
        localStringBuilder.append(localException);
        QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, localStringBuilder.toString());
      }
      if (!d()) {
        return;
      }
      a(localProteusItemData.bb);
      a(localProteusItemData, paramContext, paramFastWebArticleInfo);
      a(paramAbsBaseArticleInfo);
      setVisibility(0);
      a(this.f.getVirtualView());
      return;
      QLog.d("ReadInJoyFastWebBottomSocialViewNew", 1, "setData error!  params is null!");
      return;
      label264:
      int i1 = 1;
    }
  }
  
  public void setData(FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    setData(this.z, paramFastWebArticleInfo, paramAbsBaseArticleInfo);
  }
  
  public void setFavoriteArticle(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, int paramInt)
  {
    a(paramContext, paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramInt);
  }
  
  public void setIsWebBottomView(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setOnOpenCommentEditListener(ReadInJoyFastWebBottomSocialViewNew.OnOpenCommentEditListener paramOnOpenCommentEditListener)
  {
    this.o = paramOnOpenCommentEditListener;
  }
  
  public void setProteusContext(VafContext paramVafContext)
  {
    this.e = paramVafContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialViewNew
 * JD-Core Version:    0.7.0.1
 */