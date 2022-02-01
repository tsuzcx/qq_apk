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
import bmbx;
import bmda;
import bnnl;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.tavcut.timeline.CoverSelectView;
import com.tencent.tavcut.timeline.CoverSelectView.UIConfigWrapper;
import com.tencent.tavcut.view.TAVCutVideoView;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.io.File;

public class AECoverSelectFragment
  extends AbsAEPublishVideoProcessFragment
  implements View.OnClickListener
{
  public static final float DEFAULT_COVER_PROGRESS = 0.0F;
  private static final String TAG = "AECoverSelectFragment";
  CoverSelectView coverSelectView;
  private float defaultCoverProgress;
  FrameLayout flCoverSelectContainer;
  LinearLayout llBottomContainer;
  TextView tvCancel;
  TextView tvConfirm;
  
  private void addCoverSelectView()
  {
    Object localObject = new CoverSelectView.UIConfigWrapper(getActivity(), 2130837929, 2130837707, 2130837706, 2130837748, 2130837749, 2130837750, 2130837751, 2130837924, 11);
    ((CoverSelectView.UIConfigWrapper)localObject).setPrevibarHeight(bnnl.b(getActivity(), 59.0F)).setPreviewBarWidth(bnnl.b(getActivity(), 34.0F)).setCoverDefaultProgress(this.defaultCoverProgress);
    this.coverSelectView = new CoverSelectView(getActivity(), (CoverSelectView.UIConfigWrapper)localObject);
    int i = bnnl.b(getActivity(), 4.0F);
    int j = bnnl.b(getActivity(), 2.0F);
    Log.d("AECoverSelectFragment", "addCoverSelectView: pixValue2Dip = " + j);
    int k = bnnl.b(getActivity(), 16.0F);
    int m = bnnl.b(getActivity(), 13.0F);
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
      bmbx.d("AECoverSelectFragment", "获取封面图失败");
      showLoading(false);
      return;
    }
    for (;;)
    {
      try
      {
        Log.d("AECoverSelectFragment", "saveDataAndQuit: w=" + ((Bitmap)localObject2).getWidth() + " h=" + ((Bitmap)localObject2).getHeight());
        String str = bmda.e + File.separator + this.missionId + "_" + System.currentTimeMillis() + ".JPG";
        localFile = new File(str);
        if (localFile.getParentFile().exists()) {
          continue;
        }
        if (!localFile.getParentFile().mkdirs()) {
          bmbx.d("AECoverSelectFragment", "保存封面，创建父路径失败");
        }
        if (!localFile.createNewFile()) {
          bmbx.d("AECoverSelectFragment", "保存封面，创建封面文件失败");
        }
        if (!FileUtil.writeBitmapToFile((Bitmap)localObject2, str)) {
          continue;
        }
        bmbx.a("AECoverSelectFragment", "封面保存成功,path=" + str);
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
        bmbx.d("AECoverSelectFragment", "封面保存出错:" + localException.toString());
        getActivity().setResult(0);
        return;
        bmbx.d("AECoverSelectFragment", "封面保存出错");
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
      FileUtil.deleteSubFile(localFile.getParentFile());
    }
  }
  
  void bindViews(View paramView)
  {
    this.tavCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378228));
    this.llBottomContainer = ((LinearLayout)paramView.findViewById(2131370136));
    this.flCoverSelectContainer = ((FrameLayout)paramView.findViewById(2131366760));
    this.tvCancel = ((TextView)paramView.findViewById(2131379504));
    this.tvConfirm = ((TextView)paramView.findViewById(2131379543));
    this.tvCancel.setOnClickListener(this);
    this.tvConfirm.setOnClickListener(this);
  }
  
  void customizeBindingData(VideoResourceModel paramVideoResourceModel)
  {
    addCoverSelectView();
    this.coverSelectView.bindPlayer(this.mMoviePlayer);
    Log.d("AECoverSelectFragment", "initTavCutAndPlayer: \nresource.selectDuration = " + paramVideoResourceModel.getSelectTimeDuration() + "\nresource.start = " + paramVideoResourceModel.getSelectTimeStart() + "\n resource.end = " + (paramVideoResourceModel.getSelectTimeStart() + paramVideoResourceModel.getSelectTimeDuration()));
    this.coverSelectView.updateTavVideoSession(this.tavCutVideoSession);
    this.coverSelectView.setClipAndSpeed(paramVideoResourceModel.getSpeed(), getTotalDuration(paramVideoResourceModel), paramVideoResourceModel.getSelectTimeStart(), paramVideoResourceModel.getSelectTimeStart() + getTotalDuration(paramVideoResourceModel));
    this.mMoviePlayer.pause();
    paramVideoResourceModel = CMTime.fromUs(((float)this.tavCutVideoSession.getDuration().getTimeUs() * this.defaultCoverProgress / 100.0F));
    this.mMoviePlayer.seekToTime(paramVideoResourceModel);
  }
  
  protected int getLayoutId()
  {
    return 2131558542;
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
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558542, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AECoverSelectFragment
 * JD-Core Version:    0.7.0.1
 */