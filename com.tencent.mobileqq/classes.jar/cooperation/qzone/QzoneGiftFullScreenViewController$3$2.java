package cooperation.qzone;

import android.view.View;
import bjbf;
import bjbh;
import bjbi;
import bjbj;
import com.tencent.image.URLDrawable;
import java.util.List;

public class QzoneGiftFullScreenViewController$3$2
  implements Runnable
{
  public QzoneGiftFullScreenViewController$3$2(bjbh parambjbh) {}
  
  public void run()
  {
    URLDrawable.resume();
    ((View)this.a.jdField_a_of_type_Bjbf.a).setBackgroundColor(0);
    bjbf.a(this.a.jdField_a_of_type_Bjbf);
    this.a.jdField_a_of_type_Bjbi.a();
    if (bjbf.a(this.a.jdField_a_of_type_Bjbf).size() > 0)
    {
      bjbj localbjbj = (bjbj)bjbf.a(this.a.jdField_a_of_type_Bjbf).get(0);
      this.a.jdField_a_of_type_Bjbf.a(localbjbj.jdField_a_of_type_JavaLangString, localbjbj.b, localbjbj.jdField_a_of_type_Boolean, localbjbj.jdField_a_of_type_Bjbi);
      bjbf.a(this.a.jdField_a_of_type_Bjbf).remove(localbjbj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QzoneGiftFullScreenViewController.3.2
 * JD-Core Version:    0.7.0.1
 */