import com.tencent.av.VideoController;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.mediacodec.NativeCodec;
import com.tencent.qphone.base.util.QLog;

public class ldk
{
  public static void a(long paramLong, VideoController paramVideoController, ldm paramldm, ldl paramldl)
  {
    long l1 = System.currentTimeMillis();
    String str = paramldm.a();
    paramVideoController = paramVideoController.a(paramLong, paramldm.a(), str.getBytes());
    long l2 = System.currentTimeMillis();
    if (paramVideoController == null) {}
    for (paramVideoController = "";; paramVideoController = new String(paramVideoController))
    {
      QLog.w("DeviceCapability", 1, "doCodecTest, codec[" + paramldm.jdField_a_of_type_Int + "], sampleMD5[" + paramldm.jdField_a_of_type_JavaLangString + "], cmdParams[" + str + "], result[" + paramVideoController + "], cost[" + (l2 - l1) + "], seq[" + paramLong + "]");
      NativeCodec.hardwareCodecLevelInfo();
      QLog.w("DeviceCapability", 1, "doCodecTest get_info_test numCores: " + lld.e() + ", cpu frep: " + lld.d() + ", memory: " + lld.a() + ", output format: " + AndroidCodec.getHwDetectOutputFormatForReport() + ", H264EncBaseLineLevel: " + NativeCodec.mH264EncBaseLineLevel + ", H264DecBaseLineLevel: " + NativeCodec.mH264DecBaseLineLevel + ", H264EncHighProfileLevel: " + NativeCodec.mH264EncHighProfileLevel + ", H264DecHighProfileLevel: " + NativeCodec.mH264DecHighProfileLevel + ", H265EncLevel: " + NativeCodec.mH265EncLevel + ", H265DecLevel: " + NativeCodec.mH265DecLevel);
      paramldm = new mwz('=', ';');
      paramldm.a(paramVideoController);
      paramldl.a(paramldm.a("i_resultCode", -99), "", 0, paramldm.a("i_delay", -99), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ldk
 * JD-Core Version:    0.7.0.1
 */