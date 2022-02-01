package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.mobileqq.widget.QQToast;

class GuildMixedMsgItemBuilder$3
  implements View.OnClickListener
{
  GuildMixedMsgItemBuilder$3(GuildMixedMsgItemBuilder paramGuildMixedMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    long l = System.currentTimeMillis();
    if (l - GuildMixedMsgItemBuilder.a(this.a) < 1000L) {
      return;
    }
    GuildMixedMsgItemBuilder.a(this.a, l);
    Object localObject = (URLImageView)paramView;
    MessageForPic localMessageForPic = (MessageForPic)((URLImageView)localObject).getTag(2131430592);
    URLDrawable localURLDrawable = (URLDrawable)((URLImageView)localObject).getDrawable();
    if (localURLDrawable == null) {
      return;
    }
    int i = localURLDrawable.getStatus();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        localObject = ((IPicAIO)QRoute.api(IPicAIO.class)).getReceivePicFailedTip(localURLDrawable);
        if (localObject != null)
        {
          QQToast.makeText(paramView.getContext(), (CharSequence)localObject, 0).show();
          return;
        }
        if (FolderUtils.a(paramView.getContext())) {
          localURLDrawable.restartDownload();
        }
      }
      else
      {
        if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(localMessageForPic))
        {
          AIOEmotionFragment.a(paramView.getContext(), localMessageForPic, this.a.c, AnimationUtils.a(paramView));
          return;
        }
        localMessageForPic.isInMixedMsg = true;
        PicItemBuilder.a(PlayModeUtils.b(), paramView.getContext(), (View)localObject, localMessageForPic, this.a.c, false, true, true, null);
      }
    }
    else if (!localURLDrawable.isDownloadStarted()) {
      localURLDrawable.startDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMixedMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */