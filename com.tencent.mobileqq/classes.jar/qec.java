import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;

public class qec
  extends DataSetObserver
{
  public qec(VideoFeedsListView paramVideoFeedsListView) {}
  
  public void onChanged()
  {
    VideoFeedsListView localVideoFeedsListView = this.a;
    if (VideoFeedsListView.a(this.a) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      VideoFeedsListView.a(localVideoFeedsListView, bool);
      return;
    }
  }
  
  public void onInvalidated()
  {
    VideoFeedsListView localVideoFeedsListView = this.a;
    if (VideoFeedsListView.a(this.a) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      VideoFeedsListView.a(localVideoFeedsListView, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qec
 * JD-Core Version:    0.7.0.1
 */