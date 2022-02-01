package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdStrategyReportData;
import com.tencent.mobileqq.kandian.biz.ad.report.VideoAdTimeReportData;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.LiveStatus;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoInfo
  implements Parcelable, IEntranceButtonDataSource
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new VideoInfo.1();
  public int a;
  public long a;
  public MessageForShortVideo a;
  public VideoAdInfo a;
  public VideoAdStrategyReportData a;
  public VideoAdTimeReportData a;
  public StressState a;
  public UGDownloadInfo a;
  public VideoInfo.AdTagInfo a;
  public VideoInfo.DownloadBarInfo a;
  public VideoInfo.ECommerceEntranceInfo a;
  public VideoInfo.InterruptedWeishiAd a;
  public VideoInfo.LikeActionDownloadBar a;
  public VideoInfo.LocationInfo a;
  public VideoInfo.SoftAdDownloadBarInfo a;
  public VideoInfo.SubscriptInfo a;
  public VideoInfo.TopBarInfo a;
  public VideoInfo.VideoHistoryAction a;
  public AbsBaseArticleInfo a;
  public LiveStatus a;
  public VideoColumnInfo a;
  public Object a;
  public String a;
  public ArrayList<String> a;
  public HashSet<String> a;
  public boolean a;
  protected Object[] a;
  public int b;
  public long b;
  public UGDownloadInfo b;
  public String b;
  public ArrayList<DislikeInfo> b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public ArrayList<VideoInfo> c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public ArrayList<RichTitleInfo> d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public boolean h;
  public int i;
  public String i;
  public boolean i;
  public int j;
  public String j;
  public boolean j;
  public int k;
  public String k;
  public boolean k;
  public int l;
  public String l;
  public boolean l;
  public int m;
  public String m;
  public boolean m;
  public int n;
  public String n;
  public boolean n;
  public int o;
  public String o;
  public boolean o;
  public int p;
  public String p;
  public boolean p;
  public int q;
  public String q;
  public boolean q;
  public int r;
  public String r;
  public boolean r;
  public int s;
  public String s;
  protected boolean s;
  public int t;
  public String t;
  public int u;
  public String u;
  public int v;
  public String v;
  public String w;
  public String x;
  public String y;
  
  public VideoInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_o_of_type_Int = 0;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_q_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.t = 1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportVideoAdTimeReportData = new VideoAdTimeReportData();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdStrategyReportData = new VideoAdStrategyReportData();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState = StressState.Shrink;
    this.jdField_s_of_type_Boolean = true;
  }
  
  public VideoInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    boolean bool2 = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_o_of_type_Int = 0;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_q_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.t = 1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportVideoAdTimeReportData = new VideoAdTimeReportData();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdStrategyReportData = new VideoAdStrategyReportData();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState = StressState.Shrink;
    this.jdField_s_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramParcel.readParcelable(MessageForShortVideo.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_JavaLangString = paramParcel.readString();
    this.jdField_h_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_i_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(DislikeInfo.CREATOR);
    this.jdField_j_of_type_JavaLangString = paramParcel.readString();
    this.jdField_k_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_b_of_type_Boolean = bool1;
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_l_of_type_JavaLangString = paramParcel.readString();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_o_of_type_JavaLangString = paramParcel.readString();
    this.jdField_p_of_type_JavaLangString = paramParcel.readString();
    this.jdField_q_of_type_JavaLangString = paramParcel.readString();
    this.jdField_r_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Long = paramParcel.readLong();
    this.jdField_h_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)paramParcel.readParcelable(AbsBaseArticleInfo.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_r_of_type_Boolean = bool1;
    this.t = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo = ((VideoAdInfo)paramParcel.readParcelable(VideoAdInfo.class.getClassLoader()));
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_d_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_e_of_type_Boolean = bool1;
    this.jdField_i_of_type_Int = paramParcel.readInt();
    this.jdField_j_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)paramParcel.readParcelable(VideoInfo.TopBarInfo.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd = ((VideoInfo.InterruptedWeishiAd)paramParcel.readParcelable(VideoInfo.InterruptedWeishiAd.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$DownloadBarInfo = ((VideoInfo.DownloadBarInfo)paramParcel.readParcelable(VideoInfo.DownloadBarInfo.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo = ((VideoInfo.ECommerceEntranceInfo)paramParcel.readParcelable(VideoInfo.ECommerceEntranceInfo.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_s_of_type_Boolean = bool1;
    this.jdField_k_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Long = paramParcel.readLong();
    this.jdField_p_of_type_Int = paramParcel.readInt();
    this.jdField_q_of_type_Int = paramParcel.readInt();
    this.jdField_r_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_p_of_type_Boolean = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_q_of_type_Boolean = bool1;
    this.jdField_s_of_type_Int = paramParcel.readInt();
    this.w = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityStressState = StressState.valueOf(paramParcel.readString());
    this.x = paramParcel.readString();
    this.jdField_e_of_type_Long = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_f_of_type_Boolean = bool1;
    this.jdField_s_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readByte() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_g_of_type_Boolean = bool1;
    this.jdField_c_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(CREATOR);
    this.jdField_l_of_type_Int = paramParcel.readInt();
    this.jdField_m_of_type_Int = paramParcel.readInt();
    this.jdField_u_of_type_JavaLangString = paramParcel.readString();
    this.jdField_n_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_j_of_type_Boolean = bool1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar = ((VideoInfo.LikeActionDownloadBar)paramParcel.readParcelable(VideoInfo.LikeActionDownloadBar.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo = ((VideoColumnInfo)paramParcel.readParcelable(VideoColumnInfo.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo = ((VideoInfo.SoftAdDownloadBarInfo)paramParcel.readParcelable(VideoInfo.SoftAdDownloadBarInfo.class.getClassLoader()));
    this.jdField_m_of_type_JavaLangString = paramParcel.readString();
    this.jdField_n_of_type_JavaLangString = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_k_of_type_Boolean = bool1;
    this.jdField_v_of_type_JavaLangString = paramParcel.readString();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_l_of_type_Boolean = bool1;
    this.jdField_d_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(RichTitleInfo.CREATOR);
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.jdField_m_of_type_Boolean = bool1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo = ((VideoInfo.SubscriptInfo)paramParcel.readParcelable(VideoInfo.SubscriptInfo.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo = ((VideoInfo.LocationInfo)paramParcel.readParcelable(VideoInfo.LocationInfo.class.getClassLoader()));
    this.jdField_u_of_type_Int = paramParcel.readInt();
    this.jdField_v_of_type_Int = paramParcel.readInt();
    this.y = paramParcel.readString();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (localMessageForShortVideo != null) {
        return localMessageForShortVideo.thumbWidth;
      }
    }
    return this.jdField_b_of_type_Int;
  }
  
  public int a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity);
    }
    return ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[1]).intValue();
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    return ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).computeXYaxis(paramActivity, this, paramInt);
  }
  
  public String a()
  {
    return this.jdField_s_of_type_JavaLangString;
  }
  
  public URL a()
  {
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (localObject != null)
      {
        localObject = SVUtils.a(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        return ((IVideoPlayUtils)QRoute.api(IVideoPlayUtils.class)).getThumbUrl((String)localObject);
      }
    }
    try
    {
      localObject = new URL(this.jdField_b_of_type_JavaLangString);
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = null;
  }
  
  protected void a(Activity paramActivity)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject = ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).calculateVideoAreaHeight(paramActivity, a(), b());
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder("VideoInfo innerInitVideoAreaHeightInfo() ");
      paramActivity.append("videoAreaHeightInfo[0]=");
      paramActivity.append(this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      paramActivity.append(", videoAreaHeightInfo[1]=");
      paramActivity.append(this.jdField_a_of_type_ArrayOfJavaLangObject[1]);
      paramActivity.append(", videoAreaHeightInfo[2]=");
      paramActivity.append(this.jdField_a_of_type_ArrayOfJavaLangObject[2]);
      QLog.d("AbsVideoInfo", 2, paramActivity.toString());
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_Int = paramVideoInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    this.jdField_a_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramVideoInfo.jdField_c_of_type_Int;
    this.jdField_d_of_type_Int = paramVideoInfo.jdField_d_of_type_Int;
    this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramVideoInfo.jdField_c_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramVideoInfo.jdField_d_of_type_JavaLangString;
    this.jdField_e_of_type_JavaLangString = paramVideoInfo.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_Long = paramVideoInfo.jdField_a_of_type_Long;
    this.jdField_f_of_type_JavaLangString = paramVideoInfo.jdField_f_of_type_JavaLangString;
    this.jdField_g_of_type_JavaLangString = paramVideoInfo.jdField_g_of_type_JavaLangString;
    this.jdField_h_of_type_JavaLangString = paramVideoInfo.jdField_h_of_type_JavaLangString;
    this.jdField_b_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    this.jdField_i_of_type_JavaLangString = paramVideoInfo.jdField_i_of_type_JavaLangString;
    this.jdField_e_of_type_Int = paramVideoInfo.jdField_e_of_type_Int;
    this.jdField_b_of_type_JavaUtilArrayList = paramVideoInfo.jdField_b_of_type_JavaUtilArrayList;
    this.jdField_j_of_type_JavaLangString = paramVideoInfo.jdField_j_of_type_JavaLangString;
    this.jdField_k_of_type_JavaLangString = paramVideoInfo.jdField_k_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramVideoInfo.jdField_a_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramVideoInfo.jdField_b_of_type_Boolean;
    this.jdField_c_of_type_Long = paramVideoInfo.jdField_c_of_type_Long;
    this.jdField_l_of_type_JavaLangString = paramVideoInfo.jdField_l_of_type_JavaLangString;
    this.jdField_f_of_type_Int = paramVideoInfo.jdField_f_of_type_Int;
    this.jdField_o_of_type_JavaLangString = paramVideoInfo.jdField_o_of_type_JavaLangString;
    this.jdField_p_of_type_JavaLangString = paramVideoInfo.jdField_p_of_type_JavaLangString;
    this.jdField_q_of_type_JavaLangString = paramVideoInfo.jdField_q_of_type_JavaLangString;
    this.jdField_r_of_type_JavaLangString = paramVideoInfo.jdField_r_of_type_JavaLangString;
    this.jdField_d_of_type_Long = paramVideoInfo.jdField_d_of_type_Long;
    this.jdField_h_of_type_Int = paramVideoInfo.jdField_h_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    this.jdField_r_of_type_Boolean = paramVideoInfo.jdField_r_of_type_Boolean;
    this.t = paramVideoInfo.t;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo;
    this.jdField_a_of_type_JavaUtilArrayList = paramVideoInfo.jdField_a_of_type_JavaUtilArrayList;
    this.jdField_c_of_type_Boolean = paramVideoInfo.jdField_c_of_type_Boolean;
    this.jdField_d_of_type_Boolean = paramVideoInfo.jdField_d_of_type_Boolean;
    this.jdField_e_of_type_Boolean = paramVideoInfo.jdField_e_of_type_Boolean;
    this.jdField_i_of_type_Int = paramVideoInfo.jdField_i_of_type_Int;
    this.jdField_j_of_type_Int = paramVideoInfo.jdField_j_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$TopBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$TopBarInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$DownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$DownloadBarInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo;
    this.jdField_s_of_type_Boolean = paramVideoInfo.jdField_s_of_type_Boolean;
    this.jdField_k_of_type_Int = paramVideoInfo.jdField_k_of_type_Int;
    this.jdField_f_of_type_Long = paramVideoInfo.jdField_f_of_type_Long;
    this.jdField_p_of_type_Int = paramVideoInfo.jdField_p_of_type_Int;
    this.jdField_q_of_type_Int = paramVideoInfo.jdField_q_of_type_Int;
    this.jdField_r_of_type_Int = paramVideoInfo.jdField_r_of_type_Int;
    this.jdField_p_of_type_Boolean = paramVideoInfo.jdField_p_of_type_Boolean;
    this.jdField_q_of_type_Boolean = paramVideoInfo.jdField_q_of_type_Boolean;
    this.jdField_s_of_type_Int = paramVideoInfo.jdField_s_of_type_Int;
    this.w = paramVideoInfo.w;
    this.x = paramVideoInfo.x;
    this.jdField_e_of_type_Long = paramVideoInfo.jdField_e_of_type_Long;
    this.jdField_f_of_type_Boolean = paramVideoInfo.jdField_f_of_type_Boolean;
    this.jdField_s_of_type_JavaLangString = paramVideoInfo.jdField_s_of_type_JavaLangString;
    this.jdField_g_of_type_Boolean = paramVideoInfo.jdField_g_of_type_Boolean;
    this.jdField_m_of_type_Int = paramVideoInfo.jdField_m_of_type_Int;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localAbsBaseArticleInfo != null) {
      localAbsBaseArticleInfo.mArticleID = this.jdField_c_of_type_Long;
    }
    this.jdField_u_of_type_JavaLangString = paramVideoInfo.jdField_u_of_type_JavaLangString;
    this.jdField_n_of_type_Int = paramVideoInfo.jdField_n_of_type_Int;
    this.jdField_j_of_type_Boolean = paramVideoInfo.jdField_j_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$AdTagInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$AdTagInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo;
    this.jdField_m_of_type_JavaLangString = paramVideoInfo.jdField_m_of_type_JavaLangString;
    this.jdField_n_of_type_JavaLangString = paramVideoInfo.jdField_n_of_type_JavaLangString;
    this.jdField_k_of_type_Boolean = paramVideoInfo.jdField_k_of_type_Boolean;
    this.jdField_v_of_type_JavaLangString = paramVideoInfo.jdField_v_of_type_JavaLangString;
    this.jdField_g_of_type_Int = paramVideoInfo.jdField_g_of_type_Int;
    this.jdField_l_of_type_Boolean = paramVideoInfo.jdField_l_of_type_Boolean;
    this.jdField_d_of_type_JavaUtilArrayList = paramVideoInfo.jdField_d_of_type_JavaUtilArrayList;
    this.jdField_m_of_type_Boolean = paramVideoInfo.jdField_m_of_type_Boolean;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo;
    this.jdField_v_of_type_Int = paramVideoInfo.jdField_v_of_type_Int;
    this.y = paramVideoInfo.y;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity);
    }
    return ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[3]).booleanValue();
  }
  
  public int[] a(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    return ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getLogoMarginSize(paramActivity, this, paramBoolean, paramInt);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (localMessageForShortVideo != null) {
        return localMessageForShortVideo.thumbHeight;
      }
    }
    return this.jdField_c_of_type_Int;
  }
  
  public int b(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity);
    }
    return ((Integer)this.jdField_a_of_type_ArrayOfJavaLangObject[2]).intValue();
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("rpt_biu_mutli_level");
      int i1 = 0;
      while (i1 < paramString.length())
      {
        RichTitleInfo localRichTitleInfo = new RichTitleInfo((JSONObject)paramString.get(i1));
        this.jdField_d_of_type_JavaUtilArrayList.add(localRichTitleInfo);
        i1 += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public boolean b(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangObject == null) {
      a(paramActivity);
    }
    return ((Boolean)this.jdField_a_of_type_ArrayOfJavaLangObject[0]).booleanValue();
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (localMessageForShortVideo != null) {
        return localMessageForShortVideo.videoFileTime;
      }
    }
    return this.jdField_d_of_type_Int;
  }
  
  public String c()
  {
    return null;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return 1;
    }
    if ((this.jdField_r_of_type_Boolean) && (this.t == 1)) {
      return 3;
    }
    if ((this.jdField_r_of_type_Boolean) && (this.t == 2)) {
      return 4;
    }
    return 2;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (localMessageForShortVideo != null) {
        return localMessageForShortVideo.getMd5();
      }
    }
    return null;
  }
  
  public boolean d()
  {
    VideoColumnInfo localVideoColumnInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo;
    if (localVideoColumnInfo != null) {
      return localVideoColumnInfo.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    localStringBuilder1.append("VideoInfo[");
    localStringBuilder1.append("busiType=");
    localStringBuilder1.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("width=");
    localStringBuilder1.append(a());
    localStringBuilder1.append(", ");
    localStringBuilder1.append("height=");
    localStringBuilder1.append(b());
    localStringBuilder1.append(", ");
    if (this.jdField_a_of_type_Int == 0)
    {
      localStringBuilder1.append("msg=");
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (localObject == null) {
        localObject = "null ERROR";
      } else {
        localObject = ((MessageForShortVideo)localObject).toLogString();
      }
      localStringBuilder1.append((String)localObject);
    }
    else
    {
      localStringBuilder1.append("vid=");
      localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("articleID=");
      localStringBuilder1.append(this.jdField_g_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("title=");
      localStringBuilder1.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("duration=");
      localStringBuilder1.append(this.jdField_d_of_type_Int);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("coverUrl=");
      localStringBuilder1.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("summary=");
      localStringBuilder1.append(this.jdField_d_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("createTime=");
      localStringBuilder1.append(this.jdField_e_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("createTimeStamp=");
      localStringBuilder1.append(this.jdField_a_of_type_Long);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("webUrl=");
      localStringBuilder1.append(this.jdField_f_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("recommendReason=");
      localStringBuilder1.append(this.jdField_h_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("accountUin=");
      localStringBuilder1.append(this.jdField_j_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("accountName=");
      localStringBuilder1.append(this.jdField_k_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("isVerified=");
      localStringBuilder1.append(this.jdField_a_of_type_Boolean);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("biuCount=");
      localStringBuilder1.append(this.jdField_f_of_type_Int);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("commentCount=");
      localStringBuilder1.append(this.jdField_e_of_type_Int);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("playCount=");
      localStringBuilder1.append(this.jdField_q_of_type_Int);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("likeCount=");
      localStringBuilder1.append(this.jdField_r_of_type_Int);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("isDianZan=");
      localStringBuilder1.append(this.jdField_q_of_type_Boolean);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("dianZanCount=");
      localStringBuilder1.append(this.jdField_s_of_type_Int);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("thirdAction=");
      localStringBuilder1.append(this.jdField_o_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("thirdIconUrl=");
      localStringBuilder1.append(this.jdField_p_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("xgFileSize=");
      localStringBuilder1.append(this.jdField_b_of_type_Long);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("isUgc=");
      localStringBuilder1.append(this.jdField_b_of_type_Boolean);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("isFollowed=");
      localStringBuilder1.append(this.jdField_p_of_type_Boolean);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("aioShareUrl=");
      localStringBuilder1.append(this.jdField_m_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("qzoneShareUrl=");
      localStringBuilder1.append(this.jdField_n_of_type_JavaLangString);
      localStringBuilder1.append(", ");
    }
    if (this.jdField_a_of_type_Int == 6)
    {
      localStringBuilder1.append("video_url=");
      localStringBuilder1.append(this.jdField_r_of_type_JavaLangString);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("feedId=");
      localStringBuilder1.append(this.jdField_d_of_type_Long);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("feedType=");
      localStringBuilder1.append(this.jdField_h_of_type_Int);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("articleInfo.mArticleID=");
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (localObject == null) {
        localObject = "articleInfo null";
      } else {
        localObject = Long.valueOf(((AbsBaseArticleInfo)localObject).mArticleID);
      }
      localStringBuilder1.append(localObject);
      localStringBuilder1.append(", ");
    }
    localStringBuilder1.append("isAD=");
    localStringBuilder1.append(this.jdField_r_of_type_Boolean);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("adType=");
    localStringBuilder1.append(this.t);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("recommendBarrageList=[");
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder1.append((String)((Iterator)localObject).next());
        localStringBuilder1.append(", ");
      }
    }
    localStringBuilder1.append("]");
    localStringBuilder1.append(", ");
    localStringBuilder1.append("topBarInfo=[");
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$TopBarInfo;
    if (localObject != null) {
      localStringBuilder1.append(((VideoInfo.TopBarInfo)localObject).toString());
    }
    localStringBuilder1.append("]");
    localStringBuilder1.append(", ");
    localStringBuilder1.append("interruptedWeishiAd=[");
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$InterruptedWeishiAd;
    if (localObject != null) {
      localStringBuilder1.append(((VideoInfo.InterruptedWeishiAd)localObject).toString());
    }
    localStringBuilder1.append("]");
    localStringBuilder1.append(", ");
    localStringBuilder1.append("commerceEntranceInfo=[");
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$ECommerceEntranceInfo;
    if (localObject != null) {
      localStringBuilder1.append(((VideoInfo.ECommerceEntranceInfo)localObject).toString());
    }
    localStringBuilder1.append("]");
    localStringBuilder1.append(", ");
    localStringBuilder1.append("downloadBarinfo=[");
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$DownloadBarInfo;
    if (localObject != null) {
      localStringBuilder1.append(((VideoInfo.DownloadBarInfo)localObject).toString());
    }
    localStringBuilder1.append("]");
    localStringBuilder1.append(", ");
    if (this.jdField_d_of_type_JavaUtilArrayList != null)
    {
      localStringBuilder1.append("richTitleInfo=[");
      localObject = this.jdField_d_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RichTitleInfo localRichTitleInfo = (RichTitleInfo)((Iterator)localObject).next();
        if (localRichTitleInfo != null)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(localRichTitleInfo.jdField_c_of_type_JavaLangString);
          localStringBuilder2.append(" ");
          localStringBuilder2.append(localRichTitleInfo.jdField_a_of_type_JavaLangString);
          localStringBuilder1.append(localStringBuilder2.toString());
        }
      }
      localStringBuilder1.append("]");
    }
    localStringBuilder1.append("videoReportInfo=");
    localStringBuilder1.append(this.w);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("avatarJumpUrl=");
    localStringBuilder1.append(this.x);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("dynamicInsertTriggerSec=");
    localStringBuilder1.append(this.jdField_m_of_type_Int);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("videoLogoUrl=");
    localStringBuilder1.append(this.jdField_u_of_type_JavaLangString);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("followCount=");
    localStringBuilder1.append(this.jdField_n_of_type_Int);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("isShowStressFollow=");
    localStringBuilder1.append(this.jdField_j_of_type_Boolean);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("likeActionDownloadBar=");
    localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LikeActionDownloadBar);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("videoColumnInfo=");
    localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("columnId=");
    localStringBuilder1.append(this.jdField_g_of_type_Int);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("softAdDownloadBarInfo=");
    localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SoftAdDownloadBarInfo);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("wechatShareUrl=");
    localStringBuilder1.append(this.jdField_v_of_type_JavaLangString);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("]");
    localStringBuilder1.append("isUseGif=");
    localStringBuilder1.append(this.jdField_f_of_type_Boolean);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("gifUrl=");
    localStringBuilder1.append(this.jdField_s_of_type_JavaLangString);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("isShowCover=");
    localStringBuilder1.append(this.jdField_g_of_type_Boolean);
    localStringBuilder1.append("]");
    localStringBuilder1.append("isForbidReprint=");
    localStringBuilder1.append(this.jdField_k_of_type_Boolean);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("subscriptInfo=");
    localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$SubscriptInfo);
    localStringBuilder1.append(", ");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo != null)
    {
      localStringBuilder1.append("locationInfo=");
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$LocationInfo);
      localStringBuilder1.append(", ");
    }
    localStringBuilder1.append("shareCount=");
    localStringBuilder1.append(this.jdField_v_of_type_Int);
    localStringBuilder1.append(", ");
    return localStringBuilder1.toString();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo != null;
  }
  
  public String f()
  {
    if ((this.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(d()))) {
      return d();
    }
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      return this.jdField_g_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null);
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null;
  }
  
  public boolean h()
  {
    return (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoInfo{vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleID='");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.jdField_r_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recommendSeq=");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo
 * JD-Core Version:    0.7.0.1
 */