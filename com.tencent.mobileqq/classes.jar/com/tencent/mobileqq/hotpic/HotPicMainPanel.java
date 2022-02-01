package com.tencent.mobileqq.hotpic;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.InterceptListener;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@TargetApi(15)
public class HotPicMainPanel
  extends RelativeLayout
  implements Handler.Callback, AdapterView.OnItemClickListener, PanelIconLinearLayout.InterceptListener, HotPicManager.HotPicListener, HotPicPanelViewPagerAdapter.OnHotPicPageSelectedListener, HotPicRecyclerView.PullAndFastScrollListener
{
  public static final int a;
  public static final int b;
  public static final int c;
  protected int d;
  protected boolean e;
  public QQAppInterface f;
  protected Context g;
  protected HotPicIndexAndIDMap h = new HotPicIndexAndIDMap();
  protected View i;
  protected View j;
  protected View k;
  protected PanelIconLinearLayout l;
  XPanelContainer m;
  protected BaseSessionInfo n;
  protected BaseActivity o;
  public ViewPager p;
  protected HotPicPanelViewPagerAdapter q;
  public int r = 0;
  protected PopupWindow s;
  protected HotPicTab t;
  Set<String> u = new HashSet();
  Handler v = new WeakReferenceHandler(Looper.getMainLooper(), this);
  float w;
  int x;
  private HotPicPageView.OnHotPicItemClickListener y;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    double d1 = localResources.getDisplayMetrics().heightPixels;
    Double.isNaN(d1);
    a = (int)(d1 * 0.6D);
    c = AIOUtils.b(1.0F, localResources);
    b = (localResources.getDisplayMetrics().widthPixels - c * 6) / 2;
  }
  
  public HotPicMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean j()
  {
    return (AppSetting.u.equalsIgnoreCase("oppo-x907")) || (Build.MODEL.toLowerCase().equals("mi 1s"));
  }
  
  private void k()
  {
    HotPicManager.a(this.f).i();
    this.k.setVisibility(8);
  }
  
  private boolean l()
  {
    return a > this.d;
  }
  
  public void a()
  {
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.f, "hot_pic", true);
  }
  
  public void a(int paramInt)
  {
    HotPicPageView.z = true;
    k();
    if (this.t.getCurrentSelected() != paramInt) {
      this.t.setSelection(paramInt);
    }
    this.q.a(paramInt);
    HotPicTagInfo localHotPicTagInfo = this.h.b(paramInt);
    if (localHotPicTagInfo != null)
    {
      QQAppInterface localQQAppInterface = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X8008076", "0X8008076", 0, 0, localStringBuilder.toString(), "", localHotPicTagInfo.tagName, "");
    }
  }
  
  @TargetApi(14)
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new HotPicMainPanel.1(this));
    localValueAnimator.start();
  }
  
  public void a(View paramView)
  {
    if (j())
    {
      paramView.setVisibility(0);
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.2F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.2F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.4F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(paramView);
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.setInterpolator(new OvershootInterpolator());
    localAnimatorSet.start();
  }
  
  @TargetApi(14)
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, AIOContext paramAIOContext, PanelIconLinearLayout paramPanelIconLinearLayout, XPanelContainer paramXPanelContainer)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(HotPicData paramHotPicData)
  {
    ImageView localImageView = (ImageView)this.j.findViewById(2131435174);
    Object localObject = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    int i2 = paramHotPicData.width;
    int i3 = paramHotPicData.height;
    int i1 = (int)(b * 1.5F + 0.5F);
    float f1 = i2 / i1;
    i2 = (int)(i3 / f1 + 0.5F);
    ((ViewGroup.MarginLayoutParams)localObject).width = i1;
    ((ViewGroup.MarginLayoutParams)localObject).height = i2;
    i1 = (int)(160.0F / f1 + 0.5F);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramHotPicData;
    URL localURL = HotPicOriginDownLoader.d(paramHotPicData.originalUrl);
    if (localURL == null) {
      return;
    }
    localObject = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTargetDensity(i1);
    localImageView.setImageDrawable((Drawable)localObject);
    if ((((URLDrawable)localObject).getStatus() == 2) && (NetworkUtil.isNetworkAvailable(this.g))) {
      ((URLDrawable)localObject).restartDownload();
    }
    if (this.s == null)
    {
      i1 = getResources().getDisplayMetrics().widthPixels;
      i2 = getRootView().getHeight();
      this.s = new PopupWindow(this.j, i1, i2);
    }
    if (!this.s.isShowing()) {
      this.s.showAtLocation(this, 0, 0, 0);
    }
    this.j.setVisibility(0);
    if (HotPicDownLoader.a(paramHotPicData.originalUrl).exists())
    {
      a(localImageView);
      return;
    }
    ((URLDrawable)localObject).setDownloadListener(new HotPicMainPanel.2(this, localImageView));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicManager.Panel", 2, "onHide");
    }
    HotPicPageView.z = true;
    Object localObject = this.t.getSelectedTag();
    if (localObject != null) {
      HotPicManager.a(this.f).a((HotPicTagInfo)localObject);
    }
    this.t.a();
    if (!paramBoolean) {
      XPanelContainer.a = this.d;
    }
    localObject = this.l;
    if (localObject != null) {
      ((PanelIconLinearLayout)localObject).setInterceptListener(null);
    }
    HotPicManager.a(this.f).a(null);
    this.q.a();
    this.q = null;
    this.p.setAdapter(null);
    this.p.setOnPageChangeListener(null);
    this.p.removeAllViews();
    this.h.b();
    this.u.clear();
    HotPicManager.a(this.f).e();
    setVisibility(8);
    b();
  }
  
  public void b()
  {
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.f, "hot_pic", false);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = this.v.obtainMessage(paramInt1);
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    this.v.sendMessage(localMessage);
  }
  
  public void c()
  {
    if (!l()) {
      return;
    }
    if (XPanelContainer.a == this.d)
    {
      a(200, XPanelContainer.a, a);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.Panel", 2, "onPullUp");
      }
    }
  }
  
  public void d()
  {
    if (!l()) {
      return;
    }
    if (XPanelContainer.a == a)
    {
      a(250, XPanelContainer.a, this.d);
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.Panel", 2, "onPullDown");
      }
    }
  }
  
  public void e()
  {
    HotPicTab localHotPicTab = this.t;
    if (localHotPicTab != null)
    {
      if (this.q == null) {
        return;
      }
      int i1 = localHotPicTab.getCurrentSelected();
      this.q.b(i1);
    }
  }
  
  /* Error */
  @TargetApi(16)
  protected boolean f()
  {
    // Byte code:
    //   0: getstatic 564	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_1
    //   4: iconst_1
    //   5: istore_3
    //   6: iconst_1
    //   7: istore_2
    //   8: iload_1
    //   9: bipush 16
    //   11: if_icmplt +120 -> 131
    //   14: aload_0
    //   15: getfield 566	com/tencent/mobileqq/hotpic/HotPicMainPanel:o	Lcom/tencent/mobileqq/app/BaseActivity;
    //   18: ldc_w 568
    //   21: invokevirtual 574	com/tencent/mobileqq/app/BaseActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 576	android/app/ActivityManager
    //   27: astore 11
    //   29: new 578	android/app/ActivityManager$MemoryInfo
    //   32: dup
    //   33: invokespecial 579	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   36: astore 10
    //   38: aload 11
    //   40: aload 10
    //   42: invokevirtual 583	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   45: aload 10
    //   47: getfield 587	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   50: ldc2_w 588
    //   53: lcmp
    //   54: ifge +6 -> 60
    //   57: goto +5 -> 62
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: istore_3
    //   64: invokestatic 471	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +546 -> 613
    //   70: new 231	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   77: astore 11
    //   79: aload 11
    //   81: ldc_w 591
    //   84: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 11
    //   90: aload 10
    //   92: getfield 587	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   95: invokevirtual 594	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 11
    //   101: ldc_w 596
    //   104: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 11
    //   110: ldc2_w 588
    //   113: invokevirtual 594	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: ldc_w 473
    //   120: iconst_2
    //   121: aload 11
    //   123: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload_2
    //   130: ireturn
    //   131: lconst_0
    //   132: lstore 8
    //   134: new 598	java/io/FileReader
    //   137: dup
    //   138: ldc_w 600
    //   141: invokespecial 601	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   144: astore 11
    //   146: new 603	java/io/BufferedReader
    //   149: dup
    //   150: aload 11
    //   152: sipush 2048
    //   155: invokespecial 606	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   158: astore 10
    //   160: lload 8
    //   162: lstore 6
    //   164: aload 10
    //   166: astore 12
    //   168: aload 11
    //   170: astore 13
    //   172: aload 10
    //   174: invokevirtual 609	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   177: astore 14
    //   179: lload 8
    //   181: lstore 4
    //   183: aload 14
    //   185: ifnull +71 -> 256
    //   188: lload 8
    //   190: lstore 6
    //   192: aload 10
    //   194: astore 12
    //   196: aload 11
    //   198: astore 13
    //   200: aload 14
    //   202: aload 14
    //   204: ldc_w 611
    //   207: invokevirtual 615	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   210: invokevirtual 619	java/lang/String:substring	(I)Ljava/lang/String;
    //   213: astore 14
    //   215: lload 8
    //   217: lstore 4
    //   219: aload 14
    //   221: ifnull +35 -> 256
    //   224: lload 8
    //   226: lstore 6
    //   228: aload 10
    //   230: astore 12
    //   232: aload 11
    //   234: astore 13
    //   236: aload 14
    //   238: ldc_w 621
    //   241: ldc 238
    //   243: invokevirtual 625	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   246: invokestatic 630	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   249: i2l
    //   250: ldc2_w 631
    //   253: lmul
    //   254: lstore 4
    //   256: lload 4
    //   258: lstore 6
    //   260: aload 10
    //   262: astore 12
    //   264: aload 11
    //   266: astore 13
    //   268: aload 10
    //   270: invokevirtual 635	java/io/BufferedReader:close	()V
    //   273: lload 4
    //   275: lstore 6
    //   277: aload 10
    //   279: astore 12
    //   281: aload 11
    //   283: astore 13
    //   285: aload 11
    //   287: invokevirtual 636	java/io/FileReader:close	()V
    //   290: aload 10
    //   292: invokevirtual 635	java/io/BufferedReader:close	()V
    //   295: goto +23 -> 318
    //   298: astore 10
    //   300: invokestatic 471	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +15 -> 318
    //   306: ldc_w 473
    //   309: iconst_2
    //   310: ldc_w 638
    //   313: aload 10
    //   315: invokestatic 641	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload 11
    //   320: invokevirtual 636	java/io/FileReader:close	()V
    //   323: lload 4
    //   325: lstore 6
    //   327: goto +204 -> 531
    //   330: astore 10
    //   332: lload 4
    //   334: lstore 6
    //   336: invokestatic 471	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +192 -> 531
    //   342: ldc_w 473
    //   345: iconst_2
    //   346: ldc_w 638
    //   349: aload 10
    //   351: invokestatic 641	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   354: lload 4
    //   356: lstore 6
    //   358: goto +173 -> 531
    //   361: astore 14
    //   363: lload 6
    //   365: lstore 4
    //   367: goto +48 -> 415
    //   370: astore 10
    //   372: aconst_null
    //   373: astore 12
    //   375: goto +246 -> 621
    //   378: astore 14
    //   380: aconst_null
    //   381: astore 10
    //   383: lload 8
    //   385: lstore 4
    //   387: goto +28 -> 415
    //   390: astore 10
    //   392: aconst_null
    //   393: astore 12
    //   395: aload 12
    //   397: astore 11
    //   399: goto +222 -> 621
    //   402: astore 14
    //   404: aconst_null
    //   405: astore 11
    //   407: aload 11
    //   409: astore 10
    //   411: lload 8
    //   413: lstore 4
    //   415: aload 10
    //   417: astore 12
    //   419: aload 11
    //   421: astore 13
    //   423: aload 14
    //   425: invokevirtual 644	java/io/IOException:printStackTrace	()V
    //   428: aload 10
    //   430: astore 12
    //   432: aload 11
    //   434: astore 13
    //   436: invokestatic 471	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +23 -> 462
    //   442: aload 10
    //   444: astore 12
    //   446: aload 11
    //   448: astore 13
    //   450: ldc_w 473
    //   453: iconst_2
    //   454: ldc_w 638
    //   457: aload 14
    //   459: invokestatic 641	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   462: aload 10
    //   464: ifnull +31 -> 495
    //   467: aload 10
    //   469: invokevirtual 635	java/io/BufferedReader:close	()V
    //   472: goto +23 -> 495
    //   475: astore 10
    //   477: invokestatic 471	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +15 -> 495
    //   483: ldc_w 473
    //   486: iconst_2
    //   487: ldc_w 638
    //   490: aload 10
    //   492: invokestatic 641	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   495: lload 4
    //   497: lstore 6
    //   499: aload 11
    //   501: ifnull +30 -> 531
    //   504: aload 11
    //   506: invokevirtual 636	java/io/FileReader:close	()V
    //   509: lload 4
    //   511: lstore 6
    //   513: goto +18 -> 531
    //   516: astore 10
    //   518: lload 4
    //   520: lstore 6
    //   522: invokestatic 471	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   525: ifeq +6 -> 531
    //   528: goto -186 -> 342
    //   531: lload 6
    //   533: ldc2_w 588
    //   536: lcmp
    //   537: ifge +8 -> 545
    //   540: iload_3
    //   541: istore_2
    //   542: goto +5 -> 547
    //   545: iconst_0
    //   546: istore_2
    //   547: iload_2
    //   548: istore_3
    //   549: invokestatic 471	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq +61 -> 613
    //   555: new 231	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   562: astore 10
    //   564: aload 10
    //   566: ldc_w 646
    //   569: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 10
    //   575: lload 6
    //   577: invokevirtual 594	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 10
    //   583: ldc_w 648
    //   586: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 10
    //   592: ldc2_w 588
    //   595: invokevirtual 594	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: ldc_w 473
    //   602: iconst_2
    //   603: aload 10
    //   605: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: iload_2
    //   612: istore_3
    //   613: iload_3
    //   614: ireturn
    //   615: astore 10
    //   617: aload 13
    //   619: astore 11
    //   621: aload 12
    //   623: ifnull +31 -> 654
    //   626: aload 12
    //   628: invokevirtual 635	java/io/BufferedReader:close	()V
    //   631: goto +23 -> 654
    //   634: astore 12
    //   636: invokestatic 471	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +15 -> 654
    //   642: ldc_w 473
    //   645: iconst_2
    //   646: ldc_w 638
    //   649: aload 12
    //   651: invokestatic 641	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   654: aload 11
    //   656: ifnull +31 -> 687
    //   659: aload 11
    //   661: invokevirtual 636	java/io/FileReader:close	()V
    //   664: goto +23 -> 687
    //   667: astore 11
    //   669: invokestatic 471	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   672: ifeq +15 -> 687
    //   675: ldc_w 473
    //   678: iconst_2
    //   679: ldc_w 638
    //   682: aload 11
    //   684: invokestatic 641	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   687: goto +6 -> 693
    //   690: aload 10
    //   692: athrow
    //   693: goto -3 -> 690
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	696	0	this	HotPicMainPanel
    //   3	9	1	i1	int
    //   7	605	2	bool1	boolean
    //   5	609	3	bool2	boolean
    //   181	338	4	l1	long
    //   162	414	6	l2	long
    //   132	280	8	l3	long
    //   36	255	10	localObject1	Object
    //   298	16	10	localIOException1	java.io.IOException
    //   330	20	10	localIOException2	java.io.IOException
    //   370	1	10	localObject2	Object
    //   381	1	10	localObject3	Object
    //   390	1	10	localObject4	Object
    //   409	59	10	localObject5	Object
    //   475	16	10	localIOException3	java.io.IOException
    //   516	1	10	localIOException4	java.io.IOException
    //   562	42	10	localStringBuilder	StringBuilder
    //   615	76	10	localObject6	Object
    //   27	633	11	localObject7	Object
    //   667	16	11	localIOException5	java.io.IOException
    //   166	461	12	localObject8	Object
    //   634	16	12	localIOException6	java.io.IOException
    //   170	448	13	localObject9	Object
    //   177	60	14	str	String
    //   361	1	14	localIOException7	java.io.IOException
    //   378	1	14	localIOException8	java.io.IOException
    //   402	56	14	localIOException9	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   290	295	298	java/io/IOException
    //   318	323	330	java/io/IOException
    //   172	179	361	java/io/IOException
    //   200	215	361	java/io/IOException
    //   236	256	361	java/io/IOException
    //   268	273	361	java/io/IOException
    //   285	290	361	java/io/IOException
    //   146	160	370	finally
    //   146	160	378	java/io/IOException
    //   134	146	390	finally
    //   134	146	402	java/io/IOException
    //   467	472	475	java/io/IOException
    //   504	509	516	java/io/IOException
    //   172	179	615	finally
    //   200	215	615	finally
    //   236	256	615	finally
    //   268	273	615	finally
    //   285	290	615	finally
    //   423	428	615	finally
    //   436	442	615	finally
    //   450	462	615	finally
    //   626	631	634	java/io/IOException
    //   659	664	667	java/io/IOException
  }
  
  @TargetApi(16)
  public void g()
  {
    this.d = XPanelContainer.a;
    if (a > this.d) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onShow ");
      ((StringBuilder)localObject1).append(AppSetting.i());
      ((StringBuilder)localObject1).append(" init panelH ");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append(" needExtendPanel");
      ((StringBuilder)localObject1).append(this.e);
      QLog.d("HotPicManager.Panel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = HotPicManager.a(this.f);
    ((HotPicManager)localObject1).a(this);
    Object localObject2 = this.l;
    if (localObject2 != null) {
      ((PanelIconLinearLayout)localObject2).setInterceptListener(this);
    }
    ((HotPicManager)localObject1).a();
    ((HotPicManager)localObject1).f();
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll(((HotPicManager)localObject1).b());
    boolean bool = f();
    if ((this.n.a != 1011) && (this.n.a != 1006) && (this.n.a != 1000) && (this.n.a != 10004) && (this.n.a != 1020) && (this.n.a != 1004) && (this.n.a != 1025) && (this.n.a != 1009) && (this.n.a != 1022) && (this.n.a != 1008) && (this.n.a != 10008) && (this.n.a != 10010) && (this.n.a != 10013)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    Object localObject3;
    if ((i1 != 0) || (bool))
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onShow ");
        ((StringBuilder)localObject3).append(AppSetting.i());
        ((StringBuilder)localObject3).append(" isTempSession is true mSessionInfo.curType is ");
        ((StringBuilder)localObject3).append(this.n.a);
        QLog.d("HotPicManager.Panel", 2, ((StringBuilder)localObject3).toString());
      }
      localObject3 = new ArrayList();
      Object localObject4 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)((Iterator)localObject4).next();
        if (localHotPicTagInfo.tagType == 2) {
          ((ArrayList)localObject3).add(localHotPicTagInfo);
        }
      }
      if (((ArrayList)localObject3).size() > 0)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (HotPicTagInfo)((Iterator)localObject3).next();
          if (((ArrayList)localObject2).contains(localObject4)) {
            ((ArrayList)localObject2).remove(localObject4);
          }
        }
      }
    }
    localObject2 = ((ArrayList)localObject2).iterator();
    int i2 = -1;
    int i1 = 0;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (HotPicTagInfo)((Iterator)localObject2).next();
      if (this.n.a == 1)
      {
        if (((HotPicTagInfo)localObject3).tagName.equals(AIOIceBreakConstants.b)) {
          continue;
        }
        if (((HotPicTagInfo)localObject3).tagName.equals(AIOIceBreakConstants.a)) {
          this.r = (i1 + 2);
        }
      }
      if (this.n.a == 0)
      {
        if (((HotPicTagInfo)localObject3).tagName.equals(AIOIceBreakConstants.a)) {
          continue;
        }
        if (((HotPicTagInfo)localObject3).tagName.equals(AIOIceBreakConstants.b)) {
          this.r = (i1 + 2);
        }
      }
      this.h.a((HotPicTagInfo)localObject3);
      if (((HotPicTagInfo)localObject3).tagId == ((HotPicManager)localObject1).i) {
        i2 = i1;
      }
      i1 += 1;
    }
    this.q = new HotPicPanelViewPagerAdapter(this, this.p);
    localObject2 = this.y;
    if (localObject2 != null) {
      this.q.a((HotPicPageView.OnHotPicItemClickListener)localObject2);
    }
    this.p.setAdapter(this.q);
    this.p.setOnPageChangeListener(this.q);
    this.t.a(this.h.a(), i2);
    this.t.setOnItemClickListener(this);
    if (i2 != -1) {
      this.p.setCurrentItem(i2);
    }
    if (NetworkUtil.isNetworkAvailable(this.g))
    {
      localObject2 = ((HotPicManager)localObject1).b().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HotPicTagInfo)((Iterator)localObject2).next();
        i1 = ((HotPicTagInfo)localObject3).tagId;
        i2 = ((HotPicTagInfo)localObject3).tagType;
        if ((i1 != 2) && (i2 != 255) && (!((HotPicManager)localObject1).c(i1))) {
          ((HotPicManager)localObject1).e(i1);
        }
      }
    }
    ReportController.b(this.f, "dc00898", "", "", "0X8007B11", "0X8007B11", 0, 0, "", "", "", "");
    if (this.n.a == 3000) {
      ReportController.b(this.f, "dc00898", "", "", "0X8007B15", "0X8007B15", 0, 0, "", "", "", "");
    } else if (this.n.a == 1) {
      ReportController.b(this.f, "dc00898", "", "", "0X8007B16", "0X8007B16", 0, 0, "", "", "", "");
    } else {
      ReportController.b(this.f, "dc00898", "", "", "0X8007B14", "0X8007B14", 0, 0, "", "", "", "");
    }
    a();
    i();
  }
  
  @TargetApi(11)
  public void h()
  {
    Object localObject2 = (ImageView)this.j.findViewById(2131435174);
    Object localObject1;
    if (j())
    {
      localObject1 = this.s;
      if ((localObject1 != null) && (((PopupWindow)localObject1).isShowing())) {
        this.s.dismiss();
      }
      this.j.setVisibility(8);
      return;
    }
    if (VersionUtils.e())
    {
      localObject1 = ObjectAnimator.ofFloat(localObject2, "scaleX", new float[] { 1.0F, 0.4F });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject2, "scaleY", new float[] { 1.0F, 0.4F });
      localObject2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 1.0F, 0.1F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play((Animator)localObject1).with(localObjectAnimator).with((Animator)localObject2);
      localAnimatorSet.setDuration(200L);
      localAnimatorSet.setInterpolator(new LinearInterpolator());
      localAnimatorSet.addListener(new HotPicMainPanel.3(this));
      localAnimatorSet.start();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.arg1;
    int i2 = paramMessage.arg2;
    if (getVisibility() != 8)
    {
      if (this.h.a(i1) == null) {
        return true;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMessage, tagHotPic = ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", version = ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(", msg = ");
        ((StringBuilder)localObject).append(paramMessage.what);
        ((StringBuilder)localObject).append(", index = ");
        ((StringBuilder)localObject).append(this.t.getCurrentSelected());
        QLog.d("HotPicManager.Panel", 2, ((StringBuilder)localObject).toString());
      }
      if (paramMessage.what == 8)
      {
        localObject = this.q;
        if (localObject != null) {
          ((HotPicPanelViewPagerAdapter)localObject).a(i1, paramMessage.what);
        }
        return true;
      }
      if (this.h.a(i1).version == i2)
      {
        localObject = this.q;
        if (localObject != null) {
          ((HotPicPanelViewPagerAdapter)localObject).a(i1, paramMessage.what);
        }
        if ((NetworkUtil.isNetworkAvailable(this.g)) && (paramMessage.what == 7))
        {
          i1 = this.h.a(i1).position + 1;
          while (i1 < this.h.c())
          {
            i2 = this.h.b(i1).tagId;
            if (i2 == -20) {
              i1 += 1;
            } else {
              HotPicManager.a(this.f).e(i2);
            }
          }
        }
      }
    }
    return true;
  }
  
  @TargetApi(11)
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!l()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return true;
        }
      }
      else
      {
        i2 = (int)(paramMotionEvent.getY() - this.w + 0.5F);
        i1 = XPanelContainer.a;
        XPanelContainer.a -= i2;
        i2 = XPanelContainer.a;
        i3 = a;
        if (i2 > i3)
        {
          XPanelContainer.a = i3;
        }
        else
        {
          i2 = XPanelContainer.a;
          i3 = this.d;
          if (i2 < i3) {
            XPanelContainer.a = i3;
          }
        }
        if (XPanelContainer.a == i1) {
          break label329;
        }
        AbstractGifImage.pauseAll();
        paramMotionEvent = this.m;
        if (paramMotionEvent == null) {
          break label329;
        }
        paramMotionEvent.requestLayout();
        return true;
      }
    }
    int i3 = XPanelContainer.a;
    i1 = a;
    if (i3 != i1)
    {
      i2 = this.d;
      if (i3 != i2)
      {
        if (i3 <= this.x) {
          i1 = i2;
        }
        if (Math.abs(i3 - this.x) > 100) {
          i2 = i1;
        } else {
          i2 = this.x;
        }
        i1 = this.x;
        i3 = a;
        if ((i1 != i3) && (i2 == i3)) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        paramMotionEvent = ValueAnimator.ofInt(new int[] { XPanelContainer.a, i2 });
        paramMotionEvent.setDuration(150L);
        paramMotionEvent.addUpdateListener(new HotPicMainPanel.5(this, i2));
        paramMotionEvent.start();
        break label296;
      }
    }
    AbstractGifImage.resumeAll();
    i1 = this.x;
    int i2 = a;
    if ((i1 != i2) && (i3 == i2)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    label296:
    if (i1 != 0) {
      ReportController.b(this.f, "dc00898", "", "", "0X8007B21", "0X8007B21", 0, 0, "", "", "", "");
    }
    label329:
    return true;
  }
  
  protected void i()
  {
    if (HotPicManager.a(this.f).c)
    {
      if (!HotPicManager.a(this.f).c(2)) {
        return;
      }
      this.k.setVisibility(0);
      this.k.setOnTouchListener(new HotPicMainPanel.4(this));
    }
  }
  
  public boolean interceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!l()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 2)
      {
        if (getParent() != null)
        {
          getParent().requestDisallowInterceptTouchEvent(false);
          return false;
        }
      }
      else
      {
        float f1 = paramMotionEvent.getY();
        i1 = (int)(f1 - this.w + 0.5F);
        if ((this.l != null) && (Math.abs(i1) > this.l.getHeight() * 0.6F))
        {
          this.w = f1;
          return true;
        }
      }
    }
    else
    {
      this.w = paramMotionEvent.getY();
      this.x = XPanelContainer.a;
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      ReportController.b(this.f, "dc00898", "", "", "0X8007B12", "0X8007B12", 0, 0, "", "", "", "");
    } else if (paramInt == 1) {
      ReportController.b(this.f, "dc00898", "", "", "0X8007B13", "0X8007B13", 0, 0, "", "", "", "");
    } else if ((this.h.c() > paramInt) && (this.h.b(paramInt).tagType == 2)) {
      ReportController.b(this.f, "dc00898", "", "", "0X8007ED3", "0X8007ED3", 0, 0, "", "", "", "");
    }
    this.t.setSelection(paramInt);
    this.p.setCurrentItem(paramInt);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void setOnHotPicItemClickListener(HotPicPageView.OnHotPicItemClickListener paramOnHotPicItemClickListener)
  {
    this.y = paramOnHotPicItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicMainPanel
 * JD-Core Version:    0.7.0.1
 */