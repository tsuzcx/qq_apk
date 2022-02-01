import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

class nww
  implements TVK_ICacheMgr.IPreloadCallback
{
  private nww(nws paramnws) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (nws.a(this.a))
    {
      nws.c("onPreLoadFailed vid:" + paramString1 + ", i:" + paramInt + ", callbackMsg:" + paramString2);
      nws.a(this.a, nws.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (nws.a(this.a))
    {
      nws.c("onPreLoadSucess vid:" + paramString1 + ", detail:" + paramString2);
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = new File(nws.b(paramString1));
          if (paramString2.exists()) {
            paramString2.renameTo(new File(nws.a(paramString1)));
          }
          nws.a(this.a, nws.a(this.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nww
 * JD-Core Version:    0.7.0.1
 */