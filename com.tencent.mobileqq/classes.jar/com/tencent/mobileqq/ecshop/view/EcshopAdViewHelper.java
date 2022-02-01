package com.tencent.mobileqq.ecshop.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.feedback.StartGdtFeedbackParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.ad.EcshopAdHandler;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.Foreground;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EcshopAdViewHelper
{
  private int a;
  private int b;
  private PopupWindow c;
  
  private boolean a(String paramString, ViewGroup paramViewGroup, Context paramContext, MessageRecord paramMessageRecord, EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener)
  {
    try
    {
      paramString = new JSONObject(paramString);
    }
    catch (JSONException paramString)
    {
      label12:
      int i;
      break label12;
    }
    paramString = new JSONObject();
    if (!paramString.has("menus")) {
      return false;
    }
    paramString = paramString.optJSONArray("menus");
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      i = 0;
      while (i < paramString.length())
      {
        Object localObject1 = paramString.optJSONObject(i);
        if (localObject1 != null)
        {
          int j = ((JSONObject)localObject1).optInt("action_type");
          Object localObject2 = new LinearLayout(paramContext);
          ((LinearLayout)localObject2).setOnClickListener(new EcshopAdViewHelper.4(this, j, (JSONObject)localObject1, paramMessageRecord, paramContext, paramDeleteMsgListener, (AppInterface)AppUtils.a()));
          paramViewGroup.addView((View)localObject2);
          Object localObject3 = (LinearLayout.LayoutParams)((LinearLayout)localObject2).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject3).width = -1;
          ((LinearLayout.LayoutParams)localObject3).height = DisplayUtil.a(paramContext, 50.0F);
          ((LinearLayout)localObject2).setOrientation(0);
          ((LinearLayout)localObject2).setGravity(16);
          localObject3 = new ImageView(paramContext);
          ((LinearLayout)localObject2).addView((View)localObject3);
          Object localObject4 = (LinearLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject4).width = DisplayUtil.a(paramContext, 20.0F);
          ((LinearLayout.LayoutParams)localObject4).height = DisplayUtil.a(paramContext, 18.0F);
          ((LinearLayout.LayoutParams)localObject4).leftMargin = DisplayUtil.a(paramContext, 15.0F);
          localObject4 = ((JSONObject)localObject1).optString("icon_url", "");
          if (!StringUtil.isEmpty((String)localObject4))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = DisplayUtil.a(paramContext, 20.0F);
            localURLDrawableOptions.mRequestWidth = DisplayUtil.a(paramContext, 18.0F);
            localObject4 = URLDrawable.getDrawable((String)localObject4, localURLDrawableOptions);
            if (localObject4 != null) {
              ((ImageView)localObject3).setImageDrawable((Drawable)localObject4);
            }
          }
          localObject3 = new TextView(paramContext);
          ((LinearLayout)localObject2).addView((View)localObject3);
          localObject2 = (LinearLayout.LayoutParams)((TextView)localObject3).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject2).width = -1;
          ((LinearLayout.LayoutParams)localObject2).height = -2;
          ((LinearLayout.LayoutParams)localObject2).leftMargin = DisplayUtil.a(paramContext, 10.0F);
          ((TextView)localObject3).setText(((JSONObject)localObject1).optString("title"));
          ((TextView)localObject3).setTextColor(Color.parseColor("#000000"));
          ((TextView)localObject3).setTextSize(16.0F);
          if (i < paramString.length() - 1)
          {
            localObject1 = new View(paramContext);
            paramViewGroup.addView((View)localObject1);
            localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject2).width = -2;
            ((LinearLayout.LayoutParams)localObject2).height = DisplayUtil.a(paramContext, 1.0F);
            ((View)localObject1).setBackgroundColor(Color.parseColor("#E0E0E0"));
          }
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public void a(Context paramContext, MessageRecord paramMessageRecord, View paramView, EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131625595, null);
    PopupWindow localPopupWindow = new PopupWindow((View)localObject, -1, -2, true);
    localPopupWindow.setTouchable(true);
    localPopupWindow.setOutsideTouchable(true);
    ((View)localObject).findViewById(2131431713).setOnClickListener(new EcshopAdViewHelper.5(this, localPopupWindow, paramDeleteMsgListener, paramMessageRecord));
    ((View)localObject).findViewById(2131433161).setOnClickListener(new EcshopAdViewHelper.6(this, paramDeleteMsgListener, paramMessageRecord, localPopupWindow));
    paramDeleteMsgListener = ((IEcshopPublicAccountChatPieTempApi)QRoute.api(IEcshopPublicAccountChatPieTempApi.class)).getCurPieAnimator(paramContext);
    if (paramDeleteMsgListener == null) {
      return;
    }
    localObject = new int[2];
    paramDeleteMsgListener.getLocationOnScreen((int[])localObject);
    int i = localObject[1];
    int j = paramDeleteMsgListener.getHeight();
    paramDeleteMsgListener = new int[2];
    paramView.getLocationOnScreen(paramDeleteMsgListener);
    this.a = paramDeleteMsgListener[0];
    this.b = paramDeleteMsgListener[1];
    int k = ViewUtils.dip2px(106.0F);
    int m = paramView.getHeight();
    if (this.b - i + m + k > j)
    {
      localPopupWindow.setBackgroundDrawable(paramContext.getResources().getDrawable(2130848988));
      localPopupWindow.showAtLocation(paramView, 0, this.a, this.b - k);
    }
    else
    {
      localPopupWindow.setBackgroundDrawable(paramContext.getResources().getDrawable(2130848986));
      localPopupWindow.showAtLocation(paramView, 0, this.a, this.b + m);
    }
    ((EcshopAdHandler)((BaseQQAppInterface)AppUtils.a()).getBusinessHandler(EcshopAdHandler.class.getName())).a(9, paramMessageRecord);
    paramMessageRecord = (Activity)paramContext;
    paramView = paramMessageRecord.getWindow().getAttributes();
    paramView.alpha = 0.5F;
    paramMessageRecord.getWindow().setAttributes(paramView);
    localPopupWindow.setOnDismissListener(new EcshopAdViewHelper.7(this, paramContext));
  }
  
  public void a(Context paramContext, MessageRecord paramMessageRecord, View paramView, String paramString, EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener)
  {
    paramContext = new EcshopAdViewHelper.2(this, paramDeleteMsgListener, paramMessageRecord, paramContext, paramView, paramString);
    paramMessageRecord = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getAdInfoByChatMessage(paramMessageRecord);
    paramMessageRecord = StartGdtFeedbackParams.a(new WeakReference(Foreground.getTopActivity()), new WeakReference(paramContext), new GdtAd(paramMessageRecord));
    paramView.setTag(paramContext);
    ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtFeedbackFragment(paramMessageRecord);
  }
  
  public boolean a(Context paramContext, MessageRecord paramMessageRecord, TextView paramTextView, String paramString)
  {
    if (paramTextView == null) {
      return false;
    }
    try
    {
      paramTextView.setBackgroundResource(2130848990);
      paramTextView.setVisibility(0);
      paramTextView.setText(HardCodeUtil.a(2131901720));
      Drawable localDrawable = paramContext.getResources().getDrawable(2130848993);
      localDrawable.setBounds(0, 0, 24, 16);
      paramTextView.setCompoundDrawables(null, null, localDrawable, null);
      int i = DisplayUtil.a(paramContext, 6.0F);
      paramTextView.setPadding(i, 0, i, 0);
      paramTextView.setCompoundDrawablePadding(DisplayUtil.a(paramContext, 2.0F));
      paramTextView.setSingleLine(true);
      paramTextView.setGravity(17);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramTextView.setTextColor(Color.rgb(187, 187, 187));
      paramTextView.setTextSize(2, 12.0F);
      paramTextView.setOnClickListener(new EcshopAdViewHelper.1(this, paramContext, paramMessageRecord, paramTextView, paramString));
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public void b(Context paramContext, MessageRecord paramMessageRecord, View paramView, String paramString, EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2131625596, null);
    if (!a(paramString, (LinearLayout)((View)localObject).findViewById(2131437433), paramContext, paramMessageRecord, paramDeleteMsgListener))
    {
      a(paramContext, paramMessageRecord, paramView, paramDeleteMsgListener);
      return;
    }
    ((View)localObject).measure(0, 0);
    int i = 1;
    this.c = new PopupWindow((View)localObject, -1, -2, true);
    this.c.setTouchable(true);
    this.c.setOutsideTouchable(true);
    paramString = new int[2];
    paramView.getLocationOnScreen(paramString);
    this.a = paramString[0];
    this.b = paramString[1];
    int j = this.c.getContentView().getMeasuredHeight();
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("popheight: ");
      paramString.append(j);
      QLog.i("Ecshop_EcshopAdViewHelper", 2, paramString.toString());
    }
    int k = paramView.getHeight();
    paramString = ((IEcshopPublicAccountChatPieTempApi)QRoute.api(IEcshopPublicAccountChatPieTempApi.class)).getCurPieAnimator();
    if ((paramDeleteMsgListener == null) && (paramString != null))
    {
      localObject = new int[2];
      paramString.getLocationOnScreen((int[])localObject);
      int m = localObject[1];
      int n = paramString.getHeight();
      if (this.b - m + k + j > n) {}
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      this.c.setBackgroundDrawable(paramContext.getResources().getDrawable(2130848988));
      this.c.showAtLocation(paramView, 0, this.a, this.b - j);
    }
    else
    {
      if (paramDeleteMsgListener != null) {
        this.c.setBackgroundDrawable(paramContext.getResources().getDrawable(2130848987));
      } else {
        this.c.setBackgroundDrawable(paramContext.getResources().getDrawable(2130848986));
      }
      this.c.showAtLocation(paramView, 0, this.a, this.b + k);
    }
    ((EcshopAdHandler)((AppInterface)AppUtils.a()).getBusinessHandler(EcshopAdHandler.class.getName())).a(9, paramMessageRecord);
    paramMessageRecord = (Activity)paramContext;
    paramView = paramMessageRecord.getWindow().getAttributes();
    paramView.alpha = 0.5F;
    paramMessageRecord.getWindow().setAttributes(paramView);
    this.c.setOnDismissListener(new EcshopAdViewHelper.3(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper
 * JD-Core Version:    0.7.0.1
 */