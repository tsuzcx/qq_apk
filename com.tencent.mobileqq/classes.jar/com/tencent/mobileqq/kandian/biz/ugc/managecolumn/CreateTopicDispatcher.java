package com.tencent.mobileqq.kandian.biz.ugc.managecolumn;

import com.tencent.mobileqq.kandian.repo.db.struct.ColumnInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/managecolumn/CreateTopicDispatcher;", "", "()V", "createTopicListenerList", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/kandian/repo/db/struct/ColumnInfo;", "Lkotlin/ParameterName;", "name", "topicInfo", "", "addCreateTopicListener", "listener", "notifyTopicCreate", "removeCreateTopicListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CreateTopicDispatcher
{
  public static final CreateTopicDispatcher a;
  private static final List<Function1<ColumnInfo, Unit>> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizUgcManagecolumnCreateTopicDispatcher = new CreateTopicDispatcher();
    jdField_a_of_type_JavaUtilList = (List)new ArrayList();
  }
  
  @JvmStatic
  public static final void a(@NotNull Function1<? super ColumnInfo, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "listener");
    jdField_a_of_type_JavaUtilList.add(paramFunction1);
  }
  
  @JvmStatic
  public static final void b(@NotNull Function1<? super ColumnInfo, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "listener");
    jdField_a_of_type_JavaUtilList.remove(paramFunction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.managecolumn.CreateTopicDispatcher
 * JD-Core Version:    0.7.0.1
 */