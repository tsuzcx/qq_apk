package com.tencent.mobileqq.richmedia.capture.adapter;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import bbeo;
import bbew;
import bbfs;
import bbix;
import bdcn;
import bdek;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PtvTemplateViewPagerAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  bbix jdField_a_of_type_Bbix;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public HashMap<Integer, GridView> a;
  private List<bbfs> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = true;
  
  public PtvTemplateViewPagerAdapter(Context paramContext, AppInterface paramAppInterface, bbix parambbix, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bbix = parambbix;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public bbfs a(bbfs parambbfs)
  {
    if (parambbfs == null) {
      return parambbfs;
    }
    int i;
    label17:
    int j;
    label25:
    bbfs localbbfs;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (bdek.f()) {
        break label205;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label208;
      }
      localbbfs = new bbfs();
      localbbfs.jdField_a_of_type_Int = parambbfs.jdField_a_of_type_Int;
      localbbfs.jdField_a_of_type_JavaLangString = parambbfs.jdField_a_of_type_JavaLangString;
      localbbfs.jdField_a_of_type_Boolean = parambbfs.jdField_a_of_type_Boolean;
      localbbfs.jdField_b_of_type_Int = parambbfs.jdField_b_of_type_Int;
      localbbfs.jdField_b_of_type_JavaLangString = parambbfs.jdField_b_of_type_JavaLangString;
      localbbfs.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((parambbfs.jdField_a_of_type_JavaUtilList == null) || (parambbfs.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label216;
      }
      parambbfs = parambbfs.jdField_a_of_type_JavaUtilList.iterator();
    }
    label128:
    label205:
    label208:
    label214:
    for (;;)
    {
      if (!parambbfs.hasNext()) {
        break label216;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambbfs.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 9))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label214;
        }
        localbbfs.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label128;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label216:
    return localbbfs;
  }
  
  public void a(List<bbfs> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateViewPagerAdapter", 2, "instantiateItem position = " + paramInt);
    }
    GridView localGridView = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int m = agej.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(m);
      int i = agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - j * 2;
      int k = n / m;
      m = n - m * k;
      if (m > 0)
      {
        localGridView.setHorizontalSpacing(m / (k - 1));
        localGridView.setVerticalSpacing(i);
        localGridView.setVerticalScrollBarEnabled(false);
        localGridView.setPadding(j, j, j, agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 4);
        localGridView.setClipToPadding(false);
        localGridView.setSelector(new ColorDrawable(0));
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject = a(bdcn.a((bbfs)this.jdField_a_of_type_JavaUtilList.get(paramInt)));
          bbeo localbbeo = new bbeo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Bbix, (bbfs)localObject, this.jdField_a_of_type_Boolean);
          localGridView.setAdapter(localbbeo);
          localbbeo.a(((bbfs)localObject).jdField_a_of_type_JavaUtilList, 0);
          localObject = bbew.a();
          ((bbew)localObject).a(localbbeo, 112);
          ((bbew)localObject).a(localbbeo, 113);
          if (paramInt == 0) {
            ((bbew)localObject).a(localbbeo, 111);
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      paramViewGroup.addView(localGridView);
      return localGridView;
      localGridView.setHorizontalSpacing(0);
      break;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */