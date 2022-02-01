package com.tencent.tkd.weibo.atContact;

import android.os.Handler;
import android.os.Looper;
import com.tencent.tkd.weibo.bean.AtPersonItem;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "retCookie", "", "isEnd", "", "followList", "", "Lcom/tencent/tkd/weibo/bean/AtPersonItem;", "invoke"}, k=3, mv={1, 1, 16})
final class MyFollowListModel$loadDataFromNetwork$1
  extends Lambda
  implements Function5<Integer, String, byte[], Boolean, List<? extends AtPersonItem>, Unit>
{
  MyFollowListModel$loadDataFromNetwork$1(byte[] paramArrayOfByte, Function7 paramFunction7)
  {
    super(5);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString, @Nullable byte[] paramArrayOfByte, boolean paramBoolean, @Nullable List<AtPersonItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    int i;
    if (this.$cookie != null)
    {
      if (this.$cookie.length != 0) {
        break label92;
      }
      i = 1;
      if (i == 0) {}
    }
    else
    {
      if (paramInt != 0) {
        break label104;
      }
      if (paramList == null) {
        break label98;
      }
      i = paramList.size();
      label47:
      if (i <= 0) {
        break label104;
      }
      DataTransferManager.a.a(1);
    }
    for (;;)
    {
      new Handler(Looper.getMainLooper()).post((Runnable)new MyFollowListModel.loadDataFromNetwork.1.1(this, paramInt, paramBoolean, paramList, paramArrayOfByte, paramString));
      return;
      label92:
      i = 0;
      break;
      label98:
      i = 0;
      break label47;
      label104:
      DataTransferManager.a.a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.MyFollowListModel.loadDataFromNetwork.1
 * JD-Core Version:    0.7.0.1
 */