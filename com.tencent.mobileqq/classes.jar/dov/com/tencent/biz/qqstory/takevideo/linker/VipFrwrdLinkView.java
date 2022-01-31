package dov.com.tencent.biz.qqstory.takevideo.linker;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import uxp;
import uxq;
import wxe;

public class VipFrwrdLinkView
  extends FrameLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private uxp jdField_a_of_type_Uxp;
  
  public VipFrwrdLinkView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131559050, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365586));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365583));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699893, new Object[] { paramString1 }));
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) && (paramString2 != null)) {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
    }
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString2, paramString1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      wxe.b(getClass().getName(), "setIconURlDrawable:" + paramString2);
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void setLinkInfo(uxp paramuxp)
  {
    this.jdField_a_of_type_Uxp = paramuxp;
    if (this.jdField_a_of_type_Uxp.a == null) {
      return;
    }
    a(this.jdField_a_of_type_Uxp.a.f, this.jdField_a_of_type_Uxp.a.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.linker.VipFrwrdLinkView
 * JD-Core Version:    0.7.0.1
 */