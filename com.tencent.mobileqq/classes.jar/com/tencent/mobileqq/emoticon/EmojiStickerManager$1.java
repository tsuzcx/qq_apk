package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
    if ((localObject1 instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = ((List)((ArrayList)this.this$0.jdField_a_of_type_JavaUtilList).clone()).iterator();
      boolean bool1;
      Object localObject3;
      for (;;)
      {
        boolean bool2 = ((Iterator)localObject1).hasNext();
        bool1 = true;
        if (!bool2) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        localObject3 = EmojiStickerManager.a((MessageRecord)localObject2);
        if ((localObject3 != null) && (!((StickerInfo)localObject3).isDisplayed))
        {
          ((StickerInfo)localObject3).isDisplayed = true;
          EmojiStickerManager.a(localQQAppInterface, (MessageRecord)localObject2, (StickerInfo)localObject3);
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      if (localObject1 == null) {
        localObject1 = localQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        localObject3 = EmojiStickerManager.a((MessageRecord)localObject2);
        if ((localObject3 != null) && (((StickerInfo)localObject3).isShown)) {
          EmojiStickerManager.a(localQQAppInterface, (MessageRecord)localObject2, (StickerInfo)localObject3);
        }
      }
      Object localObject2 = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Bundle)((Iterator)localObject2).next();
        int i = ((Bundle)localObject3).getInt("sessionType");
        if (i == 1) {
          localObject1 = "2";
        } else if (i == 3000) {
          localObject1 = "3";
        } else {
          localObject1 = "1";
        }
        VasWebviewUtil.a("", "Stick", ((Bundle)localObject3).getString("key"), (String)localObject1, 1, 0, 0, null, ((Bundle)localObject3).getString("ext1"), ((Bundle)localObject3).getString("ext2"));
      }
      this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject1 = new File(EmojiStickerManager.a());
      if (((File)localObject1).exists())
      {
        localObject1 = ((File)localObject1).list();
        if ((localObject1 == null) || (localObject1.length <= 1)) {
          bool1 = false;
        }
        EmojiStickerManager.h = bool1;
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(EmojiStickerManager.a());
      ((StringBuilder)localObject1).append("emojiStickerGuideZip_v2.zip");
      VasUpdateUtil.a(localQQAppInterface, 1004L, "emojiStickerGuideZip_v2", ((StringBuilder)localObject1).toString(), true, null);
      EmojiStickerManager.h = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager.1
 * JD-Core Version:    0.7.0.1
 */