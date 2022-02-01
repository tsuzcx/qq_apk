package com.tencent.mobileqq.richmediabrowser.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class AIOGalleryUtils
{
  public static void a(Activity paramActivity, File paramFile, String paramString)
  {
    a(paramActivity, paramFile, paramString, null);
  }
  
  public static void a(Activity paramActivity, File paramFile, String paramString, AIOGalleryUtils.OnSavePhoto paramOnSavePhoto)
  {
    if (!CheckPermission.isHasStoragePermission(paramActivity))
    {
      CheckPermission.requestStorePermission(paramActivity, null);
      return;
    }
    new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
    String str = paramString;
    if (paramString.indexOf(".") == -1)
    {
      str = FileUtils.estimateFileType(paramFile.getAbsolutePath());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(".");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
    }
    paramString = new File(AppConstants.SDCARD_IMG_SAVE, str);
    if (!paramString.exists())
    {
      b(paramActivity, paramFile, paramString, paramOnSavePhoto);
      return;
    }
    DialogUtil.a(paramActivity, 230).setTitle(paramActivity.getString(2131718393)).setMessage(paramActivity.getString(2131694907)).setPositiveButton(paramActivity.getString(2131718205), new AIOGalleryUtils.2(paramActivity, paramFile, paramString, paramOnSavePhoto)).setNegativeButton(paramActivity.getString(2131694460), new AIOGalleryUtils.1()).show();
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "forwardLocalImgToQzoneAlbum, path is empty");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("forwardLocalImgToQzoneAlbum, path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AIOGalleryUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    a(paramActivity, BaseApplicationImpl.getApplication().getRuntime().getAccount(), (ArrayList)localObject, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, Parcelable paramParcelable, boolean paramBoolean, String paramString3)
  {
    if (paramParcelable != null)
    {
      if (!AIOPictureData.class.isInstance(paramParcelable)) {
        return;
      }
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = paramString1;
      AIOPictureData localAIOPictureData = (AIOPictureData)paramParcelable;
      paramString1 = localAIOPictureData.a;
      if (!paramString1.endsWith("_hd"))
      {
        paramParcelable = new StringBuilder();
        paramParcelable.append(paramString1);
        paramParcelable.append("_hd");
        paramParcelable = paramParcelable.toString();
        if (new File(paramParcelable).exists()) {
          paramString1 = paramParcelable;
        }
      }
      paramParcelable = localAIOPictureData.jdField_e_of_type_JavaLangString;
      long l2 = localAIOPictureData.jdField_e_of_type_Long;
      long l1;
      if (paramBoolean) {
        l1 = localAIOPictureData.f;
      } else {
        l1 = 0L;
      }
      QZoneHelper.forwardToQzoneAlbum(paramActivity, localUserInfo, paramBoolean, paramString3, paramString2, paramInt, paramString1, paramParcelable, l2, l1, -1);
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, List<MessageForPic> paramList, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = paramString1;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      boolean bool;
      if (paramInt1 == 1) {
        bool = true;
      } else {
        bool = false;
      }
      if ((paramInt1 != 1) && (paramInt1 != 3000)) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageForPic localMessageForPic = (MessageForPic)localIterator.next();
        int i;
        if (localMessageForPic.isMixed) {
          i = 1;
        } else {
          i = 65537;
        }
        paramString1 = URLDrawableHelper.getURL(localMessageForPic, i, "chatthumb");
        if (paramString1 != null)
        {
          paramString1 = AbsDownloader.getFilePath(paramString1.toString());
          if (paramString1 != null)
          {
            paramList = new File(paramString1).getAbsolutePath();
            paramString1 = paramList;
            if (!paramList.endsWith("_hd"))
            {
              paramString1 = new StringBuilder();
              paramString1.append(paramList);
              paramString1.append("_hd");
              String str = paramString1.toString();
              paramString1 = paramList;
              if (new File(str).exists()) {
                paramString1 = str;
              }
            }
            localArrayList1.add(paramString1);
            localArrayList2.add(localMessageForPic.uuid);
            localArrayList3.add(Long.valueOf(localMessageForPic.time));
            if (bool) {
              localArrayList4.add(Long.valueOf(localMessageForPic.groupFileID));
            }
            if (QLog.isColorLevel())
            {
              paramList = new StringBuilder();
              paramList.append("forwardToQzoneAlbum, uuid:");
              paramList.append(localMessageForPic.uuid);
              paramList.append(" time:");
              paramList.append(localMessageForPic.time);
              paramList.append(" path:");
              paramList.append(paramString1);
              QLog.d("AIOGalleryUtils", 2, paramList.toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("AIOGalleryUtils", 2, "forwardToQzoneAlbum exchange path = null");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AIOGalleryUtils", 2, "forwardToQzoneAlbum exchange url = null");
        }
      }
      QZoneHelper.forwardToQzoneAlbum(paramActivity, localUserInfo, bool, paramString3, paramString2, paramInt1, localArrayList1, localArrayList2, localArrayList3, localArrayList4, paramInt2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "forwardToQzoneAlbum, picMsgList is empty");
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = paramString1;
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fowardToGroupAlbum(),uin:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" qunId:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" qunCode:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" uuid:");
    localStringBuilder.append(paramString5);
    localStringBuilder.append(" time:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" path:");
    localStringBuilder.append(paramInt);
    localIBrowserLog.d("AIOGalleryUtils", 4, localStringBuilder.toString());
    QZoneHelper.forwardToGroupAlbum(paramActivity, localUserInfo, paramString2, paramString3, paramString4, paramString5, paramLong, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, ArrayList<String> paramArrayList, int paramInt)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      QZoneHelper.forwardToUploadPhoto(paramActivity, paramString, 0, 0, paramArrayList, paramActivity.getResources().getString(2131717648), paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "forwardLocalImgToQzoneAlbum, picMsgList is empty");
    }
  }
  
  private static void b(Activity paramActivity, File paramFile1, File paramFile2, AIOGalleryUtils.OnSavePhoto paramOnSavePhoto)
  {
    new AIOGalleryUtils.3(paramFile2, paramActivity, paramFile1, paramOnSavePhoto).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils
 * JD-Core Version:    0.7.0.1
 */