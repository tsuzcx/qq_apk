package com.tencent.mobileqq.emoticonview.api.impl;

import TK;;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.CommonEmoticonConstans;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelService;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class EmoticonPanelServiceImpl
  implements IEmoticonPanelService
{
  private static final String TAG = "EmoticonPanelServiceImpl";
  
  private void modifyDrawableByScreenSize(PicEmoticonInfo paramPicEmoticonInfo, Emoticon paramEmoticon)
  {
    if ((paramEmoticon.extensionWidth == 0) || (paramEmoticon.extensionHeight == 0) || ((paramPicEmoticonInfo.mFiveInchDefault == null) || (paramPicEmoticonInfo.mFiveInchFailed == null))) {}
    try
    {
      paramEmoticon = BaseApplicationImpl.getApplication().getResources();
      paramPicEmoticonInfo.mFiveInchDefault = paramEmoticon.getDrawable(2130846569);
      paramPicEmoticonInfo.mFiveInchFailed = paramEmoticon.getDrawable(2130846570);
      paramPicEmoticonInfo.mDefault = paramPicEmoticonInfo.mFiveInchDefault;
      paramPicEmoticonInfo.mFailed = paramPicEmoticonInfo.mFiveInchFailed;
      return;
    }
    catch (Exception paramEmoticon)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmoticonPanelServiceImpl", 2, paramEmoticon.getMessage());
        }
      }
    }
    catch (OutOfMemoryError paramEmoticon)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmoticonPanelServiceImpl", 2, paramEmoticon.getMessage());
        }
      }
    }
  }
  
  private void tryApng(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, URL paramURL, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
      if ((paramEmoticonPackage == null) && (!paramBoolean) && (paramEmoticon != null) && (!(paramURLDrawable.getCurrDrawable() instanceof ApngDrawable)))
      {
        paramURL = paramURL.toString();
        paramQQAppInterface.a(paramEmoticon.epId, new EmoticonPanelServiceImpl.1(this, paramURL));
      }
    }
  }
  
  public <T> URLDrawable getPicEmoticonAioPreviewDrawable(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    PicEmoticonInfo localPicEmoticonInfo = (PicEmoticonInfo)paramT;
    Emoticon localEmoticon = ((PicEmoticonInfo)paramT).emoticon;
    if (localEmoticon == null) {
      return null;
    }
    String str = CommonEmoticonConstans.emoticonAIOPreviewPath.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId);
    if (str != null) {
      try
      {
        paramT = new URL("emotion_pic", "fromAIO", PicEmoticonInfo.getFictionPath(localEmoticon));
        if (paramT != null)
        {
          modifyDrawableByScreenSize(localPicEmoticonInfo, localEmoticon);
          paramT = URLDrawable.getDrawable(paramT, localPicEmoticonInfo.mDefault, localPicEmoticonInfo.mFailed, false);
          if (paramT.getStatus() != 1)
          {
            paramT.setTag(localEmoticon);
            paramT.addHeader("my_uin", localPicEmoticonInfo.uin);
            if (!FileUtil.a(str)) {}
          }
        }
      }
      catch (MalformedURLException paramT)
      {
        try
        {
          paramT.downloadImediatly();
          return paramT;
          paramT = paramT;
          paramT.printStackTrace();
          paramT = null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("EmoticonPanelServiceImpl", 2, "getBigDrawable oom,drawableID=" + localPicEmoticonInfo.drawableId);
            }
          }
        }
      }
    }
    return null;
  }
  
  public <T, K> URLDrawable getPicEmoticonLoadingDrawable(K paramK, String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT)
  {
    if (paramK == null)
    {
      paramK = null;
      return paramK;
    }
    PicEmoticonInfo localPicEmoticonInfo = (PicEmoticonInfo)paramK;
    Object localObject2 = (MarketFaceItemBuilder.Holder)paramT;
    Emoticon localEmoticon = ((PicEmoticonInfo)paramK).emoticon;
    boolean bool = ((PicEmoticonInfo)paramK).isAPNG;
    Object localObject1 = ((PicEmoticonInfo)paramK).mDefault;
    paramT = ((PicEmoticonInfo)paramK).mFailed;
    if (localEmoticon == null) {
      return null;
    }
    try
    {
      paramK = new URL("emotion_pic", paramString, PicEmoticonInfo.getFictionPath(localEmoticon));
      if (paramK == null) {
        return null;
      }
    }
    catch (MalformedURLException paramK)
    {
      for (;;)
      {
        QLog.e("EmoticonPanelServiceImpl", 1, "market face getLoadingDrawable", paramK);
        paramK = null;
      }
      modifyDrawableByScreenSize(localPicEmoticonInfo, localEmoticon);
      if (localObject2 == null) {
        break label432;
      }
    }
    paramString = ((MarketFaceItemBuilder.Holder)localObject2).e.getDrawable();
    paramT = paramString;
    localObject1 = paramString;
    label432:
    for (;;)
    {
      paramString = BaseApplicationImpl.getApplication().waitAppRuntime(null);
      if ((paramString instanceof QQAppInterface)) {}
      for (paramString = (QQAppInterface)paramString;; paramString = null)
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = paramT;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        if (paramString != null)
        {
          paramT = (EmoticonManager)paramString.getManager(QQManagerFactory.EMOTICON_MANAGER);
          if (localEmoticon == null) {}
        }
        for (paramT = paramT.b(localEmoticon.epId, 0);; paramT = null)
        {
          paramBoolean1 = false;
          if (((paramT != null) && (paramT.isAPNG == 2)) || (bool) || (localEmoticon.isAPNG))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelServiceImpl", 2, "getBigDrawable: APNG so loaded use apng image");
            }
            paramBoolean1 = true;
            ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
            ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "useAPNG";
          }
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = localEmoticon.extensionWidth;
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = localEmoticon.extensionHeight;
          localObject1 = URLDrawable.getDrawable(paramK, (URLDrawable.URLDrawableOptions)localObject2);
          if (((URLDrawable)localObject1).getStatus() != 1)
          {
            ((URLDrawable)localObject1).setTag(localEmoticon);
            ((URLDrawable)localObject1).addHeader("my_uin", localPicEmoticonInfo.uin);
            ((URLDrawable)localObject1).addHeader("emo_type", String.valueOf(localPicEmoticonInfo.imageType));
            if (paramBoolean2) {
              ((URLDrawable)localObject1).addHeader("2g_use_gif", "true");
            }
            for (;;)
            {
              if (((URLDrawable)localObject1).getStatus() != 2)
              {
                paramK = (TK)localObject1;
                if (((URLDrawable)localObject1).getStatus() != 3) {
                  break;
                }
              }
              ((URLDrawable)localObject1).restartDownload();
              return localObject1;
              ((URLDrawable)localObject1).addHeader("2g_use_gif", "false");
            }
          }
          tryApng(paramString, localEmoticon, paramK, paramT, paramBoolean1, (URLDrawable)localObject1);
          return localObject1;
        }
      }
    }
  }
  
  public <T, K> URLDrawable getPicEmoticonLoadingDrawable(K paramK, String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT, int paramInt1, int paramInt2)
  {
    if (paramK == null)
    {
      paramK = null;
      return paramK;
    }
    PicEmoticonInfo localPicEmoticonInfo = (PicEmoticonInfo)paramK;
    Object localObject = (MarketFaceItemBuilder.Holder)paramT;
    Emoticon localEmoticon = ((PicEmoticonInfo)paramK).emoticon;
    boolean bool = ((PicEmoticonInfo)paramK).isAPNG;
    if (localEmoticon == null) {
      return null;
    }
    try
    {
      paramK = new URL("emotion_pic", paramString, PicEmoticonInfo.getFictionPath(localEmoticon));
      if (paramK == null) {
        return null;
      }
    }
    catch (MalformedURLException paramK)
    {
      for (;;)
      {
        QLog.e("EmoticonPanelServiceImpl", 1, "market face getLoadingDrawable", paramK);
        paramK = null;
      }
      modifyDrawableByScreenSize(localPicEmoticonInfo, localEmoticon);
      paramString = localPicEmoticonInfo.mDefault;
      paramT = localPicEmoticonInfo.mFailed;
      if (localObject == null) {
        break label425;
      }
    }
    paramT = ((MarketFaceItemBuilder.Holder)localObject).e.getDrawable();
    label425:
    for (;;)
    {
      paramString = BaseApplicationImpl.getApplication().waitAppRuntime(null);
      if ((paramString instanceof QQAppInterface)) {}
      for (paramString = (QQAppInterface)paramString;; paramString = null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramT;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localPicEmoticonInfo.mDefault;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        if (paramString != null)
        {
          paramT = (EmoticonManager)paramString.getManager(QQManagerFactory.EMOTICON_MANAGER);
          if (localEmoticon == null) {}
        }
        for (paramT = paramT.b(localEmoticon.epId, 0);; paramT = null)
        {
          paramBoolean1 = false;
          if (((paramT != null) && (paramT.isAPNG == 2)) || (bool) || (localEmoticon.isAPNG))
          {
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelServiceImpl", 2, "getBigDrawable: APNG so loaded use apng image");
            }
            paramBoolean1 = true;
            ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
            ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
            ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "useAPNG";
          }
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = localPicEmoticonInfo.reqWidth;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = localPicEmoticonInfo.reqHeight;
          localObject = URLDrawable.getDrawable(paramK, (URLDrawable.URLDrawableOptions)localObject);
          if (((URLDrawable)localObject).getStatus() != 1)
          {
            ((URLDrawable)localObject).setTag(localEmoticon);
            ((URLDrawable)localObject).addHeader("my_uin", localPicEmoticonInfo.uin);
            ((URLDrawable)localObject).addHeader("emo_type", String.valueOf(localPicEmoticonInfo.imageType));
            if (paramBoolean2) {
              ((URLDrawable)localObject).addHeader("2g_use_gif", "true");
            }
            for (;;)
            {
              if (((URLDrawable)localObject).getStatus() != 2)
              {
                paramK = (TK)localObject;
                if (((URLDrawable)localObject).getStatus() != 3) {
                  break;
                }
              }
              ((URLDrawable)localObject).restartDownload();
              return localObject;
              ((URLDrawable)localObject).addHeader("2g_use_gif", "false");
            }
          }
          tryApng(paramString, localEmoticon, paramK, paramT, paramBoolean1, (URLDrawable)localObject);
          return localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonPanelServiceImpl
 * JD-Core Version:    0.7.0.1
 */