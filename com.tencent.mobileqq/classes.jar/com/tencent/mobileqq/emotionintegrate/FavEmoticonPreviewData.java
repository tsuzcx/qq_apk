package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class FavEmoticonPreviewData
  extends EmoticonPreviewData
{
  public EmoticonInfo a;
  
  public FavEmoticonPreviewData(EmoticonInfo paramEmoticonInfo)
  {
    this.a = paramEmoticonInfo;
  }
  
  public int a(List<EmoticonPreviewData> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject1 = (EmoticonPreviewData)paramList.get(i);
      if ((localObject1 instanceof FavEmoticonPreviewData))
      {
        localObject1 = ((FavEmoticonPreviewData)localObject1).a;
        Object localObject2;
        if (((localObject1 instanceof IFavoriteEmoticonInfo)) && ((this.a instanceof IFavoriteEmoticonInfo)))
        {
          localObject1 = (IFavoriteEmoticonInfo)localObject1;
          localObject2 = ((IFavoriteEmoticonInfo)localObject1).getUrl();
          String str = ((IFavoriteEmoticonInfo)this.a).getUrl();
          if ((localObject2 != null) && (((String)localObject2).equals(str))) {
            return i;
          }
          localObject1 = ((IFavoriteEmoticonInfo)localObject1).getPath();
          localObject2 = ((IFavoriteEmoticonInfo)this.a).getPath();
          if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
            return i;
          }
        }
        else if (((localObject1 instanceof IPicEmoticonInfo)) && ((this.a instanceof IPicEmoticonInfo)))
        {
          localObject1 = ((IPicEmoticonInfo)localObject1).getEmoticon();
          localObject2 = ((IPicEmoticonInfo)this.a).getEmoticon();
          if ((localObject1 != null) && (localObject2 != null) && (((Emoticon)localObject1).eId != null) && (((Emoticon)localObject1).eId.equals(((Emoticon)localObject2).eId))) {
            return i;
          }
        }
        else if (((localObject1 instanceof CameraEmoticonInfo)) && ((this.a instanceof CameraEmoticonInfo)) && (((CameraEmoticonInfo)localObject1).emoId == ((CameraEmoticonInfo)this.a).emoId))
        {
          return i;
        }
      }
      i += 1;
    }
    return 0;
  }
  
  public Drawable a(Context paramContext)
  {
    EmoticonInfo localEmoticonInfo = this.a;
    if ((localEmoticonInfo instanceof IPicEmoticonInfo)) {
      return ((IPicEmoticonInfo)localEmoticonInfo).getLoadingDrawable("fromAIO", true);
    }
    if ((localEmoticonInfo instanceof IFavoriteEmoticonInfo)) {
      return ((IFavoriteEmoticonInfo)localEmoticonInfo).getBigDrawable(paramContext, paramContext.getResources().getDisplayMetrics().density, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
    }
    if ((localEmoticonInfo instanceof CameraEmoticonInfo)) {
      return ((CameraEmoticonInfo)localEmoticonInfo).getBigDrawable(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
    }
    return null;
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    paramBundle.putInt("cur_emotion_id", (int)b());
    if ((this.a instanceof CameraEmoticonInfo)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    paramBundle.putInt("cur_emotion_type", paramInt);
  }
  
  public boolean a()
  {
    return this.a instanceof IPicEmoticonInfo;
  }
  
  public boolean a(EmoticonPreviewData paramEmoticonPreviewData)
  {
    boolean bool4 = paramEmoticonPreviewData instanceof FavEmoticonPreviewData;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (bool4)
    {
      paramEmoticonPreviewData = ((FavEmoticonPreviewData)paramEmoticonPreviewData).a;
      Object localObject;
      if (((paramEmoticonPreviewData instanceof IFavoriteEmoticonInfo)) && ((this.a instanceof IFavoriteEmoticonInfo)))
      {
        paramEmoticonPreviewData = ((IFavoriteEmoticonInfo)paramEmoticonPreviewData).getResID();
        localObject = ((IFavoriteEmoticonInfo)this.a).getResID();
        bool1 = bool2;
        if (paramEmoticonPreviewData != null)
        {
          bool1 = bool2;
          if (paramEmoticonPreviewData.equals(localObject)) {
            bool1 = true;
          }
        }
        return bool1;
      }
      bool1 = bool3;
      if ((paramEmoticonPreviewData instanceof IPicEmoticonInfo))
      {
        bool1 = bool3;
        if ((this.a instanceof IPicEmoticonInfo))
        {
          paramEmoticonPreviewData = ((IPicEmoticonInfo)paramEmoticonPreviewData).getEmoticon();
          localObject = ((IPicEmoticonInfo)this.a).getEmoticon();
          bool1 = bool3;
          if (paramEmoticonPreviewData != null)
          {
            bool1 = bool3;
            if (localObject != null)
            {
              bool1 = bool3;
              if (paramEmoticonPreviewData.eId != null)
              {
                bool1 = bool3;
                if (paramEmoticonPreviewData.eId.equals(((Emoticon)localObject).eId))
                {
                  bool1 = bool3;
                  if (paramEmoticonPreviewData.epId != null)
                  {
                    bool1 = bool3;
                    if (paramEmoticonPreviewData.epId.equals(((Emoticon)localObject).epId)) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public long b()
  {
    EmoticonInfo localEmoticonInfo = this.a;
    if ((localEmoticonInfo instanceof ICustomEmotionInfo)) {
      return ((ICustomEmotionInfo)localEmoticonInfo).getEmoId();
    }
    return 0L;
  }
  
  public EmoticonPreviewData b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("cur_emotion_id"))
    {
      QLog.d("FavEmoticonPreviewData", 1, "doRestoreSaveInstanceState");
      int i = paramBundle.getInt("cur_emotion_type");
      int j = paramBundle.getInt("cur_emotion_id");
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramBundle instanceof QQAppInterface))
      {
        Object localObject = (QQAppInterface)paramBundle;
        if (i == 1) {
          paramBundle = ICameraEmotionRoamingDBManagerService.class;
        } else {
          paramBundle = IFavroamingDBManagerService.class;
        }
        paramBundle = (CustomEmotionRoamingDBManagerBase)((QQAppInterface)localObject).getRuntimeService(paramBundle);
        localObject = paramBundle.getEmoticonDataList();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)((Iterator)localObject).next();
            if (localCustomEmotionBase.emoId == j) {
              return new FavEmoticonPreviewData(paramBundle.convertEmotionDataToInfo(localCustomEmotionBase));
            }
          }
        }
      }
    }
    return null;
  }
  
  public EmoticonInfo c()
  {
    return this.a;
  }
  
  public CustomEmotionData d()
  {
    Object localObject = this.a;
    if (((localObject instanceof IFavoriteEmoticonInfo)) && (((IFavoriteEmoticonInfo)localObject).getResID() != null))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((IFavroamingDBManagerService)((QQAppInterface)localObject).getRuntimeService(IFavroamingDBManagerService.class)).getEmoticonDataList();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((IFavoriteEmoticonInfo)this.a).getResID().equalsIgnoreCase(localCustomEmotionData.resid)) {
              return localCustomEmotionData;
            }
          }
        }
      }
    }
    return null;
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public boolean g()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.FavEmoticonPreviewData
 * JD-Core Version:    0.7.0.1
 */