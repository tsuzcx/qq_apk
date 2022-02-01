package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ReadInJoyUserInfoModule$2
  implements Runnable
{
  ReadInJoyUserInfoModule$2(ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (ReadInJoyUserInfoModule.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) != null)
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams return ahead of time, do not load db or network request, because the userInfo is loading.");
      return;
    }
    if (ReadInJoyUserInfoModule.a(this.this$0) != null)
    {
      localObject1 = ReadInJoyUserInfoModule.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
      if ((localObject1 != null) && ((!this.jdField_a_of_type_Boolean) || (!((ReadInJoyUserInfo)localObject1).isReadlTimeRead())) && (!this.jdField_b_of_type_Boolean))
      {
        QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams, hit cache, do not request again.");
        ReadInJoyUserInfoModule.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, (ReadInJoyUserInfo)localObject1);
        return;
      }
    }
    Object localObject1 = ReadInJoyUserInfoModule.a(this.this$0);
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    boolean bool = true;
    ((ConcurrentHashMap)localObject1).put(localObject2, Boolean.valueOf(true));
    localObject1 = ReadInJoyUserInfoModule.a(this.this$0);
    localObject2 = this.jdField_a_of_type_JavaLangString;
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      bool = false;
    }
    localObject1 = ((ReadInJoyUserInfoRepository)localObject1).a((String)localObject2, bool);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject2 = (ReadInJoyUserInfo)((List)localObject1).get(0);
      if ((localObject2 != null) && ((!this.jdField_a_of_type_Boolean) || (!((ReadInJoyUserInfo)localObject2).isReadlTimeRead())) && (!this.jdField_b_of_type_Boolean)) {
        return;
      }
    }
    if ((localObject1 == null) || (((List)localObject1).size() <= 0) || (this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(this.jdField_a_of_type_JavaLangString);
      this.this$0.a((List)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule.2
 * JD-Core Version:    0.7.0.1
 */