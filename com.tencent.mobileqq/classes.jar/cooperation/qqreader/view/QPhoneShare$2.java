package cooperation.qqreader.view;

import bgvv;
import com.tencent.biz.widgets.ElasticHorScrView;

public class QPhoneShare$2
  implements Runnable
{
  public QPhoneShare$2(bgvv parambgvv, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (bgvv.a(this.this$0).getWidth() < this.a) {
      bgvv.a(this.this$0).setMove(true);
    }
    while (bgvv.b(this.this$0).getWidth() < this.b)
    {
      bgvv.b(this.this$0).setMove(true);
      return;
      bgvv.a(this.this$0).setMove(false);
    }
    bgvv.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.view.QPhoneShare.2
 * JD-Core Version:    0.7.0.1
 */