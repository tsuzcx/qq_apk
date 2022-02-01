package com.tencent.mobileqq.emotionintegrate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmotionDataManager
{
  private String a;
  private int b;
  private volatile boolean c;
  private long d = 9223372036854775807L;
  private long e = 9223372036854775807L;
  private int f = 3;
  private long g = 9223372036854775807L;
  private int h = 60;
  private QQAppInterface i;
  
  public EmotionDataManager(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
    this.i = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
  }
  
  public static Drawable a(Context paramContext, EmotionPreviewData paramEmotionPreviewData)
  {
    MessageRecord localMessageRecord = paramEmotionPreviewData.a;
    boolean bool = localMessageRecord instanceof MessageForMarketFace;
    Object localObject2 = null;
    Object localObject1 = null;
    if (bool)
    {
      localObject2 = a((MessageForMarketFace)localMessageRecord);
      paramContext = (Context)localObject1;
      if (localObject2 != null) {
        paramContext = ((IPicEmoticonInfo)localObject2).getLoadingDrawable("fromAIO", true);
      }
      paramEmotionPreviewData.d = true;
      return paramContext;
    }
    localObject1 = localObject2;
    if ((localMessageRecord instanceof MessageForPic))
    {
      localObject1 = (MessageForPic)localMessageRecord;
      localObject2 = URLDrawableHelper.getURL((PicUiInterface)localObject1, 1);
      if (AbsDownloader.getFile(((URL)localObject2).toString()) != null)
      {
        paramContext = URLDrawable.getDrawable((URL)localObject2, a(paramContext, (int)((MessageForPic)localObject1).width, (int)((MessageForPic)localObject1).height));
        paramEmotionPreviewData.d = true;
        return paramContext;
      }
      localObject2 = PicItemBuilder.f((MessageForPic)localObject1);
      int k = ((MessageForPic)localObject1).thumbWidth;
      int j = ((MessageForPic)localObject1).thumbHeight;
      if (localMessageRecord.istroop == 10014)
      {
        k = ((com.tencent.mobileqq.guild.pic.api.IGuildPicAIO)QRoute.api(com.tencent.mobileqq.guild.pic.api.IGuildPicAIO.class)).getThumbMinDp(true)[0];
        j = ((com.tencent.mobileqq.guild.pic.api.IGuildPicAIO)QRoute.api(com.tencent.mobileqq.guild.pic.api.IGuildPicAIO.class)).getThumbMinDp(true)[1];
      }
      localObject1 = URLDrawable.getDrawable((URL)localObject2, a(paramContext, k, j));
      paramEmotionPreviewData.d = false;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionDataManager", 2, new Object[] { "init view,big pic not exist:", AbsDownloader.getFile(((URL)localObject2).toString()) });
      }
    }
    return localObject1;
  }
  
  private static URLDrawable.URLDrawableOptions a(Context paramContext, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mMemoryCacheKeySuffix = "AIOEmotionFragment";
    localURLDrawableOptions.mRequestWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    localURLDrawableOptions.mRequestHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
    localURLDrawableOptions.mLoadingDrawable = new EmptyDrawable(paramInt1, paramInt2);
    return localURLDrawableOptions;
  }
  
  public static EmoticonPackage a(String paramString)
  {
    return ((IEmoticonManagerService)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramString);
  }
  
  public static IPicEmoticonInfo a(MessageForMarketFace paramMessageForMarketFace)
  {
    return (IPicEmoticonInfo)((IEmoticonManagerService)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getRuntimeService(IEmoticonManagerService.class)).syncGetEmoticonInfo(paramMessageForMarketFace.mMarkFaceMessage);
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (MessageRecord)paramList.next();
      if (((MessageRecord)localObject1).shmsgseq < this.e) {
        this.e = ((MessageRecord)localObject1).shmsgseq;
      }
      if (((MessageRecord)localObject1).versionCode < this.f) {
        this.f = ((MessageRecord)localObject1).versionCode;
      }
      if ((((MessageRecord)localObject1).getId() > 0L) && (((MessageRecord)localObject1).getId() < this.d)) {
        this.d = ((MessageRecord)localObject1).getId();
      }
      if (((MessageRecord)localObject1).time < this.g) {
        this.g = ((MessageRecord)localObject1).time;
      }
      Object localObject2;
      if ((localObject1 instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)localObject1;
        ((MessageForPic)localObject2).parse();
        if ((!a((MessageForPic)localObject2)) && (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject2))) {
          localArrayList.add(localObject1);
        }
      }
      else if ((localObject1 instanceof MessageForMarketFace))
      {
        localArrayList.add(localObject1);
      }
      else if ((localObject1 instanceof MessageForMixedMsg))
      {
        localObject1 = (MessageForMixedMsg)localObject1;
        if (((MessageForMixedMsg)localObject1).msgElemList != null)
        {
          localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((localObject2 instanceof MessageForPic))
            {
              localObject2 = (MessageForPic)localObject2;
              ((MessageForPic)localObject2).parse();
              if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject2)) {
                localArrayList.add(localObject2);
              }
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void a()
  {
    this.c = false;
    this.d = 9223372036854775807L;
    this.e = 9223372036854775807L;
    this.f = 3;
    this.g = 9223372036854775807L;
    this.h = 60;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, -1L);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    label543:
    label546:
    label549:
    for (;;)
    {
      Object localObject2;
      try
      {
        if ((paramString.equals(this.a)) && (this.b == paramInt))
        {
          if (paramBoolean) {
            a();
          }
          if (this.h < 60) {
            return null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("EmotionDataManager", 2, "getEmotionDataIncremental start");
          }
          long l1 = System.currentTimeMillis();
          localObject2 = new ArrayList();
          str = "getEmotionDataIncremental end, tempList.size: ";
          paramBoolean = false;
          Object localObject1 = localObject2;
          if (paramLong != -1L)
          {
            paramString = this.i.getMultiMessageProxy();
            if (paramString != null) {
              ((List)localObject2).addAll(a(paramString.a(paramLong)));
            }
            if (!QLog.isColorLevel()) {
              break label543;
            }
            paramInt = ((List)localObject2).size();
            if (paramString == null) {
              paramBoolean = true;
            }
            QLog.d("EmotionDataManager", 2, new Object[] { "getEmotionDataIncremental end, tempList.size: ", Integer.valueOf(paramInt), "  ", Boolean.valueOf(paramBoolean) });
            return localObject2;
          }
          int[] arrayOfInt = new int[4];
          arrayOfInt[0] = -2007;
          arrayOfInt[1] = -20000;
          arrayOfInt[2] = -2000;
          arrayOfInt[3] = -1035;
          if (!this.c)
          {
            List localList = this.i.getMessageProxy(paramInt).a(paramString, paramInt, arrayOfInt);
            localObject2 = localList;
            if (localList.size() >= 60) {
              break label546;
            }
            localObject2 = this.i.getMessageFacade().a(paramString, paramInt, arrayOfInt, 60);
            this.h = ((List)localObject2).size();
            break label546;
          }
          int j;
          long l2;
          if ((!UinTypeUtil.h(paramInt)) && (paramInt != 10014))
          {
            localObject2 = this.i.getMessageFacade();
            paramLong = this.d;
            j = this.f;
            l2 = this.g;
          }
          try
          {
            localObject2 = ((QQMessageFacade)localObject2).a(paramString, paramInt, paramLong, j, l2, arrayOfInt, 60);
            continue;
            this.e -= 1L;
            localObject2 = this.i.getMessageFacade().a(paramString, paramInt, this.d, this.f, this.e, arrayOfInt, 60);
            this.h = ((List)localObject2).size();
            if (!this.c) {
              this.c = true;
            }
            localObject1.addAll(0, a((List)localObject2));
            if (localObject1.size() < 30) {
              if (this.h >= 60) {
                break label549;
              }
            }
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append(str);
              paramString.append(localObject1.size());
              paramString.append(", cost:");
              paramString.append(System.currentTimeMillis() - l1);
              QLog.d("EmotionDataManager", 2, paramString.toString());
            }
            return localObject1;
          }
          catch (OutOfMemoryError paramString)
          {
            str = null;
          }
        }
        else
        {
          return null;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        String str = null;
        QLog.e("EmotionDataManager", 2, "out of memory", paramString);
        return str;
      }
      return localObject2;
    }
  }
  
  public boolean a(MessageForPic paramMessageForPic)
  {
    return ZhituManager.a(paramMessageForPic);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataManager
 * JD-Core Version:    0.7.0.1
 */