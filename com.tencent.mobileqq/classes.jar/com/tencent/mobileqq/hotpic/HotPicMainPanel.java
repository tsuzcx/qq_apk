package com.tencent.mobileqq.hotpic;

import afur;
import ahqy;
import amuf;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
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
import avbc;
import avbe;
import avbf;
import avbg;
import avbh;
import avbi;
import avbj;
import avbk;
import avbm;
import avbn;
import avce;
import avcg;
import bajd;
import bcst;
import bdzx;
import bgnt;
import bkgm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XPanelContainer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@TargetApi(15)
public class HotPicMainPanel
  extends RelativeLayout
  implements ahqy, Handler.Callback, AdapterView.OnItemClickListener, avbm, avce, avcg
{
  public static final int a;
  public static final int b;
  public static final int c;
  float a;
  protected Context a;
  public Handler a;
  public ViewPager a;
  protected View a;
  public PopupWindow a;
  protected avbe a;
  protected SessionInfo a;
  protected PanelIconLinearLayout a;
  protected BaseActivity a;
  public QQAppInterface a;
  protected HotPicPanelViewPagerAdapter a;
  protected HotPicTab a;
  public XPanelContainer a;
  public Set<String> a;
  protected boolean a;
  public View b;
  protected View c;
  protected int d;
  public int e;
  int f;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_a_of_type_Int = (int)(localResources.getDisplayMetrics().heightPixels * 0.6D);
    jdField_c_of_type_Int = afur.a(1.0F, localResources);
    jdField_b_of_type_Int = (localResources.getDisplayMetrics().widthPixels - jdField_c_of_type_Int * 6) / 2;
  }
  
  public HotPicMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Avbe = new avbe();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidOsHandler = new bkgm(Looper.getMainLooper(), this);
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
    avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e();
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a()
  {
    amuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_pic", true);
  }
  
  public void a(int paramInt)
  {
    HotPicPageView.b = true;
    i();
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a() != paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setSelection(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a(paramInt);
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_Avbe.b(paramInt);
    if (localHotPicTagInfo != null) {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008076", "0X8008076", 0, 0, paramInt + "", "", localHotPicTagInfo.tagName, "");
    }
  }
  
  @TargetApi(14)
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new avbf(this));
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
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370198);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131368096);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558606, null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131368102));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab = ((HotPicTab)findViewById(2131368083));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    setId(2131362356);
  }
  
  public void a(HotPicData paramHotPicData)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368095);
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
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = bdzx.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = bdzx.a;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramHotPicData;
    URL localURL = avbn.b(paramHotPicData.originalUrl);
    if (localURL == null) {
      return;
    }
    localObject = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTargetDensity(i);
    localImageView.setImageDrawable((Drawable)localObject);
    if ((((URLDrawable)localObject).getStatus() == 2) && (bgnt.g(this.jdField_a_of_type_AndroidContentContext))) {
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
    if (avbc.a(paramHotPicData.originalUrl).exists())
    {
      a(localImageView);
      return;
    }
    ((URLDrawable)localObject).setDownloadListener(new avbg(this, localImageView));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicManager.Panel", 2, "onHide");
    }
    HotPicPageView.b = true;
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a();
    if (localHotPicTagInfo != null) {
      avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localHotPicTagInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a();
    if (!paramBoolean) {
      XPanelContainer.jdField_a_of_type_Int = this.d;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(null);
    }
    avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(null);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(null);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.removeAllViews();
    this.jdField_a_of_type_Avbe.a();
    this.jdField_a_of_type_JavaUtilSet.clear();
    avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
    setVisibility(8);
    b();
  }
  
  @TargetApi(16)
  protected boolean a()
  {
    bool1 = true;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject1 = (ActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("activity");
      localObject2 = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
      if (((ActivityManager.MemoryInfo)localObject2).totalMem < 1073741824L)
      {
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager.Panel", 2, "isLowPerformanceDevice mi.totalMem is " + ((ActivityManager.MemoryInfo)localObject2).totalMem + " limitHovVideoMemory is " + 1073741824L);
        }
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool1 = false;
      break;
      long l3 = 0L;
      l2 = l3;
      try
      {
        localObject1 = new FileReader("/proc/meminfo");
        l2 = l3;
        localObject2 = new BufferedReader((Reader)localObject1, 2048);
        l2 = l3;
        String str = ((BufferedReader)localObject2).readLine();
        l1 = l3;
        if (str != null)
        {
          l2 = l3;
          str = str.substring(str.indexOf("MemTotal:"));
          l1 = l3;
          if (str != null)
          {
            l2 = l3;
            l1 = Integer.parseInt(str.replaceAll("\\D+", "")) * 1024L;
          }
        }
        l2 = l1;
        ((BufferedReader)localObject2).close();
        l2 = l1;
        ((FileReader)localObject1).close();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          long l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("HotPicManager.Panel", 2, "isLowPerformanceDevice has IOException", localIOException);
            l1 = l2;
            continue;
            bool1 = false;
          }
        }
      }
      if (l1 >= 1073741824L) {
        break label326;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("HotPicManager.Panel", 2, "isLowPerformanceDevice totalMem is " + l1 + " limitHovVideoMemory is " + 1073741824L);
    return bool1;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
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
  
  public void b()
  {
    amuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "hot_pic", false);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt1);
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  @TargetApi(11)
  public boolean b(MotionEvent paramMotionEvent)
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
        label155:
        if (Math.abs(j - this.f) <= 100) {
          break label276;
        }
        j = i;
        label171:
        if ((this.f == jdField_a_of_type_Int) || (j != jdField_a_of_type_Int)) {
          break label314;
        }
      }
    }
    label276:
    label312:
    label314:
    for (int i = 1;; i = 0)
    {
      paramMotionEvent = ValueAnimator.ofInt(new int[] { XPanelContainer.jdField_a_of_type_Int, j });
      paramMotionEvent.setDuration(150L);
      paramMotionEvent.addUpdateListener(new avbj(this, j));
      paramMotionEvent.start();
      for (;;)
      {
        if (i == 0) {
          break label312;
        }
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B21", "0X8007B21", 0, 0, "", "", "", "");
        break;
        i = this.d;
        break label155;
        j = this.f;
        break label171;
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
    avbk localavbk;
    if (jdField_a_of_type_Int > this.d)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.Panel", 2, "onShow " + AppSetting.g() + " init panelH " + this.d + " needExtendPanel" + this.jdField_a_of_type_Boolean);
      }
      localavbk = avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localavbk.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
      localavbk.a();
      localavbk.d();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(localavbk.a());
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
        if (((HotPicTagInfo)localObject2).tagName.equals(bajd.b)) {
          continue;
        }
        if (((HotPicTagInfo)localObject2).tagName.equals(bajd.a)) {
          this.e = (i + 2);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
      {
        if (((HotPicTagInfo)localObject2).tagName.equals(bajd.a)) {
          continue;
        }
        if (((HotPicTagInfo)localObject2).tagName.equals(bajd.b)) {
          this.e = (i + 2);
        }
      }
      this.jdField_a_of_type_Avbe.a((HotPicTagInfo)localObject2);
      if (((HotPicTagInfo)localObject2).tagId == localavbk.jdField_a_of_type_Int) {
        j = i;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter = new HotPicPanelViewPagerAdapter(this, this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a(this.jdField_a_of_type_Avbe.a(), j);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    if (j != -1) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(j);
    }
    if (bgnt.g(this.jdField_a_of_type_AndroidContentContext))
    {
      localObject1 = localavbk.a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotPicTagInfo)((Iterator)localObject1).next();
        i = ((HotPicTagInfo)localObject2).tagId;
        j = ((HotPicTagInfo)localObject2).tagType;
        if ((i != 2) && (j != 255) && (!localavbk.b(i))) {
          localavbk.a(i);
        }
      }
    }
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B11", "0X8007B11", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B15", "0X8007B15", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      a();
      h();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B16", "0X8007B16", 0, 0, "", "", "", "");
      } else {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B14", "0X8007B14", 0, 0, "", "", "", "");
      }
    }
  }
  
  @TargetApi(11)
  public void g()
  {
    Object localObject = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368095);
    if (b())
    {
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    while (!VersionUtils.isHoneycomb()) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "scaleX", new float[] { 1.0F, 0.4F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "scaleY", new float[] { 1.0F, 0.4F });
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F, 0.1F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with((Animator)localObject);
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.setInterpolator(new LinearInterpolator());
    localAnimatorSet.addListener(new avbh(this));
    localAnimatorSet.start();
  }
  
  protected void h()
  {
    if ((!avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b) || (!avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(2))) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new avbi(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    if ((getVisibility() == 8) || (this.jdField_a_of_type_Avbe.a(i) == null)) {}
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
      else if (this.jdField_a_of_type_Avbe.a(i).version == j)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.a(i, paramMessage.what);
        }
        if ((bgnt.g(this.jdField_a_of_type_AndroidContentContext)) && (paramMessage.what == 7))
        {
          i = this.jdField_a_of_type_Avbe.a(i).position + 1;
          while (i < this.jdField_a_of_type_Avbe.a())
          {
            j = this.jdField_a_of_type_Avbe.b(i).tagId;
            if (j != -20) {
              break label237;
            }
            i += 1;
          }
        }
      }
    }
    label237:
    avbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(j);
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B12", "0X8007B12", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setSelection(paramInt);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (paramInt == 1) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007B13", "0X8007B13", 0, 0, "", "", "", "");
      } else if ((this.jdField_a_of_type_Avbe.a() > paramInt) && (this.jdField_a_of_type_Avbe.b(paramInt).tagType == 2)) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007ED3", "0X8007ED3", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicMainPanel
 * JD-Core Version:    0.7.0.1
 */