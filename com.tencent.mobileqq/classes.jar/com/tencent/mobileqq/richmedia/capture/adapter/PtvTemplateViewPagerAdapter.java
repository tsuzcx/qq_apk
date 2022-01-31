package com.tencent.mobileqq.richmedia.capture.adapter;

import actj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import avrn;
import avrv;
import avsr;
import avvv;
import axjg;
import axle;
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
  avvv jdField_a_of_type_Avvv;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public HashMap<Integer, GridView> a;
  private List<avsr> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = true;
  
  public PtvTemplateViewPagerAdapter(Context paramContext, AppInterface paramAppInterface, avvv paramavvv, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Avvv = paramavvv;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public avsr a(avsr paramavsr)
  {
    if (paramavsr == null) {
      return paramavsr;
    }
    int i;
    label17:
    int j;
    label25:
    avsr localavsr;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (axle.h()) {
        break label205;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label208;
      }
      localavsr = new avsr();
      localavsr.jdField_a_of_type_Int = paramavsr.jdField_a_of_type_Int;
      localavsr.jdField_a_of_type_JavaLangString = paramavsr.jdField_a_of_type_JavaLangString;
      localavsr.jdField_a_of_type_Boolean = paramavsr.jdField_a_of_type_Boolean;
      localavsr.jdField_b_of_type_Int = paramavsr.jdField_b_of_type_Int;
      localavsr.jdField_b_of_type_JavaLangString = paramavsr.jdField_b_of_type_JavaLangString;
      localavsr.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((paramavsr.jdField_a_of_type_JavaUtilList == null) || (paramavsr.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label216;
      }
      paramavsr = paramavsr.jdField_a_of_type_JavaUtilList.iterator();
    }
    label128:
    label205:
    label208:
    label214:
    for (;;)
    {
      if (!paramavsr.hasNext()) {
        break label216;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramavsr.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 9))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label214;
        }
        localavsr.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label128;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label216:
    return localavsr;
  }
  
  public void a(List<avsr> paramList)
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
      int m = actj.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(m);
      int i = actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - j * 2;
      int k = n / m;
      m = n - m * k;
      if (m > 0)
      {
        localGridView.setHorizontalSpacing(m / (k - 1));
        localGridView.setVerticalSpacing(i);
        localGridView.setVerticalScrollBarEnabled(false);
        localGridView.setPadding(j, j, j, actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 4);
        localGridView.setClipToPadding(false);
        localGridView.setSelector(new ColorDrawable(0));
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject = a(axjg.a((avsr)this.jdField_a_of_type_JavaUtilList.get(paramInt)));
          avrn localavrn = new avrn(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Avvv, (avsr)localObject, this.jdField_a_of_type_Boolean);
          localGridView.setAdapter(localavrn);
          localavrn.a(((avsr)localObject).jdField_a_of_type_JavaUtilList, 0);
          localObject = avrv.a();
          ((avrv)localObject).a(localavrn, 112);
          ((avrv)localObject).a(localavrn, 113);
          if (paramInt == 0) {
            ((avrv)localObject).a(localavrn, 111);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */