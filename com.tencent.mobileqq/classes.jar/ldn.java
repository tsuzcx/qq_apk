import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.av.app.VideoAppInterface;

public final class ldn
  implements ldl
{
  public ldn(long paramLong1, int paramInt, ldm paramldm, lbj paramlbj, VideoAppInterface paramVideoAppInterface, long paramLong2, ldl paramldl) {}
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    paramString2 = DeviceCapabilityExamination.a(this.jdField_a_of_type_Int, paramInt1, paramInt3, this.jdField_a_of_type_Ldm.a, paramString1, paramInt2, l1 - l2);
    paramString2.f = this.jdField_a_of_type_Lbj.jdField_a_of_type_Int;
    paramString2.g = this.jdField_a_of_type_Lbj.b;
    paramString2.h = this.jdField_a_of_type_Lbj.c;
    paramString2.i = this.jdField_a_of_type_Lbj.d;
    if ((paramInt1 == 1) && (this.jdField_a_of_type_Ldm.a()) && (this.jdField_a_of_type_Lbj.jdField_a_of_type_Boolean)) {
      new mux(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.b).a(this.jdField_a_of_type_Ldm.d, new ldo(this, paramString2, paramInt1, paramString1, paramInt2, paramInt3));
    }
    for (;;)
    {
      com.tencent.av.mediacodec.NativeCodec.printLog = false;
      return;
      paramString2.j = -10000;
      DeviceCapabilityExamination.a(paramString2, this.jdField_a_of_type_Int, paramInt1);
      if (this.jdField_a_of_type_Ldl != null) {
        this.jdField_a_of_type_Ldl.a(paramInt1, paramString1, paramInt2, paramInt3, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ldn
 * JD-Core Version:    0.7.0.1
 */