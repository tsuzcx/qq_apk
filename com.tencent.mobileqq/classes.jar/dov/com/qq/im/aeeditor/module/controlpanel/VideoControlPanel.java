package dov.com.qq.im.aeeditor.module.controlpanel;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import bhtq;
import bpij;
import bpin;
import bpis;
import bpja;
import bpje;
import java.util.LinkedList;
import java.util.List;

public class VideoControlPanel
  extends AEEditorControlPanelContainer
{
  private int jdField_a_of_type_Int;
  private bpij jdField_a_of_type_Bpij;
  private bpja jdField_a_of_type_Bpja;
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
  public List<bpis> a()
  {
    if (this.jdField_a_of_type_Bpja != null) {
      return this.jdField_a_of_type_Bpja.a();
    }
    return new LinkedList();
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296277);
    this.b = bhtq.a();
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296299);
    this.jdField_a_of_type_Bpja = new bpja(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bpij = new bpij(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bpja != null) {
      this.jdField_a_of_type_Bpja.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bpij != null) {
      this.jdField_a_of_type_Bpij.c(paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull bpis parambpis)
  {
    if (this.jdField_a_of_type_Bpja != null) {
      this.jdField_a_of_type_Bpja.a(parambpis);
    }
  }
  
  public void a(@NonNull bpis parambpis, @Nullable Integer paramInteger, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bpij != null) && (!this.jdField_a_of_type_Bpij.isShowing())) {
      if (paramInteger == null) {
        break label66;
      }
    }
    label66:
    for (int i = paramInteger.intValue();; i = parambpis.a())
    {
      this.jdField_a_of_type_Bpij.a(parambpis, i, paramInt, this.b, this.c, paramBoolean);
      a(i, i + paramInt);
      this.jdField_a_of_type_Bpij.show();
      return;
    }
  }
  
  public void a(@NonNull List<bpis> paramList)
  {
    if (this.jdField_a_of_type_Bpja != null) {
      this.jdField_a_of_type_Bpja.a(paramList);
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
    if ((this.jdField_a_of_type_Bpij != null) && (this.jdField_a_of_type_Bpij.isShowing())) {
      this.jdField_a_of_type_Bpij.b(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bpij != null) && (this.jdField_a_of_type_Bpij.isShowing())) {
      this.jdField_a_of_type_Bpij.b(paramInt1, paramInt2);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bpja != null) && (!this.jdField_a_of_type_Bpja.isShowing())) {
      this.jdField_a_of_type_Bpja.show();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bpja != null) && (this.jdField_a_of_type_Bpja.isShowing())) {
      this.jdField_a_of_type_Bpja.dismiss();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bpja != null) {
      this.jdField_a_of_type_Bpja.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bpja != null) {
      this.jdField_a_of_type_Bpja.a(false);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Bpij != null) && (this.jdField_a_of_type_Bpij.isShowing())) {
      this.jdField_a_of_type_Bpij.dismiss();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bpij != null) {
      this.jdField_a_of_type_Bpij.c();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bpja != null) {
      this.jdField_a_of_type_Bpja.a();
    }
  }
  
  public void setBgmPlayed(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bpja != null) {
      this.jdField_a_of_type_Bpja.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setMusicListOperationCallback(@Nullable bpje parambpje)
  {
    if (this.jdField_a_of_type_Bpja != null) {
      this.jdField_a_of_type_Bpja.a(parambpje);
    }
  }
  
  public void setMusicLyricOperationCallback(@Nullable bpin parambpin)
  {
    if (this.jdField_a_of_type_Bpij != null) {
      this.jdField_a_of_type_Bpij.a(parambpin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel
 * JD-Core Version:    0.7.0.1
 */