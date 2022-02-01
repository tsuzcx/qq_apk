package cooperation.qzone;

import android.view.View;
import bmuu;
import bmuw;
import bmux;
import bmuy;
import com.tencent.image.URLDrawable;
import java.util.List;

public class QzoneGiftFullScreenViewController$3$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$3$2(bmuw parambmuw) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.jdField_a_of_type_Bmuu.a).setBackgroundColor(0);
    bmuu.a(this.a.jdField_a_of_type_Bmuu);
    this.a.jdField_a_of_type_Bmux.a();
    if (bmuu.a(this.a.jdField_a_of_type_Bmuu).size() > 0)
    {
      bmuy localbmuy = (bmuy)bmuu.a(this.a.jdField_a_of_type_Bmuu).get(0);
      this.a.jdField_a_of_type_Bmuu.a(localbmuy.jdField_a_of_type_JavaLangString, localbmuy.b, localbmuy.jdField_a_of_type_Boolean, localbmuy.jdField_a_of_type_Bmux);
      bmuu.a(this.a.jdField_a_of_type_Bmuu).remove(localbmuy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.2
 * JD-Core Version:    0.7.0.1
 */