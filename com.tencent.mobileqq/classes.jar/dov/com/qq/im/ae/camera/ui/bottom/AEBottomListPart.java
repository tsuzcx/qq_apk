package dov.com.qq.im.ae.camera.ui.bottom;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.Toast;
import androidx.annotation.MainThread;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.biz.videostory.capture.widgets.ScaleTransformer.Builder;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;
import dov.com.qq.im.ae.data.AEMaterialCategory;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.AEVideoStoryStateViewModel;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.play.AEPlayShowGridAdapter;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AECameraCancelableProgressDialog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.util.QIMAnimationUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;

public class AEBottomListPart
  extends VideoStoryBasePart
  implements Observer, AEBottomListScrollView.LayoutCallback, AEBottomListScrollView.OnItemChangedListener<AEBottomListAdapter.ViewHolder>, AEBottomListScrollView.ScrollStateChangeListener<AEBottomListAdapter.ViewHolder>
{
  protected int a;
  protected AEPituCameraUnit a;
  protected AECaptureController a;
  protected AEBottomListAdapter a;
  protected AEBottomListScrollView a;
  protected AEMaterialManager a;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel;
  private AECameraCancelableProgressDialog jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog;
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public AEBottomListPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController = this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a();
  }
  
  private int a(String paramString)
  {
    int j;
    if (paramString == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.getItemCount()) {
        break label57;
      }
      AEMaterialMetaData localAEMaterialMetaData = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(i);
      if (localAEMaterialMetaData != null)
      {
        j = i;
        if (paramString.equals(localAEMaterialMetaData.jdField_a_of_type_JavaLangString)) {
          break;
        }
      }
      i += 1;
    }
    label57:
    return -1;
  }
  
  private AEMaterialMetaData a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter != null) {
      return this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(paramInt);
    }
    return null;
  }
  
  private AEMaterialMetaData a(String paramString, List<AEMaterialCategory> paramList)
  {
    AEMaterialMetaData localAEMaterialMetaData;
    do
    {
      do
      {
        paramList = paramList.iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject = (AEMaterialCategory)paramList.next();
          } while ((localObject == null) || (((AEMaterialCategory)localObject).a == null));
          localObject = ((AEMaterialCategory)localObject).a.iterator();
        }
        localAEMaterialMetaData = (AEMaterialMetaData)((Iterator)localObject).next();
      } while (localAEMaterialMetaData == null);
      if (TextUtils.isEmpty(paramString)) {
        return localAEMaterialMetaData;
      }
    } while (!paramString.equals(localAEMaterialMetaData.jdField_a_of_type_JavaLangString));
    return localAEMaterialMetaData;
    return null;
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (!paramAEMaterialMetaData.equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData)))
    {
      i = 1;
      if ((i >= this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.getItemCount()) || (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(i) == null)) {
        break label103;
      }
      if (!paramAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(i).jdField_a_of_type_JavaLangString)) {
        break label96;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(i).a(paramAEMaterialMetaData);
      c(i);
    }
    label96:
    label103:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(paramAEMaterialMetaData);
        c(1);
      }
      return;
      i += 1;
      break;
    }
  }
  
  private void a(String paramString)
  {
    int i = 1;
    AEBaseReportParam.a().i("-1");
    int j = a(paramString);
    if (j != -1)
    {
      this.mActivity.getIntent().putExtra("widgetinfo", "camera^" + paramString);
      paramString = a(j);
      if (paramString != null)
      {
        AEBaseDataReporter.a().d(paramString.jdField_a_of_type_JavaLangString);
        paramString.b = true;
        this.mActivity.getIntent().putExtra("key_camera_material_name", paramString.i);
      }
      i = j;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.getItemCount())
      {
        c(i);
        this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getAdapter().notifyDataSetChanged();
      }
      return;
      AEMaterialManager localAEMaterialManager = this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
      if ((this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit != null) && (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.l())) {}
      for (boolean bool = true;; bool = false)
      {
        paramString = localAEMaterialManager.a(paramString, bool);
        if (paramString == null) {
          break label195;
        }
        this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(paramString);
        AEBaseDataReporter.a().d(paramString.jdField_a_of_type_JavaLangString);
        paramString.b = true;
        break;
      }
      label195:
      if ((this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) && (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit != null)) {
        Toast.makeText(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a(), 2131689691, 1).show();
      }
      i = 0;
    }
  }
  
  @MainThread
  private void a(String paramString1, String paramString2)
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing())) {
      if ((paramString1 == null) || (paramString1.equals(AECaptureMode.NORMAL.name)))
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label102;
        }
        if (!paramString2.startsWith("http")) {
          break label71;
        }
        b(paramString2);
      }
    }
    for (;;)
    {
      l();
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 116);
      return;
      label71:
      if (!this.jdField_a_of_type_Boolean)
      {
        a(paramString2);
      }
      else
      {
        AEQLog.b("AEBottomListPart", "take same procedure CANCELED, handleNormalEnter");
        m();
        continue;
        label102:
        m();
      }
    }
  }
  
  @WorkerThread
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramBoolean, a());
    ThreadManager.getUIHandler().post(new AEBottomListPart.7(this, (List)localObject));
    localObject = this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramString2, a());
    if ((a(paramString1, paramString2)) && (localObject != null) && (!((AEMaterialMetaData)localObject).f) && (!((AEMaterialMetaData)localObject).e))
    {
      if (NetworkUtil.g(this.mActivity)) {
        break label132;
      }
      AEQLog.b("AEBottomListPart", "loadAndHandleData---no network");
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.getUIHandler().post(new AEBottomListPart.8(this));
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new AEBottomListPart.10(this, paramString1, paramString2));
      return;
      label132:
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.getApp(), (AEMaterialMetaData)localObject, new AEBottomListPart.9(this));
      AEQLog.b("AEBottomListPart", "wait till takeSameMaterial download finish, BEGIN");
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
        AEQLog.b("AEBottomListPart", "wait till takeSameMaterial download finish, OVER");
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (!paramString1.equals(AECaptureMode.NORMAL.name)) {}
    }
    else
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool1 = bool2;
        if (!paramString2.startsWith("http")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(String paramString)
  {
    AEQLog.b("AEBottomListPart", "handleTakeSameH5Enter---url=" + paramString);
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", URLDecoder.decode(paramString, "UTF-8"));
      localIntent.putExtra("loc_play_show_material_id", paramString);
      if (this.mActivity.getIntent().hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", this.mActivity.getIntent().getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      }
      for (;;)
      {
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.J.a());
        localIntent.putExtra("VIDEO_STORY_ACTIVITY_ID", this.mActivity.getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID"));
        this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().startActivity(localIntent);
        this.mActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
        return;
        localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", this.mActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
      }
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean b()
  {
    Boolean localBoolean;
    if ((this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel != null) && (this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a() != null))
    {
      localBoolean = (Boolean)this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().getValue();
      if (localBoolean == null) {}
    }
    for (boolean bool = localBoolean.booleanValue();; bool = true) {
      return (!c()) && (this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.b()) && (bool);
    }
  }
  
  private boolean c()
  {
    return (this.mActivity != null) && ((AECameraEntry.g(this.mActivity.getIntent())) || (AECameraEntry.i(this.mActivity.getIntent())) || (AECameraEntry.j(this.mActivity.getIntent())));
  }
  
  private void j()
  {
    if (!b()) {
      return;
    }
    ViewAnimator.a(new View[] { this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new AEBottomListPart.4(this)).b();
  }
  
  private void k()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog == null)
      {
        this.jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog = new AECameraCancelableProgressDialog(this.mActivity);
        this.jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog.a(new AEBottomListPart.6(this));
      }
      this.jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog.show();
    }
  }
  
  private void l()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog != null) && (this.jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog.isShowing())) {
      this.jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog.dismiss();
    }
  }
  
  private void m()
  {
    int i = 0;
    AEMaterialMetaData localAEMaterialMetaData = AEMaterialManager.a();
    if (localAEMaterialMetaData != null)
    {
      int j = a(localAEMaterialMetaData.jdField_a_of_type_JavaLangString);
      i = j;
      if (j == -1)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(localAEMaterialMetaData);
        i = 1;
      }
    }
    if (i < this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.getItemCount()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.scrollToPosition(i);
    }
  }
  
  private void n()
  {
    if ((AEMaterialManager.a() != null) && (AEMaterialManager.a().jdField_a_of_type_Boolean)) {
      AEMaterialManager.a().b = true;
    }
  }
  
  private void o()
  {
    int j = 0;
    AEMaterialMetaData localAEMaterialMetaData1 = AEMaterialManager.a();
    if (localAEMaterialMetaData1 != null)
    {
      AEMaterialMetaData localAEMaterialMetaData2 = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(this.jdField_a_of_type_Int);
      int i = j;
      if (localAEMaterialMetaData2 != null)
      {
        i = j;
        if (localAEMaterialMetaData1.jdField_a_of_type_JavaLangString.equals(localAEMaterialMetaData2.jdField_a_of_type_JavaLangString))
        {
          c(this.jdField_a_of_type_Int);
          return;
        }
      }
      do
      {
        i += 1;
        if (i >= this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.getItemCount()) {
          break;
        }
        localAEMaterialMetaData2 = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(i);
      } while ((localAEMaterialMetaData2 == null) || (!localAEMaterialMetaData1.jdField_a_of_type_JavaLangString.equals(localAEMaterialMetaData2.jdField_a_of_type_JavaLangString)));
      c(i);
      return;
    }
    c(0);
    return;
    c(this.jdField_a_of_type_Int);
  }
  
  private void p()
  {
    String str = AECameraPrefsUtil.a().a("sp_key_ae_user_selected_watermark", "", 0);
    if (!"sp_val_ae_user_selected_watermark_none".equals(str))
    {
      AEQLog.b("AEBottomListPart", "recoverLastWatermark---materialId=" + str);
      AEBaseDataReporter.a().as();
      ThreadManager.excute(new AEBottomListPart.16(this, str), 64, null, true);
    }
  }
  
  public AEMaterialManager a()
  {
    return this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a();
    AEBaseReportParam.a().h();
    AEBaseDataReporter.a().Z();
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2, @Nullable AEBottomListAdapter.ViewHolder paramViewHolder1, @Nullable AEBottomListAdapter.ViewHolder paramViewHolder2) {}
  
  protected void a(int paramInt)
  {
    int i = UIUtils.a(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { 0.0F, i });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new AEBottomListPart.12(this));
    localAnimatorSet.setDuration(300L).start();
    b(paramInt);
  }
  
  public void a(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.a(4);
    if ((!"call_material_id".equals(paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a()) && (paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_Boolean))
    {
      paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.b = false;
      paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.c = false;
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(false);
  }
  
  public void a(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.b) {
      paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.c = true;
    }
    for (;;)
    {
      if ((!"call_material_id".equals(paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (AEMaterialManager.a() != null) && (!AEMaterialManager.a().equals(paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData)))
      {
        AEMaterialManager.a().b = false;
        AEMaterialManager.a().c = false;
      }
      return;
      paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.b = true;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData != null) {
      return paramAEMaterialMetaData.a();
    }
    return false;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEBottomListPart.2(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEBottomListPart.3(this));
  }
  
  protected void b(int paramInt)
  {
    Animation localAnimation = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 1.0F, 0.0F);
    localAnimation.setStartOffset(0L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new AEBottomListPart.13(this, paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void b(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (!"call_material_id".equals(paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = paramInt;
      paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.b = true;
      if ((AEMaterialManager.a() != null) && (!AEMaterialManager.a().equals(paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData)))
      {
        AEMaterialManager.a().b = false;
        AEMaterialManager.a().c = false;
      }
    }
    QLog.d("AEBottomListPart", 4, "prePosition:" + this.jdField_a_of_type_Int);
  }
  
  protected void c()
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {
      return;
    }
    Intent localIntent = this.mActivity.getIntent();
    String str1 = localIntent.getStringExtra("KEY_CURRENT_SELECT_ID");
    String str2 = localIntent.getStringExtra("KEY_CURRENT_TAB");
    if ("null".equalsIgnoreCase(str1)) {
      str1 = null;
    }
    for (;;)
    {
      boolean bool = a(str2, str1);
      if (bool)
      {
        ((AEMaterialManager)QIMManager.a(18)).a(str1);
        AEMaterialMetaData localAEMaterialMetaData = this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(str1, a());
        if ((localAEMaterialMetaData != null) && (localAEMaterialMetaData.e))
        {
          bool = false;
          if (bool)
          {
            k();
            if (this.jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog != null) {
              this.jdField_a_of_type_DovComQqImAeViewAECameraCancelableProgressDialog.a(10);
            }
          }
          localIntent.removeExtra("KEY_CURRENT_SELECT_ID");
          localIntent.removeExtra("KEY_CURRENT_TAB");
        }
      }
      for (;;)
      {
        ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEBottomListPart.5(this, str2, str1, bool));
        return;
        break;
      }
    }
  }
  
  protected void c(int paramInt)
  {
    AEQLog.a("AEBottomListPart", "reset Selection pos: " + paramInt);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a(paramInt, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(paramInt));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.invalidate();
  }
  
  public void c(@Nullable AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null)
    {
      paramViewHolder.a(3);
      paramViewHolder = paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
      WatermarkDataManager.a().a(paramViewHolder);
      if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter != null)
      {
        if (!a(paramViewHolder)) {
          break label46;
        }
        WeishiGuideUtils.a(this.mActivity, paramViewHolder);
      }
    }
    return;
    label46:
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.b(paramViewHolder);
  }
  
  @TargetApi(12)
  protected void d()
  {
    int i = UIUtils.a(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getHeight());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, "translationY", new float[] { i, 0.0F }));
    localAnimatorSet.addListener(new AEBottomListPart.11(this));
    localAnimatorSet.setDuration(300L).start();
    h();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.a(327683, new Object[0]);
        this.mPartManager.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().a(true, 150);
      return;
    }
    a(327683);
  }
  
  protected void f() {}
  
  protected void g()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a())
    {
      if (this.mPartManager != null)
      {
        this.mPartManager.a(327684, new Object[0]);
        this.mPartManager.a(196612, new Object[0]);
      }
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().a(true, 150);
      return;
    }
    a(327684);
  }
  
  protected void h()
  {
    Animation localAnimation = QIMAnimationUtils.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, 0.0F, 1.0F);
    localAnimation.setStartOffset(200L);
    localAnimation.setDuration(100L);
    localAnimation.setAnimationListener(new AEBottomListPart.14(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.startAnimation(localAnimation);
  }
  
  public void i()
  {
    if (AEPlayShowGridAdapter.selectedMidMaterialNotConsumed())
    {
      a(AEPlayShowGridAdapter.selectedMidMaterial);
      AEPlayShowGridAdapter.onSelectedMidMaterialConsumed();
    }
  }
  
  public void initView()
  {
    if (this.mRootView != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)((ViewStub)this.mRootView.findViewById(2131378584)).inflate().findViewById(2131374473));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new ScaleTransformer.Builder().a(0.88F).a());
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setLayoutCallback(this);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter = new AEBottomListAdapter(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(new AEBottomListPart.1(this));
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter);
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager = ((AEMaterialManager)QIMManager.a().c(18));
      if (c()) {
        break label243;
      }
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 113);
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 114);
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 115);
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 112);
      a();
      c();
    }
    for (;;)
    {
      b();
      return;
      label243:
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.b();
    }
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    AEQLog.a("AEBottomListPart", "AEBottomListPart notify---eventId=" + paramInt);
    if (paramInt == 113)
    {
      paramObject = AEMaterialManager.a();
      if ((paramObject == null) || (paramObject.equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData)))
      {
        c(0);
        if (a()) {
          p();
        }
        QLog.d("AEBottomListPart", 4, "current pendant has change");
      }
    }
    label266:
    do
    {
      for (;;)
      {
        return;
        a(paramObject);
        break;
        if (paramInt == 1024)
        {
          QLog.d("AEBottomListPart", 4, "current watermark has change");
          c(0);
          return;
        }
        if (paramInt == 114)
        {
          paramObject = AEMaterialManager.a();
          if ((paramObject != null) && (!paramObject.equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData))) {
            paramObject.jdField_a_of_type_Boolean = true;
          }
          a(paramObject);
          return;
        }
        if (paramInt == 115)
        {
          paramObject = AEMaterialManager.a();
          if (paramObject != null) {
            paramObject.jdField_a_of_type_Boolean = false;
          }
          a(paramObject);
          return;
        }
        if (paramInt != 112) {
          break label266;
        }
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
        {
          paramObject = (AEMaterialMetaData)paramVarArgs[0];
          paramInt = 0;
          while (paramInt < this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.getItemCount())
          {
            paramVarArgs = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(paramInt);
            if ((paramVarArgs != null) && (paramObject.jdField_a_of_type_JavaLangString.equals(paramVarArgs.jdField_a_of_type_JavaLangString)))
            {
              paramVarArgs.e = true;
              paramVarArgs.f = false;
              this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.notifyItemChanged(paramInt);
              return;
            }
            paramInt += 1;
          }
        }
      }
    } while (paramInt != 116);
    AEQLog.b("AEBottomListPart", "notify---TEMPLATE_INFO_LIST_UPDATE");
    ThreadManager.getUIHandler().post(new AEBottomListPart.15(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (b()) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(0);
    }
  }
  
  public void onActivityResume()
  {
    if ((AEMaterialManager.a() != null) && (!AEMaterialManager.a().c()) && (this.mActivity.getIntent().getStringExtra("widgetinfo") == null)) {
      this.mActivity.getIntent().putExtra("widgetinfo", "camera^" + AEMaterialManager.a().jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.f();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.c();
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 131076: 
    case 131077: 
    case 131075: 
      do
      {
        return;
        e();
        return;
        g();
        return;
        this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.b().postValue(Boolean.valueOf(false));
        this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.d().postValue(Boolean.valueOf(false));
        this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.c().postValue(Boolean.valueOf(false));
        n();
      } while ((!this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.b()) || (c()));
      o();
      d();
      return;
    }
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.d().postValue(Boolean.valueOf(true));
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart
 * JD-Core Version:    0.7.0.1
 */