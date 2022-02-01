package dov.com.qq.im.aeeditor.module.controlpanel;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import boax;
import bobb;
import bobg;
import bobo;
import bobs;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.LinkedList;
import java.util.List;

public class VideoControlPanel
  extends AEEditorControlPanelContainer
{
  private int jdField_a_of_type_Int;
  private boax jdField_a_of_type_Boax;
  private bobo jdField_a_of_type_Bobo;
  private int b;
  private int c;
  
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
  public List<bobg> a()
  {
    if (this.jdField_a_of_type_Bobo != null) {
      return this.jdField_a_of_type_Bobo.a();
    }
    return new LinkedList();
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296278);
    this.b = ViewUtils.getScreenWidth();
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296352);
    this.jdField_a_of_type_Bobo = new bobo(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Boax = new boax(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bobo != null) {
      this.jdField_a_of_type_Bobo.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boax != null) {
      this.jdField_a_of_type_Boax.c(paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull bobg parambobg)
  {
    if (this.jdField_a_of_type_Bobo != null) {
      this.jdField_a_of_type_Bobo.a(parambobg);
    }
  }
  
  public void a(@NonNull bobg parambobg, @Nullable Integer paramInteger, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boax != null) && (!this.jdField_a_of_type_Boax.isShowing())) {
      if (paramInteger == null) {
        break label66;
      }
    }
    label66:
    for (int i = paramInteger.intValue();; i = parambobg.a())
    {
      this.jdField_a_of_type_Boax.a(parambobg, i, paramInt, this.b, this.c, paramBoolean);
      a(i, i + paramInt);
      this.jdField_a_of_type_Boax.show();
      return;
    }
  }
  
  public void a(@NonNull List<bobg> paramList)
  {
    if (this.jdField_a_of_type_Bobo != null) {
      this.jdField_a_of_type_Bobo.a(paramList);
    }
  }
  
  public void b()
  {
    super.b();
    d();
    g();
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Boax != null) && (this.jdField_a_of_type_Boax.isShowing())) {
      this.jdField_a_of_type_Boax.b(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Boax != null) && (this.jdField_a_of_type_Boax.isShowing())) {
      this.jdField_a_of_type_Boax.b(paramInt1, paramInt2);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bobo != null) && (!this.jdField_a_of_type_Bobo.isShowing())) {
      this.jdField_a_of_type_Bobo.show();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bobo != null) && (this.jdField_a_of_type_Bobo.isShowing())) {
      this.jdField_a_of_type_Bobo.dismiss();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bobo != null) {
      this.jdField_a_of_type_Bobo.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bobo != null) {
      this.jdField_a_of_type_Bobo.a(false);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Boax != null) && (this.jdField_a_of_type_Boax.isShowing())) {
      this.jdField_a_of_type_Boax.dismiss();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boax != null) {
      this.jdField_a_of_type_Boax.c();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bobo != null) {
      this.jdField_a_of_type_Bobo.a();
    }
  }
  
  public void setBgmPlayed(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bobo != null) {
      this.jdField_a_of_type_Bobo.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setMusicListOperationCallback(@Nullable bobs parambobs)
  {
    if (this.jdField_a_of_type_Bobo != null) {
      this.jdField_a_of_type_Bobo.a(parambobs);
    }
  }
  
  public void setMusicLyricOperationCallback(@Nullable bobb parambobb)
  {
    if (this.jdField_a_of_type_Boax != null) {
      this.jdField_a_of_type_Boax.a(parambobb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel
 * JD-Core Version:    0.7.0.1
 */