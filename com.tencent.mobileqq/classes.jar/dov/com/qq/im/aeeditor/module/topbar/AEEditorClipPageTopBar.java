package dov.com.qq.im.aeeditor.module.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import blpu;
import dov.com.qq.im.aeeditor.view.AEEditorClipIndexView;

public class AEEditorClipPageTopBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private blpu jdField_a_of_type_Blpu;
  private AEEditorClipIndexView jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView;
  
  public AEEditorClipPageTopBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEEditorClipPageTopBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEEditorClipPageTopBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2131558524, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131362173));
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView = ((AEEditorClipIndexView)paramContext.findViewById(2131362174));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131362173) {
      if (this.jdField_a_of_type_Blpu != null) {
        this.jdField_a_of_type_Blpu.a();
      }
    }
    while ((i != 2131362174) || (this.jdField_a_of_type_Blpu == null)) {
      return;
    }
    this.jdField_a_of_type_Blpu.b();
  }
  
  public void setClipPageTopBarClickListener(blpu paramblpu)
  {
    this.jdField_a_of_type_Blpu = paramblpu;
  }
  
  public void setIndex(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView.setIndex(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.topbar.AEEditorClipPageTopBar
 * JD-Core Version:    0.7.0.1
 */