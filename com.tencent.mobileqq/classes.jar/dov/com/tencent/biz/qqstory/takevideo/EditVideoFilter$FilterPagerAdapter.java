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
import bqfg;
import bqfh;
import bqrm;
import bqrn;
import bqru;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import yuk;

public class EditVideoFilter$FilterPagerAdapter
  extends PagerAdapter
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<bqrn> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private bqfg jdField_a_of_type_Bqfg;
  public final List<bqrm> a;
  private final Map<Class<? extends bqrn>, Queue<bqrn>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
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
  
  public bqrm a(int paramInt)
  {
    paramInt = a(paramInt);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bqrm)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  @Nullable
  public bqrn a(int paramInt)
  {
    return (bqrn)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bqrm localbqrm = (bqrm)((Iterator)localObject).next();
      if (paramInt == localbqrm.jdField_b_of_type_Int) {
        localbqrm.jdField_b_of_type_JavaLangString = paramString;
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (bqrn)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localObject != null) && (((bqrn)localObject).jdField_a_of_type_Bqrm.jdField_b_of_type_Int == paramInt) && ((localObject instanceof bqru)))
      {
        localObject = (bqru)localObject;
        ((bqru)localObject).b.setText(paramString);
        if (TextUtils.isEmpty(paramString)) {
          EditVideoFilter.a((bqrn)localObject);
        }
      }
      i += 1;
    }
  }
  
  public void a(List<bqrm> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    bqrn localbqrn = (bqrn)paramObject;
    paramViewGroup.removeView(localbqrn.jdField_a_of_type_AndroidViewView);
    localbqrn.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
    localbqrn.a();
    paramObject = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localbqrn.getClass());
    paramViewGroup = paramObject;
    if (paramObject == null)
    {
      paramViewGroup = new LinkedList();
      this.jdField_a_of_type_JavaUtilMap.put(localbqrn.getClass(), paramViewGroup);
    }
    paramViewGroup.offer(localbqrn);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() * 100;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    bqrm localbqrm = a(paramInt);
    if (localbqrm == null)
    {
      yuk.d("Q.qqstory.publish.edit.EditVideoFilter", "instantiateItem find data is null !");
      return null;
    }
    Object localObject1 = (Queue)this.jdField_a_of_type_JavaUtilMap.get(localbqrm.a());
    if (localObject1 != null) {}
    for (localObject1 = (bqrn)((Queue)localObject1).poll();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localbqrm.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
      }
      paramViewGroup.addView(((bqrn)localObject2).jdField_a_of_type_AndroidViewView);
      ((bqrn)localObject2).jdField_a_of_type_AndroidViewView.setOnTouchListener(new bqfh(this.jdField_a_of_type_Bqfg));
      ((bqrn)localObject2).a(localbqrm, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
      return localObject2;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((paramObject instanceof bqrn)) && (((bqrn)paramObject).jdField_a_of_type_AndroidViewView == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter
 * JD-Core Version:    0.7.0.1
 */