import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;

public class rrd
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  private static rrd b(feeds_info.LocationInfo paramLocationInfo)
  {
    rrd localrrd = new rrd();
    String str;
    if (paramLocationInfo.bytes_name.has())
    {
      str = paramLocationInfo.bytes_name.get().toStringUtf8();
      localrrd.jdField_a_of_type_JavaLangString = str;
      localrrd.jdField_a_of_type_Int = paramLocationInfo.uint32_longitude.get();
      localrrd.jdField_b_of_type_Int = paramLocationInfo.uint32_latitude.get();
      if (!paramLocationInfo.bytes_icon_url.has()) {
        break label90;
      }
    }
    label90:
    for (paramLocationInfo = paramLocationInfo.bytes_icon_url.get().toStringUtf8();; paramLocationInfo = "")
    {
      localrrd.jdField_b_of_type_JavaLangString = paramLocationInfo;
      return localrrd;
      str = "";
      break;
    }
  }
  
  public rrd a()
  {
    try
    {
      rrd localrrd = (rrd)super.clone();
      return localrrd;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrd
 * JD-Core Version:    0.7.0.1
 */