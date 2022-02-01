import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class rmt
  implements rmy
{
  private static float jdField_a_of_type_Float = 0.8F;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  private List<rmz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private rmg jdField_a_of_type_Rmg;
  private rmx jdField_a_of_type_Rmx;
  private rnd jdField_a_of_type_Rnd;
  private rng jdField_a_of_type_Rng;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<rmz> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public rmt(Activity paramActivity, Bundle paramBundle, rmg paramrmg)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rmg = paramrmg;
    a(paramBundle);
    this.jdField_a_of_type_Rnd = new rni();
    this.jdField_a_of_type_Rnd.a(this);
    this.jdField_a_of_type_Rmx = new rmx();
    this.jdField_a_of_type_Rng = new rng(this.jdField_a_of_type_Rnd);
    this.jdField_a_of_type_Rmx.a(new rmu(this, paramrmg));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<rmz> paramList)
  {
    rmz localrmz = new rmz(1, this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2, paramInt3, new rmw(this, paramList.size()));
    this.jdField_a_of_type_Rng.c(localrmz);
    paramList.add(localrmz);
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = (bdzx.a + File.separator + bdsh.c(new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("-").append(paramInt).toString()));
    new rsk(paramBitmap, this.jdField_b_of_type_JavaLangString).a();
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
      this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Rmg.b() * jdField_a_of_type_Float));
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * paramInt2 / paramInt1);
    }
    for (;;)
    {
      paramInt1 = (int)(this.jdField_a_of_type_Rmg.b() * jdField_a_of_type_Float);
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_Int = paramInt1;
      return;
      this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Rmg.b() * jdField_a_of_type_Float));
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int * paramInt1 / paramInt2);
    }
  }
  
  private void f()
  {
    int j = this.jdField_a_of_type_Rmg.a();
    float f = 0.0F;
    if (j > 0) {
      f = (float)this.jdField_a_of_type_Rnd.a() / j;
    }
    int i = 0;
    while (i < j)
    {
      a((int)(i * f), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      i += 1;
    }
    this.jdField_a_of_type_Rmg.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rmx.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Rmg.a(), new rmv(this));
    this.jdField_a_of_type_Rnd.a(this.jdField_a_of_type_JavaLangString, null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rmx.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Rmg.a())
    {
      int j = (i - paramInt2) * CaptureOperateTouchLayout.jdField_a_of_type_Int + paramInt1;
      a(j, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaUtilList);
      localArrayList.add(Integer.valueOf(j));
      i += 1;
    }
    this.jdField_a_of_type_Rmg.b(this.jdField_b_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCapturePresenter", 2, "expandCandidateImageList positionList:" + localArrayList + " position：" + paramInt1 + " seedPosition：" + paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    b(paramInt1, paramInt2);
    f();
    this.jdField_a_of_type_Rmg.a(this.jdField_a_of_type_Rnd.a());
  }
  
  public void a(rmn paramrmn)
  {
    paramrmn.a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rmg.b(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rng.a();
    this.jdField_a_of_type_Rmx.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Rmx.a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Rmx.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmt
 * JD-Core Version:    0.7.0.1
 */