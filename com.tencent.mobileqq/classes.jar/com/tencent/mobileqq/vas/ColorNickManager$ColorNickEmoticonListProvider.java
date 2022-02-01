package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColorNickManager$ColorNickEmoticonListProvider
  implements EmoticonListProvider
{
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ColorNickManager$ColorNickEmoticonListProvider(ColorNickManager paramColorNickManager) {}
  
  public void a(List<Integer> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramList);
    }
  }
  
  public List<EmotionPanelInfo> getEmotionPanelInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new EmotionPanelInfo(7, 7, null));
    IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqVasColorNickManager).getRuntimeService(IEmoticonManagerService.class);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      Object localObject = localIEmoticonManagerService.syncFindEmoticonPackageById(String.valueOf(i));
      if (localObject != null)
      {
        localArrayList.add(new EmotionPanelInfo(10, 7, (EmoticonPackage)localObject));
      }
      else
      {
        localObject = new EmoticonPackage();
        ((EmoticonPackage)localObject).epId = String.valueOf(i);
        ((EmoticonPackage)localObject).wordingId = -1L;
        ((EmoticonPackage)localObject).jobType = 4;
        ((EmoticonPackage)localObject).isMagicFaceDownloading = false;
        ((EmoticonPackage)localObject).valid = true;
        ((EmoticonPackage)localObject).status = 0;
        ((EmoticonPackage)localObject).aio = true;
        localIEmoticonManagerService.saveEmoticonPackage((EmoticonPackage)localObject);
        localObject = (IEmojiManagerService)ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqVasColorNickManager).getRuntimeService(IEmojiManagerService.class);
        ((IEmojiManagerService)localObject).getEmojiListenerManager().addEmotionJsonDownloadListener(ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqVasColorNickManager));
        ((IEmojiManagerService)localObject).startDownloadEmosmJson(String.valueOf(i), EmojiManagerServiceConstant.JSON_EMOSM_MALL, null, true, 0);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickManager.ColorNickEmoticonListProvider
 * JD-Core Version:    0.7.0.1
 */