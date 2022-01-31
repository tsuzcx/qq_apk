import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewBaseActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class nzs
  implements rue
{
  private WeakReference<ReadInJoyNewBaseActivity> a;
  
  public nzs(ReadInJoyNewBaseActivity paramReadInJoyNewBaseActivity)
  {
    this.a = new WeakReference(paramReadInJoyNewBaseActivity);
  }
  
  public void a()
  {
    ReadInJoyNewFeedsActivity localReadInJoyNewFeedsActivity = (ReadInJoyNewFeedsActivity)this.a.get();
    if (localReadInJoyNewFeedsActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "NaviMaskTouchListenerImpl. activity has destoryed");
      }
    }
    while ((ReadInJoyNewFeedsActivity.a(localReadInJoyNewFeedsActivity) != 0) || (localReadInJoyNewFeedsActivity.a == null)) {
      return;
    }
    localReadInJoyNewFeedsActivity.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nzs
 * JD-Core Version:    0.7.0.1
 */