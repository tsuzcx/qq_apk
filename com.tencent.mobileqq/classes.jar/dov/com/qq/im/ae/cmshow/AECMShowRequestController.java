package dov.com.qq.im.ae.cmshow;

import amlo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import bnis;
import bnix;
import bniy;
import bniz;
import bnja;
import bnjb;
import bnjc;
import bnqm;
import bnrh;
import bofz;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.protobuf.AEPbData.CartoonPtaRequest;
import dov.com.qq.im.ae.protobuf.AEPbData.CartoonPtaResponse;
import dov.com.qq.im.ae.protobuf.AEPbData.DressItem;
import dov.com.qq.im.ae.protobuf.AEPbData.FaceAttr;
import dov.com.qq.im.ae.protobuf.AEPbData.ImageInfo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class AECMShowRequestController
{
  private int jdField_a_of_type_Int;
  private bnjc jdField_a_of_type_Bnjc;
  private HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AECMShowRequestController.1(this);
  private int b;
  
  public AECMShowRequestController(int paramInt, @Nullable bnjc parambnjc)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (parambnjc != null) {
      this.jdField_a_of_type_Bnjc = parambnjc;
    }
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    float f = 1.0F;
    int i = paramInt;
    if (paramInt <= 0) {
      i = 736;
    }
    paramInt = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = Math.max(paramInt, j);
    if (k > i) {
      f = 1.0F * i / k;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f, f);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramInt, j, localMatrix, true);
  }
  
  private PeakAppInterface a()
  {
    AppInterface localAppInterface = bofz.a();
    if ((localAppInterface instanceof PeakAppInterface)) {
      return (PeakAppInterface)localAppInterface;
    }
    return null;
  }
  
  private String a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      bnrh.d("AECMShowRequestController", "appRuntime is null");
      return "";
    }
    String str = localAppRuntime.getAccount();
    return ((TicketManager)localAppRuntime.getManager(2)).getPskey(str, "shadowai.qq.com");
  }
  
  @NonNull
  private String a(@NonNull AEPbData.CartoonPtaResponse paramCartoonPtaResponse)
  {
    return AECMShowJsonModel.convertModel2JsonString(AECMShowJsonModel.convertFromPbData(paramCartoonPtaResponse));
  }
  
  private HashMap<String, String> a(@NonNull HashMap<Integer, String> paramHashMap1, @NonNull HashMap<Integer, String> paramHashMap2)
  {
    HashMap localHashMap = new HashMap();
    paramHashMap2 = paramHashMap2.entrySet().iterator();
    while (paramHashMap2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap2.next();
      if (localEntry != null) {
        localHashMap.put(paramHashMap1.get(localEntry.getKey()), localEntry.getValue());
      }
    }
    return localHashMap;
  }
  
  private Map<String, Integer> a(@NonNull List<AEPbData.DressItem> paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AEPbData.DressItem localDressItem = (AEPbData.DressItem)paramList.next();
      if (localDressItem.id.get() > 0) {
        localHashMap.put(localDressItem.name.get(), Integer.valueOf(localDressItem.id.get()));
      }
    }
    return localHashMap;
  }
  
  private void a(int paramInt, @NonNull HashMap<String, String> paramHashMap, @NonNull String paramString, @NonNull Map<String, Integer> paramMap)
  {
    amlo.a(paramInt, new bnja(this, paramHashMap, paramMap, paramString));
  }
  
  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new bniy(this);
    localHttpNetReq.mReqUrl = "https://api.shadowai.qq.com/trpc.mobile_qq_http.mobile_qq_http_cgi.MobileQQHttpCgi/CartoonPta";
    localHttpNetReq.mHttpMethod = 1;
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    localHttpNetReq.mSendData = a(paramBitmap, paramInt1, paramInt2);
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mReqProperties.put("Content-Type", "application/proto; charset=UTF-8");
    localHttpNetReq.mReqProperties.put("Accept", "application/proto");
    paramBitmap = BaseApplicationImpl.getApplication().getRuntime();
    if (paramBitmap == null)
    {
      bnrh.d("AECMShowRequestController", "appRuntime is null");
      if (this.jdField_a_of_type_Bnjc != null) {
        this.jdField_a_of_type_Bnjc.a(2, null);
      }
    }
    label439:
    do
    {
      return;
      Object localObject = (TicketManager)paramBitmap.getManager(2);
      paramBitmap = paramBitmap.getAccount();
      String str1 = ((TicketManager)localObject).getSkey(paramBitmap);
      localObject = ((TicketManager)localObject).getPskey(paramBitmap, "shadowai.qq.com");
      String str2 = AEModule.getVersion();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHttpNetReq.mReqProperties.put("Cookie", "uin=" + paramBitmap + ";pskey=" + (String)localObject + ";qqversion=" + "8.4.10" + ";aekitversion=" + str2 + ";platform=" + "Android");
      }
      for (;;)
      {
        localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        paramBitmap = a();
        if (paramBitmap == null) {
          break label439;
        }
        paramBitmap.getNetEngine(0).sendReq(localHttpNetReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
        this.b = 1;
        if (this.jdField_a_of_type_Bnjc != null) {
          this.jdField_a_of_type_Bnjc.c(this.b);
        }
        if (this.jdField_a_of_type_JavaLangRunnable == null) {
          break;
        }
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 150L);
        return;
        c();
        localHttpNetReq.mReqProperties.put("Cookie", "uin=" + paramBitmap + ";skey=" + str1 + ";qqversion=" + "8.4.10" + ";aekitversion=" + str2 + ";platform=" + "Android");
      }
      bnrh.d("AECMShowRequestController", "[sendRequest] peakAppInterface is null");
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_Bnjc == null);
    this.jdField_a_of_type_Bnjc.a(2, null);
  }
  
  private void a(@NonNull NetResp paramNetResp)
  {
    AEPbData.CartoonPtaResponse localCartoonPtaResponse = new AEPbData.CartoonPtaResponse();
    try
    {
      localCartoonPtaResponse.mergeFrom(paramNetResp.mRespData);
      if ((localCartoonPtaResponse.code != null) && (localCartoonPtaResponse.code.get() != 1001) && (localCartoonPtaResponse.code.get() != 1005) && (localCartoonPtaResponse.dressList != null) && (!CollectionUtils.isEmpty(localCartoonPtaResponse.dressList.get())) && (localCartoonPtaResponse.faceAttr != null) && (localCartoonPtaResponse.faceAttr.get() != null) && (((AEPbData.FaceAttr)localCartoonPtaResponse.faceAttr.get()).roleID != null))
      {
        bnrh.a("AECMShowRequestController", "[processCartonResponse] valid dressList");
        String str = a(localCartoonPtaResponse);
        if (this.jdField_a_of_type_Int == 1) {
          a(localCartoonPtaResponse.dressList.get(), ((AEPbData.FaceAttr)localCartoonPtaResponse.faceAttr.get()).roleID.get(), str);
        }
        for (;;)
        {
          bnqm.a().a(1000, String.valueOf(paramNetResp.reqCost), "CartoonPta", localCartoonPtaResponse.code.get());
          return;
          if (this.jdField_a_of_type_Int == 2)
          {
            if (this.jdField_a_of_type_JavaLangRunnable != null) {
              ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            }
            if (this.jdField_a_of_type_Bnjc != null)
            {
              this.b = 100;
              this.jdField_a_of_type_Bnjc.c(this.b);
              AECMShowRequestController.CmShowDataWrapper localCmShowDataWrapper = new AECMShowRequestController.CmShowDataWrapper();
              localCmShowDataWrapper.sceneMode = this.jdField_a_of_type_Int;
              localCmShowDataWrapper.dressidMaps = a(localCartoonPtaResponse.dressList.get());
              localCmShowDataWrapper.cmJsonString = str;
              this.jdField_a_of_type_Bnjc.a(1, localCmShowDataWrapper);
            }
          }
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramNetResp)
    {
      bnrh.a("AECMShowRequestController", "[processCartonResponse] e=", paramNetResp);
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_Bnjc != null)
      {
        this.jdField_a_of_type_Bnjc.a(2, null);
        return;
        bnrh.a("AECMShowRequestController", "[processCartonResponse] dressList is empty");
        int i;
        if (localCartoonPtaResponse.code != null) {
          if (localCartoonPtaResponse.code.get() == 1001) {
            i = 3;
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_JavaLangRunnable != null) {
            ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          }
          if (this.jdField_a_of_type_Bnjc == null) {
            break;
          }
          this.jdField_a_of_type_Bnjc.a(i, null);
          break;
          if (localCartoonPtaResponse.code.get() == 1005)
          {
            i = 4;
            continue;
            if (this.jdField_a_of_type_JavaLangRunnable != null) {
              ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            }
            if (this.jdField_a_of_type_Bnjc == null) {
              break;
            }
            this.jdField_a_of_type_Bnjc.a(2, null);
            break;
          }
          i = 2;
        }
      }
    }
  }
  
  private void a(@NonNull List<AEPbData.DressItem> paramList, int paramInt, @NonNull String paramString)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AEPbData.DressItem localDressItem = (AEPbData.DressItem)localIterator.next();
      if (localDressItem.id.get() > 0) {
        localHashMap.put(Integer.valueOf(localDressItem.id.get()), localDressItem.name.get());
      }
    }
    amlo.a(new ArrayList(localHashMap.keySet()), new bniz(this, localHashMap, paramList, paramInt, paramString));
  }
  
  private byte[] a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject = new ByteArrayOutputStream();
    bnrh.b("AECMShowRequestController", "before: " + System.currentTimeMillis() + ", uploadMaxSize=" + paramInt1 + ", src bitmap size=[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + "]");
    paramBitmap = a(paramBitmap, paramInt1);
    paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt2, (OutputStream)localObject);
    bnrh.b("AECMShowRequestController", "after: " + System.currentTimeMillis() + ", scaled bitmap size=[" + paramBitmap.getWidth() + ", " + paramBitmap.getHeight() + "]");
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    AEPbData.CartoonPtaRequest localCartoonPtaRequest = new AEPbData.CartoonPtaRequest();
    localCartoonPtaRequest.img.setHasFlag(true);
    localCartoonPtaRequest.img.imgWidth.set(paramBitmap.getWidth());
    localCartoonPtaRequest.img.imgHeight.set(paramBitmap.getHeight());
    localCartoonPtaRequest.img.imageRawData.set(ByteStringMicro.copyFrom((byte[])localObject), true);
    BitmapUtils.recycle(paramBitmap);
    localCartoonPtaRequest.setHasFlag(true);
    return localCartoonPtaRequest.toByteArray();
  }
  
  private void c()
  {
    if (!TextUtils.isEmpty(a()))
    {
      bnrh.b("AECMShowRequestController", "psKey not empty.");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    localObject = ((AppRuntime)localObject).getAccount();
    bnjb localbnjb = new bnjb(this);
    localTicketManager.getPskey((String)localObject, 16L, new String[] { "shadowai.qq.com" }, localbnjb);
  }
  
  public void a()
  {
    c();
  }
  
  public void a(Bitmap paramBitmap)
  {
    bnis.b(new bnix(this, paramBitmap));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bnjc != null) {
      this.jdField_a_of_type_Bnjc = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null)
    {
      PeakAppInterface localPeakAppInterface = a();
      if (localPeakAppInterface != null) {
        localPeakAppInterface.getNetEngine(0).cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.AECMShowRequestController
 * JD-Core Version:    0.7.0.1
 */