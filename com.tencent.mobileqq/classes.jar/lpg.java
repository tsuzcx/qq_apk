import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.qphone.base.util.QLog;

public class lpg
{
  private DenoiseRender jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  private LowLightRender jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  private String jdField_a_of_type_JavaLangString;
  private final loy jdField_a_of_type_Loy;
  public boolean a;
  public int[] a;
  
  private lpf a(lpf paramlpf)
  {
    if (!lph.c()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    do
    {
      return paramlpf;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfInt[3] = 0;
        return paramlpf;
      }
      localObject = a();
    } while (localObject == null);
    this.jdField_a_of_type_Loy.a(4);
    paramlpf = ((DenoiseRender)localObject).process(paramlpf.jdField_b_of_type_Int, paramlpf.jdField_a_of_type_Int, this.jdField_a_of_type_Loy.jdField_a_of_type_Int, this.jdField_a_of_type_Loy.jdField_b_of_type_Int);
    paramlpf = lpf.a(paramlpf.getFbo(), paramlpf.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[3] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[5] += 1;
    return paramlpf;
  }
  
  private lpf a(lpf paramlpf, boolean paramBoolean)
  {
    if (!lph.b()) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    do
    {
      return paramlpf;
      if ((!this.jdField_a_of_type_Boolean) || (paramBoolean))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        return paramlpf;
      }
      localObject = a();
    } while (localObject == null);
    this.jdField_a_of_type_Loy.a(2);
    paramlpf = ((LowLightRender)localObject).process(paramlpf.jdField_b_of_type_Int, paramlpf.jdField_a_of_type_Int, this.jdField_a_of_type_Loy.jdField_a_of_type_Int, this.jdField_a_of_type_Loy.jdField_b_of_type_Int);
    paramlpf = lpf.a(paramlpf.getFbo(), paramlpf.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[2] += 1;
    return paramlpf;
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if ((lph.b()) || (lph.c()))
    {
      this.jdField_a_of_type_Loy.a(1);
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
        lba.d(this.jdField_a_of_type_JavaLangString, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        lba.d(this.jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
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
    if (!lph.c()) {}
    while (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!lph.b()) {}
    while ((!this.jdField_a_of_type_Boolean) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    if (liy.jdField_a_of_type_Int * liy.jdField_b_of_type_Int * 3 / 2 != paramArrayOfByte.length)
    {
      lba.h(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    try
    {
      paramString = LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt, liy.jdField_a_of_type_Int, liy.jdField_b_of_type_Int, 60, 0.75F);
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
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(this.jdField_a_of_type_Loy.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(lph.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(this.jdField_a_of_type_Loy.jdField_a_of_type_AndroidContentContext);
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
  
  public void a(msh parammsh, lok paramlok, mrk parammrk)
  {
    if (parammsh != null) {
      parammsh.a("checkLowLight");
    }
    a(paramlok.jdField_a_of_type_ArrayOfByte, paramlok.jdField_a_of_type_Long, paramlok.jdField_a_of_type_Boolean);
    if (parammrk != null) {
      parammrk.e();
    }
    if (parammsh != null) {
      parammsh.b("checkLowLight");
    }
  }
  
  public void a(msh parammsh, mrk parammrk)
  {
    this.jdField_a_of_type_Loy.c();
    if (a())
    {
      if (parammsh != null) {
        parammsh.a("appleVideoDeNoise");
      }
      this.jdField_a_of_type_Loy.jdField_b_of_type_Lpf = a(this.jdField_a_of_type_Loy.jdField_a_of_type_Lpf);
      if (parammrk != null) {
        if (this.jdField_a_of_type_Loy.jdField_b_of_type_Lpf.jdField_b_of_type_Int == this.jdField_a_of_type_Loy.jdField_a_of_type_Lpf.jdField_b_of_type_Int) {
          break label110;
        }
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      parammrk.b(bool);
      if (parammsh != null) {
        parammsh.b("appleVideoDeNoise");
      }
      this.jdField_a_of_type_Loy.a(6, this.jdField_a_of_type_Loy.jdField_a_of_type_Lpf, this.jdField_a_of_type_Loy.jdField_b_of_type_Lpf);
      return;
    }
  }
  
  public void b(msh parammsh, lok paramlok, mrk parammrk)
  {
    this.jdField_a_of_type_Loy.c();
    if (a(paramlok.jdField_a_of_type_Boolean))
    {
      if (parammsh != null) {
        parammsh.a("appleLowLightEnhance");
      }
      this.jdField_a_of_type_Loy.jdField_b_of_type_Lpf = a(this.jdField_a_of_type_Loy.jdField_a_of_type_Lpf, paramlok.jdField_a_of_type_Boolean);
      if (parammsh != null) {
        parammsh.b("appleLowLightEnhance");
      }
      this.jdField_a_of_type_Loy.a(7, this.jdField_a_of_type_Loy.jdField_a_of_type_Lpf, this.jdField_a_of_type_Loy.jdField_b_of_type_Lpf);
    }
    GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
    if (parammrk != null) {
      if (this.jdField_a_of_type_Loy.jdField_b_of_type_Lpf.jdField_b_of_type_Int == this.jdField_a_of_type_Loy.jdField_a_of_type_Lpf.jdField_b_of_type_Int) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      parammrk.c(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpg
 * JD-Core Version:    0.7.0.1
 */