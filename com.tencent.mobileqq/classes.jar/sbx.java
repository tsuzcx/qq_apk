import android.content.Intent;
import android.view.View;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

class sbx
  implements behi
{
  sbx(sbw paramsbw) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "onItemClick!");
    }
    paramAdapterView = (scg)sbw.a.get(paramInt);
    paramView = new Intent(paramView.getContext(), PublicAccountImageCollectionMainActivity.class);
    paramView.putExtra("recommend_source", paramAdapterView.c);
    paramView.putExtra("recommend_position", paramInt + 1);
    paramView.putExtra("click_source", 2);
    paramView.putExtra("source_for_report", 15);
    scb.a(sbw.a(this.a), paramView, String.valueOf(paramAdapterView.d));
    if ((sbw.a(this.a) instanceof PublicAccountImageCollectionMainActivity))
    {
      paramView = (PublicAccountImageCollectionMainActivity)sbw.a(this.a);
      paramInt += 1;
      paramView.a(2, paramInt, paramAdapterView.c);
      ndn.a(null, paramView.a, "0X8007B94", "0X8007B94", 0, 0, paramView.b, paramView.c, paramAdapterView.d, "" + paramInt, false);
    }
    rcv.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     sbx
 * JD-Core Version:    0.7.0.1
 */