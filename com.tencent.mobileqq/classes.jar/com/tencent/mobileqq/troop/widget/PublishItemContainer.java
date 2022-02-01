package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.troop.data.MediaInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.CustomHorizontalScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class PublishItemContainer
  extends CustomHorizontalScrollView
  implements View.OnClickListener, VoicePlayer.VoicePlayerListener
{
  protected LinearLayout a;
  protected LinearLayout b;
  protected View c;
  protected ArrayList<String> d = new ArrayList();
  protected Drawable e = null;
  protected CharSequence f = null;
  protected Activity g;
  public MediaInfo h;
  private VoicePlayer t;
  private int u = 0;
  private int v = 9;
  private boolean w = false;
  private boolean x = false;
  
  public PublishItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = ((Activity)paramContext);
    this.f = BaseApplication.getContext().getResources().getText(2131915190);
    this.b = new LinearLayout(paramContext);
    addView(this.b);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    this.b.setOrientation(0);
    this.b.setGravity(16);
    this.b.setLayoutParams(paramAttributeSet);
    this.b.setPadding(0, 0, 0, (int)DisplayUtils.a(paramContext, 7.0F));
    this.a = new LinearLayout(paramContext);
    this.b.addView(this.a);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.a.setOrientation(0);
    this.a.setGravity(16);
    this.a.setLayoutParams(paramContext);
    this.c = LayoutInflater.from(getContext()).inflate(2131625957, null);
    a(this.c);
    this.c.setVisibility(8);
    this.b.addView(this.c);
  }
  
  public void a()
  {
    if (this.u == 2)
    {
      Object localObject1 = this.h;
      if (!(localObject1 instanceof AudioInfo)) {
        return;
      }
      localObject1 = (AudioInfo)localObject1;
      ((AudioInfo)localObject1).mAudioIcon.setImageResource(2130852100);
      Object localObject2 = new Intent("key_audio_playing_action");
      ((Intent)localObject2).putExtra("audio_local_path", ((AudioInfo)localObject1).path);
      BaseApplication.getContext().sendBroadcast((Intent)localObject2);
      if (this.t == null)
      {
        this.t = new VoicePlayer(((AudioInfo)localObject1).path, new Handler(), ((AudioInfo)localObject1).getAudioType());
        this.t.a(getContext());
        this.t.h();
        this.t.a(this);
        this.t.c();
        this.x = true;
        localObject2 = (AnimationDrawable)BaseApplicationImpl.getApplication().getResources().getDrawable(2130772291);
        ((AudioInfo)localObject1).mAudioIcon.setImageDrawable((Drawable)localObject2);
        ((AnimationDrawable)localObject2).start();
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    b();
  }
  
  protected void a(View paramView)
  {
    Object localObject = paramView.findViewById(2131435570);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131449194);
    localURLImageView.setImageResource(2130850493);
    ((View)localObject).setVisibility(8);
    localURLImageView.setAdjustViewBounds(false);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localURLImageView.getLayoutParams();
    localLayoutParams.width = ((int)DisplayUtils.a(getContext(), 50.0F));
    localLayoutParams.height = ((int)DisplayUtils.a(getContext(), 50.0F));
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    localURLImageView.setOnClickListener(this);
    localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 2.0F);
    localObject = new LinearLayout.LayoutParams((int)DisplayUtils.a(getContext(), 60.0F), (int)DisplayUtils.a(getContext(), 67.0F));
    ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(getContext(), 2.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(getContext(), 4.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void b()
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      ((VoicePlayer)localObject).f();
      this.t = null;
      this.x = false;
      localObject = this.h;
      if (!(localObject instanceof AudioInfo)) {
        return;
      }
      localObject = (AudioInfo)localObject;
      if ((((AudioInfo)localObject).mAudioIcon.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)((AudioInfo)localObject).mAudioIcon.getDrawable()).stop();
      }
      ((AudioInfo)localObject).mAudioIcon.setImageResource(2130852100);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public String getAudioPath()
  {
    if (this.u == 2)
    {
      MediaInfo localMediaInfo = this.h;
      if ((localMediaInfo instanceof AudioInfo)) {
        return ((AudioInfo)localMediaInfo).path;
      }
    }
    return null;
  }
  
  public int getCurType()
  {
    return this.u;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.h;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    int i;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131449194: 
      if (paramView.getTag() != null)
      {
        localObject = (String)paramView.getTag();
        i = this.d.indexOf(localObject);
        AlbumUtil.a();
        localObject = new Intent(this.g, NewPhotoPreviewActivity.class);
        ((Intent)localObject).putExtra("ALBUM_ID", "$RecentAlbumId");
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.g.getClass().getName());
        ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.d);
        ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.d.size());
        ((Intent)localObject).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
        ((Intent)localObject).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
        ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        ((Intent)localObject).putExtra("from_tribe_class_name", this.g.getClass().getSimpleName());
        ((Intent)localObject).putExtra("PhotoConst.IS_OVERLOAD", false);
        ((Intent)localObject).addFlags(603979776);
        getContext().startActivity((Intent)localObject);
        AlbumUtil.anim(this.g, false, true);
      }
      else
      {
        localObject = new Intent("key_photo_add_action");
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
      }
      break;
    case 2131435570: 
      localObject = (String)paramView.getTag();
      i = this.d.indexOf(localObject);
      this.d.remove(i);
      this.a.removeViewAt(i);
      localObject = new Intent("key_photo_delete_action");
      ((Intent)localObject).putExtra("key_photo_delete_position", i);
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
      if (this.d.size() == 0)
      {
        setVisibility(8);
        this.c.setVisibility(8);
        this.u = 0;
      }
      else
      {
        this.c.setVisibility(0);
      }
      break;
    case 2131428853: 
      b();
      localObject = new Intent("key_audio_delete_action");
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
      this.u = 0;
      this.h = null;
      break;
    case 2131428849: 
    case 2131428852: 
      if (this.t == null)
      {
        a();
        if (!this.w)
        {
          localObject = new Intent("key_audio_play_action");
          BaseApplication.getContext().sendBroadcast((Intent)localObject);
          this.w = true;
        }
      }
      else
      {
        b();
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCurType(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void setItemEnable(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
    if (this.u == 2)
    {
      View localView2 = this.a.getChildAt(0);
      View localView1 = localView2.findViewById(2131428852);
      localView2 = localView2.findViewById(2131428853);
      if ((localView1 != null) && (localView2 != null))
      {
        localView1.setEnabled(paramBoolean);
        localView2.setEnabled(paramBoolean);
      }
    }
    setEnabled(paramBoolean);
  }
  
  public void setMaxPicNum(int paramInt)
  {
    this.v = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemContainer
 * JD-Core Version:    0.7.0.1
 */