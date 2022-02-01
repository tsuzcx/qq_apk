package com.tencent.videocut.utils.registry;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/registry/EasyRegistry;", "ListenerType", "Params", "Lcom/tencent/videocut/utils/registry/IRegistry;", "mInformer", "Lcom/tencent/videocut/utils/registry/EasyRegistry$Informer;", "mIsFilter", "", "mSticky", "mHasPriority", "mComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lcom/tencent/videocut/utils/registry/EasyRegistry$Informer;ZZZLjava/util/Comparator;)V", "mActiveListener", "Lcom/tencent/videocut/utils/registry/EasyRegistry$IActiveListener;", "mCurParams", "Ljava/lang/Object;", "mListeners", "", "mLock", "Ljava/util/concurrent/locks/ReadWriteLock;", "mParamModified", "mSearchComparator", "add", "", "listener", "(Ljava/lang/Object;)V", "checkActiveState", "isAdd", "listeners", "clear", "contains", "(Ljava/lang/Object;)Z", "notifyListeners", "params", "register", "remove", "setActiveListener", "setCurParams", "curParams", "unregister", "IActiveListener", "Informer", "lib_utils_release"}, k=1, mv={1, 4, 2})
public class EasyRegistry<ListenerType, Params>
  implements IRegistry<ListenerType>
{
  private final Comparator<ListenerType> a;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.registry.EasyRegistry
 * JD-Core Version:    0.7.0.1
 */