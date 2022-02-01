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
  private URLDrawableDownListener.Adapter a;
  String ac = "StructMsgItemLayoutNew2";
  String ad = "";
  String ae = "";
  String af = "";
  
  public StructMsgItemLayoutNew2()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new StructMsgItemLayoutNew2.1(this);
  }
  
  public static String a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject2 = "";
    if (paramString.equals("cover"))
    {
      if (TextUtils.isEmpty(paramAbsShareMsg.mContentCover)) {
        break label77;
      }
      localObject1 = paramAbsShareMsg.mContentCover;
    }
    label77:
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (paramString.equals("title"))
          {
            if (!TextUtils.isEmpty(paramAbsShareMsg.mContentTitle)) {
              return paramAbsShareMsg.mContentTitle;
            }
          }
          else if ((paramString.equals("summary")) && (!TextUtils.isEmpty(paramAbsShareMsg.mContentSummary))) {
            return paramAbsShareMsg.mContentSummary;
          }
          localObject1 = localObject2;
        } while (!(paramAbsShareMsg instanceof StructMsgForGeneralShare));
        paramAbsShareMsg = (StructMsgForGeneralShare)paramAbsShareMsg;
        localObject1 = localObject2;
      } while (paramAbsShareMsg.mStructMsgItemLists == null);
      localObject1 = localObject2;
    } while (paramAbsShareMsg.mStructMsgItemLists.isEmpty());
    Iterator localIterator = paramAbsShareMsg.mStructMsgItemLists.iterator();
    paramAbsShareMsg = (AbsShareMsg)localObject2;
    do
    {
      localObject1 = paramAbsShareMsg;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (AbsStructMsgElement)localIterator.next();
    } while ((!(localObject1 instanceof AbsStructMsgItem)) || (((AbsStructMsgItem)localObject1).a == null) || (((AbsStructMsgItem)localObject1).a.isEmpty()));
    Object localObject1 = ((AbsStructMsgItem)localObject1).a.iterator();
    label191:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
      if ((paramString.equals("cover")) && ((localObject2 instanceof StructMsgItemCover)))
      {
        paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((AbsStructMsgElement)localObject2);
        label231:
        if (TextUtils.isEmpty(paramAbsShareMsg)) {
          break label295;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramAbsShareMsg))
      {
        return paramAbsShareMsg;
        if ((paramString.equals("title")) && ((localObject2 instanceof StructMsgItemTitle)))
        {
          paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((AbsStructMsgElement)localObject2);
          break label231;
        }
        if ((!paramString.equals("summary")) || (!(localObject2 instanceof StructMsgItemSummary))) {
          break label301;
        }
        paramAbsShareMsg = StructMsgForGeneralShare.getSummary((AbsStructMsgElement)localObject2);
        break label231;
        label295:
        break label191;
      }
      break;
      label301:
      break label231;
    }
  }
  
  private String a(String paramString, int paramInt)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = "";
    int n = paramString.length();
    int k = 0;
    if ((i < n) && (k < paramInt))
    {
      int j = paramString.codePointAt(i);
      int m;
      if ((j > 65535) || (j == 20))
      {
        m = i;
        j = k;
        if (i + 1 < n)
        {
          str = paramString.substring(i, i + 2);
          if (k < paramInt - 1) {
            localStringBuilder.append(str);
          }
          m = i + 1;
          j = k + 1;
        }
      }
      for (;;)
      {
        i = m + 1;
        k = j;
        break;
        str = paramString.substring(i, i + 1);
        if (k < paramInt - 1) {
          localStringBuilder.append(str);
        }
        j = k + 1;
        m = i;
      }
    }
    if (k == paramInt)
    {
      if (i >= n) {
        break label188;
      }
      localStringBuilder.append(Html.fromHtml("&hellip;"));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label188:
      localStringBuilder.append(str);
    }
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
      if ((localObject instanceof MessageForStructing))
      {
        localObject = (AbsShareMsg)StructMsgFactory.a(((MessageRecord)localObject).msgData);
        this.ae = a((AbsShareMsg)localObject, "title");
        this.ad = a((AbsShareMsg)localObject, "cover");
        this.af = a((AbsShareMsg)localObject, "summary");
      }
    }
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = new StructMsgItemLayoutNew2.newShareHolder(this);
    Resources localResources = paramContext.getResources();
    int i;
    label114:
    int j;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && (paramView.findViewById(2131364200) != null) && ((paramView.getTag() instanceof StructMsgItemLayoutNew2.newShareHolder)))
    {
      paramContext = (StructMsgItemLayoutNew2.newShareHolder)paramView.getTag();
      a();
      boolean bool = paramBundle.getBoolean("isSend", true);
      paramBundle = (BubbleViewLayout)paramView.findViewById(2131364200);
      i = 19;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID != 114) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID != 116)) {
        break label837;
      }
      paramBundle.a(false);
      i = 9;
      paramBundle.a = bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 151) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 156) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgActionData))) {
        break label845;
      }
      j = 1;
      label162:
      if (!bool) {
        break label862;
      }
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(9.0F, localResources), 0, AIOUtils.a(i, localResources), 0);
      paramContext.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setPadding(AIOUtils.a(9.0F, localResources), AIOUtils.a(3.0F, localResources), AIOUtils.a(i, localResources), 0);
      paramBundle = (ViewGroup.MarginLayoutParams)paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (j == 0) {
        break label851;
      }
      paramBundle.setMargins(AIOUtils.a(18.0F, localResources), 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramContext.c.getLayoutParams()).addRule(9);
      paramBundle = (RelativeLayout.LayoutParams)paramContext.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramBundle.addRule(9);
      paramBundle.setMargins(AIOUtils.a(18.0F, localResources), 0, 0, 0);
      paramContext.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(AIOUtils.a(19.5F, localResources), 0, AIOUtils.a(10.0F, localResources), 0);
      label324:
      paramBundle = localResources.getDrawable(2130850894);
      if (TextUtils.isEmpty(this.ad)) {
        break label1118;
      }
    }
    try
    {
      localObject = URLDrawable.getDrawable(new URL(this.ad), AIOUtils.a(249.0F, localResources), AIOUtils.a(139.0F, localResources), paramBundle, paramBundle, true);
      paramContext.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 1)) {
        break label1033;
      }
      paramContext.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramContext.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
      label439:
      paramContext.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        label448:
        label501:
        if (QLog.isColorLevel()) {
          QLog.e(this.ac, 2, "getView, error: " + localMalformedURLException.getMessage());
        }
        label837:
        label845:
        label851:
        label862:
        paramContext.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBundle);
        label1033:
        paramContext.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
    {
      this.ae += "  ";
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setText(Html.fromHtml(this.ae));
      if ((this.af == null) || (TextUtils.isEmpty(this.af.trim())) || (this.af.trim().equals(""))) {
        break label1153;
      }
      paramContext.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
      paramContext.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(this.af);
    }
    for (;;)
    {
      if (j == 0) {
        break label1165;
      }
      i = (int)(BaseChatItemLayout.B * 0.8F) - AIOUtils.a(19.5F, localResources) - AIOUtils.a(10.0F, localResources) - AIOUtils.a(13.0F, localResources);
      paramContext.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i);
      i /= AIOUtils.a(14.0F, localResources);
      localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgActionData;
      paramBundle = (Bundle)localObject;
      if (((String)localObject).length() > i) {
        paramBundle = a((String)localObject, i);
      }
      paramContext.jdField_b_of_type_AndroidWidgetTextView.setText(new QQTextBuilder(paramBundle, 3, 15));
      paramContext.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return paramView;
      paramView = LayoutInflater.from(paramContext).inflate(2131559745, null);
      ((StructMsgItemLayoutNew2.newShareHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131365419));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379432));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378725));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364200));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362355));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365058));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362354));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject).c = ((RelativeLayout)paramView.findViewById(2131364252));
      ((StructMsgItemLayoutNew2.newShareHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364245));
      paramView.setTag(localObject);
      paramContext = (Context)localObject;
      break;
      paramBundle.a(true);
      break label114;
      j = 0;
      break label162;
      paramBundle.setMargins(0, 0, 0, 0);
      break label324;
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(i, localResources), 0, AIOUtils.a(9.0F, localResources), 0);
      paramContext.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setPadding(AIOUtils.a(i, localResources), AIOUtils.a(3.0F, localResources), AIOUtils.a(9.0F, localResources), 0);
      paramBundle = (ViewGroup.MarginLayoutParams)paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (j != 0)
      {
        paramBundle.setMargins(0, 0, AIOUtils.a(18.0F, localResources), 0);
        ((RelativeLayout.LayoutParams)paramContext.c.getLayoutParams()).addRule(11);
        paramBundle = (RelativeLayout.LayoutParams)paramContext.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(11);
        paramBundle.setMargins(0, 0, AIOUtils.a(18.0F, localResources), 0);
        paramContext.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(AIOUtils.a(10.0F, localResources), 0, AIOUtils.a(19.5F, localResources), 0);
        break label324;
      }
      paramBundle.setMargins(0, 0, 0, 0);
      break label324;
      paramContext.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramContext.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      break label439;
      label1118:
      paramContext.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBundle);
      paramContext.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      break label448;
      paramContext.jdField_a_of_type_AndroidWidgetTextView.setText(this.ae);
      break label501;
      label1153:
      paramContext.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
    }
    label1165:
    paramContext.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramContext.c.setOnClickListener(null);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutNew2
 * JD-Core Version:    0.7.0.1
 */