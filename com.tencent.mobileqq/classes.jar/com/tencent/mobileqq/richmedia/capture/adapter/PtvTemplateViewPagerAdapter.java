package com.tencent.mobileqq.richmedia.capture.adapter;

import aepi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import axnu;
import axoc;
import axoy;
import axsd;
import aziv;
import azkt;
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
  axsd jdField_a_of_type_Axsd;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public HashMap<Integer, GridView> a;
  private List<axoy> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = true;
  
  public PtvTemplateViewPagerAdapter(Context paramContext, AppInterface paramAppInterface, axsd paramaxsd, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Axsd = paramaxsd;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public axoy a(axoy paramaxoy)
  {
    if (paramaxoy == null) {
      return paramaxoy;
    }
    int i;
    label17:
    int j;
    label25:
    axoy localaxoy;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (azkt.h()) {
        break label205;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label208;
      }
      localaxoy = new axoy();
      localaxoy.jdField_a_of_type_Int = paramaxoy.jdField_a_of_type_Int;
      localaxoy.jdField_a_of_type_JavaLangString = paramaxoy.jdField_a_of_type_JavaLangString;
      localaxoy.jdField_a_of_type_Boolean = paramaxoy.jdField_a_of_type_Boolean;
      localaxoy.jdField_b_of_type_Int = paramaxoy.jdField_b_of_type_Int;
      localaxoy.jdField_b_of_type_JavaLangString = paramaxoy.jdField_b_of_type_JavaLangString;
      localaxoy.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((paramaxoy.jdField_a_of_type_JavaUtilList == null) || (paramaxoy.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label216;
      }
      paramaxoy = paramaxoy.jdField_a_of_type_JavaUtilList.iterator();
    }
    label128:
    label205:
    label208:
    label214:
    for (;;)
    {
      if (!paramaxoy.hasNext()) {
        break label216;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaxoy.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 9))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label214;
        }
        localaxoy.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label128;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label216:
    return localaxoy;
  }
  
  public void a(List<axoy> paramList)
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
      int m = aepi.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(m);
      int i = aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - j * 2;
      int k = n / m;
      m = n - m * k;
      if (m > 0)
      {
        localGridView.setHorizontalSpacing(m / (k - 1));
        localGridView.setVerticalSpacing(i);
        localGridView.setVerticalScrollBarEnabled(false);
        localGridView.setPadding(j, j, j, aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 4);
        localGridView.setClipToPadding(false);
        localGridView.setSelector(new ColorDrawable(0));
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject = a(aziv.a((axoy)this.jdField_a_of_type_JavaUtilList.get(paramInt)));
          axnu localaxnu = new axnu(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Axsd, (axoy)localObject, this.jdField_a_of_type_Boolean);
          localGridView.setAdapter(localaxnu);
          localaxnu.a(((axoy)localObject).jdField_a_of_type_JavaUtilList, 0);
          localObject = axoc.a();
          ((axoc)localObject).a(localaxnu, 112);
          ((axoc)localObject).a(localaxnu, 113);
          if (paramInt == 0) {
            ((axoc)localObject).a(localaxnu, 111);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */