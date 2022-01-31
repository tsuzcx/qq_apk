import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;

public class lon
  extends OrientationEventListener
{
  public lon(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lon
 * JD-Core Version:    0.7.0.1
 */