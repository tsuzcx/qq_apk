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
  protected Activity a;
  protected Drawable a;
  protected View a;
  protected LinearLayout a;
  public MediaInfo a;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  protected CharSequence a;
  protected ArrayList<String> a;
  private boolean jdField_a_of_type_Boolean = false;
  protected LinearLayout b;
  private boolean b;
  private int g = 0;
  private int h = 9;
  
  public PublishItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130848074);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_JavaLangCharSequence = BaseApplication.getContext().getResources().getText(2131717715);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    addView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(16);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramAttributeSet);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, (int)DisplayUtils.a(paramContext, 7.0F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131559914, null);
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a()
  {
    if (this.g == 2)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo;
      if (!(localObject1 instanceof AudioInfo)) {
        return;
      }
      localObject1 = (AudioInfo)localObject1;
      ((AudioInfo)localObject1).mAudioIcon.setImageResource(2130850309);
      Object localObject2 = new Intent("key_audio_playing_action");
      ((Intent)localObject2).putExtra("audio_local_path", ((AudioInfo)localObject1).path);
      BaseApplication.getContext().sendBroadcast((Intent)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(((AudioInfo)localObject1).path, new Handler(), ((AudioInfo)localObject1).getAudioType());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        this.jdField_b_of_type_Boolean = true;
        localObject2 = (AnimationDrawable)BaseApplicationImpl.getApplication().getResources().getDrawable(2130772225);
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
    Object localObject = paramView.findViewById(2131368657);
    URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131380276);
    localURLImageView.setImageResource(2130848826);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
    if (localObject != null)
    {
      ((VoicePlayer)localObject).e();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      this.jdField_b_of_type_Boolean = false;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo;
      if (!(localObject instanceof AudioInfo)) {
        return;
      }
      localObject = (AudioInfo)localObject;
      if ((((AudioInfo)localObject).mAudioIcon.getDrawable() instanceof AnimationDrawable)) {
        ((AnimationDrawable)((AudioInfo)localObject).mAudioIcon.getDrawable()).stop();
      }
      ((AudioInfo)localObject).mAudioIcon.setImageResource(2130850309);
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131368657)
    {
      if (i != 2131380276)
      {
        switch (i)
        {
        default: 
          break;
        case 2131363037: 
          b();
          localObject = new Intent("key_audio_delete_action");
          BaseApplication.getContext().sendBroadcast((Intent)localObject);
          this.g = 0;
          this.jdField_a_of_type_ComTencentMobileqqTroopDataMediaInfo = null;
          break;
        case 2131363035: 
        case 2131363036: 
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
          {
            a();
            if (!this.jdField_a_of_type_Boolean)
            {
              localObject = new Intent("key_audio_play_action");
              BaseApplication.getContext().sendBroadcast((Intent)localObject);
              this.jdField_a_of_type_Boolean = true;
            }
          }
          else
          {
            b();
          }
          break;
        }
      }
      else if (paramView.getTag() != null)
      {
        localObject = (String)paramView.getTag();
        i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject);
        AlbumUtil.a();
        localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, NewPhotoPreviewActivity.class);
        ((Intent)localObject).putExtra("ALBUM_ID", "$RecentAlbumId");
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_AndroidAppActivity.getClass().getName());
        ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.jdField_a_of_type_JavaUtilArrayList);
        ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.jdField_a_of_type_JavaUtilArrayList.size());
        ((Intent)localObject).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", i);
        ((Intent)localObject).putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", true);
        ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        ((Intent)localObject).putExtra("from_tribe_class_name", this.jdField_a_of_type_AndroidAppActivity.getClass().getSimpleName());
        ((Intent)localObject).putExtra("PhotoConst.IS_OVERLOAD", false);
        ((Intent)localObject).addFlags(603979776);
        getContext().startActivity((Intent)localObject);
        AlbumUtil.anim(this.jdField_a_of_type_AndroidAppActivity, false, true);
      }
      else
      {
        localObject = new Intent("key_photo_add_action");
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
      }
    }
    else
    {
      localObject = (String)paramView.getTag();
      i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localObject);
      this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(i);
      localObject = new Intent("key_photo_delete_action");
      ((Intent)localObject).putExtra("key_photo_delete_position", i);
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.g = 0;
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setCurType(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setItemEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(paramBoolean);
    if (this.g == 2)
    {
      View localView2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0);
      View localView1 = localView2.findViewById(2131363036);
      localView2 = localView2.findViewById(2131363037);
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
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemContainer
 * JD-Core Version:    0.7.0.1
 */