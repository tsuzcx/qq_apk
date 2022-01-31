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

public class qyi
{
  private static final String jdField_a_of_type_JavaLangString = qyi.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private ArrayList<qzc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private qxs jdField_a_of_type_Qxs;
  private qxu jdField_a_of_type_Qxu;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  qyi(Activity paramActivity, Bundle paramBundle, VideoFeedsPlayManager paramVideoFeedsPlayManager, qxu paramqxu)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_Qxu = paramqxu;
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
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<qzc> paramList, qbx paramqbx, long paramLong, int paramInt)
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
      qzc localqzc;
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
        if ((TextUtils.isEmpty(paramVideoInfo.J)) || (!qol.d())) {
          break label1009;
        }
        k = 1;
        int i7 = paramList.size();
        localVideoInfo = this.jdField_a_of_type_Qxu.a();
        m = 0;
        if (m >= i7) {
          return;
        }
        localqzc = (qzc)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "播放VV上报 totalPlayTime = " + localqzc.jdField_a_of_type_Long + ", currentPlayTime = " + localqzc.b);
        }
        if ((localqzc.b != 0L) || (localqzc.jdField_a_of_type_Long != 0L))
        {
          if (m != 0) {
            break label1015;
          }
          i = 0;
          localObject = new qze(str1, str3, str4, str2).d(localqzc.jdField_a_of_type_Long).a(localqzc.b).z(i).A(i7 - 1).x(i2).C(paramqbx.l).B(paramqbx.k).E(paramqbx.j).D(paramqbx.i).b(this.jdField_b_of_type_JavaLangString).c(this.c).c(paramLong).m(paramInt).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean));
          if (paramVideoInfo.N == null) {
            break label1034;
          }
          paramIntent = paramVideoInfo.N;
          paramIntent = ((qze)localObject).a(paramIntent).d(paramVideoInfo.jdField_c_of_type_Boolean).q(npx.a()).r(onk.e()).e(paramVideoInfo.f).d(paramVideoInfo.r).F(j).L(paramVideoInfo.o).G(i4).g(localVideoInfo.g).w(i3).M(i1).i(false).o(0).j(paramVideoInfo.jdField_j_of_type_Boolean).m(paramVideoInfo.I).T(k);
          if (!paramVideoInfo.e()) {
            break label1041;
          }
          i = 2;
          label518:
          paramIntent = paramIntent.Z(i);
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
            break label1047;
          }
          bool = true;
          label535:
          localObject = paramIntent.k(bool);
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1053;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label571:
          paramIntent = ((qze)localObject).q(paramIntent);
          if (!paramVideoInfo.e()) {
            break label1060;
          }
          i = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
          label594:
          paramIntent = paramIntent.u(i);
          if ((!paramVideoInfo.e()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.f))) {
            break label1066;
          }
          i = 1;
          label637:
          localObject = paramIntent.aa(i);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1072;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label673:
          localObject = ((qze)localObject).o(paramIntent);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
            break label1079;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
          label709:
          paramIntent = ((qze)localObject).p(paramIntent).h(localVideoInfo.f).N(oph.a(localVideoInfo.jdField_b_of_type_Int, localVideoInfo.jdField_c_of_type_Int, localVideoInfo.d)).O(1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i3 + ", first_video_row_key : " + localVideoInfo.g + ", first_video_type : " + i4 + "]");
          }
          if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            paramIntent.J(i5).K(i6).j(str5);
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
        noo.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        noo.a("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        paramIntent = new qcd();
        paramIntent.d = ((int)localqzc.b);
        paramIntent.e = ((int)paramLong);
        paramIntent.jdField_b_of_type_Boolean = true;
        paramIntent.jdField_a_of_type_Boolean = qku.a().c();
        paramIntent.jdField_b_of_type_Int = n;
        paramIntent.f = i3;
        npx.a(paramVideoInfo, i1, 12, (int)localqzc.jdField_a_of_type_Long, paramIntent, localVideoInfo.g);
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
  
  public void a(qqo paramqqo)
  {
    VideoInfo localVideoInfo;
    if ((paramqqo != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localVideoInfo = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (this.jdField_a_of_type_Qxu.a() == null) {
        break label52;
      }
    }
    label52:
    for (paramqqo = this.jdField_a_of_type_Qxu.a().g;; paramqqo = null)
    {
      npx.a(localVideoInfo, 409409, 1, -1, null, paramqqo);
      return;
    }
  }
  
  public void a(qqo paramqqo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    int i;
    Object localObject;
    if (this.jdField_a_of_type_Qxs != null)
    {
      i = this.jdField_a_of_type_Qxs.a();
      localObject = new qzc();
      if (!paramBoolean) {
        break label152;
      }
    }
    label152:
    for (long l1 = paramqqo.jdField_a_of_type_Qub.b();; l1 = paramqqo.jdField_a_of_type_Qub.a())
    {
      ((qzc)localObject).b = l1;
      ((qzc)localObject).jdField_a_of_type_Long = paramqqo.jdField_a_of_type_Qub.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ThreadManager.excute(new MultiVideoReportManager.1(this, localIntent, localVideoInfo, (List)localObject, paramqqo, l2, i), 16, null, true);
      return;
      i = 0;
      break;
    }
  }
  
  public void a(qxs paramqxs)
  {
    this.jdField_a_of_type_Qxs = paramqxs;
    Object localObject = this.jdField_a_of_type_Qxs.a();
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
      localObject = new qze(str1, str3, str4, str2).e(((VideoInfo)localObject).f).d(((VideoInfo)localObject).r).b(this.jdField_b_of_type_JavaLangString).c(this.c).h(i).a(409409).m(this.jdField_a_of_type_Qxs.a()).a(Boolean.valueOf(((VideoInfo)localObject).jdField_b_of_type_Boolean)).a(((VideoInfo)localObject).N).d(((VideoInfo)localObject).jdField_c_of_type_Boolean).q(npx.a()).r(onk.e()).L(((VideoInfo)localObject).o).M(j).o(0).j(((VideoInfo)localObject).jdField_j_of_type_Boolean).m(((VideoInfo)localObject).I).O(1);
      if (TextUtils.isEmpty(str2)) {
        break label297;
      }
      str1 = str2;
      label240:
      noo.b(null, str3, "0X8007412", "0X8007412", 0, 0, String.valueOf(i), null, str1, ((qze)localObject).a().a(), false);
      i = paramqxs.a();
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
    if (this.jdField_a_of_type_Qxs == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Qxs.a();
    int i = this.jdField_a_of_type_Qxs.a();
    if (this.jdField_a_of_type_Qxu.a() != null)
    {
      str = this.jdField_a_of_type_Qxu.a().g;
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      localObject = new qze("", "", "", "").b(this.jdField_b_of_type_JavaLangString).a(409409).b((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L).e(((VideoInfo)localObject).f).d(((VideoInfo)localObject).r).m(i).s(((VideoInfo)localObject).d()).t(this.jdField_a_of_type_Int + 1).d(((VideoInfo)localObject).jdField_j_of_type_JavaLangString).e(((VideoInfo)localObject).jdField_a_of_type_JavaLangString).f(((VideoInfo)localObject).g).g(str).G(j).O(1);
      if (!paramBoolean) {
        break label236;
      }
    }
    label236:
    for (String str = "1";; str = "0")
    {
      noo.a(null, "", "0X8007DBB", "0X8007DBB", 0, 0, str, "", "", ((qze)localObject).a().a(), false);
      return;
      str = null;
      break;
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.e())
    {
      localObject = new qze(paramVideoInfo).h(paramVideoInfo.g).u(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.c != null) {}
      for (paramVideoInfo = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.c.e;; paramVideoInfo = "")
      {
        noo.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((qze)localObject).o(paramVideoInfo).S(2).O(1).a().a(), false);
        return;
      }
    }
    Object localObject = new qze(null, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(paramVideoInfo.N).O(1).a().a();
    String str = paramVideoInfo.jdField_j_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      noo.a(null, str, "0X80078FD", "0X80078FD", 0, 0, "", "", paramVideoInfo, (String)localObject, false);
      return;
    }
  }
  
  public void b(qqo paramqqo)
  {
    if ((paramqqo != null) && (paramqqo.jdField_a_of_type_Qub != null))
    {
      qzc localqzc = new qzc();
      localqzc.jdField_a_of_type_Long = paramqqo.jdField_a_of_type_Qub.a(true);
      localqzc.b = paramqqo.jdField_a_of_type_Qub.b();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localqzc.jdField_a_of_type_Long + ", detailInfo.currentPlayTime = " + localqzc.b);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localqzc);
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    String str1 = new qze(null, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000L).a(-1).O(1).a().a();
    String str2 = paramVideoInfo.jdField_j_of_type_JavaLangString;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      noo.a(null, str2, "0X8007410", "0X8007410", 0, 0, "0", "", paramVideoInfo, str1, false);
      return;
    }
  }
  
  public void c(qqo paramqqo)
  {
    String str1;
    if ((paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
      str1 = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    for (;;)
    {
      try
      {
        String str3 = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g))
        {
          str2 = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
          noo.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, npx.a(str1, paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000, new JSONObject().put("video_type", 1)), false);
          return;
        }
        String str2 = "0";
        continue;
        str1 = null;
      }
      catch (Exception paramqqo)
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
        if (paramVideoInfo.N == null) {
          continue;
        }
        str = paramVideoInfo.N;
        localJSONObject.put("video_report_info", str);
        localJSONObject.put("video_type", 1);
      }
      catch (JSONException localJSONException)
      {
        String str;
        localJSONException.printStackTrace();
        continue;
      }
      noo.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", npx.a("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
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
      localObject = new qze(str, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000).O(1);
      ((qze)localObject).e(paramVideoInfo.f).d(paramVideoInfo.r).a(-1).a(paramVideoInfo.N);
      qcd localqcd = new qcd();
      localqcd.d = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
      localqcd.e = (paramVideoInfo.a() * 1000);
      localqcd.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      if (this.jdField_a_of_type_Qxu.a() == null) {
        break label259;
      }
      str = this.jdField_a_of_type_Qxu.a().g;
      label189:
      npx.a(paramVideoInfo, i, 25, -1, localqcd, str);
      str = ((qze)localObject).a().a();
      localObject = paramVideoInfo.jdField_j_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label264;
      }
    }
    label259:
    label264:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      noo.a(null, (String)localObject, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, str, false);
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
      if (paramVideoInfo.l) {
        i = 0;
      }
      localJSONObject.put("type", i);
      if (paramVideoInfo.N == null) {
        break label212;
      }
      str1 = paramVideoInfo.N;
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
      noo.a(null, str3, "0X80091A9", "0X80091A9", 0, 0, "0", "0", str2, npx.a(str1, paramVideoInfo.jdField_j_of_type_JavaLangString, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyi
 * JD-Core Version:    0.7.0.1
 */