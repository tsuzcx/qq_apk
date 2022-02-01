import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import org.jetbrains.annotations.Nullable;

public class qzu
  extends qzn
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public qzu(ViewGroup paramViewGroup, String paramString1, String paramString2, int paramInt1, int paramInt2, @Nullable String paramString3)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString3;
    paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = new ColorDrawable(0);
    paramViewGroup.mFailedDrawable = ((Drawable)localObject);
    paramViewGroup.mLoadingDrawable = ((Drawable)localObject);
    paramViewGroup = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200313/b37cb1e721304575af379f97ce72c115.png", paramViewGroup);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
    localObject = (TextView)a(2131381090);
    paramViewGroup = (TextView)a(2131381087);
    ((TextView)localObject).setText(paramString1);
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramString1.mFailedDrawable = ((Drawable)localObject);
    paramString1.mLoadingDrawable = ((Drawable)localObject);
    paramViewGroup.setBackgroundDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/readinjoy/btn_bg_2x.png", paramString1));
    paramViewGroup.setText(paramString2);
    paramViewGroup.setOnClickListener(new qzv(this));
    a(paramInt1, paramInt2, paramString3);
  }
  
  View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562759, paramViewGroup, false);
  }
  
  protected void c()
  {
    a(0, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzu
 * JD-Core Version:    0.7.0.1
 */