package com.tencent.mobileqq.richmedia.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.TemplateGroupItem;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView.ProviderViewListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
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
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ProviderView.ProviderViewListener jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener;
  public HashMap a;
  private List jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = true;
  
  public PtvTemplateViewPagerAdapter(Context paramContext, AppInterface paramAppInterface, ProviderView.ProviderViewListener paramProviderViewListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener = paramProviderViewListener;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public TemplateGroupItem a(TemplateGroupItem paramTemplateGroupItem)
  {
    if (paramTemplateGroupItem == null) {
      return paramTemplateGroupItem;
    }
    int i;
    label14:
    int j;
    label22:
    TemplateGroupItem localTemplateGroupItem;
    if (!SoLoader.f())
    {
      i = 1;
      if (PtvFilterSoLoad.f()) {
        break label202;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label205;
      }
      localTemplateGroupItem = new TemplateGroupItem();
      localTemplateGroupItem.jdField_a_of_type_Int = paramTemplateGroupItem.jdField_a_of_type_Int;
      localTemplateGroupItem.jdField_a_of_type_JavaLangString = paramTemplateGroupItem.jdField_a_of_type_JavaLangString;
      localTemplateGroupItem.jdField_a_of_type_Boolean = paramTemplateGroupItem.jdField_a_of_type_Boolean;
      localTemplateGroupItem.jdField_b_of_type_Int = paramTemplateGroupItem.jdField_b_of_type_Int;
      localTemplateGroupItem.jdField_b_of_type_JavaLangString = paramTemplateGroupItem.jdField_b_of_type_JavaLangString;
      localTemplateGroupItem.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((paramTemplateGroupItem.jdField_a_of_type_JavaUtilList == null) || (paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label213;
      }
      paramTemplateGroupItem = paramTemplateGroupItem.jdField_a_of_type_JavaUtilList.iterator();
    }
    label202:
    label205:
    label211:
    for (;;)
    {
      label125:
      if (!paramTemplateGroupItem.hasNext()) {
        break label213;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramTemplateGroupItem.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 9))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label211;
        }
        localTemplateGroupItem.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label125;
        i = 0;
        break label14;
        j = 0;
        break label22;
        break;
      }
    }
    label213:
    return localTemplateGroupItem;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(List paramList)
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
      int m = AIOUtils.a(64.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(m);
      int i = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int n = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - j * 2;
      int k = n / m;
      m = n - m * k;
      if (m > 0)
      {
        localGridView.setHorizontalSpacing(m / (k - 1));
        localGridView.setVerticalSpacing(i);
        localGridView.setVerticalScrollBarEnabled(false);
        localGridView.setPadding(j, j, j, AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 4);
        localGridView.setClipToPadding(false);
        localGridView.setSelector(new ColorDrawable(0));
        if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
        {
          Object localObject = a(GestureRecognitionUtils.a((TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)));
          PtvTemplateAdapter localPtvTemplateAdapter = new PtvTemplateAdapter(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderView$ProviderViewListener, (TemplateGroupItem)localObject, this.jdField_a_of_type_Boolean);
          localGridView.setAdapter(localPtvTemplateAdapter);
          localPtvTemplateAdapter.a(((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList, 0);
          localObject = CapturePtvTemplateManager.a();
          ((CapturePtvTemplateManager)localObject).a(localPtvTemplateAdapter, 112);
          ((CapturePtvTemplateManager)localObject).a(localPtvTemplateAdapter, 113);
          if (paramInt == 0) {
            ((CapturePtvTemplateManager)localObject).a(localPtvTemplateAdapter, 111);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */