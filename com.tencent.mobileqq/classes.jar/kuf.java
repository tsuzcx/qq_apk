import com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import java.util.ArrayList;

public class kuf
  implements Runnable
{
  public kuf(VideoCoverAdapter paramVideoCoverAdapter) {}
  
  public void run()
  {
    if ((VideoCoverAdapter.a(this.a) == null) || (VideoCoverAdapter.a(this.a).size() == 0)) {}
    VideoCoverItem localVideoCoverItem;
    do
    {
      return;
      localVideoCoverItem = (VideoCoverItem)VideoCoverAdapter.a(this.a).get(0);
    } while ((localVideoCoverItem == null) || (localVideoCoverItem.a == null));
    localVideoCoverItem.a.a(VideoCoverAdapter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kuf
 * JD-Core Version:    0.7.0.1
 */