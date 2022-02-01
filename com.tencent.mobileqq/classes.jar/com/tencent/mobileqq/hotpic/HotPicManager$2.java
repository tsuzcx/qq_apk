package com.tencent.mobileqq.hotpic;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class HotPicManager$2
  implements Runnable
{
  HotPicManager$2(HotPicManager paramHotPicManager, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.this$0.a();
    switch (this.a)
    {
    default: 
    case 10001: 
      do
      {
        return;
        if ((this.this$0.b) || (this.this$0.b())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HotPicManager", 2, "cancel request");
      return;
      boolean bool = this.this$0.a(this.b);
      localObject = this.this$0;
      int j = this.this$0.b();
      int k = this.b;
      if (bool) {}
      for (i = 10003;; i = 10002)
      {
        ((HotPicManager)localObject).a(0, 15, j, k, true, i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("HotPicManager", 2, "request REQ_CHECK_UPDATE getLoaclVersion is " + this.this$0.b());
        return;
      }
    case 10002: 
      localArrayList = (ArrayList)HotPicManager.a(this.this$0).get(this.b);
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList();
        HotPicManager.a(this.this$0).put(this.b, localObject);
      }
      i = ((ArrayList)localObject).size();
      this.this$0.a(i, 16 + i - 1, this.this$0.b(), this.b, false, this.a);
      return;
    }
    ArrayList localArrayList = (ArrayList)HotPicManager.a(this.this$0).get(this.b);
    Object localObject = localArrayList;
    if (localArrayList == null)
    {
      localObject = new ArrayList();
      HotPicManager.a(this.this$0).put(this.b, localObject);
    }
    int i = ((ArrayList)localObject).size();
    this.this$0.a(i, 8 + i - 1, this.this$0.b(), this.b, false, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager.2
 * JD-Core Version:    0.7.0.1
 */