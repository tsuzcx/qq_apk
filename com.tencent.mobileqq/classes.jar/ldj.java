import com.tencent.av.VideoController;
import com.tencent.av.mediacodec.NativeCodec;
import com.tencent.qphone.base.util.QLog;

public class ldj
{
  public static void a(long paramLong, VideoController paramVideoController, ldl paramldl, ldk paramldk)
  {
    long l1 = System.currentTimeMillis();
    String str = paramldl.a();
    paramVideoController = paramVideoController.a(paramLong, paramldl.a(), str.getBytes());
    long l2 = System.currentTimeMillis();
    if (paramVideoController == null) {}
    for (paramVideoController = "";; paramVideoController = new String(paramVideoController))
    {
      QLog.w("DeviceCapability", 1, "doCodecTest, codec[" + paramldl.jdField_a_of_type_Int + "], sampleMD5[" + paramldl.jdField_a_of_type_JavaLangString + "], cmdParams[" + str + "], result[" + paramVideoController + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      NativeCodec.hardwareCodecLevelInfo();
      QLog.w("DeviceCapability", 1, "doCodecTest get_info_test numCores: " + lkw.e() + ", cpu frep: " + lkw.d() + ", memory: " + lkw.a() + ", output format: " + lnr.a() + ", H264EncBaseLineLevel: " + NativeCodec.mH264EncBaseLineLevel + ", H264DecBaseLineLevel: " + NativeCodec.mH264DecBaseLineLevel + ", H264EncHighProfileLevel: " + NativeCodec.mH264EncHighProfileLevel + ", H264DecHighProfileLevel: " + NativeCodec.mH264DecHighProfileLevel + ", H265EncLevel: " + NativeCodec.mH265EncLevel + ", H265DecLevel: " + NativeCodec.mH265DecLevel);
      paramldl = new lny('=', ';');
      paramldl.a(paramVideoController);
      paramldk.a(paramldl.a("i_resultCode", -99), "", 0, paramldl.a("i_delay", -99), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ldj
 * JD-Core Version:    0.7.0.1
 */