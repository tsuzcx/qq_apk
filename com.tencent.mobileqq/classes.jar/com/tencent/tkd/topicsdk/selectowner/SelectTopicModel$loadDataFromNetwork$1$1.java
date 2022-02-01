package com.tencent.tkd.topicsdk.selectowner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class SelectTopicModel$loadDataFromNetwork$1$1
  extends Lambda
  implements Function0<Unit>
{
  SelectTopicModel$loadDataFromNetwork$1$1(SelectTopicModel.loadDataFromNetwork.1 param1, int paramInt, boolean paramBoolean, List paramList, byte[] paramArrayOfByte, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    int i = this.$errorCode;
    Boolean localBoolean = Boolean.valueOf(true);
    Integer localInteger = Integer.valueOf(0);
    if (i == 0)
    {
      Function7 localFunction7 = this.this$0.$callback;
      boolean bool = this.$isEnd;
      Object localObject = this.$topicList;
      if (localObject == null) {
        localObject = new ArrayList();
      }
      localFunction7.invoke(localBoolean, Boolean.valueOf(bool), localInteger, new ArrayList((Collection)localObject), this.$cookieNew, Integer.valueOf(this.$errorCode), this.$errorMsg);
      return;
    }
    this.this$0.$callback.invoke(Boolean.valueOf(false), localBoolean, localInteger, new ArrayList(), null, Integer.valueOf(this.$errorCode), this.$errorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectTopicModel.loadDataFromNetwork.1.1
 * JD-Core Version:    0.7.0.1
 */