import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class qsn
  extends SimpleAdapter
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131368041, 2131377802, 2131377801 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "key_cover_url", "key_title", "key_summary" };
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  
  public qsn(Context paramContext, List<Map<String, CharSequence>> paramList)
  {
    super(paramContext, paramList, 2131560139, jdField_a_of_type_ArrayOfJavaLangString, jdField_a_of_type_ArrayOfInt);
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    if ("create_topic".equals(paramString))
    {
      paramImageView.setImageResource(2130849000);
      return;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mRequestWidth = paramImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramImageView.getLayoutParams().height;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      QLog.e("ReadInJoyTopicListAdapt", 2, "setViewImage: illegal url  - " + paramString, localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsn
 * JD-Core Version:    0.7.0.1
 */