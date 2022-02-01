package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class PersonalityLabelGalleryActivity$6
  extends PersonalityLabelObserver
{
  PersonalityLabelGalleryActivity$6(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void onDelPersonalityLabelPhoto(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDelPersonalityLabelPhoto suc:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramLong2);
      QLog.i("PersonalityLabelGalleryActivity", 2, localStringBuilder.toString());
    }
    if ((PersonalityLabelGalleryActivity.i(this.a)) && (paramString.equals(this.a.app.getCurrentAccountUin())))
    {
      paramString = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.j(this.a).get(Long.valueOf(paramLong1));
      if (paramString == null) {
        return;
      }
      int i = 0;
      while (i < paramString.personalityLabelPhotos.size())
      {
        if (((PersonalityLabelPhoto)paramString.personalityLabelPhotos.get(i)).fileId == paramLong2)
        {
          if (paramString.personalityLabelPhotos.remove(i) != null)
          {
            PersonalityLabelGalleryActivity.b(this.a, true);
            paramString.photoCount -= 1;
            this.a.a(paramLong1, false);
          }
          PersonalityLabelGalleryActivity.m(this.a).notifyDataSetChanged();
          return;
        }
        i += 1;
      }
    }
  }
  
  public void onGetPersonalityLabel(boolean paramBoolean, String paramString, ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (TextUtils.isEmpty(PersonalityLabelGalleryActivity.h(this.a))) {
      paramArrayOfByte = this.a.app.getCurrentAccountUin();
    } else {
      paramArrayOfByte = PersonalityLabelGalleryActivity.h(this.a);
    }
    if (!paramArrayOfByte.equals(paramString)) {
      return;
    }
    if ((paramBoolean) && (paramProfilePersonalityLabelInfo != null))
    {
      if (this.a.c)
      {
        this.a.b.clear();
        if (PersonalityLabelGalleryActivity.b(this.a) == null) {
          paramInt = 0;
        } else {
          paramInt = PersonalityLabelGalleryActivity.b(this.a).getSize();
        }
        paramInt = paramProfilePersonalityLabelInfo.getSize() - paramInt;
        int i = 0;
        while (paramInt > 0)
        {
          this.a.b.add(Long.valueOf(((PersonalityLabelInfo)paramProfilePersonalityLabelInfo.personalityLabelInfos.get(i)).id));
          i += 1;
          paramInt -= 1;
        }
        this.a.c = false;
      }
      if ((paramProfilePersonalityLabelInfo.getSize() > 0) && (PersonalityLabelGalleryActivity.i(this.a)))
      {
        paramInt = 0;
        while (paramInt < paramProfilePersonalityLabelInfo.personalityLabelInfos.size())
        {
          paramString = (PersonalityLabelInfo)paramProfilePersonalityLabelInfo.personalityLabelInfos.get(paramInt);
          this.a.q.a(paramString.id, paramString, true);
          paramInt += 1;
        }
      }
      this.a.a(paramProfilePersonalityLabelInfo, true);
      if (this.a.g.hasMessages(0)) {
        this.a.g.removeMessages(0);
      }
      paramString = this.a.g.obtainMessage(0, paramProfilePersonalityLabelInfo);
      this.a.g.sendMessageDelayed(paramString, 500L);
      return;
    }
    if (!paramBoolean)
    {
      if (!NetworkUtil.isNetSupport(this.a))
      {
        paramString = this.a;
        PersonalityLabelGalleryActivity.a(paramString, paramString.getResources().getString(2131892102));
      }
      else
      {
        paramString = this.a;
        PersonalityLabelGalleryActivity.a(paramString, paramString.getResources().getString(2131891374));
      }
      paramString = this.a;
      if ((PersonalityLabelGalleryActivity.b(paramString) != null) && (PersonalityLabelGalleryActivity.b(this.a).getSize() > 0)) {
        paramInt = 8;
      } else {
        paramInt = 0;
      }
      paramString.a(paramInt, "加载失败", false);
    }
  }
  
  public void onGetPersonalityLabelPhotos(boolean paramBoolean, String paramString, long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetPersonalityLabelPhotos : isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", labelId = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", completeFlag = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", cookie = ");
      String str = "null";
      if (paramArrayOfByte == null) {
        localObject = "null";
      } else {
        localObject = paramArrayOfByte;
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", labelInfo = ");
      if (paramPersonalityLabelInfo == null) {
        localObject = str;
      } else {
        localObject = paramPersonalityLabelInfo.toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.i("PersonalityLabelGalleryActivity", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(PersonalityLabelGalleryActivity.h(this.a))) {
      localObject = this.a.app.getCurrentAccountUin();
    } else {
      localObject = PersonalityLabelGalleryActivity.h(this.a);
    }
    if (((String)localObject).equals(paramString)) {
      PersonalityLabelGalleryActivity.a(this.a, false);
    }
    if ((paramBoolean) && (paramPersonalityLabelInfo != null))
    {
      paramString = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.j(this.a).get(Long.valueOf(paramLong));
      if (paramString != null)
      {
        if (PersonalityLabelGalleryActivity.k(this.a).get(Long.valueOf(paramLong)) == null)
        {
          paramString.personalityLabelPhotos.clear();
          if (PersonalityLabelGalleryActivity.i(this.a))
          {
            int i = this.a.q.a(paramLong, paramPersonalityLabelInfo, true);
            paramPersonalityLabelInfo.photoCount += i;
          }
        }
        paramString.personalityLabelPhotos.addAll(paramPersonalityLabelInfo.personalityLabelPhotos);
        PersonalityLabelGalleryActivity.l(this.a).put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
        if (paramArrayOfByte != null) {
          PersonalityLabelGalleryActivity.k(this.a).put(Long.valueOf(paramLong), paramArrayOfByte);
        }
        PersonalityLabelGalleryActivity.a(this.a, paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.6
 * JD-Core Version:    0.7.0.1
 */