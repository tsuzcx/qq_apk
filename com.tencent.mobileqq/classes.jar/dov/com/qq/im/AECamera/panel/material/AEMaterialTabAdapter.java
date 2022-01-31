package dov.com.qq.im.AECamera.panel.material;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import bgxt;
import bgxx;
import bgzy;
import bhaf;
import bhfm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bgxx jdField_a_of_type_Bgxx;
  private bhaf jdField_a_of_type_Bhaf;
  public HashMap<Integer, AEGridView> a;
  private List<bgxt> jdField_a_of_type_JavaUtilList;
  
  public AEMaterialTabAdapter(Context paramContext, bhaf parambhaf)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bhaf = parambhaf;
    this.jdField_a_of_type_Bgxx = ((bgxx)bhfm.a(18));
  }
  
  private void a(bgzy parambgzy, int paramInt)
  {
    this.jdField_a_of_type_Bgxx.a(parambgzy, 112);
    this.jdField_a_of_type_Bgxx.a(parambgzy, 113);
    this.jdField_a_of_type_Bgxx.a(parambgzy, 114);
    this.jdField_a_of_type_Bgxx.a(parambgzy, 111);
    this.jdField_a_of_type_Bgxx.a(parambgzy, 115);
    if (paramInt == 0) {
      this.jdField_a_of_type_Bgxx.a(parambgzy, 111);
    }
  }
  
  public bgxt a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bgxt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<bgxt> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bgzy)paramViewGroup.getAdapter();
      this.jdField_a_of_type_Bgxx.a(paramViewGroup);
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
      bhaf localbhaf = this.jdField_a_of_type_Bhaf;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new bgzy((Context)localObject, localAEGridView, localbhaf, bool);
        a((bgzy)localObject, paramInt);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localAEGridView);
      }
    }
    for (;;)
    {
      ((bgzy)localObject).a(((bgxt)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
      paramViewGroup.addView(localAEGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localObject);
      }
      return localAEGridView;
      bool = false;
      break;
      localObject = (bgzy)localAEGridView.getAdapter();
      a((bgzy)localObject, paramInt);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.panel.material.AEMaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */