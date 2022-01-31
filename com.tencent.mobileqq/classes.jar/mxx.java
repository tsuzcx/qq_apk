import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.util.GalleryShareHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class mxx
  implements View.OnClickListener
{
  public mxx(GalleryShareHelper paramGalleryShareHelper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    PublicAccountReportUtils.a(null, "", "0X8008E35", "0X8008E35", 0, 0, "", "", "", GalleryReportedUtils.a(GalleryShareHelper.a(this.a), GalleryShareHelper.a(this.a).getCurrentAccountUin(), GalleryShareHelper.a(this.a), GalleryShareHelper.a(this.a), GalleryShareHelper.a(this.a)), false);
    if (GalleryShareHelper.a(this.a).isShowing()) {
      GalleryShareHelper.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxx
 * JD-Core Version:    0.7.0.1
 */