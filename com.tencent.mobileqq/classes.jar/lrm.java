import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.magic.ReadInJoyWatcherObserver;
import com.tencent.biz.pubaccount.readinjoy.magic.models.AndroidAPs;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;

public class lrm
  implements Runnable
{
  public lrm(ReadInJoyWatcherObserver paramReadInJoyWatcherObserver, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      Object localObject = ReadInJoyWatcherObserver.a(new File("/dev/cpuctl/apps/tasks"));
      if ((ReadInJoyWatcherObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver) == null) || (!((Set)localObject).contains(Integer.valueOf(ReadInJoyWatcherObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver).b))))
      {
        localObject = ReadInJoyWatcherObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver, ReadInJoyWatcherObserver.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Set)localObject));
        if (((List)localObject).size() <= 0) {
          break label119;
        }
        ReadInJoyWatcherObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver, (AndroidAPs)((List)localObject).get(0));
      }
    }
    for (;;)
    {
      ReadInJoyWatcherObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver, ReadInJoyWatcherObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver));
      return;
      label119:
      ReadInJoyWatcherObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicReadInJoyWatcherObserver, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrm
 * JD-Core Version:    0.7.0.1
 */