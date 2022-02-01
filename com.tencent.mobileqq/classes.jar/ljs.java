import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.qphone.base.util.QLog;

public class ljs
  extends ljg
  implements SurfaceTexture.OnFrameAvailableListener
{
  public ljs(lje paramlje, ljf paramljf)
  {
    super(paramlje, paramljf);
  }
  
  public void a() {}
  
  public void a(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.setOnFrameAvailableListener(this);
    }
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "setPreviewCallback, seq[" + paramLong + "], surfaceTexture[" + paramSurfaceTexture + "]");
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    lpc.a(paramSurfaceTexture);
    a(this.jdField_a_of_type_Ljh);
    int i = lje.a;
    int j = lje.b;
    this.jdField_a_of_type_Ljt.a(this.jdField_a_of_type_Ljh.a, this.jdField_a_of_type_Lje.f, lje.d, this.jdField_a_of_type_Lje.e, this.jdField_a_of_type_Ljh.c, this.jdField_a_of_type_Ljh.d, this.jdField_a_of_type_Ljh.b, 0, i, j);
    lpc locallpc;
    long l;
    int k;
    int m;
    int n;
    if (this.jdField_a_of_type_Ljf != null)
    {
      locallpc = lpc.a();
      l = this.jdField_a_of_type_Ljt.j;
      k = lje.c;
      m = this.jdField_a_of_type_Ljh.a;
      n = this.jdField_a_of_type_Ljh.b;
      if (this.jdField_a_of_type_Lje.f != 1) {
        break label171;
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      locallpc.a(l, paramSurfaceTexture, i, j, k, m, n, bool, lje.d, System.currentTimeMillis());
      this.jdField_a_of_type_Ljf.a(locallpc);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljs
 * JD-Core Version:    0.7.0.1
 */