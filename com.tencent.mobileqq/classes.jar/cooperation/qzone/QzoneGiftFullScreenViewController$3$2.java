package cooperation.qzone;

import android.view.View;
import bhac;
import bhae;
import bhaf;
import bhag;
import com.tencent.image.URLDrawable;
import java.util.List;

public class QzoneGiftFullScreenViewController$3$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$3$2(bhae parambhae) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.jdField_a_of_type_Bhac.a).setBackgroundColor(0);
    bhac.a(this.a.jdField_a_of_type_Bhac);
    this.a.jdField_a_of_type_Bhaf.a();
    if (bhac.a(this.a.jdField_a_of_type_Bhac).size() > 0)
    {
      bhag localbhag = (bhag)bhac.a(this.a.jdField_a_of_type_Bhac).get(0);
      this.a.jdField_a_of_type_Bhac.a(localbhag.jdField_a_of_type_JavaLangString, localbhag.b, localbhag.jdField_a_of_type_Boolean, localbhag.jdField_a_of_type_Bhaf);
      bhac.a(this.a.jdField_a_of_type_Bhac).remove(localbhag);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.2
 * JD-Core Version:    0.7.0.1
 */