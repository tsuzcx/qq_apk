import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class rvx
  extends odq
{
  private rvx(rvs paramrvs) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "onGetRecommend:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
      rvs.a(this.a).addAll(rvs.a(this.a).a(paramBundle));
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvx
 * JD-Core Version:    0.7.0.1
 */