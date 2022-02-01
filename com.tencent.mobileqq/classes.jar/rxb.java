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

public class rxb
  implements rxg
{
  private static float jdField_a_of_type_Float = 0.8F;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private String jdField_a_of_type_JavaLangString;
  private List<rxh> jdField_a_of_type_JavaUtilList = new ArrayList();
  private rwo jdField_a_of_type_Rwo;
  private rxf jdField_a_of_type_Rxf;
  private rxl jdField_a_of_type_Rxl;
  private rxo jdField_a_of_type_Rxo;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<rxh> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public rxb(Activity paramActivity, Bundle paramBundle, rwo paramrwo)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rwo = paramrwo;
    a(paramBundle);
    this.jdField_a_of_type_Rxl = new rxq();
    this.jdField_a_of_type_Rxl.a(this);
    this.jdField_a_of_type_Rxf = new rxf();
    this.jdField_a_of_type_Rxo = new rxo(this.jdField_a_of_type_Rxl);
    this.jdField_a_of_type_Rxf.a(new rxc(this, paramrwo));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, List<rxh> paramList)
  {
    rxh localrxh = new rxh(1, this.jdField_a_of_type_JavaLangString, paramInt1, paramInt2, paramInt3, new rxe(this, paramList.size()));
    this.jdField_a_of_type_Rxo.c(localrxh);
    paramList.add(localrxh);
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = (URLDrawableHelper.diskCachePath + File.separator + AbsDownloader.getFileName(new StringBuilder().append(this.jdField_a_of_type_JavaLangString).append("-").append(paramInt).toString()));
    new scv(paramBitmap, this.jdField_b_of_type_JavaLangString).a();
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
      this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Rwo.b() * jdField_a_of_type_Float));
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int * paramInt2 / paramInt1);
    }
    for (;;)
    {
      paramInt1 = (int)(this.jdField_a_of_type_Rwo.b() * jdField_a_of_type_Float);
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_Int = paramInt1;
      return;
      this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Rwo.b() * jdField_a_of_type_Float));
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int * paramInt1 / paramInt2);
    }
  }
  
  private void f()
  {
    int j = this.jdField_a_of_type_Rwo.a();
    float f = 0.0F;
    if (j > 0) {
      f = (float)this.jdField_a_of_type_Rxl.a() / j;
    }
    int i = 0;
    while (i < j)
    {
      a((int)(i * f), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      i += 1;
    }
    this.jdField_a_of_type_Rwo.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rxf.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Rwo.a(), new rxd(this));
    this.jdField_a_of_type_Rxl.a(this.jdField_a_of_type_JavaLangString, null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rxf.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_Rwo.a())
    {
      int j = (i - paramInt2) * CaptureOperateTouchLayout.jdField_a_of_type_Int + paramInt1;
      a(j, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaUtilList);
      localArrayList.add(Integer.valueOf(j));
      i += 1;
    }
    this.jdField_a_of_type_Rwo.b(this.jdField_b_of_type_JavaUtilList);
    if (QLog.isColorLevel()) {
      QLog.d("VideoCapturePresenter", 2, "expandCandidateImageList positionList:" + localArrayList + " position：" + paramInt1 + " seedPosition：" + paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    b(paramInt1, paramInt2);
    f();
    this.jdField_a_of_type_Rwo.a(this.jdField_a_of_type_Rxl.a());
  }
  
  public void a(rwv paramrwv)
  {
    paramrwv.a(this.jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Rwo.b(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rxo.a();
    this.jdField_a_of_type_Rxf.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Rxf.a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Rxf.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxb
 * JD-Core Version:    0.7.0.1
 */