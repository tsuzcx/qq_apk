import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment;

public class nql
  extends akdn
{
  public nql(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131701270));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131701249));
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nql
 * JD-Core Version:    0.7.0.1
 */