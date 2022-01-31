package cooperation.qzone;

import android.view.View;
import bgzl;
import bgzn;
import bgzo;
import bgzp;
import com.tencent.image.URLDrawable;
import java.util.List;

public class QzoneGiftFullScreenViewController$3$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$3$2(bgzn parambgzn) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.jdField_a_of_type_Bgzl.a).setBackgroundColor(0);
    bgzl.a(this.a.jdField_a_of_type_Bgzl);
    this.a.jdField_a_of_type_Bgzo.a();
    if (bgzl.a(this.a.jdField_a_of_type_Bgzl).size() > 0)
    {
      bgzp localbgzp = (bgzp)bgzl.a(this.a.jdField_a_of_type_Bgzl).get(0);
      this.a.jdField_a_of_type_Bgzl.a(localbgzp.jdField_a_of_type_JavaLangString, localbgzp.b, localbgzp.jdField_a_of_type_Boolean, localbgzp.jdField_a_of_type_Bgzo);
      bgzl.a(this.a.jdField_a_of_type_Bgzl).remove(localbgzp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.2
 * JD-Core Version:    0.7.0.1
 */