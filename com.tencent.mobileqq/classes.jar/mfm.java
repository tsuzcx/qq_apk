import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class mfm
  implements View.OnClickListener
{
  public mfm(VideoShareHelper paramVideoShareHelper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    if (VideoShareHelper.a(this.a).isShowing()) {
      VideoShareHelper.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfm
 * JD-Core Version:    0.7.0.1
 */