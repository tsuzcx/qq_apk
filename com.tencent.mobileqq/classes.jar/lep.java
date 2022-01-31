import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.av.app.VideoAppInterface;

public final class lep
  implements len
{
  public lep(long paramLong1, int paramInt, leo paramleo, lcn paramlcn, VideoAppInterface paramVideoAppInterface, long paramLong2, len paramlen) {}
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    paramString2 = DeviceCapabilityExamination.a(this.jdField_a_of_type_Int, paramInt1, paramInt3, this.jdField_a_of_type_Leo.a, paramString1, paramInt2, l1 - l2);
    paramString2.f = this.jdField_a_of_type_Lcn.jdField_a_of_type_Int;
    paramString2.g = this.jdField_a_of_type_Lcn.b;
    paramString2.h = this.jdField_a_of_type_Lcn.c;
    paramString2.i = this.jdField_a_of_type_Lcn.d;
    if ((paramInt1 == 1) && (this.jdField_a_of_type_Leo.a()) && (this.jdField_a_of_type_Lcn.jdField_a_of_type_Boolean)) {
      new muo(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.b).a(this.jdField_a_of_type_Leo.d, new leq(this, paramString2, paramInt1, paramString1, paramInt2, paramInt3));
    }
    for (;;)
    {
      com.tencent.av.mediacodec.NativeCodec.printLog = false;
      return;
      paramString2.j = -10000;
      DeviceCapabilityExamination.a(paramString2, this.jdField_a_of_type_Int, paramInt1);
      if (this.jdField_a_of_type_Len != null) {
        this.jdField_a_of_type_Len.a(paramInt1, paramString1, paramInt2, paramInt3, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lep
 * JD-Core Version:    0.7.0.1
 */