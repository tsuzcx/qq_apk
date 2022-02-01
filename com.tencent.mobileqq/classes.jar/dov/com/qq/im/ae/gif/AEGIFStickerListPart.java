package dov.com.qq.im.ae.gif;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.config.CameraOperationHelper;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import dov.com.qq.im.ae.data.AEGifMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.font.AEFontManager;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFStickerAdapter;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.AEVideoStoryStateViewModel;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.LinkedList;
import java.util.List;

public class AEGIFStickerListPart
  extends VideoStoryBasePart
  implements SimpleSlidingIndicator.OnTabListener
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Pair<String[], int[]> jdField_a_of_type_AndroidUtilPair;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit;
  private AEVideoStoryGIFTplViewModel jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel;
  private AEGIFStickerAdapter jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel;
  private String jdField_a_of_type_JavaLangString;
  private List<AEGifCategoryWrapper> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private List<AEMaterialWrapper> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private String c;
  
  public AEGIFStickerListPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  @Nullable
  private Pair<Integer, Integer> a(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (paramList.size() == 0) {
      return null;
    }
    Object localObject = (AEGifCategoryWrapper)paramList.get(0);
    if (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject).materialWrapperList)) {
      return null;
    }
    if ((((AEGifCategoryWrapper)localObject).materialWrapperList.get(0) != null) && (((AEMaterialWrapper)((AEGifCategoryWrapper)localObject).materialWrapperList.get(0)).b != 1))
    {
      AEMaterialWrapper localAEMaterialWrapper = new AEMaterialWrapper();
      localAEMaterialWrapper.b = 1;
      localAEMaterialWrapper.jdField_a_of_type_JavaLangString = "none";
      ((AEGifCategoryWrapper)localObject).materialWrapperList.add(0, localAEMaterialWrapper);
    }
    localObject = b(paramList);
    if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null)) {}
    for (((AEGifCategoryWrapper)paramList.get(((Integer)((Pair)localObject).first).intValue())).selected = true;; ((AEGifCategoryWrapper)paramList.get(0)).selected = true) {
      return localObject;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEGIFStickerListPart.2(this));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.c.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEGIFStickerListPart.3(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEGIFStickerListPart.4(this));
    this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel = ((AEVideoStoryGIFTplViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryGIFTplViewModel.class));
    this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEGIFStickerListPart.5(this));
    CameraOperationHelper.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEGIFStickerListPart.6(this));
    CameraOperationHelper.c().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEGIFStickerListPart.7(this));
    if (!this.jdField_a_of_type_Boolean) {
      AEGifMaterialManager.a().a();
    }
  }
  
  private void a(@NonNull Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("KEY_CURRENT_SELECT_ID");
    paramIntent = paramIntent.getStringExtra("KEY_CURRENT_TAB");
    AEQLog.a("AEGIFStickerListPart", "[initTakeSame], bottomTab=" + paramIntent + ", materialId=" + str);
    this.jdField_a_of_type_Boolean = a(paramIntent, str);
    if (this.jdField_a_of_type_Boolean)
    {
      this.c = str;
      c();
    }
  }
  
  private void a(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel.c(paramAEMaterialWrapper);
    if (paramAEMaterialWrapper == null)
    {
      this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel.b(null);
      this.c = null;
      return;
    }
    this.c = paramAEMaterialWrapper.jdField_a_of_type_JavaLangString;
    switch (paramAEMaterialWrapper.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel.a(paramAEMaterialWrapper);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel.b(paramAEMaterialWrapper);
  }
  
  private void a(@Nullable String paramString)
  {
    if (this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel != null) {
      this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel.d().postValue(paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (AEFontManager.a().a(paramString) != Typeface.DEFAULT)) {
      return;
    }
    ThreadManager.excute(new AEGIFStickerListPart.9(this, paramString), 64, null, false);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel == null) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.e().getValue();
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  private boolean a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (AECaptureMode.GIF.name.equals(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
  
  @Nullable
  private Pair<Integer, Integer> b(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (TextUtils.isEmpty(this.c))
    {
      AEQLog.b("AEGIFStickerListPart", "[findLastSelectedPosition] mPendingApplyGIFId is empty");
      return null;
    }
    int i;
    Object localObject1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      i = 0;
      if (i < paramList.size())
      {
        localObject1 = (AEGifCategoryWrapper)paramList.get(i);
        if ((localObject1 == null) || (TextUtils.isEmpty(((AEGifCategoryWrapper)localObject1).categoryId))) {}
        while (!((AEGifCategoryWrapper)localObject1).categoryId.equals(this.jdField_a_of_type_JavaLangString))
        {
          i += 1;
          break;
        }
      }
    }
    for (;;)
    {
      int j;
      Object localObject2;
      if ((localObject1 != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)))
      {
        j = 0;
        if (j < ((AEGifCategoryWrapper)localObject1).materialWrapperList.size())
        {
          localObject2 = (AEMaterialWrapper)((AEGifCategoryWrapper)localObject1).materialWrapperList.get(j);
          if ((localObject2 == null) || (TextUtils.isEmpty(((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString))) {}
          while (!((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString.equals(this.c))
          {
            j += 1;
            break;
          }
        }
      }
      for (localObject1 = localObject2;; localObject1 = null)
      {
        int k;
        int m;
        int i2;
        Object localObject3;
        int i1;
        if (localObject1 == null)
        {
          int n = 0;
          AEGifCategoryWrapper localAEGifCategoryWrapper;
          for (;;)
          {
            k = j;
            localObject2 = localObject1;
            m = i;
            if (n >= paramList.size()) {
              break label385;
            }
            localAEGifCategoryWrapper = (AEGifCategoryWrapper)paramList.get(n);
            i2 = j;
            localObject3 = localObject1;
            i1 = i;
            if (localAEGifCategoryWrapper == null) {
              break label455;
            }
            if (!CollectionUtils.isEmpty(localAEGifCategoryWrapper.materialWrapperList)) {
              break;
            }
            k = j;
            j = i;
            i = k;
            n += 1;
            k = j;
            j = i;
            i = k;
          }
          i1 = 0;
          k = j;
          localObject2 = localObject1;
          m = i;
          if (i1 < localAEGifCategoryWrapper.materialWrapperList.size())
          {
            localObject2 = (AEMaterialWrapper)localAEGifCategoryWrapper.materialWrapperList.get(i1);
            if ((localObject2 == null) || (TextUtils.isEmpty(((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString))) {}
            while (!((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString.equals(this.c))
            {
              i1 += 1;
              break;
            }
            k = i1;
            m = n;
          }
          i2 = k;
          localObject3 = localObject2;
          i1 = m;
          if (localObject2 == null) {}
        }
        for (;;)
        {
          label385:
          if (localObject2 != null)
          {
            AEQLog.b("AEGIFStickerListPart", "[findLastSelectedPosition] found tabPosition=" + m + ", itemPosition=" + k);
            return new Pair(Integer.valueOf(m), Integer.valueOf(k));
          }
          AEQLog.b("AEGIFStickerListPart", "[findLastSelectedPosition] not found");
          return null;
          label455:
          i = i2;
          localObject1 = localObject3;
          j = i1;
          break;
          k = j;
          localObject2 = localObject1;
          m = i;
        }
        j = -1;
      }
      i = -1;
      localObject1 = null;
    }
  }
  
  private void b()
  {
    ViewAnimator.a(new View[] { this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new AEGIFStickerListPart.8(this)).b();
  }
  
  private Pair<String[], int[]> c(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return new Pair(new String[0], new int[0]);
    }
    String[] arrayOfString = new String[paramList.size()];
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (AEGifCategoryWrapper)paramList.get(i);
      if ((localObject == null) || (TextUtils.isEmpty(((AEGifCategoryWrapper)localObject).categoryName))) {
        break label114;
      }
    }
    label114:
    for (Object localObject = ((AEGifCategoryWrapper)localObject).categoryName;; localObject = "")
    {
      arrayOfString[i] = localObject;
      arrayOfInt[i] = i;
      i += 1;
      break;
      return new Pair(arrayOfString, arrayOfInt);
    }
  }
  
  private void c()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.mActivity, 2131755842);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559683);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373066)).setText(2131694890);
        this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new AEGIFStickerListPart.10(this));
      }
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        AEQLog.a("AEGIFStickerListPart", "[showTakeSameLoading], show dialog");
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
    }
  }
  
  private void d()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      AEQLog.a("AEGIFStickerListPart", "[hideTakeSameLoading], dismiss dialog");
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (AEGifCategoryWrapper)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(((AEGifCategoryWrapper)localObject1).categoryId)))
    {
      this.jdField_b_of_type_JavaLangString = ((AEGifCategoryWrapper)localObject1).categoryId;
      AEBaseReportParam.a().o(this.jdField_b_of_type_JavaLangString);
      AEBaseDataReporter.a().ah();
    }
    if (!paramBoolean) {
      return 0;
    }
    this.jdField_a_of_type_JavaLangString = ((AEGifCategoryWrapper)localObject1).categoryId;
    a(((AEGifCategoryWrapper)localObject1).fontId);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(((AEGifCategoryWrapper)localObject1).materialWrapperList);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter.a();
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.scrollToPositionWithOffset(0, 0);
    if (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)) {}
    for (localObject1 = null;; localObject1 = (AEMaterialWrapper)((AEGifCategoryWrapper)localObject1).materialWrapperList.get(0))
    {
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((AEMaterialWrapper)localObject1).b == 1) {
          localObject2 = null;
        }
      }
      a(localObject2);
      return 0;
    }
  }
  
  public void initView()
  {
    if (this.mRootView == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_AndroidUtilPair = new Pair(new String[0], new int[0]);
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.mRootView.findViewById(2131362300));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mRootView.findViewById(2131362301));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter = new AEGIFStickerAdapter(this.mRootView.getContext(), this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter.a(new AEGIFStickerListPart.1(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeGifGiftextAdapterAEGIFStickerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    a(this.mActivity.getIntent());
    a();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if ((this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel != null) && (this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a())) {
      AEBaseDataReporter.a().ae();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGIFStickerListPart
 * JD-Core Version:    0.7.0.1
 */