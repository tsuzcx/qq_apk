package dov.com.qq.im.ae.biz.qcircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tavcut.TAVCut;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.MovieExporter;
import com.tencent.tavcut.exporter.MovieExporter.VideoCompressListener;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.VideoUtil;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.usq.u;
import cooperation.qzone.util.QZLog;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.album.data.AEAlbumImageModel;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.album.data.AEAlbumMediaBaseModel;
import dov.com.qq.im.ae.album.data.AEAlbumVideoModel;
import dov.com.qq.im.ae.album.data.AEPhotoCommonDataCreator;
import dov.com.qq.im.ae.album.data.AEPhotoCropInfoWrapper;
import dov.com.qq.im.ae.biz.qcircle.part.AECircleAlbumListPart;
import dov.com.qq.im.ae.biz.qcircle.part.AECirclePhotoListPart;
import dov.com.qq.im.ae.biz.qcircle.part.AECirclePreviewPart;
import dov.com.qq.im.ae.biz.qcircle.part.AECircleSelectPanelPart;
import dov.com.qq.im.ae.biz.qcircle.part.AECircleTitleChipPart;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AEEditorCancelableProgressDialog;
import dov.com.qq.im.aeeditor.AEEditorLauncher;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.CACHE;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.aeeditor.module.params.ParamFactory;
import dov.com.qq.im.aeeditor.module.params.VideoParamStrategy;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class AECirclePhotoListLogic
  implements MediaScanner.OnMediaScannerListener
{
  private static final ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new AECirclePhotoListLogic.1();
  private int jdField_a_of_type_Int = 0;
  protected long a;
  public PhotoCommonBaseData<OtherCommonData> a;
  public PhotoListBaseData a;
  private MovieExporter jdField_a_of_type_ComTencentTavcutExporterMovieExporter;
  public final AEAlbumLogicData a;
  AECircleAlbumListPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart;
  AECirclePhotoListPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart;
  AECirclePreviewPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePreviewPart;
  AECircleSelectPanelPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleSelectPanelPart;
  AECircleTitleChipPart jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleTitleChipPart;
  private AEEditorCancelableProgressDialog jdField_a_of_type_DovComQqImAeViewAEEditorCancelableProgressDialog;
  private String jdField_a_of_type_JavaLangString = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
  public ArrayList<LocalMediaInfo> a;
  private List<AECirclePhotoListLogic.InitResult> jdField_a_of_type_JavaUtilList = new ArrayList();
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  public WeakReference<AECirclePhotoListFragment> a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 3000;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 3000;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private volatile boolean d = false;
  
  public AECirclePhotoListLogic(AECirclePhotoListFragment paramAECirclePhotoListFragment)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData = new AEAlbumLogicData();
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAECirclePhotoListFragment);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = AEPhotoCommonDataCreator.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData = new PhotoListBaseData();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic new，fragment = " + paramAECirclePhotoListFragment + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  @Nullable
  private LocalMediaInfo a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
        localObject1 = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
      }
    }
    if (localObject1 == null)
    {
      localObject2 = new LinkedList(this.jdField_a_of_type_JavaUtilArrayList);
      if (!CollectionUtils.isEmpty((Collection)localObject2))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject2).next();
          if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty(localLocalMediaInfo.path)) && (localLocalMediaInfo.path.equals(paramString))) {
            return localLocalMediaInfo;
          }
        }
      }
    }
    return localObject1;
  }
  
  private EncoderWriter.OutputConfig a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    EncoderWriter.OutputConfig localOutputConfig = new EncoderWriter.OutputConfig();
    VideoParamStrategy localVideoParamStrategy = ParamFactory.a();
    paramLocalMediaInfo = localVideoParamStrategy.a(VideoUtil.getVideoSize(paramLocalMediaInfo.path));
    localOutputConfig.VIDEO_BIT_RATE = localVideoParamStrategy.b();
    localOutputConfig.VIDEO_TARGET_HEIGHT = paramLocalMediaInfo.getHeight();
    localOutputConfig.VIDEO_TARGET_WIDTH = paramLocalMediaInfo.getWidth();
    return localOutputConfig;
  }
  
  private EditorPicInfo a(@NonNull String paramString)
  {
    AEQLog.a("AECirclePhotoListLogic", "[prepareEditorPicInfo]");
    EditorPicInfo localEditorPicInfo = new EditorPicInfo();
    Size localSize = BitmapUtil.getImageSize(paramString);
    localEditorPicInfo.picPath = paramString;
    localEditorPicInfo.originPicWidth = localSize.getWidth();
    localEditorPicInfo.originPicHeight = localSize.getHeight();
    if ((localEditorPicInfo.originPicHeight != 0.0D) && (localEditorPicInfo.originPicWidth != 0.0D))
    {
      double d1 = localEditorPicInfo.originPicWidth * 1.0D / localEditorPicInfo.originPicHeight;
      if (d1 <= 0.333333343267441D)
      {
        localEditorPicInfo.x = 0.0D;
        localEditorPicInfo.y = (1.0D * (localEditorPicInfo.originPicHeight - localEditorPicInfo.originPicWidth / 0.333333343267441D) / 2.0D / localEditorPicInfo.originPicHeight);
        localEditorPicInfo.w = 1.0D;
        localEditorPicInfo.h = (1.0D * (localEditorPicInfo.originPicWidth / 0.333333343267441D) / localEditorPicInfo.originPicHeight);
        return localEditorPicInfo;
      }
      if (d1 >= 1.777777791023254D)
      {
        localEditorPicInfo.x = (1.0D * (localEditorPicInfo.originPicWidth - localEditorPicInfo.originPicHeight * 1.777777791023254D) / 2.0D / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.y = 0.0D;
        localEditorPicInfo.w = (1.0D * (localEditorPicInfo.originPicHeight * 1.777777791023254D) / localEditorPicInfo.originPicWidth);
        localEditorPicInfo.h = 1.0D;
        return localEditorPicInfo;
      }
      localEditorPicInfo.x = 0.0D;
      localEditorPicInfo.y = 0.0D;
      localEditorPicInfo.w = 1.0D;
      localEditorPicInfo.h = 1.0D;
      return localEditorPicInfo;
    }
    localEditorPicInfo.x = 0.0D;
    localEditorPicInfo.y = 0.0D;
    localEditorPicInfo.w = 1.0D;
    localEditorPicInfo.h = 1.0D;
    return localEditorPicInfo;
  }
  
  @NotNull
  private String a(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = u.a(paramLocalMediaInfo.path);
    String str = "";
    if (!StringUtil.a((String)localObject)) {
      paramLocalMediaInfo = (String)localObject + ".mp4";
    }
    for (;;)
    {
      return AEEditorPath.EDITOR.CACHE.b + File.separator + paramLocalMediaInfo;
      localObject = paramLocalMediaInfo.path.split("/");
      paramLocalMediaInfo = str;
      if (localObject.length > 0) {
        paramLocalMediaInfo = localObject[(localObject.length - 1)];
      }
    }
  }
  
  public static ArrayList<String> a()
  {
    return jdField_b_of_type_JavaUtilArrayList;
  }
  
  private void a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
      QQToast.a(paramContext, "请选择2秒到1小时之间的视频", 0).a();
      return;
    case 3: 
      QQToast.a(paramContext, HardCodeUtil.a(2131689801), 0).a();
      return;
    case 4: 
      QQToast.a(paramContext, HardCodeUtil.a(2131689799), 0).a();
      return;
    }
    QQToast.a(paramContext, HardCodeUtil.a(2131689802), 0).a();
  }
  
  @WorkerThread
  private void a(ArrayList<AEAlbumVideoModel> paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        AEAlbumVideoModel localAEAlbumVideoModel = (AEAlbumVideoModel)paramArrayList.get(i);
        LocalMediaInfo localLocalMediaInfo = a(localAEAlbumVideoModel.getPath());
        localAEAlbumVideoModel.setOriginPath(localAEAlbumVideoModel.getPath());
        int k = i + 1;
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
        AEQLog.b("AECirclePhotoListLogic", "batchCompress---begin, index=" + k);
        ThreadManager.getUIHandler().post(new AECirclePhotoListLogic.8(this, k, j));
        a(localLocalMediaInfo, new AECirclePhotoListLogic.9(this, k, localAEAlbumVideoModel));
        if (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch == null) {}
      }
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = null;
        if ((this.jdField_c_of_type_Boolean) || (this.d)) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        i += 1;
      }
    }
  }
  
  private void a(ArrayList<AEAlbumMediaBaseModel> paramArrayList, boolean paramBoolean)
  {
    Activity localActivity = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
    Object localObject2 = localActivity.getIntent();
    if (AECameraEntry.n((Intent)localObject2))
    {
      AEQLog.b("AECirclePhotoListLogic", "doRealJumpForMix---is additional pick case, setResult and finish");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("ae_album_selected_media_models", paramArrayList);
      localActivity.setResult(-1, (Intent)localObject1);
      localActivity.finish();
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putSerializable("ae_album_selected_media_models", paramArrayList);
    int i = AECameraEntry.y.a();
    if (AECameraEntry.l((Intent)localObject2)) {
      i = AECameraEntry.A.a();
    }
    for (;;)
    {
      if (paramArrayList.size() == 1)
      {
        localObject2 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((ArrayList)localObject2).add(((AEAlbumMediaBaseModel)paramArrayList.next()).getPath());
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject2);
        AEEditorLauncher.a(localActivity, 1, (Bundle)localObject1, i);
        return;
      }
      AEEditorLauncher.a(localActivity, 2, (Bundle)localObject1, i);
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.add(new AECirclePhotoListLogic.InitResult(this, paramInt));
    }
  }
  
  private void e()
  {
    Intent localIntent = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.maxSelectNumForMix;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = false;
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum = this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.maxSelectNumForNormal;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSupportVideoCheckbox = localIntent.getBooleanExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum > 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = false;
      }
    } while (!localIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", false));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = false;
  }
  
  private void f()
  {
    if (!AEKitForQQ.a()) {
      this.jdField_a_of_type_JavaUtilList.add(new AECirclePhotoListLogic.InitResult(this, -1));
    }
    for (;;)
    {
      TAVCut.initTAVCut(BaseApplicationImpl.context, FeatureManager.getResourceDir(), FeatureManager.getResourceDir(), AEResUtil.g(), new AECirclePhotoListLogic.2(this));
      return;
      a(FeatureManager.Features.YT_COMMON.init(), -2);
      a(FeatureManager.Features.PTU_TOOLS.init(), -3);
      a(FeatureManager.Features.PTU_ALGO.init(), -4);
      a(FeatureManager.Features.LIGHT_SDK.init(), -8);
      a(FeatureManager.Features.IMAGE_ALGO.init(), -7);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
  }
  
  private void h()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = new LinkedList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < ((List)localObject2).size())
    {
      String str = (String)((List)localObject2).get(i);
      if (TextUtils.isEmpty(str)) {
        AEQLog.d("AECirclePhotoListLogic", "handleClickNextBtnForOnlyPhoto--empty path, drop it: " + str);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!new File(str).exists())
        {
          AEQLog.d("AECirclePhotoListLogic", "handleClickNextBtnForOnlyPhoto--file not exists, drop it: " + str);
        }
        else
        {
          ((ArrayList)localObject1).add(a(str));
          Object localObject3 = new AEPhotoCropInfoWrapper();
          ((AEPhotoCropInfoWrapper)localObject3).a = a(str);
          localObject3 = new AEAlbumImageModel(str, ((AEPhotoCropInfoWrapper)localObject3).a);
          ((AEAlbumImageModel)localObject3).setOriginPath(str);
          localArrayList.add(localObject3);
        }
      }
    }
    if (CollectionUtils.isEmpty((Collection)localObject1))
    {
      QQToast.a(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131689791, 0).a();
      return;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", (Serializable)localObject1);
    ((Bundle)localObject2).putSerializable("ae_album_selected_media_models", localArrayList);
    ((Bundle)localObject2).putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canPickVideo);
    i = AECameraEntry.y.a();
    if (AECameraEntry.l(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent())) {
      i = AECameraEntry.A.a();
    }
    localObject1 = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity();
    if (AECameraEntry.n(((Activity)localObject1).getIntent()))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("ae_album_selected_media_models", localArrayList);
      ((Activity)localObject1).setResult(-1, (Intent)localObject2);
      ((Activity)localObject1).finish();
      return;
    }
    AEEditorLauncher.a(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 0, (Bundle)localObject2, i);
  }
  
  private void i()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    LinkedList localLinkedList = new LinkedList(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    int i = 0;
    boolean bool = false;
    if (i < localLinkedList.size())
    {
      String str1 = (String)localLinkedList.get(i);
      if (TextUtils.isEmpty(str1)) {
        AEQLog.d("AECirclePhotoListLogic", "handleClickNextBtnForMixPhotoAndVideo--empty path, drop it: " + str1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (!new File(str1).exists())
        {
          AEQLog.d("AECirclePhotoListLogic", "handleClickNextBtnForMixPhotoAndVideo--file not exists, drop it: " + str1);
        }
        else
        {
          Object localObject = a(str1);
          if ((localObject != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) == 1))
          {
            int j = a((LocalMediaInfo)localObject);
            if ((j == 2) || (j == 0))
            {
              localObject = new AEAlbumVideoModel(str1);
              ((AEAlbumVideoModel)localObject).setOriginPath(str1);
              localArrayList1.add(localObject);
              String str2;
              if (j == 2)
              {
                str2 = (String)this.jdField_a_of_type_JavaUtilMap.get(str1);
                if (!TextUtils.isEmpty(str2)) {
                  break label253;
                }
                localArrayList2.add(localObject);
              }
              for (;;)
              {
                bool = true;
                break;
                label253:
                AEQLog.a("AECirclePhotoListLogic", "hit cache, no need compress for: " + str1);
                ((AEAlbumVideoModel)localObject).setPath(str2);
              }
            }
            AEQLog.d("AECirclePhotoListLogic", "handleClickNextBtnForMixPhotoAndVideo--not supported video, drop it: " + str1);
          }
          else
          {
            localObject = new AEPhotoCropInfoWrapper();
            ((AEPhotoCropInfoWrapper)localObject).a = a(str1);
            localObject = new AEAlbumImageModel(str1, ((AEPhotoCropInfoWrapper)localObject).a);
            ((AEAlbumImageModel)localObject).setOriginPath(str1);
            localArrayList1.add(localObject);
          }
        }
      }
    }
    if (CollectionUtils.isEmpty(localArrayList1))
    {
      AEQLog.d("AECirclePhotoListLogic", "handleClickNextBtnForMixPhotoAndVideo--no media selected, should NOT happen");
      QQToast.a(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), 2131689792, 0).a();
      return;
    }
    if (localArrayList2.isEmpty())
    {
      a(localArrayList1, bool);
      return;
    }
    if (this.jdField_a_of_type_DovComQqImAeViewAEEditorCancelableProgressDialog == null)
    {
      this.jdField_a_of_type_DovComQqImAeViewAEEditorCancelableProgressDialog = new AEEditorCancelableProgressDialog(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
      this.jdField_a_of_type_DovComQqImAeViewAEEditorCancelableProgressDialog.a(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131720492));
      this.jdField_a_of_type_DovComQqImAeViewAEEditorCancelableProgressDialog.a(new AECirclePhotoListLogic.5(this));
    }
    this.jdField_a_of_type_DovComQqImAeViewAEEditorCancelableProgressDialog.show();
    AEQLog.a("AECirclePhotoListLogic", "after show, submit compress task");
    ThreadManagerV2.excute(new AECirclePhotoListLogic.6(this, localArrayList2, localArrayList1, bool), 16, new AECirclePhotoListLogic.7(this), true);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    long l = paramLocalMediaInfo.mDuration;
    if ((l > 3600000L) || (l < 2000L)) {
      return 1;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramLocalMediaInfo.path);
      int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
      paramLocalMediaInfo = localMediaMetadataRetriever.extractMetadata(12);
      if (j <= a())
      {
        j = b();
        if (i <= j) {}
      }
      else
      {
        return 2;
      }
      boolean bool = a().contains(paramLocalMediaInfo);
      if (!bool) {
        return 3;
      }
      return 0;
    }
    catch (Exception paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        paramLocalMediaInfo.printStackTrace();
      }
      return 5;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  public PhotoCommonBaseData<OtherCommonData> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
  }
  
  public PhotoListBaseData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData;
  }
  
  public AEAlbumLogicData a()
  {
    return this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData;
  }
  
  public List<LocalMediaInfo> a(boolean paramBoolean)
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId.equals("$RecentAlbumId")) {
      if (!paramBoolean) {
        break label102;
      }
    }
    List localList;
    label102:
    for (i = 12;; i = 100)
    {
      localList = AlbumUtil.getAlbumMedias(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName, i, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filterVideoDurationLimit);
      LogTag.a("PEAK", "getAlbumMedias");
      if (localList != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() != 0))
    {
      i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size())
      {
        if (TextUtils.isEmpty((String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.get(i))) {
          QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
        }
        i += 1;
      }
    }
    return localList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "PhotoListLogic close，fragment = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isRecodeLastAlbumPath = paramIntent.getBooleanExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    Object localObject;
    if (paramIntent.getBooleanExtra("album_enter_directly", false))
    {
      long l1 = System.currentTimeMillis();
      long l2 = QAlbumUtil.sLastAlbumRecordTime;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isRecodeLastAlbumPath) && (l1 - l2 < 60000L))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = QAlbumUtil.sLastAlbumName;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = QAlbumUtil.sLastAlbumId;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = "$RecentAlbumId";
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showGifTypeIcon = paramIntent.getBooleanExtra("PeakConstants.showGifTypeIcon", false);
      localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = ((ArrayList)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = new ArrayList();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
      }
      localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() == ((HashMap)localObject).size()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.putAll((Map)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.maxVideoNum = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isSingleMode = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = MediaFileFilter.getFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filterVideoGif)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.customSendBtnText = paramIntent.getStringExtra("PhotoConst.CUSTOM_SENDBTN_TEXT");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_CAMERA", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.isShowCamera) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.showCameraInVideo = paramIntent.getBooleanExtra("PhotoConst.SHOW_CAMERA_IN_VIDEO", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.photoListStartPos = paramIntent.getIntExtra("PHOTOLIST_START_POSITION", -1);
      paramIntent.removeExtra("PHOTOLIST_START_POSITION");
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_IS_NEED_MEDIA_INFO", false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.filterVideoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_FILTER_VIDEO_DURATION_LIMIT", 9223372036854775807L);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType != 2) {
        break label908;
      }
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
      label523:
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.maxSelectNumForNormal = paramIntent.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.minSelectNumForMix = 2;
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.maxSelectNumForMix = 30;
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.minSelectNumForNormal = -2147483648;
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canMixPhotoAndVideo = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", false);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canSwitchSelectionMode = paramIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", true);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
      this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.canPickVideo = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true);
      e();
      AEQLog.b("AECirclePhotoListLogic", "initData---aeAlbumData=" + this.jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData);
      f();
      g();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.myUin = paramIntent.getStringExtra("PhotoConst.MY_UIN");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.videoSizeLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.videoDurationLimit = paramIntent.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", 9223372036854775807L);
      localObject = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumName");
      String str = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent().getStringExtra("albumId");
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = ((String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = str;
      }
      if (AECameraEntry.n(paramIntent)) {
        break label916;
      }
    }
    label908:
    label916:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_b_of_type_Int = 3000;
      this.jdField_c_of_type_Int = 3000;
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramIntent.getStringExtra("ALBUM_ID");
      break;
      localObject = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
      break label523;
    }
  }
  
  public void a(View paramView)
  {
    AlbumUtil.clearSelectItemInfo();
    AlbumUtil.a();
    paramView = PresendPicMgr.a();
    if (paramView != null) {
      paramView.a(1006);
    }
    paramView = ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();; i = 0)
    {
      StatisticConstants.b(paramView, i);
      ((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().finish();
      AlbumUtil.anim(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), false, false);
      AEBaseDataReporter.a().b(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      return;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, MovieExporter.VideoCompressListener paramVideoCompressListener)
  {
    if (this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter != null) {
      this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.cancelCompress();
    }
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter = new MovieExporter();
    String str = a(paramLocalMediaInfo);
    EncoderWriter.OutputConfig localOutputConfig = a(paramLocalMediaInfo);
    this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.compressVideo(paramLocalMediaInfo.path, str, localOutputConfig, new AECirclePhotoListLogic.10(this, paramVideoCompressListener, str));
  }
  
  public void a(AECircleAlbumListPart paramAECircleAlbumListPart)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart = paramAECircleAlbumListPart;
  }
  
  public void a(AECirclePhotoListPart paramAECirclePhotoListPart)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart = paramAECirclePhotoListPart;
  }
  
  public void a(AECirclePreviewPart paramAECirclePreviewPart)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePreviewPart = paramAECirclePreviewPart;
  }
  
  public void a(AECircleSelectPanelPart paramAECircleSelectPanelPart)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleSelectPanelPart = paramAECircleSelectPanelPart;
  }
  
  public void a(AECircleTitleChipPart paramAECircleTitleChipPart)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleTitleChipPart = paramAECircleTitleChipPart;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName)) || (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName))) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    int i = a(paramLocalMediaInfo);
    switch (i)
    {
    case 1: 
    default: 
      a(paramContext, i);
      return false;
    }
    return true;
  }
  
  public boolean a(List<LocalMediaInfo> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null)) {
      return false;
    }
    if (paramList == null)
    {
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart.a(paramList);
      if (paramBoolean) {
        this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart.a().post(new AECirclePhotoListLogic.3(this));
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart.a(paramList);
    if ((paramBoolean) && (paramList.isEmpty())) {
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECirclePhotoListPart.a().post(new AECirclePhotoListLogic.4(this));
    }
    long l2;
    long l1;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      paramList = (AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((paramList != null) && (paramList.getActivity() != null))
      {
        paramList = paramList.getActivity().getIntent();
        if (AECameraEntry.k(paramList))
        {
          l2 = System.currentTimeMillis();
          l1 = l2 - paramList.getLongExtra("PhotoConst.timestamp", 0L);
          l2 -= paramList.getLongExtra("PhotoConst.timestamp_last_activity", 0L);
          if ((l1 <= 60000L) && (l2 <= 60000L) && (l1 >= 0L) && (l2 >= 0L)) {
            break label232;
          }
        }
      }
    }
    for (;;)
    {
      return true;
      label232:
      AEBaseDataReporter.a().a(l1, l2);
    }
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListBaseData.backPressed) {
      AlbumThumbManager.getInstance(((AECirclePhotoListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity()).clear();
    }
    a();
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList;
    HashMap localHashMap1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap;
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.needMediaInfo)
    {
      HashMap localHashMap2 = new HashMap(localHashMap1);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject = null;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap != null) {
          localObject = (LocalMediaInfo)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.allMediaInfoHashMap.get(str);
        }
        if (localObject != null)
        {
          localHashMap2.put(str, localObject);
        }
        else
        {
          localObject = (LocalMediaInfo)localHashMap1.get(str);
          if (localObject != null) {
            localHashMap2.put(str, localObject);
          }
        }
      }
      paramIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap2);
    }
    paramIntent.putExtra("ALBUM_ID", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId);
    paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i();
      return;
    }
    h();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter != null) {
      this.jdField_a_of_type_ComTencentTavcutExporterMovieExporter.cancelCompress();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.clear();
    }
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic
 * JD-Core Version:    0.7.0.1
 */