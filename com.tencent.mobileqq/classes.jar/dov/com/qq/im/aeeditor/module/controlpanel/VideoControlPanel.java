package dov.com.qq.im.aeeditor.module.controlpanel;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import bljv;
import blkd;
import blkf;
import java.util.LinkedList;
import java.util.List;

public class VideoControlPanel
  extends AEEditorControlPanelContainer
{
  private blkd a;
  
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
  public List<bljv> a()
  {
    if (this.jdField_a_of_type_Blkd != null) {
      return this.jdField_a_of_type_Blkd.a();
    }
    return new LinkedList();
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296269);
    this.jdField_a_of_type_Blkd = new blkd(this.jdField_a_of_type_AndroidContentContext, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Blkd != null) {
      this.jdField_a_of_type_Blkd.a(paramInt);
    }
  }
  
  public void a(@NonNull bljv parambljv)
  {
    if (this.jdField_a_of_type_Blkd != null) {
      this.jdField_a_of_type_Blkd.a(parambljv);
    }
  }
  
  public void a(@NonNull List<bljv> paramList)
  {
    if (this.jdField_a_of_type_Blkd != null) {
      this.jdField_a_of_type_Blkd.a(paramList);
    }
  }
  
  public void b()
  {
    super.b();
    d();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Blkd != null) {
      this.jdField_a_of_type_Blkd.show();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Blkd != null) && (this.jdField_a_of_type_Blkd.isShowing())) {
      this.jdField_a_of_type_Blkd.dismiss();
    }
  }
  
  public void setBackgroundMusicChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Blkd != null) {
      this.jdField_a_of_type_Blkd.a(paramBoolean);
    }
  }
  
  public void setMusicOperationCallback(@Nullable blkf paramblkf)
  {
    if (this.jdField_a_of_type_Blkd != null) {
      this.jdField_a_of_type_Blkd.a(paramblkf);
    }
  }
  
  public void setOriginalSoundChecked(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Blkd != null) {
      this.jdField_a_of_type_Blkd.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel
 * JD-Core Version:    0.7.0.1
 */