import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;

public class qak
  extends qah
{
  private qal jdField_a_of_type_Qal;
  private boolean jdField_a_of_type_Boolean = true;
  
  public qak(pzs parampzs, qal paramqal)
  {
    super(parampzs, paramqal);
    this.jdField_a_of_type_Qal = paramqal;
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    super.a(paramVideoInfo, paramBoolean);
    paramVideoInfo = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Qal.g.getLayoutParams();
    paramVideoInfo.bottomMargin = aciy.a(61.0F, pzs.a(this.jdField_a_of_type_Pzs).getResources());
    this.jdField_a_of_type_Qal.g.setLayoutParams(paramVideoInfo);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) || (!paramBoolean2)) {
      this.jdField_a_of_type_Qal.w.setVisibility(8);
    }
    for (;;)
    {
      super.a(paramBoolean1, paramBoolean2);
      return;
      if (paramBoolean2)
      {
        this.jdField_a_of_type_Qal.w.setVisibility(0);
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Qal.w.getVisibility() == 8) {
      qcn.a(this.jdField_a_of_type_Qal.w, 0);
    }
    super.c(paramBoolean);
  }
  
  protected void h(boolean paramBoolean)
  {
    super.h(paramBoolean);
    if (paramBoolean)
    {
      if ((!pzs.a(this.jdField_a_of_type_Pzs)) && (this.jdField_a_of_type_Qal.w.getVisibility() == 8)) {
        qcn.a(this.jdField_a_of_type_Qal.w, 0);
      }
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Qal.w.getVisibility() == 0)) {
      qcn.a(this.jdField_a_of_type_Qal.w, 8);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qak
 * JD-Core Version:    0.7.0.1
 */