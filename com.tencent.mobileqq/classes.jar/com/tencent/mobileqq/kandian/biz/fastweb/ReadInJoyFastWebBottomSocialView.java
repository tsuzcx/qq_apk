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
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CommentReportR5Builder;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
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
import com.tencent.mobileqq.qroute.QRoute;
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
  public static final String a;
  public static final String b;
  private static final String jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131712971);
  private static final String jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131712749);
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Share jdField_a_of_type_ComTencentBizWebviewpluginShare;
  ReadInJoyAtlasManager.AtlasCallback jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallback = new ReadInJoyFastWebBottomSocialView.4(this);
  private GuidePopuppWindow jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow;
  private FastWebActivity jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private FastWebArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyFastWebBottomSocialView.5(this);
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final Runnable jdField_b_of_type_JavaLangRunnable = new ReadInJoyFastWebBottomSocialView.6(this);
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712780);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131712960);
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public ReadInJoyFastWebBottomSocialView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
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
      int j;
      int i;
      int k;
      break label14;
    }
    localObject = null;
    j = -1;
    if (localObject != null)
    {
      j = ((AladdinConfig)localObject).getIntegerFromString("readinjoy_bottom_action_bar_business_id", -1);
      i = ((AladdinConfig)localObject).getIntegerFromString("readinjoy_bottom_action_bar_style", -1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initView,styleBusinessID=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" actionBarStyle=");
      ((StringBuilder)localObject).append(i);
      QLog.d("ReadInJoyFastWebBottomSocialView", 1, ((StringBuilder)localObject).toString());
    }
    else
    {
      i = -1;
    }
    k = 2131560186;
    if (j != 1)
    {
      i = k;
    }
    else if ((i != 1) && (i != 2) && (i != 3))
    {
      i = k;
    }
    else
    {
      j = 2131560187;
      this.jdField_a_of_type_Int = i;
      i = j;
    }
    inflate(this.jdField_a_of_type_AndroidContentContext, i, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379583));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379582));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369325));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369409));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379752));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363655));
    this.e = ((TextView)findViewById(2131379548));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380456);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131380457);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364964));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370031));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364806));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369323));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379576));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallback);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.process.fav");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareKandianFavoriteBroadcastReceiver, (IntentFilter)localObject);
    this.f = ((TextView)findViewById(2131379581));
    this.g = ((TextView)findViewById(2131379751));
  }
  
  private boolean a(GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow = new GuidePopuppWindow(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID)) && (CommentGuideConfigHandler.b()))
    {
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.findViewById(2131376073)).inflate();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(new ReadInJoyFastWebBottomSocialView.7(this, paramOnGuideDismissListener));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentGuideGuidePopuppWindow.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setRepeatCount(1);
      localScaleAnimation.setRepeatMode(2);
      localScaleAnimation.setInterpolator(new DecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimation = localScaleAnimation;
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new ReadInJoyFastWebBottomSocialView.2(this));
    this.jdField_b_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void b(boolean paramBoolean)
  {
    ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null, 4, "", null, false, null, -1, paramBoolean);
    String str = new ReadInJoyCommentUtils.CommentReportR5Builder(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, null).a(1).a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.getAppInterface(), ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, str, false);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    int i = (int)localAbsBaseArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a()) {
      str = "2";
    } else {
      str = "1";
    }
    ReportUtil.a(localAbsBaseArticleInfo, "0X8008990", RIJTransMergeKanDianReport.a(localContext, localAbsBaseArticleInfo, i, str).toString());
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
    if (localObject != null) {
      f(((FastWebArticleInfo)localObject).b());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      localObject = new ArrayList();
      ((List)localObject).add(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      ReadInJoyAtlasManager.getInstance().getAtlasFavoriteStatus((List)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallback);
      return;
    }
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, "initFavoriteStatus but articleInfo is null.");
  }
  
  private void c(boolean paramBoolean)
  {
    int i = 8;
    int j;
    if (paramBoolean)
    {
      String str = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.b, 99990000L, "9999万+", jdField_c_of_type_JavaLangString);
      if (this.f != null)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          if (!jdField_c_of_type_JavaLangString.equalsIgnoreCase(str))
          {
            this.f.setText(str);
            i = 0;
          }
          this.f.setVisibility(i);
        }
      }
      else {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      }
      j = 4;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      i = 0;
    }
    else
    {
      j = 0;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(i);
    this.jdField_a_of_type_AndroidViewView.setVisibility(j);
    this.jdField_b_of_type_AndroidViewView.setVisibility(j);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(i);
  }
  
  private void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((this.g != null) && (this.f != null))
    {
      Object localObject = new int[2];
      int[] arrayOfInt = new int[2];
      this.jdField_b_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject);
      getLocationOnScreen(arrayOfInt);
      int k = this.jdField_b_of_type_AndroidWidgetImageView.getWidth();
      int m = this.jdField_b_of_type_AndroidWidgetImageView.getHeight();
      this.jdField_b_of_type_AndroidWidgetImageView.getLeft();
      int i = localObject[1];
      int j = arrayOfInt[1];
      m /= 9;
      int n = localObject[0];
      k = k * 13 / 20;
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
      localLayoutParams.leftMargin = (n + k);
      localLayoutParams.topMargin = (i - j - m);
      this.jdField_a_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject);
      k = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      m = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      i = localObject[1];
      j = arrayOfInt[1];
      m /= 9;
      n = localObject[0];
      k = k * 13 / 20;
      localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = (n + k);
      ((RelativeLayout.LayoutParams)localObject).topMargin = (i - j - m);
      i = this.jdField_a_of_type_Int;
      if ((i == 1) || (i == 2))
      {
        getResources().getDimension(2131298856);
        this.f.setTextColor(Color.parseColor("#FF4222"));
        this.f.setBackgroundResource(2130842860);
        this.g.setBackgroundResource(2130842860);
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      f(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a(paramBoolean);
      return;
    }
    QLog.d("ReadInJoyFastWebBottomSocialView", 1, "updateFavoriteStatus but fastWebInfo is null.");
  }
  
  private void f(boolean paramBoolean)
  {
    int i;
    String str;
    if (paramBoolean)
    {
      i = 2130841716;
      str = HardCodeUtil.a(2131712991);
    }
    else
    {
      i = 2130841731;
      str = HardCodeUtil.a(2131712724);
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
    this.jdField_c_of_type_AndroidWidgetImageView.setSelected(paramBoolean);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
      if (localObject == null) {
        return;
      }
      ((FastWebArticleInfo)localObject).jdField_a_of_type_Int = paramInt;
      localObject = ReadInJoyHelper.a(paramInt, 99990000L, "9999万+", jdField_d_of_type_JavaLangString);
      if (this.g != null)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          int j = 8;
          int i = j;
          if (!jdField_d_of_type_JavaLangString.equalsIgnoreCase((String)localObject))
          {
            i = j;
            if (this.jdField_a_of_type_Int == 1)
            {
              this.g.setText((CharSequence)localObject);
              i = 0;
            }
          }
          this.g.setVisibility(i);
        }
      }
      else {
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLikeCntView | like cnt is ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo == null) {
        return;
      }
      Object localObject = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      if (localObject != null)
      {
        long l = ((ReadInJoyCommentDataManager)localObject).a(2);
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
        if (l > 0L) {
          paramLong = l;
        }
        ((FastWebArticleInfo)localObject).b = paramLong;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.b = paramLong;
      }
      c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.c());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      FastWebArticleInfo localFastWebArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
      if (localFastWebArticleInfo == null) {
        return;
      }
      localFastWebArticleInfo.jdField_a_of_type_Boolean = paramBoolean;
      int i;
      if (localFastWebArticleInfo.jdField_a_of_type_Boolean) {
        i = 2130842975;
      } else {
        i = 2130842977;
      }
      ((ImageView)localObject).setImageResource(i);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLikeIconView | isLiked  ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_a_of_type_Boolean);
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity;
    if (localObject != null)
    {
      if (this.e == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.c = paramLong;
      if (FastWebSPUtils.a(((FastWebActivity)localObject).getAppRuntime()) == 0)
      {
        this.e.setText(ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.c, 99990000L, "9999万+", "Biu"));
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateBiuCntView | biu cnt is ");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("ReadInJoyFastWebBottomSocialView", 2, ((StringBuilder)localObject).toString());
        return;
      }
      this.e.setText("Biu");
      QLog.d("ReadInJoyFastWebBottomSocialView", 2, "updateBiuCntView | biu cnt switch is closed ");
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity == null) {
        return;
      }
      int i = paramView.getId();
      paramView = "2";
      boolean bool = true;
      Object localObject;
      Context localContext;
      switch (i)
      {
      default: 
      case 2131379583: 
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
        {
          if (a(new ReadInJoyFastWebBottomSocialView.1(this))) {
            return;
          }
          b(true);
          return;
        }
        break;
      case 2131370031: 
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
        if (paramView == null)
        {
          QLog.d("ReadInJoyFastWebBottomSocialView", 2, "like click event failed");
          return;
        }
        if (paramView.jdField_a_of_type_Boolean)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
          paramView.jdField_a_of_type_Boolean = false;
          paramView.jdField_a_of_type_Int -= 1;
          ReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X8009765", "1");
        }
        else
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo;
          paramView.jdField_a_of_type_Boolean = true;
          paramView.jdField_a_of_type_Int += 1;
          ReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X8009764", "1");
        }
        b();
        a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_a_of_type_Int);
        ReadInJoyLogicEngineEventDispatcher.a().d();
        ReadInJoyLogicEngine.a().a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo);
        return;
      case 2131364964: 
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
        {
          QLog.d("ReadInJoyFastWebBottomSocialView", 1, "enter scroll");
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.c();
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
          localContext = this.jdField_a_of_type_AndroidContentContext;
          i = (int)((AbsBaseArticleInfo)localObject).mChannelID;
          if (!this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a()) {
            paramView = "1";
          }
          ReportUtil.a((AbsBaseArticleInfo)localObject, "0X8008990", RIJTransMergeKanDianReport.a(localContext, (AbsBaseArticleInfo)localObject, i, paramView).toString());
          return;
        }
        paramView = new StringBuilder();
        paramView.append("scroll to history location failed cuz activity or articleinfo is null");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity);
        if (paramView.toString() == null) {
          paramView = "activity is null";
        } else {
          paramView = "";
        }
        QLog.d("ReadInJoyFastWebBottomSocialView", 1, paramView);
        return;
      case 2131364806: 
        d(this.jdField_c_of_type_AndroidWidgetImageView.isSelected() ^ true);
        return;
      case 2131363655: 
        localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
        if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
          this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
        }
        TimeSliceHelper.c(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
        {
          if (BiuBehaviour.a() != 1) {
            bool = false;
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.a(18, 0, bool);
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
          localContext = this.jdField_a_of_type_AndroidContentContext;
          i = (int)((AbsBaseArticleInfo)localObject).mChannelID;
          if (!this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a()) {
            paramView = "1";
          }
          ReportUtil.a((AbsBaseArticleInfo)localObject, "0X8008991", RIJTransMergeKanDianReport.a(localContext, (AbsBaseArticleInfo)localObject, i, paramView, 0).toString());
        }
        break;
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() != 2131363655) {
      return false;
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((paramView != null) && (paramView.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity != null)
    {
      int i = BiuBehaviour.b();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity.a(18, 0, bool);
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      i = (int)localAbsBaseArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.a()) {
        paramView = "2";
      } else {
        paramView = "1";
      }
      ReportUtil.a(localAbsBaseArticleInfo, "0X8008991", RIJTransMergeKanDianReport.a(localContext, localAbsBaseArticleInfo, i, paramView, 0).toString());
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebFastWebActivity = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo = paramFastWebArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.b);
    b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.c);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_a_of_type_Int);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo.jdField_a_of_type_Boolean);
    c();
  }
  
  public void setFavoriteArticle()
  {
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      d(localImageView.isSelected() ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialView
 * JD-Core Version:    0.7.0.1
 */