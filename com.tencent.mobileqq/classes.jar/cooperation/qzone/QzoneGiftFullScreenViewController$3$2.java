package cooperation.qzone;

import android.view.View;
import bfre;
import bfrg;
import bfrh;
import bfri;
import com.tencent.image.URLDrawable;
import java.util.List;

public class QzoneGiftFullScreenViewController$3$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$3$2(bfrg parambfrg) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.jdField_a_of_type_Bfre.a).setBackgroundColor(0);
    bfre.a(this.a.jdField_a_of_type_Bfre);
    this.a.jdField_a_of_type_Bfrh.a();
    if (bfre.a(this.a.jdField_a_of_type_Bfre).size() > 0)
    {
      bfri localbfri = (bfri)bfre.a(this.a.jdField_a_of_type_Bfre).get(0);
      this.a.jdField_a_of_type_Bfre.a(localbfri.jdField_a_of_type_JavaLangString, localbfri.b, localbfri.jdField_a_of_type_Boolean, localbfri.jdField_a_of_type_Bfrh);
      bfre.a(this.a.jdField_a_of_type_Bfre).remove(localbfri);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.2
 * JD-Core Version:    0.7.0.1
 */