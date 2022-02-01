package dov.com.qq.im.ae.camera.ui.panel;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import bbsx;
import blsm;
import blsn;
import blux;
import bluy;
import blvb;
import blvr;
import bmbx;
import bmqh;
import bmql;
import bmtc;
import bmzp;
import bmzq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.capture.view.QIMSlidingTabView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import yqu;

public class AEMaterialProviderView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, bbsx, bmzp
{
  private int jdField_a_of_type_Int = 1;
  private blsm jdField_a_of_type_Blsm;
  private bluy jdField_a_of_type_Bluy;
  public bmtc a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = bmqh.a();
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private AEMaterialTabAdapter jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter;
  private QIMSlidingTabView jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
  private List<blux> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public AEMaterialProviderView(Context paramContext, blsm paramblsm)
  {
    super(paramContext);
    this.jdField_a_of_type_Bmtc = new blsn(this);
    this.jdField_a_of_type_Blsm = paramblsm;
    c();
  }
  
  private blux a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    blux localblux;
    blvb localblvb;
    do
    {
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        do
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localblux = (blux)localIterator1.next();
        } while ((localblux == null) || (localblux.jdField_a_of_type_JavaUtilList == null));
        localIterator2 = localblux.jdField_a_of_type_JavaUtilList.iterator();
      }
      localblvb = (blvb)localIterator2.next();
    } while ((localblvb == null) || (!paramString.equals(localblvb.a)));
    return localblux;
    return null;
  }
  
  private ArrayList<bmzq> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      blux localblux = (blux)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localblux == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (-1 == localblux.jdField_a_of_type_Int) {
          this.jdField_a_of_type_Int = i;
        }
        bmzq localbmzq = new bmzq();
        localbmzq.a = localblux.b;
        localArrayList.add(localbmzq);
      }
    }
    return localArrayList;
  }
  
  private boolean a()
  {
    if ((getContext() instanceof QIMCameraCaptureActivity))
    {
      QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)getContext();
      return (localQIMCameraCaptureActivity != null) && (blvr.j(localQIMCameraCaptureActivity.getIntent()));
    }
    return false;
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131558503, this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)findViewById(2131378957));
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131380767));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter = new AEMaterialTabAdapter(getContext(), this.jdField_a_of_type_Blsm);
    this.jdField_a_of_type_Bluy = ((bluy)bmql.a(18));
    this.jdField_a_of_type_Bluy.b(false);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bmtc);
    a(true);
  }
  
  public String a()
  {
    return "AEMaterialProviderView";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bluy != null)
    {
      if (((getContext() instanceof Activity)) && (blvr.j(((Activity)getContext()).getIntent()))) {
        this.jdField_a_of_type_Bluy.e();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bluy.d();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null))
    {
      bmbx.b("AEMaterialProviderView", "locatePage: " + paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
    }
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
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      a(true);
    }
    int i;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = a(paramString2);
      i = this.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
    }
    for (;;)
    {
      if (paramString1 == null)
      {
        return;
        i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label367;
          }
          if ((paramString1 != null) && (paramString1.equals(((blux)this.jdField_a_of_type_JavaUtilList.get(i)).b)))
          {
            paramString1 = (blux)this.jdField_a_of_type_JavaUtilList.get(i);
            break;
          }
          i += 1;
        }
      }
      int j = 0;
      label191:
      if (j < paramString1.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (blvb)paramString1.jdField_a_of_type_JavaUtilList.get(j);
        if (!((blvb)localObject).a.equals(paramString2)) {}
      }
      for (paramString1 = (String)localObject;; paramString1 = null)
      {
        ThreadManager.getUIHandler().post(new AEMaterialProviderView.2(this, i));
        if (QLog.isColorLevel()) {
          QLog.d("AEMaterialProviderView", 2, "itemInfo= " + paramString1 + ",index=" + i + ",pos=" + j);
        }
        if (paramString1 == null) {
          break;
        }
        this.b = true;
        if (paramString1.a())
        {
          yqu.a(getContext(), paramString1);
          return;
          j += 1;
          break label191;
        }
        postDelayed(new AEMaterialProviderView.3(this, i, paramString1), 200L);
        return;
        j = 0;
      }
      label367:
      i = 0;
      paramString1 = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    int j;
    int i;
    if (a())
    {
      localObject = this.jdField_a_of_type_Bluy.a();
      bmbx.a("AEMaterialProviderView", "### updateData: fromCircle = " + a() + " | totalList = " + localObject.toString());
      this.jdField_a_of_type_JavaUtilList = new ArrayList((Collection)localObject);
      j = this.jdField_a_of_type_Int;
      i = j;
      if (!paramBoolean)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null)
        {
          i = j;
          if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter != null)
          {
            if (this.jdField_a_of_type_Boolean) {
              break label394;
            }
            i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
            localObject = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.a(i);
            if (localObject == null) {
              break label394;
            }
            i = 0;
            label132:
            if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
              break label394;
            }
            blux localblux = (blux)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localblux == null) || (TextUtils.isEmpty(localblux.b)) || (!localblux.b.equals(((blux)localObject).b))) {
              break label387;
            }
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
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
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
      if ((!this.b) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)) {
        a(j);
      }
      return;
      localObject = this.jdField_a_of_type_Bluy.a(paramBoolean);
      break;
      label387:
      i += 1;
      break label132;
      label394:
      i = j;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bluy != null)
    {
      this.jdField_a_of_type_Bluy.f();
      this.jdField_a_of_type_Bluy.a(111);
      this.jdField_a_of_type_Bluy.a(113);
      this.jdField_a_of_type_Bluy.a(112);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bmtc);
    }
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 114) && (paramVarArgs != null) && (paramVarArgs.length != 1)) {}
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
  }
  
  public void onScrollChanged() {}
  
  @TargetApi(9)
  public void onTabChecked(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView
 * JD-Core Version:    0.7.0.1
 */