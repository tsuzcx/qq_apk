package com.tencent.mobileqq.graytip;

import adxd;
import adxf;
import adxg;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
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
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class UniteGrayTipItemBuilder
  extends AbstractChatItemBuilder
{
  public UniteGrayTipItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    UniteGrayTipItemBuilder.Holder localHolder = (UniteGrayTipItemBuilder.Holder)paramViewHolder;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968789, null);
      localHolder.b = ((TextView)paramViewHolder.findViewById(2131363813));
      paramView = localHolder.b.getLayoutParams();
      localObject = paramViewHolder;
      if ((paramView instanceof ViewGroup.MarginLayoutParams))
      {
        paramView = (ViewGroup.MarginLayoutParams)paramView;
        localObject = paramViewHolder;
        if (paramView.rightMargin != BaseChatItemLayout.w) {
          paramView.rightMargin = BaseChatItemLayout.w;
        }
      }
    }
    for (Object localObject = paramViewHolder;; localObject = paramView)
    {
      localHolder.b.setLineSpacing(0.0F, 1.0F);
      localHolder.b.setIncludeFontPadding(true);
      localHolder.b.setMovementMethod(null);
      localHolder.b.setTextColor(((View)localObject).getResources().getColorStateList(2131492894));
      localHolder.b.setGravity(19);
      StickerGrayTipLayout localStickerGrayTipLayout;
      int i1;
      EmoticonManager localEmoticonManager;
      List localList;
      int i;
      int j;
      int k;
      if ((localObject instanceof StickerGrayTipLayout))
      {
        StartupTracker.a(null, "AIO_Handle_Sticker_Cost");
        localStickerGrayTipLayout = (StickerGrayTipLayout)localObject;
        localStickerGrayTipLayout.a();
        paramViewHolder = EmojiStickerManager.a().a(paramMessageRecord);
        i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        if ((paramViewHolder != null) && (paramViewHolder.size() > 0))
        {
          localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramViewHolder);
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
          if (m > EmojiStickerManager.jdField_f_of_type_Int)
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
              label363:
              int i2 = (int)(localStickerInfo.x * i1);
              i = (int)(localStickerInfo.y * i1);
              int i3 = (int)(localStickerInfo.width * i1);
              int i4 = (int)(localStickerInfo.height * i1);
              int i5 = localStickerInfo.rotate;
              if (k == localList.size() - 1)
              {
                if (i >= 0) {
                  break label1186;
                }
                i = -i;
                j = 0;
              }
              for (;;)
              {
                label445:
                float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
                if ((paramViewHolder instanceof PicEmoticonInfo))
                {
                  paramView = (PicEmoticonInfo)paramViewHolder;
                  if (paramView.a == null) {
                    break label1158;
                  }
                  if ((!EmojiStickerManager.jdField_f_of_type_Boolean) && (FileUtils.a() > 1.048576E+008F))
                  {
                    n = 1;
                    label497:
                    if (n == 0) {
                      break label638;
                    }
                    paramViewHolder = paramView.a("fromAIO", true, false, null, i3, i3);
                    label516:
                    paramView = paramView.a.epId;
                  }
                }
                for (;;)
                {
                  if (paramViewHolder != null) {
                    localStickerGrayTipLayout.a(paramViewHolder, i2, j, i3, i4, i5, paramView);
                  }
                  j = i;
                  i = m;
                  break;
                  if (!(paramView instanceof MessageForText)) {
                    break label1201;
                  }
                  paramViewHolder = (MessageForText)paramView;
                  if (TextUtils.isEmpty(paramViewHolder.msg)) {
                    break label1201;
                  }
                  paramViewHolder = EmojiStickerManager.a().a(paramViewHolder.msg);
                  break label363;
                  n = j + i;
                  if (n >= 0) {
                    break label1167;
                  }
                  n = -i;
                  i = -i;
                  localStickerGrayTipLayout.a(n - j);
                  j = 0;
                  break label445;
                  n = 0;
                  break label497;
                  label638:
                  paramViewHolder = paramView.a(this.jdField_a_of_type_AndroidContentContext, f);
                  break label516;
                  if ((paramViewHolder instanceof SystemAndEmojiEmoticonInfo))
                  {
                    paramViewHolder = ((SystemAndEmojiEmoticonInfo)paramViewHolder).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramViewHolder instanceof SmallEmoticonInfo))
                  {
                    paramViewHolder = ((SmallEmoticonInfo)paramViewHolder).b(this.jdField_a_of_type_AndroidContentContext, f);
                    paramView = "";
                  }
                  else if ((paramView instanceof MessageForPic))
                  {
                    paramViewHolder = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)paramView);
                    ThreadManager.post(new adxd(this, paramView), 5, null, true);
                    paramView = "";
                    continue;
                    ((StickerGrayTipLayout)localObject).a = new adxf(this);
                    StartupTracker.a("AIO_Handle_Sticker_Cost", null);
                    if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {
                      localHolder.b.setText(paramMessageRecord.msg);
                    }
                    label1099:
                    label1147:
                    for (;;)
                    {
                      return localObject;
                      paramViewHolder = (MessageForUniteGrayTip)paramMessageRecord;
                      if (!AIOUtils.h) {
                        UniteGrayTipUtil.a(paramViewHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      if ((((MessageForUniteGrayTip)paramMessageRecord).editState == 1) && ((paramViewHolder.tipParam == null) || ((paramViewHolder.tipParam != null) && (paramViewHolder.tipParam.a == null))) && (QLog.isColorLevel()))
                      {
                        paramView = paramViewHolder.tipParam;
                        if (paramViewHolder.tipParam != null)
                        {
                          paramMessageRecord = paramViewHolder.tipParam.a;
                          QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder edit param error grayMsg.tipParam = ", paramView, " hightLightItems=", paramMessageRecord });
                        }
                      }
                      else
                      {
                        if ((paramViewHolder.tipParam == null) || (paramViewHolder.tipParam.a == null)) {
                          break label1099;
                        }
                        long l1 = paramViewHolder.uniseq;
                        long l2 = localHolder.jdField_a_of_type_Int;
                        if (QLog.isColorLevel()) {
                          QLog.d("ChatItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
                        }
                        paramMessageRecord = paramViewHolder.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext());
                        paramView = paramViewHolder.tipParam.a;
                        localHolder.b.setText(paramMessageRecord);
                        localHolder.b.setClickable(true);
                        localHolder.b.setFocusable(true);
                        localHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
                        if (AppSetting.b) {
                          localHolder.b.setAccessibilityDelegate(new adxg(this, l1, l2, paramView, paramMessageRecord));
                        }
                      }
                      for (;;)
                      {
                        if (TextUtils.isEmpty(paramViewHolder.contentDescription)) {
                          break label1147;
                        }
                        localHolder.b.setContentDescription(paramViewHolder.contentDescription);
                        return localObject;
                        paramMessageRecord = null;
                        break;
                        localHolder.b.setText(paramViewHolder.msg);
                        localHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
                        localHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
                        if (AppSetting.b) {
                          localHolder.b.setAccessibilityDelegate(null);
                        }
                      }
                    }
                  }
                  else
                  {
                    paramView = "";
                    paramViewHolder = null;
                    continue;
                    label1158:
                    paramView = "";
                    paramViewHolder = null;
                  }
                }
                label1167:
                i = n;
                int n = j;
                j = i;
                i = n;
                continue;
                label1186:
                n = j;
                j = i;
                i = n;
              }
              label1201:
              paramViewHolder = null;
            }
          }
        }
      }
    }
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new UniteGrayTipItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
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
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenu().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder
 * JD-Core Version:    0.7.0.1
 */