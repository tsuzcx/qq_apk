import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.qphone.base.util.QLog;

public class ljy
  extends ljm
  implements SurfaceTexture.OnFrameAvailableListener
{
  public ljy(ljk paramljk, ljl paramljl)
  {
    super(paramljk, paramljl);
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
    lox.a(paramSurfaceTexture);
    a(this.jdField_a_of_type_Ljn);
    int i = ljk.a;
    int j = ljk.b;
    this.jdField_a_of_type_Ljz.a(this.jdField_a_of_type_Ljn.a, this.jdField_a_of_type_Ljk.f, ljk.d, this.jdField_a_of_type_Ljk.e, this.jdField_a_of_type_Ljn.c, this.jdField_a_of_type_Ljn.d, this.jdField_a_of_type_Ljn.b, 0, i, j);
    lox locallox;
    long l;
    int k;
    int m;
    int n;
    if (this.jdField_a_of_type_Ljl != null)
    {
      locallox = lox.a();
      l = this.jdField_a_of_type_Ljz.j;
      k = ljk.c;
      m = this.jdField_a_of_type_Ljn.a;
      n = this.jdField_a_of_type_Ljn.b;
      if (this.jdField_a_of_type_Ljk.f != 1) {
        break label171;
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      locallox.a(l, paramSurfaceTexture, i, j, k, m, n, bool, ljk.d, System.currentTimeMillis());
      this.jdField_a_of_type_Ljl.a(locallox);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljy
 * JD-Core Version:    0.7.0.1
 */