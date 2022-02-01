package common.config.service;

import android.content.Intent;
import bmae;

public class QzoneConfig$3$1
  implements Runnable
{
  public QzoneConfig$3$1(bmae parambmae, Intent paramIntent) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.ACCOUNT_KICKED")) || (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.FORCE_LOGOUT")) || (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.LOGOUT"))) {
      QzoneConfig.getInstance().clearConfigs();
    }
    while ((!this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.LOGIN"))) {
      return;
    }
    QzoneConfig.getInstance().clearConfigs();
    QzoneConfig.getInstance().loadAllConfigs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     common.config.service.QzoneConfig.3.1
 * JD-Core Version:    0.7.0.1
 */