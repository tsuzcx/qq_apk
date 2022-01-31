import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;

public class qam
  extends qah
{
  private qan jdField_a_of_type_Qan;
  private boolean jdField_a_of_type_Boolean = true;
  
  public qam(pzs parampzs, qan paramqan)
  {
    super(parampzs, paramqan);
    this.jdField_a_of_type_Qan = paramqan;
  }
  
  private void k(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_Qan.a != null)
    {
      localView = this.jdField_a_of_type_Qan.a;
      if (!paramBoolean) {
        break label30;
      }
    }
    label30:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    if ((TextUtils.isEmpty(paramVideoInfo.c)) || (paramVideoInfo.a(pzs.a(this.jdField_a_of_type_Pzs))))
    {
      k(false);
      return;
    }
    k(true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (!paramBoolean2))
    {
      this.jdField_a_of_type_Qan.w.setVisibility(8);
      k(false);
    }
    for (;;)
    {
      super.a(paramBoolean1, paramBoolean2);
      return;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_Qan.w.setVisibility(0);
        k(true);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Qan.w.getVisibility() == 8) {
      qcn.a(this.jdField_a_of_type_Qan.w, 0);
    }
    if ((this.jdField_a_of_type_Qan.a != null) && (this.jdField_a_of_type_Qan.a.getVisibility() == 8)) {
      qcn.a(this.jdField_a_of_type_Qan.a, 0);
    }
    super.c(paramBoolean);
  }
  
  protected void h(boolean paramBoolean)
  {
    super.h(paramBoolean);
    if (paramBoolean)
    {
      if ((!pzs.a(this.jdField_a_of_type_Pzs)) && (this.jdField_a_of_type_Qan.w.getVisibility() == 8)) {
        qcn.a(this.jdField_a_of_type_Qan.w, 0);
      }
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Qan.w.getVisibility() == 0) {
        qcn.a(this.jdField_a_of_type_Qan.w, 8);
      }
      if ((this.jdField_a_of_type_Qan.a != null) && (this.jdField_a_of_type_Qan.a.getVisibility() == 0)) {
        qcn.a(this.jdField_a_of_type_Qan.a, 8);
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qam
 * JD-Core Version:    0.7.0.1
 */