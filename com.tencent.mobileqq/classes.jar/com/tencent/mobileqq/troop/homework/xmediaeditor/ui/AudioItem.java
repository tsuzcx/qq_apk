package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import ajsc;
import ajse;
import ajsf;
import ajsg;
import ajsh;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.io.File;

public class AudioItem
  extends UploadEditItem
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ajsg(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AudioInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo;
  private VoicePlayer.VoicePlayerListener jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer$VoicePlayerListener = new ajsf(this);
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  
  public AudioItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    paramXMediaEditor = new IntentFilter();
    paramXMediaEditor.addAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
    paramXMediaEditor.addAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramXMediaEditor);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void g(AudioInfo paramAudioInfo)
  {
    if (this.b) {}
    AudioItem.AudioViewHolder localAudioViewHolder;
    do
    {
      return;
      this.b = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo = paramAudioInfo;
      paramAudioInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramAudioInfo.jdField_a_of_type_JavaLangString, new Handler());
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer$VoicePlayerListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
      localAudioViewHolder = (AudioItem.AudioViewHolder)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(paramAudioInfo.jdField_c_of_type_Int);
    } while (localAudioViewHolder == null);
    if (paramAudioInfo.jdField_a_of_type_Boolean)
    {
      paramAudioInfo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2131034360);
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAudioInfo);
      paramAudioInfo.start();
      return;
    }
    localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843969);
  }
  
  private void h(AudioInfo paramAudioInfo)
  {
    TroopHomeworkHelper.UploadFileTask localUploadFileTask = new TroopHomeworkHelper.UploadFileTask(PlayModeUtils.a(), paramAudioInfo.jdField_a_of_type_JavaLangString, paramAudioInfo.jdField_c_of_type_JavaLangString);
    localUploadFileTask.a(new ajsh(this, paramAudioInfo));
    paramAudioInfo.g = 1;
    ThreadManager.post(new ajse(this, localUploadFileTask), 8, null, true);
  }
  
  public AudioItem.AudioViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new AudioItem.AudioViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970661, paramViewGroup, false));
    b(paramViewGroup.b, paramViewGroup);
    b(paramViewGroup.c, paramViewGroup);
    b(paramViewGroup.jdField_a_of_type_AndroidViewView, paramViewGroup);
    return paramViewGroup;
  }
  
  public void a()
  {
    if (this.b) {
      b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, AudioItem.AudioViewHolder paramAudioViewHolder)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).b)));
      a((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase);
      return;
      h((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase);
      paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramAudioViewHolder.c.setVisibility(4);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(paramAudioViewHolder);
    } while ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.jdField_c_of_type_Int != ((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).jdField_c_of_type_Int));
    b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo);
  }
  
  public void a(AudioInfo paramAudioInfo)
  {
    if (this.b)
    {
      if (paramAudioInfo.jdField_a_of_type_Boolean)
      {
        b(paramAudioInfo);
        return;
      }
      b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo);
      c(paramAudioInfo);
      return;
    }
    c(paramAudioInfo);
  }
  
  public void a(AudioItem.AudioViewHolder paramAudioViewHolder, AudioInfo paramAudioInfo, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramAudioViewHolder.b.setVisibility(4);
      paramAudioViewHolder.c.setVisibility(4);
    }
    for (;;)
    {
      paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramAudioInfo.jdField_a_of_type_Int + "\"");
      if (!paramAudioInfo.jdField_a_of_type_Boolean) {
        break;
      }
      paramAudioInfo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2131034360);
      paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAudioInfo);
      paramAudioInfo.start();
      return;
      paramAudioViewHolder.b.setVisibility(0);
      switch (paramAudioInfo.g)
      {
      default: 
        break;
      case 0: 
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramAudioViewHolder.c.setVisibility(4);
        break;
      case 1: 
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramAudioViewHolder.c.setVisibility(4);
        break;
      case 2: 
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramAudioViewHolder.c.setVisibility(0);
        break;
      case 3: 
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramAudioViewHolder.c.setVisibility(4);
      }
    }
    paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843969);
  }
  
  public void b(AudioInfo paramAudioInfo)
  {
    AudioItem.AudioViewHolder localAudioViewHolder;
    if ((paramAudioInfo != null) && (paramAudioInfo.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      paramAudioInfo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo = null;
      localAudioViewHolder = (AudioItem.AudioViewHolder)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(paramAudioInfo.jdField_c_of_type_Int);
      if (localAudioViewHolder != null)
      {
        if (!paramAudioInfo.jdField_a_of_type_Boolean) {
          break label93;
        }
        paramAudioInfo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2131034360);
        localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAudioInfo);
        paramAudioInfo.start();
      }
    }
    return;
    label93:
    localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843969);
  }
  
  public void c(AudioInfo paramAudioInfo)
  {
    if ((!TextUtils.isEmpty(paramAudioInfo.jdField_a_of_type_JavaLangString)) && (new File(paramAudioInfo.jdField_a_of_type_JavaLangString).exists())) {
      g(paramAudioInfo);
    }
    while (TextUtils.isEmpty(paramAudioInfo.b)) {
      return;
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131427563), 0).a();
      return;
    }
    ThreadManager.post(new ajsc(this, paramAudioInfo), 8, null, true);
  }
  
  public void d(AudioInfo paramAudioInfo)
  {
    e(paramAudioInfo);
  }
  
  public void e(AudioInfo paramAudioInfo)
  {
    if ((!TextUtils.isEmpty(paramAudioInfo.b)) || (paramAudioInfo.g != 0)) {
      return;
    }
    h(paramAudioInfo);
  }
  
  public void f(AudioInfo paramAudioInfo)
  {
    if ((TextUtils.isEmpty(paramAudioInfo.b)) && (paramAudioInfo.g == 1)) {
      h(paramAudioInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem
 * JD-Core Version:    0.7.0.1
 */