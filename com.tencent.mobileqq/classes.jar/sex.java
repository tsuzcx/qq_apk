import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;

public class sex
  extends rux
{
  public sex(seu paramseu) {}
  
  public void a(sfb paramsfb)
  {
    seu.a(this.a, paramsfb);
  }
  
  public void a(sfb paramsfb, Object paramObject)
  {
    seu.a(this.a, paramsfb, paramObject);
  }
  
  public void a(sfb paramsfb, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((seu.a(this.a) != null) && (seu.a(this.a).a != null)) {
      seu.a(this.a).a.g = paramString;
    }
    shd.a().a(paramsfb, seu.a(this.a).b, paramsfb.d());
  }
  
  public void a(sfb paramsfb, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onCaptureImage , id : " + paramInt2 + " succ : " + paramBoolean + " errCode : " + paramInt1);
    }
    if (seu.a(this.a).size() >= 10)
    {
      paramsfb = (Pair)seu.a(this.a).remove(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "Capture Image Pool full ! remove first image, id : " + paramsfb.first);
      }
    }
    if (paramBoolean) {
      seu.a(this.a).add(new Pair(Integer.valueOf(paramInt2), paramBitmap));
    }
    ((sfb)seu.a(this.a).get(Integer.valueOf(paramInt2))).l();
  }
  
  public boolean a(sfb paramsfb, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return seu.a(this.a, paramsfb, paramInt1, paramInt2, paramInt3, paramString, paramObject);
  }
  
  public boolean a(sfb paramsfb, int paramInt, Object paramObject)
  {
    return seu.a(this.a, paramsfb, paramInt, paramObject);
  }
  
  public void c(sfb paramsfb)
  {
    if (QLog.isColorLevel()) {
      QLog.d(seu.a, 2, "onSeekComplete(): video seek complete ! curPlayState:" + sfa.a(this.a.a()));
    }
    if ((paramsfb == seu.a(this.a)) && (this.a.a() != 5)) {
      seu.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sex
 * JD-Core Version:    0.7.0.1
 */