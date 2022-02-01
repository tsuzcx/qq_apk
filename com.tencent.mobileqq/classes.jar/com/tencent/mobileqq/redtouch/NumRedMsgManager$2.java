package com.tencent.mobileqq.redtouch;

import aodd;
import bbap;
import bbaq;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgRspBody;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class NumRedMsgManager$2
  implements Runnable
{
  public NumRedMsgManager$2(bbaq parambbaq, long[] paramArrayOfLong, bbap parambbap, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    int k = 0;
    if ((bbaq.a(this.this$0)) || (this.jdField_a_of_type_ArrayOfLong.length < 1) || (this.jdField_a_of_type_Bbap == null)) {
      return;
    }
    if (!this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_Bbap.a))) {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_Bbap.a), this.jdField_a_of_type_Bbap);
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = this.this$0.a();
    int j;
    if (localObject != null)
    {
      localObject = ((NumRedMsg.NumMsgRspBody)localObject).rpt_num_red.get();
      if (localObject != null)
      {
        i = 0;
        if (i < this.jdField_a_of_type_ArrayOfLong.length)
        {
          j = 0;
          for (;;)
          {
            if (j >= ((List)localObject).size()) {
              break label365;
            }
            if (((NumRedMsg.NumMsgBusi)((List)localObject).get(j)).ui64_msgid.get() == this.jdField_a_of_type_ArrayOfLong[i])
            {
              localArrayList1.add(((List)localObject).get(j));
              j = 1;
              if (j == 0)
              {
                NumRedMsg.NumMsgBusi localNumMsgBusi = new NumRedMsg.NumMsgBusi();
                localNumMsgBusi.ui64_msgid.set(this.jdField_a_of_type_ArrayOfLong[i]);
                localArrayList2.add(localNumMsgBusi);
              }
              i += 1;
              break;
            }
            j += 1;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        i = k;
        while (i < this.jdField_a_of_type_ArrayOfLong.length)
        {
          localObject = new NumRedMsg.NumMsgBusi();
          ((NumRedMsg.NumMsgBusi)localObject).ui64_msgid.set(this.jdField_a_of_type_ArrayOfLong[i]);
          localArrayList2.add(localObject);
          i += 1;
        }
      }
      if ((localArrayList1.size() == this.jdField_a_of_type_ArrayOfLong.length) || (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Bbap.a(this.jdField_a_of_type_JavaLangString, localArrayList1);
        return;
      }
      this.this$0.jdField_a_of_type_Aodd.a(localArrayList2, this.jdField_a_of_type_Bbap.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfLong);
      return;
      label365:
      j = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.NumRedMsgManager.2
 * JD-Core Version:    0.7.0.1
 */