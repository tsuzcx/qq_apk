import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.qphone.base.util.QLog;

public class pkl
  extends pfh
{
  public pkl(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, ppc paramppc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "onGetSelfInfo retCode:" + paramInt1 + ", followCnt:" + paramInt2 + ", fansCnt:" + paramInt3 + ", isForbidden" + paramBoolean);
    }
    if (paramInt1 == 0)
    {
      this.a.a(paramInt2, paramInt3, paramBoolean);
      if (paramppc != null) {
        ReadInJoySelfFragment.a(this.a, paramppc);
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
 * Qualified Name:     pkl
 * JD-Core Version:    0.7.0.1
 */