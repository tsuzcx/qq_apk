package dov.com.tencent.mobileqq.shortvideo;

import android.content.res.AssetManager;
import blok;
import blpe;
import bnkz;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ndq;

public class QIMPtvTemplateManager$1
  implements Runnable
{
  public QIMPtvTemplateManager$1(bnkz parambnkz, boolean paramBoolean) {}
  
  public void run()
  {
    localObject3 = null;
    localObject1 = null;
    if ((!this.this$0.jdField_a_of_type_JavaUtilList.isEmpty()) && (!this.a)) {}
    do
    {
      return;
      localObject6 = "";
      for (;;)
      {
        try
        {
          localObject5 = BaseApplication.getContext().getAssets().open("ptv_template_new.cfg");
          localObject1 = localObject5;
          localObject3 = localObject5;
          String str = ndq.a((InputStream)localObject5);
          localObject1 = str;
          localObject3 = localObject1;
          if (localObject5 == null) {}
        }
        catch (IOException localIOException)
        {
          Object localObject5;
          localObject3 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject3 = localObject1;
          localIOException.printStackTrace();
          localObject3 = localObject6;
          if (localObject1 == null) {
            continue;
          }
          try
          {
            ((InputStream)localObject1).close();
            localObject3 = localObject6;
          }
          catch (Exception localException1)
          {
            localObject3 = localObject6;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          localException1.printStackTrace();
          localObject3 = localObject6;
          continue;
        }
        finally
        {
          if (localObject3 == null) {
            continue;
          }
          try
          {
            ((InputStream)localObject3).close();
            throw localCollection;
          }
          catch (Exception localException2)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            localException2.printStackTrace();
            continue;
          }
          synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
          {
            if (!this.this$0.jdField_a_of_type_JavaUtilList.isEmpty()) {
              continue;
            }
            this.this$0.jdField_a_of_type_JavaUtilList.addAll(localCollection);
            if (this.this$0.a() == null) {
              continue;
            }
            this.this$0.a().notifyObservers(blpe.class, 3, true, null);
            return;
          }
        }
        try
        {
          ((InputStream)localObject5).close();
          localObject3 = localObject1;
        }
        catch (Exception localException3)
        {
          localObject3 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localException3.printStackTrace();
          localObject3 = localObject1;
        }
      }
      localObject1 = bnkz.a(this.this$0, (String)localObject3);
    } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
    localObject3 = ((List)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = ((blok)((Iterator)localObject3).next()).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject5).next();
        if (localObject6 != null)
        {
          ((PtvTemplateManager.PtvTemplateInfo)localObject6).usable = this.this$0.a((PtvTemplateManager.PtvTemplateInfo)localObject6);
          if ((!((PtvTemplateManager.PtvTemplateInfo)localObject6).usable) && (QLog.isColorLevel())) {
            QLog.i("QIMPtvTemplateManager", 2, "initAssetsFile template is not useable id=" + ((PtvTemplateManager.PtvTemplateInfo)localObject6).id + " md5=" + ((PtvTemplateManager.PtvTemplateInfo)localObject6).md5);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.1
 * JD-Core Version:    0.7.0.1
 */