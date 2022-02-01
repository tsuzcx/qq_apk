import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ovl
  extends bpcg
{
  public ovl(@NonNull bpep parambpep, long paramLong)
  {
    super(parambpep, paramLong);
  }
  
  private void j()
  {
    a(2131379018).setVisibility(8);
    ((TextView)a(2131365060)).setText(anni.a(2131711631));
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
      oat.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "3", "", "", "", false);
      continue;
      oat.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "1", "", "", "", false);
      continue;
      oat.a(null, "", "0X80092F5", "0X80092F5", 0, 0, "2", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovl
 * JD-Core Version:    0.7.0.1
 */