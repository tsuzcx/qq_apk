import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.beauty.QavBeautyMenuPanel;
import com.tencent.mobileqq.utils.AudioHelper;

public class mkr
  implements mkk
{
  public mkr(QavPanel paramQavPanel) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.a.a(paramInt);
    if ((paramView instanceof QavBeautyMenuPanel)) {
      ((QavBeautyMenuPanel)paramView).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mkr
 * JD-Core Version:    0.7.0.1
 */