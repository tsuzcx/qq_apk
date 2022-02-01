package com.tencent.ttpic.openapi.filter.zoomfilter;

import com.tencent.filter.BaseFilter;

public class PaddingFilter
  extends BaseFilter
{
  private static final String FRAGMENT = "precision highp float;\nuniform sampler2D inputImageTexture;varying vec2 textureCoordinate;\n\nvoid main(void)\n{\n    gl_FragColor = texture2D(inputImageTexture,textureCoordinate);\n}";
  private static final String VERTEXT = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 textureMat; \nuniform mat4 tMat;\nvoid main(void)\n{\ngl_Position = Projection * Modelview *position;\nvec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\ntextureCoordinate = tmp.xy;\n}";
  private float mPaddingHeight = 0.02F;
  private float mPaddingWidth = 0.1F;
  private float[] textPoint = { 0.25F, 0.25F, 0.25F, 0.5F, 0.5F, 0.5F, 0.5F, 0.25F };
  private float[] vetextPoint = { -0.5F, -0.5F, -0.5F, 0.5F, 0.5F, 0.5F, 0.5F, -0.5F };
  
  public PaddingFilter()
  {
    super("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 textureMat; \nuniform mat4 tMat;\nvoid main(void)\n{\ngl_Position = Projection * Modelview *position;\nvec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\ntextureCoordinate = tmp.xy;\n}", "precision highp float;\nuniform sampler2D inputImageTexture;varying vec2 textureCoordinate;\n\nvoid main(void)\n{\n    gl_FragColor = texture2D(inputImageTexture,textureCoordinate);\n}");
  }
  
  public void apply()
  {
    setPositions(this.vetextPoint);
    setTexCords(this.textPoint);
    super.apply();
  }
  
  public void setPaddingNum(int paramInt1, int paramInt2, int paramInt3)
  {
    float f = paramInt1;
    this.mPaddingWidth = (f / paramInt2);
    this.mPaddingHeight = (f / paramInt3);
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    int j = 0;
    int i = 0;
    while (i < 6)
    {
      this.textPoint[i] = paramArrayOfFloat[i];
      i += 1;
    }
    this.textPoint[6] = paramArrayOfFloat[(paramArrayOfFloat.length - 2)];
    this.textPoint[7] = paramArrayOfFloat[(paramArrayOfFloat.length - 1)];
    paramArrayOfFloat = this.textPoint;
    paramArrayOfFloat[0] += this.mPaddingWidth;
    paramArrayOfFloat = this.textPoint;
    paramArrayOfFloat[1] += this.mPaddingHeight;
    paramArrayOfFloat = this.textPoint;
    paramArrayOfFloat[2] += this.mPaddingWidth;
    paramArrayOfFloat = this.textPoint;
    paramArrayOfFloat[3] -= this.mPaddingHeight;
    paramArrayOfFloat = this.textPoint;
    paramArrayOfFloat[4] -= this.mPaddingWidth;
    paramArrayOfFloat = this.textPoint;
    paramArrayOfFloat[5] -= this.mPaddingHeight;
    paramArrayOfFloat = this.textPoint;
    paramArrayOfFloat[6] -= this.mPaddingWidth;
    paramArrayOfFloat = this.textPoint;
    paramArrayOfFloat[7] += this.mPaddingHeight;
    i = j;
    while (i < this.vetextPoint.length)
    {
      this.vetextPoint[i] = (this.textPoint[i] * 2.0F - 1.0F);
      i += 1;
    }
    super.setPositions(this.vetextPoint);
    return super.setTexCords(this.textPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.zoomfilter.PaddingFilter
 * JD-Core Version:    0.7.0.1
 */