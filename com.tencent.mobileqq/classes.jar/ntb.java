import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ntb
  extends bidq
{
  public ntb(@NonNull bigb parambigb, long paramLong)
  {
    super(parambigb, paramLong);
  }
  
  private void j()
  {
    ((ImageView)a(2131311766)).setVisibility(8);
    ((TextView)a(2131299188)).setText(ajjy.a(2131647069));
  }
  
  public void a()
  {
    super.a();
    j();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    paramView = (Long)this.a.get(i);
    if (paramView != null) {}
    switch ((int)paramView.longValue())
    {
    default: 
      return;
    case 4: 
      ndn.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
      return;
    case 8: 
      ndn.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
      return;
    }
    ndn.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ntb
 * JD-Core Version:    0.7.0.1
 */