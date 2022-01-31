import android.animation.TypeEvaluator;
import android.graphics.Point;

public class pyc
  implements TypeEvaluator<Point>
{
  private Point a = new Point();
  
  public Point a(float paramFloat, Point paramPoint1, Point paramPoint2)
  {
    int i = (int)(paramPoint1.x + (paramPoint2.x - paramPoint1.x) * paramFloat);
    int j = (int)(paramPoint1.y + (paramPoint2.y - paramPoint1.y) * paramFloat);
    this.a.set(i, j);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pyc
 * JD-Core Version:    0.7.0.1
 */