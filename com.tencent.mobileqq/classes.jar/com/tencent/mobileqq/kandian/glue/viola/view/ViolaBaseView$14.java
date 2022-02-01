package com.tencent.mobileqq.kandian.glue.viola.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

class ViolaBaseView$14
  implements View.OnLayoutChangeListener
{
  ViolaBaseView$14(ViolaBaseView paramViolaBaseView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (ViolaBaseView.a(this.a) != null) {
      ViolaBaseView.a(this.a).setSize(paramView.getWidth(), paramView.getHeight());
    }
    if ((ViolaBaseView.a(this.a) != null) && (ViolaBaseView.a(this.a).getActivity() != null) && (this.a.a.contains("v_check_nav=1")))
    {
      paramView = new JSONObject();
      try
      {
        paramView.put("navigationBarHeight", ViewUtils.c(CommonSuspensionGestureLayout.a(ViolaBaseView.a(this.a).getActivity())));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ViolaBaseView.a(this.a).updateInstance(paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.14
 * JD-Core Version:    0.7.0.1
 */