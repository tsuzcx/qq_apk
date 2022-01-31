import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class qup
  implements qoo
{
  qup(qun paramqun, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
        this.jdField_a_of_type_Qun.a(localUgcVideo, true);
      }
    }
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "showMobileNetworkDialog, isContinue=" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qup
 * JD-Core Version:    0.7.0.1
 */