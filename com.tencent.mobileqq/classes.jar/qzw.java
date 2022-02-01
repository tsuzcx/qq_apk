import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class qzw
  extends qzn
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  @SuppressLint({"DefaultLocale"})
  public qzw(ViewGroup paramViewGroup, long paramLong, String paramString1, @NotNull qzh paramqzh, String paramString2, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString3)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString3;
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    Object localObject2 = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    localObject1 = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200402/3aeb63b5612d43a3b555782b6d77b0e2.png", (URLDrawable.URLDrawableOptions)localObject1);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    TextView localTextView1 = (TextView)a(2131381082);
    TextView localTextView2 = (TextView)a(2131381084);
    TextView localTextView3 = (TextView)a(2131381089);
    TextView localTextView4 = (TextView)a(2131381090);
    localObject2 = (TextView)a(2131381087);
    ImageView localImageView = (ImageView)a(2131381079);
    if (paramLong % 100L == 0L) {}
    for (localObject1 = String.valueOf(paramLong / 100L);; localObject1 = String.valueOf((float)paramLong / 100.0F))
    {
      localTextView1.setText((CharSequence)localObject1);
      localTextView3.setText(paramqzh.b);
      localTextView4.setText(paramqzh.c);
      ((TextView)localObject2).setText(paramString2);
      localTextView2.setText(paramString1);
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString2 = new ColorDrawable(0);
      paramString1.mFailedDrawable = paramString2;
      paramString1.mLoadingDrawable = paramString2;
      paramString1.mRequestWidth = 414;
      paramString1.mRequestHeight = 148;
      ((TextView)localObject2).setBackgroundDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/readinjoy/btn_bg_2x.png", paramString1));
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup = paramViewGroup.getContext().getResources().getDrawable(2130845420);
      paramString1.mFailedDrawable = paramViewGroup;
      paramString1.mLoadingDrawable = paramViewGroup;
      paramViewGroup = URLDrawable.getDrawable(paramqzh.jdField_a_of_type_JavaLangString, paramString1);
      paramViewGroup.setDecodeHandler(bgey.a);
      localImageView.setImageDrawable(paramViewGroup);
      ((TextView)localObject2).setOnClickListener(new qzx(this, paramInt1, paramInt2, paramInt3));
      a(paramInt1, paramInt2, paramString3);
      return;
    }
  }
  
  View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562760, paramViewGroup, false);
  }
  
  protected void c()
  {
    a(0, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzw
 * JD-Core Version:    0.7.0.1
 */