package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import bktf;
import bktm;
import bkvq;
import bkvr;
import blmf;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bktm jdField_a_of_type_Bktm;
  private bkvr jdField_a_of_type_Bkvr;
  public HashMap<Integer, AEGridView> a;
  private List<bkvq> jdField_a_of_type_JavaUtilList;
  
  public AEMaterialTabAdapter(Context paramContext, bktm parambktm)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bktm = parambktm;
    this.jdField_a_of_type_Bkvr = ((bkvr)blmf.a(18));
  }
  
  private void a(bktf parambktf, int paramInt)
  {
    this.jdField_a_of_type_Bkvr.a(parambktf, 112);
    this.jdField_a_of_type_Bkvr.a(parambktf, 113);
    this.jdField_a_of_type_Bkvr.a(parambktf, 114);
    this.jdField_a_of_type_Bkvr.a(parambktf, 111);
    this.jdField_a_of_type_Bkvr.a(parambktf, 115);
    if (paramInt == 0) {
      this.jdField_a_of_type_Bkvr.a(parambktf, 111);
    }
  }
  
  public bkvq a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bkvq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<bkvq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bktf)paramViewGroup.getAdapter();
      this.jdField_a_of_type_Bkvr.a(paramViewGroup);
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
      bktm localbktm = this.jdField_a_of_type_Bktm;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new bktf((Context)localObject, localAEGridView, localbktm, bool);
        a((bktf)localObject, paramInt);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localAEGridView);
      }
    }
    for (;;)
    {
      ((bktf)localObject).a(((bkvq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
      paramViewGroup.addView(localAEGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localObject);
      }
      return localAEGridView;
      bool = false;
      break;
      localObject = (bktf)localAEGridView.getAdapter();
      a((bktf)localObject, paramInt);
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