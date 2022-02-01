package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.screendetect.ScreenShotFragment.ActionSheetItemViewHolder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import org.json.JSONException;
import org.json.JSONObject;

class NativeShareView$2
  implements AdapterView.OnItemClickListener
{
  NativeShareView$2(NativeShareView paramNativeShareView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("OnItemClickListener : position = ");
      paramAdapterView.append(paramInt);
      paramAdapterView.append(", view = ");
      paramAdapterView.append(paramView);
      paramAdapterView.append(", id = ");
      paramAdapterView.append(paramLong);
      QLog.d("NativeShareView", 2, paramAdapterView.toString());
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    if (NativeShareView.a(this.a) != null) {
      NativeShareView.a(this.a).run();
    }
    paramInt = ((ScreenShotFragment.ActionSheetItemViewHolder)paramAdapterView).a.action;
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 9)
        {
          if (paramInt != 10)
          {
            if (paramInt != 47)
            {
              paramInt = 0;
            }
            else
            {
              paramInt = 6;
              ShareImageUtils.a(NativeShareView.a(this.a));
            }
          }
          else
          {
            paramInt = 4;
            ShareImageUtils.c((Activity)NativeShareView.a(this.a));
          }
        }
        else
        {
          ShareImageUtils.b((Activity)NativeShareView.a(this.a));
          paramInt = 3;
        }
      }
      else
      {
        ShareImageUtils.a((BaseActivity)NativeShareView.a(this.a));
        paramInt = i;
      }
    }
    else
    {
      ShareImageUtils.a((Activity)NativeShareView.a(this.a));
      paramInt = 1;
    }
    paramAdapterView = new JSONObject();
    try
    {
      paramAdapterView.put("channel_type", paramInt);
    }
    catch (JSONException paramView)
    {
      QLog.e("NativeShareView", 1, paramView, new Object[0]);
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800A3BE", "0X800A3BE", 0, 0, "", "", "", paramAdapterView.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeShareView.2
 * JD-Core Version:    0.7.0.1
 */