package cooperation.qqcircle.eevee;

import cooperation.qqcircle.QCircleConfig;

class QCircleEeveeMananger$1
  implements Runnable
{
  QCircleEeveeMananger$1(QCircleEeveeMananger paramQCircleEeveeMananger) {}
  
  public void run()
  {
    QCircleConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_show_entrance_on_recommend_tab", "1");
    QCircleConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_enable_eevee_polling", "1");
    QCircleConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_show_entrance_on_message_tab", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.eevee.QCircleEeveeMananger.1
 * JD-Core Version:    0.7.0.1
 */