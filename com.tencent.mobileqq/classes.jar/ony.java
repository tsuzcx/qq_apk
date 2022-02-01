import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ony
  extends bqeb
{
  public ony(@NonNull bqgk parambqgk, long paramLong)
  {
    super(parambqgk, paramLong);
  }
  
  private void j()
  {
    a(2131379182).setVisibility(8);
    ((TextView)a(2131365109)).setText(anzj.a(2131711740));
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
      ocd.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
      continue;
      ocd.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
      continue;
      ocd.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ony
 * JD-Core Version:    0.7.0.1
 */