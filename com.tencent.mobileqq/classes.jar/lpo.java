import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class lpo
{
  private int jdField_a_of_type_Int = 0;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int jdField_b_of_type_Int = 0;
  private final float[] jdField_b_of_type_ArrayOfFloat;
  private final float[] c;
  
  public lpo()
  {
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    this.jdField_b_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    this.c = new float[16];
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    }
  }
  
  public lpx a(lpx paramlpx, int paramInt1, int paramInt2)
  {
    if ((paramlpx == null) || (paramlpx.jdField_b_of_type_Int == -1) || (paramInt1 == 0) || (paramInt2 == 0)) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || (paramInt1 != this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth()) || (paramInt2 != this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight()))
    {
      if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      }
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramInt1, paramInt2, 33984);
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramlpx.jdField_b_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    return lpx.a(0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
    }
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == paramInt2)) {
      return;
    }
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    if (paramInt1 == 1)
    {
      Matrix.rotateM(this.jdField_b_of_type_ArrayOfFloat, 0, 90.0F, 0.0F, 0.0F, 1.0F);
      label43:
      if (paramInt2 != 1) {
        break label184;
      }
      Matrix.setIdentityM(this.c, 0);
      Matrix.scaleM(this.c, 0, -1.0F, 1.0F, 1.0F);
      Matrix.multiplyMM(this.jdField_b_of_type_ArrayOfFloat, 0, this.c, 0, this.jdField_b_of_type_ArrayOfFloat, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ExtraRender", 4, "updateMatrix, rotateFlag[" + paramInt1 + "], mirrorFlag[" + paramInt2 + "]");
      return;
      if (paramInt1 == 2)
      {
        Matrix.rotateM(this.jdField_b_of_type_ArrayOfFloat, 0, -90.0F, 0.0F, 0.0F, 1.0F);
        break label43;
      }
      if (paramInt1 != 3) {
        break label43;
      }
      Matrix.rotateM(this.jdField_b_of_type_ArrayOfFloat, 0, 180.0F, 0.0F, 0.0F, 1.0F);
      break label43;
      label184:
      if (paramInt2 == 2)
      {
        Matrix.setIdentityM(this.c, 0);
        Matrix.scaleM(this.c, 0, 1.0F, -1.0F, 1.0F);
        Matrix.multiplyMM(this.jdField_b_of_type_ArrayOfFloat, 0, this.c, 0, this.jdField_b_of_type_ArrayOfFloat, 0);
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int != 0) || (this.jdField_b_of_type_Int != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpo
 * JD-Core Version:    0.7.0.1
 */