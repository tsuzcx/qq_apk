import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.RefreshEntryTask;
import com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.ShowAwardResult;
import com.tencent.qphone.base.util.QLog;

public class myu
  extends nam
{
  public myu(GameActivityCenterCtrl paramGameActivityCenterCtrl) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameACCtrl", 2, "onSyncShareGame, [isSuccess: " + paramBoolean + ", errorCode: " + paramInt + ", errorMsg:" + paramString1 + ", playGameId: " + paramString2 + ", jumpUrl: " + paramString3 + "]");
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString3))) {
      ngk.a().b().post(new GameActivityCenterCtrl.ShowAwardResult(paramString3));
    }
    if (paramBoolean) {
      GameActivityCenterCtrl.a(this.a, true);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, mzh parammzh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameACCtrl", 2, "onGetActivityEntry, [isSuccess: " + paramBoolean + ", errorCode: " + paramInt + ", errorMsg:" + paramString + ", entry: " + parammzh + "]");
    }
    if (paramBoolean)
    {
      GameActivityCenterCtrl.a(this.a, parammzh);
      ngk.a().b().post(new GameActivityCenterCtrl.RefreshEntryTask());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myu
 * JD-Core Version:    0.7.0.1
 */