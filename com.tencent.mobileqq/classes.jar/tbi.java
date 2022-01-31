import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.ar.config.WorldCup;

public class tbi
  implements Runnable
{
  public tbi(MainFragment paramMainFragment) {}
  
  public void run()
  {
    String str = MainFragment.a(this.a);
    WorldCup.a(MainFragment.a(this.a), this.a.getActivity(), this.a.getView(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tbi
 * JD-Core Version:    0.7.0.1
 */