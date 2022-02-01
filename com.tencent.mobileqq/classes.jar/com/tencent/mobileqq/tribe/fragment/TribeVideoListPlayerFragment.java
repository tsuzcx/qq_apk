package com.tencent.mobileqq.tribe.fragment;

import acwb;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import anzj;
import bapg;
import bdll;
import begp;
import bfcu;
import bfcv;
import bfcw;
import bfcx;
import bfcy;
import bfcz;
import bfda;
import bfdb;
import bfdc;
import bfdd;
import bfde;
import bfdf;
import bfdg;
import bfdh;
import bfdi;
import bfdj;
import bfdk;
import bfdl;
import bfdm;
import bfdn;
import bfdo;
import bfdp;
import bfdt;
import bfdx;
import bfed;
import bfee;
import bfef;
import bfeg;
import bfeh;
import bgqv;
import bhgr;
import bhlo;
import bhlq;
import bhpc;
import blir;
import blji;
import bnrf;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
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
import lax;
import laz;
import lba;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import nkl;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rsp;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import zuc;

public class TribeVideoListPlayerFragment
  extends PublicBaseFragment
  implements View.OnClickListener, rsp
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
  public bfdt a;
  bhpc jdField_a_of_type_Bhpc;
  public VideoFeedsRecyclerView a;
  protected GdtAppReceiver a;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new bfdf(this);
  private TribeVideoListPlayerFragment.TribeWebViewFragment jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment;
  public ISuperPlayer a;
  protected SuperPlayerVideoInfo a;
  public ISPlayerVideoView a;
  public Runnable a;
  private String jdField_a_of_type_JavaLangString = "https://buluo.qq.com/mobile/short_video_list.html?bid=%d&pid=%s";
  public ArrayList<bfed> a;
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
    this.jdField_b_of_type_AndroidOsHandler = new bfdg(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new TribeVideoListPlayerFragment.26(this);
  }
  
  private void a(ImageView paramImageView)
  {
    paramImageView.setImageResource(2130843561);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.4F, 1.0F, 1.4F, 1, 0.5F, 1, 0.0F);
    localScaleAnimation.setRepeatCount(2147483647);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setRepeatMode(2);
    paramImageView.setAnimation(localScaleAnimation);
    localScaleAnimation.start();
  }
  
  private void a(bfef parambfef, String paramString1, String paramString2)
  {
    try
    {
      long l = parambfef.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.trace_info.aid.get();
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(parambfef);
      bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", paramString1, this.jdField_e_of_type_Int, 0, Long.toString(l), Integer.toString(i + 1), "", "");
      return;
    }
    catch (Exception parambfef)
    {
      QLog.e("TribeVideoListPlayerFragment", 1, paramString2 + parambfef.toString());
    }
  }
  
  private void a(bfeg parambfeg)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.isAdded()) && (!this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.isVisible())) {
        getActivity().getSupportFragmentManager().beginTransaction().show(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment).commitAllowingStateLoss();
      }
      c(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_Int);
      if (parambfeg.jdField_c_of_type_Int != 31) {
        break label167;
      }
    }
    label167:
    for (String str = "1";; str = "2")
    {
      bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_more", 0, 0, parambfeg.d, parambfeg.b + "", "", str);
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
  
  private void b(bfef parambfef)
  {
    blir localblir = (blir)blji.a(getActivity(), null);
    localblir.a(anzj.a(2131713882), 9, "#FFB800");
    localblir.c(2131690580);
    localblir.a(new bfcv(this));
    localblir.a(new bfcw(this, localblir, parambfef));
    localblir.show();
    this.jdField_e_of_type_Boolean = true;
    a(parambfef, "ad_Clk_dislike", "negative ad report error: e= ");
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getActivity());
    this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView = a();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView, localLayoutParams);
  }
  
  private void l()
  {
    if (!bapg.a()) {
      bapg.a(BaseApplicationImpl.getApplication(), null);
    }
  }
  
  private void m()
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
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment = new TribeVideoListPlayerFragment.TribeWebViewFragment();
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment = this;
    Object localObject1 = new Bundle();
    Intent localIntent = new Intent();
    Object localObject2 = (bfed)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if ((localObject2 instanceof bfeg))
    {
      localObject2 = (bfeg)localObject2;
      long l2 = ((bfeg)localObject2).b;
      long l1 = l2;
      if (((bfeg)localObject2).jdField_a_of_type_JavaUtilArrayList != null)
      {
        l1 = l2;
        if (((bfeg)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          l1 = ((bfee)((bfeg)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
        }
      }
      localIntent.putExtra("url", String.format(this.jdField_a_of_type_JavaLangString, new Object[] { Long.valueOf(l1), ((bfeg)localObject2).d }));
    }
    localIntent.putExtra("isTransparentTitleAndClickable", true);
    localIntent.putExtra("hide_left_button", true);
    localIntent.putExtra("hide_more_button", true);
    ((Bundle)localObject1).putParcelable("intent", localIntent);
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.setArguments((Bundle)localObject1);
    if (!this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.isAdded())
    {
      localObject1 = getActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject1).add(2131365060, this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment, "TransparentWebviewFragment");
      ((FragmentTransaction)localObject1).hide(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment).commitAllowingStateLoss();
    }
  }
  
  private void o()
  {
    Object localObject = (bfdp)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
    localObject = (bfed)this.jdField_a_of_type_JavaUtilArrayList.get(((bfdp)localObject).jdField_a_of_type_Int);
    if ((localObject instanceof bfeg)) {
      a((bfeg)localObject);
    }
    while (!(localObject instanceof bfef)) {
      return;
    }
    b((bfef)localObject);
  }
  
  @TargetApi(11)
  private void p()
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
  
  public void D_() {}
  
  public Spannable a(bfeg parambfeg)
  {
    Object localObject = bgqv.a(parambfeg.j.replaceAll("\024", ""));
    if ((float)(bhlo.k() - bhgr.a(getActivity(), 24.0F)) == 0.0F) {
      return null;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(bhgr.a(getActivity(), 14.0F));
    int j = ((String)localObject).indexOf("{{");
    int i = ((String)localObject).indexOf("}}");
    if ((j >= 0) && (i > j)) {
      localObject = ((String)localObject).substring(0, j) + anzj.a(2131713891) + ((String)localObject).substring(i + 2);
    }
    for (i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(parambfeg.i))
      {
        localObject = new begp("# " + parambfeg.i + " " + (String)localObject, 2, 16);
        ((begp)localObject).setSpan(new zuc(getActivity(), 2130843576), 0, 1, 33);
        ((begp)localObject).setSpan(new zuc(getActivity(), 2130842880), 1, 2, 33);
        ((begp)localObject).setSpan(new zuc(getActivity(), 2130845876), parambfeg.i.length() + 2, parambfeg.i.length() + 3, 33);
        ((begp)localObject).setSpan(new ForegroundColorSpan(-18432), 2, parambfeg.i.length() + 2, 33);
        ((begp)localObject).setSpan(new bfdb(this, parambfeg), 2, parambfeg.i.length() + 2, 33);
      }
      for (parambfeg = (bfeg)localObject;; parambfeg = new begp((CharSequence)localObject, 2, 16))
      {
        if (i != 0) {
          parambfeg.setSpan(new zuc(getActivity(), 2130843568), j, j + 1, 33);
        }
        return parambfeg;
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
    localISPlayerVideoView.addViewCallBack(new bfdk(this));
    return localISPlayerVideoView;
  }
  
  public String a(int paramInt)
  {
    if (paramInt >= 10000)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("###.#");
      return localDecimalFormat.format(paramInt / 10000.0D) + anzj.a(2131713898);
    }
    if (paramInt > 0) {
      return String.valueOf(paramInt);
    }
    return anzj.a(2131713900);
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
      f1 = (float)(bhlo.k() - bhgr.a(getActivity(), 40.0F));
      localObject = new Paint();
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setTextSize(bhgr.a(getActivity(), 12.0F));
      str = anzj.a(2131713895);
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
        f1 = (float)((bhlo.k() - bhgr.a(getActivity(), 66.0F)) / 2L);
        break;
      }
      f1 = (float)((bhlo.k() - bhgr.a(getActivity(), 92.0F)) / 3L);
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
    localValueAnimator.addUpdateListener(new bfde(this));
    localValueAnimator.start();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bfdx localbfdx = (bfdx)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
    bfeg localbfeg = localbfdx.jdField_a_of_type_Bfeg;
    if (localbfeg == null) {}
    do
    {
      return;
      if (paramInt1 == 1)
      {
        localbfeg.l += paramInt2;
        a(localbfdx.i);
        localbfdx.jdField_e_of_type_AndroidWidgetTextView.setText(a(localbfeg.l));
        localbfdx.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
        return;
      }
    } while (paramInt1 != 0);
    localbfeg.m += paramInt2;
    localbfdx.jdField_a_of_type_AndroidWidgetTextView.setText(a(localbfeg.m));
    localbfdx.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
  }
  
  public void a(int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("client_ver", "8.4.5");
      localJSONObject.put("from", "1");
      localJSONObject.put("targetuin", paramString);
      localJSONObject.put("operation", paramInt);
      localJSONObject.put("sourceid", 10013);
      localJSONObject.put("sub_sourceid", 5);
      paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), nkl.class);
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
    bfeg localbfeg = (bfeg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    bfeh.a(this.jdField_a_of_type_Bfdt.getItemCount() + this.jdField_a_of_type_Int, 10, this.jdField_c_of_type_Int, localbfeg.jdField_h_of_type_Int, localbfeg.b, localbfeg.d, this.jdField_d_of_type_Int, new bfdn(this, localbfeg));
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
      paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), nkl.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.shortvideo_readreport");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString.setObserver(new bfdd(this));
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
      paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), nkl.class);
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
    if ((paramDialog instanceof blir)) {
      m();
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_Int = -1;
    j();
    if ((!(paramViewHolder instanceof bfdp)) || (this.jdField_g_of_type_Int == ((bfdp)paramViewHolder).jdField_a_of_type_Int)) {
      return;
    }
    Object localObject;
    boolean bool;
    label149:
    bfeg localbfeg;
    label215:
    label247:
    String str;
    if ((((bfdp)paramViewHolder).jdField_a_of_type_Int > this.jdField_g_of_type_Int) || (((bfdp)paramViewHolder).jdField_a_of_type_Int != this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
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
      if ((paramViewHolder instanceof bfdx))
      {
        a((bfdp)paramViewHolder);
        a((bfdx)paramViewHolder);
        bool = false;
        if ((paramViewHolder instanceof bfdx))
        {
          localbfeg = (bfeg)this.jdField_a_of_type_JavaUtilArrayList.get(((bfdx)paramViewHolder).jdField_a_of_type_Int);
          localObject = (bfdx)paramViewHolder;
          if ((localbfeg.jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!localbfeg.jdField_c_of_type_Boolean)) {
            break label476;
          }
          ((bfdx)localObject).c.setVisibility(8);
          if (localbfeg.jdField_h_of_type_Int == 0) {
            break label508;
          }
          localObject = "" + localbfeg.jdField_h_of_type_Int;
          if (localbfeg.jdField_c_of_type_Int != 31) {
            break label514;
          }
          str = "1";
          label262:
          if (((bfdx)paramViewHolder).jdField_a_of_type_Int <= this.jdField_g_of_type_Int) {
            break label522;
          }
          bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "slide_up", this.jdField_e_of_type_Int, 0, localbfeg.d, "" + localbfeg.b, (String)localObject, str);
        }
      }
    }
    for (;;)
    {
      a(((bfdp)paramViewHolder).jdField_a_of_type_Int, bool);
      this.jdField_g_of_type_Int = ((bfdp)paramViewHolder).jdField_a_of_type_Int;
      return;
      if (!(paramViewHolder instanceof bfdo)) {
        break;
      }
      a((bfdp)paramViewHolder);
      localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(200L);
      ((AlphaAnimation)localObject).setStartOffset(3000L);
      ((AlphaAnimation)localObject).setFillAfter(true);
      ((bfdo)paramViewHolder).jdField_a_of_type_AndroidViewView.clearAnimation();
      ((bfdo)paramViewHolder).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((bfdo)paramViewHolder).jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
      if (((bfdo)paramViewHolder).jdField_a_of_type_Bfef.jdField_b_of_type_Boolean) {
        break;
      }
      ((bfdo)paramViewHolder).jdField_a_of_type_Bfef.jdField_b_of_type_Boolean = true;
      ThreadManager.excute(new TribeVideoListPlayerFragment.7(this, paramViewHolder), 128, null, true);
      break;
      bool = true;
      break label149;
      label476:
      ((bfdx)localObject).c.setVisibility(0);
      ((bfdx)localObject).l.clearAnimation();
      ((bfdx)localObject).k.clearAnimation();
      ((bfdx)localObject).jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label215;
      label508:
      localObject = "";
      break label247;
      label514:
      str = "2";
      break label262;
      label522:
      if (((bfdx)paramViewHolder).jdField_a_of_type_Int < this.jdField_g_of_type_Int) {
        bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "slide_down", this.jdField_e_of_type_Int, 0, localbfeg.d, "" + localbfeg.b, (String)localObject, str);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_AndroidViewView = paramFrameLayout.findViewById(2131364596);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    paramFrameLayout.findViewById(2131370735).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = new VideoFeedsRecyclerView(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setClipChildren(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    paramFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 0, new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_Bfdt = new bfdt(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Bfdt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    l();
    k();
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getActivity());
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundColor(1711276032);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843196);
    this.jdField_b_of_type_AndroidWidgetImageView.setId(2131367454);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bfcu(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, -1, -1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837518);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getActivity());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131713887));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getActivity()).inflate(2131560559, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131370324));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131370328));
    d(0);
    int i = getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_JavaLangString += String.format("&x=%d&y=%d", new Object[] { Integer.valueOf(bhgr.a(getActivity(), 180.0F)), Integer.valueOf(i - bhgr.a(getActivity(), 30.0F)) });
    LiuHaiUtils.a(getActivity());
    if ((LiuHaiUtils.b()) && (!LiuHaiUtils.jdField_d_of_type_Boolean) && (LiuHaiUtils.enableNotch(getActivity()))) {
      paramFrameLayout.findViewById(2131370751).setPadding(0, LiuHaiUtils.jdField_a_of_type_Int - bhgr.a(getActivity(), 10.0F), 0, 0);
    }
  }
  
  public void a(bfdp parambfdp)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    Object localObject2 = (bfed)this.jdField_a_of_type_JavaUtilArrayList.get(parambfdp.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = a(this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(new bfcx(this, parambfdp));
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent();
    if (localObject1 != null) {
      ((ViewGroup)localObject1).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    parambfdp.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, -1, -1);
    parambfdp.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    ((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setAlpha(0.0F);
    label182:
    int i;
    label262:
    long l;
    label276:
    int j;
    if (!TextUtils.isEmpty(((bfed)localObject2).jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(((bfed)localObject2).jdField_a_of_type_JavaLangString, 101, "");
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(getActivity(), this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo, 0L);
      if (!((bfed)localObject2).jdField_a_of_type_Boolean) {
        break label387;
      }
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setXYaxis(0);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
      ((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setTag(parambfdp);
      this.jdField_a_of_type_Boolean = false;
      b(0);
      e();
      parambfdp = "";
      localObject1 = "";
      if (!(localObject2 instanceof bfeg)) {
        break label407;
      }
      localObject1 = (bfeg)localObject2;
      i = ((bfeg)localObject1).jdField_h_of_type_Int;
      if (((bfeg)localObject1).jdField_c_of_type_Int != 31) {
        break label400;
      }
      parambfdp = "1";
      l = ((bfeg)localObject1).b;
      localObject1 = ((bfeg)localObject1).d;
      j = this.jdField_e_of_type_Int;
      if (l == 0L) {
        break label442;
      }
      localObject2 = "" + l;
      label310:
      if (i == 0) {
        break label449;
      }
    }
    label387:
    label400:
    label407:
    label442:
    label449:
    for (String str = "" + i;; str = "")
    {
      bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv", j, 0, (String)localObject1, (String)localObject2, str, parambfdp);
      a(l, (String)localObject1, i);
      return;
      this.jdField_a_of_type_ComTencentSuperplayerApiSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForTVideo(4080303, ((bfed)localObject2).c);
      break;
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setXYaxis(2);
      break label182;
      parambfdp = "2";
      break label262;
      if ((localObject2 instanceof bfef))
      {
        parambfdp = "100";
        a((bfef)localObject2, "ad_vv", "ad_vv: e= ");
      }
      l = 0L;
      i = 0;
      break label276;
      localObject2 = "";
      break label310;
    }
  }
  
  protected void a(bfdx parambfdx)
  {
    bfeg localbfeg = parambfdx.jdField_a_of_type_Bfeg;
    if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.webView != null)
    {
      int[] arrayOfInt = new int[2];
      parambfdx.i.getLocationOnScreen(arrayOfInt);
      long l2 = localbfeg.b;
      long l1 = l2;
      if (localbfeg.jdField_a_of_type_JavaUtilArrayList != null)
      {
        l1 = l2;
        if (localbfeg.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          l1 = ((bfee)localbfeg.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
        }
      }
      this.jdField_a_of_type_JavaLangString = String.format(this.jdField_a_of_type_JavaLangString, new Object[] { Long.valueOf(l1), localbfeg.d });
      if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_b_of_type_Boolean)
      {
        parambfdx = "javascript:mqq.dispatchEvent(\"updateVideo\",{\"bid\":" + l1 + ",\"pid\":\"" + localbfeg.d + "\"})";
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.webView.callJs(parambfdx);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.webView.loadUrl(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(bfef parambfef)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_c_of_type_Int = 7;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(parambfef.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = true;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    localParams.jdField_b_of_type_JavaLangClass = TribeGdtCanvasFragment.class;
    localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_buluo");
    GdtHandler.a(localParams);
    a(parambfef, "ad_Clk", "handleADClick report error: e= ");
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void a(bfef parambfef, long paramLong1, long paramLong2)
  {
    a(parambfef, paramLong1, paramLong2, false);
  }
  
  protected void a(bfef parambfef, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    ThreadManager.excute(new TribeVideoListPlayerFragment.6(this, paramBoolean, parambfef, paramLong2, paramLong1), 128, null, true);
  }
  
  protected void a(ISuperPlayer paramISuperPlayer)
  {
    paramISuperPlayer.setOnCompletionListener(new bfdh(this));
    paramISuperPlayer.setOnErrorListener(new bfdi(this));
    paramISuperPlayer.setOnInfoListener(new bfdj(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView == null) {}
    for (;;)
    {
      return;
      Object localObject2;
      JSONObject localJSONObject;
      if ((((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag() instanceof bfdx))
      {
        localObject1 = (bfdx)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
        localObject1 = (bfed)this.jdField_a_of_type_JavaUtilArrayList.get(((bfdx)localObject1).jdField_a_of_type_Int);
        if (!(localObject1 instanceof bfeg)) {
          continue;
        }
        localObject2 = (bfeg)localObject1;
        if (((bfeg)localObject2).jdField_h_of_type_Int != 0) {
          localObject1 = "" + ((bfeg)localObject2).jdField_h_of_type_Int;
        }
        for (;;)
        {
          int i;
          if (((bfeg)localObject2).jdField_c_of_type_Int == 31)
          {
            i = 1;
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put("timeofplayed", this.jdField_h_of_type_Int);
            localJSONObject.put("totaltime", ((bfeg)localObject2).jdField_a_of_type_Long);
            localJSONObject.put("report", ((bfeg)localObject2).jdField_a_of_type_OrgJsonJSONObject);
            bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv_time", this.jdField_e_of_type_Int, i, ((bfeg)localObject2).d, "" + ((bfeg)localObject2).b, (String)localObject1, localJSONObject.toString());
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
      if (!(((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag() instanceof bfdo)) {
        continue;
      }
      Object localObject1 = (bfed)this.jdField_a_of_type_JavaUtilArrayList.get(((bfdo)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag()).jdField_a_of_type_Int);
      if ((localObject1 instanceof bfef))
      {
        localObject2 = (bfef)localObject1;
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("timeofplayed", this.jdField_h_of_type_Int);
        localJSONObject.put("totaltime", ((bfef)localObject2).jdField_a_of_type_Long);
        bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv_time", this.jdField_e_of_type_Int, 100, "", "", "", localJSONObject.toString());
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "ad_vv_time", this.jdField_e_of_type_Int, 0, "" + ((bfef)localObject2).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.trace_info.aid.get(), "" + (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject2) + 1), "" + ((bfef)localObject2).jdField_a_of_type_Long, "" + this.jdField_h_of_type_Int);
          if ((!(localObject1 instanceof bfef)) || (this.jdField_c_of_type_Boolean)) {
            continue;
          }
          a((bfef)localObject1, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), paramBoolean);
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
      return localDecimalFormat.format(paramInt / 10000.0D) + anzj.a(2131713888);
    }
    if (paramInt > 0) {
      return String.valueOf(paramInt);
    }
    return anzj.a(2131713878);
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
      this.jdField_a_of_type_JavaUtilArrayList.addAll(bfeg.a((JSONArray)localObject));
      this.jdField_a_of_type_Bfdt.notifyDataSetChanged();
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
    localValueAnimator.addUpdateListener(new bfdl(this));
    localValueAnimator.start();
  }
  
  public void b(bfdp parambfdp)
  {
    Message localMessage = new Message();
    localMessage.obj = parambfdp;
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 33L);
  }
  
  protected void c()
  {
    Object localObject1 = new bfdm(this);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localObject1 = new laz((lba)localObject1);
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
    localObject2 = acwb.a(getActivity());
    if (localObject2 != null) {
      localQQAdGet.device_info.set((MessageMicro)localObject2);
    }
    lax.a().a(getActivity(), BaseApplicationImpl.getApplication().getRuntime(), localQQAdGet, (BusinessObserver)localObject1);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713877));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    case 3: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713894));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130843562, 0, 0, 0);
      bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "exp_nomore", this.jdField_e_of_type_Int, 0, "", "", "", "");
      return;
    case 4: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713899));
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
    bfdx localbfdx;
    if ((((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag() instanceof bfdx))
    {
      localbfdx = (bfdx)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
      if (localbfdx != null) {}
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
      localbfdx.j.setVisibility(8);
      localbfdx.i.setVisibility(0);
      localbfdx.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 1: 
      localbfdx.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      localbfdx.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      localbfdx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    localbfdx.h.setVisibility(8);
    localbfdx.g.setVisibility(0);
    localbfdx.d.setVisibility(0);
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
    if (this.jdField_a_of_type_Bhpc == null)
    {
      this.jdField_a_of_type_Bhpc = bhlq.a(getActivity(), 230, null, anzj.a(2131713886), new bfcy(this), null);
      this.jdField_a_of_type_Bhpc.setOnDismissListener(new bfcz(this));
    }
    if (!this.jdField_a_of_type_Bhpc.isShowing()) {
      this.jdField_a_of_type_Bhpc.show();
    }
  }
  
  protected void h()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = bnrf.a((AppRuntime)localObject1, true, true);
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
      bnrf.a((SharedPreferences.Editor)localObject2, true);
      localObject1 = (FrameLayout)getActivity().getWindow().getDecorView();
      localObject2 = LayoutInflater.from(getActivity()).inflate(2131560562, (ViewGroup)localObject1, false);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131380543));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131380544));
      ((View)localObject2).setOnTouchListener(new bfda(this, (FrameLayout)localObject1, (View)localObject2));
      jdField_a_of_type_AndroidOsHandler.postDelayed(new TribeVideoListPlayerFragment.16(this, (FrameLayout)localObject1, (View)localObject2), 5000L);
      ((FrameLayout)localObject1).addView((View)localObject2);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
        p();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
    b((bfdx)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag());
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
    localAlphaAnimation.setAnimationListener(new bfdc(this));
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
      o();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (FrameLayout)paramLayoutInflater.inflate(2131560560, paramViewGroup, false);
    a(paramLayoutInflater);
    b();
    n();
    h();
    bdll.b(null, "dc00899", "Grp_tribe", "", "video_player", "in", this.jdField_e_of_type_Int, 0, "", "", "", "");
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
    getActivity().overridePendingTransition(0, 2130772332);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView != null) && (this.jdField_f_of_type_Boolean))
    {
      bfdp localbfdp = (bfdp)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
      if (((localbfdp instanceof bfdo)) && (!this.jdField_c_of_type_Boolean)) {
        a(((bfdo)localbfdp).jdField_a_of_type_Bfef, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
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
      b((bfdp)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag());
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
    this.jdField_g_of_type_Boolean = false;
    m();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView == null) {
      return;
    }
    m();
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      b((bfdp)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag());
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
        bfdp localbfdp = (bfdp)((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
        if (((localbfdp instanceof bfdo)) && (!this.jdField_c_of_type_Boolean))
        {
          a(((bfdo)localbfdp).jdField_a_of_type_Bfef, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
          if (this.jdField_h_of_type_Boolean) {
            this.jdField_c_of_type_Boolean = true;
          }
        }
      }
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
      ((View)this.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).setKeepScreenOn(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment
 * JD-Core Version:    0.7.0.1
 */