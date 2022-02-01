package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import bnzc;
import boiq;

public class ImageEditToolBar
  extends AEEditorToolBar
{
  private boolean a;
  
  public ImageEditToolBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImageEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ImageEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = bnzc.a();
    a(0, "text", 2130837701, 2130837646);
  }
  
  void a(String paramString)
  {
    if ((paramString.equals("text")) && (this.jdField_a_of_type_Boip != null) && ((this.jdField_a_of_type_Boip instanceof boiq))) {
      ((boiq)this.jdField_a_of_type_Boip).v();
    }
  }
  
  protected boolean a(String paramString)
  {
    return "text".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.ImageEditToolBar
 * JD-Core Version:    0.7.0.1
 */