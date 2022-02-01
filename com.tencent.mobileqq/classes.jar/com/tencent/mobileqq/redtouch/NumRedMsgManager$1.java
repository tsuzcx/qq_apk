package com.tencent.mobileqq.redtouch;

import com.tencent.mobileqq.app.NumRedMsgHandler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgRspBody;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

class NumRedMsgManager$1
  implements Runnable
{
  NumRedMsgManager$1(NumRedMsgManager paramNumRedMsgManager, List paramList, NumRedGetMsgCallback paramNumRedGetMsgCallback, String paramString) {}
  
  public void run()
  {
    if (!NumRedMsgManager.a(this.this$0))
    {
      Object localObject1 = this.a;
      if (localObject1 != null)
      {
        int i = ((List)localObject1).size();
        int j = 1;
        if (i >= 1)
        {
          if (this.b == null) {
            return;
          }
          if ((this.this$0.c != null) && (!this.this$0.c.containsKey(Integer.valueOf(this.b.c)))) {
            this.this$0.c.put(Integer.valueOf(this.b.c), this.b);
          }
          Object localObject2 = new ArrayList();
          localObject1 = new ArrayList();
          Object localObject3 = this.this$0.a();
          int k = 0;
          i = j;
          if (localObject3 != null)
          {
            localObject3 = ((NumRedMsg.NumMsgRspBody)localObject3).rpt_num_red.get();
            i = j;
            if (localObject3 != null)
            {
              i = 0;
              while (i < this.a.size())
              {
                j = 0;
                while (j < ((List)localObject3).size())
                {
                  if (((NumRedMsg.NumMsgBusi)((List)localObject3).get(j)).ui64_msgid.get() == ((Submsgtype0x89.NumRedBusiInfo)this.a.get(i)).uint32_app_id.get())
                  {
                    ((List)localObject2).add(((List)localObject3).get(j));
                    j = 1;
                    break label254;
                  }
                  j += 1;
                }
                j = 0;
                label254:
                if (j == 0)
                {
                  NumRedMsg.NumMsgBusi localNumMsgBusi = new NumRedMsg.NumMsgBusi();
                  localNumMsgBusi.ui64_msgid.set(((Submsgtype0x89.NumRedBusiInfo)this.a.get(i)).uint64_msgid.get());
                  localNumMsgBusi.ui_appid.set(((Submsgtype0x89.NumRedBusiInfo)this.a.get(i)).uint32_android_app_id.get());
                  localNumMsgBusi.str_path.set(((Submsgtype0x89.NumRedBusiInfo)this.a.get(i)).str_android_path.get());
                  ((List)localObject1).add(localNumMsgBusi);
                }
                i += 1;
              }
              i = 0;
            }
          }
          if (i != 0)
          {
            i = 0;
            while (i < this.a.size())
            {
              localObject3 = new NumRedMsg.NumMsgBusi();
              ((NumRedMsg.NumMsgBusi)localObject3).ui64_msgid.set(((Submsgtype0x89.NumRedBusiInfo)this.a.get(i)).uint64_msgid.get());
              ((NumRedMsg.NumMsgBusi)localObject3).ui_appid.set(((Submsgtype0x89.NumRedBusiInfo)this.a.get(i)).uint32_android_app_id.get());
              ((NumRedMsg.NumMsgBusi)localObject3).str_path.set(((Submsgtype0x89.NumRedBusiInfo)this.a.get(i)).str_android_path.get());
              ((List)localObject1).add(localObject3);
              i += 1;
            }
          }
          if (((List)localObject2).size() == this.a.size())
          {
            this.b.a(this.c, (List)localObject2);
            return;
          }
          localObject2 = new long[this.a.size()];
          i = k;
          while (i < this.a.size())
          {
            localObject2[i] = ((Submsgtype0x89.NumRedBusiInfo)this.a.get(i)).uint64_msgid.get();
            i += 1;
          }
          this.this$0.b.a((List)localObject1, this.b.c, this.c, (long[])localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.NumRedMsgManager.1
 * JD-Core Version:    0.7.0.1
 */