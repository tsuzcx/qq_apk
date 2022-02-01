import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class mev
  implements lrz
{
  mev(meu parammeu, VideoAppInterface paramVideoAppInterface) {}
  
  public void a()
  {
    meu.c(this.jdField_a_of_type_Meu);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = meu.a(paramInt4);
    if (QLog.isColorLevel()) {
      QLog.w(meu.a(this.jdField_a_of_type_Meu), 1, "onRenderInfoNotify, width[" + this.jdField_a_of_type_Meu.w + "->" + paramInt1 + "], height[" + this.jdField_a_of_type_Meu.x + "->" + paramInt2 + "], angle[" + this.jdField_a_of_type_Meu.v + "->" + paramInt3 + "], rotation[" + meu.a(this.jdField_a_of_type_Meu) + "->" + i + "], srcR[" + paramInt4 + "], isLocalView[" + this.jdField_a_of_type_Meu.c() + "]");
    }
    if ((!this.jdField_a_of_type_Meu.c()) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10004), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    this.jdField_a_of_type_Meu.w = paramInt1;
    this.jdField_a_of_type_Meu.x = paramInt2;
    this.jdField_a_of_type_Meu.v = paramInt3;
    this.jdField_a_of_type_Meu.i = i;
    if (paramInt4 != -1) {
      meu.a(this.jdField_a_of_type_Meu, i);
    }
    meu.d(this.jdField_a_of_type_Meu);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      String str = this.jdField_a_of_type_Meu.c();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(130), str, paramArrayOfByte });
    }
  }
  
  public void b()
  {
    meu.b(this.jdField_a_of_type_Meu);
  }
  
  public void c()
  {
    meu.a(this.jdField_a_of_type_Meu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mev
 * JD-Core Version:    0.7.0.1
 */