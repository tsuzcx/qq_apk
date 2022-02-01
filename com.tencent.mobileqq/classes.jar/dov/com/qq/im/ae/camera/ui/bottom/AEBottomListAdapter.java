package dov.com.qq.im.ae.camera.ui.bottom;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.camera.ui.AECaptureController;
import dov.com.qq.im.ae.camera.ui.aiscene.TTAutoAISceneAni;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.data.AEPreDownloadResMetaData;
import dov.com.qq.im.ae.download.AEMaterialDownloader.MaterialDownloadListener;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.capture.QIMManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class AEBottomListAdapter
  extends RecyclerView.Adapter<AEBottomListAdapter.ViewHolder>
{
  public static int a;
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static List<String> jdField_b_of_type_JavaUtilList;
  public static int c;
  private static int d;
  private static int e;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new AEBottomListAdapter.1(this);
  public AEPituCameraUnit a;
  private AECaptureController jdField_a_of_type_DovComQqImAeCameraUiAECaptureController;
  private AEBottomListAdapter.AEBottomListListener jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter$AEBottomListListener;
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private AEMaterialManager jdField_a_of_type_DovComQqImAeDataAEMaterialManager;
  private AEMaterialMetaData jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
  private AEMaterialDownloader.MaterialDownloadListener jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener = new AEBottomListAdapter.4(this);
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel;
  private List<AEMaterialMetaData> jdField_a_of_type_JavaUtilList;
  private Map<String, AEBottomListAdapter.ViewHolder> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
    c = 2130837646;
    jdField_b_of_type_JavaUtilList = new ArrayList();
    d = 54;
    e = 54;
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/yellow2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/green2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/purple2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/blue2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/android/video_story_ptv_pendant_enter.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none1.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png");
  }
  
  public AEBottomListAdapter(AEPituCameraUnit paramAEPituCameraUnit, AEBottomListScrollView paramAEBottomListScrollView, AECaptureController paramAECaptureController)
  {
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = paramAEPituCameraUnit;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController = paramAECaptureController;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager = ((AEMaterialManager)QIMManager.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    if (AECameraEntry.a(paramAEPituCameraUnit))
    {
      d = 69;
      e = 53;
    }
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private void a(AEPreDownloadResMetaData paramAEPreDownloadResMetaData)
  {
    if ((paramAEPreDownloadResMetaData != null) && (!paramAEPreDownloadResMetaData.d())) {
      this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.getApp(), paramAEPreDownloadResMetaData.s, paramAEPreDownloadResMetaData, this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener);
    }
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.3(this, paramAEMaterialMetaData));
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.a != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.a.a())) {
      this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.a.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.b, this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString);
    }
  }
  
  public AEBottomListAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = AECameraEntry.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit);
    if (bool) {}
    for (paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558489, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563202, paramViewGroup, false)) {
      return new AEBottomListAdapter.ViewHolder(paramViewGroup, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, bool);
    }
  }
  
  public AEMaterialMetaData a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (AEMaterialMetaData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData);
    AEMaterialMetaData localAEMaterialMetaData = new AEMaterialMetaData();
    localAEMaterialMetaData.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localAEMaterialMetaData);
      i += 1;
    }
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(AEBottomListAdapter.AEBottomListListener paramAEBottomListListener)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter$AEBottomListListener = paramAEBottomListListener;
  }
  
  public void a(AEBottomListAdapter.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if ((paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null) && (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString, paramViewHolder);
    }
  }
  
  public void a(AEBottomListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.a((AEMaterialMetaData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if ((paramAEMaterialMetaData != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, paramAEMaterialMetaData);
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, paramAEMaterialMetaData);
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<AEMaterialMetaData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new AEMaterialMetaData();
      paramList.jdField_a_of_type_JavaLangString = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    a(TTAutoAISceneAni.c());
    a(TTAutoAISceneAni.b());
    a(TTAutoAISceneAni.a());
  }
  
  public void b(AEBottomListAdapter.ViewHolder paramViewHolder)
  {
    super.onViewDetachedFromWindow(paramViewHolder);
    if ((paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null) && (!TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramViewHolder.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (!AEResUtil.a())
    {
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131716232), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    label206:
    do
    {
      int i;
      do
      {
        return;
        if (paramAEMaterialMetaData != null) {}
        for (;;)
        {
          this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData = paramAEMaterialMetaData;
          if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData != null) {
            this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString);
          }
          if ((this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString))) {
            break;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.a()) && (!this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.equals(AEMaterialMetaData.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData))) {
            break label206;
          }
          this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData, false);
          QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
          if (this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController != null) {
            this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.a(null);
          }
          this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().getIntent().removeExtra("widgetinfo");
          return;
          i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a();
          if (i >= getItemCount()) {
            break;
          }
          paramAEMaterialMetaData = a(i);
        }
        if (!this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
          break;
        }
      } while (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter$AEBottomListListener == null);
      this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListAdapter$AEBottomListListener.a();
      return;
      if (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.e)
      {
        c(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData);
        i = AEBeautyProviderView.a();
        this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.a(i);
        i = AEBeautyProviderView.b();
        this.jdField_a_of_type_DovComQqImAeCameraUiAECaptureController.b(i);
        return;
      }
    } while ((this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.f) || (this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.e) || (TextUtils.isEmpty(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager == null));
    if (!NetworkUtil.g(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
    {
      ToastUtil.a().a(HardCodeUtil.a(2131716227));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "start download template runnable");
    }
    this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialManager.getApp(), this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData, this.jdField_a_of_type_DovComQqImAeDownloadAEMaterialDownloader$MaterialDownloadListener);
  }
  
  public void c()
  {
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter
 * JD-Core Version:    0.7.0.1
 */