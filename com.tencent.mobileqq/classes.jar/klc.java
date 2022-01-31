import com.tencent.biz.common.offline.BidDownloader;

class klc
  extends Thread
{
  klc(klb paramklb) {}
  
  public void run()
  {
    if (this.a.a.b == 1) {}
    for (;;)
    {
      try
      {
        Thread.sleep(5000L);
        this.a.a.b();
        return;
      }
      catch (InterruptedException localInterruptedException1)
      {
        localInterruptedException1.printStackTrace();
        continue;
      }
      try
      {
        Thread.sleep(10000L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klc
 * JD-Core Version:    0.7.0.1
 */