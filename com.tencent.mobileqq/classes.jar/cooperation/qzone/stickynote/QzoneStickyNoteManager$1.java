package cooperation.qzone.stickynote;

import android.app.Activity;
import android.os.Handler;
import bhby;
import bhnr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.qzone.QzonePluginProxyActivity;

public class QzoneStickyNoteManager$1
  implements Runnable
{
  public QzoneStickyNoteManager$1(bhnr parambhnr, Activity paramActivity, QQAppInterface paramQQAppInterface, ListView paramListView, Card paramCard) {}
  
  public void run()
  {
    try
    {
      QzonePluginProxyActivity.a(this.jdField_a_of_type_AndroidAppActivity);
      bhby.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bhby.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bhnr.a(this.this$0).post(new QzoneStickyNoteManager.1.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QzoneStickyNoteManager", 1, "tryLoadQzonePlugin: failed to load qzone plugin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager.1
 * JD-Core Version:    0.7.0.1
 */