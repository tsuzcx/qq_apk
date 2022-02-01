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
    int i = ((ScreenShotFragment.ActionSheetItemViewHolder)paramAdapterView).c.action;
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
    if ((ScreenShotFragment.d(this.a)) && (paramAdapterView != null)) {
      ScreenShotHelper.a("0X800A9A9", paramAdapterView, "1");
    }
    if ((i == 9) || (i == 10))
    {
      if (!WXShareHelper.a().b()) {
        paramInt = 2131918154;
      } else if (!WXShareHelper.a().c()) {
        paramInt = 2131918155;
      } else {
        paramInt = -1;
      }
      if (paramInt != -1)
      {
        QQToast.makeText(this.a.getBaseActivity(), this.a.getBaseActivity().getString(paramInt), 0).show(this.a.getBaseActivity().getResources().getDimensionPixelSize(2131299920));
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
              ScreenShotFragment.a(paramAdapterView, ScreenShotFragment.e(paramAdapterView));
              return;
            }
            paramAdapterView = new File(ScreenShotFragment.e(this.a));
            if (paramAdapterView.exists())
            {
              paramView = this.a.getBaseActivity();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramAdapterView.getAbsolutePath());
              localStringBuilder.append(NetConnInfoCenter.getServerTime());
              AIOGalleryUtils.a(paramView, paramAdapterView, Utils.Crc64String(localStringBuilder.toString()));
              QQToast.makeText(this.a.getBaseActivity(), 2, this.a.getBaseActivity().getString(2131915871), 0).show();
            }
            this.a.b();
            return;
          }
          paramAdapterView = this.a;
          ScreenShotFragment.b(paramAdapterView, ScreenShotFragment.e(paramAdapterView), ScreenShotFragment.g(this.a));
          return;
        }
        if ((PicShareToWX.b().e()) && (PicShareToWX.b().a(ScreenShotFragment.e(this.a))))
        {
          PicShareToWX.b().a(this.a.getBaseActivity(), ScreenShotFragment.f(this.a), ScreenShotFragment.e(this.a), 3);
          ReportController.b(null, "dc00898", "", "", "0X800A505", "0X800A505", 0, 0, "", "", "", "");
          return;
        }
        paramAdapterView = this.a;
        ScreenShotFragment.a(paramAdapterView, ScreenShotFragment.e(paramAdapterView), ScreenShotFragment.g(this.a));
        return;
      }
      paramAdapterView = this.a;
      ScreenShotFragment.a(paramAdapterView, paramAdapterView.getBaseActivity(), ScreenShotFragment.e(this.a));
      return;
    }
    ScreenShotFragment.a(this.a.getBaseActivity(), ScreenShotFragment.e(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.4
 * JD-Core Version:    0.7.0.1
 */