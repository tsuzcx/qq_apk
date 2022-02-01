package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
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

@IgnoreDenyDependencyToSelf
public class VideoInfo
  implements Parcelable, IEntranceButtonDataSource
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new VideoInfo.1();
  public String A;
  public String B;
  public String C;
  public String D;
  public long E;
  public int F;
  public ArrayList<String> G = new ArrayList();
  public boolean H;
  public HashSet<String> I;
  public boolean J;
  public boolean K;
  public int L;
  public int M;
  public long N;
  public int O;
  public boolean P;
  public String Q;
  public boolean R;
  public int S;
  public boolean T;
  public int U;
  public boolean V;
  public String W;
  public String X;
  public int Y;
  public boolean Z;
  public int a;
  public UGDownloadInfo aA;
  public AbsBaseArticleInfo aB;
  public VideoInfo.AdTagInfo aC;
  public VideoInfo.TopBarInfo aD;
  public VideoInfo.InterruptedWeishiAd aE;
  public VideoInfo.DownloadBarInfo aF;
  public VideoInfo.ECommerceEntranceInfo aG;
  public ArrayList<VideoInfo> aH;
  public VideoInfo.VideoHistoryAction aI;
  public VideoInfo.LikeActionDownloadBar aJ;
  public VideoInfo.SoftAdDownloadBarInfo aK;
  public ArrayList<RichTitleInfo> aL;
  public VideoInfo.SubscriptInfo aM;
  public VideoInfo.LocationInfo aN;
  public LiveStatus aO;
  public StressState aP;
  public MessageForShortVideo aQ;
  protected boolean aR;
  protected Object[] aS;
  public Object aT;
  public String aU;
  public boolean aa;
  public String ab;
  public boolean ac;
  public boolean ad;
  public int ae;
  public boolean af;
  public boolean ag;
  public long ah;
  public int ai;
  public int aj;
  public int ak;
  public boolean al;
  public boolean am;
  public int an;
  public String ao;
  public String ap;
  public boolean aq;
  public int ar;
  public VideoAdInfo as;
  public VideoAdTimeReportData at;
  public VideoAdStrategyReportData au;
  public int av;
  public int aw;
  public ArrayList<DislikeInfo> ax;
  public VideoColumnInfo ay;
  public UGDownloadInfo az;
  public String b;
  public int c;
  public int d;
  public int e;
  public String f;
  public String g;
  public String h;
  public String i;
  public long j;
  public String k;
  public String l;
  public String m;
  public long n;
  public String o;
  public int p;
  public String q;
  public String r;
  public boolean s;
  public boolean t;
  public long u;
  public String v;
  public int w;
  public int x;
  public String y;
  public String z;
  
  public VideoInfo()
  {
    this.H = false;
    this.I = new HashSet();
    this.J = false;
    this.K = false;
    this.L = 0;
    this.M = 0;
    this.O = 0;
    this.R = true;
    this.T = true;
    this.V = false;
    this.aa = false;
    this.ac = false;
    this.ae = 0;
    this.af = false;
    this.ag = false;
    this.aj = 0;
    this.ak = 0;
    this.al = false;
    this.am = false;
    this.aq = false;
    this.ar = 1;
    this.at = new VideoAdTimeReportData();
    this.au = new VideoAdStrategyReportData();
    this.aP = StressState.Shrink;
    this.aR = true;
  }
  
  public VideoInfo(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.H = false;
    this.I = new HashSet();
    this.J = false;
    this.K = false;
    this.L = 0;
    this.M = 0;
    this.O = 0;
    this.R = true;
    this.T = true;
    this.V = false;
    this.aa = false;
    this.ac = false;
    this.ae = 0;
    this.af = false;
    this.ag = false;
    this.aj = 0;
    this.ak = 0;
    this.al = false;
    this.am = false;
    this.aq = false;
    this.ar = 1;
    this.at = new VideoAdTimeReportData();
    this.au = new VideoAdStrategyReportData();
    this.aP = StressState.Shrink;
    this.aR = true;
    this.a = paramParcel.readInt();
    this.aQ = ((MessageForShortVideo)paramParcel.readParcelable(MessageForShortVideo.class.getClassLoader()));
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
    this.j = paramParcel.readLong();
    this.k = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readString();
    this.n = paramParcel.readLong();
    this.o = paramParcel.readString();
    this.p = paramParcel.readInt();
    this.ax = paramParcel.createTypedArrayList(DislikeInfo.CREATOR);
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.s = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.t = bool1;
    this.u = paramParcel.readLong();
    this.v = paramParcel.readString();
    this.w = paramParcel.readInt();
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
    this.C = paramParcel.readString();
    this.D = paramParcel.readString();
    this.E = paramParcel.readLong();
    this.F = paramParcel.readInt();
    this.aB = ((AbsBaseArticleInfo)paramParcel.readParcelable(AbsBaseArticleInfo.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.aq = bool1;
    this.ar = paramParcel.readInt();
    this.as = ((VideoAdInfo)paramParcel.readParcelable(VideoAdInfo.class.getClassLoader()));
    this.G = paramParcel.createStringArrayList();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.H = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.J = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.K = bool1;
    this.L = paramParcel.readInt();
    this.M = paramParcel.readInt();
    this.aD = ((VideoInfo.TopBarInfo)paramParcel.readParcelable(VideoInfo.TopBarInfo.class.getClassLoader()));
    this.aE = ((VideoInfo.InterruptedWeishiAd)paramParcel.readParcelable(VideoInfo.InterruptedWeishiAd.class.getClassLoader()));
    this.aF = ((VideoInfo.DownloadBarInfo)paramParcel.readParcelable(VideoInfo.DownloadBarInfo.class.getClassLoader()));
    this.aG = ((VideoInfo.ECommerceEntranceInfo)paramParcel.readParcelable(VideoInfo.ECommerceEntranceInfo.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.aR = bool1;
    this.O = paramParcel.readInt();
    this.ah = paramParcel.readLong();
    this.ai = paramParcel.readInt();
    this.aj = paramParcel.readInt();
    this.ak = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.al = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.am = bool1;
    this.an = paramParcel.readInt();
    this.ao = paramParcel.readString();
    this.aP = StressState.valueOf(paramParcel.readString());
    this.ap = paramParcel.readString();
    this.N = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.P = bool1;
    this.Q = paramParcel.readString();
    if (paramParcel.readByte() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.R = bool1;
    this.aH = paramParcel.createTypedArrayList(CREATOR);
    this.S = paramParcel.readInt();
    this.U = paramParcel.readInt();
    this.X = paramParcel.readString();
    this.Y = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.Z = bool1;
    this.aJ = ((VideoInfo.LikeActionDownloadBar)paramParcel.readParcelable(VideoInfo.LikeActionDownloadBar.class.getClassLoader()));
    this.ay = ((VideoColumnInfo)paramParcel.readParcelable(VideoColumnInfo.class.getClassLoader()));
    this.aK = ((VideoInfo.SoftAdDownloadBarInfo)paramParcel.readParcelable(VideoInfo.SoftAdDownloadBarInfo.class.getClassLoader()));
    this.y = paramParcel.readString();
    this.z = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.aa = bool1;
    this.ab = paramParcel.readString();
    this.x = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.ac = bool1;
    this.aL = paramParcel.createTypedArrayList(RichTitleInfo.CREATOR);
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.ad = bool1;
    this.aM = ((VideoInfo.SubscriptInfo)paramParcel.readParcelable(VideoInfo.SubscriptInfo.class.getClassLoader()));
    this.aN = ((VideoInfo.LocationInfo)paramParcel.readParcelable(VideoInfo.LocationInfo.class.getClassLoader()));
    this.av = paramParcel.readInt();
    this.aw = paramParcel.readInt();
    this.aU = paramParcel.readString();
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    return ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).computeXYaxis(paramActivity, this, paramInt);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.a = paramVideoInfo.a;
    this.aQ = paramVideoInfo.aQ;
    this.b = paramVideoInfo.b;
    this.c = paramVideoInfo.c;
    this.d = paramVideoInfo.d;
    this.e = paramVideoInfo.e;
    this.f = paramVideoInfo.f;
    this.g = paramVideoInfo.g;
    this.h = paramVideoInfo.h;
    this.i = paramVideoInfo.i;
    this.j = paramVideoInfo.j;
    this.k = paramVideoInfo.k;
    this.l = paramVideoInfo.l;
    this.m = paramVideoInfo.m;
    this.n = paramVideoInfo.n;
    this.o = paramVideoInfo.o;
    this.p = paramVideoInfo.p;
    this.ax = paramVideoInfo.ax;
    this.q = paramVideoInfo.q;
    this.r = paramVideoInfo.r;
    this.s = paramVideoInfo.s;
    this.t = paramVideoInfo.t;
    this.u = paramVideoInfo.u;
    this.v = paramVideoInfo.v;
    this.w = paramVideoInfo.w;
    this.A = paramVideoInfo.A;
    this.B = paramVideoInfo.B;
    this.C = paramVideoInfo.C;
    this.D = paramVideoInfo.D;
    this.E = paramVideoInfo.E;
    this.F = paramVideoInfo.F;
    this.aB = paramVideoInfo.aB;
    this.aq = paramVideoInfo.aq;
    this.ar = paramVideoInfo.ar;
    this.as = paramVideoInfo.as;
    this.G = paramVideoInfo.G;
    this.H = paramVideoInfo.H;
    this.J = paramVideoInfo.J;
    this.K = paramVideoInfo.K;
    this.L = paramVideoInfo.L;
    this.M = paramVideoInfo.M;
    this.aD = paramVideoInfo.aD;
    this.aE = paramVideoInfo.aE;
    this.aF = paramVideoInfo.aF;
    this.aG = paramVideoInfo.aG;
    this.aR = paramVideoInfo.aR;
    this.O = paramVideoInfo.O;
    this.ah = paramVideoInfo.ah;
    this.ai = paramVideoInfo.ai;
    this.aj = paramVideoInfo.aj;
    this.ak = paramVideoInfo.ak;
    this.al = paramVideoInfo.al;
    this.am = paramVideoInfo.am;
    this.an = paramVideoInfo.an;
    this.ao = paramVideoInfo.ao;
    this.ap = paramVideoInfo.ap;
    this.N = paramVideoInfo.N;
    this.P = paramVideoInfo.P;
    this.Q = paramVideoInfo.Q;
    this.R = paramVideoInfo.R;
    this.U = paramVideoInfo.U;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.aB;
    if (localAbsBaseArticleInfo != null) {
      localAbsBaseArticleInfo.mArticleID = this.u;
    }
    this.X = paramVideoInfo.X;
    this.Y = paramVideoInfo.Y;
    this.Z = paramVideoInfo.Z;
    this.aJ = paramVideoInfo.aJ;
    this.aC = paramVideoInfo.aC;
    this.ay = paramVideoInfo.ay;
    this.aK = paramVideoInfo.aK;
    this.y = paramVideoInfo.y;
    this.z = paramVideoInfo.z;
    this.aa = paramVideoInfo.aa;
    this.ab = paramVideoInfo.ab;
    this.x = paramVideoInfo.x;
    this.ac = paramVideoInfo.ac;
    this.aL = paramVideoInfo.aL;
    this.ad = paramVideoInfo.ad;
    this.aM = paramVideoInfo.aM;
    this.aN = paramVideoInfo.aN;
    this.aw = paramVideoInfo.aw;
    this.aU = paramVideoInfo.aU;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public boolean a()
  {
    return this.P;
  }
  
  public boolean a(Activity paramActivity)
  {
    if (this.aS == null) {
      b(paramActivity);
    }
    return ((Boolean)this.aS[3]).booleanValue();
  }
  
  public int[] a(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    return ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).getLogoMarginSize(paramActivity, this, paramBoolean, paramInt);
  }
  
  public String b()
  {
    return this.Q;
  }
  
  protected void b(Activity paramActivity)
  {
    this.aS = ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).calculateVideoAreaHeight(paramActivity, i(), j());
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder("VideoInfo innerInitVideoAreaHeightInfo() ");
      paramActivity.append("videoAreaHeightInfo[0]=");
      paramActivity.append(this.aS[0]);
      paramActivity.append(", videoAreaHeightInfo[1]=");
      paramActivity.append(this.aS[1]);
      paramActivity.append(", videoAreaHeightInfo[2]=");
      paramActivity.append(this.aS[2]);
      QLog.d("AbsVideoInfo", 2, paramActivity.toString());
    }
  }
  
  public void b(String paramString)
  {
    this.aL = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("rpt_biu_mutli_level");
      int i1 = 0;
      while (i1 < paramString.length())
      {
        RichTitleInfo localRichTitleInfo = new RichTitleInfo((JSONObject)paramString.get(i1));
        this.aL.add(localRichTitleInfo);
        i1 += 1;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int c(Activity paramActivity)
  {
    if (this.aS == null) {
      b(paramActivity);
    }
    return ((Integer)this.aS[1]).intValue();
  }
  
  public boolean c()
  {
    return this.R;
  }
  
  public int d(Activity paramActivity)
  {
    if (this.aS == null) {
      b(paramActivity);
    }
    return ((Integer)this.aS[2]).intValue();
  }
  
  public String d()
  {
    return this.f;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public boolean e(Activity paramActivity)
  {
    if (this.aS == null) {
      b(paramActivity);
    }
    return ((Boolean)this.aS[0]).booleanValue();
  }
  
  public String f()
  {
    return null;
  }
  
  public boolean g()
  {
    VideoColumnInfo localVideoColumnInfo = this.ay;
    if (localVideoColumnInfo != null) {
      return localVideoColumnInfo.h;
    }
    return false;
  }
  
  public boolean h()
  {
    return this.ay != null;
  }
  
  public int i()
  {
    if (this.a == 0)
    {
      MessageForShortVideo localMessageForShortVideo = this.aQ;
      if (localMessageForShortVideo != null) {
        return localMessageForShortVideo.thumbWidth;
      }
    }
    return this.c;
  }
  
  public int j()
  {
    if (this.a == 0)
    {
      MessageForShortVideo localMessageForShortVideo = this.aQ;
      if (localMessageForShortVideo != null) {
        return localMessageForShortVideo.thumbHeight;
      }
    }
    return this.d;
  }
  
  public int k()
  {
    if (this.a == 0)
    {
      MessageForShortVideo localMessageForShortVideo = this.aQ;
      if (localMessageForShortVideo != null) {
        return localMessageForShortVideo.videoFileTime;
      }
    }
    return this.e;
  }
  
  public String l()
  {
    if (this.a == 0)
    {
      MessageForShortVideo localMessageForShortVideo = this.aQ;
      if (localMessageForShortVideo != null) {
        return localMessageForShortVideo.getMd5();
      }
    }
    return null;
  }
  
  public boolean m()
  {
    return (this.a == 0) && (this.aQ != null);
  }
  
  public boolean n()
  {
    return this.as != null;
  }
  
  public boolean o()
  {
    return (!TextUtils.isEmpty(this.l)) && (this.aB != null);
  }
  
  public int p()
  {
    if (this.a == 0) {
      return 1;
    }
    if ((this.aq) && (this.ar == 1)) {
      return 3;
    }
    if ((this.aq) && (this.ar == 2)) {
      return 4;
    }
    return 2;
  }
  
  public String q()
  {
    StringBuilder localStringBuilder1 = new StringBuilder(1024);
    localStringBuilder1.append("VideoInfo[");
    localStringBuilder1.append("busiType=");
    localStringBuilder1.append(this.a);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("width=");
    localStringBuilder1.append(i());
    localStringBuilder1.append(", ");
    localStringBuilder1.append("height=");
    localStringBuilder1.append(j());
    localStringBuilder1.append(", ");
    if (this.a == 0)
    {
      localStringBuilder1.append("msg=");
      localObject = this.aQ;
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
      localStringBuilder1.append(this.b);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("articleID=");
      localStringBuilder1.append(this.l);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("title=");
      localStringBuilder1.append(this.g);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("duration=");
      localStringBuilder1.append(this.e);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("coverUrl=");
      localStringBuilder1.append(this.f);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("summary=");
      localStringBuilder1.append(this.h);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("createTime=");
      localStringBuilder1.append(this.i);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("createTimeStamp=");
      localStringBuilder1.append(this.j);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("webUrl=");
      localStringBuilder1.append(this.k);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("recommendReason=");
      localStringBuilder1.append(this.m);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("accountUin=");
      localStringBuilder1.append(this.q);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("accountName=");
      localStringBuilder1.append(this.r);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("isVerified=");
      localStringBuilder1.append(this.s);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("biuCount=");
      localStringBuilder1.append(this.w);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("commentCount=");
      localStringBuilder1.append(this.p);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("playCount=");
      localStringBuilder1.append(this.aj);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("likeCount=");
      localStringBuilder1.append(this.ak);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("isDianZan=");
      localStringBuilder1.append(this.am);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("dianZanCount=");
      localStringBuilder1.append(this.an);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("thirdAction=");
      localStringBuilder1.append(this.A);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("thirdIconUrl=");
      localStringBuilder1.append(this.B);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("xgFileSize=");
      localStringBuilder1.append(this.n);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("isUgc=");
      localStringBuilder1.append(this.t);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("isFollowed=");
      localStringBuilder1.append(this.al);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("aioShareUrl=");
      localStringBuilder1.append(this.y);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("qzoneShareUrl=");
      localStringBuilder1.append(this.z);
      localStringBuilder1.append(", ");
    }
    if (this.a == 6)
    {
      localStringBuilder1.append("video_url=");
      localStringBuilder1.append(this.D);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("feedId=");
      localStringBuilder1.append(this.E);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("feedType=");
      localStringBuilder1.append(this.F);
      localStringBuilder1.append(", ");
      localStringBuilder1.append("articleInfo.mArticleID=");
      localObject = this.aB;
      if (localObject == null) {
        localObject = "articleInfo null";
      } else {
        localObject = Long.valueOf(((AbsBaseArticleInfo)localObject).mArticleID);
      }
      localStringBuilder1.append(localObject);
      localStringBuilder1.append(", ");
    }
    localStringBuilder1.append("isAD=");
    localStringBuilder1.append(this.aq);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("adType=");
    localStringBuilder1.append(this.ar);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("recommendBarrageList=[");
    Object localObject = this.G;
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
    localObject = this.aD;
    if (localObject != null) {
      localStringBuilder1.append(((VideoInfo.TopBarInfo)localObject).toString());
    }
    localStringBuilder1.append("]");
    localStringBuilder1.append(", ");
    localStringBuilder1.append("interruptedWeishiAd=[");
    localObject = this.aE;
    if (localObject != null) {
      localStringBuilder1.append(((VideoInfo.InterruptedWeishiAd)localObject).toString());
    }
    localStringBuilder1.append("]");
    localStringBuilder1.append(", ");
    localStringBuilder1.append("commerceEntranceInfo=[");
    localObject = this.aG;
    if (localObject != null) {
      localStringBuilder1.append(((VideoInfo.ECommerceEntranceInfo)localObject).toString());
    }
    localStringBuilder1.append("]");
    localStringBuilder1.append(", ");
    localStringBuilder1.append("downloadBarinfo=[");
    localObject = this.aF;
    if (localObject != null) {
      localStringBuilder1.append(((VideoInfo.DownloadBarInfo)localObject).toString());
    }
    localStringBuilder1.append("]");
    localStringBuilder1.append(", ");
    if (this.aL != null)
    {
      localStringBuilder1.append("richTitleInfo=[");
      localObject = this.aL.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RichTitleInfo localRichTitleInfo = (RichTitleInfo)((Iterator)localObject).next();
        if (localRichTitleInfo != null)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(localRichTitleInfo.c);
          localStringBuilder2.append(" ");
          localStringBuilder2.append(localRichTitleInfo.a);
          localStringBuilder1.append(localStringBuilder2.toString());
        }
      }
      localStringBuilder1.append("]");
    }
    localStringBuilder1.append("videoReportInfo=");
    localStringBuilder1.append(this.ao);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("avatarJumpUrl=");
    localStringBuilder1.append(this.ap);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("dynamicInsertTriggerSec=");
    localStringBuilder1.append(this.U);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("videoLogoUrl=");
    localStringBuilder1.append(this.X);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("followCount=");
    localStringBuilder1.append(this.Y);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("isShowStressFollow=");
    localStringBuilder1.append(this.Z);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("likeActionDownloadBar=");
    localStringBuilder1.append(this.aJ);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("videoColumnInfo=");
    localStringBuilder1.append(this.ay);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("columnId=");
    localStringBuilder1.append(this.x);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("softAdDownloadBarInfo=");
    localStringBuilder1.append(this.aK);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("wechatShareUrl=");
    localStringBuilder1.append(this.ab);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("]");
    localStringBuilder1.append("isUseGif=");
    localStringBuilder1.append(this.P);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("gifUrl=");
    localStringBuilder1.append(this.Q);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("isShowCover=");
    localStringBuilder1.append(this.R);
    localStringBuilder1.append("]");
    localStringBuilder1.append("isForbidReprint=");
    localStringBuilder1.append(this.aa);
    localStringBuilder1.append(", ");
    localStringBuilder1.append("subscriptInfo=");
    localStringBuilder1.append(this.aM);
    localStringBuilder1.append(", ");
    if (this.aN != null)
    {
      localStringBuilder1.append("locationInfo=");
      localStringBuilder1.append(this.aN);
      localStringBuilder1.append(", ");
    }
    localStringBuilder1.append("shareCount=");
    localStringBuilder1.append(this.aw);
    localStringBuilder1.append(", ");
    return localStringBuilder1.toString();
  }
  
  public void r()
  {
    this.aS = null;
  }
  
  public String s()
  {
    if ((this.a == 0) && (!TextUtils.isEmpty(l()))) {
      return l();
    }
    if (!TextUtils.isEmpty(this.l)) {
      return this.l;
    }
    return this.b;
  }
  
  public URL t()
  {
    Object localObject;
    if (this.a == 0)
    {
      localObject = this.aQ;
      if (localObject != null)
      {
        localObject = SVUtils.a(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        return ((IVideoPlayUtils)QRoute.api(IVideoPlayUtils.class)).getThumbUrl((String)localObject);
      }
    }
    try
    {
      localObject = new URL(this.f);
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoInfo{vid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleID='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.D);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recommendSeq=");
    localStringBuilder.append(this.N);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo
 * JD-Core Version:    0.7.0.1
 */