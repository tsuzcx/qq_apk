import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;

class qda
  extends NativeTextImp
{
  qda(qcz paramqcz, Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!TextUtils.isEmpty(getText()))
    {
      this.a.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      this.a.b.set(0.0F, 0.0F, getWidth() * qcz.a(this.a) / 100.0F, getHeight());
      this.a.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(qcz.a(this.a)));
      paramCanvas.drawRoundRect(this.a.jdField_a_of_type_AndroidGraphicsRectF, agej.a(2.0F, getResources()), agej.a(2.0F, getResources()), this.a.jdField_a_of_type_AndroidGraphicsPaint);
      this.a.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(qcz.b(this.a)));
      paramCanvas.drawRoundRect(this.a.b, agej.a(2.0F, getResources()), agej.a(2.0F, getResources()), this.a.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qda
 * JD-Core Version:    0.7.0.1
 */