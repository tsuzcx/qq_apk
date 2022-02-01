package dov.com.qq.im.capture.text;

import android.graphics.RectF;

public class LineMarginCoverter
  extends BaseCovert
{
  private int a;
  
  public LineMarginCoverter(int paramInt)
  {
    this.a = paramInt;
  }
  
  void a(int paramInt, BaseTextModel paramBaseTextModel)
  {
    RectF localRectF = paramBaseTextModel.a;
    localRectF.top += this.a * paramInt;
    paramBaseTextModel = paramBaseTextModel.a;
    paramBaseTextModel.bottom += this.a * paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.LineMarginCoverter
 * JD-Core Version:    0.7.0.1
 */