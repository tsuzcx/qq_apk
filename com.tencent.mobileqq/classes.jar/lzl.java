import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;

public class lzl
  extends OrientationEventListener
{
  private int jdField_a_of_type_Int = -1;
  
  public lzl(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + 360;
    }
    if ((i > 314) || (i < 45)) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
      }
      return;
      if (i < 135) {
        paramInt = 90;
      } else if (i < 225) {
        paramInt = 180;
      } else {
        paramInt = 270;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzl
 * JD-Core Version:    0.7.0.1
 */