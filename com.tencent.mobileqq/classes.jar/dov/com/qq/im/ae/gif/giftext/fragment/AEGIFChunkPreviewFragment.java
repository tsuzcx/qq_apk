package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import dov.com.qq.im.ae.data.AEGifMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.gif.RecognizedEmotionBean;
import dov.com.qq.im.ae.gif.giftext.AEGIFPreviewWrapper;
import dov.com.qq.im.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.OnTextClickListener;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel;
import dov.com.qq.im.ae.gif.video.MaterialWrapper;
import dov.com.qq.im.ae.gif.video.PngCreateResult.PngResultItem;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.lifecycle.GlobalViewModelFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.light.device.LightDeviceUtils;

public class AEGIFChunkPreviewFragment
  extends ReportFragment
  implements AEGIFChunkPreviewAdapter.OnTextClickListener
{
  public static double a;
  public static List<PTFaceAttr> a;
  private long jdField_a_of_type_Long = 9223372036854775807L;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private AEGIFChunkPreviewAdapter jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter;
  private AEGIFMaterialViewModel jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFMaterialViewModel;
  private AEGIFRecommandTextViewModel jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFRecommandTextViewModel;
  private AEGIFTextEditViewModel jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel;
  private PngCreateResult.PngResultItem jdField_a_of_type_DovComQqImAeGifVideoPngCreateResult$PngResultItem;
  private PngsCreateWorkingQueue jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private List<AEGIFPreviewWrapper> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_Double = 1.0D;
  }
  
  public static AEGIFChunkPreviewFragment a(String paramString1, long paramLong, String paramString2)
  {
    AEGIFChunkPreviewFragment localAEGIFChunkPreviewFragment = new AEGIFChunkPreviewFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString1);
    localBundle.putLong("KEY_AVAILABLE_EMO_COUNT", paramLong);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("KEY_FONT_ID", paramString2);
    }
    localAEGIFChunkPreviewFragment.setArguments(localBundle);
    return localAEGIFChunkPreviewFragment;
  }
  
  @Nullable
  private String a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_JavaUtilList.size())) {
      return null;
    }
    if ((this.jdField_b_of_type_JavaUtilList.get(paramInt) == null) || (((AEGIFPreviewWrapper)this.jdField_b_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial == null)) {
      return null;
    }
    return ((AEGIFPreviewWrapper)this.jdField_b_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id;
  }
  
  private void a(@NonNull RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    AEQLog.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion] - BEGIN -");
    Object localObject1 = AEGifMaterialManager.a().a(3).iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (AEGifCategoryWrapper)((Iterator)localObject1).next();
    } while ((localObject2 == null) || (TextUtils.isEmpty(((AEGifCategoryWrapper)localObject2).categoryName)) || (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject2).materialWrapperList)) || (!((AEGifCategoryWrapper)localObject2).categoryName.equals(paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString)));
    for (localObject1 = ((AEGifCategoryWrapper)localObject2).materialWrapperList;; localObject1 = null)
    {
      int j;
      int i;
      if (localObject1 == null)
      {
        AEQLog.d("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], matchedMaterialList == null");
        if ((localObject1 != null) && (this.jdField_b_of_type_JavaUtilList != null))
        {
          AEQLog.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], matchedMaterialList.size() = " + ((List)localObject1).size());
          j = Math.min(((List)localObject1).size(), paramRecognizedEmotionBean.b);
          Collections.shuffle((List)localObject1);
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          paramRecognizedEmotionBean = (AEMaterialWrapper)((List)localObject1).get(i);
          localObject2 = new AEGIFPreviewWrapper();
          ((AEGIFPreviewWrapper)localObject2).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = paramRecognizedEmotionBean.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial;
          AEQLog.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], sssigning material to item index = " + i + "material id = " + paramRecognizedEmotionBean.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
          ((AEGIFPreviewWrapper)localObject2).b = 0;
          ((AEGIFPreviewWrapper)localObject2).jdField_a_of_type_Int = 10;
          ((AEGIFPreviewWrapper)localObject2).jdField_a_of_type_JavaLangString = "";
          AEBaseDataReporter.a().m(paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString);
          if (this.jdField_b_of_type_JavaUtilList.size() < this.jdField_a_of_type_Long) {}
        }
        else
        {
          AEQLog.a("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion] - BEGIN -");
          return;
          if (!((List)localObject1).isEmpty()) {
            break;
          }
          AEQLog.d("AEGIFChunkPreviewFragment", "[prepareMaterialByEmotion], aeMaterialWrappers is empty");
          break;
        }
        this.jdField_b_of_type_JavaUtilList.add(localObject2);
        this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter.notifyItemInserted(this.jdField_b_of_type_JavaUtilList.size() - 1);
        this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFMaterialViewModel.a(CaptureContext.a(), (AEGIFPreviewWrapper)localObject2);
        i += 1;
      }
    }
  }
  
  private void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_camera_emo_snapshots", paramArrayList3);
    localBundle.putStringArrayList("qipc_param_emo_widget_infos", paramArrayList4);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new AEGIFChunkPreviewFragment.7(this));
    getActivity().setResult(201);
    getActivity().finish();
    paramArrayList1 = getActivity().getApplicationContext();
    ThreadManager.getUIHandler().post(new AEGIFChunkPreviewFragment.8(this, paramArrayList1));
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377306);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(LightDeviceUtils.getScreenHeight(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367922).setOnClickListener(new AEGIFChunkPreviewFragment.2(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380641));
    int i = (int)(LightDeviceUtils.getScreenWidth(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.04F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F), 0, DisplayUtil.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377437));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new AEGIFChunkPreviewFragment.3(this));
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377429));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 2));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new AEGIFChunkPreviewFragment.4(this));
    d();
  }
  
  private void d()
  {
    Object localObject = new AEGIFPreviewWrapper();
    ((AEGIFPreviewWrapper)localObject).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
    ((AEGIFPreviewWrapper)localObject).jdField_a_of_type_JavaLangString = null;
    ((AEGIFPreviewWrapper)localObject).b = 2;
    this.jdField_b_of_type_JavaUtilList.add(0, new AEGIFPreviewWrapper());
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter = new AEGIFChunkPreviewAdapter(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter.a(this);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter);
    localObject = new MaterialWrapper();
    ((MaterialWrapper)localObject).jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue.a((MaterialWrapper)localObject);
  }
  
  private void e()
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel = ((AEGIFTextEditViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).get(AEGIFTextEditViewModel.class));
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFChunkPreviewAdapter.a(this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel, this.jdField_a_of_type_DovComQqImBaseVMPeakActivity);
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.b().postValue("");
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.a().postValue(new AEGIFTextColorConfig.SmartTextColor("#ccffffff", "#000000"));
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.c().observe(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new AEGIFChunkPreviewFragment.5(this));
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFTextEditViewModel.a();
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFMaterialViewModel = ((AEGIFMaterialViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).get(AEGIFMaterialViewModel.class));
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFRecommandTextViewModel = ((AEGIFRecommandTextViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, GlobalViewModelFactory.a()).get(AEGIFRecommandTextViewModel.class));
    this.jdField_a_of_type_DovComQqImAeGifGiftextViewmodelAEGIFRecommandTextViewModel.a().observe(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new AEGIFChunkPreviewFragment.6(this));
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(0);
    localObject = AEGIFTextEditFragment.a(this.jdField_b_of_type_JavaLangString, true, (View)localObject, this.jdField_a_of_type_JavaLangString);
    getFragmentManager().beginTransaction().add(2131367438, (Fragment)localObject).addToBackStack(null).commit();
  }
  
  protected int a()
  {
    return 2131558611;
  }
  
  public void a()
  {
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComQqImBaseVMPeakActivity = ((BaseVMPeakActivity)getActivity());
    paramBundle = getArguments().getString("KEY_PREVIEW_SOURCE_PATH");
    this.jdField_a_of_type_Long = getArguments().getLong("KEY_AVAILABLE_EMO_COUNT");
    QLog.d("AEGIFChunkPreviewFragment", 4, "availableEmoCount = " + this.jdField_a_of_type_Long);
    if (getArguments().containsKey("KEY_FONT_ID")) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("KEY_FONT_ID");
    }
    this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue = new PngsCreateWorkingQueue(paramBundle, jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaLangString, getActivity());
    this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue.a(new AEGIFChunkPreviewFragment.1(this));
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put("happy", HardCodeUtil.a(2131700046));
    this.jdField_a_of_type_JavaUtilHashMap.put("neutral", HardCodeUtil.a(2131700047));
    this.jdField_a_of_type_JavaUtilHashMap.put("sad", HardCodeUtil.a(2131700052));
    this.jdField_a_of_type_JavaUtilHashMap.put("anger", HardCodeUtil.a(2131700050));
    this.jdField_a_of_type_JavaUtilHashMap.put("disgust", HardCodeUtil.a(2131700048));
    this.jdField_a_of_type_JavaUtilHashMap.put("fear", HardCodeUtil.a(2131700055));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    b();
    e();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    PngsCreateWorkingQueue localPngsCreateWorkingQueue;
    if (this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue != null)
    {
      localPngsCreateWorkingQueue = this.jdField_a_of_type_DovComQqImAeGifVideoPngsCreateWorkingQueue;
      if (this.jdField_a_of_type_Boolean) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localPngsCreateWorkingQueue.a(bool);
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AEBaseDataReporter.a().aj();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    AEBaseReportParam.a().j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment
 * JD-Core Version:    0.7.0.1
 */