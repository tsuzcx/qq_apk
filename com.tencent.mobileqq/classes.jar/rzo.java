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

public class rzo
  implements ryq, rzt
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
  private ArrayList<sia> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private pkt jdField_a_of_type_Pkt = new rzp(this);
  private rvn jdField_a_of_type_Rvn;
  private ryo jdField_a_of_type_Ryo;
  private rzk jdField_a_of_type_Rzk;
  private txu jdField_a_of_type_Txu;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  private rvn jdField_b_of_type_Rvn;
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
    jdField_a_of_type_ArrayOfInt = new int[] { 2130841820, 2130841819, 2130841821 };
  }
  
  public rzo(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, boolean paramBoolean2, boolean paramBoolean3, ArrayList<VideoInfo> paramArrayList, int paramInt)
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
    this.jdField_a_of_type_Int = pay.e();
    this.jdField_b_of_type_Int = ofe.a();
    paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    this.jdField_d_of_type_Boolean = bkwm.d();
    if ((paramInt == 4) || (paramInt == 5) || (paramInt == 2) || (paramInt == 1)) {
      this.jdField_a_of_type_Int = 5;
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(128);
      label220:
      this.jdField_d_of_type_JavaLangString = paramActivity.getIntent().getStringExtra("video_player_session_id");
      ThreadManager.excute(new VideoFeedsRecommendPresenter.2(this), 16, null, true);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      break label220;
    }
  }
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<sia> paramList, rdt paramrdt, long paramLong, int paramInt, boolean paramBoolean)
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
      sia localsia;
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
        if ((TextUtils.isEmpty(paramVideoInfo.u)) || (!rwv.e())) {
          break label881;
        }
        k = 1;
        int i7 = paramIntent.getIntExtra("RETURN_SCENE", 0);
        int i8 = paramList.size();
        m = 0;
        if (m >= i8) {
          return;
        }
        localsia = (sia)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendPresenter", 2, "播放VV上报 totalPlayTime = " + localsia.jdField_a_of_type_Long + ", currentPlayTime = " + localsia.jdField_b_of_type_Long);
        }
        if ((localsia.jdField_b_of_type_Long != 0L) || (localsia.jdField_a_of_type_Long != 0L))
        {
          if (m != 0) {
            break label887;
          }
          i = 0;
          paramIntent = new sie(str1, str3, str4, str2).d(localsia.jdField_a_of_type_Long).a(localsia.jdField_b_of_type_Long).x(i).y(i8 - 1).v(i2).A(paramrdt.m).z(paramrdt.l).C(paramrdt.k).B(paramrdt.j).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_c_of_type_JavaLangString).c(paramLong).l(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean)).a(paramVideoInfo.y).e(paramVideoInfo.jdField_c_of_type_Boolean).q(this.jdField_b_of_type_Int).r(this.jdField_a_of_type_Int).e(paramVideoInfo.f).c(paramVideoInfo.q).D(j).J(paramVideoInfo.l).E(i4).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).u(i3).K(i1).i(false).n(0).j(paramVideoInfo.jdField_j_of_type_Boolean).n(paramVideoInfo.t).R(k).a(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.f).L(pcv.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int)).M(0).b(this.jdField_d_of_type_Boolean).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).ab(i7).k(shg.a.a());
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
          odq.b(null, str3, "0X8009297", "0X8009297", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, str6, false);
          odq.a("0X8009297", str3, String.valueOf(n), String.valueOf(i1), "", str6);
        }
      }
      for (;;)
      {
        paramIntent = new rdz();
        paramIntent.jdField_d_of_type_Int = ((int)localsia.jdField_b_of_type_Long);
        paramIntent.jdField_e_of_type_Int = ((int)paramLong);
        paramIntent.jdField_b_of_type_Boolean = true;
        paramIntent.jdField_a_of_type_Boolean = rtp.a().c();
        paramIntent.jdField_b_of_type_Int = n;
        paramIntent.f = i3;
        ofe.b(paramVideoInfo, i1, 12, (int)localsia.jdField_a_of_type_Long, paramIntent, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
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
        odq.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, str6, false);
        odq.a("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", str6);
      }
    }
  }
  
  private static boolean a(ryo paramryo)
  {
    return (paramryo != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramryo.jdField_a_of_type_Rds != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void c(ryo paramryo, boolean paramBoolean)
  {
    int i = 1;
    if ((paramryo == null) || (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (paramryo.jdField_a_of_type_Sdj == null)) {
      return;
    }
    boolean bool = paramryo.jdField_a_of_type_AndroidOsBundle.getBoolean("is_auto_play", true);
    paramryo = sic.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("dt_vdend").b("6").e(paramryo.jdField_a_of_type_Sdj.b()).e(paramryo.jdField_a_of_type_Sdj.a()).a(bool).b(System.currentTimeMillis()).c(paramryo.jdField_a_of_type_Sdj.a(paramBoolean)).c(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
    if (this.jdField_c_of_type_Boolean) {
      i = 2;
    }
    sib.a(paramryo.b(i));
  }
  
  private void g(ryo paramryo)
  {
    int i = 1;
    if ((paramryo == null) || (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (paramryo.jdField_a_of_type_Sdj == null)) {
      return;
    }
    boolean bool = paramryo.jdField_a_of_type_AndroidOsBundle.getBoolean("is_auto_play", true);
    paramryo = sic.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).a("dt_vdstart").b("6").e(paramryo.jdField_a_of_type_Sdj.b()).e(paramryo.jdField_a_of_type_Sdj.a()).a(bool).a(System.currentTimeMillis());
    if (this.jdField_c_of_type_Boolean) {
      i = 2;
    }
    sib.a(paramryo.b(i).c(this.jdField_a_of_type_JavaUtilArrayList.size()));
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
      sie localsie = new sie(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
      localsie.M(0).W(i).o(str2);
      odq.b(null, str1, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", str2, localsie.a().a(), false);
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
        Object localObject3 = new sie(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo).M(0);
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
          localObject3 = ((sie)localObject3).b((VideoColumnInfo)localObject1).b(this.jdField_b_of_type_Long).u(this.jdField_e_of_type_Int).m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()).a();
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
            odq.a(localQQAppInterface, (String)localObject1, "0X800AF2E", "0X800AF2E", 0, 0, "", "", "", ((sid)localObject3).a(), false);
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
      sie localsie = new sie(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localsie.O(this.jdField_c_of_type_Int);
      odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localsie.a().a(), false);
    }
  }
  
  private void l()
  {
    if ((this.jdField_b_of_type_Rvn != null) && (this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = false;
      pkp.a().b(this.jdField_a_of_type_Pkt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_b_of_type_Rvn.jdField_a_of_type_Ryo, false);
    }
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_Rvn = this.jdField_b_of_type_Rvn;
    if ((paramViewHolder instanceof rvn))
    {
      this.jdField_b_of_type_Rvn = ((rvn)paramViewHolder);
      this.jdField_a_of_type_Ryo = this.jdField_b_of_type_Rvn.jdField_a_of_type_Ryo;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (this.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj != null) {
        this.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj.i();
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Rvn != null) && (this.jdField_b_of_type_Rvn != null) && (this.jdField_a_of_type_Rvn.jdField_c_of_type_Int > this.jdField_b_of_type_Rvn.jdField_c_of_type_Int)) {
        this.jdField_c_of_type_Int += 1;
      }
      d();
      return;
      this.jdField_b_of_type_Rvn = null;
      this.jdField_a_of_type_Ryo = null;
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(ryo paramryo) {}
  
  public void a(ryo paramryo, int paramInt)
  {
    if ((paramryo != null) && (paramryo.jdField_a_of_type_Sdj != null))
    {
      sia localsia = new sia();
      localsia.jdField_a_of_type_Long = paramryo.jdField_a_of_type_Sdj.a(true);
      localsia.jdField_b_of_type_Long = paramryo.jdField_a_of_type_Sdj.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localsia.jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + localsia.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localsia);
      if ((a(paramryo)) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
        txg.a(paramryo, this.jdField_a_of_type_AndroidAppActivity, paramryo.jdField_a_of_type_Sdj);
      }
      if (this.jdField_a_of_type_Txu != null) {
        this.jdField_a_of_type_Txu.b(this.jdField_b_of_type_Rvn.jdField_c_of_type_Int, paramryo, this.jdField_b_of_type_JavaUtilArrayList);
      }
      c(paramryo, true);
      g(paramryo);
    }
  }
  
  public void a(ryo paramryo, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(ryo paramryo, boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
    int i;
    Object localObject;
    long l1;
    label88:
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Rvn != null)
    {
      i = this.jdField_a_of_type_Rvn.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Rvn != null) {
        int j = this.jdField_a_of_type_Rvn.jdField_b_of_type_Int;
      }
      localObject = new sia();
      if (!paramBoolean) {
        break label224;
      }
      l1 = paramryo.jdField_a_of_type_Sdj.b();
      ((sia)localObject).jdField_b_of_type_Long = l1;
      ((sia)localObject).jdField_a_of_type_Long = paramryo.jdField_a_of_type_Sdj.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      c(paramryo, paramBoolean);
      localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (!(this.jdField_a_of_type_Rvn instanceof rvs)) {
        break label236;
      }
      localObject = (rvs)this.jdField_a_of_type_Rvn;
      label163:
      if ((localObject == null) || (((rvs)localObject).j == null)) {
        break label242;
      }
      paramBoolean = bool;
      if (((rvs)localObject).j.getVisibility() != 0) {}
    }
    label224:
    label236:
    label242:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.excute(new VideoFeedsRecommendPresenter.3(this, localIntent, localVideoInfo, localArrayList, paramryo, l2, i, paramBoolean), 16, null, true);
      return;
      i = 0;
      break;
      l1 = paramryo.jdField_a_of_type_Sdj.a();
      break label88;
      localObject = null;
      break label163;
    }
  }
  
  public void a(rzk paramrzk)
  {
    this.jdField_a_of_type_Rzk = paramrzk;
  }
  
  public void a(txu paramtxu)
  {
    this.jdField_a_of_type_Txu = paramtxu;
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void b()
  {
    int j = 0;
    ryo localryo;
    int i;
    if (this.jdField_b_of_type_Rvn != null)
    {
      localryo = this.jdField_b_of_type_Rvn.jdField_a_of_type_Ryo;
      i = j;
      if (localryo != null)
      {
        i = j;
        if (localryo.jdField_a_of_type_Sdj != null) {
          i = localryo.jdField_a_of_type_Sdj.b();
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
        localryo = null;
        break;
        if (a(localryo)) {
          localryo.jdField_a_of_type_Rds.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localryo, false);
        return;
        if (a(localryo)) {
          localryo.jdField_a_of_type_Rds.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localryo);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localryo, true);
        return;
        String str1;
        if ((localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          str1 = localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
        for (;;)
        {
          try
          {
            String str3 = localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
            if (TextUtils.isEmpty(localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
              continue;
            }
            str2 = localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
            odq.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, ofe.a(str1, localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000, new JSONObject().put("video_type", 0)), false);
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
        if (a(localryo)) {
          localryo.jdField_a_of_type_Rds.jdField_a_of_type_Boolean = false;
        }
      } while (localryo.a("continue_pause", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
    }
    if (a(localryo)) {
      localryo.jdField_a_of_type_Rds.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(ryo paramryo) {}
  
  public void b(ryo paramryo, boolean paramBoolean) {}
  
  public void c()
  {
    pkp.a().b(this.jdField_a_of_type_Pkt);
    k();
    j();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(ryo paramryo) {}
  
  public void d()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(jdField_a_of_type_ArrayOfFloat[0]);
    if (this.jdField_b_of_type_Rvn != null) {
      this.jdField_b_of_type_Rvn.jdField_a_of_type_Rsn.b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
    }
  }
  
  public void d(ryo paramryo)
  {
    if (this.jdField_a_of_type_Txu != null) {
      this.jdField_a_of_type_Txu.a(this.jdField_b_of_type_Rvn.jdField_c_of_type_Int, paramryo, this.jdField_b_of_type_JavaUtilArrayList);
    }
    odq.a(null, "", "0X800AF11", "0X800AF11", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      paramryo.jdField_a_of_type_Sdj.a(this.jdField_d_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = null;
    }
    g(paramryo);
  }
  
  public void e()
  {
    int i;
    if (this.jdField_b_of_type_Rvn != null)
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
      this.jdField_b_of_type_Rvn.jdField_a_of_type_Rsn.b(jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int]);
      return;
      label64:
      i += 1;
    }
  }
  
  public void e(ryo paramryo)
  {
    if ((paramryo != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!this.jdField_a_of_type_Boolean)) {
      ofe.b(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 409409, 1, -1, null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
  }
  
  public void f()
  {
    pkp.a().a(this.jdField_a_of_type_Pkt);
  }
  
  public void f(ryo paramryo) {}
  
  public void g()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_b_of_type_Long += System.currentTimeMillis() - this.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Long = 0L;
    c(this.jdField_a_of_type_Ryo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g());
  }
  
  public void h()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    l();
  }
  
  public void y_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzo
 * JD-Core Version:    0.7.0.1
 */