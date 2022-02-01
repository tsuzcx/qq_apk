package com.tencent.mobileqq.qqexpand.profilecard;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileComponentConst;
import com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector;

public class ExpandComponentCollector
  implements IProfileComponentConst, IProfileComponentCollector
{
  public SparseArray<Class<? extends AbsProfileComponent>> collect()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(1008, ProfileExtendFriendComponent.class);
    return localSparseArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ExpandComponentCollector
 * JD-Core Version:    0.7.0.1
 */