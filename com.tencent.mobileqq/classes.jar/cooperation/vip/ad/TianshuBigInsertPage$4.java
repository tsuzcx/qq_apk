package cooperation.vip.ad;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class TianshuBigInsertPage$4
  implements IPreloadService.OnGetPathListener
{
  TianshuBigInsertPage$4(TianshuBigInsertPage paramTianshuBigInsertPage) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TianshuBigInsertPage", 2, "onResult: " + paramInt + ", path: " + paramPathResult.filePath);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.filePath))) {
      TianshuBigInsertPage.a(this.a).a().runOnUiThread(new TianshuBigInsertPage.4.1(this, paramPathResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBigInsertPage.4
 * JD-Core Version:    0.7.0.1
 */