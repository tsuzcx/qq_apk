import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.qphone.base.util.QLog;

public class prp
  extends pmn
{
  public prp(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, pwr parampwr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "onGetSelfInfo retCode:" + paramInt1 + ", followCnt:" + paramInt2 + ", fansCnt:" + paramInt3 + ", isForbidden" + paramBoolean);
    }
    if (paramInt1 == 0)
    {
      this.a.a(paramInt2, paramInt3, paramBoolean);
      if (parampwr != null) {
        ReadInJoySelfFragment.a(this.a, parampwr);
      }
    }
    else
    {
      return;
    }
    QLog.e("Q.readinjoy.self.SelfFragment", 1, "onGetSelfInfo, columnInfoForSelfPage = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prp
 * JD-Core Version:    0.7.0.1
 */