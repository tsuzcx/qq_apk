import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

class srf
  extends DataSetObserver
{
  srf(sre paramsre) {}
  
  public void onChanged()
  {
    QLog.d("FastWebActivity", 2, "DataSetObserver ");
    FastWebActivity.a(this.a.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srf
 * JD-Core Version:    0.7.0.1
 */