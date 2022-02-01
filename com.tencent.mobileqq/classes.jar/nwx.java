import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;
import java.lang.ref.WeakReference;

class nwx
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private nwx(nws paramnws) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    for (;;)
    {
      synchronized (nws.a(this.a))
      {
        nws.c("onPreloadComplete vid:" + paramString1 + ", detail:" + paramString2);
        paramString2 = new File(nws.b(paramString1));
        if (paramString2.exists()) {
          paramString2.renameTo(new File(nws.a(paramString1)));
        }
        bdll.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", nws.a(this.a).mVideoVid, String.valueOf(nws.a(this.a).mSource));
        paramString2 = (QQAppInterface)nws.a(this.a).get();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getCurrentAccountUin();
          nwp.b(paramString2, paramString1);
          nws.a(this.a, nws.a(this.a));
          return;
        }
      }
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwx
 * JD-Core Version:    0.7.0.1
 */