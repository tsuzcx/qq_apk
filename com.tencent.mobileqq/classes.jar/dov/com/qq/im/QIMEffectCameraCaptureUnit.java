package dov.com.qq.im;

import aepi;
import alud;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axpa;
import axpd;
import axpe;
import axpl;
import axpm;
import axpx;
import axqq;
import axqw;
import axrk;
import axrm;
import azgd;
import azjh;
import azki;
import azkt;
import azqs;
import bkms;
import bknb;
import bknc;
import bknd;
import bkne;
import bknf;
import bkng;
import bknh;
import bkni;
import bknj;
import bknk;
import bkob;
import bkoh;
import blqi;
import blqk;
import blqr;
import blra;
import blro;
import blrx;
import blsz;
import blua;
import blvi;
import blyz;
import blza;
import bmar;
import bmau;
import bmbh;
import bmgz;
import bmhg;
import bmhh;
import bmhu;
import bmzn;
import bnfq;
import bnhb;
import bnhe;
import bnhg;
import bniy;
import bnlr;
import bnmb;
import bnpl;
import bnrp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.richmedia.capture.view.GuideVideoView;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wxj;
import xsm;

@TargetApi(9)
public abstract class QIMEffectCameraCaptureUnit
  extends bkms
  implements axqq, axrk, axrm, bmbh, bnhe, bnhg, bnlr, bnmb, QQDanceEventHandler
{
  private static boolean C = true;
  public static boolean w;
  public static boolean x;
  private boolean A;
  private boolean B;
  private boolean D = true;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private boolean I;
  private boolean J = true;
  private boolean K;
  private boolean L;
  private boolean M;
  private boolean N;
  private boolean O;
  private boolean P;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  protected Bundle a;
  public Handler a;
  public AlphaAnimation a;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new bknc(this);
  protected axpa a;
  protected axpd a;
  protected axpe a;
  protected blqk a;
  public EffectsCameraCaptureView a;
  public RedDotImageView a;
  private final QIMEffectCameraCaptureUnit.ReplayTips jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit$ReplayTips = new QIMEffectCameraCaptureUnit.ReplayTips(this, null);
  QIMFilterCategoryItem jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = null;
  private ProviderViewEditContainer jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer;
  public QIMProviderContainerView a;
  public VideoFilterViewPager a;
  private GuideVideoView jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView;
  public Runnable a;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  protected ViewGroup b;
  public AlphaAnimation b;
  private Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new bknd(this);
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  protected TextView b;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  protected int c;
  public AlphaAnimation c;
  private Animation.AnimationListener jdField_c_of_type_AndroidViewAnimationAnimation$AnimationListener = new bkne(this);
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected String c;
  protected List<Integer> c;
  private int jdField_d_of_type_Int = -1;
  protected View d;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  protected String d;
  private int jdField_e_of_type_Int = 0;
  protected View e;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  protected String e;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  protected String f;
  private int jdField_g_of_type_Int = 50;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  protected String g;
  private int jdField_h_of_type_Int;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  protected String h;
  private TextView i;
  protected String i;
  protected String j;
  protected String k;
  public boolean o = true;
  public boolean p = true;
  public boolean q = true;
  public boolean r = true;
  public boolean s = true;
  public boolean t = true;
  public boolean u = true;
  public volatile boolean v;
  private boolean y;
  private boolean z;
  
  public QIMEffectCameraCaptureUnit(bmhh parambmhh, bmhg parambmhg)
  {
    super(parambmhh, parambmhg);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new bknf(this, Looper.getMainLooper());
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    ae();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.jdField_b_of_type_JavaLangRunnable = new QIMEffectCameraCaptureUnit.13(this);
    this.jdField_a_of_type_AndroidOsHandler.post(new QIMEffectCameraCaptureUnit.14(this, paramLazyLoadAnimationDrawable));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(null);
      this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.cancel();
      this.jdField_h_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.reset();
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setStartOffset(2000L);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
    this.jdField_h_of_type_AndroidWidgetTextView.setAnimation(this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.startNow();
  }
  
  private void ac()
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText("");
    this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void ad()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView = null;
    }
  }
  
  private void ae()
  {
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new QIMEffectCameraCaptureUnit.15(this));
  }
  
  private void af()
  {
    if (this.N) {
      return;
    }
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "now showDGVideoGuide and animation,  mGuideVideoView : " + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView == null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView = a(this.jdField_a_of_type_Bmhh.a(), ThreadManager.getUIHandler());
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCloseListener(new bknh(this));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCompleteListener(new bkni(this));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnErrorListener(new bknj(this));
    }
    Object localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView;
    ((ViewGroup)localObject).removeView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    ((ViewGroup)localObject).addView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setEnabled(false);
    localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(500L);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.clearAnimation();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.startAnimation((Animation)localObject);
    this.N = true;
  }
  
  private void ag()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QIMEffectCameraCaptureUnit.28(this));
  }
  
  private void ah()
  {
    this.L = false;
    k();
  }
  
  private void ai()
  {
    this.jdField_f_of_type_AndroidWidgetImageView = new ImageView(this.jdField_b_of_type_AndroidViewViewGroup.getContext());
    int m = DisplayUtils.pixelToRealPixel(47.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(m, m);
    localLayoutParams.topMargin = DisplayUtils.pixelToRealPixel(110.0F);
    localLayoutParams.rightMargin = DisplayUtils.pixelToRealPixel(40.0F);
    localLayoutParams.addRule(11, -1);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130845589);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(new bknk(this));
    if (h())
    {
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_f_of_type_AndroidWidgetImageView, localLayoutParams);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_f_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  private void aj()
  {
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131364977));
  }
  
  private void ak()
  {
    if (!this.O) {
      return;
    }
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a()) && (this.J)) {}
    for (int m = 1;; m = 0)
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (m == 0) {
        break;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    al();
  }
  
  private void al()
  {
    this.P = true;
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131720151);
    q(true);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.jdField_a_of_type_Boolean = true;
    this.y = paramBoolean1;
    this.z = paramBoolean2;
    this.A = paramBoolean3;
    this.B = paramBoolean4;
    if (this.O)
    {
      if (!this.P) {
        al();
      }
      return;
    }
    int n;
    label72:
    boolean bool;
    label98:
    int m;
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.a()) && (this.J))
    {
      n = 1;
      bool = paramBoolean1;
      if (paramBoolean1)
      {
        if ((!e()) || (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.h())) {
          break label172;
        }
        paramBoolean1 = true;
        bool = paramBoolean1;
      }
      if ((!bool) || (paramBoolean3)) {
        break label177;
      }
      m = 0;
    }
    for (;;)
    {
      a(null, false);
      if (m == 0)
      {
        if ((bool) && (!paramBoolean2))
        {
          if (n != 0)
          {
            this.jdField_f_of_type_AndroidViewView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
            n = 0;
            break label72;
            label172:
            paramBoolean1 = false;
            break label98;
            label177:
            if ((!bool) && (paramBoolean3))
            {
              m = 1;
              continue;
            }
            if ((!bool) || (!paramBoolean3)) {
              break label532;
            }
            m = 2;
            continue;
          }
          this.jdField_f_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692712);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          return;
        }
        if ((bool) && (paramBoolean2))
        {
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          String str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.b();
          if ((TextUtils.isEmpty(str)) || (this.E)) {
            break;
          }
          this.E = true;
          a(str, true);
          return;
        }
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if (m == 1)
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if (m != 2) {
        break;
      }
      if (paramBoolean4)
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if ((!paramBoolean4) && (paramBoolean2))
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      if ((paramBoolean4) || (paramBoolean2)) {
        break;
      }
      if (n != 0)
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692712);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label532:
      m = 0;
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(alud.a(2131710178));
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(alud.a(2131710176));
        return;
      }
    } while (paramInt != 2);
    this.jdField_i_of_type_AndroidWidgetTextView.setText(alud.a(2131710177));
  }
  
  private void o(boolean paramBoolean)
  {
    if ((this.D) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a()))
    {
      this.D = false;
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView);
    }
    ThreadManager.excute(new QIMEffectCameraCaptureUnit.3(this, paramBoolean), 64, null, true);
  }
  
  private void p(boolean paramBoolean)
  {
    int m;
    ObjectAnimator localObjectAnimator;
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean) {
        break label146;
      }
      if (this.jdField_e_of_type_Int != 1) {
        break label118;
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a()) {
        break label108;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "visible == false, Container opened operation invisible");
      }
      m = DisplayUtils.pixelToRealPixel(98.0F);
      this.jdField_e_of_type_Int = 2;
      localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "translationX", new float[] { this.jdField_c_of_type_AndroidWidgetImageView.getTranslationX(), m });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
    label108:
    label118:
    label255:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_e_of_type_Int = 3;
          m = 0;
          break;
        } while ((this.jdField_e_of_type_Int != 3) || (this.jdField_b_of_type_AndroidAnimationObjectAnimator == null));
        this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
        this.jdField_e_of_type_Int = 2;
        return;
        if ((!this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a()) || (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.getVisibility() != 0)) {
          break label255;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_e_of_type_Int == 0)
        {
          localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetImageView, "translationX", new float[] { 0.0F, DisplayUtils.pixelToRealPixel(-139.0F) });
          localObjectAnimator.setDuration(500L);
          localObjectAnimator.start();
          this.jdField_e_of_type_Int = 1;
          return;
        }
      } while ((this.jdField_e_of_type_Int != 2) || (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      this.jdField_e_of_type_Int = 3;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "visible == true, Container opened operation invisible");
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    } while ((this.jdField_e_of_type_Int != 3) || (this.jdField_b_of_type_AndroidAnimationObjectAnimator == null));
    label146:
    this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
    this.jdField_e_of_type_Int = 2;
  }
  
  private void q(boolean paramBoolean)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1000, Boolean.valueOf(paramBoolean));
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 2000L);
  }
  
  public void A()
  {
    super.A();
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      this.jdField_c_of_type_JavaUtilList.remove(this.jdField_c_of_type_JavaUtilList.size() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureDelete, segmentMusicTimePoints size = " + this.jdField_c_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_Blqk.w();
  }
  
  public void C()
  {
    super.C();
    this.jdField_a_of_type_Blqk.j();
  }
  
  public void J()
  {
    super.J();
    this.jdField_a_of_type_Blqk.w();
    if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
      this.jdField_c_of_type_JavaUtilList.remove(this.jdField_c_of_type_JavaUtilList.size() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureError, segmentMusicTimePoints size = " + this.jdField_c_of_type_JavaUtilList.size());
    }
  }
  
  public void L()
  {
    super.L();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.B();
  }
  
  public void M()
  {
    super.M();
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(4);
    }
  }
  
  public void N()
  {
    super.N();
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.getVisibility() != 0)) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
    }
  }
  
  public void T()
  {
    this.jdField_a_of_type_Blqk.f();
    super.T();
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setBottomTabParentLH(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCaptureControllerAndPreloadView(this.jdField_a_of_type_Blqk);
      if (this.N) {
        ag();
      }
      return;
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setBottomTabParentLH(null);
    }
  }
  
  public void U()
  {
    o(false);
  }
  
  protected void V()
  {
    int m = AdvancedProviderView.b();
    int n = AdvancedProviderView.c();
    if (QLog.isColorLevel()) {
      QLog.d("sv_beauty_level", 2, "initBeautyAndSharpFace beauty level : " + m + ", sharp level:" + n);
    }
    this.jdField_a_of_type_Blqk.b(m);
    blqk localblqk = this.jdField_a_of_type_Blqk;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.k) {}
    for (m = AdvancedProviderView.c();; m = -1)
    {
      localblqk.c(m);
      return;
    }
  }
  
  public void W() {}
  
  protected void X()
  {
    if (!this.N)
    {
      if (this.M)
      {
        ((bnpl)blqr.a(3)).a("0", blra.jdField_b_of_type_Int, "");
        blra.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Blqk.x();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
        this.M = false;
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit$ReplayTips);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      }
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.e();
  }
  
  @TargetApi(11)
  protected void Y()
  {
    if ((this.jdField_a_of_type_Bmhh == null) || (this.jdField_a_of_type_Bmhh.a() == null)) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = this.jdField_a_of_type_Bmhh.a().getIntent();
      } while (localObject1 == null);
      localObject1 = ((Intent)localObject1).getExtras();
    } while ((localObject1 == null) || (((Bundle)localObject1).getString("share_url_target_url") == null));
    Object localObject3;
    String str3;
    String str2;
    Object localObject2;
    String str1;
    Object localObject4;
    if (this.jdField_f_of_type_JavaLangString != null)
    {
      localObject3 = this.jdField_f_of_type_JavaLangString;
      str3 = this.jdField_g_of_type_JavaLangString;
      str2 = this.jdField_h_of_type_JavaLangString;
      localObject2 = this.jdField_i_of_type_JavaLangString;
      str1 = this.j;
      localObject1 = this.k;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initSharedLinkerView : url = ");
        if (localObject3 != null) {
          break label551;
        }
        localObject4 = "null";
        label127:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , name = ");
        if (str3 != null) {
          break label558;
        }
        localObject4 = "null";
        label152:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , text = ");
        if (str2 != null) {
          break label565;
        }
        localObject4 = "null";
        label177:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , thumUrl = ");
        if (localObject2 != null) {
          break label572;
        }
        localObject4 = "null";
        label201:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , sourceName = ");
        if (str1 != null) {
          break label578;
        }
        localObject4 = "null";
        label225:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , sourceIconUrl = ");
        if (localObject1 != null) {
          break label584;
        }
        localObject4 = "null";
        label249:
        QLog.d("QIMEffectCameraCaptureUnit", 2, (String)localObject4);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379675) != null) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379675));
        }
        localObject3 = new bmzn((String)localObject3);
        ((bmzn)localObject3).b = str3;
        ((bmzn)localObject3).jdField_c_of_type_JavaLangString = str2;
        ((bmzn)localObject3).jdField_d_of_type_JavaLangString = ((String)localObject2);
        localObject2 = new LinkerSummaryView(this.jdField_a_of_type_AndroidViewView.getContext());
        ((LinkerSummaryView)localObject2).setReadOnly();
        ((LinkerSummaryView)localObject2).b = str1;
        ((LinkerSummaryView)localObject2).a = ((String)localObject1);
        ((LinkerSummaryView)localObject2).setShowShare(true);
        ((LinkerSummaryView)localObject2).setLinkerObject((bmzn)localObject3);
        this.jdField_e_of_type_AndroidViewView = ((View)localObject2);
        ((LinkerSummaryView)localObject2).setId(2131379675);
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131372385);
        ((LinkerSummaryView)localObject2).setTranslationY(xsm.a(this.jdField_a_of_type_Bmhh.a(), 88.0F));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        wxj.a("video_shoot", "exp_linkbar", 0, 0, new String[] { "", "", "", "" });
        if (this.jdField_b_of_type_Int != 7) {
          break label590;
        }
        this.jdField_e_of_type_AndroidViewView.setVisibility(4);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.g();
      return;
      localObject3 = ((Bundle)localObject1).getString("share_url_target_url");
      str3 = ((Bundle)localObject1).getString("share_url_name");
      str2 = ((Bundle)localObject1).getString("share_url_text");
      localObject2 = ((Bundle)localObject1).getString("share_url_thumb_url");
      str1 = ((Bundle)localObject1).getString("struct_share_key_source_name");
      localObject1 = ((Bundle)localObject1).getString("struct_share_key_source_icon");
      break;
      label551:
      localObject4 = localObject3;
      break label127;
      label558:
      localObject4 = str3;
      break label152;
      label565:
      localObject4 = str2;
      break label177;
      label572:
      localObject4 = localObject2;
      break label201;
      label578:
      localObject4 = str1;
      break label225;
      label584:
      localObject4 = localObject1;
      break label249;
      label590:
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  @TargetApi(11)
  protected void Z()
  {
    if ((this.jdField_a_of_type_Bmhh == null) || (this.jdField_a_of_type_Bmhh.a() == null)) {}
    String str3;
    String str2;
    String str1;
    Object localObject4;
    label127:
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = this.jdField_a_of_type_Bmhh.a().getIntent();
        } while (localObject1 == null);
        localObject1 = ((Intent)localObject1).getExtras();
      } while ((localObject1 == null) || (((Bundle)localObject1).getString("share_url_target_url") == null));
      if (this.jdField_f_of_type_JavaLangString == null) {
        break;
      }
      localObject3 = this.jdField_f_of_type_JavaLangString;
      str3 = this.jdField_g_of_type_JavaLangString;
      str2 = this.jdField_h_of_type_JavaLangString;
      localObject2 = this.jdField_i_of_type_JavaLangString;
      str1 = this.j;
      localObject1 = this.k;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("updateSharedLinkerView : url = ");
        if (localObject3 != null) {
          break label512;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , name = ");
        if (str3 != null) {
          break label519;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , text = ");
        if (str2 != null) {
          break label526;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , thumUrl = ");
        if (localObject2 != null) {
          break label533;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , sourceName = ");
        if (str1 != null) {
          break label539;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , sourceIconUrl = ");
        if (localObject1 != null) {
          break label545;
        }
        localObject4 = "null";
        QLog.d("QIMEffectCameraCaptureUnit", 2, (String)localObject4);
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
    label152:
    label177:
    label201:
    label225:
    label249:
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379675) != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379675));
    }
    Object localObject3 = new bmzn((String)localObject3);
    ((bmzn)localObject3).b = str3;
    ((bmzn)localObject3).jdField_c_of_type_JavaLangString = str2;
    ((bmzn)localObject3).jdField_d_of_type_JavaLangString = ((String)localObject2);
    Object localObject2 = new LinkerSummaryView(this.jdField_a_of_type_AndroidViewView.getContext());
    ((LinkerSummaryView)localObject2).setReadOnly();
    ((LinkerSummaryView)localObject2).b = str1;
    ((LinkerSummaryView)localObject2).a = ((String)localObject1);
    ((LinkerSummaryView)localObject2).setShowShare(true);
    ((LinkerSummaryView)localObject2).setLinkerObject((bmzn)localObject3);
    this.jdField_e_of_type_AndroidViewView = ((View)localObject2);
    ((LinkerSummaryView)localObject2).setId(2131379675);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131372385);
    ((LinkerSummaryView)localObject2).setTranslationY(xsm.a(this.jdField_a_of_type_Bmhh.a(), 88.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    if (this.jdField_b_of_type_Int == 7) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.g();
      return;
      localObject3 = ((Bundle)localObject1).getString("share_url_target_url");
      str3 = ((Bundle)localObject1).getString("share_url_name");
      str2 = ((Bundle)localObject1).getString("share_url_text");
      localObject2 = ((Bundle)localObject1).getString("share_url_thumb_url");
      str1 = ((Bundle)localObject1).getString("struct_share_key_source_name");
      localObject1 = ((Bundle)localObject1).getString("struct_share_key_source_icon");
      break;
      label512:
      localObject4 = localObject3;
      break label127;
      label519:
      localObject4 = str3;
      break label152;
      label526:
      localObject4 = str2;
      break label177;
      label533:
      localObject4 = localObject2;
      break label201;
      label539:
      localObject4 = str1;
      break label225;
      label545:
      localObject4 = localObject1;
      break label249;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public int a()
  {
    return 2131560740;
  }
  
  public IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("new_qq_android_native_short_filter_");
    localIntentFilter.addAction("new_qq_android_native_ptu_res_");
    return localIntentFilter;
  }
  
  public View a()
  {
    boolean bool3 = false;
    o();
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)super.a());
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366530));
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(8);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setScrollCallBack(this);
    this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView = ((EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffectListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setDanceFilterEventHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setCameraChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFiltersChainListener(this);
    this.jdField_a_of_type_Blqk = new blqk(this.jdField_a_of_type_Bmhh.a(), b(), this.jdField_a_of_type_Bmhg);
    this.jdField_a_of_type_Blqk.jdField_a_of_type_Int = this.jdField_a_of_type_Bmgz.jdField_c_of_type_Int;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setProviderViewListener(this.jdField_a_of_type_Blqk);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView = ((QIMProviderContainerView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131372385));
    this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131372387));
    boolean bool4 = azkt.c();
    int m;
    label216:
    Object localObject;
    boolean bool2;
    if ((axpm.d()) && (bool4))
    {
      m = 1;
      if (azki.l()) {
        break label922;
      }
      bool1 = true;
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setBottomTabParentLH(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setDpcEnable(bool1);
      localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if ((!this.o) || (m == 0)) {
        break label927;
      }
      bool2 = true;
      label261:
      ((QIMProviderContainerView)localObject).setBeautyEnable(bool2);
      localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if (!this.p) {
        break label932;
      }
      bool2 = true;
      label282:
      ((QIMProviderContainerView)localObject).setFilterEnable(bool2);
      localObject = this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if ((!this.q) || (!bool4)) {
        break label937;
      }
      bool2 = true;
      label308:
      ((QIMProviderContainerView)localObject).setFaceEffectEnable(bool2);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setComboEnable(this.r);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setMusicEnable(this.s);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.o) || (m == 0) || (!bool1)) {
        break label942;
      }
      bool2 = true;
      label359:
      ((EffectsCameraCaptureView)localObject).setBeautyEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.t) || (!bool4) || (!bool1)) {
        break label947;
      }
      bool2 = true;
      label389:
      ((EffectsCameraCaptureView)localObject).setSharpFaceEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.p) || (!bool1)) {
        break label952;
      }
      bool2 = true;
      label414:
      ((EffectsCameraCaptureView)localObject).setFilterEnable(bool2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
      if ((!this.q) || (!bool4) || (!bool1)) {
        break label957;
      }
    }
    label922:
    label927:
    label932:
    label937:
    label942:
    label947:
    label952:
    label957:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((EffectsCameraCaptureView)localObject).setFaceEffectEnable(bool1);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.b();
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366593));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366595));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366594));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366517));
      this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131365926);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131365925));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131362575));
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      CosFunHelper.setCountDownListener(new bkng(this));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131377531));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366597));
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(1000L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366596));
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_Axpa = new axpa(this.jdField_a_of_type_Blqk.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView);
      this.jdField_a_of_type_Axpe = new axpe(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager);
      this.jdField_a_of_type_Axpd = new axpd();
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366521);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363909));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = ((RedDotImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379678));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setOnClickListener(this);
      aj();
      Y();
      bool1 = bool3;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        bool1 = bool3;
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
          bool1 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QIMEffectCameraCaptureUnit", 1, "onCreateView needLiuHaiTop:" + bool1);
      }
      localObject = this.jdField_b_of_type_AndroidViewViewGroup;
      if ((this.jdField_d_of_type_Boolean) || (bool1)) {
        this.jdField_b_of_type_AndroidViewViewGroup = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      }
      ai();
      return localObject;
      m = 0;
      break;
      bool1 = false;
      break label216;
      bool2 = false;
      break label261;
      bool2 = false;
      break label282;
      bool2 = false;
      break label308;
      bool2 = false;
      break label359;
      bool2 = false;
      break label389;
      bool2 = false;
      break label414;
    }
  }
  
  protected GuideVideoView a(Activity paramActivity, MqqHandler paramMqqHandler)
  {
    return new GuideVideoView(paramActivity, paramMqqHandler);
  }
  
  public void a()
  {
    super.a();
    blro.c = true;
    b(System.currentTimeMillis());
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.B();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.a(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onActivityResult:requestCode=" + paramInt1 + " resultCode=" + paramInt2 + " data=" + paramIntent + " publishStoryFlag=" + w);
    }
    Activity localActivity = this.jdField_a_of_type_Bmhh.a();
    axpx.a(localActivity, paramInt1, paramInt2);
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      if (QLog.isColorLevel())
      {
        if (localActivity == null) {
          bool = true;
        }
        QLog.d("QIMEffectCameraCaptureUnit", 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool) });
      }
      return;
    }
    if ((paramIntent != null) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setBlockCameraFlag(w);
      if (QLog.isColorLevel()) {
        QLog.i("QIMEffectCameraCaptureUnit", 2, "cameraCaptureView setBlockCameraFlag");
      }
      label181:
      if (paramInt1 != 10006) {
        break label361;
      }
      if (paramInt2 != -1) {
        break label354;
      }
      this.jdField_a_of_type_Blqk.n();
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b(false);
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        bkoh.a(null);
      }
      if (this.jdField_a_of_type_Blqk != null)
      {
        if (paramIntent != null) {
          paramIntent.putExtra("story_video_publishing", w);
        }
        this.jdField_a_of_type_Blqk.a(paramInt1, paramInt2, paramIntent);
      }
      if (paramIntent == null) {
        break;
      }
      this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("share_url_target_url");
      this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("share_url_name");
      this.jdField_h_of_type_JavaLangString = paramIntent.getStringExtra("share_url_text");
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("share_url_thumb_url");
      this.j = paramIntent.getStringExtra("struct_share_key_source_name");
      this.k = paramIntent.getStringExtra("struct_share_key_source_icon");
      return;
      if ((paramIntent != null) || (paramInt2 != 0) || (!w)) {
        break label181;
      }
      w = false;
      this.jdField_a_of_type_JavaLangRunnable = new QIMEffectCameraCaptureUnit.1(this, localActivity, paramInt2, paramIntent);
      return;
      label354:
      if (paramInt2 == 0)
      {
        continue;
        label361:
        if ((paramInt1 == 1012) && (paramInt2 == -1))
        {
          this.jdField_a_of_type_Blqk.n();
          this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.b(false);
        }
      }
    }
  }
  
  public void a(int paramInt, blsz paramblsz)
  {
    super.a(paramInt, paramblsz);
    if (!paramblsz.a()) {
      P();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Blqk != null) {
        this.jdField_a_of_type_Blqk.d(paramblsz.a());
      }
      ad();
      return;
      O();
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Blqk != null) && (this.jdField_a_of_type_Blqk.a() != null)) {
      this.jdField_a_of_type_Blqk.a().setTimeStamp(paramLong, false);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    bhrb.jdField_a_of_type_Boolean = true;
    axpl.i();
    axpl.e = true;
    axpl.jdField_a_of_type_Int = this.jdField_a_of_type_Bmgz.a();
    axpl.a();
    axpm.c = false;
    w = false;
    bnhb.a().b(true);
    ((bknb)blqr.a(13)).b(this.jdField_a_of_type_Bmgz.jdField_c_of_type_Int);
    if (blyz.c)
    {
      boolean bool = this.jdField_a_of_type_Bmhh.a().getIntent().hasExtra("pendingIntentClass");
      if ((this.jdField_b_of_type_Long == -1L) || (bool)) {
        break label132;
      }
    }
    label132:
    for (long l = this.jdField_b_of_type_Long;; l = System.currentTimeMillis())
    {
      blyz.e.b();
      blyz.e.a(0, l);
      blyz.e.a(1, System.currentTimeMillis());
      return;
    }
  }
  
  public void a(axqw paramaxqw)
  {
    this.jdField_a_of_type_AndroidOsBundle = blqi.a(this.jdField_a_of_type_Blqk);
    this.jdField_a_of_type_Bmgz.a(h());
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().k();
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onPhotoCaptured");
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (azjh.a(this.jdField_a_of_type_Bmgz.a()))
    {
      localPtvTemplateInfo = ((bnpl)blqr.a(3)).a();
      if ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.funcType != PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET)) {
        break label56;
      }
      paramLocalMediaInfo.redBagType = LocalMediaInfo.REDBAG_TYPE_GET;
      QLog.d("QIMEffectCameraCaptureUnit", 1, "VideoRedbag, onVideoCaptured, LocalMediaInfo take redbag flag ");
    }
    label56:
    do
    {
      do
      {
        return;
      } while ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.kind != 5));
      paramLocalMediaInfo.specialVideoType = 2;
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 2, "checkMediaInfoPreJump specialVideoType dancegame!");
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    this.jdField_a_of_type_Blqk.v();
    this.jdField_a_of_type_AndroidOsBundle = blqi.a(this.jdField_a_of_type_Blqk);
    super.a(paramVideoCaptureResult);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((blyz.c) && (paramLocalMediaInfo.mDuration > 0L))
    {
      File localFile = new File(paramLocalMediaInfo.path);
      if (localFile.exists()) {
        paramLocalMediaInfo.fileSize = (localFile.length() / 1024L);
      }
      float f1 = paramVideoCaptureResult.videoFrameCount / (float)paramLocalMediaInfo.mDuration;
      wxj.a("CamRecordFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_Bmgz.jdField_c_of_type_Int), String.valueOf(f1 * 1000.0F), String.valueOf(paramLocalMediaInfo.fileSize), String.valueOf(paramLocalMediaInfo.mDuration), wxj.b(h()) });
    }
    this.jdField_a_of_type_Bmgz.a(h());
    azgd.a().a(false);
  }
  
  public void a(QQFilterRenderManager.ChainBuilder paramChainBuilder) {}
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    boolean bool1 = false;
    ae();
    if (paramVideoMaterial == null) {}
    boolean bool2;
    do
    {
      return;
      this.E = false;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.AR_PARTICLE.value) {
        bool1 = true;
      }
      bool2 = paramVideoMaterial.isSupportTouchEvent();
    } while (((this.v) && (bool1)) || ((!this.v) && (!bool1)));
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.12(this, bool1, bool2));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_Bmhh.a().runOnUiThread(new QIMEffectCameraCaptureUnit.6(this, paramString1, paramString2));
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    int n = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a();
    int i1 = AdvancedProviderView.b();
    int m = AdvancedProviderView.c();
    if (QLog.isColorLevel()) {
      QLog.d("sv_beauty_level", 2, "onCameraStarted beauty level : " + i1 + ", sharp level:" + m);
    }
    this.jdField_a_of_type_Blqk.b(i1);
    paramString = this.jdField_a_of_type_Blqk;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.k) {}
    for (;;)
    {
      paramString.c(m);
      if (this.jdField_d_of_type_Int != n) {
        this.jdField_a_of_type_Blqk.f(n);
      }
      this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a();
      return;
      m = -1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.10(this, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Blqk == null) {}
    while ((this.jdField_a_of_type_Blqk.a()) || (g()) || (this.jdField_a_of_type_Blqk.d())) {
      return false;
    }
    boolean bool = super.a();
    if ((!this.jdField_i_of_type_Boolean) || (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_a_of_type_Blqk.l();
      this.K = true;
      this.jdField_a_of_type_Blqk.n();
      this.K = false;
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = bnhb.a().b(0);
      if ((localObject != null) && (((QIMFilterCategoryItem)localObject).jdField_a_of_type_Int != 100)) {
        ((blrx)blqr.a(5)).a((Activity)b().getContext(), this, 0);
      }
    }
    int m;
    if (paramBoolean)
    {
      m = 4;
      localObject = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
      if (paramBoolean) {
        break label85;
      }
    }
    label85:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((VideoFilterViewPager)localObject).setEnabled(paramBoolean);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(m);
      return false;
      m = 0;
      break;
    }
  }
  
  public void a_(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.4(this));
    V();
    int m = this.jdField_a_of_type_Bmhh.a().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.a(blro.a, new Object[] { this, Integer.valueOf(m) });
  }
  
  public void aa()
  {
    boolean bool2 = false;
    Object localObject;
    blqk localblqk;
    int m;
    boolean bool3;
    int n;
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView))
    {
      localObject = (EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
      ((EffectsCameraCaptureView)localObject).setFaceEffect("");
      localblqk = this.jdField_a_of_type_Blqk;
      if (localblqk != null)
      {
        if ((!axpm.d()) || (!azkt.c())) {
          break label195;
        }
        m = 1;
        bool3 = azkt.c();
        if (azki.l()) {
          break label200;
        }
        n = 1;
        label68:
        if ((!this.o) || (m == 0) || (n == 0)) {
          break label205;
        }
        bool1 = true;
        label85:
        ((EffectsCameraCaptureView)localObject).setBeautyEnable(bool1);
        if ((!bool3) || (n == 0)) {
          break label210;
        }
        bool1 = true;
        label102:
        com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceOpen = bool1;
        if ((!bool3) || (n == 0)) {
          break label215;
        }
      }
    }
    label195:
    label200:
    label205:
    label210:
    label215:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((EffectsCameraCaptureView)localObject).setSharpFaceEnable(bool1);
      bool1 = bool2;
      if (this.q)
      {
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (n != 0) {
            bool1 = true;
          }
        }
      }
      ((EffectsCameraCaptureView)localObject).setFaceEffectEnable(bool1);
      localObject = EffectsCameraCaptureView.b();
      if (localObject != null) {
        ((QQFilterRenderManager)localObject).setFaceDetectFlags(true);
      }
      localblqk.b(this.jdField_g_of_type_Int);
      localblqk.c(this.jdField_h_of_type_Int);
      return;
      m = 0;
      break;
      n = 0;
      break label68;
      bool1 = false;
      break label85;
      bool1 = false;
      break label102;
    }
  }
  
  public void ab()
  {
    this.jdField_g_of_type_Int = AdvancedProviderView.b();
    this.jdField_h_of_type_Int = AdvancedProviderView.c();
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView))
    {
      EffectsCameraCaptureView localEffectsCameraCaptureView = (EffectsCameraCaptureView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
      localEffectsCameraCaptureView.setFaceEffect("");
      blqk localblqk = this.jdField_a_of_type_Blqk;
      if (localblqk != null)
      {
        QQFilterRenderManager localQQFilterRenderManager = EffectsCameraCaptureView.b();
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.setFaceDetectFlags(false);
        }
        localblqk.b(0);
        localblqk.c(-1);
        localEffectsCameraCaptureView.setBeautyEnable(false);
        localEffectsCameraCaptureView.setSharpFaceEnable(false);
        com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceOpen = false;
        localEffectsCameraCaptureView.setFaceEffectEnable(false);
      }
    }
  }
  
  protected int b()
  {
    return 7;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Blqk.a(8);
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onPhotoCaptureStart");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(paramInt);
  }
  
  public void b(long paramLong)
  {
    long l1;
    if (this.jdField_b_of_type_Long != -1L)
    {
      l1 = this.jdField_b_of_type_Long;
      bnfq.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), paramLong - l1, this.jdField_a_of_type_Bmgz.a() + "", C);
      C = false;
    }
    long l2;
    long l3;
    if (blyz.c)
    {
      boolean bool = this.jdField_a_of_type_Bmhh.a().getIntent().getBooleanExtra("camera_peak_is_alive", false);
      blyz.e.a(3, paramLong);
      if (blyz.e.a())
      {
        paramLong -= blyz.e.a[0];
        l1 = blyz.e.a[1] - blyz.e.a[0];
        l2 = blyz.e.a[2] - blyz.e.a[1];
        l3 = blyz.e.a[3] - blyz.e.a[2];
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label299;
        }
      }
    }
    label299:
    for (int m = 1;; m = 0)
    {
      if ((wxj.a(paramLong, 0L, 10000L)) && (wxj.a(l1, 0L, 10000L)) && (wxj.a(l2, 0L, 10000L)) && (wxj.a(l3, 0L, 10000L))) {
        wxj.a("CamCaptureCost", true, paramLong, new String[] { String.valueOf(this.jdField_a_of_type_Bmgz.jdField_c_of_type_Int), String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(m) });
      }
      blyz.e.c();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.O = paramBoolean;
    this.P = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    ak();
  }
  
  public boolean b()
  {
    bnpl localbnpl = (bnpl)blqr.a(3);
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = localbnpl.a();
    if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.kind == 20))
    {
      localbnpl.a("0", blra.jdField_b_of_type_Int, "");
      blra.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect(null);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_Blqk.u();
    }
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.9(this));
  }
  
  public void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366530);
    if ((localView != null) && ((localView instanceof VideoFilterViewPager)))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i("QIMEffectCameraCaptureUnit", 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_Bmhh.a().runOnUiThread(new QIMEffectCameraCaptureUnit.5(this, paramBoolean));
    }
  }
  
  public boolean changeDanceStatus(boolean paramBoolean, String paramString)
  {
    this.M = paramBoolean;
    int m;
    label198:
    Object localObject1;
    boolean bool;
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "changeDanceStatus " + paramBoolean + " " + paramString);
      }
      if (paramBoolean)
      {
        h();
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetImageView.setEnabled(true);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(4);
        if (this.jdField_f_of_type_AndroidViewView.getVisibility() == 0) {
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = ((blrx)blqr.a(5)).a((Activity)b().getContext(), this, 0);
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() == 2)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.q();
        }
        if (!paramBoolean) {
          break label514;
        }
        m = 4;
        localObject1 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
        if (paramBoolean) {
          break label519;
        }
        bool = true;
        label211:
        ((VideoFilterViewPager)localObject1).setEnabled(bool);
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(m);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label1033;
      }
      if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) || (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaUtilMap.get(paramString)))) {
        break label525;
      }
      this.jdField_e_of_type_JavaLangString = ((String)this.jdField_a_of_type_JavaUtilMap.get(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "has parsed shareWebUrl : " + this.jdField_e_of_type_JavaLangString);
      }
      label315:
      if (!this.N) {
        break label662;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "DGVideoGuide is showing, now start ");
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.f();
      bool = false;
      if (this.N) {
        break label1007;
      }
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetImageView.setEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        label371:
        if ((this.jdField_d_of_type_Boolean) && (paramBoolean) && (bool)) {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
        }
        return bool;
        if ((d()) && (!this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().a())) {
          g();
        }
        for (;;)
        {
          if (this.jdField_b_of_type_Int != 5) {
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
          }
          this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_f_of_type_AndroidWidgetImageView.setEnabled(false);
          if (this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem == null) {
            break;
          }
          ((blrx)blqr.a(5)).a((Activity)b().getContext(), 0, this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem);
          this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = null;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("QIMEffectCameraCaptureUnit", 2, "changeDanceStatus showButtons deny, is capturing");
          }
        }
        label514:
        m = 0;
        break label198;
        label519:
        bool = false;
        break label211;
        try
        {
          label525:
          localObject1 = new JSONObject(ResourceManager.readFileContent(paramString + "params.json")).getJSONObject("postureParam");
          this.jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).getString("shareWebUrl");
          localObject1 = ((JSONObject)localObject1).getString("guideVideoUrl");
          this.jdField_a_of_type_JavaUtilMap.put(paramString, this.jdField_e_of_type_JavaLangString);
          this.jdField_b_of_type_JavaUtilMap.put(paramString, localObject1);
          if (!QLog.isColorLevel()) {
            break label315;
          }
          QLog.d("QIMEffectCameraCaptureUnit", 2, "has not parsed shareWebUrl, now parse  ; " + this.jdField_e_of_type_JavaLangString);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      label662:
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if (this.jdField_a_of_type_Bmgz.a() != 10007)
      {
        bool = localSharedPreferences.getBoolean("hasShowDGVideoGuide", false);
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasShowDGVideoGuide : " + bool);
        }
        localObject2 = (bnpl)blqr.a(3);
        if (localObject2 == null) {
          break label1027;
        }
      }
      label1027:
      for (Object localObject2 = ((bnpl)localObject2).a();; localObject2 = null)
      {
        if ((!bool) && (f()) && ((localObject2 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject2).kind != 6)))
        {
          af();
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
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.b();
            localSharedPreferences.edit().putBoolean("hasShowDGVideoGuide", true).commit();
            bool = false;
            break;
            try
            {
              paramString = new JSONObject(ResourceManager.readFileContent(paramString + "params.json")).getJSONObject("postureParam").getString("guideVideoUrl");
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              paramString = null;
            }
          }
          localSharedPreferences.edit().putBoolean("hasShowDGVideoGuide", true).commit();
        }
        bool = true;
        break;
        label1007:
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetImageView.setEnabled(false);
        break label371;
      }
      label1033:
      bool = true;
    }
  }
  
  public void closeEvent(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QIMEffectCameraCaptureUnit.24(this, paramBoolean));
  }
  
  public void d()
  {
    super.d();
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpa);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpe);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpd);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.d();
    this.jdField_a_of_type_Blqk.l();
    if (this.M)
    {
      if (this.L)
      {
        this.l = true;
        ah();
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView != null) && (this.N)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.d();
      }
    }
  }
  
  public void e()
  {
    super.e();
    ((blvi)blqr.a().c(4)).d();
    bniy.a();
    this.jdField_a_of_type_Blqk.e();
    VideoMemoryManager.getInstance().clear();
    axpl.i();
    if ((blyz.c) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.y > 100) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c > 0L))
    {
      float f1 = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.y / (float)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c * 1000.0F;
      if (wxj.a((int)f1, 0L, 30L)) {
        wxj.a("CamRenderFreq", true, 0L, new String[] { String.valueOf(this.jdField_a_of_type_Bmgz.jdField_c_of_type_Int), String.valueOf(f1), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.y), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c) });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.v();
    bnpa.a = null;
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (this.jdField_a_of_type_Blqk != null) {
      this.jdField_a_of_type_Blqk.e(paramBoolean);
    }
    if (!paramBoolean)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      blua localblua = (blua)blqr.a().c(8);
      if (localblua != null) {
        localblua.a(localblua.a(), true, 0);
      }
    }
  }
  
  protected boolean e()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = ((bnpl)blqr.a(3)).a();
    if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.kind == 7)) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() == 1;
    }
    return true;
  }
  
  public void enterSilhouette() {}
  
  public void f()
  {
    super.f();
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpa);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpe);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpd);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
    this.jdField_a_of_type_Blqk.m();
    X();
    Z();
    o(false);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setContainerViewListener(this);
    if (blyz.c) {
      blyz.e.a(2, System.currentTimeMillis());
    }
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Int != 7;
  }
  
  public void g()
  {
    super.g();
    if ((azkt.d()) && (azkt.a(a()))) {}
    for (int m = 1;; m = 0)
    {
      if ((this.u) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a() != 0) && (m != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(0);
      }
      this.jdField_a_of_type_Blqk.a(0);
      p(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_b_of_type_Int != 7)) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean) {
      M();
    }
    View localView = this.jdField_c_of_type_AndroidViewView;
    if (paramBoolean) {}
    for (int m = 4;; m = 0)
    {
      localView.setVisibility(m);
      return;
    }
  }
  
  public boolean g()
  {
    boolean bool = false;
    if (!this.N)
    {
      if (this.M)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.C();
        bool = true;
      }
      return bool;
    }
    ag();
    return false;
  }
  
  public int h()
  {
    if ((this instanceof bkob)) {
      return 6;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_Blqk.a(8);
    p(false);
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      M();
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public boolean h()
  {
    return this.jdField_b_of_type_Int != 7;
  }
  
  public void j()
  {
    super.j();
    ((blrx)blqr.a(5)).a(true);
    c(8);
    if (this.jdField_h_of_type_Boolean)
    {
      if (this.jdField_c_of_type_JavaUtilList.size() <= 0) {
        break label99;
      }
      this.jdField_a_of_type_Blqk.f(true);
      blua localblua = (blua)blqr.a().c(8);
      if (localblua != null)
      {
        localblua.c(((Integer)this.jdField_c_of_type_JavaUtilList.get(this.jdField_c_of_type_JavaUtilList.size() - 1)).intValue());
        localblua.c();
      }
    }
    return;
    label99:
    this.jdField_a_of_type_Blqk.u();
  }
  
  public void k()
  {
    super.k();
    ((blrx)blqr.a(5)).a(false);
    c(0);
    this.jdField_a_of_type_Blqk.f(false);
    blua localblua;
    if (this.jdField_h_of_type_Boolean)
    {
      localblua = (blua)blqr.a().c(8);
      if (localblua != null)
      {
        int m = localblua.a();
        if (m < 0) {
          break label120;
        }
        this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(m));
      }
    }
    for (;;)
    {
      localblua.d();
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onCaptureButtonVideoStop, segmentMusicTimePoints size = " + this.jdField_c_of_type_JavaUtilList.size());
      }
      return;
      label120:
      if (this.jdField_c_of_type_JavaUtilList.size() > 0) {
        this.jdField_c_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList.get(this.jdField_c_of_type_JavaUtilList.size() - 1));
      } else {
        this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Boolean) {
      b(this.y, this.z, this.A, this.B);
    }
    ThreadManager.getUIHandler().postDelayed(new QIMEffectCameraCaptureUnit.22(this), 300L);
  }
  
  public void l(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!x)
    {
      x = true;
      this.jdField_a_of_type_Bmhh.a().runOnUiThread(new QIMEffectCameraCaptureUnit.7(this));
      return;
    }
    this.jdField_a_of_type_Bmhh.a().runOnUiThread(new QIMEffectCameraCaptureUnit.8(this));
  }
  
  public void m() {}
  
  public void m(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.11(this, paramBoolean));
  }
  
  protected void n()
  {
    this.jdField_a_of_type_Blqk.c();
    this.jdField_a_of_type_Blqk.d();
  }
  
  public void n(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpf);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axoz);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpe);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpc);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpa);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Axpd);
      return;
    }
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpf);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axoz);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpe);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpc);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpa);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Axpd);
  }
  
  protected void o() {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Blqk.g();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      bmar.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView, 200L, null);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.jdField_a_of_type_Int, 0, null, false);
      azqs.b(null, "dc00898", "", "", "0X8009ED3", "0X8009ED3", b(), 0, "", "", "", "");
      wxj.a("clk_enter_all", wxj.b(this.jdField_a_of_type_Bmhh.a().getIntent().getIntExtra("edit_video_type", 10000)), 0, false, new String[0]);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.g()) {
      a(null, null);
    }
    if (this.M) {
      return true;
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void playSceneEndEvent(BoyDataReport paramBoyDataReport)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QIMEffectCameraCaptureUnit.21(this));
    axpl.a(paramBoyDataReport);
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_Blqk != null) {
      this.jdField_a_of_type_Blqk.n();
    }
    super.r();
  }
  
  public void readySceneBegin(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new QIMEffectCameraCaptureUnit.20(this));
  }
  
  public void scoreSceneEnd(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidOsHandler.post(new QIMEffectCameraCaptureUnit.23(this));
  }
  
  public void t()
  {
    super.t();
    bnrp.a.clear();
  }
  
  public void v()
  {
    super.v();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = ((RedDotImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379678));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getLayoutParams();
    localLayoutParams.bottomMargin = aepi.a(50.0F, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getResources());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setLayoutParams(localLayoutParams);
  }
  
  public void x()
  {
    super.x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */