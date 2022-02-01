import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class pre
  implements sgw
{
  public pre(VideoView paramVideoView) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(@NotNull sgx arg1)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (VideoView.access$1300(this.a))
        {
          VideoView.access$000(this.a, 6);
          VideoView.access$1402(this.a, VideoView.access$1500(this.a));
          VideoView.access$1602(this.a, "");
          VideoView.access$1700(this.a);
          if (VideoView.access$1800(this.a) != null) {
            this.a.mProgressHandler.postDelayed(this.a, 500L);
          }
          return;
        }
        QLog.d("gifvideo.VideoView", 1, "invalid state");
        VideoView.access$1602(this.a, "");
        if (VideoView.access$500(this.a).get() == 5) {
          VideoView.access$1900(this.a);
        }
      }
      if (VideoView.access$500(this.a).get() == 4) {
        VideoView.access$2000(this.a);
      }
    }
  }
  
  public void a(@NotNull sgx paramsgx, int paramInt1, int paramInt2) {}
  
  public void a(@NotNull sgx paramsgx, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap) {}
  
  public boolean a(@NotNull sgx paramsgx, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    QLog.e("gifvideo.VideoView", 1, "TVK_IMediaPlayer.OnErrorListener model = " + paramInt1 + " errorType = " + paramInt2 + " errorCode = " + paramInt3 + " extra = " + paramString);
    return false;
  }
  
  public boolean a(@NotNull sgx paramsgx, int paramInt, @Nullable Object paramObject)
  {
    return false;
  }
  
  public void b(@NotNull sgx arg1)
  {
    synchronized (this.a)
    {
      VideoView.access$000(this.a, 10);
      this.a.displayCover();
      if (VideoView.access$2100(this.a) != null) {
        VideoView.access$2100(this.a).c();
      }
      VideoView.access$2200(this.a);
      return;
    }
  }
  
  public void c(@NotNull sgx arg1)
  {
    synchronized (this.a)
    {
      if (VideoView.access$900(this.a) != null) {
        VideoView.access$900(this.a).a();
      }
      if (VideoView.access$1800(this.a) != null) {
        this.a.mProgressHandler.postDelayed(this.a, 500L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pre
 * JD-Core Version:    0.7.0.1
 */