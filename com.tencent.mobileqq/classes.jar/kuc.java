import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

public class kuc
{
  public static void a(long paramLong, VideoController paramVideoController, kue paramkue, kud paramkud)
  {
    long l1 = System.currentTimeMillis();
    String str = paramkue.a();
    paramVideoController = paramVideoController.a(paramLong, paramkue.a(), str.getBytes());
    long l2 = System.currentTimeMillis();
    if (paramVideoController == null) {}
    for (paramVideoController = "";; paramVideoController = new String(paramVideoController))
    {
      QLog.w("DeviceCapability", 1, "doCodecTest, codec[" + paramkue.jdField_a_of_type_Int + "], sampleMD5[" + paramkue.jdField_a_of_type_JavaLangString + "], cmdParams[" + str + "], result[" + paramVideoController + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      paramkue = new lem('=', ';');
      paramkue.a(paramVideoController);
      paramkud.a(paramkue.a("i_resultCode", -99), "", 0, paramkue.a("i_delay", -99), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kuc
 * JD-Core Version:    0.7.0.1
 */