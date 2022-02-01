package dov.com.qq.im.aeeditor.module.aifilter;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;

class AEEditorAIFilterManager$1
  implements AIFilterProxyBase.AIFilterProxyCallback
{
  AEEditorAIFilterManager$1(AEEditorAIFilterManager paramAEEditorAIFilterManager, AppInterface paramAppInterface, AIFilterProxyBase paramAIFilterProxyBase, AEEditorAIFilterManager.AIFilterObserver paramAIFilterObserver) {}
  
  public void a(int paramInt)
  {
    AEQLog.b(AEEditorAIFilterManager.a(), "proxy onProcessFailed: errCode=" + paramInt);
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver.a(paramInt, this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterProxyBase.a());
    }
  }
  
  public void a(ArrayList<SmartFilterReqItem> paramArrayList)
  {
    AEQLog.b(AEEditorAIFilterManager.a(), "proxy onDataReadyForRequest");
    AEEditorAIFilterManager.a(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAIFilterManager, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramArrayList, new AEEditorAIFilterManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager.1
 * JD-Core Version:    0.7.0.1
 */