import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.RefreshEntryTask;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.ShowAwardResult;
import com.tencent.qphone.base.util.QLog;

public class nfm
  extends nhd
{
  public nfm(GameActivityCenterCtrl paramGameActivityCenterCtrl) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameACCtrl", 2, "onSyncShareGame, [isSuccess: " + paramBoolean + ", errorCode: " + paramInt + ", errorMsg:" + paramString1 + ", playGameId: " + paramString2 + ", jumpUrl: " + paramString3 + "]");
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString3))) {
      nom.a().b().post(new GameActivityCenterCtrl.ShowAwardResult(paramString3));
    }
    if (paramBoolean) {
      GameActivityCenterCtrl.a(this.a, true);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, nfy paramnfy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameACCtrl", 2, "onGetActivityEntry, [isSuccess: " + paramBoolean + ", errorCode: " + paramInt + ", errorMsg:" + paramString + ", entry: " + paramnfy + "]");
    }
    if (paramBoolean)
    {
      GameActivityCenterCtrl.a(this.a, paramnfy);
      nom.a().b().post(new GameActivityCenterCtrl.RefreshEntryTask());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfm
 * JD-Core Version:    0.7.0.1
 */