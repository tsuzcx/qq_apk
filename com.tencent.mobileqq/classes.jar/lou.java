import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.effect.beauty.Beauty20Render;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.BeautyNative;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class lou
{
  int jdField_a_of_type_Int = 0;
  Beauty20Render jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = null;
  BeautyRender jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
  int b = 0;
  
  public lou()
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
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = new Beauty20Render(BaseApplicationImpl.getContext());
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
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = new BeautyRender(BaseApplicationImpl.getContext(), lbh.h());
    }
    if (paramInt == this.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.setBeautyLevel(paramInt * 1.0F / 100.0F * lpb.a());
    this.jdField_a_of_type_Int = paramInt;
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
  }
  
  public lps a(int paramInt1, int paramInt2, lps paramlps, FilterDesc paramFilterDesc, int paramInt3)
  {
    if (!lpb.a()) {}
    BeautyRender localBeautyRender;
    do
    {
      do
      {
        return paramlps;
      } while ((paramFilterDesc != null) && (paramFilterDesc.id == 3));
      localBeautyRender = a(paramInt3);
    } while (localBeautyRender == null);
    GraphicRenderMgr.getInstance().setBeautyFlag(2);
    if ((paramFilterDesc != null) && ((paramFilterDesc.id == 1) || (paramFilterDesc.id == 2))) {
      localBeautyRender.setNeedSkinColor(false);
    }
    for (;;)
    {
      paramlps = localBeautyRender.process(paramlps.b, paramlps.jdField_a_of_type_Int, paramInt1, paramInt2);
      return lps.a(paramlps.getFbo(), paramlps.getTextureId());
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
      if (!AudioHelper.f()) {
        return;
      }
      QLog.w("AVSDKBeautyRender", 1, "setBeautyLevel, UnsatisfiedLinkError");
      return;
      GraphicRenderMgr.getInstance().setBeautyFlag(1);
    }
    if (lpb.a())
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(2);
      return;
    }
  }
  
  public void a(lpl paramlpl, mte parammte, lox paramlox, msh parammsh, lqc paramlqc, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramlox.b()) {
      return;
    }
    if (parammte != null) {
      parammte.a("applyBeauty20");
    }
    byte[] arrayOfByte = paramlox.a;
    paramlox.a = a(paramInt1, paramInt2, paramlox.a, paramlqc.a, paramInt3);
    if (paramlox.a != arrayOfByte) {
      paramlpl.a(8);
    }
    if (parammsh != null) {
      if (paramlox.a == arrayOfByte) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      parammsh.a(bool);
      if (parammte != null) {
        parammte.b("applyBeauty20");
      }
      if (paramlpl.jdField_a_of_type_Lpn == null) {
        break;
      }
      paramlpl.jdField_a_of_type_Lpn.a(paramlpl, 10, paramlox, null);
      return;
    }
  }
  
  public void a(lpl paramlpl, mte parammte, msh parammsh, lqc paramlqc, int paramInt1, int paramInt2, int paramInt3)
  {
    paramlpl.c();
    if (parammte != null) {
      parammte.a("applyBeauty30");
    }
    paramlpl.b = a(paramInt1, paramInt2, paramlpl.jdField_a_of_type_Lps, paramlqc.a, paramInt3);
    if (paramlpl.b.b != paramlpl.jdField_a_of_type_Lps.b) {
      paramlpl.a(8);
    }
    if (parammsh != null) {
      if (paramlpl.b.b == paramlpl.jdField_a_of_type_Lps.b) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      parammsh.d(bool);
      if (parammte != null) {
        parammte.b("applyBeauty30");
      }
      paramlpl.a(8, paramlpl.jdField_a_of_type_Lps, paramlpl.b);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (lpb.a())
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
    if (lpb.a()) {}
    while ((paramFilterDesc != null) && (paramFilterDesc.id == 3)) {
      return paramArrayOfByte;
    }
    if (paramInt2 * paramInt1 * 3 / 2 != paramArrayOfByte.length)
    {
      lbd.h("AVSDKBeautyRender", "(mHeight * mWidth * 3 / 2) != yuvData.length");
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
      if (ljk.c == 17)
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
        if (ljk.c == 17)
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
        lbd.h("AVSDKBeautyRender", "convertI420ToNV21 or convertI420ToNV12 e = " + paramArrayOfByte.getMessage());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lou
 * JD-Core Version:    0.7.0.1
 */