import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.widget.PullToZoomListView;

public class szg
  implements Runnable
{
  public szg(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    if (this.a.c == null) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = this.a.e;
    localURLDrawableOptions.mRequestWidth = this.a.d;
    this.a.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.a.b.setImageDrawable(URLDrawable.getDrawable(this.a.c, localURLDrawableOptions));
    this.a.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     szg
 * JD-Core Version:    0.7.0.1
 */