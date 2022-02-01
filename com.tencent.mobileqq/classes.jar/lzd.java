import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;

public class lzd
  extends lyu
{
  public lzd(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "SmallScreenVideo";
    this.i = 2131559774;
    this.j = paramContext.getResources().getDimensionPixelSize(2131297912);
    this.k = paramContext.getResources().getDimensionPixelSize(2131297904);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Lza.a;
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_Lza.a();
    if (((WindowManager)localObject).getDefaultDisplay().getRotation() % 2 == 0) {
      localLayoutParams.width = this.j;
    }
    for (localLayoutParams.height = this.k;; localLayoutParams.height = this.j)
    {
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a(paramInt);
      localLayoutParams.x = ((Point)localObject).x;
      localLayoutParams.y = ((Point)localObject).y;
      return;
      localLayoutParams.width = this.k;
    }
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramBaseSmallScreenService instanceof SmallScreenService))
    {
      paramBaseSmallScreenService = ((SmallScreenService)paramBaseSmallScreenService).a;
      bool1 = bool2;
      if (paramBaseSmallScreenService != null)
      {
        bool1 = bool2;
        if (paramBaseSmallScreenService.a != null) {
          bool1 = paramBaseSmallScreenService.a.i();
        }
      }
    }
    if (bool1)
    {
      int i = mit.b(this.j);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, i);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
      return;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (!this.jdField_a_of_type_Lza.b())) {
      a(paramInt);
    }
    super.a(paramBoolean, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzd
 * JD-Core Version:    0.7.0.1
 */