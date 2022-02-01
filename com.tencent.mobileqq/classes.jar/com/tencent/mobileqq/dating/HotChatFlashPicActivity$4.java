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
      if ((HotChatFlashPicActivity.a(this.a) != null) && (HotChatFlashPicActivity.a(this.a).getBitmap() != null))
      {
        HotChatFlashPicActivity.a(this.a).getBitmap().recycle();
        HotChatFlashPicActivity.a(this.a, null);
        return false;
      }
      break;
    case 7: 
      if ((!HotChatFlashPicActivity.a(this.a).a()) && (!HotChatFlashPicActivity.c(this.a)))
      {
        HotChatFlashPicActivity.a(this.a).a();
        HotChatFlashPicActivity.a(this.a).a(HotChatFlashPicActivity.c(this.a));
        return false;
      }
      break;
    case 5: 
      HotChatFlashPicActivity.a(this.a, (Bitmap)paramMessage.obj);
      return false;
    case 4: 
      if (HotChatFlashPicActivity.b(this.a))
      {
        if (HotChatFlashPicActivity.a(this.a) >= 2) {
          paramMessage = this.a.getString(2131693228);
        } else {
          paramMessage = this.a.getString(2131693227);
        }
      }
      else
      {
        if (HotChatFlashPicActivity.a(this.a) != 2) {
          break label434;
        }
        localObject = this.a.getString(2131691024);
        paramMessage = (Message)localObject;
        if (!HotChatFlashPicActivity.e(this.a)) {
          if (HotChatFlashPicActivity.b(this.a) == 0)
          {
            ReportController.b(this.a.app, "dc00898", "", "", "0X80069A3", "0X80069A3", 0, 0, "", "", "", "");
            paramMessage = (Message)localObject;
          }
          else if (HotChatFlashPicActivity.b(this.a) == 3000)
          {
            ReportController.b(this.a.app, "dc00898", "", "", "0X80069A4", "0X80069A4", 0, 0, "", "", "", "");
            paramMessage = (Message)localObject;
          }
          else
          {
            paramMessage = (Message)localObject;
            if (HotChatFlashPicActivity.b(this.a) == 1)
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
        if (HotChatFlashPicActivity.a(this.a) < 2)
        {
          localObject = this.a.getString(2131691019);
          paramMessage = (Message)localObject;
          if (!HotChatFlashPicActivity.e(this.a)) {
            if (HotChatFlashPicActivity.b(this.a) == 0)
            {
              ReportController.b(this.a.app, "dc00898", "", "", "0X80069A0", "0X80069A0", 0, 0, "", "", "", "");
              paramMessage = (Message)localObject;
            }
            else if (HotChatFlashPicActivity.b(this.a) == 3000)
            {
              ReportController.b(this.a.app, "dc00898", "", "", "0X80069A1", "0X80069A1", 0, 0, "", "", "", "");
              paramMessage = (Message)localObject;
            }
            else
            {
              paramMessage = (Message)localObject;
              if (HotChatFlashPicActivity.b(this.a) == 1)
              {
                ReportController.b(this.a.app, "dc00898", "", "", "0X80069A2", "0X80069A2", 0, 0, "", "", "", "");
                paramMessage = (Message)localObject;
              }
            }
          }
        }
        else
        {
          paramMessage = HotChatFlashPicActivity.e(this.a);
        }
      }
      localObject = this.a;
      HotChatFlashPicActivity.a((HotChatFlashPicActivity)localObject, DialogUtil.a((Context)localObject, paramMessage, 0, 2131719065, null, new HotChatFlashPicActivity.4.1(this)));
      if (!this.a.isFinishing())
      {
        HotChatFlashPicActivity.d(this.a, false);
        HotChatFlashPicActivity.a(this.a).setVisibility(8);
        HotChatFlashPicActivity.a(this.a).setVisibility(8);
        HotChatFlashPicActivity.a(this.a).setVisibility(8);
        HotChatFlashPicActivity.a(this.a).show();
        return false;
      }
      break;
    case 3: 
      if (!HotChatFlashPicActivity.d(this.a))
      {
        HotChatFlashPicActivity.d(this.a, true);
        HotChatFlashPicActivity.b(this.a).setVisibility(8);
        if (HotChatFlashPicActivity.a(this.a).getTag() != null)
        {
          HotChatFlashPicActivity.a(this.a).setVisibility(0);
          HotChatFlashPicActivity.a(this.a).setImageDrawable((URLDrawable)HotChatFlashPicActivity.a(this.a).getTag());
        }
        HotChatFlashPicActivity.a(this.a).setVisibility(0);
        HotChatFlashPicActivity.a(this.a).a();
        HotChatFlashPicActivity.a(this.a).b(HotChatFlashPicActivity.a(this.a));
        return false;
      }
      break;
    case 2: 
      int i = paramMessage.arg1;
      if ((HotChatFlashPicActivity.a(this.a).a()) && (!HotChatFlashPicActivity.a(this.a).d))
      {
        HotChatFlashPicActivity.a(this.a).a(i);
        return false;
      }
      break;
    case 1: 
      HotChatFlashPicActivity.a(this.a).setVisibility(0);
      HotChatFlashPicActivity.a(this.a).setOnTouchListener(this.a);
      HotChatFlashPicActivity.b(this.a).setVisibility(0);
      HotChatFlashPicActivity.a(this.a).setImageResource(2130842641);
      if (HotChatFlashPicActivity.b(this.a)) {
        HotChatFlashPicActivity.a(this.a).setText(2131693225);
      } else {
        HotChatFlashPicActivity.a(this.a).setText(2131691017);
      }
      if (HotChatFlashPicActivity.a(this.a).a())
      {
        HotChatFlashPicActivity.a(this.a).b();
        return false;
      }
      break;
    case 0: 
      label434:
      localObject = (String)paramMessage.obj;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramMessage = new File((String)localObject);
        if ((!((String)localObject).endsWith(HotChatFlashPicActivity.a(this.a).c)) && (HotChatFlashPicActivity.a(this.a).d))
        {
          if (!HotChatFlashPicActivity.a(this.a).b)
          {
            HotChatFlashPicActivity.a(this.a, true);
            HotChatFlashPicActivity.a(this.a).a(HotChatFlashPicActivity.a(this.a).jdField_f_of_type_Long, HotChatFlashPicActivity.a(this.a).jdField_f_of_type_Int, 2);
            return false;
          }
          HotChatFlashPicActivity.a(this.a).sendEmptyMessage(1);
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
        HotChatFlashPicActivity.a(this.a).setTag(paramMessage);
        HotChatFlashPicActivity.a(this.a).setVisibility(0);
        HotChatFlashPicActivity.a(this.a).setOnTouchListener(this.a);
        if (HotChatFlashPicActivity.c(this.a)) {
          HotChatFlashPicActivity.b(this.a).setVisibility(0);
        }
        HotChatFlashPicActivity.c(this.a, true);
        HotChatFlashPicActivity.a(this.a).setImageResource(2130842643);
        if (HotChatFlashPicActivity.b(this.a)) {
          HotChatFlashPicActivity.a(this.a).setText(2131693229);
        } else {
          HotChatFlashPicActivity.a(this.a).setText(2131691025);
        }
        if (HotChatFlashPicActivity.a(this.a).a())
        {
          HotChatFlashPicActivity.a(this.a).b();
          return false;
        }
      }
      else
      {
        HotChatFlashPicActivity.a(this.a).sendEmptyMessage(1);
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity.4
 * JD-Core Version:    0.7.0.1
 */