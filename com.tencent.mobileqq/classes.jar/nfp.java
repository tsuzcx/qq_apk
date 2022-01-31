import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class nfp
  implements View.OnClickListener
{
  nfp(nfo paramnfo) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof nms)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "click!");
      }
      paramView = (nms)paramView;
      if (this.a.a != null) {
        this.a.a.a(paramView);
      }
      this.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfp
 * JD-Core Version:    0.7.0.1
 */