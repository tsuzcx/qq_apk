import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;

public class rew
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  private static rew b(feeds_info.LocationInfo paramLocationInfo)
  {
    rew localrew = new rew();
    String str;
    if (paramLocationInfo.bytes_name.has())
    {
      str = paramLocationInfo.bytes_name.get().toStringUtf8();
      localrew.jdField_a_of_type_JavaLangString = str;
      localrew.jdField_a_of_type_Int = paramLocationInfo.uint32_longitude.get();
      localrew.jdField_b_of_type_Int = paramLocationInfo.uint32_latitude.get();
      if (!paramLocationInfo.bytes_icon_url.has()) {
        break label90;
      }
    }
    label90:
    for (paramLocationInfo = paramLocationInfo.bytes_icon_url.get().toStringUtf8();; paramLocationInfo = "")
    {
      localrew.jdField_b_of_type_JavaLangString = paramLocationInfo;
      return localrew;
      str = "";
      break;
    }
  }
  
  public rew a()
  {
    try
    {
      rew localrew = (rew)super.clone();
      return localrew;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rew
 * JD-Core Version:    0.7.0.1
 */