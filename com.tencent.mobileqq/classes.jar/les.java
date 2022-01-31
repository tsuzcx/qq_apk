import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class les
  extends ReadInJoyObserver
{
  public les(ReadInJoySelfActivity paramReadInJoySelfActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.ReadInJoySelfActivity", 2, "onGetFollowAndFansResultAndForbidden retCode:" + paramInt1 + ", followCnt:" + paramInt2 + ", fansCnt:" + paramInt3 + ", isForbidden = " + paramBoolean);
    }
    if (paramInt1 == 0)
    {
      ReadInJoyHelper.a(this.a.a, paramInt2, paramInt3);
      ReadInJoyHelper.j(this.a.app, paramBoolean);
      if (ReadInJoySelfActivity.a(this.a) != null) {
        ReadInJoySelfActivity.a(this.a).setText(ReadInJoyHelper.a(paramInt2));
      }
      if (ReadInJoySelfActivity.b(this.a) != null) {
        ReadInJoySelfActivity.b(this.a).setText(ReadInJoyHelper.a(paramInt3));
      }
      if (ReadInJoySelfActivity.a(this.a) != null)
      {
        if (!paramBoolean) {
          break label162;
        }
        ReadInJoySelfActivity.a(this.a).setVisibility(0);
      }
    }
    return;
    label162:
    ReadInJoySelfActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     les
 * JD-Core Version:    0.7.0.1
 */