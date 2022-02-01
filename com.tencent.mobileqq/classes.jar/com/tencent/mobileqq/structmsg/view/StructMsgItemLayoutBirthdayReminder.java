package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class StructMsgItemLayoutBirthdayReminder
  extends AbsStructMsgItem
{
  private List<StructMsgItemLayoutBirthdayReminder.BirthdayReminder> aA = new ArrayList();
  private RelativeLayout aB;
  private TextView aC;
  private String aD;
  private String aE;
  private String aF;
  private String az;
  
  public StructMsgItemLayoutBirthdayReminder(String paramString)
  {
    this.az = paramString;
  }
  
  public static Drawable a(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setColor(paramInt1);
    localGradientDrawable.setCornerRadius(ViewUtils.dip2px(paramFloat1));
    localGradientDrawable.setStroke(ViewUtils.dip2px(paramFloat2), paramInt2);
    return localGradientDrawable;
  }
  
  public static Drawable a(String paramString1, String paramString2, float paramFloat)
  {
    try
    {
      paramString1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { Color.parseColor(paramString1), Color.parseColor(paramString2) });
      paramString1.setShape(0);
      paramString1.setCornerRadius(ViewUtils.dip2px(paramFloat));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("QWalletGdtAdApiStructMsgItemLayoutBirthdayReminder", 1, paramString1, new Object[0]);
    }
    return null;
  }
  
  private String a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      if (paramInt2 < 1) {
        return "";
      }
    }
    for (;;)
    {
      int j;
      int k;
      try
      {
        Object localObject = Calendar.getInstance();
        int i = ((Calendar)localObject).get(1);
        j = ((Calendar)localObject).get(2);
        k = ((Calendar)localObject).get(5);
        if ((j != paramInt1) || (k != paramInt2)) {
          break label157;
        }
        paramContext = paramContext.getResources().getString(2131899388);
        continue;
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(i, paramInt1, paramInt2);
        paramInt1 = (int)((localCalendar.getTimeInMillis() - ((Calendar)localObject).getTimeInMillis()) / 86400000L);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(paramContext.getResources().getString(2131899396));
        paramContext = ((StringBuilder)localObject).toString();
        continue;
        paramContext = paramContext.getResources().getString(2131899385);
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      return "";
      label157:
      if (j <= paramInt1) {
        if ((j != paramInt1) || (k <= paramInt2)) {}
      }
    }
  }
  
  private void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    Object localObject = (RecyclerView)paramRelativeLayout.findViewById(2131429534);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(paramContext));
    ((RecyclerView)localObject).setAdapter(new StructMsgItemLayoutBirthdayReminder.RecyclerAdapter(this, paramContext, this.aA));
    ((RecyclerView)localObject).addItemDecoration(new StructMsgItemLayoutBirthdayReminder.1(this, paramContext));
    paramContext = (TextView)paramRelativeLayout.findViewById(2131429536);
    localObject = (TextView)paramRelativeLayout.findViewById(2131429538);
    TextView localTextView = (TextView)paramRelativeLayout.findViewById(2131429537);
    if (!TextUtils.isEmpty(this.aF))
    {
      String[] arrayOfString = this.aF.split("\\|");
      if (!TextUtils.isEmpty(arrayOfString[0]))
      {
        paramContext.setText(arrayOfString[0]);
        paramContext.setVisibility(0);
      }
      if (!TextUtils.isEmpty(arrayOfString[1]))
      {
        ((TextView)localObject).setText(arrayOfString[1]);
        ((TextView)localObject).setVisibility(0);
      }
      if (!TextUtils.isEmpty(arrayOfString[2]))
      {
        localTextView.setText(arrayOfString[2]);
        localTextView.setVisibility(0);
      }
    }
    this.aB = ((RelativeLayout)paramRelativeLayout.findViewById(2131429535));
    this.aC = ((TextView)paramRelativeLayout.findViewById(2131434822));
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("channel", 1000004);
      localJSONObject.put("bus_type", 1);
      localJSONObject.put("recv_type", 1);
      localJSONObject.put("recv_uin", paramString1);
      localJSONObject.put("recv_name", paramString2);
      localJSONObject.put("birthday", paramString3);
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    localIntent.putExtra("come_from", 2);
    localIntent.putExtra("extra_data", localJSONObject.toString());
    localIntent.putExtra("isFromPanel", false);
    localIntent.addFlags(536870912);
    RouteUtils.a(paramContext, localIntent, "/qwallet/redpacket/sendhb");
  }
  
  private void a(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setOutlineProvider(new StructMsgItemLayoutBirthdayReminder.3(this, paramInt));
      paramView.setClipToOutline(true);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 1) {
        return true;
      }
      try
      {
        Calendar localCalendar1 = Calendar.getInstance();
        int i = localCalendar1.get(1);
        Calendar localCalendar2 = Calendar.getInstance();
        localCalendar2.set(i, paramInt1, paramInt2);
        long l = (localCalendar1.getTimeInMillis() - localCalendar2.getTimeInMillis()) / 86400000L;
        if (l > paramInt3) {
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return false;
    }
    return true;
  }
  
  private void b(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    Object localObject = QWalletPicHelper.getNetDrawableForQWallet(this.aD, new ColorDrawable(-1), new ColorDrawable(-1));
    ((ImageView)paramRelativeLayout.findViewById(2131429533)).setImageDrawable((Drawable)localObject);
    this.aB.setOnClickListener(new StructMsgItemLayoutBirthdayReminder.2(this, paramContext));
    paramRelativeLayout = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    int i = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getInt(paramRelativeLayout, 0);
    if (i > 0)
    {
      paramRelativeLayout = this.aC;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(paramContext.getString(2131899393));
      paramRelativeLayout.setText(((StringBuilder)localObject).toString());
      return;
    }
    this.aC.setText(paramContext.getString(2131899390));
  }
  
  private String d(String paramString)
  {
    try
    {
      paramString = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getString(paramString, "birthdayHB_skinList_", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONArray(paramString);
        if (paramString.length() > 0)
        {
          paramString = paramString.optJSONObject(0).optString("preArcColor");
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(this.az)) {
          return;
        }
        Object localObject1 = new JSONObject(this.az);
        this.aD = ((JSONObject)localObject1).optString("bgImg");
        this.aE = ((JSONObject)localObject1).optString("tailJumpURL");
        this.aF = ((JSONObject)localObject1).optString("title");
        JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("birthList");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            Object localObject2 = localJSONArray.optJSONObject(i);
            if (localObject2 == null) {
              break label337;
            }
            localObject1 = ((JSONObject)localObject2).optString("uin");
            String str1 = ((JSONObject)localObject2).optString("nick");
            String str2 = ((JSONObject)localObject2).optString("thisBirthday");
            String str3 = ((JSONObject)localObject2).optString("interactiveName");
            String str4 = ((JSONObject)localObject2).optString("beginColor");
            String str5 = ((JSONObject)localObject2).optString("endColor");
            String str6 = ((JSONObject)localObject2).optString("actionBgBeginColor");
            localObject2 = ((JSONObject)localObject2).optString("actionBgEndColor");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label337;
            }
            boolean bool = TextUtils.isEmpty(str2);
            if (bool) {
              break label337;
            }
            try
            {
              Date localDate = new SimpleDateFormat("yyyy-MM-dd").parse(str2);
              Calendar localCalendar = Calendar.getInstance();
              localCalendar.setTime(localDate);
              int j = localCalendar.get(2);
              int k = localCalendar.get(5);
              try
              {
                localObject1 = new StructMsgItemLayoutBirthdayReminder.BirthdayReminder(this, (String)localObject1, str1, str2, j, k, str3, str4, str5, str6, (String)localObject2);
                this.aA.add(localObject1);
              }
              catch (Exception localException1) {}
              localException2.printStackTrace();
            }
            catch (Exception localException2) {}
            break label337;
          }
        }
        if (this.aA.isEmpty())
        {
          paramRelativeLayout.setVisibility(8);
          return;
        }
      }
      catch (Exception paramRelativeLayout)
      {
        QLog.e("QWalletGdtAdApiStructMsgItemLayoutBirthdayReminder", 1, paramRelativeLayout, new Object[0]);
      }
      return;
      label337:
      i += 1;
    }
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramContext == null) {
      return null;
    }
    if ((paramView instanceof RelativeLayout)) {
      paramView = (RelativeLayout)paramView;
    } else {
      paramView = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131628373, null);
    }
    a(paramView);
    a(paramContext, paramView);
    b(paramContext, paramView);
    a(paramView, 8);
    return paramView;
  }
  
  protected int c()
  {
    return 102666;
  }
  
  public String e()
  {
    return "StructMsgItemLayoutBirthdayReminder";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutBirthdayReminder
 * JD-Core Version:    0.7.0.1
 */