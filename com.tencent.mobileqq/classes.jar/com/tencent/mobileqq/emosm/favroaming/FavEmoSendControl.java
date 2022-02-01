package com.tencent.mobileqq.emosm.favroaming;

import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emosm.control.EmoCaptureAsyncControl;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class FavEmoSendControl
{
  public static EmoCaptureAsyncControl a = new EmoCaptureAsyncControl();
  
  public static BaseQQAppInterface a()
  {
    return (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public static void a(List<String> paramList)
  {
    QLog.i("FavEmoSendControl", 1, "uploadCameraEmoList");
    Object localObject1 = a();
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)((BaseQQAppInterface)localObject1).getRuntimeService(IFavroamingDBManagerService.class);
    FavEmoRoamingHandler localFavEmoRoamingHandler = (FavEmoRoamingHandler)((BaseQQAppInterface)localObject1).getBusinessHandler(FavEmoRoamingHandler.a);
    localObject1 = ((BaseQQAppInterface)localObject1).getCurrentUin();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int k = 0;
    int j = 0;
    int i;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      List localList = localIFavroamingDBManagerService.getEmoticonDataList();
      Object localObject2 = localList.iterator();
      i = 1;
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (CustomEmotionData)((Iterator)localObject2).next();
        if (i < ((CustomEmotionData)localObject3).emoId) {
          i = ((CustomEmotionData)localObject3).emoId;
        }
      }
      CustomEmotionData localCustomEmotionData = new CustomEmotionData();
      localCustomEmotionData.uin = ((String)localObject1);
      localCustomEmotionData.emoId = (i + 1);
      localCustomEmotionData.emoOriginalPath = str1;
      localCustomEmotionData.RomaingType = "needUpload";
      if (!a(localCustomEmotionData.emoOriginalPath))
      {
        QLog.e("FavEmoSendControl", 1, new Object[] { "doStep, checkPicFavEnable false, path ", localCustomEmotionData.emoOriginalPath });
        localCustomEmotionData.emoPath = str1;
        localCustomEmotionData.RomaingType = "failed";
        localIFavroamingDBManagerService.insertCustomEmotion(localCustomEmotionData);
        k += 1;
        localFavEmoRoamingHandler.notifyUI(2, true, null);
        FavEmoSendControlConstant.a(false, 1, 0);
      }
      else
      {
        localObject2 = localCustomEmotionData.emoOriginalPath;
        if (b()) {
          localObject2 = b(localCustomEmotionData.emoOriginalPath);
        }
        String str2 = SecUtil.getFileMd5((String)localObject2);
        i = ((String)localObject2).lastIndexOf(".");
        if (i > 0) {
          localObject3 = ((String)localObject2).substring(i);
        } else {
          localObject3 = ".jpg";
        }
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(AppConstants.SDCARD_IMG_FAVORITE);
        ((StringBuilder)localObject4).append(DiySecureFileHelper.a((String)localObject1));
        ((StringBuilder)localObject4).append(str2);
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject3 = ((StringBuilder)localObject4).toString();
        boolean bool = FileUtils.copyFile((String)localObject2, (String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoSendControl", 2, new Object[] { "doStep, copyFile completed, result:", Boolean.valueOf(bool) });
        }
        if (!((String)localObject2).equals(localCustomEmotionData.emoOriginalPath)) {
          FileUtils.deleteFile((String)localObject2);
        }
        localObject2 = localList.iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (CustomEmotionData)((Iterator)localObject2).next();
          if ((!((String)localObject3).equals(((CustomEmotionData)localObject4).emoPath)) && (!str2.equals(((CustomEmotionData)localObject4).md5))) {
            break label586;
          }
          QLog.e("FavEmoSendControl", 1, new Object[] { "doStep fail, duplicate path, path:", ((CustomEmotionData)localObject4).emoPath });
          FavEmoSendControlConstant.a(false, 2, 0);
          if ("needDel".equals(((CustomEmotionData)localObject4).RomaingType))
          {
            localIFavroamingDBManagerService.updateDeletedEmoticon((CustomEmotionData)localObject4, localList.indexOf(localObject4));
            i = 1;
          }
          else
          {
            if (!"failed".equals(((CustomEmotionData)localObject4).RomaingType)) {
              break label589;
            }
            localIFavroamingDBManagerService.deleteCustomEmotion((CustomEmotionData)localObject4);
          }
          label586:
          continue;
          label589:
          j += 1;
          i = 1;
        }
        if (i == 0)
        {
          localCustomEmotionData.md5 = str2;
          localCustomEmotionData.emoPath = ((String)localObject3);
          localIFavroamingDBManagerService.insertCustomEmotion(localCustomEmotionData);
          localArrayList.add(localCustomEmotionData);
          if (paramList.indexOf(str1) % 4 == 3) {
            localFavEmoRoamingHandler.notifyUI(2, true, null);
          } else {}
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      localFavEmoRoamingHandler.notifyUI(2, true, null);
      QLog.d("FavEmoSendControl", 1, "doStep, insert completed");
      i = paramList.size();
      a.a(String.valueOf(1000), new Object[] { localArrayList, Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
      return;
    }
    new CameraEmoAllSend().a(paramList.size(), 0, 0, k, j);
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig localFavLocalEmoticonsConfig = (FavLocalEmoticonsProcessor.FavLocalEmoticonsConfig)QConfigManager.b().b(561);
      if (new File(paramString).length() >= localFavLocalEmoticonsConfig.a) {
        return false;
      }
      if (!BaseImageUtil.c(paramString))
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(paramString, localOptions);
        if (localOptions.outWidth < localFavLocalEmoticonsConfig.b)
        {
          int i = localOptions.outHeight;
          int j = localFavLocalEmoticonsConfig.b;
          if (i < j) {}
        }
        else
        {
          return false;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("FavEmoSendControl", 1, "checkPicFavEnable exception, ", paramString);
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramString, 0, -1);
    localCompressInfo.w = true;
    boolean bool = ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(localCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoSendControl", 2, new Object[] { "compressBeforeUpload, success: ", Boolean.valueOf(bool) });
    }
    if (bool) {
      paramString = localCompressInfo.l;
    }
    return paramString;
  }
  
  public static boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSendControl
 * JD-Core Version:    0.7.0.1
 */