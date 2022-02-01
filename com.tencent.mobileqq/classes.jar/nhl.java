import com.tencent.avgame.gameresult.GamePKResultFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class nhl
  extends ndr
{
  nhl(nhk paramnhk) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameResultPKPresenterImp", 2, String.format("onUserHeadUpdated", new Object[0]));
    }
    if ((this.a.a instanceof GamePKResultFragment)) {
      ((GamePKResultFragment)this.a.a).b();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameResultPKPresenterImp", 2, String.format("onUserNickUpdated", new Object[0]));
      }
      if ((this.a.a instanceof GamePKResultFragment)) {
        ((GamePKResultFragment)this.a.a).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhl
 * JD-Core Version:    0.7.0.1
 */