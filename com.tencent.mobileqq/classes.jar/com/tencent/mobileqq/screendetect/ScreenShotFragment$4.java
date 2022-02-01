package com.tencent.mobileqq.screendetect;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
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
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "OnItemClickListener : position = " + paramInt + ", view = " + paramView + ", id = " + paramLong);
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    int i = ((ScreenShotFragment.ActionSheetItemViewHolder)paramAdapterView).a.action;
    paramAdapterView = null;
    switch (i)
    {
    default: 
      if ((ScreenShotFragment.a(this.a)) && (paramAdapterView != null)) {
        ScreenShotHelper.a("0X800A9A9", paramAdapterView, "1");
      }
      if ((i != 9) && (i != 10)) {
        break label300;
      }
      paramInt = -1;
      if (!WXShareHelper.a().a()) {
        paramInt = 2131720753;
      }
      break;
    }
    for (;;)
    {
      if (paramInt == -1) {
        break label300;
      }
      QQToast.a(this.a.getActivity(), this.a.getActivity().getString(paramInt), 0).b(this.a.getActivity().getResources().getDimensionPixelSize(2131299166));
      return;
      ScreenShotHelper.a("0X8009FF0", 0);
      paramAdapterView = "1";
      break;
      ScreenShotHelper.a("0X8009FF1", 0);
      paramAdapterView = "2";
      break;
      ScreenShotHelper.a("0X8009FF2", 0);
      paramAdapterView = "3";
      break;
      ScreenShotHelper.a("0X8009FF3", 0);
      paramAdapterView = "4";
      break;
      ScreenShotHelper.a("0X800A77D", 0);
      paramAdapterView = "5";
      break;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131720754;
      }
    }
    switch (i)
    {
    default: 
      return;
    case 2: 
      ScreenShotFragment.a(this.a.getActivity(), ScreenShotFragment.a(this.a));
      return;
    case 3: 
      ScreenShotFragment.a(this.a, this.a.getActivity(), ScreenShotFragment.a(this.a));
      return;
    case 9: 
      if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(ScreenShotFragment.a(this.a))))
      {
        PicShareToWX.a().a(this.a.getActivity(), ScreenShotFragment.a(this.a), ScreenShotFragment.a(this.a), 3);
        ReportController.b(null, "dc00898", "", "", "0X800A505", "0X800A505", 0, 0, "", "", "", "");
        return;
      }
      ScreenShotFragment.a(this.a, ScreenShotFragment.a(this.a), ScreenShotFragment.a(this.a));
      return;
    case 10: 
      ScreenShotFragment.b(this.a, ScreenShotFragment.a(this.a), ScreenShotFragment.a(this.a));
      return;
    case 50: 
      label300:
      ScreenShotFragment.a(this.a, ScreenShotFragment.a(this.a));
      return;
    }
    paramAdapterView = new File(ScreenShotFragment.a(this.a));
    if (paramAdapterView.exists())
    {
      AIOGalleryUtils.a(this.a.getActivity(), paramAdapterView, Utils.Crc64String(paramAdapterView.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
      QQToast.a(this.a.getActivity(), 2, this.a.getActivity().getString(2131718661), 0).a();
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotFragment.4
 * JD-Core Version:    0.7.0.1
 */