package com.tencent.mobileqq.qqfavor.api;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQFavHelper
  extends IRuntimeService
{
  public abstract void downloadThumb(BaseQQAppInterface paramBaseQQAppInterface, FavFileInfo paramFavFileInfo, int paramInt);
  
  public abstract void forwardFavFileList(BaseQQAppInterface paramBaseQQAppInterface, List<FavFileInfo> paramList, String paramString, int paramInt);
  
  public abstract void getFavList(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, boolean paramBoolean, Bundle paramBundle);
  
  public abstract boolean refreshList(BaseQQAppInterface paramBaseQQAppInterface, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfavor.api.IQQFavHelper
 * JD-Core Version:    0.7.0.1
 */