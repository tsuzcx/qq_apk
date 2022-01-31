import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment.2.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.qphone.base.util.QLog;

public class pbf
  implements srk
{
  public pbf(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void a()
  {
    if (this.a.getActivity() != null) {
      new Handler(this.a.getActivity().getMainLooper()).postDelayed(new ReadInJoyViolaChannelFragment.2.1(this), 200L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "initViola success!");
    }
    if ((ReadInJoyViolaChannelFragment.a(this.a) != null) && (ReadInJoyViolaChannelFragment.a(this.a).c()) && (this.a.c()) && (ReadinjoyTabFrame.c_())) {
      ReadInJoyViolaChannelFragment.a(this.a).a(true);
    }
  }
  
  public void a(int paramInt)
  {
    ReadInJoyViolaChannelFragment.a(this.a);
    ReadInJoyViolaChannelFragment.a(this.a).c();
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyViolaChannelFragment", 2, "initViola error,error code=" + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {}
  
  public void a(String paramString, int paramInt)
  {
    if ((1 == paramInt) && (otb.a())) {
      oxb.a().m();
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "initViola process,process code=" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pbf
 * JD-Core Version:    0.7.0.1
 */