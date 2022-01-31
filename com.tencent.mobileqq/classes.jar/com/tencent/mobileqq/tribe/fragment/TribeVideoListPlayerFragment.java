package com.tencent.mobileqq.tribe.fragment;

import ajjy;
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
import android.widget.Toast;
import awqx;
import axkd;
import ayad;
import ayae;
import ayaf;
import ayag;
import ayah;
import ayai;
import ayaj;
import ayak;
import ayal;
import ayam;
import ayan;
import ayao;
import ayap;
import ayaq;
import ayar;
import ayas;
import ayat;
import ayau;
import ayav;
import ayaw;
import ayax;
import ayay;
import ayaz;
import aybe;
import aybi;
import aybn;
import aybo;
import aybp;
import aybq;
import aybr;
import azho;
import azvv;
import babp;
import babr;
import bafb;
import begr;
import behe;
import bgmq;
import bjeh;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
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
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import krg;
import kri;
import krj;
import mmi;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import obz;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qfs;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import vrc;
import yjr;
import yjs;
import yoy;

public class TribeVideoListPlayerFragment
  extends PublicBaseFragment
  implements View.OnClickListener, qfs
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
  public aybe a;
  bafb jdField_a_of_type_Bafb;
  public VideoFeedsRecyclerView a;
  protected GdtAppReceiver a;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ayao(this);
  private TribeVideoListPlayerFragment.TribeWebViewFragment jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment;
  public TVK_IMediaPlayer a;
  protected TVK_IProxyFactory a;
  protected TVK_PlayerVideoInfo a;
  protected TVK_UserInfo a;
  public IVideoViewBase a;
  public Runnable a;
  private String jdField_a_of_type_JavaLangString = "https://buluo.qq.com/mobile/short_video_list.html?bid=%d&pid=%s";
  public ArrayList<aybn> a;
  protected Map<String, TVK_IMediaPlayer> a;
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
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
    this.jdField_b_of_type_AndroidOsHandler = new ayap(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRunnable = new TribeVideoListPlayerFragment.27(this);
  }
  
  private void a(ImageView paramImageView)
  {
    paramImageView.setImageResource(2130842901);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.4F, 1.0F, 1.4F, 1, 0.5F, 1, 0.0F);
    localScaleAnimation.setRepeatCount(2147483647);
    localScaleAnimation.setRepeatCount(1);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setRepeatMode(2);
    paramImageView.setAnimation(localScaleAnimation);
    localScaleAnimation.start();
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
  
  private void l()
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
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment = new TribeVideoListPlayerFragment.TribeWebViewFragment();
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment = this;
    Object localObject1 = new Bundle();
    Intent localIntent = new Intent();
    Object localObject2 = (aybn)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if ((localObject2 instanceof aybq))
    {
      localObject2 = (aybq)localObject2;
      long l2 = ((aybq)localObject2).b;
      long l1 = l2;
      if (((aybq)localObject2).jdField_a_of_type_JavaUtilArrayList != null)
      {
        l1 = l2;
        if (((aybq)localObject2).jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          l1 = ((aybo)((aybq)localObject2).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
        }
      }
      localIntent.putExtra("url", String.format(this.jdField_a_of_type_JavaLangString, new Object[] { Long.valueOf(l1), ((aybq)localObject2).d }));
    }
    localIntent.putExtra("isTransparentTitleAndClickable", true);
    localIntent.putExtra("hide_left_button", true);
    localIntent.putExtra("hide_more_button", true);
    ((Bundle)localObject1).putParcelable("intent", localIntent);
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.setArguments((Bundle)localObject1);
    if (!this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.isAdded())
    {
      localObject1 = getActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject1).add(2131299146, this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment, "TransparentWebviewFragment");
      ((FragmentTransaction)localObject1).hide(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment).commitAllowingStateLoss();
    }
  }
  
  @TargetApi(11)
  private void n()
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
  
  public Spannable a(aybq paramaybq)
  {
    Object localObject = azho.a(paramaybq.j.replaceAll("\024", ""));
    if ((float)(babp.k() - azvv.a(getActivity(), 24.0F)) == 0.0F) {
      return null;
    }
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setTextSize(azvv.a(getActivity(), 14.0F));
    int j = ((String)localObject).indexOf("{{");
    int i = ((String)localObject).indexOf("}}");
    if ((j >= 0) && (i > j)) {
      localObject = ((String)localObject).substring(0, j) + ajjy.a(2131649317) + ((String)localObject).substring(i + 2);
    }
    for (i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramaybq.i))
      {
        localObject = new axkd("# " + paramaybq.i + " " + (String)localObject, 2, 16);
        ((axkd)localObject).setSpan(new vrc(getActivity(), 2130842916), 0, 1, 33);
        ((axkd)localObject).setSpan(new vrc(getActivity(), 2130842274), 1, 2, 33);
        ((axkd)localObject).setSpan(new vrc(getActivity(), 2130844939), paramaybq.i.length() + 2, paramaybq.i.length() + 3, 33);
        ((axkd)localObject).setSpan(new ForegroundColorSpan(-18432), 2, paramaybq.i.length() + 2, 33);
        ((axkd)localObject).setSpan(new ayak(this, paramaybq), 2, paramaybq.i.length() + 2, 33);
      }
      for (paramaybq = (aybq)localObject;; paramaybq = new axkd((CharSequence)localObject, 2, 16))
      {
        if (i != 0) {
          paramaybq.setSpan(new vrc(getActivity(), 2130842908), j, j + 1, 33);
        }
        return paramaybq;
      }
    }
  }
  
  protected TVK_IMediaPlayer a(IVideoViewBase paramIVideoViewBase)
  {
    paramIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getActivity(), paramIVideoViewBase);
    a(paramIVideoViewBase);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo.setLoginCookie("");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo.setUin(obz.a() + "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setPlayMode("cache_video");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    HashMap localHashMap = new HashMap();
    localHashMap.put("shouq_bus_type", "bus_type_trib");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap(localHashMap);
    return paramIVideoViewBase;
  }
  
  protected IVideoViewBase a()
  {
    if (TVK_SDKMgr.isInstalled(getActivity())) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null) {
        break;
      }
      localObject = Toast.makeText(getActivity(), ajjy.a(2131649305), 1);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
      return null;
      ThreadManager.post(new TribeVideoListPlayerFragment.TVKSDKInstallRunnable(this), 5, null, true);
    }
    Object localObject = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(getActivity());
    ((IVideoViewBase)localObject).addViewCallBack(new ayat(this));
    return localObject;
  }
  
  public String a(int paramInt)
  {
    if (paramInt >= 10000)
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("###.#");
      return localDecimalFormat.format(paramInt / 10000.0D) + ajjy.a(2131649324);
    }
    if (paramInt > 0) {
      return String.valueOf(paramInt);
    }
    return ajjy.a(2131649326);
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
      f1 = (float)(babp.k() - azvv.a(getActivity(), 40.0F));
      localObject = new Paint();
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setTextSize(azvv.a(getActivity(), 12.0F));
      str = ajjy.a(2131649321);
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
        f1 = (float)((babp.k() - azvv.a(getActivity(), 66.0F)) / 2L);
        break;
      }
      f1 = (float)((babp.k() - azvv.a(getActivity(), 92.0F)) / 3L);
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
  
  public void a() {}
  
  public void a(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(paramInt);
    localValueAnimator.addUpdateListener(new ayau(this));
    localValueAnimator.start();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    aybi localaybi = (aybi)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag();
    aybq localaybq = localaybi.jdField_a_of_type_Aybq;
    if (localaybq == null) {}
    do
    {
      return;
      if (paramInt1 == 1)
      {
        localaybq.l += paramInt2;
        a(localaybi.i);
        localaybi.jdField_e_of_type_AndroidWidgetTextView.setText(a(localaybq.l));
        localaybi.jdField_e_of_type_AndroidWidgetTextView.setMaxLines(1);
        return;
      }
    } while (paramInt1 != 0);
    localaybq.m += paramInt2;
    localaybi.jdField_a_of_type_AndroidWidgetTextView.setText(a(localaybq.m));
    localaybi.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
  }
  
  public void a(int paramInt, String paramString, BusinessObserver paramBusinessObserver)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("client_ver", "8.2.6");
      localJSONObject.put("from", "1");
      localJSONObject.put("targetuin", paramString);
      localJSONObject.put("operation", paramInt);
      localJSONObject.put("sourceid", 10013);
      localJSONObject.put("sub_sourceid", 5);
      paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), mmi.class);
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
    aybq localaybq = (aybq)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    aybr.a(this.jdField_a_of_type_Aybe.getItemCount() + this.jdField_a_of_type_Int, 10, this.jdField_c_of_type_Int, localaybq.jdField_h_of_type_Int, localaybq.b, localaybq.d, this.jdField_d_of_type_Int, new ayax(this, localaybq));
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
      paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), mmi.class);
      paramString.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.shortvideo_readreport");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramString.setObserver(new ayan(this));
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
      paramString = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), mmi.class);
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
    if ((paramDialog instanceof begr)) {
      l();
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_Int = -1;
    k();
    if ((!(paramViewHolder instanceof ayaz)) || (this.jdField_g_of_type_Int == ((ayaz)paramViewHolder).jdField_a_of_type_Int)) {
      return;
    }
    Object localObject;
    boolean bool;
    label140:
    aybq localaybq;
    label206:
    label239:
    String str;
    if ((((ayaz)paramViewHolder).jdField_a_of_type_Int > this.jdField_g_of_type_Int) || (((ayaz)paramViewHolder).jdField_a_of_type_Int != this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent();
      if (localObject != null)
      {
        e();
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        }
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      if ((paramViewHolder instanceof aybi))
      {
        a((ayaz)paramViewHolder);
        a((aybi)paramViewHolder);
        bool = false;
        if ((paramViewHolder instanceof aybi))
        {
          localaybq = (aybq)this.jdField_a_of_type_JavaUtilArrayList.get(((aybi)paramViewHolder).jdField_a_of_type_Int);
          localObject = (aybi)paramViewHolder;
          if ((localaybq.jdField_c_of_type_Long != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (!localaybq.jdField_c_of_type_Boolean)) {
            break label473;
          }
          ((aybi)localObject).c.setVisibility(8);
          if (localaybq.jdField_h_of_type_Int == 0) {
            break label505;
          }
          localObject = "" + localaybq.jdField_h_of_type_Int;
          if (localaybq.jdField_c_of_type_Int != 31) {
            break label512;
          }
          str = "1";
          label254:
          if (((aybi)paramViewHolder).jdField_a_of_type_Int <= this.jdField_g_of_type_Int) {
            break label520;
          }
          awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "slide_up", this.jdField_e_of_type_Int, 0, localaybq.d, "" + localaybq.b, (String)localObject, str);
        }
      }
    }
    for (;;)
    {
      a(((ayaz)paramViewHolder).jdField_a_of_type_Int, bool);
      this.jdField_g_of_type_Int = ((ayaz)paramViewHolder).jdField_a_of_type_Int;
      return;
      if (!(paramViewHolder instanceof ayay)) {
        break;
      }
      a((ayaz)paramViewHolder);
      localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(200L);
      ((AlphaAnimation)localObject).setStartOffset(3000L);
      ((AlphaAnimation)localObject).setFillAfter(true);
      ((ayay)paramViewHolder).jdField_a_of_type_AndroidViewView.clearAnimation();
      ((ayay)paramViewHolder).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((ayay)paramViewHolder).jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
      if (((ayay)paramViewHolder).jdField_a_of_type_Aybp.jdField_b_of_type_Boolean) {
        break;
      }
      ((ayay)paramViewHolder).jdField_a_of_type_Aybp.jdField_b_of_type_Boolean = true;
      ThreadManager.excute(new TribeVideoListPlayerFragment.8(this, paramViewHolder), 128, null, true);
      break;
      bool = true;
      break label140;
      label473:
      ((aybi)localObject).c.setVisibility(0);
      ((aybi)localObject).l.clearAnimation();
      ((aybi)localObject).k.clearAnimation();
      ((aybi)localObject).jdField_f_of_type_AndroidWidgetTextView.clearAnimation();
      break label206;
      label505:
      localObject = "";
      break label239;
      label512:
      str = "2";
      break label254;
      label520:
      if (((aybi)paramViewHolder).jdField_a_of_type_Int < this.jdField_g_of_type_Int) {
        awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "slide_down", this.jdField_e_of_type_Int, 0, localaybq.d, "" + localaybq.b, (String)localObject, str);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_AndroidViewView = paramFrameLayout.findViewById(2131298714);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    paramFrameLayout.findViewById(2131304230).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = new VideoFeedsRecyclerView(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setClipChildren(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    paramFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 0, new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_Aybe = new aybe(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Aybe);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getActivity());
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = a();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase == null) {
      getActivity().finish();
    }
    do
    {
      return;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundColor(1711276032);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842556);
      this.jdField_b_of_type_AndroidWidgetImageView.setId(2131301360);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ayad(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, -1, -1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837516);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getActivity());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649313));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getActivity()).inflate(2131494710, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, false));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131303832));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131303835));
      d(0);
      int i = getResources().getDisplayMetrics().heightPixels;
      this.jdField_a_of_type_JavaLangString += String.format("&x=%d&y=%d", new Object[] { Integer.valueOf(azvv.a(getActivity(), 180.0F)), Integer.valueOf(i - azvv.a(getActivity(), 30.0F)) });
      bjeh.a(getActivity());
    } while ((!bjeh.b()) || (bjeh.jdField_d_of_type_Boolean) || (!bjeh.c(getActivity())));
    paramFrameLayout.findViewById(2131304244).setPadding(0, bjeh.jdField_a_of_type_Int - azvv.a(getActivity(), 10.0F), 0, 0);
  }
  
  public void a(ayaz paramayaz)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    Object localObject2 = (aybn)this.jdField_a_of_type_JavaUtilArrayList.get(paramayaz.jdField_a_of_type_Int);
    Object localObject1;
    label175:
    label193:
    long l;
    int i;
    if (!TextUtils.isEmpty(((aybn)localObject2).jdField_a_of_type_JavaLangString))
    {
      localObject1 = ((aybn)localObject2).jdField_a_of_type_JavaLangString;
      a((String)localObject1);
      a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new ayag(this, paramayaz));
      localObject1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      paramayaz.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, -1, -1);
      paramayaz.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setAlpha(0.0F);
      if (TextUtils.isEmpty(((aybn)localObject2).jdField_a_of_type_JavaLangString)) {
        break label402;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getActivity(), ((aybn)localObject2).jdField_a_of_type_JavaLangString, 0L, 0L, null, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
      if (!((aybn)localObject2).jdField_a_of_type_Boolean) {
        break label443;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(0);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setTag(paramayaz);
      this.jdField_a_of_type_Boolean = false;
      b(0);
      f();
      localObject1 = "";
      l = 0L;
      if (!(localObject2 instanceof aybq)) {
        break label463;
      }
      localObject1 = (aybq)localObject2;
      i = ((aybq)localObject1).jdField_h_of_type_Int;
      if (((aybq)localObject1).jdField_c_of_type_Int != 31) {
        break label456;
      }
      paramayaz = "1";
      label274:
      l = ((aybq)localObject1).b;
      localObject2 = ((aybq)localObject1).d;
      localObject1 = paramayaz;
      paramayaz = (ayaz)localObject2;
    }
    for (;;)
    {
      label294:
      int j = this.jdField_e_of_type_Int;
      if (l != 0L)
      {
        localObject2 = "" + l;
        label329:
        if (i == 0) {
          break label643;
        }
      }
      label643:
      for (String str = "" + i;; str = "")
      {
        for (;;)
        {
          awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv", j, 0, paramayaz, (String)localObject2, str, (String)localObject1);
          a(l, paramayaz, i);
          return;
          localObject1 = ((aybn)localObject2).c;
          break;
          label402:
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setVid(((aybn)localObject2).c);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(getActivity(), this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, "hd", 0L, 0L);
          break label175;
          label443:
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(2);
          break label193;
          label456:
          paramayaz = "2";
          break label274;
          label463:
          if (!(localObject2 instanceof aybp)) {
            break label651;
          }
          try
          {
            awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "ad_vv", this.jdField_e_of_type_Int, 0, "" + ((aybp)localObject2).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.trace_info.aid.get(), "" + (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject2) + 1), "", "");
            paramayaz = "";
            localObject1 = "100";
            i = 0;
          }
          catch (Exception paramayaz)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TribeVideoListPlayerFragment", 2, "ad_vv: e= " + paramayaz.toString());
            }
            paramayaz = "";
            localObject1 = "100";
            i = 0;
          }
        }
        break label294;
        localObject2 = "";
        break label329;
      }
      label651:
      paramayaz = "";
      i = 0;
    }
  }
  
  protected void a(aybi paramaybi)
  {
    aybq localaybq = paramaybi.jdField_a_of_type_Aybq;
    if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      int[] arrayOfInt = new int[2];
      paramaybi.i.getLocationOnScreen(arrayOfInt);
      long l2 = localaybq.b;
      long l1 = l2;
      if (localaybq.jdField_a_of_type_JavaUtilArrayList != null)
      {
        l1 = l2;
        if (localaybq.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          l1 = ((aybo)localaybq.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long;
        }
      }
      this.jdField_a_of_type_JavaLangString = String.format(this.jdField_a_of_type_JavaLangString, new Object[] { Long.valueOf(l1), localaybq.d });
      if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_b_of_type_Boolean)
      {
        paramaybi = "javascript:mqq.dispatchEvent(\"updateVideo\",{\"bid\":" + l1 + ",\"pid\":\"" + localaybq.d + "\"})";
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.callJs(paramaybi);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(aybp paramaybp)
  {
    yjs localyjs = new yjs();
    localyjs.jdField_a_of_type_Int = 7;
    localyjs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
    localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramaybp.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo);
    localyjs.jdField_a_of_type_Boolean = true;
    localyjs.jdField_b_of_type_Boolean = true;
    localyjs.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    localyjs.jdField_b_of_type_JavaLangClass = TribeGdtCanvasFragment.class;
    localyjs.jdField_a_of_type_AndroidOsBundle = new Bundle();
    localyjs.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", "biz_src_feeds_buluo");
    yjr.a(localyjs);
    try
    {
      awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "ad_Clk", this.jdField_e_of_type_Int, 0, "" + paramaybp.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.trace_info.aid.get(), "" + (this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramaybp) + 1), "", "");
      this.jdField_f_of_type_Boolean = true;
      return;
    }
    catch (Exception paramaybp)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeVideoListPlayerFragment", 2, "handleADClick report error: e= " + paramaybp.toString());
        }
      }
    }
  }
  
  public void a(aybp paramaybp, long paramLong1, long paramLong2)
  {
    a(paramaybp, paramLong1, paramLong2, false);
  }
  
  protected void a(aybp paramaybp, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    ThreadManager.excute(new TribeVideoListPlayerFragment.7(this, paramBoolean, paramaybp, paramLong2, paramLong1), 128, null, true);
  }
  
  protected void a(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    paramTVK_IMediaPlayer.setOnCompletionListener(new ayaq(this));
    paramTVK_IMediaPlayer.setOnErrorListener(new ayar(this));
    paramTVK_IMediaPlayer.setOnInfoListener(new ayas(this));
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaUtilMap.get(paramString));
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = a(this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase == null) {}
    for (;;)
    {
      return;
      Object localObject2;
      JSONObject localJSONObject;
      if ((((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag() instanceof aybi))
      {
        localObject1 = (aybi)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag();
        localObject1 = (aybn)this.jdField_a_of_type_JavaUtilArrayList.get(((aybi)localObject1).jdField_a_of_type_Int);
        if (!(localObject1 instanceof aybq)) {
          continue;
        }
        localObject2 = (aybq)localObject1;
        if (((aybq)localObject2).jdField_h_of_type_Int != 0) {
          localObject1 = "" + ((aybq)localObject2).jdField_h_of_type_Int;
        }
        for (;;)
        {
          int i;
          if (((aybq)localObject2).jdField_c_of_type_Int == 31)
          {
            i = 1;
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put("timeofplayed", this.jdField_h_of_type_Int);
            localJSONObject.put("totaltime", ((aybq)localObject2).jdField_a_of_type_Long);
            localJSONObject.put("report", ((aybq)localObject2).jdField_a_of_type_OrgJsonJSONObject);
            awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv_time", this.jdField_e_of_type_Int, i, ((aybq)localObject2).d, "" + ((aybq)localObject2).b, (String)localObject1, localJSONObject.toString());
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
      if (!(((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag() instanceof ayay)) {
        continue;
      }
      Object localObject1 = (aybn)this.jdField_a_of_type_JavaUtilArrayList.get(((ayay)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag()).jdField_a_of_type_Int);
      if ((localObject1 instanceof aybp))
      {
        localObject2 = (aybp)localObject1;
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("timeofplayed", this.jdField_h_of_type_Int);
        localJSONObject.put("totaltime", ((aybp)localObject2).jdField_a_of_type_Long);
        awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "vv_time", this.jdField_e_of_type_Int, 100, "", "", "", localJSONObject.toString());
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "ad_vv_time", this.jdField_e_of_type_Int, 0, "" + ((aybp)localObject2).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.trace_info.aid.get(), "" + (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject2) + 1), "" + ((aybp)localObject2).jdField_a_of_type_Long, "" + this.jdField_h_of_type_Int);
          if ((!(localObject1 instanceof aybp)) || (this.jdField_c_of_type_Boolean)) {
            continue;
          }
          a((aybp)localObject1, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion(), paramBoolean);
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
      return localDecimalFormat.format(paramInt / 10000.0D) + ajjy.a(2131649314);
    }
    if (paramInt > 0) {
      return String.valueOf(paramInt);
    }
    return ajjy.a(2131649304);
  }
  
  protected void b()
  {
    TVK_SDKMgr.initSdk(getActivity(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    if (QLog.isColorLevel())
    {
      TVK_SDKMgr.setDebugEnable(true);
      TVK_SDKMgr.setOnLogListener(new ayam(this));
    }
  }
  
  public void b(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.setDuration(paramInt);
    localValueAnimator.addUpdateListener(new ayav(this));
    localValueAnimator.start();
  }
  
  public void b(ayaz paramayaz)
  {
    Message localMessage = new Message();
    localMessage.obj = paramayaz;
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 33L);
  }
  
  protected void c()
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
      this.jdField_a_of_type_JavaUtilArrayList.addAll(aybq.a((JSONArray)localObject));
      this.jdField_a_of_type_Aybe.notifyDataSetChanged();
      ThreadManager.executeOnSubThread(new TribeVideoListPlayerFragment.5(this));
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
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    String str = "javascript:mqq.dispatchEvent(\"startShowAnim\",{\"type\":\"" + jdField_a_of_type_ArrayOfJavaLangString[paramInt] + "\"})";
    jdField_a_of_type_AndroidOsHandler.post(new TribeVideoListPlayerFragment.10(this, str));
  }
  
  protected void d()
  {
    Object localObject1 = new ayaw(this);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localObject1 = new kri((krj)localObject1);
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
    localObject2 = yoy.a(getActivity());
    if (localObject2 != null) {
      localQQAdGet.device_info.set((MessageMicro)localObject2);
    }
    krg.a().a(getActivity(), BaseApplicationImpl.getApplication().getRuntime(), localQQAdGet, (BusinessObserver)localObject1);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649303));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    case 3: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649320));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130842902, 0, 0, 0);
      awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "exp_nomore", this.jdField_e_of_type_Int, 0, "", "", "", "");
      return;
    case 4: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131649325));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  protected void e()
  {
    a(false);
  }
  
  public void e(int paramInt)
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    aybi localaybi;
    if ((((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag() instanceof aybi))
    {
      localaybi = (aybi)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag();
      if (localaybi != null) {}
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
      localaybi.j.setVisibility(8);
      localaybi.i.setVisibility(0);
      localaybi.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 1: 
      localaybi.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      localaybi.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      localaybi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    localaybi.h.setVisibility(8);
    localaybi.g.setVisibility(0);
    localaybi.d.setVisibility(0);
  }
  
  protected void f()
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
  
  protected void g()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TribeVideoListPlayerFragment", 2, "onVideoError");
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    a(0);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = babr.a(getActivity(), 230, null, ajjy.a(2131649312), new ayah(this), null);
      this.jdField_a_of_type_Bafb.setOnDismissListener(new ayai(this));
    }
    if (!this.jdField_a_of_type_Bafb.isShowing()) {
      this.jdField_a_of_type_Bafb.show();
    }
  }
  
  protected void i()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = bgmq.a((AppRuntime)localObject1, true, true);
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
      bgmq.a((SharedPreferences.Editor)localObject2, true);
      localObject1 = (FrameLayout)getActivity().getWindow().getDecorView();
      localObject2 = LayoutInflater.from(getActivity()).inflate(2131494713, (ViewGroup)localObject1, false);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131312925));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131312926));
      ((View)localObject2).setOnTouchListener(new ayaj(this, (FrameLayout)localObject1, (View)localObject2));
      jdField_a_of_type_AndroidOsHandler.postDelayed(new TribeVideoListPlayerFragment.17(this, (FrameLayout)localObject1, (View)localObject2), 5000L);
      ((FrameLayout)localObject1).addView((View)localObject2);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
        n();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    b((aybi)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag());
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
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
  
  protected void j()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(3000L);
    this.jdField_b_of_type_AndroidWidgetTextView.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new ayal(this));
  }
  
  public void k()
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
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.a(paramInt1, paramInt2, paramIntent);
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
    label260:
    do
    {
      do
      {
        return;
        this.jdField_h_of_type_Boolean = true;
        getActivity().finish();
        return;
        paramView = (ayaz)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag();
        paramView = (aybn)this.jdField_a_of_type_JavaUtilArrayList.get(paramView.jdField_a_of_type_Int);
        if ((paramView instanceof aybq))
        {
          localObject = (aybq)paramView;
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_Int = 3;
          if (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_b_of_type_Boolean)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.isAdded()) && (!this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.isVisible())) {
              getActivity().getSupportFragmentManager().beginTransaction().show(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment).commitAllowingStateLoss();
            }
            c(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_Int);
            if (((aybq)localObject).jdField_c_of_type_Int != 31) {
              break label260;
            }
          }
          for (paramView = "1";; paramView = "2")
          {
            awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_more", 0, 0, ((aybq)localObject).d, ((aybq)localObject).b + "", "", paramView);
            return;
            if ((!this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment$TribeWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
            break;
          }
        }
      } while (!(paramView instanceof aybp));
      paramView = (aybp)paramView;
      Object localObject = (begr)behe.a(getActivity(), null);
      ((begr)localObject).a(ajjy.a(2131649308), 9, "#FFB800");
      ((begr)localObject).c(2131625035);
      ((begr)localObject).a(new ayae(this));
      ((begr)localObject).a(new ayaf(this, (begr)localObject, paramView));
      ((begr)localObject).show();
      this.jdField_e_of_type_Boolean = true;
      try
      {
        awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "ad_Clk_dislike", this.jdField_e_of_type_Int, 0, "" + paramView.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp$AdInfo.report_info.trace_info.aid.get(), "" + (this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramView) + 1), "", "");
        return;
      }
      catch (Exception paramView) {}
    } while (!QLog.isColorLevel());
    QLog.e("TribeVideoListPlayerFragment", 2, "negative ad report error: e= " + paramView.toString());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (FrameLayout)paramLayoutInflater.inflate(2131494711, paramViewGroup, false);
    a(paramLayoutInflater);
    c();
    m();
    i();
    awqx.b(null, "dc00899", "Grp_tribe", "", "video_player", "in", this.jdField_e_of_type_Int, 0, "", "", "", "");
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(getActivity());
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaUtilMap.get(str)).stop();
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaUtilMap.get(str)).release();
      ((TVK_IMediaPlayer)this.jdField_a_of_type_JavaUtilMap.get(str)).removeAllListener();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase != null) && (((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getParent() != null)) {
      ((ViewGroup)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getParent()).removeView((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
    }
    e();
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
    getActivity().overridePendingTransition(0, 2130772305);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase != null) && (this.jdField_f_of_type_Boolean))
    {
      ayaz localayaz = (ayaz)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag();
      if (((localayaz instanceof ayay)) && (!this.jdField_c_of_type_Boolean)) {
        a(((ayay)localayaz).jdField_a_of_type_Aybp, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      b((ayaz)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag());
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    this.jdField_g_of_type_Boolean = false;
    l();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase == null) {
      return;
    }
    l();
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      b((ayaz)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag());
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setKeepScreenOn(true);
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase != null))
    {
      if (!this.jdField_f_of_type_Boolean)
      {
        ayaz localayaz = (ayaz)((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag();
        if (((localayaz instanceof ayay)) && (!this.jdField_c_of_type_Boolean))
        {
          a(((ayay)localayaz).jdField_a_of_type_Aybp, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          if (this.jdField_h_of_type_Boolean) {
            this.jdField_c_of_type_Boolean = true;
          }
        }
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setKeepScreenOn(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment
 * JD-Core Version:    0.7.0.1
 */