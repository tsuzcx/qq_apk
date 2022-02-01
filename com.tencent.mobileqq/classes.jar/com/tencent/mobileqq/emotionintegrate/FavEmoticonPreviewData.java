package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ICustomEmotionInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
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
    if (i < paramList.size())
    {
      Object localObject1 = (EmoticonPreviewData)paramList.get(i);
      Object localObject2;
      if ((localObject1 instanceof FavEmoticonPreviewData))
      {
        localObject1 = ((FavEmoticonPreviewData)localObject1).a;
        if ((!(localObject1 instanceof FavoriteEmoticonInfo)) || (!(this.a instanceof FavoriteEmoticonInfo))) {
          break label133;
        }
        localObject2 = ((FavoriteEmoticonInfo)localObject1).url;
        String str = ((FavoriteEmoticonInfo)this.a).url;
        if ((localObject2 != null) && (((String)localObject2).equals(str))) {}
        do
        {
          return i;
          localObject1 = ((FavoriteEmoticonInfo)localObject1).path;
          localObject2 = ((FavoriteEmoticonInfo)this.a).path;
        } while ((localObject1 != null) && (((String)localObject1).equals(localObject2)));
      }
      label133:
      label203:
      do
      {
        do
        {
          i += 1;
          break;
          if ((!(localObject1 instanceof PicEmoticonInfo)) || (!(this.a instanceof PicEmoticonInfo))) {
            break label203;
          }
          localObject1 = ((PicEmoticonInfo)localObject1).emoticon;
          localObject2 = ((PicEmoticonInfo)this.a).emoticon;
        } while ((localObject1 == null) || (localObject2 == null) || (((Emoticon)localObject1).eId == null) || (!((Emoticon)localObject1).eId.equals(((Emoticon)localObject2).eId)));
        return i;
      } while ((!(localObject1 instanceof CameraEmoticonInfo)) || (!(this.a instanceof CameraEmoticonInfo)) || (((CameraEmoticonInfo)localObject1).emoId != ((CameraEmoticonInfo)this.a).emoId));
      return i;
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.a instanceof ICustomEmotionInfo)) {
      return ((ICustomEmotionInfo)this.a).getEmoId();
    }
    return 0L;
  }
  
  public Drawable a(Context paramContext)
  {
    URLDrawable localURLDrawable = null;
    if ((this.a instanceof PicEmoticonInfo)) {
      localURLDrawable = ((PicEmoticonInfo)this.a).getLoadingDrawable("fromAIO", true);
    }
    do
    {
      return localURLDrawable;
      if ((this.a instanceof FavoriteEmoticonInfo)) {
        return ((FavoriteEmoticonInfo)this.a).getBigDrawable(paramContext, paramContext.getResources().getDisplayMetrics().density, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
      }
    } while (!(this.a instanceof CameraEmoticonInfo));
    return ((CameraEmoticonInfo)this.a).getBigDrawable(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels, paramContext.getResources().getDisplayMetrics().heightPixels);
  }
  
  public CustomEmotionData a()
  {
    if (((this.a instanceof FavoriteEmoticonInfo)) && (((FavoriteEmoticonInfo)this.a).resID != null))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((FavroamingDBManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).a();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
            if (((FavoriteEmoticonInfo)this.a).resID.equalsIgnoreCase(localCustomEmotionData.resid)) {
              return localCustomEmotionData;
            }
          }
        }
      }
    }
    return null;
  }
  
  public EmoticonInfo a()
  {
    return this.a;
  }
  
  public void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    paramBundle.putInt("cur_emotion_id", (int)a());
    if ((this.a instanceof CameraEmoticonInfo)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramBundle.putInt("cur_emotion_type", paramInt);
      return;
    }
  }
  
  public boolean a()
  {
    return this.a instanceof PicEmoticonInfo;
  }
  
  public boolean a(EmoticonPreviewData paramEmoticonPreviewData)
  {
    boolean bool = true;
    if ((paramEmoticonPreviewData instanceof FavEmoticonPreviewData))
    {
      paramEmoticonPreviewData = ((FavEmoticonPreviewData)paramEmoticonPreviewData).a;
      Object localObject;
      if (((paramEmoticonPreviewData instanceof FavoriteEmoticonInfo)) && ((this.a instanceof FavoriteEmoticonInfo)))
      {
        paramEmoticonPreviewData = ((FavoriteEmoticonInfo)paramEmoticonPreviewData).resID;
        localObject = ((FavoriteEmoticonInfo)this.a).resID;
        return (paramEmoticonPreviewData != null) && (paramEmoticonPreviewData.equals(localObject));
      }
      if (((paramEmoticonPreviewData instanceof PicEmoticonInfo)) && ((this.a instanceof PicEmoticonInfo)))
      {
        paramEmoticonPreviewData = ((PicEmoticonInfo)paramEmoticonPreviewData).emoticon;
        localObject = ((PicEmoticonInfo)this.a).emoticon;
        if ((paramEmoticonPreviewData != null) && (localObject != null) && (paramEmoticonPreviewData.eId != null) && (paramEmoticonPreviewData.eId.equals(((Emoticon)localObject).eId)) && (paramEmoticonPreviewData.epId != null) && (paramEmoticonPreviewData.epId.equals(((Emoticon)localObject).epId))) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    }
    return false;
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
        paramBundle = (QQAppInterface)paramBundle;
        if (i == 1) {}
        for (i = QQManagerFactory.CAMERA_EMOTION_DB_MANAGER;; i = QQManagerFactory.FAVROAMING_DB_MANAGER)
        {
          paramBundle = (CustomEmotionRoamingDBManagerBase)paramBundle.getManager(i);
          Object localObject = paramBundle.a();
          if ((localObject == null) || (((List)localObject).isEmpty())) {
            break;
          }
          localObject = ((List)localObject).iterator();
          CustomEmotionBase localCustomEmotionBase;
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localCustomEmotionBase = (CustomEmotionBase)((Iterator)localObject).next();
          } while (localCustomEmotionBase.emoId != j);
          return new FavEmoticonPreviewData(paramBundle.a(localCustomEmotionBase));
        }
      }
    }
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.FavEmoticonPreviewData
 * JD-Core Version:    0.7.0.1
 */