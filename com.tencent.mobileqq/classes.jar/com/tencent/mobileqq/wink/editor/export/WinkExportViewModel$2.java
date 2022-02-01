package com.tencent.mobileqq.wink.editor.export;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.edit.base.AEEditorPath.EDITOR.FILES;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataHelper;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.render.ComposeRenderLayer;
import com.tencent.videocut.render.ComposeRenderLayer.RenderScene;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WinkExportViewModel$2
  implements Runnable
{
  WinkExportViewModel$2(WinkExportViewModel paramWinkExportViewModel, WinkEditorViewModel paramWinkEditorViewModel, List paramList, WinkEditorFragment paramWinkEditorFragment, WinkEditDataWrapper paramWinkEditDataWrapper) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    String str1 = this.a.h();
    String str2 = AEEditorPath.EDITOR.FILES.e;
    Object localObject = new File(str2);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    ICutSession localICutSession = TavCut.a.b();
    localICutSession.a(TavCut.a.c(null));
    localObject = new ComposeRenderLayer(localICutSession, new MediaModel(), ComposeRenderLayer.RenderScene.PIC);
    ArrayList localArrayList1 = this.a.f();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < this.b.size())
    {
      LocalMediaInfo localLocalMediaInfo = WinkExportViewModel.a(this.this$0, localICutSession, (ComposeRenderLayer)localObject, (LocalMediaInfo)localArrayList1.get(i), (MediaModel)this.b.get(i), str1, str2);
      if (!TextUtils.isEmpty(localLocalMediaInfo.path))
      {
        localArrayList2.add(localLocalMediaInfo.path);
        localHashMap.put(localLocalMediaInfo.path, localLocalMediaInfo);
      }
      i += 1;
    }
    localICutSession.g();
    WinkExportViewModel.a(this.this$0).postValue(WinkExportState.e);
    this.this$0.a(this.c, localArrayList2, localHashMap, this.d);
    WinkEditDataHelper.a(this.d, str1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exportImage total count:");
    ((StringBuilder)localObject).append(this.b.size());
    ((StringBuilder)localObject).append(" cost:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    AEQLog.d("WinkExportViewModel", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.export.WinkExportViewModel.2
 * JD-Core Version:    0.7.0.1
 */