import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.PublicAccountUnfollowTask.UnFollowPublicAccountListenner;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.mobileqq.widget.QQToast;

public class lib
  implements PublicAccountUnfollowTask.UnFollowPublicAccountListenner
{
  public lib(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity, Context paramContext) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      new Handler(Looper.getMainLooper()).postDelayed(new lic(this), 500L);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, "取消关注失败，请检查网络设置！", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lib
 * JD-Core Version:    0.7.0.1
 */