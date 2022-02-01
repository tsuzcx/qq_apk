import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInjoyIMAXAdFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

public class qbl
  implements URLDrawable.URLDrawableListener
{
  public qbl(ReadInjoyIMAXAdFragment paramReadInjoyIMAXAdFragment, int paramInt1, int paramInt2) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyIMAXAdFragment", 2, "onLoadProgressed =" + paramInt);
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment, this.jdField_a_of_type_Int, this.b);
    ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).removeMessages(-2);
    ReadInjoyIMAXAdFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInjoyIMAXAdFragment).sendEmptyMessage(-2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbl
 * JD-Core Version:    0.7.0.1
 */