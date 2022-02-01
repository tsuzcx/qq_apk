import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;

public class oav
  implements tqb
{
  public oav(ADBaseAppDownloadManager.3 param3) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.this$0.a(this.a.a, 5, 100);
      this.a.this$0.d(this.a.a);
    }
    do
    {
      return;
      if (this.a.a.a)
      {
        oau.a(this.a.this$0, this.a.a);
        return;
      }
    } while (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()));
    this.a.this$0.a(this.a.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oav
 * JD-Core Version:    0.7.0.1
 */