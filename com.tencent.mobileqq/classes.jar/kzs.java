import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment;
import com.tencent.mobileqq.app.PublicAccountObserver;

public class kzs
  extends PublicAccountObserver
{
  public kzs(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("已关注");
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText("关注");
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130843941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzs
 * JD-Core Version:    0.7.0.1
 */