import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.widget.AdapterView;

public class pjr
  implements behi
{
  public pjr(ComponentContentGridImage paramComponentContentGridImage) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((ComponentContentGridImage.a(this.a) == 62) || (ComponentContentGridImage.a(this.a) == 63) || (ComponentContentGridImage.a(this.a) == 64) || (ComponentContentGridImage.a(this.a) == 65))
    {
      if (ComponentContentGridImage.a(this.a) != null) {
        ComponentContentGridImage.a(this.a).a(paramInt);
      }
      return;
    }
    ComponentContentGridImage.a(this.a, paramInt, ComponentContentGridImage.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pjr
 * JD-Core Version:    0.7.0.1
 */