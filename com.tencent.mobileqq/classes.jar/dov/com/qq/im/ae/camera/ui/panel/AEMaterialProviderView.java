package dov.com.qq.im.ae.camera.ui.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import azga;
import bkxt;
import bkxu;
import bkzx;
import bkzy;
import blab;
import blqh;
import blqr;
import bltq;
import bmbm;
import bmbn;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMSlidingTabView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import xsx;

public class AEMaterialProviderView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, azga, bmbm
{
  private int jdField_a_of_type_Int = 1;
  private bkxt jdField_a_of_type_Bkxt;
  private bkzy jdField_a_of_type_Bkzy;
  public bltq a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = blqh.a();
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private AEMaterialTabAdapter jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter;
  private QIMSlidingTabView jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
  private List<bkzx> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public AEMaterialProviderView(Context paramContext, bkxt parambkxt)
  {
    super(paramContext);
    this.jdField_a_of_type_Bltq = new bkxu(this);
    this.jdField_a_of_type_Bkxt = parambkxt;
    c();
  }
  
  private ArrayList<bmbn> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bkzx localbkzx = (bkzx)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbkzx == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (-1 == localbkzx.jdField_a_of_type_Int) {
          this.jdField_a_of_type_Int = i;
        }
        bmbn localbmbn = new bmbn();
        localbmbn.a = localbkzx.b;
        localArrayList.add(localbmbn);
      }
    }
    return localArrayList;
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131558491, this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)findViewById(2131378176));
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131379906));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter = new AEMaterialTabAdapter(getContext(), this.jdField_a_of_type_Bkxt);
    this.jdField_a_of_type_Bkzy = ((bkzy)blqr.a(18));
    this.jdField_a_of_type_Bkzy.e();
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bltq);
    a(true);
  }
  
  public String a()
  {
    return "AEMaterialProviderView";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkzy != null) {
      this.jdField_a_of_type_Bkzy.g();
    }
  }
  
  @TargetApi(9)
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 114) && (paramVarArgs != null) && (paramVarArgs.length != 1)) {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("selectCategoryAndItem");
      ((StringBuilder)localObject).append(", categoryName=").append(paramString1);
      ((StringBuilder)localObject).append(", itemId=").append(paramString2);
      ((StringBuilder)localObject).append(", mTabListSize=").append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("AEMaterialProviderView", 2, ((StringBuilder)localObject).toString());
    }
    this.b = true;
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      a(true);
    }
    int i = 0;
    int j;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((paramString1 != null) && (paramString1.equals(((bkzx)this.jdField_a_of_type_JavaUtilList.get(i)).b)))
      {
        paramString1 = (bkzx)this.jdField_a_of_type_JavaUtilList.get(i);
        j = i;
      }
    }
    for (;;)
    {
      if (paramString1 == null)
      {
        return;
        i += 1;
        break;
      }
      i = 0;
      label167:
      if (i < paramString1.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (blab)paramString1.jdField_a_of_type_JavaUtilList.get(i);
        if (!((blab)localObject).a.equals(paramString2)) {}
      }
      for (paramString1 = (String)localObject;; paramString1 = null)
      {
        ThreadManager.getUIHandler().post(new AEMaterialProviderView.2(this, j));
        if (QLog.isColorLevel()) {
          QLog.d("AEMaterialProviderView", 2, "itemInfo= " + paramString1 + ",index=" + j + ",pos=" + i);
        }
        if (paramString1 == null) {
          break;
        }
        if (paramString1.a())
        {
          xsx.a(getContext(), paramString1);
          return;
          i += 1;
          break label167;
        }
        postDelayed(new AEMaterialProviderView.3(this, j, paramString1), 200L);
        return;
        i = 0;
      }
      j = 0;
      paramString1 = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_Bkzy.a(paramBoolean));
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null)
      {
        i = j;
        if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            break label340;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
          bkzx localbkzx1 = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.a(i);
          if (localbkzx1 == null) {
            break label340;
          }
          i = 0;
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label340;
          }
          bkzx localbkzx2 = (bkzx)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localbkzx2 == null) || (TextUtils.isEmpty(localbkzx2.b)) || (!localbkzx2.b.equals(localbkzx1.b))) {
            break label333;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter != null)
      {
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.a(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(a());
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
      }
      j = i;
      if (i >= this.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("AEMaterialProviderView", 2, "resetPos " + i + " not exist, mTabList size = " + this.jdField_a_of_type_JavaUtilList.size());
          j = 0;
        }
      }
      if ((!this.b) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(j);
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(j);
      }
      return;
      label333:
      i += 1;
      break;
      label340:
      i = j;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bkzy != null)
    {
      this.jdField_a_of_type_Bkzy.b(null, false);
      this.jdField_a_of_type_Bkzy.a(111);
      this.jdField_a_of_type_Bkzy.a(113);
      this.jdField_a_of_type_Bkzy.a(112);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bltq);
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(paramInt);
  }
  
  public void onScrollChanged() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView
 * JD-Core Version:    0.7.0.1
 */