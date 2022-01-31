import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.qphone.base.util.QLog;

public class okg
  extends ohe
{
  public okg(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "onGetFollowAndFansResultAndForbidden retCode:" + paramInt1 + ", followCnt:" + paramInt2 + ", fansCnt:" + paramInt3 + ", isForbidden" + paramBoolean);
    }
    if (paramInt1 == 0) {
      this.a.a(paramInt2, paramInt3, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okg
 * JD-Core Version:    0.7.0.1
 */