package com.tencent.mobileqq.magicface.drawable;

import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PngFrameManager$4
  implements Runnable
{
  PngFrameManager$4(PngFrameManager paramPngFrameManager, PngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func showPngFrame, zip NOT exist, download from Server.");
    }
    Object localObject3 = (EmoticonManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
    Object localObject2 = ((EmoticonManager)localObject3).a(this.a.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = this.a.jdField_a_of_type_JavaLangString;
      ((EmoticonPackage)localObject1).aio = true;
    }
    ((EmoticonPackage)localObject1).rscType = 1;
    ((EmoticonManager)localObject3).a((EmoticonPackage)localObject1);
    String str = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.a.emoticon.eId;
    localObject2 = EmoticonUtils.emoticonPNGZIPUrl.replace("[eIdSub]", str.substring(0, 2)).replace("[eId]", str);
    localObject1 = EmoticonUtils.emoticonEncryptPath.replace("[epId]", this.a.jdField_a_of_type_JavaLangString).replace("[eId]", str);
    localObject3 = EmoticonUtils.emoticonAIOPreviewExtensionUrl.replace("[eIdSub]", str.substring(0, 2)).replace("[eId]", str).replace("[width]", "200").replace("[height]", "200");
    str = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", this.a.jdField_a_of_type_JavaLangString).replace("[eId]", str);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    localArrayList.add(localObject2);
    localHashMap.put(localObject2, new File((String)localObject1));
    localArrayList.add(localObject3);
    localHashMap.put(localObject3, new File(str));
    localObject2 = new DownloadTask(localArrayList, localHashMap, "random_magicface_" + this.a.jdField_a_of_type_JavaLangString);
    ((DownloadTask)localObject2).n = true;
    this.this$0.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)localObject2, new PngFrameManager.4.1(this, (String)localObject1), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager.4
 * JD-Core Version:    0.7.0.1
 */