package dov.com.qq.im.aeeditor.module.edit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.microrapid.opencv.ImageMainColorData;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.ImageExportConfig;
import com.tencent.tavcut.exporter.ImageExporter;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.play.FaceChangeUtils;
import dov.com.qq.im.ae.protobuf.AEPbData.FaceInfo;
import dov.com.qq.im.ae.protobuf.AEPbData.ImageInfo;
import dov.com.qq.im.ae.protobuf.AEPbData.ImageStylizeRequest;
import dov.com.qq.im.ae.protobuf.AEPbData.ImageStylizeResponse;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.report.AEEditReportData;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.CACHE;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.FILES;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroup;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIFilterManager.AIFilterObserver;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterDataCache;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterProxyBase;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterProxy;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.ComicsFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.SilentBatchImageAIFilterProxy;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterProxy;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterResult;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorCropperPanel;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.FilterControlListener;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.ImageFilterControlListener;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import dov.com.qq.im.aeeditor.module.filter.AEFilterExtendBean;
import dov.com.qq.im.aeeditor.module.filter.FilterChangedComparator;
import dov.com.qq.im.aeeditor.module.filter.ImageFilterInfoCache;
import dov.com.qq.im.aeeditor.module.frame.AEFrameColorListAdapter;
import dov.com.qq.im.aeeditor.module.params.ImageParamStrategy;
import dov.com.qq.im.aeeditor.module.params.ParamFactory;
import dov.com.qq.im.aeeditor.module.params.ParamsUtil;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextPart.AEEditorTextDialogListener;
import dov.com.qq.im.aeeditor.module.toolbar.ImageEditToolBar.ImageToolBarListener;
import dov.com.qq.im.aeeditor.util.AEExtractColorUtil;
import dov.com.qq.im.aeeditor.util.AELocalMediaInfoUtil;
import dov.com.qq.im.aeeditor.view.NumberIndicator;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class AEEditorImageEditFragment
  extends AEEditorCommonEditFragment
  implements Handler.Callback, ViewPager.OnPageChangeListener, AEEditorFilterControlPanel.ImageFilterControlListener, ImageEditToolBar.ImageToolBarListener
{
  private long jdField_a_of_type_Long;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  private ImageExporter jdField_a_of_type_ComTencentTavcutExporterImageExporter;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  AEEditorAIFilterManager.AIFilterObserver jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver = new AEEditorImageEditFragment.18(this);
  private AIFilterDataCache jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterDataCache = new AIFilterDataCache();
  private BatchImageAIFilterResult jdField_a_of_type_DovComQqImAeeditorModuleAifilterBatchImageAIFilterResult;
  private AEEditorCropperPanel jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel;
  private AEEditorImagePagerAdapter jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter;
  private AEEditorImageViewPager jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager;
  private ImageFilterInfoCache jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache = new ImageFilterInfoCache();
  private AEFrameColorListAdapter jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter;
  private ImageParamStrategy jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy = ParamFactory.a();
  private AEEditorTextBean jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean = null;
  private NumberIndicator jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, ComicsFilterResult> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private SparseArray<List<ImageMainColorData>> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  AEEditorAIFilterManager.AIFilterObserver jdField_b_of_type_DovComQqImAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver = new AEEditorImageEditFragment.19(this);
  private StringBuilder jdField_b_of_type_JavaLangStringBuilder;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  private List<AEEditorImageInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private SparseArray<List<ImageMainColorData>> jdField_c_of_type_AndroidUtilSparseArray = new SparseArray();
  private FrameLayout jdField_c_of_type_AndroidWidgetFrameLayout;
  private StringBuilder jdField_c_of_type_JavaLangStringBuilder;
  private boolean jdField_c_of_type_Boolean = false;
  private SparseArray<String> jdField_d_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = true;
  
  private void B()
  {
    AEQLog.b("AEEditorImageEditFragment", "showImages");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = new AEEditorImagePagerAdapter(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_d_of_type_AndroidUtilSparseArray, new AEEditorImageEditFragment.9(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setTotalCount(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.getCount());
    NumberIndicator localNumberIndicator = this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.getCount() > 0) {}
    for (int i = 1;; i = 0)
    {
      localNumberIndicator.setCurrentIndex(i);
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setImageInfo(0, Md5Utils.getMD5((String)this.jdField_a_of_type_JavaUtilList.get(0)));
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter);
      return;
    }
  }
  
  private void C()
  {
    if (!TextUtils.isEmpty(d()))
    {
      AEQLog.b("AEEditorImageEditFragment", "psKey not empty.");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    AEEditorImageEditFragment.10 local10 = new AEEditorImageEditFragment.10(this);
    localTicketManager.getPskey((String)localObject, 16L, new String[] { "shadowai.qq.com" }, local10);
  }
  
  private void D()
  {
    AEQLog.b("AEEditorImageEditFragment", "initTAVCutSession");
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = new TAVCutImageSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setMinIntermediateRenderSize(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.a());
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.b());
    localSessionConfig.setMaxImageDecodeSize(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.c());
    Object localObject = new StickerEditViewIconConfig();
    ((StickerEditViewIconConfig)localObject).setDeleteIconResId(2130837919);
    ((StickerEditViewIconConfig)localObject).setEditIconResId(2130837918);
    ((StickerEditViewIconConfig)localObject).setZoomIconResId(2130837920);
    localSessionConfig.setStickerEditViewIconConfig((StickerEditViewIconConfig)localObject);
    localObject = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      ((List)localObject).add(((AEEditorImageInfo)this.jdField_b_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    localSessionConfig.setImageInitCropConfigs((List)localObject);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setImagePaths(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setStickerOperationCallback(new AEEditorImageEditFragment.11(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.init(getActivity());
  }
  
  private void E()
  {
    if ((!this.e) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.g) && (this.f))
    {
      this.e = true;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void F()
  {
    AEEditorApplyAllLoadingView localAEEditorApplyAllLoadingView = new AEEditorApplyAllLoadingView(getActivity());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localAEEditorApplyAllLoadingView);
  }
  
  private void G()
  {
    int i = 0;
    boolean bool = AECameraPrefsUtil.a().a("ae_editor_tool_bar_red_dot_text", false, 0);
    if (!bool) {
      AECameraPrefsUtil.a().a("ae_editor_tool_bar_red_dot_text", true, 0);
    }
    AEEditReportData localAEEditReportData = AEBaseReportParam.a().a();
    if (bool) {}
    for (;;)
    {
      localAEEditReportData.i = i;
      AEBaseDataReporter.a().j();
      return;
      i = 1;
    }
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (e())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837735);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837736);
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.mediaChanged())
    {
      Object localObject = getActivity();
      localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2131689743)).setMessage(((Context)localObject).getString(2131689742)).setPositiveButton(((Context)localObject).getString(2131689715), new AEEditorImageEditFragment.26(this)).setNegativeButton(((Context)localObject).getString(2131689713), new AEEditorImageEditFragment.25(this));
      if (localObject != null) {}
      try
      {
        if (!((QQCustomDialog)localObject).isShowing()) {
          ((QQCustomDialog)localObject).show();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        J();
        return;
      }
    }
    J();
  }
  
  private void J()
  {
    Bundle localBundle = getArguments();
    a().c("AEEditorImageEdit", localBundle);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    float f1 = 1.0F;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 736;
    }
    paramInt = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = Math.max(paramInt, j);
    if (k > i) {
      f1 = 1.0F * i / k;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f1);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, j, localMatrix, true);
  }
  
  private Bitmap a(String paramString, CropConfig paramCropConfig)
  {
    k = 1;
    j = 0;
    try
    {
      localObject = BitmapUtil.getImageSize(paramString, false);
      Size localSize = Util.constrainMaxSize((Size)localObject, this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.c());
      m = ((Size)localObject).getWidth() / localSize.getWidth();
      if (((Size)localObject).getWidth() % localSize.getWidth() != 0) {
        break label358;
      }
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        Logger.e(paramString);
        return null;
        i = 270;
        continue;
        i = 180;
        continue;
        i = 90;
      }
    }
    catch (Error paramString)
    {
      for (;;)
      {
        int m;
        Logger.e(paramString);
        continue;
        continue;
        for (;;)
        {
          i += m;
          if (i > 0) {
            break label340;
          }
          i = k;
          break;
          i = 1;
        }
        int i = j;
      }
    }
    localObject = BitmapUtil.decodeBitmap(paramString, i);
    if (!a((Bitmap)localObject)) {
      return null;
    }
    i = j;
    switch (new ExifInterface(paramString).getAttributeInt("Orientation", 1))
    {
    case 4: 
    case 5: 
    case 7: 
      paramString = new Matrix();
      paramString.postRotate(i);
      paramString = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), paramString, true);
      localObject = Bitmap.createBitmap((int)(paramString.getWidth() * paramCropConfig.getWidth()), (int)(paramString.getHeight() * paramCropConfig.getHeight()), paramString.getConfig());
      new Canvas((Bitmap)localObject).drawBitmap(paramString, new Rect((int)(paramString.getWidth() * paramCropConfig.getX()), (int)(paramString.getHeight() * paramCropConfig.getY()), (int)(paramString.getWidth() * (paramCropConfig.getX() + paramCropConfig.getWidth())), (int)(paramString.getHeight() * (paramCropConfig.getY() + paramCropConfig.getHeight()))), new Rect(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()), new Paint());
      return localObject;
    }
  }
  
  private String a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    return paramInt + "_" + paramAEEditorFilterBean.getEffectId();
  }
  
  private String a(int paramInt, byte[] paramArrayOfByte, long paramLong, AEEditorFilterBean paramAEEditorFilterBean)
  {
    AEPbData.ImageStylizeResponse localImageStylizeResponse = new AEPbData.ImageStylizeResponse();
    try
    {
      localImageStylizeResponse.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        try
        {
          int i = localImageStylizeResponse.code.get();
          AEQLog.b("AEEditorImageEditFragment", "comics response: code=" + i + ", msg=" + localImageStylizeResponse.msg.get());
          AEBaseDataReporter.a().a(1000, paramLong + "", "lut_comics", i);
          if (!localImageStylizeResponse.imageRawData.has()) {
            break label222;
          }
          paramArrayOfByte = localImageStylizeResponse.imageRawData.get().toByteArray();
          paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramAEEditorFilterBean = AEEditorPath.EDITOR.CACHE.jdField_d_of_type_JavaLangString + File.separator + paramInt + "_" + paramAEEditorFilterBean.getEffectId() + ".jpg";
          com.tencent.qapmsdk.common.util.FileUtil.createFile(paramAEEditorFilterBean);
          BitmapUtil.saveBitmap(paramArrayOfByte, 100, paramAEEditorFilterBean);
          BitmapUtils.recycle(paramArrayOfByte);
          return paramAEEditorFilterBean;
        }
        catch (Exception paramArrayOfByte)
        {
          AEQLog.d("AEEditorImageEditFragment", paramArrayOfByte.toString());
        }
        paramArrayOfByte = paramArrayOfByte;
        paramArrayOfByte.printStackTrace();
      }
    }
    label222:
    return "";
  }
  
  @Nullable
  private ArrayList<String> a(@Nullable BatchImageAIFilterResult paramBatchImageAIFilterResult, int paramInt)
  {
    if ((paramBatchImageAIFilterResult == null) || (CollectionUtils.isEmpty(paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList)) || (paramInt < 0) || (paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.size() <= paramInt)) {}
    do
    {
      return null;
      paramBatchImageAIFilterResult = (SingleImageAIFilterResult)new LinkedList(paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList).get(paramInt);
    } while ((paramBatchImageAIFilterResult == null) || (CollectionUtils.isEmpty(paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList)));
    Object localObject = new LinkedList(paramBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList);
    if ((((List)localObject).size() > 0) && (((List)localObject).get(0) != null)) {}
    for (paramBatchImageAIFilterResult = ((YoutuResultItem)((List)localObject).get(0)).Label;; paramBatchImageAIFilterResult = null)
    {
      if ((((List)localObject).size() > 1) && (((List)localObject).get(1) != null)) {}
      for (localObject = ((YoutuResultItem)((List)localObject).get(1)).Label;; localObject = null)
      {
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(paramBatchImageAIFilterResult)) {
          localArrayList.add(paramBatchImageAIFilterResult);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
        if (CollectionUtils.isEmpty(localArrayList)) {
          break;
        }
        return localArrayList;
      }
    }
  }
  
  @Nullable
  private ArrayList<String> a(@Nullable HashMap<String, ArrayList<String>> paramHashMap, @NonNull String paramString)
  {
    if (paramHashMap == null) {
      return null;
    }
    return (ArrayList)paramHashMap.get(paramString);
  }
  
  private HashMap<String, LocalMediaInfo> a(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      LocalMediaInfo localLocalMediaInfo = AELocalMediaInfoUtil.a(str);
      Object localObject1 = ((MediaClipModel)((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(i)).getMediaResourceModel().getVideos().get(0)).getResource().getPath();
      Object localObject2 = BitmapUtil.getImageSize((String)localObject1);
      localLocalMediaInfo.mediaOriginHeight = ((Size)localObject2).getHeight();
      localLocalMediaInfo.mediaOriginWidth = ((Size)localObject2).getWidth();
      localLocalMediaInfo.mediaOriginSize = com.tencent.mobileqq.filemanager.util.FileUtil.a((String)localObject1);
      AEBaseDataReporter.a().b(localLocalMediaInfo);
      localLocalMediaInfo = AELocalMediaInfoUtil.a(localLocalMediaInfo, getArguments().getString("material_id"), getArguments().getString("material_topic"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.b(i));
      localObject1 = a(this.jdField_a_of_type_JavaUtilHashMap, str);
      int j = paramArrayList.indexOf(str);
      localObject2 = a(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterBatchImageAIFilterResult, j);
      if ((localObject1 != null) && (!CollectionUtils.isEmpty((Collection)localObject1))) {}
      for (localLocalMediaInfo.aiTextLabel = ((ArrayList)localObject1);; localLocalMediaInfo.aiTextLabel = ((ArrayList)localObject2)) {
        do
        {
          a(localLocalMediaInfo, ((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(i)).getMediaEffectModel().getStickerModelList());
          if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
            a(localLocalMediaInfo, ((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(i)).getMediaEffectModel().getStickerModelList(), this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a());
          }
          localHashMap.put(str, localLocalMediaInfo);
          i += 1;
          break;
        } while ((localObject2 == null) || (CollectionUtils.isEmpty((Collection)localObject2)));
      }
    }
    return localHashMap;
  }
  
  private void a(int paramInt1, ComicsFilterResult paramComicsFilterResult, int paramInt2, AEEditorFilterBean paramAEEditorFilterBean)
  {
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.17(this, paramInt2, paramInt1, paramComicsFilterResult, paramAEEditorFilterBean));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorImageEditFragment.12(this, paramInt, paramBoolean));
  }
  
  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2, AEEditorFilterBean paramAEEditorFilterBean)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AEEditorImageEditFragment.16(this, paramInt1, paramAEEditorFilterBean, paramInt2);
    localHttpNetReq.mReqUrl = "https://api.shadowai.qq.com/trpc.mobile_qq_http.mobile_qq_http_cgi.MobileQQHttpCgi/ImageStylize";
    localHttpNetReq.mHttpMethod = 1;
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    localHttpNetReq.mSendData = a(paramBitmap, paramAEEditorFilterBean);
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mReqProperties.put("Content-Type", "application/proto; charset=UTF-8");
    localHttpNetReq.mReqProperties.put("Accept", "application/proto");
    paramBitmap = BaseApplicationImpl.getApplication().getRuntime();
    if (paramBitmap == null)
    {
      QLog.e("AEEditorImageEditFragment", 1, "app is null");
      return;
    }
    Object localObject = (TicketManager)paramBitmap.getManager(2);
    paramBitmap = paramBitmap.getAccount();
    paramAEEditorFilterBean = ((TicketManager)localObject).getSkey(paramBitmap);
    localObject = ((TicketManager)localObject).getPskey(paramBitmap, "shadowai.qq.com");
    String str = AEModule.getVersion();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localHttpNetReq.mReqProperties.put("Cookie", "uin=" + paramBitmap + ";pskey=" + (String)localObject + ";qqversion=" + "8.5.5" + ";aekitversion=" + str + ";platform=" + "Android");
    }
    for (;;)
    {
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)getActivity().getAppInterface().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      return;
      C();
      localHttpNetReq.mReqProperties.put("Cookie", "uin=" + paramBitmap + ";skey=" + paramAEEditorFilterBean + ";qqversion=" + "8.5.5" + ";aekitversion=" + str + ";platform=" + "Android");
    }
  }
  
  private void a(ImageExportConfig paramImageExportConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("outputPaths=");
    localStringBuilder.append(paramImageExportConfig.getOutputPaths());
    localStringBuilder.append(", maxExportSize=");
    localStringBuilder.append(paramImageExportConfig.getMaxExportSize());
    localStringBuilder.append(", minRenderSize=");
    localStringBuilder.append(paramImageExportConfig.getMinIntermediateRenderSize());
    localStringBuilder.append(", maxRenderSize=");
    localStringBuilder.append(paramImageExportConfig.getMaxIntermediateRenderSize());
    localStringBuilder.append(", quality=");
    localStringBuilder.append(paramImageExportConfig.getQuality());
    AEQLog.d("AEEditorImageEditFragment", "[onGoNext], exportParams: " + localStringBuilder.toString());
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangStringBuilder.length() == 0)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append((String)paramHashMap.get("filter_id"));
      if (this.jdField_b_of_type_JavaLangStringBuilder.length() != 0) {
        break label117;
      }
      this.jdField_b_of_type_JavaLangStringBuilder.append((String)paramHashMap.get("text_item_id"));
    }
    for (;;)
    {
      if (this.jdField_c_of_type_JavaLangStringBuilder.length() != 0) {
        break label144;
      }
      this.jdField_c_of_type_JavaLangStringBuilder.append((String)paramHashMap.get("ai_color_frame_states"));
      return;
      this.jdField_a_of_type_JavaLangStringBuilder.append(",").append((String)paramHashMap.get("filter_id"));
      break;
      label117:
      this.jdField_b_of_type_JavaLangStringBuilder.append(",").append((String)paramHashMap.get("text_item_id"));
    }
    label144:
    this.jdField_c_of_type_JavaLangStringBuilder.append(",").append((String)paramHashMap.get("ai_color_frame_states"));
  }
  
  private static boolean a(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private byte[] a(Bitmap paramBitmap, AEEditorFilterBean paramAEEditorFilterBean)
  {
    boolean bool = false;
    Object localObject2 = new ByteArrayOutputStream();
    int i = paramAEEditorFilterBean.getUploadMaxSize();
    AEQLog.b("AEEditorImageEditFragment", "before: " + System.currentTimeMillis() + ", uploadMaxSize=" + i + ", src bitmap size=[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + "]");
    Object localObject1 = a(paramBitmap, i);
    BitmapUtils.recycle(paramBitmap);
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
    AEQLog.b("AEEditorImageEditFragment", "after: " + System.currentTimeMillis() + ", scaled bitmap size=[" + ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "]");
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    paramBitmap = new AEPbData.ImageStylizeRequest();
    int j = paramAEEditorFilterBean.getEditorEffectItem().getStylizeType();
    i = j;
    if (j == 0) {
      i = 1;
    }
    paramBitmap.stylizeType.set(i, true);
    paramBitmap.imgInfo.setHasFlag(true);
    paramBitmap.imgInfo.imgWidth.set(((Bitmap)localObject1).getWidth());
    paramBitmap.imgInfo.imgHeight.set(((Bitmap)localObject1).getHeight());
    paramBitmap.imgInfo.imageRawData.set(ByteStringMicro.copyFrom((byte[])localObject2), true);
    paramAEEditorFilterBean = FaceChangeUtils.detectFaceOrigin((Bitmap)localObject1);
    BitmapUtils.recycle((Bitmap)localObject1);
    if ((paramAEEditorFilterBean == null) || (paramAEEditorFilterBean.getAllFacePoints() == null) || (paramAEEditorFilterBean.getAllFacePoints().isEmpty())) {
      paramBitmap.imgInfo.hasFace.set(false);
    }
    for (;;)
    {
      paramBitmap.setHasFlag(true);
      return paramBitmap.toByteArray();
      paramAEEditorFilterBean = paramAEEditorFilterBean.getAllFacePoints().iterator();
      while (paramAEEditorFilterBean.hasNext())
      {
        localObject1 = (List)paramAEEditorFilterBean.next();
        if (localObject1 != null)
        {
          localObject2 = new AEPbData.FaceInfo();
          ((AEPbData.FaceInfo)localObject2).setHasFlag(true);
          i = 0;
          while (i < ((List)localObject1).size())
          {
            ((AEPbData.FaceInfo)localObject2).pos.add(Float.valueOf(((PointF)((List)localObject1).get(i)).x));
            ((AEPbData.FaceInfo)localObject2).pos.add(Float.valueOf(((PointF)((List)localObject1).get(i)).y));
            i += 1;
          }
          paramBitmap.imgInfo.faceInfos.add((MessageMicro)localObject2);
        }
      }
      i = paramBitmap.imgInfo.faceInfos.size();
      paramAEEditorFilterBean = paramBitmap.imgInfo.hasFace;
      if (i > 0) {
        bool = true;
      }
      paramAEEditorFilterBean.set(bool);
      paramBitmap.imgInfo.faceNum.set(i);
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.c(paramInt))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.d(paramInt);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.clearAEKitModel(paramInt);
      int i = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt);
      if (!CollectionUtils.indexOutOfBounds(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(), i))
      {
        AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a().get(i);
        if (paramInt == this.jdField_b_of_type_Int) {
          a(i, localAEEditorFilterBean);
        }
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void b(View paramView)
  {
    AEQLog.b("AEEditorImageEditFragment", "initViews");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager = ((AEEditorImageViewPager)paramView.findViewById(2131381619));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator = ((NumberIndicator)paramView.findViewById(2131372463));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367052));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setOnPageChangeListener(this);
    Object localObject = new GestureDetector(paramView.getContext(), new AEEditorImageEditFragment.1(this));
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AEEditorImageEditFragment.2(this));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setOnTouchListener(new AEEditorImageEditFragment.3(this, (GestureDetector)localObject));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377425));
    localObject = new LinearLayoutManager(getActivity(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter = new AEFrameColorListAdapter();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter.a(new AEEditorImageEditFragment.4(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter);
    this.jdField_c_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131365471));
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel = ((AEEditorCropperPanel)paramView.findViewById(2131362281));
    this.jdField_a_of_type_DovComQqImAeeditorModuleClipImageAEEditorCropperPanel.setCropChangeCallBack(new AEEditorImageEditFragment.5(this));
    this.jdField_c_of_type_AndroidWidgetFrameLayout.setOnClickListener(new AEEditorImageEditFragment.6(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366190));
    H();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new AEEditorImageEditFragment.7(this));
    g(this.h);
  }
  
  private void b(List<ImageMainColorData> paramList)
  {
    if (CollectionUtil.isEmptyList(paramList)) {
      return;
    }
    Collections.sort(paramList, new AEEditorImageEditFragment.13(this));
  }
  
  private int c()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  private void c(int paramInt)
  {
    Object localObject = AEExtractColorUtil.a((List)this.jdField_c_of_type_AndroidUtilSparseArray.get(paramInt), 6);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter.a((List)localObject);
    localObject = (String)this.jdField_d_of_type_AndroidUtilSparseArray.get(paramInt);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter.a((String)localObject);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFrameAEFrameColorListAdapter.notifyDataSetChanged();
  }
  
  private int d()
  {
    return this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.d();
  }
  
  private String d()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e("AEEditorImageEditFragment", 1, "app is null");
      return "";
    }
    String str = localAppRuntime.getAccount();
    return ((TicketManager)localAppRuntime.getManager(2)).getPskey(str, "shadowai.qq.com");
  }
  
  private void d(int paramInt)
  {
    AEQLog.b("AEEditorImageEditFragment", "updateImageFilterByIndex: " + paramInt);
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.b(paramInt) == 0) && (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt) == 0)) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.render(paramInt);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.b(paramInt))
      {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModelForAI(paramInt, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt).b(), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt).a(), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt).a(), (int)(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt).b() * 100.0F), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt).c());
        return;
      }
      if (!this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.c(paramInt)) {
        break;
      }
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt) != null)
      {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt).a());
        return;
      }
      paramInt = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt);
    } while (CollectionUtils.indexOutOfBounds(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(), paramInt));
    a(paramInt, (AEEditorFilterBean)this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a().get(paramInt));
    return;
    e(paramInt);
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel == null) || (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a() == null)) {
      AEQLog.d("AEEditorImageEditFragment", "filter list null.");
    }
    int i;
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      i = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt);
    } while (i >= ((List)localObject1).size());
    Object localObject2 = (AEEditorFilterBean)((List)localObject1).get(i);
    float f1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getGlowStrength();
    Object localObject1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getAdjustParams();
    localObject2 = AEEditorResourceManager.a().c((AEEditorFilterBean)localObject2);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModel(paramInt, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt), f1, (Map)localObject1, (String)localObject2);
  }
  
  private void f(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel == null) || (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a() == null)) {
      AEQLog.d("AEEditorImageEditFragment", "filter list null.");
    }
    int i;
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      i = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt);
    } while (i >= ((List)localObject1).size());
    Object localObject2 = (AEEditorFilterBean)((List)localObject1).get(i);
    float f1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getGlowStrength();
    Object localObject1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getAdjustParams();
    localObject2 = AEEditorResourceManager.a().c((AEEditorFilterBean)localObject2);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAllAeKitModelWithOutRender(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(paramInt), f1, (Map)localObject1, (String)localObject2);
  }
  
  private void g(int paramInt)
  {
    if (paramInt >= 1) {
      d(paramInt - 1);
    }
    if (paramInt < c() - 1) {
      d(paramInt + 1);
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private boolean g()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!new File((String)localIterator.next()).exists()) {
        return false;
      }
    }
    return true;
  }
  
  private void h(int paramInt)
  {
    AEQLog.a("AEEditorImageEditFragment", "update all data.");
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.b(paramInt))
    {
      int i = 0;
      if (i < c())
      {
        if (paramInt == i) {}
        for (;;)
        {
          i += 1;
          break;
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitNodeForAIWithoutRender(i, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(i).b(), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(i).a(), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(i).a(), (int)(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(i).b() * 100.0F), this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(i).c());
        }
      }
    }
    else
    {
      if (!this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.c(paramInt)) {
        break label124;
      }
    }
    return;
    label124:
    f(paramInt);
  }
  
  public void A()
  {
    i();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    NumberIndicator localNumberIndicator = this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null) {}
    for (int i = 0;; i = 4)
    {
      ViewUtils.b(localNumberIndicator, i);
      G();
      return;
    }
  }
  
  public int a()
  {
    return 2131558579;
  }
  
  protected TAVCutSession a()
  {
    return this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  }
  
  protected AEEditorFilterControlPanel.FilterControlListener a()
  {
    return this;
  }
  
  protected FilterChangedComparator a()
  {
    return new AEEditorImageEditFragment.24(this);
  }
  
  protected AEEditorTextPart.AEEditorTextDialogListener a()
  {
    return new AEEditorImageEditFragment.21(this);
  }
  
  public String a()
  {
    return "AEEditorImageEdit";
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131377163: 
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel, 0);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, 8);
      j();
      ViewUtils.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 8);
      AEReportUtils.h();
      return;
    case 2131377173: 
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel, 8);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, 0);
      ViewUtils.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 8);
      AEReportUtils.i();
      return;
    }
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel, 8);
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel, 8);
    j();
    ViewUtils.b(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, 0);
    AEReportUtils.j();
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setEffectStrength(this.jdField_b_of_type_Int, paramFloat);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_Int, paramFloat);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_Int, paramInt, paramFloat);
    AEBaseReportParam.a().a().b.put(Integer.valueOf(this.jdField_b_of_type_Int), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    o();
    String str1 = AEEditorResourceManager.a().a(paramAEEditorFilterBean);
    float f1 = paramAEEditorFilterBean.getEffectExtendBean().getDefaultEffectAlpha();
    if (c(paramInt))
    {
      e(true);
      if (!a(paramInt)) {
        break label207;
      }
      f(true);
    }
    for (;;)
    {
      float f2 = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_Int, paramInt, f1);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f2);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_Int, str1, f2, paramInt);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_Int, paramAEEditorFilterBean.getEffectId());
      float f3 = paramAEEditorFilterBean.getEffectExtendBean().getGlowStrength();
      Map localMap = paramAEEditorFilterBean.getEffectExtendBean().getAdjustParams();
      String str2 = AEEditorResourceManager.a().c(paramAEEditorFilterBean);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModel(this.jdField_b_of_type_Int, f2, str1, f3, localMap, str2);
      AEBaseReportParam.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_b_of_type_Int), paramAEEditorFilterBean.getEffectId());
      AEBaseReportParam.a().a().b.put(Integer.valueOf(this.jdField_b_of_type_Int), Float.valueOf(f1));
      return;
      e(false);
      break;
      label207:
      f(false);
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    super.a(paramString1, paramInt1, paramInt2, paramString2);
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator, 4);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(4);
      g(false);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    g(this.h);
    AEReportUtils.g();
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.mediaChanged()) {
      return false;
    }
    return super.a();
  }
  
  protected boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_JavaUtilList.size() > 1) && (!b(paramInt));
  }
  
  public boolean a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    int i = this.jdField_b_of_type_Int;
    ComicsFilterResult localComicsFilterResult = (ComicsFilterResult)this.jdField_a_of_type_JavaUtilMap.get(a(i, paramAEEditorFilterBean));
    if (localComicsFilterResult == null)
    {
      if (!NetworkUtil.a())
      {
        QQToast.a(getActivity(), getActivity().getResources().getString(2131690921), 1).a();
        return false;
      }
      this.jdField_c_of_type_Boolean = false;
      m();
      FaceChangeUtils.runInGLThread(new AEEditorImageEditFragment.15(this, i, paramInt, paramAEEditorFilterBean), false, "GLThread-changeFaceSingle");
      return false;
    }
    a(i, localComicsFilterResult, paramInt, paramAEEditorFilterBean);
    return true;
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = ((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getCurrentIndex())).getMediaEffectModel().getStickerModelList();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.size())
      {
        if ((((StickerModel)paramString.get(i)).getInteractive() > 0) && (((StickerModel)paramString.get(i)).getMaterialId().startsWith("qiukuolie"))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected int b()
  {
    return 0;
  }
  
  public String b()
  {
    return HardCodeUtil.a(2131689734);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c()
  {
    AEQLog.b("AEEditorImageEditFragment", "initImageInfos");
    Object localObject1 = new ArrayList();
    Object localObject2 = getArguments();
    if (((Bundle)localObject2).containsKey("AEEditorConstants_CLIPPED_PIC_INFOS")) {
      localObject1 = (List)((Bundle)localObject2).getSerializable("AEEditorConstants_CLIPPED_PIC_INFOS");
    }
    for (;;)
    {
      this.h = ((Bundle)localObject2).getBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EditorPicInfo)((Iterator)localObject1).next();
        CropConfig localCropConfig = new CropConfig((float)((EditorPicInfo)localObject2).x, (float)((EditorPicInfo)localObject2).y, (float)Math.min(((EditorPicInfo)localObject2).w, 1.0D), (float)((EditorPicInfo)localObject2).h);
        this.jdField_a_of_type_JavaUtilList.add(((EditorPicInfo)localObject2).picPath);
        this.jdField_b_of_type_JavaUtilList.add(new AEEditorImageInfo(((EditorPicInfo)localObject2).picPath, (int)((EditorPicInfo)localObject2).originPicWidth, (int)((EditorPicInfo)localObject2).originPicHeight, localCropConfig));
      }
      AEQLog.d("AEEditorImageEditFragment", "no image crop infos");
    }
    this.jdField_c_of_type_Int = d();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_d_of_type_Boolean = AEThemeUtil.a();
  }
  
  public void c(boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  protected void d()
  {
    AEEditorAIFilterManager.a().a();
  }
  
  protected void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    a(paramBoolean);
  }
  
  protected void e()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
  }
  
  public boolean f()
  {
    Object localObject = this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterDataCache.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int));
    boolean bool;
    if ((localObject != null) && ((localObject instanceof SingleImageAIFilterResult)))
    {
      AEQLog.b("AEEditorImageEditFragment", "onAIFilterRequest: has cache");
      bool = ((SingleImageAIFilterResult)localObject).jdField_a_of_type_Boolean;
      AEQLog.b("AEEditorImageEditFragment", "onAIFilterRequest: needRequest=" + bool);
      if (!bool) {
        break label153;
      }
      l();
      localObject = new SingleImageAIFilterProxy((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int), this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int);
      ((SingleImageAIFilterProxy)localObject).a(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver);
      AEEditorAIFilterManager.a().a(getActivity().getAppInterface(), getActivity(), (AIFilterProxyBase)localObject);
    }
    for (;;)
    {
      if (bool) {
        break label268;
      }
      return true;
      bool = true;
      break;
      label153:
      e(false);
      f(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      if (a(1)) {
        f(true);
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_Int, (AIFilterResult)localObject);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModelForAI(this.jdField_b_of_type_Int, ((AIFilterResult)localObject).b(), ((AIFilterResult)localObject).a(), ((AIFilterResult)localObject).a(), (int)(((AIFilterResult)localObject).b() * 100.0F), ((AIFilterResult)localObject).c());
      a(new String[] { "智能滤镜label", ((AIFilterResult)localObject).a(), "智能滤镜errCode", "0" });
    }
    label268:
    return false;
  }
  
  public void g()
  {
    AEQLog.b("AEEditorImageEditFragment", "exportImages");
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession == null)
    {
      AEQLog.d("AEEditorImageEditFragment", "exportImages error: session is null");
      return;
    }
    if (!g())
    {
      QQToast.a(getActivity(), "图片不存在或被删除", 0).a();
      return;
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.22(this));
    Object localObject1 = AEEditorPath.EDITOR.FILES.jdField_c_of_type_JavaLangString;
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList = null;
    }
    for (this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();; this.jdField_b_of_type_JavaUtilArrayList = new ArrayList())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject2 = new File((String)this.jdField_a_of_type_JavaUtilList.get(i));
        localObject2 = (String)localObject1 + File.separator + "output_" + i + "_" + System.currentTimeMillis() + "_" + VideoFilterTools.a(((File)localObject2).getName()) + ".jpg";
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
        if (this.jdField_a_of_type_JavaUtilHashMap != null)
        {
          ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(i));
          if (localArrayList != null)
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(String.valueOf(i));
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localArrayList);
          }
        }
        i += 1;
      }
    }
    localObject1 = new ImageExportConfig();
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_b_of_type_Int);
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = d();
    }
    ((ImageExportConfig)localObject1).setMaxExportSize(d());
    ((ImageExportConfig)localObject1).setMinIntermediateRenderSize(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.a());
    ((ImageExportConfig)localObject1).setMaxIntermediateRenderSize(d());
    ((ImageExportConfig)localObject1).setQuality(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.e());
    ((ImageExportConfig)localObject1).setOutputPath(this.jdField_b_of_type_JavaUtilArrayList);
    a((ImageExportConfig)localObject1);
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getExporter((ImageExportConfig)localObject1);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_c_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter.export(new AEEditorImageEditFragment.23(this));
  }
  
  protected void h()
  {
    if ((List)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int) == null) {}
    while (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.jdField_b_of_type_Int, (List)this.jdField_b_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int), true);
  }
  
  public void i()
  {
    super.i();
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setScrollable(false);
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a() == 2) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.b(this.jdField_b_of_type_Int);
    }
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator, 4);
  }
  
  public void j()
  {
    super.j();
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator, 0);
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.20(this));
  }
  
  protected void n()
  {
    this.f = true;
    E();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b("AEEditorImageEditFragment", "onCreate");
    super.onCreate(paramBundle);
    C();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AEQLog.b("AEEditorImageEditFragment", "onDestroy");
    super.onDestroy();
    FileUtils.a(AEEditorPath.EDITOR.CACHE.jdField_d_of_type_JavaLangString, false);
  }
  
  public void onDestroyView()
  {
    AEQLog.b("AEEditorImageEditFragment", "onDestroyView");
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null) {
      ((IHttpEngineService)getActivity().getAppInterface().getRuntimeService(IHttpEngineService.class, "all")).cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = null;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = null;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_b_of_type_Int);
      j();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AEQLog.b("AEEditorImageEditFragment", "onPageSelected: " + paramInt);
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setImageInfo(this.jdField_b_of_type_Int, Md5Utils.getMD5((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)));
    }
    a(paramInt, false);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setCurrentIndex(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setCurrentIndex(paramInt + 1);
    int i = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(i);
    if ((!this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_Int)) && (!this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.b(this.jdField_b_of_type_Int)) && (!this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.c(this.jdField_b_of_type_Int)) && (c(i))) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(this.jdField_b_of_type_Int));
    }
    d(paramInt);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AEQLog.b("AEEditorImageEditFragment", "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    AEQLog.b("AEEditorImageEditFragment", "init");
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(Looper.getMainLooper(), this);
    D();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.b();
    b(paramView);
    B();
    a(0, false);
    if (AEEditorResourceManager.a().b()) {
      u();
    }
    a(new String[] { "设备级别", ParamsUtil.a(), "图片最小预览尺寸", String.valueOf(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.a()), "图片最大预览尺寸", String.valueOf(this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.b()), "图片导出质量", this.jdField_a_of_type_DovComQqImAeeditorModuleParamsImageParamStrategy.e() + "%", "图片最大导出尺寸", String.valueOf(this.jdField_c_of_type_Int) });
    int i;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      paramView = AEEditorResourceManager.a().a();
      if ((paramView.get(0) == null) || (((AEEditorPagStickerGroup)paramView.get(0)).stickerInfoList == null)) {
        return;
      }
      paramView = ((AEEditorPagStickerGroup)paramView.get(0)).stickerInfoList;
      i = 0;
    }
    for (;;)
    {
      if (i < paramView.size())
      {
        if (((AEEditorPagStickerInfo)paramView.get(i)).stickerId.equals(this.jdField_c_of_type_JavaLangString))
        {
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextBean = AEEditorTextBean.createTextBeanByStickerInfo((AEEditorPagStickerInfo)paramView.get(i));
          a(0, true);
        }
      }
      else
      {
        AEReportUtils.w();
        return;
      }
      i += 1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public void p()
  {
    super.p();
  }
  
  public void t()
  {
    new Handler(Looper.getMainLooper()).postDelayed(new AEEditorImageEditFragment.8(this), 100L);
  }
  
  protected void u()
  {
    SilentBatchImageAIFilterProxy localSilentBatchImageAIFilterProxy = new SilentBatchImageAIFilterProxy(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
    localSilentBatchImageAIFilterProxy.a(new AEEditorImageEditFragment.14(this));
    AEEditorAIFilterManager.a().a(getActivity().getAppInterface(), getActivity(), localSilentBatchImageAIFilterProxy);
  }
  
  public void v()
  {
    int j = 0;
    AEQLog.b("AEEditorImageEditFragment", "onApplyAll current position = " + this.jdField_b_of_type_Int);
    AEBaseDataReporter.a().l();
    Object localObject1;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c())
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterDataCache.a((String)localObject2);
          if ((localObject2 != null) && ((localObject2 instanceof SingleImageAIFilterResult)))
          {
            AEQLog.b("AEEditorImageEditFragment", "onAIFilterRequest: has cache");
            if (!((AIFilterResult)localObject2).jdField_a_of_type_Boolean) {
              continue;
            }
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        l();
        localObject1 = new BatchImageAIFilterProxy(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterDataCache.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)));
        ((BatchImageAIFilterProxy)localObject1).a(this.jdField_b_of_type_DovComQqImAeeditorModuleAifilterAEEditorAIFilterManager$AIFilterObserver);
        AEEditorAIFilterManager.a().a(getActivity().getAppInterface(), getActivity(), (AIFilterProxyBase)localObject1);
      }
      do
      {
        return;
        i = 1;
        break;
        e(false);
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
        localObject1 = new StringBuilder();
        i = j;
        while (i < c())
        {
          localObject2 = (SingleImageAIFilterResult)this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterDataCache.a((String)this.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a(i, (AIFilterResult)localObject2);
          ((StringBuilder)localObject1).append(((SingleImageAIFilterResult)localObject2).a() + "|");
          i += 1;
        }
        a("智能滤镜label", ((StringBuilder)localObject1).toString());
        d(this.jdField_b_of_type_Int);
        g(this.jdField_b_of_type_Int);
        h(this.jdField_b_of_type_Int);
        F();
        return;
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.d())
        {
          this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.a();
          g(this.jdField_b_of_type_Int);
          h(this.jdField_b_of_type_Int);
          F();
          return;
        }
      } while (c());
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.b(this.jdField_b_of_type_Int);
      g(this.jdField_b_of_type_Int);
      h(this.jdField_b_of_type_Int);
      F();
      return;
      i = 0;
    }
  }
  
  public void w()
  {
    o();
    e(false);
    f(false);
    if (a(0)) {
      f(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.clearAEKitModel(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterImageFilterInfoCache.c(this.jdField_b_of_type_Int);
      ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator, 0);
      AEBaseReportParam.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_b_of_type_Int), "effect_blank");
      AEBaseReportParam.a().a().b.put(Integer.valueOf(this.jdField_b_of_type_Int), Float.valueOf(-1.0F));
      return;
      f(false);
    }
  }
  
  public void x()
  {
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator, 4);
  }
  
  public void y()
  {
    ViewUtils.b(this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator, 0);
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment
 * JD-Core Version:    0.7.0.1
 */