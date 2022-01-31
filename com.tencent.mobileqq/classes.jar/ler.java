import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

public class ler
{
  public static void a(long paramLong, VideoController paramVideoController, let paramlet, les paramles)
  {
    long l1 = System.currentTimeMillis();
    String str = paramlet.a();
    paramVideoController = paramVideoController.a(paramLong, paramlet.a(), str.getBytes());
    long l2 = System.currentTimeMillis();
    if (paramVideoController == null) {}
    for (paramVideoController = "";; paramVideoController = new String(paramVideoController))
    {
      QLog.w("DeviceCapability", 1, "doCodecTest, codec[" + paramlet.jdField_a_of_type_Int + "], sampleMD5[" + paramlet.jdField_a_of_type_JavaLangString + "], cmdParams[" + str + "], result[" + paramVideoController + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      paramlet = new lpd('=', ';');
      paramlet.a(paramVideoController);
      paramles.a(paramlet.a("i_resultCode", -99), "", 0, paramlet.a("i_delay", -99), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ler
 * JD-Core Version:    0.7.0.1
 */