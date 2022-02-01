import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;
import java.lang.ref.WeakReference;

class ofi
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private ofi(ofd paramofd) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    for (;;)
    {
      synchronized (ofd.a(this.a))
      {
        ofd.c("onPreloadComplete vid:" + paramString1 + ", detail:" + paramString2);
        paramString2 = new File(ofd.b(paramString1));
        if (paramString2.exists()) {
          paramString2.renameTo(new File(ofd.a(paramString1)));
        }
        bdla.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", ofd.a(this.a).mVideoVid, String.valueOf(ofd.a(this.a).mSource));
        paramString2 = (QQAppInterface)ofd.a(this.a).get();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getCurrentAccountUin();
          ofa.b(paramString2, paramString1);
          ofd.a(this.a, ofd.a(this.a));
          return;
        }
      }
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ofi
 * JD-Core Version:    0.7.0.1
 */