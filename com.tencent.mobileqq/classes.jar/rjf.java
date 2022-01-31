import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class rjf
  extends ntc
{
  private rjf(rja paramrja) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "onGetRecommend:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
      rja.a(this.a).addAll(rja.a(this.a).a(paramBundle));
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rjf
 * JD-Core Version:    0.7.0.1
 */