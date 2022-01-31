package com.tencent.mobileqq.structmsg.view;

import ahuq;
import ahus;
import ahut;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class StructMsgItemLayout13
  extends AbsStructMsgItem
{
  protected static HashMap a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahus(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  }
  
  private RelativeLayout a(Context paramContext)
  {
    Object localObject2 = paramContext.getResources();
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localRelativeLayout.setMinimumHeight(AIOUtils.a(71.0F, (Resources)localObject2));
    localRelativeLayout.setPadding(AIOUtils.a(15.0F, (Resources)localObject2), AIOUtils.a(1.0F, (Resources)localObject2), AIOUtils.a(15.0F, (Resources)localObject2), 0);
    localRelativeLayout.setId(2131362158);
    ImageView localImageView = new ImageView(paramContext);
    Object localObject1 = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, (Resources)localObject2), AIOUtils.a(40.0F, (Resources)localObject2));
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, AIOUtils.a(15.0F, (Resources)localObject2), 0, AIOUtils.a(15.0F, (Resources)localObject2));
    localImageView.setImageResource(2130841049);
    localImageView.setTag(2131362172, Integer.valueOf(1));
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setId(2131362159);
    localRelativeLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject1).setTextSize(0, AIOUtils.a(16.0F, (Resources)localObject2));
    ((TextView)localObject1).setMaxLines(1);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setPadding(AIOUtils.a(10.0F, (Resources)localObject2), AIOUtils.a(15.0F, (Resources)localObject2), AIOUtils.a(10.0F, (Resources)localObject2), AIOUtils.a(15.0F, (Resources)localObject2));
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131362159);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject3).setMargins(0, 0, AIOUtils.a(55.0F, (Resources)localObject2), 0);
    ((TextView)localObject1).setTag(2131362172, Integer.valueOf(1));
    ((TextView)localObject1).setId(2131362160);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new ImageView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(13.0F, (Resources)localObject2), AIOUtils.a(13.0F, (Resources)localObject2));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15, -1);
    ((ImageView)localObject3).setId(2131362161);
    ((ImageView)localObject3).setTag(2131362172, Integer.valueOf(2));
    localRelativeLayout.addView((View)localObject3, localLayoutParams);
    paramContext = new TextView(paramContext);
    paramContext.setTextColor(Color.parseColor("#777777"));
    paramContext.setTextSize(0, AIOUtils.a(16.0F, (Resources)localObject2));
    paramContext.setPadding(AIOUtils.a(10.0F, (Resources)localObject2), AIOUtils.a(15.0F, (Resources)localObject2), AIOUtils.a(5.0F, (Resources)localObject2), AIOUtils.a(15.0F, (Resources)localObject2));
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131362161);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
    paramContext.setTag(2131362172, Integer.valueOf(2));
    paramContext.setId(2131362162);
    localRelativeLayout.addView(paramContext, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new StructMsgItemLayout13.ViewHolder();
    ((StructMsgItemLayout13.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = localImageView;
    ((StructMsgItemLayout13.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    ((StructMsgItemLayout13.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = paramContext;
    ((StructMsgItemLayout13.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
    localRelativeLayout.setTag(localObject2);
    return localRelativeLayout;
  }
  
  public static URLDrawable a(Context paramContext, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      paramContext = URLDrawable.URLDrawableOptions.obtain();
      paramContext.mRequestWidth = paramInt1;
      paramContext.mRequestHeight = paramInt2;
      paramContext.mLoadingDrawable = paramDrawable;
      paramContext.mFailedDrawable = paramDrawable;
      paramContext = URLDrawable.getDrawable(paramString, paramContext);
      paramContext.setAutoDownload(true);
      if ((paramContext != null) && (paramContext.getStatus() == 2)) {
        paramContext.restartDownload();
      }
      return paramContext;
    }
    return null;
  }
  
  public static final void a()
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  protected String a(String paramString1, String paramString2)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString1 + ": " + paramString2);
    }
    return null;
  }
  
  public void a(Resources paramResources, String paramString, TextView paramTextView)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      TextUtils.ellipsize(paramString, paramTextView.getPaint(), AIOUtils.a(190.0F, paramResources), TextUtils.TruncateAt.END, false, new ahut(this, paramTextView, paramString));
      return;
    }
    paramTextView.setText("");
  }
  
  protected int b()
  {
    return 13;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout13 getView start.");
    }
    paramBundle = ((FragmentActivity)paramContext).getChatFragment();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBundle.a();
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= 2)) {
        break label157;
      }
      if (QLog.isColorLevel()) {
        if ("StructingMsgItemLayout13 getView. mElements:" + this.jdField_a_of_type_JavaUtilArrayList != null) {
          break label127;
        }
      }
    }
    label127:
    for (paramContext = "is null";; paramContext = "size is " + this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      QLog.d(".troop.troop_topic", 2, paramContext);
      paramContext = null;
      return paramContext;
      paramBundle = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramBundle instanceof QQAppInterface)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
      break;
    }
    label157:
    paramBundle = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    Object localObject1 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(1);
    label225:
    Resources localResources;
    StructMsgItemLayout13.ViewHolder localViewHolder;
    String str;
    if (((paramBundle instanceof StructMsgItemTextButton)) && ((localObject1 instanceof StructMsgItemTextButton)))
    {
      paramBundle = (StructMsgItemTextButton)paramBundle;
      localObject1 = (StructMsgItemTextButton)localObject1;
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label579;
      }
      paramView = (RelativeLayout)paramView;
      localResources = paramContext.getResources();
      localViewHolder = (StructMsgItemLayout13.ViewHolder)paramView.getTag();
      Object localObject2 = paramContext.getResources().getDrawable(2130841049);
      localObject2 = a(paramContext, paramBundle.v, AIOUtils.a(40.0F, localResources), AIOUtils.a(40.0F, localResources), (Drawable)localObject2);
      if (localObject2 != null)
      {
        ((URLDrawable)localObject2).setTag(new int[] { AIOUtils.a(40.0F, localResources), AIOUtils.a(40.0F, localResources) });
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      if (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare)) {
        break label588;
      }
      localObject2 = (StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
      str = a(((StructMsgForGeneralShare)localObject2).message.frienduin, ((StructMsgForGeneralShare)localObject2).author);
      if (!TextUtils.isEmpty(str)) {
        break label590;
      }
      ThreadManager.post(new ahuq(this, (StructMsgForGeneralShare)localObject2, localResources, localViewHolder), 8, null, true);
      a(localResources, paramBundle.u, localViewHolder.jdField_a_of_type_AndroidWidgetTextView);
    }
    for (;;)
    {
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((StructMsgItemTextButton)localObject1).u);
      localViewHolder.jdField_a_of_type_JavaLangString = ((StructMsgItemTextButton)localObject1).b;
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTag(2131362173, localViewHolder);
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(2131362173, localViewHolder);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramContext = a(paramContext, ((StructMsgItemTextButton)localObject1).w, AIOUtils.a(13.0F, localResources), AIOUtils.a(13.0F, localResources), null);
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
      paramContext = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout13 getView end.");
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout13 getView. mElements is not StructMsgItemTextButton");
      }
      return null;
      label579:
      paramView = a(paramContext);
      break label225;
      label588:
      return null;
      label590:
      a(localResources, str, localViewHolder.jdField_a_of_type_AndroidWidgetTextView);
    }
  }
  
  public String b()
  {
    return "Layout13";
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.put(paramString2 + ": " + paramString3, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13
 * JD-Core Version:    0.7.0.1
 */