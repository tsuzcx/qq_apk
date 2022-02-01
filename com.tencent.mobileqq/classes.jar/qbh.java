import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment.3.1;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment.3.2;
import com.tencent.qphone.base.util.QLog;

public class qbh
  implements ucq
{
  public qbh(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void a()
  {
    if (this.a.getActivity() != null) {
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.3.2(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "reloadPage success!");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.a.getActivity() != null) {
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.3.1(this), 1000L);
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyViolaChannelFragment", 2, "reloadPage error,error code=" + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((1 == paramInt) && (pli.a())) {
      pvm.a().l();
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "reloadPage process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbh
 * JD-Core Version:    0.7.0.1
 */