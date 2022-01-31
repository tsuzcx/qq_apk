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

public class qrj
  implements qqn, qrn
{
  private int jdField_a_of_type_Int = 5;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<qyz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private qkp jdField_a_of_type_Qkp;
  private qmf jdField_a_of_type_Qmf;
  private qql jdField_a_of_type_Qql;
  private qrf jdField_a_of_type_Qrf;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList;
  private qmf jdField_b_of_type_Qmf;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private final boolean d;
  
  public qrj(Activity paramActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager paramVideoFeedsPlayManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, ArrayList<VideoInfo> paramArrayList)
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
    this.jdField_a_of_type_Int = onh.e();
    this.jdField_b_of_type_Int = npu.a();
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
  
  private void a(Intent paramIntent, VideoInfo paramVideoInfo, List<qyz> paramList, qbu paramqbu, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
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
      qyz localqyz;
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
        if ((TextUtils.isEmpty(paramVideoInfo.J)) || (!qoi.d())) {
          break label1066;
        }
        k = 1;
        int i7 = paramList.size();
        m = 0;
        if (m >= i7) {
          return;
        }
        localqyz = (qyz)paramList.get(m);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsRecommendPresenter", 2, "播放VV上报 totalPlayTime = " + localqyz.a + ", currentPlayTime = " + localqyz.b);
        }
        if ((localqyz.b != 0L) || (localqyz.a != 0L))
        {
          if (m != 0) {
            break label1072;
          }
          i = 0;
          localObject = new qzb(str2, str3, str4, str1).d(localqyz.a).a(localqyz.b).z(i).A(i7 - 1).x(i2).C(paramqbu.l).B(paramqbu.k).E(paramqbu.j).D(paramqbu.i).b(this.jdField_a_of_type_JavaLangString).c(this.jdField_b_of_type_JavaLangString).c(paramLong).m(paramInt1).a(409409).a(Boolean.valueOf(paramVideoInfo.jdField_b_of_type_Boolean));
          if (paramVideoInfo.N == null) {
            break label1091;
          }
          paramIntent = paramVideoInfo.N;
          paramIntent = ((qzb)localObject).a(paramIntent).d(paramVideoInfo.jdField_c_of_type_Boolean).q(this.jdField_b_of_type_Int).r(this.jdField_a_of_type_Int).e(paramVideoInfo.f).d(paramVideoInfo.r).F(j).L(paramVideoInfo.o).G(i4).g(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g).w(i3).M(i1).i(false);
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
          paramIntent = ((qzb)localObject).q(paramIntent);
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
          localObject = ((qzb)localObject).o(paramIntent);
          if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
            break label1142;
          }
          paramIntent = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
          label718:
          paramIntent = ((qzb)localObject).p(paramIntent).h(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.f).N(ope.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.d)).O(0);
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
        nol.b(null, str3, "0X8009297", "0X8009297", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        nol.a("0X8009297", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        paramIntent = new qca();
        paramIntent.d = ((int)localqyz.b);
        paramIntent.e = ((int)paramLong);
        paramIntent.jdField_b_of_type_Boolean = true;
        paramIntent.jdField_a_of_type_Boolean = qkr.a().c();
        paramIntent.jdField_b_of_type_Int = n;
        paramIntent.f = i3;
        npu.b(paramVideoInfo, i1, 12, (int)localqyz.a, paramIntent, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
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
        nol.b(null, str3, "0X8007409", "0X8007409", 0, 0, String.valueOf(n), String.valueOf(i1), paramIntent, (String)localObject, false);
        nol.a("0X8007409", str3, String.valueOf(n), String.valueOf(i1), "", (String)localObject);
        break;
      }
    }
  }
  
  private static boolean a(qql paramqql)
  {
    return (paramqql != null) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramqql.jdField_a_of_type_Qbt != null) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    int j = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    qzb localqzb = new qzb(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    localqzb.O(0).Y(i).n(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    nol.b(null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X800A98F", "0X800A98F", 0, 0, String.valueOf(j), "", this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g, localqzb.a().a(), false);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      qzb localqzb = new qzb(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localqzb.Q(this.jdField_c_of_type_Int);
      nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, "0X8009B79", "0X8009B79", 0, 0, "", "", "", localqzb.a().a(), false);
    }
  }
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_Qmf = this.jdField_b_of_type_Qmf;
    if ((paramViewHolder instanceof qmf))
    {
      this.jdField_b_of_type_Qmf = ((qmf)paramViewHolder);
      this.jdField_a_of_type_Qql = this.jdField_b_of_type_Qmf.jdField_a_of_type_Qql;
    }
    for (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = this.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;; this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null)
    {
      if ((this.jdField_a_of_type_Qmf != null) && (this.jdField_b_of_type_Qmf != null) && (this.jdField_a_of_type_Qmf.jdField_c_of_type_Int > this.jdField_b_of_type_Qmf.jdField_c_of_type_Int)) {
        this.jdField_c_of_type_Int += 1;
      }
      return;
      this.jdField_b_of_type_Qmf = null;
      this.jdField_a_of_type_Qql = null;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(qkp paramqkp)
  {
    this.jdField_a_of_type_Qkp = paramqkp;
  }
  
  public void a(qql paramqql)
  {
    if ((paramqql != null) && (paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!this.jdField_a_of_type_Boolean)) {
      npu.b(paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, 409409, 1, -1, null, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
  }
  
  public void a(qql paramqql, int paramInt)
  {
    if ((paramqql != null) && (paramqql.jdField_a_of_type_Qty != null))
    {
      qyz localqyz = new qyz();
      localqyz.a = paramqql.jdField_a_of_type_Qty.a(true);
      localqyz.b = paramqql.jdField_a_of_type_Qty.b();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsRecommendPresenter", 2, "mPlayInfoListForReport add detailInfo.totalPlayTime = " + localqyz.a + ", detailInfo.currentPlayTime = " + localqyz.b);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localqyz);
      if ((a(paramqql)) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppActivity != null)) {
        obc.a(paramqql, this.jdField_a_of_type_AndroidAppActivity, paramqql.jdField_a_of_type_Qty);
      }
      if (this.jdField_a_of_type_Qkp != null) {
        this.jdField_a_of_type_Qkp.b(this.jdField_b_of_type_Qmf.jdField_c_of_type_Int, paramqql, this.jdField_b_of_type_JavaUtilArrayList);
      }
    }
  }
  
  public void a(qql paramqql, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qql paramqql, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    VideoInfo localVideoInfo = paramqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    int i;
    int j;
    label63:
    boolean bool;
    label83:
    Object localObject;
    if (this.jdField_a_of_type_Qmf != null)
    {
      i = this.jdField_a_of_type_Qmf.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Qmf == null) {
        break label190;
      }
      j = this.jdField_a_of_type_Qmf.jdField_b_of_type_Int;
      if ((this.jdField_a_of_type_Qmf == null) || (!this.jdField_a_of_type_Qmf.jdField_b_of_type_Boolean)) {
        break label196;
      }
      bool = true;
      localObject = new qyz();
      if (!paramBoolean) {
        break label202;
      }
    }
    label190:
    label196:
    label202:
    for (long l1 = paramqql.jdField_a_of_type_Qty.b();; l1 = paramqql.jdField_a_of_type_Qty.a())
    {
      ((qyz)localObject).b = l1;
      ((qyz)localObject).a = paramqql.jdField_a_of_type_Qty.a(paramBoolean);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ThreadManager.excute(new VideoFeedsRecommendPresenter.1(this, localIntent, localVideoInfo, (List)localObject, paramqql, l2, i, j, bool), 16, null, true);
      return;
      i = 0;
      break;
      j = 0;
      break label63;
      bool = false;
      break label83;
    }
  }
  
  public void a(qrf paramqrf)
  {
    this.jdField_a_of_type_Qrf = paramqrf;
  }
  
  public void b()
  {
    int j = 0;
    qql localqql;
    int i;
    if (this.jdField_b_of_type_Qmf != null)
    {
      localqql = this.jdField_b_of_type_Qmf.jdField_a_of_type_Qql;
      i = j;
      if (localqql != null)
      {
        i = j;
        if (localqql.jdField_a_of_type_Qty != null) {
          i = localqql.jdField_a_of_type_Qty.e();
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
        localqql = null;
        break;
        if (a(localqql)) {
          localqql.jdField_a_of_type_Qbt.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqql, false);
        return;
        if (a(localqql)) {
          localqql.jdField_a_of_type_Qbt.jdField_a_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(localqql);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localqql, true);
        return;
        String str1;
        if ((localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0) && (localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          str1 = localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        }
        for (;;)
        {
          try
          {
            String str3 = localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString;
            if (TextUtils.isEmpty(localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
              continue;
            }
            str2 = localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
            nol.a(null, str3, "0X800740D", "0X800740D", 0, 0, "", "", str2, npu.a(str1, localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_j_of_type_JavaLangString, localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localqql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a() * 1000, new JSONObject().put("video_type", 0)), false);
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
        if (a(localqql)) {
          localqql.jdField_a_of_type_Qbt.jdField_a_of_type_Boolean = false;
        }
      } while (localqql.a("continue_pause", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      return;
    }
    if (a(localqql)) {
      localqql.jdField_a_of_type_Qbt.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
  }
  
  public void b(qql paramqql)
  {
    if (this.jdField_a_of_type_Qkp != null) {
      this.jdField_a_of_type_Qkp.a(this.jdField_b_of_type_Qmf.jdField_c_of_type_Int, paramqql, this.jdField_b_of_type_JavaUtilArrayList);
    }
  }
  
  public void c()
  {
    e();
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(qql paramqql) {}
  
  public void d(qql paramqql) {}
  
  public void e(qql paramqql) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrj
 * JD-Core Version:    0.7.0.1
 */