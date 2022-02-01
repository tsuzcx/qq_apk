package com.tencent.mobileqq.structmsg;

import android.util.SparseArray;
import com.tencent.mobileqq.structmsg.view.StructMsgItemAvatar;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemContent;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout10;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout11;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout18;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout19;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout21;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout22;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout23;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout24;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout25;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout26;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout27;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout28;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout29;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout3;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout30;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout31;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout7;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout8;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout9;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemMore;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPrice;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemRemark;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTd;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTextButton;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTimer;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemType;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVote;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVoteCover;
import java.util.HashMap;

public class StructMsgElementFactory
{
  private static HashMap<String, Class<? extends AbsStructMsgElement>> a = new HashMap();
  private static final SparseArray<Class<? extends AbsStructMsgItem>> b;
  
  static
  {
    a.put("pavideo", StructMsgItemPAVideo.class);
    a.put("video", StructMsgItemVideo.class);
    a.put("picture", StructMsgItemCover.class);
    a.put("title", StructMsgItemTitle.class);
    a.put("summary", StructMsgItemSummary.class);
    a.put("timer", StructMsgItemTimer.class);
    a.put("hr", StructMsgItemHr.class);
    a.put("image", StructMsgItemImage.class);
    a.put("more", StructMsgItemMore.class);
    a.put("progress", StructMsgItemProgress.class);
    a.put("checklist", StructMsgItemVote.class);
    a.put("vote", StructMsgItemVoteCover.class);
    a.put("price", StructMsgItemPrice.class);
    a.put("button", StructMsgItemButton.class);
    a.put("remark", StructMsgItemRemark.class);
    a.put("paaudio", StructMsgItemPAAudio.class);
    a.put("textButton", StructMsgItemTextButton.class);
    a.put("content", StructMsgItemContent.class);
    a.put("tips", StructMsgItemTips.class);
    a.put("live", StructMsgItemLive.class);
    a.put("tr", StructMsgItemTr.class);
    a.put("td", StructMsgItemTd.class);
    a.put("head", StructMsgItemAvatar.class);
    a.put("type", StructMsgItemType.class);
    a.put("tag", StructMsgItemTag.class);
    a.put("taglist", StructMsgItemTagList.class);
    a.put("group", StructMsgGroupElement.class);
    a.put("groupitem", StructMsgGroupItemElement.class);
    a.put("voice", StructMsgItemVoice.class);
    b = new SparseArray();
    b.append(0, StructMsgItemLayoutDefault.class);
    b.append(1, StructMsgItemLayout1.class);
    b.append(2, StructMsgItemLayout2.class);
    b.append(3, StructMsgItemLayout3.class);
    b.append(4, StructMsgItemLayout4.class);
    b.append(5, StructMsgItemLayout5.class);
    b.append(6, StructMsgItemLayout6.class);
    b.append(7, StructMsgItemLayout7.class);
    b.append(8, StructMsgItemLayout8.class);
    b.append(9, StructMsgItemLayout9.class);
    b.append(10, StructMsgItemLayout10.class);
    b.append(11, StructMsgItemLayout11.class);
    b.append(12, StructMsgItemLayout12.class);
    b.append(18, StructMsgItemLayout18.class);
    b.append(19, StructMsgItemLayout19.class);
    b.append(20, StructMsgItemLayout20.class);
    b.append(21, StructMsgItemLayout21.class);
    b.append(22, StructMsgItemLayout22.class);
    b.append(23, StructMsgItemLayout23.class);
    b.append(24, StructMsgItemLayout24.class);
    b.append(25, StructMsgItemLayout25.class);
    b.append(26, StructMsgItemLayout26.class);
    b.append(27, StructMsgItemLayout27.class);
    b.append(28, StructMsgItemLayout28.class);
    b.append(29, StructMsgItemLayout29.class);
    b.append(30, StructMsgItemLayout30.class);
    b.append(31, StructMsgItemLayout31.class);
  }
  
  public static AbsStructMsgElement a(String paramString)
  {
    return a(paramString, 0);
  }
  
