import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

public class rwb
  extends rlt
{
  public rwb(rvy paramrvy) {}
  
  public void a(rwf paramrwf, Object paramObject)
  {
    rvy.a(this.a, paramrwf, paramObject);
  }
  
  public void a(rwf paramrwf, String paramString)
  {
    if ((rvy.a(this.a) != null) && (rvy.a(this.a).a != null)) {
      rvy.a(this.a).a.g = paramString;
    }
    ryh.a().a(paramrwf, rvy.a(this.a).b, paramrwf.d());
  }
  
  public void a(rwf paramrwf, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (rvy.a(this.a).size() >= 10)
    {
      paramrwf = (Pair)rvy.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramrwf.first);
      }
    }
    if (paramBoolean) {
      rvy.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((rwf)rvy.a(this.a).get(Integer.valueOf(paramInt2))).l();
  }
  
  public boolean a(rwf paramrwf, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return rvy.a(this.a, paramrwf, paramInt1, paramInt2, paramInt3, paramString, paramObject);
  }
  
  public boolean a(rwf paramrwf, int paramInt, Object paramObject)
  {
    return rvy.a(this.a, paramrwf, paramInt, paramObject);
  }
  
  public void b(rwf paramrwf)
  {
    rvy.a(this.a, paramrwf);
  }
  
  public void c(rwf paramrwf)
  {
    if (QLog.isColorLevel()) {
      QLog.d(rvy.a, 2, "onSeekComplete(): video seek complete ! curPlayState:" + rwe.a(this.a.a()));
    }
    if ((paramrwf == rvy.a(this.a)) && (this.a.a() != 5)) {
      rvy.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rwb
 * JD-Core Version:    0.7.0.1
 */