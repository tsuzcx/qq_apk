package com.tencent.mobileqq.search.util;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mobileqq.app.ThreadManager;

class PAOfflineSearchManager$1
  implements AsyncBack
{
  public void loaded(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      ThreadManager.post(new PAOfflineSearchManager.1.1(this), 0, null, true);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.PAOfflineSearchManager.1
 * JD-Core Version:    0.7.0.1
 */