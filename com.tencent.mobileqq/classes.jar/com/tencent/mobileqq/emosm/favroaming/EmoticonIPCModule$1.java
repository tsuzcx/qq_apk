package com.tencent.mobileqq.emosm.favroaming;

import android.os.Bundle;
import eipc.EIPCResult;

class EmoticonIPCModule$1
  implements Runnable
{
  EmoticonIPCModule$1(EmoticonIPCModule paramEmoticonIPCModule, Bundle paramBundle, String paramString, EmoticonFromGroupManager paramEmoticonFromGroupManager, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.a.getString("pic_md5");
    if ("action_group_emo_big_pic_add_fav".equals(this.b))
    {
      if (!this.c.c((String)localObject))
      {
        localObject = EIPCResult.createResult(-102, null);
        this.this$0.callbackResult(this.d, (EIPCResult)localObject);
      }
    }
    else if ("action_group_emo_big_pic_upload_wy".equals(this.b)) {
      this.c.b((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule.1
 * JD-Core Version:    0.7.0.1
 */