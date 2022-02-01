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
  public GradientDrawable a;
  public Bundle a;
  View.OnClickListener a;
  public boolean a;
  private String ac;
  public boolean b = false;
  public boolean c = false;
  
  public StructMsgItemLayout12()
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new StructMsgItemLayout12.1(this);
  }
  
  private FrameLayout a(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, AIOUtils.b(105.0F, paramContext.getResources())));
    localFrameLayout.setId(2131371728);
    if (AppSetting.d) {
      localFrameLayout.setContentDescription(this.ac);
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
        boolean bool = paramAbsStructMsg.jdField_a_of_type_AndroidOsBundle.getBoolean("isSend", false);
        localStringBuilder.append("isSend:");
        localStringBuilder.append(bool);
        localStringBuilder.append(" nick:");
        if (bool) {
          localStringBuilder.append(paramAbsStructMsg.jdField_a_of_type_AndroidOsBundle.getString("rNick"));
        } else {
          localStringBuilder.append(paramAbsStructMsg.jdField_a_of_type_AndroidOsBundle.getString("sNick"));
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
  
  private String b(String paramString)
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
  
  public void a()
  {
    for (;;)
    {
      try
      {
        localObject6 = new JSONObject(this.h);
        if (QLog.isColorLevel()) {
          QLog.i("StructMsgItemLayout12", 2, ((JSONObject)localObject6).toString());
        }
        boolean bool1 = ((JSONObject)localObject6).has("fMean");
        String str16 = "";
        if (!bool1) {
          break label1380;
        }
        str2 = ((JSONObject)localObject6).getString("fMean");
        if (!((JSONObject)localObject6).has("cMean")) {
          break label1387;
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
            break label1394;
          }
          localObject3 = ((JSONObject)localObject6).getString("fPic");
          Object localObject7 = localObject1;
          if (!((JSONObject)localObject6).has("sinfo")) {
            break label1401;
          }
          localObject1 = ((JSONObject)localObject6).getString("sinfo");
          if (!((JSONObject)localObject6).has("rinfo")) {
            break label1408;
          }
          localObject4 = ((JSONObject)localObject6).getString("rinfo");
          if (!((JSONObject)localObject6).has("score")) {
            break label1415;
          }
          str3 = ((JSONObject)localObject6).getString("score");
          if (!((JSONObject)localObject6).has("pID")) {
            break label1422;
          }
          str4 = ((JSONObject)localObject6).getString("pID");
          if (!((JSONObject)localObject6).has("pURL")) {
            break label1429;
          }
          str5 = ((JSONObject)localObject6).getString("pURL");
          if (!((JSONObject)localObject6).has("fCount")) {
            break label1436;
          }
          str6 = ((JSONObject)localObject6).getString("fCount");
          if (!((JSONObject)localObject6).has("rUin")) {
            break label1443;
          }
          str7 = ((JSONObject)localObject6).getString("rUin");
          if (!((JSONObject)localObject6).has("sUin")) {
            break label1450;
          }
          str8 = ((JSONObject)localObject6).getString("sUin");
          if (!((JSONObject)localObject6).has("rSex")) {
            break label1457;
          }
          str9 = ((JSONObject)localObject6).getString("rSex");
          if (!((JSONObject)localObject6).has("sSex")) {
            break label1464;
          }
          str10 = ((JSONObject)localObject6).getString("sSex");
          if (!((JSONObject)localObject6).has("rNick")) {
            break label1471;
          }
          str12 = ((JSONObject)localObject6).getString("rNick");
          if (!((JSONObject)localObject6).has("sNick")) {
            break label1478;
          }
          localObject5 = ((JSONObject)localObject6).getString("sNick");
          if (!((JSONObject)localObject6).has("version")) {
            break label1485;
          }
          str11 = ((JSONObject)localObject6).getString("version");
          if (!((JSONObject)localObject6).has("groupCode")) {
            break label1492;
          }
          str13 = ((JSONObject)localObject6).getString("groupCode");
          if (!((JSONObject)localObject6).has("gScore")) {
            break label1499;
          }
          str14 = ((JSONObject)localObject6).getString("gScore");
          if (!((JSONObject)localObject6).has("sID")) {
            break label1506;
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
          this.jdField_a_of_type_AndroidOsBundle.putBoolean("isSend", bool1);
          this.jdField_a_of_type_AndroidOsBundle.putBoolean("isReceive", bool2);
          localObject6 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break label1516;
          }
          Object localObject8 = (AbsStructMsgElement)((Iterator)localObject6).next();
          if (!(localObject8 instanceof StructMsgItemCover)) {
            break label1513;
          }
          localObject6 = ((StructMsgItemCover)localObject8).ac;
          str12 = b(str12);
          String str17 = b((String)localObject5);
          localObject5 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          localObject8 = (FriendsManager)((QQAppInterface)localObject5).getManager(QQManagerFactory.FRIENDS_MANAGER);
          this.jdField_a_of_type_AndroidOsBundle.putString("sNick", str17);
          if (!bool1)
          {
            if ((localObject8 == null) || (!((FriendsManager)localObject8).b(str8))) {
              break label1522;
            }
            j = 1;
            if (j != 0)
            {
              str17 = ContactUtils.d((QQAppInterface)localObject5, str8);
              this.jdField_a_of_type_AndroidOsBundle.putString("sNick", str17);
              if (bool2) {
                this.jdField_a_of_type_AndroidOsBundle.putBoolean("isFriend", true);
              }
            }
          }
          this.jdField_a_of_type_AndroidOsBundle.putString("rNick", str12);
          if (!bool2)
          {
            if ((localObject8 == null) || (!((FriendsManager)localObject8).b(str7))) {
              break label1527;
            }
            j = 1;
            if (j != 0)
            {
              localObject5 = ContactUtils.d((QQAppInterface)localObject5, str7);
              this.jdField_a_of_type_AndroidOsBundle.putString("rNick", (String)localObject5);
              if (bool1) {
                this.jdField_a_of_type_AndroidOsBundle.putBoolean("isFriend", true);
              }
            }
          }
          this.jdField_a_of_type_AndroidOsBundle.putString("rUin", str7);
          this.jdField_a_of_type_AndroidOsBundle.putString("sUin", str8);
          this.jdField_a_of_type_AndroidOsBundle.putString("rSex", str9);
          this.jdField_a_of_type_AndroidOsBundle.putString("sSex", str10);
          this.jdField_a_of_type_AndroidOsBundle.putString("bgPic", (String)localObject2);
          this.jdField_a_of_type_AndroidOsBundle.putString("sInfo", (String)localObject1);
          this.jdField_a_of_type_AndroidOsBundle.putString("rInfo", (String)localObject4);
          this.jdField_a_of_type_AndroidOsBundle.putString("score", str3);
          this.jdField_a_of_type_AndroidOsBundle.putString("fPic", (String)localObject3);
          this.jdField_a_of_type_AndroidOsBundle.putString("fMean", str2);
          this.jdField_a_of_type_AndroidOsBundle.putString("cMean", localObject7);
          this.jdField_a_of_type_AndroidOsBundle.putString("fCount", str6);
          this.jdField_a_of_type_AndroidOsBundle.putInt("count", i);
          this.jdField_a_of_type_AndroidOsBundle.putString("pID", str4);
          this.jdField_a_of_type_AndroidOsBundle.putString("pURL", str5);
          this.jdField_a_of_type_AndroidOsBundle.putString("version", str11);
          this.jdField_a_of_type_AndroidOsBundle.putString("groupCode", str13);
          this.jdField_a_of_type_AndroidOsBundle.putString("gScore", str14);
          if (!TextUtils.isEmpty((CharSequence)localObject6)) {
            this.jdField_a_of_type_AndroidOsBundle.putString("cover", (String)localObject6);
          }
          this.jdField_a_of_type_AndroidOsBundle.putString("sID", str15);
          if (!TextUtils.isEmpty(str16)) {
            this.jdField_a_of_type_AndroidOsBundle.putString("anonyInfo", str16);
          }
          if ((AppSetting.d) && (this.ac == null))
          {
            localObject2 = new StringBuilder();
            localObject1 = str12;
            if (bool1) {
              localObject1 = "我";
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            if (!bool1) {
              break label1532;
            }
            localObject1 = "送出";
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(localObject7);
            ((StringBuilder)localObject2).append(',');
            str2 = null;
            localObject1 = null;
            localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
              str3 = ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangString;
              if ("remark".equals(str3))
              {
                localObject1 = ((StructMsgItemRemark)localObject4).b();
                continue;
              }
              if (!"summary".equals(str3)) {
                continue;
              }
              str2 = ((StructMsgItemSummary)localObject4).b();
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
            this.ac = ((StringBuilder)localObject2).toString();
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
      this.jdField_a_of_type_Boolean = true;
      return;
      label1380:
      String str2 = "";
      continue;
      label1387:
      String str1 = "";
      continue;
      label1394:
      Object localObject3 = "";
      continue;
      label1401:
      str1 = "";
      continue;
      label1408:
      Object localObject4 = "";
      continue;
      label1415:
      String str3 = "";
      continue;
      label1422:
      String str4 = "";
      continue;
      label1429:
      String str5 = "";
      continue;
      label1436:
      String str6 = "";
      continue;
      label1443:
      String str7 = "";
      continue;
      label1450:
      String str8 = "";
      continue;
      label1457:
      String str9 = "";
      continue;
      label1464:
      String str10 = "";
      continue;
      label1471:
      String str12 = "";
      continue;
      label1478:
      Object localObject5 = "";
      continue;
      label1485:
      String str11 = "";
      continue;
      label1492:
      String str13 = "";
      continue;
      label1499:
      String str14 = "";
      continue;
      label1506:
      String str15 = "";
      continue;
      label1513:
      continue;
      label1516:
      Object localObject6 = null;
      continue;
      label1522:
      int j = 0;
      continue;
      label1527:
      j = 0;
      continue;
      label1532:
      str1 = "送你";
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (QLog.isColorLevel())
    {
      paramObjectInput = new StringBuilder();
      paramObjectInput.append("readExternal inited:");
      paramObjectInput.append(this.jdField_a_of_type_Boolean);
      paramObjectInput.append(" ");
      paramObjectInput.append(hashCode());
      QLog.i("StructMsgItemLayout12", 2, paramObjectInput.toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    boolean bool = super.a(paramStructMsgNode);
    if (QLog.isColorLevel())
    {
      paramStructMsgNode = new StringBuilder();
      paramStructMsgNode.append("fromXml inited:");
      paramStructMsgNode.append(this.jdField_a_of_type_Boolean);
      paramStructMsgNode.append(" ");
      paramStructMsgNode.append(hashCode());
      QLog.i("StructMsgItemLayout12", 2, paramStructMsgNode.toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    return bool;
  }
  
  protected int b()
  {
    return 12;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject2 = paramContext;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView inited:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(hashCode());
      QLog.i("StructMsgItemLayout12", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    boolean bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isSend", false);
    boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("isReceive", false);
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("groupCode");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("rNick");
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
        if (((StructMsgItemLayout12.ViewHolder)localObject2).c != null) {
          ((StructMsgItemLayout12.ViewHolder)localObject2).c.setVisibility(8);
        }
        if (((StructMsgItemLayout12.ViewHolder)localObject2).d != null) {
          ((StructMsgItemLayout12.ViewHolder)localObject2).d.setVisibility(8);
        }
        if (((StructMsgItemLayout12.ViewHolder)localObject2).jdField_b_of_type_AndroidViewView != null) {
          ((StructMsgItemLayout12.ViewHolder)localObject2).jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        localObject1 = localObject3;
        paramView = (View)localObject2;
        if (((StructMsgItemLayout12.ViewHolder)localObject2).e == null) {
          break label625;
        }
        ((StructMsgItemLayout12.ViewHolder)localObject2).e.setVisibility(8);
        localObject1 = localObject3;
        paramView = (View)localObject2;
        break label625;
      }
    }
    paramView = new StructMsgItemLayout12.ViewHolder();
    Object localObject1 = a(paramContext);
    ((FrameLayout)localObject1).setTag(paramView);
    paramView.jdField_a_of_type_AndroidViewView = new View((Context)localObject2);
    Object localObject3 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout)localObject1).addView(paramView.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject3);
    ((FrameLayout.LayoutParams)localObject3).setMargins(0, AIOUtils.b(10.0F, localResources), 0, 0);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = new GradientDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setShape(0);
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(-1);
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setCornerRadius(AIOUtils.b(14.0F, localResources));
    }
    paramView.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable);
    paramView.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout((Context)localObject2);
    paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    localObject3 = new FrameLayout.LayoutParams(-2, -1);
    paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
    ((FrameLayout)localObject1).addView(paramView.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject3);
    paramView.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout((Context)localObject2);
    paramView.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localObject2 = new LinearLayout.LayoutParams(AIOUtils.b(135.0F, localResources), -2);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    ((LinearLayout.LayoutParams)localObject2).topMargin = AIOUtils.b(5.0F, localResources);
    localObject3 = paramView.jdField_b_of_type_AndroidWidgetLinearLayout;
    int i;
    if (bool1) {
      i = 5;
    } else {
      i = 3;
    }
    ((LinearLayout)localObject3).setGravity(i);
    paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
    label625:
    if (bool1) {
      paramView.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, AIOUtils.b(15.0F, localResources), 0);
    } else {
      paramView.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(AIOUtils.b(15.0F, localResources), 0, 0, 0);
    }
    localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      localObject3 = paramContext;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      Object localObject4 = (AbsStructMsgElement)((Iterator)localObject2).next();
      ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      Object localObject5 = ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangString;
      if ("title".equals(localObject5))
      {
        if ((localObject4 instanceof StructMsgItemTitle))
        {
          localObject5 = (StructMsgItemTitle)localObject4;
          ((StructMsgItemTitle)localObject5).a(a(), 0);
          ((StructMsgItemTitle)localObject5).a(true);
          ((StructMsgItemTitle)localObject5).b(true);
        }
        localObject5 = ((AbsStructMsgElement)localObject4).a((Context)localObject3, paramView.c, paramBundle);
        localObject3 = (TextView)((View)localObject5).findViewById(2131379930);
        if (paramView.c == null)
        {
          paramView.c = ((View)localObject5);
          paramView.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject5, 0);
        }
        else
        {
          paramView.c.setVisibility(0);
        }
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("getview title:");
          ((StringBuilder)localObject5).append(((AbsStructMsgTextElement)localObject4).b());
          ((StringBuilder)localObject5).append(" realText:");
          ((StringBuilder)localObject5).append(((TextView)localObject3).getText());
          QLog.i("StructMsgItemLayout12", 2, ((StringBuilder)localObject5).toString());
        }
      }
      else if ("summary".equals(localObject5))
      {
        bool2 = localObject4 instanceof StructMsgItemSummary;
        if (bool2) {
          ((StructMsgItemSummary)localObject4).b("black");
        }
        localObject3 = ((AbsStructMsgElement)localObject4).a((Context)localObject3, paramView.d, paramBundle);
        localObject5 = (TextView)localObject3;
        if (!TextUtils.isEmpty(str1))
        {
          ((TextView)localObject5).setMaxLines(1);
          if (bool2) {
            ((StructMsgItemSummary)localObject4).a(str2);
          }
        }
        else
        {
          ((TextView)localObject5).setMaxLines(2);
        }
        if (paramView.d == null)
        {
          paramView.d = ((View)localObject3);
          localObject5 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject5).setMargins(0, AIOUtils.b(4.0F, localResources), 0, 0);
          paramView.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject5);
        }
        else
        {
          paramView.d.setVisibility(0);
        }
        localObject3 = (StructMsgItemSummary)localObject4;
        if ((this.jdField_a_of_type_AndroidOsBundle.size() > 0) && (TextUtils.isEmpty(str1))) {
          this.jdField_a_of_type_AndroidOsBundle.putString("cMeanPostfix", ((StructMsgItemSummary)localObject3).b());
        }
      }
      else if ("picture".equals(localObject5))
      {
        localObject5 = (StructMsgItemCover)localObject4;
        if (!((StructMsgItemCover)localObject5).ac.startsWith("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, 4))) {
          ((StructMsgItemCover)localObject5).ac = String.format("https://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s", new Object[] { ((StructMsgItemCover)localObject5).ac });
        }
        localObject3 = ((AbsStructMsgElement)localObject4).a((Context)localObject3, paramView.jdField_b_of_type_AndroidViewView, paramBundle);
        if (this.jdField_a_of_type_AndroidOsBundle.getInt("count", 0) > 9) {
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_END);
        } else {
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (paramView.jdField_b_of_type_AndroidViewView == null)
        {
          paramView.jdField_b_of_type_AndroidViewView = ((View)localObject3);
          paramView.jdField_b_of_type_AndroidViewView.setFocusable(true);
          localObject4 = new LinearLayout.LayoutParams(AIOUtils.b(115.0F, localResources), -1);
          ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
          paramView.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, bool1 ^ true, (ViewGroup.LayoutParams)localObject4);
        }
        else
        {
          paramView.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if (bool1 != paramView.jdField_a_of_type_Boolean) {
            if (bool1) {
              paramView.jdField_b_of_type_AndroidWidgetLinearLayout.bringToFront();
            } else {
              paramView.jdField_b_of_type_AndroidViewView.bringToFront();
            }
          }
        }
        if (VersionUtils.e()) {
          e(paramView.jdField_b_of_type_AndroidViewView);
        } else {
          paramView.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
      }
      else if ("remark".equals(localObject5))
      {
        if ((localObject4 instanceof StructMsgItemRemark)) {
          ((StructMsgItemRemark)localObject4).b("#FF9B9B9B");
        }
        localObject3 = ((AbsStructMsgElement)localObject4).a((Context)localObject3, paramView.e, paramBundle);
        if (paramView.e == null)
        {
          paramView.e = ((View)localObject3);
          localObject5 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject5).topMargin = AIOUtils.b(7.0F, localResources);
          paramView.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject5);
        }
        else
        {
          paramView.e.setVisibility(0);
        }
        localObject3 = (StructMsgItemRemark)localObject4;
        if (this.jdField_a_of_type_AndroidOsBundle.size() > 0)
        {
          this.jdField_a_of_type_AndroidOsBundle.putString("remark", ((StructMsgItemRemark)localObject3).b());
          if (!TextUtils.isEmpty(str1)) {
            this.jdField_a_of_type_AndroidOsBundle.putString("cMeanPostfix", ((StructMsgItemRemark)localObject3).b());
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getview remark:");
          ((StringBuilder)localObject3).append(((AbsStructMsgTextElement)localObject4).b());
          QLog.i("StructMsgItemLayout12", 2, ((StringBuilder)localObject3).toString());
        }
        else {}
      }
    }
    paramView.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidOsBundle;
    paramView.jdField_a_of_type_Boolean = bool1;
    return localObject1;
  }
  
  public String b()
  {
    return "Layout12";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12
 * JD-Core Version:    0.7.0.1
 */