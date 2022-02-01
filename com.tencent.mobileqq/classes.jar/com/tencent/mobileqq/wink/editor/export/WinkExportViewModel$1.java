package com.tencent.mobileqq.wink.editor.export;

import android.graphics.Bitmap;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.edit.base.AEEditorPath.EDITOR.FILES;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkTavCutDelegate;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataHelper;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.render.cover.ICoverProvider;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okio.ByteString;

class WinkExportViewModel$1
  implements Runnable
{
  WinkExportViewModel$1(WinkExportViewModel paramWinkExportViewModel, WinkEditDataWrapper paramWinkEditDataWrapper, MediaModel paramMediaModel, WinkTavCutDelegate paramWinkTavCutDelegate, WinkEditorFragment paramWinkEditorFragment) {}
  
  public void run()
  {
    try
    {
      String str = this.a.getMissionId();
      Object localObject2 = AEEditorPath.EDITOR.FILES.e;
      Object localObject1 = new File((String)localObject2);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      localObject1 = this.b.videos;
      int j = 0;
      int i = 0;
      boolean bool = false;
      Object localObject3 = new File(((MediaClip)((List)localObject1).get(0)).resource.path);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("output_");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(WinkExportViewModel.a(((File)localObject3).getName()));
      ((StringBuilder)localObject1).append(".jpg");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append("output_");
      ((StringBuilder)localObject4).append(str);
      ((StringBuilder)localObject4).append("_");
      ((StringBuilder)localObject4).append(System.currentTimeMillis());
      ((StringBuilder)localObject4).append("_");
      ((StringBuilder)localObject4).append(WinkExportViewModel.a(((File)localObject3).getName()));
      ((StringBuilder)localObject4).append(".mp4");
      localObject2 = ((StringBuilder)localObject4).toString();
      localObject3 = WinkExportManager.a(this.a, this.a.getOriginMediaInfos());
      WinkExportManager.a(this.c.b(), this.a, (Pair)localObject3);
      float f1 = ((Integer)((Pair)localObject3).first).intValue();
      float f2 = ((Integer)((Pair)localObject3).second).intValue();
      localObject3 = this.c.b().d();
      if (localObject3 != null)
      {
        i = j;
        try
        {
          localObject3 = TavCut.a.a((RenderModel)localObject3, new Size(Integer.valueOf((int)f1), Integer.valueOf((int)f2), ByteString.EMPTY));
          i = j;
          localObject4 = ((ICoverProvider)localObject3).a(0L);
          if (localObject4 != null)
          {
            i = j;
            bool = FileUtils.saveBitmapToFile((Bitmap)localObject4, (String)localObject1);
            i = bool;
            ((Bitmap)localObject4).recycle();
          }
          i = bool;
          ((ICoverProvider)localObject3).a();
          i = bool;
          localObject3 = new StringBuilder();
          i = bool;
          ((StringBuilder)localObject3).append("startExport... extract cover isSuccess:");
          i = bool;
          ((StringBuilder)localObject3).append(bool);
          i = bool;
          ((StringBuilder)localObject3).append(" thumbfileName:");
          i = bool;
          ((StringBuilder)localObject3).append((String)localObject1);
          i = bool;
          AEQLog.d("WinkExportViewModel", ((StringBuilder)localObject3).toString());
          i = bool;
        }
        catch (Exception localException)
        {
          AEQLog.a("WinkExportViewModel", "startExport ERROR", localException);
        }
      }
      if (i != 0)
      {
        WinkExportViewModel.a(this.this$0).postValue(WinkExportState.b);
        localObject1 = this.this$0.a(this.b.videos, (String)localObject2, (String)localObject1, str, (int)f1, (int)f2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(((LocalMediaInfo)localObject1).path);
        HashMap localHashMap = new HashMap();
        localHashMap.put(((LocalMediaInfo)localObject1).path, localObject1);
        this.this$0.a(this.d, (ArrayList)localObject2, localHashMap, this.a);
        this.a.setOutMediaInfo((LocalMediaInfo)localObject1);
        WinkEditDataHelper.a(this.a, str);
        WinkExportManager.a().a(this.a);
        return;
      }
      WinkExportViewModel.a(this.this$0).postValue(WinkExportState.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      WinkExportViewModel.a(this.this$0).postValue(WinkExportState.c);
      AEQLog.a("WinkExportViewModel", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.export.WinkExportViewModel.1
 * JD-Core Version:    0.7.0.1
 */