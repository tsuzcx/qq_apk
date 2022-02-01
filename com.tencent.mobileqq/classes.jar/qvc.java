import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class qvc
  extends NativeTextImp
{
  qvc(qvb paramqvb, Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (!TextUtils.isEmpty(getText()))
    {
      this.a.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getWidth(), getHeight());
      this.a.b.set(0.0F, 0.0F, getWidth() * qvb.a(this.a) / 100.0F, getHeight());
      this.a.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(qvb.a(this.a)));
      paramCanvas.drawRoundRect(this.a.jdField_a_of_type_AndroidGraphicsRectF, AIOUtils.dp2px(2.0F, getResources()), AIOUtils.dp2px(2.0F, getResources()), this.a.jdField_a_of_type_AndroidGraphicsPaint);
      this.a.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(qvb.b(this.a)));
      paramCanvas.drawRoundRect(this.a.b, AIOUtils.dp2px(2.0F, getResources()), AIOUtils.dp2px(2.0F, getResources()), this.a.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvc
 * JD-Core Version:    0.7.0.1
 */