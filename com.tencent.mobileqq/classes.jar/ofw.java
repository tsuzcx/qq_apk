import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayer;
import com.tribe.async.reactive.SimpleObserver;

public class ofw
  extends SimpleObserver
{
  public ofw(EditVideoPlayer paramEditVideoPlayer) {}
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    if (paramBitmap != null)
    {
      if (this.a.b)
      {
        this.a.a.setImageBitmap(paramBitmap);
        SLog.b("Q.qqstory.record.EditVideoPlayer", "blur current frame success");
      }
    }
    else {
      return;
    }
    SLog.d("Q.qqstory.record.EditVideoPlayer", "finish blur current frame but play-cover-view is not visible");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.d("Q.qqstory.record.EditVideoPlayer", "blur the current frame error : " + paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofw
 * JD-Core Version:    0.7.0.1
 */