package dov.com.qq.im.capture.adapter;

import aepi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import azkt;
import bhuw;
import blqr;
import blra;
import blsw;
import bmau;
import bnpl;
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
  private bhuw jdField_a_of_type_Bhuw;
  bmau jdField_a_of_type_Bmau;
  private bnpl jdField_a_of_type_Bnpl;
  public HashMap<Integer, GridView> a;
  private List<blsw> jdField_a_of_type_JavaUtilList;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, bmau parambmau, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bmau = parambmau;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bnpl = ((bnpl)blqr.a(3));
  }
  
  public blsw a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (blsw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public blsw a(blsw paramblsw)
  {
    if (paramblsw == null) {
      return paramblsw;
    }
    int i;
    label17:
    int j;
    label25:
    blsw localblsw;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (azkt.h()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localblsw = new blsw();
      localblsw.jdField_a_of_type_Int = paramblsw.jdField_a_of_type_Int;
      localblsw.jdField_a_of_type_JavaLangString = paramblsw.jdField_a_of_type_JavaLangString;
      localblsw.b = paramblsw.b;
      localblsw.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((paramblsw.jdField_a_of_type_JavaUtilList == null) || (paramblsw.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label198;
      }
      paramblsw = paramblsw.jdField_a_of_type_JavaUtilList.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!paramblsw.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramblsw.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localblsw.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localblsw;
  }
  
  public void a(List<blsw> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (blra)paramViewGroup.a();
      this.jdField_a_of_type_Bnpl.a(paramViewGroup);
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
    blra localblra;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int n = aepi.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(n);
      int i = aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = aepi.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = aepi.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
        localblra = new blra(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Bmau, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bnpl.a(localblra, 112);
        this.jdField_a_of_type_Bnpl.a(localblra, 113);
        this.jdField_a_of_type_Bnpl.a(localblra, 114);
        this.jdField_a_of_type_Bnpl.a(localblra, 115);
        if (paramInt == 0) {
          this.jdField_a_of_type_Bnpl.a(localblra, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_Bhuw);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localblra.a(a((blsw)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localblra);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localblra);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localblra = (blra)localGridView.a();
      this.jdField_a_of_type_Bnpl.a(localblra, 112);
      this.jdField_a_of_type_Bnpl.a(localblra, 113);
      this.jdField_a_of_type_Bnpl.a(localblra, 114);
      this.jdField_a_of_type_Bnpl.a(localblra, 115);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bnpl.a(localblra, 111);
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */