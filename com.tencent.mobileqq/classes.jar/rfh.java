import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;

public class rfh
  implements Cloneable
{
  public int a;
  public long a;
  public long b;
  
  public rfh()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private static rfh b(feeds_info.VisibleShowInfo paramVisibleShowInfo)
  {
    long l2 = 0L;
    rfh localrfh = new rfh();
    long l1;
    if (paramVisibleShowInfo.uint64_feed_id.has())
    {
      l1 = paramVisibleShowInfo.uint64_feed_id.get();
      localrfh.b = l1;
      if (!paramVisibleShowInfo.uint32_visible_type.has()) {
        break label150;
      }
    }
    label150:
    for (int i = paramVisibleShowInfo.uint32_visible_type.get();; i = 0)
    {
      localrfh.jdField_a_of_type_Int = i;
      l1 = l2;
      if (paramVisibleShowInfo.uint64_who.has()) {
        l1 = paramVisibleShowInfo.uint64_who.get();
      }
      localrfh.jdField_a_of_type_Long = l1;
      QLog.d("SocializeFeedsInfo", 1, "feeds privacy | feedsid  " + localrfh.b + " | privacyType " + localrfh.jdField_a_of_type_Int + " | privacySetUin " + localrfh.jdField_a_of_type_Long);
      return localrfh;
      l1 = 0L;
      break;
    }
  }
  
  public rfh a()
  {
    try
    {
      rfh localrfh = (rfh)super.clone();
      return localrfh;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfh
 * JD-Core Version:    0.7.0.1
 */