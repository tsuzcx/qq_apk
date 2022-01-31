import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.opengl.texture.YUVTexture;

public class lsd
  extends Handler
{
  public lsd(YUVTexture paramYUVTexture, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    this.a.d = true;
    switch (i)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (YUVTexture.a(this.a) == null);
          YUVTexture.a(this.a).c();
          return;
        } while (YUVTexture.a(this.a) == null);
        YUVTexture.a(this.a).b();
        return;
      } while (YUVTexture.a(this.a) == null);
      YUVTexture.a(this.a).a();
      return;
    } while (YUVTexture.a(this.a) == null);
    if (YUVTexture.a(this.a) == null) {
      YUVTexture.a(this.a, new lpd('=', ';'));
    }
    paramMessage = (String)paramMessage.obj;
    YUVTexture.a(this.a).a(paramMessage);
    i = YUVTexture.a(this.a).a("width");
    int j = YUVTexture.a(this.a).a("height");
    int k = YUVTexture.a(this.a).a("angle");
    int m = YUVTexture.a(this.a).a("rotation", -1);
    YUVTexture.a(this.a).a(i, j, k, m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsd
 * JD-Core Version:    0.7.0.1
 */