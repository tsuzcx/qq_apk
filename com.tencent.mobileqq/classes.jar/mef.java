import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class mef
  implements lse
{
  mef(mee parammee, VideoAppInterface paramVideoAppInterface) {}
  
  public void a()
  {
    mee.c(this.jdField_a_of_type_Mee);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = mee.a(paramInt4);
    if (QLog.isColorLevel()) {
      QLog.w(mee.a(this.jdField_a_of_type_Mee), 1, "onRenderInfoNotify, width[" + this.jdField_a_of_type_Mee.u + "->" + paramInt1 + "], height[" + this.jdField_a_of_type_Mee.v + "->" + paramInt2 + "], angle[" + this.jdField_a_of_type_Mee.t + "->" + paramInt3 + "], rotation[" + mee.a(this.jdField_a_of_type_Mee) + "->" + i + "], srcR[" + paramInt4 + "], isLocalView[" + this.jdField_a_of_type_Mee.c() + "]");
    }
    if ((!this.jdField_a_of_type_Mee.c()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    this.jdField_a_of_type_Mee.u = paramInt1;
    this.jdField_a_of_type_Mee.v = paramInt2;
    this.jdField_a_of_type_Mee.t = paramInt3;
    this.jdField_a_of_type_Mee.i = i;
    if (paramInt4 != -1) {
      mee.a(this.jdField_a_of_type_Mee, i);
    }
    mee.d(this.jdField_a_of_type_Mee);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      String str = this.jdField_a_of_type_Mee.b();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void b()
  {
    mee.b(this.jdField_a_of_type_Mee);
  }
  
  public void c()
  {
    mee.a(this.jdField_a_of_type_Mee);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mef
 * JD-Core Version:    0.7.0.1
 */