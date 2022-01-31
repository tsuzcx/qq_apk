package com.tencent.mobileqq.richmedia.capture.fragment;

import ahir;
import ahis;
import ahit;
import ahiu;
import ahiv;
import ahiw;
import ahix;
import ahiy;
import ahiz;
import ahja;
import ahjb;
import ahjc;
import ahjd;
import ahje;
import ahjf;
import ahjg;
import ahjh;
import ahji;
import ahjj;
import ahjk;
import ahjl;
import ahjm;
import ahjn;
import ahjo;
import ahjp;
import ahjs;
import ahjw;
import ahjy;
import ahjz;
import ahka;
import ahkb;
import ahkc;
import ahkd;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgTranslator;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.richmedia.subtitles.AnimDrawerFactory;
import com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraProviderViewGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraViewPagerGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.EffectsListenerController;
import com.tencent.mobileqq.richmedia.capture.util.ReportBadCase;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager.OnViewPageListener;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.EffectListener;
import com.tencent.mobileqq.richmedia.capture.view.GuideVideoView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.ContainerViewListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@TargetApi(9)
public abstract class EffectsCameraCaptureFragment
  extends CameraCaptureFragment
  implements CaptureVideoFilterViewPager.OnViewPageListener, EffectsCameraCaptureView.EffectListener, QQDanceEventHandler
{
  private static boolean i = true;
  private int jdField_a_of_type_Int = -1;
  private final ahkd jdField_a_of_type_Ahkd = new ahkd(this, null);
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public AlphaAnimation a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new ahiu(this);
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private SubtitleLayout jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout;
  private EffectsCameraCaptureFragment.DanceGLGestureListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment$DanceGLGestureListener = new EffectsCameraCaptureFragment.DanceGLGestureListener();
  private CameraProviderViewGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture;
  private CameraViewPagerGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture;
  EffectsListenerController jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilEffectsListenerController;
  private CaptureVideoFilterViewPager jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager;
  public EffectsCameraCaptureView a;
  private GuideVideoView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView;
  private ProviderContainerView.ContainerViewListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener;
  public ProviderContainerView a;
  public PtvTemplateManager.PtvTemplateInfo a;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public int b;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  public AlphaAnimation b;
  private Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new ahiw(this);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private ProviderContainerView.ContainerViewListener jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener;
  String jdField_b_of_type_JavaLangString = "";
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private ObjectAnimator jdField_c_of_type_AndroidAnimationObjectAnimator;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public String c;
  protected boolean c;
  private int jdField_d_of_type_Int;
  private ObjectAnimator jdField_d_of_type_AndroidAnimationObjectAnimator;
  public View d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  public boolean d;
  private TextView e;
  protected String e;
  public boolean e;
  private TextView f;
  public boolean f;
  private TextView g;
  public boolean g;
  private TextView h;
  public volatile boolean h;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p = true;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  
  public EffectsCameraCaptureFragment()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidOsHandler = new ahit(this, Looper.getMainLooper());
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_h_of_type_AndroidWidgetTextView.setText("准备进入视频回放.");
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.jdField_h_of_type_AndroidWidgetTextView.setText("准备进入视频回放..");
        return;
      }
    } while (paramInt != 2);
    this.jdField_h_of_type_AndroidWidgetTextView.setText("准备进入视频回放...");
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (this.q)
    {
      if (!this.r) {
        o();
      }
      return;
    }
    int i2;
    label46:
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.a()) && (this.p))
    {
      i2 = 1;
      if ((!paramBoolean1) || (paramBoolean3)) {
        break label118;
      }
      i1 = 0;
    }
    for (;;)
    {
      if (i1 == 0)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        if ((paramBoolean1) && (!paramBoolean2))
        {
          if (i2 != 0)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
            i2 = 0;
            break label46;
            label118:
            if ((!paramBoolean1) && (paramBoolean3))
            {
              i1 = 1;
              continue;
            }
            if ((!paramBoolean1) || (!paramBoolean3)) {
              break label654;
            }
            i1 = 2;
            continue;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(2131438168);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        if ((paramBoolean1) && (paramBoolean2))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          String str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.b();
          if (TextUtils.isEmpty(str)) {
            break;
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setText(str);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          g(false);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if (i1 == 1)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        if ((paramBoolean3) && (!paramBoolean4))
        {
          if (i2 != 0)
          {
            this.jdField_d_of_type_AndroidViewView.setVisibility(8);
            return;
          }
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = GestureRecognitionUtils.a(getActivity(), GestureFilterManager.a);
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(GestureFilterManager.jdField_b_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        if ((!paramBoolean3) || (!paramBoolean4)) {
          break;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      if (i1 != 2) {
        break;
      }
      if (paramBoolean4)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if ((!paramBoolean4) && (paramBoolean2))
      {
        if (i2 != 0) {
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = GestureRecognitionUtils.a(getActivity(), GestureFilterManager.a);
          this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(GestureFilterManager.jdField_b_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        }
      }
      if ((paramBoolean4) || (paramBoolean2)) {
        break;
      }
      if (i2 != 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131438168);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label654:
      i1 = 0;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1000, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 2000L);
  }
  
  private void h(boolean paramBoolean)
  {
    int i1;
    ObjectAnimator localObjectAnimator;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        break label130;
      }
      if (this.jdField_c_of_type_Int != 1) {
        break label102;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a()) {
        break label92;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      i1 = DisplayUtils.a(98.0F);
      this.jdField_c_of_type_Int = 2;
      localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationX", new float[] { this.jdField_a_of_type_AndroidWidgetImageView.getTranslationX(), i1 });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
    label92:
    label102:
    label239:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_c_of_type_Int = 3;
          i1 = 0;
          break;
        } while ((this.jdField_c_of_type_Int != 3) || (this.jdField_d_of_type_AndroidAnimationObjectAnimator == null));
        this.jdField_d_of_type_AndroidAnimationObjectAnimator.start();
        this.jdField_c_of_type_Int = 2;
        return;
        if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a()) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.getVisibility() != 0)) {
          break label239;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_c_of_type_Int == 0)
        {
          localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, DisplayUtils.a(-154.0F) });
          localObjectAnimator.setDuration(500L);
          localObjectAnimator.start();
          this.jdField_c_of_type_Int = 1;
          return;
        }
      } while ((this.jdField_c_of_type_Int != 2) || (this.jdField_c_of_type_AndroidAnimationObjectAnimator == null));
      this.jdField_c_of_type_AndroidAnimationObjectAnimator.start();
      this.jdField_c_of_type_Int = 3;
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    } while ((this.jdField_c_of_type_Int != 3) || (this.jdField_d_of_type_AndroidAnimationObjectAnimator == null));
    label130:
    this.jdField_d_of_type_AndroidAnimationObjectAnimator.start();
    this.jdField_c_of_type_Int = 2;
  }
  
  private void n()
  {
    if (!this.q) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.a()) && (this.p)) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      if (i1 == 0) {
        break;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    o();
  }
  
  private void o()
  {
    this.r = true;
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131439128);
    g(true);
  }
  
  private void p()
  {
    if (!this.u)
    {
      if (this.t)
      {
        k();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
        this.t = false;
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Ahkd);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.g();
  }
  
  private void q()
  {
    if (this.u) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "now showDGVideoGuide and animation,  mGuideVideoView : " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView = new GuideVideoView(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCloseListener(new ahjd(this));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCompleteListener(new ahje(this));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnErrorListener(new ahjf(this));
    }
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.startAnimation(localScaleAnimation);
    this.u = true;
  }
  
  private void r()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ahjg(this));
  }
  
  private void s()
  {
    this.s = false;
    d();
  }
  
  private void t()
  {
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    int i1 = DisplayUtils.a(47.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, i1);
    localLayoutParams.topMargin = DisplayUtils.a(110.0F);
    localLayoutParams.rightMargin = DisplayUtils.a(40.0F);
    localLayoutParams.addRule(11, -1);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843244);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ahjh(this));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  private void u()
  {
    this.jdField_h_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    int i1 = DisplayUtils.a(160.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = i1;
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_h_of_type_AndroidWidgetTextView.setText("准备进入视频回放.");
    this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(15.0F);
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_h_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370029));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370030));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370031));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
      this.jdField_b_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 1.0F, 0.0F });
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new ahji(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ahjj(this));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.setTriggerLisener(new ahjk(this));
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.removeAllListeners();
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.removeAllListeners();
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.cancel();
    }
  }
  
  private void x()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!this.jdField_c_of_type_Boolean)) {
      return;
    }
    ThreadManager.getUIHandler().post(new ahjp(this));
  }
  
  private void y()
  {
    if (a() == 10001) {}
    RecentDanceConfigMgr.DItemInfo localDItemInfo;
    do
    {
      do
      {
        return;
      } while ((!RecentDanceConfigMgr.b()) || (!RecentDanceConfigMgr.a(this.jdField_a_of_type_AndroidViewViewGroup.getContext())));
      localDItemInfo = RecentDanceConfigMgr.b();
    } while (localDItemInfo == null);
    ThreadManager.getUIHandler().post(new ahjs(this, localDItemInfo));
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView = null;
    }
  }
  
  public void A_()
  {
    super.A_();
    if (this.jdField_a_of_type_Long != -1L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      NewFlowCameraReporter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), l1 - l2, a() + "", i);
      i = false;
    }
  }
  
  public abstract int a();
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ahja(this, paramString1, paramInt, paramString2));
    DanceGameVideoManager.a().a(paramInt);
  }
  
  public void a(long paramLong) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (RedBagVideoManager.a(a()))
    {
      localPtvTemplateInfo = CapturePtvTemplateManager.a().a();
      if ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.funcType != PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET)) {
        break label49;
      }
      paramLocalMediaInfo.redBagType = LocalMediaInfo.REDBAG_TYPE_GET;
      QLog.d("CameraCaptureFragment", 1, "VideoRedbag, onVideoCaptured, LocalMediaInfo take redbag flag ");
    }
    label49:
    do
    {
      do
      {
        return;
      } while ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.kind != 3));
      paramLocalMediaInfo.specialVideoType = 2;
    } while (!QLog.isColorLevel());
    QLog.d("CameraCaptureFragment", 2, "checkMediaInfoPreJump specialVideoType dancegame!");
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    if ((paramFilterCategoryItem != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFilter(paramFilterCategoryItem);
    }
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    super.a(paramPhotoCaptureResult);
    i();
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    super.a(paramVideoCaptureResult);
    if (paramVideoCaptureResult.videoFrameCount < this.jdField_b_of_type_Long)
    {
      ThreadManager.getUIHandler().post(new ahkc(this));
      AudioTranslator.a().b();
      return;
    }
    ThreadManager.getUIHandler().post(new ahis(this));
  }
  
  public void a(BoyDataReport paramBoyDataReport)
  {
    DanceLog.a("EffectsFragment", "playSceneEndEvent...");
    this.jdField_a_of_type_AndroidOsHandler.post(new ahiz(this));
    CaptureReportUtil.a(paramBoyDataReport);
  }
  
  public void a(QQVideoMaterial paramQQVideoMaterial)
  {
    x();
    if (paramQQVideoMaterial == null) {
      return;
    }
    if (paramQQVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.AR_PARTICLE.value) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = paramQQVideoMaterial.b();
      if (((this.jdField_h_of_type_Boolean) && (bool1)) || ((!this.jdField_h_of_type_Boolean) && (!bool1))) {
        break;
      }
      ThreadManager.getUIHandler().post(new ahka(this, bool1, bool2));
      return;
    }
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    int i1 = paramString.getInt("sv_beauty_level", 3);
    int i2 = EffectsListenerController.a[i1];
    if (QLog.isColorLevel()) {
      QLog.d("sv_beauty_level", 2, "beauty level : " + paramString.getInt("sv_beauty_level", 888));
    }
    if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a() != 1) {
        break label134;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(i1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(i2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a();
      return;
      label134:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(0.0F);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(EffectsListenerController.a[0]);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ThreadManager.getUIHandler().post(new ahjy(this, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4));
  }
  
  public boolean a(boolean paramBoolean, String paramString)
  {
    this.t = paramBoolean;
    int i1;
    label141:
    Object localObject1;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(true);
        f();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        }
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() == 2)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.i();
        }
        if (!paramBoolean) {
          break label358;
        }
        i1 = 4;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager;
        if (paramBoolean) {
          break label363;
        }
        bool = true;
        label154:
        ((CaptureVideoFilterViewPager)localObject1).setEnabled(bool);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.setVisibility(i1);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label843;
      }
      if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get(paramString)))) {
        break label369;
      }
      this.jdField_e_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureFragment", 2, "has parsed shareWebUrl : " + this.jdField_e_of_type_JavaLangString);
      }
      label258:
      if (!this.u) {
        break label506;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "DGVideoGuide is showing, now start ");
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.h();
      paramBoolean = false;
    }
    for (;;)
    {
      for (;;)
      {
        if (this.u) {
          break label824;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
        return paramBoolean;
        z_();
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
        if (!DanceGameVideoManager.a().c()) {
          break;
        }
        a(CaptureVideoFilterManager.a().a());
        break;
        label358:
        i1 = 0;
        break label141;
        label363:
        bool = false;
        break label154;
        try
        {
          label369:
          localObject1 = new JSONObject(ResourceManager.a(paramString + "params.json")).getJSONObject("postureParam");
          this.jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).getString("shareWebUrl");
          localObject1 = ((JSONObject)localObject1).getString("guideVideoUrl");
          this.jdField_a_of_type_JavaUtilMap.put(paramString, this.jdField_e_of_type_JavaLangString);
          this.jdField_b_of_type_JavaUtilMap.put(paramString, localObject1);
          if (!QLog.isColorLevel()) {
            break label258;
          }
          QLog.d("CameraCaptureFragment", 2, "has not parsed shareWebUrl, now parse  ; " + this.jdField_e_of_type_JavaLangString);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      label506:
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if (a() != 10007)
      {
        paramBoolean = localSharedPreferences.getBoolean("hasShowDGVideoGuide", false);
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasShowDGVideoGuide : " + paramBoolean);
        }
        Object localObject2 = CapturePtvTemplateManager.a().a();
        if ((!paramBoolean) && (((PtvTemplateManager.PtvTemplateInfo)localObject2).kind != 4) && (getActivity() != null))
        {
          q();
          if ((this.jdField_b_of_type_JavaUtilMap.containsKey(paramString)) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilMap.get(paramString))))
          {
            localObject2 = (String)this.jdField_b_of_type_JavaUtilMap.get(paramString);
            paramString = (String)localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("CameraCaptureFragment", 2, "has parsed guideVideoUrl : " + (String)localObject2);
              paramString = (String)localObject2;
            }
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(paramString)) {
              this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.a(paramString);
            }
            this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.a();
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
        }
      }
      else
      {
        localSharedPreferences.edit().putBoolean("hasShowDGVideoGuide", true).commit();
      }
      paramBoolean = true;
    }
    label824:
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
    return paramBoolean;
    label843:
    return true;
  }
  
  public byte[] a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureFragment", 2, "getSubtitleData ,clear: " + paramBoolean);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.a())
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.b()) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.a();
        }
      }
    }
    if (localObject1 == null) {
      SubtitleDataManager.a().jdField_c_of_type_Int = 0;
    }
    for (;;)
    {
      if (paramBoolean) {
        i();
      }
      return localObject1;
      if (localObject1.length > 4)
      {
        int i1 = DoodleMsgTranslator.a((byte[])localObject1, 0);
        SubtitleDataManager.a().jdField_c_of_type_Int = AnimDrawerFactory.a(i1);
      }
    }
  }
  
  public void aj_()
  {
    super.aj_();
    ThreadManager.getUIHandler().post(new ahkb(this));
  }
  
  public int b()
  {
    return 2130970314;
  }
  
  public void c(long paramLong)
  {
    DanceLog.a("EffectsFragment", "readySceneBegin...");
    this.jdField_a_of_type_AndroidOsHandler.post(new ahix(this));
    ThreadManager.post(new ahiy(this, paramLong), 8, null, false);
  }
  
  public void c(boolean paramBoolean)
  {
    this.q = paramBoolean;
    this.r = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    n();
  }
  
  protected boolean c()
  {
    return true;
  }
  
  public void d(boolean paramBoolean) {}
  
  public boolean d()
  {
    return this.t;
  }
  
  public void d_(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new ahjw(this));
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.d();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    int i1 = localSharedPreferences.getInt("sv_beauty_level", 3);
    if (QLog.isColorLevel()) {
      QLog.d("sv_beauty_level", 2, "beauty level : " + localSharedPreferences.getInt("sv_beauty_level", 888));
    }
    int i2 = EffectsListenerController.a[i1];
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(i1);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(i2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(EffectsListenerController.a[0]);
  }
  
  public void e(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new ahjz(this, paramBoolean));
  }
  
  public boolean e()
  {
    if (!this.u)
    {
      if (this.t)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.x();
        return true;
      }
    }
    else
    {
      r();
      return true;
    }
    return false;
  }
  
  protected void f()
  {
    super.f();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.setVisibility(8);
    h(false);
  }
  
  public void f(boolean paramBoolean)
  {
    DanceLog.a("EffectsFragment", "closeEvent");
    this.jdField_a_of_type_AndroidOsHandler.post(new ahjb(this, paramBoolean));
  }
  
  public void h()
  {
    super.h();
    if (this.q)
    {
      this.q = false;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.v();
    }
  }
  
  public void i()
  {
    ThreadManager.getUIHandler().post(new ahiv(this));
  }
  
  public void j()
  {
    if (!GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment$DanceGLGestureListener)) {
      GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment$DanceGLGestureListener);
    }
  }
  
  public void k()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = CapturePtvTemplateManager.a().a();
    if (localPtvTemplateInfo != null)
    {
      int i1 = localPtvTemplateInfo.categoryId;
      CapturePtvTemplateManager.a().a(null);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(102, i1, "");
    }
    GLGestureProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentEffectsCameraCaptureFragment$DanceGLGestureListener);
  }
  
  public void l()
  {
    w();
    if (!this.j) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { UIUtils.a(getActivity(), 80.0F), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new ahjl(this));
    localObjectAnimator2.addListener(new ahjm(this));
    localObjectAnimator1.setDuration(60L);
    localObjectAnimator2.setDuration(200L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.setStartDelay(240L);
    localAnimatorSet.start();
  }
  
  public void m()
  {
    w();
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (this.k)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (!this.j) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { 0.0F, UIUtils.a(getActivity(), 80.0F) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 1.0F, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.addListener(new ahjo(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    paramInt1 = a();
    if ((paramInt1 == 10001) || (paramInt1 == 10002))
    {
      if (paramInt2 != -1) {
        break label56;
      }
      ReportBadCase.a(getActivity().getAppInterface());
    }
    for (;;)
    {
      if ((paramInt1 == 10007) && (paramInt2 == 0)) {
        ReportBadCase.a();
      }
      return;
      label56:
      if (paramInt2 == 0) {
        ReportBadCase.a();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    LbsFilterStatusManager.a = getActivity().getAppInterface();
    LbsFilterStatusManager.a(getActivity().getAppInterface());
    ThreadManager.postImmediately(new ahir(this), null, true);
    CapturePtvTemplateManager.a();
    CapturePtvTemplateManager.jdField_a_of_type_Int = a();
    CaptureReportUtil.m();
    CaptureReportUtil.jdField_e_of_type_Boolean = true;
    CaptureReportUtil.jdField_a_of_type_Int = a();
    CaptureReportUtil.a();
    CaptureUtil.b = false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilEffectsListenerController = new EffectsListenerController(((PeakFragmentActivity)getActivity()).getAppInterface(), this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager = ((CaptureVideoFilterViewPager)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368994));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.a(this);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffectListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setDanceFilterEventHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView = ((ProviderContainerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368982));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.setListenerController(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilEffectsListenerController);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.setNeedAdvertisement(c());
    int i1;
    boolean bool1;
    if ((CaptureUtil.f()) && (PtvFilterSoLoad.b()))
    {
      i1 = 1;
      boolean bool3 = PtvFilterSoLoad.b();
      boolean bool4 = CaptureVideoFilterManager.a(getActivity());
      boolean bool2 = SubtitleDataManager.a().a();
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView;
      if ((!this.jdField_d_of_type_Boolean) || (i1 == 0)) {
        break label765;
      }
      bool1 = true;
      label204:
      paramLayoutInflater.setBeautyEnable(bool1);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView;
      if ((!this.jdField_e_of_type_Boolean) || (!bool4)) {
        break label771;
      }
      bool1 = true;
      label230:
      paramLayoutInflater.setFilterEnable(bool1);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView;
      if ((!this.jdField_f_of_type_Boolean) || (!bool3)) {
        break label777;
      }
      bool1 = true;
      label256:
      paramLayoutInflater.setFaceEffectEnable(bool1);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView;
      if ((!this.jdField_g_of_type_Boolean) || (!bool2)) {
        break label783;
      }
      bool1 = true;
      label282:
      paramLayoutInflater.setSubtitleEnable(bool1);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.jdField_d_of_type_Boolean) || (i1 == 0)) {
        break label789;
      }
      bool1 = true;
      label308:
      paramLayoutInflater.setBeautyEnable(bool1);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.jdField_e_of_type_Boolean) || (!bool4)) {
        break label795;
      }
      bool1 = true;
      label334:
      paramLayoutInflater.setFilterEnable(bool1);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.jdField_f_of_type_Boolean) || (!bool3)) {
        break label801;
      }
      bool1 = true;
      label360:
      paramLayoutInflater.setFaceEffectEnable(bool1);
      i1 = a();
      if ((i1 != 10007) && (i1 != 10001) && (i1 != 10002)) {
        break label807;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setEnableBadCaseReport(true);
      label404:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.b();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370033));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368985));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370032));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370034);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370035);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370036));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370037));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368986));
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout = ((SubtitleLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370028));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.a(0);
      }
      if ((!this.jdField_g_of_type_Boolean) || (!bool2) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout == null)) {
        break label818;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener = new ahjc(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1000L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture = new CameraProviderViewGesture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture = new CameraViewPagerGesture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager);
      GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraProviderViewGesture);
      GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraViewPagerGesture);
      t();
      u();
      v();
      ThreadManager.post(new ahjn(this), 5, null, true);
      return this.jdField_a_of_type_AndroidViewViewGroup;
      i1 = 0;
      break;
      label765:
      bool1 = false;
      break label204;
      label771:
      bool1 = false;
      break label230;
      label777:
      bool1 = false;
      break label256;
      label783:
      bool1 = false;
      break label282;
      label789:
      bool1 = false;
      break label308;
      label795:
      bool1 = false;
      break label334;
      label801:
      bool1 = false;
      break label360;
      label807:
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setEnableBadCaseReport(false);
      break label404;
      label818:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.setVisibility(8);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    LbsFilterStatusManager.c();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a();
    }
    CaptureReportUtil.m();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.b();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    CapturePtvTemplateManager.a();
    CapturePtvTemplateManager.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.f();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.b(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener);
    }
    z();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.e();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.c();
    }
    if (this.t)
    {
      if (this.s)
      {
        this.jdField_a_of_type_Boolean = true;
        s();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView != null) && (this.u)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewGuideVideoView.f();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.g();
    p();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesSubtitleLayout.d();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.f();
    GestureRecognitionUtils.a.clear();
    ReportUtil.g();
    ImageMemoryManager.getInstance().clear();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  protected void z_()
  {
    super.z_();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.setVisibility(0);
    h(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */