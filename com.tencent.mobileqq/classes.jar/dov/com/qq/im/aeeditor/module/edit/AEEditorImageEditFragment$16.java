package dov.com.qq.im.aeeditor.module.edit;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.aifilter.ComicsFilterResult;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import java.util.Map;
import mqq.os.MqqHandler;

class AEEditorImageEditFragment$16
  implements INetEngineListener
{
  AEEditorImageEditFragment$16(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, AEEditorFilterBean paramAEEditorFilterBean, int paramInt2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, null);
    if (AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment) == null) {}
    while (AEEditorImageEditFragment.b(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment)) {
      return;
    }
    if (paramNetResp.mRespData != null)
    {
      paramNetResp = AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, paramNetResp.mRespData, paramNetResp.reqCost, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      if (!TextUtils.isEmpty(paramNetResp))
      {
        paramNetResp = new ComicsFilterResult(paramNetResp);
        AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment).put(AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean), paramNetResp);
        AEEditorImageEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment, this.jdField_a_of_type_Int, paramNetResp, this.b, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
        return;
      }
      AEQLog.d("AEEditorImageEditFragment", "processComicResponse return path is empty");
      ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.16.1(this));
      return;
    }
    AEBaseDataReporter.a().a(paramNetResp.mErrCode, paramNetResp.reqCost + "", "lut_comics", -2);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.16.2(this));
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.16
 * JD-Core Version:    0.7.0.1
 */