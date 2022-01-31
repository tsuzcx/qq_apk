import com.tencent.av.VideoController;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.effect.beauty.Beauty20Render;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.BeautyNative;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lrp
{
  int jdField_a_of_type_Int = 0;
  Beauty20Render jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = null;
  BeautyRender jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
  int b = 0;
  
  public lrp()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVSDKBeautyRender", 2, "AVSDKBeautyRender");
    }
  }
  
  public Beauty20Render a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b = 0;
      return null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = new Beauty20Render(VideoController.a().a());
    }
    if (paramInt == this.b) {
      return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render;
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render.setBeautyLevel(paramInt * 1.0F / 100.0F);
    this.b = paramInt;
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render;
  }
  
  public BeautyRender a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Int = 0;
      return null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = new BeautyRender(VideoController.a().a(), len.h());
    }
    if (paramInt == this.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.setBeautyLevel(paramInt * 1.0F / 100.0F * lrw.a());
    this.jdField_a_of_type_Int = paramInt;
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
  }
  
  public lsk a(int paramInt1, int paramInt2, lsk paramlsk, FilterDesc paramFilterDesc, int paramInt3)
  {
    if (!lrw.a()) {}
    BeautyRender localBeautyRender;
    do
    {
      do
      {
        return paramlsk;
      } while ((paramFilterDesc != null) && (paramFilterDesc.id == 3));
      localBeautyRender = a(paramInt3);
    } while (localBeautyRender == null);
    GraphicRenderMgr.getInstance().setBeautyFlag(2);
    if ((paramFilterDesc != null) && ((paramFilterDesc.id == 1) || (paramFilterDesc.id == 2))) {
      localBeautyRender.setNeedSkinColor(false);
    }
    for (;;)
    {
      paramlsk = localBeautyRender.process(paramlsk.b, paramlsk.jdField_a_of_type_Int, paramInt1, paramInt2);
      return lsk.a(paramlsk.getFbo(), paramlsk.getTextureId());
      localBeautyRender.setNeedSkinColor(true);
    }
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVSDKBeautyRender", 2, "destroy");
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(0);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (!AudioHelper.e()) {
        return;
      }
      QLog.w("AVSDKBeautyRender", 1, "setBeautyLevel, UnsatisfiedLinkError");
      return;
      GraphicRenderMgr.getInstance().setBeautyFlag(1);
    }
    if (lrw.a())
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(2);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (lrw.a())
    {
      bool1 = bool2;
      if (paramInt > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public byte[] a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, FilterDesc paramFilterDesc, int paramInt3)
  {
    if (lrw.a()) {}
    while ((paramFilterDesc != null) && (paramFilterDesc.id == 3)) {
      return paramArrayOfByte;
    }
    if (paramInt2 * paramInt1 * 3 / 2 != paramArrayOfByte.length)
    {
      lek.e("AVSDKBeautyRender", "(mHeight * mWidth * 3 / 2) != yuvData.length");
      return paramArrayOfByte;
    }
    paramFilterDesc = a(paramInt3);
    EffectFrame localEffectFrame1;
    if (paramFilterDesc != null)
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(1);
      localEffectFrame1 = new EffectFrame();
      localEffectFrame1.frameData = paramArrayOfByte;
      localEffectFrame1.frameWidth = paramInt2;
      localEffectFrame1.frameHeight = paramInt1;
      if (llz.m == 17)
      {
        paramArrayOfByte = ColorFormat.NV21;
        localEffectFrame1.frameFormat = paramArrayOfByte;
        EffectFrame localEffectFrame2 = paramFilterDesc.processData(localEffectFrame1);
        paramFilterDesc = localEffectFrame2.frameData;
        paramArrayOfByte = paramFilterDesc;
        if (localEffectFrame2.frameFormat != ColorFormat.I420) {}
      }
    }
    for (;;)
    {
      try
      {
        if (llz.m == 17)
        {
          paramArrayOfByte = BeautyNative.convertI420ToNV21(paramFilterDesc, paramInt2, paramInt1);
          return paramArrayOfByte;
          paramArrayOfByte = ColorFormat.NV12;
          break;
        }
        paramArrayOfByte = BeautyNative.convertI420ToNV12(paramFilterDesc, paramInt2, paramInt1);
      }
      catch (Throwable paramArrayOfByte)
      {
        lek.e("AVSDKBeautyRender", "convertI420ToNV21 or convertI420ToNV12 e = " + paramArrayOfByte.getMessage());
        paramArrayOfByte = localEffectFrame1.frameData;
      }
    }
  }
  
  public void b()
  {
    GraphicRenderMgr.getInstance().setBeautyFlag(0);
    if (QLog.isColorLevel()) {
      QLog.i("AVSDKBeautyRender", 2, "clear");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrp
 * JD-Core Version:    0.7.0.1
 */