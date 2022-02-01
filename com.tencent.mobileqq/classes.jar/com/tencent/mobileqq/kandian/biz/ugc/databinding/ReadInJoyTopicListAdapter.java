package com.tencent.mobileqq.kandian.biz.ugc.databinding;

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

public class ReadInJoyTopicListAdapter
  extends SimpleAdapter
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131368578, 2131378647, 2131378646 };
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "key_cover_url", "key_title", "key_summary" };
  
  public ReadInJoyTopicListAdapter(Context paramContext, List<Map<String, CharSequence>> paramList)
  {
    super(paramContext, paramList, 2131560306, jdField_a_of_type_ArrayOfJavaLangString, jdField_a_of_type_ArrayOfInt);
  }
  
  public void setViewImage(ImageView paramImageView, String paramString)
  {
    if ("create_topic".equals(paramString))
    {
      paramImageView.setImageResource(2130849816);
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
      paramImageView = new StringBuilder();
      paramImageView.append("setViewImage: illegal url  - ");
      paramImageView.append(paramString);
      QLog.e("ReadInJoyTopicListAdapt", 2, paramImageView.toString(), localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter
 * JD-Core Version:    0.7.0.1
 */