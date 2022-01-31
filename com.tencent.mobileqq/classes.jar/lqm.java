import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;

public class lqm
  implements Runnable
{
  public lqm(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void run()
  {
    if (ReadInJoySelfFragment.a(this.a) != null) {
      ReadInJoySelfFragment.a(this.a).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqm
 * JD-Core Version:    0.7.0.1
 */