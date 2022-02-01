package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import dov.com.qq.im.ae.util.AEThemeUtil;

public class VideoEditToolBar
  extends AEEditorToolBar
{
  private boolean a;
  private boolean b = false;
  
  public VideoEditToolBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void a()
  {
    this.b = AEThemeUtil.a();
    a(0, "clip", 2130837741, 2130837653);
    a(1, "text", 2130837744, 2130837653);
    a(2, "music", 2130837944, 2130837653);
  }
  
  void a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar$ToolBarBaseListener != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar$ToolBarBaseListener instanceof VideoEditToolBar.VideoToolBarListener)) {
        localObject1 = (VideoEditToolBar.VideoToolBarListener)this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar$ToolBarBaseListener;
      }
    }
    if (paramString.equals("clip")) {
      if (localObject1 != null) {
        ((VideoEditToolBar.VideoToolBarListener)localObject1).A();
      }
    }
    do
    {
      do
      {
        return;
        if (!paramString.equals("text")) {
          break;
        }
      } while (localObject1 == null);
      ((VideoEditToolBar.VideoToolBarListener)localObject1).B();
      return;
    } while ((!paramString.equals("music")) || (localObject1 == null));
    ((VideoEditToolBar.VideoToolBarListener)localObject1).D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar
 * JD-Core Version:    0.7.0.1
 */