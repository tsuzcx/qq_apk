import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

class qho
  extends nev
{
  private qho(qhj paramqhj) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "onGetRecommend:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
      qhj.a(this.a).addAll(qhj.a(this.a).a(paramBundle));
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qho
 * JD-Core Version:    0.7.0.1
 */