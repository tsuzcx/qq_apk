import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.CriticalEventConfiguration;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.ReqBody;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.RspBody;

public class ooa
{
  private static String jdField_a_of_type_JavaLangString;
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private static boolean jdField_a_of_type_Boolean = true;
  private static String b;
  private static String c;
  
  public static String a()
  {
    return b;
  }
  
  public static Set<String> a()
  {
    return jdField_a_of_type_JavaUtilSet;
  }
  
  public static void a(oidb_cmd0x80a.ReqBody paramReqBody)
  {
    int j = paramReqBody.uint32_configuration_bitmap.get();
    int i = j;
    if (a()) {
      i = j | 0x1;
    }
    paramReqBody.uint32_configuration_bitmap.set(i);
  }
  
  public static void a(oidb_cmd0x80a.RspBody paramRspBody)
  {
    int i = 1;
    if (paramRspBody.critical_event_configuration.has())
    {
      paramRspBody = (oidb_cmd0x80a.CriticalEventConfiguration)paramRspBody.critical_event_configuration.get();
      if (paramRspBody.path_1.has())
      {
        jdField_a_of_type_JavaLangString = paramRspBody.path_1.get();
        if (!paramRspBody.path_2.has()) {
          break label127;
        }
        b = paramRspBody.path_2.get();
        label63:
        if (!paramRspBody.path_3.has()) {
          break label132;
        }
        c = paramRspBody.path_3.get();
        label83:
        j = i;
        if (paramRspBody.filter_list.has()) {
          jdField_a_of_type_JavaUtilSet.addAll(paramRspBody.filter_list.get());
        }
      }
    }
    for (int j = i;; j = 0)
    {
      if (j != 0) {
        a(false);
      }
      return;
      i = 0;
      break;
      label127:
      i = 0;
      break label63;
      label132:
      i = 0;
      break label83;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static String b()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ooa
 * JD-Core Version:    0.7.0.1
 */