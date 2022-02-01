package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class StructMsgItemLayout12
  extends AbsStructMsgItem
{
  public GradientDrawable aA = null;
  public boolean aB = false;
  View.OnClickListener aC = new StructMsgItemLayout12.1(this);
  public boolean aD = false;
  public boolean aE = false;
  private String aF;
  public Bundle az = new Bundle();
  
  private FrameLayout a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, AIOUtils.b(105.0F, paramContext.getResources())));
    localFrameLayout.setId(2131439157);
    if (AppSetting.e) {
      localFrameLayout.setContentDescription(this.aF);
    }
    return localFrameLayout;
  }
  
  public static String a(AbsStructMsg paramAbsStructMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramAbsStructMsg instanceof AbsShareMsg))
    {
      paramAbsStructMsg = (AbsShareMsg)paramAbsStructMsg;
      if ((paramAbsStructMsg.getItemCount() > 0) && ((paramAbsStructMsg.getItemByIndex(0) instanceof StructMsgItemLayout12)))
      {
        paramAbsStructMsg = (StructMsgItemLayout12)paramAbsStructMsg.getItemByIndex(0);
        boolean bool = paramAbsStructMsg.az.getBoolean("isSend", false);
        localStringBuilder.append("isSend:");
        localStringBuilder.append(bool);
        localStringBuilder.append(" nick:");
        if (bool) {
          localStringBuilder.append(paramAbsStructMsg.az.getString("rNick"));
        } else {
          localStringBuilder.append(paramAbsStructMsg.az.getString("sNick"));
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool3 = paramChatMessage instanceof MessageForStructing;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      bool1 = bool2;
      if (paramChatMessage.structingMsg != null)
      {
        bool1 = bool2;
        if ((paramChatMessage.structingMsg instanceof AbsShareMsg))
        {
          bool1 = bool2;
          if (paramChatMessage.structingMsg.mMsgServiceID == 52)
          {
            paramChatMessage = (AbsShareMsg)paramChatMessage.structingMsg;
            bool1 = bool2;
            if (paramChatMessage.getItemCount() > 0)
            {
              bool1 = bool2;
              if ((paramChatMessage.getItemByIndex(0) instanceof StructMsgItemLayout12)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private String d(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = null;
      Object localObject;
      try
      {
        localObject = Base64.decode(paramString, 0);
      }
      catch (Exception localException)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localException.getMessage());
          localObject = str;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("StructMsgItemLayout12", 2, localIllegalArgumentException.getMessage());
          localObject = str;
        }
      }
      str = paramString;
      if (localObject != null)
      {
        str = paramString;
        if (localObject.length > 0) {
          str = new String((byte[])localObject);
        }
      }
    }
    return str;
  }
  
  @TargetApi(11)
  private void e(View paramView)
  {
    paramView.setOnTouchListener(new StructMsgItemLayout12.2(this, paramView));
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (QLog.isColorLevel())
    {
      paramObjectInput = new StringBuilder();
      paramObjectInput.append("readExternal inited:");
      paramObjectInput.append(this.aB);
      paramObjectInput.append(" ");
      paramObjectInput.append(hashCode());
      QLog.i("StructMsgItemLayout12", 2, paramObjectInput.toString());
    }
    if (!this.aB) {
      f();
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    boolean bool = super.a(paramStructMsgNode);
    if (QLog.isColorLevel())
    {
      paramStructMsgNode = new StringBuilder();
      paramStructMsgNode.append("fromXml inited:");
      paramStructMsgNode.append(this.aB);
      paramStructMsgNode.append(" ");
      paramStructMsgNode.append(hashCode());
      QLog.i("StructMsgItemLayout12", 2, paramStructMsgNode.toString());
    }
    if (!this.aB) {
      f();
    }
    return bool;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject2 = paramContext;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView inited:");
      ((StringBuilder)localObject1).append(this.aB);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(hashCode());
      QLog.i("StructMsgItemLayout12", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.aB) {
      f();
    }
    boolean bool1 = this.az.getBoolean("isSend", false);
    boolean bool2 = this.az.getBoolean("isReceive", false);
    String str1 = this.az.getString("groupCode");
    String str2 = this.az.getString("rNick");
    if (!TextUtils.isEmpty(str1))
    {
      if (bool1) {
        localObject1 = "0X800638D";
      } else if (bool2) {
        localObject1 = "0X800638E";
      } else {
        localObject1 = "0X800638F";
      }
    }
    else if (bool1) {
      localObject1 = "0X80060B1";
    } else {
      localObject1 = "0X80060B2";
    }
    NearbyFlowerManager.a(((BaseActivity)localObject2).app, (String)localObject1);
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof FrameLayout)))
    {
      localObject3 = (FrameLayout)paramView;
      if ((((FrameLayout)localObject3).getChildCount() == 2) && ((((FrameLayout)localObject3).getTag() instanceof StructMsgItemLayout12.ViewHolder)))
      {
        localObject2 = (StructMsgItemLayout12.ViewHolder)((FrameLayout)localObject3).getTag();
        if (((StructMsgItemLayout12.ViewHolder)localObject2).e != null) {
          ((StructMsgItemLayout12.ViewHolder)localObject2).e.setVisibility(8);
        }
        if (((StructMsgItemLayout12.ViewHolder)localObject2).f != null) {
          ((StructMsgItemLayout12.ViewHolder)localObject2).f.setVisibility(8);
        }
        if (((StructMsgItemLayout12.ViewHolder)localObject2).d != null) {
          ((StructMsgItemLayout12.ViewHolder)localObject2).d.setVisibility(8);
        }
        localObject1 = localObject3;
        paramView = (View)localObject2;
        if (((StructMsgItemLayout12.ViewHolder)localObject2).g == null) {
          break label617;
        }
        ((StructMsgItemLayout12.ViewHolder)localObject2).g.setVisibility(8);
        localObject1 = localObject3;
        paramView = (View)localObject2;
        break label617;
      }
    }
    paramView = new StructMsgItemLayout12.ViewHolder();
    Object localObject1 = a(paramContext);
    ((FrameLayout)localObject1).setTag(paramView);
    paramView.c = new View((Context)localObject2);
    Object localObject3 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout)localObject1).addView(paramView.c, (ViewGroup.LayoutParams)localObject3);
    ((FrameLayout.LayoutParams)localObject3).setMargins(0, AIOUtils.b(10.0F, localResources), 0, 0);
    if (this.aA == null)
    {
      this.aA = new GradientDrawable();
      this.aA.setShape(0);
      this.aA.setColor(-1);
      this.aA.setCornerRadius(AIOUtils.b(14.0F, localResources));
    }
    paramView.c.setBackgroundDrawable(this.aA);
    paramView.h = new LinearLayout((Context)localObject2);
    paramView.h.setOrientation(0);
    localObject3 = new FrameLayout.LayoutParams(-2, -1);
    paramView.h.setGravity(16);
    ((FrameLayout)localObject1).addView(paramView.h, (ViewGroup.LayoutParams)localObject3);
    paramView.i = new LinearLayout((Context)localObject2);
    paramView.i.setOrientation(1);
    localObject2 = new LinearLayout.LayoutParams(AIOUtils.b(135.0F, localResources), -2);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(5.0F, localResources);
    localObject3 = paramView.i;
    int i;
    if (bool1) {
      i = 5;
    } else {
      i = 3;
    }
    ((LinearLayout)localObject3).setGravity(i);
    paramView.h.addView(paramView.i, (ViewGroup.LayoutParams)localObject2);
    label617:
    if (bool1) {
      paramView.i.setPadding(0, 0, AIOUtils.b(15.0F, localResources), 0);
    } else {
      paramView.i.setPadding(AIOUtils.b(15.0F, localResources), 0, 0, 0);
    }
    localObject2 = this.ax.iterator();
    for (;;)
    {
      localObject3 = paramContext;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      Object localObject4 = (AbsStructMsgElement)((Iterator)localObject2).next();
      ((AbsStructMsgElement)localObject4).ar = this.ar;
      Object localObject5 = ((AbsStructMsgElement)localObject4).b;
      if ("title".equals(localObject5))
      {
        if ((localObject4 instanceof StructMsgItemTitle))
        {
          localObject5 = (StructMsgItemTitle)localObject4;
          ((StructMsgItemTitle)localObject5).a(d(), 0);
          ((StructMsgItemTitle)localObject5).a(true);
          ((StructMsgItemTitle)localObject5).b(true);
        }
        localObject5 = ((AbsStructMsgElement)localObject4).a((Context)localObject3, paramView.e, paramBundle);
        localObject3 = (TextView)((View)localObject5).findViewById(2131448814);
        if (paramView.e == null)
        {
          paramView.e = ((View)localObject5);
          paramView.i.addView((View)localObject5, 0);
        }
        else
        {
          paramView.e.setVisibility(0);
        }
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("getview title:");
          ((StringBuilder)localObject5).append(((AbsStructMsgTextElement)localObject4).e());
          ((StringBuilder)localObject5).append(" realText:");
          ((StringBuilder)localObject5).append(((TextView)localObject3).getText());
          QLog.i("StructMsgItemLayout12", 2, ((StringBuilder)localObject5).toString());
        }
      }
      else if ("summary".equals(localObject5))
      {
        bool2 = localObject4 instanceof StructMsgItemSummary;
        if (bool2) {
          ((StructMsgItemSummary)localObject4).c("black");
        }
        localObject3 = ((AbsStructMsgElement)localObject4).a((Context)localObject3, paramView.f, paramBundle);
        localObject5 = (TextView)localObject3;
        if (!TextUtils.isEmpty(str1))
        {
          ((TextView)localObject5).setMaxLines(1);
          if (bool2) {
            ((StructMsgItemSummary)localObject4).b(str2);
          }
        }
        else
        {
          ((TextView)localObject5).setMaxLines(2);
        }
        if (paramView.f == null)
        {
          paramView.f = ((View)localObject3);
          localObject5 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject5).setMargins(0, AIOUtils.b(4.0F, localResources), 0, 0);
          paramView.i.addView((View)localObject3, (ViewGroup.LayoutParams)localObject5);
        }
        else
        {
          paramView.f.setVisibility(0);
        }
        localObject3 = (StructMsgItemSummary)localObject4;
        if ((this.az.size() > 0) && (TextUtils.isEmpty(str1))) {
          this.az.putString("cMeanPostfix", ((StructMsgItemSummary)localObject3).e());
        }
      }
      else if ("picture".equals(localObject5))
      {
        localObject5 = (StructMsgItemCover)localObject4;
        if (!((StructMsgItemCover)localObject5).av.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, 4))) {
          ((StructMsgItemCover)localObject5).av = String.format("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s", new Object[] { ((StructMsgItemCover)localObject5).av });
        }
        localObject3 = ((AbsStructMsgElement)localObject4).a((Context)localObject3, paramView.d, paramBundle);
        if (this.az.getInt("count", 0) > 9) {
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_END);
        } else {
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (paramView.d == null)
        {
          paramView.d = ((View)localObject3);
          paramView.d.setFocusable(true);
          localObject4 = new LinearLayout.LayoutParams(AIOUtils.b(115.0F, localResources), -1);
          ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
          paramView.h.addView((View)localObject3, bool1 ^ true, (ViewGroup.LayoutParams)localObject4);
        }
        else
        {
          paramView.d.setVisibility(0);
          if (bool1 != paramView.a) {
            if (bool1) {
              paramView.i.bringToFront();
            } else {
              paramView.d.bringToFront();
            }
          }
        }
        if (VersionUtils.e()) {
          e(paramView.d);
        } else {
          paramView.d.setOnClickListener(this.aC);
        }
      }
      else if ("remark".equals(localObject5))
      {
        if ((localObject4 instanceof StructMsgItemRemark)) {
          ((StructMsgItemRemark)localObject4).c("#FF9B9B9B");
        }
        localObject3 = ((AbsStructMsgElement)localObject4).a((Context)localObject3, paramView.g, paramBundle);
        if (paramView.g == null)
        {
          paramView.g = ((View)localObject3);
          localObject5 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject5).topMargin = AIOUtils.b(7.0F, localResources);
          paramView.i.addView((View)localObject3, (ViewGroup.LayoutParams)localObject5);
        }
        else
        {
          paramView.g.setVisibility(0);
        }
        localObject3 = (StructMsgItemRemark)localObject4;
        if (this.az.size() > 0)
        {
          this.az.putString("remark", ((StructMsgItemRemark)localObject3).e());
          if (!TextUtils.isEmpty(str1)) {
            this.az.putString("cMeanPostfix", ((StructMsgItemRemark)localObject3).e());
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getview remark:");
          ((StringBuilder)localObject3).append(((AbsStructMsgTextElement)localObject4).e());
          QLog.i("StructMsgItemLayout12", 2, ((StringBuilder)localObject3).toString());
        }
        else {}
      }
    }
    paramView.b = this.az;
    paramView.a = bool1;
    return localObject1;
  }
  
  protected int c()
  {
    return 12;
  }
  
  public String e()
  {
    return "Layout12";
  }
  
  public void f()
  {
    for (;;)
    {
      try
      {
        localObject6 = new JSONObject(this.j);
        if (QLog.isColorLevel()) {
          QLog.i("StructMsgItemLayout12", 2, ((JSONObject)localObject6).toString());
        }
        boolean bool1 = ((JSONObject)localObject6).has("fMean");
        String str16 = "";
        if (!bool1) {
          break label1432;
        }
        str2 = ((JSONObject)localObject6).getString("fMean");
        if (!((JSONObject)localObject6).has("cMean")) {
          break label1440;
        }
        Object localObject1 = ((JSONObject)localObject6).getString("cMean");
        Object localObject2;
        if (((JSONObject)localObject6).has("bgPic")) {
          localObject2 = ((JSONObject)localObject6).getString("bgPic");
        } else {
          localObject2 = "";
        }
        try
        {
          if (!((JSONObject)localObject6).has("fPic")) {
            break label1448;
          }
          localObject3 = ((JSONObject)localObject6).getString("fPic");
          Object localObject7 = localObject1;
          if (!((JSONObject)localObject6).has("sinfo")) {
            break label1456;
          }
          localObject1 = ((JSONObject)localObject6).getString("sinfo");
          if (!((JSONObject)localObject6).has("rinfo")) {
            break label1464;
          }
          localObject4 = ((JSONObject)localObject6).getString("rinfo");
          if (!((JSONObject)localObject6).has("score")) {
            break label1472;
          }
          str3 = ((JSONObject)localObject6).getString("score");
          if (!((JSONObject)localObject6).has("pID")) {
            break label1480;
          }
          str4 = ((JSONObject)localObject6).getString("pID");
          if (!((JSONObject)localObject6).has("pURL")) {
            break label1488;
          }
          str5 = ((JSONObject)localObject6).getString("pURL");
          if (!((JSONObject)localObject6).has("fCount")) {
            break label1496;
          }
          str6 = ((JSONObject)localObject6).getString("fCount");
          if (!((JSONObject)localObject6).has("rUin")) {
            break label1504;
          }
          str7 = ((JSONObject)localObject6).getString("rUin");
          if (!((JSONObject)localObject6).has("sUin")) {
            break label1512;
          }
          str8 = ((JSONObject)localObject6).getString("sUin");
          if (!((JSONObject)localObject6).has("rSex")) {
            break label1520;
          }
          str9 = ((JSONObject)localObject6).getString("rSex");
          if (!((JSONObject)localObject6).has("sSex")) {
            break label1528;
          }
          str10 = ((JSONObject)localObject6).getString("sSex");
          if (!((JSONObject)localObject6).has("rNick")) {
            break label1536;
          }
          str12 = ((JSONObject)localObject6).getString("rNick");
          if (!((JSONObject)localObject6).has("sNick")) {
            break label1544;
          }
          localObject5 = ((JSONObject)localObject6).getString("sNick");
          if (!((JSONObject)localObject6).has("version")) {
            break label1552;
          }
          str11 = ((JSONObject)localObject6).getString("version");
          if (!((JSONObject)localObject6).has("groupCode")) {
            break label1560;
          }
          str13 = ((JSONObject)localObject6).getString("groupCode");
          if (!((JSONObject)localObject6).has("gScore")) {
            break label1568;
          }
          str14 = ((JSONObject)localObject6).getString("gScore");
          if (!((JSONObject)localObject6).has("sID")) {
            break label1576;
          }
          str15 = ((JSONObject)localObject6).getString("sID");
          if (((JSONObject)localObject6).has("aNony")) {
            str16 = ((JSONObject)localObject6).getString("aNony");
          }
          int i;
          if (TextUtils.isEmpty(str6)) {
            i = 0;
          } else {
            i = Integer.valueOf(str6).intValue();
          }
          localObject6 = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
          bool1 = str8.equals(localObject6);
          boolean bool2 = str7.equals(localObject6);
          this.az.putBoolean("isSend", bool1);
          this.az.putBoolean("isReceive", bool2);
          localObject6 = this.ax.iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break label1587;
          }
          Object localObject8 = (AbsStructMsgElement)((Iterator)localObject6).next();
          if (!(localObject8 instanceof StructMsgItemCover)) {
            break label1584;
          }
          localObject6 = ((StructMsgItemCover)localObject8).av;
          str12 = d(str12);
          String str17 = d((String)localObject5);
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject8 = (FriendsManager)((QQAppInterface)localObject5).getManager(QQManagerFactory.FRIENDS_MANAGER);
          this.az.putString("sNick", str17);
          if (!bool1)
          {
            if ((localObject8 == null) || (!((FriendsManager)localObject8).n(str8))) {
              break label1593;
            }
            j = 1;
            if (j != 0)
            {
              str17 = ContactUtils.d((QQAppInterface)localObject5, str8);
              this.az.putString("sNick", str17);
              if (bool2) {
                this.az.putBoolean("isFriend", true);
              }
            }
          }
          this.az.putString("rNick", str12);
          if (!bool2)
          {
            if ((localObject8 == null) || (!((FriendsManager)localObject8).n(str7))) {
              break label1598;
            }
            j = 1;
            if (j != 0)
            {
              localObject5 = ContactUtils.d((QQAppInterface)localObject5, str7);
              this.az.putString("rNick", (String)localObject5);
              if (bool1) {
                this.az.putBoolean("isFriend", true);
              }
            }
          }
          this.az.putString("rUin", str7);
          this.az.putString("sUin", str8);
          this.az.putString("rSex", str9);
          this.az.putString("sSex", str10);
          this.az.putString("bgPic", (String)localObject2);
          this.az.putString("sInfo", (String)localObject1);
          this.az.putString("rInfo", (String)localObject4);
          this.az.putString("score", str3);
          this.az.putString("fPic", (String)localObject3);
          this.az.putString("fMean", str2);
          this.az.putString("cMean", localObject7);
          this.az.putString("fCount", str6);
          this.az.putInt("count", i);
          this.az.putString("pID", str4);
          this.az.putString("pURL", str5);
          this.az.putString("version", str11);
          this.az.putString("groupCode", str13);
          this.az.putString("gScore", str14);
          if (!TextUtils.isEmpty((CharSequence)localObject6)) {
            this.az.putString("cover", (String)localObject6);
          }
          this.az.putString("sID", str15);
          if (!TextUtils.isEmpty(str16)) {
            this.az.putString("anonyInfo", str16);
          }
          if ((AppSetting.e) && (this.aF == null))
          {
            localObject2 = new StringBuilder();
            localObject1 = str12;
            if (bool1) {
              localObject1 = "我";
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            if (!bool1) {
              break label1603;
            }
            localObject1 = "送出";
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(localObject7);
            ((StringBuilder)localObject2).append(',');
            str2 = null;
            localObject1 = null;
            localObject3 = this.ax.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
              str3 = ((AbsStructMsgElement)localObject4).b;
              if ("remark".equals(str3))
              {
                localObject1 = ((StructMsgItemRemark)localObject4).e();
                continue;
              }
              if (!"summary".equals(str3)) {
                continue;
              }
              str2 = ((StructMsgItemSummary)localObject4).e();
              continue;
            }
            ((StringBuilder)localObject2).append(str2);
            ((StringBuilder)localObject2).append(",");
            if (bool1)
            {
              ((StringBuilder)localObject2).append("对方");
              ((StringBuilder)localObject2).append((String)localObject1);
            }
            else
            {
              ((StringBuilder)localObject2).append((String)localObject1);
            }
            ((StringBuilder)localObject2).append("按钮");
            this.aF = ((StringBuilder)localObject2).toString();
          }
        }
        catch (Exception localException1) {}catch (JSONException localJSONException1)
        {
          str2 = "StructMsgItemLayout12";
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("StructMsgItemLayout12", 2, localException2.getMessage());
        }
      }
      catch (JSONException localJSONException2)
      {
        str2 = "StructMsgItemLayout12";
      }
      QLog.i(str2, 2, localJSONException2.getMessage());
      continue;
      this.aB = true;
      return;
      label1432:
      String str2 = "";
      continue;
      label1440:
      String str1 = "";
      continue;
      label1448:
      Object localObject3 = "";
      continue;
      label1456:
      str1 = "";
      continue;
      label1464:
      Object localObject4 = "";
      continue;
      label1472:
      String str3 = "";
      continue;
      label1480:
      String str4 = "";
      continue;
      label1488:
      String str5 = "";
      continue;
      label1496:
      String str6 = "";
      continue;
      label1504:
      String str7 = "";
      continue;
      label1512:
      String str8 = "";
      continue;
      label1520:
      String str9 = "";
      continue;
      label1528:
      String str10 = "";
      continue;
      label1536:
      String str12 = "";
      continue;
      label1544:
      Object localObject5 = "";
      continue;
      label1552:
      String str11 = "";
      continue;
      label1560:
      String str13 = "";
      continue;
      label1568:
      String str14 = "";
      continue;
      label1576:
      String str15 = "";
      continue;
      label1584:
      continue;
      label1587:
      Object localObject6 = null;
      continue;
      label1593:
      int j = 0;
      continue;
      label1598:
      j = 0;
      continue;
      label1603:
      str1 = "送你";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12
 * JD-Core Version:    0.7.0.1
 */