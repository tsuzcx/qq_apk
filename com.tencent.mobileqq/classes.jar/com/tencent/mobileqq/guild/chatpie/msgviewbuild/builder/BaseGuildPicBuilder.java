package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ContextMenuBuilder2;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.guild.GuildAIOPicThumbDrawableObject;
import com.tencent.mobileqq.guild.GuildAIOPicThumbDrawableObject.Builder;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.guild.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.pic.aio.AioPicTransFileController;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import java.net.URL;

public abstract class BaseGuildPicBuilder
  extends BaseGuildMsgViewBuild
  implements Callback, ContextMenuBuilder2
{
  protected final float a;
  protected MultiRichMediaSaveManager l;
  protected AioPicTransFileController m = new AioPicTransFileController();
  boolean n = false;
  
  public BaseGuildPicBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = paramContext.getResources().getDisplayMetrics().density;
    if (this.l == null) {
      this.l = ((MultiRichMediaSaveManager)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER));
    }
  }
  
  private static int a(Context paramContext)
  {
    boolean bool = paramContext instanceof SplashActivity;
    int i = 2;
    if ((!bool) && (!(paramContext instanceof ChatActivity)))
    {
      if (!(paramContext instanceof ChatHistoryActivity))
      {
        if ((paramContext instanceof ChatHistory)) {
          return 2;
        }
        if ((paramContext instanceof PublicFragmentActivity))
        {
          if ((((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
            return 2;
          }
        }
        else if ((paramContext instanceof MultiForwardActivity)) {
          return 5;
        }
        return -1;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic, ChatThumbView paramChatThumbView, int[] paramArrayOfInt, BaseGuildPicBuilder.DrawURL paramDrawURL)
  {
    return new GuildAIOPicThumbDrawableObject.Builder(paramMessageForPic).a(paramChatThumbView).a(paramArrayOfInt).a(paramDrawURL).a().a();
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramView != null) {
      paramBundle.putParcelable("KEY_THUMBNAL_BOUND", AnimationUtils.a(paramView));
    }
    paramBundle.putBoolean("is_one_item", paramBoolean);
    paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
    String str = paramChatMessage.selfuin;
    paramBundle.putInt("forward_source_uin_type", paramSessionInfo.a);
    paramBundle.putString("uin", paramChatMessage.frienduin);
    paramView = new AIOImageProviderService(str, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage);
    if ((str != null) && (paramChatMessage.frienduin != null))
    {
      paramSessionInfo = (MultiRichMediaSaveManager)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      paramBoolean = paramSessionInfo.b(paramChatMessage);
      paramBundle.putBoolean("extra.IS_SAVING_FILE", paramBoolean);
      if (paramBoolean)
      {
        paramSessionInfo = paramSessionInfo.a(paramSessionInfo.a(paramChatMessage));
        if ((paramSessionInfo != null) && (paramSessionInfo.f == 1)) {
          paramBundle.putInt("extra.SAVE_FILE_PROGRESS", paramSessionInfo.e);
        }
      }
      int i = a(paramContext);
      if ((paramChatMessage instanceof MessageForPic))
      {
        paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        PeakUtils.a(paramContext, paramBundle, paramView, AIOGalleryUtils.a((MessageForPic)paramChatMessage), -1, i);
      }
      else if ((paramChatMessage instanceof MessageForTroopFile))
      {
        paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        PeakUtils.a(paramContext, paramBundle, paramView, AIOGalleryUtils.a((MessageForTroopFile)paramChatMessage, paramQQAppInterface), -1, i);
      }
      if (QLog.isColorLevel()) {
        QLog.i("BaseGuildPicBuilder", 2, "PicItemBuilder.enterImagePreview()");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("BaseGuildPicBuilder", 2, "PicItemBuilder.enterImagePreview() selfUin || pic.frienduin is null");
    }
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, BaseGuildPicBuilder.Holder paramHolder)
  {
    if (paramHolder.j == null) {
      return;
    }
    Object localObject1;
    if ((paramIHttpCommunicatorListener instanceof BaseTransProcessor))
    {
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      int i = (int)paramIHttpCommunicatorListener.getFileStatus();
      if (i != 1006)
      {
        if (i != 4001) {
          switch (i)
          {
          default: 
            if (paramHolder.b != null)
            {
              paramIHttpCommunicatorListener = paramHolder.b;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramHolder.q.frienduin);
              ((StringBuilder)localObject1).append(paramHolder.q.uniseq);
              paramIHttpCommunicatorListener.setProgressKey(((StringBuilder)localObject1).toString());
              paramIHttpCommunicatorListener = paramHolder.b;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramHolder.q.frienduin);
              ((StringBuilder)localObject1).append(paramHolder.q.uniseq);
              if (!paramIHttpCommunicatorListener.c(((StringBuilder)localObject1).toString()))
              {
                paramIHttpCommunicatorListener = paramHolder.b;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(paramHolder.q.frienduin);
                ((StringBuilder)localObject1).append(paramHolder.q.uniseq);
                paramIHttpCommunicatorListener.b(((StringBuilder)localObject1).toString());
                paramHolder.b.setProcessor(null);
                ((RelativeLayout)paramHolder.j).removeView(paramHolder.b);
                paramHolder.b = null;
              }
              else
              {
                paramHolder.b.setProgress(100);
              }
            }
            if (i == 1003) {
              paramHolder.k.setFailedIconVisable(false, this);
            }
            paramHolder.k.setProgressVisable(false);
            return;
          }
        }
        paramHolder.k.setFailedIconVisable(false, this);
        if (paramHolder.b == null)
        {
          localObject1 = new PicProgressView(this.b);
          ((PicProgressView)localObject1).setRadius(6.0F, true);
          ((PicProgressView)localObject1).setSharpCornerCor(BubbleImageView.d);
          ((PicProgressView)localObject1).setShowCorner(false);
          ((PicProgressView)localObject1).setCustomSize(1);
          ((PicProgressView)localObject1).setProgressBackgroudColor(2130706432);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131440242);
          ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131440242);
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131440242);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131440242);
          ((RelativeLayout)paramHolder.j).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          paramHolder.b = ((PicProgressView)localObject1);
        }
        localObject1 = paramHolder.b;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramHolder.q.frienduin);
        ((StringBuilder)localObject2).append(paramHolder.q.uniseq);
        ((PicProgressView)localObject1).setProgressKey(((StringBuilder)localObject2).toString());
        paramHolder.b.setProcessor(paramIHttpCommunicatorListener);
        paramHolder.b.setVisibility(0);
        if ((paramHolder.b != null) && ((1001 == i) || (1002 == i))) {
          paramHolder.b.a = false;
        }
        if (i != 1002)
        {
          paramHolder.k.setProgressVisable(false);
          paramHolder.b.setProgress(0);
          return;
        }
        paramHolder.k.setProgressVisable(false);
        paramHolder.b.a();
        paramHolder.b.setShowProgress(true);
        return;
      }
      if ((paramIHttpCommunicatorListener.isRawPic()) && (!this.n))
      {
        paramHolder.k.setFailedIconVisable(true, this);
        if (paramHolder.b != null)
        {
          paramIHttpCommunicatorListener = paramHolder.b;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramHolder.q.frienduin);
          ((StringBuilder)localObject1).append(paramHolder.q.uniseq);
          paramIHttpCommunicatorListener.setProgressKey(((StringBuilder)localObject1).toString());
          paramIHttpCommunicatorListener = paramHolder.b;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramHolder.q.frienduin);
          ((StringBuilder)localObject1).append(paramHolder.q.uniseq);
          paramIHttpCommunicatorListener.b(((StringBuilder)localObject1).toString());
          paramHolder.b.setProcessor(null);
          ((RelativeLayout)paramHolder.j).removeView(paramHolder.b);
          paramHolder.b = null;
        }
        paramHolder.k.setProgressVisable(false);
      }
      paramHolder.k.setProgressVisable(false);
      if (paramHolder.b != null) {
        paramHolder.b.a = true;
      }
    }
    else
    {
      if (paramHolder.b != null)
      {
        paramIHttpCommunicatorListener = paramHolder.b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramHolder.q.frienduin);
        ((StringBuilder)localObject1).append(paramHolder.q.uniseq);
        paramIHttpCommunicatorListener.setProgressKey(((StringBuilder)localObject1).toString());
        paramIHttpCommunicatorListener = paramHolder.b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramHolder.q.frienduin);
        ((StringBuilder)localObject1).append(paramHolder.q.uniseq);
        paramIHttpCommunicatorListener.b(((StringBuilder)localObject1).toString());
        paramHolder.b.setProcessor(null);
        ((RelativeLayout)paramHolder.j).removeView(paramHolder.b);
        paramHolder.b = null;
      }
      paramHolder.k.setProgressVisable(false);
    }
  }
  
  private void b(MessageForPic paramMessageForPic)
  {
    ThreadManager.post(new BaseGuildPicBuilder.2(this, paramMessageForPic), 5, null, false);
    if (paramMessageForPic.isSendFromLocal()) {
      ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
    localBuilder.a(paramMessageForPic.path);
    localBuilder.d(5);
    localBuilder.d(paramMessageForPic.frienduin);
    if (paramMessageForPic.fileSizeFlag == 1) {
      localBuilder.c(1);
    } else {
      localBuilder.c(0);
    }
    localBuilder.e(paramMessageForPic.senderuin);
    localBuilder.c(paramMessageForPic.selfuin);
    localBuilder.e(paramMessageForPic.istroop);
    localBuilder.l(paramMessageForPic.getConfessTopicId());
    localBuilder.A = paramMessageForPic.extLong;
    localBuilder.B = paramMessageForPic.extStr;
    Object localObject = new PicUploadInfo.RetryInfo();
    ((PicUploadInfo.RetryInfo)localObject).a = paramMessageForPic.msgseq;
    ((PicUploadInfo.RetryInfo)localObject).b = paramMessageForPic.shmsgseq;
    ((PicUploadInfo.RetryInfo)localObject).c = paramMessageForPic.msgUid;
    localBuilder.a((PicUploadInfo.RetryInfo)localObject);
    localBuilder.b(paramMessageForPic.uniseq);
    ((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(this.c.b, paramMessageForPic.uniseq);
    localObject = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(4, 5);
    ((PicReq)localObject).a(localBuilder.k());
    ((PicReq)localObject).i = paramMessageForPic.picExtraData;
    ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject);
  }
  
  private void c(MessageForPic paramMessageForPic)
  {
    Object localObject1 = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForPic.selfuin, paramMessageForPic.uniseq);
    if ((localObject1 != null) && ((localObject1 instanceof BaseUploadProcessor)))
    {
      ((BaseUploadProcessor)localObject1).start();
      return;
    }
    this.g.getMessageFacade().h(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq);
    if (paramMessageForPic.isSendFromLocal()) {
      ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(paramMessageForPic.frienduin, paramMessageForPic.uniseq));
    }
    localObject1 = new PicFowardInfo();
    Object localObject2 = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject2).d(1009);
    ((PicUploadInfo.Builder)localObject2).a(paramMessageForPic.path);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.istroop);
    ((PicUploadInfo.Builder)localObject2).c(paramMessageForPic.selfuin);
    ((PicUploadInfo.Builder)localObject2).e(paramMessageForPic.senderuin);
    ((PicUploadInfo.Builder)localObject2).d(paramMessageForPic.frienduin);
    ((PicUploadInfo.Builder)localObject2).A = paramMessageForPic.extLong;
    ((PicUploadInfo.Builder)localObject2).B = paramMessageForPic.extStr;
    ((PicUploadInfo.Builder)localObject2).c(10);
    ((PicUploadInfo.Builder)localObject2).b(paramMessageForPic.uniseq);
    ((PicFowardInfo)localObject1).b = ((PicUploadInfo.Builder)localObject2).k();
    if ((!FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path)) && ((paramMessageForPic.picExtraObject instanceof PicFowardDbRecordData)))
    {
      localObject2 = (PicFowardDbRecordData)paramMessageForPic.picExtraObject;
      PicDownloadInfo.Builder localBuilder = new PicDownloadInfo.Builder();
      localBuilder.a(1009);
      localBuilder.a(paramMessageForPic.selfuin);
      localBuilder.b(((PicFowardDbRecordData)localObject2).fowardOrgUin);
      localBuilder.b(((PicFowardDbRecordData)localObject2).fowardOrgUinType);
      localBuilder.c(((PicFowardDbRecordData)localObject2).fowardOrgUrl);
      localBuilder.a(((PicFowardDbRecordData)localObject2).fowardOrgId);
      localBuilder.d(paramMessageForPic.md5);
      localBuilder.c(paramMessageForPic.issend);
      ((PicFowardInfo)localObject1).c = localBuilder.h();
    }
    ((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(this.c.b, paramMessageForPic.uniseq);
    paramMessageForPic = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(3, 1009);
    paramMessageForPic.a((PicFowardInfo)localObject1);
    ((IPicBus)QRoute.api(IPicBus.class)).launch(paramMessageForPic);
  }
  
  private void c(MessageForPic paramMessageForPic, BaseGuildPicBuilder.Holder paramHolder)
  {
    Object localObject = this.l;
    if ((localObject != null) && (paramMessageForPic != null) && (paramHolder != null))
    {
      paramMessageForPic = ((MultiRichMediaSaveManager)localObject).a(paramMessageForPic.getPicDownloadInfo());
      localObject = this.l.a(paramMessageForPic);
      if ((localObject != null) && (((FileSaveResult)localObject).f == 1))
      {
        int i;
        if (((FileSaveResult)localObject).e < 0) {
          i = 0;
        } else {
          i = Math.min(((FileSaveResult)localObject).e, 100);
        }
        if ((i < 100) && (!((FileSaveResult)localObject).a) && (paramHolder.b == null) && (((FileSaveResult)localObject).g != null))
        {
          ((FileSaveResult)localObject).g.a(new BaseGuildPicBuilder.3(this, paramHolder, paramMessageForPic));
          this.l.a(paramMessageForPic, (FileSaveResult)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("BaseGuildPicBuilder", 2, "show picSaveProgress");
          }
          paramMessageForPic = new PicProgressView(this.b);
          paramMessageForPic.setRadius(6.0F, true);
          paramMessageForPic.setSharpCornerCor(BubbleImageView.d);
          paramMessageForPic.setShowCorner(false);
          paramMessageForPic.setCustomSize(1);
          paramMessageForPic.setProgressBackgroudColor(2130706432);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131440242);
          ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131440242);
          ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131440242);
          ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131440242);
          ((RelativeLayout)paramHolder.j).addView(paramMessageForPic, (ViewGroup.LayoutParams)localObject);
          paramHolder.b = paramMessageForPic;
          paramMessageForPic = paramHolder.b;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramHolder.q.frienduin);
          ((StringBuilder)localObject).append(paramHolder.q.uniseq);
          paramMessageForPic.setProgressKey(((StringBuilder)localObject).toString());
          paramHolder.b.setVisibility(0);
          paramHolder.b.a = false;
          paramHolder.b.setProgress(i);
          paramHolder.b.setShowProgress(true);
        }
      }
    }
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramGuildMsgItemLayout = (MessageForPic)paramChatMessage;
    boolean bool3 = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramGuildMsgItemLayout.imageType);
    try
    {
      BaseGuildPicBuilder.Holder localHolder = (BaseGuildPicBuilder.Holder)paramViewHolder;
      if (localHolder == null) {
        return paramView;
      }
      System.currentTimeMillis();
      localHolder.g = bool3;
      boolean bool2 = false;
      paramViewHolder = paramView;
      if (paramView == null)
      {
        paramViewHolder = new RelativeLayout(this.b);
        paramViewHolder.setId(2131440242);
        paramView = new BubbleImageView(this.b);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramView.w = true;
        }
        paramView.setId(2131440242);
        paramView.setAdjustViewBounds(true);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setRadius(6.0F);
        paramView.c(false);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject);
        localHolder.e = new BaseGuildPicBuilder.GuildRefreshURLDrawableListener();
        paramView.setURLDrawableDownListener(localHolder.e);
        localHolder.a = paramView;
        paramView = new ImageView(this.b);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131440242);
        ((RelativeLayout.LayoutParams)localObject).addRule(8, 2131440242);
        paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject);
        localHolder.d = paramView;
        paramViewHolder.setOnClickListener(this);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      }
      paramView = localHolder.a;
      Object localObject = (IGuildPicAIO)QRoute.api(IGuildPicAIO.class);
      paramOnLongClickAndTouchListener = ((IGuildPicAIO)localObject).getThumbMaxPx(bool3);
      localObject = ((IGuildPicAIO)localObject).getThumbMinPx(bool3);
      paramView.setMaxWidth(paramOnLongClickAndTouchListener[0]);
      paramView.setMaxHeight(paramOnLongClickAndTouchListener[1]);
      paramView.setMinimumWidth(localObject[0]);
      paramView.setMinimumHeight(localObject[1]);
      boolean bool1 = bool2;
      if (!((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion(paramGuildMsgItemLayout))
      {
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
      paramView.setShowEdge(bool1);
      if (v) {
        paramView.setContentDescription(HardCodeUtil.a(2131905947));
      }
      if (!paramGuildMsgItemLayout.isSendFromLocal()) {
        a(paramGuildMsgItemLayout, localHolder, paramViewHolder, bool3);
      } else {
        b(paramGuildMsgItemLayout, localHolder, paramViewHolder, bool3);
      }
      if (QLog.isColorLevel())
      {
        paramOnLongClickAndTouchListener = new StringBuilder();
        paramOnLongClickAndTouchListener.append("getView ");
        if (localHolder.f != null) {
          paramView = localHolder.f.toString();
        } else {
          paramView = "";
        }
        paramOnLongClickAndTouchListener.append(paramView);
        paramOnLongClickAndTouchListener.append(", isDynamic=");
        paramOnLongClickAndTouchListener.append(bool3);
        QLog.d("BaseGuildPicBuilder", 2, paramOnLongClickAndTouchListener.toString());
      }
      a(paramChatMessage, paramViewHolder, this);
      c(paramGuildMsgItemLayout, localHolder);
      return paramViewHolder;
    }
    catch (Exception paramChatMessage)
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("picitem holer Exception e= ");
      paramViewHolder.append(paramChatMessage);
      QLog.e("BaseGuildPicBuilder", 2, paramViewHolder.toString());
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("picitem holer Exception e= ");
      paramViewHolder.append(paramChatMessage);
      throw new ClassCastException(paramViewHolder.toString());
    }
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new BaseGuildPicBuilder.Holder(this);
  }
  
  void a(MessageForPic paramMessageForPic)
  {
    String str = ((IPicAIO)QRoute.api(IPicAIO.class)).getSendPicFailedTip(paramMessageForPic);
    if (str != null)
    {
      QQToast.makeText(this.b, str, 0).show();
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path))
    {
      b(paramMessageForPic);
      return;
    }
    if (paramMessageForPic.picExtraFlag == 10) {
      c(paramMessageForPic);
    }
  }
  
  void a(MessageForPic paramMessageForPic, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStatus() == 1) && ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))) {
      ((IPicPreDownload)this.g.getRuntimeService(IPicPreDownload.class)).productFromAIODynamicPic(paramMessageForPic);
    }
  }
  
  protected abstract void a(MessageForPic paramMessageForPic, BaseGuildPicBuilder.Holder paramHolder);
  
  protected void a(MessageForPic paramMessageForPic, BaseGuildPicBuilder.Holder paramHolder, View paramView, boolean paramBoolean)
  {
    Object localObject1;
    if (paramHolder.b != null)
    {
      paramHolder.b.setVisibility(8);
      localObject1 = paramHolder.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramMessageForPic.frienduin);
      ((StringBuilder)localObject2).append(paramMessageForPic.uniseq);
      ((PicProgressView)localObject1).setProgressKey(((StringBuilder)localObject2).toString());
      localObject1 = paramHolder.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramMessageForPic.frienduin);
      ((StringBuilder)localObject2).append(paramMessageForPic.uniseq);
      ((PicProgressView)localObject1).b(((StringBuilder)localObject2).toString());
      paramHolder.b.setProcessor(null);
      ((RelativeLayout)paramHolder.j).removeView(paramHolder.b);
      paramHolder.b = null;
    }
    Object localObject3 = new BaseGuildPicBuilder.DrawURL(paramMessageForPic);
    Object localObject2 = ((BaseGuildPicBuilder.DrawURL)localObject3).a;
    int[] arrayOfInt = new int[2];
    int[] tmp157_155 = arrayOfInt;
    tmp157_155[0] = 0;
    int[] tmp161_157 = tmp157_155;
    tmp161_157[1] = 0;
    tmp161_157;
    if ((paramHolder.c != null) && (paramHolder.c.getURL().equals(localObject2)))
    {
      paramMessageForPic = paramHolder.c;
      arrayOfInt[0] = paramHolder.a.getWidth();
      arrayOfInt[1] = paramHolder.a.getHeight();
    }
    else
    {
      if (paramHolder.c != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("holder.d=");
        ((StringBuilder)localObject1).append(paramHolder.c.getURL());
        ((StringBuilder)localObject1).append("==url=");
        ((StringBuilder)localObject1).append(localObject2);
        QLog.d("BaseGuildPicBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = a(this.b, paramMessageForPic, paramHolder.a, arrayOfInt, (BaseGuildPicBuilder.DrawURL)localObject3);
      paramHolder.a.setImageDrawable((Drawable)localObject1);
      paramHolder.e.a(paramMessageForPic);
      paramHolder.c = ((URLDrawable)localObject1);
      paramHolder.f = ((BaseGuildPicBuilder.DrawURL)localObject3);
      ((IPicPreDownload)this.g.getRuntimeService(IPicPreDownload.class, "")).productFromAIO(paramMessageForPic, 2);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("show receive pic uniseq=");
        ((StringBuilder)localObject3).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject3).append(" url=");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.d("BaseGuildPicBuilder", 2, ((StringBuilder)localObject3).toString());
      }
      paramMessageForPic = (MessageForPic)localObject1;
    }
    if (paramMessageForPic == null) {
      QLog.d("BaseGuildPicBuilder", 2, "d==null");
    }
    a(paramHolder, paramBoolean, arrayOfInt, (URL)localObject2);
    paramHolder.j = paramView;
  }
  
  protected void a(BaseGuildPicBuilder.Holder paramHolder, boolean paramBoolean, int[] paramArrayOfInt, URL paramURL) {}
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    if (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    long l1 = paramChatMessage.size;
    boolean bool2 = true;
    if (l1 <= 0L)
    {
      paramChatMessage = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      boolean bool1 = bool2;
      if ((paramChatMessage instanceof BaseTransProcessor))
      {
        l1 = ((BaseTransProcessor)paramChatMessage).getFileStatus();
        bool1 = bool2;
        if (l1 != 1005L) {
          if (l1 == 1006L)
          {
            bool1 = bool2;
            if (!this.n) {}
          }
          else
          {
            if (l1 == 1004L) {
              return true;
            }
            bool1 = false;
          }
        }
      }
      return bool1;
    }
    return paramChatMessage.extraflag == 32768;
  }
  
  abstract void b(MessageForPic paramMessageForPic, BaseGuildPicBuilder.Holder paramHolder);
  
  protected void b(MessageForPic paramMessageForPic, BaseGuildPicBuilder.Holder paramHolder, View paramView, boolean paramBoolean)
  {
    if (paramHolder.c != null) {
      paramHolder.c.setWatermarkVisibility(4);
    }
    Object localObject = new BaseGuildPicBuilder.DrawURL(paramMessageForPic);
    URL localURL = ((BaseGuildPicBuilder.DrawURL)localObject).a;
    if ((paramHolder.c == null) || (!paramHolder.c.getURL().equals(localURL)))
    {
      URLDrawable localURLDrawable = a(this.b, paramMessageForPic, paramHolder.a, null, (BaseGuildPicBuilder.DrawURL)localObject);
      paramHolder.a.setImageDrawable(localURLDrawable);
      paramHolder.c = localURLDrawable;
      paramHolder.f = ((BaseGuildPicBuilder.DrawURL)localObject);
      if (paramBoolean)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("predownloadDynamic pic uniseq=");
          ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
          ((StringBuilder)localObject).append(" url=");
          ((StringBuilder)localObject).append(localURL);
          QLog.d("BaseGuildPicBuilder", 2, ((StringBuilder)localObject).toString());
        }
        a(paramMessageForPic, paramHolder.c);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("show send pic uniseq=");
        ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject).append(" url=");
        ((StringBuilder)localObject).append(localURL);
        QLog.d("BaseGuildPicBuilder", 2, ((StringBuilder)localObject).toString());
      }
    }
    paramMessageForPic = ((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
    paramHolder.j = paramView;
    a(paramMessageForPic, paramHolder);
    if (paramHolder.b != null) {
      paramHolder.b.a = true;
    }
  }
  
  protected boolean b(View paramView)
  {
    paramView = (MessageForPic)((BaseGuildPicBuilder.Holder)AIOUtils.b(paramView)).q;
    if (paramView.isSendFromLocal())
    {
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.b, null);
      localActionSheet.addButton(2131886574, 5);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new BaseGuildPicBuilder.1(this, paramView, localActionSheet));
      localActionSheet.show();
    }
    return true;
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    if (MessageRecordInfo.b(paramChatMessage.issend)) {
      return HardCodeUtil.a(2131905948);
    }
    return HardCodeUtil.a(2131905949);
  }
  
  public BaseBubbleBuilder.TouchDelegate c(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (BaseGuildPicBuilder.Holder)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.a;
      }
    }
    return null;
  }
  
  protected void g(View paramView)
  {
    Object localObject = (BaseGuildPicBuilder.Holder)AIOUtils.b(paramView);
    MessageForPic localMessageForPic = (MessageForPic)((BaseGuildPicBuilder.Holder)localObject).q;
    paramView = ((BaseGuildPicBuilder.Holder)localObject).c;
    if (!localMessageForPic.isSendFromLocal())
    {
      int i = paramView.getStatus();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          if ((Utils.b()) && (Utils.c() < 31457280L))
          {
            QQToast.makeText(this.b, HardCodeUtil.a(2131905946), 0).show();
            return;
          }
          localObject = ((IPicAIO)QRoute.api(IPicAIO.class)).getReceivePicFailedTip(paramView);
          if (localObject != null)
          {
            QQToast.makeText(this.b, (CharSequence)localObject, 0).show();
            return;
          }
          if (FolderUtils.a(this.b)) {
            paramView.restartDownload();
          }
          return;
        }
        a(localMessageForPic, (BaseGuildPicBuilder.Holder)localObject);
        return;
      }
      if (!paramView.isDownloadStarted()) {
        paramView.startDownload();
      }
    }
    else
    {
      if (paramView.getStatus() == 2)
      {
        if ((Utils.b()) && (Utils.c() < 31457280L))
        {
          QQToast.makeText(this.b, HardCodeUtil.a(2131905950), 0).show();
          return;
        }
        String str = ((IPicAIO)QRoute.api(IPicAIO.class)).getReceivePicFailedTip(paramView);
        if (str != null)
        {
          QQToast.makeText(this.b, str, 0).show();
          return;
        }
        if (FolderUtils.a(this.b)) {
          paramView.restartDownload();
        }
      }
      a(localMessageForPic, (BaseGuildPicBuilder.Holder)localObject);
    }
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    BaseGuildPicBuilder.Holder localHolder = (BaseGuildPicBuilder.Holder)AIOUtils.b(paramView);
    if (localHolder == null)
    {
      QLog.e("BaseGuildPicBuilder", 2, "handleMessage(): holder is null");
      return;
    }
    try
    {
      paramView = (MessageForPic)localHolder.q;
    }
    catch (ClassCastException paramView)
    {
      QLog.e("BaseGuildPicBuilder", 2, "handleMessage(): cast exception", paramView);
      paramView = null;
    }
    if ((localHolder.q != null) && (paramView != null))
    {
      boolean bool;
      int i;
      Object localObject;
      if ((paramInt1 == 2003) && (paramFileMsg.fileType == 65537))
      {
        bool = ((IPicUtil)QRoute.api(IPicUtil.class)).isDynamicImg(paramView.imageType);
        i = localHolder.a.getWidth();
        int j = localHolder.a.getHeight();
        localHolder.c.getURL().getProtocol();
        localObject = URLDrawableHelper.getURL(paramView, 65537);
        a(localHolder, bool, new int[] { i, j }, (URL)localObject);
      }
      if (((paramFileMsg.fileType == 1) || (paramFileMsg.fileType == 131075)) && (paramInt1 != 2002))
      {
        if (paramInt1 == 2001) {
          return;
        }
        if (paramView.uniseq == paramFileMsg.uniseq)
        {
          i = paramView.istroop;
          bool = paramView.isSendFromLocal();
          long l1 = paramView.uniseq;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("status:");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(",retCode");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append("message.uniseq：");
          ((StringBuilder)localObject).append(paramView.uniseq);
          ((StringBuilder)localObject).append(",file.uniseq:");
          ((StringBuilder)localObject).append(paramFileMsg.uniseq);
          RichMediaUtil.logUI(i, bool, 65537, String.valueOf(l1), "BaseGuildPicBuilder.transf.in", ((StringBuilder)localObject).toString(), null);
          if (paramView.isSendFromLocal())
          {
            a(((ITransFileController)this.g.getRuntimeService(ITransFileController.class)).findProcessor(paramView.frienduin, paramView.uniseq), localHolder);
            if (paramInt1 == 1005) {
              g();
            }
          }
          if (paramInt1 == 2003)
          {
            b(paramView, localHolder);
            paramView = a(this.b, (MessageForPic)localHolder.q, localHolder.a, null, null);
            localHolder.a.setImageDrawable(paramView);
            localHolder.c = paramView;
            if (localHolder.c != null) {
              localHolder.c.setWatermarkVisibility(4);
            }
          }
        }
      }
      return;
    }
    QLog.e("BaseGuildPicBuilder", 2, "handleMessage(): holder.mMessage is null");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430578)
    {
      g(paramView);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildPicBuilder
 * JD-Core Version:    0.7.0.1
 */