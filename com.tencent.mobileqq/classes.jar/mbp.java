import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;

public class mbp
  extends OrientationEventListener
{
  public mbp(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mbp
 * JD-Core Version:    0.7.0.1
 */