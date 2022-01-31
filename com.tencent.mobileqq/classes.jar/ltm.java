import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class ltm
  implements lhn
{
  ltm(ltl paramltl, VideoAppInterface paramVideoAppInterface) {}
  
  public void a()
  {
    ltl.c(this.jdField_a_of_type_Ltl);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = ltl.a(paramInt4);
    if (QLog.isColorLevel()) {
      QLog.w(ltl.a(this.jdField_a_of_type_Ltl), 1, "onRenderInfoNotify, width[" + this.jdField_a_of_type_Ltl.s + "->" + paramInt1 + "], height[" + this.jdField_a_of_type_Ltl.t + "->" + paramInt2 + "], angle[" + this.jdField_a_of_type_Ltl.r + "->" + paramInt3 + "], rotation[" + ltl.a(this.jdField_a_of_type_Ltl) + "->" + i + "], srcR[" + paramInt4 + "]");
    }
    this.jdField_a_of_type_Ltl.s = paramInt1;
    this.jdField_a_of_type_Ltl.t = paramInt2;
    this.jdField_a_of_type_Ltl.r = paramInt3;
    if (paramInt4 != -1) {
      ltl.a(this.jdField_a_of_type_Ltl, i);
    }
    ltl.d(this.jdField_a_of_type_Ltl);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      String str = this.jdField_a_of_type_Ltl.b();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void b()
  {
    ltl.b(this.jdField_a_of_type_Ltl);
  }
  
  public void c()
  {
    ltl.a(this.jdField_a_of_type_Ltl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ltm
 * JD-Core Version:    0.7.0.1
 */