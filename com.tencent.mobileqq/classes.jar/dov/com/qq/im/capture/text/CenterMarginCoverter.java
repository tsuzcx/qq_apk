package dov.com.qq.im.capture.text;

import android.graphics.RectF;

public class CenterMarginCoverter
  extends BaseCovert
{
  private float a;
  private float b;
  
  public CenterMarginCoverter(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  void a(int paramInt, BaseTextModel paramBaseTextModel)
  {
    float f3 = paramBaseTextModel.a.right;
    float f4 = paramBaseTextModel.a.left;
    float f1 = paramBaseTextModel.a.bottom;
    float f2 = paramBaseTextModel.a.top;
    f3 = Math.abs(f3 - f4 - this.a) / 2.0F;
    f1 = Math.abs(f1 - f2 - this.b) / 2.0F;
    RectF localRectF = paramBaseTextModel.a;
    localRectF.left += f3;
    paramBaseTextModel = paramBaseTextModel.a;
    paramBaseTextModel.right = (f3 + paramBaseTextModel.right);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.CenterMarginCoverter
 * JD-Core Version:    0.7.0.1
 */