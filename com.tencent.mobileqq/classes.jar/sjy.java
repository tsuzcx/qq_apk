import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.Random;

public class sjy
  extends ska
{
  private float i;
  
  public sjy(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView)
  {
    super(paramLikeExplosionView);
    b();
  }
  
  public sjy(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView, int paramInt)
  {
    super(paramLikeExplosionView);
    double d = Math.toRadians(paramInt);
    this.e = ((float)Math.cos(d));
    this.f = ((float)Math.sin(d));
    a();
    b();
  }
  
  private void b()
  {
    VideoFeedsLikeAnimate.LikeExplosionView.a(this.a).setColor(Color.parseColor("#E6FF4222"));
    VideoFeedsLikeAnimate.LikeExplosionView.a(this.a).setStyle(Paint.Style.FILL);
    this.i = (VideoFeedsLikeAnimate.LikeExplosionView.a(this.a).nextFloat() * AIOUtils.dp2px(10.0F, this.a.getResources()) + AIOUtils.dp2px(4.5F, this.a.getResources()));
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.c, this.d, this.i, VideoFeedsLikeAnimate.LikeExplosionView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjy
 * JD-Core Version:    0.7.0.1
 */