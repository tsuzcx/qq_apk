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

public class rsk
  implements rro, rsp
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
  private ArrayList<sbc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private pfh jdField_a_of_type_Pfh = new rsl(this);
  private rol jdField_a_of_type_Rol;
  private rrm jdField_a_of_type_Rrm;
  private rsg jdField_a_of_type_Rsg;
  private trb jdField_a_of_type_Trb;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  private rol jdField_b_of_type_Rol;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130841778, 2130841777, 2130841779 };
  }
  
  public rsk(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, ArrayList<VideoInfo> paramArrayList, int paramInt)
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
    this.jdField_a_of_type_Int = ozs.e();
    this.jdField_b_of_type_Int = odr.a();
    paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    this.jdField_d_of_type_Boolean = bnrf.d();
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 2) || (paramInt == 1)) {
      this.jdField_a_of_type_Int = 5;
    }
    this.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(128);
    this.jdField_d_of_type_JavaLangString = paramActivity.getIntent().getStringExtra("video_player_session_id");
    ThreadManager.excute(new VideoFeedsRecommendPresenter.2(this), 16, null, true);
  }
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<sbc> paramList, qwv paramqwv, long paramLong, int paramInt, boolean paramBoolean)
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
      sbc localsbc;
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
          break label875;
        }
        j = 1;
        this.jdField_b_of_type_Boolean = false;
        int i2 = paramIntent.getIntExtra("key_source", -1);
        i3 = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
        int i4 = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i5 = paramIntent.getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i6 = paramIntent.getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str5 = paramIntent.getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty(paramVideoInfo.u)) || (!rpt.e())) {
          break label881;
        }
        k = 1;
        int i7 = paramIntent.getIntExtra("RETURN_SCENE", 0);
        int i8 = paramList.size();
        m = 0;
        if (m >= i8) {
          return;
        }
        localsbc = (sbc)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendPresenter", 2, "播放VV上报 totalPlayTime = " + localsbc.jdField_a_of_type_Long + ", currentPlayTime = " + localsbc.jdField_b_of_type_Long);
        }
        if ((localsbc.jdField_b_of_type_Long != 0L) || (localsbc.jdField_a_of_type_Long != 0L))
        {
          if (m != 0) {
            break label887;
          }
          i = 0;
          paramIntent = new sbg(str1, str3, str4, str2).d(localsbc.jdField_a_of_type_Long).a(localsbc.jdField_b_of_type_Long).x(i).y(i8 - 1).v(i2).A(paramqwv.m).z(paramqwv.l).C(paramqwv.k).B(paramqwv.j).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_c_of_type_JavaLangString).c(paramLong).l(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean)).a(paramVideoInfo.z).e(paramVideoInfo.jdField_c_of_type_Boolean).q(this.jdField_b_of_type_Int).r(this.jdField_a_of_type_Int).e(paramVideoInfo.f).c(paramVideoInfo.p).D(j).J(paramVideoInfo.l).E(i4).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).u(i3).K(i1).i(false).n(0).j(paramVideoInfo.jdField_j_of_type_Boolean).n(paramVideoInfo.t).R(k).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.f).L(pbn.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).M(0).b(this.jdField_d_of_type_Boolean).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).ab(i7).k(sac.a.a());
          if (!paramBoolean) {
            break label906;
          }
          i = 1;
          paramIntent = paramIntent.a("is_show_followed", Integer.valueOf(i)).a(this.jdField_e_of_type_Int, this.jdField_b_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i3 + ", first_video_row_key : " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g + ", first_video_type : " + i4 + "]");
          }
          if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            paramIntent.H(i5).I(i6).k(str5);
          }
          str6 = paramIntent.a().a();
          if (TextUtils.isEmpty(str2)) {
            break label912;
          }
          paramIntent = str2;
          label728:
          if (!this.jdField_a_of_type_Boolean) {
            break label919;
          }
          ocd.b(null, str3, "0X8009297", "0X8009297", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, str6, false);
          ocd.a("0X8009297", str3, String.valueOf(n), String.valueOf(i1), "", str6);
        }
      }
      for (;;)
      {
        paramIntent = new qxb();
        paramIntent.jdField_d_of_type_Int = ((int)localsbc.jdField_b_of_type_Long);
        paramIntent.jdField_e_of_type_Int = ((int)paramLong);
        paramIntent.jdField_b_of_type_Boolean = true;
        paramIntent.jdField_a_of_type_Boolean = rmn.a().c();
        paramIntent.jdField_b_of_type_Int = n;
        paramIntent.f = i3;
        odr.b(paramVideoInfo, i1, 12, (int)localsbc.jdField_a_of_type_Long, paramIntent, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
        m += 1;
        break label174;
        str1 = null;
        break;
        label875:
        j = -1;
        break label77;
        label881:
        k = 0;
        break label154;
        label887:
        if (this.jdField_c_of_type_Boolean)
        {
          i = 2;
          break label271;
        }
        i = 1;
        break label271;
        label906:
        i = 0;
        break label586;
        label912:
        paramIntent = "0";
        break label728;
        label919:
        ocd.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, str6, false);
        ocd.a("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", str6);
      }
    }
  }
  
  private static boolean a(rrm paramrrm)
  {
    return (paramrrm != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrrm.jdField_a_of_type_Qwu != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void c(rrm paramrrm, boolean paramBoolean)
  {
    int i = 1;
    if ((paramrrm == null) || (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (paramrrm.jdField_a_of_type_Rwf == null)) {
      return;
    }
    boolean bool = paramrrm.jdField_a_of_type_AndroidOsBundle.getBoolean("is_auto_play", true);
    paramrrm = sbe.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("dt_vdend").b("8006").e(paramrrm.jdField_a_of_type_Rwf.b()).e(paramrrm.jdField_a_of_type_Rwf.a()).a(bool).b(System.currentTimeMillis()).c(paramrrm.jdField_a_of_type_Rwf.a(paramBoolean)).c(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (this.jdField_c_of_type_Boolean) {
      i = 2;
    }
    sbd.a(paramrrm.b(i));
  }
  
  private void g(rrm paramrrm)
  {
    int i = 1;
    if ((paramrrm == null) || (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (paramrrm.jdField_a_of_type_Rwf == null)) {
      return;
    }
    boolean bool = paramrrm.jdField_a_of_type_AndroidOsBundle.getBoolean("is_auto_play", true);
    paramrrm = sbe.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("dt_vdstart").b("8006").e(paramrrm.jdField_a_of_type_Rwf.b()).e(paramrrm.jdField_a_of_type_Rwf.a()).a(bool).a(System.currentTimeMillis());
    if (this.jdField_c_of_type_Boolean) {
      i = 2;
    }
    sbd.a(paramrrm.b(i).c(this.jdField_a_of_type_JavaUtilArrayList.size()));
  }
  
  private void i()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    }
    for (;;)
    {
      String str1 = "";
      String str2 = "";
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        str2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g;
        str1 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
      }
      sbg localsbg = new sbg(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
      localsbg.M(0).W(i).o(str2);
      ocd.b(null, str1, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", str2, localsbg.a().a(), false);
      return;
      j = 0;
      i = 0;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = new sbg(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).M(0);
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
          localObject3 = ((sbg)localObject3).b((VideoColumnInfo)localObject1).b(this.jdField_b_of_type_Long).u(this.jdField_e_of_type_Int).m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()).a();
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
            ocd.a(localQQAppInterface, (String)localObject1, "0X800AF2E", "0X800AF2E", 0, 0, "", "", "", ((sbf)localObject3).a(), false);
            return;
          }
          localObject1 = "";
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      sbg localsbg = new sbg(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localsbg.O(this.jdField_c_of_type_Int);
      ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localsbg.a().a(), false);
    }
  }
  
  private void l()
  {
    if ((this.jdField_b_of_type_Rol != null) && (this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = false;
      pfd.a().b(this.jdField_a_of_type_Pfh);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_b_of_type_Rol.jdField_a_of_type_Rrm, false);
    }
  }
  
  public void D_() {}
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_Rol = this.jdField_b_of_type_Rol;
    if ((paramViewHolder instanceof rol))
    {
      this.jdField_b_of_type_Rol = ((rol)paramViewHolder);
      this.jdField_a_of_type_Rrm = this.jdField_b_of_type_Rol.jdField_a_of_type_Rrm;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (this.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf != null) {
        this.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf.i();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Rol != null) && (this.jdField_b_of_type_Rol != null) && (this.jdField_a_of_type_Rol.jdField_c_of_type_Int > this.jdField_b_of_type_Rol.jdField_c_of_type_Int)) {
        this.jdField_c_of_type_Int += 1;
      }
      d();
      return;
      this.jdField_b_of_type_Rol = null;
      this.jdField_a_of_type_Rrm = null;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(rrm paramrrm)
  {
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!this.jdField_a_of_type_Boolean)) {
      odr.b(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 409409, 1, -1, null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
  }
  
  public void a(rrm paramrrm, int paramInt)
  {
    if ((paramrrm != null) && (paramrrm.jdField_a_of_type_Rwf != null))
    {
      sbc localsbc = new sbc();
      localsbc.jdField_a_of_type_Long = paramrrm.jdField_a_of_type_Rwf.a(true);
      localsbc.jdField_b_of_type_Long = paramrrm.jdField_a_of_type_Rwf.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localsbc.jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + localsbc.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localsbc);
      if ((a(paramrrm)) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
        tqs.a(paramrrm, this.jdField_a_of_type_AndroidAppActivity, paramrrm.jdField_a_of_type_Rwf);
      }
      if (this.jdField_a_of_type_Trb != null) {
        this.jdField_a_of_type_Trb.b(this.jdField_b_of_type_Rol.jdField_c_of_type_Int, paramrrm, this.jdField_b_of_type_JavaUtilArrayList);
      }
      c(paramrrm, true);
      g(paramrrm);
    }
  }
  
  public void a(rrm paramrrm, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(rrm paramrrm, boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    int i;
    Object localObject;
    long l1;
    label88:
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Rol != null)
    {
      i = this.jdField_a_of_type_Rol.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Rol != null) {
        int j = this.jdField_a_of_type_Rol.jdField_b_of_type_Int;
      }
      localObject = new sbc();
      if (!paramBoolean) {
        break label224;
      }
      l1 = paramrrm.jdField_a_of_type_Rwf.b();
      ((sbc)localObject).jdField_b_of_type_Long = l1;
      ((sbc)localObject).jdField_a_of_type_Long = paramrrm.jdField_a_of_type_Rwf.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      c(paramrrm, paramBoolean);
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (!(this.jdField_a_of_type_Rol instanceof roq)) {
        break label236;
      }
      localObject = (roq)this.jdField_a_of_type_Rol;
      label163:
      if ((localObject == null) || (((roq)localObject).j == null)) {
        break label242;
      }
      paramBoolean = bool;
      if (((roq)localObject).j.getVisibility() != 0) {}
    }
    label224:
    label236:
    label242:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.excute(new VideoFeedsRecommendPresenter.3(this, localIntent, localVideoInfo, localArrayList, paramrrm, l2, i, paramBoolean), 16, null, true);
      return;
      i = 0;
      break;
      l1 = paramrrm.jdField_a_of_type_Rwf.a();
      break label88;
      localObject = null;
      break label163;
    }
  }
  
  public void a(rsg paramrsg)
  {
    this.jdField_a_of_type_Rsg = paramrsg;
  }
  
  public void a(trb paramtrb)
  {
    this.jdField_a_of_type_Trb = paramtrb;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    int j = 0;
    rrm localrrm;
    int i;
    if (this.jdField_b_of_type_Rol != null)
    {
      localrrm = this.jdField_b_of_type_Rol.jdField_a_of_type_Rrm;
      i = j;
      if (localrrm != null)
      {
        i = j;
        if (localrrm.jdField_a_of_type_Rwf != null) {
          i = localrrm.jdField_a_of_type_Rwf.b();
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
        localrrm = null;
        break;
        if (a(localrrm)) {
          localrrm.jdField_a_of_type_Qwu.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localrrm, false);
        return;
        if (a(localrrm)) {
          localrrm.jdField_a_of_type_Qwu.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localrrm);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localrrm, true);
        return;
        String str1;
        if ((localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          str1 = localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
        for (;;)
        {
          try
          {
            String str3 = localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
            if (TextUtils.isEmpty(localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
              continue;
            }
            str2 = localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
            ocd.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, odr.a(str1, localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000, new JSONObject().put("video_type", 0)), false);
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
        if (a(localrrm)) {
          localrrm.jdField_a_of_type_Qwu.jdField_a_of_type_Boolean = false;
        }
      } while (localrrm.a("continue_pause", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
    }
    if (a(localrrm)) {
      localrrm.jdField_a_of_type_Qwu.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
  }
  
  public void b(rrm paramrrm)
  {
    if (this.jdField_a_of_type_Trb != null) {
      this.jdField_a_of_type_Trb.a(this.jdField_b_of_type_Rol.jdField_c_of_type_Int, paramrrm, this.jdField_b_of_type_JavaUtilArrayList);
    }
    ocd.a(null, "", "0X800AF11", "0X800AF11", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      paramrrm.jdField_a_of_type_Rwf.b(this.jdField_d_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = null;
    }
    g(paramrrm);
  }
  
  public void b(rrm paramrrm, boolean paramBoolean) {}
  
  public void c()
  {
    pfd.a().b(this.jdField_a_of_type_Pfh);
    k();
    j();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(rrm paramrrm) {}
  
  public void d()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(jdField_a_of_type_ArrayOfFloat[0]);
    if (this.jdField_b_of_type_Rol != null) {
      this.jdField_b_of_type_Rol.jdField_a_of_type_Rln.b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
    }
  }
  
  public void d(rrm paramrrm) {}
  
  public void e()
  {
    int i;
    if (this.jdField_b_of_type_Rol != null)
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
      this.jdField_b_of_type_Rol.jdField_a_of_type_Rln.b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
      return;
      label64:
      i += 1;
    }
  }
  
  public void e(rrm paramrrm) {}
  
  public void f()
  {
    pfd.a().a(this.jdField_a_of_type_Pfh);
  }
  
  public void f(rrm paramrrm) {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Long = 0L;
    c(this.jdField_a_of_type_Rrm, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f());
  }
  
  public void h()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsk
 * JD-Core Version:    0.7.0.1
 */