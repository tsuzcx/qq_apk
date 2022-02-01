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
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.InterceptListener;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  float jdField_a_of_type_Float;
  protected Context a;
  Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public ViewPager a;
  protected View a;
  protected PopupWindow a;
  protected SessionInfo a;
  protected PanelIconLinearLayout a;
  protected BaseActivity a;
  public QQAppInterface a;
  protected HotPicIndexAndIDMap a;
  private HotPicPageView.OnHotPicItemClickListener jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener;
  protected HotPicPanelViewPagerAdapter a;
  protected HotPicTab a;
  XPanelContainer jdField_a_of_type_ComTencentWidgetXPanelContainer;
  Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected boolean a;
  protected View b;
  protected View c;
  protected int d;
  public int e = 0;
  int f;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_a_of_type_Int = (int)(localResources.getDisplayMetrics().heightPixels * 0.6D);
    jdField_c_of_type_Int = AIOUtils.a(1.0F, localResources);
    jdField_b_of_type_Int = (localResources.getDisplayMetrics().widthPixels - jdField_c_of_type_Int * 6) / 2;
  }
  
  public HotPicMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap = new HotPicIndexAndIDMap();
  }
  
  private boolean b()
  {
    return (AppSetting.c.equalsIgnoreCase("oppo-x907")) || (Build.MODEL.toLowerCase().equals("mi 1s"));
  }
  
  private boolean c()
  {
    return jdField_a_of_type_Int > this.d;
  }
  
  private void i()
  {
    HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e();
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a()
  {
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_pic", true);
  }
  
  public void a(int paramInt)
  {
    HotPicPageView.b = true;
    i();
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a() != paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setSelection(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a(paramInt);
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.b(paramInt);
    if (localHotPicTagInfo != null) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008076", "0X8008076", 0, 0, paramInt + "", "", localHotPicTagInfo.tagName, "");
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
    if (b())
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
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatPie paramBaseChatPie, PanelIconLinearLayout paramPanelIconLinearLayout, XPanelContainer paramXPanelContainer)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramPanelIconLinearLayout;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = paramXPanelContainer;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370723);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131368559);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558647, null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131368565));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab = ((HotPicTab)findViewById(2131368546));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    setId(2131362411);
  }
  
  public void a(HotPicData paramHotPicData)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368558);
    Object localObject = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    int j = paramHotPicData.width;
    int k = paramHotPicData.height;
    int i = (int)(jdField_b_of_type_Int * 1.5F + 0.5F);
    float f1 = j / i;
    j = (int)(k / f1 + 0.5F);
    ((ViewGroup.MarginLayoutParams)localObject).width = i;
    ((ViewGroup.MarginLayoutParams)localObject).height = j;
    i = (int)(160.0F / f1 + 0.5F);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramHotPicData;
    URL localURL = HotPicOriginDownLoader.b(paramHotPicData.originalUrl);
    if (localURL == null) {
      return;
    }
    localObject = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTargetDensity(i);
    localImageView.setImageDrawable((Drawable)localObject);
    if ((((URLDrawable)localObject).getStatus() == 2) && (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))) {
      ((URLDrawable)localObject).restartDownload();
    }
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null)
    {
      i = getResources().getDisplayMetrics().widthPixels;
      j = getRootView().getHeight();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_b_of_type_AndroidViewView, i, j);
    }
    if (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(this, 0, 0, 0);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
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
    HotPicPageView.b = true;
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a();
    if (localHotPicTagInfo != null) {
      HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localHotPicTagInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a();
    if (!paramBoolean) {
      XPanelContainer.jdField_a_of_type_Int = this.d;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(null);
    }
    HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(null);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter = null;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(null);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(null);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a();
    this.jdField_a_of_type_JavaUtilSet.clear();
    HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
    setVisibility(8);
    b();
  }
  
  /* Error */
  @TargetApi(16)
  protected boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_1
    //   4: istore_1
    //   5: getstatic 539	android/os/Build$VERSION:SDK_INT	I
    //   8: bipush 16
    //   10: if_icmplt +106 -> 116
    //   13: aload_0
    //   14: getfield 308	com/tencent/mobileqq/hotpic/HotPicMainPanel:jdField_a_of_type_ComTencentMobileqqAppBaseActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   17: ldc_w 541
    //   20: invokevirtual 547	com/tencent/mobileqq/app/BaseActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 549	android/app/ActivityManager
    //   26: astore 9
    //   28: new 551	android/app/ActivityManager$MemoryInfo
    //   31: dup
    //   32: invokespecial 552	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   35: astore 10
    //   37: aload 9
    //   39: aload 10
    //   41: invokevirtual 556	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   44: aload 10
    //   46: getfield 560	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   49: ldc2_w 561
    //   52: lcmp
    //   53: ifge +58 -> 111
    //   56: iconst_1
    //   57: istore_1
    //   58: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +46 -> 107
    //   64: ldc_w 483
    //   67: iconst_2
    //   68: new 211	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 564
    //   78: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 10
    //   83: getfield 560	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   86: invokevirtual 567	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: ldc_w 569
    //   92: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc2_w 561
    //   98: invokevirtual 567	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   101: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 488	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: iload_1
    //   108: istore_2
    //   109: iload_2
    //   110: ireturn
    //   111: iconst_0
    //   112: istore_1
    //   113: goto -55 -> 58
    //   116: lconst_0
    //   117: lstore 7
    //   119: new 571	java/io/FileReader
    //   122: dup
    //   123: ldc_w 573
    //   126: invokespecial 576	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   129: astore 11
    //   131: new 578	java/io/BufferedReader
    //   134: dup
    //   135: aload 11
    //   137: sipush 2048
    //   140: invokespecial 581	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   143: astore 10
    //   145: lload 7
    //   147: lstore 5
    //   149: aload 10
    //   151: invokevirtual 584	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   154: astore 9
    //   156: lload 7
    //   158: lstore_3
    //   159: aload 9
    //   161: ifnull +53 -> 214
    //   164: lload 7
    //   166: lstore 5
    //   168: aload 9
    //   170: aload 9
    //   172: ldc_w 586
    //   175: invokevirtual 590	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   178: invokevirtual 594	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: astore 9
    //   183: lload 7
    //   185: lstore_3
    //   186: aload 9
    //   188: ifnull +26 -> 214
    //   191: lload 7
    //   193: lstore 5
    //   195: aload 9
    //   197: ldc_w 596
    //   200: ldc 207
    //   202: invokevirtual 600	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   205: invokestatic 605	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   208: i2l
    //   209: ldc2_w 606
    //   212: lmul
    //   213: lstore_3
    //   214: lload_3
    //   215: lstore 5
    //   217: aload 10
    //   219: invokevirtual 610	java/io/BufferedReader:close	()V
    //   222: lload_3
    //   223: lstore 5
    //   225: aload 11
    //   227: invokevirtual 611	java/io/FileReader:close	()V
    //   230: aload 10
    //   232: ifnull +8 -> 240
    //   235: aload 10
    //   237: invokevirtual 610	java/io/BufferedReader:close	()V
    //   240: lload_3
    //   241: lstore 7
    //   243: aload 11
    //   245: ifnull +11 -> 256
    //   248: aload 11
    //   250: invokevirtual 611	java/io/FileReader:close	()V
    //   253: lload_3
    //   254: lstore 7
    //   256: lload 7
    //   258: ldc2_w 561
    //   261: lcmp
    //   262: ifge +299 -> 561
    //   265: iload_1
    //   266: istore_2
    //   267: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq -161 -> 109
    //   273: ldc_w 483
    //   276: iconst_2
    //   277: new 211	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 613
    //   287: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: lload 7
    //   292: invokevirtual 567	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   295: ldc_w 615
    //   298: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc2_w 561
    //   304: invokevirtual 567	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 488	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: iload_1
    //   314: ireturn
    //   315: astore 9
    //   317: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq -80 -> 240
    //   323: ldc_w 483
    //   326: iconst_2
    //   327: ldc_w 617
    //   330: aload 9
    //   332: invokestatic 620	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   335: goto -95 -> 240
    //   338: astore 9
    //   340: lload_3
    //   341: lstore 7
    //   343: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq -90 -> 256
    //   349: ldc_w 483
    //   352: iconst_2
    //   353: ldc_w 617
    //   356: aload 9
    //   358: invokestatic 620	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: lload_3
    //   362: lstore 7
    //   364: goto -108 -> 256
    //   367: astore 11
    //   369: aconst_null
    //   370: astore 10
    //   372: lload 7
    //   374: lstore 5
    //   376: aload 11
    //   378: invokevirtual 623	java/io/IOException:printStackTrace	()V
    //   381: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +15 -> 399
    //   387: ldc_w 483
    //   390: iconst_2
    //   391: ldc_w 617
    //   394: aload 11
    //   396: invokestatic 620	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   399: aload 10
    //   401: ifnull +8 -> 409
    //   404: aload 10
    //   406: invokevirtual 610	java/io/BufferedReader:close	()V
    //   409: lload 5
    //   411: lstore 7
    //   413: aload 9
    //   415: ifnull -159 -> 256
    //   418: aload 9
    //   420: invokevirtual 611	java/io/FileReader:close	()V
    //   423: lload 5
    //   425: lstore 7
    //   427: goto -171 -> 256
    //   430: astore 9
    //   432: lload 5
    //   434: lstore 7
    //   436: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq -183 -> 256
    //   442: ldc_w 483
    //   445: iconst_2
    //   446: ldc_w 617
    //   449: aload 9
    //   451: invokestatic 620	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   454: lload 5
    //   456: lstore 7
    //   458: goto -202 -> 256
    //   461: astore 10
    //   463: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq -57 -> 409
    //   469: ldc_w 483
    //   472: iconst_2
    //   473: ldc_w 617
    //   476: aload 10
    //   478: invokestatic 620	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   481: goto -72 -> 409
    //   484: astore 9
    //   486: aconst_null
    //   487: astore 10
    //   489: aconst_null
    //   490: astore 11
    //   492: aload 10
    //   494: ifnull +8 -> 502
    //   497: aload 10
    //   499: invokevirtual 610	java/io/BufferedReader:close	()V
    //   502: aload 11
    //   504: ifnull +8 -> 512
    //   507: aload 11
    //   509: invokevirtual 611	java/io/FileReader:close	()V
    //   512: aload 9
    //   514: athrow
    //   515: astore 10
    //   517: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq -18 -> 502
    //   523: ldc_w 483
    //   526: iconst_2
    //   527: ldc_w 617
    //   530: aload 10
    //   532: invokestatic 620	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   535: goto -33 -> 502
    //   538: astore 10
    //   540: invokestatic 481	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq -31 -> 512
    //   546: ldc_w 483
    //   549: iconst_2
    //   550: ldc_w 617
    //   553: aload 10
    //   555: invokestatic 620	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   558: goto -46 -> 512
    //   561: iconst_0
    //   562: istore_1
    //   563: goto -298 -> 265
    //   566: astore 9
    //   568: aconst_null
    //   569: astore 10
    //   571: goto -79 -> 492
    //   574: astore 9
    //   576: goto -84 -> 492
    //   579: astore 12
    //   581: aload 9
    //   583: astore 11
    //   585: aload 12
    //   587: astore 9
    //   589: goto -97 -> 492
    //   592: astore 12
    //   594: aconst_null
    //   595: astore 10
    //   597: aload 11
    //   599: astore 9
    //   601: aload 12
    //   603: astore 11
    //   605: lload 7
    //   607: lstore 5
    //   609: goto -233 -> 376
    //   612: astore 12
    //   614: aload 11
    //   616: astore 9
    //   618: aload 12
    //   620: astore 11
    //   622: goto -246 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	625	0	this	HotPicMainPanel
    //   4	559	1	bool1	boolean
    //   108	159	2	bool2	boolean
    //   158	204	3	l1	long
    //   147	461	5	l2	long
    //   117	489	7	l3	long
    //   1	195	9	localObject1	Object
    //   315	16	9	localIOException1	java.io.IOException
    //   338	81	9	localIOException2	java.io.IOException
    //   430	20	9	localIOException3	java.io.IOException
    //   484	29	9	localObject2	Object
    //   566	1	9	localObject3	Object
    //   574	8	9	localObject4	Object
    //   587	30	9	localObject5	Object
    //   35	370	10	localObject6	Object
    //   461	16	10	localIOException4	java.io.IOException
    //   487	11	10	localObject7	Object
    //   515	16	10	localIOException5	java.io.IOException
    //   538	16	10	localIOException6	java.io.IOException
    //   569	27	10	localObject8	Object
    //   129	120	11	localFileReader	java.io.FileReader
    //   367	28	11	localIOException7	java.io.IOException
    //   490	131	11	localObject9	Object
    //   579	7	12	localObject10	Object
    //   592	10	12	localIOException8	java.io.IOException
    //   612	7	12	localIOException9	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   235	240	315	java/io/IOException
    //   248	253	338	java/io/IOException
    //   119	131	367	java/io/IOException
    //   418	423	430	java/io/IOException
    //   404	409	461	java/io/IOException
    //   119	131	484	finally
    //   497	502	515	java/io/IOException
    //   507	512	538	java/io/IOException
    //   131	145	566	finally
    //   149	156	574	finally
    //   168	183	574	finally
    //   195	214	574	finally
    //   217	222	574	finally
    //   225	230	574	finally
    //   376	399	579	finally
    //   131	145	592	java/io/IOException
    //   149	156	612	java/io/IOException
    //   168	183	612	java/io/IOException
    //   195	214	612	java/io/IOException
    //   217	222	612	java/io/IOException
    //   225	230	612	java/io/IOException
  }
  
  public void b()
  {
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_pic", false);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt1);
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void c()
  {
    if (!c()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != this.d);
      a(200, XPanelContainer.jdField_a_of_type_Int, jdField_a_of_type_Int);
    } while (!QLog.isColorLevel());
    QLog.d("HotPicManager.Panel", 2, "onPullUp");
  }
  
  public void d()
  {
    if (!c()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.jdField_a_of_type_Int != jdField_a_of_type_Int);
      a(250, XPanelContainer.jdField_a_of_type_Int, this.d);
    } while (!QLog.isColorLevel());
    QLog.d("HotPicManager.Panel", 2, "onPullDown");
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab == null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter == null)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.b(i);
  }
  
  @TargetApi(16)
  public void f()
  {
    this.d = XPanelContainer.jdField_a_of_type_Int;
    boolean bool;
    HotPicManager localHotPicManager;
    if (jdField_a_of_type_Int > this.d)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.Panel", 2, "onShow " + AppSetting.g() + " init panelH " + this.d + " needExtendPanel" + this.jdField_a_of_type_Boolean);
      }
      localHotPicManager = HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localHotPicManager.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
      localHotPicManager.a();
      localHotPicManager.d();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(localHotPicManager.a());
      bool = a();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1011) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1020) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1025) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1009) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1022) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10008) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10010)) {
        break label430;
      }
      i = 1;
    }
    label308:
    Object localObject2;
    for (;;)
    {
      if ((i != 0) || (bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager.Panel", 2, "onShow " + AppSetting.g() + " isTempSession is true mSessionInfo.curType is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
        localObject2 = new ArrayList();
        Object localObject3 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)((Iterator)localObject3).next();
            if (localHotPicTagInfo.tagType == 2)
            {
              ((ArrayList)localObject2).add(localHotPicTagInfo);
              continue;
              bool = false;
              break;
              label430:
              i = 0;
              break label308;
            }
          }
        }
        if (((ArrayList)localObject2).size() > 0)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (HotPicTagInfo)((Iterator)localObject2).next();
            if (((ArrayList)localObject1).contains(localObject3)) {
              ((ArrayList)localObject1).remove(localObject3);
            }
          }
        }
      }
    }
    Object localObject1 = ((ArrayList)localObject1).iterator();
    int i = 0;
    int j = -1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HotPicTagInfo)((Iterator)localObject1).next();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        if (((HotPicTagInfo)localObject2).tagName.equals(AIOIceBreakConstants.b)) {
          continue;
        }
        if (((HotPicTagInfo)localObject2).tagName.equals(AIOIceBreakConstants.a)) {
          this.e = (i + 2);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        if (((HotPicTagInfo)localObject2).tagName.equals(AIOIceBreakConstants.a)) {
          continue;
        }
        if (((HotPicTagInfo)localObject2).tagName.equals(AIOIceBreakConstants.b)) {
          this.e = (i + 2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a((HotPicTagInfo)localObject2);
      if (((HotPicTagInfo)localObject2).tagId == localHotPicManager.jdField_a_of_type_Int) {
        j = i;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter = new HotPicPanelViewPagerAdapter(this, this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener);
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a(), j);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    if (j != -1) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(j);
    }
    if (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      localObject1 = localHotPicManager.a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotPicTagInfo)((Iterator)localObject1).next();
        i = ((HotPicTagInfo)localObject2).tagId;
        j = ((HotPicTagInfo)localObject2).tagType;
        if ((i != 2) && (j != 255) && (!localHotPicManager.b(i))) {
          localHotPicManager.a(i);
        }
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B11", "0X8007B11", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B15", "0X8007B15", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      a();
      h();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B16", "0X8007B16", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B14", "0X8007B14", 0, 0, "", "", "", "");
      }
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    Object localObject = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368558);
    if (b())
    {
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    while (!VersionUtils.e()) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "scaleX", new float[] { 1.0F, 0.4F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "scaleY", new float[] { 1.0F, 0.4F });
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F, 0.1F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with((Animator)localObject);
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.setInterpolator(new LinearInterpolator());
    localAnimatorSet.addListener(new HotPicMainPanel.3(this));
    localAnimatorSet.start();
  }
  
  protected void h()
  {
    if ((!HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b) || (!HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(2))) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new HotPicMainPanel.4(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    if ((getVisibility() == 8) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a(i) == null)) {}
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.Panel", 2, "handleMessage, tagHotPic = " + i + ", version = " + j + ", msg = " + paramMessage.what + ", index = " + this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a());
      }
      if (paramMessage.what == 8)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a(i, paramMessage.what);
          return true;
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a(i).version == j)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a(i, paramMessage.what);
        }
        if ((NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext)) && (paramMessage.what == 7))
        {
          i = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a(i).position + 1;
          while (i < this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a())
          {
            j = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.b(i).tagId;
            if (j != -20) {
              break label237;
            }
            i += 1;
          }
        }
      }
    }
    label237:
    HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(j);
    return true;
  }
  
  @TargetApi(11)
  public boolean handleTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!c()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 2: 
      i = (int)(paramMotionEvent.getY() - this.jdField_a_of_type_Float + 0.5F);
      j = XPanelContainer.jdField_a_of_type_Int;
      XPanelContainer.jdField_a_of_type_Int -= i;
      if (XPanelContainer.jdField_a_of_type_Int > jdField_a_of_type_Int) {
        XPanelContainer.jdField_a_of_type_Int = jdField_a_of_type_Int;
      }
      while (XPanelContainer.jdField_a_of_type_Int != j)
      {
        AbstractGifImage.pauseAll();
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.requestLayout();
        break;
        if (XPanelContainer.jdField_a_of_type_Int < this.d) {
          XPanelContainer.jdField_a_of_type_Int = this.d;
        }
      }
    }
    int j = XPanelContainer.jdField_a_of_type_Int;
    if ((j != jdField_a_of_type_Int) && (j != this.d)) {
      if (j > this.f)
      {
        i = jdField_a_of_type_Int;
        label162:
        if (Math.abs(j - this.f) <= 100) {
          break label283;
        }
        j = i;
        label178:
        if ((this.f == jdField_a_of_type_Int) || (j != jdField_a_of_type_Int)) {
          break label321;
        }
      }
    }
    label283:
    label319:
    label321:
    for (int i = 1;; i = 0)
    {
      paramMotionEvent = ValueAnimator.ofInt(new int[] { XPanelContainer.jdField_a_of_type_Int, j });
      paramMotionEvent.setDuration(150L);
      paramMotionEvent.addUpdateListener(new HotPicMainPanel.5(this, j));
      paramMotionEvent.start();
      for (;;)
      {
        if (i == 0) {
          break label319;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B21", "0X8007B21", 0, 0, "", "", "", "");
        break;
        i = this.d;
        break label162;
        j = this.f;
        break label178;
        AbstractGifImage.resumeAll();
        if ((this.f != jdField_a_of_type_Int) && (j == jdField_a_of_type_Int)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      break;
    }
  }
  
  public boolean interceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!c()) {}
    float f1;
    int i;
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        }
      } while (getParent() == null);
      getParent().requestDisallowInterceptTouchEvent(false);
      return false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.f = XPanelContainer.jdField_a_of_type_Int;
      return false;
      f1 = paramMotionEvent.getY();
      i = (int)(f1 - this.jdField_a_of_type_Float + 0.5F);
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (Math.abs(i) <= this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() * 0.6F));
    this.jdField_a_of_type_Float = f1;
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B12", "0X8007B12", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setSelection(paramInt);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (paramInt == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B13", "0X8007B13", 0, 0, "", "", "", "");
      } else if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.a() > paramInt) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicIndexAndIDMap.b(paramInt).tagType == 2)) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007ED3", "0X8007ED3", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void setOnHotPicItemClickListener(HotPicPageView.OnHotPicItemClickListener paramOnHotPicItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$OnHotPicItemClickListener = paramOnHotPicItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicMainPanel
 * JD-Core Version:    0.7.0.1
 */