package cooperation.qzone.contentbox;

import android.widget.RelativeLayout.LayoutParams;
import bbll;
import com.tencent.widget.ListView;
import java.util.ArrayList;

class QZoneMsgFragment$6
  implements Runnable
{
  QZoneMsgFragment$6(QZoneMsgFragment paramQZoneMsgFragment, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.size() > 0)) {}
    for (int i = 44;; i = 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)QZoneMsgFragment.a(this.this$0).getLayoutParams();
      localLayoutParams.bottomMargin = bbll.b(i);
      QZoneMsgFragment.a(this.this$0).setLayoutParams(localLayoutParams);
      QZoneMsgFragment.a(this.this$0).a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.6
 * JD-Core Version:    0.7.0.1
 */