import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rgs
  implements View.OnClickListener
{
  public rgs(ComponentContentNoteCard paramComponentContentNoteCard) {}
  
  public void onClick(View paramView)
  {
    ComponentContentNoteCard.a(this.a).onClick(ComponentContentNoteCard.a(this.a).a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgs
 * JD-Core Version:    0.7.0.1
 */