package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForwardPreviewMixedMsgController
  extends ForwardPreviewBaseController
{
  protected LinearLayout e;
  protected QQAppInterface f;
  private int g;
  
  public ForwardPreviewMixedMsgController(QQCustomDialog paramQQCustomDialog, QQAppInterface paramQQAppInterface)
  {
    super(paramQQCustomDialog);
    this.f = paramQQAppInterface;
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramChatMessage = (MessageForMixedMsg)paramChatMessage;
      if (paramChatMessage.msgElemList != null)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" initMixMsgLayout size:");
          ((StringBuilder)localObject1).append(paramChatMessage.msgElemList.size());
          QLog.d("ForwardPreviewMixedMsgController", 2, ((StringBuilder)localObject1).toString());
        }
        int i = ViewUtils.dip2px(4.0F);
        paramChatMessage = new ArrayList(paramChatMessage.msgElemList).iterator();
        while (paramChatMessage.hasNext())
        {
          Object localObject2 = (MessageRecord)paramChatMessage.next();
          if ((localObject2 instanceof MessageForText))
          {
            localObject1 = new AnimationTextView(this.b);
            ((AnimationTextView)localObject1).setTextSize(17.0F);
            ((AnimationTextView)localObject1).setTextColor(this.b.getResources().getColor(2131166115));
            ((AnimationTextView)localObject1).setSpannableFactory(QQText.SPANNABLE_FACTORY);
            localObject2 = (MessageForText)localObject2;
            if (!TextUtils.isEmpty(((MessageForText)localObject2).sb2)) {
              ((AnimationTextView)localObject1).setText(new QQText(((MessageForText)localObject2).sb2.toString(), 5, 20));
            } else if (!TextUtils.isEmpty(((MessageForText)localObject2).sb)) {
              ((AnimationTextView)localObject1).setText(new QQText(((MessageForText)localObject2).sb.toString(), 5, 20));
            } else if (!TextUtils.isEmpty(((MessageForText)localObject2).msg)) {
              ((AnimationTextView)localObject1).setText(new QQText(((MessageForText)localObject2).msg, 5, 20));
            }
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).gravity = 3;
            ((LinearLayout.LayoutParams)localObject2).setMargins(0, i, 0, i);
            this.e.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
          else if ((localObject2 instanceof MessageForPic))
          {
            Object localObject3 = (MessageForPic)localObject2;
            localObject1 = new ImageView(this.b);
            localObject2 = PicItemBuilder.a(this.b, (MessageForPic)localObject3);
            ((ImageView)localObject1).setMaxWidth(CommonImgThumbHelper.getImgThumbMaxPx(((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject3)));
            ((ImageView)localObject1).setMaxHeight(CommonImgThumbHelper.getImgThumbMaxPx(((IPicHelper)QRoute.api(IPicHelper.class)).isEmotion((MessageForPic)localObject3)));
            if (localObject2 != null)
            {
              if (((((URLDrawable)localObject2).getCurrDrawable() instanceof RoundRectDrawable)) && (i()))
              {
                localObject3 = (RoundRectDrawable)((URLDrawable)localObject2).getCurrDrawable();
                ((ImageView)localObject1).setImageDrawable(new EmptyDrawable(0, ((RoundRectDrawable)localObject3).getIntrinsicWidth(), ((RoundRectDrawable)localObject3).getIntrinsicHeight()));
                ((ImageView)localObject1).postDelayed(new ForwardPreviewMixedMsgController.1(this, (ImageView)localObject1, (URLDrawable)localObject2), 300L);
              }
              else
              {
                ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
              }
              ((ImageView)localObject1).setAdjustViewBounds(true);
              localObject2 = new LinearLayout.LayoutParams(-2, -2);
              ((LinearLayout.LayoutParams)localObject2).gravity = 3;
              ((LinearLayout.LayoutParams)localObject2).setMargins(0, i, 0, i);
              this.e.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            }
          }
          else if ((localObject2 instanceof MessageForReplyText))
          {
            localObject2 = (MessageForReplyText)localObject2;
            localObject1 = new AnimationTextView(this.b);
            ((AnimationTextView)localObject1).setTextSize(17.0F);
            ((AnimationTextView)localObject1).setTextColor(this.b.getResources().getColor(2131166115));
            ((AnimationTextView)localObject1).setSpannableFactory(QQText.SPANNABLE_FACTORY);
            if (!TextUtils.isEmpty(((MessageForReplyText)localObject2).sb))
            {
              ((AnimationTextView)localObject1).setText(new QQText(((MessageForReplyText)localObject2).sb.toString(), 5, 20));
              ((AnimationTextView)localObject1).setVisibility(0);
            }
            else
            {
              ((AnimationTextView)localObject1).setVisibility(8);
            }
            localObject2 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject2).gravity = 3;
            ((LinearLayout.LayoutParams)localObject2).setMargins(0, i, 0, i);
            this.e.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
          }
        }
      }
      this.e.getViewTreeObserver().addOnGlobalLayoutListener(new ForwardPreviewMixedMsgController.2(this));
    }
  }
  
  private boolean i()
  {
    String str = Build.MODEL;
    if ((!str.equals("vivo X20A")) && (!str.equals("vivo X20")) && (!str.equals("vivo X20Plus A")) && (!str.equals("vivo X20Plus"))) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardPreviewMixedMsgController", 2, "isVivoBlackModel  ");
    }
    return true;
  }
  
  private void j()
  {
    if (this.e.getHeight() >= ViewUtils.dip2px(this.g + 1))
    {
      this.c.setMaxHeight(ViewUtils.dip2px(450.0F));
      this.c.requestLayout();
      if (QLog.isColorLevel()) {
        QLog.d("ForwardPreviewMixedMsgController", 2, " reset height ");
      }
    }
  }
  
  public void a(String paramString, MessageForMixedMsg paramMessageForMixedMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardPreviewMixedMsgController", 2, " bindData ");
    }
    if (paramString != null) {
      a(paramString);
    }
    if ((paramMessageForMixedMsg != null) && (this.e != null)) {
      a(paramMessageForMixedMsg);
    }
  }
  
  protected View c()
  {
    ScrollView localScrollView = new ScrollView(this.b);
    localScrollView.setOverScrollMode(2);
    localScrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.e = new LinearLayout(this.b);
    int i = ViewUtils.dip2px(15.0F);
    int j = ViewUtils.dip2px(8.0F);
    this.e.setPadding(i, j, i, j);
    this.e.setOrientation(1);
    localScrollView.addView(this.e, new ViewGroup.LayoutParams(-1, -2));
    return localScrollView;
  }
  
  protected int d()
  {
    if (this.g == 0) {
      this.g = ((int)((this.d.getRootViewHeight() - this.b.getResources().getDimensionPixelSize(2131297496)) / ViewUtils.mDensity));
    }
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewMixedMsgController
 * JD-Core Version:    0.7.0.1
 */