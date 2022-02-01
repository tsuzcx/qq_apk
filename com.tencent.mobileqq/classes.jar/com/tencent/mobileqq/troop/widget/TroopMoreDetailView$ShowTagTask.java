package com.tencent.mobileqq.troop.widget;

import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

class TroopMoreDetailView$ShowTagTask
  implements Runnable
{
  private final WeakReference<TroopMoreDetailView> a;
  
  public TroopMoreDetailView$ShowTagTask(TroopMoreDetailView paramTroopMoreDetailView1, TroopMoreDetailView paramTroopMoreDetailView2)
  {
    this.a = new WeakReference(paramTroopMoreDetailView2);
  }
  
  public void run()
  {
    TroopMoreDetailView localTroopMoreDetailView = (TroopMoreDetailView)this.a.get();
    if (localTroopMoreDetailView == null) {}
    while (localTroopMoreDetailView.getContext() == null) {
      return;
    }
    ArrayList localArrayList = TroopInfoActivity.a(localTroopMoreDetailView.getContext(), localTroopMoreDetailView.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    ThreadManager.getUIHandler().post(new TroopMoreDetailView.ShowTagTask.1(this, localTroopMoreDetailView, localArrayList));
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    TroopMoreDetailView.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopMoreDetailView.ShowTagTask
 * JD-Core Version:    0.7.0.1
 */