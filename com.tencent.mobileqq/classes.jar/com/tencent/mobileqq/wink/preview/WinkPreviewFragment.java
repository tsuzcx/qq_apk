package com.tencent.mobileqq.wink.preview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.editor.WinkTAVCutBaseFragment;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataHelper;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.player.IPlayer.PlayerListener;
import com.tencent.tavcut.session.ISessionListener;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.ComposeRenderLayer;
import com.tencent.videocut.render.ComposeRenderLayer.RenderScene;
import com.tencent.videocut.render.repository.DataBuilder;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WinkPreviewFragment
  extends WinkTAVCutBaseFragment
  implements View.OnClickListener
{
  boolean f = true;
  private String g;
  private FrameLayout h;
  private SeekBar i;
  private RelativeLayout j;
  private TextView k;
  private TextView l;
  private ArrayList<LocalMediaInfo> m;
  private ImageView n;
  private ImageView o;
  
  private MediaData a(LocalMediaInfo paramLocalMediaInfo, long paramLong)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    if (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1) {
      return new MediaData(0, paramLocalMediaInfo.mMimeType, 720, 1280, 0L, 0L, 1000L * paramLocalMediaInfo.mDuration, paramLocalMediaInfo.path, paramLocalMediaInfo.path, paramLocalMediaInfo.mAlbumName);
    }
    return new MediaData(1, paramLocalMediaInfo.mMimeType, 720, 1280, 0L, 0L, paramLong, paramLocalMediaInfo.path, paramLocalMediaInfo.path, paramLocalMediaInfo.mAlbumName);
  }
  
  private String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long l1 = paramLong / 1000000L;
    paramLong = l1 % 60L;
    l1 /= 60L;
    String str2 = "0";
    String str1;
    if (l1 < 10L) {
      str1 = "0";
    } else {
      str1 = "";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(l1);
    localStringBuilder.append(":");
    if (paramLong < 10L) {
      str1 = str2;
    } else {
      str1 = "";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  private void n()
  {
    if (e() != null) {
      e().setOnClickListener(this);
    }
    this.o.setOnClickListener(this);
  }
  
  private void o()
  {
    FrameLayout localFrameLayout = this.h;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(0);
    }
    this.j.setVisibility(8);
    this.h.setOnTouchListener(new WinkPreviewFragment.1(this));
    this.i.setMax(1000);
    this.i.setOnSeekBarChangeListener(new WinkPreviewFragment.2(this));
  }
  
  private void u()
  {
    AEQLog.a("WinkPreviewFragment", "initParamsFromIntent, getMissionId");
    Object localObject = getArguments();
    if (getActivity().getIntent().getExtras() != null)
    {
      this.g = getActivity().getIntent().getStringExtra("key_wink_video_mission_id");
      this.m = getActivity().getIntent().getParcelableArrayListExtra("localMediaInfos");
    }
    if ((TextUtils.isEmpty(this.g)) && (localObject != null) && (((Bundle)localObject).containsKey("key_wink_video_mission_id"))) {
      this.g = ((Bundle)localObject).getString("key_wink_video_mission_id");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("missionId = ");
    ((StringBuilder)localObject).append(this.g);
    AEQLog.a("WinkPreviewFragment", ((StringBuilder)localObject).toString());
  }
  
  protected String a()
  {
    WinkEditDataWrapper localWinkEditDataWrapper = WinkEditDataHelper.a(getActivity().getIntent().getStringExtra("key_wink_video_mission_id"));
    if (localWinkEditDataWrapper != null) {
      return localWinkEditDataWrapper.getTemplateFilePath();
    }
    return null;
  }
  
  public void a(String paramString)
  {
    Object localObject = new ComposeRenderLayer(this.a, new MediaModel(), ComposeRenderLayer.RenderScene.VIDEO);
    paramString = WinkEditDataHelper.a(paramString);
    if (paramString != null)
    {
      paramString = paramString.getEditDatas();
      if ((paramString != null) && (paramString.size() == 1) && (paramString.get(0) != null))
      {
        paramString = ((WinkEditData)paramString.get(0)).getMediaModel();
        if (paramString != null) {
          ((ComposeRenderLayer)localObject).a(paramString);
        }
      }
    }
    else
    {
      paramString = new ArrayList();
      localObject = this.m;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.m.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MediaData localMediaData = a((LocalMediaInfo)((Iterator)localObject).next(), 2500000L);
          if (localMediaData != null) {
            paramString.add(localMediaData);
          }
        }
      }
      paramString = DataBuilder.a.a(paramString);
      new ComposeRenderLayer(this.a, new MediaModel(), ComposeRenderLayer.RenderScene.VIDEO).a(paramString);
      this.b.a();
    }
  }
  
  public String b()
  {
    return null;
  }
  
  protected int c()
  {
    return 2131629704;
  }
  
  protected List<Part> d()
  {
    return null;
  }
  
  protected FrameLayout e()
  {
    return (FrameLayout)getView().findViewById(2131446854);
  }
  
  protected ISessionListener f()
  {
    return null;
  }
  
  protected IPlayer.PlayerListener g()
  {
    return new WinkPreviewFragment.3(this);
  }
  
  protected int j()
  {
    return 0;
  }
  
  public String l()
  {
    return "";
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131446854) && (this.b != null))
    {
      if (this.f)
      {
        this.f = false;
        this.b.b();
        this.n.setVisibility(0);
      }
      else
      {
        this.f = true;
        this.b.a();
        this.n.setVisibility(8);
      }
    }
    else if ((paramView.getId() == 2131442811) && (getActivity() != null)) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ImmersiveUtils.setStatusTextColor(QQTheme.isNowThemeIsNight() ^ true, getActivity().getWindow());
    u();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.h = ((FrameLayout)paramView.findViewById(2131433326));
    this.i = ((SeekBar)paramView.findViewById(2131433386));
    this.k = ((TextView)paramView.findViewById(2131433327));
    this.l = ((TextView)paramView.findViewById(2131433329));
    this.j = ((RelativeLayout)paramView.findViewById(2131450181));
    this.n = ((ImageView)paramView.findViewById(2131442812));
    this.o = ((ImageView)paramView.findViewById(2131442811));
    a(this.g);
    o();
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.preview.WinkPreviewFragment
 * JD-Core Version:    0.7.0.1
 */