package dov.com.qq.im.aeeditor.module.text;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import java.util.List;

class AEEditorTextControlPanel$3
  extends RecyclerView.OnScrollListener
{
  AEEditorTextControlPanel$3(AEEditorTextControlPanel paramAEEditorTextControlPanel, List paramList) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((AEEditorTextControlPanel.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel)) && (paramInt == 0))
    {
      AEEditorTextControlPanel.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, false);
      AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, paramRecyclerView, AEEditorTextControlPanel.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel));
    }
    while (paramInt != 0) {
      return;
    }
    AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, false);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (!AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel))
    {
      paramInt1 = AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel).findFirstVisibleItemPosition();
      paramInt1 = AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, ((AEEditorTextBean)AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel).get(paramInt1)).parentId, this.jdField_a_of_type_JavaUtilList);
      AEEditorTextControlPanel.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel).smoothScrollToPosition(paramInt1);
      AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel).a(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.3
 * JD-Core Version:    0.7.0.1
 */