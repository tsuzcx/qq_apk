import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener;
import com.tencent.mobileqq.app.ThreadManager;

public class lsy
  implements UserOperationModule.Ox978RespCallBack
{
  public lsy(OnTopicRecommendHeaderFollowClickListener paramOnTopicRecommendHeaderFollowClickListener) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 1)) {
      ThreadManager.post(new lsz(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsy
 * JD-Core Version:    0.7.0.1
 */