import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.BuluoInfo;

public class req
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static req a(articlesummary.BuluoInfo paramBuluoInfo)
  {
    req localreq = new req();
    String str;
    if (paramBuluoInfo.bytes_wording.has())
    {
      str = paramBuluoInfo.bytes_wording.get().toStringUtf8();
      localreq.jdField_a_of_type_JavaLangString = str;
      if (!paramBuluoInfo.bytes_head_url.has()) {
        break label131;
      }
      str = paramBuluoInfo.bytes_head_url.get().toStringUtf8();
      label55:
      localreq.d = str;
      localreq.jdField_a_of_type_Long = paramBuluoInfo.uint64_buluo_id.get();
      if (!paramBuluoInfo.bytes_jump_url.has()) {
        break label137;
      }
      str = paramBuluoInfo.bytes_jump_url.get().toStringUtf8();
      label92:
      localreq.b = str;
      if (!paramBuluoInfo.bytes_name.has()) {
        break label143;
      }
    }
    label131:
    label137:
    label143:
    for (paramBuluoInfo = paramBuluoInfo.bytes_name.get().toStringUtf8();; paramBuluoInfo = "")
    {
      localreq.c = paramBuluoInfo;
      return localreq;
      str = "";
      break;
      str = "";
      break label55;
      str = "";
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     req
 * JD-Core Version:    0.7.0.1
 */