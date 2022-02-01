package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import androidx.annotation.NonNull;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoReportUtil;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.net.URL;

public class GuildPicBuilder
  extends BaseGuildPicBuilder
{
  public GuildPicBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_one_item", paramBoolean1);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean2);
    localBundle.putBoolean(PeakUtils.b, paramBoolean3);
    if (a(paramContext, paramSessionInfo))
    {
      Object localObject = ((BaseActivity)paramContext).getChatFragment();
      if (localObject == null)
      {
        QLog.d("BaseGuildPicBuilder", 1, "enterImagePreview  chatFragment is null.");
      }
      else
      {
        localObject = ((ChatFragment)localObject).k();
        if (localObject == null)
        {
          QLog.d("BaseGuildPicBuilder", 1, "enterImagePreview  BaseChatPie is null.");
        }
        else
        {
          int i = ((BaseChatPie)localObject).aR();
          localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", i);
          if (i == 1)
          {
            localObject = (InputMethodManager)paramContext.getSystemService("input_method");
            if (localObject != null) {
              ((InputMethodManager)localObject).toggleSoftInput(1, 0);
            }
          }
        }
      }
    }
    if (paramMessageForReplyText != null) {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    } else {
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramChatMessage.isMultiMsg);
    }
    paramMessageForReplyText = (IOCRService)paramQQAppInterface.getRuntimeService(IOCRService.class, "");
    paramBoolean2 = paramMessageForReplyText.isSupportOcr(paramQQAppInterface.getCurrentAccountUin(), 1);
    localBundle.putBoolean("extra.OCR", paramBoolean2);
    if (paramBoolean2)
    {
      paramMessageForReplyText = paramMessageForReplyText.getAIOText(paramQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty(paramMessageForReplyText)) {
        localBundle.putString("extra.OCR_TEXT", paramMessageForReplyText);
      }
    }
    BaseGuildPicBuilder.a(paramQQAppInterface, paramContext, paramView, paramChatMessage, paramSessionInfo, paramBoolean1, localBundle);
  }
  
  private void a(MessageForPic paramMessageForPic, Rect paramRect)
  {
    AIOEmotionFragment.a(this.b, paramMessageForPic, this.c, paramRect);
  }
  
  private static boolean a(Context paramContext, SessionInfo paramSessionInfo)
  {
    return (((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.G);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, URL paramURL)
  {
    return false;
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return super.a(paramChatMessage, paramViewHolder, paramView, paramGuildMsgItemLayout, paramOnLongClickAndTouchListener);
  }
  
  protected void a(MessageForPic paramMessageForPic, BaseGuildPicBuilder.Holder paramHolder)
  {
    if (ZhituManager.b(paramMessageForPic))
    {
      if (!ZhituManager.a(paramMessageForPic)) {
        a(paramMessageForPic, AnimationUtils.a(paramHolder.a));
      }
    }
    else
    {
      if (((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramMessageForPic))
      {
        new AdEmoReportUtil().d(this.g, this.c, paramMessageForPic);
        a(paramMessageForPic, AnimationUtils.a(paramHolder.a));
        return;
      }
      a(this.g, this.b, paramHolder.a, paramMessageForPic, this.c, false, true, true, null);
    }
  }
  
  protected void a(BaseGuildPicBuilder.Holder paramHolder, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL)
  {
    Object localObject = paramHolder.c;
    if (localObject != null)
    {
      localObject = ((URLDrawable)localObject).getURL().getProtocol();
      if (a(this.b, paramBoolean, ((String)localObject).equals("chatthumb"), paramArrayOfInt[0], paramArrayOfInt[1], paramURL))
      {
        paramHolder.c.setWatermarkDrawable(((ICompressOperator)QRoute.api(ICompressOperator.class)).getGifTagBitmap(), AIOUtils.b(6.0F, this.b.getResources()), AIOUtils.b(6.0F, this.b.getResources()));
        paramHolder.c.setWatermarkVisibility(0);
        return;
      }
      paramHolder.c.setWatermarkVisibility(4);
      return;
    }
    paramHolder.c.setWatermarkVisibility(4);
  }
  
  public boolean a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof BaseGuildPicBuilder.Holder;
  }
  
  void b(MessageForPic paramMessageForPic, BaseGuildPicBuilder.Holder paramHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildPicBuilder
 * JD-Core Version:    0.7.0.1
 */