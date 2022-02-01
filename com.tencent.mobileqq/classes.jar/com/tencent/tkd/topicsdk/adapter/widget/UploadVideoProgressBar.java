package com.tencent.tkd.topicsdk.adapter.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.bean.DisplayItem;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.Media;
import com.tencent.tkd.topicsdk.bean.MediaType;
import com.tencent.tkd.topicsdk.bean.PreUploadVideoInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.common.BitmapUtils;
import com.tencent.tkd.topicsdk.common.NetworkUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.ICheckResultCallBack;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishStatusListener;
import com.tencent.tkd.topicsdk.qq_adapter.R.drawable;
import com.tencent.tkd.topicsdk.qq_adapter.R.id;
import com.tencent.tkd.topicsdk.qq_adapter.R.layout;
import com.tencent.tkd.topicsdk.qq_adapter.R.string;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/adapter/widget/UploadVideoProgressBar;", "Landroid/widget/LinearLayout;", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishStatusListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btn", "Landroid/widget/TextView;", "canPublishInMobileNet", "", "date", "Ljava/util/Date;", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "isUsed", "preUploadVideoInfo", "Lcom/tencent/tkd/topicsdk/bean/PreUploadVideoInfo;", "progressBar", "Landroid/widget/ProgressBar;", "status", "Lcom/tencent/tkd/topicsdk/adapter/widget/UploadVideoProgressBar$Status;", "statusDesc", "timeFormat", "Ljava/text/SimpleDateFormat;", "timeToRefreshUploadSpeedStatus", "", "title", "getUploadedCoverUrl", "", "initFromConfig", "", "publishId", "needRefreshUploadSpeedStatus", "onDetachedFromWindow", "onFailedStatus", "onPauseStatus", "onProgress", "progress", "", "speed", "uploadedSize", "fileSize", "onUploadSuccessStatus", "onUploadVideoCoverSuccessStatus", "coverUrl", "onUploadingStatus", "pauseUploadVideo", "preUploadVideo", "isStart", "reportClickEvent", "reportEventElement", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/report/ReportEventElement;", "resetView", "startUploadVideo", "timeToString", "time", "updateVideoInfo", "displayItem", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "Companion", "Status", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class UploadVideoProgressBar
  extends LinearLayout
  implements IPublishManager.IPublishStatusListener
{
  public static final UploadVideoProgressBar.Companion a;
  private long jdField_a_of_type_Long;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private UploadVideoProgressBar.Status jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar$Status = UploadVideoProgressBar.Status.UPLOADING;
  private GlobalPublisherConfig jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
  private PreUploadVideoInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
  private final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("mm:ss");
  private final Date jdField_a_of_type_JavaUtilDate = new Date();
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView c;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar$Companion = new UploadVideoProgressBar.Companion(null);
  }
  
  public UploadVideoProgressBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.d, (ViewGroup)this, true);
    paramContext = findViewById(R.id.q);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.progress)");
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext);
    paramContext = findViewById(R.id.t);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.progress_title)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    paramContext = findViewById(R.id.r);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.progress_btn)");
    this.c = ((TextView)paramContext);
    paramContext = findViewById(R.id.s);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.progress_desc)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext);
    this.c.setOnClickListener((View.OnClickListener)new UploadVideoProgressBar.1(this));
  }
  
  private final String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00";
    }
    long l1 = 3600;
    long l2 = paramLong / l1;
    if (l2 <= 0L)
    {
      this.jdField_a_of_type_JavaUtilDate.setTime(paramLong * 1000);
      localObject = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(this.jdField_a_of_type_JavaUtilDate);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "timeFormat.format(date)");
      return localObject;
    }
    this.jdField_a_of_type_JavaUtilDate.setTime(paramLong % l1 * 1000);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(':');
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaTextSimpleDateFormat.format(this.jdField_a_of_type_JavaUtilDate));
    return ((StringBuilder)localObject).toString();
  }
  
  private final void a(ReportEventElement paramReportEventElement)
  {
    UserActionEvent localUserActionEvent = new UserActionEvent();
    localUserActionEvent.a(ReportEventKey.EVENT_CLICK);
    localUserActionEvent.a(ReportEventPage.PAGE_PUBLISH);
    localUserActionEvent.a(paramReportEventElement);
    paramReportEventElement = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (paramReportEventElement == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    localUserActionEvent.a(paramReportEventElement);
    DispatchManager.a.a((IEvent)localUserActionEvent);
  }
  
  private final void a(boolean paramBoolean)
  {
    IPublishManager localIPublishManager = TopicSDK.a.a().a().a();
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    PreUploadVideoInfo localPreUploadVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
    if (localPreUploadVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
    }
    localIPublishManager.a(localGlobalPublisherConfig, localPreUploadVideoInfo, paramBoolean, (IPublishManager.IPublishStatusListener)this);
  }
  
  private final boolean a()
  {
    long l = System.currentTimeMillis();
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = (l + 100L);
      return true;
    }
    return false;
  }
  
  private final void e()
  {
    f();
    Object localObject = NetworkUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    if ((!((NetworkUtils)localObject).b(localContext)) && (!this.jdField_a_of_type_Boolean))
    {
      localObject = TopicSDK.a.a().a().a();
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      PreUploadVideoInfo localPreUploadVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
      if (localPreUploadVideoInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
      }
      ((IPublishManager)localObject).a(localContext, localPreUploadVideoInfo.getVideoInfo().getFileSize(), (IPublishManager.ICheckResultCallBack)new UploadVideoProgressBar.startUploadVideo.1(this));
      return;
    }
    a(true);
  }
  
  private final void f()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)"");
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.o));
    this.c.setText((CharSequence)getResources().getString(R.string.n));
    this.c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.a), null, null, null);
    this.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar$Status = UploadVideoProgressBar.Status.UPLOADING;
  }
  
  private final void g()
  {
    IPublishManager localIPublishManager = TopicSDK.a.a().a().a();
    GlobalPublisherConfig localGlobalPublisherConfig = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
    if (localGlobalPublisherConfig == null) {
      Intrinsics.throwUninitializedPropertyAccessException("globalPublisherConfig");
    }
    PreUploadVideoInfo localPreUploadVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
    if (localPreUploadVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
    }
    localIPublishManager.a(localGlobalPublisherConfig, localPreUploadVideoInfo);
  }
  
  @NotNull
  public final String a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      PreUploadVideoInfo localPreUploadVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
      if (localPreUploadVideoInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
      }
      return localPreUploadVideoInfo.getVideoInfo().getCoverUrl();
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.o));
    this.c.setText((CharSequence)getResources().getString(R.string.n));
    this.c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.a), null, null, null);
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar$Status = UploadVideoProgressBar.Status.UPLOADING;
  }
  
  public void a(int paramInt, @NotNull String paramString, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "speed");
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar$Status == UploadVideoProgressBar.Status.UPLOADING)
    {
      if (paramInt > this.jdField_a_of_type_AndroidWidgetProgressBar.getProgress()) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      }
      if (paramLong1 <= 0L)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)"");
        return;
      }
      if (!a()) {
        return;
      }
      Object localObject1 = (CharSequence)paramString;
      float f2;
      if (StringsKt.contains((CharSequence)localObject1, (CharSequence)"KB", true))
      {
        f2 = Float.parseFloat(StringsKt.dropLast(paramString, 4));
        f1 = 1024;
        f1 = f2 * f1;
      }
      else
      {
        if (StringsKt.contains((CharSequence)localObject1, (CharSequence)"MB", true))
        {
          f2 = Float.parseFloat(StringsKt.dropLast(paramString, 4));
          f1 = 1024;
        }
        for (;;)
        {
          f2 *= f1;
          break;
          if (!StringsKt.contains$default((CharSequence)localObject1, (CharSequence)"GB", false, 2, null)) {
            break label195;
          }
          f2 = Float.parseFloat(StringsKt.dropLast(paramString, 4));
          f1 = 1024;
          f2 *= f1;
        }
        label195:
        if (!StringsKt.contains((CharSequence)localObject1, 'B', true)) {
          break label332;
        }
        f1 = Float.parseFloat(StringsKt.dropLast(paramString, 3));
      }
      if (f1 <= (float)0L)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)"0KB/S");
        return;
      }
      float f1 = (float)(paramLong2 - paramLong1) / f1;
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      Object localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = getResources().getString(R.string.l);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources.getString(R.st…load_video_progress_desc)");
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = a(f1);
      paramString = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(paramString, "java.lang.String.format(format, *args)");
      ((TextView)localObject1).setText((CharSequence)paramString);
      return;
      label332:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("upload video speed error, the speed value is  ");
      ((StringBuilder)localObject1).append(paramString);
      TLog.d("UploadVideoProgressBar", ((StringBuilder)localObject1).toString());
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)"");
    }
  }
  
  public final void a(@NotNull DisplayItem paramDisplayItem)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayItem, "displayItem");
    if (getVisibility() == 8) {
      return;
    }
    PreUploadVideoInfo localPreUploadVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
    if (localPreUploadVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
    }
    if (Intrinsics.areEqual(localPreUploadVideoInfo.getVideoInfo().getCoverPath(), paramDisplayItem.getCoverPath())) {
      return;
    }
    if (paramDisplayItem.getMedia().getType() == MediaType.VIDEO)
    {
      localPreUploadVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
      if (localPreUploadVideoInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
      }
      localPreUploadVideoInfo.getVideoInfo().setCoverPath(paramDisplayItem.getCoverPath());
      paramDisplayItem = BitmapUtils.a.a(paramDisplayItem.getCoverPath());
      localPreUploadVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
      if (localPreUploadVideoInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
      }
      localPreUploadVideoInfo.getVideoInfo().setCoverWidth(((Number)paramDisplayItem.getFirst()).intValue());
      localPreUploadVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
      if (localPreUploadVideoInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
      }
      localPreUploadVideoInfo.getVideoInfo().setCoverHeight(((Number)paramDisplayItem.getSecond()).intValue());
      e();
      paramDisplayItem = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
      if (paramDisplayItem == null) {
        Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
      }
      paramDisplayItem.getVideoInfo().setCoverUrl("");
    }
  }
  
  public final void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig = paramGlobalPublisherConfig;
    if (paramGlobalPublisherConfig.getOriginVideoInfo() != null)
    {
      int i;
      if (((CharSequence)paramString).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        this.jdField_b_of_type_Boolean = true;
        VideoInfo localVideoInfo = paramGlobalPublisherConfig.getOriginVideoInfo();
        if (localVideoInfo == null) {
          Intrinsics.throwNpe();
        }
        String str = paramGlobalPublisherConfig.getScene();
        paramGlobalPublisherConfig = paramGlobalPublisherConfig.getCommunityInfo();
        if (paramGlobalPublisherConfig != null)
        {
          paramGlobalPublisherConfig = paramGlobalPublisherConfig.getCommunityId();
          if (paramGlobalPublisherConfig != null) {}
        }
        else
        {
          paramGlobalPublisherConfig = "";
        }
        this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo = new PreUploadVideoInfo(paramString, localVideoInfo, str, paramGlobalPublisherConfig);
        e();
        return;
      }
    }
    setVisibility(8);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "coverUrl");
    PreUploadVideoInfo localPreUploadVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPreUploadVideoInfo;
    if (localPreUploadVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("preUploadVideoInfo");
    }
    localPreUploadVideoInfo.getVideoInfo().setCoverUrl(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.k));
    this.c.setText((CharSequence)getResources().getString(R.string.j));
    this.c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.c), null, null, null);
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar$Status = UploadVideoProgressBar.Status.PAUSE;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.m));
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)"");
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(100);
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar$Status = UploadVideoProgressBar.Status.SUCCESS;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)getResources().getString(R.string.i));
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)"");
    this.c.setText((CharSequence)getResources().getString(R.string.h));
    this.c.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.b), null, null, null);
    this.jdField_a_of_type_ComTencentTkdTopicsdkAdapterWidgetUploadVideoProgressBar$Status = UploadVideoProgressBar.Status.FAILED;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TopicSDK.a.a().a().a().a((IPublishManager.IPublishStatusListener)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.UploadVideoProgressBar
 * JD-Core Version:    0.7.0.1
 */