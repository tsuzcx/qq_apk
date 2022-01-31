import com.tencent.av.VideoController;
import com.tencent.av.mediacodec.NativeCodec;
import com.tencent.qphone.base.util.QLog;

public class lgp
{
  public static void a(long paramLong, VideoController paramVideoController, lgr paramlgr, lgq paramlgq)
  {
    long l1 = System.currentTimeMillis();
    String str = paramlgr.a();
    paramVideoController = paramVideoController.a(paramLong, paramlgr.a(), str.getBytes());
    long l2 = System.currentTimeMillis();
    if (paramVideoController == null) {}
    for (paramVideoController = "";; paramVideoController = new String(paramVideoController))
    {
      QLog.w("DeviceCapability", 1, "doCodecTest, codec[" + paramlgr.jdField_a_of_type_Int + "], sampleMD5[" + paramlgr.jdField_a_of_type_JavaLangString + "], cmdParams[" + str + "], result[" + paramVideoController + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      NativeCodec.hardwareCodecLevelInfo();
      QLog.w("DeviceCapability", 1, "doCodecTest get_info_test numCores: " + lnz.e() + ", cpu frep: " + lnz.d() + ", memory: " + lnz.a() + ", output format: " + lqu.a() + ", H264EncBaseLineLevel: " + NativeCodec.mH264EncBaseLineLevel + ", H264DecBaseLineLevel: " + NativeCodec.mH264DecBaseLineLevel + ", H264EncHighProfileLevel: " + NativeCodec.mH264EncHighProfileLevel + ", H264DecHighProfileLevel: " + NativeCodec.mH264DecHighProfileLevel + ", H265EncLevel: " + NativeCodec.mH265EncLevel + ", H265DecLevel: " + NativeCodec.mH265DecLevel);
      paramlgr = new lrb('=', ';');
      paramlgr.a(paramVideoController);
      paramlgq.a(paramlgr.a("i_resultCode", -99), "", 0, paramlgr.a("i_delay", -99), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lgp
 * JD-Core Version:    0.7.0.1
 */