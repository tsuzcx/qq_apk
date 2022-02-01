import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;

public class qxy
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  private static qxy b(feeds_info.LocationInfo paramLocationInfo)
  {
    qxy localqxy = new qxy();
    String str;
    if (paramLocationInfo.bytes_name.has())
    {
      str = paramLocationInfo.bytes_name.get().toStringUtf8();
      localqxy.jdField_a_of_type_JavaLangString = str;
      localqxy.jdField_a_of_type_Int = paramLocationInfo.uint32_longitude.get();
      localqxy.jdField_b_of_type_Int = paramLocationInfo.uint32_latitude.get();
      if (!paramLocationInfo.bytes_icon_url.has()) {
        break label90;
      }
    }
    label90:
    for (paramLocationInfo = paramLocationInfo.bytes_icon_url.get().toStringUtf8();; paramLocationInfo = "")
    {
      localqxy.jdField_b_of_type_JavaLangString = paramLocationInfo;
      return localqxy;
      str = "";
      break;
    }
  }
  
  public qxy a()
  {
    try
    {
      qxy localqxy = (qxy)super.clone();
      return localqxy;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxy
 * JD-Core Version:    0.7.0.1
 */