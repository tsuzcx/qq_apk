import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;

public class lgt
  extends ReadInJoyObserver
{
  public lgt(ReadInJoySelfActivity paramReadInJoySelfActivity) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.ReadInJoySelfActivity", 2, "onGetFollowAndFansResultAndForbidden retCode:" + paramInt1 + ", followCnt:" + paramInt2 + ", fansCnt:" + paramInt3 + ", isForbidden = " + paramBoolean);
    }
    if (paramInt1 == 0) {
      ReadInJoySelfActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgt
 * JD-Core Version:    0.7.0.1
 */