package com.tencent.mobileqq.newnearby.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.newnearby.INearbyResDownloader;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NearbyResDownloaderImpl
  implements INearbyResDownloader
{
  private static final String TAG = "NearbyResDownloader";
  
  private boolean isFileExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  private Drawable readImage(String paramString)
  {
    return new BitmapDrawable(BitmapFactory.decodeFile(paramString));
  }
  
  private void saveImage(Drawable paramDrawable, String paramString)
  {
    paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
    try
    {
      paramString = new FileOutputStream(new File(paramString));
      paramDrawable.compress(Bitmap.CompressFormat.WEBP, 100, paramString);
      paramString.flush();
      paramString.close();
      return;
    }
    catch (Exception paramDrawable)
    {
      paramString = new StringBuilder();
      paramString.append("saveImage error: ");
      paramString.append(paramDrawable.getMessage());
      QLog.e("NearbyResDownloader", 2, paramString.toString());
    }
  }
  
  public boolean checkRes()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append(".nearby/cache/res/");
    localObject = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("find_icon_nor.webp");
    if (isFileExist(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("find_icon_sel.webp");
      if (isFileExist(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("live_icon_nor.webp");
        if (isFileExist(localStringBuilder.toString()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("live_icon_sel.webp");
          if (isFileExist(localStringBuilder.toString()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("match_icon_nor.webp");
            if (isFileExist(localStringBuilder.toString()))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("match_icon_sel.webp");
              if (isFileExist(localStringBuilder.toString()))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append((String)localObject);
                localStringBuilder.append("msg_icon_nor.webp");
                if (isFileExist(localStringBuilder.toString()))
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append((String)localObject);
                  localStringBuilder.append("msg_icon_sel.webp");
                  if (isFileExist(localStringBuilder.toString())) {
                    return true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public Drawable downloadImg(int paramInt, boolean paramBoolean)
  {
    String str = getImgResPath(paramInt, paramBoolean);
    if (isFileExist(str)) {
      return readImage(str);
    }
    return null;
  }
  
  public Drawable downloadImg(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject = getImgResPath(paramInt, paramBoolean);
    if (isFileExist((String)localObject)) {
      return readImage((String)localObject);
    }
    try
    {
      paramString = (InputStream)new URL(paramString).getContent();
      Drawable localDrawable = Drawable.createFromStream(paramString, "src");
      paramString.close();
      saveImage(localDrawable, (String)localObject);
      return localDrawable;
    }
    catch (IOException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadImg err:");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.e("NearbyResDownloader", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String getImgResPath(int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append(".nearby/cache/res/");
    String str = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 100) {
                return "";
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append("nearby_bg.webp");
              return ((StringBuilder)localObject).toString();
            }
            if (paramBoolean)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str);
              str = "msg_icon_sel.webp";
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str);
              str = "msg_icon_nor.webp";
            }
            ((StringBuilder)localObject).append(str);
            return ((StringBuilder)localObject).toString();
          }
          if (paramBoolean)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            str = "group_icon_sel.webp";
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str);
            str = "group_icon_nor.webp";
          }
          ((StringBuilder)localObject).append(str);
          return ((StringBuilder)localObject).toString();
        }
        if (paramBoolean)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          str = "match_icon_sel.webp";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          str = "match_icon_nor.webp";
        }
        ((StringBuilder)localObject).append(str);
        return ((StringBuilder)localObject).toString();
      }
      if (paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        str = "live_icon_sel.webp";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        str = "live_icon_nor.webp";
      }
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      str = "find_icon_sel.webp";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      str = "find_icon_nor.webp";
    }
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyResDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */