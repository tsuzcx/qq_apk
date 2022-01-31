import android.text.TextUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.util.HashMap;

class rlm
  implements TVK_ICacheMgr.IPreloadCallback
{
  rlm(rlk paramrlk) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    if (rlk.a(this.a) != null)
    {
      paramString2 = (String)rlk.a(this.a).get(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        rlk.a(this.a).a(paramString1, paramInt, paramString2);
      }
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    if (rlk.a(this.a) != null)
    {
      paramString2 = (String)rlk.a(this.a).get(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        rlk.a(this.a).a(paramString1, 1, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rlm
 * JD-Core Version:    0.7.0.1
 */