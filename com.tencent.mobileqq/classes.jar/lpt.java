import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.qphone.base.util.QLog;

public class lpt
{
  private DenoiseRender jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  private LowLightRender jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  private String jdField_a_of_type_JavaLangString;
  private final lpl jdField_a_of_type_Lpl;
  public boolean a;
  public int[] a;
  
  private lps a(lps paramlps)
  {
    if (!lpu.c()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    do
    {
      return paramlps;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfInt[3] = 0;
        return paramlps;
      }
      localObject = a();
    } while (localObject == null);
    this.jdField_a_of_type_Lpl.a(4);
    paramlps = ((DenoiseRender)localObject).process(paramlps.jdField_b_of_type_Int, paramlps.jdField_a_of_type_Int, this.jdField_a_of_type_Lpl.jdField_a_of_type_Int, this.jdField_a_of_type_Lpl.jdField_b_of_type_Int);
    paramlps = lps.a(paramlps.getFbo(), paramlps.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[3] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[5] += 1;
    return paramlps;
  }
  
  private lps a(lps paramlps, boolean paramBoolean)
  {
    if (!lpu.b()) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    do
    {
      return paramlps;
      if ((!this.jdField_a_of_type_Boolean) || (paramBoolean))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        return paramlps;
      }
      localObject = a();
    } while (localObject == null);
    this.jdField_a_of_type_Lpl.a(2);
    paramlps = ((LowLightRender)localObject).process(paramlps.jdField_b_of_type_Int, paramlps.jdField_a_of_type_Int, this.jdField_a_of_type_Lpl.jdField_a_of_type_Int, this.jdField_a_of_type_Lpl.jdField_b_of_type_Int);
    paramlps = lps.a(paramlps.getFbo(), paramlps.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[2] += 1;
    return paramlps;
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if ((lpu.b()) || (lpu.c()))
    {
      this.jdField_a_of_type_Lpl.a(1);
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
        lbd.d(this.jdField_a_of_type_JavaLangString, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        lbd.d(this.jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
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
    if (!lpu.c()) {}
    while (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!lpu.b()) {}
    while ((!this.jdField_a_of_type_Boolean) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    if (ljk.jdField_a_of_type_Int * ljk.jdField_b_of_type_Int * 3 / 2 != paramArrayOfByte.length)
    {
      lbd.h(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    try
    {
      paramString = LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt, ljk.jdField_a_of_type_Int, ljk.jdField_b_of_type_Int, 60, 0.75F);
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
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(this.jdField_a_of_type_Lpl.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(lpu.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(this.jdField_a_of_type_Lpl.jdField_a_of_type_AndroidContentContext);
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
  
  public void a(mte parammte, lox paramlox, msh parammsh)
  {
    if (parammte != null) {
      parammte.a("checkLowLight");
    }
    a(paramlox.jdField_a_of_type_ArrayOfByte, paramlox.jdField_a_of_type_Long, paramlox.jdField_a_of_type_Boolean);
    if (parammsh != null) {
      parammsh.e();
    }
    if (parammte != null) {
      parammte.b("checkLowLight");
    }
  }
  
  public void a(mte parammte, msh parammsh)
  {
    this.jdField_a_of_type_Lpl.c();
    if (a())
    {
      if (parammte != null) {
        parammte.a("appleVideoDeNoise");
      }
      this.jdField_a_of_type_Lpl.jdField_b_of_type_Lps = a(this.jdField_a_of_type_Lpl.jdField_a_of_type_Lps);
      if (parammsh != null) {
        if (this.jdField_a_of_type_Lpl.jdField_b_of_type_Lps.jdField_b_of_type_Int == this.jdField_a_of_type_Lpl.jdField_a_of_type_Lps.jdField_b_of_type_Int) {
          break label110;
        }
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      parammsh.b(bool);
      if (parammte != null) {
        parammte.b("appleVideoDeNoise");
      }
      this.jdField_a_of_type_Lpl.a(6, this.jdField_a_of_type_Lpl.jdField_a_of_type_Lps, this.jdField_a_of_type_Lpl.jdField_b_of_type_Lps);
      return;
    }
  }
  
  public void b(mte parammte, lox paramlox, msh parammsh)
  {
    this.jdField_a_of_type_Lpl.c();
    if (a(paramlox.jdField_a_of_type_Boolean))
    {
      if (parammte != null) {
        parammte.a("appleLowLightEnhance");
      }
      this.jdField_a_of_type_Lpl.jdField_b_of_type_Lps = a(this.jdField_a_of_type_Lpl.jdField_a_of_type_Lps, paramlox.jdField_a_of_type_Boolean);
      if (parammte != null) {
        parammte.b("appleLowLightEnhance");
      }
      this.jdField_a_of_type_Lpl.a(7, this.jdField_a_of_type_Lpl.jdField_a_of_type_Lps, this.jdField_a_of_type_Lpl.jdField_b_of_type_Lps);
    }
    GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
    if (parammsh != null) {
      if (this.jdField_a_of_type_Lpl.jdField_b_of_type_Lps.jdField_b_of_type_Int == this.jdField_a_of_type_Lpl.jdField_a_of_type_Lps.jdField_b_of_type_Int) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      parammsh.c(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lpt
 * JD-Core Version:    0.7.0.1
 */