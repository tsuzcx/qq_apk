import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qzp
  extends qzn
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private raj jdField_a_of_type_Raj;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public qzp(ViewGroup paramViewGroup, String paramString1, String paramString2, raj paramraj, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_Raj = paramraj;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString3;
    paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
    paramraj = new ColorDrawable(0);
    paramViewGroup.mFailedDrawable = paramraj;
    paramViewGroup.mLoadingDrawable = paramraj;
    paramViewGroup = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200313/09d27592d8034af2a494db92ca9e8e25.png", paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((TextView)a(2131370480)).setText(paramString1);
    ((TextView)a(2131378008)).setText(paramString2);
    a(paramInt1, paramInt2, paramString3);
  }
  
  View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562756, paramViewGroup, false);
  }
  
  protected void c()
  {
    a(0, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (this.jdField_a_of_type_Boolean) {
      QQToast.a(BaseApplicationImpl.getContext(), 0, BaseApplicationImpl.getContext().getString(2131714478), 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetImageView)
      {
        a(1, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Raj.a(this.jdField_a_of_type_Int, this.b, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzp
 * JD-Core Version:    0.7.0.1
 */