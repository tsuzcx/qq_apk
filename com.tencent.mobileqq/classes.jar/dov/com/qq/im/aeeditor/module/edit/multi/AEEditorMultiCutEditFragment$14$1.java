package dov.com.qq.im.aeeditor.module.edit.multi;

import android.arch.lifecycle.MutableLiveData;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import dov.com.qq.im.aeeditor.module.edit.multi.action.ActionFactory;
import dov.com.qq.im.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;

class AEEditorMultiCutEditFragment$14$1
  implements DialogInterface.OnClickListener
{
  AEEditorMultiCutEditFragment$14$1(AEEditorMultiCutEditFragment.14 param14, CutModelKt paramCutModelKt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a, this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getResource().getPath());
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a, 0L);
    AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a).a.postValue(ActionFactory.a(this.jdField_a_of_type_ComTencentWeseevideoCameraMvautoRedoCutModelKt.getUuid(), AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a), AEEditorMultiCutEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditMultiAEEditorMultiCutEditFragment$14.a).getMediaModel()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.14.1
 * JD-Core Version:    0.7.0.1
 */