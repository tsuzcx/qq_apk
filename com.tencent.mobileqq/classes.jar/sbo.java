import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendPresenter.3;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class sbo
  implements sat, sbt
{
  public static final float[] a;
  public static final int[] a;
  private int jdField_a_of_type_Int = 5;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<sjy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private orj jdField_a_of_type_Orj;
  private pmn jdField_a_of_type_Pmn = new sbp(this);
  private rxq jdField_a_of_type_Rxq;
  private sar jdField_a_of_type_Sar;
  private sbk jdField_a_of_type_Sbk;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  private rxq jdField_b_of_type_Rxq;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private final boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 1.5F, 2.0F };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130841768, 2130841767, 2130841769 };
  }
  
  public sbo(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this);
    paramVideoFeedsRecyclerView.a(this);
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_Int = pha.e();
    this.jdField_b_of_type_Int = och.a();
    paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    this.jdField_d_of_type_Boolean = bmqa.d();
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 2) || (paramInt == 1)) {
      this.jdField_a_of_type_Int = 5;
    }
    this.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(128);
    this.jdField_d_of_type_JavaLangString = paramActivity.getIntent().getStringExtra("video_player_session_id");
    ThreadManager.excute(new VideoFeedsRecommendPresenter.2(this), 16, null, true);
  }
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<sjy> paramList, rgc paramrgc, long paramLong, int paramInt, boolean paramBoolean)
  {
    if ((paramVideoInfo != null) && (paramIntent != null))
    {
      String str3 = paramVideoInfo.jdField_j_of_type_JavaLangString;
      String str4 = paramVideoInfo.jdField_a_of_type_JavaLangString;
      String str2 = paramVideoInfo.g;
      String str1;
      int n;
      int i1;
      int j;
      label77:
      int i3;
      int k;
      label154:
      int m;
      label174:
      sjy localsjy;
      int i;
      label271:
      label586:
      String str6;
      if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
      {
        str1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        n = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        if (!this.jdField_b_of_type_Boolean) {
          break label879;
        }
        j = 1;
        this.jdField_b_of_type_Boolean = false;
        int i2 = paramIntent.getIntExtra("key_source", -1);
        i3 = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
        int i4 = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i5 = paramIntent.getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i6 = paramIntent.getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str5 = paramIntent.getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty(paramVideoInfo.u)) || (!ryx.d())) {
          break label885;
        }
        k = 1;
        int i7 = paramIntent.getIntExtra("RETURN_SCENE", 0);
        int i8 = paramList.size();
        m = 0;
        if (m >= i8) {
          return;
        }
        localsjy = (sjy)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendPresenter", 2, "播放VV上报 totalPlayTime = " + localsjy.jdField_a_of_type_Long + ", currentPlayTime = " + localsjy.jdField_b_of_type_Long);
        }
        if ((localsjy.jdField_b_of_type_Long != 0L) || (localsjy.jdField_a_of_type_Long != 0L))
        {
          if (m != 0) {
            break label891;
          }
          i = 0;
          paramIntent = new skc(str1, str3, str4, str2).d(localsjy.jdField_a_of_type_Long).a(localsjy.jdField_b_of_type_Long).y(i).z(i8 - 1).w(i2).B(paramrgc.m).A(paramrgc.l).D(paramrgc.k).C(paramrgc.j).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_c_of_type_JavaLangString).c(paramLong).l(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean)).a(paramVideoInfo.B).e(paramVideoInfo.jdField_c_of_type_Boolean).p(this.jdField_b_of_type_Int).q(this.jdField_a_of_type_Int).e(paramVideoInfo.f).c(paramVideoInfo.p).E(j).K(paramVideoInfo.l).F(i4).g(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).v(i3).L(i1).j(false).n(0).k(paramVideoInfo.jdField_j_of_type_Boolean).m(paramVideoInfo.t).S(k).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.f).M(piv.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).N(0).b(this.jdField_d_of_type_Boolean).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).ac(i7).l(siy.a.a());
          if (!paramBoolean) {
            break label910;
          }
          i = 1;
          paramIntent = paramIntent.a("is_show_followed", Integer.valueOf(i)).a(this.jdField_e_of_type_Int, this.jdField_b_of_type_JavaLangString).b(paramVideoInfo);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i3 + ", first_video_row_key : " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g + ", first_video_type : " + i4 + "]");
          }
          if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            paramIntent.I(i5).J(i6).j(str5);
          }
          str6 = paramIntent.a().a();
          if (TextUtils.isEmpty(str2)) {
            break label916;
          }
          paramIntent = str2;
          label732:
          if (!this.jdField_a_of_type_Boolean) {
            break label923;
          }
          oat.b(null, str3, "0X8009297", "0X8009297", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, str6, false);
          oat.a("0X8009297", str3, String.valueOf(n), String.valueOf(i1), "", str6);
        }
      }
      for (;;)
      {
        paramIntent = new rgi();
        paramIntent.jdField_d_of_type_Int = ((int)localsjy.jdField_b_of_type_Long);
        paramIntent.jdField_e_of_type_Int = ((int)paramLong);
        paramIntent.jdField_b_of_type_Boolean = true;
        paramIntent.jdField_a_of_type_Boolean = rvr.a().c();
        paramIntent.jdField_b_of_type_Int = n;
        paramIntent.f = i3;
        och.b(paramVideoInfo, i1, 12, (int)localsjy.jdField_a_of_type_Long, paramIntent, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
        m += 1;
        break label174;
        str1 = null;
        break;
        label879:
        j = -1;
        break label77;
        label885:
        k = 0;
        break label154;
        label891:
        if (this.jdField_c_of_type_Boolean)
        {
          i = 2;
          break label271;
        }
        i = 1;
        break label271;
        label910:
        i = 0;
        break label586;
        label916:
        paramIntent = "0";
        break label732;
        label923:
        oat.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, str6, false);
        oat.a("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", str6);
      }
    }
  }
  
  private static boolean a(sar paramsar)
  {
    return (paramsar != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramsar.jdField_a_of_type_Rgb != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void c(sar paramsar, boolean paramBoolean)
  {
    int i = 1;
    if ((paramsar == null) || (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (paramsar.jdField_a_of_type_Sfb == null)) {
      return;
    }
    boolean bool = paramsar.jdField_a_of_type_AndroidOsBundle.getBoolean("is_auto_play", true);
    paramsar = ska.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("dt_vdend").b("8006").e(paramsar.jdField_a_of_type_Sfb.b()).e(paramsar.jdField_a_of_type_Sfb.a()).a(bool).b(System.currentTimeMillis()).c(paramsar.jdField_a_of_type_Sfb.a(paramBoolean)).c(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (this.jdField_c_of_type_Boolean) {
      i = 2;
    }
    sjz.a(paramsar.b(i));
  }
  
  private void g(sar paramsar)
  {
    int i = 1;
    if ((paramsar == null) || (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (paramsar.jdField_a_of_type_Sfb == null)) {
      return;
    }
    boolean bool = paramsar.jdField_a_of_type_AndroidOsBundle.getBoolean("is_auto_play", true);
    paramsar = ska.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("dt_vdstart").b("8006").e(paramsar.jdField_a_of_type_Sfb.b()).e(paramsar.jdField_a_of_type_Sfb.a()).a(bool).a(System.currentTimeMillis());
    if (this.jdField_c_of_type_Boolean) {
      i = 2;
    }
    sjz.a(paramsar.b(i).c(this.jdField_a_of_type_JavaUtilArrayList.size()));
  }
  
  private void i()
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    String str1 = "";
    String str2 = "";
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      str2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
      str1 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
    }
    skc localskc = new skc(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    localskc.N(0).X(i).n(str2);
    oat.b(null, str1, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", str2, localskc.a().a(), false);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    Object localObject2 = new skc(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).N(0);
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
      localObject2 = ((skc)localObject2).b((VideoColumnInfo)localObject1).b(this.jdField_b_of_type_Long).v(this.jdField_e_of_type_Int).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).a();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) {
        break label143;
      }
    }
    label143:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;; localObject1 = "")
    {
      oat.a(localQQAppInterface, (String)localObject1, "0X800AF2E", "0X800AF2E", 0, 0, "", "", "", ((skb)localObject2).a(), false);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      skc localskc = new skc(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localskc.P(this.jdField_c_of_type_Int);
      oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localskc.a().a(), false);
    }
  }
  
  private void l()
  {
    if ((this.jdField_b_of_type_Rxq != null) && (this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = false;
      pmk.a().b(this.jdField_a_of_type_Pmn);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_b_of_type_Rxq.jdField_a_of_type_Sar, false);
    }
  }
  
  public void D_() {}
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_Rxq = this.jdField_b_of_type_Rxq;
    if ((paramViewHolder instanceof rxq))
    {
      this.jdField_b_of_type_Rxq = ((rxq)paramViewHolder);
      this.jdField_a_of_type_Sar = this.jdField_b_of_type_Rxq.jdField_a_of_type_Sar;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (this.jdField_a_of_type_Sar.jdField_a_of_type_Sfb != null) {
        this.jdField_a_of_type_Sar.jdField_a_of_type_Sfb.i();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Rxq != null) && (this.jdField_b_of_type_Rxq != null) && (this.jdField_a_of_type_Rxq.jdField_c_of_type_Int > this.jdField_b_of_type_Rxq.jdField_c_of_type_Int)) {
        this.jdField_c_of_type_Int += 1;
      }
      d();
      return;
      this.jdField_b_of_type_Rxq = null;
      this.jdField_a_of_type_Sar = null;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(orj paramorj)
  {
    this.jdField_a_of_type_Orj = paramorj;
  }
  
  public void a(sar paramsar)
  {
    if ((paramsar != null) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!this.jdField_a_of_type_Boolean)) {
      och.b(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 409409, 1, -1, null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
  }
  
  public void a(sar paramsar, int paramInt)
  {
    if ((paramsar != null) && (paramsar.jdField_a_of_type_Sfb != null))
    {
      sjy localsjy = new sjy();
      localsjy.jdField_a_of_type_Long = paramsar.jdField_a_of_type_Sfb.a(true);
      localsjy.jdField_b_of_type_Long = paramsar.jdField_a_of_type_Sfb.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localsjy.jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + localsjy.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localsjy);
      if ((a(paramsar)) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
        ora.a(paramsar, this.jdField_a_of_type_AndroidAppActivity, paramsar.jdField_a_of_type_Sfb);
      }
      if (this.jdField_a_of_type_Orj != null) {
        this.jdField_a_of_type_Orj.b(this.jdField_b_of_type_Rxq.jdField_c_of_type_Int, paramsar, this.jdField_b_of_type_JavaUtilArrayList);
      }
      c(paramsar, true);
      g(paramsar);
    }
  }
  
  public void a(sar paramsar, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(sar paramsar, boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    int i;
    Object localObject;
    long l1;
    label88:
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Rxq != null)
    {
      i = this.jdField_a_of_type_Rxq.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Rxq != null) {
        int j = this.jdField_a_of_type_Rxq.jdField_b_of_type_Int;
      }
      localObject = new sjy();
      if (!paramBoolean) {
        break label224;
      }
      l1 = paramsar.jdField_a_of_type_Sfb.b();
      ((sjy)localObject).jdField_b_of_type_Long = l1;
      ((sjy)localObject).jdField_a_of_type_Long = paramsar.jdField_a_of_type_Sfb.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      c(paramsar, paramBoolean);
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (!(this.jdField_a_of_type_Rxq instanceof rxv)) {
        break label236;
      }
      localObject = (rxv)this.jdField_a_of_type_Rxq;
      label163:
      if ((localObject == null) || (((rxv)localObject).k == null)) {
        break label242;
      }
      paramBoolean = bool;
      if (((rxv)localObject).k.getVisibility() != 0) {}
    }
    label224:
    label236:
    label242:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.excute(new VideoFeedsRecommendPresenter.3(this, localIntent, localVideoInfo, localArrayList, paramsar, l2, i, paramBoolean), 16, null, true);
      return;
      i = 0;
      break;
      l1 = paramsar.jdField_a_of_type_Sfb.a();
      break label88;
      localObject = null;
      break label163;
    }
  }
  
  public void a(sbk paramsbk)
  {
    this.jdField_a_of_type_Sbk = paramsbk;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    int j = 0;
    sar localsar;
    int i;
    if (this.jdField_b_of_type_Rxq != null)
    {
      localsar = this.jdField_b_of_type_Rxq.jdField_a_of_type_Sar;
      i = j;
      if (localsar != null)
      {
        i = j;
        if (localsar.jdField_a_of_type_Sfb != null) {
          i = localsar.jdField_a_of_type_Sfb.b();
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
        localsar = null;
        break;
        if (a(localsar)) {
          localsar.jdField_a_of_type_Rgb.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localsar, false);
        return;
        if (a(localsar)) {
          localsar.jdField_a_of_type_Rgb.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localsar);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localsar, true);
        return;
        String str1;
        if ((localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          str1 = localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
        for (;;)
        {
          try
          {
            String str3 = localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
            if (TextUtils.isEmpty(localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
              continue;
            }
            str2 = localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
            oat.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, och.a(str1, localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000, new JSONObject().put("video_type", 0)), false);
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
        if (a(localsar)) {
          localsar.jdField_a_of_type_Rgb.jdField_a_of_type_Boolean = false;
        }
      } while (localsar.a("continue_pause", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
    }
    if (a(localsar)) {
      localsar.jdField_a_of_type_Rgb.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
  }
  
  public void b(sar paramsar)
  {
    if (this.jdField_a_of_type_Orj != null) {
      this.jdField_a_of_type_Orj.a(this.jdField_b_of_type_Rxq.jdField_c_of_type_Int, paramsar, this.jdField_b_of_type_JavaUtilArrayList);
    }
    oat.a(null, "", "0X800AF11", "0X800AF11", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      paramsar.jdField_a_of_type_Sfb.b(this.jdField_d_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = null;
    }
    g(paramsar);
  }
  
  public void b(sar paramsar, boolean paramBoolean) {}
  
  public void c()
  {
    pmk.a().b(this.jdField_a_of_type_Pmn);
    k();
    j();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(sar paramsar) {}
  
  public void d()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(jdField_a_of_type_ArrayOfFloat[0]);
    if (this.jdField_b_of_type_Rxq != null) {
      this.jdField_b_of_type_Rxq.jdField_a_of_type_Rur.b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
    }
  }
  
  public void d(sar paramsar) {}
  
  public void e()
  {
    int i;
    if (this.jdField_b_of_type_Rxq != null)
    {
      i = this.jdField_d_of_type_Int;
      if (i < jdField_a_of_type_ArrayOfFloat.length - 1) {
        break label64;
      }
      i = 0;
    }
    for (;;)
    {
      float f = jdField_a_of_type_ArrayOfFloat[i];
      this.jdField_d_of_type_Int = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(f);
      this.jdField_b_of_type_Rxq.jdField_a_of_type_Rur.b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
      return;
      label64:
      i += 1;
    }
  }
  
  public void e(sar paramsar) {}
  
  public void f()
  {
    pmk.a().a(this.jdField_a_of_type_Pmn);
  }
  
  public void f(sar paramsar) {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Long = 0L;
    c(this.jdField_a_of_type_Sar, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f());
  }
  
  public void h()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbo
 * JD-Core Version:    0.7.0.1
 */