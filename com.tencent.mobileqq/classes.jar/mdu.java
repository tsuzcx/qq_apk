import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class mdu
  implements lri
{
  mdu(mdt parammdt, VideoAppInterface paramVideoAppInterface) {}
  
  public void a()
  {
    mdt.c(this.jdField_a_of_type_Mdt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = mdt.a(paramInt4);
    if (QLog.isColorLevel()) {
      QLog.w(mdt.a(this.jdField_a_of_type_Mdt), 1, "onRenderInfoNotify, width[" + this.jdField_a_of_type_Mdt.w + "->" + paramInt1 + "], height[" + this.jdField_a_of_type_Mdt.x + "->" + paramInt2 + "], angle[" + this.jdField_a_of_type_Mdt.v + "->" + paramInt3 + "], rotation[" + mdt.a(this.jdField_a_of_type_Mdt) + "->" + i + "], srcR[" + paramInt4 + "], isLocalView[" + this.jdField_a_of_type_Mdt.c() + "]");
    }
    if ((!this.jdField_a_of_type_Mdt.c()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    this.jdField_a_of_type_Mdt.w = paramInt1;
    this.jdField_a_of_type_Mdt.x = paramInt2;
    this.jdField_a_of_type_Mdt.v = paramInt3;
    this.jdField_a_of_type_Mdt.i = i;
    if (paramInt4 != -1) {
      mdt.a(this.jdField_a_of_type_Mdt, i);
    }
    mdt.d(this.jdField_a_of_type_Mdt);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      String str = this.jdField_a_of_type_Mdt.b();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void b()
  {
    mdt.b(this.jdField_a_of_type_Mdt);
  }
  
  public void c()
  {
    mdt.a(this.jdField_a_of_type_Mdt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdu
 * JD-Core Version:    0.7.0.1
 */