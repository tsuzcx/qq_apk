package com.tencent.mobileqq.emosm.favroaming;

import arrc;
import arre;
import arri;
import arro;
import arrp;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EmoticonFromGroupManager$5
  implements Runnable
{
  public EmoticonFromGroupManager$5(arre paramarre, List paramList) {}
  
  public void run()
  {
    arro localarro = (arro)arre.a(this.this$0).getManager(149);
    arrp localarrp = (arrp)arre.a(this.this$0).getManager(103);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "Call getEmoticonDataList from onUploadPic.");
    }
    Object localObject1 = localarro.a();
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
      ((CustomEmotionData)localObject1).uin = arre.a(this.this$0).c();
      j += 1;
      ((CustomEmotionData)localObject1).emoId = j;
      localArrayList.add(localObject1);
    }
    j = localArrayList.size();
    i = 0;
    Object localObject2;
    URLDrawable localURLDrawable;
    for (;;)
    {
      if (i < j)
      {
        localObject2 = (EmoticonFromGroupEntity)this.a.get(i);
        localObject1 = (CustomEmotionData)localArrayList.get(i);
        i += 1;
        localURLDrawable = (URLDrawable)this.this$0.a((EmoticonFromGroupEntity)localObject2, 1, -1, null);
        if (localURLDrawable == null)
        {
          QLog.e("EmoticonFromGroup_Manager", 1, "get drawable failed: " + localObject2);
        }
        else if (1 != localURLDrawable.getStatus())
        {
          arre.a(this.this$0).a.add(localURLDrawable);
          localURLDrawable.setURLDrawableListener(new arri(this, localURLDrawable, (CustomEmotionData)localObject1, localarrp, localarro));
          localURLDrawable.startDownload();
        }
      }
    }
    for (;;)
    {
      break;
      localObject2 = this.this$0.a(localURLDrawable.getURL().toString());
      if (this.this$0.a((String)localObject2)) {
        return;
      }
      String str = arre.a(this.this$0, (String)localObject2);
      if (!"".equals(str))
      {
        ((CustomEmotionData)localObject1).emoPath = str;
        ((CustomEmotionData)localObject1).md5 = ((String)localObject2);
        if (!"".equals(str)) {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonFromGroup_Manager", 4, "normal upload emo " + (String)localObject2);
            }
            localURLDrawable.saveTo(str);
            localarrp.d((CustomEmotionData)localObject1);
            localarro.c((CustomEmotionBase)localObject1);
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            QLog.d("EmoticonFromGroup_Manager", 1, localIOException, new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.5
 * JD-Core Version:    0.7.0.1
 */