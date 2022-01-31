package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import biol;
import bios;
import bira;
import birb;
import bjav;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bios jdField_a_of_type_Bios;
  private birb jdField_a_of_type_Birb;
  public HashMap<Integer, AEGridView> a;
  private List<bira> jdField_a_of_type_JavaUtilList;
  
  public AEMaterialTabAdapter(Context paramContext, bios parambios)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bios = parambios;
    this.jdField_a_of_type_Birb = ((birb)bjav.a(18));
  }
  
  private void a(biol parambiol, int paramInt)
  {
    this.jdField_a_of_type_Birb.a(parambiol, 112);
    this.jdField_a_of_type_Birb.a(parambiol, 113);
    this.jdField_a_of_type_Birb.a(parambiol, 114);
    this.jdField_a_of_type_Birb.a(parambiol, 111);
    this.jdField_a_of_type_Birb.a(parambiol, 115);
    if (paramInt == 0) {
      this.jdField_a_of_type_Birb.a(parambiol, 111);
    }
  }
  
  public bira a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bira)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<bira> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (biol)paramViewGroup.getAdapter();
      this.jdField_a_of_type_Birb.a(paramViewGroup);
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
      bios localbios = this.jdField_a_of_type_Bios;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new biol((Context)localObject, localAEGridView, localbios, bool);
        a((biol)localObject, paramInt);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localAEGridView);
      }
    }
    for (;;)
    {
      ((biol)localObject).a(((bira)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
      paramViewGroup.addView(localAEGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localObject);
      }
      return localAEGridView;
      bool = false;
      break;
      localObject = (biol)localAEGridView.getAdapter();
      a((biol)localObject, paramInt);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */