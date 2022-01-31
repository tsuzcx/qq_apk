import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.12;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.4;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class raw
  extends RecyclerView.Adapter<rbl>
  implements View.OnClickListener, View.OnLongClickListener, rde, rgp, rmn, rmo
{
  private int jdField_a_of_type_Int;
  public long a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new raz(this, Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = new RecyclerView.RecycledViewPool();
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private bhym jdField_a_of_type_Bhym;
  private bhzx jdField_a_of_type_Bhzx;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  public GdtHandler.Params a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ray(this);
  private String jdField_a_of_type_JavaLangString;
  public HashMap<String, Integer> a;
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, Bitmap> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private odf jdField_a_of_type_Odf;
  private qym jdField_a_of_type_Qym;
  private qzw jdField_a_of_type_Qzw;
  private qzy jdField_a_of_type_Qzy;
  private rac jdField_a_of_type_Rac;
  private rbk jdField_a_of_type_Rbk;
  private rbn jdField_a_of_type_Rbn;
  rbq jdField_a_of_type_Rbq;
  private rbt jdField_a_of_type_Rbt;
  private rby jdField_a_of_type_Rby;
  private rcz jdField_a_of_type_Rcz;
  private res jdField_a_of_type_Res;
  private rez jdField_a_of_type_Rez;
  private rgn jdField_a_of_type_Rgn;
  private rgr jdField_a_of_type_Rgr;
  public rgv a;
  private ric jdField_a_of_type_Ric;
  private rig jdField_a_of_type_Rig;
  private riq jdField_a_of_type_Riq;
  private ron jdField_a_of_type_Ron;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 5;
  private long jdField_c_of_type_Long;
  private Set<String> jdField_c_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = true;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private final boolean s;
  private boolean t;
  private boolean u;
  private boolean v = true;
  
  public raw(Context paramContext, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, LinearLayoutManager paramLinearLayoutManager, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, int paramInt, rgr paramrgr)
  {
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Rgv = new rba(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Rgv);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = paramLinearLayoutManager;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bdhj.a(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165307));
    this.jdField_a_of_type_Qzy = qzy.a();
    this.jdField_a_of_type_Rac = new rac(paramActivity);
    this.jdField_a_of_type_Res = new res(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Bhym = new bhym(this.jdField_a_of_type_AndroidAppActivity);
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1930498322);
    this.jdField_a_of_type_Rgr = paramrgr;
    setHasStableIds(true);
    registerAdapterDataObserver(new rbj(this, null));
    this.r = azmk.b();
    this.jdField_a_of_type_Odf = new odf(paramActivity, this);
    if (Aladdin.getConfig(260).getIntegerFromString("interact_button_style", 0) == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.s = paramBoolean;
      return;
    }
  }
  
  private Drawable a(int paramInt)
  {
    Bitmap localBitmap;
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), paramInt);
      if (localBitmap == null) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(paramInt);
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localBitmap);
    }
    for (;;)
    {
      return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return alud.a(2131716640);
    }
    if (paramInt == 2) {
      return alud.a(2131716637);
    }
    return null;
  }
  
  private String a(VideoInfo paramVideoInfo, int paramInt)
  {
    return oee.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, paramInt);
  }
  
  @NonNull
  private String a(VideoInfo paramVideoInfo, Resources paramResources)
  {
    return oee.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, paramResources);
  }
  
  private void a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, int paramInt)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((localViewHolder instanceof rbt))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((rbt)localViewHolder).jdField_b_of_type_Int);
        if ((localVideoInfo.e()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int == paramInt)) {
          ((rbt)localViewHolder).jdField_a_of_type_Qyv.b(localVideoInfo);
        }
      }
      i1 += 1;
    }
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    }
    if (this.jdField_a_of_type_Odf != null) {
      this.jdField_a_of_type_Odf.a(paramView, paramInt, paramVideoInfo);
    }
  }
  
  private void a(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = noy.a(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      szl.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo = noy.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    if (paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.P).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
      return;
    }
    noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.N).a(localAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    szl.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
    paramAdvertisementInfo = noy.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
    noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.Y).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(paramInt).a());
  }
  
  private void a(VideoInfo paramVideoInfo, ron paramron)
  {
    boolean bool = true;
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = paramVideoInfo.j;
      if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
      for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
      {
        nrt.b(null, (String)localObject, "0X8009298", "0X8009298", 0, 0, "0", "", paramVideoInfo, paramron.a().a(), false);
        return;
      }
    }
    int i1;
    if ((!TextUtils.isEmpty(paramVideoInfo.s)) && (rdm.d()))
    {
      i1 = 1;
      localObject = paramron.S(i1);
      if (!paramVideoInfo.e()) {
        break label375;
      }
      i1 = 2;
      label102:
      localObject = ((ron)localObject).Y(i1);
      if (!paramVideoInfo.e()) {
        break label380;
      }
      i1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
      label125:
      localObject = ((ron)localObject).t(i1);
      if ((!paramVideoInfo.e()) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.h)) || (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.g))) {
        break label385;
      }
      i1 = 1;
      label168:
      ron localron = ((ron)localObject).Z(i1);
      if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
        break label390;
      }
      localObject = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
      label205:
      localron = localron.o((String)localObject);
      if ((!paramVideoInfo.e()) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d == null)) {
        break label398;
      }
      localObject = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.d.e;
      label243:
      localObject = localron.p((String)localObject);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) {
        break label406;
      }
      label259:
      localron = ((ron)localObject).l(bool);
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null)) {
        break label412;
      }
      localObject = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;
      label297:
      localron.q((String)localObject).b(this.s).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo);
      localObject = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label420;
      }
    }
    label385:
    label390:
    label398:
    label406:
    label412:
    label420:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      nrt.b(null, (String)localObject, "0X8007801", "0X8007801", 0, 0, "0", "", paramVideoInfo, paramron.a().a(), false);
      return;
      i1 = 0;
      break;
      label375:
      i1 = 1;
      break label102;
      label380:
      i1 = 0;
      break label125;
      i1 = 0;
      break label168;
      localObject = "";
      break label205;
      localObject = "";
      break label243;
      bool = false;
      break label259;
      localObject = "";
      break label297;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
      if ((paramVideoInfo.jdField_a_of_type_Int == 6) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
        localIntent.putExtra("feedsType", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      }
      localIntent.putExtra("ARG_VIDEO_ARTICLE_ID", paramVideoInfo.g);
      localIntent.putExtra("biu_src", 2);
      localIntent.putExtra("arg_from_type", 8);
      localIntent.putExtra("arg_article_info", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      localIntent.putExtra("fast_biu_type", paramBoolean);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 102);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "innerOpenReadInJoyBiuActivity error exception = " + paramVideoInfo.getMessage());
    }
  }
  
  private void a(VideoInfo paramVideoInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramVideoInfo == null) {
      return;
    }
    a(paramVideoInfo, paramBoolean2);
    Object localObject1;
    if ((paramVideoInfo.jdField_a_of_type_Int == 0) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
    {
      localObject1 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
      localObject1 = new ron((String)localObject1, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramVideoInfo.a() * 1000);
      ((ron)localObject1).h(paramBoolean1).i(paramBoolean2).b(this.s);
      if (!this.jdField_a_of_type_Boolean)
      {
        ((ron)localObject1).e(paramVideoInfo.f).c(paramVideoInfo.jdField_o_of_type_Int).a(-1).a(paramVideoInfo.y).N(0);
        localObject2 = new qlw();
        ((qlw)localObject2).jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a());
        ((qlw)localObject2).jdField_e_of_type_Int = (paramVideoInfo.a() * 1000);
        ((qlw)localObject2).jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        ntd.b(paramVideoInfo, this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1), 25, -1, (qlw)localObject2, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      localObject1 = ((ron)localObject1).a().a();
      if (!this.jdField_a_of_type_Boolean) {
        break label290;
      }
      localObject2 = paramVideoInfo.j;
      if (TextUtils.isEmpty(paramVideoInfo.g)) {
        break label283;
      }
    }
    label283:
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      nrt.a(null, (String)localObject2, "0X8009299", "0X8009299", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
      localObject1 = null;
      break;
    }
    label290:
    Object localObject2 = paramVideoInfo.j;
    if (!TextUtils.isEmpty(paramVideoInfo.g)) {}
    for (paramVideoInfo = paramVideoInfo.g;; paramVideoInfo = "0")
    {
      nrt.a(null, (String)localObject2, "0X8007B89", "0X8007B89", 0, 0, "0", "0", paramVideoInfo, (String)localObject1, false);
      return;
    }
  }
  
  private void a(VideoFeedsUGView paramVideoFeedsUGView, boolean paramBoolean)
  {
    if (paramVideoFeedsUGView != null) {
      paramVideoFeedsUGView.setActive(paramBoolean);
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, VideoInfo paramVideoInfo)
  {
    if ((paramKandianUrlImageView == null) || (paramVideoInfo == null)) {
      return;
    }
    if ((!rdm.d()) || (TextUtils.isEmpty(paramVideoInfo.s)))
    {
      paramKandianUrlImageView.setVisibility(8);
      return;
    }
    Object localObject;
    if (paramVideoInfo.s.endsWith("zip"))
    {
      localObject = out.a(paramVideoInfo.s);
      ((out)localObject).setRepeatCount(0);
      paramKandianUrlImageView.setImageDrawable((Drawable)localObject);
      if ((paramKandianUrlImageView.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) && (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo)) {
        ((out)localObject).playAnimation();
      }
    }
    for (;;)
    {
      paramKandianUrlImageView.setVisibility(0);
      return;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      paramKandianUrlImageView.setImageDrawable(URLDrawable.getDrawable(paramVideoInfo.s, (URLDrawable.URLDrawableOptions)localObject));
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, VideoInfo paramVideoInfo, Boolean paramBoolean)
  {
    int[] arrayOfInt;
    if (paramKandianUrlImageView.getVisibility() == 0)
    {
      arrayOfInt = paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity, paramBoolean.booleanValue());
      if ((arrayOfInt[0] >= 0) && (arrayOfInt[1] >= 0)) {}
    }
    else
    {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramKandianUrlImageView.getLayoutParams();
    localLayoutParams.topMargin = arrayOfInt[0];
    localLayoutParams.rightMargin = arrayOfInt[1];
    if ((paramBoolean.booleanValue()) || (paramVideoInfo.b(this.jdField_a_of_type_AndroidAppActivity))) {
      localLayoutParams.width = aepi.a(91.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    for (localLayoutParams.height = aepi.a(28.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());; localLayoutParams.height = aepi.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()))
    {
      paramKandianUrlImageView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = aepi.a(78.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() uin=" + paramString);
    }
    if ((paramString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      return;
      rdm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramBoolean);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      paramBoolean = false;
      while (localIterator.hasNext())
      {
        Object localObject = (VideoInfo)localIterator.next();
        boolean bool = paramBoolean | a((VideoInfo)localObject, paramString);
        paramBoolean = bool;
        if (((VideoInfo)localObject).d != null)
        {
          localObject = ((VideoInfo)localObject).d.iterator();
          for (;;)
          {
            paramBoolean = bool;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            bool = a((VideoInfo)((Iterator)localObject).next(), paramString) | bool;
          }
        }
      }
      if (paramBoolean) {
        a(paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount() isDataChanged=" + paramBoolean);
  }
  
  private void a(rbi paramrbi)
  {
    int i1;
    Object localObject;
    if ((paramrbi != null) && (paramrbi.jdField_a_of_type_Rfs != null) && (paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = oed.c(noy.a(paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label84;
      }
      paramrbi = paramrbi.jdField_d_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramrbi.getLayoutParams();
      if (localObject != null)
      {
        ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
        paramrbi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label84:
    do
    {
      do
      {
        return;
      } while (i1 != 2);
      localObject = paramrbi.jdField_e_of_type_AndroidViewView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.weight = 0.0F;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      paramrbi = paramrbi.jdField_f_of_type_AndroidViewView;
      localObject = (LinearLayout.LayoutParams)paramrbi.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramrbi.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void a(rbi paramrbi, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    int i1 = 8;
    int i2 = 0;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if ((!AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) || (!oed.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))) {
        break label318;
      }
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label130;
      }
      szl.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == noy.Y)
      {
        paramrbi = noy.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.Y).a(paramrbi).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(noy.aL).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, noy.at);
    return;
    label130:
    oee.a(paramAdvertisementInfo, 0, null);
    int i3 = paramArrayOfView1.length;
    i1 = 0;
    while (i1 < i3)
    {
      paramArrayOfView1[i1].setVisibility(0);
      i1 += 1;
    }
    paramrbi.jdField_a_of_type_Boolean = true;
    i3 = paramArrayOfView2.length;
    i1 = i2;
    while (i1 < i3)
    {
      paramArrayOfView2[i1].setVisibility(8);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.f();
    if (paramInt == noy.Y)
    {
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.ak).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(noy.aL).a());
      return;
    }
    noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.ak).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a());
    return;
    label318:
    if (paramInt == noy.Y)
    {
      paramInt = 38;
      paramrbi = noy.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.Y).a(paramrbi).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(noy.aL).a());
    }
    for (;;)
    {
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramrbi = new obg();
      paramrbi.jdField_c_of_type_Boolean = true;
      szl.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, paramrbi);
      return;
      paramInt = i1;
      if (this.i) {
        paramInt = 13;
      }
      a(paramVideoInfo, noy.at);
    }
  }
  
  private void a(rbi paramrbi, boolean paramBoolean1, boolean paramBoolean2, View paramView1, View paramView2, TextView paramTextView1, Drawable paramDrawable1, Drawable paramDrawable2, View paramView3, TextView paramTextView2)
  {
    if (paramView1 != null) {
      paramView1.setVisibility(8);
    }
    if (paramBoolean2)
    {
      paramView2.setVisibility(0);
      paramView2.getParent().requestDisallowInterceptTouchEvent(true);
      paramView2.setOnClickListener(this);
      paramView2.setTag(paramrbi);
      Object localObject = null;
      paramView1 = localObject;
      if (paramTextView1 != null)
      {
        paramView1 = localObject;
        if (paramrbi.jdField_a_of_type_Rfs != null)
        {
          paramView1 = a(paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_AndroidContentContext.getResources());
          paramTextView1.setText(paramView1);
        }
      }
      if (!paramBoolean1) {
        break label123;
      }
      paramView2.setBackgroundDrawable(paramDrawable1);
    }
    for (this.i = true;; this.i = false)
    {
      a(paramBoolean1, paramView3, paramTextView2, paramView1);
      return;
      label123:
      if ((oed.a()) && (paramDrawable2 != null)) {
        paramView2.setBackgroundDrawable(paramDrawable2);
      }
    }
  }
  
  private void a(rbl paramrbl, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    int i1 = 0;
    if ((paramVideoInfo.jdField_c_of_type_Boolean) && (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo)) && (oed.d(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)))
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a(paramVideoInfo)) {
        break label118;
      }
      szl.b(this.jdField_a_of_type_AndroidAppActivity, paramAdvertisementInfo, null, 3, true, null);
      if (paramInt == noy.Y) {
        noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.jdField_a_of_type_Int).b(noy.Y).a(paramAdvertisementInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).d(noy.aL).a());
      }
    }
    else
    {
      return;
    }
    a(paramVideoInfo, noy.at);
    return;
    label118:
    paramView.setVisibility(0);
    ((rbi)paramrbl).jdField_a_of_type_Boolean = true;
    paramInt = i1;
    while (paramInt < paramVarArgs.length)
    {
      paramVarArgs[paramInt].setVisibility(8);
      paramInt += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.f();
  }
  
  private void a(rbn paramrbn)
  {
    if ((this.jdField_a_of_type_Rbn != null) && (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn != null))
    {
      int i1 = this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.e();
      if ((i1 != 0) && (i1 != 1) && (i1 != 2) && (this.jdField_a_of_type_Rbn.jdField_c_of_type_Int == paramrbn.jdField_c_of_type_Int - 1) && (bkbq.u(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (rmd.a().a(this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(paramrbn.jdField_a_of_type_Rfs);
      }
    }
  }
  
  private void a(rbn paramrbn, VideoInfo paramVideoInfo)
  {
    rfs localrfs2 = paramrbn.jdField_a_of_type_Rfs;
    rfs localrfs1 = localrfs2;
    if (localrfs2 == null)
    {
      localrfs1 = new rfs();
      localrfs1.jdField_a_of_type_Qyz = paramrbn.jdField_a_of_type_Riw;
      localrfs1.jdField_a_of_type_AndroidOsBundle.putInt("jump_from_scene", this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 0));
    }
    localrfs1.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    localrfs1.jdField_a_of_type_Int = paramVideoInfo.c(this.jdField_a_of_type_AndroidAppActivity);
    localrfs1.jdField_a_of_type_AndroidViewViewGroup = paramrbn.jdField_b_of_type_AndroidViewViewGroup;
    localrfs1.jdField_b_of_type_Int = paramrbn.jdField_c_of_type_Int;
    localrfs1.jdField_a_of_type_Boolean = false;
    localrfs1.jdField_a_of_type_AndroidOsBundle.putInt("video_feeds_index", paramrbn.jdField_c_of_type_Int);
    localrfs1.jdField_a_of_type_Long = 0L;
    localrfs1.jdField_b_of_type_Boolean = true;
    if (paramVideoInfo.jdField_c_of_type_Boolean)
    {
      if (!paramVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label170;
      }
      localrfs1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", noy.P);
    }
    for (;;)
    {
      paramrbn.jdField_a_of_type_Riw.jdField_a_of_type_Boolean = true;
      paramrbn.jdField_a_of_type_Rfs = localrfs1;
      paramrbn.jdField_a_of_type_Roh.a(this, paramrbn);
      return;
      label170:
      localrfs1.jdField_a_of_type_AndroidOsBundle.putInt("ad_origin", noy.N);
    }
  }
  
  private void a(rbn paramrbn1, rbn paramrbn2)
  {
    VideoInfo localVideoInfo;
    ron localron1;
    if ((paramrbn2 != null) && (paramrbn2.jdField_c_of_type_Int == paramrbn1.jdField_c_of_type_Int))
    {
      localVideoInfo = paramrbn1.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      localron1 = new ron(paramrbn1.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      localron1.h(localVideoInfo.g).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(paramrbn1.jdField_b_of_type_Int).l(paramrbn1.jdField_c_of_type_Int);
      if (paramrbn1.jdField_b_of_type_Int != paramrbn2.jdField_b_of_type_Int + 1) {
        break label124;
      }
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009952", "0X8009952", 0, 0, "", "", "", localron1.a().a(), false);
    }
    label124:
    while (paramrbn1.jdField_b_of_type_Int != paramrbn2.jdField_b_of_type_Int - 1) {
      return;
    }
    ron localron2 = localron1.o(0);
    if (paramrbn2.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {}
    for (paramrbn1 = paramrbn2.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; paramrbn1 = "")
    {
      localron2.h(paramrbn1);
      nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localron1.a().a(), false);
      return;
    }
  }
  
  private void a(rbn paramrbn1, rbn paramrbn2, boolean paramBoolean)
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    VideoInfo localVideoInfo = paramrbn1.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    int i1 = paramrbn1.jdField_b_of_type_Int;
    int i2 = paramrbn1.jdField_c_of_type_Int;
    int i3 = paramrbn1.jdField_a_of_type_Int;
    ThreadManager.post(new VideoFeedsAdapter.4(this, localVideoInfo, localActivity, i2, paramrbn1.jdField_b_of_type_Boolean, i1, paramBoolean, i3, paramrbn1, paramrbn2), 1, null, true);
  }
  
  private void a(rbq paramrbq)
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      paramrbq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramrbq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramrbq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramrbq.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        paramrbq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        paramrbq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramrbq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramrbq.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
        return;
      }
    } while (this.jdField_b_of_type_Int != 3);
    if (paramrbq.jdField_a_of_type_Int == 6)
    {
      paramrbq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramrbq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramrbq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramrbq.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
      return;
    }
    paramrbq.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramrbq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramrbq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(rbt paramrbt, VideoInfo paramVideoInfo)
  {
    if (babd.a()) {}
    do
    {
      do
      {
        return;
        if (paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
        if (paramrbt.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) {
          paramrbt.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.a();
        }
      } while ((paramVideoInfo.jdField_a_of_type_Nsx == null) && (paramVideoInfo.jdField_b_of_type_Nsx == null));
      if ((paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null) && (paramVideoInfo.jdField_a_of_type_Nsx != null) && ((paramVideoInfo.jdField_a_of_type_Nsx.jdField_c_of_type_Int == 1) || (paramVideoInfo.jdField_a_of_type_Nsx.jdField_c_of_type_Int == 2))) {
        paramrbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_a_of_type_Nsx, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_ContentMix");
      }
    } while ((paramrbt.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView == null) || (paramVideoInfo.jdField_b_of_type_Nsx == null) || ((paramVideoInfo.jdField_b_of_type_Nsx.jdField_c_of_type_Int != 1) && (paramVideoInfo.jdField_b_of_type_Nsx.jdField_c_of_type_Int != 2)));
    paramrbt.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.setInfo(paramVideoInfo.jdField_b_of_type_Nsx, paramVideoInfo.jdField_c_of_type_JavaLangString, "VideoPlay_Shooting");
  }
  
  private void a(rbt paramrbt, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_Long != 0L) {
        ThreadManager.excute(new VideoFeedsAdapter.1(this, paramLong), 16, null, true);
      }
      if ((paramrbt.jdField_a_of_type_Rfs != null) && (paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq != null))
      {
        paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.n = paramLong;
        paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_Qlq.r = ors.a(paramInt, paramrbt.jdField_c_of_type_Int, false);
      }
      if ((paramrbt.jdField_a_of_type_Rfs != null) && (paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp != null)) {
        paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_Qlp.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void a(boolean paramBoolean, View paramView, TextView paramTextView, String paramString)
  {
    if ((paramView == null) || (paramTextView == null)) {}
    do
    {
      do
      {
        return;
        if (!oed.a()) {
          break;
        }
        paramView.setVisibility(8);
        paramTextView.setVisibility(0);
      } while (TextUtils.isEmpty(paramString));
      paramTextView.setText(paramString);
      return;
      if (!paramBoolean) {
        break;
      }
      paramView.setVisibility(8);
      paramTextView.setVisibility(0);
    } while (TextUtils.isEmpty(paramString));
    paramTextView.setText(paramString);
    return;
    paramView.setVisibility(0);
    paramTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean, rbi paramrbi)
  {
    if (!a(paramrbi)) {
      return;
    }
    TextView localTextView1 = paramrbi.jdField_d_of_type_AndroidWidgetTextView;
    View localView = paramrbi.jdField_a_of_type_AndroidViewView;
    TextView localTextView2 = paramrbi.jdField_e_of_type_AndroidWidgetTextView;
    if (localView != null) {}
    for (boolean bool = true;; bool = false)
    {
      GradientDrawable localGradientDrawable1 = new GradientDrawable();
      localGradientDrawable1.setColor(Color.parseColor("#FF12B7F6"));
      localGradientDrawable1.setCornerRadius(aepi.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      GradientDrawable localGradientDrawable2 = new GradientDrawable();
      if (oed.a())
      {
        localGradientDrawable1.setColor(Color.parseColor("#FF12B7F6"));
        localGradientDrawable1.setCornerRadius(aepi.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        localGradientDrawable2.setColor(Color.parseColor("#33FFFFFF"));
        localGradientDrawable2.setCornerRadius(aepi.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      }
      a(paramrbi, paramBoolean, bool, localTextView1, localView, localTextView2, localGradientDrawable1, localGradientDrawable2, paramrbi.jdField_b_of_type_AndroidViewView, paramrbi.jdField_f_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void a(boolean paramBoolean, rbt paramrbt)
  {
    if (!rbi.class.isInstance(paramrbt)) {
      return;
    }
    paramrbt = (rbi)paramrbt;
    int i1;
    if ((paramrbt.jdField_a_of_type_Rfs != null) && (paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (oed.c(paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!paramrbt.jdField_a_of_type_Boolean))
    {
      a(paramBoolean, paramrbt);
      if (paramrbt.jdField_a_of_type_Rfs != null)
      {
        if (!c(paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
          break label338;
        }
        i1 = 8;
        label85:
        if (!c(paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
          break label343;
        }
      }
    }
    label338:
    label343:
    for (int i2 = 0;; i2 = 8)
    {
      paramrbt.jdField_d_of_type_AndroidWidgetTextView.setVisibility(i1);
      paramrbt.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(i2);
      if (oed.a()) {
        paramrbt.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramrbt.jdField_c_of_type_AndroidViewView != null)
      {
        paramrbt.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        paramrbt.jdField_c_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
        paramrbt.jdField_c_of_type_AndroidViewView.setTag(paramrbt);
      }
      if (paramrbt.r != null)
      {
        paramrbt.r.setOnClickListener(this);
        paramrbt.r.getParent().requestDisallowInterceptTouchEvent(true);
        paramrbt.r.setTag(paramrbt);
      }
      if ((paramrbt.jdField_b_of_type_AndroidWidgetSeekBar != null) && (!paramrbt.jdField_a_of_type_Boolean)) {
        paramrbt.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
      if ((paramrbt.jdField_c_of_type_AndroidViewView != null) && (!paramrbt.jdField_a_of_type_Boolean)) {
        paramrbt.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if ((paramrbt.jdField_c_of_type_AndroidViewView != null) && (c(paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)))
      {
        paramrbt.jdField_c_of_type_AndroidViewView.setVisibility(8);
        paramrbt.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if ((paramrbt.jdField_c_of_type_AndroidViewView != null) && (paramrbt.jdField_c_of_type_AndroidViewView.getVisibility() == 0))
      {
        paramrbt.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramrbt.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      a(paramrbt);
      return;
      b(paramBoolean, paramrbt);
      break;
      i1 = 0;
      break label85;
    }
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, VideoInfo paramVideoInfo)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i3 = paramList.indexOf(paramVideoInfo);
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((i3 >= 0) && ((paramList instanceof rbt)) && (((rbt)paramList).jdField_b_of_type_Int == i3))
      {
        ((rbt)paramList).jdField_a_of_type_Qyv.b(paramVideoInfo);
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(RecyclerView paramRecyclerView, List<VideoInfo> paramList, String paramString)
  {
    int i2 = paramRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      RecyclerView.ViewHolder localViewHolder = paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i1));
      if ((localViewHolder instanceof rbt))
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.get(((rbt)localViewHolder).jdField_b_of_type_Int);
        if (paramString.equals(localVideoInfo.j)) {
          ((rbt)localViewHolder).jdField_a_of_type_Qyv.b(localVideoInfo);
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    do
    {
      return false;
      paramVideoAdInfo = noy.a(paramVideoAdInfo);
    } while ((TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url)) || (!oed.d(paramVideoAdInfo)));
    return true;
  }
  
  private boolean a(VideoInfo paramVideoInfo, String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramVideoInfo.j != null)
    {
      bool1 = bool3;
      if (paramVideoInfo.j.equals(paramString))
      {
        bool1 = bool2;
        if (!paramVideoInfo.jdField_o_of_type_Boolean) {
          bool1 = true;
        }
        paramVideoInfo.jdField_o_of_type_Boolean = true;
      }
    }
    return bool1;
  }
  
  private boolean a(rbi paramrbi)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (paramrbi != null)
    {
      bool2 = bool1;
      if (paramrbi.jdField_a_of_type_Rfs != null)
      {
        if (paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) {
          break label34;
        }
        bool2 = bool1;
      }
    }
    label34:
    do
    {
      return bool2;
      Object localObject = paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      bool1 = bool3;
      if (((VideoInfo)localObject).jdField_c_of_type_Boolean)
      {
        localObject = noy.a(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        bool1 = bool3;
        if (localObject != null)
        {
          bool1 = bool3;
          if (!((AdvertisementInfo)localObject).mShowAdButton)
          {
            if (paramrbi.jdField_d_of_type_AndroidWidgetTextView != null) {
              paramrbi.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            if (paramrbi.jdField_a_of_type_AndroidViewView != null) {
              paramrbi.jdField_a_of_type_AndroidViewView.setVisibility(8);
            }
            bool1 = false;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "showButton = " + bool1);
    return bool1;
  }
  
  private boolean a(rbt paramrbt)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    paramrbt.jdField_a_of_type_Riw.jdField_a_of_type_Boolean = false;
    Bundle localBundle;
    int i2;
    int i1;
    if ((paramrbt.jdField_c_of_type_Int == this.jdField_e_of_type_Int) && (this.jdField_a_of_type_AndroidContentContext != null) && (paramrbt.jdField_a_of_type_Rfs != null) && (paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      i2 = localBundle.getInt("VIDEO_FROM_TYPE", 0);
      if (!bdin.b(this.jdField_a_of_type_AndroidContentContext))
      {
        i1 = 1;
        if ((i1 == 0) && (!this.jdField_f_of_type_Boolean)) {
          break label120;
        }
        i1 = 1;
        label96:
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
          break label125;
        }
      }
    }
    label288:
    label291:
    for (;;)
    {
      return false;
      i1 = 0;
      break;
      label120:
      i1 = 0;
      break label96;
      label125:
      if (i2 == 27)
      {
        if (Aladdin.getConfig(271).getIntegerFromString("auto_play", 1) == 1)
        {
          paramrbt = paramrbt.jdField_a_of_type_Riw;
          bool1 = bool2;
          if (i1 == 0) {
            bool1 = true;
          }
          paramrbt.jdField_a_of_type_Boolean = bool1;
          return true;
        }
        paramrbt = paramrbt.jdField_a_of_type_Riw;
        if (i1 == 0) {}
        for (;;)
        {
          paramrbt.jdField_a_of_type_Boolean = bool1;
          return false;
          bool1 = false;
        }
      }
      if (i1 != 0)
      {
        paramrbt.jdField_a_of_type_Riw.jdField_a_of_type_Boolean = false;
        return true;
      }
      i1 = localBundle.getInt("VIDEO_PLAY_STATUS", 0);
      if (((2 == i2) || (6 == i2) || (5 == i2)) && (3 == i1))
      {
        paramrbt.jdField_a_of_type_Riw.jdField_a_of_type_Boolean = false;
        if ((i2 != 0) && (1 != i2) && (12 != i2) && (11 != i2)) {
          break label288;
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label291;
        }
        return true;
        paramrbt.jdField_a_of_type_Riw.jdField_a_of_type_Boolean = true;
        break;
      }
    }
  }
  
  private void b(rbi paramrbi)
  {
    int i1;
    Object localObject;
    if ((paramrbi != null) && (paramrbi.jdField_a_of_type_Rfs != null) && (paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
    {
      i1 = oed.c(noy.a(paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo));
      if (i1 != 1) {
        break label88;
      }
      paramrbi = paramrbi.l;
      if (paramrbi != null)
      {
        localObject = (LinearLayout.LayoutParams)paramrbi.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramrbi.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
    label88:
    do
    {
      do
      {
        do
        {
          return;
        } while (i1 != 2);
        localObject = paramrbi.jdField_m_of_type_AndroidViewView;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramrbi = paramrbi.n;
      } while (paramrbi == null);
      localObject = (LinearLayout.LayoutParams)paramrbi.getLayoutParams();
    } while (localObject == null);
    ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
    paramrbi.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(rbn paramrbn)
  {
    paramrbn = paramrbn.jdField_a_of_type_Rfs;
    if ((paramrbn != null) && ((paramrbn.jdField_a_of_type_Boolean) || ((paramrbn.jdField_a_of_type_Rjn != null) && (paramrbn.jdField_a_of_type_Rjn.e() != 0))))
    {
      paramrbn.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(paramrbn);
    }
  }
  
  private void b(boolean paramBoolean, rbi paramrbi)
  {
    if (oed.a()) {
      a(paramBoolean, paramrbi);
    }
    while (!a(paramrbi)) {
      return;
    }
    View localView = paramrbi.jdField_a_of_type_AndroidViewView;
    TextView localTextView = paramrbi.jdField_d_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (!paramrbi.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      ColorDrawable localColorDrawable = new ColorDrawable();
      localColorDrawable.setColor(Color.parseColor("#FF12B7F6"));
      new GradientDrawable().setColor(Color.parseColor("#33FFFFFF"));
      a(paramrbi, paramBoolean, bool, localView, localTextView, localTextView, localColorDrawable, null, paramrbi.jdField_b_of_type_AndroidViewView, paramrbi.jdField_f_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void c(rbi paramrbi)
  {
    if ((paramrbi == null) || (paramrbi.jdField_c_of_type_AndroidViewView == null) || (paramrbi.g == null) || (paramrbi.jdField_m_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidContentContext.getResources() == null)) {
      return;
    }
    if ((paramrbi.jdField_c_of_type_AndroidViewView != null) && (c(paramrbi.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))) {
      paramrbi.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = paramrbi.jdField_c_of_type_AndroidViewView;
    Object localObject = new GradientDrawable();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    TextView localTextView = paramrbi.g;
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramrbi.jdField_m_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      ((GradientDrawable)localObject).setCornerRadius(aepi.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localLayoutParams.height = aepi.a(31.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.topMargin = aepi.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.bottomMargin = aepi.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.leftMargin = aepi.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.rightMargin = aepi.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(13);
        localTextView.setLayoutParams(localLayoutParams1);
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842354);
    }
    for (;;)
    {
      localView.setLayoutParams(localLayoutParams);
      if ((paramrbi.jdField_a_of_type_AndroidWidgetProgressBar == null) || (localObject == null)) {
        break;
      }
      paramrbi.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject);
      return;
      localLayoutParams.height = aepi.a(42.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.topMargin = aepi.a(15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.bottomMargin = aepi.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.leftMargin = aepi.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.rightMargin = aepi.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      ((GradientDrawable)localObject).setCornerRadius(aepi.a(0.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842352);
      if (localLayoutParams1 != null)
      {
        localLayoutParams1.addRule(15);
        localTextView.setLayoutParams(localLayoutParams1);
      }
    }
  }
  
  private static boolean c(VideoInfo paramVideoInfo)
  {
    return oee.a(paramVideoInfo);
  }
  
  private void e(VideoInfo paramVideoInfo)
  {
    int i2 = 1;
    if (paramVideoInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel_id", 409409);
      if (!paramVideoInfo.p) {
        break label299;
      }
      i1 = 0;
      localJSONObject.put("type", i1);
      if (paramVideoInfo.y == null) {
        break label304;
      }
      str1 = paramVideoInfo.y;
      label60:
      localJSONObject.put("video_report_info", str1);
      if (!paramVideoInfo.p) {
        break label103;
      }
      if (this.jdField_a_of_type_Rez == null) {
        break label357;
      }
      i1 = this.jdField_a_of_type_Rez.a();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        label103:
        String str2;
        label161:
        label191:
        label213:
        label236:
        String str4;
        String str3;
        label299:
        label304:
        label320:
        label325:
        label333:
        label339:
        continue;
        int i1 = 0;
        continue;
        i1 = 0;
        continue;
        i1 = 0;
      }
    }
    localJSONObject.put("style", i1);
    localJSONObject.put("algorithm_id", paramVideoInfo.f);
    if (this.jdField_a_of_type_Res != null)
    {
      if (!this.jdField_a_of_type_Res.a()) {
        break label362;
      }
      i1 = 1;
      localJSONObject.put("is_display_download_bar", i1);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar != null)
      {
        str1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
        localJSONObject.put("common_data", str1);
        localJSONObject.put("video_type", 0);
        if (!this.s) {
          break label320;
        }
        i1 = i2;
        localJSONObject.put("interact_button_style", i1);
        if (!this.jdField_a_of_type_Boolean) {
          break label325;
        }
        str1 = "0X800929C";
        if ((paramVideoInfo.jdField_a_of_type_Int != 0) || (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label333;
        }
        str2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        str4 = paramVideoInfo.j;
        if (TextUtils.isEmpty(paramVideoInfo.g)) {
          break label339;
        }
      }
      for (str3 = paramVideoInfo.g;; str3 = "0")
      {
        nrt.a(null, str4, str1, str1, 0, 0, "0", "0", str3, ntd.a(str2, paramVideoInfo.j, paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, localJSONObject), false);
        return;
        i1 = 1;
        break;
        str1 = "";
        break label60;
        str1 = "";
        break label161;
        i1 = 0;
        break label191;
        str1 = "0X80091A9";
        break label213;
        str2 = null;
        break label236;
      }
    }
  }
  
  private void f(VideoInfo paramVideoInfo)
  {
    int i1 = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "innerSubscribeColume() columeid=" + i1);
    }
    rdm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
    paramVideoInfo = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramVideoInfo.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramVideoInfo.next();
      if ((localVideoInfo.e()) && (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int == i1))
      {
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Boolean = true;
        VideoColumnInfo localVideoColumnInfo = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo;
        localVideoColumnInfo.jdField_c_of_type_Int += 1;
        b(localVideoInfo);
      }
    }
    b(i1);
  }
  
  private void g(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_e_of_type_Int == 1)) {
      nrt.a(null, "", "0X800AC2B", "0X800AC2B", 0, 0, "3", "", "", new ron(paramVideoInfo).a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).N(0).a().a(), false);
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleConnetNetWorkChange");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_c_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsAdapter.12(this, paramBoolean));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b(false);
  }
  
  private void h(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = 0;
      if (i1 < paramVideoInfo.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject = (VideoInfo.ChannelInfo)paramVideoInfo.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localObject = new ron("", "", paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g).t(((VideoInfo.ChannelInfo)localObject).jdField_a_of_type_Int).u(rdm.a((VideoInfo.ChannelInfo)localObject)).a(paramVideoInfo.y).a().a();
        if (this.jdField_a_of_type_Boolean) {
          nrt.a(null, "", "0X8009330", "0X8009330", 0, 0, "3", "", "", (String)localObject, false);
        }
        for (;;)
        {
          i1 += 1;
          break;
          nrt.a(null, "", "0X80092F8", "0X80092F8", 0, 0, "3", "", "", (String)localObject, false);
        }
      }
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a = new rjz(rjz.jdField_c_of_type_Int, rjz.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(new rax(this));
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "handleNotNetWorkChange mIsActivityOnResume = " + this.jdField_c_of_type_Boolean);
    }
    if (!this.jdField_c_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(false);
  }
  
  public VideoInfo a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    VideoInfo localVideoInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break label103;
          }
          localVideoInfo = (VideoInfo)localIterator.next();
          localObject = localVideoInfo;
          if (paramString.equals(localVideoInfo.g)) {
            break;
          }
        } while (localVideoInfo.d == null);
        localObject = localVideoInfo.d.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.g));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public rbl a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = LayoutInflater.from(paramViewGroup.getContext());
    Object localObject3;
    switch (paramInt)
    {
    case 3: 
    default: 
      localObject3 = null;
      paramViewGroup = null;
      localObject1 = null;
      if (paramViewGroup != null)
      {
        paramViewGroup.jdField_a_of_type_Qyv = ((qyv)localObject3);
        paramViewGroup.jdField_a_of_type_Riw = new riw(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_f_of_type_Boolean);
        return paramViewGroup;
      }
      break;
    case 2: 
      localObject1 = rha.a(2131560164, true, new ViewGroup.LayoutParams(-1, -1));
      paramViewGroup = (rbs)((View)localObject1).getTag();
      if (paramViewGroup == null) {
        paramViewGroup = rbs.a((View)localObject1);
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject3 = new rbr(this, (rbs)paramViewGroup);
        try
        {
          paramInt = bnle.b(this.jdField_a_of_type_AndroidAppActivity);
          if ((bnle.b()) && (paramInt > 0) && (((rbs)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView != null))
          {
            localObject1 = (View)((rbs)paramViewGroup).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView.getParent();
            ((View)localObject1).setPadding(((View)localObject1).getPaddingLeft(), paramInt + ((View)localObject1).getPaddingTop(), ((View)localObject1).getPaddingRight(), ((View)localObject1).getPaddingBottom());
          }
          localObject1 = null;
        }
        catch (Exception localException)
        {
          localObject2 = null;
        }
      }
      break;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560155, paramViewGroup, false);
      ((LayoutInflater)localObject2).inflate(2131560182, (ViewGroup)paramViewGroup.findViewById(2131364613), true);
      ((LayoutInflater)localObject2).inflate(2131560179, (ViewGroup)paramViewGroup.findViewById(2131364611), true);
      ((LayoutInflater)localObject2).inflate(2131560180, (ViewGroup)paramViewGroup.findViewById(2131364609), true);
      paramViewGroup = new rbi(paramViewGroup, paramInt);
      localObject3 = new rbd(this, (rbi)paramViewGroup);
      Object localObject2 = null;
      break;
      localObject3 = rha.a(2131560160, true, new ViewGroup.LayoutParams(-1, -1));
      localObject2 = (rbq)((View)localObject3).getTag();
      paramViewGroup = (ViewGroup)localObject2;
      if (localObject2 == null) {
        paramViewGroup = new rbq((View)localObject3, paramInt);
      }
      this.jdField_a_of_type_Rbq = paramViewGroup;
      localObject3 = null;
      localObject2 = paramViewGroup;
      paramViewGroup = null;
      break;
      return localObject2;
    }
  }
  
  public rcz a()
  {
    return this.jdField_a_of_type_Rcz;
  }
  
  public rig a()
  {
    return this.jdField_a_of_type_Rig;
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilList.size();
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c();
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(i1 + i2 - 1);
    if ((localViewHolder instanceof rbq)) {
      a((rbq)localViewHolder);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_Rby != null) && (this.jdField_a_of_type_Rby.a()) && (this.jdField_a_of_type_Rby.b()))
    {
      this.jdField_a_of_type_Rby.h();
      break label34;
    }
    for (;;)
    {
      label34:
      return;
      if (!this.v) {
        continue;
      }
      paramView = (rbn)paramView.getTag();
      if (paramView != this.jdField_a_of_type_Rbn)
      {
        if (this.jdField_a_of_type_Rbn == null) {
          break;
        }
        if ((paramView != null) && (paramView.jdField_c_of_type_Int == this.jdField_a_of_type_Rbn.jdField_c_of_type_Int + 1) && (paramView.jdField_c_of_type_Int != getItemCount()))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
          return;
        }
        if ((paramView == null) || (paramView.jdField_c_of_type_Int != this.jdField_a_of_type_Rbn.jdField_c_of_type_Int - 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
      }
      paramView.jdField_a_of_type_Qyv.c();
      JSONObject localJSONObject;
      switch (paramView.jdField_a_of_type_Int)
      {
      case 3: 
      case 4: 
      case 6: 
      default: 
      case 2: 
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
          continue;
        }
        localJSONObject = new JSONObject();
      case 5: 
      case 7: 
        try
        {
          localJSONObject.put("channel_id", 409409);
          label221:
          nrt.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", ntd.a(null, null, paramView.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
          return;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d())) {
            continue;
          }
          localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("channel_id", 409409);
            label307:
            nrt.a(null, null, "0X80091AB", "0X80091AB", 0, 0, "", "", "", ntd.a(null, null, paramView.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
            return;
          }
          catch (JSONException localJSONException1)
          {
            break label307;
          }
        }
        catch (JSONException localJSONException2)
        {
          break label221;
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (rbt)paramView.getTag();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.t);
        paramView.jdField_a_of_type_Qyv.a(1);
        this.t = false;
        return;
      } while (paramView.d.getVisibility() != 0);
      paramView.jdField_a_of_type_Qyv.a(2);
    } while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b());
    this.t = true;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    rbt localrbt = (rbt)paramView.getTag();
    if (localrbt != this.jdField_a_of_type_Rbn) {}
    while ((!this.v) || (localrbt == null) || (localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!(localrbt instanceof rbn)) || (TextUtils.isEmpty(localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g))) {
      return;
    }
    Object localObject = localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    boolean bool;
    int i1;
    label108:
    JSONObject localJSONObject;
    if (!((VideoInfo)localObject).p)
    {
      bool = true;
      ((VideoInfo)localObject).p = true;
      if (!bool) {
        break label570;
      }
      i1 = ((VideoInfo)localObject).r + 1;
      ((VideoInfo)localObject).r = i1;
      if ((this.jdField_a_of_type_Res != null) && ((localrbt instanceof rbs)))
      {
        int i2 = 0;
        i1 = i2;
        if (this.jdField_a_of_type_Ric != null)
        {
          i1 = i2;
          if (this.jdField_a_of_type_Ric.a()) {
            i1 = 1;
          }
        }
        if (i1 == 0) {
          this.jdField_a_of_type_Res.a((VideoInfo)localObject, (rbs)localrbt);
        }
      }
      localrbt.jdField_a_of_type_Qyv.a(paramInt1, paramInt2, bool);
      if (bool)
      {
        if (this.jdField_a_of_type_Rbk != null) {
          this.jdField_a_of_type_Rbk.a((VideoInfo)localObject, ((VideoInfo)localObject).p);
        }
        e((VideoInfo)localObject);
      }
      if (this.jdField_a_of_type_Rgn != null) {
        this.jdField_a_of_type_Rgn.a(3, (VideoInfo)localObject, 0L);
      }
      localJSONObject = new JSONObject();
      if ((localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int != 0) || (localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
        break label580;
      }
      paramView = localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
    }
    try
    {
      label298:
      localJSONObject.put("channel_id", 409409);
      localJSONObject.put("rowkey", localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      if (this.jdField_a_of_type_Rez == null) {
        break label585;
      }
      paramInt1 = this.jdField_a_of_type_Rez.a();
      label345:
      localJSONObject.put("style", paramInt1);
      localJSONObject.put("algorithm_id", ((VideoInfo)localObject).f);
      paramInt1 = 0;
      if (this.jdField_a_of_type_Res != null)
      {
        if (!this.jdField_a_of_type_Res.a()) {
          break label590;
        }
        paramInt1 = 1;
      }
      label390:
      localJSONObject.put("is_display_download_bar", paramInt1);
      if (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar == null) {
        break label595;
      }
      localObject = ((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.jdField_c_of_type_JavaLangString;
      label418:
      localJSONObject.put("common_data", localObject);
      if (!this.s) {
        break label603;
      }
      paramInt1 = 1;
      label438:
      localJSONObject.put("interact_button_style", paramInt1);
    }
    catch (Exception localException)
    {
      label448:
      label460:
      String str2;
      String str1;
      label570:
      label580:
      label585:
      label590:
      label595:
      label603:
      label616:
      break label448;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = "0X80097F5";
      str2 = localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j;
      if (TextUtils.isEmpty(localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g)) {
        break label616;
      }
    }
    for (str1 = localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;; str1 = "0")
    {
      nrt.a(null, str2, (String)localObject, (String)localObject, 0, 0, "0", "0", str1, ntd.a(paramView, localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j, localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, localrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, localJSONObject), false);
      return;
      bool = false;
      break;
      i1 = ((VideoInfo)localObject).r;
      break label108;
      paramView = null;
      break label298;
      paramInt1 = 0;
      break label345;
      paramInt1 = 0;
      break label390;
      localObject = "";
      break label418;
      paramInt1 = 0;
      break label438;
      localObject = "0X80091AA";
      break label460;
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Ron != null))
    {
      this.jdField_a_of_type_Ron.a(paramVideoInfo.y);
      a(paramVideoInfo, this.jdField_a_of_type_Ron);
      this.jdField_a_of_type_Ron = null;
    }
  }
  
  public void a(ADVideoAppDownloadManager paramADVideoAppDownloadManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = paramADVideoAppDownloadManager;
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    i();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(new rbc(this));
  }
  
  public void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, List<VideoInfo> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoInfo)paramList.next()).a();
      }
    }
    int i2 = paramVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      paramList = paramVideoFeedsRecyclerView.getChildViewHolder(paramVideoFeedsRecyclerView.getChildAt(i1));
      if ((paramList instanceof rbt)) {
        ((rbt)paramList).jdField_a_of_type_Qyv.a();
      }
      i1 += 1;
    }
  }
  
  public void a(String paramString)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramString);
  }
  
  public void a(List<VideoInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(qym paramqym)
  {
    this.jdField_a_of_type_Qym = paramqym;
  }
  
  public void a(qzw paramqzw)
  {
    this.jdField_a_of_type_Qzw = paramqzw;
  }
  
  public void a(rbk paramrbk)
  {
    this.jdField_a_of_type_Rbk = paramrbk;
  }
  
  public void a(rbl paramrbl, int paramInt)
  {
    paramrbl.jdField_b_of_type_Int = paramInt;
    paramrbl.jdField_c_of_type_Int = paramInt;
    paramrbl.jdField_b_of_type_Boolean = true;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      if (this.jdField_a_of_type_Qzw != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Qzw.b(paramInt);
        if (localVideoInfo != null) {
          this.jdField_a_of_type_JavaUtilList.set(paramInt, localVideoInfo);
        }
      }
      a(paramrbl, (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      return;
    }
    a(paramrbl, null);
  }
  
  public void a(rbl paramrbl, VideoInfo paramVideoInfo)
  {
    int i1 = paramrbl.jdField_a_of_type_Int;
    if ((i1 == 3) || (i1 == 6))
    {
      a((rbq)paramrbl);
      this.jdField_a_of_type_Rbq = ((rbq)paramrbl);
    }
    do
    {
      return;
      paramrbl = (rbn)paramrbl;
      b(paramrbl);
      a(paramrbl, paramVideoInfo);
      TraceCompat.beginSection("refreshMenuUI");
      paramrbl.jdField_a_of_type_Qyv.a(paramVideoInfo);
      TraceCompat.endSection();
      TraceCompat.beginSection("refreshContentUI");
      paramrbl.jdField_a_of_type_Qyv.a(paramVideoInfo, this.jdField_d_of_type_Boolean);
      TraceCompat.endSection();
      if ((this.h) && (paramrbl == this.jdField_a_of_type_Rbn)) {
        paramrbl.jdField_a_of_type_Qyv.e(this.h);
      }
    } while (!paramrbl.jdField_b_of_type_Boolean);
    a(paramrbl);
  }
  
  public void a(rbt paramrbt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "adapter playVideo (VideoItemHolder holder) ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    int i1;
    boolean bool;
    label101:
    long l1;
    long l2;
    if (this.jdField_a_of_type_Rbn != null)
    {
      i1 = this.jdField_a_of_type_Rbn.jdField_c_of_type_Int;
      this.jdField_a_of_type_Rbn = paramrbt;
      if ((this.jdField_a_of_type_Rbn.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_Rbn.jdField_b_of_type_Int == 0))
      {
        paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = 0L;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break label196;
      }
      bool = a(paramrbt);
      this.jdField_g_of_type_Boolean = false;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_b_of_type_Long;
      if (!bool) {
        break label201;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs, false);
    }
    for (;;)
    {
      a(paramrbt, bool, l1 - l2, i1);
      if ((paramrbt.jdField_a_of_type_Rfs != null) && (paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        syb.a(paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, 0, 0);
      }
      return;
      i1 = -1;
      break;
      label196:
      bool = true;
      break label101;
      label201:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(paramrbt.jdField_a_of_type_Rfs);
    }
  }
  
  public void a(rby paramrby)
  {
    this.jdField_a_of_type_Rby = paramrby;
  }
  
  public void a(rcz paramrcz)
  {
    this.jdField_a_of_type_Rcz = paramrcz;
  }
  
  public void a(rez paramrez)
  {
    this.jdField_a_of_type_Rez = paramrez;
  }
  
  public void a(rgn paramrgn)
  {
    this.jdField_a_of_type_Rgn = paramrgn;
  }
  
  public void a(ric paramric)
  {
    this.jdField_a_of_type_Ric = paramric;
  }
  
  public void a(rig paramrig)
  {
    this.jdField_a_of_type_Rig = paramrig;
  }
  
  public void a(riq paramriq)
  {
    this.jdField_a_of_type_Riq = paramriq;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    return (this.jdField_a_of_type_Rbn == null) || (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs == null) || (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == paramVideoInfo);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public VideoInfo b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    VideoInfo localVideoInfo;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          if (!localIterator.hasNext()) {
            break label103;
          }
          localVideoInfo = (VideoInfo)localIterator.next();
          localObject = localVideoInfo;
          if (paramString.equals(localVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
        } while (localVideoInfo.d == null);
        localObject = localVideoInfo.d.iterator();
      }
      localVideoInfo = (VideoInfo)((Iterator)localObject).next();
    } while (!paramString.equals(localVideoInfo.jdField_a_of_type_JavaLangString));
    return localVideoInfo;
    label103:
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramInt);
  }
  
  public void b(View paramView) {}
  
  public void b(VideoInfo paramVideoInfo)
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_JavaUtilList, paramVideoInfo);
  }
  
  public void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    paramString = oqu.k + bdfr.encodeToString(String.valueOf(paramString).getBytes(), 2);
    ors.a(this.jdField_a_of_type_AndroidAppActivity, paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildAt(i1));
      if (((localObject instanceof rbt)) && (((rbt)localObject).jdField_c_of_type_Int == this.jdField_a_of_type_Rbn.jdField_c_of_type_Int + 1))
      {
        localObject = ((rbt)localObject).jdField_a_of_type_Rfs;
        if ((localObject != null) && ((((rfs)localObject).jdField_a_of_type_Boolean) || ((((rfs)localObject).jdField_a_of_type_Rjn != null) && (((rfs)localObject).jdField_a_of_type_Rjn.e() != 0))))
        {
          ((rfs)localObject).jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c((rfs)localObject);
        }
      }
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.e();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2, null);
    }
    ApngImage.pauseByTag(28);
    ApngImage.pauseByTag(29);
    ApngImage.pauseByTag(30);
    if (paramInt == 1) {
      odt.c(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void c(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (!this.q))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "rePostMsgForAd");
      }
      this.q = true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4, null);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(VideoInfo paramVideoInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(paramVideoInfo)))
    {
      int i1 = this.jdField_a_of_type_JavaUtilList.indexOf(paramVideoInfo);
      h();
      this.jdField_a_of_type_JavaUtilList.remove(paramVideoInfo);
      this.jdField_a_of_type_Rbn = null;
      notifyItemRemoved(i1);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void e()
  {
    this.jdField_c_of_type_Boolean = true;
    szl.a(this);
    if ((this.jdField_a_of_type_Rbn != null) && (this.jdField_a_of_type_Rbn.jdField_a_of_type_Qyv != null) && ((this.jdField_a_of_type_Rbn.jdField_a_of_type_Qyv instanceof rbd))) {
      ((rbd)this.jdField_a_of_type_Rbn.jdField_a_of_type_Qyv).e();
    }
    ApngImage.playByTag(28);
    ApngImage.playByTag(29);
    ApngImage.playByTag(30);
    odt.d();
    oee.a(this.jdField_a_of_type_Qym, this, (rbt)this.jdField_a_of_type_Rbn);
  }
  
  public void e(boolean paramBoolean)
  {
    if ((!this.jdField_o_of_type_Boolean) && (paramBoolean) && (this.p))
    {
      if ((this.jdField_a_of_type_Rbn instanceof rbt)) {
        a((rbt)this.jdField_a_of_type_Rbn);
      }
      this.p = false;
    }
    this.jdField_o_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Ron != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_Ron);
    }
    if (this.jdField_a_of_type_Rbk != null) {
      this.jdField_a_of_type_Rbk = null;
    }
    if (this.jdField_a_of_type_Rbn != null) {
      this.jdField_a_of_type_Rbn.jdField_b_of_type_ComTencentImageURLImageView = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Bhzx = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Odf != null) {
      this.jdField_a_of_type_Odf.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    if (this.jdField_a_of_type_Rac != null)
    {
      this.jdField_a_of_type_Rac.b();
      this.jdField_a_of_type_Rac = null;
    }
    if (this.jdField_a_of_type_Res != null)
    {
      this.jdField_a_of_type_Res.a();
      this.jdField_a_of_type_Res = null;
    }
    odt.e();
    bfkr.a().b(VideoFeedsUGView.a);
    if (this.jdField_a_of_type_Rbt != null)
    {
      a(this.jdField_a_of_type_Rbt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
      a(this.jdField_a_of_type_Rbt.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsUGView, false);
    }
  }
  
  public void f(boolean paramBoolean) {}
  
  public void g()
  {
    if ((this.jdField_a_of_type_Rbn == null) || (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs == null) || (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Long <= 0L)) {
      return;
    }
    String str = alud.a(2131716571);
    this.jdField_a_of_type_Rbn.jdField_a_of_type_Roh.a(0, str, "点击重试");
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).hashCode();
    }
    if ((this.jdField_a_of_type_Rbq != null) && (this.jdField_a_of_type_Rbq.itemView != null)) {
      return this.jdField_a_of_type_Rbq.itemView.hashCode();
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!localVideoInfo.jdField_c_of_type_Boolean) {
        return 2;
      }
      if (localVideoInfo.h == 1) {
        return 7;
      }
    }
    return 6;
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    Object localObject3 = (rbl)paramView.getTag();
    VideoInfo localVideoInfo;
    if ((localObject3 instanceof rbt))
    {
      localVideoInfo = ((rbt)localObject3).jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Rbn != null) && (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs != null) && (localVideoInfo == this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    label62:
    label2414:
    label2671:
    label3825:
    for (;;)
    {
      return;
      for (;;)
      {
        if (localVideoInfo == null) {
          break label3825;
        }
        Object localObject1 = null;
        long l1;
        if (localVideoInfo.jdField_c_of_type_Boolean)
        {
          localObject1 = oen.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = szl.a(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
          if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null)
          {
            l1 = SystemClock.elapsedRealtime();
            label118:
            this.jdField_a_of_type_Long = l1;
          }
        }
        else
        {
          if ((localVideoInfo.jdField_a_of_type_Int != 0) || (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label557;
          }
        }
        Object localObject4;
        for (Object localObject2 = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();; localObject2 = null)
        {
          localObject4 = new JSONObject();
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131361821: 
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
              break label62;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
            return;
            l1 = -2147483648L;
            break label118;
          }
        }
        if (this.jdField_a_of_type_Rgr != null) {
          this.jdField_a_of_type_Rgr.b();
        }
        if (paramView.getId() != 2131365813) {
          break;
        }
        roi.b(localVideoInfo.g, 1);
        return;
        if ((this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs == null) || (localVideoInfo == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(false);
        roi.a(this.jdField_a_of_type_AndroidAppActivity, qys.a(localVideoInfo), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(localVideoInfo.g), 1, 0);
        roi.a(localVideoInfo.g, 1, 0);
        return;
        if ((((rbl)localObject3).jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a() == 5)) {
          rdm.a(((rbt)localObject3).d, 8, 200);
        }
        if (this.jdField_a_of_type_Rgr == null) {
          break;
        }
        this.jdField_a_of_type_Rgr.b();
        return;
        if (ohq.a() == 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localVideoInfo, false, bool);
          if (this.jdField_a_of_type_Rgn == null) {
            break;
          }
          this.jdField_a_of_type_Rgn.a(2, localVideoInfo, 0L);
          return;
        }
        if ((this.jdField_a_of_type_Rby != null) && (localVideoInfo.a(this.jdField_a_of_type_AndroidAppActivity))) {
          this.jdField_a_of_type_Rby.h();
        }
        if (localVideoInfo.jdField_c_of_type_Boolean)
        {
          szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
          a(localVideoInfo, 0);
          return;
        }
        if (localVideoInfo.e())
        {
          rdm.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
          localObject1 = new ron(localVideoInfo).h(localVideoInfo.g).t(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {}
          for (paramView = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramView = "")
          {
            nrt.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((ron)localObject1).o(paramView).R(1).a().a(), false);
            return;
          }
        }
        if ((localVideoInfo.z != null) && (!localVideoInfo.z.equals("")))
        {
          ors.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.z);
          return;
        }
        if (localVideoInfo.jdField_a_of_type_Int == 6)
        {
          if (!TextUtils.isEmpty(localVideoInfo.j))
          {
            paramView = oqu.g + bdfr.encodeToString(localVideoInfo.j.getBytes(), 2);
            ors.a(this.jdField_a_of_type_AndroidAppActivity, paramView);
          }
          localObject1 = new ron((String)localObject2, localVideoInfo.j, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L).a(-1).N(0).a().a();
          localObject2 = localVideoInfo.j;
          if (TextUtils.isEmpty(localVideoInfo.g)) {
            break label1173;
          }
        }
        for (paramView = localVideoInfo.g;; paramView = "0")
        {
          nrt.a(null, (String)localObject2, "0X8007410", "0X8007410", 0, 0, "0", "", paramView, (String)localObject1, false);
          return;
          if ((TextUtils.isEmpty(localVideoInfo.j)) || (localVideoInfo.j.equals("16888"))) {
            break;
          }
          b(localVideoInfo.j);
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        return;
        if (localVideoInfo.e())
        {
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Boolean) {
            break;
          }
          f(localVideoInfo);
          rdm.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
          localObject1 = new ron(localVideoInfo).h(localVideoInfo.g).t(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {}
          for (paramView = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_c_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.e;; paramView = "")
          {
            nrt.b(null, "", "0X800A18C", "0X800A18C", 0, 0, "", "", "", ((ron)localObject1).o(paramView).R(2).N(0).a().a(), false);
            return;
          }
        }
        if (localVideoInfo.jdField_o_of_type_Boolean) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsAdapter", 2, "followPubAccount onClick() puin=" + localVideoInfo.j + ", isFollowed=" + localVideoInfo.jdField_o_of_type_Boolean + ", pname=" + localVideoInfo.k);
        }
        localObject1 = new ron(null, localVideoInfo.j, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo.a() * 1000L).a(localVideoInfo.y).N(0).a().a();
        if (this.jdField_a_of_type_Boolean)
        {
          localObject2 = localVideoInfo.j;
          if (!TextUtils.isEmpty(localVideoInfo.g)) {}
          for (paramView = localVideoInfo.g;; paramView = "0")
          {
            nrt.a(null, (String)localObject2, "0X800929B", "0X800929B", 0, 0, "", "", paramView, (String)localObject1, false);
            a(localVideoInfo.j, localVideoInfo.jdField_b_of_type_Boolean);
            return;
          }
        }
        localObject2 = localVideoInfo.j;
        if (!TextUtils.isEmpty(localVideoInfo.g)) {}
        for (paramView = localVideoInfo.g;; paramView = "0")
        {
          nrt.a(null, (String)localObject2, "0X80078FD", "0X80078FD", 0, 0, "", "", paramView, (String)localObject1, false);
          break;
        }
        if ((!localVideoInfo.jdField_c_of_type_Boolean) || (!(this.jdField_a_of_type_Rbn instanceof rbi))) {
          break;
        }
        a(paramView, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), localVideoInfo);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, 0);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        oee.a((AdvertisementInfo)localObject1, 1000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, noy.ay);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        oee.a((AdvertisementInfo)localObject1, 2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, noy.aq);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        oee.a((AdvertisementInfo)localObject1, 3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, noy.ar);
        return;
        if (!localVideoInfo.jdField_c_of_type_Boolean) {
          break;
        }
        if (this.n)
        {
          this.n = false;
          oee.a((AdvertisementInfo)localObject1, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
          szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
          a(localVideoInfo, noy.ap);
          return;
        }
        oee.a((AdvertisementInfo)localObject1, 4, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, false, null);
        a(localVideoInfo, noy.as);
        return;
        if (!(localObject3 instanceof rbi)) {
          break;
        }
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.J).b(noy.N).a((AdvertisementInfo)localObject1).a());
          return;
        }
        localObject2 = (rbi)localObject3;
        int i1 = 8;
        if (this.i) {
          i1 = 13;
        }
        oee.a((AdvertisementInfo)localObject1, i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        c((rbi)localObject2);
        paramView = new View[1];
        paramView[0] = ((rbi)localObject2).jdField_c_of_type_AndroidViewView;
        if (c(localVideoInfo)) {
          paramView = new View[0];
        }
        a((rbi)localObject2, localVideoInfo, (AdvertisementInfo)localObject1, -1, paramView, new View[] { ((rbi)localObject2).jdField_d_of_type_AndroidWidgetTextView, ((rbi)localObject2).jdField_a_of_type_AndroidViewView, ((rbi)localObject2).jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        if (!(localObject3 instanceof rbi)) {
          break;
        }
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.J).b(noy.N).a((AdvertisementInfo)localObject1).a());
        }
        while ((this.jdField_a_of_type_Rbn != null) && (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs != null))
        {
          oee.a(this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs, true);
          return;
          localObject2 = (rbi)localObject3;
          paramView = new View[2];
          paramView[0] = ((rbi)localObject2).r;
          paramView[1] = ((rbi)localObject2).jdField_c_of_type_AndroidViewView;
          if (c(localVideoInfo))
          {
            paramView = new View[1];
            paramView[0] = ((rbi)localObject2).r;
          }
          localObject3 = ((rbi)localObject2).jdField_d_of_type_AndroidWidgetTextView;
          localObject4 = ((rbi)localObject2).jdField_a_of_type_AndroidViewView;
          TextView localTextView = ((rbi)localObject2).jdField_m_of_type_AndroidWidgetTextView;
          SeekBar localSeekBar = ((rbi)localObject2).jdField_b_of_type_AndroidWidgetSeekBar;
          a((rbi)localObject2, localVideoInfo, (AdvertisementInfo)localObject1, noy.Y, paramView, new View[] { localObject3, localObject4, localTextView, localSeekBar });
        }
        if (!(localObject3 instanceof rbi)) {
          break;
        }
        paramView = (rbi)localObject3;
        a((rbl)localObject3, localVideoInfo, (AdvertisementInfo)localObject1, -1, paramView.jdField_c_of_type_AndroidViewView, new View[] { paramView.jdField_d_of_type_AndroidWidgetTextView, paramView.jdField_a_of_type_AndroidViewView, paramView.jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        if (!(localObject3 instanceof rbi)) {
          break;
        }
        paramView = (rbi)localObject3;
        a((rbl)localObject3, localVideoInfo, (AdvertisementInfo)localObject1, noy.Y, paramView.r, new View[] { paramView.jdField_m_of_type_AndroidWidgetTextView, paramView.jdField_b_of_type_AndroidWidgetSeekBar });
        return;
        a(paramView);
        return;
        this.jdField_a_of_type_Rby.g();
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = "0X800948A";
          localObject1 = (rbt)localObject3;
          if (((rbt)localObject1).jdField_a_of_type_Rfs == null) {
            break label2651;
          }
          localObject1 = ((rbt)localObject1).jdField_a_of_type_Rfs.jdField_a_of_type_Rjn;
          localObject2 = new ron(null, localVideoInfo.j, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g);
          if (localObject1 == null) {
            break label2663;
          }
          if (((rjn)localObject1).e() != 7) {
            break label2657;
          }
          bool = true;
          l1 = ((rjn)localObject1).a(bool);
          localObject2 = ((ron)localObject2).d(l1);
          if (localObject1 == null) {
            break label2671;
          }
          l1 = ((rjn)localObject1).a();
          localObject2 = ((ron)localObject2).a(l1);
          if (localObject1 == null) {
            break label2679;
          }
          l1 = ((rjn)localObject1).b();
          localObject2 = ((ron)localObject2).c(l1).a(409409).a(localVideoInfo.y).v(this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1)).a().a();
          localObject3 = localVideoInfo.j;
          if (TextUtils.isEmpty(localVideoInfo.g)) {
            break label2687;
          }
        }
        label2679:
        label2687:
        for (localObject1 = localVideoInfo.g;; localObject1 = "0")
        {
          nrt.a(null, (String)localObject3, paramView, paramView, 0, 0, "", "", (String)localObject1, (String)localObject2, false);
          if (this.jdField_a_of_type_Rgn == null) {
            break;
          }
          this.jdField_a_of_type_Rgn.a(4, localVideoInfo, 0L);
          return;
          paramView = "0X8009485";
          break label2414;
          localObject1 = null;
          break label2439;
          bool = false;
          break label2482;
          l1 = -1L;
          break label2491;
          l1 = -1L;
          break label2512;
          l1 = -1L;
          break label2533;
        }
        this.jdField_a_of_type_Rby.e();
        for (;;)
        {
          try
          {
            if (localVideoInfo.y == null) {
              continue;
            }
            paramView = localVideoInfo.y;
            ((JSONObject)localObject4).put("video_report_info", paramView);
            ((JSONObject)localObject4).put("video_type", 0);
            if (!this.s) {
              continue;
            }
            i1 = 1;
            ((JSONObject)localObject4).put("interact_button_style", i1);
          }
          catch (JSONException paramView)
          {
            paramView.printStackTrace();
            continue;
            nrt.a(null, "", "0X8008E54", "0X8008E54", 0, 0, "", "", "", ntd.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g, (JSONObject)localObject4), false);
            return;
          }
          if (!this.jdField_a_of_type_Boolean) {
            continue;
          }
          nrt.a(null, "", "0X80092A1", "0X80092A1", 0, 0, "", "", "", ntd.a("", "", localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g, (JSONObject)localObject4), false);
          return;
          paramView = "";
          continue;
          i1 = 0;
        }
        if (!localVideoInfo.p)
        {
          bool = true;
          localVideoInfo.p = bool;
          if (!localVideoInfo.p) {
            break label3087;
          }
          i1 = localVideoInfo.r + 1;
        }
        for (;;)
        {
          localVideoInfo.r = i1;
          if ((localObject3 instanceof rbt)) {
            ((rbt)localObject3).jdField_a_of_type_Qyv.d();
          }
          if ((this.jdField_a_of_type_Rez != null) && (localVideoInfo.p)) {
            this.jdField_a_of_type_Rez.a((float)(bdgk.i() / 2L), (float)(bdgk.j() / 2L));
          }
          if (this.jdField_a_of_type_Rgn != null) {
            this.jdField_a_of_type_Rgn.a(3, localVideoInfo, 0L);
          }
          if (this.jdField_a_of_type_Rbk != null) {
            this.jdField_a_of_type_Rbk.a(localVideoInfo, localVideoInfo.p);
          }
          if ((this.jdField_a_of_type_Res != null) && ((localObject3 instanceof rbs)))
          {
            int i2 = 0;
            i1 = i2;
            if (this.jdField_a_of_type_Ric != null)
            {
              i1 = i2;
              if (this.jdField_a_of_type_Ric.a()) {
                i1 = 1;
              }
            }
            if (i1 == 0) {
              this.jdField_a_of_type_Res.a(localVideoInfo, (rbs)localObject3);
            }
          }
          e(localVideoInfo);
          return;
          bool = false;
          break;
          if (localVideoInfo.r > 0) {
            i1 = localVideoInfo.r - 1;
          } else {
            i1 = 0;
          }
        }
        if ((!(localObject3 instanceof rbs)) || (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null)) {
          break;
        }
        rdm.a(this.jdField_a_of_type_AndroidAppActivity, localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo);
        paramView = new ron(localVideoInfo).a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo).h(localVideoInfo.g).N(0).a();
        nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramView.a(), false);
        return;
        this.jdField_a_of_type_Qym.e();
        a(false, (rbt)localObject3);
        a((rbt)localObject3);
        a(localVideoInfo, noy.ax);
        return;
        oee.a((AdvertisementInfo)localObject1, 15, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Qym.f();
        szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, noy.au);
        return;
        oee.a((AdvertisementInfo)localObject1, 16, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Qym.f();
        szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        a(localVideoInfo, noy.av);
        return;
        oee.a((AdvertisementInfo)localObject1, 17, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        if (a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
          noy.a(new obk().a(this.jdField_a_of_type_AndroidContentContext).a(noy.J).b(noy.N).a((AdvertisementInfo)localObject1).a());
          return;
        }
        this.jdField_a_of_type_Qym.f();
        if (localObject1 != null) {
          szl.b(this.jdField_a_of_type_AndroidAppActivity, (AdvertisementInfo)localObject1, null, 3, true, null);
        }
        a(localVideoInfo, noy.aw);
        return;
        oee.a((AdvertisementInfo)localObject1, 4001, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4001);
        return;
        oee.a((AdvertisementInfo)localObject1, 4002, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4002);
        return;
        oee.a((AdvertisementInfo)localObject1, 4007, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4007);
        return;
        oee.a((AdvertisementInfo)localObject1, 4000, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 4000);
        return;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, Boolean.valueOf(false)));
        this.j = true;
        if (!(this.jdField_a_of_type_Rbn instanceof rbi)) {
          break;
        }
        c((rbi)this.jdField_a_of_type_Rbn);
        return;
        oee.a((AdvertisementInfo)localObject1, 34, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, noy.aI);
        return;
        oee.a((AdvertisementInfo)localObject1, 35, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, noy.aH);
        return;
        oee.a((AdvertisementInfo)localObject1, 37, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, noy.aJ);
        return;
        oee.a((AdvertisementInfo)localObject1, 2003, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 2003);
        return;
        oee.a((AdvertisementInfo)localObject1, 2004, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, 2004);
        return;
        oee.a((AdvertisementInfo)localObject1, 18, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        a(localVideoInfo, (AdvertisementInfo)localObject1, noy.aK);
        return;
        if (TextUtils.isEmpty(localVideoInfo.u)) {
          break;
        }
        RIJRedPacketManager.a().a(this.jdField_a_of_type_AndroidAppActivity, 4, localVideoInfo.u, localVideoInfo.g, new rbb(this), false, null);
        paramView = new ron(localVideoInfo).a(localVideoInfo).h(localVideoInfo.g).n(1).a();
        nrt.a(null, "", "0X800ABBA", "0X800ABBA", 0, 0, "", "", localVideoInfo.g, paramView.a(), false);
        return;
        localVideoInfo = null;
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    rbl localrbl = (rbl)paramView.getTag();
    VideoInfo localVideoInfo = null;
    if ((localrbl instanceof rbt))
    {
      localVideoInfo = ((rbt)localrbl).jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if ((this.jdField_a_of_type_Rbn != null) && (this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs != null) && (localVideoInfo == this.jdField_a_of_type_Rbn.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {}
    }
    while (localVideoInfo == null) {
      return false;
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (ohq.b() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      a(localVideoInfo, true, bool);
      if (this.jdField_a_of_type_Rgn != null) {
        this.jdField_a_of_type_Rgn.a(2, localVideoInfo, 0L);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     raw
 * JD-Core Version:    0.7.0.1
 */