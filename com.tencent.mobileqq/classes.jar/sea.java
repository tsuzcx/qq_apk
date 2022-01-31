import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

class sea
  implements Runnable
{
  sea(sdz paramsdz, String paramString) {}
  
  public void run()
  {
    FormSimpleItem localFormSimpleItem;
    if (this.jdField_a_of_type_Sdz.a.a != null)
    {
      localFormSimpleItem = (FormSimpleItem)this.jdField_a_of_type_Sdz.a.a[6];
      if ((localFormSimpleItem != null) && (!TextUtils.equals(localFormSimpleItem.a().getText(), this.jdField_a_of_type_JavaLangString)))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label78;
        }
        localFormSimpleItem.setRightText(this.jdField_a_of_type_Sdz.a.getString(2131430597));
      }
    }
    return;
    label78:
    localFormSimpleItem.setRightText(new QQText(this.jdField_a_of_type_JavaLangString, 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sea
 * JD-Core Version:    0.7.0.1
 */