package dov.com.tencent.biz.qqstory.takevideo.linker;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import ter;
import tes;
import veg;

public class VipFrwrdLinkView
  extends FrameLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private ter jdField_a_of_type_Ter;
  
  public VipFrwrdLinkView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131559012, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365500));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365497));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699515, new Object[] { paramString1 }));
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) && (paramString2 != null)) {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
    }
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString2, paramString1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      veg.b(getClass().getName(), "setIconURlDrawable:" + paramString2);
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setLinkInfo(ter paramter)
  {
    this.jdField_a_of_type_Ter = paramter;
    if (this.jdField_a_of_type_Ter.a == null) {
      return;
    }
    a(this.jdField_a_of_type_Ter.a.f, this.jdField_a_of_type_Ter.a.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView
 * JD-Core Version:    0.7.0.1
 */