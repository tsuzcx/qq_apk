import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class saf
  implements rtp
{
  saf(sad paramsad, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
        this.jdField_a_of_type_Sad.a(localUgcVideo, true);
      }
    }
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "showMobileNetworkDialog, isContinue=" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     saf
 * JD-Core Version:    0.7.0.1
 */