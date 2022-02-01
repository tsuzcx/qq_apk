package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.io.File;
import mqq.app.MobileQQ;

public class AudioItem
  extends UploadEditItem<AudioItem.AudioViewHolder, AudioInfo>
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new AudioItem.4(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AudioInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo;
  private VoicePlayer.VoicePlayerListener jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer$VoicePlayerListener = new AudioItem.3(this);
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
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
    if (this.b) {
      return;
    }
    this.b = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo = paramAudioInfo;
    paramAudioInfo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramAudioInfo.jdField_a_of_type_JavaLangString, new Handler());
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer$VoicePlayerListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
    AudioItem.AudioViewHolder localAudioViewHolder = (AudioItem.AudioViewHolder)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(paramAudioInfo.jdField_c_of_type_Int);
    if (localAudioViewHolder != null)
    {
      if (paramAudioInfo.jdField_a_of_type_Boolean)
      {
        paramAudioInfo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772313);
        localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAudioInfo);
        paramAudioInfo.start();
        return;
      }
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847265);
    }
  }
  
  private void h(AudioInfo paramAudioInfo)
  {
    TroopHomeworkHelper.UploadFileTask localUploadFileTask = new TroopHomeworkHelper.UploadFileTask(MobileQQ.sMobileQQ.waitAppRuntime(null), paramAudioInfo.jdField_a_of_type_JavaLangString, paramAudioInfo.jdField_c_of_type_JavaLangString);
    localUploadFileTask.a(new AudioItem.AudioUploadCallback(this, paramAudioInfo));
    paramAudioInfo.f = 1;
    ThreadManager.post(new AudioItem.2(this, localUploadFileTask), 8, null, true);
  }
  
  public AudioItem.AudioViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new AudioItem.AudioViewHolder(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561524, paramViewGroup, false));
    b(paramViewGroup.b, paramViewGroup);
    b(paramViewGroup.c, paramViewGroup);
    b(paramViewGroup.jdField_a_of_type_AndroidViewView, paramViewGroup);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
      localLayoutParams.leftMargin = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
      localLayoutParams.rightMargin = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
    }
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
    int i = paramView.getId();
    if (i == 2131363049)
    {
      if ((TextUtils.isEmpty(((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).b))) {
        return;
      }
      a((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase);
      return;
    }
    if (i == 2131376497)
    {
      h((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase);
      paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramAudioViewHolder.c.setVisibility(4);
      return;
    }
    if (i == 2131364719)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(paramAudioViewHolder);
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo;
      if ((paramView != null) && (paramView.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.jdField_c_of_type_Int == ((AudioInfo)paramAudioViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).jdField_c_of_type_Int)) {
        b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo);
      }
    }
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
    if (paramInt != 0)
    {
      paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramAudioViewHolder.b.setVisibility(4);
      paramAudioViewHolder.c.setVisibility(4);
    }
    else
    {
      paramAudioViewHolder.b.setVisibility(0);
      paramInt = paramAudioInfo.f;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 3)
            {
              paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramAudioViewHolder.c.setVisibility(4);
            }
          }
          else
          {
            paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
            paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            paramAudioViewHolder.c.setVisibility(0);
          }
        }
        else
        {
          paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
          paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          paramAudioViewHolder.c.setVisibility(4);
        }
      }
      else
      {
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramAudioViewHolder.c.setVisibility(4);
      }
    }
    TextView localTextView = paramAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAudioInfo.jdField_a_of_type_Int);
    localStringBuilder.append("\"");
    localTextView.setText(localStringBuilder.toString());
    if (paramAudioInfo.jdField_a_of_type_Boolean)
    {
      paramAudioInfo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772313);
      paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAudioInfo);
      paramAudioInfo.start();
      return;
    }
    paramAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847265);
  }
  
  public void b(AudioInfo paramAudioInfo)
  {
    if ((paramAudioInfo != null) && (paramAudioInfo.jdField_a_of_type_Boolean))
    {
      this.b = false;
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      paramAudioInfo.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo = null;
      AudioItem.AudioViewHolder localAudioViewHolder = (AudioItem.AudioViewHolder)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForAdapterPosition(paramAudioInfo.jdField_c_of_type_Int);
      if (localAudioViewHolder != null)
      {
        if (paramAudioInfo.jdField_a_of_type_Boolean)
        {
          paramAudioInfo = (AnimationDrawable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130772313);
          localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAudioInfo);
          paramAudioInfo.start();
          return;
        }
        localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847265);
      }
    }
  }
  
  public void c(AudioInfo paramAudioInfo)
  {
    if ((!TextUtils.isEmpty(paramAudioInfo.jdField_a_of_type_JavaLangString)) && (new File(paramAudioInfo.jdField_a_of_type_JavaLangString).exists()))
    {
      g(paramAudioInfo);
      return;
    }
    if (!TextUtils.isEmpty(paramAudioInfo.b))
    {
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
      {
        paramAudioInfo = this.jdField_a_of_type_AndroidContentContext;
        QQToast.a(paramAudioInfo, paramAudioInfo.getString(2131693759), 0).a();
        return;
      }
      ThreadManager.post(new AudioItem.1(this, paramAudioInfo), 8, null, true);
    }
  }
  
  public void d(AudioInfo paramAudioInfo)
  {
    e(paramAudioInfo);
  }
  
  public void e(AudioInfo paramAudioInfo)
  {
    if (TextUtils.isEmpty(paramAudioInfo.b))
    {
      if (paramAudioInfo.f != 0) {
        return;
      }
      h(paramAudioInfo);
    }
  }
  
  public void f(AudioInfo paramAudioInfo)
  {
    if ((TextUtils.isEmpty(paramAudioInfo.b)) && (paramAudioInfo.f == 1)) {
      h(paramAudioInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem
 * JD-Core Version:    0.7.0.1
 */