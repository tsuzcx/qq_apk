import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class lzj
{
  public SmallScreenRelativeLayout a;
  protected String a;
  public lzp a;
  protected int i;
  protected int j;
  protected int k;
  
  public void a()
  {
    this.jdField_a_of_type_Lzp.b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_Lzp = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
  }
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, lzk paramlzk)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = ((SmallScreenRelativeLayout)paramLayoutInflater.inflate(this.i, null));
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setFloatListener(paramlzk);
    this.jdField_a_of_type_Lzp = new lzp(paramContext, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setIsRotateSize(true);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
    a(this.jdField_a_of_type_Lzp.a());
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 136;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    if (lzq.a()) {}
    for (int m = 2005;; m = 2002)
    {
      paramLayoutParams.type = m;
      return;
    }
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = a();
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_Lzp.b()) {
        this.jdField_a_of_type_Lzp.a();
      }
      if (!bool)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(paramInt);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
        if (QLog.isDevelopLevel()) {
          QLog.w(this.jdField_a_of_type_JavaLangString, 4, "showOrHide, show toast view , tag[" + this.jdField_a_of_type_JavaLangString + "]");
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (!bool);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
    } while (!QLog.isDevelopLevel());
    QLog.w(this.jdField_a_of_type_JavaLangString, 4, "showOrHide, hide toast view , tag[" + this.jdField_a_of_type_JavaLangString + "]");
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzj
 * JD-Core Version:    0.7.0.1
 */