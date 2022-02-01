package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.report.AEEditReportData;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterDataCache;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterResult;
import dov.com.qq.im.aeeditor.module.filter.ImageFilterInfoCache;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$18
  implements AEEditorAIFilterManager.AIFilterObserver
{
  AEEditorImageEditFragment$18(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.18.1(this, paramAIFilterResult));
    }
    if (paramInt == 0)
    {
      AEQLog.b("AEEditorImageEditFragment", "onAIFilterApplySuccess");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.18.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label105;
      }
    }
    label105:
    SingleImageAIFilterResult localSingleImageAIFilterResult;
    do
    {
      do
      {
        return;
        AEQLog.b("AEEditorImageEditFragment", "onAIFilterAppliedFailed:" + paramInt);
        ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.18.2(this));
        break;
      } while (paramAIFilterResult == null);
      AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(AEEditorImageEditFragment.a(this.a)), paramAIFilterResult);
      AEEditorImageEditFragment.a(this.a).put(String.valueOf(AEEditorImageEditFragment.a(this.a)), this.a.a(paramAIFilterResult));
      localSingleImageAIFilterResult = (SingleImageAIFilterResult)paramAIFilterResult;
    } while (localSingleImageAIFilterResult == null);
    AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), paramAIFilterResult);
    AEEditorImageEditFragment.a(this.a).resetAEKitModelForAI(AEEditorImageEditFragment.a(this.a), localSingleImageAIFilterResult.jdField_b_of_type_JavaLangString, localSingleImageAIFilterResult.jdField_a_of_type_Float, localSingleImageAIFilterResult.jdField_a_of_type_JavaUtilHashMap, (int)(localSingleImageAIFilterResult.c * 100.0F), localSingleImageAIFilterResult.jdField_b_of_type_Float);
    this.a.a(new String[] { "智能滤镜label", localSingleImageAIFilterResult.jdField_a_of_type_JavaLangString, "智能滤镜errCode", String.valueOf(paramInt) });
    paramAIFilterResult = "none";
    Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
    if (localIterator.hasNext())
    {
      NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
      if (!localNewEnhanceCategories.serverLabel.equals(localSingleImageAIFilterResult.jdField_a_of_type_JavaLangString)) {
        break label423;
      }
      paramAIFilterResult = localNewEnhanceCategories.filterType;
    }
    label423:
    for (;;)
    {
      break;
      AEBaseReportParam.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), "effect_aieffect_" + paramAIFilterResult);
      AEBaseReportParam.a().a().b.put(Integer.valueOf(AEEditorImageEditFragment.a(this.a)), Float.valueOf(-1.0F));
      AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), "effect_aieffect");
      return;
    }
  }
  
  public void aJ_()
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "资源下载中，请稍后再试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.18
 * JD-Core Version:    0.7.0.1
 */