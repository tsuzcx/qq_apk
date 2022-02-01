package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.UrlBottomImageSpan;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
  
  public static void decodeImageSpan(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder, GrayTipsMessageConstants.HighlightItem paramHighlightItem, boolean paramBoolean, Drawable.Callback paramCallback, MessageRecord paramMessageRecord)
  {
    String str = paramHighlightItem.icon;
    Bitmap localBitmap = paramHighlightItem.mBitmap;
    if (localBitmap != null)
    {
      paramSpannableStringBuilder.setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, localBitmap), paramHighlightItem.start, paramHighlightItem.end, 33);
      if (QLog.isColorLevel()) {
        QLog.d("MessageForGrayTips", 2, new Object[] { "MessageForGrayTips.getHightlightMsgText, bitmap size: ", Integer.valueOf(localBitmap.getHeight() * localBitmap.getWidth()) });
      }
    }
    else if ((!str.startsWith("http://")) && (!str.startsWith("https://")))
    {
      if (MutualMarkUtils.c(str))
      {
        paramMessageRecord = MutualMarkUtils.d(str);
        if (!TextUtils.isEmpty(paramMessageRecord))
        {
          if (paramBoolean) {
            paramContext = new UrlBottomImageSpan(paramContext, 0, paramMessageRecord, ViewUtils.dpToPx(16.0F), paramCallback);
          } else {
            paramContext = new UrlBottomImageSpan(paramContext, 0, paramMessageRecord, paramCallback);
          }
          paramSpannableStringBuilder.setSpan(paramContext, paramHighlightItem.start, paramHighlightItem.end, 33);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("decodeImageSpan isMutualMarkImageUrlTemplate Url Image=");
            paramContext.append(paramMessageRecord);
            QLog.i("MessageForGrayTips", 2, paramContext.toString());
          }
        }
      }
      else
      {
        int i = str.indexOf('.');
        paramCallback = str;
        if (i != -1) {
          paramCallback = str.substring(0, i);
        }
        if (MutualMarkUtils.b.containsKey(paramCallback)) {
          i = ((Integer)MutualMarkUtils.b.get(paramCallback)).intValue();
        } else {
          i = paramContext.getResources().getIdentifier(paramCallback, "drawable", paramContext.getPackageName());
        }
        if (i != 0) {
          if (paramBoolean) {
            paramSpannableStringBuilder.setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, i, paramHighlightItem.getIconSize()), paramHighlightItem.start, paramHighlightItem.end, 33);
          } else {
            paramSpannableStringBuilder.setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, i), paramHighlightItem.start, paramHighlightItem.end, 33);
          }
        }
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("MessageForGrayTips.getHightlightMsgText Image=");
          paramContext.append(paramCallback);
          paramContext.append(" resourceId:");
          paramContext.append(i);
          QLog.i("MessageForGrayTips", 2, paramContext.toString());
        }
      }
    }
    else
    {
      if (paramBoolean)
      {
        paramContext = new MessageForGrayTips.UrlCenterImageSpan(paramContext, 0, str, 32);
        paramContext.a(paramCallback);
        paramSpannableStringBuilder.setSpan(paramContext, paramHighlightItem.start, paramHighlightItem.end, 33);
      }
      else
      {
        paramContext = new MessageForGrayTips.UrlCenterImageSpan(paramContext, 0, str);
        paramContext.a(paramCallback);
        paramContext.a(paramMessageRecord);
        paramSpannableStringBuilder.setSpan(paramContext, paramHighlightItem.start, paramHighlightItem.end, 33);
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("MessageForGrayTips.getHightlightMsgText Url Image=");
        paramContext.append(str);
        QLog.i("MessageForGrayTips", 2, paramContext.toString());
      }
    }
  }
  
  public static String getOrginMsg(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.indexOf("                    ##**##");
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  public void addHightlightItem(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 >= paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageForGrayTips", 2, "revoke msg addHightlightItem start >= end error");
      }
      return;
    }
    saveExtInfoToExtStr("new_item_tag", Boolean.TRUE.toString());
    Object localObject2;
    Object localObject1;
    Object localObject4;
    int i;
    Object localObject3;
    if (paramBundle == null)
    {
      localObject2 = null;
      localObject1 = localObject2;
      localObject4 = localObject1;
      i = -1;
      localObject3 = localObject1;
      localObject1 = localObject4;
    }
    for (;;)
    {
      try
      {
        i = paramBundle.getInt("key_action");
        localObject2 = paramBundle.getString("textColor");
        localObject3 = paramBundle.getString("image_resource");
        localObject1 = paramBundle.getString("image_alt");
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("addHightlightItem ==>actionType:");
          ((StringBuilder)localObject4).append(i);
          QLog.d("MessageForGrayTips", 2, ((StringBuilder)localObject4).toString());
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(paramInt1);
        ((StringBuilder)localObject4).append(",");
        ((StringBuilder)localObject4).append(paramInt2);
        localObject4 = ((StringBuilder)localObject4).toString();
        if ((i != 1) && (i != 2) && (i != 3)) {
          if (i != 5) {
            if (i != 26)
            {
              if (i == 28) {
                continue;
              }
              if (i == 43) {}
            }
          }
        }
        Object localObject5;
        switch (i)
        {
        default: 
          switch (i)
          {
          default: 
            paramBundle = (Bundle)localObject4;
            break;
          case 20: 
            paramBundle = paramBundle.getString("key_action_DATA");
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append((String)localObject4);
            ((StringBuilder)localObject5).append(",");
            ((StringBuilder)localObject5).append(paramBundle);
            paramBundle = ((StringBuilder)localObject5).toString();
            break;
          case 19: 
            paramBundle = paramBundle.getString("troop_mem_uin");
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append((String)localObject4);
            ((StringBuilder)localObject5).append(",");
            ((StringBuilder)localObject5).append(paramBundle);
            paramBundle = ((StringBuilder)localObject5).toString();
            break;
          case 18: 
            paramBundle = paramBundle.getString("key_action_DATA");
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append((String)localObject4);
            ((StringBuilder)localObject5).append(",");
            ((StringBuilder)localObject5).append(paramBundle);
            paramBundle = ((StringBuilder)localObject5).toString();
          }
          break;
        case 14: 
          paramInt1 = paramBundle.getInt("group_id", -1);
          paramBundle = new StringBuilder();
          paramBundle.append((String)localObject4);
          paramBundle.append(",");
          paramBundle.append(paramInt1);
          paramBundle = paramBundle.toString();
          break;
        case 13: 
          localObject5 = paramBundle.getString("remark");
          paramBundle = (Bundle)localObject5;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            paramBundle = "";
          }
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject4);
          ((StringBuilder)localObject5).append(",");
          ((StringBuilder)localObject5).append(paramBundle);
          paramBundle = ((StringBuilder)localObject5).toString();
          continue;
          paramBundle = paramBundle.getString("key_action_DATA");
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append((String)localObject4);
          ((StringBuilder)localObject5).append(",");
          ((StringBuilder)localObject5).append(paramBundle);
          paramBundle = ((StringBuilder)localObject5).toString();
          continue;
          localObject5 = paramBundle.getString("troop_mem_uin");
          if (!paramBundle.getBoolean("need_update_nick")) {
            break label1338;
          }
          paramInt1 = 1;
          paramBundle = new StringBuilder();
          paramBundle.append((String)localObject4);
          paramBundle.append(",");
          paramBundle.append(paramInt1);
          paramBundle.append(",");
          paramBundle.append((String)localObject5);
          paramBundle = paramBundle.toString();
          break;
        case 15: 
          localObject5 = paramBundle.getString("key_action_DATA");
          paramBundle = paramBundle.getString("key_a_action_DATA");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject4);
          localStringBuilder.append(",");
          localStringBuilder.append((String)localObject5);
          localStringBuilder.append(",");
          localStringBuilder.append(paramBundle);
          paramBundle = localStringBuilder.toString();
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(paramBundle);
        ((StringBuilder)localObject4).append(",icon");
        paramBundle = ((StringBuilder)localObject4).toString();
        if (localObject3 != null)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramBundle);
          ((StringBuilder)localObject4).append(",1,");
          ((StringBuilder)localObject4).append((String)localObject3);
          paramBundle = ((StringBuilder)localObject4).toString();
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramBundle);
          ((StringBuilder)localObject3).append(",0");
          paramBundle = ((StringBuilder)localObject3).toString();
        }
        if (localObject1 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramBundle);
          ((StringBuilder)localObject3).append(",1,");
          ((StringBuilder)localObject3).append((String)localObject1);
          paramBundle = ((StringBuilder)localObject3).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramBundle);
          ((StringBuilder)localObject1).append(",0");
          paramBundle = ((StringBuilder)localObject1).toString();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramBundle);
        ((StringBuilder)localObject1).append(",color");
        paramBundle = ((StringBuilder)localObject1).toString();
        if (localObject2 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramBundle);
          ((StringBuilder)localObject1).append(",1,");
          ((StringBuilder)localObject1).append((String)localObject2);
          paramBundle = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramBundle);
          ((StringBuilder)localObject1).append(",0");
          paramBundle = ((StringBuilder)localObject1).toString();
        }
        paramInt1 = this.msg.indexOf("                    ##**##");
        if (paramInt1 == -1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.msg);
          ((StringBuilder)localObject1).append("                    ##**##");
          ((StringBuilder)localObject1).append("1");
          ((StringBuilder)localObject1).append(paramBundle);
          this.msg = ((StringBuilder)localObject1).toString();
          return;
        }
        localObject1 = this.msg.substring(0, paramInt1);
        localObject3 = this.msg.substring(paramInt1 + 26, this.msg.length());
        paramInt1 = ((String)localObject3).indexOf(',');
        localObject2 = ((String)localObject3).substring(0, paramInt1);
        localObject3 = ((String)localObject3).substring(paramInt1, ((String)localObject3).length());
        paramInt1 = Integer.parseInt((String)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt1 + 1);
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append(paramBundle);
        paramBundle = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("                    ##**##");
        ((StringBuilder)localObject2).append(paramBundle);
        this.msg = ((StringBuilder)localObject2).toString();
        if ((QLog.isColorLevel()) && ((this instanceof MessageForDeliverGiftTips)))
        {
          paramBundle = new StringBuilder();
          paramBundle.append("MessageForGrayTips.addHightlightItem:");
          paramBundle.append(this.msg);
          QLog.i(".troop.send_gift", 2, paramBundle.toString());
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      return;
      label1338:
      paramInt1 = 0;
    }
  }
  
  public boolean checkAbillity(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return false;
      }
      return isSupportColor();
    }
    return isSupportImage();
  }
  
  protected void doParse() {}
  
  public SpannableStringBuilder getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean, Drawable.Callback paramCallback)
  {
    try
    {
      if (this.extStr == null) {
        break label43;
      }
      bool = new JSONObject(this.extStr).getBoolean("new_item_tag");
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        boolean bool;
        label43:
        Object localObject1;
        Object localObject11;
        Object localObject4;
        int i4;
        ArrayList localArrayList;
        int i1;
        int k;
        label998:
        label1388:
        continue;
        label1358:
        localObject5 = localNumberFormatException4;
        label2185:
        label2858:
        continue;
        label2865:
        m = i;
        int i = j;
        int j = m;
        continue;
        label2880:
        m = i;
        i = j;
        localObject5 = localNumberFormatException4;
        j = m;
        continue;
        label2899:
        localObject7 = null;
        localObject6 = localObject5;
        break label2958;
        label2909:
        m = -1;
        n = i;
        i = j;
        localObject5 = "";
        localObject6 = null;
        localObject7 = null;
        localObject8 = null;
        j = n;
        continue;
        label2941:
        continue;
        label2944:
        localObject5 = null;
        continue;
        label2950:
        localObject7 = localNumberFormatException4;
        localObject6 = localObject5;
        label2958:
        localObject8 = null;
        label2961:
        n = -1;
        m = i;
        i = j;
        localObject5 = "";
        j = m;
        m = n;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageForGrayTips", 2, "revoke msg getHightlightMsgText JSONException");
    }
    bool = false;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("revoke msg getHightlightMsgText==> isNewHighlitItem:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("MessageForGrayTips", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.msg;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      i = ((String)localObject1).indexOf("                    ##**##");
    } else {
      i = -1;
    }
    if (i == -1) {
      return new SpannableStringBuilder((CharSequence)localObject1);
    }
    localObject11 = this.msg.substring(0, i);
    localObject1 = this.msg.substring(i + 26, this.msg.length());
    i = ((String)localObject1).indexOf(',');
    localObject4 = ((String)localObject1).substring(0, i);
    localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
    i4 = Integer.parseInt((String)localObject4);
    new LinkedList();
    localArrayList = new ArrayList(i4);
    i1 = 0;
    for (;;)
    {
      if (i1 >= i4) {
        break label2185;
      }
      if (bool) {
        k = 0;
      } else {
        k = 1;
      }
      int i3 = -12541697;
      int i2;
      if (bool)
      {
        try
        {
          i = ((String)localObject1).indexOf(',');
          localObject4 = ((String)localObject1).substring(0, i);
          localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
          i2 = Integer.parseInt((String)localObject4);
          i = ((String)localObject1).indexOf(',');
          localObject4 = ((String)localObject1).substring(0, i);
          localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
          j = Integer.parseInt((String)localObject4);
          i = ((String)localObject1).indexOf(',');
          if (i != -1)
          {
            localObject4 = ((String)localObject1).substring(0, i);
            localObject1 = ((String)localObject1).substring(i + 1, ((String)localObject1).length());
            i = Integer.parseInt((String)localObject4);
          }
          else
          {
            i = Integer.parseInt((String)localObject1);
          }
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("revoke msg getHightlightMsgText==> decodeMagicString error.msg:");
          ((StringBuilder)localObject4).append(MessageRecordUtil.a(this.msg));
          QLog.d("MessageForGrayTips", 1, ((StringBuilder)localObject4).toString(), localNumberFormatException1);
          break label2185;
        }
      }
      else
      {
        i = 0;
        i2 = -1;
        j = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("revoke msg getHightlightMsgText==> actionType:");
        ((StringBuilder)localObject4).append(i2);
        QLog.d("MessageForGrayTips", 2, ((StringBuilder)localObject4).toString());
      }
      if ((i2 != -1) && (i2 != 11)) {
        if (i2 != 26)
        {
          if (i2 == 28) {
            break label2941;
          }
          switch (i2)
          {
          default: 
            switch (i2)
            {
            default: 
              switch (i2)
              {
              default: 
                if (bool) {}
                break;
              }
              break;
            }
            break;
          }
        }
      }
      try
      {
        i = localNumberFormatException1.indexOf(',');
        localObject4 = localNumberFormatException1.substring(0, i);
        localObject2 = localNumberFormatException1.substring(i + 1, localNumberFormatException1.length());
        i = Integer.parseInt((String)localObject4);
        j = ((String)localObject2).indexOf(',');
        localObject4 = ((String)localObject2).substring(0, j);
        localObject2 = ((String)localObject2).substring(j + 1, ((String)localObject2).length());
        j = Integer.parseInt((String)localObject4);
        k = ((String)localObject2).indexOf(',');
        localObject4 = ((String)localObject2).substring(0, k);
        localObject2 = ((String)localObject2).substring(k + 1, ((String)localObject2).length());
        k = Integer.parseInt((String)localObject4);
        m = ((String)localObject2).indexOf(',');
        if (m == -1) {
          break label2858;
        }
        localObject4 = ((String)localObject2).substring(0, m);
        localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
      }
      catch (NumberFormatException localNumberFormatException6)
      {
        for (;;)
        {
          Object localObject2;
          int m;
          Object localObject6;
          Object localObject8;
          Object localObject7;
          int n;
          Object localObject5;
          continue;
          NumberFormatException localNumberFormatException7 = localNumberFormatException4;
          continue;
          Object localObject9 = localNumberFormatException4;
          continue;
          localObject9 = null;
          continue;
          localNumberFormatException7 = localNumberFormatException4;
        }
      }
      m = ((String)localObject2).indexOf(',');
      if (m == -1) {
        break label2880;
      }
      localObject4 = ((String)localObject2).substring(0, m);
      localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
      break label2865;
      m = ((String)localObject2).indexOf(',');
      if (m != -1)
      {
        localObject4 = ((String)localObject2).substring(0, m);
        localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
        break label2899;
        localObject6 = ((String)localObject2).substring(((String)localObject2).indexOf("{"), ((String)localObject2).indexOf("}") + 1);
        m = i;
        i = j;
        localObject4 = "";
        j = m;
        break label1358;
        m = ((String)localObject2).indexOf(',');
        if (m != -1)
        {
          localObject4 = ((String)localObject2).substring(0, m);
          localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
        }
      }
      try
      {
        m = Integer.parseInt((String)localObject4);
      }
      catch (NumberFormatException localNumberFormatException5)
      {
        long l;
        break label998;
      }
      if (!QLog.isColorLevel()) {
        break label2909;
      }
      QLog.e("MessageForGrayTips", 2, "parse group id ==>NumberFormatException");
      break label2909;
      m = ((String)localObject2).indexOf(',');
      if (m != -1)
      {
        localObject8 = ((String)localObject2).substring(0, m);
        localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
        localObject6 = null;
        localObject7 = null;
        break label2961;
        m = ((String)localObject2).indexOf(',');
        if (m == -1) {
          break label2944;
        }
        localObject4 = ((String)localObject2).substring(0, m);
        localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
        m = ((String)localObject2).indexOf(',');
        if (m == -1) {
          break label2950;
        }
        localObject7 = ((String)localObject2).substring(0, m);
        localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
        localObject8 = null;
        localObject6 = localObject4;
        break label2961;
        k = ((String)localObject2).indexOf(',');
        localObject4 = ((String)localObject2).substring(0, k);
        localObject2 = ((String)localObject2).substring(k + 1, ((String)localObject2).length());
        k = Integer.parseInt((String)localObject4);
        m = ((String)localObject2).indexOf(',');
        if (m == -1) {
          break label2993;
        }
        localObject4 = ((String)localObject2).substring(0, m);
        localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
        break label2865;
        m = ((String)localObject2).indexOf(',');
        if (m != -1)
        {
          localObject4 = ((String)localObject2).substring(0, m);
          localObject2 = ((String)localObject2).substring(m + 1, ((String)localObject2).length());
          break label2899;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getHightlightMsgText==> decodeMagicString error.msg:");
          ((StringBuilder)localObject2).append(MessageRecordUtil.a(this.msg));
          QLog.d("MessageForGrayTips", 1, ((StringBuilder)localObject2).toString(), (Throwable)localObject4);
          break label2185;
        }
      }
      m = j;
      localObject4 = "";
      j = i;
      i = m;
      localObject6 = null;
      localObject7 = null;
      localObject8 = null;
      m = -1;
      l = 0L;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {}
      try
      {
        l = Long.parseLong((String)localObject4);
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        Object localObject10;
        Object localObject3;
        break label1388;
      }
      if (!QLog.isColorLevel()) {
        break label2185;
      }
      QLog.e("MessageForGrayTips", 2, "getHightlightMsgText ==>NumberFormatException");
      break label2185;
      n = ((String)localObject2).indexOf(',');
      if ((n != -1) && ("icon".equals(((String)localObject2).substring(0, n))))
      {
        localObject2 = ((String)localObject2).substring(n + 1, ((String)localObject2).length());
        n = 1;
      }
      else
      {
        n = 0;
      }
      if ((!checkAbillity(1)) && (n == 0))
      {
        localObject9 = "";
        localObject10 = null;
      }
      try
      {
        n = ((String)localObject2).indexOf(',');
        if (n != -1)
        {
          localObject4 = ((String)localObject2).substring(0, n);
          localObject2 = ((String)localObject2).substring(n + 1, ((String)localObject2).length());
          n = Integer.parseInt((String)localObject4);
        }
        else
        {
          n = Integer.parseInt((String)localObject2);
        }
        if (n == 0) {
          break label3007;
        }
        n = ((String)localObject2).indexOf(',');
        if (n == -1) {
          break label3000;
        }
        localObject9 = ((String)localObject2).substring(0, n);
        localObject2 = ((String)localObject2).substring(n + 1, ((String)localObject2).length());
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        if (!QLog.isColorLevel()) {
          break label2185;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("parse gray tips image resource or alt failed. msg:");
        ((StringBuilder)localObject4).append(this.msg);
        ((StringBuilder)localObject4).append("exception:");
        ((StringBuilder)localObject4).append(localNumberFormatException3.getStackTrace());
        QLog.e("MessageForGrayTips", 2, ((StringBuilder)localObject4).toString());
      }
      n = ((String)localObject2).indexOf(',');
      if (n != -1)
      {
        localObject4 = ((String)localObject2).substring(0, n);
        localObject2 = ((String)localObject2).substring(n + 1, ((String)localObject2).length());
        n = Integer.parseInt((String)localObject4);
      }
      else
      {
        n = Integer.parseInt((String)localObject2);
      }
      if (n != 0)
      {
        n = ((String)localObject2).indexOf(',');
        if (n != -1)
        {
          localObject4 = ((String)localObject2).substring(0, n);
          localObject2 = ((String)localObject2).substring(n + 1, ((String)localObject2).length());
        }
        else
        {
          localObject4 = localObject2;
        }
      }
      else
      {
        localObject4 = null;
      }
      localObject10 = localObject4;
      n = ((String)localObject2).indexOf(',');
      if ((n != -1) && ("color".equals(((String)localObject2).substring(0, n))))
      {
        localObject2 = ((String)localObject2).substring(n + 1, ((String)localObject2).length());
        n = 1;
      }
      else
      {
        n = 0;
      }
      if ((!checkAbillity(2)) && (n == 0)) {
        n = -12541697;
      }
      try
      {
        n = ((String)localObject2).indexOf(',');
        if (n != -1)
        {
          localObject4 = ((String)localObject2).substring(0, n);
          localObject2 = ((String)localObject2).substring(n + 1, ((String)localObject2).length());
          n = Integer.parseInt((String)localObject4);
        }
        else
        {
          n = Integer.parseInt((String)localObject2);
        }
        if (n != 0)
        {
          n = ((String)localObject2).indexOf(',');
          if (n == -1) {
            break label3013;
          }
          localObject4 = ((String)localObject2).substring(0, n);
          String str = ((String)localObject2).substring(n + 1, ((String)localObject2).length());
          localObject2 = localObject4;
          localObject4 = str;
          n = Color.parseColor((String)localObject2);
          localObject2 = localObject4;
        }
        else
        {
          n = i3;
        }
        localArrayList.add(new GrayTipsMessageConstants.HighlightItem(i, j, l, k, i2, (String)localObject6, (String)localObject7, (String)localObject9, (String)localObject10, n, (String)localObject8, m));
        i1 += 1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (!QLog.isColorLevel()) {
          break label2185;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("parse gray tips text color failed. msg:");
        ((StringBuilder)localObject4).append(this.msg);
        ((StringBuilder)localObject4).append("exception:");
        ((StringBuilder)localObject4).append(localIllegalArgumentException.getStackTrace());
        QLog.e("MessageForGrayTips", 2, ((StringBuilder)localObject4).toString());
        break label2185;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        if (!QLog.isColorLevel()) {
          break label2185;
        }
      }
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("parse gray tips hasColor failed. msg:");
    ((StringBuilder)localObject4).append(this.msg);
    ((StringBuilder)localObject4).append("exception:");
    ((StringBuilder)localObject4).append(localNumberFormatException2.getStackTrace());
    QLog.e("MessageForGrayTips", 2, ((StringBuilder)localObject4).toString());
    for (i = 0; i < localArrayList.size() - 1; i = j)
    {
      j = i + 1;
      k = j;
      while (k < localArrayList.size())
      {
        if (((GrayTipsMessageConstants.HighlightItem)localArrayList.get(i)).start > ((GrayTipsMessageConstants.HighlightItem)localArrayList.get(k)).start)
        {
          localObject3 = (GrayTipsMessageConstants.HighlightItem)localArrayList.get(i);
          localArrayList.add(i, localArrayList.get(k));
          localArrayList.add(k, localObject3);
        }
        k += 1;
      }
    }
    localObject7 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    localObject8 = localArrayList.iterator();
    localObject4 = "";
    i = 0;
    for (localObject3 = localObject11; ((Iterator)localObject8).hasNext(); localObject3 = localObject6)
    {
      localObject9 = (GrayTipsMessageConstants.HighlightItem)((Iterator)localObject8).next();
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append((String)localObject4);
      ((StringBuilder)localObject6).append(((String)localObject3).substring(0, ((GrayTipsMessageConstants.HighlightItem)localObject9).start - i));
      localObject10 = ((StringBuilder)localObject6).toString();
      localObject4 = ((String)localObject3).substring(((GrayTipsMessageConstants.HighlightItem)localObject9).start - i, ((GrayTipsMessageConstants.HighlightItem)localObject9).end - i);
      localObject6 = ((String)localObject3).substring(((GrayTipsMessageConstants.HighlightItem)localObject9).end - i, ((String)localObject3).length());
      i = ((GrayTipsMessageConstants.HighlightItem)localObject9).end;
      ((GrayTipsMessageConstants.HighlightItem)localObject9).start = ((String)localObject10).length();
      if (((GrayTipsMessageConstants.HighlightItem)localObject9).needUpdateNick)
      {
        localObject3 = this.frienduin;
        localObject11 = new StringBuilder();
        ((StringBuilder)localObject11).append("");
        ((StringBuilder)localObject11).append(((GrayTipsMessageConstants.HighlightItem)localObject9).uin);
        localObject3 = ((TroopManager)localObject7).f((String)localObject3, ((StringBuilder)localObject11).toString());
        if (localObject3 != null)
        {
          localObject11 = new StringBuilder();
          ((StringBuilder)localObject11).append(((GrayTipsMessageConstants.HighlightItem)localObject9).uin);
          ((StringBuilder)localObject11).append("");
          if ((((String)localObject3).equals(((StringBuilder)localObject11).toString())) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
            localObject3 = localObject4;
          }
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append((String)localObject10);
        ((StringBuilder)localObject4).append((String)localObject3);
        localObject3 = ((StringBuilder)localObject4).toString();
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject10);
        ((StringBuilder)localObject3).append((String)localObject4);
        localObject3 = ((StringBuilder)localObject3).toString();
      }
      ((GrayTipsMessageConstants.HighlightItem)localObject9).end = ((String)localObject3).length();
      localObject4 = localObject3;
    }
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append((String)localObject4);
    ((StringBuilder)localObject6).append((String)localObject3);
    localObject3 = new SpannableStringBuilder(((StringBuilder)localObject6).toString());
    localObject4 = localArrayList.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject6 = (GrayTipsMessageConstants.HighlightItem)((Iterator)localObject4).next();
      if (localObject6 != null) {
        if (TextUtils.isEmpty(((GrayTipsMessageConstants.HighlightItem)localObject6).icon)) {
          ((SpannableStringBuilder)localObject3).setSpan(new MessageForGrayTips.HightlightClickableSpan(paramQQAppInterface, ((GrayTipsMessageConstants.HighlightItem)localObject6).textColor, paramContext, (GrayTipsMessageConstants.HighlightItem)localObject6, this), ((GrayTipsMessageConstants.HighlightItem)localObject6).start, ((GrayTipsMessageConstants.HighlightItem)localObject6).end, 33);
        } else {
          decodeImageSpan(paramContext, (SpannableStringBuilder)localObject3, (GrayTipsMessageConstants.HighlightItem)localObject6, paramBoolean, paramCallback, this);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("revoke msg MessageForGrayTips.getHightlightMsgText:");
      paramQQAppInterface.append(localObject3);
      QLog.i(".troop.send_gift", 2, paramQQAppInterface.toString());
    }
    return localObject3;
  }
  
  public int getTextGravity()
  {
    String str = getExtInfoFromExtStr("textGravity");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        int i = Integer.parseInt(str);
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    saveExtInfoToExtStr("textGravity", localStringBuilder.toString());
  }
  
  public void switch2HightlightMsg() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips
 * JD-Core Version:    0.7.0.1
 */