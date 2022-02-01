import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;
import java.lang.ref.WeakReference;

class nyi
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private nyi(nyd paramnyd) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    for (;;)
    {
      synchronized (nyd.a(this.a))
      {
        nyd.c("onPreloadComplete vid:" + paramString1 + ", detail:" + paramString2);
        paramString2 = new File(nyd.b(paramString1));
        if (paramString2.exists()) {
          paramString2.renameTo(new File(nyd.a(paramString1)));
        }
        bcef.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", nyd.a(this.a).mVideoVid, String.valueOf(nyd.a(this.a).mSource));
        paramString2 = (QQAppInterface)nyd.a(this.a).get();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getCurrentAccountUin();
          nya.b(paramString2, paramString1);
          nyd.a(this.a, nyd.a(this.a));
          return;
        }
      }
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nyi
 * JD-Core Version:    0.7.0.1
 */