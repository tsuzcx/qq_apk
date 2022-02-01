import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qphone.base.util.QLog;

public abstract class lbh
  implements liz
{
  protected int a;
  private low jdField_a_of_type_Low;
  protected mrd a;
  protected boolean a;
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  private void a(byte[] paramArrayOfByte)
  {
    int i;
    if ((this.jdField_a_of_type_Int <= 30) && (!this.jdField_a_of_type_Boolean)) {
      i = 0;
    }
    for (;;)
    {
      if ((i > 10) || (paramArrayOfByte[((int)(java.lang.Math.random() * paramArrayOfByte.length))] != 0))
      {
        if (i < 10) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_Int += 1;
        if ((this.jdField_a_of_type_Int == 30) && (!this.jdField_a_of_type_Boolean)) {
          a();
        }
        return;
      }
      i += 1;
    }
  }
  
  public abstract void a();
  
  public void a(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, boolean paramBoolean)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    a(paramArrayOfByte);
    boolean bool = false;
    if (this.jdField_a_of_type_Low != null) {
      bool = this.jdField_a_of_type_Low.a();
    }
    mrd localmrd;
    if (mrd.a())
    {
      localmrd = new mrd(this.jdField_a_of_type_Mrd, paramLong1);
      localmrd.a(paramArrayOfByte.length, paramInt1, paramInt2, liw.m, paramInt3, paramInt4, paramLong2, paramBoolean, bool);
      localmrd.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_Mrd = localmrd;
      if (bool)
      {
        paramArrayOfByte = new lop(paramLong1, paramArrayOfByte, paramInt1, paramInt2, liw.m, paramInt3, paramInt4, paramBoolean, paramLong2, System.currentTimeMillis());
        paramArrayOfByte.jdField_a_of_type_Mrd = localmrd;
        if (this.jdField_a_of_type_Low == null) {
          break;
        }
        this.jdField_a_of_type_Low.a(paramArrayOfByte);
        return;
      }
      if (localmrd != null) {
        localmrd.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramArrayOfByte, liw.m, paramInt1, paramInt2, paramInt3, paramInt4, System.currentTimeMillis(), paramBoolean, this.jdField_a_of_type_ArrayOfFloat, null, 0, 0);
      ljh.a().a(paramArrayOfByte, 0);
      lsa.a().a(0);
      return;
      localmrd = null;
    }
  }
  
  public void a(low paramlow)
  {
    this.jdField_a_of_type_Low = paramlow;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
  }
  
  public float[] a()
  {
    return this.jdField_a_of_type_ArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbh
 * JD-Core Version:    0.7.0.1
 */