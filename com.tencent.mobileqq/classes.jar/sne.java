import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

class sne
  extends DataSetObserver
{
  sne(snd paramsnd) {}
  
  public void onChanged()
  {
    QLog.d("FastWebActivity", 2, "DataSetObserver ");
    FastWebActivity.a(this.a.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sne
 * JD-Core Version:    0.7.0.1
 */