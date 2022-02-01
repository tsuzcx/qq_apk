package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;
import java.util.List;

class EmoticonFromGroupManager$5$1
  implements URLDrawable.URLDrawableListener
{
  EmoticonFromGroupManager$5$1(EmoticonFromGroupManager.5 param5, URLDrawable paramURLDrawable, CustomEmotionData paramCustomEmotionData, IFavroamingManagerService paramIFavroamingManagerService, IFavroamingDBManagerService paramIFavroamingDBManagerService) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.b(this.e.this$0).getUploadDrawableList().remove(this.a);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    EmoticonFromGroupManager.b(this.e.this$0).getUploadDrawableList().remove(this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmoticonFromGroupManager.b(this.e.this$0).getUploadDrawableList().remove(this.a);
    paramURLDrawable = this.e.this$0.d(this.a.getURL().toString());
    if (this.e.this$0.a(paramURLDrawable)) {
      return;
    }
    String str = EmoticonFromGroupManager.a(this.e.this$0, paramURLDrawable);
    if (!"".equals(str))
    {
      Object localObject = this.b;
      ((CustomEmotionData)localObject).emoPath = str;
      ((CustomEmotionData)localObject).md5 = paramURLDrawable;
      if (!"".equals(str)) {
        try
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onLoadSuccessed upload emo ");
            ((StringBuilder)localObject).append(paramURLDrawable);
            QLog.i("EmoticonFromGroup_Manager", 4, ((StringBuilder)localObject).toString());
          }
          this.a.saveTo(str);
          this.c.syncUpload(this.b);
          this.d.insertCustomEmotion(this.b);
          return;
        }
        catch (IOException paramURLDrawable)
        {
          paramURLDrawable.printStackTrace();
          QLog.d("EmoticonFromGroup_Manager", 1, paramURLDrawable, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.5.1
 * JD-Core Version:    0.7.0.1
 */