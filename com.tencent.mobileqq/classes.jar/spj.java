import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

public class spj
  extends sfi
{
  public spj(spg paramspg) {}
  
  public void a(spn paramspn, Object paramObject)
  {
    spg.a(this.a, paramspn, paramObject);
  }
  
  public void a(spn paramspn, String paramString)
  {
    if ((spg.a(this.a) != null) && (spg.a(this.a).a != null)) {
      spg.a(this.a).a.g = paramString;
    }
    srq.a().a(paramspn, spg.a(this.a).b, paramspn.d());
  }
  
  public void a(spn paramspn, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (spg.a(this.a).size() >= 10)
    {
      paramspn = (Pair)spg.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramspn.first);
      }
    }
    if (paramBoolean) {
      spg.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((spn)spg.a(this.a).get(Integer.valueOf(paramInt2))).l();
  }
  
  public boolean a(spn paramspn, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return spg.a(this.a, paramspn, paramInt1, paramInt2, paramInt3, paramString, paramObject);
  }
  
  public boolean a(spn paramspn, int paramInt, Object paramObject)
  {
    return spg.a(this.a, paramspn, paramInt, paramObject);
  }
  
  public void b(spn paramspn)
  {
    spg.a(this.a, paramspn);
  }
  
  public void c(spn paramspn)
  {
    if (QLog.isColorLevel()) {
      QLog.d(spg.a, 2, "onSeekComplete(): video seek complete ! curPlayState:" + spm.a(this.a.a()));
    }
    if ((paramspn == spg.a(this.a)) && (this.a.a() != 5)) {
      spg.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spj
 * JD-Core Version:    0.7.0.1
 */