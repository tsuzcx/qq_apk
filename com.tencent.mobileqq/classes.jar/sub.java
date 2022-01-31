import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.mobileqq.activity.Leba;

public class sub
  implements Runnable
{
  public sub(Leba paramLeba) {}
  
  public void run()
  {
    SearchProtocol.a += 1;
    Leba.a(this.a, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sub
 * JD-Core Version:    0.7.0.1
 */