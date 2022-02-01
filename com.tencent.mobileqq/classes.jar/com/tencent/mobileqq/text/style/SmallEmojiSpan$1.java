package com.tencent.mobileqq.text.style;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmotionJsonUtils;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;

class SmallEmojiSpan$1
  implements Runnable
{
  SmallEmojiSpan$1(SmallEmojiSpan paramSmallEmojiSpan) {}
  
  public void run()
  {
    Object localObject2 = EmotionPanelConstans.emoticonJsonFilePath.replace("[epId]", Integer.toString(this.this$0.b));
    boolean bool = FileUtils.fileExists((String)localObject2);
    ArrayList localArrayList = null;
    try
    {
      AppInterface localAppInterface1 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
    }
    AppInterface localAppInterface2 = null;
    if (localAppInterface2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "appInterface is null. return");
      }
      return;
    }
    if (bool)
    {
      localObject3 = EmoticonPanelUtils.d();
      if (localObject3 != null) {
        localObject1 = ((IEmoticonManagerService)localObject3).syncFindEmoticonById(Integer.toString(this.this$0.b), Integer.toString(this.this$0.c));
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = ((IEmoticonManagerService)localObject3).syncFindEmoticonPackageById(Integer.toString(this.this$0.b));
        if ((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 0))
        {
          localArrayList = new ArrayList();
          localObject2 = FileUtils.fileToBytes(new File((String)localObject2));
          EmotionJsonUtils.parseSmallJson(localAppInterface2, (EmoticonPackage)localObject1, EmojiManagerServiceConstant.JSON_EMOSM_MALL, (byte[])localObject2, localArrayList);
        }
        this.this$0.a((EmoticonPackage)localObject1);
        return;
      }
    }
    Object localObject1 = EmotionPanelConstans.smallEmoticonJsonUrl.replace("[epId]", Integer.toString(this.this$0.b));
    localObject2 = new File((String)localObject2);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("small emoji json not exist. epId:");
      ((StringBuilder)localObject3).append(this.this$0.b);
      ((StringBuilder)localObject3).append(",downloadUrl:");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d("QQText", 2, ((StringBuilder)localObject3).toString());
    }
    localObject1 = new DownloadTask((String)localObject1, (File)localObject2);
    ((DownloadTask)localObject1).D = true;
    int i = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download((DownloadTask)localObject1, localAppInterface2);
    Object localObject3 = new EmoticonPackage();
    ((EmoticonPackage)localObject3).epId = Integer.toString(this.this$0.b);
    ((EmoticonPackage)localObject3).jobType = 4;
    if (i == 0)
    {
      localObject1 = localArrayList;
      if (((File)localObject2).exists()) {
        localObject1 = FileUtils.fileToBytes((File)localObject2);
      }
      localArrayList = new ArrayList();
      EmotionJsonUtils.parseSmallJson(localAppInterface2, (EmoticonPackage)localObject3, EmojiManagerServiceConstant.JSON_EMOSM_MALL, (byte[])localObject1, localArrayList);
      this.this$0.a((EmoticonPackage)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.SmallEmojiSpan.1
 * JD-Core Version:    0.7.0.1
 */