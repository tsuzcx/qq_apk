package dov.com.qq.im.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QQFilterRenderManagerHolder;
import dov.com.qq.im.ae.camera.core.AEFilterManagerHolder;
import dov.com.qq.im.ae.camera.filter.AEFilterProcessTex;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureComboListener;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureRecord;
import dov.com.qq.im.capture.data.ComboSet;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.FilterSet;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TemplateSet;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.predownload.QIMPredownManager;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import java.util.ArrayList;
import java.util.List;

public class AEFilterProviderView
  extends ProviderView
  implements AEFilterProviderAdapter.OnItemClickListener, CaptureComboManager.CaptureComboListener
{
  public int a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEFilterProviderAdapter jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter;
  private AEProviderContainerView jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView;
  private CaptureComboManager jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager;
  public VideoFilterTools.DataSet a;
  public ArrayList<FilterCategory> a;
  public int b = 0;
  
  public AEFilterProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  public static String a()
  {
    String str = AECameraPrefsUtil.a().a("ae_filter_id", "", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "getFilterId(ae_filter_id, " + str + ")");
    }
    return str;
  }
  
  public static void a(String paramString)
  {
    AECameraPrefsUtil.a().a("ae_filter_id", paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "saveFilterPref(ae_filter_id, " + paramString + ")");
    }
  }
  
  private void c(Bundle paramBundle)
  {
    Bundle localBundle = null;
    if (paramBundle != null) {
      localBundle = paramBundle.getBundle(AEFilterProviderView.class.getSimpleName());
    }
    if (localBundle != null)
    {
      if (VideoFilterTools.a().a[this.g] != null) {
        VideoFilterTools.a().a[this.g].c = 1;
      }
      paramBundle = (QIMFilterCategoryItem)localBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AEFilterProviderView", 2, "restore " + paramBundle.a);
        }
        paramBundle.c = 1;
      }
    }
  }
  
  public int a()
  {
    return 2131561010;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[this.g].a();
      this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "onDestroy");
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    FilterCategory localFilterCategory = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.b);
    paramInt = 0;
    if (paramInt < localFilterCategory.a.size())
    {
      paramString1 = (QIMFilterCategoryItem)localFilterCategory.a.get(paramInt);
      if (!paramString1.a.equals(paramString2)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterProviderView", 2, "itemInfo= " + paramString1 + ",index=" + this.b + ",pos=" + paramInt);
      }
      if (paramString1 != null)
      {
        postDelayed(new AEFilterProviderView.1(this, paramInt), 200L);
        if (this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager != null)
        {
          paramString2 = new Bundle();
          paramString2.putInt("apply_source", 1);
          paramString2.putInt("capture_scene", this.g);
          this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.a(paramString1, (Activity)getContext(), paramString2);
        }
        if (!this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.a()) {
          a(paramString1.a);
        }
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
      }
      return;
      paramInt += 1;
      break;
      paramInt = 0;
      paramString1 = null;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView = ((AEProviderContainerView)((Activity)getContext()).findViewById(2131363552));
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558505, this, true);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366979));
    paramBundle = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter = new AEFilterProviderAdapter(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter.a(this);
    if (QIMManager.a().a(5))
    {
      this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager = ((CaptureComboManager)QIMManager.a(5));
      if (this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager != null) {
        this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.a(this);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    paramBundle = this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterProviderView", 2, "filterProviderView get data is null");
      }
      return;
    }
    a(paramBundle.a(this.g));
  }
  
  public void a(View paramView, int paramInt)
  {
    StringBuilder localStringBuilder = null;
    if (paramView != null) {}
    for (Object localObject = paramView.getTag();; localObject = null)
    {
      paramView = localStringBuilder;
      if (localObject != null) {
        paramView = (QIMFilterCategoryItem)localObject;
      }
      if (paramView == null) {
        return;
      }
      if (paramView != null)
      {
        if (paramInt != 0) {
          break label253;
        }
        AEBaseReportParam.a().k("none");
        label46:
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("report filter click(").append(paramInt).append(", ");
          if (paramInt != 0) {
            break label266;
          }
        }
      }
      label266:
      for (localObject = "none";; localObject = "" + paramView.a)
      {
        QLog.d("AEFilterProviderView", 2, (String)localObject + ")");
        if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
          this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(-1, paramView);
        }
        if (this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("apply_source", 1);
          ((Bundle)localObject).putInt("capture_scene", this.g);
          if ((AEFilterManagerHolder.getAEFilterManager() != null) && (!AEFilterManagerHolder.getAEFilterManager().a)) {
            ((Bundle)localObject).putBoolean("capture_force_enable", true);
          }
          this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.a(paramView, (Activity)getContext(), (Bundle)localObject);
        }
        if (!this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.a()) {
          a(paramView.a);
        }
        ((QIMPredownManager)QIMManager.a(14)).a(paramView.b, 1);
        if (this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager == null) {
          break;
        }
        this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.a(this.g, (Activity)this.jdField_a_of_type_AndroidContentContext);
        return;
        label253:
        AEBaseReportParam.a().k(paramView.a);
        break label46;
      }
    }
  }
  
  public void a(ComboSet paramComboSet) {}
  
  public void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "fp onComboApply combo " + paramComboSet.a + " filter ");
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
  }
  
  public void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
    if (paramBoolean)
    {
      paramFilterSet = (QimMusicPlayer)QIMManager.a().c(8);
      if (this.g != 0) {
        break label44;
      }
    }
    label44:
    for (paramInt = QQFilterRenderManagerHolder.b;; paramInt = QQFilterRenderManagerHolder.c)
    {
      paramFilterSet.c(paramInt);
      paramFilterSet.d();
      return;
    }
  }
  
  public void a(TemplateSet paramTemplateSet, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onComboFilterDataUpdated data:");
      if (paramComboFilterData != null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AEFilterProviderView", 2, bool);
      if (paramComboFilterData != null) {
        a(paramComboFilterData.a(this.g));
      }
      return;
    }
  }
  
  public void a(VideoFilterTools.DataSet paramDataSet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "filters setup()");
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = paramDataSet;
    this.jdField_a_of_type_JavaUtilArrayList = paramDataSet.jdField_b_of_type_JavaUtilArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > this.b)) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter.a(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.b)).a);
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
  }
  
  public void b()
  {
    super.b();
    Object localObject;
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet == null) && (this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager != null))
    {
      localObject = this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
      if (localObject != null) {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = ((VideoFilterTools.ComboFilterData)localObject).a(this.g);
      }
    }
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null))
    {
      localObject = (Activity)getContext();
      this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a((Activity)localObject, this.g);
      VideoFilterTools.a().b(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, (Activity)getContext(), this.g);
      VideoFilterTools.a().a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, this.g);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
      a(null, 0);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b();
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEFilterProviderAdapter.notifyDataSetChanged();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.b(false);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager != null) {
      this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.a(this);
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager != null) {
      this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView
 * JD-Core Version:    0.7.0.1
 */