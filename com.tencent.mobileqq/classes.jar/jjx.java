import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.opengl.GlStringParser;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.texture.YUVTexture.GLRenderListener;

public class jjx
  extends Handler
{
  public jjx(YUVTexture paramYUVTexture, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
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
          YUVTexture.a(this.a).a();
          return;
        } while (YUVTexture.a(this.a) == null);
        YUVTexture.a(this.a).b();
        return;
      } while (YUVTexture.a(this.a) == null);
      YUVTexture.a(this.a).c();
      return;
    } while (YUVTexture.a(this.a) == null);
    if (YUVTexture.a(this.a) == null) {
      YUVTexture.a(this.a, new GlStringParser('=', ';'));
    }
    paramMessage = (String)paramMessage.obj;
    YUVTexture.a(this.a).a(paramMessage);
    int i = YUVTexture.a(this.a).a("width");
    int j = YUVTexture.a(this.a).a("height");
    int k = YUVTexture.a(this.a).a("angle");
    YUVTexture.a(this.a).a(i, j, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjx
 * JD-Core Version:    0.7.0.1
 */