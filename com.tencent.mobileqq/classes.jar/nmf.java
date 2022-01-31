import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

class nmf
  implements TVK_ICacheMgr.IPreloadCallback
{
  private nmf(nmb paramnmb) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (nmb.a(this.a))
    {
      nmb.c("onPreLoadFailed vid:" + paramString1 + ", i:" + paramInt + ", callbackMsg:" + paramString2);
      nmb.a(this.a, nmb.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (nmb.a(this.a))
    {
      nmb.c("onPreLoadSucess vid:" + paramString1 + ", detail:" + paramString2);
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = new File(nmb.b(paramString1));
          if (paramString2.exists()) {
            paramString2.renameTo(new File(nmb.a(paramString1)));
          }
          nmb.a(this.a, nmb.a(this.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nmf
 * JD-Core Version:    0.7.0.1
 */