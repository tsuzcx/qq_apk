import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.av.VideoController;

public class lcr
  extends OrientationEventListener
{
  private long jdField_a_of_type_Long;
  
  public lcr(VideoController paramVideoController, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_Long < 50L);
    this.jdField_a_of_type_Long = l;
    if ((paramInt > 315) || (paramInt <= 45))
    {
      VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, 1);
      return;
    }
    if ((paramInt > 45) && (paramInt <= 135))
    {
      VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, 2);
      return;
    }
    if ((paramInt > 135) && (paramInt <= 225))
    {
      VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, 3);
      return;
    }
    VideoController.a(this.jdField_a_of_type_ComTencentAvVideoController, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lcr
 * JD-Core Version:    0.7.0.1
 */