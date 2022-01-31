import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

public class lem
{
  public static void a(long paramLong, VideoController paramVideoController, leo paramleo, len paramlen)
  {
    long l1 = System.currentTimeMillis();
    String str = paramleo.a();
    paramVideoController = paramVideoController.a(paramLong, paramleo.a(), str.getBytes());
    long l2 = System.currentTimeMillis();
    if (paramVideoController == null) {}
    for (paramVideoController = "";; paramVideoController = new String(paramVideoController))
    {
      QLog.w("DeviceCapability", 1, "doCodecTest, codec[" + paramleo.jdField_a_of_type_Int + "], sampleMD5[" + paramleo.jdField_a_of_type_JavaLangString + "], cmdParams[" + str + "], result[" + paramVideoController + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      paramleo = new loy('=', ';');
      paramleo.a(paramVideoController);
      paramlen.a(paramleo.a("i_resultCode", -99), "", 0, paramleo.a("i_delay", -99), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lem
 * JD-Core Version:    0.7.0.1
 */