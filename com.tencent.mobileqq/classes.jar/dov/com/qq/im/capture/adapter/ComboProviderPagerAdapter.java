package dov.com.qq.im.capture.adapter;

import aepi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import bhuw;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.data.FilterCategory;
import java.util.ArrayList;

public class ComboProviderPagerAdapter
  extends PagerAdapter
{
  public static final int a;
  public static final int b = aepi.a(0.0F, BaseApplication.getContext().getResources());
  private Context jdField_a_of_type_AndroidContentContext;
  public SparseArray<GridView> a;
  private bhuw jdField_a_of_type_Bhuw;
  private ArrayList<FilterCategory> jdField_a_of_type_JavaUtilArrayList;
  int c;
  
  static
  {
    jdField_a_of_type_Int = aepi.a(7.0F, BaseApplication.getContext().getResources());
  }
  
  public ComboProviderPagerAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.c = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public GridView a(int paramInt)
  {
    return (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(bhuw parambhuw)
  {
    this.jdField_a_of_type_Bhuw = parambhuw;
  }
  
  public void a(ArrayList<FilterCategory> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboProviderView", 2, "instantiateItem position = " + paramInt);
    }
    Object localObject2 = (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GridView(this.jdField_a_of_type_AndroidContentContext);
      ((GridView)localObject1).setNumColumns(3);
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setVerticalSpacing(b);
      ((GridView)localObject1).setHorizontalSpacing(b);
      ((GridView)localObject1).setClipToPadding(false);
      ((GridView)localObject1).setPadding(jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int + aepi.a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GridView)localObject1).setVerticalScrollBarEnabled(false);
      localObject2 = new ComboProviderGridAdapter(this.jdField_a_of_type_AndroidContentContext, this.c);
      ((ComboProviderGridAdapter)localObject2).a = ((GridView)localObject1);
      ((ComboProviderGridAdapter)localObject2).a(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      ((GridView)localObject1).setAdapter((ListAdapter)localObject2);
      ((ComboProviderGridAdapter)localObject2).a(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int);
      ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_Bhuw);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    paramViewGroup.addView((View)localObject1, -1, -1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.ComboProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */