import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class mgq
  implements lug
{
  mgq(mgp parammgp, VideoAppInterface paramVideoAppInterface) {}
  
  public void a()
  {
    mgp.c(this.jdField_a_of_type_Mgp);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = mgp.a(paramInt4);
    if (QLog.isColorLevel()) {
      QLog.w(mgp.a(this.jdField_a_of_type_Mgp), 1, "onRenderInfoNotify, width[" + this.jdField_a_of_type_Mgp.w + "->" + paramInt1 + "], height[" + this.jdField_a_of_type_Mgp.x + "->" + paramInt2 + "], angle[" + this.jdField_a_of_type_Mgp.v + "->" + paramInt3 + "], rotation[" + mgp.a(this.jdField_a_of_type_Mgp) + "->" + i + "], srcR[" + paramInt4 + "], isLocalView[" + this.jdField_a_of_type_Mgp.c() + "]");
    }
    if ((!this.jdField_a_of_type_Mgp.c()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    this.jdField_a_of_type_Mgp.w = paramInt1;
    this.jdField_a_of_type_Mgp.x = paramInt2;
    this.jdField_a_of_type_Mgp.v = paramInt3;
    this.jdField_a_of_type_Mgp.i = i;
    if (paramInt4 != -1) {
      mgp.a(this.jdField_a_of_type_Mgp, i);
    }
    mgp.d(this.jdField_a_of_type_Mgp);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      String str = this.jdField_a_of_type_Mgp.b();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void b()
  {
    mgp.b(this.jdField_a_of_type_Mgp);
  }
  
  public void c()
  {
    mgp.a(this.jdField_a_of_type_Mgp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mgq
 * JD-Core Version:    0.7.0.1
 */