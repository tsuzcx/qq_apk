import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.qphone.base.util.QLog;

public class ljm
  extends lja
  implements SurfaceTexture.OnFrameAvailableListener
{
  public ljm(liy paramliy, liz paramliz)
  {
    super(paramliy, paramliz);
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
    lok.a(paramSurfaceTexture);
    a(this.jdField_a_of_type_Ljb);
    int i = liy.a;
    int j = liy.b;
    this.jdField_a_of_type_Ljn.a(this.jdField_a_of_type_Ljb.a, this.jdField_a_of_type_Liy.f, liy.d, this.jdField_a_of_type_Liy.e, this.jdField_a_of_type_Ljb.c, this.jdField_a_of_type_Ljb.d, this.jdField_a_of_type_Ljb.b, 0, i, j);
    lok locallok;
    long l;
    int k;
    int m;
    int n;
    if (this.jdField_a_of_type_Liz != null)
    {
      locallok = lok.a();
      l = this.jdField_a_of_type_Ljn.j;
      k = liy.c;
      m = this.jdField_a_of_type_Ljb.a;
      n = this.jdField_a_of_type_Ljb.b;
      if (this.jdField_a_of_type_Liy.f != 1) {
        break label171;
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      locallok.a(l, paramSurfaceTexture, i, j, k, m, n, bool, liy.d, System.currentTimeMillis());
      this.jdField_a_of_type_Liz.a(locallok);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljm
 * JD-Core Version:    0.7.0.1
 */