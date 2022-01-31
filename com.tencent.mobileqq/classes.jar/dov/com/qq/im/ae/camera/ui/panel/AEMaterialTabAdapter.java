package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import bkxm;
import bkxt;
import bkzx;
import bkzy;
import blqr;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bkxt jdField_a_of_type_Bkxt;
  private bkzy jdField_a_of_type_Bkzy;
  public HashMap<Integer, AEGridView> a;
  private List<bkzx> jdField_a_of_type_JavaUtilList;
  
  public AEMaterialTabAdapter(Context paramContext, bkxt parambkxt)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bkxt = parambkxt;
    this.jdField_a_of_type_Bkzy = ((bkzy)blqr.a(18));
  }
  
  private void a(bkxm parambkxm, int paramInt)
  {
    this.jdField_a_of_type_Bkzy.a(parambkxm, 112);
    this.jdField_a_of_type_Bkzy.a(parambkxm, 113);
    this.jdField_a_of_type_Bkzy.a(parambkxm, 114);
    this.jdField_a_of_type_Bkzy.a(parambkxm, 111);
    this.jdField_a_of_type_Bkzy.a(parambkxm, 115);
    if (paramInt == 0) {
      this.jdField_a_of_type_Bkzy.a(parambkxm, 111);
    }
  }
  
  public bkzx a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bkzx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<bkzx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bkxm)paramViewGroup.getAdapter();
      this.jdField_a_of_type_Bkzy.a(paramViewGroup);
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
      bkxt localbkxt = this.jdField_a_of_type_Bkxt;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new bkxm((Context)localObject, localAEGridView, localbkxt, bool);
        a((bkxm)localObject, paramInt);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localAEGridView);
      }
    }
    for (;;)
    {
      ((bkxm)localObject).a(((bkzx)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
      paramViewGroup.addView(localAEGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localObject);
      }
      return localAEGridView;
      bool = false;
      break;
      localObject = (bkxm)localAEGridView.getAdapter();
      a((bkxm)localObject, paramInt);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */