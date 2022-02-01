import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager.jumpToColumnPlay.1;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager;", "", "context", "Landroid/app/Activity;", "sessionId", "", "fromType", "", "dataList", "", "Lcom/tencent/biz/pubaccount/VideoInfo;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "columnDataManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;", "action", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "(Landroid/app/Activity;Ljava/lang/String;ILjava/util/List;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;)V", "getAction", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "animFlagArray", "Landroid/util/SparseBooleanArray;", "animing", "", "getColumnDataManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;", "getContext", "()Landroid/app/Activity;", "getDataList", "()Ljava/util/List;", "getFromType", "()I", "interval", "lightLineLottie", "Lcom/tencent/biz/pubaccount/readinjoy/drawable/ReadInJoyLottieDrawable;", "onColumnSubscribeChangeObserver", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/managecolumn/ColumnSubscribeChangeObserver;", "playingHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter$ShortVideoItemHolder;", "getSessionId", "()Ljava/lang/String;", "targetPercent", "", "getViolaTopicVideoParam", "Lorg/json/JSONObject;", "data", "videoInfo", "playingVideoHolder", "initView", "", "videoHolder", "jumpToColumnPlay", "videoFromType", "onCenterViewChanged", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter$VideoItemHolder;", "onColumnClick", "onDestory", "onProgressChanged", "currentPosMs", "", "durationMs", "onSubscribeBtnClick", "performAnim", "refreshColumnBanner", "refreshColumnData", "refreshColumnIcon", "videoColumnInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;", "refreshColumnText", "refreshFollowState", "updateAllSubscribeData", "columnId", "subscribed", "Companion", "IVideoColumnBannerAction", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rtv
{
  public static final rtw a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private pid jdField_a_of_type_Pid;
  private final rmm jdField_a_of_type_Rmm;
  @Nullable
  private final rtx jdField_a_of_type_Rtx;
  @NotNull
  private final ruw jdField_a_of_type_Ruw;
  private rvs jdField_a_of_type_Rvs;
  @NotNull
  private final sfo jdField_a_of_type_Sfo;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  static
  {
    jdField_a_of_type_Rtw = new rtw(null);
  }
  
  public rtv(@NotNull Activity paramActivity, @NotNull String paramString, int paramInt, @NotNull List<? extends VideoInfo> paramList, @NotNull ruw paramruw, @NotNull sfo paramsfo, @Nullable rtx paramrtx)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Ruw = paramruw;
    this.jdField_a_of_type_Sfo = paramsfo;
    this.jdField_a_of_type_Rtx = paramrtx;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Rmm = ((rmm)new rtz(this));
    this.jdField_a_of_type_Int = Aladdin.getConfig(331).getIntegerFromString("videodetail_column_animation_videocount", 5);
    this.jdField_a_of_type_Float = Aladdin.getConfig(331).getFloatFromString("videodetail_column_animation_playprogress", 0.5F);
    if (QLog.isColorLevel()) {
      QLog.d("VideoColumnBannerManager", 2, "interval=" + this.jdField_a_of_type_Int + ", targetPercent=" + this.jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_Pid = pid.a("https://kd.qpic.cn/kamlin/assets/dea93113d39b484eaa5d72605fc52344_b88d05d2.zip");
    paramActivity = this.jdField_a_of_type_Pid;
    if (paramActivity != null) {
      paramActivity.a(false);
    }
    paramActivity = this.jdField_a_of_type_Pid;
    if (paramActivity != null) {
      paramActivity.b(false);
    }
    pkp.a().a((pkt)this.jdField_a_of_type_Rmm);
  }
  
  private final void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.a != null)
    {
      rvs localrvs = this.jdField_a_of_type_Rvs;
      if (localrvs != null)
      {
        int i = a(paramVideoInfo, localrvs, 1, this.jdField_b_of_type_Int);
        paramVideoInfo = new sie(paramVideoInfo).a(paramVideoInfo.a).i(paramVideoInfo.g).M(0).a("load_page", Integer.valueOf(i)).a();
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "VideoR5.Builder(videoInf…                 .build()");
        odq.a(pay.a(), "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramVideoInfo.a(), false);
      }
    }
  }
  
  private final void a(VideoInfo paramVideoInfo, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label128:
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if ((localVideoInfo.a != null) && (localVideoInfo.a.jdField_a_of_type_Int == paramInt))
      {
        localVideoInfo.a.jdField_a_of_type_Boolean = paramBoolean;
        VideoColumnInfo localVideoColumnInfo;
        if (paramBoolean) {
          localVideoColumnInfo = localVideoInfo.a;
        }
        for (localVideoColumnInfo.jdField_c_of_type_Int += 1;; localVideoColumnInfo.jdField_c_of_type_Int -= 1)
        {
          if (!(Intrinsics.areEqual(paramVideoInfo, localVideoInfo) ^ true)) {
            break label128;
          }
          this.jdField_a_of_type_Ruw.b(localVideoInfo);
          break;
          localVideoColumnInfo = localVideoInfo.a;
        }
      }
    }
  }
  
  private final void a(VideoColumnInfo paramVideoColumnInfo, rvs paramrvs)
  {
    if (paramVideoColumnInfo.jdField_a_of_type_Boolean)
    {
      paramrvs.i.setTextColor(-7829368);
      paramVideoColumnInfo = paramrvs.i;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "videoHolder.columnBannerSubscribeBtn");
      paramVideoColumnInfo.setText((CharSequence)amtj.a(2131715233));
      paramrvs.i.setBackgroundResource(2130843092);
      return;
    }
    paramrvs.i.setTextColor(-1);
    paramVideoColumnInfo = paramrvs.i;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "videoHolder.columnBannerSubscribeBtn");
    paramVideoColumnInfo.setText((CharSequence)amtj.a(2131715255));
    paramrvs.i.setBackgroundResource(2130843006);
  }
  
  private final void a(rvs paramrvs)
  {
    paramrvs.jdField_a_of_type_AndroidViewViewStub.inflate();
    paramrvs.j = ((ViewGroup)paramrvs.r.findViewById(2131380559));
    paramrvs.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramrvs.j.findViewById(2131380567));
    paramrvs.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramrvs.j.findViewById(2131380569));
    paramrvs.b = ((URLImageView)paramrvs.j.findViewById(2131380553));
    paramrvs.jdField_e_of_type_AndroidViewView = paramrvs.j.findViewById(2131380573);
    paramrvs.k = ((ViewGroup)paramrvs.j.findViewById(2131380542));
    paramrvs.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramrvs.j.findViewById(2131380550));
    paramrvs.g = ((TextView)paramrvs.j.findViewById(2131380566));
    paramrvs.h = ((TextView)paramrvs.j.findViewById(2131380568));
    paramrvs.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)paramrvs.j.findViewById(2131380552));
    paramrvs.i = ((TextView)paramrvs.j.findViewById(2131380570));
    paramrvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramrvs.r.findViewById(2131380555));
    paramrvs.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramrvs.j.findViewById(2131380551));
  }
  
  private final void b(VideoColumnInfo paramVideoColumnInfo, rvs paramrvs)
  {
    String str = paramVideoColumnInfo.jdField_c_of_type_JavaLangString;
    Intrinsics.checkExpressionValueIsNotNull(str, "videoColumnInfo.columnIconUrl");
    if (((CharSequence)str).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = ViewUtils.dip2px(38.0F);
      paramVideoColumnInfo = URLDrawable.getDrawable(paramVideoColumnInfo.jdField_c_of_type_JavaLangString, i, i);
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "drawable");
      paramVideoColumnInfo.setTag(new int[] { 0, 0, ViewUtils.dip2px(6.0F), 0 });
      paramVideoColumnInfo.setDecodeHandler(bfol.k);
      paramrvs.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)paramVideoColumnInfo);
      return;
    }
    paramrvs.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
  
  private final void b(rvs paramrvs)
  {
    Object localObject = paramrvs.j;
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label67;
      }
      localObject = paramrvs.jdField_e_of_type_AndroidViewView;
      if ((localObject == null) || (((View)localObject).getVisibility() != 0)) {
        break label67;
      }
    }
    label67:
    for (int j = 1;; j = 0)
    {
      if ((!this.jdField_a_of_type_Boolean) && (i != 0) && (j == 0)) {
        break label72;
      }
      return;
      i = 0;
      break;
    }
    label72:
    this.jdField_a_of_type_Boolean = true;
    localObject = ValueAnimator.ofInt(new int[] { ViewUtils.dip2px(34.0F), ViewUtils.dip2px(50.0F) }).setDuration(200L);
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new rua(this, paramrvs));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new rub(this, paramrvs));
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ViewUtils.dip2px(40.0F), ViewUtils.dip2px(58.0F) }).setDuration(400L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ruc(paramrvs, (ValueAnimator)localObject));
    localValueAnimator.addListener((Animator.AnimatorListener)new rud(paramrvs, (ValueAnimator)localObject));
    localValueAnimator.start();
    rwv.a((View)paramrvs.jdField_e_of_type_AndroidWidgetImageView, 8, (int)400L);
    rwv.a(paramrvs.jdField_e_of_type_AndroidViewView, 0, (int)500L);
  }
  
  private final void c(VideoInfo paramVideoInfo, rvs paramrvs)
  {
    int i = 1;
    Object localObject2 = paramVideoInfo.a;
    boolean bool;
    if (localObject2 != null)
    {
      QQAppInterface localQQAppInterface = pay.a();
      int j = ((VideoColumnInfo)localObject2).jdField_a_of_type_Int;
      if (((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label222;
      }
      bool = true;
      if (paramVideoInfo == null) {
        break label228;
      }
      localObject1 = paramVideoInfo.a;
      if (localObject1 == null) {
        break label228;
      }
      localObject1 = ((VideoColumnInfo)localObject1).jdField_c_of_type_JavaLangString;
      if (localObject1 == null) {
        break label228;
      }
      label63:
      rwv.a(localQQAppInterface, j, bool, (String)localObject1);
      j = ((VideoColumnInfo)localObject2).jdField_a_of_type_Int;
      if (((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label236;
      }
      bool = true;
      label92:
      a(paramVideoInfo, j, bool);
      a((VideoColumnInfo)localObject2, paramrvs);
      if (!((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label242;
      }
      label116:
      pkp.a().a(((VideoColumnInfo)localObject2).jdField_a_of_type_Int, i, ((VideoColumnInfo)localObject2).jdField_c_of_type_Int);
      if (!((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label247;
      }
      paramrvs = "0X800A7FB";
      label145:
      localObject2 = new sie(paramVideoInfo);
      localObject1 = pay.a();
      if (localObject1 == null) {
        break label254;
      }
    }
    label222:
    label228:
    label236:
    label242:
    label247:
    label254:
    for (Object localObject1 = ((QQAppInterface)localObject1).getCurrentUin();; localObject1 = null)
    {
      paramVideoInfo = ((sie)localObject2).m((String)localObject1).b(paramVideoInfo.a).aa(4).a();
      odq.a(pay.a(), "", paramrvs, paramrvs, 0, 0, "", "", "", paramVideoInfo.a(), false);
      return;
      bool = false;
      break;
      localObject1 = "";
      break label63;
      bool = false;
      break label92;
      i = 2;
      break label116;
      paramrvs = "0X800A7D3";
      break label145;
    }
  }
  
  private final void c(VideoColumnInfo paramVideoColumnInfo, rvs paramrvs)
  {
    Object localObject1 = paramrvs.jdField_e_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerPrefix");
    ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.i);
    localObject1 = paramrvs.jdField_f_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerName");
    ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.jdField_b_of_type_JavaLangString);
    if ((paramVideoColumnInfo.jdField_a_of_type_Boolean) && (paramVideoColumnInfo.f > 0))
    {
      localObject1 = paramrvs.g;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerHighLightText");
      localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717250);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources.getStr…scribed_and_update_count)");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramVideoColumnInfo.f);
      paramVideoColumnInfo = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo);
      paramVideoColumnInfo = paramrvs.h;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "videoHolder.columnBannerNormalText");
      paramVideoColumnInfo.setText((CharSequence)null);
      return;
    }
    if (paramVideoColumnInfo.jdField_a_of_type_Boolean)
    {
      localObject1 = paramrvs.g;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerHighLightText");
      ((TextView)localObject1).setText((CharSequence)(amtj.a(2131715233) + "  "));
      paramrvs = paramrvs.h;
      Intrinsics.checkExpressionValueIsNotNull(paramrvs, "videoHolder.columnBannerNormalText");
      localObject1 = StringCompanionObject.INSTANCE;
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717251);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…olumn_banner_video_count)");
      localObject2 = new Object[1];
      localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
      paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
      paramrvs.setText((CharSequence)paramVideoColumnInfo);
      return;
    }
    localObject1 = paramrvs.g;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerHighLightText");
    ((TextView)localObject1).setText((CharSequence)null);
    paramrvs = paramrvs.h;
    Intrinsics.checkExpressionValueIsNotNull(paramrvs, "videoHolder.columnBannerNormalText");
    localObject1 = StringCompanionObject.INSTANCE;
    localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717252);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…unt_and_subscribed_count)");
    Object localObject2 = new Object[2];
    localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
    localObject2[1] = rwv.e(paramVideoColumnInfo.jdField_c_of_type_Int);
    paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
    Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
    paramrvs.setText((CharSequence)paramVideoColumnInfo);
  }
  
  public final int a(@NotNull VideoInfo paramVideoInfo, @NotNull rvs paramrvs, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramrvs, "playingVideoHolder");
    if (paramVideoInfo.a != null)
    {
      rtx localrtx = this.jdField_a_of_type_Rtx;
      if (localrtx != null) {
        localrtx.a();
      }
      if ((shg.a.a()) && (bkwm.f(paramInt2)))
      {
        this.jdField_a_of_type_Sfo.a(String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int), (Function1)new VideoColumnBannerManager.jumpToColumnPlay.1(this, paramrvs, paramVideoInfo, paramInt1, paramInt2));
        return 2;
      }
      tgc.a((Context)this.jdField_a_of_type_AndroidAppActivity, "", "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&v_bid=3740&hideNav=1&statusColor=1&v_present_titleHeight=44&v_nav_immer=1&rowkey=" + paramVideoInfo.g + "&topicId=" + String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int), null);
      return 1;
    }
    return 1;
  }
  
  @NotNull
  public final Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  @NotNull
  public final JSONObject a(@NotNull String paramString, @NotNull VideoInfo paramVideoInfo, @NotNull rvs paramrvs, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramrvs, "playingVideoHolder");
    JSONObject localJSONObject = new JSONObject();
    paramString = localJSONObject.put("columnData", paramString);
    Object localObject = this.jdField_a_of_type_Sfo;
    VideoColumnInfo localVideoColumnInfo = paramVideoInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(localVideoColumnInfo, "videoInfo.videoColumnInfo");
    paramString.put("columnInfo", ((sfo)localObject).a(localVideoColumnInfo));
    int i = paramrvs.jdField_d_of_type_Int;
    localObject = rwv.b(this.jdField_a_of_type_AndroidAppActivity);
    paramString = rwv.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, i);
    float f = 750.0F / localObject[0];
    localObject = new JSONObject();
    ((JSONObject)localObject).put("x", paramString.left * f);
    ((JSONObject)localObject).put("y", paramString.top * f);
    ((JSONObject)localObject).put("width", paramString.width() * f);
    ((JSONObject)localObject).put("height", paramString.height() * f);
    localJSONObject.put("videoFromFrame", localObject);
    if (QLog.isColorLevel()) {
      QLog.d("VideoColumnBannerManager", 2, "onFlingRToL: rect=" + paramString);
    }
    long l;
    if (paramrvs.jdField_a_of_type_Ryo != null)
    {
      paramString = paramrvs.jdField_a_of_type_Ryo.a;
      if (paramString != null) {
        paramString.d();
      }
      if (paramString == null) {
        break label372;
      }
      l = paramString.a() / 1000;
      label274:
      if (paramString == null) {
        break label378;
      }
      paramString = paramString.c();
      label283:
      localJSONObject.put("sessionId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("videoToken", paramString);
      if (!shg.a.a()) {
        break label383;
      }
    }
    label372:
    label378:
    label383:
    for (i = 1;; i = 0)
    {
      localJSONObject.put("isSuperPlayer", i);
      localJSONObject.put("videoArticleModel", sgi.a(paramVideoInfo, null));
      localJSONObject.put("startPlayTime", l);
      localJSONObject.put("fromType", paramInt);
      return localJSONObject;
      paramString = null;
      break;
      l = 0L;
      break label274;
      paramString = null;
      break label283;
    }
  }
  
  public final void a()
  {
    pkp.a().b((pkt)this.jdField_a_of_type_Rmm);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull rvs paramrvs)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramrvs, "videoHolder");
    Object localObject = paramrvs.j;
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      i = 1;
      localObject = paramVideoInfo.a;
      if ((localObject == null) || (((VideoColumnInfo)localObject).e != 2) || (i != 0)) {
        break label71;
      }
      b(paramVideoInfo, paramrvs);
    }
    label71:
    do
    {
      return;
      i = 0;
      break;
      localObject = paramVideoInfo.a;
    } while ((localObject == null) || (((VideoColumnInfo)localObject).e != 2));
    paramVideoInfo = paramVideoInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.videoColumnInfo");
    a(paramVideoInfo, paramrvs);
  }
  
  public final void a(@NotNull rvv paramrvv)
  {
    Intrinsics.checkParameterIsNotNull(paramrvv, "videoHolder");
    if (!(paramrvv instanceof rvs)) {
      paramrvv = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Rvs = ((rvs)paramrvv);
      paramrvv = this.jdField_a_of_type_Rvs;
      if (paramrvv != null)
      {
        paramrvv = paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (paramrvv != null) {
          paramrvv.setVisibility(8);
        }
      }
      paramrvv = this.jdField_a_of_type_Rvs;
      if (paramrvv != null)
      {
        paramrvv = paramrvv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (paramrvv != null) {
          paramrvv.setImageDrawable((Drawable)this.jdField_a_of_type_Pid);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public final void a(@NotNull rvv paramrvv, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramrvv, "videoHolder");
    int i = paramrvv.jdField_b_of_type_Int;
    if ((bkwm.g(this.jdField_b_of_type_Int)) && (i == 0)) {}
    for (;;)
    {
      return;
      if (!(paramrvv instanceof rvs)) {}
      for (rvv localrvv = null; (rvs)localrvv != null; localrvv = paramrvv)
      {
        if ((this.jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i / this.jdField_a_of_type_Int)) && (paramLong2 > 0L) && ((float)paramLong1 / (float)paramLong2 > this.jdField_a_of_type_Float))
        {
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(i / this.jdField_a_of_type_Int, true);
          b((rvs)paramrvv);
        }
        return;
      }
    }
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull rvs paramrvs)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramrvs, "videoHolder");
    Object localObject = paramVideoInfo.a;
    if ((localObject != null) && (((VideoColumnInfo)localObject).e == 2))
    {
      if (paramrvs.j == null) {
        a(paramrvs);
      }
      localObject = paramrvs.jdField_e_of_type_AndroidViewView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnExpandBannerBg");
      ((View)localObject).setVisibility(8);
      localObject = paramrvs.jdField_e_of_type_AndroidWidgetImageView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerArrow");
      ((ImageView)localObject).setVisibility(0);
      localObject = paramrvs.j;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBanner");
      ((ViewGroup)localObject).getLayoutParams().height = ViewUtils.dip2px(40.0F);
      paramrvs.j.setOnClickListener((View.OnClickListener)new rue(this, paramVideoInfo));
      localObject = paramrvs.j;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBanner");
      ((ViewGroup)localObject).setVisibility(0);
      localObject = paramrvs.i;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerSubscribeBtn");
      ((TextView)localObject).setVisibility(8);
      paramrvs.i.setOnClickListener((View.OnClickListener)new ruf(this, paramVideoInfo, paramrvs));
      localObject = paramrvs.b;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerLogo");
      ((URLImageView)localObject).setVisibility(0);
      localObject = paramrvs.jdField_d_of_type_ComTencentImageURLImageView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerIcon");
      ((URLImageView)localObject).setVisibility(8);
      localObject = paramrvs.jdField_e_of_type_AndroidWidgetTextView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerPrefix");
      localLayoutParams = ((TextView)localObject).getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        localObject = null;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      if (localObject != null) {
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = ViewUtils.dip2px(34.0F);
      }
      localObject = paramrvs.g;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerHighLightText");
      ((TextView)localObject).setVisibility(8);
      localObject = paramrvs.h;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerNormalText");
      ((TextView)localObject).setVisibility(8);
      localObject = paramrvs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerLightLine");
      ((KandianUrlImageView)localObject).setVisibility(8);
      localObject = paramrvs.jdField_f_of_type_AndroidWidgetImageView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerBlackArrow");
      ((ImageView)localObject).setVisibility(8);
      paramrvs.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1186049);
      paramrvs.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-1186049);
      paramrvs.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843124);
      localObject = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoInfo.videoColumnInfo");
      c((VideoColumnInfo)localObject, paramrvs);
      localObject = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoInfo.videoColumnInfo");
      b((VideoColumnInfo)localObject, paramrvs);
      paramVideoInfo = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.videoColumnInfo");
      a(paramVideoInfo, paramrvs);
      rwv.a((View)paramrvs.j, 200);
    }
    while (paramrvs.j == null)
    {
      ViewGroup.LayoutParams localLayoutParams;
      return;
    }
    paramVideoInfo = paramrvs.j;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoHolder.columnBanner");
    paramVideoInfo.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtv
 * JD-Core Version:    0.7.0.1
 */