import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment;
import com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment.1.1;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;

public class nqk
  implements View.OnClickListener
{
  public nqk(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      onClick(paramView);
      return;
    case 2131368655: 
      if (!this.a.jdField_a_of_type_Bejh.a.a)
      {
        paramView = this.a.jdField_a_of_type_Beft.c.getText().toString();
        this.a.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("javascript:onRightBtn(\"" + paramView + "\")");
        return;
      }
      if (PublicAccountBrowser.PublicAccountBrowserFragment.a(this.a) == 1001)
      {
        ThreadManager.executeOnSubThread(new PublicAccountBrowser.PublicAccountBrowserFragment.1.1(this));
        this.a.getActivity().finish();
        return;
      }
      onClick(paramView);
      return;
    }
    if (!this.a.jdField_a_of_type_Bejh.a.a)
    {
      paramView = this.a.jdField_a_of_type_Beft.a.getText().toString();
      if (paramView.equals(PublicAccountBrowser.PublicAccountBrowserFragment.a(this.a).getStringExtra("leftViewText")))
      {
        this.a.f();
        return;
      }
      this.a.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("javascript:onLeftBtn(\"" + paramView + "\")");
      return;
    }
    onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nqk
 * JD-Core Version:    0.7.0.1
 */