import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.qphone.base.util.QLog;

public class smu
  implements srk
{
  public smu(ViolaFragment paramViolaFragment) {}
  
  public void a()
  {
    this.a.a.b();
    this.a.a.d();
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "initViola success!");
    }
  }
  
  public void a(int paramInt)
  {
    this.a.a.b();
    this.a.a.c();
    if (QLog.isColorLevel()) {
      QLog.e("ViolaFragment", 2, "initViola error,error code=" + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((this.a.a.b()) && (paramBoolean))
    {
      if (Math.abs(paramInt1) < this.a.a.a() / 2) {
        break label79;
      }
      if (!ViolaFragment.a(this.a))
      {
        this.a.a(Boolean.valueOf(false));
        ajen.a(this.a.getActivity(), true);
        ViolaFragment.a(this.a, true);
      }
    }
    label79:
    while (!ViolaFragment.a(this.a)) {
      return;
    }
    this.a.a(Boolean.valueOf(true));
    ajen.a(this.a.getActivity(), false);
    ViolaFragment.a(this.a, false);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "initViola process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     smu
 * JD-Core Version:    0.7.0.1
 */