package dov.com.qq.im.capture.adapter;

import agej;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import bdek;
import bljm;
import bplq;
import bplz;
import bpnv;
import bpvt;
import brhn;
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
  private bljm jdField_a_of_type_Bljm;
  bpvt jdField_a_of_type_Bpvt;
  private brhn jdField_a_of_type_Brhn;
  public HashMap<Integer, GridView> a;
  private List<bpnv> jdField_a_of_type_JavaUtilList;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, bpvt parambpvt, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bpvt = parambpvt;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Brhn = ((brhn)bplq.a(3));
  }
  
  public bpnv a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bpnv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public bpnv a(bpnv parambpnv)
  {
    if (parambpnv == null) {
      return parambpnv;
    }
    int i;
    label17:
    int j;
    label25:
    bpnv localbpnv;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (bdek.f()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localbpnv = new bpnv();
      localbpnv.jdField_a_of_type_Int = parambpnv.jdField_a_of_type_Int;
      localbpnv.jdField_a_of_type_JavaLangString = parambpnv.jdField_a_of_type_JavaLangString;
      localbpnv.b = parambpnv.b;
      localbpnv.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((parambpnv.jdField_a_of_type_JavaUtilList == null) || (parambpnv.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label198;
      }
      parambpnv = parambpnv.jdField_a_of_type_JavaUtilList.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!parambpnv.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)parambpnv.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localbpnv.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localbpnv;
  }
  
  public void a(List<bpnv> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bplz)paramViewGroup.a();
      this.jdField_a_of_type_Brhn.a(paramViewGroup);
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
    bplz localbplz;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int n = agej.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(n);
      int i = agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = agej.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
        localbplz = new bplz(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Bpvt, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Brhn.a(localbplz, 112);
        this.jdField_a_of_type_Brhn.a(localbplz, 113);
        this.jdField_a_of_type_Brhn.a(localbplz, 114);
        this.jdField_a_of_type_Brhn.a(localbplz, 115);
        if (paramInt == 0) {
          this.jdField_a_of_type_Brhn.a(localbplz, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_Bljm);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localbplz.a(a((bpnv)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localbplz);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localbplz);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localbplz = (bplz)localGridView.a();
      this.jdField_a_of_type_Brhn.a(localbplz, 112);
      this.jdField_a_of_type_Brhn.a(localbplz, 113);
      this.jdField_a_of_type_Brhn.a(localbplz, 114);
      this.jdField_a_of_type_Brhn.a(localbplz, 115);
      if (paramInt == 0) {
        this.jdField_a_of_type_Brhn.a(localbplz, 111);
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