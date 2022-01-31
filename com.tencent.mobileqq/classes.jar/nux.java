import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class nux
  implements View.OnTouchListener
{
  public nux(ShopWebViewFragment paramShopWebViewFragment, JSONObject paramJSONObject1, JSONObject paramJSONObject2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.c = ((int)paramMotionEvent.getY());
      return false;
      int i = (int)(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.c - paramMotionEvent.getY());
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.c = ((int)paramMotionEvent.getY());
      if ((i < 0) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d > 0)) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d = 0;
      }
      if ((i > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d < 0)) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d = 0;
      }
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment;
      paramView.d = (i + paramView.d);
      return false;
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("y_offset", this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.d);
        paramView = WebViewPlugin.toJsScript("onScroll", this.jdField_a_of_type_OrgJsonJSONObject, this.b);
        if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.a != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment.a.callJs(paramView);
          return false;
        }
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nux
 * JD-Core Version:    0.7.0.1
 */