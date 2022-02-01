package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.widget.AbsListView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/IStateChangeListener;", "", "onCreate", "", "onDestroy", "onFinishPage", "onPause", "onResume", "onScrollStateChanged", "view", "Lcom/tencent/widget/AbsListView;", "scrollState", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IStateChangeListener
{
  public abstract void a();
  
  public abstract void a(@Nullable AbsListView paramAbsListView, int paramInt);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.IStateChangeListener
 * JD-Core Version:    0.7.0.1
 */