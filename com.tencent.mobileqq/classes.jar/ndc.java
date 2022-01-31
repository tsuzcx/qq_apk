import com.tencent.biz.qqstory.model.TroopNickNameManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ndc
  extends TroopObserver
{
  public ndc(TroopNickNameManager paramTroopNickNameManager) {}
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onGetTroopMemberCardInfoResult suc=").append(paramBoolean).append(" size=");
      if (paramArrayList != null) {
        break label78;
      }
    }
    label78:
    for (int i = 0;; i = paramArrayList.size())
    {
      QLog.d("TroopNickNameManager", 2, i);
      if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
        ThreadManager.executeOnSubThread(new ndd(this, paramArrayList));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndc
 * JD-Core Version:    0.7.0.1
 */