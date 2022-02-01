package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;

class OperatorDataPusher<UP, DOWN>
  extends BaseDataPusher<DOWN>
{
  private Operator<UP, DOWN> mOperator;
  private DataPusher<UP> mUpDataPusher;
  
  public OperatorDataPusher(DataPusher<UP> paramDataPusher, Operator<UP, DOWN> paramOperator)
  {
    this.mUpDataPusher = paramDataPusher;
    this.mOperator = paramOperator;
  }
  
  public void apply(Observer<DOWN> paramObserver)
  {
    super.apply(paramObserver);
    AssertUtils.checkNotNull(paramObserver);
    paramObserver = (Observer)this.mOperator.apply(paramObserver);
    this.mUpDataPusher.apply(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.reactive.OperatorDataPusher
 * JD-Core Version:    0.7.0.1
 */