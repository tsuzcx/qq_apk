import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;

public class rhf
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  private static rhf b(feeds_info.LocationInfo paramLocationInfo)
  {
    rhf localrhf = new rhf();
    String str;
    if (paramLocationInfo.bytes_name.has())
    {
      str = paramLocationInfo.bytes_name.get().toStringUtf8();
      localrhf.jdField_a_of_type_JavaLangString = str;
      localrhf.jdField_a_of_type_Int = paramLocationInfo.uint32_longitude.get();
      localrhf.jdField_b_of_type_Int = paramLocationInfo.uint32_latitude.get();
      if (!paramLocationInfo.bytes_icon_url.has()) {
        break label90;
      }
    }
    label90:
    for (paramLocationInfo = paramLocationInfo.bytes_icon_url.get().toStringUtf8();; paramLocationInfo = "")
    {
      localrhf.jdField_b_of_type_JavaLangString = paramLocationInfo;
      return localrhf;
      str = "";
      break;
    }
  }
  
  public rhf a()
  {
    try
    {
      rhf localrhf = (rhf)super.clone();
      return localrhf;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rhf
 * JD-Core Version:    0.7.0.1
 */