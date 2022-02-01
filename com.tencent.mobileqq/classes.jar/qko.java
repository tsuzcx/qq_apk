import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;

class qko
  extends NativeTextImp
{
  qko(qkn paramqkn, Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!TextUtils.isEmpty(getText()))
    {
      this.a.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      this.a.b.set(0.0F, 0.0F, getWidth() * qkn.a(this.a) / 100.0F, getHeight());
      this.a.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(qkn.a(this.a)));
      paramCanvas.drawRoundRect(this.a.jdField_a_of_type_AndroidGraphicsRectF, afur.a(2.0F, getResources()), afur.a(2.0F, getResources()), this.a.jdField_a_of_type_AndroidGraphicsPaint);
      this.a.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(qkn.b(this.a)));
      paramCanvas.drawRoundRect(this.a.b, afur.a(2.0F, getResources()), afur.a(2.0F, getResources()), this.a.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qko
 * JD-Core Version:    0.7.0.1
 */