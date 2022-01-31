package dov.com.qq.im.capture.adapter;

import aekt;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import azgk;
import bhqp;
import blmf;
import blmo;
import blok;
import blwi;
import bnkz;
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
  private bhqp jdField_a_of_type_Bhqp;
  blwi jdField_a_of_type_Blwi;
  private bnkz jdField_a_of_type_Bnkz;
  public HashMap<Integer, GridView> a;
  private List<blok> jdField_a_of_type_JavaUtilList;
  
  public QIMPtvTemplateViewPagerAdapter(Context paramContext, blwi paramblwi, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blwi = paramblwi;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bnkz = ((bnkz)blmf.a(3));
  }
  
  public blok a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (blok)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public blok a(blok paramblok)
  {
    if (paramblok == null) {
      return paramblok;
    }
    int i;
    label17:
    int j;
    label25:
    blok localblok;
    if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT))
    {
      i = 1;
      if (azgk.h()) {
        break label187;
      }
      j = 1;
      if ((j == 0) && (i == 0)) {
        break label190;
      }
      localblok = new blok();
      localblok.jdField_a_of_type_Int = paramblok.jdField_a_of_type_Int;
      localblok.jdField_a_of_type_JavaLangString = paramblok.jdField_a_of_type_JavaLangString;
      localblok.b = paramblok.b;
      localblok.jdField_a_of_type_JavaUtilList = new ArrayList();
      if ((paramblok.jdField_a_of_type_JavaUtilList == null) || (paramblok.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label198;
      }
      paramblok = paramblok.jdField_a_of_type_JavaUtilList.iterator();
    }
    label187:
    label190:
    label196:
    for (;;)
    {
      label110:
      if (!paramblok.hasNext()) {
        break label198;
      }
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramblok.next();
      if (((i != 0) && (localPtvTemplateInfo.kind == 7)) || ((j != 0) && (localPtvTemplateInfo.kind == 11))) {}
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label196;
        }
        localblok.jdField_a_of_type_JavaUtilList.add(localPtvTemplateInfo);
        break label110;
        i = 0;
        break label17;
        j = 0;
        break label25;
        break;
      }
    }
    label198:
    return localblok;
  }
  
  public void a(List<blok> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (GridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (blmo)paramViewGroup.a();
      this.jdField_a_of_type_Bnkz.a(paramViewGroup);
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
    blmo localblmo;
    if (localGridView == null)
    {
      localGridView = new GridView(this.jdField_a_of_type_AndroidContentContext);
      localGridView.setNumColumns(-1);
      int n = aekt.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localGridView.setColumnWidth(n);
      int i = aekt.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = aekt.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int k = aekt.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
        localblmo = new blmo(this.jdField_a_of_type_AndroidContentContext, localGridView, this.jdField_a_of_type_Blwi, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Bnkz.a(localblmo, 112);
        this.jdField_a_of_type_Bnkz.a(localblmo, 113);
        this.jdField_a_of_type_Bnkz.a(localblmo, 114);
        this.jdField_a_of_type_Bnkz.a(localblmo, 115);
        if (paramInt == 0) {
          this.jdField_a_of_type_Bnkz.a(localblmo, 111);
        }
        localGridView.setOnItemClickListener(this.jdField_a_of_type_Bhqp);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localGridView);
      }
    }
    for (;;)
    {
      localblmo.a(a((blok)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localGridView.setAdapter(localblmo);
      paramViewGroup.addView(localGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localblmo);
      }
      return localGridView;
      localGridView.setHorizontalSpacing(j);
      break;
      localblmo = (blmo)localGridView.a();
      this.jdField_a_of_type_Bnkz.a(localblmo, 112);
      this.jdField_a_of_type_Bnkz.a(localblmo, 113);
      this.jdField_a_of_type_Bnkz.a(localblmo, 114);
      this.jdField_a_of_type_Bnkz.a(localblmo, 115);
      if (paramInt == 0) {
        this.jdField_a_of_type_Bnkz.a(localblmo, 111);
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