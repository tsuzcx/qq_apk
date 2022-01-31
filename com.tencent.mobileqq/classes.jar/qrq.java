import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class qrq
  implements qrv
{
  private static float jdField_a_of_type_Float = 0.8F;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  private List<qrw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private qrd jdField_a_of_type_Qrd;
  private qru jdField_a_of_type_Qru;
  private qsa jdField_a_of_type_Qsa;
  private qsd jdField_a_of_type_Qsd;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<qrw> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public qrq(Activity paramActivity, Bundle paramBundle, qrd paramqrd)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Qrd = paramqrd;
    a(paramBundle);
    this.jdField_a_of_type_Qsa = new qsf();
    this.jdField_a_of_type_Qsa.a(this);
    this.jdField_a_of_type_Qru = new qru();
    this.jdField_a_of_type_Qsd = new qsd(this.jdField_a_of_type_Qsa);
    this.jdField_a_of_type_Qru.a(new qrr(this, paramqrd));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<qrw> paramList)
  {
    qrw localqrw = new qrw(1, this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2, paramInt3, new qrt(this, paramList.size()));
    this.jdField_a_of_type_Qsd.c(localqrw);
    paramList.add(localqrw);
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = (baul.a + File.separator + bame.c(new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("-").append(paramInt).toString()));
    new qwm(paramBitmap, this.jdField_b_of_type_JavaLangString).a();
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("ARG_VIDEO_URL");
    this.jdField_b_of_type_Float = paramBundle.getFloat("ARG_INITIAL_PROGRESS");
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Qrd.b() * jdField_a_of_type_Float));
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * paramInt2 / paramInt1);
    }
    for (;;)
    {
      paramInt1 = (int)(this.jdField_a_of_type_Qrd.b() * jdField_a_of_type_Float);
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_Int = paramInt1;
      return;
      this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Qrd.b() * jdField_a_of_type_Float));
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int * paramInt1 / paramInt2);
    }
  }
  
  private void f()
  {
    int j = this.jdField_a_of_type_Qrd.a();
    float f = 0.0F;
    if (j > 0) {
      f = (float)this.jdField_a_of_type_Qsa.a() / j;
    }
    int i = 0;
    while (i < j)
    {
      a((int)(i * f), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      i += 1;
    }
    this.jdField_a_of_type_Qrd.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qru.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Qrd.a(), new qrs(this));
    this.jdField_a_of_type_Qsa.a(this.jdField_a_of_type_JavaLangString, null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qru.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Qrd.a())
    {
      int j = (i - paramInt2) * CaptureOperateTouchLayout.jdField_a_of_type_Int + paramInt1;
      a(j, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaUtilList);
      localArrayList.add(Integer.valueOf(j));
      i += 1;
    }
    this.jdField_a_of_type_Qrd.b(this.jdField_b_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCapturePresenter", 2, "expandCandidateImageList positionList:" + localArrayList + " position：" + paramInt1 + " seedPosition：" + paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    b(paramInt1, paramInt2);
    f();
    this.jdField_a_of_type_Qrd.a(this.jdField_a_of_type_Qsa.a());
  }
  
  public void a(qrk paramqrk)
  {
    paramqrk.a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Qrd.b(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Qsd.a();
    this.jdField_a_of_type_Qru.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Qru.a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Qru.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qrq
 * JD-Core Version:    0.7.0.1
 */