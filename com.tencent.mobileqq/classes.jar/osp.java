import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdDownloadView.3.1;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdDownloadView.3.2;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdDownloadView.3.3;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdDownloadView.3.4;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class osp
  implements olq
{
  osp(osm paramosm) {}
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyAdDownloadView.3.1(this));
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new ReadInJoyAdDownloadView.3.3(this, paramInt));
  }
  
  public void a(orb paramorb, int paramInt1, int paramInt2)
  {
    if (osm.a(this.a).a(paramorb)) {
      ThreadManager.getUIHandler().post(new ReadInJoyAdDownloadView.3.4(this, paramInt1, paramInt2));
    }
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ReadInJoyAdDownloadView.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osp
 * JD-Core Version:    0.7.0.1
 */