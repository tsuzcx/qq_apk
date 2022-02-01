package com.tencent.mobileqq.nearby.profilecard;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.View.DragShadowBuilder;

@TargetApi(11)
class NearbyProfileEditPanel$PicDragShadowBuilder
  extends View.DragShadowBuilder
{
  public int a;
  
  public NearbyProfileEditPanel$PicDragShadowBuilder(NearbyProfileEditPanel paramNearbyProfileEditPanel, View paramView)
  {
    super(paramView);
    double d = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.imageWidth;
    Double.isNaN(d);
    this.jdField_a_of_type_Int = ((int)(d * 1.4D));
  }
  
  public void onDrawShadow(Canvas paramCanvas)
  {
    getView().setDrawingCacheEnabled(false);
    getView().setDrawingCacheEnabled(true);
    Object localObject = new Paint();
    ((Paint)localObject).setShadowLayer(10.0F, 0.0F, 0.0F, -16777216);
    int i = this.jdField_a_of_type_Int;
    paramCanvas.drawRect(new Rect(10, 10, i + 10, i + 10), (Paint)localObject);
    localObject = getView().getDrawingCache();
    Matrix localMatrix = new Matrix();
    float f = this.jdField_a_of_type_Int / ((Bitmap)localObject).getWidth();
    localMatrix.postScale(f, f);
    paramCanvas.drawBitmap(Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true), 10.0F, 10.0F, null);
  }
  
  public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    int j = this.jdField_a_of_type_Int;
    int i = j + 20;
    j += 20;
    paramPoint1.set(i, j);
    paramPoint2.set(i / 2, j / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.PicDragShadowBuilder
 * JD-Core Version:    0.7.0.1
 */