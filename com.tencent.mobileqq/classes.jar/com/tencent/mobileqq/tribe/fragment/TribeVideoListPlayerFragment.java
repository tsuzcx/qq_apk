package com.tencent.mobileqq.tribe.fragment;

import amtj;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import azjl;
import bcef;
import bdli;
import bdlj;
import bdlk;
import bdll;
import bdlm;
import bdln;
import bdlo;
import bdlp;
import bdlq;
import bdlr;
import bdls;
import bdlt;
import bdlu;
import bdlv;
import bdlw;
import bdlx;
import bdly;
import bdlz;
import bdma;
import bdmb;
import bdmc;
import bdmd;
import bdmh;
import bdml;
import bdmr;
import bdms;
import bdmt;
import bdmu;
import bdmv;
import bfaj;
import bfur;
import bjnw;
import bjon;
import bkwm;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import lao;
import laq;
import lar;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import nma;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rzt;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import ytn;

public class TribeVideoListPlayerFragment
  extends PublicBaseFragment
  implements View.OnClickListener, rzt
{
  public static Handler a;
  public static WeakReference<TribeVideoPlugin> a;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "likes", "comments", "share", "topRightShare", "quickReply", "doReply" };
  public int a;
  public long a;
  protected AnimatorSet a;
  protected LinearLayoutManager a;
  protected View a;
  protected ImageView a;
  protected ProgressBar a;
  public RelativeLayout a;
  protected TextView a;
  public bdmh a;
  public VideoFeedsRecyclerView a;
  protected GdtAppReceiver a;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new bdlt(this);
  private TribeVideoListPlayerFragment.TribeWebViewFragment jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public ISuperPlayer a;
  protected SuperPlayerVideoInfo a;
  public ISPlayerVideoView a;
  public Runnable a;
  private String jdField_a_of_type_JavaLangString = "https://buluo.qq.com/mobile/short_video_list.html?bid=%d&pid=%s";
  public ArrayList<bdmr> a;
  public boolean a;
  protected int b;
  protected Handler b;
  public ImageView b;
  public RelativeLayout b;
  public TextView b;
  public boolean b;
  public int c;
  private ImageView c;
  public boolean c;
  protected int d;
  private ImageView d;
  public boolean d;
  public int e;
  public boolean e;
  protected int f;
  protected boolean f;
  protected int g;
  protected boolean g;
  public int h;
  protected boolean h;
  
  static
  {
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public TribeVideoListPlayerFragment()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    this.jdField_b_of_type_AndroidOsHandler = new bdlu(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new TribeVideoListPlayerFragment.26(this);
  }
  
  private void a(ImageView paramImageView)
  {
    paramImageView.setImageResource(2130843623);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.4F, 1.0F, 1.4F, 1, 0.5F, 1, 0.0F);
    localScaleAnimation.setRepeatCount(2147483647);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setRepeatMode(2);
    paramImageView.setAnimation(localScaleAnimation);
    localScaleAnimation.start();
  }
  
  private void a(bdmt parambdmt, String paramString1, String paramString2)
  {
    try
    {
      long l = parambdmt.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.trace_info.aid.get();
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(parambdmt);
      bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", paramString1, this.jdField_e_of_type_Int, 0, Long.toString(l), Integer.toString(i + 1), "", "");
      return;
    }
    catch (Exception parambdmt)
    {
      QLog.e("TribeVideoListPlayerFragment", 1, paramString2 + parambdmt.toString());
    }
  }
  
  private void a(bdmu parambdmu)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.isAdded()) && (!this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.isVisible())) {
        getActivity().getSupportFragmentManager().beginTransaction().show(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment).commitAllowingStateLoss();
      }
      c(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_Int);
      if (parambdmu.jdField_c_of_type_Int != 31) {
        break label167;
      }
    }
    label167:
    for (String str = "1";; str = "2")
    {
      bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_more", 0, 0, parambdmu.d, parambdmu.b + "", "", str);
      return;
      if ((!this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.webView == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.webView.loadUrl(this.jdField_a_of_type_JavaLangString);
      break;
    }
  }
  
  public static void a(TribeVideoPlugin paramTribeVideoPlugin)
  {
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTribeVideoPlugin);
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
  }
  
  private void b(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = new VideoFeedsRecyclerView(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setClipChildren(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    paramFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 0, new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_Bdmh = new bdmh(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Bdmh);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
  }
  
  private void b(bdmt parambdmt)
  {
    bjnw localbjnw = (bjnw)bjon.a(getActivity(), null);
    localbjnw.a(amtj.a(2131714114), 9, "#FFB800");
    localbjnw.c(2131690620);
    localbjnw.a(new bdlj(this));
    localbjnw.a(new bdlk(this, localbjnw, parambdmt));
    localbjnw.show();
    this.jdField_e_of_type_Boolean = true;
    a(parambdmt, "ad_Clk_dislike", "negative ad report error: e= ");
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getActivity());
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView instanceof View))
    {
      i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = a();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView, i, localLayoutParams);
      return;
      i = -1;
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getActivity());
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundColor(1711276032);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843258);
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2131367482);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bdli(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, -1, -1);
  }
  
  private void m()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837518);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  private void n()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getActivity());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131714119));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void o()
  {
    if (!azjl.a()) {
      azjl.a(BaseApplicationImpl.getApplication(), null);
    }
  }
  
  private void p()
  {
    int i = getActivity().getWindow().getDecorView().getSystemUiVisibility();
    if (Build.VERSION.SDK_INT >= 21)
    {
      i = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label70;
      }
      i |= 0x800;
    }
    for (;;)
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(i);
      return;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i = 1798;
      break;
      label70:
      i |= 0x1;
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment = new TribeVideoListPlayerFragment.TribeWebViewFragment();
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment = this;
    Object localObject1 = new Bundle();
    Intent localIntent = new Intent();
    Object localObject2 = (bdmr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if ((localObject2 instanceof bdmu))
    {
      localObject2 = (bdmu)localObject2;
      long l2 = ((bdmu)localObject2).b;
      long l1 = l2;
      if (((bdmu)localObject2).jdField_a_of_type_JavaUtilArrayList != null)
      {
        l1 = l2;
        if (((bdmu)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          l1 = ((bdms)((bdmu)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
        }
      }
      localIntent.putExtra("url", String.format(this.jdField_a_of_type_JavaLangString, new Object[] { Long.valueOf(l1), ((bdmu)localObject2).d }));
    }
    localIntent.putExtra("isTransparentTitleAndClickable", true);
    localIntent.putExtra("hide_left_button", true);
    localIntent.putExtra("hide_more_button", true);
    ((Bundle)localObject1).putParcelable("intent", localIntent);
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.setArguments((Bundle)localObject1);
    if (!this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.isAdded())
    {
      localObject1 = getActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject1).add(2131365087, this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment, "TransparentWebviewFragment");
      ((FragmentTransaction)localObject1).hide(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment).commitAllowingStateLoss();
    }
  }
  
  private void r()
  {
    Object localObject = (bdmd)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
    localObject = (bdmr)this.jdField_a_of_type_JavaUtilArrayList.get(((bdmd)localObject).jdField_a_of_type_Int);
    if ((localObject instanceof bdmu)) {
      a((bdmu)localObject);
    }
    while (!(localObject instanceof bdmt)) {
      return;
    }
    b((bdmt)localObject);
  }
  
  @TargetApi(11)
  private void s()
  {
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
    localObjectAnimator1.setDuration(1800L);
    localObjectAnimator1.setRepeatCount(-1);
    localObjectAnimator1.setRepeatMode(1);
    localObjectAnimator1.setStartDelay(100L);
    localObjectAnimator2.setDuration(1800L);
    localObjectAnimator2.setRepeatCount(-1);
    localObjectAnimator2.setRepeatMode(1);
    localObjectAnimator2.setStartDelay(240L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
  }
  
  public Spannable a(bdmu parambdmu)
  {
    Object localObject = bfaj.a(parambdmu.j.replaceAll("\024", ""));
    if ((float)(DeviceInfoUtil.getWidth() - DisplayUtil.dip2px(getActivity(), 24.0F)) == 0.0F) {
      return null;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(DisplayUtil.dip2px(getActivity(), 14.0F));
    int j = ((String)localObject).indexOf("{{");
    int i = ((String)localObject).indexOf("}}");
    if ((j >= 0) && (i > j)) {
      localObject = ((String)localObject).substring(0, j) + amtj.a(2131714123) + ((String)localObject).substring(i + 2);
    }
    for (i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(parambdmu.i))
      {
        localObject = new QQText("# " + parambdmu.i + " " + (String)localObject, 2, 16);
        ((QQText)localObject).setSpan(new ytn(getActivity(), 2130843638), 0, 1, 33);
        ((QQText)localObject).setSpan(new ytn(getActivity(), 2130842934), 1, 2, 33);
        ((QQText)localObject).setSpan(new ytn(getActivity(), 2130845776), parambdmu.i.length() + 2, parambdmu.i.length() + 3, 33);
        ((QQText)localObject).setSpan(new ForegroundColorSpan(-18432), 2, parambdmu.i.length() + 2, 33);
        ((QQText)localObject).setSpan(new bdlp(this, parambdmu), 2, parambdmu.i.length() + 2, 33);
      }
      for (parambdmu = (bdmu)localObject;; parambdmu = new QQText((CharSequence)localObject, 2, 16))
      {
        if (i != 0) {
          parambdmu.setSpan(new ytn(getActivity(), 2130843630), j, j + 1, 33);
        }
        return parambdmu;
      }
    }
  }
  
  protected ISuperPlayer a(ISPlayerVideoView paramISPlayerVideoView)
  {
    paramISPlayerVideoView.removeViewCallBack(null);
    paramISPlayerVideoView = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 111, paramISPlayerVideoView);
    a(paramISPlayerVideoView);
    return paramISPlayerVideoView;
  }
  
  @NotNull
  protected ISPlayerVideoView a()
  {
    ISPlayerVideoView localISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(getActivity());
    localISPlayerVideoView.addViewCallBack(new bdly(this));
    return localISPlayerVideoView;
  }
  
  public String a(int paramInt)
  {
    if (paramInt >= 10000)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("###.#");
      return localDecimalFormat.format(paramInt / 10000.0D) + amtj.a(2131714130);
    }
    if (paramInt > 0) {
      return String.valueOf(paramInt);
    }
    return amtj.a(2131714132);
  }
  
  public String a(int paramInt, String paramString)
  {
    float f1;
    Object localObject;
    String str;
    label75:
    float f3;
    int j;
    if (paramInt == 1)
    {
      f1 = (float)(DeviceInfoUtil.getWidth() - DisplayUtil.dip2px(getActivity(), 40.0F));
      localObject = new Paint();
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setTextSize(DisplayUtil.dip2px(getActivity(), 12.0F));
      str = amtj.a(2131714127);
      float f2 = ((Paint)localObject).measureText(str);
      i = 0;
      paramInt = 0;
      if (i >= paramString.length()) {
        break label228;
      }
      f3 = ((Paint)localObject).measureText(paramString, 0, i + 1);
      if (f3 + f2 >= f1) {
        break label178;
      }
      j = i + 1;
    }
    label178:
    do
    {
      i += 1;
      paramInt = j;
      break label75;
      if (paramInt == 2)
      {
        f1 = (float)((DeviceInfoUtil.getWidth() - DisplayUtil.dip2px(getActivity(), 66.0F)) / 2L);
        break;
      }
      f1 = (float)((DeviceInfoUtil.getWidth() - DisplayUtil.dip2px(getActivity(), 92.0F)) / 3L);
      break;
      j = paramInt;
    } while (f3 < f1);
    label228:
    for (int i = 1;; i = 0)
    {
      localObject = paramString;
      if (i != 0) {
        localObject = paramString.substring(0, paramInt) + str;
      }
      return localObject;
    }
  }
  
  public void a(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(paramInt);
    localValueAnimator.addUpdateListener(new bdls(this));
    localValueAnimator.start();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bdml localbdml = (bdml)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
    bdmu localbdmu = localbdml.jdField_a_of_type_Bdmu;
    if (localbdmu == null) {}
    do
    {
      return;
      if (paramInt1 == 1)
      {
        localbdmu.l += paramInt2;
        a(localbdml.i);
        localbdml.jdField_e_of_type_AndroidWidgetTextView.setText(a(localbdmu.l));
        localbdml.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
        return;
      }
    } while (paramInt1 != 0);
    localbdmu.m += paramInt2;
    localbdml.jdField_a_of_type_AndroidWidgetTextView.setText(a(localbdmu.m));
    localbdml.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
  }
  
  public void a(int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("client_ver", "8.4.8");
      localJSONObject.put("from", "1");
      localJSONObject.put("targetuin", paramString);
      localJSONObject.put("operation", paramInt);
      localJSONObject.put("sourceid", 10013);
      localJSONObject.put("sub_sourceid", 5);
      paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), nma.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString.setObserver(paramBusinessObserver);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_f_of_type_Int == 1) {}
    while (((this.jdField_a_of_type_JavaUtilArrayList.size() <= 2) || (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size() - 2)) && ((this.jdField_a_of_type_JavaUtilArrayList.size() > 2) || (paramInt != 0)) && (!paramBoolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, new Object[] { "onLoadMore listSize:%d", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
    }
    bdmu localbdmu = (bdmu)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    bdmv.a(this.jdField_a_of_type_Bdmh.getItemCount() + this.jdField_a_of_type_Int, 10, this.jdField_c_of_type_Int, localbdmu.jdField_h_of_type_Int, localbdmu.b, localbdmu.d, this.jdField_d_of_type_Int, new bdmb(this, localbdmu));
    d(1);
  }
  
  protected void a(long paramLong, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bid", paramLong);
      localJSONObject.put("pid", paramString);
      localJSONObject.put("theme_id", paramInt);
      paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), nma.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.shortvideo_readreport");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString.setObserver(new bdlr(this));
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong, String paramString, BusinessObserver paramBusinessObserver)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bid", paramLong);
      localJSONObject.put("pid", paramString);
      localJSONObject.put("like", 1);
      paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), nma.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.like");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString.setObserver(paramBusinessObserver);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(Dialog paramDialog)
  {
    if ((paramDialog instanceof bjnw)) {
      p();
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_Int = -1;
    j();
    if ((!(paramViewHolder instanceof bdmd)) || (this.jdField_g_of_type_Int == ((bdmd)paramViewHolder).jdField_a_of_type_Int)) {
      return;
    }
    Object localObject;
    boolean bool;
    label149:
    bdmu localbdmu;
    label215:
    label247:
    String str;
    if ((((bdmd)paramViewHolder).jdField_a_of_type_Int > this.jdField_g_of_type_Int) || (((bdmd)paramViewHolder).jdField_a_of_type_Int != this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent();
      if (localObject != null)
      {
        d();
        if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()) {
          this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
        }
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      if ((paramViewHolder instanceof bdml))
      {
        a((bdmd)paramViewHolder);
        a((bdml)paramViewHolder);
        bool = false;
        if ((paramViewHolder instanceof bdml))
        {
          localbdmu = (bdmu)this.jdField_a_of_type_JavaUtilArrayList.get(((bdml)paramViewHolder).jdField_a_of_type_Int);
          localObject = (bdml)paramViewHolder;
          if ((localbdmu.jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!localbdmu.jdField_c_of_type_Boolean)) {
            break label476;
          }
          ((bdml)localObject).c.setVisibility(8);
          if (localbdmu.jdField_h_of_type_Int == 0) {
            break label508;
          }
          localObject = "" + localbdmu.jdField_h_of_type_Int;
          if (localbdmu.jdField_c_of_type_Int != 31) {
            break label514;
          }
          str = "1";
          label262:
          if (((bdml)paramViewHolder).jdField_a_of_type_Int <= this.jdField_g_of_type_Int) {
            break label522;
          }
          bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "slide_up", this.jdField_e_of_type_Int, 0, localbdmu.d, "" + localbdmu.b, (String)localObject, str);
        }
      }
    }
    for (;;)
    {
      a(((bdmd)paramViewHolder).jdField_a_of_type_Int, bool);
      this.jdField_g_of_type_Int = ((bdmd)paramViewHolder).jdField_a_of_type_Int;
      return;
      if (!(paramViewHolder instanceof bdmc)) {
        break;
      }
      a((bdmd)paramViewHolder);
      localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(200L);
      ((AlphaAnimation)localObject).setStartOffset(3000L);
      ((AlphaAnimation)localObject).setFillAfter(true);
      ((bdmc)paramViewHolder).jdField_a_of_type_AndroidViewView.clearAnimation();
      ((bdmc)paramViewHolder).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((bdmc)paramViewHolder).jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
      if (((bdmc)paramViewHolder).jdField_a_of_type_Bdmt.jdField_b_of_type_Boolean) {
        break;
      }
      ((bdmc)paramViewHolder).jdField_a_of_type_Bdmt.jdField_b_of_type_Boolean = true;
      ThreadManager.excute(new TribeVideoListPlayerFragment.7(this, paramViewHolder), 128, null, true);
      break;
      bool = true;
      break label149;
      label476:
      ((bdml)localObject).c.setVisibility(0);
      ((bdml)localObject).l.clearAnimation();
      ((bdml)localObject).k.clearAnimation();
      ((bdml)localObject).jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label215;
      label508:
      localObject = "";
      break label247;
      label514:
      str = "2";
      break label262;
      label522:
      if (((bdml)paramViewHolder).jdField_a_of_type_Int < this.jdField_g_of_type_Int) {
        bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "slide_down", this.jdField_e_of_type_Int, 0, localbdmu.d, "" + localbdmu.b, (String)localObject, str);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  @SuppressLint({"DefaultLocale"})
  protected void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_AndroidViewView = paramFrameLayout.findViewById(2131364627);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    paramFrameLayout.findViewById(2131370703).setOnClickListener(this);
    b(paramFrameLayout);
    o();
    k();
    l();
    m();
    n();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getActivity()).inflate(2131560569, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131370292));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131370296));
    d(0);
    int i = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_JavaLangString += String.format("&x=%d&y=%d", new Object[] { Integer.valueOf(DisplayUtil.dip2px(getActivity(), 180.0F)), Integer.valueOf(i - DisplayUtil.dip2px(getActivity(), 30.0F)) });
    LiuHaiUtils.a(getActivity());
    if ((LiuHaiUtils.b()) && (!LiuHaiUtils.jdField_d_of_type_Boolean) && (LiuHaiUtils.enableNotch(getActivity()))) {
      paramFrameLayout.findViewById(2131370719).setPadding(0, LiuHaiUtils.jdField_a_of_type_Int - DisplayUtil.dip2px(getActivity(), 10.0F), 0, 0);
    }
  }
  
  public void a(bdmd parambdmd)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    Object localObject2 = (bdmr)this.jdField_a_of_type_JavaUtilArrayList.get(parambdmd.jdField_a_of_type_Int);
    k();
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = a(this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(new bdll(this, parambdmd));
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent();
    if (localObject1 != null) {
      ((ViewGroup)localObject1).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    parambdmd.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, -1, -1);
    parambdmd.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    ((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setAlpha(0.0F);
    label186:
    int i;
    label266:
    long l;
    label280:
    int j;
    if (!TextUtils.isEmpty(((bdmr)localObject2).jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(((bdmr)localObject2).jdField_a_of_type_JavaLangString, 101, "");
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(getActivity(), this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo, 0L);
      if (!((bdmr)localObject2).jdField_a_of_type_Boolean) {
        break label391;
      }
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setXYaxis(0);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
      ((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setTag(parambdmd);
      this.jdField_a_of_type_Boolean = false;
      b(0);
      e();
      parambdmd = "";
      localObject1 = "";
      if (!(localObject2 instanceof bdmu)) {
        break label411;
      }
      localObject1 = (bdmu)localObject2;
      i = ((bdmu)localObject1).jdField_h_of_type_Int;
      if (((bdmu)localObject1).jdField_c_of_type_Int != 31) {
        break label404;
      }
      parambdmd = "1";
      l = ((bdmu)localObject1).b;
      localObject1 = ((bdmu)localObject1).d;
      j = this.jdField_e_of_type_Int;
      if (l == 0L) {
        break label446;
      }
      localObject2 = "" + l;
      label314:
      if (i == 0) {
        break label453;
      }
    }
    label391:
    label404:
    label411:
    label446:
    label453:
    for (String str = "" + i;; str = "")
    {
      bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv", j, 0, (String)localObject1, (String)localObject2, str, parambdmd);
      a(l, (String)localObject1, i);
      return;
      this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(4080303, ((bdmr)localObject2).c);
      break;
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setXYaxis(2);
      break label186;
      parambdmd = "2";
      break label266;
      if ((localObject2 instanceof bdmt))
      {
        parambdmd = "100";
        a((bdmt)localObject2, "ad_vv", "ad_vv: e= ");
      }
      l = 0L;
      i = 0;
      break label280;
      localObject2 = "";
      break label314;
    }
  }
  
  protected void a(bdml parambdml)
  {
    bdmu localbdmu = parambdml.jdField_a_of_type_Bdmu;
    if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.webView != null)
    {
      int[] arrayOfInt = new int[2];
      parambdml.i.getLocationOnScreen(arrayOfInt);
      long l2 = localbdmu.b;
      long l1 = l2;
      if (localbdmu.jdField_a_of_type_JavaUtilArrayList != null)
      {
        l1 = l2;
        if (localbdmu.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          l1 = ((bdms)localbdmu.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
        }
      }
      this.jdField_a_of_type_JavaLangString = String.format(this.jdField_a_of_type_JavaLangString, new Object[] { Long.valueOf(l1), localbdmu.d });
      if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_b_of_type_Boolean)
      {
        parambdml = "javascript:mqq.dispatchEvent(\"updateVideo\",{\"bid\":" + l1 + ",\"pid\":\"" + localbdmu.d + "\"})";
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.webView.callJs(parambdml);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.webView.loadUrl(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bdmt parambdmt)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_c_of_type_Int = 7;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(parambdmt.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = true;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    localParams.jdField_b_of_type_JavaLangClass = TribeGdtCanvasFragment.class;
    localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_buluo");
    GdtHandler.a(localParams);
    a(parambdmt, "ad_Clk", "handleADClick report error: e= ");
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void a(bdmt parambdmt, long paramLong1, long paramLong2)
  {
    a(parambdmt, paramLong1, paramLong2, false);
  }
  
  protected void a(bdmt parambdmt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    ThreadManager.excute(new TribeVideoListPlayerFragment.6(this, paramBoolean, parambdmt, paramLong2, paramLong1), 128, null, true);
  }
  
  protected void a(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer.setOnCompletionListener(new bdlv(this));
    paramISuperPlayer.setOnErrorListener(new bdlw(this));
    paramISuperPlayer.setOnInfoListener(new bdlx(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView == null) {}
    for (;;)
    {
      return;
      Object localObject2;
      JSONObject localJSONObject;
      if ((((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag() instanceof bdml))
      {
        localObject1 = (bdml)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
        localObject1 = (bdmr)this.jdField_a_of_type_JavaUtilArrayList.get(((bdml)localObject1).jdField_a_of_type_Int);
        if (!(localObject1 instanceof bdmu)) {
          continue;
        }
        localObject2 = (bdmu)localObject1;
        if (((bdmu)localObject2).jdField_h_of_type_Int != 0) {
          localObject1 = "" + ((bdmu)localObject2).jdField_h_of_type_Int;
        }
        for (;;)
        {
          int i;
          if (((bdmu)localObject2).jdField_c_of_type_Int == 31)
          {
            i = 1;
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put("timeofplayed", this.jdField_h_of_type_Int);
            localJSONObject.put("totaltime", ((bdmu)localObject2).jdField_a_of_type_Long);
            localJSONObject.put("report", ((bdmu)localObject2).jdField_a_of_type_OrgJsonJSONObject);
            bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv_time", this.jdField_e_of_type_Int, i, ((bdmu)localObject2).d, "" + ((bdmu)localObject2).b, (String)localObject1, localJSONObject.toString());
            return;
            localObject1 = "";
            continue;
            i = 2;
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              localJSONException1.printStackTrace();
            }
          }
        }
      }
      if (!(((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag() instanceof bdmc)) {
        continue;
      }
      Object localObject1 = (bdmr)this.jdField_a_of_type_JavaUtilArrayList.get(((bdmc)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag()).jdField_a_of_type_Int);
      if ((localObject1 instanceof bdmt))
      {
        localObject2 = (bdmt)localObject1;
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("timeofplayed", this.jdField_h_of_type_Int);
        localJSONObject.put("totaltime", ((bdmt)localObject2).jdField_a_of_type_Long);
        bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv_time", this.jdField_e_of_type_Int, 100, "", "", "", localJSONObject.toString());
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "ad_vv_time", this.jdField_e_of_type_Int, 0, "" + ((bdmt)localObject2).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.trace_info.aid.get(), "" + (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject2) + 1), "" + ((bdmt)localObject2).jdField_a_of_type_Long, "" + this.jdField_h_of_type_Int);
          if ((!(localObject1 instanceof bdmt)) || (this.jdField_c_of_type_Boolean)) {
            continue;
          }
          a((bdmt)localObject1, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), paramBoolean);
          return;
          localJSONException2 = localJSONException2;
          localJSONException2.printStackTrace();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TribeVideoListPlayerFragment", 2, "ad_vv_time: " + QLog.getStackTraceString(localException));
            }
          }
        }
      }
    }
  }
  
  public String b(int paramInt)
  {
    if (paramInt >= 10000)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("###.#");
      return localDecimalFormat.format(paramInt / 10000.0D) + amtj.a(2131714120);
    }
    if (paramInt > 0) {
      return String.valueOf(paramInt);
    }
    return amtj.a(2131714110);
  }
  
  protected void b()
  {
    Object localObject = getActivity().getIntent();
    String str = ((Intent)localObject).getStringExtra("feeds");
    this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("start", 0);
    this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("num", 0);
    this.jdField_c_of_type_Int = ((Intent)localObject).getIntExtra("type", 0);
    this.jdField_e_of_type_Int = ((Intent)localObject).getIntExtra("source_type", 0);
    this.jdField_d_of_type_Int = ((Intent)localObject).getIntExtra("recommend_by_bid", -1);
    if (str != null) {}
    try
    {
      localObject = new JSONArray(str);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(bdmu.a((JSONArray)localObject));
      this.jdField_a_of_type_Bdmh.notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new TribeVideoListPlayerFragment.4(this));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void b(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(paramInt);
    localValueAnimator.addUpdateListener(new bdlz(this));
    localValueAnimator.start();
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(bdmd parambdmd)
  {
    Message localMessage = new Message();
    localMessage.obj = parambdmd;
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 33L);
  }
  
  protected void c()
  {
    Object localObject1 = new bdma(this);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localObject1 = new laq((lar)localObject1);
    Object localObject2 = new qq_ad_get.QQAdGet.UserInfo();
    ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin());
    localQQAdGet.user_info.set((MessageMicro)localObject2, true);
    localObject2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).deep_link_version.set(1, true);
    qq_ad_get.QQAdGet.PositionInfo localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
    localPositionInfo.ad_count.set(1, true);
    localPositionInfo.pos_id.set("3000534547000254", true);
    localPositionInfo.pos_ext.set((MessageMicro)localObject2, true);
    localQQAdGet.position_info.add(localPositionInfo);
    localPositionInfo = new qq_ad_get.QQAdGet.PositionInfo();
    localPositionInfo.ad_count.set(1, true);
    localPositionInfo.pos_id.set("6060433537303235", true);
    localPositionInfo.pos_ext.set((MessageMicro)localObject2, true);
    localQQAdGet.position_info.add(localPositionInfo);
    localQQAdGet.support_https.set(true, true);
    localObject2 = GdtDeviceInfoHelper.create(getActivity());
    if (localObject2 != null) {
      localQQAdGet.device_info.set((MessageMicro)localObject2);
    }
    lao.a().a(getActivity(), BaseApplicationImpl.getApplication().getRuntime(), localQQAdGet, (BusinessObserver)localObject1);
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.webView == null)) {
      return;
    }
    String str = "javascript:mqq.dispatchEvent(\"startShowAnim\",{\"type\":\"" + jdField_a_of_type_ArrayOfJavaLangString[paramInt] + "\"})";
    jdField_a_of_type_AndroidOsHandler.post(new TribeVideoListPlayerFragment.9(this, str));
  }
  
  protected void d()
  {
    a(false);
  }
  
  public void d(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    case 1: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131714109));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    case 3: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131714126));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130843624, 0, 0, 0);
      bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "exp_nomore", this.jdField_e_of_type_Int, 0, "", "", "", "");
      return;
    case 4: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131714131));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  protected void e()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(500L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setRepeatMode(1);
    localRotateAnimation.setStartTime(-1L);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
  }
  
  public void e(int paramInt)
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    bdml localbdml;
    if ((((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag() instanceof bdml))
    {
      localbdml = (bdml)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
      if (localbdml != null) {}
    }
    else
    {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localbdml.j.setVisibility(8);
      localbdml.i.setVisibility(0);
      localbdml.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 1: 
      localbdml.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      localbdml.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      localbdml.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    localbdml.h.setVisibility(8);
    localbdml.g.setVisibility(0);
    localbdml.d.setVisibility(0);
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TribeVideoListPlayerFragment", 2, "onVideoError");
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    a(0);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(getActivity(), 230, null, amtj.a(2131714118), new bdlm(this), null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new bdln(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  protected void h()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = bkwm.a((AppRuntime)localObject1, true, true);
    if (localObject2 == null) {
      QLog.d("TribeVideoListPlayerFragment", 1, "showGuideView() failed");
    }
    do
    {
      do
      {
        return;
        if (!((SharedPreferences)localObject2).getBoolean("tribe_video_list_play_guide_view" + ((AppRuntime)localObject1).getAccount(), false)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("TribeVideoListPlayerFragment", 2, "is already show guide views");
      return;
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putBoolean("tribe_video_list_play_guide_view" + ((AppRuntime)localObject1).getAccount(), true);
      bkwm.a((SharedPreferences.Editor)localObject2, true);
      localObject1 = (FrameLayout)getActivity().getWindow().getDecorView();
      localObject2 = LayoutInflater.from(getActivity()).inflate(2131560572, (ViewGroup)localObject1, false);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131380267));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131380268));
      ((View)localObject2).setOnTouchListener(new bdlo(this, (FrameLayout)localObject1, (View)localObject2));
      jdField_a_of_type_AndroidOsHandler.postDelayed(new TribeVideoListPlayerFragment.16(this, (FrameLayout)localObject1, (View)localObject2), 5000L);
      ((FrameLayout)localObject1).addView((View)localObject2);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
        s();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
    b((bdml)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag());
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
  }
  
  protected void i()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(3000L);
    this.jdField_b_of_type_AndroidWidgetTextView.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new bdlq(this));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    e(0);
    e(1);
    e(2);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    this.jdField_h_of_type_Boolean = true;
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_h_of_type_Boolean = true;
      getActivity().finish();
      continue;
      r();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (FrameLayout)paramLayoutInflater.inflate(2131560570, paramViewGroup, false);
    a(paramLayoutInflater);
    b();
    q();
    h();
    bcef.b(null, "dc00899", "Grp_tribe", "", "video_player", "in", this.jdField_e_of_type_Int, 0, "", "", "", "");
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(getActivity());
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if ((this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView != null) && (((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getParent() != null)) {
      ((ViewGroup)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getParent()).removeView((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
    }
    d();
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      jdField_a_of_type_JavaLangRefWeakReference.clear();
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(getActivity());
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(0, 2130772330);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView != null) && (this.jdField_f_of_type_Boolean))
    {
      bdmd localbdmd = (bdmd)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
      if (((localbdmd instanceof bdmc)) && (!this.jdField_c_of_type_Boolean)) {
        a(((bdmc)localbdmd).jdField_a_of_type_Bdmt, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
      }
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
    }
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      b((bdmd)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag());
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
    this.jdField_g_of_type_Boolean = false;
    p();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView == null) {
      return;
    }
    p();
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      b((bdmd)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag());
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
    ((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setKeepScreenOn(true);
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView != null))
    {
      if (!this.jdField_f_of_type_Boolean)
      {
        bdmd localbdmd = (bdmd)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
        if (((localbdmd instanceof bdmc)) && (!this.jdField_c_of_type_Boolean))
        {
          a(((bdmc)localbdmd).jdField_a_of_type_Bdmt, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
          if (this.jdField_h_of_type_Boolean) {
            this.jdField_c_of_type_Boolean = true;
          }
        }
      }
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
      ((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setKeepScreenOn(false);
    }
  }
  
  public void y_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment
 * JD-Core Version:    0.7.0.1
 */