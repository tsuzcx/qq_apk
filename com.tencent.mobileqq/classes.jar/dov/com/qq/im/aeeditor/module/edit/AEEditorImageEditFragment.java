package dov.com.qq.im.aeeditor.module.edit;

import alud;
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
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import baub;
import baue;
import bavg;
import bdgf;
import bdhb;
import bdin;
import blhy;
import bliu;
import bliy;
import bljb;
import bljn;
import blkd;
import blke;
import blki;
import blkl;
import blkn;
import blld;
import blle;
import bllj;
import bllk;
import bllm;
import blln;
import bllo;
import blmr;
import blmt;
import blmu;
import blmv;
import blmw;
import blmx;
import blmy;
import blmz;
import blna;
import blnr;
import blns;
import blnt;
import blnz;
import bloe;
import blou;
import blov;
import blow;
import blpi;
import blpm;
import blpp;
import blpq;
import blpx;
import bnhb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
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
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.bean.Size;
import com.tencent.tavcut.exporter.ImageExportConfig;
import com.tencent.tavcut.exporter.ImageExporter;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.FaceInfo;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageInfo;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageStylizeRequest;
import dov.com.qq.im.ae.protobuf.AEImageStylizeReqData.ImageStylizeResponse;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.view.NumberIndicator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class AEEditorImageEditFragment
  extends AEEditorCommonEditFragment
  implements Handler.Callback, ViewPager.OnPageChangeListener, blns, blpq
{
  private static final String jdField_b_of_type_JavaLangString = AEEditorImageEditFragment.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SparseArray<bllm> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private baub jdField_a_of_type_Baub;
  blkn jdField_a_of_type_Blkn = new blmy(this);
  private blld jdField_a_of_type_Blld = new blld();
  private bloe jdField_a_of_type_Bloe = new bloe();
  private blou jdField_a_of_type_Blou = blov.a();
  private ImageExporter jdField_a_of_type_ComTencentTavcutExporterImageExporter;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private AEEditorImagePagerAdapter jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter;
  private AEEditorImageViewPager jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager;
  private NumberIndicator jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  blkn jdField_b_of_type_Blkn = new blmz(this);
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  private List<blki> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private String c = "";
  
  private Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f = 1.0F;
    if (j > i) {
      if (j > 736) {
        f = 736.0F / j;
      }
    }
    for (;;)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f, f);
      return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      if (i > 736) {
        f = 736.0F / i;
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
      Size localSize = Util.constrainMaxSize((Size)localObject, this.jdField_a_of_type_Blou.c());
      m = ((Size)localObject).getWidth() / localSize.getWidth();
      if (((Size)localObject).getWidth() % localSize.getWidth() != 0) {
        break label354;
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
            break label336;
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
  
  private String a(int paramInt, byte[] paramArrayOfByte, long paramLong)
  {
    Object localObject = new AEImageStylizeReqData.ImageStylizeResponse();
    try
    {
      ((AEImageStylizeReqData.ImageStylizeResponse)localObject).mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        try
        {
          int i = ((AEImageStylizeReqData.ImageStylizeResponse)localObject).code.get();
          bljn.b(jdField_b_of_type_JavaLangString, "comics response: code=" + i + ", msg=" + ((AEImageStylizeReqData.ImageStylizeResponse)localObject).msg.get());
          bliu.a().a(1000, paramLong + "", "lut_comics", i);
          if (!((AEImageStylizeReqData.ImageStylizeResponse)localObject).imageRawData.has()) {
            break label210;
          }
          paramArrayOfByte = ((AEImageStylizeReqData.ImageStylizeResponse)localObject).imageRawData.get().toByteArray();
          paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
          localObject = blkd.c + File.separator + paramInt + "_comicResult.jpg";
          FileUtil.createFile((String)localObject);
          BitmapUtil.saveBitmap(paramArrayOfByte, 100, (String)localObject);
          BitmapUtils.recycle(paramArrayOfByte);
          return localObject;
        }
        catch (Exception paramArrayOfByte)
        {
          bljn.d(jdField_b_of_type_JavaLangString, paramArrayOfByte.toString());
        }
        paramArrayOfByte = paramArrayOfByte;
        paramArrayOfByte.printStackTrace();
      }
    }
    label210:
    return "";
  }
  
  private HashMap<String, LocalMediaInfo> a(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      LocalMediaInfo localLocalMediaInfo = blpx.a(str);
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localLocalMediaInfo.aiTextLabel = ((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
      localHashMap.put(str, localLocalMediaInfo);
    }
    return localHashMap;
  }
  
  private void a(int paramInt, bllm parambllm)
  {
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.6(this, paramInt, parambllm));
  }
  
  private void a(Bitmap paramBitmap, int paramInt)
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = new blmx(this, paramInt);
    localbaub.jdField_a_of_type_JavaLangString = "https://api.shadowai.qq.com/trpc.mobile_qq_http.mobile_qq_http_cgi.MobileQQHttpCgi/ImageStylize";
    localbaub.jdField_a_of_type_Int = 1;
    localbaub.jdField_c_of_type_Long = 30000L;
    localbaub.jdField_a_of_type_ArrayOfByte = a(paramBitmap);
    localbaub.e = 0;
    localbaub.jdField_a_of_type_JavaUtilHashMap.put("Content-Type", "application/proto; charset=UTF-8");
    localbaub.jdField_a_of_type_JavaUtilHashMap.put("Accept", "application/proto");
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 1, "app is null");
      return;
    }
    paramBitmap = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    String str = paramBitmap.getSkey((String)localObject);
    paramBitmap = paramBitmap.getPskey((String)localObject, "shadowai.qq.com");
    if (!TextUtils.isEmpty(paramBitmap)) {
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "uin=" + (String)localObject + ";pskey=" + paramBitmap);
    }
    for (;;)
    {
      localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
      getActivity().getAppInterface().getNetEngine(0).a(localbaub);
      this.jdField_a_of_type_Baub = localbaub;
      return;
      s();
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Cookie", "uin=" + (String)localObject + ";skey=" + str);
    }
  }
  
  private void a(View paramView)
  {
    bljn.b(jdField_b_of_type_JavaLangString, "initViews");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager = ((AEEditorImageViewPager)paramView.findViewById(2131379940));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator = ((NumberIndicator)paramView.findViewById(2131371326));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setOnPageChangeListener(this);
  }
  
  private static boolean a(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  private byte[] a(Bitmap paramBitmap)
  {
    boolean bool = false;
    Object localObject2 = new ByteArrayOutputStream();
    bljn.b(jdField_b_of_type_JavaLangString, "before: " + System.currentTimeMillis());
    Object localObject1 = a(paramBitmap);
    BitmapUtils.recycle(paramBitmap);
    ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
    bljn.b(jdField_b_of_type_JavaLangString, "after: " + System.currentTimeMillis());
    localObject2 = ((ByteArrayOutputStream)localObject2).toByteArray();
    paramBitmap = new AEImageStylizeReqData.ImageStylizeRequest();
    paramBitmap.stylizeType.set(1, true);
    paramBitmap.imgInfo.setHasFlag(true);
    paramBitmap.imgInfo.imgWidth.set(((Bitmap)localObject1).getWidth());
    paramBitmap.imgInfo.imgHeight.set(((Bitmap)localObject1).getHeight());
    paramBitmap.imgInfo.imageRawData.set(ByteStringMicro.copyFrom((byte[])localObject2), true);
    localObject2 = blhy.b((Bitmap)localObject1);
    BitmapUtils.recycle((Bitmap)localObject1);
    if ((localObject2 == null) || (((PTFaceAttr)localObject2).getAllFacePoints() == null) || (((PTFaceAttr)localObject2).getAllFacePoints().isEmpty())) {
      paramBitmap.imgInfo.hasFace.set(false);
    }
    for (;;)
    {
      paramBitmap.setHasFlag(true);
      return paramBitmap.toByteArray();
      localObject1 = ((PTFaceAttr)localObject2).getAllFacePoints().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (List)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          AEImageStylizeReqData.FaceInfo localFaceInfo = new AEImageStylizeReqData.FaceInfo();
          localFaceInfo.setHasFlag(true);
          i = 0;
          while (i < ((List)localObject2).size())
          {
            localFaceInfo.pos.add(Float.valueOf(((PointF)((List)localObject2).get(i)).x));
            localFaceInfo.pos.add(Float.valueOf(((PointF)((List)localObject2).get(i)).y));
            i += 1;
          }
          paramBitmap.imgInfo.faceInfos.add(localFaceInfo);
        }
      }
      int i = paramBitmap.imgInfo.faceInfos.size();
      localObject1 = paramBitmap.imgInfo.hasFace;
      if (i > 0) {
        bool = true;
      }
      ((PBBoolField)localObject1).set(bool);
      paramBitmap.imgInfo.faceNum.set(i);
    }
  }
  
  private void b(int paramInt)
  {
    bljn.b(jdField_b_of_type_JavaLangString, "updateImageFilterByIndex: " + paramInt);
    if ((this.jdField_a_of_type_Bloe.b(paramInt) == 0) && (this.jdField_a_of_type_Bloe.a(paramInt) == 0))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.render(paramInt);
      return;
    }
    if (this.jdField_a_of_type_Bloe.b(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, null);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setAEKitAIFilter(paramInt, this.jdField_a_of_type_Bloe.a(paramInt).b(), this.jdField_a_of_type_Bloe.a(paramInt).a(), this.jdField_a_of_type_Bloe.a(paramInt).a(), (int)(this.jdField_a_of_type_Bloe.a(paramInt).b() * 100.0F), this.jdField_a_of_type_Bloe.a(paramInt).c());
      return;
    }
    if (this.jdField_a_of_type_Bloe.c(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, this.jdField_a_of_type_Bloe.a(paramInt).a());
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(paramInt, null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.removeAIFilter(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutImage(paramInt, this.jdField_a_of_type_Bloe.a(paramInt));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutAlpha(paramInt, this.jdField_a_of_type_Bloe.a(paramInt));
  }
  
  private int c()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  private void c(int paramInt)
  {
    if (paramInt >= 1) {
      b(paramInt - 1);
    }
    if (paramInt < c() - 1) {
      b(paramInt + 1);
    }
  }
  
  private int d()
  {
    return this.jdField_a_of_type_Blou.d();
  }
  
  private String f()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 1, "app is null");
      return "";
    }
    String str = localAppRuntime.getAccount();
    return ((TicketManager)localAppRuntime.getManager(2)).getPskey(str, "shadowai.qq.com");
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
  
  private void r()
  {
    bljn.b(jdField_b_of_type_JavaLangString, "showImages");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = new AEEditorImagePagerAdapter(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, new blmr(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setTotalCount(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.getCount());
    NumberIndicator localNumberIndicator = this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.getCount() > 0) {}
    for (int i = 1;; i = 0)
    {
      localNumberIndicator.setCurrentIndex(i);
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter);
      return;
    }
  }
  
  private void s()
  {
    if (!TextUtils.isEmpty(f()))
    {
      bljn.b(jdField_b_of_type_JavaLangString, "psKey not empty.");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    blmv localblmv = new blmv(this);
    localTicketManager.GetPskey((String)localObject, 16L, new String[] { "shadowai.qq.com" }, localblmv);
  }
  
  private void t()
  {
    bljn.b(jdField_b_of_type_JavaLangString, "initTAVCutSession");
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = new TAVCutImageSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setMinIntermediateRenderSize(this.jdField_a_of_type_Blou.a());
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Blou.b());
    localSessionConfig.setMaxImageDecodeSize(this.jdField_a_of_type_Blou.c());
    Object localObject = new StickerEditViewIconConfig();
    ((StickerEditViewIconConfig)localObject).setDeleteIconResId(2130837658);
    ((StickerEditViewIconConfig)localObject).setEditIconResId(2130837659);
    ((StickerEditViewIconConfig)localObject).setZoomIconResId(2130837660);
    localSessionConfig.setStickerEditViewIconConfig((StickerEditViewIconConfig)localObject);
    localObject = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      ((List)localObject).add(((blki)this.jdField_b_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    localSessionConfig.setImageInitCropConfigs((List)localObject);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setImagePaths(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setStickerOperationCallback(new blmw(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.init(getActivity());
  }
  
  private void u()
  {
    AEEditorApplyAllLoadingView localAEEditorApplyAllLoadingView = new AEEditorApplyAllLoadingView(getActivity());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localAEEditorApplyAllLoadingView);
  }
  
  public int a()
  {
    return 2131558531;
  }
  
  protected blnr a()
  {
    return this;
  }
  
  protected blnz a()
  {
    return new blmu(this);
  }
  
  protected blpm a()
  {
    return new blna(this);
  }
  
  protected blpp a()
  {
    return this;
  }
  
  public String a()
  {
    return "AEEditorImageEdit";
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutAlpha(this.jdField_a_of_type_Int, paramFloat);
    this.jdField_a_of_type_Bloe.a(this.jdField_a_of_type_Int, paramFloat);
    this.jdField_a_of_type_Bloe.a(this.jdField_a_of_type_Int, paramInt, paramFloat);
    bliy.a().a().b.put(Integer.valueOf(this.jdField_a_of_type_Int), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt, String paramString, float paramFloat, AEEditorFilterBean paramAEEditorFilterBean)
  {
    j();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(true);
    if (b()) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
    }
    float f = this.jdField_a_of_type_Bloe.a(this.jdField_a_of_type_Int, paramInt, paramFloat);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f);
    this.jdField_a_of_type_Bloe.a(this.jdField_a_of_type_Int, paramString, f, paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.removeAIFilter(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutImage(this.jdField_a_of_type_Int, paramString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutAlpha(this.jdField_a_of_type_Int, f);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(this.jdField_a_of_type_Int, null);
    bliy.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), paramAEEditorFilterBean.getSid());
    bliy.a().a().b.put(Integer.valueOf(this.jdField_a_of_type_Int), Float.valueOf(paramFloat));
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.mediaChanged()) {
      return false;
    }
    return super.a();
  }
  
  protected int b()
  {
    return 0;
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_JavaUtilList.size() > 1;
  }
  
  public String c()
  {
    return alud.a(2131689798);
  }
  
  protected void c()
  {
    bljn.b(jdField_b_of_type_JavaLangString, "initImageInfos");
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
        this.jdField_b_of_type_JavaUtilList.add(new blki(((EditorPicInfo)localObject2).picPath, (int)((EditorPicInfo)localObject2).originPicWidth, (int)((EditorPicInfo)localObject2).originPicHeight, localCropConfig));
      }
      bljn.d(jdField_b_of_type_JavaLangString, "no image crop infos");
    }
    this.jdField_b_of_type_Int = d();
    this.jdField_a_of_type_Bloe.a(this.jdField_a_of_type_JavaUtilList.size());
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void d()
  {
    blkl.a().a();
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean e()
  {
    Object localObject = this.jdField_a_of_type_Blld.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
    boolean bool;
    if ((localObject != null) && ((localObject instanceof bllo)))
    {
      bljn.b(jdField_b_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool = ((bllo)localObject).a;
      bljn.b(jdField_b_of_type_JavaLangString, "onAIFilterRequest: needRequest=" + bool);
      if (!bool) {
        break label155;
      }
      h();
      localObject = new blln((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int), this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Int);
      ((blln)localObject).a(this.jdField_a_of_type_Blkn);
      blkl.a().a(getActivity().getAppInterface(), getActivity(), (blle)localObject);
    }
    for (;;)
    {
      if (bool) {
        break label282;
      }
      return true;
      bool = true;
      break;
      label155:
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      if (b()) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
      }
      this.jdField_a_of_type_Bloe.a(this.jdField_a_of_type_Int, (bllj)localObject);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(this.jdField_a_of_type_Int, null);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setAEKitAIFilter(this.jdField_a_of_type_Int, ((bllj)localObject).b(), ((bllj)localObject).a(), ((bllj)localObject).a(), (int)(((bllj)localObject).b() * 100.0F), ((bllj)localObject).c());
      a(new String[] { "智能滤镜label", ((bllj)localObject).a(), "智能滤镜errCode", "0" });
    }
    label282:
    return false;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_a_of_type_Int);
    }
  }
  
  public boolean f()
  {
    int i = this.jdField_a_of_type_Int;
    bllm localbllm = (bllm)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if (localbllm == null)
    {
      if (!bdin.a())
      {
        QQToast.a(getActivity(), getActivity().getResources().getString(2131690839), 1).a();
        return false;
      }
      this.jdField_b_of_type_Boolean = false;
      i();
      blhy.a(new AEEditorImageEditFragment.4(this, i), false, "GLThread-changeFaceSingle");
      return false;
    }
    a(i, localbllm);
    return true;
  }
  
  public void g()
  {
    bljn.b(jdField_b_of_type_JavaLangString, "exportImages");
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession == null)
    {
      bljn.d(jdField_b_of_type_JavaLangString, "exportImages error: session is null");
      return;
    }
    if (!g())
    {
      QQToast.a(getActivity(), "图片不存在或被删除", 0).a();
      return;
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.10(this));
    Object localObject1 = blke.c;
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
        localObject2 = (String)localObject1 + File.separator + "output_" + i + "_" + System.currentTimeMillis() + "_" + bnhb.a(((File)localObject2).getName()) + ".jpg";
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
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = d();
    }
    ((ImageExportConfig)localObject1).setMaxExportSize(d());
    ((ImageExportConfig)localObject1).setMaxIntermediateRenderSize(d());
    ((ImageExportConfig)localObject1).setQuality(this.jdField_a_of_type_Blou.e());
    ((ImageExportConfig)localObject1).setOutputPath(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getExporter((ImageExportConfig)localObject1);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter.export(new blmt(this));
  }
  
  public void l()
  {
    int j = 0;
    bljn.b(jdField_b_of_type_JavaLangString, "onApplyAll current position = " + this.jdField_a_of_type_Int);
    bliu.a().m();
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
          localObject2 = this.jdField_a_of_type_Blld.a((String)localObject2);
          if ((localObject2 != null) && ((localObject2 instanceof bllo)))
          {
            bljn.b(jdField_b_of_type_JavaLangString, "onAIFilterRequest: has cache");
            if (!((bllj)localObject2).a) {
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
        h();
        localObject1 = new bllk(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Blld.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)));
        ((bllk)localObject1).a(this.jdField_b_of_type_Blkn);
        blkl.a().a(getActivity().getAppInterface(), getActivity(), (blle)localObject1);
      }
      do
      {
        return;
        i = 1;
        break;
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(false);
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
        localObject1 = new StringBuilder();
        i = j;
        while (i < c())
        {
          localObject2 = (bllo)this.jdField_a_of_type_Blld.a((String)this.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_a_of_type_Bloe.a(i, (bllj)localObject2);
          ((StringBuilder)localObject1).append(((bllo)localObject2).a() + "|");
          i += 1;
        }
        a("智能滤镜label", ((StringBuilder)localObject1).toString());
        b(this.jdField_a_of_type_Int);
        c(this.jdField_a_of_type_Int);
        u();
        return;
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b())
        {
          this.jdField_a_of_type_Bloe.a();
          c(this.jdField_a_of_type_Int);
          u();
          return;
        }
      } while (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c());
      this.jdField_a_of_type_Bloe.b(this.jdField_a_of_type_Int);
      c(this.jdField_a_of_type_Int);
      u();
      return;
      i = 0;
    }
  }
  
  public void m()
  {
    j();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(false);
    if (b()) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.removeAIFilter(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutImage(this.jdField_a_of_type_Int, null);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setOverlayImage(this.jdField_a_of_type_Int, null);
    this.jdField_a_of_type_Bloe.c(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.getVisibility() != 0) {
      this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(4);
  }
  
  public void o()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
    s();
  }
  
  public void onDestroy()
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onDestroy");
    super.onDestroy();
    bdhb.a(blkd.c, false);
  }
  
  public void onDestroyView()
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onDestroyView");
    super.onDestroyView();
    if (this.jdField_a_of_type_Baub != null) {
      getActivity().getAppInterface().getNetEngine(0).b(this.jdField_a_of_type_Baub);
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = null;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = null;
    }
    this.jdField_a_of_type_Bloe.b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_a_of_type_Int);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    boolean bool = true;
    bljn.b(jdField_b_of_type_JavaLangString, "onPageSelected: " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setCurrentIndex(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setCurrentIndex(paramInt + 1);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_Bloe.a(this.jdField_a_of_type_Int));
    AEEditorFilterControlPanel localAEEditorFilterControlPanel;
    if ((this.jdField_a_of_type_Bloe.a(this.jdField_a_of_type_Int)) || (this.jdField_a_of_type_Bloe.b(this.jdField_a_of_type_Int)) || (this.jdField_a_of_type_Bloe.c(this.jdField_a_of_type_Int)))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(false);
      if (b())
      {
        localAEEditorFilterControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel;
        if (this.jdField_a_of_type_Bloe.c(this.jdField_a_of_type_Int)) {
          break label183;
        }
      }
    }
    for (;;)
    {
      localAEEditorFilterControlPanel.b(bool);
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(true);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(this.jdField_a_of_type_Bloe.a(this.jdField_a_of_type_Int));
      break;
      label183:
      bool = false;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bljn.b(jdField_b_of_type_JavaLangString, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    bljn.b(jdField_b_of_type_JavaLangString, "init");
    this.jdField_a_of_type_Bdgf = new bdgf(Looper.getMainLooper(), this);
    t();
    this.jdField_a_of_type_Bloe.b();
    a(paramView);
    r();
    if (d())
    {
      if (!blnt.a().a()) {
        break label214;
      }
      bljn.b(jdField_b_of_type_JavaLangString, "single image + first time : aifilter auto request");
      e();
      k();
    }
    for (;;)
    {
      a(new String[] { "设备级别", blow.a(), "图片最小预览尺寸", String.valueOf(this.jdField_a_of_type_Blou.a()), "图片最大预览尺寸", String.valueOf(this.jdField_a_of_type_Blou.b()), "图片导出质量", this.jdField_a_of_type_Blou.e() + "%", "图片最大导出尺寸", String.valueOf(this.jdField_b_of_type_Int) });
      return;
      label214:
      bljn.d(jdField_b_of_type_JavaLangString, "single image + first time : aifilter res not ready, do not request");
    }
  }
  
  public void p() {}
  
  public void q()
  {
    this.jdField_a_of_type_Blpi.a(getActivity(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment
 * JD-Core Version:    0.7.0.1
 */