package com.tencent.ttpic.openapi.cache;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.factory.TTPicFilterFactoryLocal;
import java.io.File;
import java.util.Map;

class VideoMemoryManager$2
  implements Runnable
{
  VideoMemoryManager$2(VideoMemoryManager paramVideoMemoryManager, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = this.val$externalDir;
    Object localObject = str;
    if (str == null) {
      localObject = this.val$assertsDir;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.val$resource);
    localObject = localStringBuilder.toString();
    if (this.val$encrypted) {
      localObject = TTPicFilterFactoryLocal.getBitmapFromEncryptedFile((String)localObject);
    } else {
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, 1);
    }
    if (localObject != null)
    {
      if ((VideoMemoryManager.access$800(this.this$0).containsKey(this.val$resource)) && (BitmapUtils.isLegal((Bitmap)VideoMemoryManager.access$800(this.this$0).get(this.val$resource))))
      {
        ((Bitmap)localObject).recycle();
        return;
      }
      VideoMemoryManager.access$800(this.this$0).put(this.val$resource, localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.VideoMemoryManager.2
 * JD-Core Version:    0.7.0.1
 */