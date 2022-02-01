package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.api.essence.data.TroopCardEssenceMsg;
import com.tencent.mobileqq.troop.api.essence.data.TroopCardEssenceMsg.EssenceMsgContent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class TroopEssenceMsgView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected final String a;
  
  public TroopEssenceMsgView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "TroopEssenceMsgView";
    setOrientation(1);
  }
  
  public TroopEssenceMsgView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "TroopEssenceMsgView";
    setOrientation(1);
  }
  
  public TroopEssenceMsgView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangString = "TroopEssenceMsgView";
    setOrientation(1);
  }
  
  private int a(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    paramTroopCardEssenceMsg = paramTroopCardEssenceMsg.msgContent.iterator();
    int i = 0;
    if (paramTroopCardEssenceMsg.hasNext())
    {
      TroopCardEssenceMsg.EssenceMsgContent localEssenceMsgContent = (TroopCardEssenceMsg.EssenceMsgContent)paramTroopCardEssenceMsg.next();
      int j = localEssenceMsgContent.msgType;
      if ((j >= 1) && (j <= 5)) {
        if ((j == 4) && (FileManagerUtil.a(localEssenceMsgContent.fileName) != 0) && (FileManagerUtil.a(localEssenceMsgContent.fileName) != 2))
        {
          j = 1048576;
          label79:
          i = j | i;
        }
      }
      for (;;)
      {
        break;
        j = 1 << (j - 1) * 4;
        break label79;
        QLog.e("TroopEssenceMsgView", 1, "error msgType =" + j);
      }
    }
    return i;
  }
  
  private Drawable a(String paramString)
  {
    try
    {
      paramString = URLDrawable.getDrawable(paramString);
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        return paramString;
      }
      catch (Exception localException2)
      {
        break label22;
      }
      localException1 = localException1;
      paramString = null;
    }
    label22:
    return paramString;
  }
  
  private void a(int paramInt, List<TroopCardEssenceMsg> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEssenceMsgView", 2, "updateHeadView");
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131561716, null);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839582);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setTag(paramList.get(0));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379432)).setText(getContext().getString(2131720119));
      addView(this.jdField_a_of_type_AndroidViewView);
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369051)).setText(getContext().getString(2131720118).replace("$COUNT$", String.valueOf(paramInt)));
  }
  
  private void a(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramTroopCardEssenceMsg.msgContent.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TroopCardEssenceMsg.EssenceMsgContent)((Iterator)localObject2).next();
      if (localObject3 != null)
      {
        if ((((TroopCardEssenceMsg.EssenceMsgContent)localObject3).msgType == 1) && (!TextUtils.isEmpty(((TroopCardEssenceMsg.EssenceMsgContent)localObject3).text))) {
          ((StringBuilder)localObject1).append(((TroopCardEssenceMsg.EssenceMsgContent)localObject3).text);
        }
        if (((TroopCardEssenceMsg.EssenceMsgContent)localObject3).msgType == 2)
        {
          localObject3 = QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(((TroopCardEssenceMsg.EssenceMsgContent)localObject3).faceIndext));
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((StringBuilder)localObject1).append((String)localObject3);
          }
        }
      }
    }
    localObject1 = new QQText((CharSequence)localObject1, 3);
    if (((QQText)localObject1).length() > 0)
    {
      localObject2 = View.inflate(getContext(), 2131563131, null);
      ((View)localObject2).setBackgroundResource(2130839582);
      localObject3 = (TextView)((View)localObject2).findViewById(2131365294);
      LinearLayout localLinearLayout = (LinearLayout)((View)localObject2).findViewById(2131365419);
      Button localButton = (Button)localLinearLayout.findViewById(2131371858);
      localButton.setTag(paramTroopCardEssenceMsg);
      localButton.setOnClickListener(this);
      ((TextView)localObject3).setText((CharSequence)localObject1);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        localButton.setBackgroundDrawable(null);
      }
      ((TextView)localObject3).post(new TroopEssenceMsgView.2(this, (TextView)localObject3, localLinearLayout));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, -1, -2);
    }
  }
  
  private void a(TroopCardEssenceMsg paramTroopCardEssenceMsg, boolean paramBoolean)
  {
    int i = a(paramTroopCardEssenceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("TroopEssenceMsgView", 2, "setContentView flag=" + i);
    }
    switch (i)
    {
    default: 
      QLog.e("TroopEssenceMsgView", 1, "setContentView error flag:" + i);
      return;
    case 1: 
    case 16: 
    case 17: 
      a(paramTroopCardEssenceMsg);
      return;
    case 256: 
      c(paramTroopCardEssenceMsg);
      return;
    case 257: 
    case 272: 
    case 273: 
      b(paramTroopCardEssenceMsg);
      return;
    case 4096: 
      if (paramBoolean)
      {
        d(paramTroopCardEssenceMsg);
        return;
      }
      e(paramTroopCardEssenceMsg);
      return;
    case 65536: 
      f(paramTroopCardEssenceMsg);
      return;
    }
    g(paramTroopCardEssenceMsg);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Context localContext = getContext();
      Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      if ((localContext instanceof Activity)) {
        ((Activity)localContext).startActivityForResult(localIntent, 20008);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    View localView = View.inflate(getContext(), 2131563130, null);
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = paramString1;
      if (!paramString1.startsWith("https://")) {
        str = "https://" + paramString1;
      }
      paramString1 = a(str);
      if (paramString1 != null) {
        ((URLImageView)localView.findViewById(2131365309)).setImageDrawable(paramString1);
      }
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((TextView)localView.findViewById(2131365326)).setText(paramString2);
    }
    paramString1 = new LinearLayout.LayoutParams(-2, -2);
    paramString1.leftMargin = AIOUtils.a(16.0F, getResources());
    paramString1.bottomMargin = AIOUtils.a(17.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, paramString1);
  }
  
  private void a(List<TroopCardEssenceMsg> paramList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEssenceMsgView", 2, "updateContentView");
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839582);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramList.get(0));
    }
    int j = Math.min(1, paramList.size());
    int i = 0;
    while (i < j)
    {
      a((TroopCardEssenceMsg)paramList.get(i), paramBoolean);
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new TroopEssenceMsgView.1(this, paramBoolean));
  }
  
  private void b(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    Object localObject2 = new StringBuilder();
    Object localObject3 = paramTroopCardEssenceMsg.msgContent.iterator();
    Object localObject1 = null;
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (TroopCardEssenceMsg.EssenceMsgContent)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        if ((((TroopCardEssenceMsg.EssenceMsgContent)localObject4).msgType == 1) && (!TextUtils.isEmpty(((TroopCardEssenceMsg.EssenceMsgContent)localObject4).text))) {
          ((StringBuilder)localObject2).append(((TroopCardEssenceMsg.EssenceMsgContent)localObject4).text);
        }
        if (((TroopCardEssenceMsg.EssenceMsgContent)localObject4).msgType == 2)
        {
          String str = QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(((TroopCardEssenceMsg.EssenceMsgContent)localObject4).faceIndext));
          if (!TextUtils.isEmpty(str)) {
            ((StringBuilder)localObject2).append(str);
          }
        }
        if ((((TroopCardEssenceMsg.EssenceMsgContent)localObject4).msgType != 3) || (TextUtils.isEmpty(((TroopCardEssenceMsg.EssenceMsgContent)localObject4).imageThumbnailUrl))) {
          break label395;
        }
        localObject1 = ((TroopCardEssenceMsg.EssenceMsgContent)localObject4).imageThumbnailUrl;
      }
    }
    label395:
    for (;;)
    {
      break;
      localObject3 = View.inflate(getContext(), 2131563129, null);
      ((View)localObject3).setBackgroundResource(2130839582);
      localObject2 = new QQText((CharSequence)localObject2, 3);
      if (((QQText)localObject2).length() > 0)
      {
        localObject4 = (TextView)((View)localObject3).findViewById(2131365326);
        ((TextView)localObject4).setText((CharSequence)localObject2);
        ((TextView)localObject4).setVisibility(0);
      }
      int j;
      for (int i = 1;; i = 0)
      {
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = a((String)localObject1);
          localObject2 = (URLImageView)((View)localObject3).findViewById(2131365309);
          ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.MATRIX);
          j = i;
          if (localObject1 == null) {}
        }
        try
        {
          ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
          j = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            j = i;
          }
        }
        if (j != 0)
        {
          localObject1 = (RelativeLayout)((View)localObject3).findViewById(2131365419);
          localObject2 = (Button)((RelativeLayout)localObject1).findViewById(2131371858);
          ((Button)localObject2).setOnClickListener(this);
          ((Button)localObject2).setTag(paramTroopCardEssenceMsg);
          if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
          {
            ((Button)localObject2).setBackgroundDrawable(null);
            ((RelativeLayout)localObject1).setBackgroundResource(2130851176);
          }
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, -1, AIOUtils.a(108.0F, getResources()));
          post(new TroopEssenceMsgView.3(this, (View)localObject3, (RelativeLayout)localObject1));
        }
        return;
      }
    }
  }
  
  private void c(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    RoundRectUrlImageView localRoundRectUrlImageView = null;
    Object localObject = (TroopCardEssenceMsg.EssenceMsgContent)paramTroopCardEssenceMsg.msgContent.get(0);
    paramTroopCardEssenceMsg = localRoundRectUrlImageView;
    if (localObject != null) {
      paramTroopCardEssenceMsg = ((TroopCardEssenceMsg.EssenceMsgContent)localObject).imageUrl;
    }
    if ((!TextUtils.isEmpty(paramTroopCardEssenceMsg)) && (((TroopCardEssenceMsg.EssenceMsgContent)localObject).msgType == 3))
    {
      localObject = a(paramTroopCardEssenceMsg);
      if (localObject != null)
      {
        paramTroopCardEssenceMsg = new LinearLayout(getContext());
        paramTroopCardEssenceMsg.setOrientation(1);
        paramTroopCardEssenceMsg.setBackgroundResource(2130839582);
        localRoundRectUrlImageView = new RoundRectUrlImageView(getContext());
        localRoundRectUrlImageView.setAllRadius(AIOUtils.a(8.0F, getResources()));
        localRoundRectUrlImageView.setAdjustViewBounds(true);
        localRoundRectUrlImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        localRoundRectUrlImageView.setImageDrawable((Drawable)localObject);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(18.0F, getResources());
        ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.a(16.0F, getResources());
        paramTroopCardEssenceMsg.addView(localRoundRectUrlImageView, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramTroopCardEssenceMsg, -1, AIOUtils.a(124.0F, getResources()));
      }
    }
  }
  
  private void d(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    Object localObject1 = null;
    Object localObject2 = (TroopCardEssenceMsg.EssenceMsgContent)paramTroopCardEssenceMsg.msgContent.get(0);
    paramTroopCardEssenceMsg = (TroopCardEssenceMsg)localObject1;
    if (localObject2 != null) {
      paramTroopCardEssenceMsg = ((TroopCardEssenceMsg.EssenceMsgContent)localObject2).fileThumbnailUrl;
    }
    if ((!TextUtils.isEmpty(paramTroopCardEssenceMsg)) && (((TroopCardEssenceMsg.EssenceMsgContent)localObject2).msgType == 4))
    {
      Object localObject3 = a(paramTroopCardEssenceMsg);
      if (localObject3 != null)
      {
        paramTroopCardEssenceMsg = new LinearLayout(getContext());
        paramTroopCardEssenceMsg.setOrientation(1);
        paramTroopCardEssenceMsg.setBackgroundResource(2130839582);
        localObject1 = new RoundRectUrlImageView(getContext());
        ((RoundRectUrlImageView)localObject1).setAllRadius(AIOUtils.a(8.0F, getResources()));
        ((RoundRectUrlImageView)localObject1).setAdjustViewBounds(true);
        ((RoundRectUrlImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((RoundRectUrlImageView)localObject1).setImageDrawable((Drawable)localObject3);
        localObject3 = new LinearLayout.LayoutParams(AIOUtils.a(60.0F, getResources()), AIOUtils.a(108.0F, getResources()));
        ((LinearLayout.LayoutParams)localObject3).leftMargin = AIOUtils.a(18.0F, getResources());
        paramTroopCardEssenceMsg.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        if (FileManagerUtil.a(((TroopCardEssenceMsg.EssenceMsgContent)localObject2).fileName) == 2)
        {
          localObject1 = new ImageView(getContext());
          ((ImageView)localObject1).setImageResource(2130839793);
          localObject2 = new LinearLayout.LayoutParams(AIOUtils.a(40.0F, getResources()), AIOUtils.a(40.0F, getResources()));
          ((LinearLayout.LayoutParams)localObject2).leftMargin = (AIOUtils.a(60.0F, getResources()) / 2 - AIOUtils.a(40.0F, getResources()) / 2 + AIOUtils.a(18.0F, getResources()));
          ((LinearLayout.LayoutParams)localObject2).topMargin = (0 - (AIOUtils.a(108.0F, getResources()) / 2 + AIOUtils.a(40.0F, getResources()) / 2));
          paramTroopCardEssenceMsg.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramTroopCardEssenceMsg, -2, AIOUtils.a(124.0F, getResources()));
      }
    }
  }
  
  private void e(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    Object localObject = (TroopCardEssenceMsg.EssenceMsgContent)paramTroopCardEssenceMsg.msgContent.get(0);
    if (localObject != null)
    {
      paramTroopCardEssenceMsg = ((TroopCardEssenceMsg.EssenceMsgContent)localObject).fileThumbnailUrl;
      localObject = ((TroopCardEssenceMsg.EssenceMsgContent)localObject).fileName;
      if ((!TextUtils.isEmpty(paramTroopCardEssenceMsg)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        a(paramTroopCardEssenceMsg, (String)localObject);
      }
    }
  }
  
  private void f(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    paramTroopCardEssenceMsg = (TroopCardEssenceMsg.EssenceMsgContent)paramTroopCardEssenceMsg.msgContent.get(0);
    if ((paramTroopCardEssenceMsg != null) && (paramTroopCardEssenceMsg.msgType == 5)) {
      a(paramTroopCardEssenceMsg.shareImageUrl, paramTroopCardEssenceMsg.shareTitle);
    }
  }
  
  private void g(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    paramTroopCardEssenceMsg = (TroopCardEssenceMsg.EssenceMsgContent)paramTroopCardEssenceMsg.msgContent.get(0);
    if ((paramTroopCardEssenceMsg != null) && (paramTroopCardEssenceMsg.msgType == 4)) {
      a(paramTroopCardEssenceMsg.fileThumbnailUrl, paramTroopCardEssenceMsg.fileName);
    }
  }
  
  public void a(List<TroopCardEssenceMsg> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramInt == 0))
    {
      setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("TroopEssenceMsgView", 2, "updateUI View is GONE");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopEssenceMsgView", 2, "updateUI totalNum = " + paramInt + ", isMember" + paramBoolean + ", msgs:" + paramList.toString());
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEssenceMsgView", 2, "updateUI removeAllViews");
      }
      removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_a_of_type_AndroidViewView = null;
    }
    a(paramInt, paramList);
    a(paramList, paramBoolean);
    if (getChildCount() > 1)
    {
      String str;
      if (!TextUtils.isEmpty(((TroopCardEssenceMsg)paramList.get(0)).troopUin))
      {
        str = ((TroopCardEssenceMsg)paramList.get(0)).troopUin;
        if (!paramBoolean) {
          break label239;
        }
      }
      label239:
      for (paramList = "1";; paramList = "2")
      {
        ReportController.b(null, "dc00899", "grpProfile", "", "pin", "exp", 0, 0, str, paramList, "", "");
        setVisibility(0);
        return;
      }
    }
    setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof TroopCardEssenceMsg))
    {
      if (paramView.getId() != 2131371858) {
        break label52;
      }
      a(((TroopCardEssenceMsg.EssenceMsgContent)((TroopCardEssenceMsg)localObject).msgContent.get(0)).jumpUrlForMore);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label52:
      a(((TroopCardEssenceMsg)localObject).jumpUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopEssenceMsgView
 * JD-Core Version:    0.7.0.1
 */