package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StructMsgItemLayoutNew2
  extends StructMsgItemLayout2
{
  String aA = "StructMsgItemLayoutNew2";
  String aB = "";
  String aC = "";
  String aD = "";
  private URLDrawableDownListener.Adapter aE = new StructMsgItemLayoutNew2.1(this);
  
  public static String a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (paramString.equals("cover"))
    {
      if (!TextUtils.isEmpty(paramAbsShareMsg.mContentCover)) {
        return paramAbsShareMsg.mContentCover;
      }
    }
    else if (paramString.equals("title"))
    {
      if (!TextUtils.isEmpty(paramAbsShareMsg.mContentTitle)) {
        return paramAbsShareMsg.mContentTitle;
      }
    }
    else if ((paramString.equals("summary")) && (!TextUtils.isEmpty(paramAbsShareMsg.mContentSummary))) {
      return paramAbsShareMsg.mContentSummary;
    }
    boolean bool = paramAbsShareMsg instanceof StructMsgForGeneralShare;
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (bool)
    {
      paramAbsShareMsg = (StructMsgForGeneralShare)paramAbsShareMsg;
      localObject1 = localObject2;
      if (paramAbsShareMsg.mStructMsgItemLists != null)
      {
        localObject1 = localObject2;
        if (!paramAbsShareMsg.mStructMsgItemLists.isEmpty())
        {
          Iterator localIterator1 = paramAbsShareMsg.mStructMsgItemLists.iterator();
          paramAbsShareMsg = (AbsShareMsg)localObject2;
          do
          {
            do
            {
              do
              {
                localObject1 = paramAbsShareMsg;
                if (!localIterator1.hasNext()) {
                  break;
                }
                localObject1 = (AbsStructMsgElement)localIterator1.next();
              } while (!(localObject1 instanceof AbsStructMsgItem));
              localObject1 = (AbsStructMsgItem)localObject1;
            } while ((((AbsStructMsgItem)localObject1).ax == null) || (((AbsStructMsgItem)localObject1).ax.isEmpty()));
            Iterator localIterator2 = ((AbsStructMsgItem)localObject1).ax.iterator();
            localObject2 = paramAbsShareMsg;
            do
            {
              localObject1 = localObject2;
              if (!localIterator2.hasNext()) {
                break;
              }
              localObject1 = (AbsStructMsgElement)localIterator2.next();
              if ((paramString.equals("cover")) && ((localObject1 instanceof StructMsgItemCover)))
              {
                paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((AbsStructMsgElement)localObject1);
              }
              else if ((paramString.equals("title")) && ((localObject1 instanceof StructMsgItemTitle)))
              {
                paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((AbsStructMsgElement)localObject1);
              }
              else
              {
                paramAbsShareMsg = (AbsShareMsg)localObject2;
                if (paramString.equals("summary"))
                {
                  paramAbsShareMsg = (AbsShareMsg)localObject2;
                  if ((localObject1 instanceof StructMsgItemSummary)) {
                    paramAbsShareMsg = StructMsgForGeneralShare.getSummary((AbsStructMsgElement)localObject1);
                  }
                }
              }
              localObject2 = paramAbsShareMsg;
            } while (TextUtils.isEmpty(paramAbsShareMsg));
            localObject1 = paramAbsShareMsg;
            paramAbsShareMsg = (AbsShareMsg)localObject1;
          } while (TextUtils.isEmpty((CharSequence)localObject1));
        }
      }
    }
    return localObject1;
  }
  
  private String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = paramString.length();
    int i = 0;
    String str = "";
    int j;
    for (int k = 0; (i < i1) && (k < paramInt); k = j)
    {
      j = paramString.codePointAt(i);
      int m;
      if ((j <= 65535) && (j != 20))
      {
        str = paramString.substring(i, i + 1);
        if (k < paramInt - 1) {
          localStringBuilder.append(str);
        }
        j = k + 1;
        m = i;
      }
      else
      {
        int n = i + 1;
        m = i;
        j = k;
        if (n < i1)
        {
          str = paramString.substring(i, i + 2);
          if (k < paramInt - 1) {
            localStringBuilder.append(str);
          }
          j = k + 1;
          m = n;
        }
      }
      i = m + 1;
    }
    if (k == paramInt) {
      if (i < i1) {
        localStringBuilder.append(Html.fromHtml("&hellip;"));
      } else {
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = paramView;
    Object localObject2 = new StructMsgItemLayoutNew2.newShareHolder(this);
    Resources localResources = paramContext.getResources();
    if ((localObject1 != null) && ((localObject1 instanceof RelativeLayout)) && (((View)localObject1).findViewById(2131430084) != null) && ((paramView.getTag() instanceof StructMsgItemLayoutNew2.newShareHolder)))
    {
      paramView = (StructMsgItemLayoutNew2.newShareHolder)paramView.getTag();
      paramContext = (Context)localObject1;
    }
    else
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2131625650, null);
      ((StructMsgItemLayoutNew2.newShareHolder)localObject2).a = ((URLImageView)paramContext.findViewById(2131431458));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject2).b = ((TextView)paramContext.findViewById(2131447463));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject2).c = ((SingleLineTextView)paramContext.findViewById(2131446627));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject2).d = ((RelativeLayout)paramContext.findViewById(2131430084));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject2).e = ((RelativeLayout)paramContext.findViewById(2131427915));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject2).f = ((LinearLayout)paramContext.findViewById(2131431066));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject2).g = ((TextView)paramContext.findViewById(2131427914));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject2).h = ((RelativeLayout)paramContext.findViewById(2131430148));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject2).i = ((ImageView)paramContext.findViewById(2131430132));
      paramContext.setTag(localObject2);
      paramView = (View)localObject2;
    }
    f();
    boolean bool = paramBundle.getBoolean("isSend", true);
    paramBundle = (BubbleViewLayout)paramContext.findViewById(2131430084);
    int i = 19;
    if ((this.as.mMsgServiceID != 114) && (this.as.mMsgServiceID != 116))
    {
      paramBundle.a(QQTheme.isNowSimpleUI() ^ true);
    }
    else
    {
      paramBundle.a(false);
      i = 9;
    }
    float f;
    if (QQTheme.isNowSimpleUI()) {
      f = 8.0F;
    } else {
      f = 15.0F;
    }
    paramBundle.setRadius(f);
    paramBundle.a = bool;
    int j;
    if ((this.as.mMsgServiceID != 151) && (this.as.mMsgServiceID != 156) && (!TextUtils.isEmpty(this.as.mMsgActionData))) {
      j = 1;
    } else {
      j = 0;
    }
    if (bool)
    {
      paramBundle = paramView.b;
      int k = AIOUtils.b(9.0F, localResources);
      f = i;
      paramBundle.setPadding(k, 0, AIOUtils.b(f, localResources), 0);
      paramView.c.setPadding(AIOUtils.b(9.0F, localResources), AIOUtils.b(3.0F, localResources), AIOUtils.b(f, localResources), 0);
      paramBundle = (ViewGroup.MarginLayoutParams)paramView.d.getLayoutParams();
      if (j != 0)
      {
        paramBundle.setMargins(AIOUtils.b(18.0F, localResources), 0, 0, 0);
        ((RelativeLayout.LayoutParams)paramView.h.getLayoutParams()).addRule(9);
        paramBundle = (RelativeLayout.LayoutParams)paramView.f.getLayoutParams();
        paramBundle.addRule(9);
        paramBundle.setMargins(AIOUtils.b(18.0F, localResources), 0, 0, 0);
        paramView.f.setPadding(AIOUtils.b(19.5F, localResources), 0, AIOUtils.b(10.0F, localResources), 0);
      }
      else
      {
        paramBundle.setMargins(0, 0, 0, 0);
      }
    }
    else
    {
      paramBundle = paramView.b;
      f = i;
      paramBundle.setPadding(AIOUtils.b(f, localResources), 0, AIOUtils.b(9.0F, localResources), 0);
      paramView.c.setPadding(AIOUtils.b(f, localResources), AIOUtils.b(3.0F, localResources), AIOUtils.b(9.0F, localResources), 0);
      paramBundle = (ViewGroup.MarginLayoutParams)paramView.d.getLayoutParams();
      if (j != 0)
      {
        paramBundle.setMargins(0, 0, AIOUtils.b(18.0F, localResources), 0);
        ((RelativeLayout.LayoutParams)paramView.h.getLayoutParams()).addRule(11);
        paramBundle = (RelativeLayout.LayoutParams)paramView.f.getLayoutParams();
        paramBundle.addRule(11);
        paramBundle.setMargins(0, 0, AIOUtils.b(18.0F, localResources), 0);
        paramView.f.setPadding(AIOUtils.b(10.0F, localResources), 0, AIOUtils.b(19.5F, localResources), 0);
      }
      else
      {
        paramBundle.setMargins(0, 0, 0, 0);
      }
    }
    paramBundle = localResources.getDrawable(2130852666);
    if (!TextUtils.isEmpty(this.aB))
    {
      try
      {
        localObject1 = URLDrawable.getDrawable(new URL(this.aB), AIOUtils.b(249.0F, localResources), AIOUtils.b(139.0F, localResources), paramBundle, paramBundle, true);
        paramView.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 2)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
        {
          paramView.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
          paramView.a.setBackgroundDrawable(null);
        }
        else
        {
          paramView.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          paramView.a.setURLDrawableDownListener(this.aE);
        }
        paramView.a.setImageDrawable((Drawable)localObject1);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = this.aA;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getView, error: ");
          localStringBuilder.append(localMalformedURLException.getMessage());
          QLog.e((String)localObject2, 2, localStringBuilder.toString());
        }
        paramView.a.setImageDrawable(paramBundle);
        paramView.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
    }
    else
    {
      paramView.a.setImageDrawable(paramBundle);
      paramView.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
    {
      paramBundle = new StringBuilder();
      paramBundle.append(this.aC);
      paramBundle.append("  ");
      this.aC = paramBundle.toString();
      paramView.b.setText(Html.fromHtml(this.aC));
    }
    else
    {
      paramView.b.setText(this.aC);
    }
    paramBundle = this.aD;
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.trim())) && (!this.aD.trim().equals("")))
    {
      paramView.c.setVisibility(0);
      paramView.c.setText(this.aD);
    }
    else
    {
      paramView.c.setVisibility(8);
    }
    if (j != 0)
    {
      i = (int)(BaseChatItemLayout.B * 0.8F) - AIOUtils.b(19.5F, localResources) - AIOUtils.b(10.0F, localResources) - AIOUtils.b(13.0F, localResources);
      paramView.g.setMaxWidth(i);
      i /= AIOUtils.b(14.0F, localResources);
      String str = this.as.mMsgActionData;
      paramBundle = str;
      if (str.length() > i) {
        paramBundle = a(str, i);
      }
      paramView.g.setText(new QQTextBuilder(paramBundle, 3, 15));
      paramView.e.setVisibility(0);
      return paramContext;
    }
    paramView.e.setVisibility(8);
    paramView.h.setOnClickListener(null);
    paramView.f.setOnClickListener(null);
    return paramContext;
  }
  
  void f()
  {
    if ((this.as != null) && (this.as.message != null))
    {
      Object localObject = this.as.message;
      if ((localObject instanceof MessageForStructing))
      {
        localObject = (AbsShareMsg)StructMsgFactory.a(((MessageRecord)localObject).msgData);
        this.aC = a((AbsShareMsg)localObject, "title");
        this.aB = a((AbsShareMsg)localObject, "cover");
        this.aD = a((AbsShareMsg)localObject, "summary");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutNew2
 * JD-Core Version:    0.7.0.1
 */