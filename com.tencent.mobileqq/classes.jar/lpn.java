import android.content.Context;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.camera.CameraUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public class lpn
  implements lpl
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AESticker jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker;
  private volatile Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private PendantItem jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private final lqo jdField_a_of_type_Lqo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = true;
  private int e = -1;
  
  public lpn(Context paramContext, lqo paramlqo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Lqo = paramlqo;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterOldWrapper", 4, "AEFilterOldWrapper, useAVSDKBeauty[" + this.jdField_c_of_type_Boolean + "], useGestureDetect[" + this.jdField_d_of_type_Boolean + "]");
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      int i = paramInt;
      if (paramInt > 95) {
        i = 95;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().updatePtuBeautyFilter(i);
    }
  }
  
  private void a(int paramInt, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        GestureMgrRecognize.getInstance().start();
        this.jdField_a_of_type_Boolean = true;
        GestureFilterManager.sLayoutType = GestureFilterManager.GestureFilterManager_Layout_AV;
      }
      GestureFilterManager.sGestureType = paramPendantItem.getGestureType();
      b(paramInt);
      this.jdField_a_of_type_Lqo.a(paramPendantItem.getGestureType());
      return;
    }
    this.jdField_a_of_type_Lqo.a();
    if (this.jdField_a_of_type_Boolean)
    {
      GestureMgrRecognize.getInstance().stop();
      this.jdField_a_of_type_Boolean = false;
      GestureFilterManager.sLayoutType = GestureFilterManager.GestureFilterManager_Layout_None;
    }
    GestureFilterManager.sGestureType = "";
  }
  
  private void b(int paramInt)
  {
    GestureMgrRecognize.getInstance().setRecognizeMillis(Long.valueOf(PtvTemplateManager.h).longValue());
    GestureMgrRecognize.getInstance().setRecognizeFrameRate(Integer.valueOf(PtvTemplateManager.g).intValue());
    int i = (int)(this.jdField_a_of_type_Int * 0.25F);
    int j = (int)(this.jdField_b_of_type_Int * 0.25F);
    GestureMgrRecognize.getInstance().transferRGBAbuffer(paramInt, i, j, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().clearPtvVideoActiveFilter();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.initAEDetector_sync();
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasAEDetectorInited());
    QLog.e("AEFilterOldWrapper", 1, "initFaceDetectorSDK_Sync failed!");
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
      return;
    }
    QQFilterRenderManager.ChainBuilder localChainBuilder = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getChainBuilder();
    localChainBuilder.setUseSort(true);
    localChainBuilder.addFilter(25, null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setBackCameraDetectEnable(true);
    localChainBuilder.addFilter(40, null);
    localChainBuilder.addFilter(184, null);
    localChainBuilder.commit();
    QLog.w("AEFilterOldWrapper", 1, "commitChainBuilder");
  }
  
  public int a(int paramInt, boolean paramBoolean1, lqc paramlqc, boolean paramBoolean2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null) {
      return paramInt;
    }
    if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null) || (this.jdField_b_of_type_Boolean))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasAEDetectorInited()) || (!this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getFaceDetectFlags())) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setFaceDetectFlags(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setPtvNeedFlip(false);
      lqn.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasAEDetectorInited());
    }
    for (;;)
    {
      paramBoolean1 = bool;
      if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker != null)
      {
        paramBoolean1 = bool;
        if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null)
        {
          paramBoolean1 = bool;
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.hasGesture()) {
            paramBoolean1 = true;
          }
        }
      }
      a(paramInt, this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramBoolean1);
      int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.drawFrame(paramInt);
      if ((!this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.needFaceDetect()) && (this.jdField_b_of_type_Boolean))
      {
        e();
        if ((this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame == null) || (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.getFBO() != this.jdField_d_of_type_Int) || (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.width != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.height != this.jdField_b_of_type_Int)) {
          this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame(this.jdField_d_of_type_Int, this.e, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setFaceDetectFlags(true);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.initDetectFaceSDK(this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      }
      paramInt = i;
      if (paramlqc == null) {
        break;
      }
      paramlqc.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getFaceAttr(), (float)this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getWindowScale(), paramBoolean2);
      return i;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setFaceDetectFlags(false);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffect(null);
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = null;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setPtvVideoFilter(null);
    }
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = new QQFilterRenderManager();
      if (!axlc.a(BaseApplicationImpl.getContext())) {
        break label69;
      }
      f();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.cameraInterFace == null)) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.cameraInterFace = liq.a();
      }
      return;
      label69:
      QLog.w("AEFilterOldWrapper", 1, "initial, isLoadedSO fail");
    }
  }
  
  public void a(long paramLong)
  {
    QLog.w("AEFilterOldWrapper", 1, "clearState, seq[" + paramLong + "]");
    this.jdField_a_of_type_Lqo.a(paramLong);
    if (this.jdField_a_of_type_Boolean)
    {
      GestureMgrRecognize.getInstance().stop();
      this.jdField_a_of_type_Boolean = false;
    }
    GestureFilterManager.sLayoutType = GestureFilterManager.GestureFilterManager_Layout_None;
    GestureFilterManager.sGestureType = "";
  }
  
  public void a(PendantItem paramPendantItem, VideoMaterial paramVideoMaterial)
  {
    if ((paramPendantItem != null) && (paramPendantItem.hasGesture()) && (!this.jdField_d_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterOldWrapper", 2, "setPendant, not support gesture pendant.");
      }
    }
    do
    {
      do
      {
        return;
      } while ((lqn.a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramPendantItem)) && (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == paramVideoMaterial));
      QLog.d("AEFilterOldWrapper", 1, "setPendant[" + paramPendantItem + "]");
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.hasAEDetectorInited())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AEFilterOldWrapper", 2, "initFaceDetectorSDK_Sync failed!");
    return;
    if ((paramPendantItem != null) && (paramPendantItem.hasGesture()) && (paramVideoMaterial != null))
    {
      paramVideoMaterial.mHasGestureFilter = true;
      if (!paramPendantItem.hasFace()) {
        paramVideoMaterial.isNeedDecodeFaceFilter = false;
      }
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = paramPendantItem;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) {
      d();
    }
    for (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = new AESticker(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial, this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getFaceDetector());; this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setPtvVideoFilter(this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker, this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      return;
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    if (!lqn.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramFilterDesc))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffect(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
    }
  }
  
  public void a(lpz paramlpz, lqc paramlqc)
  {
    String str2 = "";
    String str1 = "";
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null)
    {
      str2 = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getGestureType();
      str1 = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getGestureWording();
    }
    for (boolean bool1 = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.hasFace();; bool1 = false)
    {
      boolean bool2 = liq.a().b();
      if ((liv.a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial)) && (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        this.jdField_a_of_type_Lqo.a(paramlpz, paramlqc.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, bool1, str1, str2);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.hasGesture());
  }
  
  public boolean a(lps paramlps)
  {
    boolean bool = false;
    if (paramlps != null) {}
    for (int i = paramlps.a("BEAUTY_SKIN");; i = 0)
    {
      if (this.jdField_c_of_type_Int != i)
      {
        a(i);
        this.jdField_c_of_type_Int = i;
      }
      if (this.jdField_c_of_type_Int == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setFilterEffect(null);
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAESticker = null;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.getBusinessOperation().setPtvVideoFilter(null);
    }
    GestureMgrRecognize.getInstance().stop();
    this.jdField_a_of_type_Boolean = false;
    GestureFilterManager.sLayoutType = GestureFilterManager.GestureFilterManager_Layout_None;
    GestureFilterManager.sGestureType = "";
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceCreate(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceChange(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      String str = "null camera";
      if (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(0L))
      {
        str = String.valueOf(CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.setParam("key_front_camera", str);
      }
      lcl.c("AEFilterOldWrapper", "mQQFilterRenderManager surfaceChange" + str);
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.needFaceDetect();
    }
    return bool;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null) {
      f();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.e = paramInt2;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpn
 * JD-Core Version:    0.7.0.1
 */