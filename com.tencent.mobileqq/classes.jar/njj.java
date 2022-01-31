import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

class njj
  implements TVK_ICacheMgr.IPreloadCallback
{
  private njj(njf paramnjf) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (njf.a(this.a))
    {
      njf.c("onPreLoadFailed vid:" + paramString1 + ", i:" + paramInt + ", callbackMsg:" + paramString2);
      njf.a(this.a, njf.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (njf.a(this.a))
    {
      njf.c("onPreLoadSucess vid:" + paramString1 + ", detail:" + paramString2);
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = new File(njf.b(paramString1));
          if (paramString2.exists()) {
            paramString2.renameTo(new File(njf.a(paramString1)));
          }
          njf.a(this.a, njf.a(this.a));
        }
      }
      catch (Exception paramString1)
      {
        label136:
        break label136;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     njj
 * JD-Core Version:    0.7.0.1
 */