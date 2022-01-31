import android.os.Build.VERSION;
import com.dataline.activities.LiteActivity;
import com.tencent.widget.XListView;

public class dn
  implements akta
{
  public dn(LiteActivity paramLiteActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.isFinishing()) {}
    while ((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) {
      return;
    }
    if (paramInt > 0)
    {
      this.a.jdField_a_of_type_Fk.b();
      this.a.jdField_a_of_type_Fk.notifyDataSetChanged();
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromBottom(paramInt, 0);
    }
    this.a.jdField_a_of_type_ComTencentWidgetXListView.springBackOverScrollHeaderView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dn
 * JD-Core Version:    0.7.0.1
 */