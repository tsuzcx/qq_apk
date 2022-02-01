package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialCategory;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.capture.QIMManager;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AEMaterialPanel.AEMaterialPanelListener jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
  private AEMaterialManager jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
  public HashMap<Integer, AEGridView> a;
  private List<AEMaterialCategory> jdField_a_of_type_JavaUtilList;
  
  public AEMaterialTabAdapter(Context paramContext, AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = paramAEMaterialPanelListener;
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager = ((AEMaterialManager)QIMManager.a(18));
  }
  
  private void a(AEMaterialAdapter paramAEMaterialAdapter, int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramAEMaterialAdapter, 112);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramAEMaterialAdapter, 113);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramAEMaterialAdapter, 1024);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramAEMaterialAdapter, 114);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramAEMaterialAdapter, 111);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramAEMaterialAdapter, 115);
    if (paramInt == 0) {
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramAEMaterialAdapter, 111);
    }
  }
  
  public AEMaterialCategory a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (paramInt >= 0)) {
      return (AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<AEMaterialCategory> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (AEMaterialAdapter)paramViewGroup.getAdapter();
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramViewGroup);
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
      AEMaterialPanel.AEMaterialPanelListener localAEMaterialPanelListener = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new AEMaterialAdapter((Context)localObject, localAEGridView, localAEMaterialPanelListener, bool);
        a((AEMaterialAdapter)localObject, paramInt);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localAEGridView);
      }
    }
    for (;;)
    {
      ((AEMaterialAdapter)localObject).a(((AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
      paramViewGroup.addView(localAEGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localObject);
      }
      return localAEGridView;
      bool = false;
      break;
      localObject = (AEMaterialAdapter)localAEGridView.getAdapter();
      a((AEMaterialAdapter)localObject, paramInt);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */