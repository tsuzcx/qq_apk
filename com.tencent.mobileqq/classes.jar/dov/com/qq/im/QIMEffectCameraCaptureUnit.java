package dov.com.qq.im;

import amsy;
import amsz;
import amta;
import amtb;
import amtc;
import amtd;
import amte;
import amtf;
import amtg;
import amth;
import amti;
import amtj;
import amtk;
import amtl;
import amtm;
import amtn;
import amto;
import amtp;
import amtq;
import amtr;
import amts;
import amtt;
import amtu;
import amtv;
import amtw;
import amtx;
import amty;
import amtz;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraProviderViewGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraViewPagerGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.EffectListener;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import dov.com.qq.im.capture.EditState;
import dov.com.qq.im.capture.QIMCaptureController;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.OnResourceDownloadListener;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.ScrollCallBack;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;
import dov.com.tencent.mobileqq.richmedia.capture.util.DanceGameReporter;
import dov.com.tencent.mobileqq.richmedia.capture.util.EffectsListenerController;
import dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar.BeautyBarListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager.OnViewPagerItemVisiableChangeListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.GuideVideoView;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import dov.com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@TargetApi(9)
public abstract class QIMEffectCameraCaptureUnit
  extends QIMCameraCaptureUnit
  implements EffectsCameraCaptureView.EffectListener, QQDanceEventHandler, VideoFilterTools.OnResourceDownloadListener, VideoFilterViewPager.ScrollCallBack, BeautyBar.BeautyBarListener, CaptureVideoFilterViewPager.OnViewPagerItemVisiableChangeListener
{
  public static boolean k;
  private static boolean jdField_l_of_type_Boolean = true;
  private final amtz jdField_a_of_type_Amtz = new amtz(this, null);
  protected Bundle a;
  public Handler a;
  public AlphaAnimation a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new amte(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQStoryTakeVideoHelper a;
  private CameraProviderViewGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture;
  private CameraViewPagerGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture;
  public EffectsCameraCaptureView a;
  public QIMCaptureController a;
  QIMFilterCategoryItem jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = null;
  public QIMProviderContainerView a;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private GuideVideoView jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView;
  protected String a;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  protected int b;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public AlphaAnimation b;
  private Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new amtf(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  protected String b;
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int = -1;
  public AlphaAnimation c;
  private Animation.AnimationListener jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = new amtg(this);
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  protected String c;
  protected List c;
  private int d;
  public boolean e = true;
  public boolean f = true;
  public boolean g = true;
  private TextView h;
  public boolean h;
  private TextView i;
  public volatile boolean i;
  private TextView j;
  public boolean j;
  private TextView k;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  private boolean jdField_m_of_type_Boolean;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q = true;
  private boolean r;
  private boolean s;
  private boolean t;
  
  public QIMEffectCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_j_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new amth(this, Looper.getMainLooper());
  }
  
  private void C()
  {
    this.jdField_i_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void D() {}
  
  private void E()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "removeCaptureGuide");
    }
  }
  
  private void F()
  {
    if (!this.t)
    {
      if (this.s)
      {
        ((QIMPtvTemplateManager)QIMManager.a(3)).a("0", QIMPtvTemplateAdapter.jdField_b_of_type_Int, "");
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.t();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
        this.s = false;
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Amtz);
        this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.e();
  }
  
  private void G()
  {
    if (this.t) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "now showDGVideoGuide and animation,  mGuideVideoView : " + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView == null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView = new GuideVideoView(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a());
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCloseListener(new amtn(this));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCompleteListener(new amto(this));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnErrorListener(new amtp(this));
    }
    Object localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView;
    ((ViewGroup)localObject).removeView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    ((ViewGroup)localObject).addView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
    localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(500L);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.clearAnimation();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.startAnimation((Animation)localObject);
    this.t = true;
  }
  
  private void H()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new amtq(this));
  }
  
  private void I()
  {
    this.r = false;
    t();
  }
  
  private void J()
  {
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_b_of_type_AndroidViewViewGroup.getContext());
    int i1 = DisplayUtils.a(47.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
    localLayoutParams.topMargin = DisplayUtils.a(110.0F);
    localLayoutParams.rightMargin = DisplayUtils.a(40.0F);
    localLayoutParams.addRule(11, -1);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843145);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new amtr(this));
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_c_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  private void K()
  {
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368926));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
      this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.cancel();
      this.jdField_k_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.reset();
    this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_k_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setStartOffset(2000L);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
    this.jdField_k_of_type_AndroidWidgetTextView.setAnimation(this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.startNow();
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i2;
    boolean bool;
    int i1;
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a()) && (this.q))
    {
      i2 = 1;
      bool = paramBoolean1;
      if (paramBoolean1) {
        bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.d();
      }
      if ((!bool) || (paramBoolean3)) {
        break label105;
      }
      i1 = 0;
    }
    for (;;)
    {
      label55:
      a(null, false);
      if (i1 == 0) {
        if ((bool) && (!paramBoolean2)) {
          if (i2 != 0)
          {
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
        }
      }
      label105:
      do
      {
        do
        {
          String str;
          do
          {
            return;
            i2 = 0;
            break;
            if ((!bool) && (paramBoolean3))
            {
              i1 = 1;
              break label55;
            }
            if ((!bool) || (!paramBoolean3)) {
              break label376;
            }
            i1 = 2;
            break label55;
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438150);
            return;
            if ((!bool) || (!paramBoolean2)) {
              break label214;
            }
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.b();
          } while (TextUtils.isEmpty(str));
          a(str, true);
          return;
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          if (i1 == 1)
          {
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
          }
        } while (i1 != 2);
        if (paramBoolean4)
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        if ((!paramBoolean4) && (paramBoolean2))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
      } while ((paramBoolean4) || (paramBoolean2));
      label214:
      if (i2 != 0)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438150);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      label376:
      i1 = 0;
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_m_of_type_AndroidWidgetTextView.setText("准备进入视频回放.");
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.jdField_m_of_type_AndroidWidgetTextView.setText("准备进入视频回放..");
        return;
      }
    } while (paramInt != 2);
    this.jdField_m_of_type_AndroidWidgetTextView.setText("准备进入视频回放...");
  }
  
  public void A()
  {
    VideoFilterTools.a().a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getApplicationContext(), this);
  }
  
  public void B() {}
  
  public void L_()
  {
    super.L_();
    ThreadManager.getUIHandler().post(new amty(this));
    if (this.jdField_a_of_type_Long != -1L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      NewFlowCameraReporter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), l1 - l2, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a() + "", jdField_l_of_type_Boolean);
      jdField_l_of_type_Boolean = false;
    }
  }
  
  protected int a()
  {
    return 2130970076;
  }
  
  public View a()
  {
    boolean bool3 = true;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)super.a());
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368928));
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(8);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setScrollCallBack(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffectListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setDanceFilterEventHandler(this);
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController = new QIMCaptureController(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), c(), this.jdField_a_of_type_DovComQqImSettingICameraEntrance);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setProviderViewListener(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView = ((QIMProviderContainerView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368916));
    int i1;
    label166:
    Object localObject;
    boolean bool2;
    if ((CaptureUtil.f()) && (PtvFilterSoLoad.b()))
    {
      i1 = 1;
      boolean bool4 = PtvFilterSoLoad.b();
      if (MediaCodecDPC.l()) {
        break label618;
      }
      bool1 = true;
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setDpcEnable(bool1);
      localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if ((!this.e) || (i1 == 0)) {
        break label623;
      }
      bool2 = true;
      label193:
      ((QIMProviderContainerView)localObject).setBeautyEnable(bool2);
      localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if (!this.g) {
        break label628;
      }
      bool2 = true;
      label214:
      ((QIMProviderContainerView)localObject).setFilterEnable(bool2);
      localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if ((!this.jdField_h_of_type_Boolean) || (!bool4)) {
        break label633;
      }
      bool2 = true;
      label240:
      ((QIMProviderContainerView)localObject).setFaceEffectEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.e) || (i1 == 0) || (!bool1)) {
        break label638;
      }
      bool2 = true;
      label269:
      ((EffectsCameraCaptureView)localObject).setBeautyEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!bool4) || (!bool1)) {
        break label643;
      }
      bool2 = true;
      label292:
      ((EffectsCameraCaptureView)localObject).setSharpFaceEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.g) || (!bool1)) {
        break label648;
      }
      bool2 = true;
      label317:
      ((EffectsCameraCaptureView)localObject).setFilterEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.jdField_h_of_type_Boolean) || (!bool4) || (!bool1)) {
        break label653;
      }
    }
    label643:
    label648:
    label653:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      ((EffectsCameraCaptureView)localObject).setFaceEffectEnable(bool1);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.b();
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368924));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368923));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368922));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368925));
      this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368927));
      this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368918);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368919));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368920));
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1000L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368921));
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture = new CameraProviderViewGesture(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture = new CameraViewPagerGesture(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager);
      J();
      K();
      return this.jdField_b_of_type_AndroidViewViewGroup;
      i1 = 0;
      break;
      label618:
      bool1 = false;
      break label166;
      label623:
      bool2 = false;
      break label193;
      label628:
      bool2 = false;
      break label214;
      label633:
      bool2 = false;
      break label240;
      label638:
      bool2 = false;
      break label269;
      bool2 = false;
      break label292;
      bool2 = false;
      break label317;
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.v();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
    }
    Activity localActivity = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    ReportUtil.a(localActivity, paramInt1, paramInt2);
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if ((paramInt1 == 10006) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.j();
      g(false);
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        QQFilterRenderManagerHolder.a(null);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController == null) {
        break;
      }
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.a(paramInt1, paramInt2, paramIntent);
      return;
      if ((paramInt1 == 1012) && (paramInt2 == -1))
      {
        ShortVideoProcessUtil.a(localActivity, paramIntent, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper, this.jdField_a_of_type_DovComQqImSettingICameraEntrance);
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.j();
        g(false);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    DanceGameVideoManager.a().a(false);
    this.jdField_a_of_type_AndroidOsHandler.post(new amtl(this));
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null) && (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.a() != null)) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.a().setTimeStamp(paramLong, false);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    LbsFilterStatusManager.a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a());
    ThreadManager.postImmediately(new amsy(this), null, true);
    CaptureReportUtil.m();
    CaptureReportUtil.e = true;
    CaptureReportUtil.a = this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a();
    CaptureReportUtil.a();
    CaptureUtil.b = false;
    paramBundle = (QimMusicPlayer)QIMManager.a().c(8);
    if (paramBundle != null) {
      paramBundle.e();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper = new QQStoryTakeVideoHelper(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), RMVideoStateMgr.a(), this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent());
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    this.jdField_a_of_type_AndroidOsBundle = EditState.a(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.r();
    this.jdField_a_of_type_AndroidOsBundle = EditState.a(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController);
    super.a(paramVideoCaptureResult);
  }
  
  public void a(BoyDataReport paramBoyDataReport)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new amtk(this));
    CaptureReportUtil.a(paramBoyDataReport);
  }
  
  public void a(QQVideoMaterial paramQQVideoMaterial)
  {
    if (paramQQVideoMaterial == null) {
      return;
    }
    if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.AR_PARTICLE.value) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramQQVideoMaterial.b();
      if (((this.jdField_i_of_type_Boolean) && (bool1)) || ((!this.jdField_i_of_type_Boolean) && (!bool1))) {
        break;
      }
      ThreadManager.getUIHandler().post(new amtd(this, bool1, bool2));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new amtu(this, paramString1, paramString2));
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    int i1 = -1;
    super.a(paramBoolean, paramString);
    int i2 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a();
    if (i2 == 1)
    {
      int i3 = AdvancedProviderView.b();
      if (QLog.isColorLevel()) {
        QLog.d(EffectsListenerController.jdField_a_of_type_JavaLangString, 2, "beauty level : " + i3);
      }
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.c(i3);
      paramString = this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.jdField_i_of_type_Boolean) {
        i1 = AdvancedProviderView.c();
      }
      paramString.b(i1, false);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int != i2) {
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.e(i2);
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a();
      return;
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.c(0);
      if ((QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString.equals("0")) && (QIMPtvTemplateAdapter.jdField_b_of_type_Int == 0)) {
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(-1, false);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ThreadManager.getUIHandler().post(new amtb(this, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4));
  }
  
  public boolean a(boolean paramBoolean, String paramString)
  {
    this.s = paramBoolean;
    int i1;
    label177:
    Object localObject1;
    boolean bool;
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "changeDanceStatus " + paramBoolean + " " + paramString);
      }
      if (paramBoolean)
      {
        g();
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(4);
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).a((Activity)c().getContext(), 0);
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() == 2)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.h();
        }
        if (!paramBoolean) {
          break label443;
        }
        i1 = 4;
        localObject1 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
        if (paramBoolean) {
          break label448;
        }
        bool = true;
        label190:
        ((VideoFilterViewPager)localObject1).setEnabled(bool);
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(i1);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label946;
      }
      if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get(paramString)))) {
        break label454;
      }
      this.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "has parsed shareWebUrl : " + this.jdField_c_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (this.t)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "DGVideoGuide is showing, now start ");
        }
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.f();
        paramBoolean = false;
        if (this.t) {
          break label921;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
        return paramBoolean;
        if (a()) {
          e();
        }
        for (;;)
        {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
          if (this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem == null) {
            break;
          }
          ((CaptureComboManager)QIMManager.a(5)).a((Activity)c().getContext(), 0, this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem);
          this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = null;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("QIMEffectCameraCaptureUnit", 2, "changeDanceStatus showButtons deny, is capturing");
          }
        }
        label443:
        i1 = 0;
        break label177;
        label448:
        bool = false;
        break label190;
        try
        {
          label454:
          localObject1 = new JSONObject(ResourceManager.a(paramString + "params.json")).getJSONObject("postureParam");
          this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).getString("shareWebUrl");
          localObject1 = ((JSONObject)localObject1).getString("guideVideoUrl");
          this.jdField_a_of_type_JavaUtilMap.put(paramString, this.jdField_c_of_type_JavaLangString);
          this.jdField_b_of_type_JavaUtilMap.put(paramString, localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("QIMEffectCameraCaptureUnit", 2, "has not parsed shareWebUrl, now parse  ; " + this.jdField_c_of_type_JavaLangString);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    if (this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a() != 10007)
    {
      paramBoolean = localSharedPreferences.getBoolean("hasShowDGVideoGuide", false);
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasShowDGVideoGuide : " + paramBoolean);
      }
      localObject2 = (QIMPtvTemplateManager)QIMManager.a(3);
      if (localObject2 == null) {
        break label940;
      }
    }
    label921:
    label940:
    for (Object localObject2 = ((QIMPtvTemplateManager)localObject2).a();; localObject2 = null)
    {
      if ((!paramBoolean) && ((localObject2 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject2).kind != 6)))
      {
        G();
        if ((this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilMap.get(paramString))))
        {
          localObject2 = (String)this.jdField_b_of_type_JavaUtilMap.get(paramString);
          paramString = (String)localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("QIMEffectCameraCaptureUnit", 2, "has parsed guideVideoUrl : " + (String)localObject2);
            paramString = (String)localObject2;
          }
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramString)) {
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.a(paramString);
          }
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.a();
          localSharedPreferences.edit().putBoolean("hasShowDGVideoGuide", true).commit();
          paramBoolean = false;
          break;
          try
          {
            paramString = new JSONObject(ResourceManager.a(paramString + "params.json")).getJSONObject("postureParam").getString("guideVideoUrl");
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            paramString = null;
          }
        }
        localSharedPreferences.edit().putBoolean("hasShowDGVideoGuide", true).commit();
      }
      paramBoolean = true;
      break;
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(false);
      return paramBoolean;
    }
    label946:
    return true;
  }
  
  public void ag_()
  {
    super.ag_();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(8);
    ThreadManager.getUIHandler().post(new amta(this));
  }
  
  public void ah_()
  {
    super.ah_();
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.q();
    }
    ThreadManager.getUIHandler().post(new amsz(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(paramInt);
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new amti(this));
    DanceGameReporter.a().a(paramLong);
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean c()
  {
    boolean bool = false;
    if (!this.t)
    {
      if (this.s)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.w();
        bool = true;
      }
      return bool;
    }
    H();
    return false;
  }
  
  public void d()
  {
    super.d();
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.i();
    F();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new amtt(this, paramBoolean));
    }
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(0);
  }
  
  public void f()
  {
    ThreadManager.getUIHandler().post(new amtx(this));
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new amtm(this, paramBoolean));
  }
  
  public void f_(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new amtj(this));
    ThreadManager.post(new amts(this), 10, null, true);
  }
  
  protected void g()
  {
    super.g();
    D();
    E();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(8);
  }
  
  public void g(boolean paramBoolean)
  {
    super.g(paramBoolean);
    if ((this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null) && (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null)) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.f(paramBoolean);
    }
  }
  
  public void g_(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(paramBoolean);
  }
  
  protected void h()
  {
    super.h();
    if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.j();
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    super.h(paramBoolean);
    if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.g(paramBoolean);
    }
    if (!paramBoolean)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
      if (localQimMusicPlayer != null) {
        localQimMusicPlayer.a(localQimMusicPlayer.b(), true, 0);
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!jdField_k_of_type_Boolean)
    {
      jdField_k_of_type_Boolean = true;
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new amtv(this));
      return;
    }
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new amtw(this));
  }
  
  public void j() {}
  
  public void j(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new amtc(this, paramBoolean));
  }
  
  public void l()
  {
    super.l();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.h();
    GestureRecognitionUtils.a.clear();
  }
  
  public void m()
  {
    super.m();
    LbsFilterStatusManager.a();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.c();
    ImageMemoryManager.getInstance().clear();
    CaptureReportUtil.m();
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController == null) {}
    while ((this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.a()) || (c()) || (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.d())) {
      return;
    }
    D();
    E();
    super.n();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.h();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.j();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.e();
    }
    super.onClick(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.c()) {
      a(null, null);
    }
    if (this.s) {
      return true;
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void p()
  {
    super.p();
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a();
    if (this.s)
    {
      if (this.r)
      {
        this.jdField_d_of_type_Boolean = true;
        I();
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView != null) && (this.t)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.d();
      }
    }
  }
  
  protected void q()
  {
    super.q();
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      this.jdField_c_of_type_JavaUtilList.remove(this.jdField_c_of_type_JavaUtilList.size() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureDelete, segmentMusicTimePoints size = " + this.jdField_c_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.s();
  }
  
  public void s()
  {
    super.s();
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_c_of_type_JavaUtilList.size() <= 0) {
        break label82;
      }
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.h(true);
      QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
      if (localQimMusicPlayer != null)
      {
        localQimMusicPlayer.c(((Integer)this.jdField_c_of_type_JavaUtilList.get(this.jdField_c_of_type_JavaUtilList.size() - 1)).intValue());
        localQimMusicPlayer.c();
      }
    }
    return;
    label82:
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.q();
  }
  
  public void t()
  {
    super.t();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.h(false);
    QimMusicPlayer localQimMusicPlayer;
    if (this.jdField_a_of_type_Boolean)
    {
      localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
      if (localQimMusicPlayer != null)
      {
        int i1 = localQimMusicPlayer.a();
        if (i1 < 0) {
          break label103;
        }
        this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(i1));
      }
    }
    for (;;)
    {
      localQimMusicPlayer.d();
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onCaptureButtonVideoStop, segmentMusicTimePoints size = " + this.jdField_c_of_type_JavaUtilList.size());
      }
      return;
      label103:
      if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
        this.jdField_c_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList.get(this.jdField_c_of_type_JavaUtilList.size() - 1));
      } else {
        this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
    }
  }
  
  protected void w()
  {
    super.w();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.s();
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      this.jdField_c_of_type_JavaUtilList.remove(this.jdField_c_of_type_JavaUtilList.size() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureError, segmentMusicTimePoints size = " + this.jdField_c_of_type_JavaUtilList.size());
    }
  }
  
  protected void y()
  {
    super.y();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.v();
  }
  
  public void z()
  {
    int i1 = -1;
    int i2 = AdvancedProviderView.b();
    if (QLog.isColorLevel()) {
      QLog.d(EffectsListenerController.jdField_a_of_type_JavaLangString, 2, "beauty level : " + i2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a() == 1)
    {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.c(i2);
      QIMCaptureController localQIMCaptureController = this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.jdField_i_of_type_Boolean) {
        i1 = AdvancedProviderView.c();
      }
      localQIMCaptureController.b(i1, false);
    }
    do
    {
      return;
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.c(0);
    } while ((!QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString.equals("0")) || (QIMPtvTemplateAdapter.jdField_b_of_type_Int != 0));
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(-1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */