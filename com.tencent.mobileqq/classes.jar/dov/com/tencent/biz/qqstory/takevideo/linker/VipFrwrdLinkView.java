package dov.com.tencent.biz.qqstory.takevideo.linker;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import teo;
import tep;
import ved;

public class VipFrwrdLinkView
  extends FrameLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private teo jdField_a_of_type_Teo;
  
  public VipFrwrdLinkView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131559012, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365499));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365496));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699526, new Object[] { paramString1 }));
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) && (paramString2 != null)) {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
    }
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString2, paramString1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      ved.b(getClass().getName(), "setIconURlDrawable:" + paramString2);
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setLinkInfo(teo paramteo)
  {
    this.jdField_a_of_type_Teo = paramteo;
    if (this.jdField_a_of_type_Teo.a == null) {
      return;
    }
    a(this.jdField_a_of_type_Teo.a.f, this.jdField_a_of_type_Teo.a.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView
 * JD-Core Version:    0.7.0.1
 */