import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;

public class sar
  implements RadioGroup.OnCheckedChangeListener
{
  public sar(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    ServiceAccountFolderActivityNew.a(this.a, true);
    if (ServiceAccountFolderActivityNew.a(this.a).getId() == paramInt) {
      ServiceAccountFolderActivityNew.a(this.a).setCurrentItem(0);
    }
    while (ServiceAccountFolderActivityNew.b(this.a).getId() != paramInt) {
      return;
    }
    ServiceAccountFolderActivityNew.a(this.a).setCurrentItem(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sar
 * JD-Core Version:    0.7.0.1
 */