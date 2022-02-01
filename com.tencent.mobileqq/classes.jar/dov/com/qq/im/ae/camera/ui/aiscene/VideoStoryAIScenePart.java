package dov.com.qq.im.ae.camera.ui.aiscene;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.AISceneCallback;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.PTFaceAttr;
import dov.com.qq.im.ae.AEPath.AISCENE.FILES;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEPituCameraUnit.ViewStubHoldersViewModel;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.FilterPagerViewStubHolder;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.SelectCallBack;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mqq.os.MqqHandler;

public class VideoStoryAIScenePart
  extends VideoStoryBasePart
  implements CameraCaptureView.AISceneCallback, VideoFilterViewPager.SelectCallBack
{
  private final int jdField_a_of_type_Int = 400;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit = (AEPituCameraUnit)this.mPartManager.a(65537, new Object[0]);
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private FilterPagerViewStubHolder jdField_a_of_type_DovComQqImAeCameraUiFilterPagerViewStubHolder;
  private IAIScene jdField_a_of_type_DovComQqImAeCameraUiAisceneIAIScene = new TTAutoAIScene();
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private QIMFilterCategoryItem jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
  private AbsAECaptureButton jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final String jdField_a_of_type_JavaLangString = "ai_guide_shown";
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicReference<CameraCaptureView.AISceneCallback> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  private boolean jdField_a_of_type_Boolean = false;
  private final int jdField_b_of_type_Int = 1500;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQAnimationDrawable jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private volatile AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private boolean jdField_b_of_type_Boolean = false;
  private final int jdField_c_of_type_Int = 2000;
  private QQAnimationDrawable jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  
  public VideoStoryAIScenePart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
  }
  
  private AnimationSet a()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight(), 0.0F);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new DecelerateInterpolator());
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(localTranslateAnimation);
    }
    return this.jdField_a_of_type_AndroidViewAnimationAnimationSet;
  }
  
  private void a(int paramInt, String paramString)
  {
    AlphaAnimation localAlphaAnimation1 = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation1.setDuration(1000L);
    AlphaAnimation localAlphaAnimation2 = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation2.setDuration(1000L);
    String str1 = "";
    String str2 = AEPath.AISCENE.FILES.f;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131716243) + paramString + HardCodeUtil.a(2131716242));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setAnimation(a());
      if (TextUtils.isEmpty(str2)) {
        break label423;
      }
      str2 = str2 + File.separator + str1;
      paramString = new File(str2);
      if (!paramString.exists()) {
        break label423;
      }
      File[] arrayOfFile = paramString.listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length <= 0)) {
        break label423;
      }
      paramString = new String[arrayOfFile.length];
      paramInt = 0;
      while (paramInt < arrayOfFile.length)
      {
        String str3 = str2 + File.separator + str1 + "_" + (paramInt + 1) + ".png";
        if (new File(str3).exists()) {
          paramString[paramInt] = str3;
        }
        paramInt += 1;
      }
      str1 = "object";
      continue;
      str1 = "food";
      continue;
      str1 = "scene";
      continue;
      str1 = "face";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2500L);
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(true);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
      this.jdField_a_of_type_AndroidViewView.postDelayed(new VideoStoryAIScenePart.8(this), 2500L);
      localAlphaAnimation1.setAnimationListener(new VideoStoryAIScenePart.9(this, localAlphaAnimation2));
      localAlphaAnimation2.setAnimationListener(new VideoStoryAIScenePart.10(this));
      return;
      label423:
      paramString = null;
    }
  }
  
  private void a(AEMaterialPanel paramAEMaterialPanel)
  {
    Activity localActivity = (Activity)paramAEMaterialPanel.getContext();
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) || (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)))
    {
      int i = UIUtils.c(localActivity);
      this.jdField_a_of_type_AndroidViewView.post(new VideoStoryAIScenePart.18(this, paramAEMaterialPanel, i));
    }
  }
  
  private void a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    int i = 0;
    float f1 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    RelativeLayout.LayoutParams localLayoutParams;
    float f2;
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(13, 0);
      localLayoutParams.addRule(6, 2131364338);
      localLayoutParams.topMargin = ((int)(f1 - this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth()) >> 1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
        break label215;
      }
      f2 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels / f1;
      if (f2 >= 1.78D) {
        break label190;
      }
      i = -20;
    }
    for (;;)
    {
      if (i == 0)
      {
        return;
        if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.FULL) {
          break;
        }
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.addRule(14);
        localLayoutParams.addRule(13, -1);
        localLayoutParams.addRule(6, 0);
        localLayoutParams.topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        break;
        label190:
        if (f2 < 1.78D) {
          break label332;
        }
        i = -DisplayUtil.a(this.mActivity, f1 / 2.0F);
        continue;
        label215:
        if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.FULL) {
          continue;
        }
        i = 46;
        continue;
      }
      paramRatio = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramRatio.bottomMargin = (this.e - ScreenUtil.dip2px(i));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramRatio);
      paramRatio = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramRatio.bottomMargin = (this.f - ScreenUtil.dip2px(i));
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramRatio);
      paramRatio = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramRatio.bottomMargin = (this.g - ScreenUtil.dip2px(i));
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramRatio);
      return;
      label332:
      i = 0;
    }
  }
  
  private void a(AtomicReference<CameraCaptureView.AISceneCallback> paramAtomicReference, AEFilterManager paramAEFilterManager)
  {
    if (paramAtomicReference.get() == null) {
      Logger.a("Q.videostory", "Q.videostory.capture", "requestAIScene()", "sceneCallback is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((paramAEFilterManager != null) && (paramAEFilterManager.getFaceAttr() != null)) {
            break;
          }
        } while (paramAtomicReference.get() == null);
        ((CameraCaptureView.AISceneCallback)paramAtomicReference.get()).a("mQQFilterRenderManager is null");
        return;
        Logger.a("Q.videostory", "Q.videostory.capture", "requestAIScene()", "start");
        Object localObject2 = paramAEFilterManager.getFaceAttr();
        Object localObject1 = ((PTFaceAttr)localObject2).getData();
        if ((localObject1 == null) || (localObject1.length == 0))
        {
          AEQLog.d("AEAIScenePart", "requestAIScene: ptFaceAttr.getData() == null, 不使用智能滤镜");
          return;
        }
        int i = ((PTFaceAttr)localObject2).getFaceDetWidth();
        int j = ((PTFaceAttr)localObject2).getFaceDetHeight();
        paramAEFilterManager = new ArrayList();
        localObject2 = ((PTFaceAttr)localObject2).getAllFacePoints();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (List)((Iterator)localObject2).next();
            float f1 = ((PointF)((List)localObject3).get(18)).x;
            float f2 = ((PointF)((List)localObject3).get(0)).x;
            float f3 = ((PointF)((List)localObject3).get(9)).y;
            float f4 = ((PointF)((List)localObject3).get(87)).y;
            localObject3 = new IAIScene.FaceRect();
            ((IAIScene.FaceRect)localObject3).jdField_b_of_type_Int = ((int)(f3 - f4));
            ((IAIScene.FaceRect)localObject3).jdField_a_of_type_Int = ((int)(f1 - f2));
            paramAEFilterManager.add(localObject3);
          }
        }
        if ((i == 0) || (j == 0)) {
          break;
        }
        localObject2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localObject1 = ByteBuffer.wrap((byte[])localObject1);
        try
        {
          ((Bitmap)localObject2).copyPixelsFromBuffer((Buffer)localObject1);
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
          this.jdField_a_of_type_DovComQqImAeCameraUiAisceneIAIScene.a((Bitmap)localObject2, paramAEFilterManager, new VideoStoryAIScenePart.12(this, paramAtomicReference));
          return;
        }
        catch (Exception paramAEFilterManager) {}
      } while ((CameraCaptureView.AISceneCallback)paramAtomicReference.get() == null);
      ((CameraCaptureView.AISceneCallback)paramAtomicReference.get()).a(paramAEFilterManager.toString());
      return;
      AEQLog.d("AEAIScenePart", "width or height is 0, fail to request AIScene!");
    } while ((CameraCaptureView.AISceneCallback)paramAtomicReference.get() == null);
    ((CameraCaptureView.AISceneCallback)paramAtomicReference.get()).a("no bitmap");
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.equals("network error"))) {
      this.mRootView.post(new VideoStoryAIScenePart.15(this));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null)
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getSelectedCamera() != 1) {
        break label85;
      }
      b();
      a(null);
      if (this.jdField_c_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      }
      g();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.postDelayed(new VideoStoryAIScenePart.22(this), 1000L);
      VSReporter.a("mystatus_shoot", "cam_reverse", 0, 0, new String[0]);
      return;
      label85:
      if (!paramBoolean)
      {
        if (this.jdField_c_of_type_JavaLangRunnable == null) {
          this.jdField_c_of_type_JavaLangRunnable = new VideoStoryAIScenePart.21(this);
        }
        this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1000L);
      }
    }
  }
  
  private void d()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams1;
    ViewGroup.MarginLayoutParams localMarginLayoutParams2;
    ViewGroup.MarginLayoutParams localMarginLayoutParams3;
    if (this.mActivity != null)
    {
      localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      this.e = localMarginLayoutParams1.bottomMargin;
      localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      this.f = localMarginLayoutParams2.bottomMargin;
      localMarginLayoutParams3 = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      this.g = localMarginLayoutParams3.bottomMargin;
      if (!this.jdField_d_of_type_Boolean) {
        break label74;
      }
    }
    label74:
    int i;
    do
    {
      return;
      i = 0;
      if (AECameraEntry.g(this.mActivity.getIntent())) {
        i = 76;
      }
    } while (i == 0);
    localMarginLayoutParams1.bottomMargin = (this.e - ScreenUtil.dip2px(i));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localMarginLayoutParams1);
    localMarginLayoutParams2.bottomMargin = (this.f - ScreenUtil.dip2px(i));
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localMarginLayoutParams2);
    localMarginLayoutParams3.bottomMargin = (this.g - ScreenUtil.dip2px(i));
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localMarginLayoutParams3);
  }
  
  private void e()
  {
    ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEPituCameraUnit.ViewStubHoldersViewModel.class)).b.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryAIScenePart.2(this));
    ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class)).a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryAIScenePart.3(this));
    if (this.jdField_d_of_type_Boolean) {
      ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class)).a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryAIScenePart.4(this));
    }
  }
  
  private void f()
  {
    if (AECameraPrefsUtil.a().a("ai_guide_shown", false, 0)) {}
    while (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getSelectedCamera() == 1) {
      return;
    }
    String str2 = AEPath.AISCENE.FILES.d;
    String str1 = null;
    Object localObject1 = str1;
    if (!TextUtils.isEmpty(str2))
    {
      Object localObject2 = new File(str2);
      localObject1 = str1;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        localObject1 = str1;
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (localObject2.length > 0)
          {
            localObject1 = new String[localObject2.length];
            int i = 0;
            while (i < localObject2.length)
            {
              str1 = str2 + File.separator + "tap_" + i + ".png";
              if (new File(str1).exists()) {
                localObject1[i] = str1;
              }
              i += 1;
            }
          }
        }
      }
    }
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(2000L);
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (localObject1 != null) {
      this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a((String[])localObject1);
    }
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new VideoStoryAIScenePart.5(this), 10000L);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetImageView.post(new VideoStoryAIScenePart.6(this));
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a() != null) && (this.jdField_d_of_type_Boolean))
    {
      MqqHandler localMqqHandler = ThreadManager.getUIHandler();
      VideoStoryAIScenePart.19 local19 = new VideoStoryAIScenePart.19(this);
      this.jdField_b_of_type_JavaLangRunnable = local19;
      localMqqHandler.postDelayed(local19, 250L);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.jdField_a_of_type_AndroidViewView.post(new VideoStoryAIScenePart.20(this));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131716223));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a();
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    String str2 = AEPath.AISCENE.FILES.e;
    String str1 = null;
    Object localObject1 = str1;
    if (!TextUtils.isEmpty(str2))
    {
      Object localObject2 = new File(str2);
      localObject1 = str1;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        localObject1 = str1;
        if (localObject2 != null)
        {
          localObject1 = str1;
          if (localObject2.length > 0)
          {
            localObject1 = new String[localObject2.length];
            int i = 0;
            while (i < localObject2.length)
            {
              str1 = str2 + File.separator + "image_000" + i + ".png";
              if (new File(str1).exists()) {
                localObject1[i] = str1;
              }
              i += 1;
            }
          }
        }
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(1500L);
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    if (localObject1 != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a((String[])localObject1);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
  }
  
  public void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    Log.d("AEAIScenePart", "onAIScene: ");
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) && (paramInt == 2))
    {
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new VideoStoryAIScenePart.11(this, paramAEFilterManager);
      }
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 128);
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 128, null, true);
    }
  }
  
  public void a(int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt).append("");
    String str;
    if (paramQIMFilterCategoryItem != null)
    {
      str = paramQIMFilterCategoryItem.b;
      Logger.a("Q.videostory", "Q.videostory.capture", "onFilterSelect", str);
      if (paramInt != 0) {
        a(null);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label102;
      }
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = paramQIMFilterCategoryItem;
      VSReporter.a("mystatus_shoot", "filter_change", 0, 0, new String[0]);
      return;
      str = "no filter";
      break;
      label102:
      b();
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredHeight());
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.setDuration(400L);
      localAnimationSet.addAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
      localAnimationSet.setAnimationListener(new VideoStoryAIScenePart.7(this, paramBoolean, paramInt, paramString));
    }
  }
  
  public void a(CameraCaptureView.AISceneCallback paramAISceneCallback)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.set(paramAISceneCallback);
  }
  
  public void a(TTAutoAISceneType paramTTAutoAISceneType)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a()))
    {
      a(null);
      b();
      return;
    }
    if ((paramTTAutoAISceneType.jdField_a_of_type_Int == -1) || ((this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit != null) && (!this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.m())))
    {
      b();
      return;
    }
    Object localObject2 = paramTTAutoAISceneType.b;
    Object localObject1 = VideoFilterTools.a().c(0);
    Bundle localBundle;
    CaptureComboManager localCaptureComboManager;
    if (localObject1 != null)
    {
      localObject1 = ((QIMFilterCategoryItem)localObject1).b;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label419;
      }
      Logger.a("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", (String)localObject2 + " " + (String)localObject1);
      localBundle = new Bundle();
      localBundle.putInt("apply_source", CaptureComboManager.jdField_a_of_type_Int);
      localBundle.putInt("capture_scene", 0);
      localBundle.putBoolean("capture_force_enable", this.jdField_c_of_type_Boolean);
      localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
      if (localCaptureComboManager.a() != null) {
        break label243;
      }
      paramTTAutoAISceneType = new ArrayList();
      b();
    }
    for (;;)
    {
      Logger.a("Q.videostory", "Q.videostory.capture", "onAISceneSuccess", "filterLister is empty:" + paramTTAutoAISceneType.size());
      return;
      localObject1 = "";
      break;
      label243:
      localObject1 = localCaptureComboManager.a().c;
      Object localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject3).next();
        if (localQIMFilterCategoryItem.b.equals(localObject2))
        {
          localQIMFilterCategoryItem.c = ((String)localObject2);
          localObject2 = new Message();
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("sceneName", paramTTAutoAISceneType.jdField_a_of_type_JavaLangString);
          ((Bundle)localObject3).putInt("sceneLvOne", paramTTAutoAISceneType.jdField_a_of_type_Int);
          ((Message)localObject2).setData((Bundle)localObject3);
          ((Message)localObject2).what = 1;
          long l = this.jdField_a_of_type_Long % 1500L;
          if (l > 1100L) {}
          for (;;)
          {
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, 0L);
            this.mRootView.postDelayed(new VideoStoryAIScenePart.13(this, localQIMFilterCategoryItem, localBundle, localCaptureComboManager), 500L);
            paramTTAutoAISceneType = (TTAutoAISceneType)localObject1;
            break;
          }
          label419:
          b();
          return;
        }
      }
      paramTTAutoAISceneType = (TTAutoAISceneType)localObject1;
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) && (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a()))
    {
      a(null);
      return;
    }
    b(paramString);
    this.mRootView.post(new VideoStoryAIScenePart.14(this));
    Logger.a("Q.videostory", "Q.videostory.capture", "onAISceneFail", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    a(0, null, false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return super.get(paramInt, paramVarArgs);
    }
    return this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
  }
  
  public void initView()
  {
    this.jdField_d_of_type_Boolean = AECameraEntry.k(this.mActivity.getIntent());
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131362356);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mRootView.findViewById(2131362360));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mRootView.findViewById(2131362359));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mRootView.findViewById(2131362357));
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2131362358);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364338));
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378585);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton = ((AbsAECaptureButton)this.mRootView.findViewById(2131364388));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.mRootView.findViewById(2131373621));
    a(this);
    this.jdField_a_of_type_AndroidOsHandler = new VideoStoryAIScenePart.1(this, Looper.getMainLooper());
    d();
    e();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_b_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    }
    if (this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_c_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 128);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    this.mActivity = null;
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 196610: 
    default: 
    case 196609: 
    case 196611: 
    case 196612: 
      do
      {
        return;
        a(null);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoStoryAIScenePart.17(this));
        return;
        b(((Boolean)paramVarArgs[0]).booleanValue());
        return;
      } while (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel == null);
      a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel);
      return;
    case 196613: 
      h();
      return;
    case 196614: 
      g();
      a(this);
      c();
      return;
    case 196615: 
      a(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    case 196616: 
      g();
      return;
    }
    a(((Integer)paramVarArgs[0]).intValue(), (AEFilterManager)paramVarArgs[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart
 * JD-Core Version:    0.7.0.1
 */