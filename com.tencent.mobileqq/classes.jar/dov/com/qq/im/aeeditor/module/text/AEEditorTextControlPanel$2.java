package dov.com.qq.im.aeeditor.module.text;

import android.support.v7.widget.RecyclerView;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroup;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import java.util.List;

class AEEditorTextControlPanel$2
  implements AETextStickerCategoryAdapter.OnItemClickListener
{
  AEEditorTextControlPanel$2(AEEditorTextControlPanel paramAEEditorTextControlPanel, List paramList) {}
  
  public void a(int paramInt)
  {
    int i = 0;
    AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, true);
    AEEditorPagStickerGroup localAEEditorPagStickerGroup = (AEEditorPagStickerGroup)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localAEEditorPagStickerGroup.stickerInfoList.size() != 0)
    {
      AEEditorTextControlPanel localAEEditorTextControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel;
      RecyclerView localRecyclerView = AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel);
      if (paramInt == -1)
      {
        paramInt = i;
        AEEditorTextControlPanel.a(localAEEditorTextControlPanel, localRecyclerView, paramInt);
      }
    }
    else
    {
      if (AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel) != 10001) {
        break label122;
      }
      AEReportUtils.d(localAEEditorPagStickerGroup.stickerGroupId);
    }
    label122:
    while (AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel) != 10002)
    {
      return;
      paramInt = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(((AEEditorPagStickerInfo)localAEEditorPagStickerGroup.stickerInfoList.get(0)).stickerId, AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel));
      break;
    }
    AEReportUtils.p(localAEEditorPagStickerGroup.stickerGroupId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.2
 * JD-Core Version:    0.7.0.1
 */