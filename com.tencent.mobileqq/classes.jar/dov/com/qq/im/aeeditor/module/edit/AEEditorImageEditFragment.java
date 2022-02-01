package dov.com.qq.im.aeeditor.module.edit;

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
import anzj;
import auog;
import beum;
import beuo;
import bevn;
import bhlj;
import bhmi;
import bhnv;
import boyv;
import bozr;
import bozv;
import bozy;
import bozz;
import bpam;
import bpan;
import bpbp;
import bpbq;
import bpbu;
import bpdx;
import bpdz;
import bpet;
import bpeu;
import bpez;
import bpfa;
import bpfc;
import bpfd;
import bpfe;
import bpge;
import bpgf;
import bpgg;
import bpgh;
import bpgi;
import bpgj;
import bpgl;
import bpgm;
import bpgn;
import bpgo;
import bpgp;
import bpgq;
import bpgr;
import bpgs;
import bpgt;
import bpgu;
import bphp;
import bphq;
import bphr;
import bphx;
import bpid;
import bpif;
import bpjh;
import bpji;
import bpjj;
import bpke;
import bpkk;
import bpkl;
import bpkv;
import bpkw;
import bqzz;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qapmsdk.common.util.FileUtil;
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
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class AEEditorImageEditFragment
  extends AEEditorCommonEditFragment
  implements Handler.Callback, ViewPager.OnPageChangeListener, bphq, bpkl
{
  private static final String jdField_c_of_type_JavaLangString = AEEditorImageEditFragment.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private beum jdField_a_of_type_Beum;
  bpdz jdField_a_of_type_Bpdz = new bpgh(this);
  private bpet jdField_a_of_type_Bpet = new bpet();
  private bpid jdField_a_of_type_Bpid = new bpid();
  private bpif jdField_a_of_type_Bpif;
  private bpjh jdField_a_of_type_Bpjh = bpji.a();
  private ImageExporter jdField_a_of_type_ComTencentTavcutExporterImageExporter;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private AEEditorImagePagerAdapter jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter;
  private AEEditorImageViewPager jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager;
  private NumberIndicator jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, bpfc> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private SparseArray<List<ImageMainColorData>> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  bpdz jdField_b_of_type_Bpdz = new bpgi(this);
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  private List<bpbu> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private SparseArray<List<ImageMainColorData>> jdField_c_of_type_AndroidUtilSparseArray = new SparseArray();
  private boolean jdField_c_of_type_Boolean;
  private SparseArray<String> jdField_d_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  
  private void A()
  {
    bpam.b(jdField_c_of_type_JavaLangString, "initTAVCutSession");
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = new TAVCutImageSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setMinIntermediateRenderSize(this.jdField_a_of_type_Bpjh.a());
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Bpjh.b());
    localSessionConfig.setMaxImageDecodeSize(this.jdField_a_of_type_Bpjh.c());
    Object localObject = new StickerEditViewIconConfig();
    ((StickerEditViewIconConfig)localObject).setDeleteIconResId(2130837735);
    ((StickerEditViewIconConfig)localObject).setEditIconResId(2130837734);
    ((StickerEditViewIconConfig)localObject).setZoomIconResId(2130837736);
    localSessionConfig.setStickerEditViewIconConfig((StickerEditViewIconConfig)localObject);
    localObject = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      ((List)localObject).add(((bpbu)this.jdField_b_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    localSessionConfig.setImageInitCropConfigs((List)localObject);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setImagePaths(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setStickerOperationCallback(new bpgu(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.init(getActivity());
  }
  
  private void B()
  {
    if ((!this.e) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.g) && (this.f))
    {
      this.e = true;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  private void C()
  {
    AEEditorApplyAllLoadingView localAEEditorApplyAllLoadingView = new AEEditorApplyAllLoadingView(getActivity());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localAEEditorApplyAllLoadingView);
  }
  
  private void D()
  {
    int i = 0;
    boolean bool = bozz.a().a("ae_editor_tool_bar_red_dot_text", false, 0);
    if (!bool)
    {
      bozz.a().a("ae_editor_tool_bar_red_dot_text", true, 0);
      this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b("text");
    }
    bozy localbozy = bozv.a().a();
    if (bool) {}
    for (;;)
    {
      localbozy.h = i;
      bozr.a().j();
      return;
      i = 1;
    }
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = 1.0F;
    if (j > i) {
      if (j > 736) {
        f1 = 736.0F / j;
      }
    }
    for (;;)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f1);
      return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      if (i > 736) {
        f1 = 736.0F / i;
      }
    }
  }
  
  private Bitmap a(String paramString, CropConfig paramCropConfig)
  {
    k = 1;
    j = 0;
    try
    {
      localObject = BitmapUtil.getImageSize(paramString, false);
      Size localSize = Util.constrainMaxSize((Size)localObject, this.jdField_a_of_type_Bpjh.c());
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
          bpam.b(jdField_c_of_type_JavaLangString, "comics response: code=" + i + ", msg=" + localImageStylizeResponse.msg.get());
          bozr.a().a(1000, paramLong + "", "lut_comics", i);
          if (!localImageStylizeResponse.imageRawData.has()) {
            break label224;
          }
          paramArrayOfByte = localImageStylizeResponse.imageRawData.get().toByteArray();
          paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramAEEditorFilterBean = bpbp.jdField_d_of_type_JavaLangString + File.separator + paramInt + "_" + paramAEEditorFilterBean.getEffectId() + ".jpg";
          FileUtil.createFile(paramAEEditorFilterBean);
          BitmapUtil.saveBitmap(paramArrayOfByte, 100, paramAEEditorFilterBean);
          BitmapUtils.recycle(paramArrayOfByte);
          return paramAEEditorFilterBean;
        }
        catch (Exception paramArrayOfByte)
        {
          bpam.d(jdField_c_of_type_JavaLangString, paramArrayOfByte.toString());
        }
        paramArrayOfByte = paramArrayOfByte;
        paramArrayOfByte.printStackTrace();
      }
    }
    label224:
    return "";
  }
  
  private HashMap<String, LocalMediaInfo> a(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      String str1 = (String)paramArrayList.next();
      LocalMediaInfo localLocalMediaInfo = bpkw.a(str1);
      String str2 = ((MediaClipModel)((MediaModel)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getMediaModels().get(i)).getMediaResourceModel().getVideos().get(0)).getResource().getPath();
      Size localSize = BitmapUtil.getImageSize(str2);
      localLocalMediaInfo.mediaOriginHeight = localSize.getHeight();
      localLocalMediaInfo.mediaOriginWidth = localSize.getWidth();
      localLocalMediaInfo.mediaOriginSize = auog.a(str2);
      bozr.a().b(localLocalMediaInfo);
      localLocalMediaInfo = bpkw.a(localLocalMediaInfo, getArguments().getString("material_id"), getArguments().getString("key_camera_material_name"), getArguments().getInt("ae_editor_is_show_take_same"), this.jdField_a_of_type_Bpid.b(i));
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localLocalMediaInfo.aiTextLabel = ((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(str1));
      }
      localHashMap.put(str1, localLocalMediaInfo);
      i += 1;
    }
    return localHashMap;
  }
  
  private void a(int paramInt)
  {
    Object localObject = bpkv.a((List)this.jdField_c_of_type_AndroidUtilSparseArray.get(paramInt), 3);
    this.jdField_a_of_type_Bpif.a((List)localObject);
    localObject = (String)this.jdField_d_of_type_AndroidUtilSparseArray.get(paramInt);
    this.jdField_a_of_type_Bpif.a((String)localObject);
    this.jdField_a_of_type_Bpif.notifyDataSetChanged();
    AECompoundButton localAECompoundButton = this.jdField_a_of_type_DovComQqImAeViewAECompoundButton;
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    for (paramInt = 2130837729;; paramInt = 2130837730)
    {
      localAECompoundButton.setForegroundResource(paramInt);
      return;
    }
  }
  
  private void a(int paramInt1, bpfc parambpfc, int paramInt2, AEEditorFilterBean paramAEEditorFilterBean)
  {
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.14(this, paramInt2, paramInt1, parambpfc, paramAEEditorFilterBean));
  }
  
  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2, AEEditorFilterBean paramAEEditorFilterBean)
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = new bpgg(this, paramInt1, paramAEEditorFilterBean, paramInt2);
    localbeum.jdField_a_of_type_JavaLangString = "https://api.shadowai.qq.com/trpc.mobile_qq_http.mobile_qq_http_cgi.MobileQQHttpCgi/ImageStylize";
    localbeum.jdField_a_of_type_Int = 1;
    localbeum.c = 30000L;
    localbeum.jdField_a_of_type_ArrayOfByte = a(paramBitmap, paramAEEditorFilterBean);
    localbeum.d = 0;
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Content-Type", "application/proto; charset=UTF-8");
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Accept", "application/proto");
    paramAEEditorFilterBean = BaseApplicationImpl.getApplication().getRuntime();
    if (paramAEEditorFilterBean == null)
    {
      QLog.e(jdField_c_of_type_JavaLangString, 1, "app is null");
      return;
    }
    paramBitmap = (TicketManager)paramAEEditorFilterBean.getManager(2);
    paramAEEditorFilterBean = paramAEEditorFilterBean.getAccount();
    String str = paramBitmap.getSkey(paramAEEditorFilterBean);
    paramBitmap = paramBitmap.getPskey(paramAEEditorFilterBean, "shadowai.qq.com");
    if (!TextUtils.isEmpty(paramBitmap)) {
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "uin=" + paramAEEditorFilterBean + ";pskey=" + paramBitmap);
    }
    for (;;)
    {
      localbeum.jdField_b_of_type_Int = bhnv.a(bevn.a().a());
      getActivity().getAppInterface().getNetEngine(0).a(localbeum);
      this.jdField_a_of_type_Beum = localbeum;
      return;
      z();
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "uin=" + paramAEEditorFilterBean + ";skey=" + str);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(View paramView)
  {
    bpam.b(jdField_c_of_type_JavaLangString, "initViews");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager = ((AEEditorImageViewPager)paramView.findViewById(2131381075));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator = ((NumberIndicator)paramView.findViewById(2131372005));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366716));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setOnPageChangeListener(this);
    GestureDetector localGestureDetector = new GestureDetector(paramView.getContext(), new bpgl(this));
    this.jdField_b_of_type_AndroidWidgetFrameLayout.setOnClickListener(new bpgo(this));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setOnTouchListener(new bpgp(this, localGestureDetector));
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)paramView.findViewById(2131363815));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376994));
    paramView = new LinearLayoutManager(getActivity(), 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Bpif = new bpif();
    this.jdField_a_of_type_Bpif.a(new bpgq(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bpif);
    boolean bool = bozz.a().a("ae_editor_tool_bar_red_dot_frame", false, 0);
    if (!bool) {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.addView(LayoutInflater.from(getActivity()).inflate(2131558560, this.jdField_a_of_type_DovComQqImAeViewAECompoundButton, false));
    }
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundResource(2130837729);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(new bpgr(this, bool));
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
    bpam.d(jdField_c_of_type_JavaLangString, "[onGoNext], exportParams: " + localStringBuilder.toString());
  }
  
  private void a(List<ImageMainColorData> paramList)
  {
    if (CollectionUtil.isEmptyList(paramList)) {
      return;
    }
    Collections.sort(paramList, new bpgf(this));
  }
  
  private static boolean a(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private byte[] a(Bitmap paramBitmap, AEEditorFilterBean paramAEEditorFilterBean)
  {
    boolean bool = false;
    Object localObject2 = new ByteArrayOutputStream();
    bpam.b(jdField_c_of_type_JavaLangString, "before: " + System.currentTimeMillis());
    Object localObject1 = a(paramBitmap);
    BitmapUtils.recycle(paramBitmap);
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
    bpam.b(jdField_c_of_type_JavaLangString, "after: " + System.currentTimeMillis());
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    paramBitmap = new AEImageStylizeReqData.ImageStylizeRequest();
    int j = paramAEEditorFilterBean.getEditorEffectItem().getStylizeType();
    int i = j;
    if (j == 0) {
      i = 1;
    }
    paramBitmap.stylizeType.set(i, true);
    paramBitmap.imgInfo.setHasFlag(true);
    paramBitmap.imgInfo.imgWidth.set(((Bitmap)localObject1).getWidth());
    paramBitmap.imgInfo.imgHeight.set(((Bitmap)localObject1).getHeight());
    paramBitmap.imgInfo.imageRawData.set(ByteStringMicro.copyFrom((byte[])localObject2), true);
    paramAEEditorFilterBean = boyv.b((Bitmap)localObject1);
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
    bpam.b(jdField_c_of_type_JavaLangString, "updateImageFilterByIndex: " + paramInt);
    if ((this.jdField_a_of_type_Bpid.b(paramInt) == 0) && (this.jdField_a_of_type_Bpid.a(paramInt) == 0))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.render(paramInt);
      return;
    }
    if (this.jdField_a_of_type_Bpid.b(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModelForAI(paramInt, this.jdField_a_of_type_Bpid.a(paramInt).b(), this.jdField_a_of_type_Bpid.a(paramInt).a(), this.jdField_a_of_type_Bpid.a(paramInt).a(), (int)(this.jdField_a_of_type_Bpid.a(paramInt).b() * 100.0F), this.jdField_a_of_type_Bpid.a(paramInt).c());
      return;
    }
    if (this.jdField_a_of_type_Bpid.c(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, this.jdField_a_of_type_Bpid.a(paramInt).a());
      return;
    }
    d(paramInt);
  }
  
  private int d()
  {
    return this.jdField_a_of_type_Bpjh.d();
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel == null) || (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a() == null)) {
      bpam.d(jdField_c_of_type_JavaLangString, "filter list null.");
    }
    int i;
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      i = this.jdField_a_of_type_Bpid.a(paramInt);
    } while (i >= ((List)localObject1).size());
    Object localObject2 = (AEEditorFilterBean)((List)localObject1).get(i);
    float f1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getGlowStrength();
    Object localObject1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getAdjustParams();
    localObject2 = bphr.a().c((AEEditorFilterBean)localObject2);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModel(paramInt, this.jdField_a_of_type_Bpid.a(paramInt), this.jdField_a_of_type_Bpid.a(paramInt), f1, (Map)localObject1, (String)localObject2);
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel == null) || (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a() == null)) {
      bpam.d(jdField_c_of_type_JavaLangString, "filter list null.");
    }
    int i;
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      i = this.jdField_a_of_type_Bpid.a(paramInt);
    } while (i >= ((List)localObject1).size());
    Object localObject2 = (AEEditorFilterBean)((List)localObject1).get(i);
    float f1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getGlowStrength();
    Object localObject1 = ((AEEditorFilterBean)localObject2).getEffectExtendBean().getAdjustParams();
    localObject2 = bphr.a().c((AEEditorFilterBean)localObject2);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAllAeKitModelWithOutRender(this.jdField_a_of_type_Bpid.a(paramInt), this.jdField_a_of_type_Bpid.a(paramInt), f1, (Map)localObject1, (String)localObject2);
  }
  
  private String f()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e(jdField_c_of_type_JavaLangString, 1, "app is null");
      return "";
    }
    String str = localAppRuntime.getAccount();
    return ((TicketManager)localAppRuntime.getManager(2)).getPskey(str, "shadowai.qq.com");
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
    bpam.a(jdField_c_of_type_JavaLangString, "update all data.");
    if (this.jdField_a_of_type_Bpid.b(paramInt))
    {
      int i = 0;
      if (i < c())
      {
        if (paramInt == i) {}
        for (;;)
        {
          i += 1;
          break;
          this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitNodeForAIWithoutRender(i, this.jdField_a_of_type_Bpid.a(i).b(), this.jdField_a_of_type_Bpid.a(i).a(), this.jdField_a_of_type_Bpid.a(i).a(), (int)(this.jdField_a_of_type_Bpid.a(i).b() * 100.0F), this.jdField_a_of_type_Bpid.a(i).c());
        }
      }
    }
    else
    {
      if (!this.jdField_a_of_type_Bpid.c(paramInt)) {
        break label125;
      }
    }
    return;
    label125:
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
  
  private void w()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.startAnimation(localAlphaAnimation);
  }
  
  private void x()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.startAnimation(localAlphaAnimation);
  }
  
  private void y()
  {
    bpam.b(jdField_c_of_type_JavaLangString, "showImages");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = new AEEditorImagePagerAdapter(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_d_of_type_AndroidUtilSparseArray, new bpgs(this));
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
  
  private void z()
  {
    if (!TextUtils.isEmpty(f()))
    {
      bpam.b(jdField_c_of_type_JavaLangString, "psKey not empty.");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    bpgt localbpgt = new bpgt(this);
    localTicketManager.getPskey((String)localObject, 16L, new String[] { "shadowai.qq.com" }, localbpgt);
  }
  
  public int a()
  {
    return 2131558549;
  }
  
  protected bphp a()
  {
    return this;
  }
  
  protected bphx a()
  {
    return new bpgn(this);
  }
  
  protected bpke a()
  {
    return new bpgj(this);
  }
  
  protected bpkk a()
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
    this.jdField_a_of_type_Bpid.a(this.jdField_b_of_type_Int, paramFloat);
    this.jdField_a_of_type_Bpid.a(this.jdField_b_of_type_Int, paramInt, paramFloat);
    bozv.a().a().b.put(Integer.valueOf(this.jdField_b_of_type_Int), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt, AEEditorFilterBean paramAEEditorFilterBean)
  {
    n();
    String str1 = bphr.a().a(paramAEEditorFilterBean);
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
      float f2 = this.jdField_a_of_type_Bpid.a(this.jdField_b_of_type_Int, paramInt, f1);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f2);
      this.jdField_a_of_type_Bpid.a(this.jdField_b_of_type_Int, str1, f2, paramInt);
      this.jdField_a_of_type_Bpid.a(this.jdField_b_of_type_Int, paramAEEditorFilterBean.getEffectId());
      float f3 = paramAEEditorFilterBean.getEffectExtendBean().getGlowStrength();
      Map localMap = paramAEEditorFilterBean.getEffectExtendBean().getAdjustParams();
      String str2 = bphr.a().c(paramAEEditorFilterBean);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModel(this.jdField_b_of_type_Int, f2, str1, f3, localMap, str2);
      bozv.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_b_of_type_Int), paramAEEditorFilterBean.getEffectId());
      bozv.a().a().b.put(Integer.valueOf(this.jdField_b_of_type_Int), Float.valueOf(f1));
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
    bpfc localbpfc = (bpfc)this.jdField_a_of_type_JavaUtilMap.get(a(i, paramAEEditorFilterBean));
    if (localbpfc == null)
    {
      if (!bhnv.a())
      {
        QQToast.a(getActivity(), getActivity().getResources().getString(2131690699), 1).a();
        return false;
      }
      this.jdField_c_of_type_Boolean = false;
      l();
      boyv.a(new AEEditorImageEditFragment.12(this, i, paramInt, paramAEEditorFilterBean), false, "GLThread-changeFaceSingle");
      return false;
    }
    a(i, localbpfc, paramInt, paramAEEditorFilterBean);
    return true;
  }
  
  protected int b()
  {
    return 0;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public String c()
  {
    return anzj.a(2131689695);
  }
  
  protected void c()
  {
    bpam.b(jdField_c_of_type_JavaLangString, "initImageInfos");
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
        CropConfig localCropConfig = new CropConfig((float)((EditorPicInfo)localObject2).x, (float)((EditorPicInfo)localObject2).y, (float)((EditorPicInfo)localObject2).w, (float)((EditorPicInfo)localObject2).h);
        this.jdField_a_of_type_JavaUtilList.add(((EditorPicInfo)localObject2).picPath);
        this.jdField_b_of_type_JavaUtilList.add(new bpbu(((EditorPicInfo)localObject2).picPath, (int)((EditorPicInfo)localObject2).originPicWidth, (int)((EditorPicInfo)localObject2).originPicHeight, localCropConfig));
      }
      bpam.d(jdField_c_of_type_JavaLangString, "no image crop infos");
    }
    this.jdField_c_of_type_Int = d();
    this.jdField_a_of_type_Bpid.a(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_d_of_type_Boolean = bpan.a();
  }
  
  protected void d()
  {
    bpdx.a().a();
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
    Object localObject = this.jdField_a_of_type_Bpet.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int));
    boolean bool;
    if ((localObject != null) && ((localObject instanceof bpfe)))
    {
      bpam.b(jdField_c_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool = ((bpfe)localObject).a;
      bpam.b(jdField_c_of_type_JavaLangString, "onAIFilterRequest: needRequest=" + bool);
      if (!bool) {
        break label155;
      }
      k();
      localObject = new bpfd((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int), this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int);
      ((bpfd)localObject).a(this.jdField_a_of_type_Bpdz);
      bpdx.a().a(getActivity().getAppInterface(), getActivity(), (bpeu)localObject);
    }
    for (;;)
    {
      if (bool) {
        break label271;
      }
      return true;
      bool = true;
      break;
      label155:
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      if (a(1)) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(true);
      }
      this.jdField_a_of_type_Bpid.a(this.jdField_b_of_type_Int, (bpez)localObject);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.resetAEKitModelForAI(this.jdField_b_of_type_Int, ((bpez)localObject).b(), ((bpez)localObject).a(), ((bpez)localObject).a(), (int)(((bpez)localObject).b() * 100.0F), ((bpez)localObject).c());
      a(new String[] { "智能滤镜label", ((bpez)localObject).a(), "智能滤镜errCode", "0" });
    }
    label271:
    return false;
  }
  
  public void g()
  {
    bpam.b(jdField_c_of_type_JavaLangString, "exportImages");
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession == null)
    {
      bpam.d(jdField_c_of_type_JavaLangString, "exportImages error: session is null");
      return;
    }
    if (!g())
    {
      QQToast.a(getActivity(), "图片不存在或被删除", 0).a();
      return;
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.19(this));
    Object localObject1 = bpbq.jdField_c_of_type_JavaLangString;
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
        localObject2 = (String)localObject1 + File.separator + "output_" + i + "_" + System.currentTimeMillis() + "_" + bqzz.a(((File)localObject2).getName()) + ".jpg";
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
    ((ImageExportConfig)localObject1).setMinIntermediateRenderSize(this.jdField_a_of_type_Bpjh.a());
    ((ImageExportConfig)localObject1).setMaxIntermediateRenderSize(d());
    ((ImageExportConfig)localObject1).setQuality(this.jdField_a_of_type_Bpjh.e());
    ((ImageExportConfig)localObject1).setOutputPath(this.jdField_b_of_type_JavaUtilArrayList);
    a((ImageExportConfig)localObject1);
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getExporter((ImageExportConfig)localObject1);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter.export(new bpgm(this));
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
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(anzj.a(2131689695));
    if (this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.getVisibility() != 0) {
      this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
    }
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
    ThreadManager.getUIHandler().postDelayed(new AEEditorImageEditFragment.17(this), 200L);
  }
  
  protected void m()
  {
    this.f = true;
    B();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bpam.b(jdField_c_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    z();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = new AEInterceptTouchFrameLayout(paramLayoutInflater.getContext());
    paramViewGroup.addView(paramLayoutInflater, -1, -1);
    paramViewGroup.setInterceptTouchEventHandler(new bpge(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    bpam.b(jdField_c_of_type_JavaLangString, "onDestroy");
    super.onDestroy();
    bhmi.a(bpbp.jdField_d_of_type_JavaLangString, false);
  }
  
  public void onDestroyView()
  {
    bpam.b(jdField_c_of_type_JavaLangString, "onDestroyView");
    super.onDestroyView();
    if (this.jdField_a_of_type_Beum != null) {
      getActivity().getAppInterface().getNetEngine(0).b(this.jdField_a_of_type_Beum);
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = null;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = null;
    }
    this.jdField_a_of_type_Bpid.b();
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
    bpam.b(jdField_c_of_type_JavaLangString, "onPageSelected: " + paramInt);
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setImageInfo(this.jdField_b_of_type_Int, Md5Utils.getMD5((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)));
    }
    a(paramInt);
    b(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setCurrentIndex(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setCurrentIndex(paramInt + 1);
    paramInt = this.jdField_a_of_type_Bpid.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(paramInt);
    AEEditorFilterControlPanel localAEEditorFilterControlPanel;
    if ((this.jdField_a_of_type_Bpid.a(this.jdField_b_of_type_Int)) || (this.jdField_a_of_type_Bpid.b(this.jdField_b_of_type_Int)) || (this.jdField_a_of_type_Bpid.c(this.jdField_b_of_type_Int)))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      if (!a(paramInt)) {
        break label257;
      }
      localAEEditorFilterControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel;
      if (this.jdField_a_of_type_Bpid.c(this.jdField_b_of_type_Int)) {
        break label252;
      }
    }
    label252:
    for (boolean bool = true;; bool = false)
    {
      localAEEditorFilterControlPanel.a(bool);
      return;
      if (c(paramInt))
      {
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(this.jdField_a_of_type_Bpid.a(this.jdField_b_of_type_Int));
        break;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      break;
    }
    label257:
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bpam.b(jdField_c_of_type_JavaLangString, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    bpam.b(jdField_c_of_type_JavaLangString, "init");
    this.jdField_a_of_type_Bhlj = new bhlj(Looper.getMainLooper(), this);
    A();
    this.jdField_a_of_type_Bpid.b();
    a(paramView);
    y();
    b(0);
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (e()))
    {
      if (!bphr.a().a()) {
        break label235;
      }
      bpam.b(jdField_c_of_type_JavaLangString, "single image + first time : aifilter auto request");
      f();
      o();
      bozr.a().x();
    }
    for (;;)
    {
      a(new String[] { "设备级别", bpjj.a(), "图片最小预览尺寸", String.valueOf(this.jdField_a_of_type_Bpjh.a()), "图片最大预览尺寸", String.valueOf(this.jdField_a_of_type_Bpjh.b()), "图片导出质量", this.jdField_a_of_type_Bpjh.e() + "%", "图片最大导出尺寸", String.valueOf(this.jdField_c_of_type_Int) });
      return;
      label235:
      bpam.d(jdField_c_of_type_JavaLangString, "single image + first time : aifilter res not ready, do not request");
    }
  }
  
  public void q()
  {
    int j = 0;
    bpam.b(jdField_c_of_type_JavaLangString, "onApplyAll current position = " + this.jdField_b_of_type_Int);
    bozr.a().m();
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
          localObject2 = this.jdField_a_of_type_Bpet.a((String)localObject2);
          if ((localObject2 != null) && ((localObject2 instanceof bpfe)))
          {
            bpam.b(jdField_c_of_type_JavaLangString, "onAIFilterRequest: has cache");
            if (!((bpez)localObject2).a) {
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
        localObject1 = new bpfa(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_b_of_type_Int, this.jdField_a_of_type_Bpet.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)));
        ((bpfa)localObject1).a(this.jdField_b_of_type_Bpdz);
        bpdx.a().a(getActivity().getAppInterface(), getActivity(), (bpeu)localObject1);
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
          localObject2 = (bpfe)this.jdField_a_of_type_Bpet.a((String)this.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_a_of_type_Bpid.a(i, (bpez)localObject2);
          ((StringBuilder)localObject1).append(((bpfe)localObject2).a() + "|");
          i += 1;
        }
        a("智能滤镜label", ((StringBuilder)localObject1).toString());
        c(this.jdField_b_of_type_Int);
        f(this.jdField_b_of_type_Int);
        g(this.jdField_b_of_type_Int);
        C();
        return;
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b())
        {
          this.jdField_a_of_type_Bpid.a();
          f(this.jdField_b_of_type_Int);
          g(this.jdField_b_of_type_Int);
          C();
          return;
        }
      } while (d());
      this.jdField_a_of_type_Bpid.b(this.jdField_b_of_type_Int);
      f(this.jdField_b_of_type_Int);
      g(this.jdField_b_of_type_Int);
      C();
      return;
      i = 0;
    }
  }
  
  public void r()
  {
    n();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
    if (a(0)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.clearAEKitModel(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bpid.c(this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.getVisibility() != 0) {
        this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
      }
      bozv.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_b_of_type_Int), "effect_blank");
      bozv.a().a().b.put(Integer.valueOf(this.jdField_b_of_type_Int), Float.valueOf(-1.0F));
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(false);
    }
  }
  
  public void s()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(4);
  }
  
  public void t()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
  }
  
  public void u() {}
  
  public void v()
  {
    i();
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
    }
    D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment
 * JD-Core Version:    0.7.0.1
 */