import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;
import java.lang.ref.WeakReference;

class nmg
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private nmg(nmb paramnmb) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    for (;;)
    {
      synchronized (nmb.a(this.a))
      {
        nmb.c("onPreloadComplete vid:" + paramString1 + ", detail:" + paramString2);
        paramString2 = new File(nmb.b(paramString1));
        if (paramString2.exists()) {
          paramString2.renameTo(new File(nmb.a(paramString1)));
        }
        azmj.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", nmb.a(this.a).mVideoVid, String.valueOf(nmb.a(this.a).mSource));
        paramString2 = (QQAppInterface)nmb.a(this.a).get();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getCurrentAccountUin();
          nly.b(paramString2, paramString1);
          nmb.a(this.a, nmb.a(this.a));
          return;
        }
      }
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nmg
 * JD-Core Version:    0.7.0.1
 */