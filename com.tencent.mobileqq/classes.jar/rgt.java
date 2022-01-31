import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.QQAppInterface;

public class rgt
  implements View.OnClickListener
{
  public rgt(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.a).setText("");
    ReadinjoyTabFrame.a(this.a).setVisibility(8);
    shu.a(this.a.a, true);
    ((KandianMergeManager)this.a.a.getManager(162)).d(true);
    onh.a(this.a.a(), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rgt
 * JD-Core Version:    0.7.0.1
 */