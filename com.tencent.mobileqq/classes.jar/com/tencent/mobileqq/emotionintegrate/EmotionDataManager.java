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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 3;
  private long jdField_b_of_type_Long = 9223372036854775807L;
  private int jdField_c_of_type_Int = 60;
  private long jdField_c_of_type_Long = 9223372036854775807L;
  
  public EmotionDataManager(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime());
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
      paramEmotionPreviewData.c = true;
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
        paramEmotionPreviewData.c = true;
        return paramContext;
      }
      localObject2 = PicItemBuilder.a((MessageForPic)localObject1);
      paramContext = URLDrawable.getDrawable((URL)localObject2, a(paramContext, ((MessageForPic)localObject1).thumbWidth, ((MessageForPic)localObject1).thumbHeight));
      paramEmotionPreviewData.c = false;
      localObject1 = paramContext;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionDataManager", 2, new Object[] { "init view,big pic not exist:", AbsDownloader.getFile(((URL)localObject2).toString()) });
        localObject1 = paramContext;
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
      if (((MessageRecord)localObject1).shmsgseq < this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = ((MessageRecord)localObject1).shmsgseq;
      }
      if (((MessageRecord)localObject1).versionCode < this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = ((MessageRecord)localObject1).versionCode;
      }
      if ((((MessageRecord)localObject1).getId() > 0L) && (((MessageRecord)localObject1).getId() < this.jdField_a_of_type_Long)) {
        this.jdField_a_of_type_Long = ((MessageRecord)localObject1).getId();
      }
      if (((MessageRecord)localObject1).time < this.jdField_c_of_type_Long) {
        this.jdField_c_of_type_Long = ((MessageRecord)localObject1).time;
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.jdField_b_of_type_Long = 9223372036854775807L;
    this.jdField_b_of_type_Int = 3;
    this.jdField_c_of_type_Long = 9223372036854775807L;
    this.jdField_c_of_type_Int = 60;
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, -1L);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    label533:
    label536:
    label539:
    for (;;)
    {
      Object localObject2;
      try
      {
        if ((paramString.equals(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == paramInt))
        {
          if (paramBoolean) {
            a();
          }
          if (this.jdField_c_of_type_Int < 60) {
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
            paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy();
            if (paramString != null) {
              ((List)localObject2).addAll(a(paramString.a(paramLong)));
            }
            if (!QLog.isColorLevel()) {
              break label533;
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
          if (!this.jdField_a_of_type_Boolean)
          {
            List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt, arrayOfInt);
            localObject2 = localList;
            if (localList.size() >= 60) {
              break label536;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt, arrayOfInt, 60);
            this.jdField_c_of_type_Int = ((List)localObject2).size();
            break label536;
          }
          int i;
          long l2;
          if (UinTypeUtil.g(paramInt))
          {
            this.jdField_b_of_type_Long -= 1L;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
            paramLong = this.jdField_a_of_type_Long;
            i = this.jdField_b_of_type_Int;
            l2 = this.jdField_b_of_type_Long;
          }
          try
          {
            localObject2 = ((QQMessageFacade)localObject2).a(paramString, paramInt, paramLong, i, l2, arrayOfInt, 60);
            continue;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_c_of_type_Long, arrayOfInt, 60);
            this.jdField_c_of_type_Int = ((List)localObject2).size();
            if (!this.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_Boolean = true;
            }
            localObject1.addAll(0, a((List)localObject2));
            if (localObject1.size() < 30) {
              if (this.jdField_c_of_type_Int >= 60) {
                break label539;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataManager
 * JD-Core Version:    0.7.0.1
 */