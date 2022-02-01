package com.tencent.mobileqq.qqfavor.api.impl;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.qqfavor.api.IQQFavHelper;
import cooperation.qqfav.QfavHelper;
import java.util.List;
import mqq.app.AppRuntime;

public class QQFavHelperImpl
  implements IQQFavHelper
{
  public void downloadThumb(BaseQQAppInterface paramBaseQQAppInterface, FavFileInfo paramFavFileInfo, int paramInt)
  {
    QfavHelper.a(paramBaseQQAppInterface.getApplicationContext(), paramFavFileInfo, paramInt);
  }
  
  public void forwardFavFileList(BaseQQAppInterface paramBaseQQAppInterface, List<FavFileInfo> paramList, String paramString, int paramInt)
  {
    QfavHelper.a((QQAppInterface)paramBaseQQAppInterface, paramList, paramString, paramInt);
  }
  
  public void getFavList(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, boolean paramBoolean, Bundle paramBundle)
  {
    QfavHelper.a(paramBaseQQAppInterface.getApplicationContext(), paramLong, Boolean.valueOf(paramBoolean), paramBundle);
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
  
  public boolean refreshList(BaseQQAppInterface paramBaseQQAppInterface, Bundle paramBundle)
  {
    return QfavHelper.a(paramBaseQQAppInterface.getApplicationContext(), paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqfavor.api.impl.QQFavHelperImpl
 * JD-Core Version:    0.7.0.1
 */