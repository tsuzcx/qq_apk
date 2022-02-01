package cooperation.qzone.contentbox;

import android.view.ViewGroup.LayoutParams;
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
    Object localObject = this.val$datas;
    int i;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      i = 44;
    } else {
      i = 0;
    }
    localObject = (RelativeLayout.LayoutParams)QZoneMsgFragment.access$500(this.this$0).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = ViewUtils.dpToPx(i);
    QZoneMsgFragment.access$500(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    QZoneMsgFragment.access$600(this.this$0).updateData(this.val$datas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.6
 * JD-Core Version:    0.7.0.1
 */