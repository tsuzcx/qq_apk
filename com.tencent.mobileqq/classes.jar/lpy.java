import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.qphone.base.util.QLog;

public class lpy
{
  private DenoiseRender jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  private LowLightRender jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  private String jdField_a_of_type_JavaLangString;
  private final lpq jdField_a_of_type_Lpq;
  public boolean a;
  public int[] a;
  
  private lpx a(lpx paramlpx)
  {
    if (!lpz.c()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    do
    {
      return paramlpx;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfInt[3] = 0;
        return paramlpx;
      }
      localObject = a();
    } while (localObject == null);
    this.jdField_a_of_type_Lpq.a(4);
    paramlpx = ((DenoiseRender)localObject).process(paramlpx.jdField_b_of_type_Int, paramlpx.jdField_a_of_type_Int, this.jdField_a_of_type_Lpq.jdField_a_of_type_Int, this.jdField_a_of_type_Lpq.jdField_b_of_type_Int);
    paramlpx = lpx.a(paramlpx.getFbo(), paramlpx.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[3] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[5] += 1;
    return paramlpx;
  }
  
  private lpx a(lpx paramlpx, boolean paramBoolean)
  {
    if (!lpz.b()) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    do
    {
      return paramlpx;
      if ((!this.jdField_a_of_type_Boolean) || (paramBoolean))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        return paramlpx;
      }
      localObject = a();
    } while (localObject == null);
    this.jdField_a_of_type_Lpq.a(2);
    paramlpx = ((LowLightRender)localObject).process(paramlpx.jdField_b_of_type_Int, paramlpx.jdField_a_of_type_Int, this.jdField_a_of_type_Lpq.jdField_a_of_type_Int, this.jdField_a_of_type_Lpq.jdField_b_of_type_Int);
    paramlpx = lpx.a(paramlpx.getFbo(), paramlpx.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[2] += 1;
    return paramlpx;
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if ((lpz.b()) || (lpz.c()))
    {
      this.jdField_a_of_type_Lpq.a(1);
      paramArrayOfByte = a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte, (int)paramLong);
      j = paramArrayOfByte[0];
      i = paramArrayOfByte[1];
    }
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfInt;
    if (j == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.jdField_a_of_type_Boolean) && (bool))
      {
        if (!paramBoolean) {
          paramArrayOfByte[1] += 1;
        }
        paramArrayOfByte[4] += 1;
        lbj.a(this.jdField_a_of_type_JavaLangString, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        lbj.a(this.jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
      }
      paramArrayOfByte[6] = i;
      if (j == 0)
      {
        paramArrayOfByte[0] = 0;
        paramArrayOfByte[3] = 0;
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(paramArrayOfByte);
      }
      paramArrayOfByte[7] = ((int)paramLong);
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private boolean a()
  {
    if (!lpz.c()) {}
    while (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!lpz.b()) {}
    while ((!this.jdField_a_of_type_Boolean) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    if (lje.jdField_a_of_type_Int * lje.jdField_b_of_type_Int * 3 / 2 != paramArrayOfByte.length)
    {
      lbj.e(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    try
    {
      paramString = LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt, lje.jdField_a_of_type_Int, lje.jdField_b_of_type_Int, 60, 0.75F);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "detectLowLightProcess", paramString);
        paramString = arrayOfInt;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "detectLowLightProcess", paramString);
        paramString = arrayOfInt;
      }
    }
  }
  
  public DenoiseRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(this.jdField_a_of_type_Lpq.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(lpz.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(this.jdField_a_of_type_Lpq.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
    }
  }
  
  public void a(msy parammsy, lpc paramlpc, msb parammsb)
  {
    if (parammsy != null) {
      parammsy.a("checkLowLight");
    }
    a(paramlpc.jdField_a_of_type_ArrayOfByte, paramlpc.jdField_a_of_type_Long, paramlpc.jdField_a_of_type_Boolean);
    if (parammsb != null) {
      parammsb.e();
    }
    if (parammsy != null) {
      parammsy.b("checkLowLight");
    }
  }
  
  public void a(msy parammsy, msb parammsb)
  {
    this.jdField_a_of_type_Lpq.c();
    if (a())
    {
      if (parammsy != null) {
        parammsy.a("appleVideoDeNoise");
      }
      this.jdField_a_of_type_Lpq.jdField_b_of_type_Lpx = a(this.jdField_a_of_type_Lpq.jdField_a_of_type_Lpx);
      if (parammsb != null) {
        if (this.jdField_a_of_type_Lpq.jdField_b_of_type_Lpx.jdField_b_of_type_Int == this.jdField_a_of_type_Lpq.jdField_a_of_type_Lpx.jdField_b_of_type_Int) {
          break label110;
        }
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      parammsb.b(bool);
      if (parammsy != null) {
        parammsy.b("appleVideoDeNoise");
      }
      this.jdField_a_of_type_Lpq.a(6, this.jdField_a_of_type_Lpq.jdField_a_of_type_Lpx, this.jdField_a_of_type_Lpq.jdField_b_of_type_Lpx);
      return;
    }
  }
  
  public void b(msy parammsy, lpc paramlpc, msb parammsb)
  {
    this.jdField_a_of_type_Lpq.c();
    if (a(paramlpc.jdField_a_of_type_Boolean))
    {
      if (parammsy != null) {
        parammsy.a("appleLowLightEnhance");
      }
      this.jdField_a_of_type_Lpq.jdField_b_of_type_Lpx = a(this.jdField_a_of_type_Lpq.jdField_a_of_type_Lpx, paramlpc.jdField_a_of_type_Boolean);
      if (parammsy != null) {
        parammsy.b("appleLowLightEnhance");
      }
      this.jdField_a_of_type_Lpq.a(7, this.jdField_a_of_type_Lpq.jdField_a_of_type_Lpx, this.jdField_a_of_type_Lpq.jdField_b_of_type_Lpx);
    }
    GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
    if (parammsb != null) {
      if (this.jdField_a_of_type_Lpq.jdField_b_of_type_Lpx.jdField_b_of_type_Int == this.jdField_a_of_type_Lpq.jdField_a_of_type_Lpx.jdField_b_of_type_Int) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      parammsb.c(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpy
 * JD-Core Version:    0.7.0.1
 */