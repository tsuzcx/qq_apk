import com.tencent.biz.pubaccount.persistence.entity.PAAdPreloadTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;
import java.lang.ref.WeakReference;

class mym
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private mym(myh parammyh) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    for (;;)
    {
      synchronized (myh.a(this.a))
      {
        myh.c("onPreloadComplete vid:" + paramString1 + ", detail:" + paramString2);
        paramString2 = new File(myh.b(paramString1));
        if (paramString2.exists()) {
          paramString2.renameTo(new File(myh.a(paramString1)));
        }
        awqx.a(null, "dc00898", "", "", "0X8008F77", "0X8008F77", 0, 0, "", "", myh.a(this.a).mVideoVid, String.valueOf(myh.a(this.a).mSource));
        paramString2 = (QQAppInterface)myh.a(this.a).get();
        if (paramString2 != null)
        {
          paramString2 = paramString2.getCurrentAccountUin();
          mye.b(paramString2, paramString1);
          myh.a(this.a, myh.a(this.a));
          return;
        }
      }
      paramString2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     mym
 * JD-Core Version:    0.7.0.1
 */