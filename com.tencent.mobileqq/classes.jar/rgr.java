import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class rgr
  implements rfu, rgv
{
  private int jdField_a_of_type_Int = 5;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<rol> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private qzw jdField_a_of_type_Qzw;
  private rbn jdField_a_of_type_Rbn;
  private rfs jdField_a_of_type_Rfs;
  private rgn jdField_a_of_type_Rgn;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  private rbn jdField_b_of_type_Rbn;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private final boolean d;
  
  public rgr(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, ArrayList<VideoInfo> paramArrayList)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    paramVideoFeedsRecyclerView.a(this);
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_Int = ors.e();
    this.jdField_b_of_type_Int = ntd.a();
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.d = paramBoolean1;
      if ((i == 4) || (i == 5) || (i == 2) || (i == 1)) {
        this.jdField_a_of_type_Int = 5;
      }
      this.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(128);
      d();
      return;
    }
  }
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<rol> paramList, qlq paramqlq, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramVideoInfo != null) && (paramIntent != null))
    {
      String str3 = paramVideoInfo.jdField_j_of_type_JavaLangString;
      String str4 = paramVideoInfo.jdField_a_of_type_JavaLangString;
      String str1 = paramVideoInfo.g;
      String str2;
      int n;
      int i1;
      int j;
      label77:
      int i3;
      int k;
      label154:
      int m;
      label174:
      rol localrol;
      int i;
      label270:
      Object localObject;
      label404:
      label500:
      boolean bool;
      if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
      {
        str2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        n = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        if (!this.jdField_b_of_type_Boolean) {
          break label1075;
        }
        j = 1;
        this.jdField_b_of_type_Boolean = false;
        int i2 = paramIntent.getIntExtra("key_source", -1);
        i3 = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
        int i4 = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i5 = paramIntent.getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i6 = paramIntent.getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str5 = paramIntent.getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty(paramVideoInfo.s)) || (!rdm.d())) {
          break label1081;
        }
        k = 1;
        int i7 = paramIntent.getIntExtra("RETURN_SCENE", 0);
        int i8 = paramList.size();
        m = 0;
        if (m >= i8) {
          return;
        }
        localrol = (rol)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendPresenter", 2, "播放VV上报 totalPlayTime = " + localrol.a + ", currentPlayTime = " + localrol.b);
        }
        if ((localrol.b != 0L) || (localrol.a != 0L))
        {
          if (m != 0) {
            break label1087;
          }
          i = 0;
          localObject = new ron(str2, str3, str4, str1).d(localrol.a).a(localrol.b).y(i).z(i8 - 1).w(i2).B(paramqlq.l).A(paramqlq.k).D(paramqlq.j).C(paramqlq.i).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_b_of_type_JavaLangString).c(paramLong).l(paramInt1).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean));
          if (paramVideoInfo.y == null) {
            break label1106;
          }
          paramIntent = paramVideoInfo.y;
          paramIntent = ((ron)localObject).a(paramIntent).e(paramVideoInfo.jdField_c_of_type_Boolean).p(this.jdField_b_of_type_Int).q(this.jdField_a_of_type_Int).e(paramVideoInfo.f).c(paramVideoInfo.o).E(j).K(paramVideoInfo.k).F(i4).g(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).v(i3).L(i1).j(false);
          if ((paramBoolean) || (paramInt2 <= 0)) {
            break label1113;
          }
          i = 1;
          paramIntent = paramIntent.n(i).k(paramVideoInfo.jdField_j_of_type_Boolean).m(paramVideoInfo.r).S(k);
          if (!paramVideoInfo.e()) {
            break label1119;
          }
          i = 2;
          label536:
          paramIntent = paramIntent.Y(i);
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
            break label1125;
          }
          bool = true;
          label553:
          localObject = paramIntent.l(bool);
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1131;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label589:
          paramIntent = ((ron)localObject).q(paramIntent);
          if (!paramVideoInfo.e()) {
            break label1138;
          }
          i = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
          label612:
          paramIntent = paramIntent.t(i);
          if ((!paramVideoInfo.e()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g))) {
            break label1144;
          }
          i = 1;
          label655:
          localObject = paramIntent.Z(i);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1150;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label691:
          localObject = ((ron)localObject).o(paramIntent);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
            break label1157;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
          label727:
          paramIntent = ((ron)localObject).p(paramIntent).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.f).M(otp.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.d)).N(0).b(this.d).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).ad(i7).a(paramVideoInfo);
          if (!paramBoolean) {
            paramIntent.m(paramInt2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i3 + ", first_video_row_key : " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g + ", first_video_type : " + i4 + "]");
          }
          if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            paramIntent.I(i5).J(i6).j(str5);
          }
          localObject = paramIntent.a().a();
          if (!this.jdField_a_of_type_Boolean) {
            break label1171;
          }
          if (TextUtils.isEmpty(str1)) {
            break label1164;
          }
        }
      }
      label1157:
      label1164:
      for (paramIntent = str1;; paramIntent = "0")
      {
        nrt.b(null, str3, "0X8009297", "0X8009297", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        nrt.a("0X8009297", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        paramIntent = new qlw();
        paramIntent.d = ((int)localrol.b);
        paramIntent.e = ((int)paramLong);
        paramIntent.jdField_b_of_type_Boolean = true;
        paramIntent.jdField_a_of_type_Boolean = qzy.a().c();
        paramIntent.jdField_b_of_type_Int = n;
        paramIntent.f = i3;
        ntd.b(paramVideoInfo, i1, 12, (int)localrol.a, paramIntent, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
        m += 1;
        break label174;
        str2 = null;
        break;
        label1075:
        j = -1;
        break label77;
        label1081:
        k = 0;
        break label154;
        label1087:
        if (this.jdField_c_of_type_Boolean)
        {
          i = 2;
          break label270;
        }
        i = 1;
        break label270;
        label1106:
        paramIntent = "";
        break label404;
        label1113:
        i = 0;
        break label500;
        label1119:
        i = 1;
        break label536;
        label1125:
        bool = false;
        break label553;
        label1131:
        paramIntent = "";
        break label589;
        label1138:
        i = 0;
        break label612;
        label1144:
        i = 0;
        break label655;
        label1150:
        paramIntent = "";
        break label691;
        paramIntent = "";
        break label727;
      }
      label1171:
      if (!TextUtils.isEmpty(str1)) {}
      for (paramIntent = str1;; paramIntent = "0")
      {
        nrt.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        nrt.a("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        break;
      }
    }
  }
  
  private static boolean a(rfs paramrfs)
  {
    return (paramrfs != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrfs.jdField_a_of_type_Qlp != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    ron localron = new ron(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    localron.N(0).X(i).n(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    nrt.b(null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g, localron.a().a(), false);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      ron localron = new ron(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localron.P(this.jdField_c_of_type_Int);
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localron.a().a(), false);
    }
  }
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_Rbn = this.jdField_b_of_type_Rbn;
    if ((paramViewHolder instanceof rbn))
    {
      this.jdField_b_of_type_Rbn = ((rbn)paramViewHolder);
      this.jdField_a_of_type_Rfs = this.jdField_b_of_type_Rbn.jdField_a_of_type_Rfs;
    }
    for (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null)
    {
      if ((this.jdField_a_of_type_Rbn != null) && (this.jdField_b_of_type_Rbn != null) && (this.jdField_a_of_type_Rbn.jdField_c_of_type_Int > this.jdField_b_of_type_Rbn.jdField_c_of_type_Int)) {
        this.jdField_c_of_type_Int += 1;
      }
      return;
      this.jdField_b_of_type_Rbn = null;
      this.jdField_a_of_type_Rfs = null;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(qzw paramqzw)
  {
    this.jdField_a_of_type_Qzw = paramqzw;
  }
  
  public void a(rfs paramrfs)
  {
    if ((paramrfs != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!this.jdField_a_of_type_Boolean)) {
      ntd.b(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 409409, 1, -1, null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
  }
  
  public void a(rfs paramrfs, int paramInt)
  {
    if ((paramrfs != null) && (paramrfs.jdField_a_of_type_Rjn != null))
    {
      rol localrol = new rol();
      localrol.a = paramrfs.jdField_a_of_type_Rjn.a(true);
      localrol.b = paramrfs.jdField_a_of_type_Rjn.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localrol.a + ", detailInfo.currentPlayTime = " + localrol.b);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localrol);
      if ((a(paramrfs)) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
        oeu.a(paramrfs, this.jdField_a_of_type_AndroidAppActivity, paramrfs.jdField_a_of_type_Rjn);
      }
      if (this.jdField_a_of_type_Qzw != null) {
        this.jdField_a_of_type_Qzw.b(this.jdField_b_of_type_Rbn.jdField_c_of_type_Int, paramrfs, this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public void a(rfs paramrfs, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(rfs paramrfs, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    int i;
    int j;
    label63:
    boolean bool;
    label83:
    Object localObject;
    if (this.jdField_a_of_type_Rbn != null)
    {
      i = this.jdField_a_of_type_Rbn.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Rbn == null) {
        break label190;
      }
      j = this.jdField_a_of_type_Rbn.jdField_b_of_type_Int;
      if ((this.jdField_a_of_type_Rbn == null) || (!this.jdField_a_of_type_Rbn.jdField_b_of_type_Boolean)) {
        break label196;
      }
      bool = true;
      localObject = new rol();
      if (!paramBoolean) {
        break label202;
      }
    }
    label190:
    label196:
    label202:
    for (long l1 = paramrfs.jdField_a_of_type_Rjn.b();; l1 = paramrfs.jdField_a_of_type_Rjn.a())
    {
      ((rol)localObject).b = l1;
      ((rol)localObject).a = paramrfs.jdField_a_of_type_Rjn.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ThreadManager.excute(new VideoFeedsRecommendPresenter.1(this, localIntent, localVideoInfo, (List)localObject, paramrfs, l2, i, j, bool), 16, null, true);
      return;
      i = 0;
      break;
      j = 0;
      break label63;
      bool = false;
      break label83;
    }
  }
  
  public void a(rgn paramrgn)
  {
    this.jdField_a_of_type_Rgn = paramrgn;
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    int j = 0;
    rfs localrfs;
    int i;
    if (this.jdField_b_of_type_Rbn != null)
    {
      localrfs = this.jdField_b_of_type_Rbn.jdField_a_of_type_Rfs;
      i = j;
      if (localrfs != null)
      {
        i = j;
        if (localrfs.jdField_a_of_type_Rjn != null) {
          i = localrfs.jdField_a_of_type_Rjn.e();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "handlePlayButtonClick() status()=" + i);
      }
    }
    switch (i)
    {
    default: 
    case 0: 
    case 7: 
    case 6: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        return;
        localrfs = null;
        break;
        if (a(localrfs)) {
          localrfs.jdField_a_of_type_Qlp.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localrfs, false);
        return;
        if (a(localrfs)) {
          localrfs.jdField_a_of_type_Qlp.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localrfs);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localrfs, true);
        return;
        String str1;
        if ((localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          str1 = localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
        for (;;)
        {
          try
          {
            String str3 = localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
            if (TextUtils.isEmpty(localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
              continue;
            }
            str2 = localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
            nrt.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, ntd.a(str1, localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000, new JSONObject().put("video_type", 0)), false);
          }
          catch (Exception localException)
          {
            String str2;
            continue;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
          return;
          str1 = null;
          continue;
          str2 = "0";
        }
        if (a(localrfs)) {
          localrfs.jdField_a_of_type_Qlp.jdField_a_of_type_Boolean = false;
        }
      } while (localrfs.a("continue_pause", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
    }
    if (a(localrfs)) {
      localrfs.jdField_a_of_type_Qlp.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
  }
  
  public void b(rfs paramrfs)
  {
    if (this.jdField_a_of_type_Qzw != null) {
      this.jdField_a_of_type_Qzw.a(this.jdField_b_of_type_Rbn.jdField_c_of_type_Int, paramrfs, this.jdField_b_of_type_JavaUtilArrayList);
    }
  }
  
  public void b(rfs paramrfs, boolean paramBoolean) {}
  
  public void c()
  {
    e();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(rfs paramrfs) {}
  
  public void d(rfs paramrfs) {}
  
  public void e(rfs paramrfs) {}
  
  public void f(rfs paramrfs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rgr
 * JD-Core Version:    0.7.0.1
 */