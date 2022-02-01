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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager;", "", "context", "Landroid/app/Activity;", "sessionId", "", "fromType", "", "dataList", "", "Lcom/tencent/biz/pubaccount/VideoInfo;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "columnDataManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;", "action", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "(Landroid/app/Activity;Ljava/lang/String;ILjava/util/List;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;)V", "getAction", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "animFlagArray", "Landroid/util/SparseBooleanArray;", "animing", "", "getColumnDataManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;", "getContext", "()Landroid/app/Activity;", "getDataList", "()Ljava/util/List;", "getFromType", "()I", "interval", "lightLineLottie", "Lcom/tencent/biz/pubaccount/readinjoy/drawable/ReadInJoyLottieDrawable;", "onColumnSubscribeChangeObserver", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/managecolumn/ColumnSubscribeChangeObserver;", "playingHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter$ShortVideoItemHolder;", "getSessionId", "()Ljava/lang/String;", "targetPercent", "", "getViolaTopicVideoParam", "Lorg/json/JSONObject;", "data", "videoInfo", "playingVideoHolder", "initView", "", "videoHolder", "jumpToColumnPlay", "onCenterViewChanged", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter$VideoItemHolder;", "onColumnClick", "onDestory", "onProgressChanged", "currentPosMs", "", "durationMs", "onSubscribeBtnClick", "performAnim", "refreshColumnBanner", "refreshColumnData", "refreshColumnIcon", "videoColumnInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;", "refreshColumnText", "refreshFollowState", "updateAllSubscribeData", "columnId", "subscribed", "Companion", "IVideoColumnBannerAction", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rvx
{
  public static final rvy a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private pka jdField_a_of_type_Pka;
  private final roq jdField_a_of_type_Roq;
  @Nullable
  private final rvz jdField_a_of_type_Rvz;
  @NotNull
  private final rwy jdField_a_of_type_Rwy;
  private rxv jdField_a_of_type_Rxv;
  @NotNull
  private final shg jdField_a_of_type_Shg;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  static
  {
    jdField_a_of_type_Rvy = new rvy(null);
  }
  
  public rvx(@NotNull Activity paramActivity, @NotNull String paramString, int paramInt, @NotNull List<? extends VideoInfo> paramList, @NotNull rwy paramrwy, @NotNull shg paramshg, @Nullable rvz paramrvz)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Rwy = paramrwy;
    this.jdField_a_of_type_Shg = paramshg;
    this.jdField_a_of_type_Rvz = paramrvz;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Roq = ((roq)new rwb(this));
    this.jdField_a_of_type_Int = Aladdin.getConfig(331).getIntegerFromString("videodetail_column_animation_videocount", 5);
    this.jdField_a_of_type_Float = Aladdin.getConfig(331).getFloatFromString("videodetail_column_animation_playprogress", 0.5F);
    if (QLog.isColorLevel()) {
      QLog.d("VideoColumnBannerManager", 2, "interval=" + this.jdField_a_of_type_Int + ", targetPercent=" + this.jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_Pka = pka.a("https://kd.qpic.cn/kamlin/assets/dea93113d39b484eaa5d72605fc52344_b88d05d2.zip");
    paramActivity = this.jdField_a_of_type_Pka;
    if (paramActivity != null) {
      paramActivity.a(false);
    }
    paramActivity = this.jdField_a_of_type_Pka;
    if (paramActivity != null) {
      paramActivity.b(false);
    }
    pmk.a().a((pmn)this.jdField_a_of_type_Roq);
  }
  
  private final void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.a != null)
    {
      rxv localrxv = this.jdField_a_of_type_Rxv;
      if (localrxv != null)
      {
        int i = a(paramVideoInfo, localrxv, 1);
        paramVideoInfo = new skc(paramVideoInfo).a(paramVideoInfo.a).h(paramVideoInfo.g).N(0).a("load_page", Integer.valueOf(i)).a();
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "VideoR5.Builder(videoInf…                 .build()");
        oat.a(pha.a(), "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramVideoInfo.a(), false);
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
          this.jdField_a_of_type_Rwy.b(localVideoInfo);
          break;
          localVideoColumnInfo = localVideoInfo.a;
        }
      }
    }
  }
  
  private final void a(VideoColumnInfo paramVideoColumnInfo, rxv paramrxv)
  {
    if (paramVideoColumnInfo.jdField_a_of_type_Boolean)
    {
      paramrxv.j.setTextColor(-7829368);
      paramVideoColumnInfo = paramrxv.j;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "videoHolder.columnBannerSubscribeBtn");
      paramVideoColumnInfo.setText((CharSequence)anni.a(2131714890));
      paramrxv.j.setBackgroundResource(2130843018);
      return;
    }
    paramrxv.j.setTextColor(-1);
    paramVideoColumnInfo = paramrxv.j;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "videoHolder.columnBannerSubscribeBtn");
    paramVideoColumnInfo.setText((CharSequence)anni.a(2131714912));
    paramrxv.j.setBackgroundResource(2130842932);
  }
  
  private final void a(rxv paramrxv)
  {
    paramrxv.jdField_a_of_type_AndroidViewViewStub.inflate();
    paramrxv.k = ((ViewGroup)paramrxv.r.findViewById(2131380650));
    paramrxv.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramrxv.k.findViewById(2131380662));
    paramrxv.f = ((TextView)paramrxv.k.findViewById(2131380664));
    paramrxv.c = ((URLImageView)paramrxv.k.findViewById(2131380643));
    paramrxv.e = paramrxv.k.findViewById(2131380668);
    paramrxv.l = ((ViewGroup)paramrxv.k.findViewById(2131380629));
    paramrxv.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramrxv.k.findViewById(2131380640));
    paramrxv.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramrxv.k.findViewById(2131380661));
    paramrxv.i = ((TextView)paramrxv.k.findViewById(2131380663));
    paramrxv.jdField_d_of_type_ComTencentImageURLImageView = ((URLImageView)paramrxv.k.findViewById(2131380642));
    paramrxv.j = ((TextView)paramrxv.k.findViewById(2131380665));
    paramrxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramrxv.r.findViewById(2131380645));
    paramrxv.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)paramrxv.k.findViewById(2131380641));
  }
  
  private final void b(VideoColumnInfo paramVideoColumnInfo, rxv paramrxv)
  {
    String str = paramVideoColumnInfo.jdField_c_of_type_JavaLangString;
    Intrinsics.checkExpressionValueIsNotNull(str, "videoColumnInfo.columnIconUrl");
    if (((CharSequence)str).length() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = bgtn.a(38.0F);
      paramVideoColumnInfo = URLDrawable.getDrawable(paramVideoColumnInfo.jdField_c_of_type_JavaLangString, i, i);
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "drawable");
      paramVideoColumnInfo.setTag(new int[] { 0, 0, bgtn.a(6.0F), 0 });
      paramVideoColumnInfo.setDecodeHandler(bgey.k);
      paramrxv.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)paramVideoColumnInfo);
      return;
    }
    paramrxv.jdField_d_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
  
  private final void b(rxv paramrxv)
  {
    Object localObject = paramrxv.k;
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label67;
      }
      localObject = paramrxv.e;
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
    localObject = ValueAnimator.ofInt(new int[] { bgtn.a(34.0F), bgtn.a(50.0F) }).setDuration(200L);
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new rwc(this, paramrxv));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new rwd(this, paramrxv));
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { bgtn.a(40.0F), bgtn.a(58.0F) }).setDuration(400L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new rwe(paramrxv, (ValueAnimator)localObject));
    localValueAnimator.addListener((Animator.AnimatorListener)new rwf(paramrxv, (ValueAnimator)localObject));
    localValueAnimator.start();
    ryx.a((View)paramrxv.jdField_g_of_type_AndroidWidgetImageView, 8, (int)400L);
    ryx.a(paramrxv.e, 0, (int)500L);
  }
  
  private final void c(VideoInfo paramVideoInfo, rxv paramrxv)
  {
    int i = 1;
    Object localObject2 = paramVideoInfo.a;
    boolean bool;
    if (localObject2 != null)
    {
      QQAppInterface localQQAppInterface = pha.a();
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
      ryx.a(localQQAppInterface, j, bool, (String)localObject1);
      j = ((VideoColumnInfo)localObject2).jdField_a_of_type_Int;
      if (((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label236;
      }
      bool = true;
      label92:
      a(paramVideoInfo, j, bool);
      a((VideoColumnInfo)localObject2, paramrxv);
      if (!((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label242;
      }
      label116:
      pmk.a().a(((VideoColumnInfo)localObject2).jdField_a_of_type_Int, i, ((VideoColumnInfo)localObject2).jdField_c_of_type_Int);
      if (!((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label247;
      }
      paramrxv = "0X800A7FB";
      label145:
      localObject2 = new skc(paramVideoInfo);
      localObject1 = pha.a();
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
    for (Object localObject1 = ((QQAppInterface)localObject1).c();; localObject1 = null)
    {
      paramVideoInfo = ((skc)localObject2).l((String)localObject1).b(paramVideoInfo.a).ab(4).a();
      oat.a(pha.a(), "", paramrxv, paramrxv, 0, 0, "", "", "", paramVideoInfo.a(), false);
      return;
      bool = false;
      break;
      localObject1 = "";
      break label63;
      bool = false;
      break label92;
      i = 2;
      break label116;
      paramrxv = "0X800A7D3";
      break label145;
    }
  }
  
  private final void c(VideoColumnInfo paramVideoColumnInfo, rxv paramrxv)
  {
    Object localObject1 = paramrxv.f;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerPrefix");
    ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.i);
    localObject1 = paramrxv.jdField_g_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerName");
    ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.jdField_b_of_type_JavaLangString);
    if ((paramVideoColumnInfo.jdField_a_of_type_Boolean) && (paramVideoColumnInfo.f > 0))
    {
      localObject1 = paramrxv.jdField_h_of_type_AndroidWidgetTextView;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerHighLightText");
      localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131716899);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources.getStr…scribed_and_update_count)");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramVideoColumnInfo.f);
      paramVideoColumnInfo = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo);
      paramVideoColumnInfo = paramrxv.i;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "videoHolder.columnBannerNormalText");
      paramVideoColumnInfo.setText((CharSequence)null);
      return;
    }
    if (paramVideoColumnInfo.jdField_a_of_type_Boolean)
    {
      localObject1 = paramrxv.jdField_h_of_type_AndroidWidgetTextView;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerHighLightText");
      ((TextView)localObject1).setText((CharSequence)(anni.a(2131714890) + "  "));
      paramrxv = paramrxv.i;
      Intrinsics.checkExpressionValueIsNotNull(paramrxv, "videoHolder.columnBannerNormalText");
      localObject1 = StringCompanionObject.INSTANCE;
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131716900);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…olumn_banner_video_count)");
      localObject2 = new Object[1];
      localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
      paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
      paramrxv.setText((CharSequence)paramVideoColumnInfo);
      return;
    }
    localObject1 = paramrxv.jdField_h_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoHolder.columnBannerHighLightText");
    ((TextView)localObject1).setText((CharSequence)null);
    paramrxv = paramrxv.i;
    Intrinsics.checkExpressionValueIsNotNull(paramrxv, "videoHolder.columnBannerNormalText");
    localObject1 = StringCompanionObject.INSTANCE;
    localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131716901);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…unt_and_subscribed_count)");
    Object localObject2 = new Object[2];
    localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
    localObject2[1] = ryx.e(paramVideoColumnInfo.jdField_c_of_type_Int);
    paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
    Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
    paramrxv.setText((CharSequence)paramVideoColumnInfo);
  }
  
  public final int a(@NotNull VideoInfo paramVideoInfo, @NotNull rxv paramrxv, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramrxv, "playingVideoHolder");
    if (paramVideoInfo.a != null)
    {
      rvz localrvz = this.jdField_a_of_type_Rvz;
      if (localrvz != null) {
        localrvz.a();
      }
      if ((siy.a.a()) && (bmqa.E()))
      {
        this.jdField_a_of_type_Shg.a(String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int), (Function1)new VideoColumnBannerManager.jumpToColumnPlay.1(this, paramrxv, paramVideoInfo, paramInt));
        return 2;
      }
      tlg.a((Context)this.jdField_a_of_type_AndroidAppActivity, "", "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&v_bid=3740&hideNav=1&statusColor=1&v_present_titleHeight=44&v_nav_immer=1&rowkey=" + paramVideoInfo.g + "&topicId=" + String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int), null);
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
  public final JSONObject a(@NotNull String paramString, @NotNull VideoInfo paramVideoInfo, @NotNull rxv paramrxv, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramrxv, "playingVideoHolder");
    JSONObject localJSONObject = new JSONObject();
    paramString = localJSONObject.put("columnData", paramString);
    Object localObject = this.jdField_a_of_type_Shg;
    VideoColumnInfo localVideoColumnInfo = paramVideoInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(localVideoColumnInfo, "videoInfo.videoColumnInfo");
    paramString.put("columnInfo", ((shg)localObject).a(localVideoColumnInfo));
    int i = paramrxv.jdField_d_of_type_Int;
    localObject = ryx.b(this.jdField_a_of_type_AndroidAppActivity);
    paramString = ryx.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, i);
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
    if (paramrxv.jdField_a_of_type_Sar != null)
    {
      paramString = paramrxv.jdField_a_of_type_Sar.a;
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
      if (!siy.a.a()) {
        break label383;
      }
    }
    label372:
    label378:
    label383:
    for (i = 1;; i = 0)
    {
      localJSONObject.put("isSuperPlayer", i);
      localJSONObject.put("videoArticleModel", sia.a(paramVideoInfo, null));
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
    pmk.a().b((pmn)this.jdField_a_of_type_Roq);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull rxv paramrxv)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramrxv, "videoHolder");
    Object localObject = paramrxv.k;
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      i = 1;
      localObject = paramVideoInfo.a;
      if ((localObject == null) || (((VideoColumnInfo)localObject).e != 2) || (i != 0)) {
        break label71;
      }
      b(paramVideoInfo, paramrxv);
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
    a(paramVideoInfo, paramrxv);
  }
  
  public final void a(@NotNull rxy paramrxy)
  {
    Intrinsics.checkParameterIsNotNull(paramrxy, "videoHolder");
    if (!(paramrxy instanceof rxv)) {
      paramrxy = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Rxv = ((rxv)paramrxy);
      paramrxy = this.jdField_a_of_type_Rxv;
      if (paramrxy != null)
      {
        paramrxy = paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (paramrxy != null) {
          paramrxy.setVisibility(8);
        }
      }
      paramrxy = this.jdField_a_of_type_Rxv;
      if (paramrxy != null)
      {
        paramrxy = paramrxy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
        if (paramrxy != null) {
          paramrxy.setImageDrawable((Drawable)this.jdField_a_of_type_Pka);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public final void a(@NotNull rxy paramrxy, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramrxy, "videoHolder");
    int i = paramrxy.jdField_b_of_type_Int;
    if ((this.jdField_b_of_type_Int == 124) && (i == 0)) {}
    for (;;)
    {
      return;
      if (!(paramrxy instanceof rxv)) {}
      for (rxy localrxy = null; (rxv)localrxy != null; localrxy = paramrxy)
      {
        if ((this.jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i / this.jdField_a_of_type_Int)) && (paramLong2 > 0L) && ((float)paramLong1 / (float)paramLong2 > this.jdField_a_of_type_Float))
        {
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(i / this.jdField_a_of_type_Int, true);
          b((rxv)paramrxy);
        }
        return;
      }
    }
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull rxv paramrxv)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramrxv, "videoHolder");
    Object localObject = paramVideoInfo.a;
    if ((localObject != null) && (((VideoColumnInfo)localObject).e == 2))
    {
      if (paramrxv.k == null) {
        a(paramrxv);
      }
      localObject = paramrxv.e;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnExpandBannerBg");
      ((View)localObject).setVisibility(8);
      localObject = paramrxv.jdField_g_of_type_AndroidWidgetImageView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerArrow");
      ((ImageView)localObject).setVisibility(0);
      localObject = paramrxv.k;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBanner");
      ((ViewGroup)localObject).getLayoutParams().height = bgtn.a(40.0F);
      paramrxv.k.setOnClickListener((View.OnClickListener)new rwg(this, paramVideoInfo));
      localObject = paramrxv.k;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBanner");
      ((ViewGroup)localObject).setVisibility(0);
      localObject = paramrxv.j;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerSubscribeBtn");
      ((TextView)localObject).setVisibility(8);
      paramrxv.j.setOnClickListener((View.OnClickListener)new rwh(this, paramVideoInfo, paramrxv));
      localObject = paramrxv.c;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerLogo");
      ((URLImageView)localObject).setVisibility(0);
      localObject = paramrxv.jdField_d_of_type_ComTencentImageURLImageView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerIcon");
      ((URLImageView)localObject).setVisibility(8);
      localObject = paramrxv.f;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerPrefix");
      localLayoutParams = ((TextView)localObject).getLayoutParams();
      localObject = localLayoutParams;
      if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        localObject = null;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      if (localObject != null) {
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = bgtn.a(34.0F);
      }
      localObject = paramrxv.jdField_h_of_type_AndroidWidgetTextView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerHighLightText");
      ((TextView)localObject).setVisibility(8);
      localObject = paramrxv.i;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerNormalText");
      ((TextView)localObject).setVisibility(8);
      localObject = paramrxv.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerLightLine");
      ((KandianUrlImageView)localObject).setVisibility(8);
      localObject = paramrxv.jdField_h_of_type_AndroidWidgetImageView;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.columnBannerBlackArrow");
      ((ImageView)localObject).setVisibility(8);
      paramrxv.f.setTextColor(-1186049);
      paramrxv.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-1186049);
      paramrxv.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130843050);
      localObject = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoInfo.videoColumnInfo");
      c((VideoColumnInfo)localObject, paramrxv);
      localObject = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoInfo.videoColumnInfo");
      b((VideoColumnInfo)localObject, paramrxv);
      paramVideoInfo = paramVideoInfo.a;
      Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.videoColumnInfo");
      a(paramVideoInfo, paramrxv);
      ryx.a((View)paramrxv.k, 200);
    }
    while (paramrxv.k == null)
    {
      ViewGroup.LayoutParams localLayoutParams;
      return;
    }
    paramVideoInfo = paramrxv.k;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoHolder.columnBanner");
    paramVideoInfo.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvx
 * JD-Core Version:    0.7.0.1
 */