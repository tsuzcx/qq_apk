package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import bdee;
import bogd;
import bogm;
import boii;
import boop;
import bpqs;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
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
  boop jdField_a_of_type_Boop;
  private bpqs jdField_a_of_type_Bpqs;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  public HashMap<Integer, GridView> a;
  private List<boii> jdField_a_of_type_JavaUtilList;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, boop paramboop, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boop = paramboop;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bpqs = ((bpqs)bogd.a(3));
  }
  
  public boii a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (boii)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public boii a(boii paramboii)
  {
    if (paramboii == null) {
      return paramboii;
    }
    int i;
    label17:
    int j;
    label25:
    boii localboii;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (bdee.f()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localboii = new boii();
      localboii.jdField_a_of_type_Int = paramboii.jdField_a_of_type_Int;
      localboii.jdField_a_of_type_JavaLangString = paramboii.jdField_a_of_type_JavaLangString;
      localboii.b = paramboii.b;
      localboii.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((paramboii.jdField_a_of_type_JavaUtilList == null) || (paramboii.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label198;
      }
      paramboii = paramboii.jdField_a_of_type_JavaUtilList.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!paramboii.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramboii.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localboii.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localboii;
  }
  
  public void a(List<boii> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bogm)paramViewGroup.getAdapter();
      this.jdField_a_of_type_Bpqs.a(paramViewGroup);
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
    bogm localbogm;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int n = AIOUtils.dp2px(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(n);
      int i = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = AIOUtils.dp2px(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
        localbogm = new bogm(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Boop, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bpqs.a(localbogm, 112);
        this.jdField_a_of_type_Bpqs.a(localbogm, 113);
        this.jdField_a_of_type_Bpqs.a(localbogm, 114);
        this.jdField_a_of_type_Bpqs.a(localbogm, 115);
        if (paramInt == 0) {
          this.jdField_a_of_type_Bpqs.a(localbogm, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localbogm.a(a((boii)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localbogm);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localbogm);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localbogm = (bogm)localGridView.getAdapter();
      this.jdField_a_of_type_Bpqs.a(localbogm, 112);
      this.jdField_a_of_type_Bpqs.a(localbogm, 113);
      this.jdField_a_of_type_Bpqs.a(localbogm, 114);
      this.jdField_a_of_type_Bpqs.a(localbogm, 115);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bpqs.a(localbogm, 111);
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */