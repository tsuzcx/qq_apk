package common.config.service;

import android.content.Intent;

class QzoneConfig$3$1
  implements Runnable
{
  QzoneConfig$3$1(QzoneConfig.3 param3, Intent paramIntent) {}
  
  public void run()
  {
    if ((!this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.ACCOUNT_KICKED")) && (!this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.FORCE_LOGOUT")) && (!this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.LOGOUT")))
    {
      if ((this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.ACCOUNT_CHANGED")) || (this.jdField_a_of_type_AndroidContentIntent.getAction().equals("mqq.intent.action.LOGIN")))
      {
        QzoneConfig.getInstance().clearConfigs();
        QzoneConfig.getInstance().loadAllConfigs();
      }
    }
    else {
      QzoneConfig.getInstance().clearConfigs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     common.config.service.QzoneConfig.3.1
 * JD-Core Version:    0.7.0.1
 */