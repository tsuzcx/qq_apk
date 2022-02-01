package com.tencent.mobileqq.kandian.biz.publisher.observer;

import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher.IPublisherObserver;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/observer/PublisherObserverController;", "", "()V", "publishObserverList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher$IPublisherObserver;", "Lkotlin/collections/ArrayList;", "addPublisherObserver", "", "observer", "removePublisherObserver", "sendPublishArticleResult", "code", "", "msg", "", "sendUploadImageResult", "sendUploadVideoResult", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublisherObserverController
{
  public static final PublisherObserverController a;
  private static final ArrayList<IKanDianPublisher.IPublisherObserver> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPublisherObserverPublisherObserverController = new PublisherObserverController();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IKanDianPublisher.IPublisherObserver)localIterator.next()).a(paramInt, paramString);
    }
  }
  
  public final void a(@NotNull IKanDianPublisher.IPublisherObserver paramIPublisherObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublisherObserver, "observer");
    jdField_a_of_type_JavaUtilArrayList.add(paramIPublisherObserver);
  }
  
  public final void b(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IKanDianPublisher.IPublisherObserver)localIterator.next()).b(paramInt, paramString);
    }
  }
  
  public final void b(@NotNull IKanDianPublisher.IPublisherObserver paramIPublisherObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublisherObserver, "observer");
    jdField_a_of_type_JavaUtilArrayList.remove(paramIPublisherObserver);
  }
  
  public final void c(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IKanDianPublisher.IPublisherObserver)localIterator.next()).c(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.observer.PublisherObserverController
 * JD-Core Version:    0.7.0.1
 */