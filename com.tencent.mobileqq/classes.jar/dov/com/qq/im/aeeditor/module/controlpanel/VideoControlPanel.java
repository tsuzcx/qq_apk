package dov.com.qq.im.aeeditor.module.controlpanel;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import bmlf;
import bmlj;
import bmlo;
import bmlw;
import bmma;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.LinkedList;
import java.util.List;

public class VideoControlPanel
  extends AEEditorControlPanelContainer
{
  private int jdField_a_of_type_Int;
  private bmlf jdField_a_of_type_Bmlf;
  private bmlw jdField_a_of_type_Bmlw;
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
  public List<bmlo> a()
  {
    if (this.jdField_a_of_type_Bmlw != null) {
      return this.jdField_a_of_type_Bmlw.a();
    }
    return new LinkedList();
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296278);
    this.b = ViewUtils.getScreenWidth();
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296352);
    this.jdField_a_of_type_Bmlw = new bmlw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bmlf = new bmlf(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bmlw != null) {
      this.jdField_a_of_type_Bmlw.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bmlf != null) {
      this.jdField_a_of_type_Bmlf.c(paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull bmlo parambmlo)
  {
    if (this.jdField_a_of_type_Bmlw != null) {
      this.jdField_a_of_type_Bmlw.a(parambmlo);
    }
  }
  
  public void a(@NonNull bmlo parambmlo, @Nullable Integer paramInteger, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bmlf != null) && (!this.jdField_a_of_type_Bmlf.isShowing())) {
      if (paramInteger == null) {
        break label66;
      }
    }
    label66:
    for (int i = paramInteger.intValue();; i = parambmlo.a())
    {
      this.jdField_a_of_type_Bmlf.a(parambmlo, i, paramInt, this.b, this.c, paramBoolean);
      a(i, i + paramInt);
      this.jdField_a_of_type_Bmlf.show();
      return;
    }
  }
  
  public void a(@NonNull List<bmlo> paramList)
  {
    if (this.jdField_a_of_type_Bmlw != null) {
      this.jdField_a_of_type_Bmlw.a(paramList);
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
    if ((this.jdField_a_of_type_Bmlf != null) && (this.jdField_a_of_type_Bmlf.isShowing())) {
      this.jdField_a_of_type_Bmlf.b(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bmlf != null) && (this.jdField_a_of_type_Bmlf.isShowing())) {
      this.jdField_a_of_type_Bmlf.b(paramInt1, paramInt2);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bmlw != null) && (!this.jdField_a_of_type_Bmlw.isShowing())) {
      this.jdField_a_of_type_Bmlw.show();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bmlw != null) && (this.jdField_a_of_type_Bmlw.isShowing())) {
      this.jdField_a_of_type_Bmlw.dismiss();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bmlw != null) {
      this.jdField_a_of_type_Bmlw.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bmlw != null) {
      this.jdField_a_of_type_Bmlw.a(false);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Bmlf != null) && (this.jdField_a_of_type_Bmlf.isShowing())) {
      this.jdField_a_of_type_Bmlf.dismiss();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bmlf != null) {
      this.jdField_a_of_type_Bmlf.c();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bmlw != null) {
      this.jdField_a_of_type_Bmlw.a();
    }
  }
  
  public void setBgmPlayed(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bmlw != null) {
      this.jdField_a_of_type_Bmlw.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setMusicListOperationCallback(@Nullable bmma parambmma)
  {
    if (this.jdField_a_of_type_Bmlw != null) {
      this.jdField_a_of_type_Bmlw.a(parambmma);
    }
  }
  
  public void setMusicLyricOperationCallback(@Nullable bmlj parambmlj)
  {
    if (this.jdField_a_of_type_Bmlf != null) {
      this.jdField_a_of_type_Bmlf.a(parambmlj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel
 * JD-Core Version:    0.7.0.1
 */