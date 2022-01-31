package dov.com.qq.im.AECamera.panel.material;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import awhd;
import bgxt;
import bgxx;
import bgya;
import bhaf;
import bhag;
import bhfc;
import bhfm;
import bhik;
import bhqh;
import bhqi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMSlidingTabView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import vnd;

public class AEMaterialProviderView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, awhd, bhqh
{
  private int jdField_a_of_type_Int = 1;
  private bgxx jdField_a_of_type_Bgxx;
  private bhaf jdField_a_of_type_Bhaf;
  public bhik a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = bhfc.a();
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private AEMaterialTabAdapter jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter;
  private QIMSlidingTabView jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
  private List<bgxt> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  
  public AEMaterialProviderView(Context paramContext, bhaf parambhaf)
  {
    super(paramContext);
    this.jdField_a_of_type_Bhik = new bhag(this);
    this.jdField_a_of_type_Bhaf = parambhaf;
    c();
  }
  
  private ArrayList<bhqi> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bgxt localbgxt = (bgxt)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localbgxt == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (-1 == localbgxt.jdField_a_of_type_Int) {
          this.jdField_a_of_type_Int = i;
        }
        bhqi localbhqi = new bhqi();
        localbhqi.a = localbgxt.b;
        localArrayList.add(localbhqi);
      }
    }
    return localArrayList;
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131492949, this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)findViewById(2131311772));
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131313312));
    this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter = new AEMaterialTabAdapter(getContext(), this.jdField_a_of_type_Bhaf);
    this.jdField_a_of_type_Bgxx = ((bgxx)bhfm.a(18));
    this.jdField_a_of_type_Bgxx.c();
    this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_Bhik);
    a(true);
  }
  
  public String a()
  {
    return "AEMaterialProviderView";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bgxx != null) {
      this.jdField_a_of_type_Bgxx.e();
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
    int i = 0;
    int j;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((paramString1 != null) && (paramString1.equals(((bgxt)this.jdField_a_of_type_JavaUtilList.get(i)).b)))
      {
        paramString1 = (bgxt)this.jdField_a_of_type_JavaUtilList.get(i);
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
      label145:
      if (i < paramString1.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (bgya)paramString1.jdField_a_of_type_JavaUtilList.get(i);
        if (!((bgya)localObject).a.equals(paramString2)) {}
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
          vnd.a(getContext(), paramString1);
          return;
          i += 1;
          break label145;
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
    this.jdField_a_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_Bgxx.a(paramBoolean));
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null)
      {
        i = j;
        if (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            break label333;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
          bgxt localbgxt1 = this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter.a(i);
          if (localbgxt1 == null) {
            break label333;
          }
          i = 0;
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label333;
          }
          bgxt localbgxt2 = (bgxt)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localbgxt2 == null) || (TextUtils.isEmpty(localbgxt2.b)) || (!localbgxt2.b.equals(localbgxt1.b))) {
            break label326;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter != null)
      {
        this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter.a(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialTabAdapter);
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
      if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(j);
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.a(j);
      }
      return;
      label326:
      i += 1;
      break;
      label333:
      i = j;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bgxx != null)
    {
      this.jdField_a_of_type_Bgxx.b(null, false);
      this.jdField_a_of_type_Bgxx.a(111);
      this.jdField_a_of_type_Bgxx.a(113);
      this.jdField_a_of_type_Bgxx.a(112);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_Bhik);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.panel.material.AEMaterialProviderView
 * JD-Core Version:    0.7.0.1
 */