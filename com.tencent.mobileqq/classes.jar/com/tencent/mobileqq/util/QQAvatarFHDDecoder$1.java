package com.tencent.mobileqq.util;

import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class QQAvatarFHDDecoder$1
  extends AvatarObserver
{
  QQAvatarFHDDecoder$1(QQAvatarFHDDecoder paramQQAvatarFHDDecoder) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetHeadInfo ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      String str;
      if (paramSetting != null) {
        str = paramSetting.uin;
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      QLog.i("QQAvatarFHDDecoder", 2, localStringBuilder.toString());
    }
    if ((paramSetting != null) && (paramSetting.uin != null) && (paramSetting.uin.equals(QQAvatarFHDDecoder.a(this.a)))) {
      ThreadManagerV2.excute(new QQAvatarFHDDecoder.1.1(this, paramSetting), 128, null, true);
    }
  }
  
  public void onGetHeadInfoEmpty(boolean paramBoolean, int paramInt, List<String> paramList)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetHeadInfoEmpty ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      if (paramList != null) {
        str = paramList.toString();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      QLog.i("QQAvatarFHDDecoder", 2, localStringBuilder.toString());
    }
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        str = (String)paramList.next();
        if ((str != null) && (str.equals(QQAvatarFHDDecoder.a(this.a))))
        {
          if (paramBoolean)
          {
            ThreadManagerV2.excute(new QQAvatarFHDDecoder.1.2(this, str), 128, null, true);
            return;
          }
          QQAvatarFHDDecoder.a(this.a).obtainMessage(1).sendToTarget();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQAvatarFHDDecoder.1
 * JD-Core Version:    0.7.0.1
 */