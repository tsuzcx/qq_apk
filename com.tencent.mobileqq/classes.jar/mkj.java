import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

public class mkj
  implements Runnable
{
  public mkj(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void run()
  {
    if (this.a.h)
    {
      this.a.h = false;
      ReadInJoyBaseAdapter.a(this.a);
      return;
    }
    ReadInJoyBaseAdapter.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkj
 * JD-Core Version:    0.7.0.1
 */