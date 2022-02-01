package com.tencent.mobileqq.troop.troopcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg;
import com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg.EssenceMsgContent;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class TroopEssenceMsgView
  extends LinearLayout
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public TroopEssenceMsgView(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
  }
  
  public TroopEssenceMsgView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
  }
  
  public TroopEssenceMsgView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
  }
  
  private int a(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    paramTroopCardEssenceMsg = paramTroopCardEssenceMsg.msgContent.iterator();
    int i = 0;
    while (paramTroopCardEssenceMsg.hasNext())
    {
      Object localObject = (TroopCardEssenceMsg.EssenceMsgContent)paramTroopCardEssenceMsg.next();
      int j = ((TroopCardEssenceMsg.EssenceMsgContent)localObject).msgType;
      if ((j >= 1) && (j <= 5))
      {
        if ((j == 4) && (QQFileManagerUtil.b(((TroopCardEssenceMsg.EssenceMsgContent)localObject).fileName) != 0) && (QQFileManagerUtil.b(((TroopCardEssenceMsg.EssenceMsgContent)localObject).fileName) != 2)) {
          j = 1048576;
        } else {
          j = 1 << (j - 1) * 4;
        }
        i |= j;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error msgType =");
        ((StringBuilder)localObject).append(j);
        QLog.e("TroopEssenceMsgView", 1, ((StringBuilder)localObject).toString());
      }
    }
    return i;
  }
  
  private Drawable a(String paramString)
  {
    try
    {
      paramString = URLDrawable.getDrawable(paramString);
      String str1 = paramString;
      try
      {
        if (paramString.getStatus() != 2) {
          return ???;
        }
        paramString.restartDownload();
        return paramString;
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramString = null;
    }
    String str2 = paramString;
    return str2;
  }
  
  private void a(int paramInt, List<TroopCardEssenceMsg> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEssenceMsgView", 2, "updateHeadView");
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131561559, null);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839440);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setTag(paramList.get(0));
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378784)).setText(getContext().getString(2131719851));
      addView(this.jdField_a_of_type_AndroidViewView);
    }
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368773)).setText(getContext().getString(2131719850).replace("$COUNT$", String.valueOf(paramInt)));
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
      localObject2 = View.inflate(getContext(), 2131562954, null);
      ((View)localObject2).setBackgroundResource(2130839440);
      localObject3 = (TextView)((View)localObject2).findViewById(2131365169);
      LinearLayout localLinearLayout = (LinearLayout)((View)localObject2).findViewById(2131365284);
      Button localButton = (Button)localLinearLayout.findViewById(2131371480);
      localButton.setTag(paramTroopCardEssenceMsg);
      localButton.setOnClickListener(this);
      ((TextView)localObject3).setText((CharSequence)localObject1);
      if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.waitAppRuntime(null), false, null)) {
        localButton.setBackgroundDrawable(null);
      }
      ((TextView)localObject3).post(new TroopEssenceMsgView.2(this, (TextView)localObject3, localLinearLayout));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, -1, -2);
    }
  }
  
  private void a(TroopCardEssenceMsg paramTroopCardEssenceMsg, boolean paramBoolean)
  {
    int i = a(paramTroopCardEssenceMsg);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setContentView flag=");
      localStringBuilder.append(i);
      QLog.d("TroopEssenceMsgView", 2, localStringBuilder.toString());
    }
    if (i != 1) {
      if (i != 4096)
      {
        if (i != 65536)
        {
          if (i != 1048576)
          {
            if ((i != 16) && (i != 17))
            {
              if (i != 256)
              {
                if ((i != 257) && (i != 272) && (i != 273))
                {
                  paramTroopCardEssenceMsg = new StringBuilder();
                  paramTroopCardEssenceMsg.append("setContentView error flag:");
                  paramTroopCardEssenceMsg.append(i);
                  QLog.e("TroopEssenceMsgView", 1, paramTroopCardEssenceMsg.toString());
                  return;
                }
                b(paramTroopCardEssenceMsg);
                return;
              }
              c(paramTroopCardEssenceMsg);
            }
          }
          else {
            g(paramTroopCardEssenceMsg);
          }
        }
        else {
          f(paramTroopCardEssenceMsg);
        }
      }
      else
      {
        if (paramBoolean)
        {
          d(paramTroopCardEssenceMsg);
          return;
        }
        e(paramTroopCardEssenceMsg);
        return;
      }
    }
    a(paramTroopCardEssenceMsg);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Context localContext = getContext();
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(localContext, "/base/browser");
      Intent localIntent = new Intent();
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localActivityURIRequest.extra().putAll(localIntent.getExtras());
      localActivityURIRequest.setRequestCode(20008);
      if ((localContext instanceof Activity)) {
        QRoute.startUri(localActivityURIRequest, null);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    View localView = View.inflate(getContext(), 2131562953, null);
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject = paramString1;
      if (!paramString1.startsWith("https://"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://");
        ((StringBuilder)localObject).append(paramString1);
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString1 = a((String)localObject);
      if (paramString1 != null) {
        ((URLImageView)localView.findViewById(2131365184)).setImageDrawable(paramString1);
      }
    }
    if (!TextUtils.isEmpty(paramString2)) {
      ((TextView)localView.findViewById(2131365201)).setText(paramString2);
    }
    paramString1 = new LinearLayout.LayoutParams(-2, -2);
    paramString1.leftMargin = Utils.a(16.0F, getResources());
    paramString1.bottomMargin = Utils.a(17.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, paramString1);
  }
  
  private void a(List<TroopCardEssenceMsg> paramList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEssenceMsgView", 2, "updateContentView");
    }
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    int i = 0;
    if (localLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
      addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130839440);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramList.get(0));
    }
    int j = Math.min(1, paramList.size());
    while (i < j)
    {
      a((TroopCardEssenceMsg)paramList.get(i), paramBoolean);
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new TroopEssenceMsgView.1(this, paramBoolean));
  }
  
  private void b(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    Object localObject3 = new StringBuilder();
    Object localObject2 = paramTroopCardEssenceMsg.msgContent.iterator();
    Object localObject1 = null;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (TroopCardEssenceMsg.EssenceMsgContent)((Iterator)localObject2).next();
      if (localObject4 != null)
      {
        if ((((TroopCardEssenceMsg.EssenceMsgContent)localObject4).msgType == 1) && (!TextUtils.isEmpty(((TroopCardEssenceMsg.EssenceMsgContent)localObject4).text))) {
          ((StringBuilder)localObject3).append(((TroopCardEssenceMsg.EssenceMsgContent)localObject4).text);
        }
        if (((TroopCardEssenceMsg.EssenceMsgContent)localObject4).msgType == 2)
        {
          String str = QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(((TroopCardEssenceMsg.EssenceMsgContent)localObject4).faceIndext));
          if (!TextUtils.isEmpty(str)) {
            ((StringBuilder)localObject3).append(str);
          }
        }
        if ((((TroopCardEssenceMsg.EssenceMsgContent)localObject4).msgType == 3) && (!TextUtils.isEmpty(((TroopCardEssenceMsg.EssenceMsgContent)localObject4).imageThumbnailUrl))) {
          localObject1 = ((TroopCardEssenceMsg.EssenceMsgContent)localObject4).imageThumbnailUrl;
        }
      }
    }
    localObject2 = View.inflate(getContext(), 2131562952, null);
    ((View)localObject2).setBackgroundResource(2130839440);
    localObject3 = new QQText((CharSequence)localObject3, 3);
    int i;
    if (((QQText)localObject3).length() > 0)
    {
      localObject4 = (TextView)((View)localObject2).findViewById(2131365201);
      ((TextView)localObject4).setText((CharSequence)localObject3);
      ((TextView)localObject4).setVisibility(0);
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j = i;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = a((String)localObject1);
      localObject3 = (URLImageView)((View)localObject2).findViewById(2131365184);
      ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.MATRIX);
      j = i;
      if (localObject1 != null) {
        try
        {
          ((URLImageView)localObject3).setImageDrawable((Drawable)localObject1);
          j = 1;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          j = i;
        }
      }
    }
    if (j != 0)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131365284);
      localObject3 = (Button)localRelativeLayout.findViewById(2131371480);
      ((Button)localObject3).setOnClickListener(this);
      ((Button)localObject3).setTag(paramTroopCardEssenceMsg);
      if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.waitAppRuntime(null), false, null))
      {
        ((Button)localObject3).setBackgroundDrawable(null);
        localRelativeLayout.setBackgroundResource(2130851092);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, -1, Utils.a(108.0F, getResources()));
      post(new TroopEssenceMsgView.3(this, (View)localObject2, localRelativeLayout));
    }
  }
  
  private void c(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    Object localObject1 = (TroopCardEssenceMsg.EssenceMsgContent)paramTroopCardEssenceMsg.msgContent.get(0);
    if (localObject1 != null) {
      paramTroopCardEssenceMsg = ((TroopCardEssenceMsg.EssenceMsgContent)localObject1).imageUrl;
    } else {
      paramTroopCardEssenceMsg = null;
    }
    if ((!TextUtils.isEmpty(paramTroopCardEssenceMsg)) && (((TroopCardEssenceMsg.EssenceMsgContent)localObject1).msgType == 3))
    {
      Object localObject2 = a(paramTroopCardEssenceMsg);
      if (localObject2 != null)
      {
        paramTroopCardEssenceMsg = new LinearLayout(getContext());
        paramTroopCardEssenceMsg.setOrientation(1);
        paramTroopCardEssenceMsg.setBackgroundResource(2130839440);
        localObject1 = new RoundRectUrlImageView(getContext());
        ((RoundRectUrlImageView)localObject1).setAllRadius(Utils.a(8.0F, getResources()));
        ((RoundRectUrlImageView)localObject1).setAdjustViewBounds(true);
        ((RoundRectUrlImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ((RoundRectUrlImageView)localObject1).setImageDrawable((Drawable)localObject2);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject2).leftMargin = Utils.a(18.0F, getResources());
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = Utils.a(16.0F, getResources());
        paramTroopCardEssenceMsg.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramTroopCardEssenceMsg, -1, Utils.a(124.0F, getResources()));
      }
    }
  }
  
  private void d(TroopCardEssenceMsg paramTroopCardEssenceMsg)
  {
    Object localObject1 = (TroopCardEssenceMsg.EssenceMsgContent)paramTroopCardEssenceMsg.msgContent.get(0);
    if (localObject1 != null) {
      paramTroopCardEssenceMsg = ((TroopCardEssenceMsg.EssenceMsgContent)localObject1).fileThumbnailUrl;
    } else {
      paramTroopCardEssenceMsg = null;
    }
    if ((!TextUtils.isEmpty(paramTroopCardEssenceMsg)) && (((TroopCardEssenceMsg.EssenceMsgContent)localObject1).msgType == 4))
    {
      Object localObject3 = a(paramTroopCardEssenceMsg);
      if (localObject3 != null)
      {
        paramTroopCardEssenceMsg = new LinearLayout(getContext());
        paramTroopCardEssenceMsg.setOrientation(1);
        paramTroopCardEssenceMsg.setBackgroundResource(2130839440);
        Object localObject2 = new RoundRectUrlImageView(getContext());
        ((RoundRectUrlImageView)localObject2).setAllRadius(Utils.a(8.0F, getResources()));
        ((RoundRectUrlImageView)localObject2).setAdjustViewBounds(true);
        ((RoundRectUrlImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((RoundRectUrlImageView)localObject2).setImageDrawable((Drawable)localObject3);
        localObject3 = new LinearLayout.LayoutParams(Utils.a(60.0F, getResources()), Utils.a(108.0F, getResources()));
        ((LinearLayout.LayoutParams)localObject3).leftMargin = Utils.a(18.0F, getResources());
        paramTroopCardEssenceMsg.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        if (QQFileManagerUtil.b(((TroopCardEssenceMsg.EssenceMsgContent)localObject1).fileName) == 2)
        {
          localObject1 = new ImageView(getContext());
          ((ImageView)localObject1).setImageResource(2130839652);
          localObject2 = new LinearLayout.LayoutParams(Utils.a(40.0F, getResources()), Utils.a(40.0F, getResources()));
          ((LinearLayout.LayoutParams)localObject2).leftMargin = (Utils.a(60.0F, getResources()) / 2 - Utils.a(40.0F, getResources()) / 2 + Utils.a(18.0F, getResources()));
          ((LinearLayout.LayoutParams)localObject2).topMargin = (0 - (Utils.a(108.0F, getResources()) / 2 + Utils.a(40.0F, getResources()) / 2));
          paramTroopCardEssenceMsg.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramTroopCardEssenceMsg, -2, Utils.a(124.0F, getResources()));
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
    if ((paramList != null) && (!paramList.isEmpty()) && (paramInt != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateUI totalNum = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", isMember");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", msgs:");
        ((StringBuilder)localObject).append(paramList.toString());
        QLog.d("TroopEssenceMsgView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if ((localObject != null) && (((LinearLayout)localObject).getChildCount() > 1))
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
        if (!TextUtils.isEmpty(((TroopCardEssenceMsg)paramList.get(0)).troopUin))
        {
          localObject = ((TroopCardEssenceMsg)paramList.get(0)).troopUin;
          if (paramBoolean) {
            paramList = "1";
          } else {
            paramList = "2";
          }
          ReportController.b(null, "dc00899", "grpProfile", "", "pin", "exp", 0, 0, (String)localObject, paramList, "", "");
        }
        setVisibility(0);
        return;
      }
      setVisibility(8);
      return;
    }
    setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("TroopEssenceMsgView", 2, "updateUI View is GONE");
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof TroopCardEssenceMsg)) {
      if (paramView.getId() == 2131371480) {
        a(((TroopCardEssenceMsg.EssenceMsgContent)((TroopCardEssenceMsg)localObject).msgContent.get(0)).jumpUrlForMore);
      } else {
        a(((TroopCardEssenceMsg)localObject).jumpUrl);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopEssenceMsgView
 * JD-Core Version:    0.7.0.1
 */