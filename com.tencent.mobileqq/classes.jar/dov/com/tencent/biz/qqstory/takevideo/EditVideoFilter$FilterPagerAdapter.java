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
import biev;
import biew;
import bird;
import bire;
import birq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import urk;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<bire> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private biev jdField_a_of_type_Biev;
  public final List<bird> a;
  private final Map<Class<? extends bire>, Queue<bire>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
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
  
  public bird a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bird)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public bire a(int paramInt)
  {
    return (bire)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bird localbird = (bird)((Iterator)localObject).next();
      if (paramInt == localbird.jdField_b_of_type_Int) {
        localbird.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (bire)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((bire)localObject).jdField_a_of_type_Bird.jdField_b_of_type_Int == paramInt) && ((localObject instanceof birq)))
      {
        localObject = (birq)localObject;
        ((birq)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((bire)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<bird> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    bire localbire = (bire)paramObject;
    paramViewGroup.removeView(localbire.jdField_a_of_type_AndroidViewView);
    localbire.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localbire.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localbire.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localbire.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localbire);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    bird localbird = a(paramInt);
    if (localbird == null)
    {
      urk.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localbird.a());
    if (localObject1 != null) {}
    for (localObject1 = (bire)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localbird.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((bire)localObject2).jdField_a_of_type_AndroidViewView);
      ((bire)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new biew(this.jdField_a_of_type_Biev));
      ((bire)localObject2).a(localbird, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof bire)) && (((bire)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */