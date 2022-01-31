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

public class qgo
  extends qgf
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  @SuppressLint({"DefaultLocale"})
  public qgo(ViewGroup paramViewGroup, long paramLong, String paramString1, @NotNull qfz paramqfz, String paramString2, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString3)
  {
    super(paramViewGroup);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString3;
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    Object localObject2 = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    localObject1 = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20200402/3aeb63b5612d43a3b555782b6d77b0e2.png", (URLDrawable.URLDrawableOptions)localObject1);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    TextView localTextView1 = (TextView)a(2131380060);
    TextView localTextView2 = (TextView)a(2131380062);
    TextView localTextView3 = (TextView)a(2131380067);
    TextView localTextView4 = (TextView)a(2131380068);
    localObject2 = (TextView)a(2131380065);
    ImageView localImageView = (ImageView)a(2131380057);
    if (paramLong % 100L == 0L) {}
    for (localObject1 = String.valueOf(paramLong / 100L);; localObject1 = String.valueOf((float)paramLong / 100.0F))
    {
      localTextView1.setText((CharSequence)localObject1);
      localTextView3.setText(paramqfz.b);
      localTextView4.setText(paramqfz.c);
      ((TextView)localObject2).setText(paramString2);
      localTextView2.setText(paramString1);
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString2 = new ColorDrawable(0);
      paramString1.mFailedDrawable = paramString2;
      paramString1.mLoadingDrawable = paramString2;
      paramString1.mRequestWidth = 414;
      paramString1.mRequestHeight = 148;
      ((TextView)localObject2).setBackgroundDrawable(URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/readinjoy/btn_bg_2x.png", paramString1));
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup = paramViewGroup.getContext().getResources().getDrawable(2130844950);
      paramString1.mFailedDrawable = paramViewGroup;
      paramString1.mLoadingDrawable = paramViewGroup;
      paramViewGroup = URLDrawable.getDrawable(paramqfz.jdField_a_of_type_JavaLangString, paramString1);
      paramViewGroup.setDecodeHandler(bcuq.a);
      localImageView.setImageDrawable(paramViewGroup);
      ((TextView)localObject2).setOnClickListener(new qgp(this, paramInt1, paramInt2, paramInt3));
      a(paramInt1, paramInt2, paramString3);
      return;
    }
  }
  
  View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562505, paramViewGroup, false);
  }
  
  protected void c()
  {
    a(0, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qgo
 * JD-Core Version:    0.7.0.1
 */