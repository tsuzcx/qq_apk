import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;

public final class kno
  implements AsyncBack
{
  public void loaded(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (HtmlOffline.a.a())) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "CODE_SUCCESS");
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kno
 * JD-Core Version:    0.7.0.1
 */