import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class mdz
  implements lrm
{
  mdz(mdy parammdy, VideoAppInterface paramVideoAppInterface) {}
  
  public void a()
  {
    mdy.c(this.jdField_a_of_type_Mdy);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = mdy.a(paramInt4);
    if (QLog.isColorLevel()) {
      QLog.w(mdy.a(this.jdField_a_of_type_Mdy), 1, "onRenderInfoNotify, width[" + this.jdField_a_of_type_Mdy.w + "->" + paramInt1 + "], height[" + this.jdField_a_of_type_Mdy.x + "->" + paramInt2 + "], angle[" + this.jdField_a_of_type_Mdy.v + "->" + paramInt3 + "], rotation[" + mdy.a(this.jdField_a_of_type_Mdy) + "->" + i + "], srcR[" + paramInt4 + "], isLocalView[" + this.jdField_a_of_type_Mdy.c() + "]");
    }
    if ((!this.jdField_a_of_type_Mdy.c()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    this.jdField_a_of_type_Mdy.w = paramInt1;
    this.jdField_a_of_type_Mdy.x = paramInt2;
    this.jdField_a_of_type_Mdy.v = paramInt3;
    this.jdField_a_of_type_Mdy.i = i;
    if (paramInt4 != -1) {
      mdy.a(this.jdField_a_of_type_Mdy, i);
    }
    mdy.d(this.jdField_a_of_type_Mdy);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      String str = this.jdField_a_of_type_Mdy.b();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void b()
  {
    mdy.b(this.jdField_a_of_type_Mdy);
  }
  
  public void c()
  {
    mdy.a(this.jdField_a_of_type_Mdy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdz
 * JD-Core Version:    0.7.0.1
 */