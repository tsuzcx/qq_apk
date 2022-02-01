import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oxh
  extends botb
{
  public oxh(@NonNull botw parambotw, int paramInt)
  {
    super(parambotw, paramInt);
  }
  
  private void d()
  {
    a(2131379246).setVisibility(8);
    ((TextView)a(2131365221)).setText(anvx.a(2131712319));
  }
  
  public void a()
  {
    super.a();
    d();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    Long localLong = (Long)this.a.get(i);
    if (localLong != null) {
      switch ((int)localLong.longValue())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      olh.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
      continue;
      olh.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
      continue;
      olh.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxh
 * JD-Core Version:    0.7.0.1
 */