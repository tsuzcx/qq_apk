package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class EmoticonFromGroupManager$5
  implements Runnable
{
  EmoticonFromGroupManager$5(EmoticonFromGroupManager paramEmoticonFromGroupManager, List paramList) {}
  
  public void run()
  {
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)EmoticonFromGroupManager.c(this.this$0).getRuntimeService(IFavroamingDBManagerService.class);
    IFavroamingManagerService localIFavroamingManagerService = (IFavroamingManagerService)EmoticonFromGroupManager.c(this.this$0).getRuntimeService(IFavroamingManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "Call getEmoticonDataList from onUploadPic.");
    }
    Object localObject1 = localIFavroamingDBManagerService.getEmoticonDataList();
    ArrayList localArrayList = new ArrayList(30);
    if (localObject1 != null)
    {
      int k = 0;
      for (i = 1;; i = j)
      {
        j = i;
        if (k >= ((List)localObject1).size()) {
          break;
        }
        int m = ((CustomEmotionData)((List)localObject1).get(k)).emoId;
        j = i;
        if (i < m) {
          j = m;
        }
        k += 1;
      }
    }
    int j = 1;
    int i = this.a.size();
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      localObject1 = new CustomEmotionData();
      ((CustomEmotionData)localObject1).uin = EmoticonFromGroupManager.c(this.this$0).getCurrentUin();
      j += 1;
      ((CustomEmotionData)localObject1).emoId = j;
      localArrayList.add(localObject1);
    }
    j = localArrayList.size();
    i = 0;
    while (i < j)
    {
      Object localObject2 = (EmoticonFromGroupEntity)this.a.get(i);
      localObject1 = (CustomEmotionData)localArrayList.get(i);
      URLDrawable localURLDrawable = (URLDrawable)this.this$0.a((EmoticonFromGroupEntity)localObject2, 1, -1, null);
      if (localURLDrawable == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("get drawable failed: ");
        ((StringBuilder)localObject1).append(localObject2);
        QLog.e("EmoticonFromGroup_Manager", 1, ((StringBuilder)localObject1).toString());
      }
      else if (1 != localURLDrawable.getStatus())
      {
        EmoticonFromGroupManager.b(this.this$0).getUploadDrawableList().add(localURLDrawable);
        localURLDrawable.setURLDrawableListener(new EmoticonFromGroupManager.5.1(this, localURLDrawable, (CustomEmotionData)localObject1, localIFavroamingManagerService, localIFavroamingDBManagerService));
        localURLDrawable.startDownload();
      }
      else
      {
        localObject2 = this.this$0.d(localURLDrawable.getURL().toString());
        if (this.this$0.a((String)localObject2)) {
          return;
        }
        String str = EmoticonFromGroupManager.a(this.this$0, (String)localObject2);
        if (!"".equals(str))
        {
          ((CustomEmotionData)localObject1).emoPath = str;
          ((CustomEmotionData)localObject1).md5 = ((String)localObject2);
          if (!"".equals(str)) {
            try
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("normal upload emo ");
                localStringBuilder.append((String)localObject2);
                QLog.i("EmoticonFromGroup_Manager", 4, localStringBuilder.toString());
              }
              localURLDrawable.saveTo(str);
              localIFavroamingManagerService.syncUpload((CustomEmotionData)localObject1);
              localIFavroamingDBManagerService.insertCustomEmotion((CustomEmotionData)localObject1);
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
              QLog.d("EmoticonFromGroup_Manager", 1, localIOException, new Object[0]);
            }
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.5
 * JD-Core Version:    0.7.0.1
 */