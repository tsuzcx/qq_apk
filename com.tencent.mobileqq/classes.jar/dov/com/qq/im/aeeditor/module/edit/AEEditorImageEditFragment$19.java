package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterDataCache;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterResult;
import dov.com.qq.im.aeeditor.module.filter.ImageFilterInfoCache;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$19
  implements AEEditorAIFilterManager.AIFilterObserver
{
  AEEditorImageEditFragment$19(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void a(int paramInt, AIFilterResult paramAIFilterResult)
  {
    if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.19.1(this, paramAIFilterResult));
    }
    if (paramInt == 0)
    {
      AEQLog.b("AEEditorImageEditFragment", "onAIFilterApplySuccess:");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.19.3(this));
      if (AEEditorImageEditFragment.a(this.a) != null) {
        break label105;
      }
    }
    label105:
    while (paramAIFilterResult == null)
    {
      return;
      AEQLog.b("AEEditorImageEditFragment", "onAIFilterAppliedFailed:" + paramInt);
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.19.2(this));
      break;
    }
    paramAIFilterResult = (BatchImageAIFilterResult)paramAIFilterResult;
    if (paramAIFilterResult != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt = 0;
      if (paramInt < AEEditorImageEditFragment.b(this.a))
      {
        if (paramInt == AEEditorImageEditFragment.a(this.a)) {
          localStringBuilder.append(AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt)).a() + "(当前图)|");
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if ((AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt)) != null) && (((SingleImageAIFilterResult)paramAIFilterResult.a.get(paramInt)).a))
          {
            AEEditorImageEditFragment.a(this.a).a(paramInt, AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt)));
            localStringBuilder.append(AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt)).a() + "(err)|");
          }
          else
          {
            AEEditorImageEditFragment.a(this.a).a((String)AEEditorImageEditFragment.b(this.a).get(paramInt), (AIFilterResult)paramAIFilterResult.a.get(paramInt));
            AEEditorImageEditFragment.a(this.a).put(String.valueOf(paramInt), this.a.a((AIFilterResult)paramAIFilterResult.a.get(paramInt)));
            AEEditorImageEditFragment.a(this.a).a(paramInt, (AIFilterResult)paramAIFilterResult.a.get(paramInt));
            localStringBuilder.append(((SingleImageAIFilterResult)paramAIFilterResult.a.get(paramInt)).a() + "|");
          }
        }
      }
      this.a.a("智能滤镜label", localStringBuilder.toString());
    }
    AEEditorImageEditFragment.d(this.a, AEEditorImageEditFragment.a(this.a));
    AEEditorImageEditFragment.e(this.a, AEEditorImageEditFragment.a(this.a));
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
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.19
 * JD-Core Version:    0.7.0.1
 */