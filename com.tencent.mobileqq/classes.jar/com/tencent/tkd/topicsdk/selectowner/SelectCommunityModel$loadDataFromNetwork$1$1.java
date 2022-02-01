package com.tencent.tkd.topicsdk.selectowner;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class SelectCommunityModel$loadDataFromNetwork$1$1
  extends Lambda
  implements Function0<Unit>
{
  SelectCommunityModel$loadDataFromNetwork$1$1(SelectCommunityModel.loadDataFromNetwork.1 param1, int paramInt, String paramString1, boolean paramBoolean, List paramList, String paramString2)
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
      Object localObject1 = (byte[])null;
      Object localObject2 = this.$cookieStr;
      if (localObject2 != null)
      {
        localObject1 = Charsets.UTF_8;
        if (localObject2 != null)
        {
          localObject1 = ((String)localObject2).getBytes((Charset)localObject1);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      Function7 localFunction7 = this.this$0.$callback;
      boolean bool = this.$isEnd;
      localObject2 = this.$communityList;
      if (localObject2 == null) {
        localObject2 = CollectionsKt.emptyList();
      }
      localFunction7.invoke(localBoolean, Boolean.valueOf(bool), localInteger, new ArrayList((Collection)localObject2), localObject1, Integer.valueOf(this.$errorCode), this.$errorMsg);
      return;
    }
    this.this$0.$callback.invoke(Boolean.valueOf(false), localBoolean, localInteger, new ArrayList(), null, Integer.valueOf(this.$errorCode), this.$errorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.SelectCommunityModel.loadDataFromNetwork.1.1
 * JD-Core Version:    0.7.0.1
 */