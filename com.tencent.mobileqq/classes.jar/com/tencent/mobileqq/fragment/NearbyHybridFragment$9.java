package com.tencent.mobileqq.fragment;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout.OnActionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class NearbyHybridFragment$9
  implements OverCoverFrameLayout.OnActionListener
{
  NearbyHybridFragment$9(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public boolean a()
  {
    return this.a.jdField_a_of_type_ComTencentBizUiRefreshView.b();
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("status =");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",direction =");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",height =");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.i("nearby.NearbyHybridFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).getString("nearby_view_change_callback", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("status", paramInt1);
        localJSONObject.put("direction", paramInt2);
        localJSONObject.put("height", paramInt3);
        if (this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment$NearbyWebViewBuilder.mWebview.callJs((String)localObject, new String[] { localJSONObject.toString() });
          return false;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("nearby.NearbyHybridFragment", 2, localJSONException, new Object[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.9
 * JD-Core Version:    0.7.0.1
 */