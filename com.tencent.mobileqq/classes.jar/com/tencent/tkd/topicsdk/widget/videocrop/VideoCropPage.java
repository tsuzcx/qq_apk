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
      TopicSDKHelperKt.a("video play error: " + paramString, true, null, 4, null);
      return;
    }
    paramString = a();
    if (paramString != null)
    {
      paramString = paramString.getResources();
      if (paramString != null)
      {
        paramString = paramString.getString(R.string.aA);
        if (paramString == null) {}
      }
    }
    for (;;)
    {
      TopicSDKHelperKt.a(paramString, false, null, 6, null);
      return;
      paramString = "视频播放错误";
    }
  }
  
  private final void b(View paramView)
  {
    View localView = paramView.findViewById(R.id.an);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.iv_close)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView);
    localView = paramView.findViewById(R.id.bD);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.tv_finish)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView);
    localView = paramView.findViewById(R.id.cb);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.video_view)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFixedSizeVideoView = ((FixedSizeVideoView)localView);
    localView = paramView.findViewById(R.id.ca);
    Intrinsics.checkExpressionValueIsNotNull(localView, "view.findViewById(R.id.video_select_bar)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar = ((VideoFrameSelectBar)localView);
    paramView = paramView.findViewById(R.id.bB);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.tv_duration)");
    this.b = ((TextView)paramView);
  }
  
  private final void f()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("video_path");
      if (localObject != null) {
        if (((CharSequence)localObject).length() != 0) {
          break label109;
        }
      }
    }
    label109:
    for (int i = 1;; i = 0)
    {
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
      return;
      localObject = "";
      break;
    }
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
      localObject = ((Activity)localObject).getResources().getString(R.string.aB);
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
    TLog.b("VideoCropPage", "mStartTime=" + i + ", mEndTime=" + j);
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
    int j;
    if (localObject != null)
    {
      i = ((Bundle)localObject).getInt("min_video_length");
      localObject = a();
      if (localObject == null) {
        break label136;
      }
      j = ((Bundle)localObject).getInt("max_video_length");
      label34:
      if (!new IntRange(0, this.jdField_a_of_type_Int).contains(i)) {
        break label141;
      }
      label53:
      if (!new IntRange(i, this.jdField_a_of_type_Int).contains(j)) {
        break label146;
      }
    }
    for (;;)
    {
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
      return;
      i = 0;
      break;
      label136:
      j = 0;
      break label34;
      label141:
      i = 0;
      break label53;
      label146:
      j = this.jdField_a_of_type_Int;
    }
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.m, paramViewGroup, false);
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
      String str = ((Activity)localObject1).getString(R.string.av);
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        localObject1 = this.b;
        if (localObject1 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("durationView");
        }
        Object localObject2 = StringCompanionObject.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(str, "textFormatter");
        localObject2 = new Object[1];
        localObject2[0] = Integer.valueOf((int)(paramFloat / 1000 + 0.5D));
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
    if ((paramInt != i) && (paramInt != j)) {}
    Object localObject2;
    boolean bool2;
    label250:
    do
    {
      return;
      localObject1 = a();
      if (localObject1 != null)
      {
        localObject1 = ((Activity)localObject1).getResources();
        if (localObject1 != null)
        {
          localObject1 = ((Resources)localObject1).getString(R.string.ay, new Object[] { Integer.valueOf(i / 1000) });
          if (localObject1 != null)
          {
            localObject2 = a();
            if (localObject2 == null) {
              break label250;
            }
            localObject2 = ((Activity)localObject2).getResources();
            if (localObject2 == null) {
              break label250;
            }
            localObject2 = ((Resources)localObject2).getString(R.string.ax, new Object[] { Integer.valueOf(j / 1000) });
            if (localObject2 == null) {
              break label250;
            }
          }
        }
      }
      for (;;)
      {
        boolean bool1 = StorageManager.a.a("sp_has_show_min_limit", false);
        bool2 = StorageManager.a.a("sp_has_show_max_limit", false);
        if ((paramInt != i) || (bool1)) {
          break label285;
        }
        TopicSDKHelperKt.a((String)localObject1, true, null, 4, null);
        StorageManager.a.a("sp_has_show_min_limit", true);
        return;
        localObject1 = "最少选择" + i / 1000 + "s哦";
        break;
        localObject2 = "最多选择" + j / 1000 + "s哦";
      }
    } while ((paramInt != j) || (bool2));
    label285:
    TopicSDKHelperKt.a((String)localObject2, true, null, 4, null);
    StorageManager.a.a("sp_has_show_max_limit", true);
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
    }
    do
    {
      return;
      localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCropDialog");
      }
    } while (!localCommonProgressDialog.isShowing());
    CommonProgressDialog localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
    if (localCommonProgressDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoCropDialog");
    }
    localCommonProgressDialog.dismiss();
  }
  
  public void aI_()
  {
    Object localObject = a();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      localObject = ((Activity)localObject).getResources().getString(R.string.an);
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
    if (((CharSequence)((VideoCropPresenter)localObject).a()).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label81;
      }
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFixedSizeVideoView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoView");
      }
      VideoCropPresenter localVideoCropPresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoCropPresenter;
      if (localVideoCropPresenter == null) {
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
      }
      ((FixedSizeVideoView)localObject).setVideoPath(localVideoCropPresenter.a());
    }
    label81:
    do
    {
      return;
      i = 0;
      break;
      localObject = a();
    } while (localObject == null);
    ((Activity)localObject).finish();
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage
 * JD-Core Version:    0.7.0.1
 */