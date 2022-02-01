package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmojiStickerManager$1
  implements Runnable
{
  EmojiStickerManager$1(EmojiStickerManager paramEmojiStickerManager, List paramList, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    if ((localObject1 instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = ((List)((ArrayList)this.this$0.jdField_a_of_type_JavaUtilList).clone()).iterator();
      Object localObject3;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        localObject3 = EmojiStickerManager.a((MessageRecord)localObject2);
        if ((localObject3 != null) && (!((EmojiStickerManager.StickerInfo)localObject3).isDisplayed))
        {
          ((EmojiStickerManager.StickerInfo)localObject3).isDisplayed = true;
          EmojiStickerManager.a(localQQAppInterface, (MessageRecord)localObject2, (EmojiStickerManager.StickerInfo)localObject3);
        }
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      for (localObject1 = this.jdField_a_of_type_JavaUtilList;; localObject1 = localQQAppInterface.getMessageFacade().getAIOList(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          localObject3 = EmojiStickerManager.a((MessageRecord)localObject2);
          if ((localObject3 != null) && (((EmojiStickerManager.StickerInfo)localObject3).isShown)) {
            EmojiStickerManager.a(localQQAppInterface, (MessageRecord)localObject2, (EmojiStickerManager.StickerInfo)localObject3);
          }
        }
      }
      Object localObject2 = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Bundle)((Iterator)localObject2).next();
        int i = ((Bundle)localObject3).getInt("sessionType");
        localObject1 = "1";
        if (i == 1) {
          localObject1 = "2";
        }
        for (;;)
        {
          VasWebviewUtil.reportCommercialDrainage("", "Stick", ((Bundle)localObject3).getString("key"), (String)localObject1, 1, 0, 0, null, ((Bundle)localObject3).getString("ext1"), ((Bundle)localObject3).getString("ext2"));
          break;
          if (i == 3000) {
            localObject1 = "3";
          }
        }
      }
      this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject1 = new File(EmojiStickerManager.a());
      if (!((File)localObject1).exists()) {
        break label352;
      }
      localObject1 = ((File)localObject1).list();
      if ((localObject1 == null) || (localObject1.length <= 1)) {
        break label347;
      }
    }
    label347:
    for (boolean bool = true;; bool = false)
    {
      EmojiStickerManager.g = bool;
      return;
    }
    label352:
    VasQuickUpdateManager.getFileFromLocal(localQQAppInterface, 1004L, "emojiStickerGuideZip_v2", EmojiStickerManager.a() + "emojiStickerGuideZip_v2.zip", true, null);
    EmojiStickerManager.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager.1
 * JD-Core Version:    0.7.0.1
 */