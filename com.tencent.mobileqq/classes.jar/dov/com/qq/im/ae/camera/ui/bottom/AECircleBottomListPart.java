package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.capture.QIMManager;
import java.util.HashMap;

public class AECircleBottomListPart
  extends AEBottomListPart
  implements AEBottomListScrollView.AEEditMaterialSelectedListener
{
  private View jdField_a_of_type_AndroidViewView;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  
  public AECircleBottomListPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
  }
  
  private boolean a(AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramViewHolder != null)
    {
      bool1 = bool2;
      if (paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null)
      {
        bool1 = bool2;
        if (paramInt == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean)) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = ((AEBottomListScrollView)this.mRootView.findViewById(2131377419));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFling(true);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransitionTimeMillis(100);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setSlideOnFlingThreshold(1000);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOffscreenItems(10);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setOnItemChangedListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setScrollStateChangeListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAEEditMaterialSelectedListener(this);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setItemTransformer(new AECircleScaleTransformer.Builder().a(1.0F).b(1.3839F).a());
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter = new AEBottomListAdapter(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.a(new AECircleBottomListPart.1(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setAdapter(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter);
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131369471);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager = ((AEMaterialManager)QIMManager.a().c(18));
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 113);
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this, 112);
    a();
    c();
  }
  
  public void a(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.mPartManager != null)
    {
      if (paramBoolean) {
        this.mPartManager.a(327696, new Object[0]);
      }
    }
    else {
      return;
    }
    this.mPartManager.a(327689, new Object[0]);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AECircleBottomListPart.2(this));
  }
  
  public void b(@NonNull AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    super.b(paramViewHolder, paramInt);
    if (a(paramViewHolder, paramInt))
    {
      this.jdField_a_of_type_Boolean = false;
      b(false);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  protected void c(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      b(true);
      super.c(paramInt);
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
  }
  
  public void c(@Nullable AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null)
    {
      paramViewHolder.a(3);
      paramViewHolder = paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
      if ((paramViewHolder != null) && (!"call_material_id".equals(paramViewHolder.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_Int = paramInt;
        if (a())
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("ext2", paramViewHolder.jdField_a_of_type_JavaLangString);
          AEReportUtils.b(2, localHashMap);
        }
      }
      if ((paramViewHolder != null) && (!"0".equals(paramViewHolder.jdField_a_of_type_JavaLangString)) && (paramViewHolder.jdField_a_of_type_Boolean)) {
        a(true);
      }
      WatermarkDataManager.a().a(paramViewHolder);
      if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter != null)
      {
        if (!a(paramViewHolder)) {
          break label126;
        }
        WeishiGuideUtils.a(this.mActivity, paramViewHolder);
      }
    }
    return;
    label126:
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter.b(paramViewHolder);
  }
  
  protected void d()
  {
    h();
  }
  
  protected void e()
  {
    b(327683);
  }
  
  protected void f()
  {
    b(327697);
  }
  
  protected void g()
  {
    b(327684);
  }
  
  public void initView()
  {
    if (this.mRootView != null) {
      j();
    }
    b();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    super.send(paramInt, paramVarArgs);
    if (paramInt == 786433) {
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(0);
    }
    do
    {
      do
      {
        return;
        if (paramInt == 786434)
        {
          b(false);
          return;
        }
        if (paramInt == 786435)
        {
          b(true);
          return;
        }
        if (paramInt != 131075) {
          break;
        }
        paramVarArgs = AEMaterialManager.a();
      } while ((paramVarArgs != null) && (!paramVarArgs.equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData)));
      b(false);
      return;
    } while (paramInt != 786436);
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.smoothScrollToPosition(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AECircleBottomListPart
 * JD-Core Version:    0.7.0.1
 */