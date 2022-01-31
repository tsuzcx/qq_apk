package dov.com.qq.im;

import android.animation.ObjectAnimator;
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
import anrj;
import anrk;
import anrl;
import anrm;
import anrn;
import anro;
import anrp;
import anrq;
import anrr;
import anrs;
import anrt;
import anru;
import anrv;
import anrw;
import anrx;
import anry;
import anrz;
import ansa;
import ansb;
import ansc;
import ansd;
import anse;
import ansf;
import ansg;
import ansh;
import ansi;
import ansm;
import ansn;
import anso;
import ansp;
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
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.ContainerViewListener;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
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
  public static boolean l;
  private static boolean m = true;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  protected Bundle a;
  public Handler a;
  public AlphaAnimation a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new anrr(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final ansp jdField_a_of_type_Ansp = new ansp(this, null);
  public QQStoryTakeVideoHelper a;
  private CameraProviderViewGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture;
  private CameraViewPagerGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture;
  public EffectsCameraCaptureView a;
  private ProviderContainerView.ContainerViewListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener;
  public QIMCaptureController a;
  QIMFilterCategoryItem jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = null;
  public QIMProviderContainerView a;
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  private GuideVideoView jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView;
  protected String a;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  protected int b;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  protected View b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public AlphaAnimation b;
  private Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new anrs(this);
  public ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  protected String b;
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private int jdField_c_of_type_Int = -1;
  private View jdField_c_of_type_AndroidViewView;
  public AlphaAnimation c;
  private Animation.AnimationListener jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = new anrt(this);
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  protected String c;
  private int jdField_d_of_type_Int = 0;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  protected List d;
  private int jdField_e_of_type_Int;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private TextView f;
  public boolean f;
  private TextView g;
  public boolean g;
  private TextView h;
  public boolean h;
  private TextView i;
  public boolean i;
  public volatile boolean j;
  public boolean k = false;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r = true;
  private boolean s;
  private boolean t;
  private boolean u;
  
  public QIMEffectCameraCaptureUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new anrv(this, Looper.getMainLooper());
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a() == 10001) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "qzone not show operation");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (RecentDanceConfigMgr.c()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QIMEffectCameraCaptureUnit", 2, "configuration not show operation");
        return;
        if (RecentDanceConfigMgr.b(this.jdField_b_of_type_AndroidViewViewGroup.getContext())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QIMEffectCameraCaptureUnit", 2, "resource hasn't ready not show operation");
      return;
      RecentDanceConfigMgr.DItemInfo localDItemInfo = RecentDanceConfigMgr.c();
      if (localDItemInfo != null)
      {
        ThreadManager.getUIHandler().post(new ansi(this, localDItemInfo));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 2, "itemInfo == null not show operation");
  }
  
  private void H()
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void I()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView = null;
    }
  }
  
  private void J() {}
  
  private void K()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "removeCaptureGuide");
    }
  }
  
  private void L()
  {
    if (!this.u)
    {
      if (this.t)
      {
        ((QIMPtvTemplateManager)QIMManager.a(3)).a("0", QIMPtvTemplateAdapter.jdField_b_of_type_Int, "");
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.t();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
        this.t = false;
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Ansp);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.e();
  }
  
  private void M()
  {
    if (this.u) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "now showDGVideoGuide and animation,  mGuideVideoView : " + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView == null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView = new GuideVideoView(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), ThreadManager.getUIHandler());
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCloseListener(new ansa(this));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCompleteListener(new ansb(this));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnErrorListener(new ansc(this));
    }
    Object localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView;
    ((ViewGroup)localObject).removeView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    ((ViewGroup)localObject).addView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
    localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(500L);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.clearAnimation();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.startAnimation((Animation)localObject);
    this.u = true;
  }
  
  private void N()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ansd(this));
  }
  
  private void O()
  {
    this.s = false;
    u();
  }
  
  private void P()
  {
    this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this.jdField_b_of_type_AndroidViewViewGroup.getContext());
    int i1 = DisplayUtils.a(47.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
    localLayoutParams.topMargin = DisplayUtils.a(110.0F);
    localLayoutParams.rightMargin = DisplayUtils.a(40.0F);
    localLayoutParams.addRule(11, -1);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130843277);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new anse(this));
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_d_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  private void Q()
  {
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368993));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
      this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.cancel();
      this.jdField_g_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.reset();
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setStartOffset(2000L);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
    this.jdField_g_of_type_AndroidWidgetTextView.setAnimation(this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.startNow();
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int i2;
    boolean bool;
    int i1;
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a()) && (this.r))
    {
      i2 = 1;
      bool = paramBoolean1;
      if (paramBoolean1) {
        bool = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.f();
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
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
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
            this.jdField_c_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438188);
            return;
            if ((!bool) || (!paramBoolean2)) {
              break label214;
            }
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.b();
          } while (TextUtils.isEmpty(str));
          a(str, true);
          return;
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          if (i1 == 1)
          {
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
          }
        } while (i1 != 2);
        if (paramBoolean4)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        if ((!paramBoolean4) && (paramBoolean2))
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
      } while ((paramBoolean4) || (paramBoolean2));
      label214:
      if (i2 != 0)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438188);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      label376:
      i1 = 0;
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_i_of_type_AndroidWidgetTextView.setText("准备进入视频回放.");
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setText("准备进入视频回放..");
        return;
      }
    } while (paramInt != 2);
    this.jdField_i_of_type_AndroidWidgetTextView.setText("准备进入视频回放...");
  }
  
  private void l(boolean paramBoolean)
  {
    int i1;
    ObjectAnimator localObjectAnimator;
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        break label145;
      }
      if (this.jdField_d_of_type_Int != 1) {
        break label117;
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a()) {
        break label107;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "visible == false, Container opened operation invisible");
      }
      i1 = DisplayUtils.a(98.0F);
      this.jdField_d_of_type_Int = 2;
      localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "translationX", new float[] { this.jdField_b_of_type_AndroidWidgetImageView.getTranslationX(), i1 });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
    label107:
    label117:
    label254:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_d_of_type_Int = 3;
          i1 = 0;
          break;
        } while ((this.jdField_d_of_type_Int != 3) || (this.jdField_b_of_type_AndroidAnimationObjectAnimator == null));
        this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
        this.jdField_d_of_type_Int = 2;
        return;
        if ((!this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a()) || (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.getVisibility() != 0)) {
          break label254;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_d_of_type_Int == 0)
        {
          localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, DisplayUtils.a(-139.0F) });
          localObjectAnimator.setDuration(500L);
          localObjectAnimator.start();
          this.jdField_d_of_type_Int = 1;
          return;
        }
      } while ((this.jdField_d_of_type_Int != 2) || (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      this.jdField_d_of_type_Int = 3;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "visible == true, Container opened operation invisible");
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    } while ((this.jdField_d_of_type_Int != 3) || (this.jdField_b_of_type_AndroidAnimationObjectAnimator == null));
    label145:
    this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
    this.jdField_d_of_type_Int = 2;
  }
  
  protected void A()
  {
    super.A();
    I();
  }
  
  public void A_()
  {
    super.A_();
    ThreadManager.getUIHandler().post(new anrl(this));
    if (this.jdField_a_of_type_Long != -1L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      NewFlowCameraReporter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), l1 - l2, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a() + "", m);
      m = false;
    }
  }
  
  protected void B()
  {
    super.B();
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(4);
    }
  }
  
  public void B_()
  {
    super.B_();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(8);
    ThreadManager.getUIHandler().post(new anrn(this));
  }
  
  protected void C()
  {
    super.C();
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
    }
  }
  
  public void D()
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
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.j) {
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
  
  public void E()
  {
    VideoFilterTools.a().a(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getApplicationContext(), this);
  }
  
  public void F() {}
  
  protected int a()
  {
    return 2130970102;
  }
  
  public View a()
  {
    boolean bool3 = true;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)super.a());
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368995));
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(8);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setScrollCallBack(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffectListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setDanceFilterEventHandler(this);
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController = new QIMCaptureController(this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a(), c(), this.jdField_a_of_type_DovComQqImSettingICameraEntrance);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setProviderViewListener(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView = ((QIMProviderContainerView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368983));
    int i1;
    label166:
    Object localObject;
    boolean bool2;
    if ((CaptureUtil.f()) && (PtvFilterSoLoad.b()))
    {
      i1 = 1;
      boolean bool4 = PtvFilterSoLoad.b();
      if (MediaCodecDPC.l()) {
        break label632;
      }
      bool1 = true;
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setDpcEnable(bool1);
      localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if ((!this.jdField_f_of_type_Boolean) || (i1 == 0)) {
        break label637;
      }
      bool2 = true;
      label193:
      ((QIMProviderContainerView)localObject).setBeautyEnable(bool2);
      localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if (!this.jdField_h_of_type_Boolean) {
        break label642;
      }
      bool2 = true;
      label214:
      ((QIMProviderContainerView)localObject).setFilterEnable(bool2);
      localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if ((!this.jdField_i_of_type_Boolean) || (!bool4)) {
        break label647;
      }
      bool2 = true;
      label240:
      ((QIMProviderContainerView)localObject).setFaceEffectEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.jdField_f_of_type_Boolean) || (i1 == 0) || (!bool1)) {
        break label652;
      }
      bool2 = true;
      label269:
      ((EffectsCameraCaptureView)localObject).setBeautyEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!bool4) || (!bool1)) {
        break label657;
      }
      bool2 = true;
      label292:
      ((EffectsCameraCaptureView)localObject).setSharpFaceEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.jdField_h_of_type_Boolean) || (!bool1)) {
        break label662;
      }
      bool2 = true;
      label317:
      ((EffectsCameraCaptureView)localObject).setFilterEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.jdField_i_of_type_Boolean) || (!bool4) || (!bool1)) {
        break label667;
      }
    }
    label642:
    label647:
    label652:
    label657:
    label662:
    label667:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      ((EffectsCameraCaptureView)localObject).setFaceEffectEnable(bool1);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.b();
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368991));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368990));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368989));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368992));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368994));
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368985);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368986));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368987));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1000L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368988));
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture = new CameraProviderViewGesture(this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture = new CameraViewPagerGesture(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369001);
      P();
      Q();
      return this.jdField_b_of_type_AndroidViewViewGroup;
      i1 = 0;
      break;
      label632:
      bool1 = false;
      break label166;
      label637:
      bool2 = false;
      break label193;
      bool2 = false;
      break label214;
      bool2 = false;
      break label240;
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
    this.jdField_a_of_type_AndroidOsHandler.post(new anry(this));
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
    ThreadManager.postImmediately(new anrj(this), null, true);
    CaptureReportUtil.m();
    CaptureReportUtil.jdField_e_of_type_Boolean = true;
    CaptureReportUtil.a = this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams.a();
    CaptureReportUtil.a();
    CaptureUtil.jdField_b_of_type_Boolean = false;
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
    this.jdField_a_of_type_AndroidOsHandler.post(new anrx(this));
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
      if (((this.j) && (bool1)) || ((!this.j) && (!bool1))) {
        break;
      }
      ThreadManager.getUIHandler().post(new anrq(this, bool1, bool2));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new ansm(this, paramString1, paramString2));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(paramBoolean);
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
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.j) {
        i1 = AdvancedProviderView.c();
      }
      paramString.b(i1, false);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int != i2) {
        this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.f(i2);
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
    ThreadManager.getUIHandler().post(new anro(this, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4));
  }
  
  public boolean a(boolean paramBoolean, String paramString)
  {
    this.t = paramBoolean;
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
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(4);
        if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).a((Activity)c().getContext(), 0);
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() == 2)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.h();
        }
        if (!paramBoolean) {
          break label444;
        }
        i1 = 4;
        localObject1 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
        if (paramBoolean) {
          break label449;
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
        break label948;
      }
      if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get(paramString)))) {
        break label455;
      }
      this.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "has parsed shareWebUrl : " + this.jdField_c_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (this.u)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "DGVideoGuide is showing, now start ");
        }
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.f();
        paramBoolean = false;
        if (this.u) {
          break label923;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
        return paramBoolean;
        if (a()) {
          e();
        }
        for (;;)
        {
          this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
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
        label444:
        i1 = 0;
        break label177;
        label449:
        bool = false;
        break label190;
        try
        {
          label455:
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
        break label942;
      }
    }
    label923:
    label942:
    for (Object localObject2 = ((QIMPtvTemplateManager)localObject2).a();; localObject2 = null)
    {
      if ((!paramBoolean) && ((localObject2 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject2).kind != 6)))
      {
        M();
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
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(false);
      return paramBoolean;
    }
    label948:
    return true;
  }
  
  public void al_()
  {
    super.al_();
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.q();
    }
    ThreadManager.getUIHandler().post(new anrm(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(paramInt);
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (!this.u)
    {
      if (this.t)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.w();
        bool = true;
      }
      return bool;
    }
    N();
    return false;
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new anrw(this));
    DanceGameReporter.a().a(paramLong);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d()
  {
    super.d();
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.i();
    L();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new ansh(this, paramBoolean));
    }
  }
  
  public void d_(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new anru(this));
    ThreadManager.post(new ansf(this), 10, null, true);
    ThreadManager.post(new ansg(this), 5, null, true);
  }
  
  protected void e()
  {
    super.e();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(0);
    l(true);
  }
  
  public void f()
  {
    ThreadManager.getUIHandler().post(new anrk(this));
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new anrz(this, paramBoolean));
  }
  
  protected void g()
  {
    super.g();
    J();
    K();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.b(8);
    l(false);
  }
  
  public void g(boolean paramBoolean)
  {
    super.g(paramBoolean);
    if ((this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null) && (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null)) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.g(paramBoolean);
    }
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
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.h(paramBoolean);
    }
    if (!paramBoolean)
    {
      this.jdField_d_of_type_JavaUtilList.clear();
      QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
      if (localQimMusicPlayer != null) {
        localQimMusicPlayer.a(localQimMusicPlayer.b(), true, 0);
      }
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController != null) {
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.f(paramBoolean);
    }
  }
  
  public void j() {}
  
  public void j(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!l)
    {
      l = true;
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new ansn(this));
      return;
    }
    this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().runOnUiThread(new anso(this));
  }
  
  public void k(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new anrp(this, paramBoolean));
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
    while ((this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.a()) || (b()) || (this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.d())) {
      return;
    }
    J();
    K();
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.e()) {
      a(null, null);
    }
    if (this.t) {
      return true;
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void q()
  {
    super.q();
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a();
    if (this.t)
    {
      if (this.s)
      {
        this.jdField_e_of_type_Boolean = true;
        O();
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView != null) && (this.u)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.d();
      }
    }
  }
  
  protected void r()
  {
    super.r();
    if (this.jdField_d_of_type_JavaUtilList.size() > 0) {
      this.jdField_d_of_type_JavaUtilList.remove(this.jdField_d_of_type_JavaUtilList.size() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureDelete, segmentMusicTimePoints size = " + this.jdField_d_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.s();
  }
  
  public void t()
  {
    super.t();
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_d_of_type_JavaUtilList.size() <= 0) {
        break label82;
      }
      this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.i(true);
      QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
      if (localQimMusicPlayer != null)
      {
        localQimMusicPlayer.c(((Integer)this.jdField_d_of_type_JavaUtilList.get(this.jdField_d_of_type_JavaUtilList.size() - 1)).intValue());
        localQimMusicPlayer.c();
      }
    }
    return;
    label82:
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.q();
  }
  
  public void u()
  {
    super.u();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.i(false);
    QimMusicPlayer localQimMusicPlayer;
    if (this.jdField_b_of_type_Boolean)
    {
      localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
      if (localQimMusicPlayer != null)
      {
        int i1 = localQimMusicPlayer.a();
        if (i1 < 0) {
          break label103;
        }
        this.jdField_d_of_type_JavaUtilList.add(Integer.valueOf(i1));
      }
    }
    for (;;)
    {
      localQimMusicPlayer.d();
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onCaptureButtonVideoStop, segmentMusicTimePoints size = " + this.jdField_d_of_type_JavaUtilList.size());
      }
      return;
      label103:
      if (this.jdField_d_of_type_JavaUtilList.size() > 0) {
        this.jdField_d_of_type_JavaUtilList.add(this.jdField_d_of_type_JavaUtilList.get(this.jdField_d_of_type_JavaUtilList.size() - 1));
      } else {
        this.jdField_d_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
    }
  }
  
  protected void x()
  {
    super.x();
    this.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.s();
    if (this.jdField_d_of_type_JavaUtilList.size() > 0) {
      this.jdField_d_of_type_JavaUtilList.remove(this.jdField_d_of_type_JavaUtilList.size() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureError, segmentMusicTimePoints size = " + this.jdField_d_of_type_JavaUtilList.size());
    }
  }
  
  protected void z()
  {
    super.z();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */