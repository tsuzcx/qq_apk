import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.youtu.android.rapidnet.ILogCallbackInterface;

public final class pjc
  implements ILogCallbackInterface
{
  public void printLog(int paramInt, String paramString1, String paramString2)
  {
    ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "prio: " + paramInt + ", tag: " + paramString1 + ", info: " + paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjc
 * JD-Core Version:    0.7.0.1
 */