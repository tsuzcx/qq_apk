import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;

public class rhq
  implements Cloneable
{
  public int a;
  public long a;
  public long b;
  
  public rhq()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private static rhq b(feeds_info.VisibleShowInfo paramVisibleShowInfo)
  {
    long l2 = 0L;
    rhq localrhq = new rhq();
    long l1;
    if (paramVisibleShowInfo.uint64_feed_id.has())
    {
      l1 = paramVisibleShowInfo.uint64_feed_id.get();
      localrhq.b = l1;
      if (!paramVisibleShowInfo.uint32_visible_type.has()) {
        break label150;
      }
    }
    label150:
    for (int i = paramVisibleShowInfo.uint32_visible_type.get();; i = 0)
    {
      localrhq.jdField_a_of_type_Int = i;
      l1 = l2;
      if (paramVisibleShowInfo.uint64_who.has()) {
        l1 = paramVisibleShowInfo.uint64_who.get();
      }
      localrhq.jdField_a_of_type_Long = l1;
      QLog.d("SocializeFeedsInfo", 1, "feeds privacy | feedsid  " + localrhq.b + " | privacyType " + localrhq.jdField_a_of_type_Int + " | privacySetUin " + localrhq.jdField_a_of_type_Long);
      return localrhq;
      l1 = 0L;
      break;
    }
  }
  
  public rhq a()
  {
    try
    {
      rhq localrhq = (rhq)super.clone();
      return localrhq;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhq
 * JD-Core Version:    0.7.0.1
 */