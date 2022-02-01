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
    ArrayList localArrayList;
    int i;
    switch (this.a)
    {
    default: 
      return;
    case 10003: 
      localArrayList = (ArrayList)HotPicManager.a(this.this$0).get(this.b);
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList();
        HotPicManager.a(this.this$0).put(this.b, localObject);
      }
      i = ((ArrayList)localObject).size();
      localObject = this.this$0;
      ((HotPicManager)localObject).a(i, i + 8 - 1, ((HotPicManager)localObject).b(), this.b, false, this.a);
      return;
    case 10002: 
      localArrayList = (ArrayList)HotPicManager.a(this.this$0).get(this.b);
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList();
        HotPicManager.a(this.this$0).put(this.b, localObject);
      }
      i = ((ArrayList)localObject).size();
      localObject = this.this$0;
      ((HotPicManager)localObject).a(i, i + 16 - 1, ((HotPicManager)localObject).b(), this.b, false, this.a);
      return;
    }
    if ((!this.this$0.b) && (!this.this$0.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager", 2, "cancel request");
      }
      return;
    }
    boolean bool = this.this$0.a(this.b);
    Object localObject = this.this$0;
    int j = ((HotPicManager)localObject).b();
    int k = this.b;
    if (bool) {
      i = 10003;
    } else {
      i = 10002;
    }
    ((HotPicManager)localObject).a(0, 15, j, k, true, i);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request REQ_CHECK_UPDATE getLoaclVersion is ");
      ((StringBuilder)localObject).append(this.this$0.b());
      QLog.d("HotPicManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager.2
 * JD-Core Version:    0.7.0.1
 */