package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import bnge;
import bngl;
import bnka;
import bnkb;
import bnrh;
import bofz;
import bogd;
import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import java.util.List;

public class AEWaterMarkProviderView
  extends FrameLayout
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private bnge jdField_a_of_type_Bnge;
  private bngl jdField_a_of_type_Bngl;
  private bnkb jdField_a_of_type_Bnkb;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = bofz.a();
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private View b;
  
  public AEWaterMarkProviderView(@NonNull Context paramContext, bngl parambngl)
  {
    super(paramContext);
    this.jdField_a_of_type_Bngl = parambngl;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    bnrh.a("AEWaterMarkProviderView", "watermark initView");
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558494, this);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131381348);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366806));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_Bnge = new bnge(paramContext, this.jdField_a_of_type_Bngl);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bnge);
    this.jdField_a_of_type_Bnkb = ((bnkb)bogd.a(18));
    this.jdField_a_of_type_Bnkb.b(false);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bnge != null) {
      this.jdField_a_of_type_Bnge.a();
    }
  }
  
  public void a(List<bnka> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_Bnge.a(((bnka)paramList.get(0)).a);
    }
  }
  
  public void setCaptureRadio(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    bnrh.a("AEWaterMarkProviderView", "pannel setCaptureRadio" + paramRatio);
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = paramRatio;
    if (this.jdField_a_of_type_Bnge != null) {
      this.jdField_a_of_type_Bnge.a(paramRatio);
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL) {
      this.b.setBackgroundColor(getResources().getColor(2131165361));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkProviderView
 * JD-Core Version:    0.7.0.1
 */