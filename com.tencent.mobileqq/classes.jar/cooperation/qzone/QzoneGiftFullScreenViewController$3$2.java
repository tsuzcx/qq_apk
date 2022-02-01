package cooperation.qzone;

import android.view.View;
import blts;
import bltu;
import bltv;
import bltw;
import com.tencent.image.URLDrawable;
import java.util.List;

public class QzoneGiftFullScreenViewController$3$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$3$2(bltu parambltu) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.jdField_a_of_type_Blts.a).setBackgroundColor(0);
    blts.a(this.a.jdField_a_of_type_Blts);
    this.a.jdField_a_of_type_Bltv.a();
    if (blts.a(this.a.jdField_a_of_type_Blts).size() > 0)
    {
      bltw localbltw = (bltw)blts.a(this.a.jdField_a_of_type_Blts).get(0);
      this.a.jdField_a_of_type_Blts.a(localbltw.jdField_a_of_type_JavaLangString, localbltw.b, localbltw.jdField_a_of_type_Boolean, localbltw.jdField_a_of_type_Bltv);
      blts.a(this.a.jdField_a_of_type_Blts).remove(localbltw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.2
 * JD-Core Version:    0.7.0.1
 */