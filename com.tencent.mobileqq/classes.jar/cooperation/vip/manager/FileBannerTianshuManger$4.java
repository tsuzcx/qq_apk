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
    if (this.a != null)
    {
      if (this.this$0.e == null) {
        return;
      }
      try
      {
        FileBannerTianshuManger.a(this.this$0, (ViewStub)this.this$0.i.findViewById(2131429295));
        if (FileBannerTianshuManger.a(this.this$0) == null)
        {
          QZLog.e("FileBannerTianshuManger", "mFileAssistantBannerViewStub  is null ");
          return;
        }
        FileBannerTianshuManger.a(this.this$0).inflate();
        this.this$0.g = ((URLImageView)this.this$0.i.findViewById(2131429294));
        this.this$0.h = ((RelativeLayout)this.this$0.i.findViewById(2131429293));
        this.this$0.f = this.this$0.i.findViewById(2131429292);
        ViewGroup.LayoutParams localLayoutParams1 = this.this$0.g.getLayoutParams();
        localLayoutParams1.width = this.this$0.c();
        localLayoutParams1.height = this.this$0.d();
        this.this$0.g.setLayoutParams(localLayoutParams1);
        this.this$0.g.setImageDrawable(this.a);
        ViewGroup.LayoutParams localLayoutParams2 = this.this$0.h.getLayoutParams();
        localLayoutParams2.width = localLayoutParams1.width;
        localLayoutParams2.height = localLayoutParams1.height;
        this.this$0.h.setLayoutParams(localLayoutParams2);
        this.this$0.h.setVisibility(0);
        QZLog.i("FileBannerTianshuManger", "showFileBanner setvisble ");
        this.this$0.g.setOnClickListener(new FileBannerTianshuManger.4.1(this));
        this.this$0.f.setOnClickListener(new FileBannerTianshuManger.4.2(this));
        return;
      }
      catch (Exception localException)
      {
        QZLog.e("FileBannerTianshuManger", localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.4
 * JD-Core Version:    0.7.0.1
 */