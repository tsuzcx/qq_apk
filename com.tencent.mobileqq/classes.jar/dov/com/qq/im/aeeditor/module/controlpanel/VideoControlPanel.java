package dov.com.qq.im.aeeditor.module.controlpanel;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import bgtn;
import bogo;
import bogs;
import bogx;
import bohf;
import bohj;
import java.util.LinkedList;
import java.util.List;

public class VideoControlPanel
  extends AEEditorControlPanelContainer
{
  private int jdField_a_of_type_Int;
  private bogo jdField_a_of_type_Bogo;
  private bohf jdField_a_of_type_Bohf;
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
  public List<bogx> a()
  {
    if (this.jdField_a_of_type_Bohf != null) {
      return this.jdField_a_of_type_Bohf.a();
    }
    return new LinkedList();
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296275);
    this.b = bgtn.a();
    this.c = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296295);
    this.jdField_a_of_type_Bohf = new bohf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bogo = new bogo(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bohf != null) {
      this.jdField_a_of_type_Bohf.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bogo != null) {
      this.jdField_a_of_type_Bogo.c(paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull bogx parambogx)
  {
    if (this.jdField_a_of_type_Bohf != null) {
      this.jdField_a_of_type_Bohf.a(parambogx);
    }
  }
  
  public void a(@NonNull bogx parambogx, @Nullable Integer paramInteger, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bogo != null) && (!this.jdField_a_of_type_Bogo.isShowing())) {
      if (paramInteger == null) {
        break label66;
      }
    }
    label66:
    for (int i = paramInteger.intValue();; i = parambogx.a())
    {
      this.jdField_a_of_type_Bogo.a(parambogx, i, paramInt, this.b, this.c, paramBoolean);
      a(i, i + paramInt);
      this.jdField_a_of_type_Bogo.show();
      return;
    }
  }
  
  public void a(@NonNull List<bogx> paramList)
  {
    if (this.jdField_a_of_type_Bohf != null) {
      this.jdField_a_of_type_Bohf.a(paramList);
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
    if ((this.jdField_a_of_type_Bogo != null) && (this.jdField_a_of_type_Bogo.isShowing())) {
      this.jdField_a_of_type_Bogo.b(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bogo != null) && (this.jdField_a_of_type_Bogo.isShowing())) {
      this.jdField_a_of_type_Bogo.b(paramInt1, paramInt2);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bohf != null) && (!this.jdField_a_of_type_Bohf.isShowing())) {
      this.jdField_a_of_type_Bohf.show();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Bohf != null) && (this.jdField_a_of_type_Bohf.isShowing())) {
      this.jdField_a_of_type_Bohf.dismiss();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bohf != null) {
      this.jdField_a_of_type_Bohf.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bohf != null) {
      this.jdField_a_of_type_Bohf.a(false);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Bogo != null) && (this.jdField_a_of_type_Bogo.isShowing())) {
      this.jdField_a_of_type_Bogo.dismiss();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Bogo != null) {
      this.jdField_a_of_type_Bogo.c();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Bohf != null) {
      this.jdField_a_of_type_Bohf.a();
    }
  }
  
  public void setBgmPlayed(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Bohf != null) {
      this.jdField_a_of_type_Bohf.a(paramBoolean1, paramBoolean2);
    }
  }
  
  public void setMusicListOperationCallback(@Nullable bohj parambohj)
  {
    if (this.jdField_a_of_type_Bohf != null) {
      this.jdField_a_of_type_Bohf.a(parambohj);
    }
  }
  
  public void setMusicLyricOperationCallback(@Nullable bogs parambogs)
  {
    if (this.jdField_a_of_type_Bogo != null) {
      this.jdField_a_of_type_Bogo.a(parambogs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel
 * JD-Core Version:    0.7.0.1
 */