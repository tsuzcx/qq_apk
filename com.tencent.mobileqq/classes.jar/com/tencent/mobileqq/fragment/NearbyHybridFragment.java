package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.CircleImageView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.RefreshView.OnRefreshListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.nearby.NearPeopleFilters;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.EnterItem;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter.OnItemClickListener;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.home.INearbyTabInfo;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.INearbyProcObserver;
import com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper;
import com.tencent.mobileqq.nearby.redtouch.INearbyRecommendPeopleInfo;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedDotCustomInfo;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.nearby.widget.NearbyActivityDialog;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.OnItemClickListener;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout.OnActionListener;
import com.tencent.mobileqq.nearby.widget.OverlapLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.NearbyPeople;

public class NearbyHybridFragment
  extends NearbyBaseFragment
  implements Handler.Callback
{
  public static boolean M = false;
  public static final Runnable N = new NearbyHybridFragment.2();
  protected static SosoLbsInfo g;
  protected static long h;
  protected NearPeopleFilters A = new NearPeopleFilters();
  protected boolean B = false;
  protected boolean C = false;
  protected long D = 0L;
  protected View E;
  protected View F;
  protected FrameLayout G;
  protected View H;
  protected int I = -1;
  protected boolean J = false;
  protected boolean K = false;
  protected boolean L = false;
  protected long O = 0L;
  protected long P = 0L;
  CookieManager Q;
  protected boolean R = false;
  protected long S = 0L;
  protected String T = "";
  protected RefreshView.OnRefreshListener U = new NearbyHybridFragment.8(this);
  protected OverCoverFrameLayout.OnActionListener V = new NearbyHybridFragment.9(this);
  protected View.OnClickListener W = new NearbyHybridFragment.11(this);
  NearbyPublishMenu.OnItemClickListener X = new NearbyHybridFragment.12(this);
  protected NearbyFragmentEnterAdapter.OnItemClickListener Y = new NearbyHybridFragment.13(this);
  protected RedTouch Z;
  public NearbyActivity a;
  protected String aa = "";
  protected INearbyProcObserver ab = new NearbyHybridFragment.17(this);
  protected NearbyObserver ac = new NearbyHybridFragment.18(this);
  protected ActionSheet ad;
  int ae = 0;
  String af = "";
  public NearbyHybridFragment.NearbyWebViewBuilder b;
  public RefreshView c;
  public OverCoverFrameLayout d;
  protected LinearLayout e;
  protected View f;
  protected String i = "";
  public String r = "";
  protected NearbyFragmentEnterAdapter s;
  protected LinearLayout t;
  protected View u;
  protected OverlapLayout v;
  protected URLImageView w;
  protected TextView x;
  protected boolean y;
  protected boolean z = true;
  
  private void F()
  {
    if ((((INearbyRecommendPeopleInfo)QRoute.api(INearbyRecommendPeopleInfo.class)).getLatestRecommendList() != null) && (this.ai))
    {
      this.v.removeAllViews();
      int j = 0;
      Iterator localIterator = ((INearbyRecommendPeopleInfo)QRoute.api(INearbyRecommendPeopleInfo.class)).getLatestRecommendList().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (oidb_0x8dd.NearbyPeople)localIterator.next();
        if (j >= 3) {
          return;
        }
        localObject = ((oidb_0x8dd.NearbyPeople)localObject).bytes_picture_face.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          a((String)localObject, getResources().getDrawable(2130841060));
          j += 1;
        }
      }
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    URLImageView localURLImageView = new URLImageView(getBaseActivity());
    localURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.b(30.0F, getBaseActivity().getResources()), AIOUtils.b(30.0F, getBaseActivity().getResources())));
    localURLImageView.setImageDrawable(paramDrawable);
    this.v.addView(localURLImageView);
  }
  
  private void a(INearbyRedDotCustomInfo paramINearbyRedDotCustomInfo)
  {
    NearbyHandler localNearbyHandler = (NearbyHandler)this.k.getBusinessHandler(NearbyConstants.a);
    if (!((INearbyRecommendPeopleInfo)QRoute.api(INearbyRecommendPeopleInfo.class)).getLatestRecommendMsgid().equals(paramINearbyRedDotCustomInfo.getRecommendPeopleMsgId())) {
      localNearbyHandler.a(paramINearbyRedDotCustomInfo.getRecommendPeopleMsgId());
    }
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addAvatarImg,avatarUrl =  ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyRecommend", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (FrameLayout)getBaseActivity().getLayoutInflater().inflate(2131625509, null);
    CircleImageView localCircleImageView = (CircleImageView)((FrameLayout)localObject).findViewById(2131435404);
    localCircleImageView.setBorderColor(-11382188);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    localURLDrawableOptions.mFailedDrawable = paramDrawable;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(URLDrawableDecodeHandler.a(1000, 1000));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.o);
    localCircleImageView.setImageDrawable(paramString);
    this.v.addView((View)localObject);
  }
  
  public void A()
  {
    this.D = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment.duration", 2, "resetUserBrowseTime");
    }
  }
  
  public void B()
  {
    int j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.k.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
    long l2 = (System.currentTimeMillis() - this.D) / 1000L;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 1L;
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "home", "home_exp", 0, 0, "", String.valueOf(j), "", String.valueOf(l1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportUserBroseTime: d2[gender]=");
      localStringBuilder.append(j);
      localStringBuilder.append(", d4[duration]=");
      localStringBuilder.append(l1);
      QLog.d("nearby.NearbyHybridFragment.duration", 2, localStringBuilder.toString());
    }
  }
  
  public void C()
  {
    try
    {
      localObject1 = this.k.getNearbyProcManager();
      Object localObject2 = ((INearbyProcManager)localObject1).a(11);
      String str;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleNearbyActivityTip, dotInfo=");
        if (localObject2 == null) {
          str = "";
        } else {
          str = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get();
        }
        localStringBuilder.append(str);
        localStringBuilder.append(", isFinish=");
        localStringBuilder.append(this.ag.isFinishing());
        QLog.d("nearby.redpoint", 2, localStringBuilder.toString());
      }
      if ((localObject2 != null) && (!this.ag.isFinishing()))
      {
        str = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.get();
        localObject2 = new NearbyActivityDialog((AppInterface)this.k, this.ag);
        if (((NearbyActivityDialog)localObject2).a(str)) {
          ((NearbyActivityDialog)localObject2).show();
        }
        ((INearbyProcManager)localObject1).b(58);
        ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "pop_clk_red", 0, 0, String.valueOf(((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.k.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleNearbyActivityTip, exp=");
      ((StringBuilder)localObject1).append(localException.toString());
      QLog.d("nearby.redpoint", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext());
    Object localObject;
    if (bool) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    String str2 = NetworkUtil.getApn(BaseApplicationImpl.getContext());
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "home", "loc_time_out", 0, 0, String.valueOf(paramInt), String.valueOf(5000), (String)localObject, str1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportTimeOut: isNetworkOk=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", APN=");
      ((StringBuilder)localObject).append(str1);
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(NearbyFragmentEnterAdapter.EnterItem paramEnterItem)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(INearbyAppInterface paramINearbyAppInterface)
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("nearby.NearbyHybridFragment", "createWebView", new Object[] { this.b, this.a, paramINearbyAppInterface });
      }
      if ((this.b == null) && (this.a != null) && (paramINearbyAppInterface != null))
      {
        Context localContext = this.a.getBaseContext();
        this.b = new NearbyHybridFragment.NearbyWebViewBuilder(this, localContext, this.a, (AppInterface)paramINearbyAppInterface);
        paramINearbyAppInterface = new TouchWebView(localContext);
        paramINearbyAppInterface.setBackgroundColor(-1);
        this.b.a(paramINearbyAppInterface);
        if (QSecFramework.c().a(1001).booleanValue()) {
          QSecFramework.c().a(5, 0, 1, new Object[] { Integer.valueOf(83), paramINearbyAppInterface }, null);
        }
        paramINearbyAppInterface.setOnTouchListener(new NearbyHybridFragment.6(this));
        long l = System.currentTimeMillis();
        this.b.a();
        this.a.mInitTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitTime", new Object[] { Long.valueOf(this.a.mInitTime) });
        }
        if (QLog.isColorLevel())
        {
          paramINearbyAppInterface = new StringBuilder();
          paramINearbyAppInterface.append("init webView time:");
          paramINearbyAppInterface.append(this.a.mInitTime);
          QLog.i("nearby.NearbyHybridFragment.webloading", 2, paramINearbyAppInterface.toString());
        }
        this.n = true;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(SosoLbsInfo paramSosoLbsInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 575	com/tencent/mobileqq/fragment/NearbyHybridFragment:b	Lcom/tencent/mobileqq/fragment/NearbyHybridFragment$NearbyWebViewBuilder;
    //   4: ifnonnull +20 -> 24
    //   7: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +183 -> 193
    //   13: ldc_w 554
    //   16: iconst_2
    //   17: ldc_w 648
    //   20: invokestatic 650	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload_0
    //   25: getfield 575	com/tencent/mobileqq/fragment/NearbyHybridFragment:b	Lcom/tencent/mobileqq/fragment/NearbyHybridFragment$NearbyWebViewBuilder;
    //   28: invokevirtual 654	com/tencent/mobileqq/fragment/NearbyHybridFragment$NearbyWebViewBuilder:getWebView	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +95 -> 128
    //   36: new 656	org/json/JSONObject
    //   39: dup
    //   40: invokespecial 657	org/json/JSONObject:<init>	()V
    //   43: astore_3
    //   44: aload_3
    //   45: ldc_w 659
    //   48: aload_1
    //   49: getfield 665	com/tencent/mobileqq/soso/location/data/SosoLbsInfo:mLocation	Lcom/tencent/mobileqq/soso/location/data/SosoLocation;
    //   52: getfield 670	com/tencent/mobileqq/soso/location/data/SosoLocation:mLat02	D
    //   55: invokevirtual 674	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   58: pop
    //   59: aload_3
    //   60: ldc_w 676
    //   63: aload_1
    //   64: getfield 665	com/tencent/mobileqq/soso/location/data/SosoLbsInfo:mLocation	Lcom/tencent/mobileqq/soso/location/data/SosoLocation;
    //   67: getfield 679	com/tencent/mobileqq/soso/location/data/SosoLocation:mLon02	D
    //   70: invokevirtual 674	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   73: pop
    //   74: ldc_w 681
    //   77: aload_3
    //   78: aconst_null
    //   79: invokestatic 687	com/tencent/mobileqq/webview/swift/WebViewPlugin:toJsScript	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)Ljava/lang/String;
    //   82: astore_1
    //   83: aload_2
    //   84: aload_1
    //   85: invokevirtual 692	com/tencent/biz/pubaccount/CustomWebView:callJs	(Ljava/lang/String;)V
    //   88: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +97 -> 188
    //   94: new 327	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   101: astore_2
    //   102: aload_2
    //   103: ldc_w 694
    //   106: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_2
    //   111: aload_1
    //   112: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: ldc_w 554
    //   119: iconst_2
    //   120: aload_2
    //   121: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: return
    //   128: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +57 -> 188
    //   134: ldc_w 554
    //   137: iconst_2
    //   138: ldc_w 696
    //   141: invokestatic 650	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: return
    //   145: astore_1
    //   146: invokestatic 325	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +39 -> 188
    //   152: new 327	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 328	java/lang/StringBuilder:<init>	()V
    //   159: astore_2
    //   160: aload_2
    //   161: ldc_w 698
    //   164: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_2
    //   169: aload_1
    //   170: invokevirtual 526	java/lang/Exception:toString	()Ljava/lang/String;
    //   173: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc_w 554
    //   180: iconst_2
    //   181: aload_2
    //   182: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 700	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: return
    //   189: astore_1
    //   190: goto -116 -> 74
    //   193: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	NearbyHybridFragment
    //   0	194	1	paramSosoLbsInfo	SosoLbsInfo
    //   31	151	2	localObject	Object
    //   43	35	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	23	145	java/lang/Exception
    //   24	32	145	java/lang/Exception
    //   36	44	145	java/lang/Exception
    //   74	127	145	java/lang/Exception
    //   128	144	145	java/lang/Exception
    //   44	74	189	java/lang/Exception
  }
  
  protected void a(ilive_feeds_near_anchor.NearAnchorInfo paramNearAnchorInfo)
  {
    Object localObject2;
    Object localObject1;
    if ((paramNearAnchorInfo != null) && (paramNearAnchorInfo.jump_type.get() != 1))
    {
      if (paramNearAnchorInfo.jump_type.get() == 2)
      {
        localObject2 = String.format("nowmqqapi://now/openroom?src_type=app&version=1&fromid=10006&roomid=%d&first=1&startsrc=fujin7", new Object[] { Integer.valueOf(paramNearAnchorInfo.root_roomid.get()) });
        localObject1 = localObject2;
        if (paramNearAnchorInfo.cover_url.has())
        {
          paramNearAnchorInfo = paramNearAnchorInfo.cover_url.get().toStringUtf8();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("&coverurl=");
          ((StringBuilder)localObject1).append(paramNearAnchorInfo);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        paramNearAnchorInfo = null;
        localObject2 = this.ag.getIntent();
        if (localObject2 != null) {
          paramNearAnchorInfo = ((Intent)localObject2).getStringExtra("big_brother_source_key");
        }
        localObject2 = new Intent(this.ag, JumpActivity.class);
        if (!TextUtils.isEmpty(paramNearAnchorInfo)) {
          ((Intent)localObject2).putExtra("big_brother_source_key", paramNearAnchorInfo);
        }
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        this.ag.startActivity((Intent)localObject2);
        if (QLog.isColorLevel())
        {
          paramNearAnchorInfo = new StringBuilder();
          paramNearAnchorInfo.append("jump from nearby|uri:");
          paramNearAnchorInfo.append((String)localObject1);
          QLog.d("nearby.NearbyHybridFragmentQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, paramNearAnchorInfo.toString());
        }
      }
    }
    else
    {
      int j = this.k.getNearbyProcManager().b() + 1;
      this.i = "";
      if (g != null)
      {
        paramNearAnchorInfo = new StringBuilder();
        paramNearAnchorInfo.append("&latitude=");
        paramNearAnchorInfo.append(g.mLocation.mLat02);
        paramNearAnchorInfo.append("&longitude=");
        paramNearAnchorInfo.append(g.mLocation.mLon02);
        this.i = paramNearAnchorInfo.toString();
      }
      if (j != -1)
      {
        paramNearAnchorInfo = new StringBuilder();
        paramNearAnchorInfo.append(this.i);
        paramNearAnchorInfo.append("&gender=");
        if (j == 2) {
          j = 2;
        } else {
          j = 1;
        }
        paramNearAnchorInfo.append(j);
        this.i = paramNearAnchorInfo.toString();
      }
      if ((NowLiveFragment.i != null) && (NowLiveFragment.i.length() > 0))
      {
        paramNearAnchorInfo = this.Q;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("p_skey=");
        ((StringBuilder)localObject1).append(NowLiveFragment.i);
        paramNearAnchorInfo.setCookie("now.qq.com", ((StringBuilder)localObject1).toString());
        if (QLog.isColorLevel())
        {
          paramNearAnchorInfo = new StringBuilder();
          paramNearAnchorInfo.append("now.qq.com pskey : ");
          paramNearAnchorInfo.append(NowLiveFragment.i);
          QLog.i("nearby.NearbyHybridFragment", 2, paramNearAnchorInfo.toString());
        }
        CookieSyncManager.getInstance().sync();
        n();
        return;
      }
      if (this.Q.getCookie("now.qq.com") != null)
      {
        paramNearAnchorInfo = this.Q.getCookie("now.qq.com");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("now.qq.com cookie : ");
          ((StringBuilder)localObject1).append(paramNearAnchorInfo);
          QLog.i("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramNearAnchorInfo.contains("p_skey"))
        {
          n();
          return;
        }
      }
      NowLiveFragment.i = this.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getString("pskey", "");
      long l = this.ag.getSharedPreferences("NearbyActivity.nearByTabUrl", 4).getLong("pskey_t", 0L);
      if ((NowLiveFragment.i != null) && (NowLiveFragment.i.length() > 0) && (System.currentTimeMillis() - l < 21600000L))
      {
        paramNearAnchorInfo = this.Q;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("p_skey=");
        ((StringBuilder)localObject1).append(NowLiveFragment.i);
        paramNearAnchorInfo.setCookie("now.qq.com", ((StringBuilder)localObject1).toString());
        CookieSyncManager.getInstance().sync();
        n();
        return;
      }
      paramNearAnchorInfo = new NearbyHybridFragment.14(this);
      this.l.postDelayed(paramNearAnchorInfo, 1000L);
      paramNearAnchorInfo = (TicketManager)this.k.getManager(2);
      localObject1 = this.k.getCurrentAccountUin();
      localObject2 = new NearbyHybridFragment.15(this);
      paramNearAnchorInfo.getPskey((String)localObject1, 16L, new String[] { "now.qq.com" }, (WtTicketPromise)localObject2);
    }
  }
  
  protected void a(StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    paramStringBuilder.append("&");
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("=");
    paramStringBuilder.append(paramObject);
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    this.af = paramString;
    this.ae = paramInt;
    if (paramBoolean)
    {
      this.f.setVisibility(0);
      NearbyUtils.b((AppInterface)this.k, "exp_pub", 1);
      return;
    }
    this.f.setVisibility(8);
  }
  
  public AbsWebView b()
  {
    return this.b;
  }
  
  public void c()
  {
    QLog.d("nearby.NearbyHybridFragment.webloading", 1, "checkLocation");
    if ((Build.VERSION.SDK_INT >= 23) && (getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
    {
      QLog.e("nearby.NearbyHybridFragment.webloading", 1, "ACCESS_FINE_LOCATION permission not granted!");
      this.I = 1;
      return;
    }
    long l = System.currentTimeMillis() - h;
    if ((g != null) && (l <= 300000L))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startLocation useCache timeDiff=");
        localStringBuilder.append(l);
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, localStringBuilder.toString());
      }
      d();
      ReportController.b(null, "dc00899", "grp_lbs", "", "home", "loc_use_cache", 0, 0, "", "", "", "");
      return;
    }
    l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, "send [MSG_SHOW_LOADING | MSG_LOCATION_TIME_OUT] before startLocation");
    }
    this.l.removeMessages(3);
    this.l.removeMessages(7);
    this.R = false;
    this.L = false;
    this.l.sendEmptyMessageDelayed(3, 500L);
    this.l.sendEmptyMessageDelayed(7, 5000L);
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new NearbyHybridFragment.3(this, 3, true, false, 300000L, true, false, "NearbyNowliveTab", l));
  }
  
  public void d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void dw_()
  {
    super.dw_();
    this.l.sendEmptyMessage(1);
  }
  
  protected void h()
  {
    ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext(), "nearby_shouye_preload");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    int j = 2;
    if (k != 1) {
      if (k != 3)
      {
        if ((k != 5) && (k != 6))
        {
          if (k != 7) {
            return false;
          }
          this.L = true;
          if (g == null)
          {
            g = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getNearbyLastLocation(this.k.getCurrentAccountUin());
            j = 1;
          }
          if (g == null)
          {
            g = new SosoLbsInfo();
            g.mLocation = new SosoLocation();
            g.mLocation.mLat02 = 0.0D;
            g.mLocation.mLon02 = 0.0D;
            j = 3;
          }
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage MSG_LOCATION_TIME_OUT， locType=");
          paramMessage.append(j);
          QLog.d("nearby.NearbyHybridFragment.webloading", 1, paramMessage.toString());
          d();
          a(j);
          return false;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage MSG_SHOW_LOADING: isLoadingFinished=");
          paramMessage.append(this.R);
          QLog.w("nearby.NearbyHybridFragment.webloading", 2, paramMessage.toString());
        }
        if (this.R) {
          break label604;
        }
        paramMessage = this.E;
        if (paramMessage == null) {
          break label604;
        }
        if (paramMessage != null) {
          paramMessage.setVisibility(0);
        }
        paramMessage = this.F;
        if (paramMessage != null) {
          paramMessage.setVisibility(8);
        }
        paramMessage = this.H;
        if (paramMessage == null) {
          break label604;
        }
        paramMessage.setVisibility(8);
        return false;
      }
    }
    if (paramMessage.what == 5)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage attach-locationEnd cost=");
        paramMessage.append(System.currentTimeMillis() - this.O);
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, paramMessage.toString());
      }
    }
    else if (paramMessage.what == 6)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage attach-viewInitEnd cost=");
        paramMessage.append(System.currentTimeMillis() - this.O);
        QLog.d("nearby.NearbyHybridFragment.webloading", 2, paramMessage.toString());
      }
    }
    else if ((paramMessage.what == 1) && (QLog.isColorLevel())) {
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, "handleMessage MSG_INIT");
    }
    if (this.J)
    {
      j = this.I;
      if (j == 0)
      {
        if ((this.B) && (!this.C) && (g != null))
        {
          this.C = true;
          this.l.postDelayed(new NearbyHybridFragment.7(this), 2000L);
        }
        if ((this.m) && (!this.K))
        {
          this.K = true;
          this.b.a(this.T);
          return false;
        }
      }
      else if (j == 1)
      {
        if (NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
        {
          paramMessage = this.H;
          if (paramMessage != null) {
            paramMessage.setVisibility(0);
          }
          paramMessage = this.E;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          paramMessage = this.F;
          if (paramMessage != null)
          {
            paramMessage.setVisibility(8);
            return false;
          }
        }
        else
        {
          paramMessage = this.H;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          paramMessage = this.E;
          if (paramMessage != null) {
            paramMessage.setVisibility(8);
          }
          paramMessage = this.F;
          if (paramMessage != null) {
            paramMessage.setVisibility(0);
          }
        }
      }
    }
    label604:
    return false;
  }
  
  public void i()
  {
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh: mAbsWebView == null");
      }
      return;
    }
    Object localObject2 = ((NearbyHybridFragment.NearbyWebViewBuilder)localObject1).getWebView();
    if (localObject2 != null)
    {
      localObject1 = WebViewPlugin.toJsScript("qbrowserPullDown", null, null);
      ((CustomWebView)localObject2).callJs((String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("notifyWebViewRefresh:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewRefresh, webView==null");
    }
  }
  
  public void j()
  {
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewShow: mAbsWebView == null");
      }
      return;
    }
    localObject1 = ((NearbyHybridFragment.NearbyWebViewBuilder)localObject1).getWebView();
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("hidden", false);
      label52:
      localObject2 = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject2, null);
      ((CustomWebView)localObject1).callJs((String)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyWebViewShow:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject1).toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.w("nearby.NearbyHybridFragment", 2, "notifyWebViewShow, webView==null");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public void k()
  {
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewHide: mAbsWebView == null");
      }
      return;
    }
    localObject1 = ((NearbyHybridFragment.NearbyWebViewBuilder)localObject1).getWebView();
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject2).put("hidden", true);
      label52:
      localObject2 = WebViewPlugin.toJsScript("qbrowserVisibilityChangeV2", (JSONObject)localObject2, null);
      ((CustomWebView)localObject1).callJs((String)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("notifyWebViewHide:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject1).toString());
        return;
        if (QLog.isColorLevel()) {
          QLog.w("nearby.NearbyHybridFragment", 2, "notifyWebViewHide, webView==null");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public NearPeopleFilters l()
  {
    return this.A;
  }
  
  public int m()
  {
    if (this.d.d()) {
      return 0;
    }
    return 1;
  }
  
  protected void n()
  {
    if (!this.y) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(NearbyActivity.nearByTabUrl);
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("&_t=");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    Intent localIntent = new Intent(this.ag, QQBrowserActivity.class);
    localIntent.putExtra("url", (String)localObject);
    this.ag.startActivity(localIntent);
  }
  
  protected ArrayList<NearbyFragmentEnterAdapter.EnterItem> o()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.k.getCurrentAccountUin(), "key_banner_enter_items", "");
    int j = 0;
    this.B = false;
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        Object localObject2;
        NearbyFragmentEnterAdapter.EnterItem localEnterItem;
        if (j < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optJSONObject(j);
          localEnterItem = new NearbyFragmentEnterAdapter.EnterItem();
          localEnterItem.b = ((JSONObject)localObject2).optString("iconUrl");
          localEnterItem.a = ((JSONObject)localObject2).optString("jumpUrl");
          localEnterItem.g = ((JSONObject)localObject2).optString("scheme");
          localEnterItem.h = ((JSONObject)localObject2).optString("package");
          localEnterItem.c = ((JSONObject)localObject2).optString("name");
          localEnterItem.d = ((JSONObject)localObject2).optInt("id");
          localEnterItem.f = ((JSONObject)localObject2).optInt("openapp");
        }
        switch (localEnterItem.d)
        {
        case 6: 
          localEnterItem.e = 8;
          break;
        case 5: 
          localEnterItem.e = 4;
          break;
        case 4: 
          localEnterItem.e = 7;
          break;
        case 3: 
          localEnterItem.e = 2;
          break;
        case 2: 
          localEnterItem.e = 1;
          break;
        case 1: 
          this.B = true;
          localEnterItem.e = 6;
          NearbyUtils.b((AppInterface)this.k, "exp_op_button", localEnterItem.d);
          localArrayList.add(localEnterItem);
          j += 1;
          continue;
          return localArrayList;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getBannerItems:");
          ((StringBuilder)localObject2).append(localException.toString());
          QLog.e("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((this.a == null) && ((paramActivity instanceof NearbyActivity))) {
      this.a = ((NearbyActivity)paramActivity);
    }
    this.A = y();
    this.O = System.currentTimeMillis();
    if (this.k.getmLastTabIndex() == 0) {
      this.P = System.currentTimeMillis();
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("onAttach, mLastTabIndex=");
      paramActivity.append(this.k.getmLastTabIndex());
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, paramActivity.toString());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    NearbyActivity localNearbyActivity = this.a;
    if ((localNearbyActivity != null) && (localNearbyActivity.mOnCreateMilliTimeStamp == 0L))
    {
      this.a.mOnCreateMilliTimeStamp = System.currentTimeMillis();
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.a.mOnCreateMilliTimeStamp) });
      }
    }
    super.onCreate(paramBundle);
    paramBundle = this.a;
    if ((paramBundle != null) && (paramBundle.onCreateTime == 0L))
    {
      this.a.onCreateTime = (System.currentTimeMillis() - this.a.mOnCreateMilliTimeStamp);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "onCreateTime", new Object[] { Long.valueOf(this.a.onCreateTime) });
      }
    }
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setObtainLocAllowed(this.k.getAccount(), true);
    long l = System.currentTimeMillis();
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.k.getAccount(), "nearby_enter_time", Long.valueOf(l));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, "onCreateView");
    }
    A();
    long l1;
    if (this.a != null) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = 0L;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("nearby.NearbyHybridFragment", new Object[] { "onCreateView", Long.valueOf(l1) });
    }
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.z) {
      c();
    }
    if (this.am == null)
    {
      long l2 = System.currentTimeMillis();
      a(this.k);
      CookieSyncManager.createInstance(this.ag);
      this.Q = CookieManager.getInstance();
      this.Q.setAcceptCookie(true);
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("total createWebView time:");
        paramViewGroup.append(System.currentTimeMillis() - l2);
        QLog.i("nearby.NearbyHybridFragment.webloading", 2, paramViewGroup.toString());
      }
      this.am = paramLayoutInflater.inflate(2131625502, null);
      this.c = ((RefreshView)this.am.findViewById(2131450066));
      this.d = ((OverCoverFrameLayout)this.am.findViewById(2131439739));
      this.d.setOnActionListener(this.V);
      this.f = this.am.findViewById(2131432575);
      this.f.setOnClickListener(this.W);
      this.e = ((LinearLayout)this.am.findViewById(2131432564));
      this.G = ((FrameLayout)this.am.findViewById(2131450073));
      this.u = this.am.findViewById(2131428615);
      paramLayoutInflater = this.am.findViewById(2131429286);
      if (("Meizu".equalsIgnoreCase(Build.BRAND)) && ("M040".equalsIgnoreCase(Build.MODEL)) && (paramLayoutInflater != null)) {
        paramLayoutInflater.setVisibility(8);
      }
      paramLayoutInflater = o();
      this.s = new NearbyFragmentEnterAdapter(this.ag, this.e);
      this.s.a(paramLayoutInflater);
      this.s.a(this.Y);
      this.t = ((LinearLayout)this.am.findViewById(2131442448));
      this.t.setOnClickListener(this.W);
      this.v = ((OverlapLayout)this.am.findViewById(2131442447));
      this.x = ((TextView)this.am.findViewById(2131442449));
      this.c.setDelayBeforeScrollBack(800L);
      this.b.mWebview.setOnOverScrollHandler(this.c);
      this.b.mWebview.setOnScrollChangedListener(new NearbyHybridFragment.1(this));
      paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
      this.G.addView(this.b.mWebview, 0, paramLayoutInflater);
      if (QLog.isColorLevel())
      {
        paramLayoutInflater = new StringBuilder();
        paramLayoutInflater.append("webView add to container:");
        paramLayoutInflater.append(System.currentTimeMillis() - l2);
        QLog.i("nearby.NearbyHybridFragment.webloading", 2, paramLayoutInflater.toString());
      }
      this.E = this.G.findViewById(2131450078);
      paramLayoutInflater = (URLImageView)this.E.findViewById(2131441401);
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup.mLoadingDrawable = URLDrawableHelperConstants.a;
      paramViewGroup.mPlayGifImage = true;
      paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLAyBjp36ialuzyODWtr9VCdVQJo0JTrkib9eDlHdRtvS90g/", paramViewGroup));
      this.E.setVisibility(8);
      this.F = this.G.findViewById(2131450075);
      this.H = this.G.findViewById(2131437689);
      this.E.setOnClickListener(this.W);
      this.F.setOnClickListener(this.W);
      this.H.setOnClickListener(this.W);
    }
    this.aj.b(getString(2131892066)).a(false);
    s();
    this.c.setOnRefreshListener(this.U);
    paramLayoutInflater = this.a;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.mViewInflateTime == 0L))
    {
      this.a.mViewInflateTime = (System.currentTimeMillis() - l1);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mViewInflateTime", new Object[] { Long.valueOf(this.a.mViewInflateTime) });
      }
    }
    if (this.z)
    {
      this.z = false;
      this.k.addObserver(this.ac);
      this.k.addNearbyProcObserver(this.ab);
      this.s.a(this.k);
      u();
      this.J = true;
      this.l.sendEmptyMessage(6);
    }
    return this.am;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (!this.n) {
      return;
    }
    this.k.removeObserver(this.ac);
    this.k.removeNearbyProcObserver(this.ab);
    this.s.b(null);
    this.b.d();
    this.l.removeCallbacksAndMessages(null);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyHybridFragment", 2, "onDestroyView");
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHiddenChanged: hidden=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      k();
      B();
      localObject = this.Z;
      if (localObject != null) {
        ((RedTouch)localObject).a((BusinessInfoCheckUpdate.RedTypeInfo)null);
      }
    }
    else
    {
      j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (!this.n) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPause:");
      localStringBuilder.append(this.y);
      QLog.i("nearby.NearbyHybridFragment", 2, localStringBuilder.toString());
    }
    this.y = false;
    this.b.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.n) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume:");
      ((StringBuilder)localObject).append(this.y);
      QLog.i("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject).toString());
    }
    A();
    this.y = true;
    this.b.b();
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
      QQToast.makeText(getBaseActivity(), 1, HardCodeUtil.a(2131905059), 0).show(getBaseActivity().getTitleBarHeight());
    }
    Object localObject = this.s;
    if (localObject != null) {
      ((NearbyFragmentEnterAdapter)localObject).a(this.k);
    }
    t();
    u();
    if (this.I == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("nearby.NearbyHybridFragment", 2, "onResume, re checkLocation");
      }
      c();
    }
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
    String str1 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_param", "");
    if (!TextUtils.isEmpty(str1))
    {
      String str2 = ((SharedPreferences)localObject).getString("nearby_now_delete_success_js_callback", "");
      if (!TextUtils.isEmpty(str2))
      {
        this.b.mWebview.callJs(str2, new String[] { str1 });
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("nearby_now_delete_success_js_param", "");
        ((SharedPreferences.Editor)localObject).remove("nearby_now_delete_success_js_param").commit();
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    h();
  }
  
  protected String p()
  {
    if (this.q != null) {
      localObject1 = this.q.getTabUrl();
    } else {
      localObject1 = "";
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(this.r);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    Object localObject3 = r();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject3 = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getUrlJsonToStr(((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getNearbyTabUrlParams());
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append((String)localObject3);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    int j = q();
    localObject1 = localObject2;
    if (j != -1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("&initTab=");
      ((StringBuilder)localObject1).append(j);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (this.P != 0L)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&_t=");
      ((StringBuilder)localObject2).append(this.P);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getUrl, url=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("nearby.NearbyHybridFragment.webloading", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  protected int q()
  {
    Intent localIntent = this.ag.getIntent();
    if (localIntent != null) {
      return localIntent.getIntExtra("nearby_main_init_tab", -1);
    }
    return -1;
  }
  
  protected StringBuilder r()
  {
    if (this.A != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      a(localStringBuilder, "sex", Integer.valueOf(this.A.a()));
      a(localStringBuilder, "time", Integer.valueOf(this.A.b()));
      a(localStringBuilder, "age", Integer.valueOf(this.A.c()));
      a(localStringBuilder, "interest", Integer.valueOf(this.A.d()));
      a(localStringBuilder, "profession", Integer.valueOf(this.A.f()));
      a(localStringBuilder, "country", this.A.g()[0]);
      a(localStringBuilder, "province", this.A.g()[1]);
      a(localStringBuilder, "city", this.A.g()[2]);
      a(localStringBuilder, "contellation", Integer.valueOf(this.A.e()));
      return localStringBuilder;
    }
    return null;
  }
  
  protected void s()
  {
    t();
    this.aj.a(HardCodeUtil.a(2131905060)).a(new NearbyHybridFragment.16(this));
    this.aj.a();
  }
  
  public void t()
  {
    Object localObject = (NearbyActivity)getBaseActivity();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateRightBtnRedTouch, selectIdx=");
      int k = -1;
      int j;
      if (localObject == null) {
        j = -1;
      } else {
        j = ((NearbyActivity)localObject).getCurrentIndex();
      }
      localStringBuilder.append(j);
      localStringBuilder.append(", selfIdx=");
      if (this.q == null) {
        j = k;
      } else {
        j = this.q.getTabIndex();
      }
      localStringBuilder.append(j);
      QLog.d("nearby.NearbyHybridFragment", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (this.q != null) && (((NearbyActivity)localObject).getCurrentIndex() == this.q.getTabIndex()))
    {
      localObject = (NearbyActivity)getActivity();
      if (localObject != null)
      {
        if (this.Z == null)
        {
          this.Z = new RedTouch((Context)localObject, ((NearbyActivity)localObject).rightViewText);
          this.Z.c(53).a();
        }
        localObject = this.k.getNearbyProcManager().a(9);
        this.Z.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      }
    }
    else
    {
      localObject = this.Z;
      if (localObject != null) {
        ((RedTouch)localObject).a(null);
      }
    }
  }
  
  public void u()
  {
    if ((this.t != null) && (getBaseActivity() != null))
    {
      if (getBaseActivity().isFinishing()) {
        return;
      }
      INearbyProcManager localINearbyProcManager = this.k.getNearbyProcManager();
      Object localObject2 = localINearbyProcManager.a(10);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch: redTypeInfo==null");
        }
        this.t.setVisibility(8);
        return;
      }
      int j;
      try
      {
        j = Integer.valueOf(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.get()).intValue();
        String str;
        if (j > 99)
        {
          str = "99+";
          break label141;
        }
        try
        {
          str = String.valueOf(j);
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          break label138;
        }
      }
      catch (Exception localException2)
      {
        j = 0;
      }
      QLog.e("nearby.NearbyHybridFragment", 2, "updateUnReadMsgRedTouch exp=", localException2);
      label138:
      Object localObject1 = "";
      label141:
      int k = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get();
      INearbyRedDotCustomInfo localINearbyRedDotCustomInfo = (INearbyRedDotCustomInfo)QRoute.api(INearbyRedDotCustomInfo.class);
      localINearbyRedDotCustomInfo.parse((BusinessInfoCheckUpdate.RedTypeInfo)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateUnReadMsgRedTouch: redType=");
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append(", numStr=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject2).toString());
      }
      if (((localINearbyRedDotCustomInfo.getIsOfficialNotify()) || (k == 5)) && (j > 0) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        this.t.setVisibility(0);
        if ((j == 1) && (localINearbyRedDotCustomInfo.getIsOfficialNotify()) && (!TextUtils.isEmpty(localINearbyRedDotCustomInfo.getContentMsg())))
        {
          this.x.setText(localINearbyRedDotCustomInfo.getContentMsg());
          if (localINearbyRedDotCustomInfo.getContentType() == 2) {
            a(localINearbyRedDotCustomInfo);
          }
        }
        else
        {
          localObject2 = this.x;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(HardCodeUtil.a(2131905058));
          ((TextView)localObject2).setText(localStringBuilder.toString());
        }
        this.v.removeAllViews();
        if ((!TextUtils.isEmpty(localINearbyRedDotCustomInfo.getFaceUrl())) && (HttpUtil.isValidUrl(localINearbyRedDotCustomInfo.getFaceUrl())))
        {
          localObject1 = getResources().getDrawable(2130841060);
          a(localINearbyRedDotCustomInfo.getFaceUrl(), (Drawable)localObject1);
        }
        else if (localINearbyRedDotCustomInfo.getUin() > 0L)
        {
          localObject1 = String.valueOf(localINearbyRedDotCustomInfo.getUin());
          this.aa = ((String)localObject1);
          localObject1 = localINearbyProcManager.a((String)localObject1, 1, true);
          localObject2 = new URLImageView(getBaseActivity());
          ((URLImageView)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.b(30.0F, getBaseActivity().getResources()), AIOUtils.b(30.0F, getBaseActivity().getResources())));
          if ((localObject1 != null) && (((Bitmap)localObject1).getByteCount() > 0)) {
            ((URLImageView)localObject2).setImageBitmap((Bitmap)localObject1);
          } else {
            ((URLImageView)localObject2).setImageDrawable(getResources().getDrawable(2130841060));
          }
          this.v.addView((View)localObject2);
        }
        else
        {
          a(getResources().getDrawable(2130841060));
        }
        localObject1 = localINearbyProcManager.e();
        if ((j == 1) && (((NearbyRedNum)localObject1).d == 1)) {
          F();
        }
        ((INearbyOfficalReportHelper)QRoute.api(INearbyOfficalReportHelper.class)).reportNearByRedDotEvent(this.k, "home", "news_slip_exp");
        NearbyUtils.b((AppInterface)this.k, "exp_msg", 0);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "!isOfficialNotify && redType != RedTouch.RED_TOUCH_NUM) || TextUtils.isEmpty(numStr)");
      }
      this.t.setVisibility(8);
    }
  }
  
  public void v()
  {
    ActionSheet localActionSheet = this.ad;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      return;
    }
    this.ad = ActionSheet.createMenuSheet(getBaseActivity());
    this.ad.addButton(2131896698);
    this.ad.addButton(2131896696);
    this.ad.addCancelButton(2131887648);
    this.ad.setOnButtonClickListener(new NearbyHybridFragment.19(this));
    this.ad.setOnDismissListener(new NearbyHybridFragment.20(this));
    this.ad.show();
  }
  
  protected void w()
  {
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "notifyWebViewSheetDismiss: mAbsWebView == null");
      }
      return;
    }
    Object localObject2 = ((NearbyHybridFragment.NearbyWebViewBuilder)localObject1).getWebView();
    if (localObject2 != null)
    {
      localObject1 = WebViewPlugin.toJsScript("closeFilterAndExitSheet", null, null);
      ((CustomWebView)localObject2).callJs((String)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ActionSheet onDissmiss:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("nearby.NearbyHybridFragment", 2, "ActionSheet onDissmiss, webView==null");
    }
  }
  
  protected void x()
  {
    String str = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://nearby.qq.com/people_filter/index.html", "_wwv", "4"), "sex", String.valueOf(this.A.a())), "time", String.valueOf(this.A.b())), "age", String.valueOf(this.A.c())), "interest", String.valueOf(this.A.d())), "profession", String.valueOf(this.A.f())), "country", String.valueOf(this.A.g()[0])), "strCountry", this.A.h), "province", String.valueOf(this.A.g()[1])), "strProvince", this.A.i), "city", String.valueOf(this.A.g()[2])), "strCity", this.A.j), "contellation", String.valueOf(this.A.e()));
    Object localObject = new Intent(this.ag, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", str);
    getBaseActivity().startActivity((Intent)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump2FilterSettingPage:");
      ((StringBuilder)localObject).append(str);
      QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected NearPeopleFilters y()
  {
    Object localObject2 = (NearbyDataManager)this.k.getManager(NearbyConstants.d);
    Object localObject1 = this.ag.getIntent();
    if (localObject1 != null) {
      ((NearbyDataManager)localObject2).a(this.ag.getIntent().getStringExtra("filter"));
    } else {
      localObject1 = new Intent();
    }
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("initNearbyFilter, filterMode=");
      ((StringBuilder)localObject3).append(((NearbyDataManager)localObject2).a());
      QLog.d("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject3).toString());
    }
    int j = ((NearbyDataManager)localObject2).a();
    int k = 0;
    String str2;
    String str1;
    if (j != 0)
    {
      j = ((Intent)localObject1).getIntExtra("filterGender", 0);
      int n = ((Intent)localObject1).getIntExtra("filter_time", 0);
      int i1 = ((Intent)localObject1).getIntExtra("filter_age", 0);
      int i2 = ((Intent)localObject1).getIntExtra("filter_xingzuo", 0);
      int m = ((Intent)localObject1).getIntExtra("filter_interest", 0);
      int i3 = ((Intent)localObject1).getIntExtra("filter_career", 0);
      str2 = ((Intent)localObject1).getStringExtra("filter_location");
      localObject3 = new NearPeopleFilters();
      ((NearPeopleFilters)localObject3).a(j);
      ((NearPeopleFilters)localObject3).b(n);
      ((NearPeopleFilters)localObject3).c(i1);
      ((NearPeopleFilters)localObject3).e(i2);
      ((NearPeopleFilters)localObject3).f(i3);
      if (m >= 0)
      {
        j = m;
        if (m <= NearPeopleFilters.b.length - 1) {}
      }
      else
      {
        j = 0;
      }
      ((NearPeopleFilters)localObject3).d(j);
      localObject2 = new String[5];
      localObject2[0] = "0";
      localObject2[1] = "0";
      localObject2[2] = "0";
      localObject2[3] = "0";
      str1 = "不限";
      localObject2[4] = "不限";
      localObject1 = localObject3;
      if (TextUtils.isEmpty(str2)) {
        break label489;
      }
    }
    try
    {
      localObject1 = str2.split("\\|");
      localObject2 = localObject1;
    }
    catch (Exception localException)
    {
      label333:
      label489:
      break label333;
    }
    localObject1 = localObject3;
    if (localObject2.length >= 4)
    {
      j = k;
      while (j < 4)
      {
        ((NearPeopleFilters)localObject3).g()[j] = localObject2[j];
        j += 1;
      }
      localObject1 = str1;
      if (localObject2.length >= 5) {
        localObject1 = localObject2[4];
      }
      ((NearPeopleFilters)localObject3).g = ((String)localObject1);
      return localObject3;
      localObject2 = NearPeopleFilters.a(this.k.getCurrentAccountUin());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new NearPeopleFilters();
        ((NearPeopleFilters)localObject2).a(0);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("defFilter: filters.gender=");
          ((StringBuilder)localObject1).append(((NearPeopleFilters)localObject2).a());
          QLog.d("nearby.heart_beat", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  public void z()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.S;
    long l3 = System.currentTimeMillis();
    long l4 = this.O;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideWebLoadingView:");
      ((StringBuilder)localObject).append(this.R);
      ((StringBuilder)localObject).append(", timeCostFromLoad=");
      ((StringBuilder)localObject).append(l1 - l2);
      ((StringBuilder)localObject).append(", timeCostFromAttach=");
      ((StringBuilder)localObject).append(l3 - l4);
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, ((StringBuilder)localObject).toString());
    }
    this.l.removeMessages(3);
    this.R = true;
    Object localObject = this.E;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.F;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.H;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment
 * JD-Core Version:    0.7.0.1
 */