package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.TMG.utils.QLog;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.bean.CommentComponentArgs;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuidePopuppWindow.OnGuideDismissListener;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUi;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper;
import com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView.MultiScrollListener;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentGuideConfigHandler;
import com.tencent.mobileqq.kandian.repo.comment.constants.CommentInfoConstants;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, FlingExitLayout.OnGestureExitListener, ReadInJoyCommentUtils.CommentListListener, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener
{
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private boolean D = false;
  private ReadInJoyCommentListFragment.ViewParams E = null;
  private boolean F = false;
  private boolean G = false;
  private View H = null;
  private View I = null;
  private View J = null;
  private View K = null;
  private ReadInJoyCommentHelper.ISecondCommentViewStateListener L = null;
  private RIJBiuAndCommentMixDataManager M;
  private TKDCommentFragment N;
  private boolean O = false;
  private ITKDHippyEventDispatcher P = new TKDHippyEventDispatcher();
  private HippyCommentPageListener Q = new ReadInJoyCommentListFragment.1(this);
  private int R = 0;
  private TimeSliceHelper S = new TimeSliceHelper();
  private ReadInJoyCommentListFragment.OnCreateViewListener T = null;
  private boolean U = true;
  private GuidePopuppWindow V;
  private LayoutInflateProcessor W;
  private ReadInJoyCommentUtils.FirstCommentEvent X;
  private ReadInJoyCommentUtils.OnFragmentViewCreateListener Y;
  private ReadInJoyCommentListView.MultiScrollListener Z = null;
  public int a = 2131445466;
  private AbsListView.OnScrollListener aa = new ReadInJoyCommentListFragment.2(this);
  private final ReadInJoyObserver ab = new ReadInJoyCommentListFragment.5(this);
  private String[] ac = { "huawei_vog-al00", "huawei_vog-al10", "huawei_ele-al00", "samsung_sm-g9750" };
  private final ITKDHippyEventReceiver ad = new ReadInJoyCommentListFragment.11(this);
  private FlingExitLayout b;
  private ReadInJoyCommentListView c;
  private ReadInJoyCommentListAdapter d;
  private ReadInJoySecondCommentListFragment e;
  private ViewGroup f;
  private View g;
  private View h;
  private View i;
  private View j;
  private TextView k;
  private FrameLayout l;
  private TextView m;
  private LinearLayout n;
  private RelativeLayout o;
  private int p = 1;
  private AbsBaseArticleInfo q;
  private AnchorData r;
  private String s = "";
  private int t;
  private CommonCommentData u;
  private int v = 5;
  private boolean w = false;
  private boolean x = false;
  private boolean y;
  private boolean z = true;
  
  private void A()
  {
    if (this.F)
    {
      RelativeLayout localRelativeLayout = this.o;
      if (localRelativeLayout != null) {
        localRelativeLayout.setVisibility(8);
      }
    }
  }
  
  private void B()
  {
    c(false);
  }
  
  private void C()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("arg_comment_list_biu_btn", false);
    this.e = new ReadInJoySecondCommentListFragment();
    this.e.a(this.u);
    this.e.a(this.R);
    this.e.b(this.F);
    Object localObject2 = this.E;
    if (localObject2 != null)
    {
      this.e.b(((ReadInJoyCommentListFragment.ViewParams)localObject2).f);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initSubCommentFragment | setMarginTop ");
      ((StringBuilder)localObject2).append(this.E.f);
      QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject2).toString());
    }
    this.e.a(this.W);
    this.e.a(this, (Bundle)localObject1, new ReadInJoyCommentListFragment.6(this));
    localObject1 = y();
    if (localObject1 != null)
    {
      ((FragmentTransaction)localObject1).add(this.a, this.e);
      ((FragmentTransaction)localObject1).hide(this.e);
      ((FragmentTransaction)localObject1).commitAllowingStateLoss();
    }
  }
  
  private void D()
  {
    this.c.initFooterView();
    this.c.hideFooterView();
    this.d = new ReadInJoyCommentListAdapter(getQBaseActivity(), this, this.c, this.t);
    this.c.setAdapter(this.d);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.ab);
  }
  
  private void E()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    boolean bool = false;
    this.O = localBundle.getBoolean("arg_comment_is_fragment_container", false);
    this.B = localBundle.getBoolean("arg_comment_list_comment_btn", false);
    this.C = localBundle.getBoolean("arg_comment_list_biu_btn", false);
    this.D = localBundle.getBoolean("arg_comment_list_share_btn", false);
    this.A = localBundle.getBoolean("readinjoy_open_comment_with_edit_panel", false);
    Object localObject = getQBaseActivity();
    if ((localObject != null) && (((Activity)localObject).getIntent() != null)) {
      this.U = ((Activity)localObject).getIntent().getBooleanExtra(CommentInfoConstants.READINJOY_IS_INDEPENDENT_COMPONENTS, true);
    }
    this.F = localBundle.getBoolean("fromViola");
    this.G = localBundle.getBoolean("is_from_viola");
    this.R = localBundle.getInt("bigT_report_entry", this.t);
    if (this.F)
    {
      if (this.E == null) {
        this.E = new ReadInJoyCommentListFragment.ViewParams();
      }
      this.U = false;
      this.v = localBundle.getInt("serviceType");
      this.E.a = (localBundle.getBoolean("isHiddenFirstPageEditorBar", false) ^ true);
      this.E.b = (localBundle.getBoolean("isHiddenHeaderRow", false) ^ true);
      this.E.e = (localBundle.getBoolean("isHiddenSecPageEditorBar", false) ^ true);
      this.E.c = localBundle.getInt("padding_top");
      this.E.d = localBundle.getInt("margin_bottom");
      this.E.f = localBundle.getInt("secPageOffsetY");
      this.E.h = localBundle.getInt("secPageShowDirection", 2);
      localObject = this.E;
      if (localBundle.getInt("isHiddenSecPageMaskView", 0) == 0) {
        bool = true;
      }
      ((ReadInJoyCommentListFragment.ViewParams)localObject).g = bool;
      this.q = ((AbsBaseArticleInfo)localBundle.getParcelable("articleInfo"));
      this.t = localBundle.getInt("source");
      this.u = ((CommonCommentData)localBundle.getSerializable("commonCommentData"));
    }
  }
  
  private void F()
  {
    LinearLayout localLinearLayout = this.n;
    if (localLinearLayout != null)
    {
      ReadInJoyCommentListFragment.ViewParams localViewParams = this.E;
      int i1;
      if ((localViewParams != null) && (localViewParams.a)) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localLinearLayout.setVisibility(i1);
    }
  }
  
  private boolean G()
  {
    if (this.p == 2)
    {
      a(false, null, null);
      return true;
    }
    ReadInJoyCommentUtils.FirstCommentEvent localFirstCommentEvent = this.X;
    if ((localFirstCommentEvent != null) && (this.d != null))
    {
      localFirstCommentEvent.a(I());
      this.d.b = 0;
    }
    H();
    return false;
  }
  
  private void H()
  {
    Object localObject = getQBaseActivity();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if ((this.q != null) && (localObject != null)) {
        ReadInJoyLogicEngineEventDispatcher.a().a(this.q.innerUniqueID, "onPanelClose", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  private int I()
  {
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.q);
    if (localReadInJoyCommentDataManager != null) {
      return (int)localReadInJoyCommentDataManager.h();
    }
    return -1;
  }
  
  private void J()
  {
    ReadInJoyCommentListView localReadInJoyCommentListView = this.c;
    if (localReadInJoyCommentListView == null) {
      return;
    }
    localReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.c.setSelection(0);
  }
  
  private void K()
  {
    Object localObject = this.q;
    if (localObject != null)
    {
      localObject = new ReadInJoyCommentUtils.CommentReportR5Builder((AbsBaseArticleInfo)localObject, null).a(this.R).b(1).a();
      PublicAccountReportUtils.a(null, ReadInJoyCommentUtils.a(this.q), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.q.mArticleID), String.valueOf(this.q.mStrategyId), this.q.innerUniqueID, (String)localObject, false);
    }
  }
  
  private void L()
  {
    RIJBiuAndCommentMixDataManager localRIJBiuAndCommentMixDataManager = this.M;
    if (localRIJBiuAndCommentMixDataManager != null) {
      localRIJBiuAndCommentMixDataManager.a();
    }
    this.M = new RIJBiuAndCommentMixDataManager();
    this.M.a(new ReadInJoyCommentListFragment.10(this));
  }
  
  /* Error */
  public static void a(Intent paramIntent, RIJBiuAndCommentMixDataManager paramRIJBiuAndCommentMixDataManager, int paramInt1, boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: new 241	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   7: astore 10
    //   9: aload 10
    //   11: ldc_w 535
    //   14: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 10
    //   20: iload_2
    //   21: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 10
    //   27: ldc_w 537
    //   30: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 10
    //   36: iload_3
    //   37: invokevirtual 540	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 253
    //   43: iconst_1
    //   44: aload 10
    //   46: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 262	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: ldc_w 542
    //   56: invokevirtual 546	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_0
    //   60: aload_0
    //   61: invokestatic 552	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: istore 7
    //   66: iconst_0
    //   67: istore 8
    //   69: iconst_0
    //   70: istore 9
    //   72: ldc 110
    //   74: astore 12
    //   76: iload 7
    //   78: ifne +133 -> 211
    //   81: new 554	org/json/JSONObject
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 557	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   89: astore_0
    //   90: aload_0
    //   91: ldc_w 559
    //   94: invokevirtual 562	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 11
    //   99: aload_0
    //   100: ldc_w 564
    //   103: invokevirtual 567	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   106: istore 7
    //   108: aload_0
    //   109: ldc_w 569
    //   112: invokevirtual 562	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore 10
    //   117: aload_0
    //   118: ldc_w 571
    //   121: invokevirtual 567	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   124: istore 9
    //   126: aload_0
    //   127: ldc_w 573
    //   130: invokevirtual 562	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_0
    //   134: iload 7
    //   136: istore 8
    //   138: iload 9
    //   140: istore 7
    //   142: goto +82 -> 224
    //   145: astore_0
    //   146: iload 7
    //   148: istore 8
    //   150: iload 9
    //   152: istore 7
    //   154: goto +47 -> 201
    //   157: astore_0
    //   158: goto +8 -> 166
    //   161: astore_0
    //   162: ldc 110
    //   164: astore 10
    //   166: iload 7
    //   168: istore 8
    //   170: goto +28 -> 198
    //   173: astore_0
    //   174: ldc 110
    //   176: astore 10
    //   178: iload 9
    //   180: istore 8
    //   182: goto +16 -> 198
    //   185: astore_0
    //   186: ldc 110
    //   188: astore 11
    //   190: aload 11
    //   192: astore 10
    //   194: iload 9
    //   196: istore 8
    //   198: iconst_0
    //   199: istore 7
    //   201: aload_0
    //   202: invokevirtual 576	org/json/JSONException:printStackTrace	()V
    //   205: ldc 110
    //   207: astore_0
    //   208: goto +16 -> 224
    //   211: ldc 110
    //   213: astore 11
    //   215: aload 11
    //   217: astore_0
    //   218: aload_0
    //   219: astore 10
    //   221: iconst_0
    //   222: istore 7
    //   224: aload 11
    //   226: invokestatic 552	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   229: ifne +106 -> 335
    //   232: new 578	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData
    //   235: dup
    //   236: invokespecial 579	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:<init>	()V
    //   239: astore 13
    //   241: aload 13
    //   243: iload_3
    //   244: invokevirtual 582	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setBiu	(Z)V
    //   247: aload 13
    //   249: iload_2
    //   250: invokevirtual 585	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setContentSrc	(I)V
    //   253: aload 13
    //   255: aload 11
    //   257: invokevirtual 588	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setContentString	(Ljava/lang/String;)V
    //   260: aload 13
    //   262: iload 8
    //   264: invokevirtual 591	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setDiffuseToFriends	(Z)V
    //   267: aload 4
    //   269: ifnonnull +10 -> 279
    //   272: aload 12
    //   274: astore 11
    //   276: goto +10 -> 286
    //   279: aload 4
    //   281: getfield 455	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   284: astore 11
    //   286: aload 13
    //   288: aload 11
    //   290: invokevirtual 594	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setRowKey	(Ljava/lang/String;)V
    //   293: aload 13
    //   295: iload 5
    //   297: invokevirtual 597	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setListShowType	(I)V
    //   300: aload 13
    //   302: iload 6
    //   304: invokevirtual 600	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setCommentType	(I)V
    //   307: aload 13
    //   309: aload 10
    //   311: invokevirtual 603	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setReplyCommentId	(Ljava/lang/String;)V
    //   314: aload 13
    //   316: iload 7
    //   318: invokevirtual 606	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setIsSecondReply	(Z)V
    //   321: aload 13
    //   323: aload_0
    //   324: invokevirtual 609	com/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData:setReplyUin	(Ljava/lang/String;)V
    //   327: aload_1
    //   328: aload 4
    //   330: aload 13
    //   332: invokevirtual 612	com/tencent/mobileqq/kandian/biz/biu/RIJBiuAndCommentMixDataManager:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;Lcom/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRequestData;)V
    //   335: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramIntent	Intent
    //   0	336	1	paramRIJBiuAndCommentMixDataManager	RIJBiuAndCommentMixDataManager
    //   0	336	2	paramInt1	int
    //   0	336	3	paramBoolean	boolean
    //   0	336	4	paramAbsBaseArticleInfo	AbsBaseArticleInfo
    //   0	336	5	paramInt2	int
    //   0	336	6	paramInt3	int
    //   64	253	7	bool1	boolean
    //   67	196	8	bool2	boolean
    //   70	125	9	bool3	boolean
    //   7	303	10	localObject	Object
    //   97	192	11	str1	String
    //   74	199	12	str2	String
    //   239	92	13	localRIJBiuAndCommentRequestData	com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRequestData
    // Exception table:
    //   from	to	target	type
    //   126	134	145	org/json/JSONException
    //   117	126	157	org/json/JSONException
    //   108	117	161	org/json/JSONException
    //   99	108	173	org/json/JSONException
    //   81	99	185	org/json/JSONException
  }
  
  private void a(View paramView)
  {
    this.b = ((FlingExitLayout)paramView);
    boolean bool = TKDCommentFragmentHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableHippyComment: ");
    localStringBuilder.append(bool);
    QLog.d("ReadInJoyCommentListFragment", 1, localStringBuilder.toString());
    if (bool)
    {
      b(paramView);
      if (this.N == null) {
        d(paramView);
      }
    }
    else
    {
      d(paramView);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (this.q != null)
    {
      b(paramInt);
      if (paramView.getId() == 2131435808)
      {
        paramView = new ReadInJoyCommentUtils.CommentReportR5Builder(this.q, null).a(this.R).a();
        PublicAccountReportUtils.a(RIJQQAppInterfaceUtil.b(), ReadInJoyCommentUtils.a(this.q), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.q.mArticleID), String.valueOf(this.q.mStrategyId), this.q.innerUniqueID, paramView, false);
        c(this.q);
      }
    }
  }
  
  private boolean a(boolean paramBoolean, GuidePopuppWindow.OnGuideDismissListener paramOnGuideDismissListener)
  {
    if (getQBaseActivity() == null)
    {
      QLog.d("ReadInJoyCommentListFragment", 0, "showGuidePopupWindow | activity is null");
      return false;
    }
    if (this.V == null) {
      this.V = new GuidePopuppWindow(getQBaseActivity(), this.q);
    }
    if ((paramBoolean) && ((this.V.a(this.q.innerUniqueID)) || (!CommentGuideConfigHandler.b()))) {
      return false;
    }
    this.V.a(new ReadInJoyCommentListFragment.9(this, paramOnGuideDismissListener));
    paramOnGuideDismissListener = this.d;
    if (paramOnGuideDismissListener != null) {
      paramOnGuideDismissListener.b();
    }
    this.V.a(this.q);
    this.V.a(getQBaseActivity().getWindow().getDecorView());
    return true;
  }
  
  private void b(View paramView)
  {
    E();
    this.N = TKDCommentFragmentHelper.a(2131435054, getChildFragmentManager());
    if (this.N != null)
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "createHippyFragment success");
      this.N.a(this.Q);
      c(paramView);
      t();
      v();
      this.N.getTKDHippyEventDispatcher().register(this.ad);
      this.N.getTKDHippyEventDispatcher().merge(this.P);
      this.P.clear();
      return;
    }
    QLog.d("ReadInJoyCommentListFragment", 1, "createHippyFragment failed");
  }
  
  private boolean b(AnchorData paramAnchorData)
  {
    if ((paramAnchorData == null) && (this.r == null)) {
      return true;
    }
    return (this.r != null) && (paramAnchorData != null) && (paramAnchorData.a != null) && (paramAnchorData.a.equals(this.r.a));
  }
  
  private boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (this.q != null) && (paramAbsBaseArticleInfo.innerUniqueID != null) && (paramAbsBaseArticleInfo.innerUniqueID.equals(this.q.innerUniqueID));
  }
  
  private void c(View paramView)
  {
    if (this.U)
    {
      paramView.setFitsSystemWindows(false);
      this.g = this.f;
    }
  }
  
  private void c(AnchorData paramAnchorData)
  {
    if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.a)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initAnchor ");
      ((StringBuilder)localObject).append(paramAnchorData.a);
      QLog.d("ReadInJoyCommentListFragment", 1, ((StringBuilder)localObject).toString());
      if ((!TextUtils.isEmpty(paramAnchorData.b)) && (!paramAnchorData.c))
      {
        this.b.setAlpha(0.0F);
        localObject = y();
        if (localObject != null)
        {
          ((FragmentTransaction)localObject).setCustomAnimations(2130772483, 0);
          this.e.a(this.q, paramAnchorData.a, paramAnchorData.b, this.t);
          ((FragmentTransaction)localObject).show(this.e);
          ((FragmentTransaction)localObject).commitAllowingStateLoss();
        }
        this.p = 2;
        ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentListFragment.3(this), 1000L);
      }
      this.d.a(new ReadInJoyCommentListFragment.4(this));
    }
  }
  
  private void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    VideoReport.reportEvent("clck", new RIJDtParamBuilder().f("write_comment_button").e(paramAbsBaseArticleInfo.innerUniqueID).c("click_write_comment").a().c());
  }
  
  private void c(boolean paramBoolean)
  {
    this.b.setOnGestureExitListener(this);
    if (paramBoolean)
    {
      TKDCommentFragment localTKDCommentFragment = this.N;
      if (localTKDCommentFragment != null)
      {
        localTKDCommentFragment.a(this.b);
        QLog.d("ReadInJoyCommentListFragment", 1, "tkdCommentFragment set FlingExitLayout success");
        break label52;
      }
    }
    this.b.setListView(this.c);
    label52:
    if (this.U) {
      this.b.findViewById(2131450248).setBackgroundResource(2130842682);
    }
  }
  
  private void d(View paramView)
  {
    this.g = paramView;
    this.k = ((TextView)paramView.findViewById(2131448343));
    this.n = ((LinearLayout)paramView.findViewById(2131429638));
    if (this.k.getPaint() != null) {
      this.k.getPaint().setFakeBoldText(true);
    }
    this.c = ((ReadInJoyCommentListView)paramView.findViewById(2131431094));
    this.m = ((TextView)paramView.findViewById(2131433080));
    this.l = ((FrameLayout)this.b.findViewById(2131440504));
    this.l.setOnClickListener(this);
    this.o = ((RelativeLayout)this.b.findViewById(2131437583));
    E();
    c(paramView);
    c(1);
    if (this.E != null)
    {
      A();
      F();
      z();
    }
    g(paramView);
    D();
    C();
    B();
    f(paramView);
    if (this.A) {
      i();
    }
    w();
    this.w = true;
    Object localObject = this.T;
    if (localObject != null) {
      ((ReadInJoyCommentListFragment.OnCreateViewListener)localObject).onViewCreated(this.w);
    }
    localObject = this.q;
    if ((localObject != null) && (!this.F))
    {
      a((AbsBaseArticleInfo)localObject, this.r, this.y, 5, this.t);
      QLog.d("ReadInJoyCommentListFragment", 0, "onCreateView | fetchCommentDataByViola");
    }
    e(paramView);
    x();
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.L != null) {}
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        if (!paramBoolean) {
          break label136;
        }
        Object localObject1 = "1";
        ((JSONObject)localObject2).put("replyViewStatus", localObject1);
        this.L.onViewState(paramBoolean, ((JSONObject)localObject2).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifySecondCommentViewStateChanged | visible ");
        ((StringBuilder)localObject1).append(paramBoolean);
        ((StringBuilder)localObject1).append("; jsonStr ");
        ((StringBuilder)localObject1).append(((JSONObject)localObject2).toString());
        QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject1).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("notifySecondCommentViewStateChanged ");
        ((StringBuilder)localObject2).append(localJSONException.getMessage());
        QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject2).toString());
      }
      return;
      label136:
      String str = "2";
    }
  }
  
  private void e(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.i = paramView.findViewById(2131439345);
    this.i.setOnClickListener(this);
    this.h = paramView.findViewById(2131439362);
    this.h.setOnClickListener(this);
    this.j = paramView.findViewById(2131441404);
    this.j.setOnClickListener(null);
  }
  
  private void f(View paramView)
  {
    this.Z = new ReadInJoyCommentListView.MultiScrollListener();
    this.Z.addScrollListener(this.aa);
    this.c.setOnScrollListener(this.Z);
    paramView.findViewById(2131430816).setOnClickListener(this);
    paramView.findViewById(2131435808).setOnClickListener(this);
    paramView.findViewById(2131447463).setOnClickListener(this);
    paramView.findViewById(2131439346).setOnClickListener(this);
    ReadInJoyCommentUtils.OnFragmentViewCreateListener localOnFragmentViewCreateListener = this.Y;
    if (localOnFragmentViewCreateListener != null) {
      localOnFragmentViewCreateListener.a(paramView);
    }
    ReadInJoyDropFrameHelper.d().a(6666, this);
  }
  
  private void g(View paramView)
  {
    View localView;
    if (this.B)
    {
      localView = paramView.findViewById(2131431065);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.D)
    {
      localView = paramView.findViewById(2131445770);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.C)
    {
      localView = paramView.findViewById(2131429563);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    h(paramView);
    i(paramView);
  }
  
  private void h(View paramView)
  {
    if ((!this.B) && (!this.D) && (RIJCommentAtUi.a()))
    {
      paramView = paramView.findViewById(2131431060);
      paramView.setVisibility(0);
      paramView.setOnClickListener(this);
    }
  }
  
  private void i(View paramView)
  {
    if ((!this.B) && (!this.D))
    {
      paramView = paramView.findViewById(2131431077);
      paramView.setVisibility(0);
      paramView.setOnClickListener(this);
    }
  }
  
  private void j(View paramView)
  {
    a(paramView, 0);
  }
  
  private void s()
  {
    Object localObject = this.N;
    if (localObject != null)
    {
      localObject = ((TKDCommentFragment)localObject).getPerformanceData();
      if (localObject != null)
      {
        long l1 = ((Long)((HashMap)localObject).get("openPageStart")).longValue();
        long l2 = ((Long)((HashMap)localObject).get("loadModuleEnd")).longValue();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hippy cost: ");
        ((StringBuilder)localObject).append(l2 - l1);
        QLog.d("ReadInJoyCommentListFragment", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void t()
  {
    Object localObject = this.N;
    if (localObject == null) {
      return;
    }
    ((TKDCommentFragment)localObject).a(this.q);
    this.N.a(this.A);
    this.N.a(ReadInJoyCommentHelper.a(this.t));
    this.N.b(this.z);
    if (this.b != null) {
      c(true);
    }
    localObject = this.r;
    if (localObject != null) {
      this.N.a((AnchorData)localObject);
    }
  }
  
  private void u()
  {
    ((RelativeLayout)this.b.findViewById(2131444985)).setVisibility(0);
  }
  
  private void v()
  {
    ((RelativeLayout)this.b.findViewById(2131444985)).setVisibility(8);
  }
  
  private void w()
  {
    if ((getQBaseActivity() != null) && (ThemeUtil.isInNightMode(RIJQQAppInterfaceUtil.b())))
    {
      View localView = new View(getQBaseActivity());
      localView.setBackgroundColor(1996488704);
      getQBaseActivity().addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  private void x()
  {
    this.H = LayoutInflater.from(getQBaseActivity()).inflate(2131629130, null, false);
    this.I = this.H.findViewById(2131439345);
    this.K = this.H.findViewById(2131439362);
    this.J = this.H.findViewById(2131437648);
    ReadInJoyCommentListView localReadInJoyCommentListView = this.c;
    if ((localReadInJoyCommentListView != null) && (this.F)) {
      localReadInJoyCommentListView.addHeaderView(this.H);
    }
  }
  
  private FragmentTransaction y()
  {
    if (this.O)
    {
      if (getChildFragmentManager() != null) {
        return getChildFragmentManager().beginTransaction();
      }
    }
    else if ((getQBaseActivity() != null) && (getQBaseActivity().getSupportFragmentManager() != null)) {
      return getQBaseActivity().getSupportFragmentManager().beginTransaction();
    }
    return null;
  }
  
  private void z()
  {
    if (this.g != null)
    {
      Object localObject = this.E;
      if ((localObject != null) && (((ReadInJoyCommentListFragment.ViewParams)localObject).c > 0))
      {
        this.g.setPadding(0, this.E.c, 0, this.E.d);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setPaddingTop : ");
        ((StringBuilder)localObject).append(this.E.c);
        QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.t = paramInt;
    this.R = paramInt;
  }
  
  public void a(Bundle paramBundle, ReadInJoyCommentUtils.FirstCommentEvent paramFirstCommentEvent, ViewGroup paramViewGroup)
  {
    this.X = paramFirstCommentEvent;
    this.f = paramViewGroup;
    setArguments(paramBundle);
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.W = paramLayoutInflateProcessor;
  }
  
  public void a(ReadInJoyCommentHelper.ISecondCommentViewStateListener paramISecondCommentViewStateListener)
  {
    this.L = paramISecondCommentViewStateListener;
  }
  
  public void a(ReadInJoyCommentItemHeightHelper.OnScrollYOffsetListener paramOnScrollYOffsetListener)
  {
    ReadInJoyCommentListAdapter localReadInJoyCommentListAdapter = this.d;
    if (localReadInJoyCommentListAdapter != null) {
      localReadInJoyCommentListAdapter.a(paramOnScrollYOffsetListener);
    }
  }
  
  public void a(ReadInJoyCommentListFragment.OnCreateViewListener paramOnCreateViewListener)
  {
    if (paramOnCreateViewListener != null) {
      this.T = paramOnCreateViewListener;
    }
  }
  
  public void a(AnchorData paramAnchorData)
  {
    this.r = paramAnchorData;
    TKDCommentFragment localTKDCommentFragment = this.N;
    if ((localTKDCommentFragment != null) && (paramAnchorData != null)) {
      localTKDCommentFragment.a(paramAnchorData);
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.u = paramCommonCommentData;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.q = paramAbsBaseArticleInfo;
    TKDCommentFragment localTKDCommentFragment = this.N;
    if ((localTKDCommentFragment != null) && (paramAbsBaseArticleInfo != null)) {
      localTKDCommentFragment.a(paramAbsBaseArticleInfo);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, int paramInt, boolean paramBoolean)
  {
    this.z = paramBoolean;
    a(paramAbsBaseArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt)
  {
    if ((!a()) && (!TKDCommentFragmentHelper.b()) && (b(paramAbsBaseArticleInfo)) && (b(paramAnchorData)))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "cache fragment data");
      this.S.b();
      this.x = true;
      paramAbsBaseArticleInfo = this.d;
      if (paramAbsBaseArticleInfo != null) {
        paramAbsBaseArticleInfo.notifyDataSetChanged();
      }
      return;
    }
    a(paramAbsBaseArticleInfo, paramAnchorData, paramBoolean, 5, paramInt);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.y = paramBoolean;
    Object localObject = this.q;
    if (localObject != null)
    {
      localObject = ReadInJoyCommentDataManager.a((AbsBaseArticleInfo)localObject);
      if (localObject != null) {
        ((ReadInJoyCommentDataManager)localObject).n().a(false, this.c);
      }
      ReadInJoyCommentDataManager.b(this.q, paramInt1);
    }
    this.S.b();
    this.q = paramAbsBaseArticleInfo;
    this.r = paramAnchorData;
    if (!this.w) {
      return;
    }
    this.x = true;
    if (!a())
    {
      if (!NetworkUtil.isNetworkAvailable(getQBaseActivity())) {
        c(3);
      } else {
        c(1);
      }
      c(paramAnchorData);
      localObject = this.d;
      if (localObject != null)
      {
        ((ReadInJoyCommentListAdapter)localObject).a(this.u);
        this.d.a(paramAbsBaseArticleInfo, paramAnchorData, paramBoolean, paramInt1, paramInt2, this.z);
      }
      paramAbsBaseArticleInfo = this.c;
      if (paramAbsBaseArticleInfo != null) {
        paramAbsBaseArticleInfo.resetState();
      }
      K();
      L();
      return;
    }
    if (this.G) {
      this.N.getTKDHippyEventDispatcher().refreshNewAndHotData(this.N.f());
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.m;
    if (localTextView == null) {
      return;
    }
    localTextView.setText(paramString);
    this.m.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.X != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      RIJTransMergeKanDianReport.a(0, this.R, i1);
      this.X.a(false);
    }
    Object localObject = this.N;
    if (localObject != null) {
      ((TKDCommentFragment)localObject).g();
    }
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.b();
    String str = ReadInJoyCommentUtils.a(this.q);
    if (this.t == 2) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    PublicAccountReportUtils.a(localQQAppInterface, str, "0X800920E", "0X800920E", 0, 0, (String)localObject, String.valueOf(1), "", "", false);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSubCommentFragmentVisible | visible ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ReadInJoyCommentListFragment", 0, ((StringBuilder)localObject).toString());
    d(paramBoolean);
    if (!paramBoolean)
    {
      paramString1 = y();
      if (paramString1 != null)
      {
        paramBoolean = TextUtils.isEmpty(paramString2);
        paramString2 = this.E;
        int i1;
        if ((paramString2 != null) && (paramString2.h == 2)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if ((!(paramBoolean ^ true)) && (i1 == 0)) {
          paramString1.setCustomAnimations(2130771998, 2130772030);
        } else {
          paramString1.setCustomAnimations(2130772482, 0);
        }
        paramString1.hide(this.e);
        this.e.h();
        paramString1.commitAllowingStateLoss();
      }
      this.p = 1;
      this.b.setCommentLevel(this.p);
      this.b.a(true);
      paramString1 = this.d;
      if (paramString1 != null) {
        paramString1.notifyDataSetChanged();
      }
      this.S.b();
      if (this.F) {
        this.l.setVisibility(8);
      }
    }
    else
    {
      this.S.c();
      if (this.q == null) {
        return;
      }
      localObject = y();
      if (localObject != null)
      {
        ReadInJoyCommentListFragment.ViewParams localViewParams = this.E;
        if ((localViewParams != null) && (localViewParams.h == 2)) {
          ((FragmentTransaction)localObject).setCustomAnimations(2130772482, 0);
        } else {
          ((FragmentTransaction)localObject).setCustomAnimations(2130771998, 2130772030);
        }
        this.e.a(this.q, paramString1, paramString2, this.t);
        ((FragmentTransaction)localObject).show(this.e);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
      }
      this.p = 2;
      this.b.setCommentLevel(this.p);
      this.b.a(false);
      if (this.F) {
        this.l.setVisibility(0);
      }
    }
  }
  
  public boolean a()
  {
    return this.N != null;
  }
  
  @NonNull
  public ITKDHippyEventDispatcher b()
  {
    TKDCommentFragment localTKDCommentFragment = this.N;
    if (localTKDCommentFragment == null) {
      return this.P;
    }
    return localTKDCommentFragment.getTKDHippyEventDispatcher();
  }
  
  public void b(int paramInt)
  {
    if (this.q == null) {
      return;
    }
    if (a(true, new ReadInJoyCommentListFragment.7(this))) {
      return;
    }
    int i1 = 4;
    if (((this.q.mFeedType == 1) && (this.q.mSocialFeedInfo != null) && (this.q.mSocialFeedInfo.b == 5)) || (RIJFeedsType.a(this.q))) {
      i1 = 2;
    } else if ((RIJItemViewTypeUtils.o(this.q)) && (this.q.mSocialFeedInfo != null) && (this.q.mSocialFeedInfo.s != null))
    {
      if (RIJItemViewTypeUtils.b(this.q.mSocialFeedInfo.s.a)) {
        i1 = 9;
      }
    }
    else if (this.q.mIsGallery != 0) {
      i1 = 17;
    }
    CommentComponentArgs localCommentComponentArgs = new CommentComponentArgs().a(this.q).a(i1).a("").b(this.s).a(this.X).a(this.y).b(paramInt);
    ReadInJoyCommentUtils.a(getQBaseActivity(), localCommentComponentArgs);
  }
  
  public void b(boolean paramBoolean)
  {
    TKDCommentFragment localTKDCommentFragment = this.N;
    if (localTKDCommentFragment != null) {
      localTKDCommentFragment.a(paramBoolean);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.g == null) {
      return;
    }
    if (this.d == null) {
      return;
    }
    if (this.c == null) {
      return;
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.h;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.j;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.H != null)
    {
      localObject = this.K;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.I;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.J;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    if (this.c.getHeaderViewsCount() > 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            this.c.hideLoadingFooter();
            return;
          }
          localObject = this.K;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          this.c.hideLoadingFooter();
          QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noNetworkView");
          return;
        }
        localObject = this.I;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = this.c;
        if (localObject != null) {
          ((ReadInJoyCommentListView)localObject).loadingMoreComplete(false);
        }
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noCommentView");
        this.c.hideLoadingFooter();
        return;
      }
      localObject = this.J;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      this.c.hideLoadingFooter();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader loadingView");
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.c.setEmptyView(this.i);
          QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
          return;
        }
        this.c.setEmptyView(this.h);
        this.c.hideLoadingFooter();
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noNetworkView");
        return;
      }
      this.c.setEmptyView(this.i);
      this.c.hideLoadingFooter();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
      return;
    }
    this.c.setEmptyView(this.j);
    this.c.hideLoadingFooter();
    QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader loadingView");
  }
  
  public boolean c()
  {
    return this.F;
  }
  
  public ReadInJoyCommentListView d()
  {
    return this.c;
  }
  
  public void d(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void e()
  {
    if (this.q != null)
    {
      int i1 = this.v;
      if (i1 == 0) {
        i1 = 5;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchCommentDataByViola by viola feedstype ");
      localStringBuilder.append(i1);
      localStringBuilder.append("contentSrc ");
      localStringBuilder.append(this.t);
      QLog.d("ReadInJoyCommentListFragment", 0, localStringBuilder.toString());
      a(this.q, null, true, i1, this.t);
    }
  }
  
  public boolean f()
  {
    ReadInJoyCommentListFragment.ViewParams localViewParams = this.E;
    if (localViewParams != null) {
      return localViewParams.b;
    }
    return true;
  }
  
  public void g()
  {
    FrameLayout localFrameLayout = this.l;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(0);
    }
  }
  
  public void h()
  {
    this.b.findViewById(2131440504).setVisibility(8);
  }
  
  public void i()
  {
    b(0);
  }
  
  public void j()
  {
    this.x = false;
    ReadInJoyCommentListAdapter localReadInJoyCommentListAdapter = this.d;
    if ((localReadInJoyCommentListAdapter != null) && (localReadInJoyCommentListAdapter.q() != null))
    {
      this.d.q().b(k(), 2);
      this.d.q().a();
    }
  }
  
  public long k()
  {
    TimeSliceHelper localTimeSliceHelper = this.S;
    if (localTimeSliceHelper != null)
    {
      long l1 = localTimeSliceHelper.e();
      this.S.g();
      return l1;
    }
    return 0L;
  }
  
  public boolean l()
  {
    if (a())
    {
      H();
      return this.N.g();
    }
    return G();
  }
  
  public int m()
  {
    return this.p;
  }
  
  public int n()
  {
    return this.R;
  }
  
  ReadInJoyCommentUtils.FirstCommentEvent o()
  {
    return this.X;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (a())
    {
      this.N.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("arg_result_json");
      paramInt1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
      paramInt2 = paramIntent.getIntExtra("comment_cmd", 0);
      paramIntent = ReadInJoyCommentDataManager.a(this.q);
      if (paramIntent == null) {
        return;
      }
      if (paramInt2 == 1)
      {
        a(false, new ReadInJoyCommentListFragment.8(this));
        return;
      }
      ReadInJoyCommentListAdapter localReadInJoyCommentListAdapter = this.d;
      if (localReadInJoyCommentListAdapter != null)
      {
        if (paramInt1 == 2)
        {
          paramIntent.d(str, localReadInJoyCommentListAdapter.o());
          return;
        }
        if (paramInt1 == 3) {
          paramIntent.c_(str, localReadInJoyCommentListAdapter.o());
        }
      }
    }
    else if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == 1699))
    {
      if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      a(paramIntent, this.M, this.t, true, this.q, this.d.o(), paramInt1);
    }
  }
  
  public boolean onBackEvent()
  {
    return l();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131447463: 
      J();
      return;
    case 2131440504: 
      a(false, null, null);
      return;
    case 2131439345: 
    case 2131439362: 
      if (this.d != null)
      {
        c(1);
        this.d.a();
        return;
      }
      break;
    case 2131435808: 
    case 2131439346: 
      j(paramView);
      return;
    case 2131431077: 
      a(paramView, 1);
      return;
    case 2131431060: 
      a(paramView, 2);
      return;
    case 2131429563: 
    case 2131430816: 
    case 2131431065: 
    case 2131445770: 
      ReadInJoyCommentUtils.FirstCommentEvent localFirstCommentEvent = this.X;
      if (localFirstCommentEvent != null)
      {
        localFirstCommentEvent.onClick(paramView);
        this.X.a(I());
        paramView = this.d;
        if (paramView != null) {
          paramView.b = 0;
        }
        this.S.c();
      }
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = this.W;
    if (paramBundle != null) {
      paramLayoutInflater = paramBundle.a(2131626162, true, new ViewGroup.LayoutParams(-1, -1));
    } else {
      paramLayoutInflater = paramLayoutInflater.inflate(2131626162, paramViewGroup, false);
    }
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.d;
    if (localObject != null)
    {
      ((ReadInJoyCommentListAdapter)localObject).e();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((ReadInJoySecondCommentListFragment)localObject).onDestroy();
      this.e = null;
    }
    this.X = null;
    this.q = null;
    this.r = null;
    this.T = null;
    localObject = getQBaseActivity().getIntent().getBundleExtra("bundle");
    if (localObject != null) {
      ReadInJoyLogicEngineEventDispatcher.a().c(((Bundle)localObject).getInt("seq"));
    }
    localObject = this.M;
    if (localObject != null) {
      ((RIJBiuAndCommentMixDataManager)localObject).a();
    }
    ReadInJoyDropFrameHelper.d().b(6666, this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.ab);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (this.q == null) {
      return;
    }
    if (paramBoolean)
    {
      this.S.c();
      return;
    }
    this.S.b();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.p == 1) && (this.w) && (this.x)) {
      this.S.b();
    }
    ReadInJoySecondCommentListFragment localReadInJoySecondCommentListFragment = this.e;
    if (localReadInJoySecondCommentListFragment != null) {
      localReadInJoySecondCommentListFragment.d();
    }
    QLog.d("ReadInJoyCommentListFragment", 0, "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.q != null) {
      this.S.c();
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((ReadInJoySecondCommentListFragment)localObject).e();
    }
    if ((getQBaseActivity() != null) && (getQBaseActivity().isFinishing()))
    {
      localObject = this.d;
      if (localObject != null)
      {
        ReadInJoyCommentDataManager.b(this.q, ((ReadInJoyCommentListAdapter)localObject).o());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStop | removeCommentDataManager feedsType ");
        ((StringBuilder)localObject).append(this.d.o());
        QLog.d("ReadInJoyCommentListFragment", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void p()
  {
    AnchorData localAnchorData = this.r;
    if ((localAnchorData != null) && (this.d != null))
    {
      if (localAnchorData.d)
      {
        this.d.j();
        return;
      }
      this.d.i();
    }
  }
  
  public void q()
  {
    if (a()) {
      this.N.getActivityLifecycleDispatcher().onActivityResumed(getQBaseActivity());
    }
  }
  
  public void r()
  {
    if (a()) {
      this.N.getActivityLifecycleDispatcher().onActivityPaused(getQBaseActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment
 * JD-Core Version:    0.7.0.1
 */