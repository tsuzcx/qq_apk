package com.tencent.mobileqq.screendetect;

import android.content.res.Resources;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.io.File;

class ScreenShotFragment$4
  implements AdapterView.OnItemClickListener
{
  ScreenShotFragment$4(ScreenShotFragment paramScreenShotFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("OnItemClickListener : position = ");
      paramAdapterView.append(paramInt);
      paramAdapterView.append(", view = ");
      paramAdapterView.append(paramView);
      paramAdapterView.append(", id = ");
      paramAdapterView.append(paramLong);
      QLog.d("ScreenShotFragment", 2, paramAdapterView.toString());
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    int i = ((ScreenShotFragment.ActionSheetItemViewHolder)paramAdapterView).a.action;
    paramAdapterView = null;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 9)
        {
          if (i != 10)
          {
            if (i == 50)
            {
              ScreenShotHelper.a("0X800A77D", 0);
              paramAdapterView = "5";
            }
          }
          else
          {
            ScreenShotHelper.a("0X8009FF3", 0);
            paramAdapterView = "4";
          }
        }
        else
        {
          ScreenShotHelper.a("0X8009FF2", 0);
          paramAdapterView = "3";
        }
      }
      else
      {
        ScreenShotHelper.a("0X8009FF1", 0);
        paramAdapterView = "2";
      }
    }
    else
    {
      ScreenShotHelper.a("0X8009FF0", 0);
      paramAdapterView = "1";
    }
    if ((ScreenShotFragment.a(this.a)) && (paramAdapterView != null)) {
      ScreenShotHelper.a("0X800A9A9", paramAdapterView, "1");
    }
    if ((i == 9) || (i == 10))
    {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720478;
      } else if (!WXShareHelper.a().b()) {
        paramInt = 2131720479;
      } else {
        paramInt = -1;
      }
      if (paramInt != -1)
      {
        QQToast.a(this.a.getBaseActivity(), this.a.getBaseActivity().getString(paramInt), 0).b(this.a.getBaseActivity().getResources().getDimensionPixelSize(2131299168));
        return;
      }
    }
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 9)
        {
          if (i != 10)
          {
            if (i != 39)
            {
              if (i != 50) {
                return;
              }
              paramAdapterView = this.a;
              ScreenShotFragment.a(paramAdapterView, ScreenShotFragment.a(paramAdapterView));
              return;
            }
            paramAdapterView = new File(ScreenShotFragment.a(this.a));
            if (paramAdapterView.exists())
            {
              paramView = this.a.getBaseActivity();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramAdapterView.getAbsolutePath());
              localStringBuilder.append(NetConnInfoCenter.getServerTime());
              AIOGalleryUtils.a(paramView, paramAdapterView, Utils.Crc64String(localStringBuilder.toString()));
              QQToast.a(this.a.getBaseActivity(), 2, this.a.getBaseActivity().getString(2131718379), 0).a();
            }
            this.a.b();
            return;
          }
          paramAdapterView = this.a;
          ScreenShotFragment.b(paramAdapterView, ScreenShotFragment.a(paramAdapterView), ScreenShotFragment.a(this.a));
          return;
        }
        if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(ScreenShotFragment.a(this.a))))
        {
          PicShareToWX.a().a(this.a.getBaseActivity(), ScreenShotFragment.a(this.a), ScreenShotFragment.a(this.a), 3);
          ReportController.b(null, "dc00898", "", "", "0X800A505", "0X800A505", 0, 0, "", "", "", "");
          return;
        }
        paramAdapterView = this.a;
        ScreenShotFragment.a(paramAdapterView, ScreenShotFragment.a(paramAdapterView), ScreenShotFragment.a(this.a));
        return;
      }
      paramAdapterView = this.a;
      ScreenShotFragment.a(paramAdapterView, paramAdapterView.getBaseActivity(), ScreenShotFragment.a(this.a));
      return;
    }
    ScreenShotFragment.a(this.a.getBaseActivity(), ScreenShotFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.4
 * JD-Core Version:    0.7.0.1
 */