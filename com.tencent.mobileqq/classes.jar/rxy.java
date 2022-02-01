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

public class rxy
  extends SimpleAdapter
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131368621, 2131378855, 2131378854 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "key_cover_url", "key_title", "key_summary" };
  
  public rxy(Context paramContext, List<Map<String, CharSequence>> paramList)
  {
    super(paramContext, paramList, 2131560348, jdField_a_of_type_ArrayOfJavaLangString, jdField_a_of_type_ArrayOfInt);
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    if ("create_topic".equals(paramString))
    {
      paramImageView.setImageResource(2130849539);
      return;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localURLDrawableOptions.mRequestWidth = paramImageView.getLayoutParams().width;
      localURLDrawableOptions.mRequestHeight = paramImageView.getLayoutParams().height;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      paramImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      QLog.e("ReadInJoyTopicListAdapt", 2, "setViewImage: illegal url  - " + paramString, localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxy
 * JD-Core Version:    0.7.0.1
 */