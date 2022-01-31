import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAdExposureManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class pys
{
  private int jdField_a_of_type_Int = 78888888;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<VideoInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private opn jdField_a_of_type_Opn;
  private pzs jdField_a_of_type_Pzs;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 78888889;
  private SparseArray<VideoInfo> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_b_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private SparseBooleanArray jdField_c_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private SparseBooleanArray jdField_d_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j = 1;
  
  public pys(pzs parampzs, List<VideoInfo> paramList, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, Handler paramHandler)
  {
    this.jdField_a_of_type_Pzs = parampzs;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    obz.a().getManager(163);
    this.jdField_a_of_type_Opn = new pyt(this);
  }
  
  private VideoInfo a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    int k = 0;
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_c_of_type_Boolean = true;
    localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = nbe.a(paramAdvertisementInfo);
    localVideoInfo.jdField_a_of_type_Int = 5;
    localVideoInfo.l = paramAdvertisementInfo.mJsonVideoList;
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList))
      {
        localObject = obz.a(paramAdvertisementInfo.mJsonVideoList, paramAdvertisementInfo);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(";");
          paramAdvertisementInfo.mVideoVid = localObject[0];
          paramAdvertisementInfo.mVideoDuration = Integer.valueOf(localObject[1]).intValue();
          paramAdvertisementInfo.mVideoJsonWidth = Integer.valueOf(localObject[7]).intValue();
          paramAdvertisementInfo.mVideoJsonHeight = Integer.valueOf(localObject[8]).intValue();
        }
      }
      if (paramAdvertisementInfo.mVideoCoverUrl != null)
      {
        localVideoInfo.jdField_b_of_type_JavaLangString = paramAdvertisementInfo.mVideoCoverUrl.toString();
        localVideoInfo.jdField_c_of_type_JavaLangString = paramAdvertisementInfo.mTitle;
        localVideoInfo.jdField_a_of_type_JavaLangString = paramAdvertisementInfo.mVideoVid;
        localVideoInfo.G = paramAdvertisementInfo.mAdVideoUrl;
        localVideoInfo.j = paramAdvertisementInfo.mSubscribeID;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName)) {
          break label382;
        }
        localVideoInfo.k = paramAdvertisementInfo.mAdCorporateImageName;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.thirdIcon)) {
          break label394;
        }
        localVideoInfo.E = paramAdvertisementInfo.mAdCorporateLogo;
        if (TextUtils.isEmpty(localVideoInfo.l)) {
          localVideoInfo.jdField_a_of_type_JavaLangString = localVideoInfo.G;
        }
        if (paramBoolean)
        {
          localObject = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
          if (paramBoolean) {
            k = 1;
          }
          ((VideoAdInfo)localObject).p = k;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "videoinfo = " + localVideoInfo.b());
        }
        if (paramAdvertisementInfo.mVideoJsonWidth != 0) {
          break label406;
        }
        k = 540;
        localVideoInfo.jdField_b_of_type_Int = k;
        if (paramAdvertisementInfo.mVideoJsonHeight != 0) {
          break label414;
        }
        k = 960;
        localVideoInfo.jdField_c_of_type_Int = k;
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.jdField_d_of_type_Boolean = true;
        return localVideoInfo;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("VideoAdExposureManager", 2, localException.getMessage());
          continue;
          localVideoInfo.jdField_b_of_type_JavaLangString = paramAdvertisementInfo.mAdImg;
          continue;
          label382:
          localVideoInfo.k = paramAdvertisementInfo.mSubscribeName;
          continue;
          label394:
          localVideoInfo.E = paramAdvertisementInfo.thirdIcon;
          continue;
          label406:
          k = paramAdvertisementInfo.mVideoJsonWidth;
          continue;
          label414:
          k = paramAdvertisementInfo.mVideoJsonHeight;
        }
      }
    }
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo = a(paramAdvertisementInfo, true);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_c_of_type_Int, paramAdvertisementInfo);
    this.jdField_c_of_type_Int = 0;
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if (paramInt2 == this.jdField_b_of_type_Int)
    {
      this.e = paramInt1;
      this.f = paramAdvertisementInfo.mAdKdPos;
    }
    for (;;)
    {
      nab localnab = new nab();
      localnab.jdField_a_of_type_Int = paramAdvertisementInfo.mAdMaterialId;
      localnab.jdField_b_of_type_Int = 1;
      localnab.jdField_c_of_type_Int = paramAdvertisementInfo.mAdKdPos;
      localnab.jdField_a_of_type_Long = paramAdvertisementInfo.mAdPosID;
      ogy.a().a().a(paramInt2, this.jdField_a_of_type_Opn);
      ThreadManager.executeOnSubThread(new VideoAdExposureManager.1(this, paramInt3, paramInt2, localnab));
      return;
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramAdvertisementInfo.mAdKdPos;
    }
  }
  
  private void b(VideoInfo paramVideoInfo, int paramInt)
  {
    this.jdField_d_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramVideoInfo);
    this.jdField_a_of_type_Pzs.notifyItemChanged(paramInt);
  }
  
  private void b(AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo = a(paramAdvertisementInfo, false);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) && (this.jdField_a_of_type_Pzs != null) && ((this.e < this.jdField_a_of_type_JavaUtilList.size()) || (this.e <= 0)))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.e);
      int k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
      this.jdField_b_of_type_JavaUtilArrayList.add(paramAdvertisementInfo);
      if ((localVideoInfo != null) && (!localVideoInfo.jdField_c_of_type_Boolean) && (this.e > k))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramAdvertisementInfo);
        this.jdField_a_of_type_JavaUtilList.add(this.e, paramAdvertisementInfo);
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady add at =" + this.e + ", currentAdpaterPosition=" + k);
        }
        this.jdField_a_of_type_Pzs.notifyItemInserted(this.e);
        this.e = 0;
      }
      if ((localVideoInfo != null) && (localVideoInfo.jdField_c_of_type_Boolean) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (this.jdField_a_of_type_Pzs.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h)))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramAdvertisementInfo);
        b(paramAdvertisementInfo, this.e);
        this.e = 0;
      }
    }
  }
  
  private void e(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady channelID=" + paramInt);
        }
        int k;
        if (paramInt == this.jdField_b_of_type_Int)
        {
          k = this.f;
          this.f = 0;
          AdvertisementInfo localAdvertisementInfo1 = ogy.a().a(paramInt, k);
          if (localAdvertisementInfo1 == null) {
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
            }
          }
        }
        else
        {
          k = this.jdField_d_of_type_Int;
          this.jdField_d_of_type_Int = 0;
          continue;
        }
        ogy.a().b(paramInt, k);
      }
      finally {}
      if (paramInt == this.jdField_b_of_type_Int) {
        b(localAdvertisementInfo2);
      } else {
        a(localAdvertisementInfo2);
      }
    }
  }
  
  public int a(int paramInt)
  {
    int m = -1;
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (localInteger.intValue() >= paramInt) {
        break;
      }
      m = localInteger.intValue();
      k += 1;
    }
    return m;
  }
  
  public VideoInfo a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "getVideoInfo");
    }
    VideoInfo localVideoInfo2 = (VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    VideoInfo localVideoInfo1;
    if (localVideoInfo2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
      }
      localVideoInfo1 = null;
    }
    do
    {
      return localVideoInfo1;
      localVideoInfo1 = localVideoInfo2;
    } while (!QLog.isColorLevel());
    QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,videoInfo");
    return localVideoInfo2;
  }
  
  public void a()
  {
    oom localoom = ogy.a().a();
    if (localoom != null)
    {
      localoom.a(this.jdField_a_of_type_Int);
      localoom.a(this.jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "hasShowAnotherAd");
    }
  }
  
  public void a(int paramInt1, int paramInt2, VideoInfo paramVideoInfo)
  {
    int m = this.jdField_a_of_type_JavaUtilList.size();
    int k = 0;
    if (k < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((!((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(k)).jdField_c_of_type_Boolean) || (k == paramInt1)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "adapterPosition = " + paramInt1 + " ,size = " + m + " ,nextAdPosition = " + k);
      }
      a(paramInt2);
      c(paramInt2);
      b(paramVideoInfo, paramInt1);
      return;
      k += 1;
      break;
      k = 0;
    }
  }
  
  public void a(int paramInt, qeq paramqeq, ArrayList<VideoInfo> paramArrayList)
  {
    if ((paramqeq == null) || (paramqeq.a == null) || (!this.jdField_c_of_type_Boolean)) {}
    for (;;)
    {
      return;
      if (!paramqeq.a.jdField_c_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount=" + this.j);
        }
        b(paramInt, paramqeq, paramArrayList);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("VideoAdExposureManager", 2, "onVideoStart , mPlayVmCount =" + this.j);
        return;
        this.j = 0;
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount= 0 ");
        }
      }
    }
  }
  
  public void a(VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    if (paramVideoAdInfo != null)
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      boolean bool1 = this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
      boolean bool2 = this.jdField_c_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
      if ((!bool1) && (localVideoInfo == null) && (!bool2))
      {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
        paramVideoAdInfo = nbe.a(paramVideoAdInfo);
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd !!! , pos=" + paramInt);
        }
        a(paramVideoAdInfo, paramInt, this.jdField_a_of_type_Int, 5);
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchChangePosAd insert wait pos = " + paramInt);
    }
    a(nbe.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo), paramInt, this.jdField_b_of_type_Int, 6);
  }
  
  public void a(qag paramqag)
  {
    try
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if ((paramqag != null) && (paramqag.a != null) && (paramqag.a.a != null) && (paramqag.a.a.jdField_c_of_type_Boolean) && (paramqag.a.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
        {
          d(paramqag.jdField_b_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAndRecord reset notCountFlag , mPlayingVideoHolder.position=" + paramqag.jdField_b_of_type_Int);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    boolean bool1 = true;
    int m;
    int k;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAdPos , hasQueryParam= " + this.jdField_b_of_type_Boolean + " ,needChangeAdPos =" + this.jdField_c_of_type_Boolean);
        }
        if (this.jdField_b_of_type_Boolean)
        {
          boolean bool2 = this.jdField_c_of_type_Boolean;
          if (!bool2) {
            return;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAdPos enter, hasNewVideo= " + paramBoolean + " ,newSize =" + paramInt);
        }
        if ((paramBoolean) && (paramInt > 1))
        {
          m = paramArrayList.size();
          k = m - paramInt;
          paramInt = k;
          if (paramInt >= paramArrayList.size()) {
            break label735;
          }
          if ((((VideoInfo)paramArrayList.get(paramInt)).jdField_c_of_type_Boolean) && (((VideoInfo)paramArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
          {
            label176:
            if (paramInt != -1) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "checkAdPos can not find Ad !!");
            }
          }
          else
          {
            paramInt += 1;
          }
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "checkAdPos findAdIndex = " + paramInt);
    }
    VideoInfo localVideoInfo = (VideoInfo)paramArrayList.get(paramInt);
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      if ((!npi.f(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) || (!this.jdField_d_of_type_Boolean)) {
        break label740;
      }
    }
    label735:
    label740:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      int n;
      for (;;)
      {
        this.jdField_c_of_type_Boolean = paramBoolean;
        Object localObject = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v;
        try
        {
          localObject = new JSONObject((String)localObject);
          this.g = ((JSONObject)localObject).optInt("ad_first_pos", 3);
          this.h = ((JSONObject)localObject).optInt("ad_interval", 3);
          this.i = ((JSONObject)localObject).optInt("ad_protect_interval", 2);
          if (QLog.isColorLevel())
          {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos needChangeAdPos = " + this.jdField_c_of_type_Boolean);
            QLog.d("VideoAdExposureManager", 2, "checkAdPos ad_first_pos = " + this.g + ",ad_interval=" + this.h + ",ad_protect_interval=" + this.i);
          }
          if (!this.jdField_c_of_type_Boolean) {
            break;
          }
          if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VideoAdExposureManager", 2, "mInsertAdPos.isEmpty()");
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            this.jdField_c_of_type_Boolean = false;
          }
          n = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).intValue();
          if ((m - 1 > n) && (n >= k))
          {
            if (paramInt == n) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "checkAdPos change findAdIndex=" + paramInt + ", lastNeedInsertAdPos=" + n);
            }
            if (n >= paramArrayList.size()) {
              break;
            }
            paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(n));
            paramArrayList.set(n, localVideoInfo);
          }
        }
      }
      if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) {
        break;
      }
      k = n + this.i;
      if (k <= paramInt) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "checkAdPos change findAdIndex=" + paramInt + ", lastNeedInsertAdPos=" + n + ", minAdIndex=" + k);
      }
      if (k >= paramArrayList.size()) {
        break;
      }
      paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(k));
      paramArrayList.set(k, localVideoInfo);
      d(k);
      break;
      paramInt = -1;
      break label176;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = this.jdField_b_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "isNeedShowAnotherAd pos=" + paramInt + ",result =" + bool);
    }
    return bool;
  }
  
  public int b(int paramInt)
  {
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (localInteger.intValue() > paramInt) {
        return localInteger.intValue();
      }
      k += 1;
    }
    return -1;
  }
  
  public VideoInfo b(int paramInt)
  {
    boolean bool = this.jdField_d_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((bool) && (localVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady replace at =" + this.e + ", currentAdpaterPosition=" + paramInt);
      }
      this.jdField_d_of_type_AndroidUtilSparseBooleanArray.put(paramInt, false);
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt);
      return localVideoInfo;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    if ((VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, false);
    }
  }
  
  public void b(int paramInt, qeq paramqeq, ArrayList<VideoInfo> paramArrayList)
  {
    boolean bool;
    label25:
    int m;
    label111:
    int n;
    label250:
    do
    {
      do
      {
        do
        {
          try
          {
            paramqeq = paramqeq.a;
            if (paramqeq != null)
            {
              bool = paramqeq.jdField_c_of_type_Boolean;
              if (!bool) {
                break label25;
              }
            }
            for (;;)
            {
              return;
              if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
                break;
              }
              if (QLog.isColorLevel())
              {
                if (!this.jdField_c_of_type_Boolean) {
                  QLog.d("VideoAdExposureManager", 2, "命中 调整广告位置的开关关闭 ");
                }
                if (this.jdField_a_of_type_Boolean) {
                  QLog.d("VideoAdExposureManager", 2, "该位置已经 触发过判断的情况");
                }
              }
            }
            this.j += 1;
          }
          finally {}
          m = b(paramInt);
          if (m == -1) {
            break;
          }
          k = 1;
          if (QLog.isColorLevel())
          {
            QLog.d("VideoAdExposureManager", 2, "nextAdPos =" + m);
            QLog.d("VideoAdExposureManager", 2, "insertAd , mPlayVmCount=" + this.j);
          }
        } while ((k == 0) && (paramArrayList.size() > paramInt + 1) && (((VideoInfo)paramArrayList.get(paramInt + 1)).jdField_c_of_type_Boolean));
        n = a(paramInt);
        if ((n == -1) && (paramInt < this.g) && (this.j >= this.g)) {
          break;
        }
        if (this.j < this.h) {
          break label798;
        }
        break;
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "isCountEnough =" + bool + ",position =" + paramInt + ",lastAdPos1 =" + n);
        }
      } while (!bool);
      this.j = 0;
      this.jdField_a_of_type_Boolean = true;
      if (k != 0) {
        break label631;
      }
      n = a(paramInt);
      if (n != -1) {
        break;
      }
      m = paramInt + 1;
      d(m);
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , lastAdPos =" + n + " ，recordAdPos =" + m);
      }
    } while (m >= paramArrayList.size());
    label342:
    int k = paramInt;
    for (;;)
    {
      if (k < paramArrayList.size())
      {
        if (!((VideoInfo)paramArrayList.get(k)).jdField_c_of_type_Boolean) {}
      }
      else
      {
        for (;;)
        {
          paramqeq = null;
          if (k == -1) {
            if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
            {
              paramqeq = (VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0);
              this.jdField_b_of_type_JavaUtilArrayList.remove(0);
            }
          }
          for (;;)
          {
            if ((paramqeq != null) || (n == -1) || (n >= paramArrayList.size())) {
              break label587;
            }
            a((VideoInfo)paramArrayList.get(n), m);
            break;
            m = Math.max(this.i + n + 1, paramInt + 1);
            break label342;
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , findPos =" + k + " ，startPos =" + paramInt);
            }
            paramqeq = (VideoInfo)paramArrayList.get(k);
            paramArrayList.remove(k);
          }
          label587:
          if (paramqeq == null) {
            break;
          }
          paramArrayList.add(m, paramqeq);
          if (this.jdField_a_of_type_Pzs != null) {
            this.jdField_a_of_type_Pzs.b(paramqeq);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , move!!! and notify!!! ");
          break;
          label631:
          if (m >= paramArrayList.size()) {
            break;
          }
          paramqeq = (VideoInfo)paramArrayList.get(m);
          if ((paramqeq == null) || (!paramqeq.jdField_c_of_type_Boolean) || (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (this.jdField_a_of_type_Pzs == null) || (!this.jdField_a_of_type_Pzs.a(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h))) {
            break;
          }
          VideoInfo localVideoInfo = (VideoInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(m);
          paramqeq = localVideoInfo;
          if (localVideoInfo == null)
          {
            paramqeq = localVideoInfo;
            if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
            {
              paramqeq = (VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0);
              this.jdField_b_of_type_JavaUtilArrayList.remove(0);
            }
          }
          if (paramqeq != null)
          {
            b(paramqeq, m);
            break;
          }
          a((VideoInfo)paramArrayList.get(m), m);
          break;
          k = -1;
        }
        bool = true;
        break label250;
        k = 0;
        break label111;
        label798:
        bool = false;
        break label250;
      }
      k += 1;
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    this.jdField_c_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "removeCacheVideoInfo ");
    }
  }
  
  public void d(int paramInt)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "recordAdPos recordAdPos=" + paramInt);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pys
 * JD-Core Version:    0.7.0.1
 */