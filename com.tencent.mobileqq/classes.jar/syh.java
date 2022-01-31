import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class syh
  implements Runnable
{
  syh(syg paramsyg, List paramList) {}
  
  public void run()
  {
    if (Leba.a(this.jdField_a_of_type_Syg.a) == null) {
      Leba.a(this.jdField_a_of_type_Syg.a, new ArrayList());
    }
    Iterator localIterator1 = Leba.a(this.jdField_a_of_type_Syg.a).iterator();
    while (localIterator1.hasNext())
    {
      LebaViewItem localLebaViewItem1 = (LebaViewItem)localIterator1.next();
      if ((localLebaViewItem1 != null) && (localLebaViewItem1.b != null) && (localLebaViewItem1.a != null))
      {
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          LebaViewItem localLebaViewItem2 = (LebaViewItem)localIterator2.next();
          if ((localLebaViewItem2 != null) && (localLebaViewItem2.a != null) && (localLebaViewItem2.a.strPkgName.equals(localLebaViewItem1.a.strPkgName))) {
            localLebaViewItem2.b = localLebaViewItem1.b;
          }
        }
      }
    }
    Leba.a(this.jdField_a_of_type_Syg.a).clear();
    Leba.a(this.jdField_a_of_type_Syg.a).addAll(this.jdField_a_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. lebaData size=" + Leba.a(this.jdField_a_of_type_Syg.a).size());
    }
    if (this.jdField_a_of_type_Syg.a.a != null)
    {
      this.jdField_a_of_type_Syg.a.a.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "refreshLebaConfig. notifyData.");
      }
      Leba.c(this.jdField_a_of_type_Syg.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syh
 * JD-Core Version:    0.7.0.1
 */