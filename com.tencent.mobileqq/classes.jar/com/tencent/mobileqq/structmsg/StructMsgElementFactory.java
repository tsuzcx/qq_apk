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
  private static final SparseArray<Class<? extends AbsStructMsgItem>> jdField_a_of_type_AndroidUtilSparseArray;
  private static HashMap<String, Class<? extends AbsStructMsgElement>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put("pavideo", StructMsgItemPAVideo.class);
    jdField_a_of_type_JavaUtilHashMap.put("video", StructMsgItemVideo.class);
    jdField_a_of_type_JavaUtilHashMap.put("picture", StructMsgItemCover.class);
    jdField_a_of_type_JavaUtilHashMap.put("title", StructMsgItemTitle.class);
    jdField_a_of_type_JavaUtilHashMap.put("summary", StructMsgItemSummary.class);
    jdField_a_of_type_JavaUtilHashMap.put("timer", StructMsgItemTimer.class);
    jdField_a_of_type_JavaUtilHashMap.put("hr", StructMsgItemHr.class);
    jdField_a_of_type_JavaUtilHashMap.put("image", StructMsgItemImage.class);
    jdField_a_of_type_JavaUtilHashMap.put("more", StructMsgItemMore.class);
    jdField_a_of_type_JavaUtilHashMap.put("progress", StructMsgItemProgress.class);
    jdField_a_of_type_JavaUtilHashMap.put("checklist", StructMsgItemVote.class);
    jdField_a_of_type_JavaUtilHashMap.put("vote", StructMsgItemVoteCover.class);
    jdField_a_of_type_JavaUtilHashMap.put("price", StructMsgItemPrice.class);
    jdField_a_of_type_JavaUtilHashMap.put("button", StructMsgItemButton.class);
    jdField_a_of_type_JavaUtilHashMap.put("remark", StructMsgItemRemark.class);
    jdField_a_of_type_JavaUtilHashMap.put("paaudio", StructMsgItemPAAudio.class);
    jdField_a_of_type_JavaUtilHashMap.put("textButton", StructMsgItemTextButton.class);
    jdField_a_of_type_JavaUtilHashMap.put("content", StructMsgItemContent.class);
    jdField_a_of_type_JavaUtilHashMap.put("tips", StructMsgItemTips.class);
    jdField_a_of_type_JavaUtilHashMap.put("live", StructMsgItemLive.class);
    jdField_a_of_type_JavaUtilHashMap.put("tr", StructMsgItemTr.class);
    jdField_a_of_type_JavaUtilHashMap.put("td", StructMsgItemTd.class);
    jdField_a_of_type_JavaUtilHashMap.put("head", StructMsgItemAvatar.class);
    jdField_a_of_type_JavaUtilHashMap.put("type", StructMsgItemType.class);
    jdField_a_of_type_JavaUtilHashMap.put("tag", StructMsgItemTag.class);
    jdField_a_of_type_JavaUtilHashMap.put("taglist", StructMsgItemTagList.class);
    jdField_a_of_type_JavaUtilHashMap.put("group", StructMsgGroupElement.class);
    jdField_a_of_type_JavaUtilHashMap.put("groupitem", StructMsgGroupItemElement.class);
    jdField_a_of_type_JavaUtilHashMap.put("voice", StructMsgItemVoice.class);
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.append(0, StructMsgItemLayoutDefault.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(1, StructMsgItemLayout1.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(2, StructMsgItemLayout2.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(3, StructMsgItemLayout3.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(4, StructMsgItemLayout4.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(5, StructMsgItemLayout5.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(6, StructMsgItemLayout6.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(7, StructMsgItemLayout7.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(8, StructMsgItemLayout8.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(9, StructMsgItemLayout9.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(10, StructMsgItemLayout10.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(11, StructMsgItemLayout11.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(12, StructMsgItemLayout12.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(18, StructMsgItemLayout18.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(19, StructMsgItemLayout19.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(20, StructMsgItemLayout20.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(21, StructMsgItemLayout21.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(22, StructMsgItemLayout22.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(23, StructMsgItemLayout23.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(24, StructMsgItemLayout24.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(25, StructMsgItemLayout25.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(26, StructMsgItemLayout26.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(27, StructMsgItemLayout27.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(28, StructMsgItemLayout28.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(29, StructMsgItemLayout29.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(30, StructMsgItemLayout30.class);
    jdField_a_of_type_AndroidUtilSparseArray.append(31, StructMsgItemLayout31.class);
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
    //   15: ldc 213
    //   17: aload_0
    //   18: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: ifne +19 -> 40
    //   24: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_0
    //   28: invokevirtual 223	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: astore_2
    //   32: aload_2
    //   33: checkcast 225	java/lang/Class
    //   36: astore_3
    //   37: goto +14 -> 51
    //   40: getstatic 143	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   43: iload_1
    //   44: invokevirtual 228	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   47: astore_2
    //   48: goto -16 -> 32
    //   51: aload 8
    //   53: astore_2
    //   54: aload_3
    //   55: ifnull +24 -> 79
    //   58: aload_3
    //   59: invokevirtual 232	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   62: checkcast 234	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   65: astore_2
    //   66: goto +13 -> 79
    //   69: astore_2
    //   70: goto +139 -> 209
    //   73: goto +246 -> 319
    //   76: goto +289 -> 365
    //   79: aload_3
    //   80: ifnonnull +64 -> 144
    //   83: aload_2
    //   84: astore 4
    //   86: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +320 -> 409
    //   92: new 242	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   99: astore 4
    //   101: aload_2
    //   102: astore_3
    //   103: aload 4
    //   105: astore_2
    //   106: aload_2
    //   107: ldc 245
    //   109: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: aload_0
    //   115: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_2
    //   120: ldc 250
    //   122: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_2
    //   127: iload_1
    //   128: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: ldc 255
    //   134: iconst_2
    //   135: aload_2
    //   136: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_3
    //   143: areturn
    //   144: aload_2
    //   145: astore 4
    //   147: aload_2
    //   148: ifnonnull +261 -> 409
    //   151: aload_2
    //   152: astore 4
    //   154: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +252 -> 409
    //   160: new 242	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   167: astore_0
    //   168: aload_0
    //   169: ldc_w 265
    //   172: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_0
    //   177: aload_3
    //   178: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   181: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_0
    //   186: ldc_w 270
    //   189: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: ldc 255
    //   195: iconst_2
    //   196: aload_0
    //   197: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_2
    //   204: areturn
    //   205: astore_2
    //   206: aload 7
    //   208: astore_3
    //   209: aload_3
    //   210: ifnonnull +56 -> 266
    //   213: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +99 -> 315
    //   219: new 242	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   226: astore_3
    //   227: aload_3
    //   228: ldc 245
    //   230: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_3
    //   235: aload_0
    //   236: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_3
    //   241: ldc 250
    //   243: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_3
    //   248: iload_1
    //   249: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: ldc 255
    //   255: iconst_2
    //   256: aload_3
    //   257: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto +52 -> 315
    //   266: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +46 -> 315
    //   272: new 242	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   279: astore_0
    //   280: aload_0
    //   281: ldc_w 265
    //   284: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_0
    //   289: aload_3
    //   290: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   293: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_0
    //   298: ldc_w 270
    //   301: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 255
    //   307: iconst_2
    //   308: aload_0
    //   309: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_2
    //   316: athrow
    //   317: aconst_null
    //   318: astore_3
    //   319: aload_3
    //   320: ifnonnull +23 -> 343
    //   323: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +83 -> 409
    //   329: new 242	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   336: astore_2
    //   337: aload 5
    //   339: astore_3
    //   340: goto -234 -> 106
    //   343: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq +63 -> 409
    //   349: new 242	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   356: astore_0
    //   357: aload 6
    //   359: astore_2
    //   360: goto -192 -> 168
    //   363: aconst_null
    //   364: astore_3
    //   365: aload_3
    //   366: ifnonnull +23 -> 389
    //   369: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +37 -> 409
    //   375: new 242	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   382: astore_2
    //   383: aload 5
    //   385: astore_3
    //   386: goto -280 -> 106
    //   389: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +17 -> 409
    //   395: new 242	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   402: astore_0
    //   403: aload 6
    //   405: astore_2
    //   406: goto -238 -> 168
    //   409: aload 4
    //   411: areturn
    //   412: astore_2
    //   413: goto -50 -> 363
    //   416: astore_2
    //   417: goto -100 -> 317
    //   420: astore_2
    //   421: goto -345 -> 76
    //   424: astore_2
    //   425: goto -352 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	paramString	String
    //   0	428	1	paramInt	int
    //   31	35	2	localObject1	Object
    //   69	33	2	localObject2	Object
    //   105	99	2	localObject3	Object
    //   205	111	2	localObject4	Object
    //   336	70	2	localObject5	Object
    //   412	1	2	localIllegalAccessException1	java.lang.IllegalAccessException
    //   416	1	2	localInstantiationException1	java.lang.InstantiationException
    //   420	1	2	localIllegalAccessException2	java.lang.IllegalAccessException
    //   424	1	2	localInstantiationException2	java.lang.InstantiationException
    //   36	350	3	localObject6	Object
    //   10	400	4	localObject7	Object
    //   1	383	5	localObject8	Object
    //   4	400	6	localObject9	Object
    //   7	200	7	localObject10	Object
    //   13	39	8	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   58	66	69	finally
    //   15	32	205	finally
    //   32	37	205	finally
    //   40	48	205	finally
    //   15	32	412	java/lang/IllegalAccessException
    //   32	37	412	java/lang/IllegalAccessException
    //   40	48	412	java/lang/IllegalAccessException
    //   15	32	416	java/lang/InstantiationException
    //   32	37	416	java/lang/InstantiationException
    //   40	48	416	java/lang/InstantiationException
    //   58	66	420	java/lang/IllegalAccessException
    //   58	66	424	java/lang/InstantiationException
  }
  
  /* Error */
  public static AbsStructMsgItem a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 143	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3: iload_0
    //   4: invokevirtual 228	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   7: checkcast 225	java/lang/Class
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
    //   23: ifnull +260 -> 283
    //   26: aload 5
    //   28: invokevirtual 232	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   31: checkcast 273	com/tencent/mobileqq/structmsg/AbsStructMsgItem
    //   34: astore_1
    //   35: goto +248 -> 283
    //   38: astore_1
    //   39: aload 5
    //   41: ifnonnull +44 -> 85
    //   44: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +88 -> 135
    //   50: new 242	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: ldc_w 275
    //   62: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: iload_0
    //   68: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 255
    //   74: iconst_2
    //   75: aload_2
    //   76: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: goto +53 -> 135
    //   85: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +47 -> 135
    //   91: new 242	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   98: astore_2
    //   99: aload_2
    //   100: ldc_w 265
    //   103: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_2
    //   108: aload 5
    //   110: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   113: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_2
    //   118: ldc_w 270
    //   121: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: ldc 255
    //   127: iconst_2
    //   128: aload_2
    //   129: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_1
    //   136: athrow
    //   137: aload 5
    //   139: ifnonnull +22 -> 161
    //   142: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +191 -> 336
    //   148: new 242	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   155: astore_2
    //   156: aload_3
    //   157: astore_1
    //   158: goto +44 -> 202
    //   161: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +172 -> 336
    //   167: new 242	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   174: astore_1
    //   175: aload 4
    //   177: astore_2
    //   178: goto +67 -> 245
    //   181: aload 5
    //   183: ifnonnull +45 -> 228
    //   186: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +147 -> 336
    //   192: new 242	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   199: astore_2
    //   200: aload_3
    //   201: astore_1
    //   202: aload_2
    //   203: ldc_w 275
    //   206: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_2
    //   211: iload_0
    //   212: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: ldc 255
    //   218: iconst_2
    //   219: aload_2
    //   220: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_1
    //   227: areturn
    //   228: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +105 -> 336
    //   234: new 242	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   241: astore_1
    //   242: aload 4
    //   244: astore_2
    //   245: aload_1
    //   246: ldc_w 265
    //   249: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_1
    //   254: aload 5
    //   256: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   259: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_1
    //   264: ldc_w 270
    //   267: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: ldc 255
    //   273: iconst_2
    //   274: aload_1
    //   275: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 263	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_2
    //   282: areturn
    //   283: aload 5
    //   285: ifnonnull +22 -> 307
    //   288: aload_1
    //   289: astore_2
    //   290: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   293: ifeq +43 -> 336
    //   296: new 242	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   303: astore_2
    //   304: goto -102 -> 202
    //   307: aload_1
    //   308: astore_2
    //   309: aload_1
    //   310: ifnonnull +26 -> 336
    //   313: aload_1
    //   314: astore_2
    //   315: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +18 -> 336
    //   321: new 242	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   328: astore_3
    //   329: aload_1
    //   330: astore_2
    //   331: aload_3
    //   332: astore_1
    //   333: goto -88 -> 245
    //   336: aload_2
    //   337: areturn
    //   338: astore_1
    //   339: goto -158 -> 181
    //   342: astore_1
    //   343: goto -206 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramInt	int
    //   16	19	1	localAbsStructMsgItem	AbsStructMsgItem
    //   38	98	1	localObject1	Object
    //   157	176	1	localObject2	Object
    //   338	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   342	1	1	localInstantiationException	java.lang.InstantiationException
    //   18	319	2	localObject3	Object
    //   20	312	3	localStringBuilder	java.lang.StringBuilder
    //   13	230	4	localObject4	Object
    //   10	274	5	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   26	35	38	finally
    //   26	35	338	java/lang/IllegalAccessException
    //   26	35	342	java/lang/InstantiationException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgElementFactory
 * JD-Core Version:    0.7.0.1
 */