package com.tencent.mobileqq.kandian.biz.fastweb;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CommentReportR5Builder;
import com.tencent.mobileqq.kandian.biz.comment.bean.CommentComponentArgs;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.biz.share.KandianFavoriteBroadcastReceiver;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentGuideConfigHandler;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ReadInJoyFastWebBottomSocialView
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public static final String a = HardCodeUtil.a(2131910353);
  public static final String b = HardCodeUtil.a(2131910526);
  private static final String e = HardCodeUtil.a(2131910536);
  private static final String f = HardCodeUtil.a(2131910323);
  private boolean A = false;
  private Share B;
  private HashMap<String, ArrayList<String>> C = new HashMap();
  private KandianFavoriteBroadcastReceiver D;
  private TextView E;
  private TextView F;
  private boolean G = false;
  private GuidePopuppWindow H;
  private View I;
  private final Runnable J = new ReadInJoyFastWebBottomSocialView.5(this);
  private final Runnable K = new ReadInJoyFastWebBottomSocialView.6(this);
  public int c = 0;
  ReadInJoyAtlasManager.AtlasCallback d = new ReadInJoyFastWebBottomSocialView.4(this);
  private Context g;
  private TextView h;
  private LinearLayout i;
  private ImageView j;
  private TextView k;
  private LinearLayout l;
  private ImageView m;
  private TextView n;
  private LinearLayout o;
  private TextView p;
  private ImageView q;
  private LinearLayout r;
  private TextView s;
  private View t;
  private View u;
  private FastWebArticleInfo v;
  private AbsBaseArticleInfo w;
  private FastWebActivity x;
  private Animation y;
  private BubblePopupWindow z;
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext)
  {
    super(paramContext);
    this.g = paramContext;
    a();
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = paramContext;
    a();
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = paramContext;
    a();
  }
  
  private void a()
  {
    try
    {
      RIJMaybeInitializedAladdinConfig.a();
      localObject = Aladdin.getConfig(151);
    }
    catch (Exception localException)
    {
      Object localObject;
      label14:
      int i2;
      int i1;
      int i3;
      break label14;
    }
    localObject = null;
    i2 = -1;
    if (localObject != null)
    {
      i2 = ((AladdinConfig)localObject).getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
      i1 = ((AladdinConfig)localObject).getIntegerFromString("readinjoy_bottom_action_bar_style", -1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initView,styleBusinessID=");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" actionBarStyle=");
      ((StringBuilder)localObject).append(i1);
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      i1 = -1;
    }
    i3 = 2131626233;
    if (i2 != 1)
    {
      i1 = i3;
    }
    else if ((i1 != 1) && (i1 != 2) && (i1 != 3))
    {
      i1 = i3;
    }
    else
    {
      i2 = 2131626234;
      this.c = i1;
      i1 = i2;
    }
    inflate(this.g, i1, this);
    this.h = ((TextView)findViewById(2131448339));
    this.k = ((TextView)findViewById(2131448338));
    this.j = ((ImageView)findViewById(2131436326));
    this.m = ((ImageView)findViewById(2131436443));
    this.n = ((TextView)findViewById(2131448560));
    this.r = ((LinearLayout)findViewById(2131429568));
    this.s = ((TextView)findViewById(2131448300));
    this.h.setOnClickListener(this);
    this.t = findViewById(2131449408);
    this.u = findViewById(2131449409);
    this.i = ((LinearLayout)findViewById(2131431091));
    this.l = ((LinearLayout)findViewById(2131437187));
    this.l.setOnClickListener(this);
    this.o = ((LinearLayout)findViewById(2131430928));
    this.q = ((ImageView)findViewById(2131436324));
    this.p = ((TextView)findViewById(2131448332));
    this.o.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.r.setOnLongClickListener(this);
    this.D = new KandianFavoriteBroadcastReceiver(this.d);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.process.fav");
    this.g.registerReceiver(this.D, (IntentFilter)localObject);
    this.E = ((TextView)findViewById(2131448337));
    this.F = ((TextView)findViewById(2131448559));
  }
  
  private boolean a(GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    if (this.H == null) {
      this.H = new GuidePopuppWindow(this.x, this.w);
    }
    if ((!this.H.a(this.w.innerUniqueID)) && (CommentGuideConfigHandler.b()))
    {
      if (this.I == null) {
        this.I = ((ViewStub)this.x.findViewById(2131444273)).inflate();
      }
      this.H.a(new ReadInJoyFastWebBottomSocialView.7(this, paramOnGuideDismissListener));
      this.I.setVisibility(0);
      this.H.a(this.w);
      this.H.a(this.x.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (this.y == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      this.y = localScaleAnimation;
    }
    this.y.setAnimationListener(new ReadInJoyFastWebBottomSocialView.2(this));
    this.m.startAnimation(this.y);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = new CommentComponentArgs().a(this.w).a(4).a("").a(paramBoolean);
    ReadInJoyCommentUtils.a(this.x, (CommentComponentArgs)localObject);
    localObject = new ReadInJoyCommentUtils.CommentReportR5Builder(this.w, null).a(1).a();
    PublicAccountReportUtils.a((QQAppInterface)this.x.getAppInterface(), ReadInJoyCommentUtils.a(this.w), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.w.mArticleID), String.valueOf(this.w.mStrategyId), this.w.innerUniqueID, (String)localObject, false);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.w;
    Context localContext = this.g;
    int i1 = (int)localAbsBaseArticleInfo.mChannelID;
    if (this.v.a()) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    ReportUtil.a(localAbsBaseArticleInfo, "0X8008990", RIJTransMergeKanDianReport.a(localContext, localAbsBaseArticleInfo, i1, (String)localObject).toString());
  }
  
  private void c()
  {
    Object localObject = this.v;
    if (localObject != null) {
      setFavoriteStatus(((FastWebArticleInfo)localObject).b());
    }
    if ((this.w != null) && (this.g != null))
    {
      localObject = new ArrayList();
      ((List)localObject).add(this.w.innerUniqueID);
      ReadInJoyAtlasManager.getInstance().getAtlasFavoriteStatus((List)localObject, this.d);
      return;
    }
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, "initFavoriteStatus but articleInfo is null.");
  }
  
  private void c(boolean paramBoolean)
  {
    int i1 = 8;
    int i2;
    if (paramBoolean)
    {
      String str = ReadInJoyHelper.a(this.v.d, 99990000L, "9999万+", e);
      if (this.E != null)
      {
        if (this.G)
        {
          if (!e.equalsIgnoreCase(str))
          {
            this.E.setText(str);
            i1 = 0;
          }
          this.E.setVisibility(i1);
        }
      }
      else {
        this.k.setText(str);
      }
      i2 = 4;
      this.i.setOnClickListener(this);
      i1 = 0;
    }
    else
    {
      i2 = 0;
    }
    this.i.setVisibility(i1);
    this.t.setVisibility(i2);
    this.u.setVisibility(i2);
    this.h.setVisibility(i1);
  }
  
  private void d()
  {
    if (this.G) {
      return;
    }
    if ((this.F != null) && (this.E != null))
    {
      Object localObject = new int[2];
      int[] arrayOfInt = new int[2];
      this.m.getLocationOnScreen((int[])localObject);
      getLocationOnScreen(arrayOfInt);
      int i3 = this.m.getWidth();
      int i4 = this.m.getHeight();
      this.m.getLeft();
      int i1 = localObject[1];
      int i2 = arrayOfInt[1];
      i4 /= 9;
      int i5 = localObject[0];
      i3 = i3 * 13 / 20;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.F.getLayoutParams();
      localLayoutParams.leftMargin = (i5 + i3);
      localLayoutParams.topMargin = (i1 - i2 - i4);
      this.j.getLocationOnScreen((int[])localObject);
      i3 = this.j.getWidth();
      i4 = this.j.getHeight();
      i1 = localObject[1];
      i2 = arrayOfInt[1];
      i4 /= 9;
      i5 = localObject[0];
      i3 = i3 * 13 / 20;
      localObject = (RelativeLayout.LayoutParams)this.E.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = (i5 + i3);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (i1 - i2 - i4);
      i1 = this.c;
      if ((i1 == 1) || (i1 == 2))
      {
        getResources().getDimension(2131299573);
        this.E.setTextColor(Color.parseColor("#FF4222"));
        this.E.setBackgroundResource(2130843816);
        this.F.setBackgroundResource(2130843816);
      }
      this.G = true;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.v != null) && (this.g != null))
    {
      setFavoriteStatus(paramBoolean);
      this.v.a(paramBoolean);
      return;
    }
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, "updateFavoriteStatus but fastWebInfo is null.");
  }
  
  private void setFavoriteArticle(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void setFavoriteStatus(boolean paramBoolean)
  {
    int i1;
    String str;
    if (paramBoolean)
    {
      i1 = 2130842632;
      str = HardCodeUtil.a(2131910555);
    }
    else
    {
      i1 = 2130842648;
      str = HardCodeUtil.a(2131910300);
    }
    this.q.setImageResource(i1);
    this.q.setSelected(paramBoolean);
    this.p.setText(str);
  }
  
  public void a(int paramInt)
  {
    if (this.n != null)
    {
      Object localObject = this.v;
      if (localObject == null) {
        return;
      }
      ((FastWebArticleInfo)localObject).f = paramInt;
      localObject = ReadInJoyHelper.a(paramInt, 99990000L, "9999万+", f);
      if (this.F != null)
      {
        if (this.G)
        {
          int i2 = 8;
          int i1 = i2;
          if (!f.equalsIgnoreCase((String)localObject))
          {
            i1 = i2;
            if (this.c == 1)
            {
              this.F.setText((CharSequence)localObject);
              i1 = 0;
            }
          }
          this.F.setVisibility(i1);
        }
      }
      else {
        this.n.setText((CharSequence)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLikeCntView | like cnt is ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.k != null) && (this.h != null) && (this.j != null))
    {
      if (this.v == null) {
        return;
      }
      Object localObject = ReadInJoyCommentDataManager.a(this.w);
      if (localObject != null)
      {
        long l1 = ((ReadInJoyCommentDataManager)localObject).b(2);
        localObject = this.v;
        if (l1 > 0L) {
          paramLong = l1;
        }
        ((FastWebArticleInfo)localObject).d = paramLong;
      }
      else
      {
        this.v.d = paramLong;
      }
      c(this.v.c());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      FastWebArticleInfo localFastWebArticleInfo = this.v;
      if (localFastWebArticleInfo == null) {
        return;
      }
      localFastWebArticleInfo.h = paramBoolean;
      int i1;
      if (localFastWebArticleInfo.h) {
        i1 = 2130843931;
      } else {
        i1 = 2130843933;
      }
      ((ImageView)localObject).setImageResource(i1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLikeIconView | isLiked  ");
      ((StringBuilder)localObject).append(this.v.h);
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(long paramLong)
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      if (this.s == null) {
        return;
      }
      this.v.e = paramLong;
      if (FastWebSPUtils.a(((FastWebActivity)localObject).getAppRuntime()) == 0)
      {
        this.s.setText(ReadInJoyHelper.a(this.v.e, 99990000L, "9999万+", "Biu"));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateBiuCntView | biu cnt is ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("ReadInJoyFastWebBottomSocialView", 2, ((StringBuilder)localObject).toString());
        return;
      }
      this.s.setText("Biu");
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateBiuCntView | biu cnt switch is closed ");
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.w != null)
    {
      if (this.x == null) {
        return;
      }
      int i1 = paramView.getId();
      paramView = "2";
      boolean bool = true;
      Object localObject;
      Context localContext;
      switch (i1)
      {
      default: 
      case 2131448339: 
        if ((this.x != null) && (this.w != null))
        {
          if (a(new ReadInJoyFastWebBottomSocialView.1(this))) {
            return;
          }
          b(true);
          return;
        }
        break;
      case 2131437187: 
        paramView = this.v;
        if (paramView == null)
        {
          QLog.d("ReadInJoyFastWebBottomSocialView", 2, "like click event failed");
          return;
        }
        if (paramView.h)
        {
          paramView = this.v;
          paramView.h = false;
          paramView.f -= 1;
          ReportUtil.b(this.w, "0X8009765", "1");
        }
        else
        {
          paramView = this.v;
          paramView.h = true;
          paramView.f += 1;
          ReportUtil.b(this.w, "0X8009764", "1");
        }
        b();
        a(this.v.f);
        ReadInJoyLogicEngineEventDispatcher.a().d();
        ReadInJoyLogicEngine.a().a(RIJQQAppInterfaceUtil.c(), this.v.h, this.v);
        return;
      case 2131431091: 
        if ((this.x != null) && (this.w != null))
        {
          QLog.d("ReadInJoyFastWebBottomSocialView", 1, "enter scroll");
          this.x.d();
          localObject = this.w;
          localContext = this.g;
          i1 = (int)((AbsBaseArticleInfo)localObject).mChannelID;
          if (!this.v.a()) {
            paramView = "1";
          }
          ReportUtil.a((AbsBaseArticleInfo)localObject, "0X8008990", RIJTransMergeKanDianReport.a(localContext, (AbsBaseArticleInfo)localObject, i1, paramView).toString());
          return;
        }
        paramView = new StringBuilder();
        paramView.append("scroll to history location failed cuz activity or articleinfo is null");
        paramView.append(this.x);
        if (paramView.toString() == null) {
          paramView = "activity is null";
        } else {
          paramView = "";
        }
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, paramView);
        return;
      case 2131430928: 
        setFavoriteArticle(this.q.isSelected() ^ true);
        return;
      case 2131429568: 
        localObject = this.z;
        if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
          this.z.dismiss();
        }
        TimeSliceHelper.d(this.w.innerUniqueID);
        if ((this.x != null) && (this.w != null))
        {
          if (BiuBehaviour.a() != 1) {
            bool = false;
          }
          this.x.a(18, 0, bool);
          localObject = this.w;
          localContext = this.g;
          i1 = (int)((AbsBaseArticleInfo)localObject).mChannelID;
          if (!this.v.a()) {
            paramView = "1";
          }
          ReportUtil.a((AbsBaseArticleInfo)localObject, "0X8008991", RIJTransMergeKanDianReport.a(localContext, (AbsBaseArticleInfo)localObject, i1, paramView, 0).toString());
        }
        break;
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() != 2131429568) {
      return false;
    }
    paramView = this.z;
    if ((paramView != null) && (paramView.isShowing())) {
      this.z.dismiss();
    }
    if (this.x != null)
    {
      int i1 = BiuBehaviour.b();
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      this.x.a(18, 0, bool);
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.w;
      Context localContext = this.g;
      i1 = (int)localAbsBaseArticleInfo.mChannelID;
      if (this.v.a()) {
        paramView = "2";
      } else {
        paramView = "1";
      }
      ReportUtil.a(localAbsBaseArticleInfo, "0X8008991", RIJTransMergeKanDianReport.a(localContext, localAbsBaseArticleInfo, i1, paramView, 0).toString());
    }
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    d();
  }
  
  public void setData(FastWebActivity paramFastWebActivity, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.x = paramFastWebActivity;
    this.v = paramFastWebArticleInfo;
    this.w = paramAbsBaseArticleInfo;
    a(this.v.d);
    b(this.v.e);
    a(this.v.f);
    a(this.v.h);
    c();
  }
  
  public void setFavoriteArticle()
  {
    ImageView localImageView = this.q;
    if (localImageView != null) {
      setFavoriteArticle(localImageView.isSelected() ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialView
 * JD-Core Version:    0.7.0.1
 */