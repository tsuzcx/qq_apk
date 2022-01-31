import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;

public class lnt
  implements Runnable
{
  public lnt(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void run()
  {
    if (ReadInJoySelfFragment.a(this.a) != null) {
      ReadInJoySelfFragment.a(this.a).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lnt
 * JD-Core Version:    0.7.0.1
 */