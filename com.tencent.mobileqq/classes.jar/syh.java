import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class syh
  implements Runnable
{
  public syh(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (BaseApplicationImpl.getContext() != null) {
      SharedPreUtils.a(BaseApplicationImpl.getContext(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syh
 * JD-Core Version:    0.7.0.1
 */