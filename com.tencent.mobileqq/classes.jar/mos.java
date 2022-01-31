import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;

public class mos
  implements View.OnClickListener
{
  public mos(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyDiandianHeaderController.a(this.a, "0X8008B87");
    ReadInJoyDiandianHeaderController.b(this.a);
    ReadInJoyUtils.a(ReadInJoyDiandianHeaderController.a(this.a).getContext(), ReadInJoyConstants.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mos
 * JD-Core Version:    0.7.0.1
 */