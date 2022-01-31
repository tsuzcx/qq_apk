import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class oei
  extends bjve
{
  public oei(@NonNull bjxn parambjxn, long paramLong)
  {
    super(parambjxn, paramLong);
  }
  
  private void j()
  {
    ((ImageView)a(2131377579)).setVisibility(8);
    ((TextView)a(2131364749)).setText(ajya.a(2131712868));
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
      nol.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
      return;
    case 8: 
      nol.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
      return;
    }
    nol.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oei
 * JD-Core Version:    0.7.0.1
 */