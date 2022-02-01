package com.tencent.mobileqq.redtouch;

import com.tencent.mobileqq.app.NumRedMsgHandler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgRspBody;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class NumRedMsgManager$2
  implements Runnable
{
  NumRedMsgManager$2(NumRedMsgManager paramNumRedMsgManager, long[] paramArrayOfLong, NumRedGetMsgCallback paramNumRedGetMsgCallback, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (!NumRedMsgManager.a(this.this$0))
    {
      int i = this.a.length;
      int j = 1;
      if (i >= 1)
      {
        if (this.b == null) {
          return;
        }
        if (!this.this$0.c.containsKey(Integer.valueOf(this.b.c))) {
          this.this$0.c.put(Integer.valueOf(this.b.c), this.b);
        }
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject = this.this$0.a();
        int k = 0;
        i = j;
        if (localObject != null)
        {
          localObject = ((NumRedMsg.NumMsgRspBody)localObject).rpt_num_red.get();
          i = j;
          if (localObject != null)
          {
            i = 0;
            while (i < this.a.length)
            {
              j = 0;
              while (j < ((List)localObject).size())
              {
                if (((NumRedMsg.NumMsgBusi)((List)localObject).get(j)).ui64_msgid.get() == this.a[i])
                {
                  localArrayList1.add(((List)localObject).get(j));
                  j = 1;
                  break label213;
                }
                j += 1;
              }
              j = 0;
              label213:
              if (j == 0)
              {
                NumRedMsg.NumMsgBusi localNumMsgBusi = new NumRedMsg.NumMsgBusi();
                localNumMsgBusi.ui64_msgid.set(this.a[i]);
                localArrayList2.add(localNumMsgBusi);
              }
              i += 1;
            }
            i = 0;
          }
        }
        if (i != 0)
        {
          i = k;
          while (i < this.a.length)
          {
            localObject = new NumRedMsg.NumMsgBusi();
            ((NumRedMsg.NumMsgBusi)localObject).ui64_msgid.set(this.a[i]);
            localArrayList2.add(localObject);
            i += 1;
          }
        }
        if ((localArrayList1.size() != this.a.length) && (!this.c))
        {
          this.this$0.b.a(localArrayList2, this.b.c, this.d, this.a);
          return;
        }
        this.b.a(this.d, localArrayList1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.NumRedMsgManager.2
 * JD-Core Version:    0.7.0.1
 */