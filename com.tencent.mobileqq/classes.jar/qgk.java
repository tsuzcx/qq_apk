import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import org.jetbrains.annotations.Nullable;

public class qgk
  extends qgf
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  @SuppressLint({"DefaultLocale"})
  public qgk(ViewGroup paramViewGroup, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString3)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString3;
    TextView localTextView2 = (TextView)a(2131380118);
    TextView localTextView1 = (TextView)a(2131380123);
    ((TextView)a(2131380120)).setText(paramString2);
    if (paramLong % 100L == 0L) {}
    for (paramViewGroup = String.valueOf(paramLong / 100L);; paramViewGroup = String.valueOf((float)paramLong / 100.0F))
    {
      localTextView2.setText(paramViewGroup);
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramString2 = new ColorDrawable(0);
      paramViewGroup.mFailedDrawable = paramString2;
      paramViewGroup.mLoadingDrawable = paramString2;
      paramViewGroup = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20200402/b05b6be7ab8245758e169dba373bfcbb.png", paramViewGroup);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramString2 = new ColorDrawable(0);
      paramViewGroup.mFailedDrawable = paramString2;
      paramViewGroup.mLoadingDrawable = paramString2;
      paramViewGroup.mRequestWidth = 414;
      paramViewGroup.mRequestHeight = 148;
      localTextView1.setBackgroundDrawable(URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/readinjoy/btn_bg_2x.png", paramViewGroup));
      localTextView1.setText(paramString1);
      localTextView1.setOnClickListener(new qgl(this, paramInt1, paramInt2, paramInt3));
      a(paramInt1, paramInt2, paramString3);
      return;
    }
  }
  
  View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562521, paramViewGroup, false);
  }
  
  protected void c()
  {
    a(0, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qgk
 * JD-Core Version:    0.7.0.1
 */