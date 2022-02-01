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
import bnnq;
import bnnr;
import bnnv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import xvv;

public class EditVideoSpeedFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<bnnr> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public final List<bnnq> a;
  private final Map<Class<? extends bnnr>, Queue<bnnr>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public EditVideoSpeedFilter$FilterPagerAdapter(@NonNull Context paramContext)
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
  
  public bnnq a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bnnq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public bnnr a(int paramInt)
  {
    return (bnnr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bnnq localbnnq = (bnnq)((Iterator)localObject).next();
      if (paramInt == localbnnq.jdField_b_of_type_Int) {
        localbnnq.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (bnnr)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((bnnr)localObject).jdField_a_of_type_Bnnq.jdField_b_of_type_Int == paramInt) && ((localObject instanceof bnnv)))
      {
        localObject = (bnnv)localObject;
        ((bnnv)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoSpeedFilter.a((bnnr)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<bnnq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    bnnr localbnnr = (bnnr)paramObject;
    paramViewGroup.removeView(localbnnr.jdField_a_of_type_AndroidViewView);
    localbnnr.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localbnnr.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localbnnr.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localbnnr.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localbnnr);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    bnnq localbnnq = a(paramInt);
    if (localbnnq == null)
    {
      xvv.d("EditVideoSpeedFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localbnnq.a());
    if (localObject1 != null) {}
    for (localObject1 = (bnnr)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localbnnq.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((bnnr)localObject2).jdField_a_of_type_AndroidViewView);
      ((bnnr)localObject2).a(localbnnq, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof bnnr)) && (((bnnr)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */