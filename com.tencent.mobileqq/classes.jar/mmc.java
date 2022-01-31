import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.ui.beauty.BeautyBaseView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class mmc
  extends PagerAdapter
{
  final List<BeautyBaseView> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public mmc(List<BeautyBaseView> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Collection localCollection;
    if (localCollection != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(localCollection);
    }
  }
  
  public BeautyBaseView a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (BeautyBaseView)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramViewGroup != null) && ((paramObject instanceof BeautyBaseView))) {
      paramViewGroup.removeView((BeautyBaseView)paramObject);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    BeautyBaseView localBeautyBaseView = a(paramInt);
    if ((paramViewGroup != null) && (localBeautyBaseView != null)) {
      paramViewGroup.addView(localBeautyBaseView);
    }
    return localBeautyBaseView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmc
 * JD-Core Version:    0.7.0.1
 */