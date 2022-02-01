package dov.com.qq.im.ae.camera.ui.tips;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.tips.AETipsManager;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.libpag.PAGView;

public class AETipsViewController
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new AETipsViewController.TipsHandler(this, null);
  private final ViewStub jdField_a_of_type_AndroidViewViewStub;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit;
  private FaceDetectTipGifViewStubHolder jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder;
  private FaceDetectTipViewStubHolder jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder;
  private MaterialTipsViewStubHolder jdField_a_of_type_DovComQqImAeCameraUiTipsMaterialTipsViewStubHolder;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel;
  private String jdField_a_of_type_JavaLangString;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g;
  
  public AETipsViewController(View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder = new FaceDetectTipViewStubHolder((ViewStub)paramView.findViewById(2131378589));
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder = new FaceDetectTipGifViewStubHolder((ViewStub)paramView.findViewById(2131378590));
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsMaterialTipsViewStubHolder = new MaterialTipsViewStubHolder((ViewStub)paramView.findViewById(2131378600));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131378599));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AETipsViewController.1(this));
    paramView = new HashMap();
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.MOUTH_OPEN.value), "张开你的嘴");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.EYEBROWS_RAISE.value), "挑动你的眉毛");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK.value), "眨眨你的眼睛");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_SHAKE.value), "摇一摇你的头");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.KISS.value), "嘟起你的嘴");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK_LEFT_EYE.value), "眨眨你的左眼");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.BLINK_RIGHT_EYE.value), "眨眨你的右眼");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_NOD.value), "点一点你的头");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.HEAD_SHAKE_NEW.value), "摇一摇你的头");
    paramView.put(Integer.valueOf(PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value), "点击屏幕试试");
    AETipsManager.getInstance().updateActionTipsString(paramView);
  }
  
  private void b(VideoMaterial paramVideoMaterial)
  {
    k();
    if (paramVideoMaterial == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
    AETipsManager.getInstance().setVideoMaterial(paramVideoMaterial);
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().post(new AETipsViewController.2(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY)
      {
        b();
        return;
      }
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
        this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder.b();
        return;
      }
    } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF);
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder.c();
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder.b();
  }
  
  private void i()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY) {
      b();
    }
    label85:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
            break label85;
          }
          this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
          if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) || (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needFaceInfo())) {
            break;
          }
        } while (!this.d);
        this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder.c();
        j();
        return;
        this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder.c();
        j();
        return;
      } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF);
      this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder.c();
      if ((this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) || (!this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial.needFaceInfo())) {
        break;
      }
    } while (!this.d);
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
    j();
    return;
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
    j();
  }
  
  private void j()
  {
    MaterialTipsViewStubHolder localMaterialTipsViewStubHolder;
    String str;
    if (!this.g)
    {
      localMaterialTipsViewStubHolder = this.jdField_a_of_type_DovComQqImAeCameraUiTipsMaterialTipsViewStubHolder;
      str = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label44;
      }
    }
    label44:
    for (Bitmap localBitmap = null;; localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      localMaterialTipsViewStubHolder.a(str, localBitmap, 3000);
      this.g = true;
      return;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder.c();
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    this.g = false;
    b(paramVideoMaterial);
    g();
  }
  
  public void a(String paramString, int paramInt)
  {
    AEQLog.a("AETipsViewController", "showPagTip: pagPath=" + paramString + ", duration=" + paramInt);
    if (this.jdField_a_of_type_OrgLibpagPAGView == null) {
      this.jdField_a_of_type_OrgLibpagPAGView = ((PAGView)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
    this.jdField_a_of_type_OrgLibpagPAGView.setPath(paramString);
    this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(1);
    this.jdField_a_of_type_OrgLibpagPAGView.addListener(new AETipsViewController.3(this));
    this.jdField_a_of_type_OrgLibpagPAGView.setVisibility(0);
    this.jdField_a_of_type_OrgLibpagPAGView.setProgress(0.0D);
    this.jdField_a_of_type_OrgLibpagPAGView.play();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    AEQLog.a("AETipsViewController", "showNormalTip: tip=" + paramString1 + ", icon=" + paramString2 + ", duration=" + paramInt);
    paramString2 = BitmapUtils.decodeSampleBitmap(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a(), paramString2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsMaterialTipsViewStubHolder.a(paramString1, paramString2, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
    if ((this.jdField_b_of_type_Boolean != this.c) || (this.d != this.e))
    {
      QLog.d("AETipsViewController", 4, "### onDetectStateChange, materialNeedFace=" + paramBoolean1 + ", hasFaceDetected=" + paramBoolean2);
      this.c = this.jdField_b_of_type_Boolean;
      this.e = this.d;
      g();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder.c();
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder.c();
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsMaterialTipsViewStubHolder.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipViewStubHolder.d();
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsFaceDetectTipGifViewStubHolder.d();
  }
  
  public void d()
  {
    QLog.d("AETipsViewController", 4, "### onChangeCameraByMaterial");
    if (this.jdField_a_of_type_Boolean) {
      g();
    }
  }
  
  public void e()
  {
    AEQLog.a("AETipsViewController", "hideNormalTip: ");
    this.jdField_a_of_type_DovComQqImAeCameraUiTipsMaterialTipsViewStubHolder.b();
  }
  
  public void f()
  {
    AEQLog.a("AETipsViewController", "hidePagTip: ");
    if (this.jdField_a_of_type_OrgLibpagPAGView == null) {
      return;
    }
    if (this.jdField_a_of_type_OrgLibpagPAGView.isPlaying()) {
      this.jdField_a_of_type_OrgLibpagPAGView.stop();
    }
    this.jdField_a_of_type_OrgLibpagPAGView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.tips.AETipsViewController
 * JD-Core Version:    0.7.0.1
 */