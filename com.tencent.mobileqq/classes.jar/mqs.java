import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.IBitmapCallback;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;

public class mqs
  implements Runnable
{
  public mqs(RunningJob paramRunningJob, CloseableBitmap paramCloseableBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest.a)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a();
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((IBitmapCallback)localWeakReference.get()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderRunningJob.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderImageRequest, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a());
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderCloseableBitmap.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqs
 * JD-Core Version:    0.7.0.1
 */