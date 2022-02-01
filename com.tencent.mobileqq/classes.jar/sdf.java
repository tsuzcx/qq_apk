import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

public class sdf
  extends rst
{
  public sdf(sdc paramsdc) {}
  
  public void a(sdj paramsdj, Object paramObject)
  {
    sdc.a(this.a, paramsdj, paramObject);
  }
  
  public void a(sdj paramsdj, String paramString)
  {
    if ((sdc.a(this.a) != null) && (sdc.a(this.a).a != null)) {
      sdc.a(this.a).a.g = paramString;
    }
    sfl.a().a(paramsdj, sdc.a(this.a).b, paramsdj.d());
  }
  
  public void a(sdj paramsdj, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (sdc.a(this.a).size() >= 10)
    {
      paramsdj = (Pair)sdc.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramsdj.first);
      }
    }
    if (paramBoolean) {
      sdc.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((sdj)sdc.a(this.a).get(Integer.valueOf(paramInt2))).l();
  }
  
  public boolean a(sdj paramsdj, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return sdc.a(this.a, paramsdj, paramInt1, paramInt2, paramInt3, paramString, paramObject);
  }
  
  public boolean a(sdj paramsdj, int paramInt, Object paramObject)
  {
    return sdc.a(this.a, paramsdj, paramInt, paramObject);
  }
  
  public void b(sdj paramsdj)
  {
    sdc.a(this.a, paramsdj);
  }
  
  public void c(sdj paramsdj)
  {
    if (QLog.isColorLevel()) {
      QLog.d(sdc.a, 2, "onSeekComplete(): video seek complete ! curPlayState:" + sdi.a(this.a.a()));
    }
    if ((paramsdj == sdc.a(this.a)) && (this.a.a() != 5)) {
      sdc.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdf
 * JD-Core Version:    0.7.0.1
 */