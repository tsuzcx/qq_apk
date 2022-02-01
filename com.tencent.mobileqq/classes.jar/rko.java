import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class rko
  implements rkt
{
  private static float jdField_a_of_type_Float = 0.8F;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  private List<rku> jdField_a_of_type_JavaUtilList = new ArrayList();
  private rkb jdField_a_of_type_Rkb;
  private rks jdField_a_of_type_Rks;
  private rky jdField_a_of_type_Rky;
  private rlb jdField_a_of_type_Rlb;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<rku> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public rko(Activity paramActivity, Bundle paramBundle, rkb paramrkb)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rkb = paramrkb;
    a(paramBundle);
    this.jdField_a_of_type_Rky = new rld();
    this.jdField_a_of_type_Rky.a(this);
    this.jdField_a_of_type_Rks = new rks();
    this.jdField_a_of_type_Rlb = new rlb(this.jdField_a_of_type_Rky);
    this.jdField_a_of_type_Rks.a(new rkp(this, paramrkb));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<rku> paramList)
  {
    rku localrku = new rku(1, this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2, paramInt3, new rkr(this, paramList.size()));
    this.jdField_a_of_type_Rlb.c(localrku);
    paramList.add(localrku);
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = (URLDrawableHelper.diskCachePath + File.separator + AbsDownloader.getFileName(new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("-").append(paramInt).toString()));
    new rqg(paramBitmap, this.jdField_b_of_type_JavaLangString).a();
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
      this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Rkb.b() * jdField_a_of_type_Float));
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * paramInt2 / paramInt1);
    }
    for (;;)
    {
      paramInt1 = (int)(this.jdField_a_of_type_Rkb.b() * jdField_a_of_type_Float);
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_Int = paramInt1;
      return;
      this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Rkb.b() * jdField_a_of_type_Float));
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int * paramInt1 / paramInt2);
    }
  }
  
  private void f()
  {
    int j = this.jdField_a_of_type_Rkb.a();
    float f = 0.0F;
    if (j > 0) {
      f = (float)this.jdField_a_of_type_Rky.a() / j;
    }
    int i = 0;
    while (i < j)
    {
      a((int)(i * f), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      i += 1;
    }
    this.jdField_a_of_type_Rkb.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rks.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Rkb.a(), new rkq(this));
    this.jdField_a_of_type_Rky.a(this.jdField_a_of_type_JavaLangString, null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rks.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Rkb.a())
    {
      int j = (i - paramInt2) * CaptureOperateTouchLayout.jdField_a_of_type_Int + paramInt1;
      a(j, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaUtilList);
      localArrayList.add(Integer.valueOf(j));
      i += 1;
    }
    this.jdField_a_of_type_Rkb.b(this.jdField_b_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCapturePresenter", 2, "expandCandidateImageList positionList:" + localArrayList + " position：" + paramInt1 + " seedPosition：" + paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    b(paramInt1, paramInt2);
    f();
    this.jdField_a_of_type_Rkb.a(this.jdField_a_of_type_Rky.a());
  }
  
  public void a(rki paramrki)
  {
    paramrki.a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rkb.b(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rlb.a();
    this.jdField_a_of_type_Rks.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Rks.a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Rks.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rko
 * JD-Core Version:    0.7.0.1
 */