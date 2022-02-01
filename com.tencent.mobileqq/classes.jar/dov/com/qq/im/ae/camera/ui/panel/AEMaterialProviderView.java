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
import bcha;
import bnmu;
import bnmv;
import bnpb;
import bnpc;
import bnpf;
import bnqb;
import bnzb;
import bojl;
import bojv;
import bomu;
import bouq;
import bour;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.capture.view.QIMSlidingTabView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import zmi;

public class AEMaterialProviderView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, bcha, bouq
{
  private int jdField_a_of_type_Int = 1;
  private bnmu jdField_a_of_type_Bnmu;
  private bnpc jdField_a_of_type_Bnpc;
  public bomu a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = bojl.a();
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private AEMaterialTabAdapter jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter;
  private QIMSlidingTabView jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
  private List<bnpb> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  public AEMaterialProviderView(Context paramContext, bnmu parambnmu)
  {
    super(paramContext);
    this.jdField_a_of_type_Bomu = new bnmv(this);
    this.jdField_a_of_type_Bnmu = parambnmu;
    c();
  }
  
  private ArrayList<bour> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bnpb localbnpb = (bnpb)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbnpb == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (-1 == localbnpb.jdField_a_of_type_Int) {
          this.jdField_a_of_type_Int = i;
        }
        bour localbour = new bour();
        localbour.a = localbnpb.b;
        localArrayList.add(localbour);
      }
    }
    return localArrayList;
  }
  
  private boolean a()
  {
    if ((getContext() instanceof QIMCameraCaptureActivity))
    {
      QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)getContext();
      return (localQIMCameraCaptureActivity != null) && (bnqb.j(localQIMCameraCaptureActivity.getIntent()));
    }
    return false;
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131558503, this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)findViewById(2131379024));
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131380863));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter = new AEMaterialTabAdapter(getContext(), this.jdField_a_of_type_Bnmu);
    this.jdField_a_of_type_Bnpc = ((bnpc)bojv.a(18));
    this.jdField_a_of_type_Bnpc.e();
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bomu);
    a(true);
  }
  
  public String a()
  {
    return "AEMaterialProviderView";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bnpc != null)
    {
      if (((getContext() instanceof Activity)) && (bnqb.j(((Activity)getContext()).getIntent()))) {
        this.jdField_a_of_type_Bnpc.h();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Bnpc.g();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null))
    {
      bnzb.b("AEMaterialProviderView", "locatePage: " + paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 114) && (paramVarArgs != null) && (paramVarArgs.length != 1)) {}
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
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
    int i = 0;
    int j;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((paramString1 != null) && (paramString1.equals(((bnpb)this.jdField_a_of_type_JavaUtilList.get(i)).b)))
      {
        paramString1 = (bnpb)this.jdField_a_of_type_JavaUtilList.get(i);
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
      label170:
      if (i < paramString1.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (bnpf)paramString1.jdField_a_of_type_JavaUtilList.get(i);
        if (!((bnpf)localObject).a.equals(paramString2)) {}
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
        this.b = true;
        if (paramString1.a())
        {
          zmi.a(getContext(), paramString1);
          return;
          i += 1;
          break label170;
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
    Object localObject;
    int j;
    int i;
    if (a())
    {
      localObject = this.jdField_a_of_type_Bnpc.a();
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
              break label352;
            }
            i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
            localObject = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.a(i);
            if (localObject == null) {
              break label352;
            }
            i = 0;
            label90:
            if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
              break label352;
            }
            bnpb localbnpb = (bnpb)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localbnpb == null) || (TextUtils.isEmpty(localbnpb.b)) || (!localbnpb.b.equals(((bnpb)localObject).b))) {
              break label345;
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
      if ((!this.b) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)) {
        a(j);
      }
      return;
      localObject = this.jdField_a_of_type_Bnpc.a(paramBoolean);
      break;
      label345:
      i += 1;
      break label90;
      label352:
      i = j;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bnpc != null)
    {
      this.jdField_a_of_type_Bnpc.b(null, false);
      this.jdField_a_of_type_Bnpc.a(111);
      this.jdField_a_of_type_Bnpc.a(113);
      this.jdField_a_of_type_Bnpc.a(112);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bomu);
    }
  }
  
  @TargetApi(9)
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView
 * JD-Core Version:    0.7.0.1
 */