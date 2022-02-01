import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class meq
  implements lse
{
  meq(mep parammep, VideoAppInterface paramVideoAppInterface) {}
  
  public void a()
  {
    mep.c(this.jdField_a_of_type_Mep);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = mep.a(paramInt4);
    if (QLog.isColorLevel()) {
      QLog.w(mep.a(this.jdField_a_of_type_Mep), 1, "onRenderInfoNotify, width[" + this.jdField_a_of_type_Mep.w + "->" + paramInt1 + "], height[" + this.jdField_a_of_type_Mep.x + "->" + paramInt2 + "], angle[" + this.jdField_a_of_type_Mep.v + "->" + paramInt3 + "], rotation[" + mep.a(this.jdField_a_of_type_Mep) + "->" + i + "], srcR[" + paramInt4 + "], isLocalView[" + this.jdField_a_of_type_Mep.c() + "]");
    }
    if ((!this.jdField_a_of_type_Mep.c()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    this.jdField_a_of_type_Mep.w = paramInt1;
    this.jdField_a_of_type_Mep.x = paramInt2;
    this.jdField_a_of_type_Mep.v = paramInt3;
    this.jdField_a_of_type_Mep.i = i;
    if (paramInt4 != -1) {
      mep.a(this.jdField_a_of_type_Mep, i);
    }
    mep.d(this.jdField_a_of_type_Mep);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      String str = this.jdField_a_of_type_Mep.b();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void b()
  {
    mep.b(this.jdField_a_of_type_Mep);
  }
  
  public void c()
  {
    mep.a(this.jdField_a_of_type_Mep);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     meq
 * JD-Core Version:    0.7.0.1
 */