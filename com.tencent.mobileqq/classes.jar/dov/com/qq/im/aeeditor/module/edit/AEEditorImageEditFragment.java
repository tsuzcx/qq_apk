package dov.com.qq.im.aeeditor.module.edit;

import amtj;
import android.annotation.SuppressLint;
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
import android.os.Handler.Callback;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import bfum;
import bmbc;
import bmbg;
import bmbj;
import bmbk;
import bmbx;
import bmby;
import bmcz;
import bmda;
import bmde;
import bmfh;
import bmfk;
import bmgf;
import bmgg;
import bmgl;
import bmgm;
import bmgn;
import bmgo;
import bmgq;
import bmgt;
import bmgu;
import bmhu;
import bmhv;
import bmhw;
import bmhx;
import bmhy;
import bmhz;
import bmia;
import bmib;
import bmid;
import bmie;
import bmif;
import bmig;
import bmih;
import bmii;
import bmij;
import bmik;
import bmil;
import bmkl;
import bmkm;
import bmkn;
import bmkt;
import bmkz;
import bmlb;
import bmmd;
import bmme;
import bmmf;
import bmna;
import bmng;
import bmnh;
import bmnr;
import bmns;
import bnub;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.microrapid.opencv.ImageMainColorData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
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
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.ae.play.FaceChangeUtils;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.FaceInfo;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageInfo;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageStylizeRequest;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageStylizeResponse;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEFilterExtendBean;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import dov.com.qq.im.aeeditor.view.AEInterceptTouchFrameLayout;
import dov.com.qq.im.aeeditor.view.NumberIndicator;
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
  implements Handler.Callback, ViewPager.OnPageChangeListener, bmkm, bmnh
{
  private long jdField_a_of_type_Long;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  bmfk jdField_a_of_type_Bmfk = new bmhy(this);
  private bmgf jdField_a_of_type_Bmgf = new bmgf();
  private bmgn jdField_a_of_type_Bmgn;
  private bmkz jdField_a_of_type_Bmkz = new bmkz();
  private bmlb jdField_a_of_type_Bmlb;
  private bmmd jdField_a_of_type_Bmmd = bmme.a();
  private HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  private ImageExporter jdField_a_of_type_ComTencentTavcutExporterImageExporter;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private AEEditorImagePagerAdapter jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter;
  private AEEditorImageViewPager jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager;
  private NumberIndicator jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, bmgo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private SparseArray<List<ImageMainColorData>> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  bmfk jdField_b_of_type_Bmfk = new bmhz(this);
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  private List<bmde> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private SparseArray<List<ImageMainColorData>> jdField_c_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private SparseArray<String> jdField_d_of_type_AndroidUtilSparseArray = new SparseArray();
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  
  private void A()
  {
    bmbx.b("AEEditorImageEditFragment", "showImages");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = new AEEditorImagePagerAdapter(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_d_of_type_AndroidUtilSparseArray, new bmij(this));
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
  
  private void B()
  {
    if (!TextUtils.isEmpty(d()))
    {
      bmbx.b("AEEditorImageEditFragment", "psKey not empty.");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    bmik localbmik = new bmik(this);
    localTicketManager.getPskey((String)localObject, 16L, new String[] { "shadowai.qq.com" }, localbmik);
  }
  
  private void C()
  {
    bmbx.b("AEEditorImageEditFragment", "initTAVCutSession");
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = new TAVCutImageSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setMinIntermediateRenderSize(this.jdField_a_of_type_Bmmd.a());
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Bmmd.b());
    localSessionConfig.setMaxImageDecodeSize(this.jdField_a_of_type_Bmmd.c());
    Object localObject = new StickerEditViewIconConfig();
    ((StickerEditViewIconConfig)localObject).setDeleteIconResId(2130837746);
    ((StickerEditViewIconConfig)localObject).setEditIconResId(2130837745);
    ((StickerEditViewIconConfig)localObject).setZoomIconResId(2130837747);
    localSessionConfig.setStickerEditViewIconConfig((StickerEditViewIconConfig)localObject);
    localObject = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      ((List)localObject).add(((bmde)this.jdField_b_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    localSessionConfig.setImageInitCropConfigs((List)localObject);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setImagePaths(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setStickerOperationCallback(new bmil(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.init(getActivity());
  }
  
  private void D()
  {
    if ((!this.e) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.g) && (this.f))
    {
      this.e = true;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void E()
  {
    AEEditorApplyAllLoadingView localAEEditorApplyAllLoadingView = new AEEditorApplyAllLoadingView(getActivity());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localAEEditorApplyAllLoadingView);
  }
  
  private void F()
  {
    int i = 0;
    boolean bool = bmbk.a().a("ae_editor_tool_bar_red_dot_text", false, 0);
    if (!bool)
    {
      bmbk.a().a("ae_editor_tool_bar_red_dot_text", true, 0);
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b("text");
    }
    bmbj localbmbj = bmbg.a().a();
    if (bool) {}
    for (;;)
    {
      localbmbj.i = i;
      bmbc.a().j();
      return;
      i = 1;
    }
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
      Size localSize = Util.constrainMaxSize((Size)localObject, this.jdField_a_of_type_Bmmd.c());
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
    AEImageStylizeReqData.ImageStylizeResponse localImageStylizeResponse = new AEImageStylizeReqData.ImageStylizeResponse();
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
          bmbx.b("AEEditorImageEditFragment", "comics response: code=" + i + ", msg=" + localImageStylizeResponse.msg.get());
          bmbc.a().a(1000, paramLong + "", "lut_comics", i);
          if (!localImageStylizeResponse.imageRawData.has()) {
            break label222;
          }
          paramArrayOfByte = localImageStylizeResponse.imageRawData.get().toByteArray();
          paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramAEEditorFilterBean = bmcz.d + File.separator + paramInt + "_" + paramAEEditorFilterBean.getEffectId() + ".jpg";
          com.tencent.qapmsdk.common.util.FileUtil.createFile(paramAEEditorFilterBean);
          BitmapUtil.saveBitmap(paramArrayOfByte, 100, paramAEEditorFilterBean);
          BitmapUtils.recycle(paramArrayOfByte);
          return paramAEEditorFilterBean;
        }
        catch (Exception paramArrayOfByte)
        {
          bmbx.d("AEEditorImageEditFragment", paramArrayOfByte.toString());
        }
        paramArrayOfByte = paramArrayOfByte;
        paramArrayOfByte.printStackTrace();
      }
    }
    label222:
    return "";
  }
  
  @Nullable
  private ArrayList<String> a(@Nullable bmgn parambmgn, int paramInt)
  {
    if ((parambmgn == null) || (CollectionUtils.isEmpty(parambmgn.jdField_a_of_type_JavaUtilList)) || (paramInt < 0) || (parambmgn.jdField_a_of_type_JavaUtilList.size() <= paramInt)) {}
    do
    {
      return null;
      parambmgn = (bmgu)new LinkedList(parambmgn.jdField_a_of_type_JavaUtilList).get(paramInt);
    } while ((parambmgn == null) || (CollectionUtils.isEmpty(parambmgn.jdField_a_of_type_JavaUtilList)));
    Object localObject = new LinkedList(parambmgn.jdField_a_of_type_JavaUtilList);
    if ((((List)localObject).size() > 0) && (((List)localObject).get(0) != null)) {}
    for (parambmgn = ((YoutuResultItem)((List)localObject).get(0)).Label;; parambmgn = null)
    {
      if ((((List)localObject).size() > 1) && (((List)localObject).get(1) != null)) {}
      for (localObject = ((YoutuResultItem)((List)localObject).get(1)).Label;; localObject = null)
      {
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(parambmgn)) {
          localArrayList.add(parambmgn);
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
      LocalMediaInfo localLocalMediaInfo = bmns.a(str);
      Object localObject1 = ((MediaClipModel)((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(i)).getMediaResourceModel().getVideos().get(0)).getResource().getPath();
      Object localObject2 = BitmapUtil.getImageSize((String)localObject1);
      localLocalMediaInfo.mediaOriginHeight = ((Size)localObject2).getHeight();
      localLocalMediaInfo.mediaOriginWidth = ((Size)localObject2).getWidth();
      localLocalMediaInfo.mediaOriginSize = com.tencent.mobileqq.filemanager.util.FileUtil.getFileSize((String)localObject1);
      bmbc.a().b(localLocalMediaInfo);
      localLocalMediaInfo = bmns.a(localLocalMediaInfo, getArguments().getString("material_id"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.jdField_a_of_type_Bmkz.b(i));
      localObject1 = a(this.jdField_a_of_type_JavaUtilHashMap, str);
      int j = paramArrayList.indexOf(str);
      localObject2 = a(this.jdField_a_of_type_Bmgn, j);
      if ((localObject1 != null) && (!CollectionUtils.isEmpty((Collection)localObject1))) {}
      for (localLocalMediaInfo.aiTextLabel = ((ArrayList)localObject1);; localLocalMediaInfo.aiTextLabel = ((ArrayList)localObject2)) {
        do
        {
          localHashMap.put(str, localLocalMediaInfo);
          i += 1;
          break;
        } while ((localObject2 == null) || (CollectionUtils.isEmpty((Collection)localObject2)));
      }
    }
    return localHashMap;
  }
  
  private void a(int paramInt)
  {
    Object localObject = bmnr.a((List)this.jdField_c_of_type_AndroidUtilSparseArray.get(paramInt), 3);
    this.jdField_a_of_type_Bmlb.a((List)localObject);
    localObject = (String)this.jdField_d_of_type_AndroidUtilSparseArray.get(paramInt);
    this.jdField_a_of_type_Bmlb.a((String)localObject);
    this.jdField_a_of_type_Bmlb.notifyDataSetChanged();
    AECompoundButton localAECompoundButton = this.jdField_a_of_type_DovComQqImAeViewAECompoundButton;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (paramInt = 2130837740;; paramInt = 2130837741)
    {
      localAECompoundButton.setForegroundResource(paramInt);
      return;
    }
  }
  
  private void a(int paramInt1, bmgo parambmgo, int paramInt2, AEEditorFilterBean paramAEEditorFilterBean)
  {
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.15(this, paramInt2, paramInt1, parambmgo, paramAEEditorFilterBean));
  }
  
  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2, AEEditorFilterBean paramAEEditorFilterBean)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new bmhx(this, paramInt1, paramAEEditorFilterBean, paramInt2);
    localHttpNetReq.mReqUrl = "https://api.shadowai.qq.com/trpc.mobile_qq_http.mobile_qq_http_cgi.MobileQQHttpCgi/ImageStylize";
    localHttpNetReq.mHttpMethod = 1;
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    localHttpNetReq.mSendData = a(paramBitmap, paramAEEditorFilterBean);
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mReqProperties.put("Content-Type", "application/proto; charset=UTF-8");
    localHttpNetReq.mReqProperties.put("Accept", "application/proto");
    paramAEEditorFilterBean = BaseApplicationImpl.getApplication().getRuntime();
    if (paramAEEditorFilterBean == null)
    {
      QLog.e("AEEditorImageEditFragment", 1, "app is null");
      return;
    }
    paramBitmap = (TicketManager)paramAEEditorFilterBean.getManager(2);
    paramAEEditorFilterBean = paramAEEditorFilterBean.getAccount();
    String str = paramBitmap.getSkey(paramAEEditorFilterBean);
    paramBitmap = paramBitmap.getPskey(paramAEEditorFilterBean, "shadowai.qq.com");
    if (!TextUtils.isEmpty(paramBitmap)) {
      localHttpNetReq.mReqProperties.put("Cookie", "uin=" + paramAEEditorFilterBean + ";pskey=" + paramBitmap);
    }
    for (;;)
    {
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      getActivity().getAppInterface().getNetEngine(0).sendReq(localHttpNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      return;
      B();
      localHttpNetReq.mReqProperties.put("Cookie", "uin=" + paramAEEditorFilterBean + ";skey=" + str);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(View paramView)
  {
    bmbx.b("AEEditorImageEditFragment", "initViews");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager = ((AEEditorImageViewPager)paramView.findViewById(2131380800));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator = ((NumberIndicator)paramView.findViewById(2131371970));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366746));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setOnPageChangeListener(this);
    GestureDetector localGestureDetector = new GestureDetector(paramView.getContext(), new bmib(this));
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(new bmif(this));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setOnTouchListener(new bmig(this, localGestureDetector));
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)paramView.findViewById(2131363842));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376747));
    paramView = new LinearLayoutManager(getActivity(), 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Bmlb = new bmlb();
    this.jdField_a_of_type_Bmlb.a(new bmih(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bmlb);
    boolean bool = bmbk.a().a("ae_editor_tool_bar_red_dot_frame", false, 0);
    if (!bool) {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.addView(LayoutInflater.from(getActivity()).inflate(2131558562, this.jdField_a_of_type_DovComQqImAeViewAECompoundButton, false));
    }
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundResource(2130837740);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(new bmii(this, bool));
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
    bmbx.d("AEEditorImageEditFragment", "[onGoNext], exportParams: " + localStringBuilder.toString());
  }
  
  private void a(List<ImageMainColorData> paramList)
  {
    if (CollectionUtil.isEmptyList(paramList)) {
      return;
    }
    Collections.sort(paramList, new bmhv(this));
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
    bmbx.b("AEEditorImageEditFragment", "before: " + System.currentTimeMillis() + ", uploadMaxSize=" + i + ", src bitmap size=[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + "]");
    Object localObject1 = a(paramBitmap, i);
    BitmapUtils.recycle(paramBitmap);
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
    bmbx.b("AEEditorImageEditFragment", "after: " + System.currentTimeMillis() + ", scaled bitmap size=[" + ((Bitmap)localObject1).getWidth() + ", " + ((Bitmap)localObject1).getHeight() + "]");
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    paramBitmap = new AEImageStylizeReqData.ImageStylizeRequest();
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
          localObject2 = new AEImageStylizeReqData.FaceInfo();
          ((AEImageStylizeReqData.FaceInfo)localObject2).setHasFlag(true);
          i = 0;
          while (i < ((List)localObject1).size())
          {
            ((AEImageStylizeReqData.FaceInfo)localObject2).pos.add(Float.valueOf(((PointF)((List)localObject1).get(i)).x));
            ((AEImageStylizeReqData.FaceInfo)localObject2).pos.add(Float.valueOf(((PointF)((List)localObject1).get(i)).y));
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
    ThreadManager.getFileThreadHandler().post(new AEEditorImageEditFragment.10(this, paramInt));
  }
  
  private int c()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  private void c(int paramInt)
  {
    bmbx.b("AEEditorImageEditFragment", "updateImageFilterByIndex: " + paramInt);
    if ((this.jdField_a_of_type_Bmkz.b(paramInt) == 0) && (this.jdField_a_of_type_Bmkz.a(paramInt) == 0))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.render(paramInt);
      return;
    }
    if (this.jdField_a_of_type_Bmkz.b(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModelForAI(paramInt, this.jdField_a_of_type_Bmkz.a(paramInt).b(), this.jdField_a_of_type_Bmkz.a(paramInt).a(), this.jdField_a_of_type_Bmkz.a(paramInt).a(), (int)(this.jdField_a_of_type_Bmkz.a(paramInt).b() * 100.0F), this.jdField_a_of_type_Bmkz.a(paramInt).c());
      return;
    }
    if (this.jdField_a_of_type_Bmkz.c(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, this.jdField_a_of_type_Bmkz.a(paramInt).a());
      return;
    }
    d(paramInt);
  }
  
  private int d()
  {
    return this.jdField_a_of_type_Bmmd.d();
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
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel == null) || (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a() == null)) {
      bmbx.d("AEEditorImageEditFragment", "filter list null.");
    }
    int i;
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      i = this.jdField_a_of_type_Bmkz.a(paramInt);
    } while (i >= ((List)localObject1).size());
    Object localObject2 = (AEEditorFilterBean)((List)localObject1).get(i);
    float f1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getGlowStrength();
    Object localObject1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getAdjustParams();
    localObject2 = bmkn.a().c((AEEditorFilterBean)localObject2);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModel(paramInt, this.jdField_a_of_type_Bmkz.a(paramInt), this.jdField_a_of_type_Bmkz.a(paramInt), f1, (Map)localObject1, (String)localObject2);
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel == null) || (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a() == null)) {
      bmbx.d("AEEditorImageEditFragment", "filter list null.");
    }
    int i;
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      i = this.jdField_a_of_type_Bmkz.a(paramInt);
    } while (i >= ((List)localObject1).size());
    Object localObject2 = (AEEditorFilterBean)((List)localObject1).get(i);
    float f1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getGlowStrength();
    Object localObject1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getAdjustParams();
    localObject2 = bmkn.a().c((AEEditorFilterBean)localObject2);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAllAeKitModelWithOutRender(this.jdField_a_of_type_Bmkz.a(paramInt), this.jdField_a_of_type_Bmkz.a(paramInt), f1, (Map)localObject1, (String)localObject2);
  }
  
  private void f(int paramInt)
  {
    if (paramInt >= 1) {
      c(paramInt - 1);
    }
    if (paramInt < c() - 1) {
      c(paramInt + 1);
    }
  }
  
  private void g(int paramInt)
  {
    bmbx.a("AEEditorImageEditFragment", "update all data.");
    if (this.jdField_a_of_type_Bmkz.b(paramInt))
    {
      int i = 0;
      if (i < c())
      {
        if (paramInt == i) {}
        for (;;)
        {
          i += 1;
          break;
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitNodeForAIWithoutRender(i, this.jdField_a_of_type_Bmkz.a(i).b(), this.jdField_a_of_type_Bmkz.a(i).a(), this.jdField_a_of_type_Bmkz.a(i).a(), (int)(this.jdField_a_of_type_Bmkz.a(i).b() * 100.0F), this.jdField_a_of_type_Bmkz.a(i).c());
        }
      }
    }
    else
    {
      if (!this.jdField_a_of_type_Bmkz.c(paramInt)) {
        break label124;
      }
    }
    return;
    label124:
    e(paramInt);
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
  
  private void y()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.startAnimation(localAlphaAnimation);
  }
  
  private void z()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.startAnimation(localAlphaAnimation);
  }
  
  public int a()
  {
    return 2131558548;
  }
  
  protected bmkl a()
  {
    return this;
  }
  
  protected bmkt a()
  {
    return new bmie(this);
  }
  
  protected bmna a()
  {
    return new bmia(this);
  }
  
  protected bmng a()
  {
    return this;
  }
  
  protected TAVCutSession a()
  {
    return this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  }
  
  public String a()
  {
    return "AEEditorImageEdit";
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setEffectStrength(this.jdField_b_of_type_Int, paramFloat);
    this.jdField_a_of_type_Bmkz.a(this.jdField_b_of_type_Int, paramFloat);
    this.jdField_a_of_type_Bmkz.a(this.jdField_b_of_type_Int, paramInt, paramFloat);
    bmbg.a().a().b.put(Integer.valueOf(this.jdField_b_of_type_Int), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    n();
    String str1 = bmkn.a().a(paramAEEditorFilterBean);
    float f1 = paramAEEditorFilterBean.getEffectExtendBean().getDefaultEffectAlpha();
    if (c(paramInt))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
      if (!a(paramInt)) {
        break label216;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(true);
    }
    for (;;)
    {
      float f2 = this.jdField_a_of_type_Bmkz.a(this.jdField_b_of_type_Int, paramInt, f1);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f2);
      this.jdField_a_of_type_Bmkz.a(this.jdField_b_of_type_Int, str1, f2, paramInt);
      this.jdField_a_of_type_Bmkz.a(this.jdField_b_of_type_Int, paramAEEditorFilterBean.getEffectId());
      float f3 = paramAEEditorFilterBean.getEffectExtendBean().getGlowStrength();
      Map localMap = paramAEEditorFilterBean.getEffectExtendBean().getAdjustParams();
      String str2 = bmkn.a().c(paramAEEditorFilterBean);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModel(this.jdField_b_of_type_Int, f2, str1, f3, localMap, str2);
      bmbg.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_b_of_type_Int), paramAEEditorFilterBean.getEffectId());
      bmbg.a().a().b.put(Integer.valueOf(this.jdField_b_of_type_Int), Float.valueOf(f1));
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      break;
      label216:
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(false);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() == 0)
    {
      j();
      return true;
    }
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
    bmgo localbmgo = (bmgo)this.jdField_a_of_type_JavaUtilMap.get(a(i, paramAEEditorFilterBean));
    if (localbmgo == null)
    {
      if (!NetworkUtil.isNetworkAvailable())
      {
        QQToast.a(getActivity(), getActivity().getResources().getString(2131690739), 1).a();
        return false;
      }
      this.jdField_c_of_type_Boolean = false;
      l();
      FaceChangeUtils.runInGLThread(new AEEditorImageEditFragment.13(this, i, paramInt, paramAEEditorFilterBean), false, "GLThread-changeFaceSingle");
      return false;
    }
    a(i, localbmgo, paramInt, paramAEEditorFilterBean);
    return true;
  }
  
  protected int b()
  {
    return 0;
  }
  
  public String b()
  {
    return amtj.a(2131689705);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c()
  {
    bmbx.b("AEEditorImageEditFragment", "initImageInfos");
    Object localObject1 = new ArrayList();
    Object localObject2 = getArguments();
    if (((Bundle)localObject2).containsKey("AEEditorConstants_CLIPPED_PIC_INFOS")) {
      localObject1 = (List)((Bundle)localObject2).getSerializable("AEEditorConstants_CLIPPED_PIC_INFOS");
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EditorPicInfo)((Iterator)localObject1).next();
        CropConfig localCropConfig = new CropConfig((float)((EditorPicInfo)localObject2).x, (float)((EditorPicInfo)localObject2).y, (float)Math.min(((EditorPicInfo)localObject2).w, 1.0D), (float)((EditorPicInfo)localObject2).h);
        this.jdField_a_of_type_JavaUtilList.add(((EditorPicInfo)localObject2).picPath);
        this.jdField_b_of_type_JavaUtilList.add(new bmde(((EditorPicInfo)localObject2).picPath, (int)((EditorPicInfo)localObject2).originPicWidth, (int)((EditorPicInfo)localObject2).originPicHeight, localCropConfig));
      }
      bmbx.d("AEEditorImageEditFragment", "no image crop infos");
    }
    this.jdField_c_of_type_Int = d();
    this.jdField_a_of_type_Bmkz.a(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_d_of_type_Boolean = bmby.a();
  }
  
  protected void d()
  {
    bmfh.a().a();
  }
  
  protected void e()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
  }
  
  public boolean f()
  {
    Object localObject = this.jdField_a_of_type_Bmgf.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int));
    boolean bool;
    if ((localObject != null) && ((localObject instanceof bmgu)))
    {
      bmbx.b("AEEditorImageEditFragment", "onAIFilterRequest: has cache");
      bool = ((bmgu)localObject).jdField_a_of_type_Boolean;
      bmbx.b("AEEditorImageEditFragment", "onAIFilterRequest: needRequest=" + bool);
      if (!bool) {
        break label153;
      }
      k();
      localObject = new bmgt((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int), this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int);
      ((bmgt)localObject).a(this.jdField_a_of_type_Bmfk);
      bmfh.a().a(getActivity().getAppInterface(), getActivity(), (bmgg)localObject);
    }
    for (;;)
    {
      if (bool) {
        break label269;
      }
      return true;
      bool = true;
      break;
      label153:
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      if (a(1)) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(true);
      }
      this.jdField_a_of_type_Bmkz.a(this.jdField_b_of_type_Int, (bmgl)localObject);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModelForAI(this.jdField_b_of_type_Int, ((bmgl)localObject).b(), ((bmgl)localObject).a(), ((bmgl)localObject).a(), (int)(((bmgl)localObject).b() * 100.0F), ((bmgl)localObject).c());
      a(new String[] { "智能滤镜label", ((bmgl)localObject).a(), "智能滤镜errCode", "0" });
    }
    label269:
    return false;
  }
  
  public void g()
  {
    bmbx.b("AEEditorImageEditFragment", "exportImages");
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession == null)
    {
      bmbx.d("AEEditorImageEditFragment", "exportImages error: session is null");
      return;
    }
    if (!g())
    {
      QQToast.a(getActivity(), "图片不存在或被删除", 0).a();
      return;
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.20(this));
    Object localObject1 = bmda.jdField_c_of_type_JavaLangString;
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
        localObject2 = (String)localObject1 + File.separator + "output_" + i + "_" + System.currentTimeMillis() + "_" + bnub.a(((File)localObject2).getName()) + ".jpg";
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
    ((ImageExportConfig)localObject1).setMinIntermediateRenderSize(this.jdField_a_of_type_Bmmd.a());
    ((ImageExportConfig)localObject1).setMaxIntermediateRenderSize(d());
    ((ImageExportConfig)localObject1).setQuality(this.jdField_a_of_type_Bmmd.e());
    ((ImageExportConfig)localObject1).setOutputPath(this.jdField_b_of_type_JavaUtilArrayList);
    a((ImageExportConfig)localObject1);
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getExporter((ImageExportConfig)localObject1);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter.export(new bmid(this));
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
    if (this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.getVisibility() != 4) {
      this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(4);
    }
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(4);
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
  }
  
  public void j()
  {
    if (!c()) {
      return;
    }
    super.j();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(amtj.a(2131689705));
    if (this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.getVisibility() != 0) {
      this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
    }
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
    ThreadManager.getUIHandler().postDelayed(new AEEditorImageEditFragment.18(this), 200L);
  }
  
  protected void m()
  {
    this.f = true;
    D();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bmbx.b("AEEditorImageEditFragment", "onCreate");
    super.onCreate(paramBundle);
    B();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = new AEInterceptTouchFrameLayout(paramLayoutInflater.getContext());
    paramViewGroup.addView(paramLayoutInflater, -1, -1);
    paramViewGroup.setInterceptTouchEventHandler(new bmhu(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    bmbx.b("AEEditorImageEditFragment", "onDestroy");
    super.onDestroy();
    FileUtils.delete(bmcz.d, false);
  }
  
  public void onDestroyView()
  {
    bmbx.b("AEEditorImageEditFragment", "onDestroyView");
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null) {
      getActivity().getAppInterface().getNetEngine(0).cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = null;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = null;
    }
    this.jdField_a_of_type_Bmkz.b();
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
    bmbx.b("AEEditorImageEditFragment", "onPageSelected: " + paramInt);
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setImageInfo(this.jdField_b_of_type_Int, Md5Utils.getMD5((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)));
    }
    a(paramInt);
    b(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setCurrentIndex(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setCurrentIndex(paramInt + 1);
    paramInt = this.jdField_a_of_type_Bmkz.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(paramInt);
    AEEditorFilterControlPanel localAEEditorFilterControlPanel;
    if ((this.jdField_a_of_type_Bmkz.a(this.jdField_b_of_type_Int)) || (this.jdField_a_of_type_Bmkz.b(this.jdField_b_of_type_Int)) || (this.jdField_a_of_type_Bmkz.c(this.jdField_b_of_type_Int)))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      if (!a(paramInt)) {
        break label256;
      }
      localAEEditorFilterControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel;
      if (this.jdField_a_of_type_Bmkz.c(this.jdField_b_of_type_Int)) {
        break label251;
      }
    }
    label251:
    for (boolean bool = true;; bool = false)
    {
      localAEEditorFilterControlPanel.a(bool);
      return;
      if (c(paramInt))
      {
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(this.jdField_a_of_type_Bmkz.a(this.jdField_b_of_type_Int));
        break;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      break;
    }
    label256:
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bmbx.b("AEEditorImageEditFragment", "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    bmbx.b("AEEditorImageEditFragment", "init");
    this.jdField_a_of_type_Bfum = new bfum(Looper.getMainLooper(), this);
    C();
    this.jdField_a_of_type_Bmkz.b();
    a(paramView);
    A();
    b(0);
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (e())) {
      if (bmkn.a().a())
      {
        bmbx.b("AEEditorImageEditFragment", "single image + first time : aifilter auto request");
        f();
        o();
        bmbc.a().w();
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((bmkn.a().b()) && (i == 0)) {
        r();
      }
      a(new String[] { "设备级别", bmmf.a(), "图片最小预览尺寸", String.valueOf(this.jdField_a_of_type_Bmmd.a()), "图片最大预览尺寸", String.valueOf(this.jdField_a_of_type_Bmmd.b()), "图片导出质量", this.jdField_a_of_type_Bmmd.e() + "%", "图片最大导出尺寸", String.valueOf(this.jdField_c_of_type_Int) });
      return;
      bmbx.d("AEEditorImageEditFragment", "single image + first time : aifilter res not ready, do not request");
    }
  }
  
  protected void r()
  {
    bmgq localbmgq = new bmgq(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
    localbmgq.a(new bmhw(this));
    bmfh.a().a(getActivity().getAppInterface(), getActivity(), localbmgq);
  }
  
  public void s()
  {
    int j = 0;
    bmbx.b("AEEditorImageEditFragment", "onApplyAll current position = " + this.jdField_b_of_type_Int);
    bmbc.a().l();
    Object localObject1;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a())
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = this.jdField_a_of_type_Bmgf.a((String)localObject2);
          if ((localObject2 != null) && ((localObject2 instanceof bmgu)))
          {
            bmbx.b("AEEditorImageEditFragment", "onAIFilterRequest: has cache");
            if (!((bmgl)localObject2).jdField_a_of_type_Boolean) {
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
        k();
        localObject1 = new bmgm(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int, this.jdField_a_of_type_Bmgf.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)));
        ((bmgm)localObject1).a(this.jdField_b_of_type_Bmfk);
        bmfh.a().a(getActivity().getAppInterface(), getActivity(), (bmgg)localObject1);
      }
      do
      {
        return;
        i = 1;
        break;
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
        localObject1 = new StringBuilder();
        i = j;
        while (i < c())
        {
          localObject2 = (bmgu)this.jdField_a_of_type_Bmgf.a((String)this.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_a_of_type_Bmkz.a(i, (bmgl)localObject2);
          ((StringBuilder)localObject1).append(((bmgu)localObject2).a() + "|");
          i += 1;
        }
        a("智能滤镜label", ((StringBuilder)localObject1).toString());
        c(this.jdField_b_of_type_Int);
        f(this.jdField_b_of_type_Int);
        g(this.jdField_b_of_type_Int);
        E();
        return;
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b())
        {
          this.jdField_a_of_type_Bmkz.a();
          f(this.jdField_b_of_type_Int);
          g(this.jdField_b_of_type_Int);
          E();
          return;
        }
      } while (d());
      this.jdField_a_of_type_Bmkz.b(this.jdField_b_of_type_Int);
      f(this.jdField_b_of_type_Int);
      g(this.jdField_b_of_type_Int);
      E();
      return;
      i = 0;
    }
  }
  
  public void t()
  {
    n();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
    if (a(0)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.clearAEKitModel(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bmkz.c(this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.getVisibility() != 0) {
        this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
      }
      bmbg.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_b_of_type_Int), "effect_blank");
      bmbg.a().a().b.put(Integer.valueOf(this.jdField_b_of_type_Int), Float.valueOf(-1.0F));
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(false);
    }
  }
  
  public void u()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(4);
  }
  
  public void v()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
  }
  
  public void w() {}
  
  public void x()
  {
    i();
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    }
    F();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment
 * JD-Core Version:    0.7.0.1
 */