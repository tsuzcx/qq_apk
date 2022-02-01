package com.tencent.tkd.weibo.atContact;

import android.os.Handler;
import android.os.Looper;
import com.tencent.tkd.topicsdk.bean.AtPersonItem;
import com.tencent.tkd.weibo.data.DataTransferManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "retCookie", "", "isEnd", "", "fansList", "", "Lcom/tencent/tkd/topicsdk/bean/AtPersonItem;", "invoke"}, k=3, mv={1, 1, 16})
final class MyFansListModel$loadDataFromNetwork$1
  extends Lambda
  implements Function5<Integer, String, byte[], Boolean, List<? extends AtPersonItem>, Unit>
{
  MyFansListModel$loadDataFromNetwork$1(byte[] paramArrayOfByte, Function7 paramFunction7)
  {
    super(5);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<AtPersonItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    byte[] arrayOfByte = this.$cookie;
    int i;
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {}
    }
    else
    {
      if (paramInt == 0)
      {
        if (paramList != null) {
          i = paramList.size();
        } else {
          i = 0;
        }
        if (i > 0)
        {
          DataTransferManager.a.b(1);
          break label83;
        }
      }
      DataTransferManager.a.b(0);
    }
    label83:
    new Handler(Looper.getMainLooper()).post((Runnable)new MyFansListModel.loadDataFromNetwork.1.1(this, paramInt, paramBoolean, paramList, paramArrayOfByte, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.MyFansListModel.loadDataFromNetwork.1
 * JD-Core Version:    0.7.0.1
 */