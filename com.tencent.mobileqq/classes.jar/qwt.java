import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class qwt
  extends DataSetObserver
{
  public qwt(FastWebActivity paramFastWebActivity) {}
  
  public void onChanged()
  {
    super.onChanged();
    if (FastWebActivity.a(this.a) == null) {
      return;
    }
    FastWebActivity.a(this.a).a(FastWebActivity.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwt
 * JD-Core Version:    0.7.0.1
 */