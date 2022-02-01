package com.tencent.mobileqq.graytip;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiMsgUtil;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AioPaiYiPaiHelper;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.loverzone.LoverZoneUtils;
import com.tencent.mobileqq.managers.PushNotificationManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterConstant;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.mobileqq.widget.ClickLinkMovementMethod;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class UniteGrayTipItemBuilder
  extends AbstractChatItemBuilder
{
  private SparseBooleanArray e = new SparseBooleanArray(5);
  private ConcurrentHashMap<Long, Boolean> f = new ConcurrentHashMap(5);
  private HashMap<Long, Boolean> g = new HashMap(10);
  
  public UniteGrayTipItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView)
  {
    if ((paramViewHolder != null) && (paramView != null) && (paramChatMessage == null)) {}
  }
  
  private void a(ChatMessage paramChatMessage, BaseActivity paramBaseActivity)
  {
    if (PaiYiPaiMsgUtil.a(paramChatMessage)) {
      ((AioPaiYiPaiHelper)paramBaseActivity.getChatFragment().k().q(84)).a(paramChatMessage);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    String str = paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_busi_id");
    if (!TextUtils.isEmpty(str))
    {
      c(paramMessageForUniteGrayTip, str);
      b(paramMessageForUniteGrayTip, str);
      a(paramMessageForUniteGrayTip, str);
      a(str, paramMessageForUniteGrayTip);
    }
    b(paramMessageRecord, paramMessageForUniteGrayTip);
  }
  
  private void a(MessageForUniteGrayTip paramMessageForUniteGrayTip, String paramString)
  {
    if ((Long.valueOf(paramString).equals(Long.valueOf(1038L))) && (!paramMessageForUniteGrayTip.troopMemberLevelTipHasReport))
    {
      paramMessageForUniteGrayTip.troopMemberLevelTipHasReport = true;
      paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_templ_id");
      if (!TextUtils.isEmpty(paramMessageForUniteGrayTip))
      {
        if (Long.valueOf(paramMessageForUniteGrayTip).equals(Long.valueOf(1111L)))
        {
          ReportController.b(this.a, "dc00898", "", "", "0X800B1A2", "0X800B1A2", 0, 0, "", "", "", "");
          return;
        }
        if (Long.valueOf(paramMessageForUniteGrayTip).equals(Long.valueOf(1112L))) {
          ReportController.b(this.a, "dc00898", "", "", "0X800B1A4", "0X800AD82", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  private void a(String paramString, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((TroopLuckyCharacterConstant.a.contains(Long.valueOf(paramString))) && (!paramMessageForUniteGrayTip.troopLuckyCharacterTipsHasReport))
    {
      paramMessageForUniteGrayTip.troopLuckyCharacterTipsHasReport = true;
      int i = (int)(Long.valueOf(paramString).longValue() - 1069L);
      ReportController.b(this.a, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_exp", 0, 0, "", "", "", "");
      ReportController.b(this.a, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_exp", i + 1, 0, "", "", "", "");
    }
  }
  
  private void b(MessageRecord paramMessageRecord, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("uint64_busi_type");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id");
    if (!TextUtils.isEmpty(paramMessageRecord))
    {
      if (TextUtils.isEmpty(str)) {
        return;
      }
      long l1 = Long.parseLong(str);
      long l2 = Long.parseLong(paramMessageRecord);
      if ((l1 == 2L) && (l2 == 1024L))
      {
        paramMessageRecord = paramMessageForUniteGrayTip.tipParam.b();
        if (paramMessageRecord != null)
        {
          paramMessageRecord = (GrayTipsMessageConstants.HighlightItem)paramMessageRecord.get(0);
          if (paramMessageRecord != null) {
            paramMessageRecord.actionType = 55;
          }
        }
      }
    }
  }
  
  private void b(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    String str = paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_busi_type");
    if (("1062".equals(paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_busi_id"))) && ("12".equals(str)))
    {
      str = paramMessageForUniteGrayTip.getExtInfoFromExtStr("bytes_content");
      if (!TextUtils.isEmpty(str)) {
        if (str.contains("动作"))
        {
          if (!this.g.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))
          {
            this.g.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
            ReportController.b(null, "dc00898", "", "", "0X800B43D", "0X800B43D", 0, 0, "", "", "", "");
          }
        }
        else if ((str.contains("效果")) && (!this.g.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq))))
        {
          this.g.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
          ReportController.b(null, "dc00898", "", "", "0X800B43F", "0X800B43F", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  private void b(MessageForUniteGrayTip paramMessageForUniteGrayTip, String paramString)
  {
    if ((Long.valueOf(paramString).equals(Long.valueOf(1021L))) && (!paramMessageForUniteGrayTip.dkTipHasReport))
    {
      paramMessageForUniteGrayTip.dkTipHasReport = true;
      ReportController.b(this.a, "dc00898", "", "", "0X800AD82", "0X800AD82", 0, 0, "", "", "", "");
    }
  }
  
  private void c(ChatMessage paramChatMessage)
  {
    int i = 2;
    if (paramChatMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "onDelBtnClick fail cause message is null");
      }
      return;
    }
    Object localObject1;
    if ((this.c instanceof BaseActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "revoke msg click handle del msg");
      }
      localObject1 = ((BaseActivity)this.c).getChatFragment();
      if ((localObject1 == null) || (((ChatFragment)localObject1).k() == null)) {}
    }
    for (;;)
    {
      try
      {
        if (!(paramChatMessage instanceof MessageForUniteGrayTip)) {
          break label558;
        }
        localObject1 = (MessageForUniteGrayTip)paramChatMessage;
        if (((MessageForUniteGrayTip)localObject1).istroop == 0)
        {
          if (((MessageForUniteGrayTip)localObject1).senderuin.equals(this.a.getCurrentAccountUin())) {
            i = 1;
          }
        }
        else if (((MessageForUniteGrayTip)localObject1).istroop == 1)
        {
          boolean bool1 = TroopUtils.a(this.a, paramChatMessage.frienduin, this.a.getCurrentUin());
          boolean bool2 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.a, paramChatMessage.frienduin, this.a.getCurrentUin());
          localObject2 = ((MessageForUniteGrayTip)localObject1).tipParam.g;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(HardCodeUtil.a(2131913135));
          ((StringBuilder)localObject3).append(this.a.getApp().getString(2131895483));
          localObject3 = ((StringBuilder)localObject3).toString();
          if (bool1)
          {
            if (((String)localObject2).startsWith((String)localObject3))
            {
              i = 3;
            }
            else
            {
              if (!((MessageForUniteGrayTip)localObject1).senderuin.equals(this.a.getCurrentAccountUin())) {
                break label540;
              }
              i = 4;
            }
          }
          else if (bool2)
          {
            if (((String)localObject2).startsWith((String)localObject3))
            {
              i = 5;
            }
            else
            {
              if (!((MessageForUniteGrayTip)localObject1).senderuin.equals(this.a.getCurrentAccountUin())) {
                break label540;
              }
              i = 6;
            }
          }
          else
          {
            if (!((MessageForUniteGrayTip)localObject1).senderuin.equals(this.a.getCurrentAccountUin())) {
              break label540;
            }
            i = 7;
          }
        }
        else if (((MessageForUniteGrayTip)localObject1).istroop == 3000)
        {
          if (!((MessageForUniteGrayTip)localObject1).senderuin.equals(this.a.getCurrentAccountUin())) {
            break label546;
          }
          i = 9;
        }
        else
        {
          localObject1 = ((MessageForUniteGrayTip)localObject1).tipParam.g;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131913134));
          ((StringBuilder)localObject2).append(this.a.getApp().getString(2131891963));
          if (((String)localObject1).equals(((StringBuilder)localObject2).toString())) {
            break label552;
          }
          i = 11;
        }
        localObject1 = this.a;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("");
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
      }
      catch (RuntimeException localRuntimeException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 1, "0X800A613", localRuntimeException);
        }
      }
      ChatActivityFacade.a(this.c, this.a, paramChatMessage);
      return;
      label540:
      i = 8;
      continue;
      label546:
      i = 10;
      continue;
      label552:
      i = 12;
      continue;
      label558:
      i = -1;
    }
  }
  
  private void c(MessageForUniteGrayTip paramMessageForUniteGrayTip, String paramString)
  {
    if (("1008".equals(paramString)) && (!paramMessageForUniteGrayTip.docTipHasReport))
    {
      paramMessageForUniteGrayTip.docTipHasReport = true;
      ReportController.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramMessageForUniteGrayTip.istroop, 0, "", "", "", "");
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    boolean bool1 = paramViewHolder instanceof UniteGrayTipItemBuilder.Holder;
    Object localObject2 = "ChatItemBuilder";
    if (!bool1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("diffclashh =");
      ((StringBuilder)localObject1).append(paramViewHolder.getClass());
      QLog.e("ChatItemBuilder", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (UniteGrayTipItemBuilder.Holder)paramViewHolder;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.c).inflate(2131624481, null);
      ((UniteGrayTipItemBuilder.Holder)localObject1).d = ((TextView)paramViewHolder.findViewById(2131434371));
      ((UniteGrayTipItemBuilder.Holder)localObject1).e = ((AutoBgImageView)paramViewHolder.findViewById(2131444751));
      paramView = ((UniteGrayTipItemBuilder.Holder)localObject1).d.getLayoutParams();
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        if (paramView.rightMargin != BaseChatItemLayout.y) {
          paramView.rightMargin = BaseChatItemLayout.y;
        }
      }
    }
    else
    {
      paramViewHolder = paramView;
    }
    ((UniteGrayTipItemBuilder.Holder)localObject1).d.setLineSpacing(0.0F, 1.0F);
    ((UniteGrayTipItemBuilder.Holder)localObject1).d.setIncludeFontPadding(true);
    ((UniteGrayTipItemBuilder.Holder)localObject1).d.setMovementMethod(null);
    ((UniteGrayTipItemBuilder.Holder)localObject1).d.setTextColor(paramViewHolder.getResources().getColorStateList(2131168417));
    ((UniteGrayTipItemBuilder.Holder)localObject1).d.setGravity(19);
    ((UniteGrayTipItemBuilder.Holder)localObject1).d.setBackgroundResource(0);
    bool1 = paramViewHolder instanceof StickerGrayTipLayout;
    Object localObject4;
    label441:
    label508:
    boolean bool2;
    if (bool1)
    {
      StartupTracker.a(null, "AIO_Handle_Sticker_Cost");
      StickerGrayTipLayout localStickerGrayTipLayout = (StickerGrayTipLayout)paramViewHolder;
      localStickerGrayTipLayout.removeAllStickers();
      paramView = EmojiStickerManager.a().c(paramMessageRecord);
      int m = this.c.getResources().getDisplayMetrics().widthPixels;
      if ((paramView != null) && (paramView.size() > 0))
      {
        IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class);
        localObject4 = this.a.getMessageFacade().a(this.d.b, this.d.a, paramView);
        int n = ((List)localObject4).size() - 1;
        j = 0;
        i = 0;
        paramView = (View)localObject2;
        localObject2 = paramViewHolder;
        while (n >= 0)
        {
          Object localObject5 = (MessageRecord)((List)localObject4).get(n);
          int k;
          if (((MessageRecord)localObject5).extraflag == 32768)
          {
            k = j;
          }
          else
          {
            localObject3 = EmojiStickerManager.d((MessageRecord)localObject5);
            k = j;
            if (localObject3 != null)
            {
              k = j;
              if (EmojiStickerManager.h((MessageRecord)localObject5))
              {
                k = j + 1;
                if (k <= QVipStickerProcessor.c) {
                  break label441;
                }
                ((MessageRecord)localObject5).msgtype = -2006;
              }
            }
          }
          j = k;
          break label890;
          if ((localObject5 instanceof MessageForMarketFace))
          {
            paramViewHolder = localIEmoticonManagerService.syncGetEmoticonInfo(((MessageForMarketFace)localObject5).mMarkFaceMessage);
          }
          else
          {
            if ((localObject5 instanceof MessageForText))
            {
              paramViewHolder = (MessageForText)localObject5;
              if (!TextUtils.isEmpty(paramViewHolder.msg))
              {
                paramViewHolder = EmojiStickerManager.a().a(paramViewHolder.msg);
                break label508;
              }
            }
            paramViewHolder = null;
          }
          float f1 = ((StickerInfo)localObject3).x;
          float f2 = m;
          int i2 = (int)(f1 * f2);
          int i1 = (int)(((StickerInfo)localObject3).y * f2);
          int i3 = (int)(((StickerInfo)localObject3).width * f2);
          int i4 = (int)(((StickerInfo)localObject3).height * f2);
          int i5 = ((StickerInfo)localObject3).rotate;
          if (n == ((List)localObject4).size() - 1)
          {
            j = i1;
            if (i1 >= 0) {
              break label636;
            }
            i = -i1;
          }
          else
          {
            j = i + i1;
            if (j >= 0) {
              break label636;
            }
            j = -i1;
            localStickerGrayTipLayout.adjustStickersVerticalPosition(j - i);
            i = j;
          }
          j = 0;
          label636:
          f1 = this.c.getResources().getDisplayMetrics().density;
          localObject3 = "";
          if ((paramViewHolder instanceof IPicEmoticonInfo))
          {
            localObject5 = (IPicEmoticonInfo)paramViewHolder;
            if (((IPicEmoticonInfo)localObject5).getEmoticon() != null)
            {
              if ((!EmojiStickerManager.u) && (FileUtils.getAvailableInnernalMemorySize() > 1.048576E+008F)) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if (i1 != 0) {
                paramViewHolder = ((IPicEmoticonInfo)localObject5).getLoadingDrawable("fromAIO", true, false, null, i3, i3);
              } else {
                paramViewHolder = ((IPicEmoticonInfo)localObject5).getDrawable(this.c, f1);
              }
              localObject3 = ((IPicEmoticonInfo)localObject5).getEmoticon().epId;
            }
            else
            {
              paramViewHolder = null;
            }
          }
          else
          {
            if (!(paramViewHolder instanceof SystemAndEmojiEmoticonInfo)) {
              break label787;
            }
            paramViewHolder = ((SystemAndEmojiEmoticonInfo)paramViewHolder).getBigDrawable(this.c, f1);
          }
          for (;;)
          {
            break;
            label787:
            if ((paramViewHolder instanceof ISmallEmoticonInfo))
            {
              paramViewHolder = ((ISmallEmoticonInfo)paramViewHolder).getBigDrawable(this.c, f1);
            }
            else if ((localObject5 instanceof MessageForPic))
            {
              paramViewHolder = PicItemBuilder.a(this.c, (MessageForPic)localObject5);
              localObject5 = new UniteGrayTipItemBuilder.1(this, (MessageRecord)localObject5);
              ThreadManager.post((Runnable)localObject5, 5, null, true);
            }
            else
            {
              paramViewHolder = null;
            }
          }
          if (paramViewHolder != null) {
            localStickerGrayTipLayout.addSticker(paramViewHolder, i2, j, i3, i4, i5, (String)localObject3);
          }
          j = k;
          label890:
          n -= 1;
        }
        paramViewHolder = paramView;
        localStickerGrayTipLayout.stickerDoubleClickListener = new UniteGrayTipItemBuilder.2(this);
        bool2 = bool1;
        paramView = (View)localObject2;
      }
      else
      {
        localObject2 = "ChatItemBuilder";
        paramView = paramViewHolder;
        paramViewHolder = (AbstractChatItemBuilder.ViewHolder)localObject2;
        bool2 = bool1;
      }
      StartupTracker.a("AIO_Handle_Sticker_Cost", null);
    }
    else
    {
      localObject2 = "ChatItemBuilder";
      paramView = paramViewHolder;
      paramViewHolder = (AbstractChatItemBuilder.ViewHolder)localObject2;
      bool2 = bool1;
    }
    if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
    {
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setText(paramMessageRecord.msg);
      return paramView;
    }
    Object localObject3 = (MessageForUniteGrayTip)paramMessageRecord;
    if (!AIOUtils.i) {
      UniteGrayTipUtil.a((MessageForUniteGrayTip)localObject3, this.a);
    }
    if ((((MessageForUniteGrayTip)localObject3).tipParam != null) && (((MessageForUniteGrayTip)localObject3).tipParam.i == 655381))
    {
      localObject2 = ((MessageForUniteGrayTip)localObject3).tipParam.b();
      localObject2 = (GrayTipsMessageConstants.HighlightItem)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
      if ((localObject2 == null) || (((GrayTipsMessageConstants.HighlightItem)localObject2).actionType != 38)) {}
    }
    try
    {
      i = Integer.parseInt(((GrayTipsMessageConstants.HighlightItem)localObject2).mMsgActionData);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      label1090:
      break label1093;
    }
    try
    {
      j = Integer.parseInt(((GrayTipsMessageConstants.HighlightItem)localObject2).mMsgAActionData);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label1090;
    }
    break label1096;
    label1093:
    int i = 0;
    label1096:
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("NumberFormatException: ");
      ((StringBuilder)localObject4).append(((GrayTipsMessageConstants.HighlightItem)localObject2).mMsgActionData);
      QLog.d(paramViewHolder, 2, ((StringBuilder)localObject4).toString());
    }
    int j = 0;
    if (this.e.get(i, true))
    {
      ReportController.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
      ReportController.b(this.a, "dc00898", "", "", "0X800BB8F", "0X800BB8F", j, 0, "", "", "", "");
      this.e.put(i, false);
    }
    localObject2 = paramViewHolder;
    if ((((MessageForUniteGrayTip)localObject3).tipParam != null) && (((MessageForUniteGrayTip)localObject3).tipParam.i == 655383))
    {
      paramViewHolder = ((MessageForUniteGrayTip)localObject3).tipParam.b();
      if (paramViewHolder == null) {
        if (paramMessageRecord.istroop == 0) {
          i = PushNotificationManager.b;
        } else {
          i = PushNotificationManager.c;
        }
      }
    }
    for (;;)
    {
      break label1379;
      paramViewHolder = (GrayTipsMessageConstants.HighlightItem)paramViewHolder.get(paramViewHolder.size() - 1);
      if ((paramViewHolder == null) || (paramViewHolder.actionType != 38)) {
        break label1376;
      }
      try
      {
        i = Integer.parseInt(paramViewHolder.mMsgActionData);
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        label1331:
        long l1;
        long l2;
        boolean bool3;
        break label1331;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("NumberFormatException: ");
      ((StringBuilder)localObject4).append(paramViewHolder.mMsgActionData);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject4).toString());
    }
    label1376:
    i = 0;
    label1379:
    if (!this.f.containsKey(Long.valueOf(((MessageForUniteGrayTip)localObject3).uniseq)))
    {
      if (QLog.isColorLevel())
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("Temp Report mark: grayTipsOnShow ");
        paramViewHolder.append(((MessageForUniteGrayTip)localObject3).uniseq);
        QLog.d((String)localObject2, 2, paramViewHolder.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
      this.f.put(Long.valueOf(((MessageForUniteGrayTip)localObject3).uniseq), Boolean.valueOf(false));
    }
    if ((((MessageForUniteGrayTip)localObject3).tipParam != null) && (((MessageForUniteGrayTip)localObject3).tipParam.i == 655397))
    {
      UniteGrayTipUtil.a(this.a, (MessageForUniteGrayTip)localObject3);
      paramViewHolder = ((MessageForUniteGrayTip)localObject3).getExtInfoFromExtStr("unite_gray_tips_align");
      if ((!TextUtils.isEmpty(paramViewHolder)) && (paramViewHolder.equals("center"))) {
        ((UniteGrayTipItemBuilder.Holder)localObject1).d.setGravity(17);
      }
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setLineSpacing(8.0F, 1.0F);
      if ((!"null".equals(((ChatBackgroundManager)this.a.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).c(this.d.b))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
      {
        ((UniteGrayTipItemBuilder.Holder)localObject1).d.setTextColor(paramView.getResources().getColorStateList(2131168264));
        ((UniteGrayTipItemBuilder.Holder)localObject1).d.setBackgroundResource(2130853402);
      }
      a(paramMessageRecord, (MessageForUniteGrayTip)localObject3);
    }
    if ((((MessageForUniteGrayTip)localObject3).editState == 1) && ((((MessageForUniteGrayTip)localObject3).tipParam == null) || ((((MessageForUniteGrayTip)localObject3).tipParam != null) && (((MessageForUniteGrayTip)localObject3).tipParam.b() == null))) && (QLog.isColorLevel()))
    {
      localObject4 = ((MessageForUniteGrayTip)localObject3).tipParam;
      if (((MessageForUniteGrayTip)localObject3).tipParam != null) {
        paramViewHolder = ((MessageForUniteGrayTip)localObject3).tipParam.b();
      } else {
        paramViewHolder = null;
      }
      QLog.d((String)localObject2, 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject4, " highlightItems=", paramViewHolder });
    }
    if ((((MessageForUniteGrayTip)localObject3).tipParam != null) && (((MessageForUniteGrayTip)localObject3).tipParam.i == 2)) {
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setGravity(17);
    }
    try
    {
      if ((((MessageForUniteGrayTip)localObject3).tipParam != null) && (((MessageForUniteGrayTip)localObject3).tipParam.i == 1))
      {
        paramViewHolder = this.c.getResources().getDrawable(2130851581);
        ((UniteGrayTipItemBuilder.Holder)localObject1).e.setImageDrawable(paramViewHolder);
        ((UniteGrayTipItemBuilder.Holder)localObject1).e.setContentDescription(this.c.getResources().getString(2131888434));
        ((UniteGrayTipItemBuilder.Holder)localObject1).e.setVisibility(0);
        ((UniteGrayTipItemBuilder.Holder)localObject1).e.setOnClickListener(new UniteGrayTipItemBuilder.3(this, (UniteGrayTipItemBuilder.Holder)localObject1));
        ((UniteGrayTipItemBuilder.Holder)localObject1).d.setMaxWidth(ViewUtils.getScreenWidth() - ViewUtils.dpToPx(31.0F));
        ((ViewGroup.MarginLayoutParams)((UniteGrayTipItemBuilder.Holder)localObject1).d.getLayoutParams()).rightMargin = 0;
      }
      else
      {
        ((UniteGrayTipItemBuilder.Holder)localObject1).e.setVisibility(8);
        paramViewHolder = ((UniteGrayTipItemBuilder.Holder)localObject1).d.getLayoutParams();
        if ((paramViewHolder instanceof ViewGroup.MarginLayoutParams))
        {
          paramViewHolder = (ViewGroup.MarginLayoutParams)paramViewHolder;
          if (paramViewHolder.rightMargin != BaseChatItemLayout.y) {
            paramViewHolder.rightMargin = BaseChatItemLayout.y;
          }
        }
        ((UniteGrayTipItemBuilder.Holder)localObject1).d.setMaxWidth(2147483647);
        ((UniteGrayTipItemBuilder.Holder)localObject1).e.setOnClickListener(null);
      }
    }
    catch (RuntimeException paramViewHolder)
    {
      if (QLog.isColorLevel()) {
        QLog.d((String)localObject2, 2, "deal revoke tips fail", paramViewHolder);
      }
    }
    if ((((MessageForUniteGrayTip)localObject3).tipParam != null) && (((MessageForUniteGrayTip)localObject3).tipParam.b() != null))
    {
      l1 = ((MessageForUniteGrayTip)localObject3).uniseq;
      l2 = ((UniteGrayTipItemBuilder.Holder)localObject1).c;
      if (QLog.isColorLevel()) {
        QLog.d((String)localObject2, 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
      }
      paramViewHolder = ((MessageForUniteGrayTip)localObject3).tipParam.b();
      if ((((MessageForUniteGrayTip)localObject3).tipParam.i != 2097155) && (((MessageForUniteGrayTip)localObject3).tipParam.i != 2097153) && (((MessageForUniteGrayTip)localObject3).tipParam.i != 2097154) && (((MessageForUniteGrayTip)localObject3).tipParam.i != 655397)) {
        bool3 = false;
      }
      do
      {
        bool1 = bool3;
        break;
        if ((!PaiYiPaiMsgUtil.a(localObject3)) && (!TroopLuckyCharacterUtil.a(localObject3))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool3 = bool1;
      } while (this.f.containsKey(Long.valueOf(((MessageForUniteGrayTip)localObject3).uniseq)));
      localObject4 = paramMessageRecord.getExtInfoFromExtStr("friendIconType");
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) && ((((String)localObject4).equals("3")) || (((String)localObject4).equals("6"))))
      {
        if (((String)localObject4).equals("3")) {
          LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "1"));
        } else if (((String)localObject4).equals("6")) {
          LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
        }
        LoverZoneUtils.a("6", "1", "1", LpReportInfo_dc03950.getReportUserType(this.a));
      }
      this.f.put(Long.valueOf(((MessageForUniteGrayTip)localObject3).uniseq), Boolean.valueOf(false));
      paramLinearLayout = ((MessageForUniteGrayTip)localObject3).getHightlightMsgText(this.a, paramLinearLayout.getContext(), bool1, ((UniteGrayTipItemBuilder.Holder)localObject1).d);
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setText(paramLinearLayout);
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setClickable(true);
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setFocusable(true);
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setMovementMethod(ClickLinkMovementMethod.a());
      if (AppSetting.e) {
        ((UniteGrayTipItemBuilder.Holder)localObject1).d.setAccessibilityDelegate(new UniteGrayTipItemBuilder.4(this, l1, l2, paramViewHolder, paramLinearLayout));
      }
    }
    else
    {
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setText(((MessageForUniteGrayTip)localObject3).msg);
      if (AppSetting.e) {
        ((UniteGrayTipItemBuilder.Holder)localObject1).d.setAccessibilityDelegate(null);
      }
    }
    ((UniteGrayTipItemBuilder.Holder)localObject1).d.setOnTouchListener(paramOnLongClickAndTouchListener);
    ((UniteGrayTipItemBuilder.Holder)localObject1).d.setOnLongClickListener(paramOnLongClickAndTouchListener);
    if (!TextUtils.isEmpty(((MessageForUniteGrayTip)localObject3).contentDescription)) {
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setContentDescription(((MessageForUniteGrayTip)localObject3).contentDescription);
    }
    paramLinearLayout = ((UniteGrayTipItemBuilder.Holder)localObject1).d.getLayoutParams();
    if ((localObject3 != null) && (((MessageForUniteGrayTip)localObject3).tipParam != null) && (((MessageForUniteGrayTip)localObject3).tipParam.i == 3276801))
    {
      paramOnLongClickAndTouchListener = this.c.getResources();
      if (Build.VERSION.SDK_INT >= 21) {
        paramViewHolder = paramOnLongClickAndTouchListener.getDrawable(2130852797, this.c.getTheme());
      } else {
        paramViewHolder = paramOnLongClickAndTouchListener.getDrawable(2130852797);
      }
      if (paramViewHolder != null) {
        paramViewHolder.setBounds(0, 0, paramViewHolder.getIntrinsicWidth(), paramViewHolder.getIntrinsicHeight());
      }
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setCompoundDrawables(paramViewHolder, null, null, null);
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setCompoundDrawablePadding(AIOUtils.b(8.0F, paramOnLongClickAndTouchListener));
      if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
      }
      if (bool2) {
        ((StickerGrayTipLayout)paramView).setGravity(16);
      }
      if (QQAudioHelper.b())
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append("TencentDocGrayTips, msg[");
        paramViewHolder.append(((MessageForUniteGrayTip)localObject3).msg);
        paramViewHolder.append("], getText[");
        paramViewHolder.append(((UniteGrayTipItemBuilder.Holder)localObject1).d.getText());
        paramViewHolder.append("], getLayoutParams[");
        paramViewHolder.append(((LinearLayout.LayoutParams)((UniteGrayTipItemBuilder.Holder)localObject1).d.getLayoutParams()).gravity);
        paramViewHolder.append("], gravity[");
        paramViewHolder.append(((LinearLayout.LayoutParams)paramLinearLayout).gravity);
        paramViewHolder.append("]");
        QLog.w((String)localObject2, 1, paramViewHolder.toString());
      }
    }
    else
    {
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setCompoundDrawables(null, null, null, null);
      ((UniteGrayTipItemBuilder.Holder)localObject1).d.setCompoundDrawablePadding(0);
      if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
        ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 17;
      }
      if (bool2) {
        ((StickerGrayTipLayout)paramView).setGravity(17);
      }
    }
    a((MessageForUniteGrayTip)localObject3);
    a((ChatMessage)paramMessageRecord, (AbstractChatItemBuilder.ViewHolder)localObject1, paramView);
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new UniteGrayTipItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131438943) {
      return;
    }
    b(paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    if ((paramInt == 0) && ((paramChatMessage instanceof MessageForUniteGrayTip)))
    {
      MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)paramChatMessage;
      paramView = (UniteGrayTipItemBuilder.Holder)paramView.getTag();
      if (paramView != null)
      {
        paramView.d.setText(paramChatMessage.msg);
        if (!TextUtils.isEmpty(localMessageForUniteGrayTip.contentDescription)) {
          paramView.d.setContentDescription(localMessageForUniteGrayTip.contentDescription);
        }
      }
    }
  }
  
  protected void a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramMessageForUniteGrayTip != null) && (paramMessageForUniteGrayTip.tipParam != null))
    {
      int i = paramMessageForUniteGrayTip.tipParam.i;
      if (i != 3)
      {
        if ((i == 131088) && (!this.g.containsKey(Long.valueOf(paramMessageForUniteGrayTip.msgseq))))
        {
          this.g.put(Long.valueOf(paramMessageForUniteGrayTip.msgseq), Boolean.valueOf(true));
          TroopUtils.a(this.a, paramMessageForUniteGrayTip);
        }
      }
      else if (!this.g.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))
      {
        this.g.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
        CustomizeGrayTipsManager.b(paramMessageForUniteGrayTip.istroop);
      }
      b(paramMessageForUniteGrayTip);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = ((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
    if ((PaiYiPaiMsgUtil.b(paramView)) && (NetConnInfoCenter.getServerTimeMillis() - paramView.time * 1000L < 120000L))
    {
      paramView = new QQCustomMenuItem(2131438943, this.c.getString(2131891960));
      paramView.a(2130839074);
      localQQCustomMenu.a(paramView);
      ReportController.b(this.a, "dc00898", "", "", "0X800BAD3", "0X800BAD3", 0, 0, "", "", "", "");
    }
    return localQQCustomMenu.d();
  }
  
  protected void b(ChatMessage paramChatMessage)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.c;
    if ((paramChatMessage != null) && (localBaseActivity != null) && (localBaseActivity.getChatFragment() != null))
    {
      a(paramChatMessage, localBaseActivity);
      return;
    }
    if (paramChatMessage == null) {
      paramChatMessage = "message is null";
    } else {
      paramChatMessage = "activity error";
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "onClickRevokeMsg error ", paramChatMessage });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder
 * JD-Core Version:    0.7.0.1
 */