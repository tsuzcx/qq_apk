import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

class rjm
  extends DataSetObserver
{
  rjm(rjl paramrjl) {}
  
  public void onChanged()
  {
    QLog.d(FastWebActivity.a(this.a.a), 2, "DataSetObserver ");
    FastWebActivity.a(this.a.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjm
 * JD-Core Version:    0.7.0.1
 */