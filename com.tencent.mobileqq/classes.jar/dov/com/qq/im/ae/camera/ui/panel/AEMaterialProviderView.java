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
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.data.AEMaterialCategory;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.view.QIMSlidingTabView;
import dov.com.qq.im.capture.view.QIMSlidingTabView.IOnTabCheckListener;
import dov.com.qq.im.capture.view.QIMSlidingTabView.TabIcon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class AEMaterialProviderView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, Observer, QIMSlidingTabView.IOnTabCheckListener
{
  private int jdField_a_of_type_Int = 1;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = CaptureContext.a();
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private AEMaterialPanel.AEMaterialPanelListener jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener;
  private AEMaterialTabAdapter jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter;
  private AEMaterialManager jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
  public CaptureConfigUpdateObserver a;
  private QIMSlidingTabView jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
  private List<AEMaterialCategory> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  private boolean c = false;
  
  public AEMaterialProviderView(Context paramContext, AEMaterialPanel.AEMaterialPanelListener paramAEMaterialPanelListener)
  {
    super(paramContext);
    this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver = new AEMaterialProviderView.1(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener = paramAEMaterialPanelListener;
    c();
  }
  
  private AEMaterialCategory a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    AEMaterialCategory localAEMaterialCategory;
    AEMaterialMetaData localAEMaterialMetaData;
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
          localAEMaterialCategory = (AEMaterialCategory)localIterator1.next();
        } while ((localAEMaterialCategory == null) || (localAEMaterialCategory.jdField_a_of_type_JavaUtilList == null));
        localIterator2 = localAEMaterialCategory.jdField_a_of_type_JavaUtilList.iterator();
      }
      localAEMaterialMetaData = (AEMaterialMetaData)localIterator2.next();
    } while ((localAEMaterialMetaData == null) || (!paramString.equals(localAEMaterialMetaData.a)));
    return localAEMaterialCategory;
    return null;
  }
  
  private ArrayList<QIMSlidingTabView.TabIcon> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localAEMaterialCategory == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (-1 == localAEMaterialCategory.jdField_a_of_type_Int) {
          this.jdField_a_of_type_Int = i;
        }
        QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
        localTabIcon.a = localAEMaterialCategory.b;
        localArrayList.add(localTabIcon);
      }
    }
    return localArrayList;
  }
  
  private boolean a()
  {
    if ((getContext() instanceof QIMCameraCaptureActivity))
    {
      QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)getContext();
      return (localQIMCameraCaptureActivity != null) && (AECameraEntry.k(localQIMCameraCaptureActivity.getIntent()));
    }
    return false;
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2131558522, this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView = ((QIMSlidingTabView)findViewById(2131379685));
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131381588));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter = new AEMaterialTabAdapter(getContext(), this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel$AEMaterialPanelListener);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager = ((AEMaterialManager)QIMManager.a(18));
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.b(false);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialTabAdapter);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
    a(true);
  }
  
  public String a()
  {
    return "AEMaterialProviderView";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager != null)
    {
      if (((getContext() instanceof Activity)) && (AECameraEntry.k(((Activity)getContext()).getIntent()))) {
        this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.e();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.d();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null))
    {
      AEQLog.b("AEMaterialProviderView", "locatePage: " + paramInt);
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
          if ((paramString1 != null) && (paramString1.equals(((AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(i)).b)))
          {
            paramString1 = (AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(i);
            break;
          }
          i += 1;
        }
      }
      int j = 0;
      label191:
      if (j < paramString1.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (AEMaterialMetaData)paramString1.jdField_a_of_type_JavaUtilList.get(j);
        if (!((AEMaterialMetaData)localObject).a.equals(paramString2)) {}
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
        this.c = true;
        if (paramString1.a())
        {
          WeishiGuideUtils.a(getContext(), paramString1);
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
      localObject = this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a();
      AEQLog.a("AEMaterialProviderView", "### updateData: fromCircle = " + a() + " | totalList = " + localObject.toString());
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
            if (this.b) {
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
            AEMaterialCategory localAEMaterialCategory = (AEMaterialCategory)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localAEMaterialCategory == null) || (TextUtils.isEmpty(localAEMaterialCategory.b)) || (!localAEMaterialCategory.b.equals(((AEMaterialCategory)localObject).b))) {
              break label387;
            }
          }
        }
      }
    }
    for (;;)
    {
      this.b = false;
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
      if ((!this.c) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)) {
        a(j);
      }
      return;
      localObject = this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(paramBoolean);
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
    if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager != null)
    {
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.f();
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(111);
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(113);
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(112);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView
 * JD-Core Version:    0.7.0.1
 */