package cooperation.qqreader.view;

import bfno;
import com.tencent.biz.widgets.ElasticHorScrView;

public class QPhoneShare$2
  implements Runnable
{
  public QPhoneShare$2(bfno parambfno, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (bfno.a(this.this$0).getWidth() < this.a) {
      bfno.a(this.this$0).setMove(true);
    }
    while (bfno.b(this.this$0).getWidth() < this.b)
    {
      bfno.b(this.this$0).setMove(true);
      return;
      bfno.a(this.this$0).setMove(false);
    }
    bfno.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.view.QPhoneShare.2
 * JD-Core Version:    0.7.0.1
 */