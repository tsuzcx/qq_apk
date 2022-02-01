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
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onDelPersonalityLabelPhoto suc:" + paramBoolean + "," + paramString + "," + paramLong1 + "," + paramLong2);
    }
    if ((PersonalityLabelGalleryActivity.a(this.a)) && (paramString.equals(this.a.app.getCurrentAccountUin())))
    {
      paramString = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.a).get(Long.valueOf(paramLong1));
      if (paramString != null) {
        break label109;
      }
    }
    for (;;)
    {
      return;
      label109:
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
          PersonalityLabelGalleryActivity.a(this.a).notifyDataSetChanged();
          return;
        }
        i += 1;
      }
    }
  }
  
  public void onGetPersonalityLabel(boolean paramBoolean, String paramString, ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt != 1) {}
    label36:
    label167:
    label169:
    label192:
    do
    {
      return;
      boolean bool;
      if (TextUtils.isEmpty(PersonalityLabelGalleryActivity.a(this.a)))
      {
        bool = this.a.app.getCurrentAccountUin().equals(paramString);
        if (!bool) {
          break label167;
        }
        if ((!paramBoolean) || (paramProfilePersonalityLabelInfo == null)) {
          continue;
        }
        if (!this.a.jdField_a_of_type_Boolean) {
          break label192;
        }
        this.a.jdField_a_of_type_JavaUtilHashSet.clear();
        if (PersonalityLabelGalleryActivity.a(this.a) != null) {
          break label169;
        }
      }
      for (paramInt = 0;; paramInt = PersonalityLabelGalleryActivity.a(this.a).getSize())
      {
        int i = paramProfilePersonalityLabelInfo.getSize();
        int j = 0;
        i -= paramInt;
        paramInt = j;
        while (i > 0)
        {
          this.a.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(((PersonalityLabelInfo)paramProfilePersonalityLabelInfo.personalityLabelInfos.get(paramInt)).id));
          i -= 1;
          paramInt += 1;
        }
        bool = PersonalityLabelGalleryActivity.a(this.a).equals(paramString);
        break label36;
        break;
      }
      this.a.jdField_a_of_type_Boolean = false;
      if ((paramProfilePersonalityLabelInfo.getSize() > 0) && (PersonalityLabelGalleryActivity.a(this.a)))
      {
        paramInt = 0;
        while (paramInt < paramProfilePersonalityLabelInfo.personalityLabelInfos.size())
        {
          paramString = (PersonalityLabelInfo)paramProfilePersonalityLabelInfo.personalityLabelInfos.get(paramInt);
          this.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(paramString.id, paramString, true);
          paramInt += 1;
        }
      }
      this.a.a(paramProfilePersonalityLabelInfo, true);
      if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      paramString = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, paramProfilePersonalityLabelInfo);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, 500L);
      return;
    } while (paramBoolean);
    if (!NetworkUtil.d(this.a))
    {
      PersonalityLabelGalleryActivity.a(this.a, this.a.getResources().getString(2131694457));
      paramString = this.a;
      if ((PersonalityLabelGalleryActivity.a(this.a) == null) || (PersonalityLabelGalleryActivity.a(this.a).getSize() <= 0)) {
        break label427;
      }
    }
    label427:
    for (paramInt = 8;; paramInt = 0)
    {
      paramString.a(paramInt, "加载失败", false);
      return;
      PersonalityLabelGalleryActivity.a(this.a, this.a.getResources().getString(2131693846));
      break;
    }
  }
  
  public void onGetPersonalityLabelPhotos(boolean paramBoolean, String paramString, long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetPersonalityLabelPhotos : isSuccess = ").append(paramBoolean).append(", uin = ").append(paramString).append(", labelId = ").append(paramLong).append(", completeFlag = ").append(paramInt).append(", cookie = ");
      if (paramArrayOfByte == null)
      {
        localObject = "null";
        localStringBuilder = localStringBuilder.append(localObject).append(", labelInfo = ");
        if (paramPersonalityLabelInfo != null) {
          break label313;
        }
        localObject = "null";
        label89:
        QLog.i("PersonalityLabelGalleryActivity", 2, (String)localObject);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(PersonalityLabelGalleryActivity.a(this.a))) {
        break label323;
      }
    }
    label313:
    label323:
    for (boolean bool = this.a.app.getCurrentAccountUin().equals(paramString);; bool = PersonalityLabelGalleryActivity.a(this.a).equals(paramString))
    {
      if (bool) {
        PersonalityLabelGalleryActivity.a(this.a, false);
      }
      if ((paramBoolean) && (paramPersonalityLabelInfo != null))
      {
        paramString = (PersonalityLabelInfo)PersonalityLabelGalleryActivity.a(this.a).get(Long.valueOf(paramLong));
        if (paramString != null)
        {
          if (PersonalityLabelGalleryActivity.b(this.a).get(Long.valueOf(paramLong)) == null)
          {
            paramString.personalityLabelPhotos.clear();
            if (PersonalityLabelGalleryActivity.a(this.a)) {
              paramPersonalityLabelInfo.photoCount = (this.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager.a(paramLong, paramPersonalityLabelInfo, true) + paramPersonalityLabelInfo.photoCount);
            }
          }
          paramString.personalityLabelPhotos.addAll(paramPersonalityLabelInfo.personalityLabelPhotos);
          PersonalityLabelGalleryActivity.c(this.a).put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
          if (paramArrayOfByte != null) {
            PersonalityLabelGalleryActivity.b(this.a).put(Long.valueOf(paramLong), paramArrayOfByte);
          }
          PersonalityLabelGalleryActivity.a(this.a, paramLong);
        }
      }
      return;
      localObject = paramArrayOfByte;
      break;
      localObject = paramPersonalityLabelInfo.toString();
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.6
 * JD-Core Version:    0.7.0.1
 */