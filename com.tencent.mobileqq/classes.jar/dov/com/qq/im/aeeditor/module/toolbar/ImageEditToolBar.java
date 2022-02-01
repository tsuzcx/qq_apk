package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import bmby;
import bmnh;

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
    this.jdField_a_of_type_Boolean = bmby.a();
    a(0, "text", 2130837717, 2130837648);
  }
  
  void a(String paramString)
  {
    if ((paramString.equals("text")) && (this.jdField_a_of_type_Bmng != null) && ((this.jdField_a_of_type_Bmng instanceof bmnh))) {
      ((bmnh)this.jdField_a_of_type_Bmng).x();
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