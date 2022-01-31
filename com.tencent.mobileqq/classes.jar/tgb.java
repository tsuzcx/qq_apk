import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class tgb
  implements Runnable
{
  public tgb(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (BaseApplicationImpl.getContext() != null) {
      SharedPreUtils.a(BaseApplicationImpl.getContext(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgb
 * JD-Core Version:    0.7.0.1
 */