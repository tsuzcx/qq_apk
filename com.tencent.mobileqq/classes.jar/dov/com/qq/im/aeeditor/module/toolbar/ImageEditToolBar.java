package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import blpq;

public class ImageEditToolBar
  extends AEEditorToolBar
{
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
    a(0, "text", 2130837650);
  }
  
  void a(String paramString)
  {
    if ((paramString.equals("text")) && (this.a != null) && ((this.a instanceof blpq))) {
      ((blpq)this.a).q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.ImageEditToolBar
 * JD-Core Version:    0.7.0.1
 */