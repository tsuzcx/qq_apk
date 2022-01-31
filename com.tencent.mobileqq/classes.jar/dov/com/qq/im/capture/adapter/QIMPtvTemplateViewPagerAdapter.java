package dov.com.qq.im.capture.adapter;

import actj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import axle;
import bfpt;
import bjav;
import bjbe;
import bjcz;
import bjky;
import bkzp;
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
  private bfpt jdField_a_of_type_Bfpt;
  bjky jdField_a_of_type_Bjky;
  private bkzp jdField_a_of_type_Bkzp;
  public HashMap<Integer, GridView> a;
  private List<bjcz> jdField_a_of_type_JavaUtilList;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, bjky parambjky, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bjky = parambjky;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bkzp = ((bkzp)bjav.a(3));
  }
  
  public bjcz a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bjcz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bjcz a(bjcz parambjcz)
  {
    if (parambjcz == null) {
      return parambjcz;
    }
    int i;
    label17:
    int j;
    label25:
    bjcz localbjcz;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (axle.h()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localbjcz = new bjcz();
      localbjcz.jdField_a_of_type_Int = parambjcz.jdField_a_of_type_Int;
      localbjcz.jdField_a_of_type_JavaLangString = parambjcz.jdField_a_of_type_JavaLangString;
      localbjcz.b = parambjcz.b;
      localbjcz.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((parambjcz.jdField_a_of_type_JavaUtilList == null) || (parambjcz.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label198;
      }
      parambjcz = parambjcz.jdField_a_of_type_JavaUtilList.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!parambjcz.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambjcz.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localbjcz.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localbjcz;
  }
  
  public void a(List<bjcz> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bjbe)paramViewGroup.a();
      this.jdField_a_of_type_Bkzp.a(paramViewGroup);
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
    bjbe localbjbe;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int n = actj.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(n);
      int i = actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = actj.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
        localbjbe = new bjbe(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Bjky, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bkzp.a(localbjbe, 112);
        this.jdField_a_of_type_Bkzp.a(localbjbe, 113);
        this.jdField_a_of_type_Bkzp.a(localbjbe, 114);
        this.jdField_a_of_type_Bkzp.a(localbjbe, 115);
        if (paramInt == 0) {
          this.jdField_a_of_type_Bkzp.a(localbjbe, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_Bfpt);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localbjbe.a(a((bjcz)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localbjbe);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localbjbe);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localbjbe = (bjbe)localGridView.a();
      this.jdField_a_of_type_Bkzp.a(localbjbe, 112);
      this.jdField_a_of_type_Bkzp.a(localbjbe, 113);
      this.jdField_a_of_type_Bkzp.a(localbjbe, 114);
      this.jdField_a_of_type_Bkzp.a(localbjbe, 115);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bkzp.a(localbjbe, 111);
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