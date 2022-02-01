package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

final class EmojiStickerManager$2
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, start");
    }
    Object localObject1 = EmojiStickerManager.a();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("extractStickerMaterial, rootPath = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists())
    {
      localObject2 = ((File)localObject2).list();
      if ((localObject2 != null) && (localObject2.length > 1))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("extractStickerMaterial, list.length =  ");
          ((StringBuilder)localObject1).append(localObject2.length);
          QLog.i("EmojiStickerManager", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmojiStickerManager", 2, "extractStickerMaterial, need to extract  ");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("emojiStickerGuideZip_v2");
      ((StringBuilder)localObject2).append(".zip");
      localObject2 = ((StringBuilder)localObject2).toString();
      try
      {
        FileUtils.uncompressZip((String)localObject2, (String)localObject1, false);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("extractStickerMaterial uncompressZip error = ");
        ((StringBuilder)localObject2).append(localOutOfMemoryError);
        QLog.e("EmojiStickerManager", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      catch (IOException localIOException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("extractStickerMaterial uncompressZip error = ");
        ((StringBuilder)localObject2).append(localIOException);
        QLog.e("EmojiStickerManager", 1, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiStickerManager.2
 * JD-Core Version:    0.7.0.1
 */