import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class oel
  extends bjun
{
  public oel(@NonNull bjww parambjww, long paramLong)
  {
    super(parambjww, paramLong);
  }
  
  private void j()
  {
    ((ImageView)a(2131377579)).setVisibility(8);
    ((TextView)a(2131364750)).setText(ajyc.a(2131712857));
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
      noo.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
      return;
    case 8: 
      noo.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
      return;
    }
    noo.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oel
 * JD-Core Version:    0.7.0.1
 */