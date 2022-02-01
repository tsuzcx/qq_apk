package cooperation.vip.manager;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import cooperation.qzone.util.QZLog;

class FileBannerTianshuManger$4
  implements Runnable
{
  FileBannerTianshuManger$4(FileBannerTianshuManger paramFileBannerTianshuManger, URLDrawable paramURLDrawable, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (this.this$0.jdField_a_of_type_MqqUtilWeakReference == null)) {
      return;
    }
    try
    {
      FileBannerTianshuManger.a(this.this$0, (ViewStub)this.this$0.b.findViewById(2131363478));
      if (FileBannerTianshuManger.a(this.this$0) == null)
      {
        QZLog.e("FileBannerTianshuManger", "mFileAssistantBannerViewStub  is null ");
        return;
      }
    }
    catch (Exception localException)
    {
      QZLog.e("FileBannerTianshuManger", localException.toString());
      return;
    }
    FileBannerTianshuManger.a(this.this$0).inflate();
    this.this$0.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.this$0.b.findViewById(2131363477));
    this.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.this$0.b.findViewById(2131363476));
    this.this$0.jdField_a_of_type_AndroidViewView = this.this$0.b.findViewById(2131363475);
    ViewGroup.LayoutParams localLayoutParams1 = this.this$0.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    localLayoutParams1.width = this.this$0.a();
    localLayoutParams1.height = this.this$0.b();
    this.this$0.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams1);
    this.this$0.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    ViewGroup.LayoutParams localLayoutParams2 = this.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams2.width = localLayoutParams1.width;
    localLayoutParams2.height = localLayoutParams1.height;
    this.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams2);
    this.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    QZLog.i("FileBannerTianshuManger", "showFileBanner setvisble ");
    this.this$0.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new FileBannerTianshuManger.4.1(this));
    this.this$0.jdField_a_of_type_AndroidViewView.setOnClickListener(new FileBannerTianshuManger.4.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.4
 * JD-Core Version:    0.7.0.1
 */