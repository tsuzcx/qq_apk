import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class osn
  extends SwiftBrowserUIStyleHandler
{
  osn(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment paramReadInJoyArticleDetailFragment) {}
  
  public void initWebViewInContentView()
  {
    super.initWebViewInContentView();
    if ((this.mComponentContext.a() != null) && (this.a.jdField_a_of_type_Boolean) && (this.a.webView != null) && (this.webviewWrapper != null))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView = new ImageView(ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.a(this.a));
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841693);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.webviewWrapper.addView(this.a.jdField_a_of_type_AndroidWidgetImageView);
      if (IPluginAdapterProxy.getProxy().isNightMode())
      {
        this.webviewWrapper.setBackgroundColor(-6710887);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841694);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osn
 * JD-Core Version:    0.7.0.1
 */