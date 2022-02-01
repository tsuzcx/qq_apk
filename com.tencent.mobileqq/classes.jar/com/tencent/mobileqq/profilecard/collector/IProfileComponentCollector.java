package com.tencent.mobileqq.profilecard.collector;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;

public abstract interface IProfileComponentCollector
{
  public abstract SparseArray<Class<? extends AbsProfileComponent>> collect();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector
 * JD-Core Version:    0.7.0.1
 */