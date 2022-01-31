import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.view.widget.WordNavView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class run
  extends GestureDetector.SimpleOnGestureListener
{
  private run(WordNavView paramWordNavView) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    float f = paramMotionEvent.getY();
    Iterator localIterator = WordNavView.a(this.a).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((f >= ((Float)localEntry.getKey()).floatValue() - this.a.getHeight() / WordNavView.a(this.a).size() / 2) && (f <= ((Float)localEntry.getKey()).floatValue() + this.a.getHeight() / WordNavView.a(this.a).size() / 2)) {
        if (WordNavView.a(this.a) != null) {
          WordNavView.a(this.a).a((String)localEntry.getValue());
        }
      }
    }
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     run
 * JD-Core Version:    0.7.0.1
 */