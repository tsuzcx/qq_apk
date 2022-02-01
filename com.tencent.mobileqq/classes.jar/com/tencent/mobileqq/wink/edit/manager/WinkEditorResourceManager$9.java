package com.tencent.mobileqq.wink.edit.manager;

import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import java.util.List;

class WinkEditorResourceManager$9
  implements Runnable
{
  WinkEditorResourceManager$9(WinkEditorResourceManager paramWinkEditorResourceManager) {}
  
  public void run()
  {
    List localList = this.this$0.t();
    MetaCategory localMetaCategory = WinkEditorMaterialManager.a().b();
    if (localMetaCategory != null) {
      localList.add(0, localMetaCategory);
    }
    this.this$0.g().postValue(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager.9
 * JD-Core Version:    0.7.0.1
 */