package cooperation.qzone.contentbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.util.ArrayList;

public class QzoneMsgPagerAdapter
  extends PagerAdapter
{
  private static final int IMAGE_HEIGHT = ViewUtils.b(230.0F);
  private static final int IMAGE_WIDTH = ViewUtils.a() - ViewUtils.b(24.0F);
  private ArrayList<String> urls;
  private ArrayList<AnyScaleTypeImageView> views;
  
  public QzoneMsgPagerAdapter(Context paramContext, ArrayList<String> paramArrayList)
  {
    int j = 0;
    int i;
    if (paramArrayList == null) {
      i = 0;
    } else {
      i = paramArrayList.size();
    }
    this.views = new ArrayList(i);
    while (j < i)
    {
      AnyScaleTypeImageView localAnyScaleTypeImageView = new AnyScaleTypeImageView(paramContext);
      localAnyScaleTypeImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ThemeUtil.setColorFilterIfNeed(localAnyScaleTypeImageView);
      this.views.add(localAnyScaleTypeImageView);
      j += 1;
    }
    this.urls = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = this.views;
    if ((paramObject != null) && (paramObject.size() != 0) && (paramInt >= 0))
    {
      if (paramInt >= this.views.size()) {
        return;
      }
      paramObject = (AnyScaleTypeImageView)this.views.get(paramInt);
      paramObject.setImageDrawable(null);
      paramViewGroup.removeView(paramObject);
    }
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.views;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.views;
    if ((localObject != null) && (((ArrayList)localObject).size() != 0) && (paramInt >= 0) && (paramInt < this.views.size()))
    {
      localObject = (AnyScaleTypeImageView)this.views.get(paramInt);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = IMAGE_WIDTH;
      localURLDrawableOptions.mRequestHeight = IMAGE_HEIGHT;
      ArrayList localArrayList = this.urls;
      if ((localArrayList != null) && (localArrayList.get(paramInt) != null)) {
        if ((!((String)this.urls.get(paramInt)).startsWith("http")) && (!((String)this.urls.get(paramInt)).startsWith("https"))) {
          ((AnyScaleTypeImageView)localObject).setImageDrawable(URLDrawable.getFileDrawable((String)this.urls.get(paramInt), localURLDrawableOptions));
        } else {
          ((AnyScaleTypeImageView)localObject).setImageDrawable(URLDrawable.getDrawable((String)this.urls.get(paramInt), localURLDrawableOptions));
        }
      }
      paramViewGroup.addView((View)localObject);
      return this.views.get(paramInt);
    }
    return null;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.QzoneMsgPagerAdapter
 * JD-Core Version:    0.7.0.1
 */