  /* Error */
  public static AbsStructMsgElement a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore 8
    //   15: ldc 214
    //   17: aload_0
    //   18: invokevirtual 220	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifne +19 -> 40
    //   24: getstatic 19	com/tencent/mobileqq/structmsg/StructMsgElementFactory:a	Ljava/util/HashMap;
    //   27: aload_0
    //   28: invokevirtual 224	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: astore_2
    //   32: aload_2
    //   33: checkcast 226	java/lang/Class
    //   36: astore_3
    //   37: goto +14 -> 51
    //   40: getstatic 144	com/tencent/mobileqq/structmsg/StructMsgElementFactory:b	Landroid/util/SparseArray;
    //   43: iload_1
    //   44: invokevirtual 229	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   47: astore_2
    //   48: goto -16 -> 32
    //   51: aload 8
    //   53: astore_2
    //   54: aload_3
    //   55: ifnull +24 -> 79
    //   58: aload_3
    //   59: invokevirtual 233	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   62: checkcast 235	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   65: astore_2
    //   66: goto +13 -> 79
    //   69: astore_2
    //   70: goto +141 -> 211
    //   73: goto +250 -> 323
    //   76: goto +293 -> 369
    //   79: aload_3
    //   80: ifnonnull +65 -> 145
    //   83: aload_2
    //   84: astore 4
    //   86: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +324 -> 413
    //   92: new 243	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   99: astore 4
    //   101: aload_2
    //   102: astore_3
    //   103: aload 4
    //   105: astore_2
    //   106: aload_2
    //   107: ldc 246
    //   109: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: aload_0
    //   115: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_2
    //   120: ldc 251
    //   122: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_2
    //   127: iload_1
    //   128: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: ldc_w 256
    //   135: iconst_2
    //   136: aload_2
    //   137: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_3
    //   144: areturn
    //   145: aload_2
    //   146: astore 4
    //   148: aload_2
    //   149: ifnonnull +264 -> 413
    //   152: aload_2
    //   153: astore 4
    //   155: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +255 -> 413
    //   161: new 243	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   168: astore_0
    //   169: aload_0
    //   170: ldc_w 266
    //   173: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_0
    //   178: aload_3
    //   179: invokevirtual 269	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   182: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_0
    //   187: ldc_w 271
    //   190: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: ldc_w 256
    //   197: iconst_2
    //   198: aload_0
    //   199: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: areturn
    //   207: astore_2
    //   208: aload 7
    //   210: astore_3
    //   211: aload_3
    //   212: ifnonnull +57 -> 269
    //   215: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +101 -> 319
    //   221: new 243	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   228: astore_3
    //   229: aload_3
    //   230: ldc 246
    //   232: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: aload_0
    //   238: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_3
    //   243: ldc 251
    //   245: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_3
    //   250: iload_1
    //   251: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc_w 256
    //   258: iconst_2
    //   259: aload_3
    //   260: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: goto +53 -> 319
    //   269: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +47 -> 319
    //   275: new 243	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   282: astore_0
    //   283: aload_0
    //   284: ldc_w 266
    //   287: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_0
    //   292: aload_3
    //   293: invokevirtual 269	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   296: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_0
    //   301: ldc_w 271
    //   304: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: ldc_w 256
    //   311: iconst_2
    //   312: aload_0
    //   313: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload_2
    //   320: athrow
    //   321: aconst_null
    //   322: astore_3
    //   323: aload_3
    //   324: ifnonnull +23 -> 347
    //   327: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +83 -> 413
    //   333: new 243	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   340: astore_2
    //   341: aload 5
    //   343: astore_3
    //   344: goto -238 -> 106
    //   347: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +63 -> 413
    //   353: new 243	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   360: astore_0
    //   361: aload 6
    //   363: astore_2
    //   364: goto -195 -> 169
    //   367: aconst_null
    //   368: astore_3
    //   369: aload_3
    //   370: ifnonnull +23 -> 393
    //   373: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +37 -> 413
    //   379: new 243	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   386: astore_2
    //   387: aload 5
    //   389: astore_3
    //   390: goto -284 -> 106
    //   393: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +17 -> 413
    //   399: new 243	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   406: astore_0
    //   407: aload 6
    //   409: astore_2
    //   410: goto -241 -> 169
    //   413: aload 4
    //   415: areturn
    //   416: astore_2
    //   417: goto -50 -> 367
    //   420: astore_2
    //   421: goto -100 -> 321
    //   424: astore_2
    //   425: goto -349 -> 76
    //   428: astore_2
    //   429: goto -356 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	paramString	String
    //   0	432	1	paramInt	int
    //   31	35	2	localObject1	Object
    //   69	33	2	localObject2	Object
    //   105	101	2	localObject3	Object
    //   207	113	2	localObject4	Object
    //   340	70	2	localObject5	Object
    //   416	1	2	localIllegalAccessException1	java.lang.IllegalAccessException
    //   420	1	2	localInstantiationException1	java.lang.InstantiationException
    //   424	1	2	localIllegalAccessException2	java.lang.IllegalAccessException
    //   428	1	2	localInstantiationException2	java.lang.InstantiationException
    //   36	354	3	localObject6	Object
    //   10	404	4	localObject7	Object
    //   1	387	5	localObject8	Object
    //   4	404	6	localObject9	Object
    //   7	202	7	localObject10	Object
    //   13	39	8	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   58	66	69	finally
    //   15	32	207	finally
    //   32	37	207	finally
    //   40	48	207	finally
    //   15	32	416	java/lang/IllegalAccessException
    //   32	37	416	java/lang/IllegalAccessException
    //   40	48	416	java/lang/IllegalAccessException
    //   15	32	420	java/lang/InstantiationException
    //   32	37	420	java/lang/InstantiationException
    //   40	48	420	java/lang/InstantiationException
    //   58	66	424	java/lang/IllegalAccessException
    //   58	66	428	java/lang/InstantiationException
  }
  
  /* Error */
  public static AbsStructMsgItem a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 144	com/tencent/mobileqq/structmsg/StructMsgElementFactory:b	Landroid/util/SparseArray;
    //   3: iload_0
    //   4: invokevirtual 229	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   7: checkcast 226	java/lang/Class
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aconst_null
    //   16: astore_1
    //   17: aconst_null
    //   18: astore_2
    //   19: aconst_null
    //   20: astore_3
    //   21: aload 5
    //   23: ifnull +264 -> 287
    //   26: aload 5
    //   28: invokevirtual 233	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   31: checkcast 274	com/tencent/mobileqq/structmsg/AbsStructMsgItem
    //   34: astore_1
    //   35: goto +252 -> 287
    //   38: astore_1
    //   39: aload 5
    //   41: ifnonnull +45 -> 86
    //   44: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +90 -> 137
    //   50: new 243	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: ldc_w 276
    //   62: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: iload_0
    //   68: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc_w 256
    //   75: iconst_2
    //   76: aload_2
    //   77: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: goto +54 -> 137
    //   86: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +48 -> 137
    //   92: new 243	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   99: astore_2
    //   100: aload_2
    //   101: ldc_w 266
    //   104: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_2
    //   109: aload 5
    //   111: invokevirtual 269	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   114: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_2
    //   119: ldc_w 271
    //   122: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: ldc_w 256
    //   129: iconst_2
    //   130: aload_2
    //   131: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_1
    //   138: athrow
    //   139: aload 5
    //   141: ifnonnull +22 -> 163
    //   144: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +193 -> 340
    //   150: new 243	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   157: astore_2
    //   158: aload_3
    //   159: astore_1
    //   160: goto +44 -> 204
    //   163: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +174 -> 340
    //   169: new 243	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   176: astore_1
    //   177: aload 4
    //   179: astore_2
    //   180: goto +68 -> 248
    //   183: aload 5
    //   185: ifnonnull +46 -> 231
    //   188: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +149 -> 340
    //   194: new 243	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   201: astore_2
    //   202: aload_3
    //   203: astore_1
    //   204: aload_2
    //   205: ldc_w 276
    //   208: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: iload_0
    //   214: invokevirtual 254	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: ldc_w 256
    //   221: iconst_2
    //   222: aload_2
    //   223: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_1
    //   230: areturn
    //   231: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +106 -> 340
    //   237: new 243	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   244: astore_1
    //   245: aload 4
    //   247: astore_2
    //   248: aload_1
    //   249: ldc_w 266
    //   252: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_1
    //   257: aload 5
    //   259: invokevirtual 269	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   262: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_1
    //   267: ldc_w 271
    //   270: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: ldc_w 256
    //   277: iconst_2
    //   278: aload_1
    //   279: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aload_2
    //   286: areturn
    //   287: aload 5
    //   289: ifnonnull +22 -> 311
    //   292: aload_1
    //   293: astore_2
    //   294: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +43 -> 340
    //   300: new 243	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   307: astore_2
    //   308: goto -104 -> 204
    //   311: aload_1
    //   312: astore_2
    //   313: aload_1
    //   314: ifnonnull +26 -> 340
    //   317: aload_1
    //   318: astore_2
    //   319: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +18 -> 340
    //   325: new 243	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   332: astore_3
    //   333: aload_1
    //   334: astore_2
    //   335: aload_3
    //   336: astore_1
    //   337: goto -89 -> 248
    //   340: aload_2
    //   341: areturn
    //   342: astore_1
    //   343: goto -160 -> 183
    //   346: astore_1
    //   347: goto -208 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	paramInt	int
    //   16	19	1	localAbsStructMsgItem	AbsStructMsgItem
    //   38	100	1	localObject1	Object
    //   159	178	1	localObject2	Object
    //   342	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   346	1	1	localInstantiationException	java.lang.InstantiationException
    //   18	323	2	localObject3	Object
    //   20	316	3	localStringBuilder	java.lang.StringBuilder
    //   13	233	4	localObject4	Object
    //   10	278	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   26	35	38	finally
    //   26	35	342	java/lang/IllegalAccessException
    //   26	35	346	java/lang/InstantiationException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgElementFactory
 * JD-Core Version:    0.7.0.1
 */