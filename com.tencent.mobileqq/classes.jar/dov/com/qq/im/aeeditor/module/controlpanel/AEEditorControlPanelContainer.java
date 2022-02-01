package dov.com.qq.im.aeeditor.module.controlpanel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bogc;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;

public abstract class AEEditorControlPanelContainer
  extends FrameLayout
{
  protected Context a;
  protected AEEditorFilterControlPanel a;
  
  public AEEditorControlPanelContainer(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public AEEditorControlPanelContainer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public AEEditorControlPanelContainer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public AEEditorFilterControlPanel a(bogc parambogc)
  {
    removeAllViews();
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel == null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel = new AEEditorFilterControlPanel(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFilterChangedComparator(parambogc);
    }
    parambogc = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel, parambogc);
    return this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel;
  }
  
  abstract void a();
  
  public void b()
  {
    removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.controlpanel.AEEditorControlPanelContainer
 * JD-Core Version:    0.7.0.1
 */