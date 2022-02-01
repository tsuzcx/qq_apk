package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import dov.com.qq.im.ae.util.AEThemeUtil;

public class ImageEditToolBar
  extends AEEditorToolBar
{
  private boolean a;
  
  public ImageEditToolBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ImageEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ImageEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = AEThemeUtil.a();
    a(0, "text", 2130837744, 2130837653);
  }
  
  void a(String paramString)
  {
    if ((paramString.equals("text")) && (this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar$ToolBarBaseListener != null) && ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar$ToolBarBaseListener instanceof ImageEditToolBar.ImageToolBarListener))) {
      ((ImageEditToolBar.ImageToolBarListener)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar$ToolBarBaseListener).A();
    }
  }
  
  protected boolean a(String paramString)
  {
    return "text".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.ImageEditToolBar
 * JD-Core Version:    0.7.0.1
 */