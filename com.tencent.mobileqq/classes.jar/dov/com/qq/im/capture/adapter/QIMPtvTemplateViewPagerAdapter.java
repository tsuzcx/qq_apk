package dov.com.qq.im.capture.adapter;

import actn;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import axlc;
import bfpc;
import bjae;
import bjan;
import bjci;
import bjkh;
import bkyy;
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
  private bfpc jdField_a_of_type_Bfpc;
  bjkh jdField_a_of_type_Bjkh;
  private bkyy jdField_a_of_type_Bkyy;
  public HashMap<Integer, GridView> a;
  private List<bjci> jdField_a_of_type_JavaUtilList;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, bjkh parambjkh, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bjkh = parambjkh;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bkyy = ((bkyy)bjae.a(3));
  }
  
  public bjci a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bjci)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bjci a(bjci parambjci)
  {
    if (parambjci == null) {
      return parambjci;
    }
    int i;
    label17:
    int j;
    label25:
    bjci localbjci;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (axlc.h()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localbjci = new bjci();
      localbjci.jdField_a_of_type_Int = parambjci.jdField_a_of_type_Int;
      localbjci.jdField_a_of_type_JavaLangString = parambjci.jdField_a_of_type_JavaLangString;
      localbjci.b = parambjci.b;
      localbjci.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((parambjci.jdField_a_of_type_JavaUtilList == null) || (parambjci.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label198;
      }
      parambjci = parambjci.jdField_a_of_type_JavaUtilList.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!parambjci.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambjci.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localbjci.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localbjci;
  }
  
  public void a(List<bjci> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bjan)paramViewGroup.a();
      this.jdField_a_of_type_Bkyy.a(paramViewGroup);
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
    bjan localbjan;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int n = actn.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(n);
      int i = actn.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = actn.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = actn.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
        localbjan = new bjan(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Bjkh, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bkyy.a(localbjan, 112);
        this.jdField_a_of_type_Bkyy.a(localbjan, 113);
        this.jdField_a_of_type_Bkyy.a(localbjan, 114);
        this.jdField_a_of_type_Bkyy.a(localbjan, 115);
        if (paramInt == 0) {
          this.jdField_a_of_type_Bkyy.a(localbjan, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_Bfpc);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localbjan.a(a((bjci)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localbjan);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localbjan);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localbjan = (bjan)localGridView.a();
      this.jdField_a_of_type_Bkyy.a(localbjan, 112);
      this.jdField_a_of_type_Bkyy.a(localbjan, 113);
      this.jdField_a_of_type_Bkyy.a(localbjan, 114);
      this.jdField_a_of_type_Bkyy.a(localbjan, 115);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bkyy.a(localbjan, 111);
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