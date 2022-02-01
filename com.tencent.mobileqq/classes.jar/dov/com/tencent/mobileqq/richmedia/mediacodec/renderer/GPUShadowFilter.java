package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class GPUShadowFilter
  extends GPUBaseFilter
{
  private float a;
  protected FloatBuffer a;
  private float b;
  protected FloatBuffer b;
  private FloatBuffer c;
  
  public GPUShadowFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nvarying vec2 vTextureCoord;\nattribute vec4 aTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform vec4 a_color;\n\nuniform float widthShadowRegion;\n\nuniform float heightShadowRegion;\n\nvoid main() {\n    float x = abs(vTextureCoord.x-0.5);\n    float y = abs(vTextureCoord.y-0.5);\n    float mx = 1.0 - (1.0-(0.5-x)/widthShadowRegion)*step(0.5-widthShadowRegion,x);\n    float my = 1.0 - (1.0-(0.5-y)/heightShadowRegion)*step(0.5-heightShadowRegion,y);\n    gl_FragColor = a_color;\n    gl_FragColor.a = gl_FragColor.a*mx*my;\n}\n");
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.jdField_a_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
    this.jdField_b_of_type_JavaNioFloatBuffer = GlUtil.createFloatBuffer(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
    this.c = GlUtil.createFloatBuffer(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUShadowFilter
 * JD-Core Version:    0.7.0.1
 */