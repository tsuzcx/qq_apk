import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoReportManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoReportManager.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class rnq
{
  private static final String jdField_a_of_type_JavaLangString = rnq.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private ArrayList<rol> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private rne jdField_a_of_type_Rne;
  private rng jdField_a_of_type_Rng;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  rnq(Activity paramActivity, Bundle paramBundle, VideoFeedsPlayManager paramVideoFeedsPlayManager, rng paramrng)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Rng = paramrng;
    a();
  }
  
  private void a()
  {
    boolean bool = true;
    long l = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    int i;
    if ((this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      i = 1;
      if ((l <= 0L) || (i == 0)) {
        break label138;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_SESSION_ID");
      this.c = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      return;
      i = 0;
      break;
      label138:
      bool = false;
    }
  }
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<rol> paramList, qlq paramqlq, long paramLong, int paramInt)
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
      VideoInfo localVideoInfo;
      int m;
      label176:
      rol localrol;
      int i;
      label273:
      Object localObject;
      label406:
      boolean bool;
      if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
      {
        str1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        n = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        if (!this.jdField_a_of_type_Boolean) {
          break label1003;
        }
        j = 1;
        this.jdField_a_of_type_Boolean = false;
        int i2 = paramIntent.getIntExtra("key_source", -1);
        i3 = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
        int i4 = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i5 = paramIntent.getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i6 = paramIntent.getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str5 = paramIntent.getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty(paramVideoInfo.s)) || (!rdm.d())) {
          break label1009;
        }
        k = 1;
        int i7 = paramList.size();
        localVideoInfo = this.jdField_a_of_type_Rng.a();
        m = 0;
        if (m >= i7) {
          return;
        }
        localrol = (rol)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "播放VV上报 totalPlayTime = " + localrol.jdField_a_of_type_Long + ", currentPlayTime = " + localrol.b);
        }
        if ((localrol.b != 0L) || (localrol.jdField_a_of_type_Long != 0L))
        {
          if (m != 0) {
            break label1015;
          }
          i = 0;
          localObject = new ron(str1, str3, str4, str2).d(localrol.jdField_a_of_type_Long).a(localrol.b).y(i).z(i7 - 1).w(i2).B(paramqlq.l).A(paramqlq.k).D(paramqlq.j).C(paramqlq.i).b(this.jdField_b_of_type_JavaLangString).c(this.c).c(paramLong).l(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean));
          if (paramVideoInfo.y == null) {
            break label1034;
          }
          paramIntent = paramVideoInfo.y;
          paramIntent = ((ron)localObject).a(paramIntent).e(paramVideoInfo.jdField_c_of_type_Boolean).p(ntd.a()).q(ors.e()).e(paramVideoInfo.f).c(paramVideoInfo.o).E(j).K(paramVideoInfo.k).F(i4).g(localVideoInfo.g).v(i3).L(i1).j(false).n(0).k(paramVideoInfo.jdField_j_of_type_Boolean).m(paramVideoInfo.r).S(k);
          if (!paramVideoInfo.e()) {
            break label1041;
          }
          i = 2;
          label518:
          paramIntent = paramIntent.Y(i);
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
            break label1047;
          }
          bool = true;
          label535:
          localObject = paramIntent.l(bool);
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1053;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label571:
          paramIntent = ((ron)localObject).q(paramIntent);
          if (!paramVideoInfo.e()) {
            break label1060;
          }
          i = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
          label594:
          paramIntent = paramIntent.t(i);
          if ((!paramVideoInfo.e()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g))) {
            break label1066;
          }
          i = 1;
          label637:
          localObject = paramIntent.Z(i);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1072;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label673:
          localObject = ((ron)localObject).o(paramIntent);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
            break label1079;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
          label709:
          paramIntent = ((ron)localObject).p(paramIntent).h(localVideoInfo.f).M(otp.a(localVideoInfo.jdField_b_of_type_Int, localVideoInfo.jdField_c_of_type_Int, localVideoInfo.d)).N(1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i3 + ", first_video_row_key : " + localVideoInfo.g + ", first_video_type : " + i4 + "]");
          }
          if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            paramIntent.I(i5).J(i6).j(str5);
          }
          localObject = paramIntent.a().a();
          if (TextUtils.isEmpty(str2)) {
            break label1086;
          }
        }
      }
      label1034:
      label1041:
      label1047:
      label1053:
      label1060:
      label1066:
      label1072:
      label1079:
      label1086:
      for (paramIntent = str2;; paramIntent = "0")
      {
        nrt.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        nrt.a("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        paramIntent = new qlw();
        paramIntent.d = ((int)localrol.b);
        paramIntent.e = ((int)paramLong);
        paramIntent.jdField_b_of_type_Boolean = true;
        paramIntent.jdField_a_of_type_Boolean = qzy.a().c();
        paramIntent.jdField_b_of_type_Int = n;
        paramIntent.f = i3;
        ntd.a(paramVideoInfo, i1, 12, (int)localrol.jdField_a_of_type_Long, paramIntent, localVideoInfo.g);
        m += 1;
        break label176;
        str1 = null;
        break;
        label1003:
        j = -1;
        break label77;
        label1009:
        k = 0;
        break label154;
        label1015:
        if (this.jdField_b_of_type_Boolean)
        {
          i = 2;
          break label273;
        }
        i = 1;
        break label273;
        paramIntent = "";
        break label406;
        i = 1;
        break label518;
        bool = false;
        break label535;
        paramIntent = "";
        break label571;
        i = 0;
        break label594;
        i = 0;
        break label637;
        paramIntent = "";
        break label673;
        paramIntent = "";
        break label709;
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo) {}
  
  public void a(VideoInfo paramVideoInfo, int paramInt)
  {
    ThreadManager.post(new MultiVideoReportManager.2(this, paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity, paramInt), 1, null, true);
  }
  
  public void a(rfs paramrfs)
  {
    VideoInfo localVideoInfo;
    if ((paramrfs != null) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localVideoInfo = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (this.jdField_a_of_type_Rng.a() == null) {
        break label52;
      }
    }
    label52:
    for (paramrfs = this.jdField_a_of_type_Rng.a().g;; paramrfs = null)
    {
      ntd.a(localVideoInfo, 409409, 1, -1, null, paramrfs);
      return;
    }
  }
  
  public void a(rfs paramrfs, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    int i;
    Object localObject;
    if (this.jdField_a_of_type_Rne != null)
    {
      i = this.jdField_a_of_type_Rne.a();
      localObject = new rol();
      if (!paramBoolean) {
        break label152;
      }
    }
    label152:
    for (long l1 = paramrfs.jdField_a_of_type_Rjn.b();; l1 = paramrfs.jdField_a_of_type_Rjn.a())
    {
      ((rol)localObject).b = l1;
      ((rol)localObject).jdField_a_of_type_Long = paramrfs.jdField_a_of_type_Rjn.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ThreadManager.excute(new MultiVideoReportManager.1(this, localIntent, localVideoInfo, (List)localObject, paramrfs, l2, i), 16, null, true);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(rne paramrne)
  {
    this.jdField_a_of_type_Rne = paramrne;
    Object localObject = this.jdField_a_of_type_Rne.a();
    String str3 = ((VideoInfo)localObject).jdField_j_of_type_JavaLangString;
    String str4 = ((VideoInfo)localObject).jdField_a_of_type_JavaLangString;
    String str2 = ((VideoInfo)localObject).g;
    String str1;
    int i;
    if ((((VideoInfo)localObject).jdField_a_of_type_Int == 0) && (((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      str1 = ((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      i = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      localObject = new ron(str1, str3, str4, str2).e(((VideoInfo)localObject).f).c(((VideoInfo)localObject).o).b(this.jdField_b_of_type_JavaLangString).c(this.c).g(i).a(409409).l(this.jdField_a_of_type_Rne.a()).a(Boolean.valueOf(((VideoInfo)localObject).jdField_b_of_type_Boolean)).a(((VideoInfo)localObject).y).e(((VideoInfo)localObject).jdField_c_of_type_Boolean).p(ntd.a()).q(ors.e()).K(((VideoInfo)localObject).k).L(j).n(0).k(((VideoInfo)localObject).jdField_j_of_type_Boolean).m(((VideoInfo)localObject).r).N(1);
      if (TextUtils.isEmpty(str2)) {
        break label297;
      }
      str1 = str2;
      label240:
      nrt.b(null, str3, "0X8007412", "0X8007412", 0, 0, String.valueOf(i), null, str1, ((ron)localObject).a().a(), false);
      i = paramrne.a();
      if (i <= this.jdField_a_of_type_Int) {
        break label305;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = i;
      return;
      str1 = null;
      break;
      label297:
      str1 = "0";
      break label240;
      label305:
      i = this.jdField_a_of_type_Int;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    rmd.a().a("multi_video", this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Rne == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Rne.a();
    int i = this.jdField_a_of_type_Rne.a();
    if (this.jdField_a_of_type_Rng.a() != null)
    {
      str = this.jdField_a_of_type_Rng.a().g;
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      localObject = new ron("", "", "", "").b(this.jdField_b_of_type_JavaLangString).a(409409).b((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L).e(((VideoInfo)localObject).f).c(((VideoInfo)localObject).o).l(i).r(((VideoInfo)localObject).d()).s(this.jdField_a_of_type_Int + 1).d(((VideoInfo)localObject).jdField_j_of_type_JavaLangString).e(((VideoInfo)localObject).jdField_a_of_type_JavaLangString).f(((VideoInfo)localObject).g).g(str).F(j).N(1);
      if (!paramBoolean) {
        break label249;
      }
    }
    label249:
    for (String str = "1";; str = "0")
    {
      nrt.a(null, "", "0X8007DBB", "0X8007DBB", 0, 0, str, "", "", ((ron)localObject).a().a(), false);
      return;
      str = null;
      break;
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e())
    {
      localObject = new ron(paramVideoInfo).h(paramVideoInfo.g).t(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.c != null) {}
      for (paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.c.e;; paramVideoInfo = "")
      {
        nrt.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((ron)localObject).o(paramVideoInfo).R(2).N(1).a().a(), false);
        return;
      }
    }
    Object localObject = new ron(null, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(paramVideoInfo.y).N(1).a().a();
    String str = paramVideoInfo.jdField_j_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      nrt.a(null, str, "0X80078FD", "0X80078FD", 0, 0, "", "", paramVideoInfo, (String)localObject, false);
      return;
    }
  }
  
  public void b(rfs paramrfs)
  {
    if ((paramrfs != null) && (paramrfs.jdField_a_of_type_Rjn != null))
    {
      rol localrol = new rol();
      localrol.jdField_a_of_type_Long = paramrfs.jdField_a_of_type_Rjn.a(true);
      localrol.b = paramrfs.jdField_a_of_type_Rjn.b();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localrol.jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + localrol.b);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localrol);
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    String str1 = new ron(null, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(-1).N(1).a().a();
    String str2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      nrt.a(null, str2, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, str1, false);
      return;
    }
  }
  
  public void c(rfs paramrfs)
  {
    String str1;
    if ((paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      str1 = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    for (;;)
    {
      try
      {
        String str3 = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g))
        {
          str2 = paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
          nrt.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, ntd.a(str1, paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000, new JSONObject().put("video_type", 1)), false);
          return;
        }
        String str2 = "0";
        continue;
        str1 = null;
      }
      catch (Exception paramrfs)
      {
        return;
      }
    }
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (paramVideoInfo.y == null) {
          continue;
        }
        str = paramVideoInfo.y;
        localJSONObject.put("video_report_info", str);
        localJSONObject.put("video_type", 1);
      }
      catch (JSONException localJSONException)
      {
        String str;
        localJSONException.printStackTrace();
        continue;
      }
      nrt.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", ntd.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      return;
      str = "";
    }
  }
  
  public void e(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    String str;
    Object localObject;
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      str = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject = new ron(str, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000).N(1);
      ((ron)localObject).e(paramVideoInfo.f).c(paramVideoInfo.o).a(-1).a(paramVideoInfo.y);
      qlw localqlw = new qlw();
      localqlw.d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
      localqlw.e = (paramVideoInfo.a() * 1000);
      localqlw.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      if (this.jdField_a_of_type_Rng.a() == null) {
        break label259;
      }
      str = this.jdField_a_of_type_Rng.a().g;
      label189:
      ntd.a(paramVideoInfo, i, 25, -1, localqlw, str);
      str = ((ron)localObject).a().a();
      localObject = paramVideoInfo.jdField_j_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label264;
      }
    }
    label259:
    label264:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      nrt.a(null, (String)localObject, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, str, false);
      return;
      str = null;
      break;
      str = null;
      break label189;
    }
  }
  
  public void f(VideoInfo paramVideoInfo)
  {
    int i = 1;
    if (paramVideoInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel_id", 409409);
      if (paramVideoInfo.p) {
        i = 0;
      }
      localJSONObject.put("type", i);
      if (paramVideoInfo.y == null) {
        break label212;
      }
      str1 = paramVideoInfo.y;
      localJSONObject.put("video_report_info", str1);
      localJSONObject.put("algorithm_id", paramVideoInfo.f);
      localJSONObject.put("is_display_download_bar", 0);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label219;
      }
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.c;
      label106:
      localJSONObject.put("common_data", str1);
      localJSONObject.put("video_type", 1);
    }
    catch (Exception localException)
    {
      String str1;
      label126:
      String str3;
      label148:
      String str2;
      break label126;
    }
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      str1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      str3 = paramVideoInfo.jdField_j_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label231;
      }
    }
    label212:
    label219:
    label231:
    for (str2 = paramVideoInfo.g;; str2 = "0")
    {
      nrt.a(null, str3, "0X80091A9", "0X80091A9", 0, 0, "0", "0", str2, ntd.a(str1, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
      return;
      str1 = "";
      break;
      str1 = "";
      break label106;
      str1 = null;
      break label148;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rnq
 * JD-Core Version:    0.7.0.1
 */