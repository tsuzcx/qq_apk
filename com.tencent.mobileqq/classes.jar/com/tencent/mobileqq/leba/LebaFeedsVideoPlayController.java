package com.tencent.mobileqq.leba;

import adyt;
import adyu;
import adyv;
import adyw;
import adyx;
import adyy;
import adyz;
import adza;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.hotpic.VideoItemEventManager;
import com.tencent.mobileqq.hotpic.VideoItemEventManager.onVideoItemEventListener;
import com.tencent.mobileqq.leba.view.LebaFPSXListView;
import com.tencent.mobileqq.leba.view.LebaFeedsVideoOutlineProvider;
import com.tencent.mobileqq.leba.view.LebaFeedsVideoView1;
import com.tencent.mobileqq.leba.view.LebaFeedsViewBase;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class LebaFeedsVideoPlayController
  implements adza, Handler.Callback, View.OnClickListener, LebaFeedsVideoSdkInstaller.OnVideoPluginInstallListener
{
  private static boolean jdField_g_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private adyz jdField_a_of_type_Adyz;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private VideoItemEventManager.onVideoItemEventListener jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager$onVideoItemEventListener = new adyy(this);
  private LebaFeedsVideoPlayController.VideoPlayParam jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam;
  private LebaFeedsVideoPlayer jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer;
  private LebaFeedsVideoSdkInstaller jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller;
  private LebaFPSXListView jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(16);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private int h = -1;
  private int i = -1;
  private int j = 0;
  private int k;
  
  public LebaFeedsVideoPlayController(Context paramContext, View paramView, LebaFPSXListView paramLebaFPSXListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView = paramLebaFPSXListView;
    this.jdField_a_of_type_AndroidViewView = paramView;
    l();
    k();
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller = new LebaFeedsVideoSdkInstaller(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller.a(this);
    VideoItemEventManager.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager$onVideoItemEventListener);
    this.jdField_a_of_type_JavaLangString = DeviceInfoUtil.e();
    this.jdField_b_of_type_JavaLangString = DeviceInfoUtil.i();
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, "LebaFeedsVideoPlayController model=" + this.jdField_a_of_type_JavaLangString + ", manufature=" + this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private LebaFeedsVideoPlayer a(LebaFeedsVideoPlayController.VideoPlayParam paramVideoPlayParam)
  {
    return new LebaFeedsVideoPlayer(this.jdField_a_of_type_AndroidContentContext, this);
  }
  
  private LebaFeedsVideoView1 a(AbsListView paramAbsListView)
  {
    Object localObject;
    if ((!this.jdField_c_of_type_Boolean) || (!a()) || (paramAbsListView.getChildCount() <= 0) || (this.jdField_f_of_type_Boolean))
    {
      localObject = null;
      return localObject;
    }
    int m = 0;
    label34:
    if (m < paramAbsListView.getChildCount())
    {
      localObject = paramAbsListView.getChildAt(m);
      if ((localObject == null) || (!(localObject instanceof LebaFeedsVideoView1))) {}
      for (;;)
      {
        m += 1;
        break label34;
        if (b((View)localObject))
        {
          LebaFeedsVideoView1 localLebaFeedsVideoView1 = (LebaFeedsVideoView1)localObject;
          if (!localLebaFeedsVideoView1.jdField_b_of_type_Boolean)
          {
            localObject = localLebaFeedsVideoView1;
            if (this.jdField_a_of_type_Adyz == null) {
              break;
            }
            localObject = localLebaFeedsVideoView1;
            if (!this.jdField_a_of_type_Adyz.a(localLebaFeedsVideoView1.a())) {
              break;
            }
          }
        }
      }
    }
    return null;
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, paramLong);
  }
  
  private void a(LebaFeedsVideoPlayController.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840616);
    if ((paramVideoPlayParam != null) && (!TextUtils.isEmpty(paramVideoPlayParam.jdField_a_of_type_JavaLangString)))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_b_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = LebaFeedsVideoView1.a;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = LebaFeedsVideoView1.a;
      localObject = URLDrawable.getDrawable(paramVideoPlayParam.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    for (;;)
    {
      b(paramVideoPlayParam);
      return;
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    paramAbsListView = a(paramAbsListView);
    if (paramAbsListView != null)
    {
      paramAbsListView = paramAbsListView.a();
      if (QLog.isColorLevel()) {
        QLog.d("LebaFeedsVideoPlayController", 2, "checkAndPlayVideo mPlayingVideoParam=" + this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long == paramAbsListView.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.b()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaFeedsVideoPlayController", 2, "checkAndPlayVideo resume");
        }
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.c();
      }
    }
    label111:
    do
    {
      do
      {
        do
        {
          break label111;
          do
          {
            return;
          } while ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long == paramAbsListView.jdField_a_of_type_Long) && (a() != 4));
          if (QLog.isColorLevel()) {
            QLog.d("LebaFeedsVideoPlayController", 2, "checkAndPlayVideo mPlayFrom=" + this.h);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam == null) || (a() == 4))
          {
            a(paramAbsListView, 2);
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam == null);
        if (a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_AndroidWidgetImageView))
        {
          a(paramAbsListView, 2);
          return;
        }
      } while (this.h == 1);
      a(paramAbsListView, 2);
      return;
      p();
    } while ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_AndroidWidgetImageView == null) || (!a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_AndroidWidgetImageView)));
    a();
  }
  
  private boolean a(View paramView)
  {
    if (paramView == null) {}
    int m;
    int n;
    do
    {
      return true;
      if (this.jdField_e_of_type_Int < 0) {
        q();
      }
      paramView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      m = this.jdField_a_of_type_ArrayOfInt[1];
      n = this.k;
    } while ((this.jdField_a_of_type_ArrayOfInt[1] + paramView.getHeight() - this.k < this.jdField_e_of_type_Int + this.jdField_g_of_type_Int) || (m + n > this.jdField_f_of_type_Int));
    return false;
  }
  
  private void b(LebaFeedsVideoPlayController.VideoPlayParam paramVideoPlayParam)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    int m;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0);
        if (paramVideoPlayParam == null)
        {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
          return;
        }
      } while (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsVideoView1 == null);
      if (this.jdField_e_of_type_Int < 0) {
        q();
      }
      this.jdField_a_of_type_ArrayOfInt[1] = 0;
      paramVideoPlayParam.jdField_b_of_type_AndroidWidgetImageView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      m = this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_e_of_type_Int;
    } while (m == this.jdField_a_of_type_AndroidWidgetFrameLayout.getTranslationY());
    ViewHelper.g(this.jdField_a_of_type_AndroidWidgetFrameLayout, m);
  }
  
  private boolean b(View paramView)
  {
    boolean bool = true;
    if (paramView == null) {
      return false;
    }
    if (this.jdField_e_of_type_Int < 0) {
      q();
    }
    paramView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    int m = this.jdField_a_of_type_ArrayOfInt[1] + this.k;
    int n = this.jdField_b_of_type_Int;
    if ((m > this.jdField_e_of_type_Int + this.jdField_g_of_type_Int) && (n + m < this.jdField_f_of_type_Int)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840616);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840617);
  }
  
  private void f(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setKeepScreenOn(paramBoolean);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370352));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366707));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366709));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366708));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366703);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370354));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370353));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(LebaFeedsViewBase.b);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.height = this.jdField_b_of_type_Int;
    localLayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.height = this.jdField_b_of_type_Int;
    localLayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams.height = this.jdField_b_of_type_Int;
    localLayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = this.jdField_b_of_type_Int;
    localLayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.height = this.jdField_b_of_type_Int;
    localLayoutParams.width = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  private void l()
  {
    int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int n = (int)(1.0F * m / 16.0F * 9.0F);
    this.jdField_a_of_type_Int = m;
    this.jdField_b_of_type_Int = n;
    this.k = AIOUtils.a(12.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, "calcVideoSize w=" + this.jdField_a_of_type_Int + ", h=" + this.jdField_b_of_type_Int);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840616);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer == null) {
      return;
    }
    LebaFeedsVideoPlayer localLebaFeedsVideoPlayer = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer;
    localLebaFeedsVideoPlayer.a(null);
    this.jdField_b_of_type_AndroidViewView = null;
    ThreadManager.postImmediately(new adyu(this, localLebaFeedsVideoPlayer), null, false);
  }
  
  private void o()
  {
    this.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a();
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      QLog.i("LebaFeedsVideoPlayController", 1, "addVideoViewToLayout mVideoView==null");
      return;
    }
    ViewParent localViewParent = this.jdField_b_of_type_AndroidViewView.getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
      ((ViewGroup)localViewParent).removeView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidViewView, 0, new FrameLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
  }
  
  private void p()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getHeaderViewsCount();
    int n = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getFirstVisiblePosition() - i1;
    int m = n;
    if (n < 0) {
      m = 0;
    }
    n = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getLastVisiblePosition();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null)
    {
      int i2 = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Int;
      if ((i2 >= 0) && ((i2 < m) || (i2 > n - i1)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("LebaFeedsVideoPlayController", 2, "checkItemLeftScreen stop video " + this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long);
        }
        a();
      }
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ArrayOfInt[1];
    this.jdField_f_of_type_Int = (this.jdField_e_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getHeight());
    int m = 0;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      m = ImmersiveUtils.a(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_g_of_type_Int = (m + AIOUtils.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a();
    }
    return 0L;
  }
  
  public LebaFeedsVideoPlayController.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +32 -> 37
    //   8: ldc 143
    //   10: iconst_2
    //   11: new 145	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 549
    //   21: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 174	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam	Lcom/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam;
    //   28: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_0
    //   38: getfield 174	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam	Lcom/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam;
    //   41: ifnull +191 -> 232
    //   44: aload_0
    //   45: getfield 183	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer	Lcom/tencent/mobileqq/leba/LebaFeedsVideoPlayer;
    //   48: ifnull +184 -> 232
    //   51: aload_0
    //   52: getfield 164	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_Adyz	Ladyz;
    //   55: ifnull +177 -> 232
    //   58: aload_0
    //   59: invokevirtual 550	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:a	()J
    //   62: lstore_2
    //   63: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +29 -> 95
    //   69: ldc 143
    //   71: iconst_2
    //   72: new 145	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 552
    //   82: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: lload_2
    //   86: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: lload_2
    //   96: lconst_0
    //   97: lcmp
    //   98: ifle +134 -> 232
    //   101: aload_0
    //   102: getfield 164	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_Adyz	Ladyz;
    //   105: invokeinterface 555 1 0
    //   110: astore 5
    //   112: aload_0
    //   113: getfield 174	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam	Lcom/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam;
    //   116: getfield 558	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam:jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo	Lcom/tencent/mobileqq/data/LebaFeedInfo;
    //   119: astore 6
    //   121: aload_0
    //   122: getfield 174	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam	Lcom/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam;
    //   125: getfield 527	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam:jdField_a_of_type_Int	I
    //   128: istore_1
    //   129: aload_0
    //   130: getfield 79	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:i	I
    //   133: iconst_1
    //   134: if_icmpne +141 -> 275
    //   137: ldc_w 560
    //   140: astore 4
    //   142: aload 5
    //   144: aload 6
    //   146: iload_1
    //   147: ldc_w 562
    //   150: aload 4
    //   152: lload_2
    //   153: invokestatic 567	com/tencent/mobileqq/leba/LebaUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/LebaFeedInfo;ILjava/lang/String;Ljava/lang/String;J)V
    //   156: aload_0
    //   157: getfield 79	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:i	I
    //   160: iconst_1
    //   161: if_icmpne +49 -> 210
    //   164: aload_0
    //   165: getfield 164	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_Adyz	Ladyz;
    //   168: invokeinterface 555 1 0
    //   173: ifnull +37 -> 210
    //   176: aload_0
    //   177: getfield 164	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_Adyz	Ladyz;
    //   180: invokeinterface 555 1 0
    //   185: sipush 276
    //   188: invokevirtual 573	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   191: checkcast 575	com/tencent/mobileqq/leba/LebaFeedsManager
    //   194: aload_0
    //   195: getfield 174	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam	Lcom/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam;
    //   198: getfield 558	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam:jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo	Lcom/tencent/mobileqq/data/LebaFeedInfo;
    //   201: lload_2
    //   202: ldc2_w 576
    //   205: ldiv
    //   206: l2i
    //   207: invokevirtual 580	com/tencent/mobileqq/leba/LebaFeedsManager:a	(Lcom/tencent/mobileqq/data/LebaFeedInfo;I)V
    //   210: aload_0
    //   211: getfield 86	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   214: aload_0
    //   215: getfield 174	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam	Lcom/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam;
    //   218: getfield 314	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam:jdField_a_of_type_Long	J
    //   221: invokestatic 586	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   224: lload_2
    //   225: invokestatic 586	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   228: invokevirtual 590	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: aload_0
    //   233: iconst_0
    //   234: invokespecial 592	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:f	(Z)V
    //   237: aload_0
    //   238: invokespecial 594	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:n	()V
    //   241: aload_0
    //   242: invokespecial 596	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:m	()V
    //   245: aload_0
    //   246: aconst_null
    //   247: putfield 183	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer	Lcom/tencent/mobileqq/leba/LebaFeedsVideoPlayer;
    //   250: aload_0
    //   251: aconst_null
    //   252: putfield 174	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam	Lcom/tencent/mobileqq/leba/LebaFeedsVideoPlayController$VideoPlayParam;
    //   255: aload_0
    //   256: ldc2_w 70
    //   259: putfield 73	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_a_of_type_Long	J
    //   262: aload_0
    //   263: iconst_1
    //   264: putfield 75	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:jdField_e_of_type_Boolean	Z
    //   267: aload_0
    //   268: iconst_0
    //   269: invokevirtual 598	com/tencent/mobileqq/leba/LebaFeedsVideoPlayController:a	(I)V
    //   272: aload_0
    //   273: monitorexit
    //   274: return
    //   275: ldc_w 600
    //   278: astore 4
    //   280: goto -138 -> 142
    //   283: astore 4
    //   285: aload_0
    //   286: monitorexit
    //   287: aload 4
    //   289: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	LebaFeedsVideoPlayController
    //   128	19	1	m	int
    //   62	163	2	l	long
    //   140	139	4	str	String
    //   283	5	4	localObject	Object
    //   110	33	5	localQQAppInterface	QQAppInterface
    //   119	26	6	localLebaFeedInfo	LebaFeedInfo
    // Exception table:
    //   from	to	target	type
    //   2	37	283	finally
    //   37	95	283	finally
    //   101	137	283	finally
    //   142	210	283	finally
    //   210	232	283	finally
    //   232	272	283	finally
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, "setState " + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
  }
  
  public void a(adyz paramadyz)
  {
    this.jdField_a_of_type_Adyz = paramadyz;
  }
  
  public void a(LebaFeedInfo paramLebaFeedInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam == null) || (paramLebaFeedInfo == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long != paramLebaFeedInfo.feedID) {
      return;
    }
    a();
  }
  
  public void a(LebaFeedsVideoPlayController.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, "playVideo playParam=" + paramVideoPlayParam + ", from=" + paramInt + ", old=" + this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam + ", mLastFeedId=" + this.jdField_a_of_type_Long + ", mLastIsMute=" + this.jdField_e_of_type_Boolean);
    }
    if (LebaUtils.a(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.i("LebaFeedsVideoPlayController", 1, "playVideo inCall==true");
      return;
    }
    if ((paramVideoPlayParam == null) || (!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller == null))
    {
      QLog.i("LebaFeedsVideoPlayController", 1, "playVideo return. mIsResume=" + this.jdField_c_of_type_Boolean + ", mSdkInstaller=" + this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller);
      return;
    }
    if (!paramVideoPlayParam.a())
    {
      QLog.i("LebaFeedsVideoPlayController", 1, "playVideo playParam invalid");
      return;
    }
    a(paramVideoPlayParam);
    this.h = paramInt;
    if (paramInt != 3) {
      this.i = paramInt;
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller.a()) {
        break label509;
      }
      this.jdField_b_of_type_Boolean = true;
      n();
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam = paramVideoPlayParam;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer = a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam);
      o();
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        QLog.i("LebaFeedsVideoPlayController", 1, "playVideo videoView == null");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("LebaFeedsVideoPlayController", 1, "playVideo param=" + paramVideoPlayParam + ", exception=" + localException, localException);
      return;
    }
    a(1);
    f(false);
    if ((this.jdField_a_of_type_Adyz != null) && (this.jdField_a_of_type_Adyz.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a(true);
      e(true);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long))) {
        l = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long))).longValue();
      }
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long;
      this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.c();
      ThreadManager.postImmediately(new adyt(this, l), null, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("LebaFeedsVideoPlayController", 2, "playVideo after post runnable");
      return;
      if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long))
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a(this.jdField_e_of_type_Boolean);
        e(this.jdField_e_of_type_Boolean);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a(true);
        e(true);
      }
    }
    label509:
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam = paramVideoPlayParam;
    a(7);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller.a();
    QLog.i("LebaFeedsVideoPlayController", 1, "sdk not install");
  }
  
  public void a(LebaFeedsVideoPlayer paramLebaFeedsVideoPlayer)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onVideoPrepared videoW=");
      if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer == null) {
        break label285;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a();
      localObject = ((StringBuilder)localObject).append(m).append(", videoH=");
      if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer == null) {
        break label290;
      }
    }
    label285:
    label290:
    for (int m = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.b();; m = 0)
    {
      QLog.i("LebaFeedsVideoPlayController", 2, m + ", viewW=" + this.jdField_a_of_type_Int + ", videoH=" + this.jdField_b_of_type_Int + ", mPlayFrom=" + this.h + ", state=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", mIsResume=" + this.jdField_c_of_type_Boolean);
      if (!this.jdField_b_of_type_Boolean)
      {
        QLog.e("LebaFeedsVideoPlayController", 1, "onVideoPrepared mIsOpenedVideo is false");
        if (!jdField_g_of_type_Boolean)
        {
          jdField_g_of_type_Boolean = true;
          localObject = new HashMap();
          ((HashMap)localObject).put("model", this.jdField_a_of_type_JavaLangString);
          ((HashMap)localObject).put("manufature", this.jdField_b_of_type_JavaLangString);
          StatisticCollector.a(BaseApplication.getContext()).a("", "newleba_feeds_recall_prepare", true, 0L, 0L, (HashMap)localObject, "");
        }
      }
      this.jdField_b_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam;
      if ((paramLebaFeedsVideoPlayer == this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer) && (localObject != null))
      {
        a(2);
        if ((!LebaUtils.a(this.jdField_a_of_type_AndroidContentContext)) && (this.jdField_c_of_type_Boolean)) {
          break label295;
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new adyv(this));
      }
      return;
      m = 0;
      break;
    }
    label295:
    m = this.h;
    this.jdField_a_of_type_AndroidOsHandler.post(new adyw(this, m));
    paramLebaFeedsVideoPlayer.a();
    a(3);
  }
  
  public void a(LebaFeedsVideoPlayer paramLebaFeedsVideoPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, String.format(Locale.getDefault(), "onVideoSizeChanged viewSize=(%d, %d), videoSize=(%d, %d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  public void a(LebaFeedsVideoPlayer paramLebaFeedsVideoPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onError feedid=");
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) {}
    for (Object localObject = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long);; localObject = "null")
    {
      QLog.i("LebaFeedsVideoPlayController", 1, localObject + ", player=" + paramLebaFeedsVideoPlayer + ", model=" + paramInt1 + ", what=" + paramInt2 + ", pos=" + paramInt3 + ", detail=" + paramString + ", obj=" + paramObject);
      a(8);
      paramLebaFeedsVideoPlayer = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(12);
      paramLebaFeedsVideoPlayer.obj = ("视频加载失败,请稍后重试:(" + paramInt1 + "." + paramInt2 + ")");
      paramLebaFeedsVideoPlayer.sendToTarget();
      if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null)
      {
        paramLebaFeedsVideoPlayer = new HashMap();
        paramLebaFeedsVideoPlayer.put("video_url", this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.c);
        paramLebaFeedsVideoPlayer.put("vid", this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_b_of_type_JavaLangString);
        paramLebaFeedsVideoPlayer.put("feedid", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long));
        paramLebaFeedsVideoPlayer.put("model", String.valueOf(paramInt1));
        paramLebaFeedsVideoPlayer.put("what", String.valueOf(paramInt2));
        paramLebaFeedsVideoPlayer.put("errCode", paramInt1 + "." + paramInt2);
        StatisticCollector.a(BaseApplication.getContext()).a("", "newleba_feeds_video_faild", false, 0L, 0L, paramLebaFeedsVideoPlayer, "");
      }
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.j = paramInt;
    if (paramInt == 0)
    {
      p();
      a(250L);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt1 + paramInt2 - 1;
    if (((this.jdField_c_of_type_Int != -1) && (this.jdField_c_of_type_Int != paramInt1)) || ((this.jdField_d_of_type_Int != -1) && (this.jdField_d_of_type_Int != paramInt2))) {
      p();
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    if (this.j != 2)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_b_of_type_Long > 200L)
      {
        this.jdField_b_of_type_Long = l;
        a(0L);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a())) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.b();
    }
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.b())) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.c();
    }
  }
  
  protected boolean a()
  {
    boolean bool = NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext);
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, "canAutoPlay " + bool);
    }
    return bool;
  }
  
  public void b()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam);
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      a(150L);
    }
  }
  
  public void b(LebaFeedsVideoPlayer paramLebaFeedsVideoPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, "onComplete");
    }
    long l;
    QQAppInterface localQQAppInterface;
    LebaFeedInfo localLebaFeedInfo;
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer != null) && (this.jdField_a_of_type_Adyz != null))
    {
      l = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.b();
      if (l > 0L)
      {
        localQQAppInterface = this.jdField_a_of_type_Adyz.a();
        localLebaFeedInfo = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo;
        m = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Int;
        if (this.i != 1) {
          break label233;
        }
      }
    }
    label233:
    for (Object localObject = "active_play";; localObject = "auto_play")
    {
      LebaUtils.a(localQQAppInterface, localLebaFeedInfo, m, "feeds_play_video", (String)localObject, l);
      if ((this.i == 1) && (this.jdField_a_of_type_Adyz.a() != null)) {
        ((LebaFeedsManager)this.jdField_a_of_type_Adyz.a().getManager(276)).a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo, (int)(l / 1000L));
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long), Long.valueOf(0L));
      localObject = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam;
      if ((paramLebaFeedsVideoPlayer == this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer) && (localObject != null) && (a() == 3))
      {
        a(6);
        this.jdField_a_of_type_AndroidOsHandler.post(new adyx(this, (LebaFeedsVideoPlayController.VideoPlayParam)localObject));
      }
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    b(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam);
    a(200L);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaFeedsVideoPlayController", 2, "onResume");
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.b()))
    {
      b(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.c();
      return;
    }
    a(100L);
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.d("LebaFeedsVideoPlayController", 1, "onInstallComplete install video sdk " + paramBoolean);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam, this.h);
      }
      return;
    }
    a(8);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam = null;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaFeedsVideoPlayController", 2, "onPause");
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a()))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.b();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, "notifyVideoChattingState " + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer != null) && (this.jdField_a_of_type_Adyz != null) && (this.jdField_a_of_type_Adyz.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a(true);
      this.jdField_e_of_type_Boolean = true;
      e(true);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaFeedsVideoPlayController", 2, "onStop");
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaFeedsVideoPlayController", 2, "onStart");
    }
  }
  
  public void g()
  {
    a();
    VideoItemEventManager.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_ComTencentMobileqqHotpicVideoItemEventManager$onVideoItemEventListener);
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller.b();
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoSdkInstaller = null;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam == null) {
      return;
    }
    if ((this.jdField_a_of_type_Adyz != null) && (this.jdField_a_of_type_Adyz.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long)))
    {
      a();
      return;
    }
    a(50L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_c_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView);
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)))
        {
          paramMessage = (String)paramMessage.obj;
          if (!TextUtils.isEmpty(paramMessage))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
        }
      }
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  @TargetApi(21)
  public void j()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaFeedsVideoPlayController", 2, "resetCornerMask using outline provider");
      }
      if (this.jdField_c_of_type_AndroidViewView.getVisibility() != 8) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOutlineProvider(new LebaFeedsVideoOutlineProvider(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setClipToOutline(true);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    switch (LebaUtils.a())
    {
    default: 
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    case 1: 
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840614);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130840613);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("LebaFeedsVideoPlayController", 2, "onClick play, " + paramView);
        }
      } while (!(paramView instanceof LebaFeedsVideoView1));
      paramView = ((LebaFeedsVideoView1)paramView).a();
      if (paramView == null)
      {
        QLog.e("LebaFeedsVideoPlayController", 2, "onClick play, param==null");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController$VideoPlayParam.jdField_a_of_type_Long == paramView.jdField_a_of_type_Long))
      {
        QLog.e("LebaFeedsVideoPlayController", 2, "onClick play, feedid same");
        return;
      }
      a();
      a(paramView, 1);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer == null);
    if (!this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.c()) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayer.a(bool);
      this.jdField_e_of_type_Boolean = bool;
      e(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaFeedsVideoPlayController
 * JD-Core Version:    0.7.0.1
 */