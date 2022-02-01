package dov.com.qq.im.aeeditor.module.autotemplate;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import java.util.List;

class AEEditorAutoTemplatePanel$2
  extends RecyclerView.OnScrollListener
{
  AEEditorAutoTemplatePanel$2(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((AEEditorAutoTemplatePanel.b(this.a)) && (paramInt == 0))
    {
      AEEditorAutoTemplatePanel.b(this.a, false);
      AEEditorAutoTemplatePanel.a(this.a, paramRecyclerView, AEEditorAutoTemplatePanel.a(this.a));
    }
    while (paramInt != 0) {
      return;
    }
    AEEditorAutoTemplatePanel.a(this.a, false);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (!AEEditorAutoTemplatePanel.a(this.a))
    {
      paramInt1 = AEEditorAutoTemplatePanel.a(this.a).findFirstVisibleItemPosition();
      paramInt1 = AEEditorAutoTemplatePanel.a(this.a, ((AEEditorAutoTemplateBean)AEEditorAutoTemplatePanel.a(this.a).a().get(paramInt1)).parentId, AEEditorAutoTemplatePanel.a(this.a).a());
      AEEditorAutoTemplatePanel.b(this.a).smoothScrollToPosition(paramInt1);
      AEEditorAutoTemplatePanel.a(this.a).a(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.2
 * JD-Core Version:    0.7.0.1
 */