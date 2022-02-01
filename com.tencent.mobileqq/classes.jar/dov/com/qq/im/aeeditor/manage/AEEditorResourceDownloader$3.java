package dov.com.qq.im.aeeditor.manage;

import bnrh;
import bnuu;
import bnuw;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class AEEditorResourceDownloader$3
  implements Runnable
{
  public AEEditorResourceDownloader$3(bnuu parambnuu) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    bnrh.b(this.this$0.c, "preDownloadAllRes---BEGIN");
    this.this$0.c();
    bnrh.b(this.this$0.c, "preDownloadAllRes---ensureSetupDownloadConfig finish");
    ArrayList localArrayList = new ArrayList();
    this.this$0.a(localArrayList);
    Object localObject = this.this$0.jdField_a_of_type_JavaUtilMap.values().iterator();
    AEEditorDownloadResBean localAEEditorDownloadResBean;
    while (((Iterator)localObject).hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)((Iterator)localObject).next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!this.this$0.a(localAEEditorDownloadResBean))) {
        localArrayList.add(localAEEditorDownloadResBean);
      }
    }
    this.this$0.b(localArrayList);
    bnrh.b(this.this$0.c, "preDownloadAllRes---needDownloads size=" + localArrayList.size());
    int i = 0;
    for (;;)
    {
      if (i < localArrayList.size())
      {
        int k = Math.min(this.this$0.jdField_a_of_type_Int, localArrayList.size() - i);
        localObject = new CountDownLatch(k);
        int j = 0;
        while (j < k)
        {
          localAEEditorDownloadResBean = (AEEditorDownloadResBean)localArrayList.get(i);
          bnrh.b(this.this$0.c, "preDownloadAllRes---[begin] " + i + ", id=" + localAEEditorDownloadResBean.getId());
          this.this$0.a(localAEEditorDownloadResBean, new bnuw(this, i, localAEEditorDownloadResBean, (CountDownLatch)localObject));
          j += 1;
          i += 1;
        }
        try
        {
          ((CountDownLatch)localObject).await();
          bnrh.b(this.this$0.c, "preDownloadAllRes--------------------finish a little group---------------------");
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    bnrh.b(this.this$0.c, "preDownloadAllRes---END cost=" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */