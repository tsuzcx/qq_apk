import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.mobileqq.utils.AudioHelper;

public class miy
  implements mip
{
  public miy(QavPanel paramQavPanel) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.a.a(paramInt);
    if ((paramView instanceof QavBeautyMenuPanel)) {
      ((QavBeautyMenuPanel)paramView).g();
    }
    long l = AudioHelper.b();
    this.a.a(l, paramInt, true);
  }
  
  public void a(View paramView1, View paramView2)
  {
    if (this.a.a != null) {
      this.a.a.onClick(paramView2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     miy
 * JD-Core Version:    0.7.0.1
 */