package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import bbxj;
import bmql;
import bmqu;
import bmsq;
import bmyx;
import boba;
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
  bmyx jdField_a_of_type_Bmyx;
  private boba jdField_a_of_type_Boba;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  public HashMap<Integer, GridView> a;
  private List<bmsq> jdField_a_of_type_JavaUtilList;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, bmyx parambmyx, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bmyx = parambmyx;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boba = ((boba)bmql.a(3));
  }
  
  public bmsq a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bmsq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bmsq a(bmsq parambmsq)
  {
    if (parambmsq == null) {
      return parambmsq;
    }
    int i;
    label17:
    int j;
    label25:
    bmsq localbmsq;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (bbxj.f()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localbmsq = new bmsq();
      localbmsq.jdField_a_of_type_Int = parambmsq.jdField_a_of_type_Int;
      localbmsq.jdField_a_of_type_JavaLangString = parambmsq.jdField_a_of_type_JavaLangString;
      localbmsq.b = parambmsq.b;
      localbmsq.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((parambmsq.jdField_a_of_type_JavaUtilList == null) || (parambmsq.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label198;
      }
      parambmsq = parambmsq.jdField_a_of_type_JavaUtilList.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!parambmsq.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambmsq.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localbmsq.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localbmsq;
  }
  
  public void a(List<bmsq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bmqu)paramViewGroup.getAdapter();
      this.jdField_a_of_type_Boba.a(paramViewGroup);
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
    bmqu localbmqu;
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
        localbmqu = new bmqu(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Bmyx, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Boba.a(localbmqu, 112);
        this.jdField_a_of_type_Boba.a(localbmqu, 113);
        this.jdField_a_of_type_Boba.a(localbmqu, 114);
        this.jdField_a_of_type_Boba.a(localbmqu, 115);
        if (paramInt == 0) {
          this.jdField_a_of_type_Boba.a(localbmqu, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localbmqu.a(a((bmsq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localbmqu);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localbmqu);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localbmqu = (bmqu)localGridView.getAdapter();
      this.jdField_a_of_type_Boba.a(localbmqu, 112);
      this.jdField_a_of_type_Boba.a(localbmqu, 113);
      this.jdField_a_of_type_Boba.a(localbmqu, 114);
      this.jdField_a_of_type_Boba.a(localbmqu, 115);
      if (paramInt == 0) {
        this.jdField_a_of_type_Boba.a(localbmqu, 111);
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