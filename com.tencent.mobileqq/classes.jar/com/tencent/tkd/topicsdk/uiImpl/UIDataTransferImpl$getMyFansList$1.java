package com.tencent.tkd.topicsdk.uiImpl;

import com.tencent.tkd.weibo.bean.AtPersonItem;
import com.tencent.tkd.weibo.data.IDataTransfer.ContactCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "retCookie", "", "isEnd", "", "personList", "", "Lcom/tencent/tkd/weibo/bean/AtPersonItem;", "invoke"}, k=3, mv={1, 1, 16})
final class UIDataTransferImpl$getMyFansList$1
  extends Lambda
  implements Function5<Integer, String, byte[], Boolean, List<? extends AtPersonItem>, Unit>
{
  UIDataTransferImpl$getMyFansList$1(IDataTransfer.ContactCallback paramContactCallback)
  {
    super(5);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<AtPersonItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        localArrayList.add((AtPersonItem)paramList.next());
      }
    }
    this.$callback.a(paramInt, paramString, paramArrayOfByte, paramBoolean, (List)localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.uiImpl.UIDataTransferImpl.getMyFansList.1
 * JD-Core Version:    0.7.0.1
 */