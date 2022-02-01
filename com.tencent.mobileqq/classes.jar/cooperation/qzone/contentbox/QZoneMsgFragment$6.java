package cooperation.qzone.contentbox;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;

class QZoneMsgFragment$6
  implements Runnable
{
  QZoneMsgFragment$6(QZoneMsgFragment paramQZoneMsgFragment, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.val$datas != null) && (this.val$datas.size() > 0)) {}
    for (int i = 44;; i = 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)QZoneMsgFragment.access$500(this.this$0).getLayoutParams();
      localLayoutParams.bottomMargin = ViewUtils.b(i);
      QZoneMsgFragment.access$500(this.this$0).setLayoutParams(localLayoutParams);
      QZoneMsgFragment.access$600(this.this$0).updateData(this.val$datas);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.6
 * JD-Core Version:    0.7.0.1
 */