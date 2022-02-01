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
    //   0: ldc 213
    //   2: aload_0
    //   3: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifne +72 -> 78
    //   9: getstatic 18	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   12: aload_0
    //   13: invokevirtual 223	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast 225	java/lang/Class
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull +421 -> 442
    //   24: aload_2
    //   25: invokevirtual 229	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   28: checkcast 231	com/tencent/mobileqq/structmsg/AbsStructMsgElement
    //   31: astore_3
    //   32: aload_2
    //   33: ifnonnull +59 -> 92
    //   36: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +37 -> 76
    //   42: ldc 239
    //   44: iconst_2
    //   45: new 241	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   52: ldc 244
    //   54: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 249
    //   63: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_3
    //   77: areturn
    //   78: getstatic 143	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   81: iload_1
    //   82: invokevirtual 263	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   85: checkcast 225	java/lang/Class
    //   88: astore_2
    //   89: goto -69 -> 20
    //   92: aload_3
    //   93: ifnonnull -17 -> 76
    //   96: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq -23 -> 76
    //   102: ldc 239
    //   104: iconst_2
    //   105: new 241	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 265
    //   115: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_2
    //   119: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   122: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 270
    //   128: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_3
    //   138: areturn
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: ifnonnull +45 -> 188
    //   146: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +291 -> 440
    //   152: ldc 239
    //   154: iconst_2
    //   155: new 241	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   162: ldc 244
    //   164: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc 249
    //   173: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload_1
    //   177: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aconst_null
    //   187: areturn
    //   188: iconst_0
    //   189: ifne +251 -> 440
    //   192: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +245 -> 440
    //   198: ldc 239
    //   200: iconst_2
    //   201: new 241	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 265
    //   211: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_2
    //   215: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   218: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 270
    //   224: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_2
    //   238: aload_2
    //   239: ifnonnull +45 -> 284
    //   242: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +195 -> 440
    //   248: ldc 239
    //   250: iconst_2
    //   251: new 241	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   258: ldc 244
    //   260: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: aload_0
    //   264: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: ldc 249
    //   269: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: iload_1
    //   273: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aconst_null
    //   283: areturn
    //   284: iconst_0
    //   285: ifne +155 -> 440
    //   288: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq +149 -> 440
    //   294: ldc 239
    //   296: iconst_2
    //   297: new 241	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 265
    //   307: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_2
    //   311: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   314: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 270
    //   320: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aconst_null
    //   330: areturn
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_2
    //   334: aload_2
    //   335: ifnonnull +45 -> 380
    //   338: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +37 -> 378
    //   344: ldc 239
    //   346: iconst_2
    //   347: new 241	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   354: ldc 244
    //   356: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_0
    //   360: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: ldc 249
    //   365: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: iload_1
    //   369: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_3
    //   379: athrow
    //   380: iconst_0
    //   381: ifne -3 -> 378
    //   384: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq -9 -> 378
    //   390: ldc 239
    //   392: iconst_2
    //   393: new 241	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 265
    //   403: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_2
    //   407: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   410: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 270
    //   416: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: goto -47 -> 378
    //   428: astore_3
    //   429: goto -95 -> 334
    //   432: astore_3
    //   433: goto -195 -> 238
    //   436: astore_3
    //   437: goto -295 -> 142
    //   440: aconst_null
    //   441: areturn
    //   442: aconst_null
    //   443: astore_3
    //   444: goto -412 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	447	0	paramString	String
    //   0	447	1	paramInt	int
    //   19	100	2	localClass	Class
    //   139	1	2	localIllegalAccessException1	java.lang.IllegalAccessException
    //   141	74	2	localObject1	Object
    //   235	1	2	localInstantiationException1	java.lang.InstantiationException
    //   237	170	2	localObject2	Object
    //   31	107	3	localAbsStructMsgElement	AbsStructMsgElement
    //   331	48	3	localObject3	Object
    //   428	1	3	localObject4	Object
    //   432	1	3	localInstantiationException2	java.lang.InstantiationException
    //   436	1	3	localIllegalAccessException2	java.lang.IllegalAccessException
    //   443	1	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	20	139	java/lang/IllegalAccessException
    //   78	89	139	java/lang/IllegalAccessException
    //   0	20	235	java/lang/InstantiationException
    //   78	89	235	java/lang/InstantiationException
    //   0	20	331	finally
    //   78	89	331	finally
    //   24	32	428	finally
    //   24	32	432	java/lang/InstantiationException
    //   24	32	436	java/lang/IllegalAccessException
  }
  
  /* Error */
  public static AbsStructMsgItem a(int paramInt)
  {
    // Byte code:
    //   0: getstatic 143	com/tencent/mobileqq/structmsg/StructMsgElementFactory:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   3: iload_0
    //   4: invokevirtual 263	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   7: checkcast 225	java/lang/Class
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +359 -> 371
    //   15: aload_2
    //   16: invokevirtual 229	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   19: checkcast 273	com/tencent/mobileqq/structmsg/AbsStructMsgItem
    //   22: astore_1
    //   23: aload_2
    //   24: ifnonnull +37 -> 61
    //   27: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +339 -> 369
    //   33: ldc 239
    //   35: iconst_2
    //   36: new 241	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 275
    //   46: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload_0
    //   50: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_1
    //   60: areturn
    //   61: aload_1
    //   62: ifnonnull +307 -> 369
    //   65: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +301 -> 369
    //   71: ldc 239
    //   73: iconst_2
    //   74: new 241	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 265
    //   84: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_2
    //   88: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   91: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 270
    //   97: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_1
    //   107: areturn
    //   108: astore_1
    //   109: aload_2
    //   110: ifnonnull +37 -> 147
    //   113: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +251 -> 367
    //   119: ldc 239
    //   121: iconst_2
    //   122: new 241	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   129: ldc_w 275
    //   132: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload_0
    //   136: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aconst_null
    //   146: areturn
    //   147: iconst_0
    //   148: ifne +219 -> 367
    //   151: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +213 -> 367
    //   157: ldc 239
    //   159: iconst_2
    //   160: new 241	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 265
    //   170: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_2
    //   174: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   177: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 270
    //   183: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: aload_2
    //   196: ifnonnull +37 -> 233
    //   199: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +165 -> 367
    //   205: ldc 239
    //   207: iconst_2
    //   208: new 241	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 275
    //   218: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload_0
    //   222: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aconst_null
    //   232: areturn
    //   233: iconst_0
    //   234: ifne +133 -> 367
    //   237: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +127 -> 367
    //   243: ldc 239
    //   245: iconst_2
    //   246: new 241	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 265
    //   256: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_2
    //   260: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   263: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 270
    //   269: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aconst_null
    //   279: areturn
    //   280: astore_1
    //   281: aload_2
    //   282: ifnonnull +37 -> 319
    //   285: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +29 -> 317
    //   291: ldc 239
    //   293: iconst_2
    //   294: new 241	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 275
    //   304: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: iload_0
    //   308: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload_1
    //   318: athrow
    //   319: iconst_0
    //   320: ifne -3 -> 317
    //   323: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq -9 -> 317
    //   329: ldc 239
    //   331: iconst_2
    //   332: new 241	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 265
    //   342: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_2
    //   346: invokevirtual 268	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   349: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 270
    //   355: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 256	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: goto -47 -> 317
    //   367: aconst_null
    //   368: areturn
    //   369: aload_1
    //   370: areturn
    //   371: aconst_null
    //   372: astore_1
    //   373: goto -350 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramInt	int
    //   22	85	1	localAbsStructMsgItem1	AbsStructMsgItem
    //   108	1	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   194	1	1	localInstantiationException	java.lang.InstantiationException
    //   280	90	1	localAbsStructMsgItem2	AbsStructMsgItem
    //   372	1	1	localObject	Object
    //   10	336	2	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   15	23	108	java/lang/IllegalAccessException
    //   15	23	194	java/lang/InstantiationException
    //   15	23	280	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgElementFactory
 * JD-Core Version:    0.7.0.1
 */