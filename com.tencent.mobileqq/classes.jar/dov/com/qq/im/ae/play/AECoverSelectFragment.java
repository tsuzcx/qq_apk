package dov.com.qq.im.ae.play;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
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
import auog;
import bpam;
import bpbq;
import bqrh;
import com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView;
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
  private float jdField_a_of_type_Float;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CoverSelectView jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView;
  TextView b;
  
  private float a()
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
  
  private void a()
  {
    Object localObject = new CoverSelectView.UIConfigWrapper(getActivity(), 2130837907, 2130837699, 2130837698, 2130837737, 2130837738, 2130837923, 2130837924, 2130837905, 11);
    ((CoverSelectView.UIConfigWrapper)localObject).setPrevibarHeight(bqrh.b(getActivity(), 59.0F)).setPreviewBarWidth(bqrh.b(getActivity(), 34.0F)).setCoverDefaultProgress(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView = new CoverSelectView(getActivity(), (CoverSelectView.UIConfigWrapper)localObject);
    int i = bqrh.b(getActivity(), 4.0F);
    int j = bqrh.b(getActivity(), 2.0F);
    Log.d("AECoverSelectFragment", "addCoverSelectView: pixValue2Dip = " + j);
    int k = bqrh.b(getActivity(), 16.0F);
    int m = bqrh.b(getActivity(), 13.0F);
    localObject = new RoundCornerImageView(getActivity());
    ((RoundCornerImageView)localObject).setCorner(j);
    ((RoundCornerImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    localShapeDrawable.getPaint().setColor(-1);
    ((RoundCornerImageView)localObject).setBackgroundDrawable(localShapeDrawable);
    ((RoundCornerImageView)localObject).setPadding(j, j, j, j);
    this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView.setCoverPreviewBarBg(localShapeDrawable);
    this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView.setPreviewBar((ImageView)localObject);
    this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView.setPreviewBarElevation(15.0F);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView.setTimelineViewPadding(k, m, k, m);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void b()
  {
    a(true);
    float f = this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView.getCurrCoverProgress();
    Object localObject2 = this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView.getCurrCoverBitmap();
    if (localObject2 == null)
    {
      bpam.d("AECoverSelectFragment", "获取封面图失败");
      a(false);
      return;
    }
    for (;;)
    {
      try
      {
        Log.d("AECoverSelectFragment", "saveDataAndQuit: w=" + ((Bitmap)localObject2).getWidth() + " h=" + ((Bitmap)localObject2).getHeight());
        String str = bpbq.e + File.separator + this.jdField_a_of_type_JavaLangString + "_" + System.currentTimeMillis() + ".JPG";
        localFile = new File(str);
        if (localFile.getParentFile().exists()) {
          continue;
        }
        if (!localFile.getParentFile().mkdirs()) {
          bpam.d("AECoverSelectFragment", "保存封面，创建父路径失败");
        }
        if (!localFile.createNewFile()) {
          bpam.d("AECoverSelectFragment", "保存封面，创建封面文件失败");
        }
        if (!auog.a((Bitmap)localObject2, str)) {
          continue;
        }
        bpam.a("AECoverSelectFragment", "封面保存成功,path=" + str);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("key_video_cover_position", f);
        ((Intent)localObject2).putExtra("key_video_cover_path", str);
        ((Intent)localObject2).putExtra("key_video_media_path", a());
        getActivity().setResult(-1, (Intent)localObject2);
      }
      catch (Exception localException)
      {
        File localFile;
        localException.printStackTrace();
        bpam.d("AECoverSelectFragment", "封面保存出错:" + localException.toString());
        getActivity().setResult(0);
        return;
        bpam.d("AECoverSelectFragment", "封面保存出错");
        getActivity().setResult(0);
        continue;
      }
      finally
      {
        a(false);
        getActivity().finish();
      }
      a(false);
      getActivity().finish();
      return;
      auog.a(localFile.getParentFile());
    }
  }
  
  protected int a()
  {
    return 2131558543;
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentTavcutViewTAVCutVideoView = ((TAVCutVideoView)paramView.findViewById(2131378461));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370141));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366732));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379720));
    this.b = ((TextView)paramView.findViewById(2131379760));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  void a(VideoResourceModel paramVideoResourceModel)
  {
    a();
    this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView.bindPlayer(this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer);
    Log.d("AECoverSelectFragment", "initTavCutAndPlayer: \nresource.selectDuration = " + paramVideoResourceModel.getSelectTimeDuration() + "\nresource.start = " + paramVideoResourceModel.getSelectTimeStart() + "\n resource.end = " + (paramVideoResourceModel.getSelectTimeStart() + paramVideoResourceModel.getSelectTimeDuration()));
    this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView.updateTavVideoSession(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession);
    this.jdField_a_of_type_ComTencentTavcutTimelineCoverSelectView.setClipAndSpeed(paramVideoResourceModel.getSpeed(), paramVideoResourceModel.getSelectTimeDuration(), paramVideoResourceModel.getSelectTimeStart(), paramVideoResourceModel.getSelectTimeStart() + paramVideoResourceModel.getSelectTimeDuration());
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.pause();
    paramVideoResourceModel = CMTime.fromUs(((float)this.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.getDuration().getTimeUs() * this.jdField_a_of_type_Float / 100.0F));
    this.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(paramVideoResourceModel);
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
      b();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Float = a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558543, paramViewGroup, false);
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