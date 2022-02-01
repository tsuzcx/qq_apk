package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.ArraySet;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.SyncParentPressedRelativeLayout;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.doutu.DoutuMsgUtil;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.IEmoticonHandler;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryTask;
import com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService;
import com.tencent.mobileqq.emoticonview.api.IPicEmoticonInfoService;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.RoundedColorDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GuildMarketFaceItemBuilder
  extends BaseGuildMsgViewBuild
  implements MediaPlayerManager.Callback
{
  public static int a = 1;
  public static ChatMessage l;
  static long q;
  private long A;
  public int m = 320;
  public int n = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
  public Context o;
  public List<GuildMarketFaceItemBuilder.Holder> p;
  IEmojiManagerService r;
  boolean s = false;
  Set<Long> t = new HashSet();
  Set<GuildMarketFaceItemBuilder.Holder> w = new HashSet();
  Set<Long> x = new ArraySet();
  EmoticonPackageDownloadListener y = new GuildMarketFaceItemBuilder.5(this);
  GuildMarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars z = new GuildMarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
  
  public GuildMarketFaceItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.o = paramContext;
    this.p = new ArrayList();
    this.r = ((IEmojiManagerService)paramQQAppInterface.getRuntimeService(IEmojiManagerService.class));
    if ((this.o instanceof SplashActivity)) {
      this.s = true;
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Handler paramHandler)
  {
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)paramQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("MarketFaceItemBuilder", 2, "Call getEmoticonDataList from addEmotionToFavorite.");
    }
    List localList = localIFavroamingDBManagerService.getEmoticonDataList();
    boolean bool = false;
    int j;
    int i;
    if (localList != null)
    {
      j = 0;
      int i1 = 0;
      int i2;
      for (i = 1; j < localList.size(); i = i2)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        int k;
        if (!TextUtils.isEmpty(localCustomEmotionData.RomaingType))
        {
          k = i1;
          if ("needDel".equals(localCustomEmotionData.RomaingType)) {}
        }
        else
        {
          k = i1 + 1;
        }
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(paramEmoticon.epId)) && (localCustomEmotionData.eId.equals(paramEmoticon.eId)))
        {
          if (localIFavroamingDBManagerService.updateDeletedEmoticon(localCustomEmotionData, j))
          {
            paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
            if (paramHandler != null) {
              paramHandler.post(new GuildMarketFaceItemBuilder.11(paramContext));
            }
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
            if (paramQQAppInterface != null)
            {
              paramQQAppInterface.obtainMessage(10).sendToTarget();
              return 0;
            }
          }
          else
          {
            if (paramHandler != null) {
              paramHandler.post(new GuildMarketFaceItemBuilder.12(paramContext));
            }
            EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
          }
          return 0;
        }
        i2 = i;
        if (i < localCustomEmotionData.emoId) {
          i2 = localCustomEmotionData.emoId;
        }
        j += 1;
        i1 = k;
      }
      if (i1 >= FavEmoConstant.a) {
        j = -2;
      } else {
        j = 0;
      }
    }
    else
    {
      j = 0;
      i = 1;
    }
    paramHandler = new CustomEmotionData();
    paramHandler.uin = paramQQAppInterface.getCurrentAccountUin();
    paramHandler.emoId = (i + 1);
    paramHandler.isMarkFace = true;
    paramHandler.emoPath = paramEmoticon.epId;
    paramHandler.eId = paramEmoticon.eId;
    paramHandler.checkMarketFace("addEmotionToFavorite");
    paramEmoticon = ((IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramEmoticon.epId);
    if (paramEmoticon != null)
    {
      if (paramEmoticon.isAPNG == 2) {
        bool = true;
      }
      paramHandler.isAPNG = bool;
    }
    paramEmoticon = (IFavroamingManagerService)paramQQAppInterface.getRuntimeService(IFavroamingManagerService.class);
    if (paramEmoticon != null) {
      paramEmoticon.syncUpload(paramHandler, ((IEmoAddedAuthCallbackService)QRoute.api(IEmoAddedAuthCallbackService.class)).createEmoAddedAuthCallback(paramQQAppInterface, paramContext, paramHandler, null, 0));
    }
    paramContext = l;
    return j;
  }
  
  private SpannableString a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      i = 2131887967;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              paramString2 = "";
              paramInt = i;
            }
            else
            {
              paramString2 = HardCodeUtil.a(2131904388);
              paramInt = i;
            }
          }
          else
          {
            paramString2 = HardCodeUtil.a(2131904378);
            paramInt = i;
          }
        }
        else
        {
          paramString2 = HardCodeUtil.a(2131904381);
          paramInt = i;
        }
      }
      else
      {
        paramInt = 2131887968;
        paramString2 = HardCodeUtil.a(2131904386);
      }
      localObject = this.o.getString(paramInt, new Object[] { paramString2 });
    }
    paramString2 = new StringBuilder();
    paramString2.append((String)localObject);
    paramString2.append(paramString1);
    paramString2 = paramString2.toString();
    localObject = new SpannableString(paramString2);
    paramInt = paramString2.indexOf(paramString1);
    int i = paramString1.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-31676), paramInt, i + paramInt, 33);
    return localObject;
  }
  
  public static void a(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, int paramInt2, String paramString, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (paramEmoticon == null)
    {
      QLog.d("MarketFaceItemBuilder", 1, "can not find emoticon");
      return;
    }
    if (!a(paramContext))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "context is not in the top");
      }
      return;
    }
    Handler localHandler = new Handler(Looper.getMainLooper());
    if (paramInt2 == 0)
    {
      paramInt1 %= 1000;
      if (7 == paramInt1) {
        try
        {
          paramQQAppInterface = new Bundle();
          paramQQAppInterface.putInt("forward_type", 9);
          paramQQAppInterface.putBoolean("forward_emotion_from_preview", paramBoolean);
          paramEmoticon = new Intent();
          paramEmoticon.putExtras(paramQQAppInterface);
          ForwardBaseOption.a((BaseActivity)paramContext, paramEmoticon, 21, 100500, "biz_src_jc_gif");
          return;
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
          }
          return;
        }
      }
      if (6 == paramInt1)
      {
        ThreadManager.post(new GuildMarketFaceItemBuilder.6(paramContext, paramQQAppInterface, paramEmoticon, localHandler), 5, null, true);
        return;
      }
      if (107 == paramInt1)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramEmoticon.epId, "", "");
        ((IPicEmoticonInfoService)QRoute.api(IPicEmoticonInfoService.class)).send(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, null);
      }
    }
    else
    {
      if (paramInt2 < 0)
      {
        localHandler.post(new GuildMarketFaceItemBuilder.7(paramContext, paramString));
        if (6 == paramInt1 % 1000) {
          EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2001", 1);
        }
        paramContext = new StringBuilder();
        paramContext.append("opType: ");
        paramContext.append(paramInt1);
        paramContext.append(",result:");
        paramContext.append(paramInt2);
        QLog.i("MarketFaceItemBuilder", 1, paramContext.toString());
        return;
      }
      localHandler.post(new GuildMarketFaceItemBuilder.8(paramInt1, paramContext, paramQQAppInterface, paramEmoticon, paramString));
      if (6 == paramInt1 % 1000) {
        EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2002", 1);
      }
    }
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, IPicEmoticonInfo paramIPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog)
  {
    a(paramInt, paramContext, paramQQAppInterface, paramEmoticonPackage, paramIPicEmoticonInfo, paramSessionInfo, paramQQProgressDialog, false);
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, IPicEmoticonInfo paramIPicEmoticonInfo, SessionInfo paramSessionInfo, QQProgressDialog paramQQProgressDialog, boolean paramBoolean)
  {
    if (paramIPicEmoticonInfo == null) {
      return;
    }
    if ((paramEmoticonPackage != null) && (paramEmoticonPackage.mobileFeetype == 1))
    {
      if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
        paramQQProgressDialog.dismiss();
      }
      a(paramInt, paramContext, paramQQAppInterface, paramIPicEmoticonInfo.getEmoticon(), 0, null, paramSessionInfo, paramBoolean);
      return;
    }
    if ((NetworkUtil.isNetworkAvailable(paramContext)) && (paramInt <= 1000))
    {
      ((IEmoticonHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).a(paramInt, Integer.valueOf(paramIPicEmoticonInfo.getEmoticon().epId).intValue(), paramIPicEmoticonInfo.getEmoticon().eId);
      return;
    }
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
    a(paramInt, paramContext, paramQQAppInterface, paramIPicEmoticonInfo.getEmoticon(), -404, HardCodeUtil.a(2131904385), paramSessionInfo, paramBoolean);
  }
  
  private void a(ChatMessage paramChatMessage, GuildMarketFaceItemBuilder.Holder paramHolder)
  {
    a(paramChatMessage, paramHolder, "");
  }
  
  private void a(ChatMessage paramChatMessage, GuildMarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    boolean bool;
    if ((paramHolder.a.isSound()) && (!c(paramChatMessage))) {
      bool = false;
    } else {
      bool = true;
    }
    URLDrawable localURLDrawable = paramHolder.a.getLoadingDrawable("fromAIO", bool);
    Object localObject;
    String str2;
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1))
    {
      String str1;
      if ((localURLDrawable.getStateTag() instanceof Bundle)) {
        str1 = ((Bundle)localURLDrawable.getStateTag()).getString("display_type");
      } else {
        str1 = "";
      }
      localObject = localURLDrawable;
      str2 = str1;
      if (!TextUtils.isEmpty(str1))
      {
        localObject = localURLDrawable;
        str2 = str1;
        if (str1.equals("aio_preview"))
        {
          localObject = paramHolder.b;
          if ((localObject != null) && (((EmoticonPackage)localObject).status == 2))
          {
            URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
            localObject = paramHolder.a.getLoadingDrawable("fromAIO", bool);
            str2 = str1;
          }
          else
          {
            localObject = localURLDrawable;
            str2 = str1;
            if ((paramString.equals("") ^ true))
            {
              URLDrawable.removeMemoryCacheByUrl(localURLDrawable.getURL().toString());
              localObject = paramHolder.a.getLoadingDrawable("fromAIO", bool, true, paramHolder);
              str2 = str1;
            }
          }
        }
      }
    }
    else
    {
      str2 = "";
      localObject = localURLDrawable;
    }
    b(paramHolder, (URLDrawable)localObject);
    paramHolder.f.setVisibility(8);
    paramHolder.e.setVisibility(8);
    paramHolder.g.setVisibility(8);
    b(paramChatMessage, paramHolder);
    if (localObject != null) {
      a(paramHolder, (URLDrawable)localObject, str2);
    }
    b(paramHolder);
  }
  
  private void a(GuildMarketFaceItemBuilder.Holder paramHolder)
  {
    if (4 == paramHolder.a.getEmoticon().jobType)
    {
      if (((MessageForMarketFace)paramHolder.q).mMarkFaceMessage == null) {
        return;
      }
      Object localObject;
      if (!this.r.isH5MagicIntact(paramHolder.a.getEmoticon().epId, true, true))
      {
        if (!EmoticonPanelUtils.a())
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("magicFaceIcon gone: H5MagicSource isnot Intact , and network isnot 2 3 4G or wifi;epId = ");
            ((StringBuilder)localObject).append(paramHolder.a.getEmoticon().epId);
            QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
          paramHolder.i.setVisibility(8);
          return;
        }
        if (-1.0F == this.r.getEmoticonPackageLoadingProgress(paramHolder.a.getEmoticon().epId))
        {
          this.r.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.y);
          localObject = new EmoticonPackage();
          ((EmoticonPackage)localObject).name = paramHolder.a.getEmoticon().name;
          ((EmoticonPackage)localObject).epId = paramHolder.a.getEmoticon().epId;
          ((EmoticonPackage)localObject).jobType = 5;
          ((EmoticonPackage)localObject).type = 1;
          ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
          ((IEmoticonManagerService)this.g.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramHolder.a.getEmoticon());
          this.p.add(paramHolder);
          paramHolder.s = ((MessageForMarketFace)paramHolder.q).needToPlay;
          paramHolder.i.setVisibility(8);
          paramHolder.o.setVisibility(0);
          ((MessageForMarketFace)paramHolder.q).needToPlay = false;
          this.r.pullEmoticonPackage((EmoticonPackage)localObject, false);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("magicFaceIcon gone,start download epId = ");
            localStringBuilder.append(paramHolder.a.getEmoticon().epId);
            QLog.d("MarketFaceItemBuilder", 2, localStringBuilder.toString());
          }
          ReportController.b(this.g, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, ((EmoticonPackage)localObject).epId, "", "", "");
        }
      }
      else
      {
        if ((this.s) && (this.r.isDPCSupportH5Magic()))
        {
          paramHolder.i.setVisibility(0);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("magicFaceIcon visible,h5source intacat epId = ");
            ((StringBuilder)localObject).append(paramHolder.a.getEmoticon().epId);
            QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          paramHolder.i.setVisibility(8);
        }
        paramHolder.i.setImageResource(2130837998);
        if ((!((MessageForMarketFace)paramHolder.q).isSend()) && (((MessageForMarketFace)paramHolder.q).needToPlay) && (this.r.canPlayH5Magic()) && (System.currentTimeMillis() - this.A > 3000L) && (((BaseActivity)this.o).getChatFragment() != null) && (((BaseActivity)this.o).getChatFragment().k() != null) && (!((BaseActivity)this.o).getChatFragment().k().at()))
        {
          this.A = System.currentTimeMillis();
          ((MessageForMarketFace)paramHolder.q).needToPlay = false;
          a(paramHolder, "1");
          ReportController.b(this.g, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.a.getEmoticon().epId, "", "", "");
        }
      }
    }
  }
  
  private void a(GuildMarketFaceItemBuilder.Holder paramHolder, int paramInt, MessageForMarketFace paramMessageForMarketFace, ChatMessage paramChatMessage, long paramLong)
  {
    paramHolder.h.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    Object localObject = paramMessageForMarketFace.mMarkFaceMessage;
    PicItemBuilder.h();
    long l1 = paramHolder.q.uniseq;
    paramHolder.t = paramHolder.q.uniseq;
    if (paramHolder.a == null)
    {
      paramHolder.h.setImageResource(2130837994);
    }
    else
    {
      localObject = paramHolder.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131904387));
      localStringBuilder.append(paramHolder.a.getEmoticon().name);
      ((ImageView)localObject).setContentDescription(localStringBuilder.toString());
      if (2 == paramHolder.a.getEmoticon().jobType)
      {
        localObject = (GuildPngFrameManager)this.g.getManager(QQManagerFactory.GUILD_PNG_FRAME_DRAWABLE_MANAGER);
        bool = false;
        if (paramHolder.l == paramHolder.m - 1) {
          bool = ((GuildPngFrameManager)localObject).a(paramHolder.q.uniseq);
        }
        if (paramMessageForMarketFace.mMarkFaceMessage != null)
        {
          if ((paramMessageForMarketFace.mMarkFaceMessage.mobileparam != null) && (paramMessageForMarketFace.mMarkFaceMessage.mobileparam.length > 0))
          {
            paramMessageForMarketFace = new String(paramMessageForMarketFace.mMarkFaceMessage.mobileparam);
            break label254;
          }
          QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage mobileparam is empty");
        }
        else
        {
          QLog.e("MarketFaceItemBuilder", 1, "getBubble view mMessage.mMarkFaceMessage is null");
        }
        paramMessageForMarketFace = "";
        label254:
        ((GuildPngFrameManager)localObject).a(paramMessageForMarketFace, paramHolder, l1, bool, true, new GuildMarketFaceItemBuilder.3(this, paramChatMessage, paramHolder));
        paramHolder.f.setVisibility(8);
        paramHolder.e.setVisibility(8);
        paramHolder.g.setVisibility(8);
        paramHolder.d.setVisibility(8);
        paramHolder.C.setVisibility(8);
        paramHolder.c.setVisibility(8);
        paramHolder.i.setVisibility(8);
        b(paramHolder);
      }
      else if (4 == paramHolder.a.getEmoticon().jobType)
      {
        if (!paramChatMessage.isSend()) {
          ReportController.b(this.g, "CliOper", "", "", "MbJieshou", "mbjieshou", 0, 0, paramHolder.a.getEmoticon().epId, "", "", "");
        }
        a(paramChatMessage, paramHolder);
        a(paramHolder);
      }
      else
      {
        a(paramChatMessage, paramHolder);
      }
      if (((2 == paramHolder.a.getEmoticon().jobType) || (4 == paramHolder.a.getEmoticon().jobType)) && (paramHolder.g != null))
      {
        paramHolder.g.setVisibility(8);
        paramHolder.g.f();
      }
      boolean bool = this.s;
    }
    l1 = System.currentTimeMillis();
    if ((QLog.isColorLevel()) && (paramHolder.a != null) && (paramHolder.a.getEmoticon() != null))
    {
      paramMessageForMarketFace = new StringBuilder();
      paramMessageForMarketFace.append("epId = ");
      paramMessageForMarketFace.append(paramHolder.a.getEmoticon().epId);
      paramMessageForMarketFace.append(":view time = ");
      paramMessageForMarketFace.append(l1 - paramLong);
      QLog.d("MarketFaceItemBuilder", 1, paramMessageForMarketFace.toString());
    }
  }
  
  private void a(GuildMarketFaceItemBuilder.Holder paramHolder, long paramLong)
  {
    Animatable localAnimatable = (Animatable)paramHolder.B.getDrawable();
    if (this.t.contains(Long.valueOf(paramLong)))
    {
      if (!localAnimatable.isRunning()) {
        localAnimatable.start();
      }
      paramHolder.w.setVisibility(4);
      paramHolder.B.setVisibility(0);
      return;
    }
    if (localAnimatable.isRunning()) {
      localAnimatable.stop();
    }
    paramHolder.w.setVisibility(0);
    paramHolder.B.setVisibility(4);
  }
  
  private void a(GuildMarketFaceItemBuilder.Holder paramHolder, Rect paramRect)
  {
    AIOEmotionFragment.a(this.o, paramHolder.q, this.c, paramRect);
  }
  
  private void a(GuildMarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, GuildMsgItemLayout paramGuildMsgItemLayout)
  {
    if (paramURLDrawable != null)
    {
      int i = paramURLDrawable.getStatus();
      if (i != 1)
      {
        if (i != 2)
        {
          paramHolder.o.setVisibility(0);
          paramGuildMsgItemLayout.setProgressVisable(true);
          return;
        }
        paramHolder.o.setVisibility(8);
        paramGuildMsgItemLayout.setProgressVisable(false);
        if (AppSetting.e) {
          paramHolder.n.setContentDescription(HardCodeUtil.a(2131904382));
        }
      }
      else
      {
        if (!MagicfaceViewController.b()) {
          paramHolder.o.setVisibility(8);
        }
        if ((!EmoticonPanelUtils.a()) || (2 != paramHolder.a.getEmoticon().jobType) || (this.r.verifyMagicFacePackageIntact(paramHolder.a.getEmoticon().epId)) || (EmoticonPanelUtils.c()))
        {
          float f = this.r.getEmoticonPackageLoadingProgress(paramHolder.a.getEmoticon().epId);
          if ((f < 0.0F) || (1.0F == f))
          {
            paramHolder.o.setVisibility(8);
            paramGuildMsgItemLayout.setProgressVisable(false);
          }
        }
      }
    }
  }
  
  private void a(GuildMarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    ThreadManager.post(new GuildMarketFaceItemBuilder.4(this, paramString, paramHolder), 5, null, true);
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    boolean bool2 = true;
    localObject = ((ActivityManager)localObject).getRunningTasks(1);
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((List)localObject).size() > 0)
      {
        localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity;
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((ComponentName)localObject).getClassName();
          bool1 = paramContext.getClass().getName().equals(localObject);
        }
      }
    }
    return bool1;
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131887648, 2131888569, new GuildMarketFaceItemBuilder.9(paramEmoticon, paramContext, paramQQAppInterface, paramInt), new GuildMarketFaceItemBuilder.10()).show();
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage, GuildMarketFaceItemBuilder.Holder paramHolder)
  {
    if ((paramHolder.a.isSound()) && (paramHolder.a.isNewSoundType()) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (paramHolder.a.getWaveformArray() != null)
      {
        paramChatMessage = (RelativeLayout.LayoutParams)paramHolder.x.getLayoutParams();
        paramChatMessage.width = AIOUtils.b(39.0F, this.o.getResources());
        paramHolder.x.setAudioData(paramHolder.a.getWaveformArray(), paramChatMessage.width, paramHolder.a.getVoiceLength());
        if (Build.VERSION.SDK_INT < 19)
        {
          paramChatMessage = (RelativeLayout.LayoutParams)paramHolder.y.getLayoutParams();
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramHolder.C.getLayoutParams();
          paramChatMessage.width = AIOUtils.b(92.0F, this.o.getResources());
          localLayoutParams.width = AIOUtils.b(92.0F, this.o.getResources());
        }
      }
      int i = paramHolder.a.getWaveBackgroundColor();
      int j = paramHolder.a.getWaveForegroundColor();
      paramChatMessage = new RoundedColorDrawable(i, 1, 1, AIOUtils.b(22.0F, this.o.getResources()));
      paramHolder.y.setBackgroundDrawable(paramChatMessage);
      paramHolder.A.setDrawColor(i);
      paramHolder.A.postInvalidate();
      paramHolder.x.setProgressColor(j);
      paramHolder.w.setThemeColor(j);
    }
  }
  
  private void b(GuildMarketFaceItemBuilder.Holder paramHolder)
  {
    paramHolder.s = false;
    if ((2 == paramHolder.a.getEmoticon().jobType) && (((MessageForMarketFace)paramHolder.q).mMarkFaceMessage != null))
    {
      if (!MagicfaceViewController.b()) {
        return;
      }
      Object localObject1;
      if (!this.r.verifyMagicFacePackageIntact(paramHolder.a.getEmoticon().epId))
      {
        if (!EmoticonPanelUtils.a())
        {
          paramHolder.i.setVisibility(8);
          return;
        }
        if (EmoticonPanelUtils.c()) {
          return;
        }
        if ((!this.r.isMagicFacePackageIntact(paramHolder.a.getEmoticon().epId, Boolean.valueOf(false))) && (-1.0F == this.r.getEmoticonPackageLoadingProgress(paramHolder.a.getEmoticon().epId)))
        {
          this.r.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.y);
          localObject1 = new EmoticonPackage();
          ((EmoticonPackage)localObject1).name = paramHolder.a.getEmoticon().name;
          ((EmoticonPackage)localObject1).epId = paramHolder.a.getEmoticon().epId;
          ((EmoticonPackage)localObject1).jobType = 3;
          ((EmoticonPackage)localObject1).rscType = PngFrameUtil.b(paramHolder.a.getEmoticon().magicValue);
          ((EmoticonPackage)localObject1).type = 1;
          ((EmoticonPackage)localObject1).isMagicFaceDownloading = true;
          ((IEmoticonManagerService)this.g.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramHolder.a.getEmoticon());
          this.p.add(paramHolder);
          paramHolder.s = ((MessageForMarketFace)paramHolder.q).needToPlay;
          paramHolder.i.setVisibility(8);
          paramHolder.o.setVisibility(0);
          ((MessageForMarketFace)paramHolder.q).needToPlay = false;
          this.r.pullEmoticonPackage((EmoticonPackage)localObject1, false);
          ReportController.b(this.g, "CliOper", "", "", "MbJieshou", "MbZidongXiazai", 0, 0, paramHolder.a.getEmoticon().epId, "", "", "");
        }
      }
      else
      {
        if (PngFrameUtil.b(paramHolder.a.getEmoticon().magicValue) == 1)
        {
          paramHolder.i.setVisibility(8);
        }
        else
        {
          paramHolder.i.setImageResource(2130837998);
          paramHolder.i.setVisibility(0);
        }
        if (((MessageForMarketFace)paramHolder.q).needToPlay)
        {
          ((MessageForMarketFace)paramHolder.q).needToPlay = false;
          localObject1 = new Emoticon();
          ((Emoticon)localObject1).eId = paramHolder.a.getEmoticon().eId;
          ((Emoticon)localObject1).epId = paramHolder.a.getEmoticon().epId;
          ((Emoticon)localObject1).magicValue = paramHolder.a.getEmoticon().magicValue;
          ((Emoticon)localObject1).jobType = paramHolder.a.getEmoticon().jobType;
          Object localObject2 = ((BaseActivity)this.o).getChatFragment();
          if (localObject2 != null)
          {
            localObject2 = ((ChatFragment)localObject2).k();
            if ((localObject2 != null) && (MagicfaceViewController.b()))
            {
              localObject2 = (AIOEmoticonUIHelper)((BaseChatPie)localObject2).q(105);
              if (localObject2 != null) {
                ((AIOEmoticonUIHelper)localObject2).a((Emoticon)localObject1, 1, ((MessageForMarketFace)paramHolder.q).senderuin, false);
              }
            }
          }
          ReportController.b(this.g, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, paramHolder.a.getEmoticon().epId, "", "", "");
        }
      }
    }
  }
  
  private void b(GuildMarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramHolder.a.getEmoticon() != null))
    {
      int i = paramHolder.a.getEmoticon().width;
      int i1 = 200;
      if (i == 0) {
        j = 200;
      } else {
        j = paramHolder.a.getEmoticon().width;
      }
      if (paramHolder.a.getEmoticon().height != 0) {
        i1 = paramHolder.a.getEmoticon().height;
      }
      int k = j;
      i = i1;
      if (paramHolder.a.getEmoticon().extensionWidth != 0)
      {
        k = j;
        i = i1;
        if (paramHolder.a.getEmoticon().extensionHeight != 0)
        {
          k = paramHolder.a.getEmoticon().extensionWidth;
          i = paramHolder.a.getEmoticon().extensionHeight;
        }
      }
      int j = k;
      if (k != i) {
        j = i;
      }
      k = this.n;
      int i2 = this.m;
      i1 = (j * k + (i2 >> 1)) / i2;
      i = (i * k + (i2 >> 1)) / i2;
      paramHolder.h.setLayoutParams(new FrameLayout.LayoutParams(i1, i));
      Object localObject1 = paramHolder.p.getTag();
      if ((localObject1 instanceof Integer)) {
        i = ((Integer)localObject1).intValue();
      } else {
        i = -1;
      }
      if ((paramHolder.p.getVisibility() == 0) && (i != -1))
      {
        String str = (String)paramHolder.p.getTag(2131430109);
        Object localObject2 = (String)paramHolder.p.getTag(2131430108);
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(AIOUtils.b(12.0F, this.o.getResources()));
        localPaint.setTextAlign(Paint.Align.LEFT);
        i2 = (int)localPaint.measureText("...");
        float f;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904383));
          ((StringBuilder)localObject1).append(str);
          f = localPaint.measureText(((StringBuilder)localObject1).toString());
        }
        else
        {
          f = localPaint.measureText(HardCodeUtil.a(2131904379));
        }
        int i3 = (int)f;
        j = ((String)localObject2).length();
        k = (int)localPaint.measureText((String)localObject2) + i3;
        localObject1 = "";
        while ((k > i1) && (j > 0))
        {
          j -= 1;
          localObject1 = ((String)localObject2).substring(0, j);
          k = (int)localPaint.measureText((String)localObject1) + i2 + i3;
        }
        if (!((String)localObject1).equals(""))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("...");
          localObject1 = a(i, ((StringBuilder)localObject2).toString(), str);
          paramHolder.p.setText((CharSequence)localObject1);
        }
      }
    }
    paramHolder.h.setImageDrawable(paramURLDrawable);
    a(paramHolder, paramURLDrawable, paramHolder.k);
  }
  
  private void b(GuildMarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, String paramString)
  {
    String str;
    if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
      str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
    } else {
      str = "";
    }
    paramURLDrawable.restartDownload();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgOnclickListener| URLDrawable restartDownload status=");
      localStringBuilder.append(paramURLDrawable.getStatus());
      QLog.d("MarketFaceItemBuilder", 2, localStringBuilder.toString());
    }
    a(paramHolder, paramURLDrawable, str);
    paramHolder.o.setVisibility(0);
    if ((paramHolder.a != null) && (paramHolder.a.isSound()) && ("big_sound".equals(paramString))) {
      q = paramHolder.q.uniseq;
    }
  }
  
  private void b(GuildMarketFaceItemBuilder.Holder paramHolder, String paramString)
  {
    if ((paramHolder.a != null) && (paramHolder.a.getEmoticon() != null) && (paramHolder.a.getEmoticon().jobType != 0) && (paramHolder.a.getEmoticon().jobType != 2) && (paramHolder.a.getEmoticon().jobType != 4))
    {
      paramHolder.o.setVisibility(8);
      if ("big_sound".equals(paramString))
      {
        if ((paramHolder.a.getEmoticon() != null) && (paramHolder.a.getEmoticon().isSound))
        {
          if (c(paramHolder.q))
          {
            MediaPlayerManager.a(this.g).a(false);
            return;
          }
          if (this.g.isVideoChatting())
          {
            QQToast.makeText(this.g.getApp(), 2131892896, 0).show(this.o.getResources().getDimensionPixelSize(2131299920));
            return;
          }
          MediaPlayerManager.a(this.g).a(paramHolder.q);
        }
      }
      else if ("aio_preview".equals(paramString))
      {
        paramString = paramHolder.a.getLoadingDrawable("fromAIO", true);
        if (paramString != null)
        {
          paramHolder.h.setImageDrawable(paramString);
          paramHolder.o.setVisibility(0);
          a(paramHolder, paramString);
          if (paramHolder.a.isSound()) {
            q = paramHolder.q.uniseq;
          }
        }
      }
    }
  }
  
  private QQProgressDialog c()
  {
    if (((BaseActivity)this.o).getChatFragment().k() != null)
    {
      if (((BaseActivity)this.o).getChatFragment().k().af == null) {
        ((BaseActivity)this.o).getChatFragment().k().af = new QQProgressDialog(this.o);
      }
      return ((BaseActivity)this.o).getChatFragment().k().af;
    }
    return null;
  }
  
  private void c(GuildMarketFaceItemBuilder.Holder paramHolder)
  {
    if (!this.r.isMagicFacePackageIntact(paramHolder.a.getEmoticon().epId, Boolean.valueOf(false)))
    {
      this.r.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.y);
      EmoticonPackage localEmoticonPackage = new EmoticonPackage();
      localEmoticonPackage.name = paramHolder.a.getEmoticon().name;
      localEmoticonPackage.epId = paramHolder.a.getEmoticon().epId;
      localEmoticonPackage.jobType = 3;
      localEmoticonPackage.type = 1;
      localEmoticonPackage.isMagicFaceDownloading = true;
      if (paramHolder.u == -1) {
        localEmoticonPackage.rscType = PngFrameUtil.b(paramHolder.a.getEmoticon().magicValue);
      } else {
        localEmoticonPackage.rscType = paramHolder.u;
      }
      ((IEmoticonManagerService)this.g.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramHolder.a.getEmoticon());
      paramHolder.s = false;
      ((MessageForMarketFace)paramHolder.q).needToPlay = true;
      this.p.add(paramHolder);
      paramHolder.i.setVisibility(8);
      paramHolder.o.setVisibility(0);
      this.r.pullEmoticonPackage(localEmoticonPackage, false);
      ReportController.b(this.g, "CliOper", "", "", "MbJieshou", "MbZhudongXiazai", 0, 0, "", "", "", "");
    }
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    if (paramChatMessage == null) {
      return false;
    }
    ChatMessage localChatMessage = MediaPlayerManager.a(this.g).f();
    boolean bool1;
    if (localChatMessage != paramChatMessage)
    {
      bool1 = bool2;
      if ((localChatMessage instanceof MessageForMarketFace))
      {
        bool1 = bool2;
        if (localChatMessage.frienduin != null)
        {
          bool1 = bool2;
          if (localChatMessage.frienduin.equals(paramChatMessage.frienduin))
          {
            bool1 = bool2;
            if (localChatMessage.uniseq != paramChatMessage.uniseq) {}
          }
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private void d(GuildMarketFaceItemBuilder.Holder paramHolder)
  {
    if ((!EmoticonPanelUtils.a()) || (2 != paramHolder.a.getEmoticon().jobType) || (this.r.verifyMagicFacePackageIntact(paramHolder.a.getEmoticon().epId)) || (!MagicfaceViewController.b()) || (EmoticonPanelUtils.c()))
    {
      float f = this.r.getEmoticonPackageLoadingProgress(paramHolder.a.getEmoticon().epId);
      if ((f < 0.0F) || (1.0F == f))
      {
        paramHolder.o.setVisibility(8);
        paramHolder.k.setProgressVisable(false);
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
        }
      }
    }
  }
  
  private void j(View paramView)
  {
    paramView = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    Object localObject;
    if ((paramView.a != null) && (paramView.a.getEmoticon() != null) && (2 == paramView.a.getEmoticon().jobType))
    {
      if (!this.r.isMagicFacePackageIntact(paramView.a.getEmoticon().epId, Boolean.valueOf(false)))
      {
        this.r.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.y);
        localObject = new EmoticonPackage();
        ((EmoticonPackage)localObject).name = paramView.a.getEmoticon().name;
        ((EmoticonPackage)localObject).epId = paramView.a.getEmoticon().epId;
        ((EmoticonPackage)localObject).jobType = 3;
        ((EmoticonPackage)localObject).type = 1;
        ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
        paramView.s = false;
        ((MessageForMarketFace)paramView.q).needToPlay = false;
        ((IEmoticonManagerService)this.g.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramView.a.getEmoticon());
        this.p.add(paramView);
        paramView.i.setVisibility(8);
        paramView.o.setVisibility(0);
        this.r.pullEmoticonPackage((EmoticonPackage)localObject, false);
      }
      else
      {
        localObject = ((BaseActivity)this.o).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).k();
          if ((localObject != null) && (MagicfaceViewController.b()))
          {
            localObject = (AIOEmoticonUIHelper)((BaseChatPie)localObject).q(105);
            if (localObject != null) {
              ((AIOEmoticonUIHelper)localObject).a(paramView.a.getEmoticon(), 1, paramView.q.senderuin, true);
            }
          }
        }
      }
      ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongBofang", 0, 0, paramView.a.getEmoticon().epId, "", "", "");
    }
    if ((paramView.a != null) && (paramView.a.getEmoticon() != null) && (4 == paramView.a.getEmoticon().jobType) && (System.currentTimeMillis() - this.A > 3000L) && (this.r.canPlayH5Magic()))
    {
      this.A = System.currentTimeMillis();
      if (this.r.isH5MagicIntact(paramView.a.getEmoticon().epId, true, true))
      {
        a(paramView, "0");
      }
      else
      {
        this.r.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.y);
        localObject = new EmoticonPackage();
        ((EmoticonPackage)localObject).name = paramView.a.getEmoticon().name;
        ((EmoticonPackage)localObject).epId = paramView.a.getEmoticon().epId;
        ((EmoticonPackage)localObject).jobType = 5;
        ((EmoticonPackage)localObject).type = 1;
        ((EmoticonPackage)localObject).isMagicFaceDownloading = true;
        paramView.s = false;
        ((MessageForMarketFace)paramView.q).needToPlay = false;
        ((IEmoticonManagerService)this.g.getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(paramView.a.getEmoticon());
        this.p.add(paramView);
        paramView.i.setVisibility(8);
        paramView.o.setVisibility(0);
        this.r.pullEmoticonPackage((EmoticonPackage)localObject, false);
      }
      ReportController.b(this.g, "CliOper", "", "", "MbFasong", "MbZhudongBofang", 0, 0, paramView.a.getEmoticon().epId, "", "", "");
    }
  }
  
  private void k(View paramView)
  {
    GuildMarketFaceItemBuilder.Holder localHolder = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    if ((localHolder.a != null) && (localHolder.a.isSound()) && (localHolder.a.isNewSoundType()))
    {
      boolean bool = c(localHolder.q);
      paramView = "";
      int i;
      if (bool)
      {
        MediaPlayerManager.a(this.g).a(false);
        localObject = this.g;
        i = this.c.a;
        if (localHolder.a.getEmoticon() != null) {
          paramView = localHolder.a.getEmoticon().epId;
        }
        EmoticonOperateReport.reportNewSoundEvent((AppInterface)localObject, "0X800A934", i, paramView);
        return;
      }
      if (this.g.isVideoChatting())
      {
        QQToast.makeText(this.g.getApp(), 2131892896, 0).show(this.o.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      if ((localHolder.q instanceof MessageForMarketFace)) {
        ((MessageForMarketFace)localHolder.q).playProgress = 0.0F;
      }
      localHolder.x.setProgress(0.0F);
      if (MediaPlayerManager.a(this.g).a(localHolder.q))
      {
        localHolder.w.setPlayState(true);
        QQAppInterface localQQAppInterface = this.g;
        i = this.c.a;
        if (localHolder.a.getEmoticon() != null) {
          localObject = localHolder.a.getEmoticon().epId;
        } else {
          localObject = "";
        }
        EmoticonOperateReport.reportNewSoundEvent(localQQAppInterface, "0X800A933", i, (String)localObject);
        bool = true;
      }
      else
      {
        bool = false;
      }
      if (!bool)
      {
        localObject = this.g;
        if (localHolder.a.getEmoticon() != null) {
          paramView = localHolder.a.getEmoticon().epId;
        }
        EmoticonOperateReport.reportNewSoundEvent((AppInterface)localObject, "0X800A935", -1, paramView);
      }
      Object localObject = new HashMap();
      if (bool) {
        paramView = "0";
      } else {
        paramView = "1";
      }
      ((HashMap)localObject).put("playResult", paramView);
      ((HashMap)localObject).put("playType", "1");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool, 0L, 0L, (HashMap)localObject, null);
    }
  }
  
  private void l(View paramView)
  {
    GuildMarketFaceItemBuilder.Holder localHolder = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    Object localObject = localHolder.h.getDrawable();
    if ((localObject instanceof URLDrawable))
    {
      URLDrawable localURLDrawable = (URLDrawable)localObject;
      localObject = localURLDrawable.getURL().getHost();
      if ((localURLDrawable.getTag() instanceof Bundle)) {
        localObject = ((Bundle)localURLDrawable.getTag()).getString("display_type");
      }
      int i = localURLDrawable.getStatus();
      if (i != 1)
      {
        if (i == 2) {
          b(localHolder, localURLDrawable, (String)localObject);
        }
      }
      else {
        b(localHolder, (String)localObject);
      }
      if ((localHolder.a != null) && (localHolder.a.getEmoticon() != null) && (localHolder.a.getEmoticon().jobType == 2) && (MagicfaceViewController.b())) {
        c(localHolder);
      }
      if ((localURLDrawable.getStatus() == 1) || ((localHolder.a != null) && (localHolder.a.getEmoticon() != null) && (localHolder.a.isAioPreviewExists()))) {
        a(localHolder, AnimationUtils.a(paramView));
      }
    }
    else if (((localObject instanceof PngFrameDrawable)) && (localHolder.a != null) && (localHolder.a.getEmoticon() != null) && (localHolder.a.isAioPreviewExists()))
    {
      a(localHolder, AnimationUtils.a(paramView));
    }
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    long l1 = System.currentTimeMillis();
    paramGuildMsgItemLayout = (MessageForMarketFace)paramChatMessage;
    GuildMarketFaceItemBuilder.Holder localHolder = (GuildMarketFaceItemBuilder.Holder)paramViewHolder;
    this.w.add(localHolder);
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(this.o);
      Object localObject2 = new RelativeLayout(this.o);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout)localObject2).setId(2131437966);
      paramView = new ImageView(this.o);
      paramView.setId(2131433475);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131430578);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15, 2131430578);
      ((RelativeLayout)localObject2).addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setOnClickListener(this);
      localObject1 = new FrameLayout(this.o);
      ((FrameLayout)localObject1).setId(2131429435);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = 8;
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131433475);
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      ((FrameLayout)localObject1).setOnClickListener(this);
      ((FrameLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((FrameLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramOnLongClickAndTouchListener = new GuildMarketFaceItemBuilder.MarketFaceView(this, this.o);
      ((FrameLayout)localObject1).addView(paramOnLongClickAndTouchListener, -2, -2);
      localObject3 = new ImageView(this.o);
      Object localObject4 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject4).gravity = 85;
      ((FrameLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new ImageView(this.o);
      ((ImageView)localObject4).setId(2131449970);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131429435);
      ((RelativeLayout.LayoutParams)localObject5).addRule(8, 2131429435);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      ((ImageView)localObject4).setOnClickListener(this);
      localObject5 = new BreathAnimationLayout(this.o);
      ((BreathAnimationLayout)localObject5).setId(2131439262);
      PttAudioPlayView localPttAudioPlayView = new PttAudioPlayView(this.o, 10);
      localPttAudioPlayView.setThemeColor(this.o.getResources().getColorStateList(2131168016).getDefaultColor());
      localPttAudioPlayView.setId(2131439264);
      localPttAudioPlayView.setPttPauseOrStopDrawable(2130838205);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject6).leftMargin = AIOUtils.b(5.0F, this.o.getResources());
      ((RelativeLayout.LayoutParams)localObject6).width = AIOUtils.b(25.0F, this.o.getResources());
      ((RelativeLayout.LayoutParams)localObject6).height = AIOUtils.b(25.0F, this.o.getResources());
      localPttAudioPlayView.setLayoutParams((ViewGroup.LayoutParams)localObject6);
      localPttAudioPlayView.setOnClickListener(this);
      localObject6 = new ImageView(this.o);
      Object localObject7 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject7).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject7).leftMargin = AIOUtils.b(5.0F, this.o.getResources());
      ((RelativeLayout.LayoutParams)localObject7).width = AIOUtils.b(20.0F, this.o.getResources());
      ((RelativeLayout.LayoutParams)localObject7).height = AIOUtils.b(20.0F, this.o.getResources());
      ((ImageView)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject7);
      ((ImageView)localObject6).setImageDrawable((Drawable)this.o.getResources().getDrawable(2130839583));
      ((ImageView)localObject6).setVisibility(4);
      localObject7 = new PttAudioWaveView(this.o);
      ((PttAudioWaveView)localObject7).setShowProgressLine(false);
      ((PttAudioWaveView)localObject7).setMaxTopBottomPadding(4);
      ((PttAudioWaveView)localObject7).setProgressColor(this.o.getResources().getColorStateList(2131168016).getDefaultColor());
      ((PttAudioWaveView)localObject7).setId(2131439265);
      Object localObject8 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject8).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject8).addRule(1, 2131439264);
      ((RelativeLayout.LayoutParams)localObject8).width = AIOUtils.b(39.0F, this.o.getResources());
      ((RelativeLayout.LayoutParams)localObject8).height = AIOUtils.b(45.0F, this.o.getResources());
      ((RelativeLayout.LayoutParams)localObject8).leftMargin = ViewUtils.dip2px(9.0F);
      ((RelativeLayout.LayoutParams)localObject8).rightMargin = ViewUtils.dip2px(12.0F);
      ((PttAudioWaveView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
      ((PttAudioWaveView)localObject7).setCanSupportSlide(false);
      ((PttAudioWaveView)localObject7).setOnClickListener(this);
      localObject8 = new SyncParentPressedRelativeLayout(this.o);
      ((RelativeLayout)localObject8).setId(2131439263);
      ((RelativeLayout)localObject8).addView((View)localObject7);
      ((RelativeLayout)localObject8).addView(localPttAudioPlayView);
      ((RelativeLayout)localObject8).addView((View)localObject6);
      RelativeLayout localRelativeLayout = new RelativeLayout(this.o);
      TriangleView localTriangleView = new TriangleView(this.o);
      Object localObject9 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(9.0F), ViewUtils.dip2px(5.0F));
      ((RelativeLayout.LayoutParams)localObject9).leftMargin = ViewUtils.dip2px(2.0F);
      ((RelativeLayout.LayoutParams)localObject9).addRule(14);
      ((RelativeLayout.LayoutParams)localObject9).addRule(10);
      localTriangleView.setId(2131440422);
      localTriangleView.setRotation(180.0F);
      localTriangleView.setTranslationY(ViewUtils.dip2px(1.0F));
      localTriangleView.setLayoutParams((ViewGroup.LayoutParams)localObject9);
      localRelativeLayout.addView(localTriangleView);
      localObject9 = new RelativeLayout.LayoutParams(-2, ViewUtils.dip2px(29.0F));
      ((RelativeLayout.LayoutParams)localObject9).addRule(3, 2131440422);
      localRelativeLayout.addView((View)localObject8, (ViewGroup.LayoutParams)localObject9);
      ((BreathAnimationLayout)localObject5).addView(localRelativeLayout);
      localObject9 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject9).addRule(14, 2131429435);
      ((RelativeLayout.LayoutParams)localObject9).addRule(3, 2131429435);
      ((RelativeLayout.LayoutParams)localObject9).bottomMargin = ViewUtils.dip2px(17.0F);
      ((RelativeLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject9);
      localObject9 = new ImageView(this.o);
      ((ImageView)localObject9).setId(2131433476);
      Object localObject10 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject10).addRule(1, 2131429435);
      ((RelativeLayout.LayoutParams)localObject10).addRule(15, 2131429435);
      ((RelativeLayout.LayoutParams)localObject10).leftMargin = 10;
      ((RelativeLayout)localObject2).addView((View)localObject9, (ViewGroup.LayoutParams)localObject10);
      ((ImageView)localObject9).setOnClickListener(this);
      localObject10 = new DuiButtonImageView(this.o, this.g, DoutuMsgUtil.a(paramChatMessage));
      ((DuiButtonImageView)localObject10).setId(2131432263);
      Object localObject11 = new RelativeLayout.LayoutParams(AIOUtils.b(50.0F, this.o.getResources()), AIOUtils.b(50.0F, this.o.getResources()));
      ((RelativeLayout.LayoutParams)localObject11).addRule(1, 2131429435);
      ((RelativeLayout.LayoutParams)localObject11).addRule(8, 2131429435);
      ((RelativeLayout.LayoutParams)localObject11).setMargins(0, 0, 0, -AIOUtils.b(6.5F, this.o.getResources()));
      ((RelativeLayout)localObject2).addView((View)localObject10, (ViewGroup.LayoutParams)localObject11);
      localObject11 = new ImageView(this.o);
      ((ImageView)localObject11).setId(2131437876);
      Object localObject12 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject12).addRule(1, 2131429435);
      ((RelativeLayout.LayoutParams)localObject12).addRule(8, 2131429435);
      ((RelativeLayout)localObject2).addView((View)localObject11, (ViewGroup.LayoutParams)localObject12);
      localObject12 = new TextView(this.o);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      ((TextView)localObject12).setTextSize(12.0F);
      ((TextView)localObject12).setTextColor(-1);
      localLayoutParams2.topMargin = AIOUtils.b(8.0F, this.o.getResources());
      ((TextView)localObject12).setGravity(17);
      localLayoutParams2.addRule(3, 2131437966);
      try
      {
        ((TextView)localObject12).setBackgroundDrawable(this.o.getResources().getDrawable(2130846198));
      }
      catch (Exception localException2)
      {
        QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException2);
      }
      ((TextView)localObject12).setPadding(AIOUtils.b(9.0F, this.o.getResources()), AIOUtils.b(4.0F, this.o.getResources()), AIOUtils.b(9.0F, this.o.getResources()), AIOUtils.b(4.0F, this.o.getResources()));
      paramViewHolder.addView((View)localObject2, localLayoutParams1);
      ((ImageView)localObject11).setOnClickListener(this);
      localObject2 = new ProgressBar(this.o, null, 0);
      ((ProgressBar)localObject2).setId(2131430606);
      try
      {
        ((ProgressBar)localObject2).setIndeterminateDrawable(this.o.getResources().getDrawable(2130839585));
      }
      catch (Exception localException1)
      {
        QLog.e("MarketFaceItemBuilder", 1, "getBubbleView: ", localException1);
      }
      int i = AIOUtils.b(16.0F, this.o.getResources());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      localLayoutParams.gravity = 17;
      ((FrameLayout)localObject1).addView((View)localObject2, localLayoutParams);
      localHolder.h = paramOnLongClickAndTouchListener;
      localHolder.c = ((ImageView)localObject3);
      localHolder.d = ((ImageView)localObject4);
      localHolder.e = paramView;
      localHolder.f = ((ImageView)localObject9);
      localHolder.g = ((DuiButtonImageView)localObject10);
      localHolder.i = ((ImageView)localObject11);
      localHolder.n = ((FrameLayout)localObject1);
      localHolder.o = ((ProgressBar)localObject2);
      localHolder.p = ((TextView)localObject12);
      localHolder.C = ((BreathAnimationLayout)localObject5);
      localHolder.w = localPttAudioPlayView;
      localHolder.x = ((PttAudioWaveView)localObject7);
      localHolder.y = ((RelativeLayout)localObject8);
      localHolder.z = localRelativeLayout;
      localHolder.A = localTriangleView;
      localHolder.B = ((ImageView)localObject6);
    }
    else
    {
      if ((localHolder.a != null) && (localHolder.a.isSound()) && (localHolder.d != null) && ((localHolder.d.getDrawable() instanceof AnimationDrawable))) {
        localHolder.d.setImageResource(2130849016);
      }
      if (AppSetting.e) {
        localHolder.n.setContentDescription("");
      }
      paramViewHolder = paramView;
    }
    paramView = paramGuildMsgItemLayout;
    if (!c(paramChatMessage)) {
      paramView.playProgress = 0.0F;
    }
    new QueryTask(new GuildMarketFaceItemBuilder.1(this, localHolder), new GuildMarketFaceItemBuilder.2(this, localHolder, paramView, paramChatMessage, l1)).execute(paramView.mMarkFaceMessage);
    return paramViewHolder;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildMarketFaceItemBuilder.Holder();
  }
  
  protected void a(MessageForMarketFace paramMessageForMarketFace, IPicEmoticonInfo paramIPicEmoticonInfo)
  {
    if ((paramMessageForMarketFace != null) && (paramIPicEmoticonInfo != null) && (paramIPicEmoticonInfo.getEmoticon() != null))
    {
      if (paramIPicEmoticonInfo.getEmoticon().epId == null) {
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.o, null);
      localActionSheet.setMainTitle(this.o.getString(2131888892));
      localActionSheet.addButton(this.o.getResources().getString(2131888891), 1);
      localActionSheet.addButton(this.o.getResources().getString(2131888893), 1);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new GuildMarketFaceItemBuilder.16(this, paramIPicEmoticonInfo, localActionSheet, paramMessageForMarketFace));
      localActionSheet.show();
    }
  }
  
  void a(GuildMarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable)
  {
    a(paramHolder, paramURLDrawable, "");
  }
  
  void a(GuildMarketFaceItemBuilder.Holder paramHolder, URLDrawable paramURLDrawable, String paramString)
  {
    paramHolder.d.setVisibility(8);
    paramHolder.C.setVisibility(8);
    paramHolder.c.setVisibility(8);
    paramHolder.i.setVisibility(8);
    paramHolder.v = false;
    int i = paramURLDrawable.getStatus();
    if (paramURLDrawable.getHeader("2g_use_gif") != null) {
      i = 1;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if ((paramURLDrawable.getStateTag() instanceof Bundle)) {
        str = ((Bundle)paramURLDrawable.getStateTag()).getString("display_type");
      }
    }
    if ("aio_preview".equals(str))
    {
      if (paramHolder.a.isSound())
      {
        if (paramHolder.a.isNewSoundType())
        {
          paramHolder.C.setVisibility(0);
          return;
        }
        paramHolder.d.setImageResource(2130849016);
        paramHolder.d.setVisibility(0);
        return;
      }
      if ((i == 1) && (paramHolder.a.getImageType() == 3))
      {
        paramHolder.c.setImageResource(2130837995);
        paramHolder.c.setVisibility(0);
        paramHolder.v = true;
      }
    }
    else if ("big_sound".equals(str))
    {
      if (c(paramHolder.q))
      {
        if (paramHolder.a.isNewSoundType())
        {
          paramHolder.C.setVisibility(0);
          paramHolder.w.setPlayState(true);
          return;
        }
        paramHolder.d.setVisibility(0);
        paramURLDrawable = (AnimationDrawable)this.o.getResources().getDrawable(2130772400);
        paramHolder.d.setImageDrawable(paramURLDrawable);
        paramURLDrawable.start();
        return;
      }
      if (paramHolder.a.isNewSoundType())
      {
        paramHolder.C.setVisibility(0);
        paramHolder.w.setPlayState(false);
        return;
      }
      paramHolder.d.setImageResource(2130849016);
      paramHolder.d.setVisibility(0);
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat)
  {
    if ((paramView != null) && (paramFloat > 0.0F))
    {
      paramXListView = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
      if ((paramXListView != null) && (paramXListView.a != null) && (paramXListView.a.isSound()) && (paramXListView.a.isNewSoundType()) && (c(paramChatMessage)))
      {
        paramView = new StringBuilder();
        paramView.append("AudioPlayer onPlayProgress progress_ratio = ");
        paramView.append(paramFloat);
        QLog.i("MarketFaceItemBuilder", 2, paramView.toString());
        paramXListView.x.setProgress(paramFloat);
        if ((paramChatMessage instanceof MessageForMarketFace)) {
          ((MessageForMarketFace)paramChatMessage).playProgress = paramFloat;
        }
      }
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
      if (paramXListView.a.isNewSoundType())
      {
        paramXListView.x.setProgress(0.0F);
        if (paramXListView.w != null) {
          paramXListView.w.setPlayState(false);
        }
      }
      else
      {
        paramXListView.d.setImageResource(2130849016);
      }
      paramView = paramXListView.a.getLoadingDrawable("fromAIO", false);
      paramXListView.h.setImageDrawable(paramView);
    }
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    if ((paramXListView != null) && (paramXListView.a != null))
    {
      if (paramXListView.a.getEmoticon() == null) {
        return false;
      }
      if (paramXListView.a.isSound())
      {
        paramView = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", paramXListView.a.getEmoticon().epId).replace("[eId]", paramXListView.a.getEmoticon().eId);
        if (!FileUtils.fileExistsAndNotEmpty(paramView))
        {
          if (this.t.contains(Long.valueOf(paramChatMessage.uniseq))) {
            return false;
          }
          this.t.add(Long.valueOf(paramChatMessage.uniseq));
          a(paramXListView, paramChatMessage.uniseq);
          ThreadManager.getFileThreadHandler().post(new GuildMarketFaceItemBuilder.17(this, paramXListView, paramChatMessage));
          return false;
        }
        paramAudioPlayerBase.a(4);
        if (paramAudioPlayerBase.a(paramView))
        {
          paramView = paramXListView.a.getLoadingDrawable("fromAIO", true);
          paramXListView.h.setImageDrawable(paramView);
          ((IPicEmoticonInfoService)QRoute.api(IPicEmoticonInfoService.class)).startSoundDrawablePlay(paramView);
          if (paramXListView.a.isNewSoundType())
          {
            if (paramXListView.w != null)
            {
              paramXListView.w.setPlayState(true);
              return true;
            }
          }
          else
          {
            paramView = (AnimationDrawable)this.o.getResources().getDrawable(2130772400);
            paramXListView.d.setImageDrawable(paramView);
            paramView.start();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = ((IEmojiManagerService)this.g.getRuntimeService(IEmojiManagerService.class)).getEmojiListenerManager();
    ((IEmojiListenerManager)localObject).removeEmoticonPackageDownloadListener(this.y);
    ((IEmojiListenerManager)localObject).removeEmotionJsonDownloadListener(this.z);
    localObject = this.w.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GuildMarketFaceItemBuilder.Holder)((Iterator)localObject).next()).a();
    }
    this.w.clear();
    this.t.clear();
    this.w = null;
  }
  
  protected boolean b(View paramView)
  {
    paramView = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    if (paramView.q.isSendFromLocal())
    {
      String str1 = this.o.getString(2131886574);
      String str2 = this.o.getString(2131886575);
      if ((paramView.q.sendFailCode == 41) && (paramView.a != null) && (paramView.a.getEmoticon() != null)) {
        a((MessageForMarketFace)paramView.q, paramView.a);
      } else {
        DialogUtil.a(this.o, 230, str1, str2, new GuildMarketFaceItemBuilder.14(this, paramView), new GuildMarketFaceItemBuilder.15(this)).show();
      }
    }
    else
    {
      paramView = paramView.h.getDrawable();
      if ((paramView instanceof URLDrawable)) {
        ((URLDrawable)paramView).restartDownload();
      }
    }
    return true;
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForMarketFace)))
    {
      if (MessageRecordInfo.b(paramChatMessage.issend)) {
        localStringBuilder.append("发出表情");
      } else {
        localStringBuilder.append("发来表情");
      }
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.mMarkFaceMessage != null)
      {
        paramChatMessage = (IPicEmoticonInfo)((IEmoticonManagerService)this.g.getRuntimeService(IEmoticonManagerService.class)).syncGetEmoticonInfo(paramChatMessage.mMarkFaceMessage);
        if (paramChatMessage != null)
        {
          paramChatMessage = paramChatMessage.getEmoticon();
          if ((paramChatMessage != null) && (paramChatMessage.name != null)) {
            localStringBuilder.append(paramChatMessage.name);
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void g(View paramView)
  {
    AIOUtils.q = true;
    if (paramView.getId() == 2131429435)
    {
      l(paramView);
      return;
    }
    if (paramView.getId() == 2131449970) {
      i(paramView);
    } else if ((paramView.getId() != 2131439264) && (paramView.getId() != 2131439265))
    {
      if ((paramView.getId() != 2131433476) && (paramView.getId() != 2131433475))
      {
        if (paramView.getId() == 2131437876) {
          j(paramView);
        }
      }
      else {
        h(paramView);
      }
    }
    else {
      k(paramView);
    }
    super.onClick(paramView);
  }
  
  protected void h(View paramView)
  {
    paramView = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    QQProgressDialog localQQProgressDialog = c();
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.a(this.o.getString(2131888896));
      localQQProgressDialog.show();
    }
    ((IEmoticonManagerService)this.g.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(paramView.a.getEmoticon().epId, new GuildMarketFaceItemBuilder.13(this, paramView, localQQProgressDialog));
  }
  
  protected void i(View paramView)
  {
    paramView = (GuildMarketFaceItemBuilder.Holder)AIOUtils.b(paramView);
    if ((paramView.a != null) && (paramView.a.isSound()))
    {
      if (c(paramView.q))
      {
        MediaPlayerManager.a(this.g).a(false);
        return;
      }
      if (this.g.isVideoChatting())
      {
        QQToast.makeText(this.g.getApp(), 2131892896, 0).show(this.o.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      MediaPlayerManager.a(this.g).a(paramView.q);
    }
  }
  
  public void onClick(View paramView)
  {
    g(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder
 * JD-Core Version:    0.7.0.1
 */