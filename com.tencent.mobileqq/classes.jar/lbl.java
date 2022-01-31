import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class lbl
  implements Runnable
{
  public lbl(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment) {}
  
  public void run()
  {
    if ((IPluginAdapterProxy.getProxy().isNightMode()) && (this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a.setBackgroundColor(-1);
    }
    if (this.a.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (Build.VERSION.SDK_INT >= 14)
      {
        this.a.jdField_a_of_type_AndroidWidgetImageView.animate().alpha(0.0F).setDuration(200L).setListener(new lbm(this));
        this.a.jdField_a_of_type_AndroidWidgetImageView.animate().start();
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbl
 * JD-Core Version:    0.7.0.1
 */