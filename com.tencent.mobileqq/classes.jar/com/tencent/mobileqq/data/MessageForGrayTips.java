package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import apey;
import auss;
import ausv;
import bdoo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForGrayTips
  extends ChatMessage
{
  public static final int ABILITY_SUPPORT_COLOR = 2;
  public static final int ABILITY_SUPPORT_IMAGE = 1;
  private static final String KEY_NEW_HIGHTLIGHT_ITEM_TAG = "new_item_tag";
  public static final String KEY_TROOP_NEW_MEMBER_UIN = "troop_new_member_uin";
  private static final String TAG = "MessageForGrayTips";
  
  public static void decodeImageSpan(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder, MessageForGrayTips.HightlightItem paramHightlightItem, boolean paramBoolean, Drawable.Callback paramCallback)
  {
    if ((paramHightlightItem.icon.startsWith("http://")) || (paramHightlightItem.icon.startsWith("https://"))) {
      if (paramBoolean)
      {
        paramSpannableStringBuilder.setSpan(new apey(paramContext, 0, paramHightlightItem.icon, 32), paramHightlightItem.start, paramHightlightItem.end, 33);
        if (QLog.isColorLevel()) {
          QLog.i("MessageForGrayTips", 2, "MessageForGrayTips.getHightlightMsgText Url Image=" + paramHightlightItem.icon);
        }
      }
    }
    label293:
    label427:
    for (;;)
    {
      return;
      paramSpannableStringBuilder.setSpan(new apey(paramContext, 0, paramHightlightItem.icon), paramHightlightItem.start, paramHightlightItem.end, 33);
      break;
      if (auss.a(paramHightlightItem.icon))
      {
        String str = auss.b(paramHightlightItem.icon);
        if (!TextUtils.isEmpty(str))
        {
          if (paramBoolean) {}
          for (paramContext = new ausv(paramContext, 0, str, bdoo.b(16.0F), paramCallback);; paramContext = new ausv(paramContext, 0, str, paramCallback))
          {
            paramSpannableStringBuilder.setSpan(paramContext, paramHightlightItem.start, paramHightlightItem.end, 33);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("MessageForGrayTips", 2, "decodeImageSpan isMutualMarkImageUrlTemplate Url Image=" + str);
            return;
          }
        }
      }
      else
      {
        int i = paramHightlightItem.icon.indexOf('.');
        if (i != -1)
        {
          paramCallback = paramHightlightItem.icon.substring(0, i);
          if (!auss.b.containsKey(paramCallback)) {
            break label382;
          }
          i = ((Integer)auss.b.get(paramCallback)).intValue();
          if (i != 0)
          {
            if (!paramBoolean) {
              break label402;
            }
            paramSpannableStringBuilder.setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, i, paramHightlightItem.getIconSize()), paramHightlightItem.start, paramHightlightItem.end, 33);
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label427;
          }
          QLog.i("MessageForGrayTips", 2, "MessageForGrayTips.getHightlightMsgText Image=" + paramCallback + " resourceId:" + i);
          return;
          paramCallback = paramHightlightItem.icon;
          break;
          label382:
          i = paramContext.getResources().getIdentifier(paramCallback, "drawable", paramContext.getPackageName());
          break label293;
          paramSpannableStringBuilder.setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, i), paramHightlightItem.start, paramHightlightItem.end, 33);
        }
      }
    }
  }
  
  public static String getOrginMsg(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("                    ##**##");
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  public void addHightlightItem(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int j = 0;
    if (paramInt1 >= paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageForGrayTips", 2, "revoke msg addHightlightItem start >= end error");
      }
      return;
    }
    saveExtInfoToExtStr("new_item_tag", Boolean.TRUE.toString());
    String str2;
    String str3;
    String str1;
    int i;
    if (paramBundle == null)
    {
      str2 = null;
      str3 = null;
      str1 = null;
      i = -1;
    }
    for (;;)
    {
      String str4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageForGrayTips", 2, "addHightlightItem ==>actionType:" + i);
        }
        str4 = "," + i + "," + paramInt1 + "," + paramInt2;
        switch (i)
        {
        case 5: 
          paramBundle = paramBundle + ",icon";
          if (str3 == null) {
            break label802;
          }
          paramBundle = paramBundle + ",1," + str3;
          if (str2 == null) {
            break label826;
          }
          paramBundle = paramBundle + ",1," + str2;
          paramBundle = paramBundle + ",color";
          if (str1 == null) {
            break label850;
          }
          paramBundle = paramBundle + ",1," + str1;
          paramInt1 = this.msg.indexOf("                    ##**##");
          if (paramInt1 != -1) {
            break label874;
          }
          this.msg = (this.msg + "                    ##**##" + "1" + paramBundle);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      i = paramBundle.getInt("key_action");
      str1 = paramBundle.getString("textColor");
      str3 = paramBundle.getString("image_resource");
      str2 = paramBundle.getString("image_alt");
      continue;
      String str5 = paramBundle.getString("troop_mem_uin");
      paramInt1 = j;
      if (paramBundle.getBoolean("need_update_nick")) {
        paramInt1 = 1;
      }
      paramBundle = str4 + "," + paramInt1 + "," + str5;
      continue;
      paramBundle = paramBundle.getString("troop_mem_uin");
      paramBundle = str4 + "," + paramBundle;
      continue;
      str5 = paramBundle.getString("key_action_DATA");
      paramBundle = paramBundle.getString("key_a_action_DATA");
      paramBundle = str4 + "," + str5 + "," + paramBundle;
      continue;
      str5 = paramBundle.getString("remark");
      paramBundle = str5;
      if (TextUtils.isEmpty(str5)) {
        paramBundle = "";
      }
      paramBundle = str4 + "," + paramBundle;
      continue;
      paramInt1 = paramBundle.getInt("group_id", -1);
      paramBundle = str4 + "," + paramInt1;
      continue;
      paramBundle = paramBundle.getString("key_action_DATA");
      paramBundle = str4 + "," + paramBundle;
      continue;
      paramBundle = paramBundle.getString("key_action_DATA");
      paramBundle = str4 + "," + paramBundle;
      continue;
      paramBundle = paramBundle.getString("key_action_DATA");
      paramBundle = str4 + "," + paramBundle;
      continue;
      label802:
      paramBundle = paramBundle + ",0";
      continue;
      label826:
      paramBundle = paramBundle + ",0";
      continue;
      label850:
      paramBundle = paramBundle + ",0";
      continue;
      label874:
      str1 = this.msg.substring(0, paramInt1);
      str3 = this.msg.substring(paramInt1 + "                    ##**##".length(), this.msg.length());
      paramInt1 = str3.indexOf(',');
      str2 = str3.substring(0, paramInt1);
      str3 = str3.substring(paramInt1, str3.length());
      paramInt1 = Integer.parseInt(str2);
      paramBundle = paramInt1 + 1 + str3 + paramBundle;
      this.msg = (str1 + "                    ##**##" + paramBundle);
      if ((!QLog.isColorLevel()) || (!(this instanceof MessageForDeliverGiftTips))) {
        break;
      }
      QLog.i(".troop.send_gift", 2, "MessageForGrayTips.addHightlightItem:" + this.msg);
      return;
      paramBundle = str4;
    }
  }
  
  public boolean checkAbillity(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      return isSupportImage();
    }
    return isSupportColor();
  }
  
  protected void doParse() {}
  
  public SpannableStringBuilder getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean, Drawable.Callback paramCallback)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    String str2;
    Object localObject1;
    Object localObject5;
    int i3;
    ArrayList localArrayList;
    int i1;
    try
    {
      if (this.extStr != null) {
        bool1 = new JSONObject(this.extStr).getBoolean("new_item_tag");
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, "revoke msg getHightlightMsgText==> isNewHighlitItem:" + bool1);
      }
      String str1 = this.msg;
      i = -1;
      if (!TextUtils.isEmpty(str1)) {
        i = str1.indexOf("                    ##**##");
      }
      if (i == -1) {
        return new SpannableStringBuilder(str1);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("MessageForGrayTips", 2, "revoke msg getHightlightMsgText JSONException");
          bool1 = bool2;
        }
      }
      str2 = this.msg.substring(0, i);
      localObject1 = this.msg.substring(i + "                    ##**##".length(), this.msg.length());
      i = ((String)localObject1).indexOf(',');
      localObject5 = ((String)localObject1).substring(0, i);
      localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
      i3 = Integer.parseInt((String)localObject5);
      new LinkedList();
      localArrayList = new ArrayList(i3);
      i1 = 0;
    }
    int i2;
    int j;
    int k;
    label259:
    Object localObject8;
    Object localObject7;
    Object localObject9;
    Object localObject10;
    if (i1 < i3)
    {
      i2 = -1;
      i = 0;
      j = 0;
      if (bool1)
      {
        k = 0;
        localObject8 = null;
        localObject7 = null;
        localObject9 = null;
        localObject10 = null;
        localObject5 = localObject1;
        if (!bool1) {}
      }
    }
    for (;;)
    {
      int n;
      int m;
      long l;
      for (;;)
      {
        label623:
        Object localObject11;
        label674:
        label946:
        try
        {
          i = ((String)localObject1).indexOf(',');
          localObject5 = ((String)localObject1).substring(0, i);
          localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
          i2 = Integer.parseInt((String)localObject5);
          i = ((String)localObject1).indexOf(',');
          localObject5 = ((String)localObject1).substring(0, i);
          localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
          i = Integer.parseInt((String)localObject5);
          j = ((String)localObject1).indexOf(',');
          if (j != -1)
          {
            localObject5 = ((String)localObject1).substring(0, j);
            localObject1 = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
            j = Integer.parseInt((String)localObject5);
            localObject5 = localObject1;
            if (QLog.isColorLevel()) {
              QLog.d("MessageForGrayTips", 2, "revoke msg getHightlightMsgText==> actionType:" + i2);
            }
            switch (i2)
            {
            case 0: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 16: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 27: 
            default: 
              if (bool1)
              {
                n = -1;
                m = k;
                localObject1 = localObject5;
                localObject5 = "";
                k = n;
                if (TextUtils.isEmpty((CharSequence)localObject5)) {
                  break label2854;
                }
              }
              break;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          label895:
          QLog.d("MessageForGrayTips", 2, "revoke msg getHightlightMsgText==> decodeMagicString error.msg:" + this.msg, localNumberFormatException1);
        }
        try
        {
          l = Long.parseLong((String)localObject5);
          n = ((String)localObject1).indexOf(',');
          if ((n == -1) || (!"icon".equals(((String)localObject1).substring(0, n)))) {
            break label2848;
          }
          localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
          n = 1;
          if (!checkAbillity(1)) {
            if (n == 0) {
              break label2838;
            }
          }
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          for (;;)
          {
            label1060:
            if (QLog.isColorLevel()) {
              QLog.e("MessageForGrayTips", 2, "getHightlightMsgText ==>NumberFormatException");
            }
          }
          n = Integer.parseInt(localNumberFormatException3);
          continue;
          n = Integer.parseInt((String)localObject6);
          continue;
          localObject8 = localObject6;
          continue;
          localObject8 = null;
          continue;
        }
        try
        {
          n = ((String)localObject1).indexOf(',');
          if (n != -1)
          {
            localObject5 = ((String)localObject1).substring(0, n);
            localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
            n = Integer.parseInt((String)localObject5);
            if (n == 0) {
              break label2953;
            }
            n = ((String)localObject1).indexOf(',');
            if (n == -1) {
              break label2938;
            }
            localObject5 = ((String)localObject1).substring(0, n);
            localObject8 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
            localObject1 = localObject5;
            localObject5 = localObject8;
            n = ((String)localObject5).indexOf(',');
            if (n == -1) {
              break label2129;
            }
            localObject8 = ((String)localObject5).substring(0, n);
            localObject5 = ((String)localObject5).substring(n + 1, ((String)localObject5).length());
            n = Integer.parseInt((String)localObject8);
            if (n == 0) {
              break label2146;
            }
            n = ((String)localObject5).indexOf(',');
            if (n == -1) {
              break label2139;
            }
            localObject8 = ((String)localObject5).substring(0, n);
            localObject5 = ((String)localObject5).substring(n + 1, ((String)localObject5).length());
            localObject11 = localObject5;
            localObject5 = localObject1;
            localObject1 = localObject11;
            n = ((String)localObject1).indexOf(',');
            if ((n == -1) || (!"color".equals(((String)localObject1).substring(0, n)))) {
              break label2832;
            }
            localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
            n = 1;
            if (!checkAbillity(2)) {
              if (n == 0) {
                break label2824;
              }
            }
          }
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          if (!QLog.isColorLevel()) {
            break label1155;
          }
          QLog.e("MessageForGrayTips", 2, "parse gray tips image resource or alt failed. msg:" + this.msg + "exception:" + localNumberFormatException4.getStackTrace());
          break label1155;
          n = Integer.parseInt(localNumberFormatException4);
          continue;
          localNumberFormatException7 = localNumberFormatException4;
          localObject11 = localNumberFormatException4;
          localObject3 = localNumberFormatException7;
          continue;
        }
        try
        {
          n = ((String)localObject1).indexOf(',');
          if (n == -1) {
            break label2206;
          }
          localObject11 = ((String)localObject1).substring(0, n);
          localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
          n = Integer.parseInt((String)localObject11);
          if (n == 0) {
            break label2816;
          }
          n = ((String)localObject1).indexOf(',');
          if (n == -1) {
            break label2216;
          }
          localObject11 = ((String)localObject1).substring(0, n);
          localObject1 = ((String)localObject1).substring(n + 1, ((String)localObject1).length());
          n = Color.parseColor((String)localObject11);
          localArrayList.add(new MessageForGrayTips.HightlightItem(i, j, l, m, i2, (String)localObject7, (String)localObject9, (String)localObject5, (String)localObject8, n, (String)localObject10, k));
          i1 += 1;
        }
        catch (NumberFormatException localNumberFormatException5)
        {
          if (!QLog.isColorLevel()) {
            break label1155;
          }
          QLog.e("MessageForGrayTips", 2, "parse gray tips hasColor failed. msg:" + this.msg + "exception:" + localNumberFormatException5.getStackTrace());
          break label1155;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (!QLog.isColorLevel()) {
            break label1155;
          }
          QLog.e("MessageForGrayTips", 2, "parse gray tips text color failed. msg:" + this.msg + "exception:" + localIllegalArgumentException.getStackTrace());
          break label1155;
          i += 1;
          break label1158;
          localObject6 = "";
          localObject8 = (TroopManager)paramQQAppInterface.getManager(52);
          localObject9 = localArrayList.iterator();
          i = 0;
          localObject4 = str2;
          if (!((Iterator)localObject9).hasNext()) {
            break label2651;
          }
          localObject10 = (MessageForGrayTips.HightlightItem)((Iterator)localObject9).next();
          localObject11 = (String)localObject6 + ((String)localObject4).substring(0, ((MessageForGrayTips.HightlightItem)localObject10).start - i);
          localObject6 = ((String)localObject4).substring(((MessageForGrayTips.HightlightItem)localObject10).start - i, ((MessageForGrayTips.HightlightItem)localObject10).end - i);
          localObject7 = ((String)localObject4).substring(((MessageForGrayTips.HightlightItem)localObject10).end - i, ((String)localObject4).length());
          i = ((MessageForGrayTips.HightlightItem)localObject10).end;
          ((MessageForGrayTips.HightlightItem)localObject10).start = ((String)localObject11).length();
          if (!((MessageForGrayTips.HightlightItem)localObject10).needUpdateNick) {
            break label2626;
          }
          localObject4 = ((TroopManager)localObject8).b(this.frienduin, "" + ((MessageForGrayTips.HightlightItem)localObject10).uin);
          if ((localObject4 == null) || (!((String)localObject4).equals(((MessageForGrayTips.HightlightItem)localObject10).uin + "")) || (TextUtils.isEmpty((CharSequence)localObject6))) {
            break;
          }
          localObject4 = localObject6;
          for (localObject4 = (String)localObject11 + (String)localObject4;; localObject4 = (String)localObject11 + (String)localObject6)
          {
            ((MessageForGrayTips.HightlightItem)localObject10).end = ((String)localObject4).length();
            localObject6 = localObject4;
            localObject4 = localObject7;
            break;
          }
          localObject4 = new SpannableStringBuilder((String)localObject6 + (String)localObject4);
          localObject6 = localArrayList.iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject7 = (MessageForGrayTips.HightlightItem)((Iterator)localObject6).next();
            if (localObject7 != null) {
              if (TextUtils.isEmpty(((MessageForGrayTips.HightlightItem)localObject7).icon)) {
                ((SpannableStringBuilder)localObject4).setSpan(new MessageForGrayTips.HightlightClickableSpan(paramQQAppInterface, ((MessageForGrayTips.HightlightItem)localObject7).textColor, paramContext, (MessageForGrayTips.HightlightItem)localObject7, this), ((MessageForGrayTips.HightlightItem)localObject7).start, ((MessageForGrayTips.HightlightItem)localObject7).end, 33);
              } else {
                decodeImageSpan(paramContext, (SpannableStringBuilder)localObject4, (MessageForGrayTips.HightlightItem)localObject7, paramBoolean, paramCallback);
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label2810;
          }
          QLog.i(".troop.send_gift", 2, "revoke msg MessageForGrayTips.getHightlightMsgText:" + localObject4);
          return localObject4;
        }
      }
      k = 1;
      break label259;
      j = Integer.parseInt((String)localObject1);
      continue;
      label1155:
      i = 0;
      label1158:
      if (i < localArrayList.size() - 1)
      {
        j = i + 1;
        for (;;)
        {
          for (;;)
          {
            if (j >= localArrayList.size()) {
              break label2339;
            }
            if (((MessageForGrayTips.HightlightItem)localArrayList.get(i)).start > ((MessageForGrayTips.HightlightItem)localArrayList.get(j)).start)
            {
              localObject2 = (MessageForGrayTips.HightlightItem)localArrayList.get(i);
              localArrayList.add(i, localArrayList.get(j));
              localArrayList.add(j, localObject2);
            }
            j += 1;
            continue;
            n = -1;
            Object localObject2 = localObject5;
            localObject5 = "";
            m = k;
            k = n;
            break;
            try
            {
              k = ((String)localObject5).indexOf(',');
              localObject8 = ((String)localObject5).substring(0, k);
              localObject2 = ((String)localObject5).substring(k + 1, ((String)localObject5).length());
              m = Integer.parseInt((String)localObject8);
              k = ((String)localObject2).indexOf(',');
              if (k == -1) {
                break label2882;
              }
              localObject5 = ((String)localObject2).substring(0, k);
              localObject2 = ((String)localObject2).substring(k + 1, ((String)localObject2).length());
              k = -1;
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              QLog.d("MessageForGrayTips", 2, "getHightlightMsgText==> decodeMagicString error.msg:" + this.msg, localNumberFormatException2);
            }
          }
          m = ((String)localObject5).indexOf(',');
          if (m == -1) {
            break label2892;
          }
          localObject8 = ((String)localObject5).substring(0, m);
          localObject2 = ((String)localObject5).substring(m + 1, ((String)localObject5).length());
          n = -1;
          localObject5 = localObject8;
          m = k;
          k = n;
          break;
          m = ((String)localObject5).indexOf(',');
          localObject2 = localObject5;
          localObject7 = localObject8;
          if (m != -1)
          {
            localObject7 = ((String)localObject5).substring(0, m);
            localObject2 = ((String)localObject5).substring(m + 1, ((String)localObject5).length());
          }
          m = ((String)localObject2).indexOf(',');
          if (m == -1) {
            break label2910;
          }
          localObject9 = ((String)localObject2).substring(0, m);
          localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
          n = -1;
          localObject5 = "";
          m = k;
          k = n;
          break;
          localObject7 = ((String)localObject5).substring(((String)localObject5).indexOf("{"), ((String)localObject5).indexOf("}") + 1);
          n = -1;
          localObject2 = localObject5;
          localObject5 = "";
          m = k;
          k = n;
          break;
          m = ((String)localObject5).indexOf(',');
          if (m == -1) {
            break label2860;
          }
          localObject10 = ((String)localObject5).substring(0, m);
          localObject2 = ((String)localObject5).substring(m + 1, ((String)localObject5).length());
          n = -1;
          localObject5 = "";
          m = k;
          k = n;
          break;
          m = ((String)localObject5).indexOf(',');
          if (m == -1) {
            break label2860;
          }
          localObject8 = ((String)localObject5).substring(0, m);
          localObject2 = ((String)localObject5).substring(m + 1, ((String)localObject5).length());
        }
      }
      for (;;)
      {
        try
        {
          m = Integer.parseInt((String)localObject8);
          n = m;
          localObject5 = "";
          m = k;
          k = n;
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          if (!QLog.isColorLevel()) {
            break label2932;
          }
        }
        QLog.e("MessageForGrayTips", 2, "parse group id ==>NumberFormatException");
        break label2932;
        m = localNumberFormatException6.indexOf(',');
        if (m != -1)
        {
          localObject7 = localNumberFormatException6.substring(0, m);
          localObject2 = localNumberFormatException6.substring(m + 1, localNumberFormatException6.length());
          n = -1;
          localObject6 = "";
          m = k;
          k = n;
          break;
          m = ((String)localObject6).indexOf(',');
          if (m != -1)
          {
            localObject7 = ((String)localObject6).substring(0, m);
            localObject2 = ((String)localObject6).substring(m + 1, ((String)localObject6).length());
            n = -1;
            localObject6 = "";
            m = k;
            k = n;
            break;
            i = ((String)localObject6).indexOf(',');
            localObject2 = ((String)localObject6).substring(0, i);
            localObject6 = ((String)localObject6).substring(i + 1, ((String)localObject6).length());
            j = Integer.parseInt((String)localObject2);
            i = ((String)localObject6).indexOf(',');
            localObject2 = ((String)localObject6).substring(0, i);
            localObject6 = ((String)localObject6).substring(i + 1, ((String)localObject6).length());
            i = Integer.parseInt((String)localObject2);
            k = ((String)localObject6).indexOf(',');
            localObject8 = ((String)localObject6).substring(0, k);
            localObject2 = ((String)localObject6).substring(k + 1, ((String)localObject6).length());
            m = Integer.parseInt((String)localObject8);
            k = ((String)localObject2).indexOf(',');
            if (k != -1)
            {
              localObject6 = ((String)localObject2).substring(0, k);
              localObject2 = ((String)localObject2).substring(k + 1, ((String)localObject2).length());
              n = -1;
              k = i;
              i = j;
              j = k;
              k = n;
              break;
            }
            n = -1;
            localObject6 = localObject2;
            k = i;
            i = j;
            j = k;
            k = n;
            break;
            break label1155;
            label2129:
            label2139:
            label2146:
            NumberFormatException localNumberFormatException7;
            label2206:
            label2216:
            Object localObject3;
            label2339:
            label2626:
            label2651:
            label2810:
            for (;;) {}
            label2816:
            n = -12541697;
            break label1060;
            label2824:
            n = -12541697;
            break label1060;
            label2832:
            n = 0;
            break label946;
            label2838:
            localObject8 = null;
            localObject6 = "";
            break label895;
            label2848:
            n = 0;
            break label674;
            label2854:
            l = 0L;
            break label623;
          }
        }
        label2860:
        n = -1;
        localObject4 = localObject6;
        localObject6 = "";
        m = k;
        k = n;
        break;
        label2882:
        k = -1;
        localObject6 = localObject4;
        break;
        label2892:
        n = -1;
        localObject4 = localObject6;
        m = k;
        k = n;
        break;
        label2910:
        n = -1;
        localObject9 = localObject4;
        localObject6 = "";
        m = k;
        k = n;
        break;
        label2932:
        m = -1;
      }
      label2938:
      localObject8 = localObject4;
      Object localObject6 = localObject4;
      Object localObject4 = localObject8;
      continue;
      label2953:
      localObject8 = null;
      localObject6 = localObject4;
      localObject4 = localObject8;
    }
  }
  
  public int getTextGravity()
  {
    String str = getExtInfoFromExtStr("textGravity");
    int i = 19;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 19;
  }
  
  public boolean isSupportColor()
  {
    return false;
  }
  
  public boolean isSupportImage()
  {
    return false;
  }
  
  public void setTextGravity(int paramInt)
  {
    saveExtInfoToExtStr("textGravity", "" + paramInt);
  }
  
  public void switch2HightlightMsg() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips
 * JD-Core Version:    0.7.0.1
 */