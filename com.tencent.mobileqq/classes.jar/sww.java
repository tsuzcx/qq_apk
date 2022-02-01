import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.tencent.biz.pubaccount.readinjoy.view.ucrop.GestureCropImageView;

public class sww
  extends ScaleGestureDetector.SimpleOnScaleGestureListener
{
  private sww(GestureCropImageView paramGestureCropImageView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.a.a(paramScaleGestureDetector.getScaleFactor(), GestureCropImageView.a(this.a), GestureCropImageView.b(this.a), true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sww
 * JD-Core Version:    0.7.0.1
 */