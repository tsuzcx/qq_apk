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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager;", "", "context", "Landroid/app/Activity;", "sessionId", "", "fromType", "", "dataList", "", "Lcom/tencent/biz/pubaccount/VideoInfo;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "columnDataManager", "Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;", "action", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "(Landroid/app/Activity;Ljava/lang/String;ILjava/util/List;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;)V", "getAction", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$IVideoColumnBannerAction;", "getAdapter", "()Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsAdapter;", "animFlagArray", "Landroid/util/SparseBooleanArray;", "animing", "", "getColumnDataManager", "()Lcom/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnDataManager;", "getContext", "()Landroid/app/Activity;", "getDataList", "()Ljava/util/List;", "getFromType", "()I", "interval", "lightLineLottie", "Lcom/tencent/biz/pubaccount/readinjoy/drawable/ReadInJoyLottieDrawable;", "onColumnSubscribeChangeObserver", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/managecolumn/ColumnSubscribeChangeObserver;", "playingHolder", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/ShortVideoItemHolder;", "getSessionId", "()Ljava/lang/String;", "targetPercent", "", "getViolaTopicVideoParam", "Lorg/json/JSONObject;", "data", "videoInfo", "playingVideoHolder", "initView", "", "videoHolder", "jumpToColumnPlay", "videoFromType", "onCenterViewChanged", "Lcom/tencent/biz/pubaccount/readinjoy/video/videofeeds/VideoItemHolder;", "onColumnClick", "onDestory", "onProgressChanged", "currentPosMs", "", "durationMs", "onSubscribeBtnClick", "performAnim", "refreshColumnBanner", "refreshColumnData", "refreshColumnIcon", "videoColumnInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;", "refreshColumnText", "refreshFollowState", "updateAllSubscribeData", "columnId", "subscribed", "Companion", "IVideoColumnBannerAction", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sgk
{
  public static final sgl a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private pta jdField_a_of_type_Pta;
  private final rzb jdField_a_of_type_Rzb;
  @Nullable
  private final sgm jdField_a_of_type_Sgm;
  @NotNull
  private final shl jdField_a_of_type_Shl;
  @NotNull
  private final srt jdField_a_of_type_Srt;
  private swr jdField_a_of_type_Swr;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  
  static
  {
    jdField_a_of_type_Sgl = new sgl(null);
  }
  
  public sgk(@NotNull Activity paramActivity, @NotNull String paramString, int paramInt, @NotNull List<? extends VideoInfo> paramList, @NotNull shl paramshl, @NotNull srt paramsrt, @Nullable sgm paramsgm)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Shl = paramshl;
    this.jdField_a_of_type_Srt = paramsrt;
    this.jdField_a_of_type_Sgm = paramsgm;
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
    this.jdField_a_of_type_Rzb = ((rzb)new sgo(this));
    this.jdField_a_of_type_Int = Aladdin.getConfig(331).getIntegerFromString("videodetail_column_animation_videocount", 5);
    this.jdField_a_of_type_Float = Aladdin.getConfig(331).getFloatFromString("videodetail_column_animation_playprogress", 0.5F);
    if (QLog.isColorLevel()) {
      QLog.d("VideoColumnBannerManager", 2, "interval=" + this.jdField_a_of_type_Int + ", targetPercent=" + this.jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_Pta = pta.a("https://kd.qpic.cn/kamlin/assets/dea93113d39b484eaa5d72605fc52344_b88d05d2.zip");
    paramActivity = this.jdField_a_of_type_Pta;
    if (paramActivity != null) {
      paramActivity.a(false);
    }
    paramActivity = this.jdField_a_of_type_Pta;
    if (paramActivity != null) {
      paramActivity.b(false);
    }
    pvm.a().a((pvq)this.jdField_a_of_type_Rzb);
  }
  
  private final void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.a != null)
    {
      swr localswr = this.jdField_a_of_type_Swr;
      if (localswr != null)
      {
        int i = a(paramVideoInfo, localswr, 1, this.jdField_b_of_type_Int);
        paramVideoInfo = new suu(paramVideoInfo).a(paramVideoInfo.a).i(paramVideoInfo.g).M(0).a("load_page", Integer.valueOf(i)).a();
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "VideoR5.Builder(videoInf…                 .build()");
        olh.a(pnn.a(), "", "0X800AC2C", "0X800AC2C", 0, 0, "", "", "", paramVideoInfo.a(), false);
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
          this.jdField_a_of_type_Shl.a(localVideoInfo);
          break;
          localVideoColumnInfo = localVideoInfo.a;
        }
      }
    }
  }
  
  private final void a(VideoColumnInfo paramVideoColumnInfo, swr paramswr)
  {
    paramswr = paramswr.f();
    if (paramswr != null)
    {
      if (!paramVideoColumnInfo.jdField_a_of_type_Boolean) {
        break label44;
      }
      paramswr.setTextColor(-7829368);
      paramswr.setText((CharSequence)anvx.a(2131715581));
      paramswr.setBackgroundResource(2130843128);
    }
    for (;;)
    {
      return;
      label44:
      paramswr.setTextColor(-1);
      paramswr.setText((CharSequence)anvx.a(2131715603));
      paramswr.setBackgroundResource(2130843040);
    }
  }
  
  private final void a(swr paramswr)
  {
    paramswr.a().inflate();
    Object localObject = paramswr.n;
    if (localObject != null)
    {
      localObject = (ViewGroup)((ViewGroup)localObject).findViewById(2131380903);
      paramswr.a((ViewGroup)localObject);
      localObject = paramswr.n;
      if (localObject == null) {
        break label224;
      }
    }
    label224:
    for (localObject = (KandianUrlImageView)((ViewGroup)localObject).findViewById(2131380899);; localObject = null)
    {
      paramswr.a((KandianUrlImageView)localObject);
      localObject = paramswr.b();
      if (localObject != null)
      {
        paramswr.b((TextView)((ViewGroup)localObject).findViewById(2131380911));
        paramswr.a((TextView)((ViewGroup)localObject).findViewById(2131380913));
        paramswr.a((URLImageView)((ViewGroup)localObject).findViewById(2131380897));
        paramswr.a(((ViewGroup)localObject).findViewById(2131380918));
        paramswr.b((ViewGroup)((ViewGroup)localObject).findViewById(2131380883));
        paramswr.a((ImageView)((ViewGroup)localObject).findViewById(2131380894));
        paramswr.c((TextView)((ViewGroup)localObject).findViewById(2131380910));
        paramswr.d((TextView)((ViewGroup)localObject).findViewById(2131380912));
        paramswr.b((URLImageView)((ViewGroup)localObject).findViewById(2131380896));
        paramswr.e((TextView)((ViewGroup)localObject).findViewById(2131380914));
        paramswr.b((ImageView)((ViewGroup)localObject).findViewById(2131380895));
      }
      return;
      localObject = null;
      break;
    }
  }
  
  private final void b(VideoColumnInfo paramVideoColumnInfo, swr paramswr)
  {
    String str = paramVideoColumnInfo.jdField_c_of_type_JavaLangString;
    Intrinsics.checkExpressionValueIsNotNull(str, "videoColumnInfo.columnIconUrl");
    int i;
    if (((CharSequence)str).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label115;
      }
      i = ViewUtils.dip2px(38.0F);
      paramVideoColumnInfo = URLDrawable.getDrawable(paramVideoColumnInfo.jdField_c_of_type_JavaLangString, i, i);
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "drawable");
      paramVideoColumnInfo.setTag(new int[] { 0, 0, ViewUtils.dip2px(6.0F), 0 });
      paramVideoColumnInfo.setDecodeHandler(bgxc.k);
      paramswr = paramswr.c();
      if (paramswr != null) {
        paramswr.setImageDrawable((Drawable)paramVideoColumnInfo);
      }
    }
    label115:
    do
    {
      return;
      i = 0;
      break;
      paramVideoColumnInfo = paramswr.c();
    } while (paramVideoColumnInfo == null);
    paramVideoColumnInfo.setImageDrawable(null);
  }
  
  private final void b(swr paramswr)
  {
    Object localObject = paramswr.b();
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label67;
      }
      localObject = paramswr.a();
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
    ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new sgp(this, paramswr));
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new sgq(this, paramswr));
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ViewUtils.dip2px(40.0F), ViewUtils.dip2px(58.0F) }).setDuration(400L);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new sgr(paramswr, (ValueAnimator)localObject));
    localValueAnimator.addListener((Animator.AnimatorListener)new sgs(paramswr, (ValueAnimator)localObject));
    localValueAnimator.start();
    six.a((View)paramswr.b(), 8, (int)400L);
    six.a(paramswr.a(), 0, (int)500L);
  }
  
  private final void c(VideoInfo paramVideoInfo, swr paramswr)
  {
    int i = 1;
    Object localObject2 = paramVideoInfo.a;
    boolean bool;
    if (localObject2 != null)
    {
      QQAppInterface localQQAppInterface = pnn.a();
      int j = ((VideoColumnInfo)localObject2).jdField_a_of_type_Int;
      if (((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label218;
      }
      bool = true;
      localObject1 = paramVideoInfo.a;
      if (localObject1 == null) {
        break label224;
      }
      localObject1 = ((VideoColumnInfo)localObject1).jdField_c_of_type_JavaLangString;
      if (localObject1 == null) {
        break label224;
      }
      label59:
      six.a(localQQAppInterface, j, bool, (String)localObject1);
      j = ((VideoColumnInfo)localObject2).jdField_a_of_type_Int;
      if (((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label232;
      }
      bool = true;
      label88:
      a(paramVideoInfo, j, bool);
      a((VideoColumnInfo)localObject2, paramswr);
      if (!((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label238;
      }
      label112:
      pvm.a().a(((VideoColumnInfo)localObject2).jdField_a_of_type_Int, i, ((VideoColumnInfo)localObject2).jdField_c_of_type_Int);
      if (!((VideoColumnInfo)localObject2).jdField_a_of_type_Boolean) {
        break label243;
      }
      paramswr = "0X800A7FB";
      label141:
      localObject2 = new suu(paramVideoInfo);
      localObject1 = pnn.a();
      if (localObject1 == null) {
        break label250;
      }
    }
    label218:
    label224:
    label232:
    label238:
    label243:
    label250:
    for (Object localObject1 = ((QQAppInterface)localObject1).getCurrentUin();; localObject1 = null)
    {
      paramVideoInfo = ((suu)localObject2).m((String)localObject1).b(paramVideoInfo.a).aa(4).a();
      olh.a(pnn.a(), "", paramswr, paramswr, 0, 0, "", "", "", paramVideoInfo.a(), false);
      return;
      bool = false;
      break;
      localObject1 = "";
      break label59;
      bool = false;
      break label88;
      i = 2;
      break label112;
      paramswr = "0X800A7D3";
      break label141;
    }
  }
  
  private final void c(VideoColumnInfo paramVideoColumnInfo, swr paramswr)
  {
    Object localObject1 = paramswr.b();
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.i);
    }
    localObject1 = paramswr.c();
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo.jdField_b_of_type_JavaLangString);
    }
    if ((paramVideoColumnInfo.jdField_a_of_type_Boolean) && (paramVideoColumnInfo.f > 0))
    {
      localObject1 = paramswr.d();
      if (localObject1 != null)
      {
        localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717614);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources.getStr…scribed_and_update_count)");
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramVideoColumnInfo.f);
        paramVideoColumnInfo = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
        Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)paramVideoColumnInfo);
      }
      paramVideoColumnInfo = paramswr.e();
      if (paramVideoColumnInfo != null) {
        paramVideoColumnInfo.setText((CharSequence)null);
      }
    }
    do
    {
      do
      {
        return;
        if (!paramVideoColumnInfo.jdField_a_of_type_Boolean) {
          break;
        }
        localObject1 = paramswr.d();
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)(anvx.a(2131715581) + "  "));
        }
        paramswr = paramswr.e();
      } while (paramswr == null);
      localObject1 = StringCompanionObject.INSTANCE;
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717615);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…olumn_banner_video_count)");
      localObject2 = new Object[1];
      localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
      paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
      paramswr.setText((CharSequence)paramVideoColumnInfo);
      return;
      localObject1 = paramswr.d();
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)null);
      }
      paramswr = paramswr.e();
    } while (paramswr == null);
    localObject1 = StringCompanionObject.INSTANCE;
    localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131717616);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "context.resources.getStr…unt_and_subscribed_count)");
    Object localObject2 = new Object[2];
    localObject2[0] = Integer.valueOf(paramVideoColumnInfo.jdField_b_of_type_Int);
    localObject2[1] = six.e(paramVideoColumnInfo.jdField_c_of_type_Int);
    paramVideoColumnInfo = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
    Intrinsics.checkExpressionValueIsNotNull(paramVideoColumnInfo, "java.lang.String.format(format, *args)");
    paramswr.setText((CharSequence)paramVideoColumnInfo);
  }
  
  public final int a(@NotNull VideoInfo paramVideoInfo, @NotNull swr paramswr, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramswr, "playingVideoHolder");
    if (paramVideoInfo.a != null)
    {
      sgm localsgm = this.jdField_a_of_type_Sgm;
      if (localsgm != null) {
        localsgm.a();
      }
      if ((stw.a.a()) && (bmhv.f(paramInt2)))
      {
        this.jdField_a_of_type_Srt.a(String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int), (Function1)new VideoColumnBannerManager.jumpToColumnPlay.1(this, paramswr, paramVideoInfo, paramInt1, paramInt2));
        return 2;
      }
      tto.a((Context)this.jdField_a_of_type_AndroidAppActivity, "", "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&v_bid=3740&hideNav=1&statusColor=1&v_present_titleHeight=44&v_nav_immer=1&rowkey=" + paramVideoInfo.g + "&topicId=" + String.valueOf(paramVideoInfo.a.jdField_a_of_type_Int), null);
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
  public final JSONObject a(@NotNull String paramString, @NotNull VideoInfo paramVideoInfo, @NotNull swr paramswr, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "data");
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramswr, "playingVideoHolder");
    JSONObject localJSONObject = new JSONObject();
    paramString = localJSONObject.put("columnData", paramString);
    Object localObject = this.jdField_a_of_type_Srt;
    VideoColumnInfo localVideoColumnInfo = paramVideoInfo.a;
    Intrinsics.checkExpressionValueIsNotNull(localVideoColumnInfo, "videoInfo.videoColumnInfo");
    paramString.put("columnInfo", ((srt)localObject).a(localVideoColumnInfo));
    int i = paramswr.d;
    localObject = six.b(this.jdField_a_of_type_AndroidAppActivity);
    paramString = six.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoInfo, i);
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
    paramString = paramswr.a;
    long l;
    if (paramString != null)
    {
      paramString = paramString.a;
      if (paramString != null) {
        paramString.d();
      }
      if (paramString == null) {
        break label366;
      }
      l = paramString.a();
      label268:
      if (paramString == null) {
        break label372;
      }
      paramString = paramString.c();
      label277:
      localJSONObject.put("sessionId", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("videoToken", paramString);
      if (!stw.a.a()) {
        break label377;
      }
    }
    label366:
    label372:
    label377:
    for (i = 1;; i = 0)
    {
      localJSONObject.put("isSuperPlayer", i);
      localJSONObject.put("videoArticleModel", ssn.a(paramVideoInfo, null));
      localJSONObject.put("startPlayTime", l);
      localJSONObject.put("fromType", paramInt);
      return localJSONObject;
      paramString = null;
      break;
      l = 0L;
      break label268;
      paramString = null;
      break label277;
    }
  }
  
  public final void a()
  {
    pvm.a().b((pvq)this.jdField_a_of_type_Rzb);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull swr paramswr)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramswr, "videoHolder");
    Object localObject = paramswr.b();
    int i;
    if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
    {
      i = 1;
      localObject = paramVideoInfo.a;
      if ((localObject == null) || (((VideoColumnInfo)localObject).e != 2) || (i != 0)) {
        break label71;
      }
      b(paramVideoInfo, paramswr);
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
    a(paramVideoInfo, paramswr);
  }
  
  public final void a(@NotNull swu paramswu)
  {
    Intrinsics.checkParameterIsNotNull(paramswu, "videoHolder");
    if (!(paramswu instanceof swr)) {
      paramswu = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Swr = ((swr)paramswu);
      paramswu = this.jdField_a_of_type_Swr;
      if (paramswu != null)
      {
        paramswu = paramswu.a();
        if (paramswu != null) {
          paramswu.setVisibility(8);
        }
      }
      paramswu = this.jdField_a_of_type_Swr;
      if (paramswu != null)
      {
        paramswu = paramswu.a();
        if (paramswu != null) {
          paramswu.setImageDrawable((Drawable)this.jdField_a_of_type_Pta);
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public final void a(@NotNull swu paramswu, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramswu, "videoHolder");
    int i = paramswu.jdField_b_of_type_Int;
    if ((bmhv.g(this.jdField_b_of_type_Int)) && (i == 0)) {}
    for (;;)
    {
      return;
      if (!(paramswu instanceof swr)) {}
      for (swu localswu = null; (swr)localswu != null; localswu = paramswu)
      {
        if ((this.jdField_a_of_type_Int > 0) && (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i / this.jdField_a_of_type_Int)) && (paramLong2 > 0L) && ((float)paramLong1 / (float)paramLong2 > this.jdField_a_of_type_Float))
        {
          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.append(i / this.jdField_a_of_type_Int, true);
          b((swr)paramswu);
        }
        return;
      }
    }
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull swr paramswr)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramswr, "videoHolder");
    Object localObject1 = paramVideoInfo.a;
    if ((localObject1 != null) && (((VideoColumnInfo)localObject1).e == 2))
    {
      if (paramswr.b() == null) {
        a(paramswr);
      }
      localObject1 = paramswr.a();
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = paramswr.b();
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = paramswr.b();
      if (localObject1 != null)
      {
        localObject1 = ((ViewGroup)localObject1).getLayoutParams();
        if (localObject1 != null) {
          ((ViewGroup.LayoutParams)localObject1).height = ViewUtils.dip2px(40.0F);
        }
      }
      localObject1 = paramswr.b();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new sgt(this, paramVideoInfo));
      }
      localObject1 = paramswr.b();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      localObject1 = paramswr.f();
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = paramswr.f();
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new sgu(this, paramVideoInfo, paramswr));
      }
      localObject1 = paramswr.b();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(0);
      }
      localObject1 = paramswr.c();
      if (localObject1 != null) {
        ((URLImageView)localObject1).setVisibility(8);
      }
      localObject1 = paramswr.b();
      if (localObject1 != null)
      {
        localObject1 = ((TextView)localObject1).getLayoutParams();
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          localObject2 = null;
        }
        localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
        if (localObject1 != null) {
          ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = ViewUtils.dip2px(34.0F);
        }
        localObject1 = paramswr.d();
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = paramswr.e();
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = paramswr.a();
        if (localObject1 != null) {
          ((KandianUrlImageView)localObject1).setVisibility(8);
        }
        localObject1 = paramswr.c();
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
        localObject1 = paramswr.b();
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(-1186049);
        }
        localObject1 = paramswr.c();
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(-1186049);
        }
        localObject1 = paramswr.b();
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageResource(2130843160);
        }
        localObject1 = paramVideoInfo.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoColumnInfo");
        c((VideoColumnInfo)localObject1, paramswr);
        localObject1 = paramVideoInfo.a;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "videoInfo.videoColumnInfo");
        b((VideoColumnInfo)localObject1, paramswr);
        paramVideoInfo = paramVideoInfo.a;
        Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoInfo.videoColumnInfo");
        a(paramVideoInfo, paramswr);
        six.a((View)paramswr.b(), 200);
      }
    }
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
      } while (paramswr.b() == null);
      paramVideoInfo = paramswr.b();
    } while (paramVideoInfo == null);
    paramVideoInfo.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgk
 * JD-Core Version:    0.7.0.1
 */