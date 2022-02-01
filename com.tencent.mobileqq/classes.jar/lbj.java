import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qphone.base.util.QLog;

public abstract class lbj
  implements ljl
{
  protected int a;
  private lpe jdField_a_of_type_Lpe;
  protected msh a;
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
  
  public void a(lox paramlox)
  {
    if (paramlox.a())
    {
      paramlox.b();
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (paramlox.jdField_a_of_type_ArrayOfByte != null) {
      a(paramlox.jdField_a_of_type_ArrayOfByte);
    }
    if ((paramlox.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) && (this.jdField_a_of_type_Lpe == null)) {
      b();
    }
    msh localmsh;
    if (this.jdField_a_of_type_Lpe != null)
    {
      if ((this.jdField_a_of_type_Lpe.a()) || (paramlox.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)) {}
      for (bool = true;; bool = false)
      {
        localmsh = null;
        if (msh.a())
        {
          localmsh = new msh(this.jdField_a_of_type_Msh, paramlox.jdField_c_of_type_Long);
          localmsh.a(paramlox.a(), paramlox.jdField_a_of_type_Int, paramlox.b, paramlox.jdField_c_of_type_Int, paramlox.d, paramlox.e, paramlox.jdField_a_of_type_Long, paramlox.jdField_a_of_type_Boolean, bool);
          localmsh.b();
        }
        this.jdField_a_of_type_Msh = localmsh;
        if (!bool) {
          break label211;
        }
        paramlox.jdField_a_of_type_Msh = localmsh;
        if (this.jdField_a_of_type_Lpe == null) {
          break;
        }
        this.jdField_a_of_type_Lpe.a(paramlox);
        return;
      }
    }
    if (paramlox.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false) {
      break;
    }
    paramlox.b();
    return;
    label211:
    if (localmsh != null) {
      localmsh.f();
    }
    GraphicRenderMgr.getInstance().sendCameraFrame(paramlox.jdField_a_of_type_ArrayOfByte, ljk.jdField_c_of_type_Int, paramlox.jdField_a_of_type_Int, paramlox.b, paramlox.d, paramlox.e, System.currentTimeMillis(), paramlox.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfFloat, null, 0, 0);
    ljv.a().a(paramlox.jdField_a_of_type_ArrayOfByte, 0);
    lsr.a().a(0);
    paramlox.b();
  }
  
  public void a(lpe paramlpe)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraDataProcess", 2, "setEffects, effects[" + paramlpe + "]");
    }
    this.jdField_a_of_type_Lpe = paramlpe;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
  }
  
  public float[] a()
  {
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbj
 * JD-Core Version:    0.7.0.1
 */