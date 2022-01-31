import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

class sis
  implements Runnable
{
  sis(sir paramsir, String paramString) {}
  
  public void run()
  {
    FormSimpleItem localFormSimpleItem;
    if (this.jdField_a_of_type_Sir.a.a != null)
    {
      localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_Sir.a.a[6];
      if ((localFormSimpleItem != null) && (!TextUtils.equals(localFormSimpleItem.a().getText(), this.jdField_a_of_type_JavaLangString)))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label78;
        }
        localFormSimpleItem.setRightText(this.jdField_a_of_type_Sir.a.getString(2131430600));
      }
    }
    return;
    label78:
    localFormSimpleItem.setRightText(new QQText(this.jdField_a_of_type_JavaLangString, 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sis
 * JD-Core Version:    0.7.0.1
 */