import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.av.app.VideoAppInterface;

public final class ldm
  implements ldk
{
  public ldm(long paramLong1, int paramInt, ldl paramldl, lbk paramlbk, VideoAppInterface paramVideoAppInterface, long paramLong2, ldk paramldk) {}
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    paramString2 = DeviceCapabilityExamination.a(this.jdField_a_of_type_Int, paramInt1, paramInt3, this.jdField_a_of_type_Ldl.a, paramString1, paramInt2, l1 - l2);
    paramString2.f = this.jdField_a_of_type_Lbk.jdField_a_of_type_Int;
    paramString2.g = this.jdField_a_of_type_Lbk.b;
    paramString2.h = this.jdField_a_of_type_Lbk.c;
    paramString2.i = this.jdField_a_of_type_Lbk.d;
    if ((paramInt1 == 1) && (this.jdField_a_of_type_Ldl.a()) && (this.jdField_a_of_type_Lbk.jdField_a_of_type_Boolean)) {
      new mup(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.b).a(this.jdField_a_of_type_Ldl.d, new ldn(this, paramString2, paramInt1, paramString1, paramInt2, paramInt3));
    }
    for (;;)
    {
      com.tencent.av.mediacodec.NativeCodec.printLog = false;
      return;
      paramString2.j = -10000;
      DeviceCapabilityExamination.a(paramString2, this.jdField_a_of_type_Int, paramInt1);
      if (this.jdField_a_of_type_Ldk != null) {
        this.jdField_a_of_type_Ldk.a(paramInt1, paramString1, paramInt2, paramInt3, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ldm
 * JD-Core Version:    0.7.0.1
 */