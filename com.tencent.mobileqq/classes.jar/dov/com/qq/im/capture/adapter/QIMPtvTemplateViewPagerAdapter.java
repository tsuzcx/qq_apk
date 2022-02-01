package dov.com.qq.im.capture.adapter;

import afur;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import bcls;
import bkij;
import bojv;
import boke;
import boma;
import boty;
import bqgc;
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
  private bkij jdField_a_of_type_Bkij;
  boty jdField_a_of_type_Boty;
  private bqgc jdField_a_of_type_Bqgc;
  public HashMap<Integer, GridView> a;
  private List<boma> jdField_a_of_type_JavaUtilList;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, boty paramboty, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boty = paramboty;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bqgc = ((bqgc)bojv.a(3));
  }
  
  public boma a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (boma)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public boma a(boma paramboma)
  {
    if (paramboma == null) {
      return paramboma;
    }
    int i;
    label17:
    int j;
    label25:
    boma localboma;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (bcls.f()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localboma = new boma();
      localboma.jdField_a_of_type_Int = paramboma.jdField_a_of_type_Int;
      localboma.jdField_a_of_type_JavaLangString = paramboma.jdField_a_of_type_JavaLangString;
      localboma.b = paramboma.b;
      localboma.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((paramboma.jdField_a_of_type_JavaUtilList == null) || (paramboma.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label198;
      }
      paramboma = paramboma.jdField_a_of_type_JavaUtilList.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!paramboma.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramboma.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localboma.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localboma;
  }
  
  public void a(List<boma> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (boke)paramViewGroup.a();
      this.jdField_a_of_type_Bqgc.a(paramViewGroup);
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
    boke localboke;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int n = afur.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(n);
      int i = afur.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = afur.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = afur.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
        localboke = new boke(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Boty, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bqgc.a(localboke, 112);
        this.jdField_a_of_type_Bqgc.a(localboke, 113);
        this.jdField_a_of_type_Bqgc.a(localboke, 114);
        this.jdField_a_of_type_Bqgc.a(localboke, 115);
        if (paramInt == 0) {
          this.jdField_a_of_type_Bqgc.a(localboke, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_Bkij);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localboke.a(a((boma)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localboke);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localboke);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localboke = (boke)localGridView.a();
      this.jdField_a_of_type_Bqgc.a(localboke, 112);
      this.jdField_a_of_type_Bqgc.a(localboke, 113);
      this.jdField_a_of_type_Bqgc.a(localboke, 114);
      this.jdField_a_of_type_Bqgc.a(localboke, 115);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bqgc.a(localboke, 111);
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