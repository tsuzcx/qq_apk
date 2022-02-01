package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class GuildMarketFaceItemBuilder$MarketFaceView
  extends URLImageView
{
  public GuildMarketFaceItemBuilder$MarketFaceView(GuildMarketFaceItemBuilder paramGuildMarketFaceItemBuilder, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadSuccessed  holder == null url=");
      ((StringBuilder)localObject).append(paramURLDrawable.getURL());
      QLog.e("MarketFaceItemBuilder", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (((GuildMarketFaceItemBuilder.Holder)localObject).a == null)
    {
      int j = -1;
      paramURLDrawable = ((GuildMarketFaceItemBuilder.Holder)localObject).q;
      int i = j;
      if ((paramURLDrawable instanceof MessageForMarketFace))
      {
        paramURLDrawable = ((MessageForMarketFace)paramURLDrawable).mMarkFaceMessage;
        i = j;
        if (paramURLDrawable != null) {
          i = paramURLDrawable.dwTabID;
        }
      }
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadSuccessed  emoticonInfo == null epId = ");
      paramURLDrawable.append(i);
      QLog.e("MarketFaceItemBuilder", 1, paramURLDrawable.toString());
      return;
    }
    GuildMarketFaceItemBuilder.b(this.a, (GuildMarketFaceItemBuilder.Holder)localObject);
    this.a.a((GuildMarketFaceItemBuilder.Holder)localObject, paramURLDrawable);
    if ((2 == ((GuildMarketFaceItemBuilder.Holder)localObject).a.getEmoticon().jobType) && (MagicfaceViewController.b()) && (this.a.r.verifyMagicFacePackageIntact(((GuildMarketFaceItemBuilder.Holder)localObject).a.getEmoticon().epId))) {
      if (PngFrameUtil.b(((GuildMarketFaceItemBuilder.Holder)localObject).a.getEmoticon().magicValue) == 1)
      {
        ((GuildMarketFaceItemBuilder.Holder)localObject).i.setVisibility(8);
      }
      else
      {
        ((GuildMarketFaceItemBuilder.Holder)localObject).i.setImageResource(2130837998);
        ((GuildMarketFaceItemBuilder.Holder)localObject).i.setVisibility(0);
      }
    }
    if ((4 == ((GuildMarketFaceItemBuilder.Holder)localObject).a.getEmoticon().jobType) && (this.a.r.isDPCSupportH5Magic()) && (this.a.r.isH5MagicIntact(((GuildMarketFaceItemBuilder.Holder)localObject).a.getEmoticon().epId, true, true)))
    {
      ((GuildMarketFaceItemBuilder.Holder)localObject).i.setImageResource(2130837998);
      ((GuildMarketFaceItemBuilder.Holder)localObject).i.setVisibility(0);
    }
    if ((GuildMarketFaceItemBuilder.q != 0L) && (GuildMarketFaceItemBuilder.q == ((GuildMarketFaceItemBuilder.Holder)localObject).q.uniseq) && (((GuildMarketFaceItemBuilder.Holder)localObject).a.isSound())) {
      if (this.a.g.isVideoChatting()) {
        QQToast.makeText(this.a.g.getApp(), 2131892896, 0).show(this.a.o.getResources().getDimensionPixelSize(2131299920));
      } else {
        MediaPlayerManager.a(this.a.g).a(((GuildMarketFaceItemBuilder.Holder)localObject).q);
      }
    }
    if (AppSetting.e) {
      ((GuildMarketFaceItemBuilder.Holder)localObject).n.setContentDescription("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.MarketFaceView
 * JD-Core Version:    0.7.0.1
 */