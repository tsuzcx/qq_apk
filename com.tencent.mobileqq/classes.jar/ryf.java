import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qphone.base.util.QLog;

class ryf
  extends DataSetObserver
{
  ryf(rye paramrye) {}
  
  public void onChanged()
  {
    QLog.d(FastWebActivity.a(this.a.a), 2, "DataSetObserver ");
    FastWebActivity.a(this.a.a, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ryf
 * JD-Core Version:    0.7.0.1
 */