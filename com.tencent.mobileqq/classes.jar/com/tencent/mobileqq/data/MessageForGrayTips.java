package com.tencent.mobileqq.data;

import accd;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class MessageForGrayTips
  extends ChatMessage
{
  public static final int ABILITY_SUPPORT_COLOR = 2;
  public static final int ABILITY_SUPPORT_IMAGE = 1;
  private static final String KEY_NEW_HIGHTLIGHT_ITEM_TAG = "new_item_tag";
  private static final String TAG = "MessageForGrayTips";
  
  public static void decodeImageSpan(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder, MessageForGrayTips.HightlightItem paramHightlightItem)
  {
    if ((paramHightlightItem.icon.startsWith("http://")) || (paramHightlightItem.icon.startsWith("https://")))
    {
      paramSpannableStringBuilder.setSpan(new accd(paramContext, 0, paramHightlightItem.icon), paramHightlightItem.start, paramHightlightItem.end, 33);
      if (QLog.isColorLevel()) {
        QLog.i("MessageForGrayTips", 2, "MessageForGrayTips.getHightlightMsgText Url Image=" + paramHightlightItem.icon);
      }
      return;
    }
    int i = paramHightlightItem.icon.indexOf('.');
    if (i != -1) {}
    for (String str = paramHightlightItem.icon.substring(0, i);; str = paramHightlightItem.icon)
    {
      i = paramContext.getResources().getIdentifier(str, "drawable", paramContext.getPackageName());
      if (i != 0) {
        paramSpannableStringBuilder.setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, i), paramHightlightItem.start, paramHightlightItem.end, 33);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("MessageForGrayTips", 2, "MessageForGrayTips.getHightlightMsgText Image=" + str + " resourceId:" + i);
      return;
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
            break label750;
          }
          paramBundle = paramBundle + ",1," + str3;
          if (str2 == null) {
            break label773;
          }
          paramBundle = paramBundle + ",1," + str2;
          paramBundle = paramBundle + ",color";
          if (str1 == null) {
            break label796;
          }
          paramBundle = paramBundle + ",1," + str1;
          paramInt1 = this.msg.indexOf("                    ##**##");
          if (paramInt1 != -1) {
            break label819;
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
      label750:
      paramBundle = paramBundle + ",0";
      continue;
      label773:
      paramBundle = paramBundle + ",0";
      continue;
      label796:
      paramBundle = paramBundle + ",0";
      continue;
      label819:
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
  
  /* Error */
  public SpannableStringBuilder getHightlightMsgText(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 13
    //   3: iload 13
    //   5: istore 12
    //   7: aload_0
    //   8: getfield 242	com/tencent/mobileqq/data/MessageForGrayTips:extStr	Ljava/lang/String;
    //   11: ifnull +21 -> 32
    //   14: new 244	org/json/JSONObject
    //   17: dup
    //   18: aload_0
    //   19: getfield 242	com/tencent/mobileqq/data/MessageForGrayTips:extStr	Ljava/lang/String;
    //   22: invokespecial 247	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   25: ldc 13
    //   27: invokevirtual 248	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   30: istore 12
    //   32: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +29 -> 64
    //   38: ldc 16
    //   40: iconst_2
    //   41: new 63	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   48: ldc 250
    //   50: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload 12
    //   55: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_0
    //   65: getfield 158	com/tencent/mobileqq/data/MessageForGrayTips:msg	Ljava/lang/String;
    //   68: astore 16
    //   70: iconst_m1
    //   71: istore_3
    //   72: aload 16
    //   74: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne +11 -> 88
    //   80: aload 16
    //   82: ldc 119
    //   84: invokevirtual 122	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   87: istore_3
    //   88: iload_3
    //   89: iconst_m1
    //   90: if_icmpne +41 -> 131
    //   93: new 51	android/text/SpannableStringBuilder
    //   96: dup
    //   97: aload 16
    //   99: invokespecial 256	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   102: areturn
    //   103: astore 16
    //   105: iload 13
    //   107: istore 12
    //   109: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq -80 -> 32
    //   115: ldc 16
    //   117: iconst_2
    //   118: ldc_w 258
    //   121: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: iload 13
    //   126: istore 12
    //   128: goto -96 -> 32
    //   131: aload_0
    //   132: getfield 158	com/tencent/mobileqq/data/MessageForGrayTips:msg	Ljava/lang/String;
    //   135: iconst_0
    //   136: iload_3
    //   137: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   140: astore 24
    //   142: aload_0
    //   143: getfield 158	com/tencent/mobileqq/data/MessageForGrayTips:msg	Ljava/lang/String;
    //   146: iload_3
    //   147: ldc 119
    //   149: invokevirtual 211	java/lang/String:length	()I
    //   152: iadd
    //   153: aload_0
    //   154: getfield 158	com/tencent/mobileqq/data/MessageForGrayTips:msg	Ljava/lang/String;
    //   157: invokevirtual 211	java/lang/String:length	()I
    //   160: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   163: astore 16
    //   165: aload 16
    //   167: bipush 44
    //   169: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   172: istore_3
    //   173: aload 16
    //   175: iconst_0
    //   176: iload_3
    //   177: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   180: astore 17
    //   182: aload 16
    //   184: iload_3
    //   185: iconst_1
    //   186: iadd
    //   187: aload 16
    //   189: invokevirtual 211	java/lang/String:length	()I
    //   192: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   195: astore 16
    //   197: aload 17
    //   199: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   202: istore 11
    //   204: new 260	java/util/LinkedList
    //   207: dup
    //   208: invokespecial 261	java/util/LinkedList:<init>	()V
    //   211: pop
    //   212: new 263	java/util/ArrayList
    //   215: dup
    //   216: iload 11
    //   218: invokespecial 266	java/util/ArrayList:<init>	(I)V
    //   221: astore 25
    //   223: iconst_0
    //   224: istore 8
    //   226: iload 8
    //   228: iload 11
    //   230: if_icmpge +916 -> 1146
    //   233: iconst_m1
    //   234: istore 9
    //   236: iconst_0
    //   237: istore_3
    //   238: iconst_0
    //   239: istore 4
    //   241: iload 12
    //   243: ifeq +854 -> 1097
    //   246: iconst_0
    //   247: istore 5
    //   249: aconst_null
    //   250: astore 19
    //   252: aconst_null
    //   253: astore 18
    //   255: aconst_null
    //   256: astore 20
    //   258: aconst_null
    //   259: astore 21
    //   261: ldc_w 268
    //   264: invokestatic 273	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   267: istore 7
    //   269: aload 16
    //   271: astore 17
    //   273: iload 12
    //   275: ifeq +132 -> 407
    //   278: aload 16
    //   280: bipush 44
    //   282: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   285: istore_3
    //   286: aload 16
    //   288: iconst_0
    //   289: iload_3
    //   290: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   293: astore 17
    //   295: aload 16
    //   297: iload_3
    //   298: iconst_1
    //   299: iadd
    //   300: aload 16
    //   302: invokevirtual 211	java/lang/String:length	()I
    //   305: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   308: astore 16
    //   310: aload 17
    //   312: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   315: istore 9
    //   317: aload 16
    //   319: bipush 44
    //   321: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   324: istore_3
    //   325: aload 16
    //   327: iconst_0
    //   328: iload_3
    //   329: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   332: astore 17
    //   334: aload 16
    //   336: iload_3
    //   337: iconst_1
    //   338: iadd
    //   339: aload 16
    //   341: invokevirtual 211	java/lang/String:length	()I
    //   344: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   347: astore 16
    //   349: aload 17
    //   351: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   354: istore_3
    //   355: aload 16
    //   357: bipush 44
    //   359: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   362: istore 4
    //   364: iload 4
    //   366: iconst_m1
    //   367: if_icmpeq +736 -> 1103
    //   370: aload 16
    //   372: iconst_0
    //   373: iload 4
    //   375: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   378: astore 17
    //   380: aload 16
    //   382: iload 4
    //   384: iconst_1
    //   385: iadd
    //   386: aload 16
    //   388: invokevirtual 211	java/lang/String:length	()I
    //   391: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   394: astore 16
    //   396: aload 17
    //   398: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   401: istore 4
    //   403: aload 16
    //   405: astore 17
    //   407: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq +30 -> 440
    //   413: ldc 16
    //   415: iconst_2
    //   416: new 63	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   423: ldc_w 275
    //   426: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: iload 9
    //   431: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: iload 9
    //   442: tableswitch	default:+134 -> 576, -1:+802->1244, 0:+134->576, 1:+972->1414, 2:+972->1414, 3:+972->1414, 4:+802->1244, 5:+824->1266, 6:+802->1244, 7:+802->1244, 8:+134->576, 9:+134->576, 10:+134->576, 11:+802->1244, 12:+134->576, 13:+1127->1569, 14:+1186->1628, 15:+1080->1522, 16:+134->576, 17:+802->1244, 18:+1273->1715, 19:+913->1355, 20:+134->576, 21:+134->576, 22:+134->576, 23:+134->576, 24:+134->576, 25:+134->576, 26:+134->576, 27:+134->576, 28:+824->1266
    //   577: fconst_1
    //   578: ifeq +1196 -> 1774
    //   581: iconst_m1
    //   582: istore 10
    //   584: iload 5
    //   586: istore 6
    //   588: aload 17
    //   590: astore 16
    //   592: ldc 200
    //   594: astore 17
    //   596: iload 10
    //   598: istore 5
    //   600: aload 17
    //   602: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   605: ifne +2091 -> 2696
    //   608: aload 17
    //   610: invokestatic 281	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   613: lstore 14
    //   615: aload 16
    //   617: bipush 44
    //   619: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   622: istore 10
    //   624: iload 10
    //   626: iconst_m1
    //   627: if_icmpeq +2063 -> 2690
    //   630: ldc_w 282
    //   633: aload 16
    //   635: iconst_0
    //   636: iload 10
    //   638: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   641: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   644: ifeq +2046 -> 2690
    //   647: aload 16
    //   649: iload 10
    //   651: iconst_1
    //   652: iadd
    //   653: aload 16
    //   655: invokevirtual 211	java/lang/String:length	()I
    //   658: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   661: astore 16
    //   663: iconst_1
    //   664: istore 10
    //   666: aload_0
    //   667: iconst_1
    //   668: invokevirtual 288	com/tencent/mobileqq/data/MessageForGrayTips:checkAbillity	(I)Z
    //   671: ifne +8 -> 679
    //   674: iload 10
    //   676: ifeq +2004 -> 2680
    //   679: aload 16
    //   681: bipush 44
    //   683: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   686: istore 10
    //   688: iload 10
    //   690: iconst_m1
    //   691: if_icmpeq +1343 -> 2034
    //   694: aload 16
    //   696: iconst_0
    //   697: iload 10
    //   699: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   702: astore 17
    //   704: aload 16
    //   706: iload 10
    //   708: iconst_1
    //   709: iadd
    //   710: aload 16
    //   712: invokevirtual 211	java/lang/String:length	()I
    //   715: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   718: astore 16
    //   720: aload 17
    //   722: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   725: istore 10
    //   727: iload 10
    //   729: ifeq +2066 -> 2795
    //   732: aload 16
    //   734: bipush 44
    //   736: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   739: istore 10
    //   741: iload 10
    //   743: iconst_m1
    //   744: if_icmpeq +2036 -> 2780
    //   747: aload 16
    //   749: iconst_0
    //   750: iload 10
    //   752: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   755: astore 17
    //   757: aload 16
    //   759: iload 10
    //   761: iconst_1
    //   762: iadd
    //   763: aload 16
    //   765: invokevirtual 211	java/lang/String:length	()I
    //   768: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   771: astore 19
    //   773: aload 17
    //   775: astore 16
    //   777: aload 19
    //   779: astore 17
    //   781: aload 17
    //   783: bipush 44
    //   785: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   788: istore 10
    //   790: iload 10
    //   792: iconst_m1
    //   793: if_icmpeq +1251 -> 2044
    //   796: aload 17
    //   798: iconst_0
    //   799: iload 10
    //   801: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   804: astore 19
    //   806: aload 17
    //   808: iload 10
    //   810: iconst_1
    //   811: iadd
    //   812: aload 17
    //   814: invokevirtual 211	java/lang/String:length	()I
    //   817: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   820: astore 17
    //   822: aload 19
    //   824: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   827: istore 10
    //   829: iload 10
    //   831: ifeq +1230 -> 2061
    //   834: aload 17
    //   836: bipush 44
    //   838: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   841: istore 10
    //   843: iload 10
    //   845: iconst_m1
    //   846: if_icmpeq +1208 -> 2054
    //   849: aload 17
    //   851: iconst_0
    //   852: iload 10
    //   854: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   857: astore 19
    //   859: aload 17
    //   861: iload 10
    //   863: iconst_1
    //   864: iadd
    //   865: aload 17
    //   867: invokevirtual 211	java/lang/String:length	()I
    //   870: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   873: astore 17
    //   875: aload 17
    //   877: astore 22
    //   879: aload 16
    //   881: astore 17
    //   883: aload 22
    //   885: astore 16
    //   887: aload 16
    //   889: bipush 44
    //   891: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   894: istore 10
    //   896: iload 10
    //   898: iconst_m1
    //   899: if_icmpeq +1775 -> 2674
    //   902: ldc_w 290
    //   905: aload 16
    //   907: iconst_0
    //   908: iload 10
    //   910: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   913: invokevirtual 286	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   916: ifeq +1758 -> 2674
    //   919: aload 16
    //   921: iload 10
    //   923: iconst_1
    //   924: iadd
    //   925: aload 16
    //   927: invokevirtual 211	java/lang/String:length	()I
    //   930: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   933: astore 16
    //   935: iconst_1
    //   936: istore 10
    //   938: aload_0
    //   939: iconst_2
    //   940: invokevirtual 288	com/tencent/mobileqq/data/MessageForGrayTips:checkAbillity	(I)Z
    //   943: ifne +8 -> 951
    //   946: iload 10
    //   948: ifeq +1723 -> 2671
    //   951: aload 16
    //   953: bipush 44
    //   955: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   958: istore 10
    //   960: iload 10
    //   962: iconst_m1
    //   963: if_icmpeq +1158 -> 2121
    //   966: aload 16
    //   968: iconst_0
    //   969: iload 10
    //   971: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   974: astore 22
    //   976: aload 16
    //   978: iload 10
    //   980: iconst_1
    //   981: iadd
    //   982: aload 16
    //   984: invokevirtual 211	java/lang/String:length	()I
    //   987: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   990: astore 16
    //   992: aload 22
    //   994: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   997: istore 10
    //   999: iload 10
    //   1001: ifeq +1667 -> 2668
    //   1004: aload 16
    //   1006: bipush 44
    //   1008: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1011: istore 7
    //   1013: iload 7
    //   1015: iconst_m1
    //   1016: if_icmpeq +1115 -> 2131
    //   1019: aload 16
    //   1021: iconst_0
    //   1022: iload 7
    //   1024: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1027: astore 22
    //   1029: aload 16
    //   1031: iload 7
    //   1033: iconst_1
    //   1034: iadd
    //   1035: aload 16
    //   1037: invokevirtual 211	java/lang/String:length	()I
    //   1040: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1043: astore 16
    //   1045: aload 22
    //   1047: invokestatic 273	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   1050: istore 7
    //   1052: aload 25
    //   1054: new 25	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem
    //   1057: dup
    //   1058: iload_3
    //   1059: iload 4
    //   1061: lload 14
    //   1063: iload 6
    //   1065: iload 9
    //   1067: aload 18
    //   1069: aload 20
    //   1071: aload 17
    //   1073: aload 19
    //   1075: iload 7
    //   1077: aload 21
    //   1079: iload 5
    //   1081: invokespecial 293	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:<init>	(IIJIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V
    //   1084: invokevirtual 296	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1087: pop
    //   1088: iload 8
    //   1090: iconst_1
    //   1091: iadd
    //   1092: istore 8
    //   1094: goto -868 -> 226
    //   1097: iconst_1
    //   1098: istore 5
    //   1100: goto -851 -> 249
    //   1103: aload 16
    //   1105: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1108: istore 4
    //   1110: goto -707 -> 403
    //   1113: astore 16
    //   1115: ldc 16
    //   1117: iconst_2
    //   1118: new 63	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   1125: ldc_w 298
    //   1128: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: aload_0
    //   1132: getfield 158	com/tencent/mobileqq/data/MessageForGrayTips:msg	Ljava/lang/String;
    //   1135: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1141: aload 16
    //   1143: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1146: iconst_0
    //   1147: istore_3
    //   1148: iload_3
    //   1149: aload 25
    //   1151: invokevirtual 304	java/util/ArrayList:size	()I
    //   1154: iconst_1
    //   1155: isub
    //   1156: if_icmpge +1105 -> 2261
    //   1159: iload_3
    //   1160: iconst_1
    //   1161: iadd
    //   1162: istore 4
    //   1164: iload 4
    //   1166: aload 25
    //   1168: invokevirtual 304	java/util/ArrayList:size	()I
    //   1171: if_icmpge +1083 -> 2254
    //   1174: aload 25
    //   1176: iload_3
    //   1177: invokevirtual 308	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1180: checkcast 25	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem
    //   1183: getfield 46	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:start	I
    //   1186: aload 25
    //   1188: iload 4
    //   1190: invokevirtual 308	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1193: checkcast 25	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem
    //   1196: getfield 46	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:start	I
    //   1199: if_icmple +36 -> 1235
    //   1202: aload 25
    //   1204: iload_3
    //   1205: invokevirtual 308	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1208: checkcast 25	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem
    //   1211: astore 16
    //   1213: aload 25
    //   1215: iload_3
    //   1216: aload 25
    //   1218: iload 4
    //   1220: invokevirtual 308	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1223: invokevirtual 311	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   1226: aload 25
    //   1228: iload 4
    //   1230: aload 16
    //   1232: invokevirtual 311	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   1235: iload 4
    //   1237: iconst_1
    //   1238: iadd
    //   1239: istore 4
    //   1241: goto -77 -> 1164
    //   1244: iconst_m1
    //   1245: istore 10
    //   1247: aload 17
    //   1249: astore 16
    //   1251: ldc 200
    //   1253: astore 17
    //   1255: iload 5
    //   1257: istore 6
    //   1259: iload 10
    //   1261: istore 5
    //   1263: goto -663 -> 600
    //   1266: aload 17
    //   1268: bipush 44
    //   1270: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1273: istore 5
    //   1275: aload 17
    //   1277: iconst_0
    //   1278: iload 5
    //   1280: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1283: astore 19
    //   1285: aload 17
    //   1287: iload 5
    //   1289: iconst_1
    //   1290: iadd
    //   1291: aload 17
    //   1293: invokevirtual 211	java/lang/String:length	()I
    //   1296: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1299: astore 16
    //   1301: aload 19
    //   1303: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1306: istore 6
    //   1308: aload 16
    //   1310: bipush 44
    //   1312: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1315: istore 5
    //   1317: iload 5
    //   1319: iconst_m1
    //   1320: if_icmpeq +1404 -> 2724
    //   1323: aload 16
    //   1325: iconst_0
    //   1326: iload 5
    //   1328: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1331: astore 17
    //   1333: aload 16
    //   1335: iload 5
    //   1337: iconst_1
    //   1338: iadd
    //   1339: aload 16
    //   1341: invokevirtual 211	java/lang/String:length	()I
    //   1344: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1347: astore 16
    //   1349: iconst_m1
    //   1350: istore 5
    //   1352: goto -752 -> 600
    //   1355: aload 17
    //   1357: bipush 44
    //   1359: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1362: istore 6
    //   1364: iload 6
    //   1366: iconst_m1
    //   1367: if_icmpeq +1367 -> 2734
    //   1370: aload 17
    //   1372: iconst_0
    //   1373: iload 6
    //   1375: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1378: astore 19
    //   1380: aload 17
    //   1382: iload 6
    //   1384: iconst_1
    //   1385: iadd
    //   1386: aload 17
    //   1388: invokevirtual 211	java/lang/String:length	()I
    //   1391: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1394: astore 16
    //   1396: iconst_m1
    //   1397: istore 10
    //   1399: aload 19
    //   1401: astore 17
    //   1403: iload 5
    //   1405: istore 6
    //   1407: iload 10
    //   1409: istore 5
    //   1411: goto -811 -> 600
    //   1414: aload 17
    //   1416: bipush 44
    //   1418: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1421: istore 6
    //   1423: aload 17
    //   1425: astore 16
    //   1427: aload 19
    //   1429: astore 18
    //   1431: iload 6
    //   1433: iconst_m1
    //   1434: if_icmpeq +29 -> 1463
    //   1437: aload 17
    //   1439: iconst_0
    //   1440: iload 6
    //   1442: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1445: astore 18
    //   1447: aload 17
    //   1449: iload 6
    //   1451: iconst_1
    //   1452: iadd
    //   1453: aload 17
    //   1455: invokevirtual 211	java/lang/String:length	()I
    //   1458: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1461: astore 16
    //   1463: aload 16
    //   1465: bipush 44
    //   1467: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1470: istore 6
    //   1472: iload 6
    //   1474: iconst_m1
    //   1475: if_icmpeq +1277 -> 2752
    //   1478: aload 16
    //   1480: iconst_0
    //   1481: iload 6
    //   1483: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1486: astore 20
    //   1488: aload 16
    //   1490: iload 6
    //   1492: iconst_1
    //   1493: iadd
    //   1494: aload 16
    //   1496: invokevirtual 211	java/lang/String:length	()I
    //   1499: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1502: astore 16
    //   1504: iconst_m1
    //   1505: istore 10
    //   1507: ldc 200
    //   1509: astore 17
    //   1511: iload 5
    //   1513: istore 6
    //   1515: iload 10
    //   1517: istore 5
    //   1519: goto -919 -> 600
    //   1522: aload 17
    //   1524: aload 17
    //   1526: ldc_w 313
    //   1529: invokevirtual 122	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1532: aload 17
    //   1534: ldc_w 315
    //   1537: invokevirtual 122	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1540: iconst_1
    //   1541: iadd
    //   1542: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1545: astore 18
    //   1547: iconst_m1
    //   1548: istore 10
    //   1550: aload 17
    //   1552: astore 16
    //   1554: ldc 200
    //   1556: astore 17
    //   1558: iload 5
    //   1560: istore 6
    //   1562: iload 10
    //   1564: istore 5
    //   1566: goto -966 -> 600
    //   1569: aload 17
    //   1571: bipush 44
    //   1573: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1576: istore 6
    //   1578: iload 6
    //   1580: iconst_m1
    //   1581: if_icmpeq +1121 -> 2702
    //   1584: aload 17
    //   1586: iconst_0
    //   1587: iload 6
    //   1589: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1592: astore 21
    //   1594: aload 17
    //   1596: iload 6
    //   1598: iconst_1
    //   1599: iadd
    //   1600: aload 17
    //   1602: invokevirtual 211	java/lang/String:length	()I
    //   1605: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1608: astore 16
    //   1610: iconst_m1
    //   1611: istore 10
    //   1613: ldc 200
    //   1615: astore 17
    //   1617: iload 5
    //   1619: istore 6
    //   1621: iload 10
    //   1623: istore 5
    //   1625: goto -1025 -> 600
    //   1628: aload 17
    //   1630: bipush 44
    //   1632: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1635: istore 6
    //   1637: iload 6
    //   1639: iconst_m1
    //   1640: if_icmpeq +1062 -> 2702
    //   1643: aload 17
    //   1645: iconst_0
    //   1646: iload 6
    //   1648: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1651: astore 19
    //   1653: aload 17
    //   1655: iload 6
    //   1657: iconst_1
    //   1658: iadd
    //   1659: aload 17
    //   1661: invokevirtual 211	java/lang/String:length	()I
    //   1664: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1667: astore 16
    //   1669: aload 19
    //   1671: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1674: istore 6
    //   1676: iload 6
    //   1678: istore 10
    //   1680: ldc 200
    //   1682: astore 17
    //   1684: iload 5
    //   1686: istore 6
    //   1688: iload 10
    //   1690: istore 5
    //   1692: goto -1092 -> 600
    //   1695: astore 17
    //   1697: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1700: ifeq +1074 -> 2774
    //   1703: ldc 16
    //   1705: iconst_2
    //   1706: ldc_w 317
    //   1709: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1712: goto +1062 -> 2774
    //   1715: aload 17
    //   1717: bipush 44
    //   1719: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1722: istore 6
    //   1724: iload 6
    //   1726: iconst_m1
    //   1727: if_icmpeq +975 -> 2702
    //   1730: aload 17
    //   1732: iconst_0
    //   1733: iload 6
    //   1735: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1738: astore 18
    //   1740: aload 17
    //   1742: iload 6
    //   1744: iconst_1
    //   1745: iadd
    //   1746: aload 17
    //   1748: invokevirtual 211	java/lang/String:length	()I
    //   1751: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1754: astore 16
    //   1756: iconst_m1
    //   1757: istore 10
    //   1759: ldc 200
    //   1761: astore 17
    //   1763: iload 5
    //   1765: istore 6
    //   1767: iload 10
    //   1769: istore 5
    //   1771: goto -1171 -> 600
    //   1774: aload 17
    //   1776: bipush 44
    //   1778: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1781: istore_3
    //   1782: aload 17
    //   1784: iconst_0
    //   1785: iload_3
    //   1786: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1789: astore 16
    //   1791: aload 17
    //   1793: iload_3
    //   1794: iconst_1
    //   1795: iadd
    //   1796: aload 17
    //   1798: invokevirtual 211	java/lang/String:length	()I
    //   1801: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1804: astore 17
    //   1806: aload 16
    //   1808: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1811: istore 4
    //   1813: aload 17
    //   1815: bipush 44
    //   1817: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1820: istore_3
    //   1821: aload 17
    //   1823: iconst_0
    //   1824: iload_3
    //   1825: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1828: astore 16
    //   1830: aload 17
    //   1832: iload_3
    //   1833: iconst_1
    //   1834: iadd
    //   1835: aload 17
    //   1837: invokevirtual 211	java/lang/String:length	()I
    //   1840: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1843: astore 17
    //   1845: aload 16
    //   1847: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1850: istore_3
    //   1851: aload 17
    //   1853: bipush 44
    //   1855: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1858: istore 5
    //   1860: aload 17
    //   1862: iconst_0
    //   1863: iload 5
    //   1865: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1868: astore 19
    //   1870: aload 17
    //   1872: iload 5
    //   1874: iconst_1
    //   1875: iadd
    //   1876: aload 17
    //   1878: invokevirtual 211	java/lang/String:length	()I
    //   1881: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1884: astore 16
    //   1886: aload 19
    //   1888: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1891: istore 6
    //   1893: aload 16
    //   1895: bipush 44
    //   1897: invokevirtual 82	java/lang/String:indexOf	(I)I
    //   1900: istore 5
    //   1902: iload 5
    //   1904: iconst_m1
    //   1905: if_icmpeq +49 -> 1954
    //   1908: aload 16
    //   1910: iconst_0
    //   1911: iload 5
    //   1913: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1916: astore 17
    //   1918: aload 16
    //   1920: iload 5
    //   1922: iconst_1
    //   1923: iadd
    //   1924: aload 16
    //   1926: invokevirtual 211	java/lang/String:length	()I
    //   1929: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   1932: astore 16
    //   1934: iconst_m1
    //   1935: istore 10
    //   1937: iload_3
    //   1938: istore 5
    //   1940: iload 4
    //   1942: istore_3
    //   1943: iload 5
    //   1945: istore 4
    //   1947: iload 10
    //   1949: istore 5
    //   1951: goto -1351 -> 600
    //   1954: iconst_m1
    //   1955: istore 10
    //   1957: aload 16
    //   1959: astore 17
    //   1961: iload_3
    //   1962: istore 5
    //   1964: iload 4
    //   1966: istore_3
    //   1967: iload 5
    //   1969: istore 4
    //   1971: iload 10
    //   1973: istore 5
    //   1975: goto -1375 -> 600
    //   1978: astore 16
    //   1980: ldc 16
    //   1982: iconst_2
    //   1983: new 63	java/lang/StringBuilder
    //   1986: dup
    //   1987: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   1990: ldc_w 319
    //   1993: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1996: aload_0
    //   1997: getfield 158	com/tencent/mobileqq/data/MessageForGrayTips:msg	Ljava/lang/String;
    //   2000: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2003: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2006: aload 16
    //   2008: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2011: goto -865 -> 1146
    //   2014: astore 16
    //   2016: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2019: ifeq -873 -> 1146
    //   2022: ldc 16
    //   2024: iconst_2
    //   2025: ldc_w 321
    //   2028: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2031: goto -885 -> 1146
    //   2034: aload 16
    //   2036: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2039: istore 10
    //   2041: goto -1314 -> 727
    //   2044: aload 17
    //   2046: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2049: istore 10
    //   2051: goto -1222 -> 829
    //   2054: aload 17
    //   2056: astore 19
    //   2058: goto -1183 -> 875
    //   2061: aconst_null
    //   2062: astore 19
    //   2064: goto -1189 -> 875
    //   2067: astore 16
    //   2069: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2072: ifeq -926 -> 1146
    //   2075: ldc 16
    //   2077: iconst_2
    //   2078: new 63	java/lang/StringBuilder
    //   2081: dup
    //   2082: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2085: ldc_w 323
    //   2088: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: aload_0
    //   2092: getfield 158	com/tencent/mobileqq/data/MessageForGrayTips:msg	Ljava/lang/String;
    //   2095: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2098: ldc_w 325
    //   2101: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2104: aload 16
    //   2106: invokevirtual 329	java/lang/NumberFormatException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   2109: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2112: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2115: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2118: goto -972 -> 1146
    //   2121: aload 16
    //   2123: invokestatic 216	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2126: istore 10
    //   2128: goto -1129 -> 999
    //   2131: aload 16
    //   2133: astore 23
    //   2135: aload 16
    //   2137: astore 22
    //   2139: aload 23
    //   2141: astore 16
    //   2143: goto -1098 -> 1045
    //   2146: astore 16
    //   2148: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2151: ifeq -1005 -> 1146
    //   2154: ldc 16
    //   2156: iconst_2
    //   2157: new 63	java/lang/StringBuilder
    //   2160: dup
    //   2161: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2164: ldc_w 334
    //   2167: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2170: aload_0
    //   2171: getfield 158	com/tencent/mobileqq/data/MessageForGrayTips:msg	Ljava/lang/String;
    //   2174: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2177: ldc_w 325
    //   2180: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: aload 16
    //   2185: invokevirtual 329	java/lang/NumberFormatException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   2188: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2191: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2194: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2197: goto -1051 -> 1146
    //   2200: astore 16
    //   2202: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2205: ifeq -1059 -> 1146
    //   2208: ldc 16
    //   2210: iconst_2
    //   2211: new 63	java/lang/StringBuilder
    //   2214: dup
    //   2215: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2218: ldc_w 336
    //   2221: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2224: aload_0
    //   2225: getfield 158	com/tencent/mobileqq/data/MessageForGrayTips:msg	Ljava/lang/String;
    //   2228: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2231: ldc_w 325
    //   2234: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: aload 16
    //   2239: invokevirtual 337	java/lang/IllegalArgumentException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   2242: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2245: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2248: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2251: goto -1105 -> 1146
    //   2254: iload_3
    //   2255: iconst_1
    //   2256: iadd
    //   2257: istore_3
    //   2258: goto -1110 -> 1148
    //   2261: aload_1
    //   2262: bipush 51
    //   2264: invokevirtual 343	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2267: checkcast 345	com/tencent/mobileqq/app/TroopManager
    //   2270: astore 19
    //   2272: aload 25
    //   2274: invokevirtual 349	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2277: astore 20
    //   2279: aload 24
    //   2281: astore 16
    //   2283: ldc 200
    //   2285: astore 17
    //   2287: iconst_0
    //   2288: istore_3
    //   2289: aload 20
    //   2291: invokeinterface 354 1 0
    //   2296: ifeq +214 -> 2510
    //   2299: aload 20
    //   2301: invokeinterface 358 1 0
    //   2306: checkcast 25	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem
    //   2309: astore 18
    //   2311: new 63	java/lang/StringBuilder
    //   2314: dup
    //   2315: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2318: aload 17
    //   2320: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: aload 16
    //   2325: iconst_0
    //   2326: aload 18
    //   2328: getfield 46	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:start	I
    //   2331: iload_3
    //   2332: isub
    //   2333: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   2336: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2339: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2342: astore 21
    //   2344: aload 16
    //   2346: aload 18
    //   2348: getfield 46	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:start	I
    //   2351: iload_3
    //   2352: isub
    //   2353: aload 18
    //   2355: getfield 49	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:end	I
    //   2358: iload_3
    //   2359: isub
    //   2360: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   2363: astore 22
    //   2365: aload 16
    //   2367: aload 18
    //   2369: getfield 49	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:end	I
    //   2372: iload_3
    //   2373: isub
    //   2374: aload 16
    //   2376: invokevirtual 211	java/lang/String:length	()I
    //   2379: invokevirtual 86	java/lang/String:substring	(II)Ljava/lang/String;
    //   2382: astore 17
    //   2384: aload 18
    //   2386: getfield 49	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:end	I
    //   2389: istore_3
    //   2390: aload 18
    //   2392: aload 21
    //   2394: invokevirtual 211	java/lang/String:length	()I
    //   2397: putfield 46	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:start	I
    //   2400: aload 18
    //   2402: getfield 362	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:needUpdateNick	Z
    //   2405: ifeq +80 -> 2485
    //   2408: new 63	java/lang/StringBuilder
    //   2411: dup
    //   2412: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2415: aload 21
    //   2417: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: aload 19
    //   2422: aload_0
    //   2423: getfield 365	com/tencent/mobileqq/data/MessageForGrayTips:frienduin	Ljava/lang/String;
    //   2426: new 63	java/lang/StringBuilder
    //   2429: dup
    //   2430: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2433: ldc 200
    //   2435: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2438: aload 18
    //   2440: getfield 369	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:uin	J
    //   2443: invokevirtual 372	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2446: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2449: invokevirtual 376	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2452: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2455: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2458: astore 16
    //   2460: aload 18
    //   2462: aload 16
    //   2464: invokevirtual 211	java/lang/String:length	()I
    //   2467: putfield 49	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:end	I
    //   2470: aload 16
    //   2472: astore 18
    //   2474: aload 17
    //   2476: astore 16
    //   2478: aload 18
    //   2480: astore 17
    //   2482: goto -193 -> 2289
    //   2485: new 63	java/lang/StringBuilder
    //   2488: dup
    //   2489: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2492: aload 21
    //   2494: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2497: aload 22
    //   2499: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2502: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2505: astore 16
    //   2507: goto -47 -> 2460
    //   2510: new 51	android/text/SpannableStringBuilder
    //   2513: dup
    //   2514: new 63	java/lang/StringBuilder
    //   2517: dup
    //   2518: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2521: aload 17
    //   2523: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: aload 16
    //   2528: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2531: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2534: invokespecial 256	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   2537: astore 16
    //   2539: aload 25
    //   2541: invokevirtual 349	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2544: astore 17
    //   2546: aload 17
    //   2548: invokeinterface 354 1 0
    //   2553: ifeq +79 -> 2632
    //   2556: aload 17
    //   2558: invokeinterface 358 1 0
    //   2563: checkcast 25	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem
    //   2566: astore 18
    //   2568: aload 18
    //   2570: ifnull -24 -> 2546
    //   2573: aload 18
    //   2575: getfield 28	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:icon	Ljava/lang/String;
    //   2578: invokestatic 198	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2581: ifeq +40 -> 2621
    //   2584: aload 16
    //   2586: new 378	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan
    //   2589: dup
    //   2590: aload_1
    //   2591: aload 18
    //   2593: getfield 380	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:textColor	I
    //   2596: aload_2
    //   2597: aload 18
    //   2599: aload_0
    //   2600: invokespecial 383	com/tencent/mobileqq/data/MessageForGrayTips$HightlightClickableSpan:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;ILandroid/content/Context;Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightItem;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   2603: aload 18
    //   2605: getfield 46	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:start	I
    //   2608: aload 18
    //   2610: getfield 49	com/tencent/mobileqq/data/MessageForGrayTips$HightlightItem:end	I
    //   2613: bipush 33
    //   2615: invokevirtual 55	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   2618: goto -72 -> 2546
    //   2621: aload_2
    //   2622: aload 16
    //   2624: aload 18
    //   2626: invokestatic 385	com/tencent/mobileqq/data/MessageForGrayTips:decodeImageSpan	(Landroid/content/Context;Landroid/text/SpannableStringBuilder;Lcom/tencent/mobileqq/data/MessageForGrayTips$HightlightItem;)V
    //   2629: goto -83 -> 2546
    //   2632: invokestatic 61	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2635: ifeq +30 -> 2665
    //   2638: ldc 220
    //   2640: iconst_2
    //   2641: new 63	java/lang/StringBuilder
    //   2644: dup
    //   2645: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   2648: ldc_w 387
    //   2651: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2654: aload 16
    //   2656: invokevirtual 332	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2659: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2662: invokestatic 78	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2665: aload 16
    //   2667: areturn
    //   2668: goto -1616 -> 1052
    //   2671: goto -1619 -> 1052
    //   2674: iconst_0
    //   2675: istore 10
    //   2677: goto -1739 -> 938
    //   2680: aconst_null
    //   2681: astore 19
    //   2683: ldc 200
    //   2685: astore 17
    //   2687: goto -1800 -> 887
    //   2690: iconst_0
    //   2691: istore 10
    //   2693: goto -2027 -> 666
    //   2696: lconst_0
    //   2697: lstore 14
    //   2699: goto -2084 -> 615
    //   2702: iconst_m1
    //   2703: istore 10
    //   2705: aload 17
    //   2707: astore 16
    //   2709: ldc 200
    //   2711: astore 17
    //   2713: iload 5
    //   2715: istore 6
    //   2717: iload 10
    //   2719: istore 5
    //   2721: goto -2121 -> 600
    //   2724: iconst_m1
    //   2725: istore 5
    //   2727: aload 16
    //   2729: astore 17
    //   2731: goto -2131 -> 600
    //   2734: iconst_m1
    //   2735: istore 10
    //   2737: aload 17
    //   2739: astore 16
    //   2741: iload 5
    //   2743: istore 6
    //   2745: iload 10
    //   2747: istore 5
    //   2749: goto -2149 -> 600
    //   2752: iconst_m1
    //   2753: istore 10
    //   2755: aload 16
    //   2757: astore 20
    //   2759: ldc 200
    //   2761: astore 17
    //   2763: iload 5
    //   2765: istore 6
    //   2767: iload 10
    //   2769: istore 5
    //   2771: goto -2171 -> 600
    //   2774: iconst_m1
    //   2775: istore 6
    //   2777: goto -1101 -> 1676
    //   2780: aload 16
    //   2782: astore 19
    //   2784: aload 16
    //   2786: astore 17
    //   2788: aload 19
    //   2790: astore 16
    //   2792: goto -2011 -> 781
    //   2795: aconst_null
    //   2796: astore 19
    //   2798: aload 16
    //   2800: astore 17
    //   2802: aload 19
    //   2804: astore 16
    //   2806: goto -2025 -> 781
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2809	0	this	MessageForGrayTips
    //   0	2809	1	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	2809	2	paramContext	Context
    //   71	2319	3	i	int
    //   239	1731	4	j	int
    //   247	2523	5	k	int
    //   586	2190	6	m	int
    //   267	809	7	n	int
    //   224	869	8	i1	int
    //   234	832	9	i2	int
    //   582	2186	10	i3	int
    //   202	29	11	i4	int
    //   5	572	12	bool1	boolean
    //   1	124	13	bool2	boolean
    //   613	2085	14	l	long
    //   68	30	16	str1	String
    //   103	1	16	localJSONException	org.json.JSONException
    //   163	941	16	localObject1	java.lang.Object
    //   1113	29	16	localNumberFormatException1	java.lang.NumberFormatException
    //   1211	747	16	localObject2	java.lang.Object
    //   1978	29	16	localNumberFormatException2	java.lang.NumberFormatException
    //   2014	21	16	localNumberFormatException3	java.lang.NumberFormatException
    //   2067	69	16	localNumberFormatException4	java.lang.NumberFormatException
    //   2141	1	16	localObject3	java.lang.Object
    //   2146	38	16	localNumberFormatException5	java.lang.NumberFormatException
    //   2200	38	16	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   2281	524	16	localObject4	java.lang.Object
    //   180	1503	17	localObject5	java.lang.Object
    //   1695	52	17	localNumberFormatException6	java.lang.NumberFormatException
    //   1761	1040	17	localObject6	java.lang.Object
    //   253	2372	18	localObject7	java.lang.Object
    //   250	2553	19	localObject8	java.lang.Object
    //   256	2502	20	localObject9	java.lang.Object
    //   259	2234	21	str2	String
    //   877	1621	22	localObject10	java.lang.Object
    //   2133	7	23	localNumberFormatException7	java.lang.NumberFormatException
    //   140	2140	24	str3	String
    //   221	2319	25	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   7	32	103	org/json/JSONException
    //   278	364	1113	java/lang/NumberFormatException
    //   370	403	1113	java/lang/NumberFormatException
    //   1103	1110	1113	java/lang/NumberFormatException
    //   1669	1676	1695	java/lang/NumberFormatException
    //   1266	1317	1978	java/lang/NumberFormatException
    //   1323	1349	1978	java/lang/NumberFormatException
    //   1355	1364	1978	java/lang/NumberFormatException
    //   1370	1396	1978	java/lang/NumberFormatException
    //   1414	1423	1978	java/lang/NumberFormatException
    //   1437	1463	1978	java/lang/NumberFormatException
    //   1463	1472	1978	java/lang/NumberFormatException
    //   1478	1504	1978	java/lang/NumberFormatException
    //   1522	1547	1978	java/lang/NumberFormatException
    //   1569	1578	1978	java/lang/NumberFormatException
    //   1584	1610	1978	java/lang/NumberFormatException
    //   1628	1637	1978	java/lang/NumberFormatException
    //   1643	1669	1978	java/lang/NumberFormatException
    //   1697	1712	1978	java/lang/NumberFormatException
    //   1715	1724	1978	java/lang/NumberFormatException
    //   1730	1756	1978	java/lang/NumberFormatException
    //   1774	1902	1978	java/lang/NumberFormatException
    //   1908	1934	1978	java/lang/NumberFormatException
    //   608	615	2014	java/lang/NumberFormatException
    //   679	688	2067	java/lang/NumberFormatException
    //   694	727	2067	java/lang/NumberFormatException
    //   732	741	2067	java/lang/NumberFormatException
    //   747	773	2067	java/lang/NumberFormatException
    //   781	790	2067	java/lang/NumberFormatException
    //   796	829	2067	java/lang/NumberFormatException
    //   834	843	2067	java/lang/NumberFormatException
    //   849	875	2067	java/lang/NumberFormatException
    //   2034	2041	2067	java/lang/NumberFormatException
    //   2044	2051	2067	java/lang/NumberFormatException
    //   951	960	2146	java/lang/NumberFormatException
    //   966	999	2146	java/lang/NumberFormatException
    //   1004	1013	2146	java/lang/NumberFormatException
    //   1019	1045	2146	java/lang/NumberFormatException
    //   1045	1052	2146	java/lang/NumberFormatException
    //   2121	2128	2146	java/lang/NumberFormatException
    //   951	960	2200	java/lang/IllegalArgumentException
    //   966	999	2200	java/lang/IllegalArgumentException
    //   1004	1013	2200	java/lang/IllegalArgumentException
    //   1019	1045	2200	java/lang/IllegalArgumentException
    //   1045	1052	2200	java/lang/IllegalArgumentException
    //   2121	2128	2200	java/lang/IllegalArgumentException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips
 * JD-Core Version:    0.7.0.1
 */