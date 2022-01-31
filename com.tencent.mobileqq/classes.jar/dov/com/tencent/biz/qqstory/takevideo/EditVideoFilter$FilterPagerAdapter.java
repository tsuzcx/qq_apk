package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bmmf;
import bmmg;
import bmyl;
import bmym;
import bmyt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import wxe;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<bmym> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private bmmf jdField_a_of_type_Bmmf;
  public final List<bmyl> a;
  private final Map<Class<? extends bmym>, Queue<bmym>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public EditVideoFilter$FilterPagerAdapter(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int a(int paramInt)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i != 0) {
      return paramInt % i;
    }
    return 0;
  }
  
  public bmyl a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bmyl)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public bmym a(int paramInt)
  {
    return (bmym)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bmyl localbmyl = (bmyl)((Iterator)localObject).next();
      if (paramInt == localbmyl.jdField_b_of_type_Int) {
        localbmyl.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (bmym)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((bmym)localObject).jdField_a_of_type_Bmyl.jdField_b_of_type_Int == paramInt) && ((localObject instanceof bmyt)))
      {
        localObject = (bmyt)localObject;
        ((bmyt)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((bmym)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<bmyl> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    bmym localbmym = (bmym)paramObject;
    paramViewGroup.removeView(localbmym.jdField_a_of_type_AndroidViewView);
    localbmym.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localbmym.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localbmym.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localbmym.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localbmym);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    bmyl localbmyl = a(paramInt);
    if (localbmyl == null)
    {
      wxe.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localbmyl.a());
    if (localObject1 != null) {}
    for (localObject1 = (bmym)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localbmyl.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((bmym)localObject2).jdField_a_of_type_AndroidViewView);
      ((bmym)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new bmmg(this.jdField_a_of_type_Bmmf));
      ((bmym)localObject2).a(localbmyl, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof bmym)) && (((bmym)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */