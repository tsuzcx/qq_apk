package cooperation.qzone.contentbox;

import bfua;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import java.util.ArrayList;
import java.util.Iterator;

class QZoneMsgFragment$4$1
  implements Runnable
{
  QZoneMsgFragment$4$1(QZoneMsgFragment.4 param4, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QZoneMsgEntityNew localQZoneMsgEntityNew = (QZoneMsgEntityNew)localIterator.next();
      if ((localQZoneMsgEntityNew != null) && (localQZoneMsgEntityNew.ArkNes_vec != null) && (localQZoneMsgEntityNew.ArkNes_vec.size() > 0)) {
        localArrayList.addAll(localQZoneMsgEntityNew.ArkNes_vec);
      }
    }
    this.jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$4.this$0.a.a(localArrayList);
    QZoneMsgFragment.a(this.jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$4.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.4.1
 * JD-Core Version:    0.7.0.1
 */