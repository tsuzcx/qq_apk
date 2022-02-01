import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nta
  implements View.OnClickListener
{
  nta(nsz paramnsz) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof oag)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailCustomModuleBaseWrapper", 2, "click!");
      }
      localObject = (oag)localObject;
      if (this.a.a != null) {
        this.a.a.a((oag)localObject);
      }
      this.a.a((oag)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nta
 * JD-Core Version:    0.7.0.1
 */