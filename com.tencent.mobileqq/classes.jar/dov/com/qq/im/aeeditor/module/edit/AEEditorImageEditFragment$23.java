package dov.com.qq.im.aeeditor.module.edit;

import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.exporter.ImageExporter.ImageExportCallback;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.report.AEEditReportData;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$23
  implements ImageExporter.ImageExportCallback
{
  AEEditorImageEditFragment$23(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onCancelled() {}
  
  public void onExportComplete()
  {
    AEQLog.b("AEEditorImageEditFragment", "images export complete");
    AEEditorImageEditFragment.a(this.a, System.currentTimeMillis());
    AEQLog.b("AEEditorImageEditFragment", "perf: image export cost = " + (AEEditorImageEditFragment.a(this.a) - AEEditorImageEditFragment.b(this.a)) + "ms");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.23.2(this));
    String str2 = AEEditorImageEditFragment.a(this.a).toString();
    String str3 = AEEditorImageEditFragment.b(this.a).toString();
    String str4 = AEEditorImageEditFragment.c(this.a).toString();
    if (AEEditorImageEditFragment.a(this.a).get(0) != null) {}
    for (String str1 = String.valueOf(((AEEditorImageInfo)AEEditorImageEditFragment.a(this.a).get(0)).c);; str1 = "")
    {
      AEReportUtils.a(str2, str3, str4, str1);
      return;
    }
  }
  
  public void onFailed(Collection<String> paramCollection)
  {
    AEQLog.d("AEEditorImageEditFragment", "images export failed");
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.23.1(this, paramCollection));
  }
  
  public void onImageExport(String paramString)
  {
    AEQLog.b("AEEditorImageEditFragment", "image export, path = " + paramString);
    if (AEEditorImageEditFragment.a(this.a) == null) {
      return;
    }
    Object localObject = AEEditorImageEditFragment.a(this.a).getMediaModels();
    if (((List)localObject).get(AEEditorImageEditFragment.a(this.a).size()) != null)
    {
      AEBaseReportParam.a().a().jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a).size()), Integer.valueOf(((MediaModel)((List)localObject).get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList().size()));
      localObject = ((MediaModel)((List)localObject).get(AEEditorImageEditFragment.a(this.a).size())).getMediaEffectModel().getStickerModelList();
      int i = AEEditorImageEditFragment.a(this.a).size();
      if (!CollectionUtil.isEmptyList((List)localObject)) {
        this.a.a((List)localObject, i);
      }
      String str = AEBaseReportParam.a((String)AEEditorImageEditFragment.a(this.a).get(i));
      AEBaseReportParam.a().a().jdField_c_of_type_AndroidUtilSparseArray.put(i, str);
      this.a.a((List)localObject);
    }
    localObject = AEBaseDataReporter.a().a(AEEditorImageEditFragment.a(this.a).size());
    AEEditorImageEditFragment.a(this.a, (HashMap)localObject);
    AEEditorImageEditFragment.a(this.a).add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.23
 * JD-Core Version:    0.7.0.1
 */