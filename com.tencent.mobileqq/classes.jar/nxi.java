import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nxi
  implements View.OnClickListener
{
  nxi(nxe paramnxe) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    nxe.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxi
 * JD-Core Version:    0.7.0.1
 */