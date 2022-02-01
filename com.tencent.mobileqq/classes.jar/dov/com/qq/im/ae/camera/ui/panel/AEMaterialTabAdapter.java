package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import booa;
import boof;
import boqq;
import boqr;
import bplq;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private boof jdField_a_of_type_Boof;
  private boqr jdField_a_of_type_Boqr;
  public HashMap<Integer, AEGridView> a;
  private List<boqq> jdField_a_of_type_JavaUtilList;
  
  public AEMaterialTabAdapter(Context paramContext, boof paramboof)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boof = paramboof;
    this.jdField_a_of_type_Boqr = ((boqr)bplq.a(18));
  }
  
  private void a(booa parambooa, int paramInt)
  {
    this.jdField_a_of_type_Boqr.a(parambooa, 112);
    this.jdField_a_of_type_Boqr.a(parambooa, 113);
    this.jdField_a_of_type_Boqr.a(parambooa, 114);
    this.jdField_a_of_type_Boqr.a(parambooa, 111);
    this.jdField_a_of_type_Boqr.a(parambooa, 115);
    if (paramInt == 0) {
      this.jdField_a_of_type_Boqr.a(parambooa, 111);
    }
  }
  
  public boqq a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (boqq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<boqq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (booa)paramViewGroup.getAdapter();
      this.jdField_a_of_type_Boqr.a(paramViewGroup);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AEGridView localAEGridView = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    Object localObject;
    boolean bool;
    if (localAEGridView == null)
    {
      localAEGridView = new AEGridView(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_AndroidContentContext;
      boof localboof = this.jdField_a_of_type_Boof;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new booa((Context)localObject, localAEGridView, localboof, bool);
        a((booa)localObject, paramInt);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localAEGridView);
      }
    }
    for (;;)
    {
      ((booa)localObject).a(((boqq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
      paramViewGroup.addView(localAEGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localObject);
      }
      return localAEGridView;
      bool = false;
      break;
      localObject = (booa)localAEGridView.getAdapter();
      a((booa)localObject, paramInt);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */