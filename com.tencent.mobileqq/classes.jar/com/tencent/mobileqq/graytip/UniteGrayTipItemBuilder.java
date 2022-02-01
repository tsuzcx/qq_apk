package com.tencent.mobileqq.graytip;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiMsgUtil;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForGrayTips.HighlightItem;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.loverzone.LoverZoneUtils;
import com.tencent.mobileqq.managers.PushNotificationManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
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

public class UniteGrayTipItemBuilder
  extends AbstractChatItemBuilder
{
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray(5);
  private HashMap<Long, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private ConcurrentHashMap<Long, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  
  public UniteGrayTipItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public static void a(ChatMessage paramChatMessage, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView)
  {
    if ((paramViewHolder != null) && (paramView != null) && (paramChatMessage == null)) {}
  }
  
  private void a(String paramString, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((TroopLuckyCharacterUtil.a.contains(Long.valueOf(paramString))) && (!paramMessageForUniteGrayTip.troopLuckyCharacterTipsHasReport))
    {
      paramMessageForUniteGrayTip.troopLuckyCharacterTipsHasReport = true;
      int i = (int)(Long.valueOf(paramString).longValue() - 1069L);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_exp", 0, 0, "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "Luckyword_tips_exp", i + 1, 0, "", "", "", "");
    }
  }
  
  private void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "onDelBtnClick fail cause message is null");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity));
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "revoke msg click handle del msg");
      }
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    } while ((localObject == null) || (((ChatFragment)localObject).a() == null));
    for (;;)
    {
      try
      {
        if (!(paramChatMessage instanceof MessageForUniteGrayTip)) {
          continue;
        }
        localObject = (MessageForUniteGrayTip)paramChatMessage;
        if (((MessageForUniteGrayTip)localObject).istroop != 0) {
          continue;
        }
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        i = 1;
      }
      catch (RuntimeException localRuntimeException)
      {
        boolean bool1;
        boolean bool2;
        String str1;
        String str2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ChatItemBuilder", 1, "0X800A613", localRuntimeException);
        continue;
        int i = -1;
        continue;
        continue;
        i = 8;
        continue;
        i = 8;
        continue;
        i = 8;
        continue;
        i = 10;
        continue;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A613", "0X800A613", 0, 0, i + "", "", "", "");
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      i = 2;
      continue;
      if (((MessageForUniteGrayTip)localObject).istroop == 1)
      {
        bool1 = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        bool2 = TroopUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        str1 = ((MessageForUniteGrayTip)localObject).tipParam.c;
        str2 = HardCodeUtil.a(2131715743) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131697704);
        if (bool1)
        {
          if (str1.startsWith(str2))
          {
            i = 3;
            continue;
          }
          if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            continue;
          }
          i = 4;
          continue;
        }
        if (bool2)
        {
          if (str1.startsWith(str2))
          {
            i = 5;
            continue;
          }
          if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            continue;
          }
          i = 6;
          continue;
        }
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        i = 7;
        continue;
      }
      if (((MessageForUniteGrayTip)localObject).istroop == 3000)
      {
        if (!((MessageForUniteGrayTip)localObject).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        i = 9;
      }
      else
      {
        bool1 = ((MessageForUniteGrayTip)localObject).tipParam.c.equals(HardCodeUtil.a(2131715742) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694360));
        if (!bool1) {
          i = 11;
        } else {
          i = 12;
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
      if (!TextUtils.isEmpty(str))
      {
        if (!str.contains("动作")) {
          break label116;
        }
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
          ReportController.b(null, "dc00898", "", "", "0X800B43D", "0X800B43D", 0, 0, "", "", "", "");
        }
      }
    }
    label116:
    while ((!str.contains("效果")) || (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
    ReportController.b(null, "dc00898", "", "", "0X800B43F", "0X800B43F", 0, 0, "", "", "", "");
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (!(paramViewHolder instanceof UniteGrayTipItemBuilder.Holder)) {
      QLog.e("ChatItemBuilder", 1, "diffclashh =" + paramViewHolder.getClass());
    }
    UniteGrayTipItemBuilder.Holder localHolder = (UniteGrayTipItemBuilder.Holder)paramViewHolder;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558963, null);
      localHolder.b = ((TextView)paramViewHolder.findViewById(2131368045));
      localHolder.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramViewHolder.findViewById(2131377027));
      paramView = localHolder.b.getLayoutParams();
      localObject1 = paramViewHolder;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject1 = paramViewHolder;
        if (paramView.rightMargin != BaseChatItemLayout.y) {
          paramView.rightMargin = BaseChatItemLayout.y;
        }
      }
    }
    for (Object localObject1 = paramViewHolder;; localObject1 = paramView)
    {
      localHolder.b.setLineSpacing(0.0F, 1.0F);
      localHolder.b.setIncludeFontPadding(true);
      localHolder.b.setMovementMethod(null);
      localHolder.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167334));
      localHolder.b.setGravity(19);
      localHolder.b.setBackgroundResource(0);
      Object localObject2;
      int i1;
      EmoticonManager localEmoticonManager;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject1 instanceof StickerGrayTipLayout))
      {
        StartupTracker.a(null, "AIO_Handle_Sticker_Cost");
        localObject2 = (StickerGrayTipLayout)localObject1;
        ((StickerGrayTipLayout)localObject2).removeAllStickers();
        paramViewHolder = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramViewHolder != null) && (paramViewHolder.size() > 0))
        {
          localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramViewHolder);
          i = 0;
          j = 0;
          k = localList.size() - 1;
          if (k >= 0)
          {
            paramView = (MessageRecord)localList.get(k);
            if (paramView.extraflag != 32768) {}
          }
        }
      }
      for (;;)
      {
        k -= 1;
        break;
        EmojiStickerManager.StickerInfo localStickerInfo = EmojiStickerManager.a(paramView);
        if ((localStickerInfo != null) && (EmojiStickerManager.c(paramView)))
        {
          int m = i + 1;
          if (m > EmojiStickerManager.f)
          {
            paramView.msgtype = -2006;
            i = m;
          }
          else
          {
            if ((paramView instanceof MessageForMarketFace)) {
              paramViewHolder = localEmoticonManager.a(((MessageForMarketFace)paramView).mMarkFaceMessage);
            }
            for (;;)
            {
              label429:
              int i2 = (int)(localStickerInfo.x * i1);
              i = (int)(localStickerInfo.y * i1);
              int i3 = (int)(localStickerInfo.width * i1);
              int i4 = (int)(localStickerInfo.height * i1);
              int i5 = localStickerInfo.rotate;
              if (k == localList.size() - 1)
              {
                if (i >= 0) {
                  break label2984;
                }
                i = -i;
                j = 0;
              }
              for (;;)
              {
                label511:
                float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
                if ((paramViewHolder instanceof PicEmoticonInfo))
                {
                  paramView = (PicEmoticonInfo)paramViewHolder;
                  if (paramView.emoticon == null) {
                    break label2957;
                  }
                  if ((!EmojiStickerManager.g) && (FileUtils.a() > 1.048576E+008F))
                  {
                    n = 1;
                    label564:
                    if (n == 0) {
                      break label706;
                    }
                    paramViewHolder = paramView.getLoadingDrawable("fromAIO", true, false, null, i3, i3);
                    label584:
                    paramView = paramView.emoticon.epId;
                  }
                }
                for (;;)
                {
                  if (paramViewHolder != null) {
                    ((StickerGrayTipLayout)localObject2).addSticker(paramViewHolder, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label2999;
                  }
                  paramViewHolder = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramViewHolder.msg)) {
                    break label2999;
                  }
                  paramViewHolder = EmojiStickerManager.a().a(paramViewHolder.msg);
                  break label429;
                  n = j + i;
                  if (n >= 0) {
                    break label2965;
                  }
                  n = -i;
                  i = -i;
                  ((StickerGrayTipLayout)localObject2).adjustStickersVerticalPosition(n - j);
                  j = 0;
                  break label511;
                  n = 0;
                  break label564;
                  label706:
                  paramViewHolder = paramView.getDrawable(this.jdField_a_of_type_AndroidContentContext, f);
                  break label584;
                  if ((paramViewHolder instanceof SystemAndEmojiEmoticonInfo))
                  {
                    paramViewHolder = ((SystemAndEmojiEmoticonInfo)paramViewHolder).getBigDrawable(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramViewHolder instanceof SmallEmoticonInfo))
                  {
                    paramViewHolder = ((SmallEmoticonInfo)paramViewHolder).getBigDrawable(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else
                  {
                    if ((paramView instanceof MessageForPic))
                    {
                      paramViewHolder = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                      ThreadManager.post(new UniteGrayTipItemBuilder.1(this, paramView), 5, null, true);
                      paramView = "";
                      continue;
                      ((StickerGrayTipLayout)localObject1).stickerDoubleClickListener = new UniteGrayTipItemBuilder.2(this);
                      StartupTracker.a("AIO_Handle_Sticker_Cost", null);
                      if (!(paramMessageRecord instanceof MessageForUniteGrayTip))
                      {
                        localHolder.b.setText(paramMessageRecord.msg);
                        return localObject1;
                      }
                      paramView = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!AIOUtils.i) {
                        UniteGrayTipUtil.a(paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((paramView.tipParam != null) && (paramView.tipParam.b == 655381))
                      {
                        paramViewHolder = paramView.tipParam.a();
                        paramViewHolder = (MessageForGrayTips.HighlightItem)paramViewHolder.get(paramViewHolder.size() - 1);
                        if ((paramViewHolder != null) && (paramViewHolder.actionType == 38)) {
                          j = 0;
                        }
                      }
                      try
                      {
                        i = Integer.parseInt(paramViewHolder.mMsgActionData);
                        if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i, true))
                        {
                          ReportController.b(null, "dc00898", "", "", "0X8009979", "0X8009979", i, i, "", "", "", "");
                          this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i, false);
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655383))
                        {
                          j = 0;
                          paramViewHolder = paramView.tipParam.a();
                          if (paramViewHolder != null) {
                            break label2574;
                          }
                          if (paramMessageRecord.istroop != 0) {
                            break label2566;
                          }
                          i = PushNotificationManager.b;
                          label1044:
                          if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d("ChatItemBuilder", 2, "Temp Report mark: grayTipsOnShow " + paramView.uniseq);
                            }
                            ReportController.b(null, "dc00898", "", "", "0X8009ACF", "0X8009ACF", i, i, "", "", "", "");
                            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                          }
                        }
                        if ((paramView.tipParam != null) && (paramView.tipParam.b == 655397))
                        {
                          UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
                          paramViewHolder = paramView.getExtInfoFromExtStr("unite_gray_tips_align");
                          if ((!TextUtils.isEmpty(paramViewHolder)) && (paramViewHolder.equals("center"))) {
                            localHolder.b.setGravity(17);
                          }
                          localHolder.b.setLineSpacing(8.0F, 1.0F);
                          if ((!"null".equals(((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || ((!ThemeUtil.isDefaultTheme()) && (!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!ThemeUtil.isNowThemeIsSimple(null, false, null))))
                          {
                            localHolder.b.setTextColor(((View)localObject1).getResources().getColorStateList(2131167235));
                            localHolder.b.setBackgroundResource(2130851240);
                          }
                          paramViewHolder = paramView.getExtInfoFromExtStr("uint64_busi_id");
                          if (("1008".equals(paramViewHolder)) && (!paramView.docTipHasReport))
                          {
                            paramView.docTipHasReport = true;
                            ReportController.b(null, "dc00898", "", "", "0X800A638", "0X800A638", paramView.istroop, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramViewHolder).equals(Long.valueOf(1021L))) && (!paramView.dkTipHasReport))
                          {
                            paramView.dkTipHasReport = true;
                            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD82", "0X800AD82", 0, 0, "", "", "", "");
                          }
                          if ((Long.valueOf(paramViewHolder).equals(Long.valueOf(1038L))) && (!paramView.troopMemberLevelTipHasReport))
                          {
                            paramView.troopMemberLevelTipHasReport = true;
                            localObject2 = paramView.getExtInfoFromExtStr("uint64_templ_id");
                            if (!TextUtils.isEmpty((CharSequence)localObject2))
                            {
                              if (!Long.valueOf((String)localObject2).equals(Long.valueOf(1111L))) {
                                break label2669;
                              }
                              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A2", "0X800B1A2", 0, 0, "", "", "", "");
                            }
                          }
                          label1510:
                          a(paramViewHolder, paramView);
                          l1 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_type"));
                          l2 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id"));
                          if ((l1 == 2L) && (l2 == 1024L))
                          {
                            paramViewHolder = paramView.tipParam.a();
                            if (paramViewHolder != null)
                            {
                              paramViewHolder = (MessageForGrayTips.HighlightItem)paramViewHolder.get(0);
                              if (paramViewHolder != null) {
                                paramViewHolder.actionType = 55;
                              }
                            }
                          }
                        }
                        if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramView.tipParam == null) || ((paramView.tipParam != null) && (paramView.tipParam.a() == null))) && (QLog.isColorLevel()))
                        {
                          localObject2 = paramView.tipParam;
                          if (paramView.tipParam != null)
                          {
                            paramViewHolder = paramView.tipParam.a();
                            label1649:
                            QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", localObject2, " highlightItems=", paramViewHolder });
                          }
                        }
                        else if ((paramView.tipParam != null) && (paramView.tipParam.b == 2))
                        {
                          localHolder.b.setGravity(17);
                        }
                      }
                      catch (NumberFormatException localNumberFormatException1)
                      {
                        try
                        {
                          long l1;
                          long l2;
                          if ((paramView.tipParam != null) && (paramView.tipParam.b == 1))
                          {
                            paramViewHolder = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849976);
                            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setImageDrawable(paramViewHolder);
                            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691555));
                            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(0);
                            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(new UniteGrayTipItemBuilder.3(this, localHolder));
                            localHolder.b.setMaxWidth(ViewUtils.a() - ViewUtils.b(31.0F));
                            ((ViewGroup.MarginLayoutParams)localHolder.b.getLayoutParams()).rightMargin = 0;
                          }
                          for (;;)
                          {
                            for (;;)
                            {
                              if ((paramView.tipParam == null) || (paramView.tipParam.a() == null)) {
                                break label2847;
                              }
                              l1 = paramView.uniseq;
                              l2 = localHolder.jdField_a_of_type_Int;
                              if (QLog.isColorLevel()) {
                                QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                              }
                              paramViewHolder = paramView.tipParam.a();
                              boolean bool2 = false;
                              if ((paramView.tipParam.b == 2097155) || (paramView.tipParam.b == 2097153) || (paramView.tipParam.b == 2097154) || (paramView.tipParam.b == 655397))
                              {
                                boolean bool1 = true;
                                if ((PaiYiPaiMsgUtil.a(paramView)) || (TroopLuckyCharacterUtil.a(paramView))) {
                                  bool1 = false;
                                }
                                bool2 = bool1;
                                if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramView.uniseq)))
                                {
                                  localObject2 = paramMessageRecord.getExtInfoFromExtStr("friendIconType");
                                  if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).equals("3")) || (((String)localObject2).equals("6"))))
                                  {
                                    if (!((String)localObject2).equals("3")) {
                                      break label2814;
                                    }
                                    LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "8", "1"));
                                    LoverZoneUtils.a("6", "1", "1", LpReportInfo_dc03950.getReportUserType(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
                                  }
                                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramView.uniseq), Boolean.valueOf(false));
                                  bool2 = bool1;
                                }
                              }
                              paramLinearLayout = paramView.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), bool2, localHolder.b);
                              localHolder.b.setText(paramLinearLayout);
                              localHolder.b.setClickable(true);
                              localHolder.b.setFocusable(true);
                              localHolder.b.setMovementMethod(ClickLinkMovementMethod.a());
                              if (AppSetting.d) {
                                localHolder.b.setAccessibilityDelegate(new UniteGrayTipItemBuilder.4(this, l1, l2, paramViewHolder, paramLinearLayout));
                              }
                              localHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
                              localHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
                              if (!TextUtils.isEmpty(paramView.contentDescription)) {
                                localHolder.b.setContentDescription(paramView.contentDescription);
                              }
                              paramLinearLayout = localHolder.b.getLayoutParams();
                              if ((paramView == null) || (paramView.tipParam == null) || (paramView.tipParam.b != 3276801)) {
                                break label2889;
                              }
                              paramOnLongClickAndTouchListener = this.jdField_a_of_type_AndroidContentContext.getResources();
                              if (Build.VERSION.SDK_INT < 21) {
                                break label2877;
                              }
                              paramViewHolder = paramOnLongClickAndTouchListener.getDrawable(2130851005, this.jdField_a_of_type_AndroidContentContext.getTheme());
                              if (paramViewHolder != null) {
                                paramViewHolder.setBounds(0, 0, paramViewHolder.getIntrinsicWidth(), paramViewHolder.getIntrinsicHeight());
                              }
                              localHolder.b.setCompoundDrawables(paramViewHolder, null, null, null);
                              localHolder.b.setCompoundDrawablePadding(AIOUtils.a(8.0F, paramOnLongClickAndTouchListener));
                              if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 16;
                              }
                              if ((localObject1 instanceof StickerGrayTipLayout)) {
                                ((StickerGrayTipLayout)localObject1).setGravity(16);
                              }
                              if (AudioHelper.d()) {
                                QLog.w("ChatItemBuilder", 1, "TencentDocGrayTips, msg[" + paramView.msg + "], getText[" + localHolder.b.getText() + "], getLayoutParams[" + ((LinearLayout.LayoutParams)localHolder.b.getLayoutParams()).gravity + "], gravity[" + ((LinearLayout.LayoutParams)paramLinearLayout).gravity + "]");
                              }
                              a(paramView);
                              a((ChatMessage)paramMessageRecord, localHolder, (View)localObject1);
                              return localObject1;
                              localNumberFormatException1 = localNumberFormatException1;
                              i = j;
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramViewHolder.mMsgActionData);
                              i = j;
                              break;
                              label2566:
                              i = PushNotificationManager.c;
                              break label1044;
                              label2574:
                              paramViewHolder = (MessageForGrayTips.HighlightItem)paramViewHolder.get(paramViewHolder.size() - 1);
                              i = j;
                              if (paramViewHolder == null) {
                                break label1044;
                              }
                              i = j;
                              if (paramViewHolder.actionType != 38) {
                                break label1044;
                              }
                              try
                              {
                                i = Integer.parseInt(paramViewHolder.mMsgActionData);
                              }
                              catch (NumberFormatException localNumberFormatException2)
                              {
                                i = j;
                              }
                            }
                            if (!QLog.isColorLevel()) {
                              break label1044;
                            }
                            QLog.d("ChatItemBuilder", 2, "NumberFormatException: " + paramViewHolder.mMsgActionData);
                            i = j;
                            break label1044;
                            label2669:
                            if (!Long.valueOf(localNumberFormatException2).equals(Long.valueOf(1112L))) {
                              break label1510;
                            }
                            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B1A4", "0X800AD82", 0, 0, "", "", "", "");
                            break label1510;
                            paramViewHolder = null;
                            break label1649;
                            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setVisibility(8);
                            paramViewHolder = localHolder.b.getLayoutParams();
                            if ((paramViewHolder instanceof ViewGroup.MarginLayoutParams))
                            {
                              paramViewHolder = (ViewGroup.MarginLayoutParams)paramViewHolder;
                              if (paramViewHolder.rightMargin != BaseChatItemLayout.y) {
                                paramViewHolder.rightMargin = BaseChatItemLayout.y;
                              }
                            }
                            localHolder.b.setMaxWidth(2147483647);
                            localHolder.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(null);
                          }
                        }
                        catch (RuntimeException paramViewHolder)
                        {
                          for (;;)
                          {
                            label2847:
                            label2877:
                            label2889:
                            if (QLog.isColorLevel())
                            {
                              QLog.d("ChatItemBuilder", 2, "deal revoke tips fail", paramViewHolder);
                              continue;
                              label2814:
                              if (localNumberFormatException2.equals("6"))
                              {
                                LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", "7", "1"));
                                continue;
                                localHolder.b.setText(paramView.msg);
                                if (AppSetting.d)
                                {
                                  localHolder.b.setAccessibilityDelegate(null);
                                  continue;
                                  paramViewHolder = paramOnLongClickAndTouchListener.getDrawable(2130851005);
                                  continue;
                                  localHolder.b.setCompoundDrawables(null, null, null, null);
                                  localHolder.b.setCompoundDrawablePadding(0);
                                  if ((paramLinearLayout instanceof LinearLayout.LayoutParams)) {
                                    ((LinearLayout.LayoutParams)paramLinearLayout).gravity = 17;
                                  }
                                  if ((localObject1 instanceof StickerGrayTipLayout)) {
                                    ((StickerGrayTipLayout)localObject1).setGravity(17);
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    paramView = "";
                    paramViewHolder = null;
                    continue;
                    label2957:
                    paramView = "";
                    paramViewHolder = null;
                  }
                }
                label2965:
                i = n;
                int n = j;
                j = i;
                i = n;
                continue;
                label2984:
                n = j;
                j = i;
                i = n;
              }
              label2999:
              paramViewHolder = null;
            }
          }
        }
      }
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new UniteGrayTipItemBuilder.Holder(this);
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
        paramView.b.setText(paramChatMessage.msg);
        if (!TextUtils.isEmpty(localMessageForUniteGrayTip.contentDescription)) {
          paramView.b.setContentDescription(localMessageForUniteGrayTip.contentDescription);
        }
      }
    }
  }
  
  protected void a(MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if ((paramMessageForUniteGrayTip != null) && (paramMessageForUniteGrayTip.tipParam != null)) {
      switch (paramMessageForUniteGrayTip.tipParam.b)
      {
      }
    }
    for (;;)
    {
      b(paramMessageForUniteGrayTip);
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.msgseq)))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.msgseq), Boolean.valueOf(true));
        TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForUniteGrayTip);
        continue;
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq)))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForUniteGrayTip.shmsgseq), Boolean.valueOf(true));
          CustomizeGrayTipsManager.b(paramMessageForUniteGrayTip.istroop);
        }
      }
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder
 * JD-Core Version:    0.7.0.1
 */