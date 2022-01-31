package cooperation.qzone;

import android.view.View;
import bjfm;
import bjfo;
import bjfp;
import bjfq;
import com.tencent.image.URLDrawable;
import java.util.List;

public class QzoneGiftFullScreenViewController$3$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$3$2(bjfo parambjfo) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.jdField_a_of_type_Bjfm.a).setBackgroundColor(0);
    bjfm.a(this.a.jdField_a_of_type_Bjfm);
    this.a.jdField_a_of_type_Bjfp.a();
    if (bjfm.a(this.a.jdField_a_of_type_Bjfm).size() > 0)
    {
      bjfq localbjfq = (bjfq)bjfm.a(this.a.jdField_a_of_type_Bjfm).get(0);
      this.a.jdField_a_of_type_Bjfm.a(localbjfq.jdField_a_of_type_JavaLangString, localbjfq.b, localbjfq.jdField_a_of_type_Boolean, localbjfq.jdField_a_of_type_Bjfp);
      bjfm.a(this.a.jdField_a_of_type_Bjfm).remove(localbjfq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.2
 * JD-Core Version:    0.7.0.1
 */