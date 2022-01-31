package cooperation.qqreader.view;

import bgwm;
import com.tencent.biz.widgets.ElasticHorScrView;

public class QPhoneShare$2
  implements Runnable
{
  public QPhoneShare$2(bgwm parambgwm, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (bgwm.a(this.this$0).getWidth() < this.a) {
      bgwm.a(this.this$0).setMove(true);
    }
    while (bgwm.b(this.this$0).getWidth() < this.b)
    {
      bgwm.b(this.this$0).setMove(true);
      return;
      bgwm.a(this.this$0).setMove(false);
    }
    bgwm.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.view.QPhoneShare.2
 * JD-Core Version:    0.7.0.1
 */