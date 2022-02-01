package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.Serializable;
import java.util.List;

final class PicEmoticonInfoSender$4
  implements Runnable
{
  PicEmoticonInfoSender$4(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, Parcelable paramParcelable, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if (this.val$app != null)
    {
      Object localObject1 = this.val$context;
      if (localObject1 != null)
      {
        localObject1 = new Intent((Context)localObject1, ((IEmosmService)QRoute.api(IEmosmService.class)).getH5MagicPlayerActivityClass());
        ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
        ((Intent)localObject1).putExtra("autoPlay", "1");
        ((Intent)localObject1).putExtra("senderUin", this.val$app.getCurrentAccountUin());
        ((Intent)localObject1).putExtra("selfUin", this.val$app.getCurrentAccountUin());
        ((Intent)localObject1).putExtra("sessionInfo", this.val$sessionInfo);
        ((Intent)localObject1).putExtra("emoticon", this.val$emoticon);
        Object localObject2 = (IEmoticonManagerService)this.val$app.getRuntimeService(IEmoticonManagerService.class);
        EmoticonPackage localEmoticonPackage = ((IEmoticonManagerService)localObject2).syncFindEmoticonPackageById(this.val$emoticon.epId);
        if (localEmoticonPackage != null)
        {
          localObject2 = ((IEmoticonManagerService)localObject2).syncGetSubEmoticonsByPackageId(localEmoticonPackage.childEpId);
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
          }
        }
        this.val$context.startActivity((Intent)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.4
 * JD-Core Version:    0.7.0.1
 */