import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.app.ThreadManager;

public class mfg
  implements ThirdVideoManager.UUIDToUrlCallback
{
  public mfg(VideoPreDownloadMgr paramVideoPreDownloadMgr, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    ThreadManager.post(new mfh(this, paramString2, paramString1, paramInt), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfg
 * JD-Core Version:    0.7.0.1
 */