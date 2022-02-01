import android.opengl.Matrix;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class lpk
{
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private final float[] b;
  
  public lpk()
  {
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    this.b = new float[16];
    Matrix.setIdentityM(this.b, 0);
    Matrix.scaleM(this.b, 0, -1.0F, 1.0F, 1.0F);
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    }
  }
  
  public lpi a(lpi paramlpi, int paramInt1, int paramInt2)
  {
    if ((paramlpi == null) || (paramlpi.b == -1) || (paramInt1 == 0) || (paramInt2 == 0)) {
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
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramlpi.b, this.jdField_a_of_type_ArrayOfFloat, this.b);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    return lpi.a(0, this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpk
 * JD-Core Version:    0.7.0.1
 */