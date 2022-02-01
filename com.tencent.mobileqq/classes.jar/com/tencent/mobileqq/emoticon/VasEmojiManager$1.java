package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

class VasEmojiManager$1
  implements Runnable
{
  VasEmojiManager$1(VasEmojiManager paramVasEmojiManager, String paramString, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    boolean bool = new File(VasEmojiManagerContstant.getSavePath(this.a)).exists();
    int i = 1;
    if ((!bool) || (!((IEmojiManagerService)localObject).isH5MagicFacePackageIntact(this.b.epId, true, false)))
    {
      localObject = (IVasQuickUpdateService)this.this$0.a.getRuntimeService(IVasQuickUpdateService.class, "");
      if (localObject != null)
      {
        ((IEmojiManagerService)this.this$0.a.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager().notifyPackageStart(this.b);
        ((IVasQuickUpdateService)localObject).downloadItem(1004L, this.a, "VasEmojiManager");
        break label121;
      }
    }
    i = 0;
    label121:
    if (i == 0)
    {
      localObject = this.this$0.a();
      ((IEmojiManagerService)localObject).getStatusMap().remove(this.b.epId);
      ((IEmojiManagerService)localObject).handleEmoticonPackageDownloaded((Bundle)this.this$0.c.remove(this.b.epId), null, false, 0, "nomatch", 0L, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.VasEmojiManager.1
 * JD-Core Version:    0.7.0.1
 */