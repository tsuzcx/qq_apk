import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.qphone.base.util.QLog;

public abstract class lbo
  implements ljf
{
  protected int a;
  private lpj jdField_a_of_type_Lpj;
  protected msb a;
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
  
  public void a(lpc paramlpc)
  {
    if (paramlpc.a())
    {
      paramlpc.b();
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (paramlpc.jdField_a_of_type_ArrayOfByte != null) {
      a(paramlpc.jdField_a_of_type_ArrayOfByte);
    }
    if ((paramlpc.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) && (this.jdField_a_of_type_Lpj == null)) {
      b();
    }
    msb localmsb;
    if (this.jdField_a_of_type_Lpj != null)
    {
      if ((this.jdField_a_of_type_Lpj.a()) || (paramlpc.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)) {}
      for (bool = true;; bool = false)
      {
        localmsb = null;
        if (msb.a())
        {
          localmsb = new msb(this.jdField_a_of_type_Msb, paramlpc.jdField_c_of_type_Long);
          localmsb.a(paramlpc.a(), paramlpc.jdField_a_of_type_Int, paramlpc.b, paramlpc.jdField_c_of_type_Int, paramlpc.d, paramlpc.e, paramlpc.jdField_a_of_type_Long, paramlpc.jdField_a_of_type_Boolean, bool);
          localmsb.b();
        }
        this.jdField_a_of_type_Msb = localmsb;
        if (!bool) {
          break label211;
        }
        paramlpc.jdField_a_of_type_Msb = localmsb;
        if (this.jdField_a_of_type_Lpj == null) {
          break;
        }
        this.jdField_a_of_type_Lpj.a(paramlpc);
        return;
      }
    }
    if (paramlpc.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false) {
      break;
    }
    paramlpc.b();
    return;
    label211:
    if (localmsb != null) {
      localmsb.f();
    }
    GraphicRenderMgr.getInstance().sendCameraFrame(paramlpc.jdField_a_of_type_ArrayOfByte, lje.jdField_c_of_type_Int, paramlpc.jdField_a_of_type_Int, paramlpc.b, paramlpc.d, paramlpc.e, System.currentTimeMillis(), paramlpc.jdField_a_of_type_Boolean, this.jdField_a_of_type_ArrayOfFloat, null, 0, 0);
    ljp.a().a(paramlpc.jdField_a_of_type_ArrayOfByte, 0);
    lsw.a().a(0);
    paramlpc.b();
  }
  
  public void a(lpj paramlpj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraDataProcess", 2, "setEffects, effects[" + paramlpj + "]");
    }
    this.jdField_a_of_type_Lpj = paramlpj;
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
 * Qualified Name:     lbo
 * JD-Core Version:    0.7.0.1
 */