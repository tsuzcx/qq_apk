package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.galleryactivity.GalleryProgressView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CountDownProgressBar;
import java.io.File;

class HotChatFlashPicActivity$4
  implements Handler.Callback
{
  HotChatFlashPicActivity$4(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage,msg:");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("Q.hotchat", 2, ((StringBuilder)localObject).toString());
    }
    switch (paramMessage.what)
    {
    case 6: 
    default: 
      return false;
    case 8: 
      if ((HotChatFlashPicActivity.z(this.a) != null) && (HotChatFlashPicActivity.z(this.a).getBitmap() != null))
      {
        HotChatFlashPicActivity.z(this.a).getBitmap().recycle();
        HotChatFlashPicActivity.a(this.a, null);
        return false;
      }
      break;
    case 7: 
      if ((!HotChatFlashPicActivity.m(this.a).d()) && (!HotChatFlashPicActivity.p(this.a)))
      {
        HotChatFlashPicActivity.m(this.a).a();
        HotChatFlashPicActivity.m(this.a).a(HotChatFlashPicActivity.y(this.a));
        return false;
      }
      break;
    case 5: 
      HotChatFlashPicActivity.a(this.a, (Bitmap)paramMessage.obj);
      return false;
    case 4: 
      if (HotChatFlashPicActivity.t(this.a) == 2)
      {
        localObject = this.a.getString(2131887963);
        paramMessage = (Message)localObject;
        if (!HotChatFlashPicActivity.u(this.a)) {
          if (HotChatFlashPicActivity.v(this.a) == 0)
          {
            ReportController.b(this.a.app, "dc00898", "", "", "0X80069A3", "0X80069A3", 0, 0, "", "", "", "");
            paramMessage = (Message)localObject;
          }
          else if (HotChatFlashPicActivity.v(this.a) == 3000)
          {
            ReportController.b(this.a.app, "dc00898", "", "", "0X80069A4", "0X80069A4", 0, 0, "", "", "", "");
            paramMessage = (Message)localObject;
          }
          else
          {
            paramMessage = (Message)localObject;
            if (HotChatFlashPicActivity.v(this.a) == 1)
            {
              ReportController.b(this.a.app, "dc00898", "", "", "0X80069A5", "0X80069A5", 0, 0, "", "", "", "");
              paramMessage = (Message)localObject;
            }
          }
        }
      }
      for (;;)
      {
        break;
        if (HotChatFlashPicActivity.t(this.a) < 2)
        {
          localObject = this.a.getString(2131887958);
          paramMessage = (Message)localObject;
          if (!HotChatFlashPicActivity.u(this.a)) {
            if (HotChatFlashPicActivity.v(this.a) == 0)
            {
              ReportController.b(this.a.app, "dc00898", "", "", "0X80069A0", "0X80069A0", 0, 0, "", "", "", "");
              paramMessage = (Message)localObject;
            }
            else if (HotChatFlashPicActivity.v(this.a) == 3000)
            {
              ReportController.b(this.a.app, "dc00898", "", "", "0X80069A1", "0X80069A1", 0, 0, "", "", "", "");
              paramMessage = (Message)localObject;
            }
            else
            {
              paramMessage = (Message)localObject;
              if (HotChatFlashPicActivity.v(this.a) == 1)
              {
                ReportController.b(this.a.app, "dc00898", "", "", "0X80069A2", "0X80069A2", 0, 0, "", "", "", "");
                paramMessage = (Message)localObject;
              }
            }
          }
        }
        else
        {
          paramMessage = HotChatFlashPicActivity.w(this.a);
        }
      }
      localObject = this.a;
      HotChatFlashPicActivity.a((HotChatFlashPicActivity)localObject, DialogUtil.a((Context)localObject, paramMessage, 0, 2131916601, null, new HotChatFlashPicActivity.4.1(this)));
      if (!this.a.isFinishing())
      {
        HotChatFlashPicActivity.d(this.a, false);
        HotChatFlashPicActivity.o(this.a).setVisibility(8);
        HotChatFlashPicActivity.i(this.a).setVisibility(8);
        HotChatFlashPicActivity.r(this.a).setVisibility(8);
        HotChatFlashPicActivity.x(this.a).show();
        return false;
      }
      break;
    case 3: 
      if (!HotChatFlashPicActivity.q(this.a))
      {
        HotChatFlashPicActivity.d(this.a, true);
        HotChatFlashPicActivity.j(this.a).setVisibility(8);
        if (HotChatFlashPicActivity.o(this.a).getTag() != null)
        {
          HotChatFlashPicActivity.o(this.a).setVisibility(0);
          HotChatFlashPicActivity.o(this.a).setImageDrawable((URLDrawable)HotChatFlashPicActivity.o(this.a).getTag());
        }
        HotChatFlashPicActivity.r(this.a).setVisibility(0);
        HotChatFlashPicActivity.r(this.a).a();
        HotChatFlashPicActivity.n(this.a).d(HotChatFlashPicActivity.s(this.a));
        return false;
      }
      break;
    case 2: 
      int i = paramMessage.arg1;
      if ((HotChatFlashPicActivity.m(this.a).d()) && (!HotChatFlashPicActivity.a(this.a).h))
      {
        HotChatFlashPicActivity.m(this.a).a(i);
        return false;
      }
      break;
    case 1: 
      HotChatFlashPicActivity.i(this.a).setVisibility(0);
      HotChatFlashPicActivity.i(this.a).setOnTouchListener(this.a);
      HotChatFlashPicActivity.j(this.a).setVisibility(0);
      HotChatFlashPicActivity.k(this.a).setImageResource(2130843594);
      HotChatFlashPicActivity.l(this.a).setText(2131887956);
      if (HotChatFlashPicActivity.m(this.a).d())
      {
        HotChatFlashPicActivity.m(this.a).b();
        return false;
      }
      break;
    case 0: 
      localObject = (String)paramMessage.obj;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramMessage = new File((String)localObject);
        if ((!((String)localObject).endsWith(HotChatFlashPicActivity.a(this.a).c)) && (HotChatFlashPicActivity.a(this.a).h))
        {
          if (!HotChatFlashPicActivity.a(this.a).f)
          {
            HotChatFlashPicActivity.a(this.a, true);
            HotChatFlashPicActivity.n(this.a).a(HotChatFlashPicActivity.a(this.a).L, HotChatFlashPicActivity.a(this.a).M, 2);
            return false;
          }
          HotChatFlashPicActivity.e(this.a).sendEmptyMessage(1);
          return false;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = localDisplayMetrics.widthPixels;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = localDisplayMetrics.heightPixels;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
        ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = true;
        ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
        paramMessage = URLDrawable.getDrawable(paramMessage, (URLDrawable.URLDrawableOptions)localObject);
        HotChatFlashPicActivity.o(this.a).setTag(paramMessage);
        HotChatFlashPicActivity.i(this.a).setVisibility(0);
        HotChatFlashPicActivity.i(this.a).setOnTouchListener(this.a);
        if (HotChatFlashPicActivity.p(this.a)) {
          HotChatFlashPicActivity.j(this.a).setVisibility(0);
        }
        HotChatFlashPicActivity.c(this.a, true);
        HotChatFlashPicActivity.k(this.a).setImageResource(2130843596);
        HotChatFlashPicActivity.l(this.a).setText(2131887964);
        if (HotChatFlashPicActivity.m(this.a).d())
        {
          HotChatFlashPicActivity.m(this.a).b();
          return false;
        }
      }
      else
      {
        HotChatFlashPicActivity.e(this.a).sendEmptyMessage(1);
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity.4
 * JD-Core Version:    0.7.0.1
 */