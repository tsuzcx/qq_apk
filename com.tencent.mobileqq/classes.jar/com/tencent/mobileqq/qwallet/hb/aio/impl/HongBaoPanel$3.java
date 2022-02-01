package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONObject;

class HongBaoPanel$3
  implements View.OnClickListener
{
  HongBaoPanel$3(HongBaoPanel paramHongBaoPanel) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = (PanelTabData)paramView.getTag();
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
      paramView = null;
    }
    if (paramView == null) {
      return;
    }
    switch (paramView.jdField_a_of_type_Int)
    {
    default: 
    case 102: 
      paramView = paramView.jdField_a_of_type_OrgJsonJSONObject.optString("url");
      if (!StringUtil.a(paramView))
      {
        ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(this.a.a, paramView);
        return;
      }
      break;
    case 101: 
      HongBaoPanel.a(this.a);
      return;
    case 100: 
      if (paramView.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        paramView = paramView.jdField_a_of_type_OrgJsonJSONObject.optString("url");
        if (!StringUtil.a(paramView)) {
          ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(this.a.a, paramView);
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanel.3
 * JD-Core Version:    0.7.0.1
 */