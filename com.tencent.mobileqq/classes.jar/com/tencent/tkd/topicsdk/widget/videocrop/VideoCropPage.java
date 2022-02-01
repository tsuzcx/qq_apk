package com.tencent.tkd.topicsdk.widget.videocrop;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.framework.BaseSDKPage;
import com.tencent.tkd.topicsdk.framework.StorageManager;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.widget.dialog.CommonProgressDialog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoCropPage;", "Lcom/tencent/tkd/topicsdk/framework/BaseSDKPage;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoCropContract$IView;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFrameSelectBar$OnFramesClipChangeListener;", "()V", "closeView", "Landroid/widget/ImageView;", "durationView", "Landroid/widget/TextView;", "finishView", "isImmersiveStatusBar", "", "()Z", "mediaPlayer", "Landroid/media/MediaPlayer;", "presenter", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoCropPresenter;", "videoBar", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFrameSelectBar;", "videoCropDialog", "Lcom/tencent/tkd/topicsdk/widget/dialog/CommonProgressDialog;", "videoDuration", "", "videoView", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FixedSizeVideoView;", "checkAndShowLimitToast", "", "interval", "finishWithData", "originalPath", "", "mergePath", "initFinishView", "initProgressDialog", "initUI", "view", "Landroid/view/View;", "initVideoBar", "initVideoView", "initView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCurrentRangeTimeChanged", "time", "", "onDestroyView", "onFramesClipChanged", "startTime", "endTime", "onResume", "showLoadingDialog", "isVisible", "showVideoCropFailedToast", "showVideoPlayErrorToast", "errorMsg", "updateVideoLimitData", "updateVideoPath", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
@RequiresApi(18)
public final class VideoCropPage
  extends BaseSDKPage
  implements VideoCropContract.IView, VideoFrameSelectBar.OnFramesClipChangeListener
{
  public static final VideoCropPage.Companion a;
  private int jdField_a_of_type_Int;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CommonProgressDialog jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
  private FixedSizeVideoView jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFixedSizeVideoView;
  private VideoCropPresenter jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
  private VideoFrameSelectBar jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar;
  private TextView b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPage$Companion = new VideoCropPage.Companion(null);
  }
  
  private final void a(View paramView)
  {
    b(paramView);
    paramView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeView");
    }
    paramView.setOnClickListener((View.OnClickListener)new VideoCropPage.initView.1(this));
    g();
    h();
    i();
  }
  
  private final void a(String paramString)
  {
    if (TopicSDKHelperKt.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("video play error: ");
      localStringBuilder.append(paramString);
      TopicSDKHelperKt.a(localStringBuilder.toString(), true, null, 4, null);
      return;
    }
    paramString = a();
    if (paramString != null)
    {
      paramString = paramString.getResources();
      if (paramString != null)
      {
        paramString = paramString.getString(R.string.ap);
        if (paramString != null) {
          break label75;
        }
      }
    }
    paramString = "视频播放错误";
    label75:
    TopicSDKHelperKt.a(paramString, false, null, 6, null);
  }
  
  private final void b(View paramView)
  {
    View localView = paramView.findViewById(R.id.Y);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.iv_close)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(R.id.aZ);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.tv_finish)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
    localView = paramView.findViewById(R.id.bv);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.video_view)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFixedSizeVideoView = ((FixedSizeVideoView)localView);
    localView = paramView.findViewById(R.id.bu);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.video_select_bar)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar = ((VideoFrameSelectBar)localView);
    paramView = paramView.findViewById(R.id.aX);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.tv_duration)");
    this.b = ((TextView)paramView);
  }
  
  private final void f()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("video_path");
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    int i;
    if (((CharSequence)localObject).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      TLog.d("VideoCropPage", "videoPath is empty.");
      a("videoPath is empty.");
      Activity localActivity = a();
      if (localActivity != null) {
        localActivity.finish();
      }
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter = new VideoCropPresenter((String)localObject);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    ((VideoCropPresenter)localObject).a((VideoCropContract.IView)this);
  }
  
  private final void g()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("finishView");
    }
    localTextView.setOnClickListener((View.OnClickListener)new VideoCropPage.initFinishView.1(this));
    localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("finishView");
    }
    localTextView.setEnabled(false);
  }
  
  private final void h()
  {
    FixedSizeVideoView localFixedSizeVideoView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFixedSizeVideoView;
    if (localFixedSizeVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoView");
    }
    localFixedSizeVideoView.setListener((FixedSizeVideoView.OnTrimVDPlayCompleteListener)new VideoCropPage.initVideoView.1(this));
    localFixedSizeVideoView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFixedSizeVideoView;
    if (localFixedSizeVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoView");
    }
    localFixedSizeVideoView.setOnErrorListener((MediaPlayer.OnErrorListener)new VideoCropPage.initVideoView.2(this));
    localFixedSizeVideoView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFixedSizeVideoView;
    if (localFixedSizeVideoView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoView");
    }
    localFixedSizeVideoView.setOnPreparedListener((MediaPlayer.OnPreparedListener)new VideoCropPage.initVideoView.3(this));
  }
  
  private final void i()
  {
    Object localObject = a();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "this");
      this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog = new CommonProgressDialog((Context)localObject, 2);
      CommonProgressDialog localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCropDialog");
      }
      localObject = ((Activity)localObject).getResources().getString(R.string.aq);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "resources.getString(R.st…ideo_processing_and_wait)");
      localCommonProgressDialog.a((String)localObject);
      localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCropDialog");
      }
      localCommonProgressDialog.setOnCancelListener((DialogInterface.OnCancelListener)new VideoCropPage.initProgressDialog..inlined.apply.lambda.1(this));
    }
  }
  
  private final void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoBar");
    }
    ((VideoFrameSelectBar)localObject).setMOnFramesClipChangeListener((VideoFrameSelectBar.OnFramesClipChangeListener)this);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    if (TextUtils.isEmpty((CharSequence)((VideoCropPresenter)localObject).a()))
    {
      TLog.b("VideoCropPage", "initFramesBar, mVideoPath is null");
      a("initFramesBar, mVideoPath is null");
      localObject = a();
      if (localObject != null) {
        ((Activity)localObject).finish();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoBar");
    }
    int i = this.jdField_a_of_type_Int;
    VideoCropPresenter localVideoCropPresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localVideoCropPresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    ((VideoFrameSelectBar)localObject).a(i, localVideoCropPresenter.a());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoBar");
    }
    i = (int)((VideoFrameSelectBar)localObject).a();
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoBar");
    }
    int j = (int)((VideoFrameSelectBar)localObject).b();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mStartTime=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", mEndTime=");
    ((StringBuilder)localObject).append(j);
    TLog.b("VideoCropPage", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFixedSizeVideoView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoView");
    }
    ((FixedSizeVideoView)localObject).setPlayDuration(j - i);
    k();
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoBar");
    }
    ((VideoFrameSelectBar)localObject).requestLayout();
  }
  
  private final void k()
  {
    Object localObject = a();
    int i;
    if (localObject != null) {
      i = ((Bundle)localObject).getInt("min_video_length");
    } else {
      i = 0;
    }
    localObject = a();
    int j;
    if (localObject != null) {
      j = ((Bundle)localObject).getInt("max_video_length");
    } else {
      j = 0;
    }
    if (!new IntRange(0, this.jdField_a_of_type_Int).contains(i)) {
      i = 0;
    }
    if (!new IntRange(i, this.jdField_a_of_type_Int).contains(j)) {
      j = this.jdField_a_of_type_Int;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    ((VideoCropPresenter)localObject).a(i);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    ((VideoCropPresenter)localObject).b(j);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoBar");
    }
    ((VideoFrameSelectBar)localObject).setVideoLimitRange(i, j);
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.l, paramViewGroup, false);
    f();
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "view");
    a(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoBar");
    }
    ((VideoFrameSelectBar)localObject).a();
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    ((VideoCropPresenter)localObject).a();
    super.a();
  }
  
  public void a(float paramFloat)
  {
    Object localObject1 = a();
    if (localObject1 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity ?: return");
      String str = ((Activity)localObject1).getString(R.string.al);
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        localObject1 = this.b;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("durationView");
        }
        Object localObject2 = StringCompanionObject.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(str, "textFormatter");
        localObject2 = new Object[1];
        double d = paramFloat / 1000;
        Double.isNaN(d);
        localObject2[0] = Integer.valueOf((int)(d + 0.5D));
        str = String.format(str, Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
        ((TextView)localObject1).setText((CharSequence)str);
      }
    }
  }
  
  @VisibleForTesting
  public final void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    int i = ((VideoCropPresenter)localObject1).a();
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    int j = ((VideoCropPresenter)localObject1).b();
    if ((paramInt != i) && (paramInt != j)) {
      return;
    }
    localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getResources();
      if (localObject1 != null)
      {
        localObject1 = ((Resources)localObject1).getString(R.string.ao, new Object[] { Integer.valueOf(i / 1000) });
        if (localObject1 != null) {
          break label156;
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("最少选择");
    ((StringBuilder)localObject1).append(i / 1000);
    ((StringBuilder)localObject1).append("s哦");
    localObject1 = ((StringBuilder)localObject1).toString();
    label156:
    Object localObject2 = a();
    if (localObject2 != null)
    {
      localObject2 = ((Activity)localObject2).getResources();
      if (localObject2 != null)
      {
        localObject2 = ((Resources)localObject2).getString(R.string.an, new Object[] { Integer.valueOf(j / 1000) });
        if (localObject2 != null) {
          break label257;
        }
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("最多选择");
    ((StringBuilder)localObject2).append(j / 1000);
    ((StringBuilder)localObject2).append("s哦");
    localObject2 = ((StringBuilder)localObject2).toString();
    label257:
    boolean bool1 = StorageManager.a.a("sp_has_show_min_limit", false);
    boolean bool2 = StorageManager.a.a("sp_has_show_max_limit", false);
    if ((paramInt == i) && (!bool1))
    {
      TopicSDKHelperKt.a((String)localObject1, true, null, 4, null);
      StorageManager.a.a("sp_has_show_min_limit", true);
      return;
    }
    if ((paramInt == j) && (!bool2))
    {
      TopicSDKHelperKt.a((String)localObject2, true, null, 4, null);
      StorageManager.a.a("sp_has_show_max_limit", true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManagerKt.b((Function0)new VideoCropPage.onFramesClipChanged.1(this, paramInt1, paramInt2));
    a(paramInt2 - paramInt1);
    VideoCropPresenter localVideoCropPresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localVideoCropPresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCropPresenter.a(paramInt1, paramInt2);
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "originalPath");
    Intrinsics.checkParameterIsNotNull(paramString2, "mergePath");
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("video_path", paramString1);
    localBundle.putString("merge_path", paramString2);
    localIntent.putExtras(localBundle);
    paramString1 = a();
    if (paramString1 != null) {
      paramString1.setResult(-1, localIntent);
    }
    paramString1 = a();
    if (paramString1 != null) {
      paramString1.finish();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      i();
      localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCropDialog");
      }
      localCommonProgressDialog.show();
      return;
    }
    CommonProgressDialog localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
    if (localCommonProgressDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoCropDialog");
    }
    if (localCommonProgressDialog.isShowing())
    {
      localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCropDialog");
      }
      localCommonProgressDialog.dismiss();
    }
  }
  
  public void aV_()
  {
    Object localObject = a();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      localObject = ((Activity)localObject).getResources().getString(R.string.ae);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.resources.getString(R…g.tips_video_crop_failed)");
      TopicSDKHelperKt.a((String)localObject, false, null, 6, null);
    }
  }
  
  public void b()
  {
    super.b();
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    int i;
    if (((CharSequence)((VideoCropPresenter)localObject).a()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFixedSizeVideoView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
      }
      VideoCropPresenter localVideoCropPresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
      if (localVideoCropPresenter == null) {
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
      }
      ((FixedSizeVideoView)localObject).setVideoPath(localVideoCropPresenter.a());
      return;
    }
    localObject = a();
    if (localObject != null) {
      ((Activity)localObject).finish();
    }
  }
  
  public boolean f()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage
 * JD-Core Version:    0.7.0.1
 */