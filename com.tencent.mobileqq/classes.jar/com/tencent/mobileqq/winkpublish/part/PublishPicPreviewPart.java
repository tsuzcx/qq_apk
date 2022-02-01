package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._PhotoConst;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QAlbumConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QQStoryMainActivity;
import com.tencent.biz.richframework.widget.MultiPicViewPager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.winkpublish.base.BaseBlockPart;
import com.tencent.mobileqq.winkpublish.bean.QCirclePicPreviewBean;
import com.tencent.mobileqq.winkpublish.preview.adapter.QCirclePicPreviewMoveAdapter;
import com.tencent.mobileqq.winkpublish.preview.adapter.QCirclePicPreviewPagerAdapter;
import com.tencent.mobileqq.winkpublish.widget.PublishCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PublishPicPreviewPart
  extends BaseBlockPart
  implements View.OnClickListener
{
  private QCirclePicPreviewMoveAdapter a;
  private QCirclePicPreviewPagerAdapter b;
  private MultiPicViewPager e;
  private ImageView f;
  private TextView g;
  private boolean h;
  private MediaPlayer i;
  private String j;
  private int k;
  private ArrayList<LocalMediaInfo> l;
  
  private void a(int paramInt)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((QCirclePicPreviewPagerAdapter)localObject).a().size() != 0))
    {
      int m = this.b.a().size();
      this.g.setVisibility(0);
      this.g.setText(g().getResources().getString(2131895836, new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(m) }));
      return;
    }
    localObject = this.g;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public static boolean a(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[localMusicExists], localMusicPath=");
    localStringBuilder.append(paramString);
    QLog.d("QCirclePublishPicPreviewPart", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  private void d()
  {
    if (c() == null) {
      return;
    }
    Intent localIntent = c().getIntent();
    if (localIntent == null) {
      return;
    }
    if (localIntent.hasExtra("localMediaInfos")) {
      this.l = ((ArrayList)localIntent.getSerializableExtra("localMediaInfos"));
    }
    if (localIntent.hasExtra("PUBLISH_MUSIC_START_TIME")) {
      this.k = ((int)localIntent.getLongExtra("PUBLISH_MUSIC_START_TIME", 0L));
    }
    if (localIntent.hasExtra("PUBLISH_MUSIC_LOCAL_PATH")) {
      this.j = localIntent.getStringExtra("PUBLISH_MUSIC_LOCAL_PATH");
    }
  }
  
  private ArrayList<QCirclePicPreviewBean> e()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.l;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        return localArrayList;
      }
      localObject = this.l.iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        if (localLocalMediaInfo != null) {
          localArrayList.add(new QCirclePicPreviewBean(localLocalMediaInfo.path, localLocalMediaInfo));
        }
      }
    }
    return localArrayList;
  }
  
  private void f()
  {
    this.b = new QCirclePicPreviewPagerAdapter();
    this.b.a(e());
    this.e.setAdapter(this.b);
    this.e.addOnPageChangeListener(new PublishPicPreviewPart.1(this));
    a(0);
  }
  
  private void l()
  {
    c().finish();
  }
  
  private void m()
  {
    MediaPlayer localMediaPlayer = this.i;
    if (localMediaPlayer == null)
    {
      this.i = new ReportMediaPlayer();
    }
    else
    {
      localMediaPlayer.stop();
      this.i.reset();
    }
    if (a(this.j)) {
      try
      {
        this.i.setAudioStreamType(3);
        this.i.setDataSource(this.j);
        this.i.setVolume(0.5F, 0.5F);
        this.i.setOnSeekCompleteListener(new PublishPicPreviewPart.3(this));
        this.i.prepare();
        this.i.seekTo(this.k);
        this.i.setLooping(true);
        this.i.start();
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playImageMusic, exception = ");
        localStringBuilder.append(localException.toString());
        QLog.d("QCirclePublishPicPreviewPart", 1, localStringBuilder.toString());
      }
    }
  }
  
  public String a()
  {
    return "QCirclePublishPicPreviewPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    HostUIHelper.closeHostEnvironment();
    if ((QCircleHostConstants._QQStoryMainActivity.REQUEST_CODE_TAKE_VIDEO() == paramInt1) && (paramInt2 == -1))
    {
      Object localObject2 = paramIntent.getStringArrayListExtra(QCircleHostConstants._PhotoConst.PHOTO_PATHS());
      Object localObject1 = (HashMap)paramIntent.getSerializableExtra(QCircleHostConstants._QAlbumConstants.SELECTED_MEDIA_INFO_HASH_MAP());
      if (localObject2 != null)
      {
        if (((ArrayList)localObject2).size() == 0) {
          return;
        }
        paramIntent = new ArrayList();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          paramIntent.add(new QCirclePicPreviewBean(str, (LocalMediaInfo)((HashMap)localObject1).get(str)));
        }
        localObject1 = this.a;
        if ((localObject1 != null) && (this.b != null))
        {
          ((QCirclePicPreviewMoveAdapter)localObject1).a(paramIntent);
          this.b.a(this.a.a());
          localObject1 = this.e;
          if (localObject1 != null) {
            a(((MultiPicViewPager)localObject1).getCurrentItem());
          }
        }
        if (paramIntent.size() > 0) {
          this.h = true;
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.e = ((MultiPicViewPager)paramView.findViewById(2131450005));
    this.f = ((ImageView)paramView.findViewById(2131436275));
    this.g = ((TextView)paramView.findViewById(2131448641));
    this.f.setOnClickListener(this);
    d();
    f();
    m();
  }
  
  public boolean ah_()
  {
    if (this.h)
    {
      PublishPicPreviewPart.2 local2 = new PublishPicPreviewPart.2(this);
      PublishCustomDialog.a(g(), HardCodeUtil.a(2131895834), null, 2131887648, 2131895835, local2, local2).show();
    }
    else
    {
      l();
    }
    return true;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.i;
    if (paramActivity != null) {
      paramActivity.release();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    paramActivity = this.i;
    if ((paramActivity != null) && (paramActivity.isPlaying())) {
      this.i.pause();
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = this.i;
    if ((paramActivity != null) && (!paramActivity.isPlaying())) {
      this.i.start();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131436275) {
      ah_();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishPicPreviewPart
 * JD-Core Version:    0.7.0.1
 */