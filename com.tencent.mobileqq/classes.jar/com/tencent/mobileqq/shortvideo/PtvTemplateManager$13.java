package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class PtvTemplateManager$13
  implements Runnable
{
  PtvTemplateManager$13(PtvTemplateManager paramPtvTemplateManager) {}
  
  public void run()
  {
    if (PtvTemplateManager.f == null) {
      return;
    }
    File[] arrayOfFile = PtvTemplateManager.f.listFiles();
    if (arrayOfFile != null)
    {
      if (arrayOfFile.length == 0) {
        return;
      }
      int k = arrayOfFile.length;
      int i = 0;
      while (i < k)
      {
        File localFile = arrayOfFile[i];
        if ((localFile != null) && (localFile.isFile()))
        {
          Object localObject = localFile.getName();
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).contains(".")))
          {
            localObject = this.this$0.l.doodleInfos.iterator();
            while (((Iterator)localObject).hasNext())
            {
              PtvTemplateManager.DoodleInfo localDoodleInfo = (PtvTemplateManager.DoodleInfo)((Iterator)localObject).next();
              if ((localDoodleInfo != null) && (!TextUtils.isEmpty(localDoodleInfo.doodleName)) && (localFile.getName().equalsIgnoreCase(localDoodleInfo.doodleName)))
              {
                j = 1;
                break label167;
              }
            }
            int j = 0;
            label167:
            if (j == 0)
            {
              localFile.deleteOnExit();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(PtvTemplateManager.d);
              ((StringBuilder)localObject).append(localFile.getName());
              new File(((StringBuilder)localObject).toString()).deleteOnExit();
            }
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.13
 * JD-Core Version:    0.7.0.1
 */