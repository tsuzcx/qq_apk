package cooperation.qzone.contentbox;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import bbll;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.util.ArrayList;

public class QzoneMsgPagerAdapter
  extends PagerAdapter
{
  private static final int jdField_a_of_type_Int = bbll.a() - bbll.b(24.0F);
  private static final int jdField_b_of_type_Int = bbll.b(230.0F);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<AnyScaleTypeImageView> jdField_b_of_type_JavaUtilArrayList;
  
  public QzoneMsgPagerAdapter(Context paramContext, ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(i);
      while (j < i)
      {
        AnyScaleTypeImageView localAnyScaleTypeImageView = new AnyScaleTypeImageView(paramContext);
        localAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ThemeUtil.setColorFilterIfNeed(localAnyScaleTypeImageView);
        this.jdField_b_of_type_JavaUtilArrayList.add(localAnyScaleTypeImageView);
        j += 1;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) || (paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilArrayList.size())) {
      return;
    }
    paramObject = (AnyScaleTypeImageView)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    paramObject.setImageDrawable(null);
    paramViewGroup.removeView(paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() == 0) || (paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    AnyScaleTypeImageView localAnyScaleTypeImageView = (AnyScaleTypeImageView)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = jdField_a_of_type_Int;
    localURLDrawableOptions.mRequestHeight = jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) != null))
    {
      if ((!((String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).startsWith("http")) && (!((String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).startsWith("https"))) {
        break label157;
      }
      localAnyScaleTypeImageView.setImageDrawable(URLDrawable.getDrawable((String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), localURLDrawableOptions));
    }
    for (;;)
    {
      paramViewGroup.addView(localAnyScaleTypeImageView);
      return this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
      label157:
      localAnyScaleTypeImageView.setImageDrawable(URLDrawable.getFileDrawable((String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), localURLDrawableOptions));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QzoneMsgPagerAdapter
 * JD-Core Version:    0.7.0.1
 */