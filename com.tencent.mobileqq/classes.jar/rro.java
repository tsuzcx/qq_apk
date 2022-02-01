import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;

public class rro
  implements Cloneable
{
  public int a;
  public long a;
  public long b;
  
  public rro()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private static rro b(feeds_info.VisibleShowInfo paramVisibleShowInfo)
  {
    long l2 = 0L;
    rro localrro = new rro();
    long l1;
    if (paramVisibleShowInfo.uint64_feed_id.has())
    {
      l1 = paramVisibleShowInfo.uint64_feed_id.get();
      localrro.b = l1;
      if (!paramVisibleShowInfo.uint32_visible_type.has()) {
        break label150;
      }
    }
    label150:
    for (int i = paramVisibleShowInfo.uint32_visible_type.get();; i = 0)
    {
      localrro.jdField_a_of_type_Int = i;
      l1 = l2;
      if (paramVisibleShowInfo.uint64_who.has()) {
        l1 = paramVisibleShowInfo.uint64_who.get();
      }
      localrro.jdField_a_of_type_Long = l1;
      QLog.d("SocializeFeedsInfo", 1, "feeds privacy | feedsid  " + localrro.b + " | privacyType " + localrro.jdField_a_of_type_Int + " | privacySetUin " + localrro.jdField_a_of_type_Long);
      return localrro;
      l1 = 0L;
      break;
    }
  }
  
  public rro a()
  {
    try
    {
      rro localrro = (rro)super.clone();
      return localrro;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rro
 * JD-Core Version:    0.7.0.1
 */