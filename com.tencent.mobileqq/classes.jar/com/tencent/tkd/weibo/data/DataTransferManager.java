package com.tencent.tkd.weibo.data;

import com.tencent.tkd.weibo.bean.AtPersonItem;
import com.tencent.tkd.weibo.bean.TweetTopicItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/data/DataTransferManager;", "", "()V", "contactFlagListenerList", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "hasFollowFlag", "hasFansFlag", "", "Lcom/tencent/tkd/weibo/data/ContactFlagListener;", "value", "getHasFansFlag", "()I", "setHasFansFlag", "(I)V", "getHasFollowFlag", "setHasFollowFlag", "mIDataTransfer", "Lcom/tencent/tkd/weibo/data/IDataTransfer;", "addContactFlagListener", "listener", "getMyFansList", "cookie", "", "callback", "Lkotlin/Function5;", "errorCode", "", "errorMsg", "cookieStr", "", "isEnd", "", "Lcom/tencent/tkd/weibo/bean/AtPersonItem;", "followList", "Lcom/tencent/tkd/weibo/data/ContactCallback;", "getMyFollowList", "getTweetHotTopicList", "pageNum", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "topicList", "Lcom/tencent/tkd/weibo/data/TopicCallback;", "getTweetRecentTopicList", "getTweetSearchTopicList", "wording", "init", "dataTransfer", "removeContactFlagListener", "sendAtContactFlagEvent", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class DataTransferManager
{
  private static int jdField_a_of_type_Int = -1;
  public static final DataTransferManager a;
  private static IDataTransfer jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
  private static final List<Function2<Integer, Integer, Unit>> jdField_a_of_type_JavaUtilList;
  private static int b = -1;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboDataDataTransferManager = new DataTransferManager();
    jdField_a_of_type_JavaUtilList = (List)new ArrayList();
  }
  
  private final void a()
  {
    Iterator localIterator = ((Iterable)jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ((Function2)localIterator.next()).invoke(Integer.valueOf(jdField_a_of_type_Int), Integer.valueOf(b));
    }
    a(-1);
    b(-1);
  }
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
    if ((paramInt != -1) && (b != -1)) {
      a();
    }
  }
  
  public final void a(int paramInt, @NotNull String paramString, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<TweetTopicItem>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramString, paramInt, (IDataTransfer.TopicCallback)new DataTransferManagerKt.sam.com_tencent_tkd_weibo_data_IDataTransfer_TopicCallback.0(paramFunction5));
  }
  
  public final void a(int paramInt, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<TweetTopicItem>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramInt, (IDataTransfer.TopicCallback)new DataTransferManagerKt.sam.com_tencent_tkd_weibo_data_IDataTransfer_TopicCallback.0(paramFunction5));
  }
  
  public final void a(@NotNull IDataTransfer paramIDataTransfer)
  {
    Intrinsics.checkParameterIsNotNull(paramIDataTransfer, "dataTransfer");
    jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer = paramIDataTransfer;
  }
  
  public final void a(@NotNull Function2<? super Integer, ? super Integer, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "listener");
    jdField_a_of_type_JavaUtilList.add(paramFunction2);
  }
  
  public final void a(@Nullable byte[] paramArrayOfByte, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<AtPersonItem>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.b(paramArrayOfByte, (IDataTransfer.ContactCallback)new DataTransferManagerKt.sam.com_tencent_tkd_weibo_data_IDataTransfer_ContactCallback.0(paramFunction5));
  }
  
  public final void b(int paramInt)
  {
    b = paramInt;
    if ((paramInt != -1) && (jdField_a_of_type_Int != -1)) {
      a();
    }
  }
  
  public final void b(@NotNull Function2<? super Integer, ? super Integer, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "listener");
    jdField_a_of_type_JavaUtilList.remove(paramFunction2);
  }
  
  public final void b(@Nullable byte[] paramArrayOfByte, @NotNull Function5<? super Integer, ? super String, ? super byte[], ? super Boolean, ? super List<AtPersonItem>, Unit> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "callback");
    IDataTransfer localIDataTransfer = jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
    if (localIDataTransfer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mIDataTransfer");
    }
    localIDataTransfer.a(paramArrayOfByte, (IDataTransfer.ContactCallback)new DataTransferManagerKt.sam.com_tencent_tkd_weibo_data_IDataTransfer_ContactCallback.0(paramFunction5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.data.DataTransferManager
 * JD-Core Version:    0.7.0.1
 */