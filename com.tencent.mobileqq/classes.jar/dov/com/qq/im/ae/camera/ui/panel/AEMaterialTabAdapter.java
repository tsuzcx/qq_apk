package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import bnfq;
import bnfv;
import bnka;
import bnkb;
import bogd;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bnfv jdField_a_of_type_Bnfv;
  private bnkb jdField_a_of_type_Bnkb;
  public HashMap<Integer, AEGridView> a;
  private List<bnka> jdField_a_of_type_JavaUtilList;
  
  public AEMaterialTabAdapter(Context paramContext, bnfv parambnfv)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bnfv = parambnfv;
    this.jdField_a_of_type_Bnkb = ((bnkb)bogd.a(18));
  }
  
  private void a(bnfq parambnfq, int paramInt)
  {
    this.jdField_a_of_type_Bnkb.a(parambnfq, 112);
    this.jdField_a_of_type_Bnkb.a(parambnfq, 113);
    this.jdField_a_of_type_Bnkb.a(parambnfq, 1024);
    this.jdField_a_of_type_Bnkb.a(parambnfq, 114);
    this.jdField_a_of_type_Bnkb.a(parambnfq, 111);
    this.jdField_a_of_type_Bnkb.a(parambnfq, 115);
    if (paramInt == 0) {
      this.jdField_a_of_type_Bnkb.a(parambnfq, 111);
    }
  }
  
  public bnka a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (bnka)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<bnka> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (bnfq)paramViewGroup.getAdapter();
      this.jdField_a_of_type_Bnkb.a(paramViewGroup);
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
      bnfv localbnfv = this.jdField_a_of_type_Bnfv;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new bnfq((Context)localObject, localAEGridView, localbnfv, bool);
        a((bnfq)localObject, paramInt);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localAEGridView);
      }
    }
    for (;;)
    {
      ((bnfq)localObject).a(((bnka)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
      paramViewGroup.addView(localAEGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localObject);
      }
      return localAEGridView;
      bool = false;
      break;
      localObject = (bnfq)localAEGridView.getAdapter();
      a((bnfq)localObject, paramInt);
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