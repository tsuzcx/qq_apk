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
      int i = this.jdField_a_of_type_ArrayOfLong.length;
      int j = 1;
      if (i >= 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuDataNumRedGetMsgCallback == null) {
          return;
        }
        if (!this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTianshuDataNumRedGetMsgCallback.a))) {
          this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqTianshuDataNumRedGetMsgCallback.a), this.jdField_a_of_type_ComTencentMobileqqTianshuDataNumRedGetMsgCallback);
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
            while (i < this.jdField_a_of_type_ArrayOfLong.length)
            {
              j = 0;
              while (j < ((List)localObject).size())
              {
                if (((NumRedMsg.NumMsgBusi)((List)localObject).get(j)).ui64_msgid.get() == this.jdField_a_of_type_ArrayOfLong[i])
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
                localNumMsgBusi.ui64_msgid.set(this.jdField_a_of_type_ArrayOfLong[i]);
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
          while (i < this.jdField_a_of_type_ArrayOfLong.length)
          {
            localObject = new NumRedMsg.NumMsgBusi();
            ((NumRedMsg.NumMsgBusi)localObject).ui64_msgid.set(this.jdField_a_of_type_ArrayOfLong[i]);
            localArrayList2.add(localObject);
            i += 1;
          }
        }
        if ((localArrayList1.size() != this.jdField_a_of_type_ArrayOfLong.length) && (!this.jdField_a_of_type_Boolean))
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppNumRedMsgHandler.a(localArrayList2, this.jdField_a_of_type_ComTencentMobileqqTianshuDataNumRedGetMsgCallback.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfLong);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqTianshuDataNumRedGetMsgCallback.a(this.jdField_a_of_type_JavaLangString, localArrayList1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.NumRedMsgManager.2
 * JD-Core Version:    0.7.0.1
 */