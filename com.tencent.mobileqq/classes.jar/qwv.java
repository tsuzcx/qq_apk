import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

class qwv
  extends DataSetObserver
{
  qwv(qwu paramqwu) {}
  
  public void onChanged()
  {
    QLog.d(FastWebActivity.a(this.a.a), 2, "DataSetObserver ");
    FastWebActivity.a(this.a.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwv
 * JD-Core Version:    0.7.0.1
 */