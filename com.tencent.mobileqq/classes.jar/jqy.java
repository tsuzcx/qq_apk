import android.graphics.Bitmap;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.OnGetSink;
import com.tencent.av.ui.BaseInviteFloatBarUICtr;
import com.tencent.av.ui.VideoInviteFloatBar;

public class jqy
  implements BaseGaInvite.GetGaFaceRunnable.OnGetSink
{
  public jqy(BaseInviteFloatBarUICtr paramBaseInviteFloatBarUICtr) {}
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    boolean bool = false;
    if (this.a.a != null)
    {
      this.a.a.a(paramBitmap);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqy
 * JD-Core Version:    0.7.0.1
 */