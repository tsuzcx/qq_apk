package com.tencent.mobileqq.wink.edit.manager;

import androidx.lifecycle.MutableLiveData;
import java.util.List;

class WinkEditorResourceManager$6
  implements Runnable
{
  WinkEditorResourceManager$6(WinkEditorResourceManager paramWinkEditorResourceManager) {}
  
  public void run()
  {
    List localList = this.this$0.q();
    this.this$0.d().postValue(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager.6
 * JD-Core Version:    0.7.0.1
 */