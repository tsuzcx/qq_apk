package com.tencent.tkd.weibo.atContact;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function7;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MyFansListModel$loadDataFromNetwork$1$1
  implements Runnable
{
  MyFansListModel$loadDataFromNetwork$1$1(MyFansListModel.loadDataFromNetwork.1 param1, int paramInt, boolean paramBoolean, List paramList, byte[] paramArrayOfByte, String paramString) {}
  
  public final void run()
  {
    int i = this.jdField_a_of_type_Int;
    Boolean localBoolean = Boolean.valueOf(true);
    Integer localInteger = Integer.valueOf(0);
    if (i == 0)
    {
      Function7 localFunction7 = this.this$0.$callback;
      boolean bool = this.jdField_a_of_type_Boolean;
      List localList = this.jdField_a_of_type_JavaUtilList;
      if (localList == null) {
        localList = CollectionsKt.emptyList();
      }
      localFunction7.invoke(localBoolean, Boolean.valueOf(bool), localInteger, new ArrayList((Collection)localList), this.jdField_a_of_type_ArrayOfByte, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.this$0.$callback.invoke(Boolean.valueOf(false), localBoolean, localInteger, new ArrayList(), null, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.MyFansListModel.loadDataFromNetwork.1.1
 * JD-Core Version:    0.7.0.1
 */