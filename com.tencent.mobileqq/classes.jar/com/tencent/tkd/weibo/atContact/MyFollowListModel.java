package com.tencent.tkd.weibo.atContact;

import com.tencent.tkd.topicsdk.bean.AtPersonItem;
import com.tencent.tkd.topicsdk.mvp.ListModel;
import com.tencent.tkd.weibo.data.DataTransferManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/atContact/MyFollowListModel;", "Lcom/tencent/tkd/topicsdk/mvp/ListModel;", "Lcom/tencent/tkd/topicsdk/bean/AtPersonItem;", "", "()V", "loadDataFromDB", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "list", "loadDataFromNetwork", "cookie", "Lkotlin/Function7;", "", "isSuccess", "isEnd", "", "totalSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "errorCode", "", "errorMsg", "Lcom/tencent/tkd/topicsdk/mvp/LoadDataFromNetworkCallback;", "saveDataToDB", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class MyFollowListModel
  extends ListModel<AtPersonItem, byte[]>
{
  public void a(@NotNull List<AtPersonItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
  }
  
  public void a(@NotNull Function1<? super List<AtPersonItem>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
  }
  
  public void a(@Nullable byte[] paramArrayOfByte, @NotNull Function7<? super Boolean, ? super Boolean, ? super Integer, ? super ArrayList<AtPersonItem>, ? super byte[], ? super Integer, ? super String, Unit> paramFunction7)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction7, "callback");
    DataTransferManager.a.a(paramArrayOfByte, (Function5)new MyFollowListModel.loadDataFromNetwork.1(paramArrayOfByte, paramFunction7));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.atContact.MyFollowListModel
 * JD-Core Version:    0.7.0.1
 */