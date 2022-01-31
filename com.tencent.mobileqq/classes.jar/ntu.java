import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment;

public class ntu
  extends alvc
{
  public ntu(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131701639));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131701618));
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ntu
 * JD-Core Version:    0.7.0.1
 */