import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.util.HashMap;

class sra
  implements TVK_ICacheMgr.IPreloadCallback
{
  sra(sqy paramsqy) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    if (sqy.a(this.a) != null)
    {
      paramString2 = (String)sqy.a(this.a).get(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        sqy.a(this.a).a(paramString1, paramInt, paramString2);
      }
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    if (sqy.a(this.a) != null)
    {
      paramString2 = (String)sqy.a(this.a).get(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        sqy.a(this.a).a(paramString1, 1, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sra
 * JD-Core Version:    0.7.0.1
 */