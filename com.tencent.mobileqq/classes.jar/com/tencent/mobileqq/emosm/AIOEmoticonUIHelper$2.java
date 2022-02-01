package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class AIOEmoticonUIHelper$2
  implements Runnable
{
  AIOEmoticonUIHelper$2(AIOEmoticonUIHelper paramAIOEmoticonUIHelper, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 9;
    int m = 0;
    BaseChatPie localBaseChatPie = this.this$0.a();
    if (localBaseChatPie == null) {}
    int j;
    do
    {
      return;
      j = AIOEmoticonUIHelper.a(this.this$0).b(this.a);
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.getTag(), 2, this.b + "is hotword, totalnum = " + j);
      }
    } while (j == 0);
    Object localObject3 = AIOEmoticonUIHelper.a(this.this$0).a(this.a);
    Object localObject2 = AIOEmoticonUIHelper.a(this.this$0).b(this.a);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    if (j > 9) {}
    for (;;)
    {
      long l = AIOEmoticonUIHelper.a(this.this$0).a(this.a);
      boolean bool;
      if (AIOEmoticonUIHelper.a(this.this$0).a()) {
        if (System.currentTimeMillis() - l > 86400000L) {
          bool = true;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.this$0.getTag(), 2, "afterTextChanged isNeedReq = " + bool);
        }
        if (bool)
        {
          ((List)localObject1).clear();
          localObject2 = new ArrayList();
          j = i;
          int k = m;
          if (localObject3 != null)
          {
            ((List)localObject2).add(((Emoticon)localObject3).eId);
            ((List)localObject1).add(localObject3);
            j = i - 1;
            k = m;
          }
          for (;;)
          {
            if (k < j)
            {
              localObject3 = new Emoticon();
              ((Emoticon)localObject3).epId = "NONE";
              ((Emoticon)localObject3).eId = ("_" + k);
              ((List)localObject1).add(localObject3);
              k += 1;
              continue;
              if (((List)localObject1).size() >= i) {
                break label422;
              }
              bool = true;
              break;
            }
          }
          localObject3 = AIOEmoticonUIHelper.a(this.this$0).c(this.a);
          ((EmoticonHandler)localBaseChatPie.a().getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(this.b, (List)localObject2, (List)localObject3);
        }
        localBaseChatPie.a().post(new AIOEmoticonUIHelper.2.1(this, (List)localObject1));
        return;
        label422:
        bool = false;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.AIOEmoticonUIHelper.2
 * JD-Core Version:    0.7.0.1
 */