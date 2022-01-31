import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate.LikeExplosionView;
import java.util.Random;

public class qpu
  extends qpw
{
  private float i;
  
  public qpu(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView)
  {
    super(paramLikeExplosionView);
    b();
  }
  
  public qpu(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView, int paramInt)
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
    this.i = (VideoFeedsLikeAnimate.LikeExplosionView.a(this.a).nextFloat() * actn.a(10.0F, this.a.getResources()) + actn.a(4.5F, this.a.getResources()));
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.c, this.d, this.i, VideoFeedsLikeAnimate.LikeExplosionView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpu
 * JD-Core Version:    0.7.0.1
 */