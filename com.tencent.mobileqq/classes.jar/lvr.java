import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend;
import com.tencent.mobileqq.app.ThreadManager;

public class lvr
  implements UserOperationModule.Ox978RespCallBack
{
  public lvr(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 2)) {
      ThreadManager.post(new lvs(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lvr
 * JD-Core Version:    0.7.0.1
 */