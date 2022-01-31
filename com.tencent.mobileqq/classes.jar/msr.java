import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoStatusListener;
import java.util.ArrayList;
import java.util.Iterator;

class msr
  implements Runnable
{
  msr(msq parammsq) {}
  
  public void run()
  {
    if (FastWebVideoFeedsPlayManager.a(this.a.a) != null)
    {
      Iterator localIterator = FastWebVideoFeedsPlayManager.a(this.a.a).iterator();
      while (localIterator.hasNext()) {
        ((FastWebVideoFeedsPlayManager.VideoStatusListener)localIterator.next()).a(FastWebVideoFeedsPlayManager.a(this.a.a));
      }
    }
    this.a.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msr
 * JD-Core Version:    0.7.0.1
 */