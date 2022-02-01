import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qphone.base.util.QLog;

public abstract class lbg
  implements liz
{
  protected int a;
  private lor jdField_a_of_type_Lor;
  protected mrk a;
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
  
  public void a(lok paramlok)
  {
    if (paramlok.a())
    {
      paramlok.b();
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (paramlok.jdField_a_of_type_ArrayOfByte != null) {
      a(paramlok.jdField_a_of_type_ArrayOfByte);
    }
    if ((paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) && (this.jdField_a_of_type_Lor == null)) {
      b();
    }
    mrk localmrk;
    if (this.jdField_a_of_type_Lor != null)
    {
      if ((this.jdField_a_of_type_Lor.a()) || (paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)) {}
      for (bool = true;; bool = false)
      {
        localmrk = null;
        if (mrk.a())
        {
          localmrk = new mrk(this.jdField_a_of_type_Mrk, paramlok.jdField_c_of_type_Long);
          localmrk.a(paramlok.a(), paramlok.jdField_a_of_type_Int, paramlok.b, paramlok.jdField_c_of_type_Int, paramlok.d, paramlok.e, paramlok.jdField_a_of_type_Long, paramlok.jdField_a_of_type_Boolean, bool);
          localmrk.b();
        }
        this.jdField_a_of_type_Mrk = localmrk;
        if (!bool) {
          break label211;
        }
        paramlok.jdField_a_of_type_Mrk = localmrk;
        if (this.jdField_a_of_type_Lor == null) {
          break;
        }
        this.jdField_a_of_type_Lor.a(paramlok);
        return;
      }
    }
    if (paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false) {
      break;
    }
    paramlok.b();
    return;
    label211:
    if (localmrk != null) {
      localmrk.f();
    }
    GraphicRenderMgr.getInstance().sendCameraFrame(paramlok.jdField_a_of_type_ArrayOfByte, liy.jdField_c_of_type_Int, paramlok.jdField_a_of_type_Int, paramlok.b, paramlok.d, paramlok.e, System.currentTimeMillis(), paramlok.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfFloat, null, 0, 0);
    ljj.a().a(paramlok.jdField_a_of_type_ArrayOfByte, 0);
    lse.a().a(0);
    paramlok.b();
  }
  
  public void a(lor paramlor)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraDataProcess", 2, "setEffects, effects[" + paramlor + "]");
    }
    this.jdField_a_of_type_Lor = paramlor;
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
 * Qualified Name:     lbg
 * JD-Core Version:    0.7.0.1
 */