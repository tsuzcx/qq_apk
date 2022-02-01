package dov.com.qq.im.ae.play;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.timeline.CoverSelectView;
import com.tencent.tavcut.timeline.CoverSelectView.UIConfigWrapper;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.ModelExtKt;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.FILES;
import dov.com.qq.im.aeeditor.AEEditorProcessManager;
import dov.com.qq.im.aeeditor.data.AEEditorVideoInfo;
import dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiVideoEditFragment;
import dov.com.qq.im.aeeditor.module.export.AEEditorGenerateRunnable;
import dov.com.qq.im.aeeditor.module.params.ParamFactory;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.io.File;
import java.util.ArrayList;

public class AECoverSelectFragment
  extends AbsAEPublishVideoProcessFragment
  implements View.OnClickListener
{
  public static final float DEFAULT_COVER_PROGRESS = 0.0F;
  private static final String TAG = "AECoverSelectFragment";
  CoverSelectView coverSelectView;
  TAVCutVideoSession coverVideoSession;
  private float defaultCoverProgress;
  FrameLayout flCoverSelectContainer;
  LinearLayout llBottomContainer;
  private String outputPath;
  TextView tvCancel;
  TextView tvConfirm;
  
  private void addCoverSelectView()
  {
    Object localObject = new CoverSelectView.UIConfigWrapper(getActivity(), 2130837974, 2130837732, 2130837731, 2130837921, 2130837922, 2130837923, 2130837924, 2130837966, 11);
    ((CoverSelectView.UIConfigWrapper)localObject).setPrevibarHeight(DisplayUtil.b(getActivity(), 59.0F)).setPreviewBarWidth(DisplayUtil.b(getActivity(), 34.0F)).setCoverDefaultProgress(this.defaultCoverProgress);
    this.coverSelectView = new CoverSelectView(getActivity(), (CoverSelectView.UIConfigWrapper)localObject);
    int i = DisplayUtil.b(getActivity(), 4.0F);
    int j = DisplayUtil.b(getActivity(), 2.0F);
    Log.d("AECoverSelectFragment", "addCoverSelectView: pixValue2Dip = " + j);
    int k = DisplayUtil.b(getActivity(), 16.0F);
    int m = DisplayUtil.b(getActivity(), 13.0F);
    localObject = new RoundCornerImageView(getActivity());
    ((RoundCornerImageView)localObject).setCorner(j);
    ((RoundCornerImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    localShapeDrawable.getPaint().setColor(-1);
    ((RoundCornerImageView)localObject).setBackgroundDrawable(localShapeDrawable);
    ((RoundCornerImageView)localObject).setPadding(j, j, j, j);
    this.coverSelectView.setCoverPreviewBarBg(localShapeDrawable);
    this.coverSelectView.setPreviewBar((ImageView)localObject);
    this.coverSelectView.setPreviewBarElevation(15.0F);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.coverSelectView.setTimelineViewPadding(k, m, k, m);
    this.flCoverSelectContainer.addView(this.coverSelectView, (ViewGroup.LayoutParams)localObject);
  }
  
  private float getDefaultCoverProgress()
  {
    Bundle localBundle = getArguments();
    if (getActivity().getIntent().getExtras() != null) {}
    for (float f1 = getActivity().getIntent().getFloatExtra("key_video_cover_position", 0.0F);; f1 = 0.0F)
    {
      float f2 = f1;
      if (f1 == 0.0F)
      {
        f2 = f1;
        if (localBundle != null)
        {
          f2 = f1;
          if (localBundle.containsKey("key_video_cover_position")) {
            f2 = localBundle.getFloat("key_video_cover_position", 0.0F);
          }
        }
      }
      return f2;
    }
  }
  
  private long getTotalDuration(@NonNull VideoResourceModel paramVideoResourceModel)
  {
    if ((this.missionId != null) && (this.missionId.startsWith("multi_video_"))) {
      return this.tavCutVideoSession.getDuration().getTimeUs() / 1000L;
    }
    return paramVideoResourceModel.getSelectTimeDuration();
  }
  
  private void saveDataAndQuit()
  {
    showLoading(true);
    float f = this.coverSelectView.getCurrCoverProgress();
    Object localObject2 = this.coverSelectView.getCurrCoverBitmap();
    if (localObject2 == null)
    {
      AEQLog.d("AECoverSelectFragment", "获取封面图失败");
      showLoading(false);
      return;
    }
    for (;;)
    {
      try
      {
        Log.d("AECoverSelectFragment", "saveDataAndQuit: w=" + ((Bitmap)localObject2).getWidth() + " h=" + ((Bitmap)localObject2).getHeight());
        String str = AEEditorPath.EDITOR.FILES.e + File.separator + this.missionId + "_" + System.currentTimeMillis() + ".JPG";
        localFile = new File(str);
        if (localFile.getParentFile().exists()) {
          continue;
        }
        if (!localFile.getParentFile().mkdirs()) {
          AEQLog.d("AECoverSelectFragment", "保存封面，创建父路径失败");
        }
        if (!localFile.createNewFile()) {
          AEQLog.d("AECoverSelectFragment", "保存封面，创建封面文件失败");
        }
        if (!FileUtil.a((Bitmap)localObject2, str)) {
          continue;
        }
        AEQLog.a("AECoverSelectFragment", "封面保存成功,path=" + str);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_video_cover_position", f);
        ((Intent)localObject2).putExtra("key_video_cover_path", str);
        ((Intent)localObject2).putExtra("key_video_media_path", getMediaPath());
        getActivity().setResult(-1, (Intent)localObject2);
      }
      catch (Exception localException)
      {
        File localFile;
        localException.printStackTrace();
        AEQLog.d("AECoverSelectFragment", "封面保存出错:" + localException.toString());
        getActivity().setResult(0);
        return;
        AEQLog.d("AECoverSelectFragment", "封面保存出错");
        getActivity().setResult(0);
        continue;
      }
      finally
      {
        showLoading(false);
        getActivity().finish();
      }
      showLoading(false);
      getActivity().finish();
      return;
      FileUtil.a(localFile.getParentFile());
    }
  }
  
  void bindViews(View paramView)
  {
    this.tavCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378947));
    this.llBottomContainer = ((LinearLayout)paramView.findViewById(2131370579));
    this.flCoverSelectContainer = ((FrameLayout)paramView.findViewById(2131367067));
    this.tvCancel = ((TextView)paramView.findViewById(2131380242));
    this.tvConfirm = ((TextView)paramView.findViewById(2131380282));
    this.tvCancel.setOnClickListener(this);
    this.tvConfirm.setOnClickListener(this);
  }
  
  void customizeBindingData(VideoResourceModel paramVideoResourceModel)
  {
    addCoverSelectView();
    this.coverVideoSession = new TAVCutVideoSession();
    AEEditorMultiVideoEditFragment.a(getActivity(), this.coverVideoSession, ParamFactory.b(), this.tavCutVideoSession.getMediaModel(), null, null);
    this.coverVideoSession.restoreStickersWithLyric(new ArrayList(this.tavCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList()));
    this.coverVideoSession.setStickerTouchEnable(false);
    if (ModelExtKt.isLightTemplate(this.coverVideoSession.getMediaModel())) {
      this.coverVideoSession.getMediaModel().getMediaEffectModel().setAeKitModel(null);
    }
    this.coverSelectView.bindPlayer(this.mMoviePlayer);
    Log.d("AECoverSelectFragment", "initTavCutAndPlayer: \nresource.selectDuration = " + paramVideoResourceModel.getSelectTimeDuration() + "\nresource.start = " + paramVideoResourceModel.getSelectTimeStart() + "\n resource.end = " + (paramVideoResourceModel.getSelectTimeStart() + paramVideoResourceModel.getSelectTimeDuration()));
    this.coverSelectView.updateTavVideoSession(this.coverVideoSession);
    this.coverSelectView.setClipAndSpeed(paramVideoResourceModel.getSpeed(), getTotalDuration(paramVideoResourceModel), paramVideoResourceModel.getSelectTimeStart(), paramVideoResourceModel.getSelectTimeStart() + getTotalDuration(paramVideoResourceModel));
    this.mMoviePlayer.pause();
    paramVideoResourceModel = CMTime.fromUs(((float)this.tavCutVideoSession.getDuration().getTimeUs() * this.defaultCoverProgress / 100.0F));
    this.mMoviePlayer.seekToTime(paramVideoResourceModel);
  }
  
  protected int getLayoutId()
  {
    return 2131558570;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      getActivity().setResult(0);
      getActivity().finish();
      continue;
      saveDataAndQuit();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.defaultCoverProgress = getDefaultCoverProgress();
    paramBundle = new File(getMediaPath());
    this.outputPath = (AEEditorPath.EDITOR.FILES.d + File.separator + "output_" + this.missionId + "_" + VideoFilterTools.a(paramBundle.getName()) + ".mp4");
    AEQLog.a("AECoverSelectFragment", "[coverGen][onCreate] missionId = " + this.missionId + " outputPath = " + this.outputPath);
    paramBundle = AEEditorProcessManager.a().a(this.missionId);
    if (paramBundle != null)
    {
      AEQLog.a("AECoverSelectFragment", "[coverGen][onCreate][tryToKillExport] videoInfo = " + paramBundle.toString());
      paramBundle.a.a().cancel();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558570, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    this.coverVideoSession.release();
    this.coverSelectView.release();
    AEEditorVideoInfo localAEEditorVideoInfo = AEEditorProcessManager.a().a(this.missionId);
    if ((localAEEditorVideoInfo != null) && (localAEEditorVideoInfo.e.equals("AEEDITOR_GENERATE_STATUS_CANEL"))) {
      AEEditorProcessManager.a().a(this.missionId);
    }
    super.onFinish();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AECoverSelectFragment
 * JD-Core Version:    0.7.0.1
 */