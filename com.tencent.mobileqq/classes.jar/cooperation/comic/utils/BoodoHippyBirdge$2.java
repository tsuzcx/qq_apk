package cooperation.comic.utils;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class BoodoHippyBirdge$2
  implements Runnable
{
  BoodoHippyBirdge$2(QQAppInterface paramQQAppInterface, BoodoHippyBirdge.ICheckPluginListener paramICheckPluginListener, Context paramContext) {}
  
  public void run()
  {
    if (QQComicPluginBridge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BoodoHippyBirdge", 2, "plugin is installed.");
      }
      if (this.jdField_a_of_type_CooperationComicUtilsBoodoHippyBirdge$ICheckPluginListener != null) {
        this.jdField_a_of_type_CooperationComicUtilsBoodoHippyBirdge$ICheckPluginListener.a(0, null);
      }
      QQComicPluginBridge.a(this.jdField_a_of_type_AndroidContentContext);
    }
    label93:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BoodoHippyBirdge", 2, "wait for plugin installation...");
      }
      boolean bool = QQComicPluginBridge.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, null);
      BoodoHippyBirdge.ICheckPluginListener localICheckPluginListener;
      int i;
      if (this.jdField_a_of_type_CooperationComicUtilsBoodoHippyBirdge$ICheckPluginListener != null)
      {
        localICheckPluginListener = this.jdField_a_of_type_CooperationComicUtilsBoodoHippyBirdge$ICheckPluginListener;
        if (!bool) {
          break label128;
        }
        i = 0;
        if (!bool) {
          break label133;
        }
      }
      for (String str = "plugin install success";; str = "plugin install failed.")
      {
        localICheckPluginListener.a(i, str);
        if (bool) {
          break label139;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BoodoHippyBirdge", 2, "plugin install failed.");
        return;
        i = -1;
        break label93;
      }
      QQComicPluginBridge.a(this.jdField_a_of_type_AndroidContentContext);
    } while (!QLog.isColorLevel());
    label128:
    label133:
    label139:
    QLog.d("BoodoHippyBirdge", 2, "plugin is installed now.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.utils.BoodoHippyBirdge.2
 * JD-Core Version:    0.7.0.1
 */