package dov.com.qq.im.capture.adapter;

import aciy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import awlw;
import behi;
import bhfm;
import bhfv;
import bhhq;
import bhpp;
import bjin;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QIMPtvTemplateViewPagerAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private behi jdField_a_of_type_Behi;
  bhpp jdField_a_of_type_Bhpp;
  private bjin jdField_a_of_type_Bjin;
  public HashMap<Integer, GridView> a;
  private List<bhhq> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, bhpp parambhpp, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhpp = parambhpp;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bjin = ((bjin)bhfm.a(18));
      return;
    }
    this.jdField_a_of_type_Bjin = ((bjin)bhfm.a(3));
  }
  
  public bhhq a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bhhq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bhhq a(bhhq parambhhq)
  {
    if (parambhhq == null) {
      return parambhhq;
    }
    int i;
    label17:
    int j;
    label25:
    bhhq localbhhq;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (awlw.h()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localbhhq = new bhhq();
      localbhhq.jdField_a_of_type_Int = parambhhq.jdField_a_of_type_Int;
      localbhhq.jdField_a_of_type_JavaLangString = parambhhq.jdField_a_of_type_JavaLangString;
      localbhhq.b = parambhhq.b;
      localbhhq.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((parambhhq.jdField_a_of_type_JavaUtilList == null) || (parambhhq.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label198;
      }
      parambhhq = parambhhq.jdField_a_of_type_JavaUtilList.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!parambhhq.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambhhq.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localbhhq.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localbhhq;
  }
  
  public void a(List<bhhq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bhfv)paramViewGroup.a();
      this.jdField_a_of_type_Bjin.a(paramViewGroup);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "instantiateItem position = " + paramInt);
    }
    GridView localGridView = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    int j;
    bhfv localbhfv;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int n = aciy.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(n);
      int i = aciy.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = aciy.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = aciy.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - k * 2;
      int m = (i1 + j) / (n + j);
      n = i1 - n * m;
      if (n > j)
      {
        localGridView.setHorizontalSpacing(n / (m - 1));
        localGridView.setVerticalSpacing(i);
        localGridView.setVerticalScrollBarEnabled(false);
        localGridView.setPadding(k, k, k, i * 4);
        localGridView.setClipToPadding(false);
        localGridView.setSelector(new ColorDrawable(0));
        localbhfv = new bhfv(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Bhpp, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_Bjin.a(localbhfv, 112);
        this.jdField_a_of_type_Bjin.a(localbhfv, 113);
        this.jdField_a_of_type_Bjin.a(localbhfv, 114);
        this.jdField_a_of_type_Bjin.a(localbhfv, 115);
        if (paramInt == 0) {
          this.jdField_a_of_type_Bjin.a(localbhfv, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_Behi);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localbhfv.a(a((bhhq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localbhfv);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localbhfv);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localbhfv = (bhfv)localGridView.a();
      this.jdField_a_of_type_Bjin.a(localbhfv, 112);
      this.jdField_a_of_type_Bjin.a(localbhfv, 113);
      this.jdField_a_of_type_Bjin.a(localbhfv, 114);
      this.jdField_a_of_type_Bjin.a(localbhfv, 115);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bjin.a(localbhfv, 111);
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */