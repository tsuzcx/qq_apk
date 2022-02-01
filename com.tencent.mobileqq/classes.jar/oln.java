import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.AdDownloadProxy.1;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.AdDownloadProxy.3;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class oln
{
  public int a;
  public Context a;
  public AdvertisementInfo a;
  public AdData a;
  public ArrayList<olq> a;
  private AtomicBoolean a;
  public nxp a;
  public orb a;
  public oro a;
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public oln()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static void a(orb paramorb, int paramInt)
  {
    if (paramorb != null)
    {
      paramorb.jdField_a_of_type_Int = paramInt;
      if (paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = paramInt;
      }
      if (paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = paramInt;
      }
      if (paramorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
        paramorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.b = paramInt;
      }
    }
  }
  
  public static void b(orb paramorb, int paramInt)
  {
    if (paramorb != null)
    {
      paramorb.b = paramInt;
      if (paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = paramInt;
      }
      if (paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
        paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j = paramInt;
      }
      if (paramorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
        paramorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = paramInt;
      }
    }
  }
  
  private String c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (opz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData.v;
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt;
    }
    return "";
  }
  
  private String d()
  {
    String str = "1";
    if (this.jdField_a_of_type_Int == 3) {
      str = "2";
    }
    while (this.jdField_a_of_type_Int != 4) {
      return str;
    }
    return "1";
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 4) {
      return nxw.ae;
    }
    if (this.jdField_a_of_type_Int == 3) {
      return nxw.Y;
    }
    if (this.jdField_a_of_type_Int == 5) {
      return nxw.af;
    }
    return nxw.ae;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    VideoInfo.GameAdComData localGameAdComData;
    do
    {
      return 0L;
      localGameAdComData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData;
    } while (localGameAdComData == null);
    try
    {
      int i = new JSONObject(localGameAdComData.u).optInt("iGiftId");
      return i;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return 0L;
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_Orb != null) {
      return this.jdField_a_of_type_Orb.d;
    }
    return "";
  }
  
  public String a(AdvertisementInfo paramAdvertisementInfo)
  {
    String str2 = "";
    String str1 = str2;
    if (paramAdvertisementInfo != null)
    {
      str1 = str2;
      if (paramAdvertisementInfo.gameAdComData != null) {
        str1 = paramAdvertisementInfo.gameAdComData.g;
      }
    }
    return str1;
  }
  
  public oln a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public oln a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    return this;
  }
  
  public oln a(AdData paramAdData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData = paramAdData;
    return this;
  }
  
  public oln a(nxp paramnxp)
  {
    this.jdField_a_of_type_Nxp = paramnxp;
    return this;
  }
  
  public oln a(olq paramolq)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramolq);
    return this;
  }
  
  public oln a(orb paramorb)
  {
    this.jdField_a_of_type_Orb = paramorb;
    return this;
  }
  
  public void a()
  {
    if (opz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      ThreadManager.executeOnNetWorkThread(new AdDownloadProxy.1(this));
      nxw.a(new omp().a(BaseApplication.getContext()).a(nxw.jdField_a_of_type_Int).b(a()).e(ooh.a(a(), nxw.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), null)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)).a());
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (opz.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
        if (!opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
          break;
        }
      } while (a());
      a(false, false);
      return;
    } while (!opz.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      oli.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    oll.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), oll.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3010405L, 9L, "", d()));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    oqh.a("AdDownloadProxy", "mAppButton is clickable");
    try
    {
      if (oqt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        oqt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        return;
      }
      if (opz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        a();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (this.jdField_a_of_type_Orb != null)
    {
      boolean bool = a();
      if (!bool)
      {
        int i;
        if ((bgnt.b(this.jdField_a_of_type_AndroidContentContext)) && (oqi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo))) {
          i = 1;
        }
        while ((acrw.a()) || (i != 0)) {
          if (opz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
          {
            this.b.set(true);
            b();
            return;
            i = 0;
          }
          else if (d())
          {
            c();
            if (e())
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(1);
              olm.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nxw.an, nxw.jdField_a_of_type_Int, paramInt);
              return;
            }
            olm.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, nxw.Z, nxw.jdField_a_of_type_Int, paramInt);
            return;
          }
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          tbe.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, true, 8);
        }
      }
    }
  }
  
  public void a(TextView paramTextView, NativeAdDownloadView paramNativeAdDownloadView, int paramInt1, int paramInt2)
  {
    if ((paramNativeAdDownloadView == null) || (paramTextView == null))
    {
      oqh.a("AdDownloadProxy", "updateUIState error : ui is null");
      return;
    }
    ThreadManager.getUIHandler().post(new AdDownloadProxy.3(this, paramInt1, paramInt2, paramTextView, paramNativeAdDownloadView));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (acrw.a()))
    {
      if (a()) {}
      while ((!acrw.a()) || (paramBoolean2)) {
        return;
      }
      this.b.set(true);
      b();
      return;
    }
    oqc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, paramBoolean1, c(), new olp(this, paramBoolean2));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Orb == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_Orb.d;
    int j = nxw.M;
    int i = nxw.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bgnw.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 1;
      if (opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        j = a();
        i = nxw.e;
        localHashMap.put("download_state", "5");
      }
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(ooh.a(a(), nxw.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(5))).d(nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
      return true;
    }
    if (nxp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Orb))
    {
      localObject = bisa.a().c(this.jdField_a_of_type_Orb.d);
      bisa.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 5;
      if (opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        j = a();
        i = nxw.e;
        localHashMap.put("download_state", "3");
      }
      for (;;)
      {
        nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).e(ooh.a(a(), nxw.T, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(6))).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
        return true;
        j = nxw.Z;
      }
    }
    return false;
  }
  
  public boolean a(orb paramorb)
  {
    return (paramorb != null) && (this.jdField_a_of_type_Orb != null) && (paramorb.d.equals(this.jdField_a_of_type_Orb.d));
  }
  
  public String b()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      localObject = anni.a(2131711727);
    }
    String str;
    do
    {
      do
      {
        do
        {
          return localObject;
          str = c();
          if (!opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break;
          }
          if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
          {
            this.b.set(false);
            b();
          }
          localObject = a();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (nxw.a(BaseApplicationImpl.getContext(), (String)localObject)) {
            return anni.a(2131711773);
          }
          if (nxp.a(BaseApplicationImpl.getContext(), (String)localObject)) {
            return "安装";
          }
          localObject = str;
        } while (!TextUtils.isEmpty(str));
        return anni.a(2131711646);
        if (!d()) {
          break;
        }
        localObject = a();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (nxw.a(BaseApplicationImpl.getContext(), (String)localObject)) {
          return anni.a(2131711845);
        }
        if (nxp.a(BaseApplicationImpl.getContext(), (String)localObject)) {
          return "立即安装";
        }
        localObject = str;
      } while (!TextUtils.isEmpty(str));
      return anni.a(2131711573);
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    if (oqt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anni.a(2131711889);
    }
    if (oqj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return BaseApplicationImpl.getContext().getResources().getString(2131717033);
    }
    if (oqj.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return BaseApplicationImpl.getContext().getResources().getString(2131717034);
    }
    if (opz.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anni.a(2131711579);
    }
    if (opz.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anni.a(2131711479);
    }
    if (opz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
      return anni.a(2131711852);
    }
    return anni.a(2131711727);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    int j = nxw.M;
    int i = nxw.jdField_a_of_type_Int;
    Object localObject1 = new HashMap();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Orb == null) {
          return;
        }
        localObject2 = this.jdField_a_of_type_Orb.d;
        if (bgnw.a(BaseApplicationImpl.getContext(), (String)localObject2))
        {
          g();
          this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 1;
          if (!opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
            break label725;
          }
          ((HashMap)localObject1).put("download_state", "5");
          paramInt = a();
          i = nxw.e;
          nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (HashMap)localObject1)).a());
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((olq)((Iterator)localObject1).next()).b();
          continue;
        }
        if (!nxp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Orb)) {
          break label353;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject2 = bisa.a().c(this.jdField_a_of_type_Orb.d);
      bisa.a().a((DownloadInfo)localObject2);
      this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 5;
      if (opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        localException.put("download_state", "3");
        paramInt = a();
        i = nxw.e;
      }
      Iterator localIterator;
      for (;;)
      {
        nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localException)).a());
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((olq)localIterator.next()).a();
        }
        paramInt = nxw.T;
      }
      label353:
      if ((bgnt.b(this.jdField_a_of_type_AndroidContentContext)) && (oqi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdExtInfo))) {}
      int k;
      for (j = 1;; j = 0)
      {
        k = nxw.T;
        if ((!acrw.a()) && (j == 0)) {
          break label603;
        }
        if (this.jdField_a_of_type_Orb.jdField_a_of_type_Int != 3) {
          break label495;
        }
        e();
        if ((!opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (!opz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
          break;
        }
        oll.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 4, d());
        return;
      }
      if (e())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 1;
        olm.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
        return;
      }
      olm.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
      return;
      label495:
      if ((this.jdField_a_of_type_Orb.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Orb.jdField_a_of_type_Int != 0)) {
        break;
      }
      c();
      if ((opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (opz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
      {
        oll.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 9, d());
        return;
      }
      if (e())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 1;
        olm.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
        return;
      }
      olm.a(false, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, k, i, paramInt);
      return;
      label603:
      if (this.jdField_a_of_type_Orb.jdField_a_of_type_Int == 3)
      {
        e();
        paramInt = k;
        if (opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
        {
          localIterator.put("download_state", "8");
          paramInt = a();
          i = nxw.e;
        }
        nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(paramInt).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).d(nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localIterator)).a());
        return;
      }
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        break;
      }
      tbe.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, true, 8);
      return;
      label725:
      paramInt = j;
    }
  }
  
  public boolean b()
  {
    if ((d()) && (this.jdField_a_of_type_Orb != null)) {
      try
      {
        Object localObject = this.jdField_a_of_type_Orb.d;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bisa.a().c((String)localObject);
          if ((nxp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Orb)) && (localObject != null) && (((DownloadInfo)localObject).a() == 4))
          {
            f();
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Nxp == null) || (this.jdField_a_of_type_Orb == null)) {}
    Iterator localIterator;
    for (;;)
    {
      return;
      this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb);
      if (this.jdField_a_of_type_Orb.jdField_a_of_type_Int != 4) {
        break;
      }
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((olq)localIterator.next()).a(this.jdField_a_of_type_Orb.b);
      }
    }
    if (this.jdField_a_of_type_Orb.b != 100) {}
    for (int i = this.jdField_a_of_type_Orb.b;; i = 0)
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((olq)localIterator.next()).a(this.jdField_a_of_type_Orb, 3, i);
      }
      break;
    }
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (paramInt != 5)) {
      return;
    }
    if ((opz.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
    {
      oll.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 5, d());
      return;
    }
    HashMap localHashMap = new HashMap();
    nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(nxw.jdField_a_of_type_Int).b(a()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(ooh.a(a(), nxw.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(2))).d(nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, localHashMap)).a());
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData == null) {}
    while ((!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerBigPicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerTriplePicItemData)) && (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData instanceof ProteusBannerVideoItemData))) {
      return false;
    }
    return true;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Nxp == null) || (this.jdField_a_of_type_Orb == null)) {
      return;
    }
    this.jdField_a_of_type_Nxp.d(this.jdField_a_of_type_Orb);
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Nxp == null) || (this.jdField_a_of_type_Orb == null)) {
      return;
    }
    this.jdField_a_of_type_Nxp.b(this.jdField_a_of_type_Orb);
  }
  
  public boolean e()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
      bool1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h();
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null);
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null);
      bool1 = bool2;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.o));
    return true;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = 100;
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.p == 32) && (d())) {
      ubb.b(this.jdField_a_of_type_AndroidContentContext, oqk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData), null, 2, true);
    }
    while ((this.jdField_a_of_type_Orb == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Orb.d))) {
      return;
    }
    oqj.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Orb.d);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Orb == null) {}
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.b.get())) {
            break label256;
          }
          if (this.jdField_a_of_type_Orb.jdField_a_of_type_Int == 4)
          {
            localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((olq)((Iterator)localObject).next()).a(this.jdField_a_of_type_Orb, 4, this.jdField_a_of_type_Orb.b);
            }
          }
          else
          {
            if (this.jdField_a_of_type_Orb.jdField_a_of_type_Int != 5) {
              break;
            }
            localObject = this.jdField_a_of_type_Orb.d;
            if (bgnw.a(BaseApplicationImpl.getContext(), (String)localObject))
            {
              this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 1;
              localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((olq)((Iterator)localObject).next()).a(this.jdField_a_of_type_Orb, 1, this.jdField_a_of_type_Orb.b);
              }
            }
          }
        }
      } while (this.jdField_a_of_type_Orb.jdField_a_of_type_Int != 3);
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((olq)((Iterator)localObject).next()).a(this.jdField_a_of_type_Orb, 3, this.jdField_a_of_type_Orb.b);
      }
    } while (this.jdField_a_of_type_Nxp == null);
    this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb);
    return;
    label256:
    this.b.compareAndSet(true, false);
    int j = nxw.N;
    int i = nxw.jdField_a_of_type_Int;
    long l = a();
    Object localObject = new HashMap();
    if (nxp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Orb))
    {
      d();
      this.jdField_a_of_type_Orb.jdField_a_of_type_Int = 5;
      if (opz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        j = a();
        i = nxw.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      nxw.a(new omp().a(this.jdField_a_of_type_AndroidContentContext).a(i).b(j).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e(ooh.a(l, nxw.G, this.jdField_a_of_type_Int, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo), String.valueOf(2))).d(nxw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (HashMap)localObject)).a());
      return;
    }
    c();
    oll.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3, d());
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Oro != null)
    {
      this.jdField_a_of_type_Oro.dismiss();
      this.jdField_a_of_type_Oro = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oln
 * JD-Core Version:    0.7.0.1
 */