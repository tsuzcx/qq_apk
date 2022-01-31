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

public class qrm
  implements qqq, qrq
{
  private int jdField_a_of_type_Int = 5;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<qzc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private qks jdField_a_of_type_Qks;
  private qmi jdField_a_of_type_Qmi;
  private qqo jdField_a_of_type_Qqo;
  private qri jdField_a_of_type_Qri;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  private qmi jdField_b_of_type_Qmi;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private final boolean d;
  
  public qrm(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, ArrayList<VideoInfo> paramArrayList)
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
    this.jdField_a_of_type_Int = onk.e();
    this.jdField_b_of_type_Int = npx.a();
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
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<qzc> paramList, qbx paramqbx, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
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
      label165:
      qzc localqzc;
      int i;
      label261:
      Object localObject;
      label395:
      label491:
      boolean bool;
      if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
      {
        str2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        n = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        if (!this.jdField_b_of_type_Boolean) {
          break label1060;
        }
        j = 1;
        this.jdField_b_of_type_Boolean = false;
        int i2 = paramIntent.getIntExtra("key_source", -1);
        i3 = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
        int i4 = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i5 = paramIntent.getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i6 = paramIntent.getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str5 = paramIntent.getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty(paramVideoInfo.J)) || (!qol.d())) {
          break label1066;
        }
        k = 1;
        int i7 = paramList.size();
        m = 0;
        if (m >= i7) {
          return;
        }
        localqzc = (qzc)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendPresenter", 2, "播放VV上报 totalPlayTime = " + localqzc.a + ", currentPlayTime = " + localqzc.b);
        }
        if ((localqzc.b != 0L) || (localqzc.a != 0L))
        {
          if (m != 0) {
            break label1072;
          }
          i = 0;
          localObject = new qze(str2, str3, str4, str1).d(localqzc.a).a(localqzc.b).z(i).A(i7 - 1).x(i2).C(paramqbx.l).B(paramqbx.k).E(paramqbx.j).D(paramqbx.i).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_b_of_type_JavaLangString).c(paramLong).m(paramInt1).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean));
          if (paramVideoInfo.N == null) {
            break label1091;
          }
          paramIntent = paramVideoInfo.N;
          paramIntent = ((qze)localObject).a(paramIntent).d(paramVideoInfo.jdField_c_of_type_Boolean).q(this.jdField_b_of_type_Int).r(this.jdField_a_of_type_Int).e(paramVideoInfo.f).d(paramVideoInfo.r).F(j).L(paramVideoInfo.o).G(i4).g(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).w(i3).M(i1).i(false);
          if ((paramBoolean) || (paramInt2 <= 0)) {
            break label1098;
          }
          i = 1;
          paramIntent = paramIntent.o(i).j(paramVideoInfo.jdField_j_of_type_Boolean).m(paramVideoInfo.I).T(k);
          if (!paramVideoInfo.e()) {
            break label1104;
          }
          i = 2;
          label527:
          paramIntent = paramIntent.Z(i);
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
            break label1110;
          }
          bool = true;
          label544:
          localObject = paramIntent.k(bool);
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1116;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label580:
          paramIntent = ((qze)localObject).q(paramIntent);
          if (!paramVideoInfo.e()) {
            break label1123;
          }
          i = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
          label603:
          paramIntent = paramIntent.u(i);
          if ((!paramVideoInfo.e()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.f))) {
            break label1129;
          }
          i = 1;
          label646:
          localObject = paramIntent.aa(i);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1135;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label682:
          localObject = ((qze)localObject).o(paramIntent);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
            break label1142;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
          label718:
          paramIntent = ((qze)localObject).p(paramIntent).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.f).N(oph.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.d)).O(0);
          if (!this.d) {
            break label1149;
          }
          i = 1;
          label776:
          paramIntent = paramIntent.c(i);
          if (!paramBoolean) {
            paramIntent.n(paramInt2);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "play video [video_from_type : " + i3 + ", first_video_row_key : " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g + ", first_video_type : " + i4 + "]");
          }
          if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
            paramIntent.J(i5).K(i6).j(str5);
          }
          localObject = paramIntent.a().a();
          if (!this.jdField_a_of_type_Boolean) {
            break label1162;
          }
          if (TextUtils.isEmpty(str1)) {
            break label1155;
          }
        }
      }
      label1155:
      for (paramIntent = str1;; paramIntent = "0")
      {
        noo.b(null, str3, "0X8009297", "0X8009297", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        noo.a("0X8009297", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        paramIntent = new qcd();
        paramIntent.d = ((int)localqzc.b);
        paramIntent.e = ((int)paramLong);
        paramIntent.jdField_b_of_type_Boolean = true;
        paramIntent.jdField_a_of_type_Boolean = qku.a().c();
        paramIntent.jdField_b_of_type_Int = n;
        paramIntent.f = i3;
        npx.b(paramVideoInfo, i1, 12, (int)localqzc.a, paramIntent, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
        m += 1;
        break label165;
        str2 = null;
        break;
        label1060:
        j = -1;
        break label77;
        label1066:
        k = 0;
        break label154;
        label1072:
        if (this.jdField_c_of_type_Boolean)
        {
          i = 2;
          break label261;
        }
        i = 1;
        break label261;
        label1091:
        paramIntent = "";
        break label395;
        label1098:
        i = 0;
        break label491;
        label1104:
        i = 1;
        break label527;
        label1110:
        bool = false;
        break label544;
        label1116:
        paramIntent = "";
        break label580;
        label1123:
        i = 0;
        break label603;
        label1129:
        i = 0;
        break label646;
        label1135:
        paramIntent = "";
        break label682;
        label1142:
        paramIntent = "";
        break label718;
        label1149:
        i = 0;
        break label776;
      }
      label1162:
      if (!TextUtils.isEmpty(str1)) {}
      for (paramIntent = str1;; paramIntent = "0")
      {
        noo.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        noo.a("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        break;
      }
    }
  }
  
  private static boolean a(qqo paramqqo)
  {
    return (paramqqo != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqqo.jdField_a_of_type_Qbw != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    qze localqze = new qze(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    localqze.O(0).Y(i).n(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    noo.b(null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g, localqze.a().a(), false);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      qze localqze = new qze(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localqze.Q(this.jdField_c_of_type_Int);
      noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localqze.a().a(), false);
    }
  }
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_Qmi = this.jdField_b_of_type_Qmi;
    if ((paramViewHolder instanceof qmi))
    {
      this.jdField_b_of_type_Qmi = ((qmi)paramViewHolder);
      this.jdField_a_of_type_Qqo = this.jdField_b_of_type_Qmi.jdField_a_of_type_Qqo;
    }
    for (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null)
    {
      if ((this.jdField_a_of_type_Qmi != null) && (this.jdField_b_of_type_Qmi != null) && (this.jdField_a_of_type_Qmi.jdField_c_of_type_Int > this.jdField_b_of_type_Qmi.jdField_c_of_type_Int)) {
        this.jdField_c_of_type_Int += 1;
      }
      return;
      this.jdField_b_of_type_Qmi = null;
      this.jdField_a_of_type_Qqo = null;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(qks paramqks)
  {
    this.jdField_a_of_type_Qks = paramqks;
  }
  
  public void a(qqo paramqqo)
  {
    if ((paramqqo != null) && (paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!this.jdField_a_of_type_Boolean)) {
      npx.b(paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 409409, 1, -1, null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
  }
  
  public void a(qqo paramqqo, int paramInt)
  {
    if ((paramqqo != null) && (paramqqo.jdField_a_of_type_Qub != null))
    {
      qzc localqzc = new qzc();
      localqzc.a = paramqqo.jdField_a_of_type_Qub.a(true);
      localqzc.b = paramqqo.jdField_a_of_type_Qub.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localqzc.a + ", detailInfo.currentPlayTime = " + localqzc.b);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localqzc);
      if ((a(paramqqo)) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
        obf.a(paramqqo, this.jdField_a_of_type_AndroidAppActivity, paramqqo.jdField_a_of_type_Qub);
      }
      if (this.jdField_a_of_type_Qks != null) {
        this.jdField_a_of_type_Qks.b(this.jdField_b_of_type_Qmi.jdField_c_of_type_Int, paramqqo, this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public void a(qqo paramqqo, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qqo paramqqo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    int i;
    int j;
    label63:
    boolean bool;
    label83:
    Object localObject;
    if (this.jdField_a_of_type_Qmi != null)
    {
      i = this.jdField_a_of_type_Qmi.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Qmi == null) {
        break label190;
      }
      j = this.jdField_a_of_type_Qmi.jdField_b_of_type_Int;
      if ((this.jdField_a_of_type_Qmi == null) || (!this.jdField_a_of_type_Qmi.jdField_b_of_type_Boolean)) {
        break label196;
      }
      bool = true;
      localObject = new qzc();
      if (!paramBoolean) {
        break label202;
      }
    }
    label190:
    label196:
    label202:
    for (long l1 = paramqqo.jdField_a_of_type_Qub.b();; l1 = paramqqo.jdField_a_of_type_Qub.a())
    {
      ((qzc)localObject).b = l1;
      ((qzc)localObject).a = paramqqo.jdField_a_of_type_Qub.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ThreadManager.excute(new VideoFeedsRecommendPresenter.1(this, localIntent, localVideoInfo, (List)localObject, paramqqo, l2, i, j, bool), 16, null, true);
      return;
      i = 0;
      break;
      j = 0;
      break label63;
      bool = false;
      break label83;
    }
  }
  
  public void a(qri paramqri)
  {
    this.jdField_a_of_type_Qri = paramqri;
  }
  
  public void b()
  {
    int j = 0;
    qqo localqqo;
    int i;
    if (this.jdField_b_of_type_Qmi != null)
    {
      localqqo = this.jdField_b_of_type_Qmi.jdField_a_of_type_Qqo;
      i = j;
      if (localqqo != null)
      {
        i = j;
        if (localqqo.jdField_a_of_type_Qub != null) {
          i = localqqo.jdField_a_of_type_Qub.e();
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
        localqqo = null;
        break;
        if (a(localqqo)) {
          localqqo.jdField_a_of_type_Qbw.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqqo, false);
        return;
        if (a(localqqo)) {
          localqqo.jdField_a_of_type_Qbw.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localqqo);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqqo, true);
        return;
        String str1;
        if ((localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          str1 = localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
        for (;;)
        {
          try
          {
            String str3 = localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
            if (TextUtils.isEmpty(localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
              continue;
            }
            str2 = localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
            noo.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, npx.a(str1, localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localqqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000, new JSONObject().put("video_type", 0)), false);
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
        if (a(localqqo)) {
          localqqo.jdField_a_of_type_Qbw.jdField_a_of_type_Boolean = false;
        }
      } while (localqqo.a("continue_pause", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
    }
    if (a(localqqo)) {
      localqqo.jdField_a_of_type_Qbw.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
  }
  
  public void b(qqo paramqqo)
  {
    if (this.jdField_a_of_type_Qks != null) {
      this.jdField_a_of_type_Qks.a(this.jdField_b_of_type_Qmi.jdField_c_of_type_Int, paramqqo, this.jdField_b_of_type_JavaUtilArrayList);
    }
  }
  
  public void c()
  {
    e();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(qqo paramqqo) {}
  
  public void d(qqo paramqqo) {}
  
  public void e(qqo paramqqo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrm
 * JD-Core Version:    0.7.0.1
 */