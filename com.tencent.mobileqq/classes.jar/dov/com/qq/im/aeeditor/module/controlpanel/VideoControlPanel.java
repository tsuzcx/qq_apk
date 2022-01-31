package dov.com.qq.im.aeeditor.module.controlpanel;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import bloh;
import blop;
import blor;
import java.util.LinkedList;
import java.util.List;

public class VideoControlPanel
  extends AEEditorControlPanelContainer
{
  private blop a;
  
  public VideoControlPanel(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @NonNull
  public List<bloh> a()
  {
    if (this.jdField_a_of_type_Blop != null) {
      return this.jdField_a_of_type_Blop.a();
    }
    return new LinkedList();
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296269);
    this.jdField_a_of_type_Blop = new blop(this.jdField_a_of_type_AndroidContentContext, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Blop != null) {
      this.jdField_a_of_type_Blop.a(paramInt);
    }
  }
  
  public void a(@NonNull bloh parambloh)
  {
    if (this.jdField_a_of_type_Blop != null) {
      this.jdField_a_of_type_Blop.a(parambloh);
    }
  }
  
  public void a(@NonNull List<bloh> paramList)
  {
    if (this.jdField_a_of_type_Blop != null) {
      this.jdField_a_of_type_Blop.a(paramList);
    }
  }
  
  public void b()
  {
    super.b();
    d();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Blop != null) {
      this.jdField_a_of_type_Blop.show();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Blop != null) && (this.jdField_a_of_type_Blop.isShowing())) {
      this.jdField_a_of_type_Blop.dismiss();
    }
  }
  
  public void setBackgroundMusicChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Blop != null) {
      this.jdField_a_of_type_Blop.a(paramBoolean);
    }
  }
  
  public void setMusicOperationCallback(@Nullable blor paramblor)
  {
    if (this.jdField_a_of_type_Blop != null) {
      this.jdField_a_of_type_Blop.a(paramblor);
    }
  }
  
  public void setOriginalSoundChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Blop != null) {
      this.jdField_a_of_type_Blop.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel
 * JD-Core Version:    0.7.0.1
 */