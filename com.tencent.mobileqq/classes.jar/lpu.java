import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public class lpu
  extends lpt
{
  private static final PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private final lpv jdField_a_of_type_Lpv;
  private PointF b;
  private PointF c;
  private PointF d = new PointF();
  private PointF e = new PointF();
  
  public lpu(Context paramContext, lpv paramlpv)
  {
    super(paramContext);
    this.jdField_a_of_type_Lpv = paramlpv;
  }
  
  private PointF a(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    float f2 = 0.0F;
    while (i < j)
    {
      f2 += paramMotionEvent.getX(i);
      f1 += paramMotionEvent.getY(i);
      i += 1;
    }
    return new PointF(f2 / j, f1 / j);
  }
  
  public float a()
  {
    return this.d.x;
  }
  
  public PointF a()
  {
    return this.e;
  }
  
  protected void a(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      a();
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
      this.jdField_a_of_type_Long = 0L;
      a(paramMotionEvent);
      return;
    }
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Lpv.b(this);
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    super.a(paramMotionEvent);
    MotionEvent localMotionEvent = this.jdField_a_of_type_AndroidViewMotionEvent;
    if ((paramMotionEvent == null) || (localMotionEvent == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
      }
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsPointF = a(paramMotionEvent);
    this.c = a(localMotionEvent);
    int i;
    if (localMotionEvent.getPointerCount() != paramMotionEvent.getPointerCount())
    {
      i = 1;
      if (i == 0) {
        break label125;
      }
    }
    label125:
    for (paramMotionEvent = jdField_a_of_type_AndroidGraphicsPointF;; paramMotionEvent = new PointF(this.jdField_b_of_type_AndroidGraphicsPointF.x - this.c.x, this.jdField_b_of_type_AndroidGraphicsPointF.y - this.c.y))
    {
      this.e = paramMotionEvent;
      paramMotionEvent = this.d;
      paramMotionEvent.x += this.e.x;
      paramMotionEvent = this.d;
      paramMotionEvent.y += this.e.y;
      return;
      i = 0;
      break;
    }
  }
  
  public float b()
  {
    return this.d.y;
  }
  
  protected void b(int paramInt, MotionEvent paramMotionEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_Lpv.a(this);
      a();
      return;
      a(paramMotionEvent);
    } while ((this.jdField_a_of_type_Float / this.jdField_b_of_type_Float <= 0.67F) || (!this.jdField_a_of_type_Lpv.a(this)) || (this.jdField_a_of_type_AndroidViewMotionEvent == null));
    this.jdField_a_of_type_AndroidViewMotionEvent.recycle();
    this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpu
 * JD-Core Version:    0.7.0.1
 */