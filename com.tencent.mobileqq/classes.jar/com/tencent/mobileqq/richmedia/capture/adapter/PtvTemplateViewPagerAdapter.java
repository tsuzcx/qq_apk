package com.tencent.mobileqq.richmedia.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import bbfz;
import bbgg;
import bbgy;
import bbje;
import bdck;
import bdee;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PtvTemplateViewPagerAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  bbje jdField_a_of_type_Bbje;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public HashMap<Integer, GridView> a;
  private List<bbgy> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  
  public bbgy a(bbgy parambbgy)
  {
    if (parambbgy == null) {
      return parambbgy;
    }
    int i;
    label17:
    int j;
    label25:
    bbgy localbbgy;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (bdee.f()) {
        break label205;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label208;
      }
      localbbgy = new bbgy();
      localbbgy.jdField_a_of_type_Int = parambbgy.jdField_a_of_type_Int;
      localbbgy.jdField_a_of_type_JavaLangString = parambbgy.jdField_a_of_type_JavaLangString;
      localbbgy.jdField_a_of_type_Boolean = parambbgy.jdField_a_of_type_Boolean;
      localbbgy.jdField_b_of_type_Int = parambbgy.jdField_b_of_type_Int;
      localbbgy.jdField_b_of_type_JavaLangString = parambbgy.jdField_b_of_type_JavaLangString;
      localbbgy.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((parambbgy.jdField_a_of_type_JavaUtilList == null) || (parambbgy.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label216;
      }
      parambbgy = parambbgy.jdField_a_of_type_JavaUtilList.iterator();
    }
    label128:
    label205:
    label208:
    label214:
    for (;;)
    {
      if (!parambbgy.hasNext()) {
        break label216;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambbgy.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 9))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label214;
        }
        localbbgy.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label128;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label216:
    return localbbgy;
  }
  
  public void a(List<bbgy> paramList)
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
      int m = AIOUtils.dp2px(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(m);
      int i = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - j * 2;
      int k = n / m;
      m = n - m * k;
      if (m > 0)
      {
        localGridView.setHorizontalSpacing(m / (k - 1));
        localGridView.setVerticalSpacing(i);
        localGridView.setVerticalScrollBarEnabled(false);
        localGridView.setPadding(j, j, j, AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 4);
        localGridView.setClipToPadding(false);
        localGridView.setSelector(new ColorDrawable(0));
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject = a(bdck.a((bbgy)this.jdField_a_of_type_JavaUtilList.get(paramInt)));
          bbfz localbbfz = new bbfz(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Bbje, (bbgy)localObject, this.jdField_a_of_type_Boolean);
          localGridView.setAdapter(localbbfz);
          localbbfz.a(((bbgy)localObject).jdField_a_of_type_JavaUtilList, 0);
          localObject = bbgg.a();
          ((bbgg)localObject).a(localbbfz, 112);
          ((bbgg)localObject).a(localbbfz, 113);
          if (paramInt == 0) {
            ((bbgg)localObject).a(localbbfz, 111);
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