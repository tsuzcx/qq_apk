import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;
import java.lang.ref.WeakReference;

class njk
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private njk(njf paramnjf) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    for (;;)
    {
      synchronized (njf.a(this.a))
      {
        njf.c("onPreloadComplete vid:" + paramString1 + ", detail:" + paramString2);
        paramString2 = new File(njf.b(paramString1));
        if (paramString2.exists()) {
          paramString2.renameTo(new File(njf.a(paramString1)));
        }
        axqy.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", njf.a(this.a).mVideoVid, String.valueOf(njf.a(this.a).mSource));
        paramString2 = (QQAppInterface)njf.a(this.a).get();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getCurrentAccountUin();
          njc.b(paramString2, paramString1);
          njf.a(this.a, njf.a(this.a));
          return;
        }
      }
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     njk
 * JD-Core Version:    0.7.0.1
 */