package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import blsh;
import blsm;
import blux;
import bluy;
import bmql;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private blsm jdField_a_of_type_Blsm;
  private bluy jdField_a_of_type_Bluy;
  public HashMap<Integer, AEGridView> a;
  private List<blux> jdField_a_of_type_JavaUtilList;
  
  public AEMaterialTabAdapter(Context paramContext, blsm paramblsm)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blsm = paramblsm;
    this.jdField_a_of_type_Bluy = ((bluy)bmql.a(18));
  }
  
  private void a(blsh paramblsh, int paramInt)
  {
    this.jdField_a_of_type_Bluy.a(paramblsh, 112);
    this.jdField_a_of_type_Bluy.a(paramblsh, 113);
    this.jdField_a_of_type_Bluy.a(paramblsh, 114);
    this.jdField_a_of_type_Bluy.a(paramblsh, 111);
    this.jdField_a_of_type_Bluy.a(paramblsh, 115);
    if (paramInt == 0) {
      this.jdField_a_of_type_Bluy.a(paramblsh, 111);
    }
  }
  
  public blux a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (blux)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<blux> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (blsh)paramViewGroup.getAdapter();
      this.jdField_a_of_type_Bluy.a(paramViewGroup);
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
      blsm localblsm = this.jdField_a_of_type_Blsm;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new blsh((Context)localObject, localAEGridView, localblsm, bool);
        a((blsh)localObject, paramInt);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localAEGridView);
      }
    }
    for (;;)
    {
      ((blsh)localObject).a(((blux)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
      paramViewGroup.addView(localAEGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localObject);
      }
      return localAEGridView;
      bool = false;
      break;
      localObject = (blsh)localAEGridView.getAdapter();
      a((blsh)localObject, paramInt);
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