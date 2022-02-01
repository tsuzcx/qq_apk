package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.data.AEMaterialCategory;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.capture.QIMManager;
import java.util.List;

public class AEWaterMarkProviderView
  extends FrameLayout
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = CaptureContext.a();
  private AEWaterMarkAdapter jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkAdapter;
  private AEWaterMarkPanel.AEWaterMarkPanelListener jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEMaterialManager jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
  private View b;
  
  public AEWaterMarkProviderView(@NonNull Context paramContext, AEWaterMarkPanel.AEWaterMarkPanelListener paramAEWaterMarkPanelListener)
  {
    super(paramContext);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener = paramAEWaterMarkPanelListener;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    AEQLog.a("AEWaterMarkProviderView", "watermark initView");
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558500, this);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131381809);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366989));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkAdapter = new AEWaterMarkAdapter(paramContext, this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel$AEWaterMarkPanelListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkAdapter);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager = ((AEMaterialManager)QIMManager.a(18));
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.b(false);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkAdapter.a();
    }
  }
  
  public void a(List<AEMaterialCategory> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkAdapter.a(((AEMaterialCategory)paramList.get(0)).a);
    }
  }
  
  public void setCaptureRadio(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    AEQLog.a("AEWaterMarkProviderView", "pannel setCaptureRadio" + paramRatio);
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = paramRatio;
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkAdapter.a(paramRatio);
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
      this.b.setBackgroundColor(getResources().getColor(2131165361));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkProviderView
 * JD-Core Version:    0.7.0.1
 */