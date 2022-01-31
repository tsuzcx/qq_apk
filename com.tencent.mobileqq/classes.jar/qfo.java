import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.Window;
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

public class qfo
  implements qes, qfs
{
  private int jdField_a_of_type_Int = 5;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<qmt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private pys jdField_a_of_type_Pys;
  private qag jdField_a_of_type_Qag;
  private qeq jdField_a_of_type_Qeq;
  private qfk jdField_a_of_type_Qfk;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  private qag jdField_b_of_type_Qag;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public qfo(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, ArrayList<VideoInfo> paramArrayList)
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
    this.jdField_a_of_type_Int = obz.e();
    this.jdField_b_of_type_Int = new.a();
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    if ((i == 4) || (i == 5) || (i == 2) || (i == 1)) {
      this.jdField_a_of_type_Int = 5;
    }
    this.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(128);
    d();
  }
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<qmt> paramList, pqb parampqb, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
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
      qmt localqmt;
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
          break label1043;
        }
        j = 1;
        this.jdField_b_of_type_Boolean = false;
        int i2 = paramIntent.getIntExtra("key_source", -1);
        i3 = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
        int i4 = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
        int i5 = paramIntent.getIntExtra("VIDEO_CHAT_TYPE", 0);
        int i6 = paramIntent.getIntExtra("VIDEO_KANDIAN_TYPE", 0);
        String str5 = paramIntent.getStringExtra("VIDEO_CHAT_UIN");
        if ((TextUtils.isEmpty(paramVideoInfo.J)) || (!qcn.c())) {
          break label1049;
        }
        k = 1;
        int i7 = paramList.size();
        m = 0;
        if (m >= i7) {
          return;
        }
        localqmt = (qmt)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendPresenter", 2, "播放VV上报 totalPlayTime = " + localqmt.a + ", currentPlayTime = " + localqmt.b);
        }
        if ((localqmt.b != 0L) || (localqmt.a != 0L))
        {
          if (m != 0) {
            break label1055;
          }
          i = 0;
          localObject = new qmv(str2, str3, str4, str1).d(localqmt.a).a(localqmt.b).y(i).z(i7 - 1).w(i2).B(parampqb.l).A(parampqb.k).D(parampqb.j).C(parampqb.i).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_b_of_type_JavaLangString).c(paramLong).l(paramInt1).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean));
          if (paramVideoInfo.N == null) {
            break label1074;
          }
          paramIntent = paramVideoInfo.N;
          paramIntent = ((qmv)localObject).a(paramIntent).d(paramVideoInfo.jdField_c_of_type_Boolean).p(this.jdField_b_of_type_Int).q(this.jdField_a_of_type_Int).e(paramVideoInfo.f).c(paramVideoInfo.r).E(j).K(paramVideoInfo.o).F(i4).g(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).v(i3).L(i1).i(false);
          if ((paramBoolean) || (paramInt2 <= 0)) {
            break label1081;
          }
          i = 1;
          paramIntent = paramIntent.n(i).j(paramVideoInfo.jdField_j_of_type_Boolean).m(paramVideoInfo.I).S(k);
          if (!paramVideoInfo.e()) {
            break label1087;
          }
          i = 2;
          label527:
          paramIntent = paramIntent.Y(i);
          if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
            break label1093;
          }
          bool = true;
          label544:
          localObject = paramIntent.k(bool);
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1099;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label580:
          paramIntent = ((qmv)localObject).q(paramIntent);
          if (!paramVideoInfo.e()) {
            break label1106;
          }
          i = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
          label603:
          paramIntent = paramIntent.t(i);
          if ((!paramVideoInfo.e()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.f))) {
            break label1112;
          }
          i = 1;
          label646:
          localObject = paramIntent.Z(i);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
            break label1118;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
          label682:
          localObject = ((qmv)localObject).o(paramIntent);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
            break label1125;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
          label718:
          paramIntent = ((qmv)localObject).p(paramIntent).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.f).M(odw.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.d)).N(0);
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
            break label1139;
          }
          if (TextUtils.isEmpty(str1)) {
            break label1132;
          }
        }
      }
      label1043:
      label1049:
      label1055:
      label1074:
      label1081:
      label1087:
      label1093:
      label1099:
      label1106:
      label1112:
      label1118:
      label1125:
      label1132:
      for (paramIntent = str1;; paramIntent = "0")
      {
        ndn.b(null, str3, "0X8009297", "0X8009297", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        ndn.a("0X8009297", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        paramIntent = new pqh();
        paramIntent.d = ((int)localqmt.b);
        paramIntent.e = ((int)paramLong);
        paramIntent.jdField_b_of_type_Boolean = true;
        paramIntent.jdField_a_of_type_Boolean = pyu.a().c();
        paramIntent.jdField_b_of_type_Int = n;
        paramIntent.f = i3;
        new.b(paramVideoInfo, i1, 12, (int)localqmt.a, paramIntent, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
        m += 1;
        break label165;
        str2 = null;
        break;
        j = -1;
        break label77;
        k = 0;
        break label154;
        if (this.jdField_c_of_type_Boolean)
        {
          i = 2;
          break label261;
        }
        i = 1;
        break label261;
        paramIntent = "";
        break label395;
        i = 0;
        break label491;
        i = 1;
        break label527;
        bool = false;
        break label544;
        paramIntent = "";
        break label580;
        i = 0;
        break label603;
        i = 0;
        break label646;
        paramIntent = "";
        break label682;
        paramIntent = "";
        break label718;
      }
      label1139:
      if (!TextUtils.isEmpty(str1)) {}
      for (paramIntent = str1;; paramIntent = "0")
      {
        ndn.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        ndn.a("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        break;
      }
    }
  }
  
  private static boolean a(qeq paramqeq)
  {
    return (paramqeq != null) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqeq.jdField_a_of_type_Pqa != null) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    qmv localqmv = new qmv(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    localqmv.N(0).X(i).n(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    ndn.b(null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g, localqmv.a().a(), false);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      qmv localqmv = new qmv(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localqmv.P(this.jdField_c_of_type_Int);
      ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localqmv.a().a(), false);
    }
  }
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_Qag = this.jdField_b_of_type_Qag;
    if ((paramViewHolder instanceof qag))
    {
      this.jdField_b_of_type_Qag = ((qag)paramViewHolder);
      this.jdField_a_of_type_Qeq = this.jdField_b_of_type_Qag.jdField_a_of_type_Qeq;
    }
    for (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null)
    {
      if ((this.jdField_a_of_type_Qag != null) && (this.jdField_b_of_type_Qag != null) && (this.jdField_a_of_type_Qag.jdField_c_of_type_Int > this.jdField_b_of_type_Qag.jdField_c_of_type_Int)) {
        this.jdField_c_of_type_Int += 1;
      }
      return;
      this.jdField_b_of_type_Qag = null;
      this.jdField_a_of_type_Qeq = null;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(pys parampys)
  {
    this.jdField_a_of_type_Pys = parampys;
  }
  
  public void a(qeq paramqeq)
  {
    if ((paramqeq != null) && (paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!this.jdField_a_of_type_Boolean)) {
      new.b(paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 409409, 1, -1, null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
  }
  
  public void a(qeq paramqeq, int paramInt)
  {
    if ((paramqeq != null) && (paramqeq.jdField_a_of_type_Qhw != null))
    {
      qmt localqmt = new qmt();
      localqmt.a = paramqeq.jdField_a_of_type_Qhw.a(true);
      localqmt.b = paramqeq.jdField_a_of_type_Qhw.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localqmt.a + ", detailInfo.currentPlayTime = " + localqmt.b);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localqmt);
      if ((a(paramqeq)) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
        npu.a(paramqeq, this.jdField_a_of_type_AndroidAppActivity, paramqeq.jdField_a_of_type_Qhw);
      }
      if (this.jdField_a_of_type_Pys != null) {
        this.jdField_a_of_type_Pys.b(this.jdField_b_of_type_Qag.jdField_c_of_type_Int, paramqeq, this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public void a(qeq paramqeq, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qeq paramqeq, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    int i;
    int j;
    label63:
    boolean bool;
    label83:
    Object localObject;
    if (this.jdField_a_of_type_Qag != null)
    {
      i = this.jdField_a_of_type_Qag.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Qag == null) {
        break label190;
      }
      j = this.jdField_a_of_type_Qag.jdField_b_of_type_Int;
      if ((this.jdField_a_of_type_Qag == null) || (!this.jdField_a_of_type_Qag.jdField_b_of_type_Boolean)) {
        break label196;
      }
      bool = true;
      localObject = new qmt();
      if (!paramBoolean) {
        break label202;
      }
    }
    label190:
    label196:
    label202:
    for (long l1 = paramqeq.jdField_a_of_type_Qhw.b();; l1 = paramqeq.jdField_a_of_type_Qhw.a())
    {
      ((qmt)localObject).b = l1;
      ((qmt)localObject).a = paramqeq.jdField_a_of_type_Qhw.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ThreadManager.excute(new VideoFeedsRecommendPresenter.1(this, localIntent, localVideoInfo, (List)localObject, paramqeq, l2, i, j, bool), 16, null, true);
      return;
      i = 0;
      break;
      j = 0;
      break label63;
      bool = false;
      break label83;
    }
  }
  
  public void a(qfk paramqfk)
  {
    this.jdField_a_of_type_Qfk = paramqfk;
  }
  
  public void b()
  {
    int j = 0;
    qeq localqeq;
    int i;
    if (this.jdField_b_of_type_Qag != null)
    {
      localqeq = this.jdField_b_of_type_Qag.jdField_a_of_type_Qeq;
      i = j;
      if (localqeq != null)
      {
        i = j;
        if (localqeq.jdField_a_of_type_Qhw != null) {
          i = localqeq.jdField_a_of_type_Qhw.e();
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
        localqeq = null;
        break;
        if (a(localqeq)) {
          localqeq.jdField_a_of_type_Pqa.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqeq, false);
        return;
        if (a(localqeq)) {
          localqeq.jdField_a_of_type_Pqa.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localqeq);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqeq, true);
        return;
        String str1;
        if ((localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          str1 = localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
        for (;;)
        {
          try
          {
            String str3 = localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
            if (TextUtils.isEmpty(localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
              continue;
            }
            str2 = localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
            ndn.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, new.a(str1, localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localqeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000, new JSONObject().put("video_type", 0)), false);
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
        if (a(localqeq)) {
          localqeq.jdField_a_of_type_Pqa.jdField_a_of_type_Boolean = false;
        }
      } while (localqeq.a("continue_pause", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
    }
    if (a(localqeq)) {
      localqeq.jdField_a_of_type_Pqa.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
  }
  
  public void b(qeq paramqeq)
  {
    if (this.jdField_a_of_type_Pys != null) {
      this.jdField_a_of_type_Pys.a(this.jdField_b_of_type_Qag.jdField_c_of_type_Int, paramqeq, this.jdField_b_of_type_JavaUtilArrayList);
    }
  }
  
  public void c()
  {
    e();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(qeq paramqeq) {}
  
  public void d(qeq paramqeq) {}
  
  public void e(qeq paramqeq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfo
 * JD-Core Version:    0.7.0.1
 */