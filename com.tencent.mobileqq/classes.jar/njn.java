import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;
import java.lang.ref.WeakReference;

class njn
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private njn(nji paramnji) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    for (;;)
    {
      synchronized (nji.a(this.a))
      {
        nji.c("onPreloadComplete vid:" + paramString1 + ", detail:" + paramString2);
        paramString2 = new File(nji.b(paramString1));
        if (paramString2.exists()) {
          paramString2.renameTo(new File(nji.a(paramString1)));
        }
        axqw.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", nji.a(this.a).mVideoVid, String.valueOf(nji.a(this.a).mSource));
        paramString2 = (QQAppInterface)nji.a(this.a).get();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getCurrentAccountUin();
          njf.b(paramString2, paramString1);
          nji.a(this.a, nji.a(this.a));
          return;
        }
      }
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     njn
 * JD-Core Version:    0.7.0.1
 */