package com.tencent.mobileqq.text;

import anvs;
import anwh;
import anzm;
import askd;
import ayki;
import aykr;
import bbdj;
import bbwg;
import bbwi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

public class QQText$SmallEmojiSpan$1
  implements Runnable
{
  public QQText$SmallEmojiSpan$1(aykr paramaykr) {}
  
  public void run()
  {
    Object localObject2 = anzm.r.replace("[epId]", Integer.toString(this.this$0.e));
    boolean bool = bbdj.a((String)localObject2);
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(ayki.d());
        if (localQQAppInterface1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQText", 2, "appInterface is null. return");
          }
          return;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localClassCastException.printStackTrace();
        QQAppInterface localQQAppInterface2 = null;
        continue;
        if (bool)
        {
          localObject3 = anzm.a();
          if (localObject3 == null) {
            break label385;
          }
          localObject1 = ((askd)localObject3).a(Integer.toString(this.this$0.e), Integer.toString(this.this$0.f));
          if (localObject1 != null)
          {
            localObject1 = ((askd)localObject3).a(Integer.toString(this.this$0.e));
            if ((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 0))
            {
              localObject3 = new ArrayList();
              localObject2 = bbdj.a(new File((String)localObject2));
              anwh.a(localQQAppInterface2, (EmoticonPackage)localObject1, anvs.c, (byte[])localObject2, (ArrayList)localObject3);
            }
            this.this$0.a((EmoticonPackage)localObject1);
            return;
          }
        }
        Object localObject3 = anzm.c.replace("[epId]", Integer.toString(this.this$0.e));
        localObject1 = new File((String)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "small emoji json not exist. epId:" + this.this$0.e + ",downloadUrl:" + (String)localObject3);
        }
        localObject2 = new bbwg((String)localObject3, (File)localObject1);
        ((bbwg)localObject2).j = true;
        int i = bbwi.a((bbwg)localObject2, localQQAppInterface2);
        localObject2 = new EmoticonPackage();
        ((EmoticonPackage)localObject2).epId = Integer.toString(this.this$0.e);
        ((EmoticonPackage)localObject2).jobType = 4;
        if (i != 0) {
          continue;
        }
        if (((File)localObject1).exists())
        {
          localObject1 = bbdj.a((File)localObject1);
          localObject3 = new ArrayList();
          anwh.a(localQQAppInterface2, (EmoticonPackage)localObject2, anvs.c, (byte[])localObject1, (ArrayList)localObject3);
          this.this$0.a((EmoticonPackage)localObject2);
          return;
        }
        localObject1 = null;
        continue;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        return;
      }
      label385:
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText.SmallEmojiSpan.1
 * JD-Core Version:    0.7.0.1
 */