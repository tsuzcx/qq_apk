package com.tencent.mobileqq.magicface.magicfaceaction;

import android.util.Xml;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.qphone.base.util.QLog;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class MagicfaceActionDecoder
{
  private Action jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction;
  private ActionProcess jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
  private MagicfacePlayRes jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes;
  
  private void a(XmlPullParser paramXmlPullParser, Action paramAction)
  {
    paramAction.jdField_a_of_type_JavaLangString = paramXmlPullParser.getAttributeValue(null, "name");
    String str = paramXmlPullParser.getAttributeValue(null, "timeout");
    if (str != null) {
      paramAction.jdField_a_of_type_Int = Integer.parseInt(str);
    }
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "nextActionIfTimeout");
    if (paramXmlPullParser != null) {
      paramAction.jdField_a_of_type_Boolean = Boolean.parseBoolean(paramXmlPullParser);
    }
  }
  
  public int a(String paramString)
  {
    int i;
    try
    {
      localObject = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject).setNamespaceAware(true);
      localObject = ((XmlPullParserFactory)localObject).newPullParser();
      ((XmlPullParser)localObject).setInput(new StringReader(paramString));
      i = ((XmlPullParser)localObject).getEventType();
    }
    catch (Exception paramString)
    {
      Object localObject;
      paramString.printStackTrace();
    }
    if (((XmlPullParser)localObject).getName().equalsIgnoreCase("random")) {
      return Integer.parseInt(((XmlPullParser)localObject).getAttributeValue(null, "value"));
    }
    for (;;)
    {
      i = ((XmlPullParser)localObject).next();
      while (i == 1) {
        return 0;
      }
      if (i != 0) {
        if (i == 2) {
          break;
        }
      }
    }
  }
  
  /* Error */
  public ActionGlobalData a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 57	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   3: astore 4
    //   5: aload 4
    //   7: iconst_1
    //   8: invokevirtual 61	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
    //   11: aload 4
    //   13: invokevirtual 65	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   16: astore 7
    //   18: aload 7
    //   20: new 67	java/io/StringReader
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 70	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   28: invokeinterface 74 2 0
    //   33: aload 7
    //   35: invokeinterface 78 1 0
    //   40: istore_2
    //   41: aconst_null
    //   42: astore_1
    //   43: aload_1
    //   44: astore 4
    //   46: iload_2
    //   47: iconst_1
    //   48: if_icmpeq +1175 -> 1223
    //   51: iload_2
    //   52: ifeq +1129 -> 1181
    //   55: iload_2
    //   56: iconst_2
    //   57: if_icmpeq +9 -> 66
    //   60: aload_1
    //   61: astore 5
    //   63: goto +1130 -> 1193
    //   66: aload_1
    //   67: astore 4
    //   69: aload 7
    //   71: invokeinterface 82 1 0
    //   76: astore 6
    //   78: aload_1
    //   79: astore 4
    //   81: aload 6
    //   83: ldc 100
    //   85: invokevirtual 89	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   88: istore_3
    //   89: iload_3
    //   90: ifeq +899 -> 989
    //   93: aload_1
    //   94: astore 4
    //   96: aload 7
    //   98: aconst_null
    //   99: ldc 102
    //   101: invokeinterface 22 3 0
    //   106: astore 5
    //   108: aload_1
    //   109: astore 4
    //   111: aload 5
    //   113: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifne +15 -> 131
    //   119: aload_1
    //   120: astore 4
    //   122: aload_1
    //   123: aload 5
    //   125: invokestatic 46	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   128: putfield 113	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_c_of_type_Boolean	Z
    //   131: aload_1
    //   132: astore 4
    //   134: aload 7
    //   136: aconst_null
    //   137: ldc 115
    //   139: invokeinterface 22 3 0
    //   144: astore 5
    //   146: aload 5
    //   148: ifnull +26 -> 174
    //   151: aload_1
    //   152: astore 4
    //   154: aload 5
    //   156: invokestatic 46	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   159: istore_3
    //   160: iload_3
    //   161: ifne +13 -> 174
    //   164: aload_1
    //   165: astore 4
    //   167: aload_1
    //   168: iload_3
    //   169: putfield 116	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_a_of_type_Boolean	Z
    //   172: aload_1
    //   173: areturn
    //   174: aload_1
    //   175: astore 4
    //   177: aload_1
    //   178: aload 7
    //   180: aconst_null
    //   181: ldc 118
    //   183: invokeinterface 22 3 0
    //   188: putfield 120	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   191: aload_1
    //   192: astore 4
    //   194: aload 7
    //   196: aconst_null
    //   197: ldc 122
    //   199: invokeinterface 22 3 0
    //   204: astore 5
    //   206: aload 5
    //   208: ifnull +15 -> 223
    //   211: aload_1
    //   212: astore 4
    //   214: aload_1
    //   215: aload 5
    //   217: invokestatic 46	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   220: putfield 125	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_b_of_type_Boolean	Z
    //   223: aload_1
    //   224: astore 4
    //   226: aload 7
    //   228: aconst_null
    //   229: ldc 127
    //   231: invokeinterface 22 3 0
    //   236: astore 5
    //   238: aload_1
    //   239: astore 4
    //   241: aload 5
    //   243: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   246: ifne +12 -> 258
    //   249: aload_1
    //   250: astore 4
    //   252: aload_1
    //   253: aload 5
    //   255: putfield 129	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   258: aload_1
    //   259: astore 4
    //   261: aload_1
    //   262: aload 7
    //   264: aconst_null
    //   265: ldc 131
    //   267: invokeinterface 22 3 0
    //   272: putfield 132	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: aload_1
    //   276: astore 4
    //   278: aload 7
    //   280: aconst_null
    //   281: ldc 134
    //   283: invokeinterface 22 3 0
    //   288: astore 6
    //   290: aload 6
    //   292: ifnull +43 -> 335
    //   295: aload 6
    //   297: astore 5
    //   299: aload_1
    //   300: astore 4
    //   302: aload 6
    //   304: ldc 136
    //   306: invokevirtual 139	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   309: ifeq +14 -> 323
    //   312: aload_1
    //   313: astore 4
    //   315: aload 6
    //   317: iconst_2
    //   318: invokevirtual 143	java/lang/String:substring	(I)Ljava/lang/String;
    //   321: astore 5
    //   323: aload_1
    //   324: aload 5
    //   326: bipush 16
    //   328: invokestatic 149	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   331: l2i
    //   332: putfield 150	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_a_of_type_Int	I
    //   335: aload_1
    //   336: astore 4
    //   338: aload 7
    //   340: aconst_null
    //   341: ldc 152
    //   343: invokeinterface 22 3 0
    //   348: astore 5
    //   350: aload 5
    //   352: ifnull +15 -> 367
    //   355: aload_1
    //   356: astore 4
    //   358: aload_1
    //   359: aload 5
    //   361: invokestatic 35	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   364: putfield 155	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_d_of_type_Int	I
    //   367: aload_1
    //   368: astore 4
    //   370: aload 7
    //   372: aconst_null
    //   373: ldc 157
    //   375: invokeinterface 22 3 0
    //   380: astore 5
    //   382: aload 5
    //   384: ifnull +15 -> 399
    //   387: aload_1
    //   388: astore 4
    //   390: aload_1
    //   391: aload 5
    //   393: invokestatic 35	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   396: putfield 160	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_e_of_type_Int	I
    //   399: aload_1
    //   400: astore 4
    //   402: aload 7
    //   404: aconst_null
    //   405: ldc 162
    //   407: invokeinterface 22 3 0
    //   412: astore 5
    //   414: aload 5
    //   416: ifnull +15 -> 431
    //   419: aload_1
    //   420: astore 4
    //   422: aload_1
    //   423: aload 5
    //   425: invokestatic 35	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   428: putfield 165	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_f_of_type_Int	I
    //   431: aload_1
    //   432: astore 4
    //   434: aload 7
    //   436: aconst_null
    //   437: ldc 167
    //   439: invokeinterface 22 3 0
    //   444: astore 5
    //   446: aload 5
    //   448: ifnull +15 -> 463
    //   451: aload_1
    //   452: astore 4
    //   454: aload_1
    //   455: aload 5
    //   457: invokestatic 35	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   460: putfield 170	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_g_of_type_Int	I
    //   463: aload_1
    //   464: astore 4
    //   466: aload 7
    //   468: aconst_null
    //   469: ldc 172
    //   471: invokeinterface 22 3 0
    //   476: astore 5
    //   478: aload 5
    //   480: ifnull +15 -> 495
    //   483: aload_1
    //   484: astore 4
    //   486: aload_1
    //   487: aload 5
    //   489: invokestatic 46	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   492: putfield 174	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_e_of_type_Boolean	Z
    //   495: aload_1
    //   496: astore 4
    //   498: aload 7
    //   500: aconst_null
    //   501: ldc 176
    //   503: invokeinterface 22 3 0
    //   508: astore 5
    //   510: aload 5
    //   512: ifnull +15 -> 527
    //   515: aload_1
    //   516: astore 4
    //   518: aload_1
    //   519: aload 5
    //   521: invokestatic 35	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   524: putfield 179	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:i	I
    //   527: aload_1
    //   528: astore 4
    //   530: aload 7
    //   532: aconst_null
    //   533: ldc 181
    //   535: invokeinterface 22 3 0
    //   540: astore 5
    //   542: aload 5
    //   544: ifnull +15 -> 559
    //   547: aload_1
    //   548: astore 4
    //   550: aload_1
    //   551: aload 5
    //   553: invokestatic 35	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   556: putfield 184	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:j	I
    //   559: aload_1
    //   560: astore 4
    //   562: aload 7
    //   564: aconst_null
    //   565: ldc 186
    //   567: invokeinterface 22 3 0
    //   572: astore 5
    //   574: aload 5
    //   576: ifnull +15 -> 591
    //   579: aload_1
    //   580: astore 4
    //   582: aload_1
    //   583: aload 5
    //   585: invokestatic 46	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   588: putfield 188	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_f_of_type_Boolean	Z
    //   591: aload_1
    //   592: astore 4
    //   594: aload 7
    //   596: aconst_null
    //   597: ldc 190
    //   599: invokeinterface 22 3 0
    //   604: astore 5
    //   606: aload 5
    //   608: ifnull +15 -> 623
    //   611: aload_1
    //   612: astore 4
    //   614: aload_1
    //   615: aload 5
    //   617: invokestatic 35	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   620: putfield 193	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:k	I
    //   623: aload_1
    //   624: astore 4
    //   626: aload 7
    //   628: aconst_null
    //   629: ldc 195
    //   631: invokeinterface 22 3 0
    //   636: astore 5
    //   638: aload 5
    //   640: ifnull +15 -> 655
    //   643: aload_1
    //   644: astore 4
    //   646: aload_1
    //   647: aload 5
    //   649: invokestatic 46	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   652: putfield 197	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_g_of_type_Boolean	Z
    //   655: aload_1
    //   656: astore 4
    //   658: aload 7
    //   660: aconst_null
    //   661: ldc 199
    //   663: invokeinterface 22 3 0
    //   668: astore 6
    //   670: aload 6
    //   672: ifnull +76 -> 748
    //   675: aload 6
    //   677: astore 5
    //   679: aload_1
    //   680: astore 4
    //   682: aload 6
    //   684: ldc 201
    //   686: invokevirtual 204	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   689: ifne +47 -> 736
    //   692: aload_1
    //   693: astore 4
    //   695: new 206	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   702: astore 5
    //   704: aload_1
    //   705: astore 4
    //   707: aload 5
    //   709: ldc 201
    //   711: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload_1
    //   716: astore 4
    //   718: aload 5
    //   720: aload 6
    //   722: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_1
    //   727: astore 4
    //   729: aload 5
    //   731: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: astore 5
    //   736: aload_1
    //   737: astore 4
    //   739: aload_1
    //   740: aload 5
    //   742: invokestatic 219	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   745: putfield 222	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:l	I
    //   748: aload_1
    //   749: astore 4
    //   751: aload 7
    //   753: aconst_null
    //   754: ldc 224
    //   756: invokeinterface 22 3 0
    //   761: astore 6
    //   763: aload 6
    //   765: ifnull +76 -> 841
    //   768: aload 6
    //   770: astore 5
    //   772: aload_1
    //   773: astore 4
    //   775: aload 6
    //   777: ldc 201
    //   779: invokevirtual 204	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   782: ifne +47 -> 829
    //   785: aload_1
    //   786: astore 4
    //   788: new 206	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   795: astore 5
    //   797: aload_1
    //   798: astore 4
    //   800: aload 5
    //   802: ldc 201
    //   804: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload_1
    //   809: astore 4
    //   811: aload 5
    //   813: aload 6
    //   815: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload_1
    //   820: astore 4
    //   822: aload 5
    //   824: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: astore 5
    //   829: aload_1
    //   830: astore 4
    //   832: aload_1
    //   833: aload 5
    //   835: invokestatic 219	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   838: putfield 227	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:m	I
    //   841: aload_1
    //   842: astore 4
    //   844: aload 7
    //   846: aconst_null
    //   847: ldc 229
    //   849: invokeinterface 22 3 0
    //   854: astore 6
    //   856: aload 6
    //   858: ifnull +76 -> 934
    //   861: aload 6
    //   863: astore 5
    //   865: aload_1
    //   866: astore 4
    //   868: aload 6
    //   870: ldc 201
    //   872: invokevirtual 204	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   875: ifne +47 -> 922
    //   878: aload_1
    //   879: astore 4
    //   881: new 206	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   888: astore 5
    //   890: aload_1
    //   891: astore 4
    //   893: aload 5
    //   895: ldc 201
    //   897: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload_1
    //   902: astore 4
    //   904: aload 5
    //   906: aload 6
    //   908: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: pop
    //   912: aload_1
    //   913: astore 4
    //   915: aload 5
    //   917: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: astore 5
    //   922: aload_1
    //   923: astore 4
    //   925: aload_1
    //   926: aload 5
    //   928: invokestatic 219	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   931: putfield 232	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:n	I
    //   934: aload_1
    //   935: astore 4
    //   937: aload_1
    //   938: aload 7
    //   940: aconst_null
    //   941: ldc 234
    //   943: invokeinterface 22 3 0
    //   948: putfield 237	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:h	Ljava/lang/String;
    //   951: aload_1
    //   952: astore 4
    //   954: aload 7
    //   956: aconst_null
    //   957: ldc 239
    //   959: invokeinterface 22 3 0
    //   964: astore 6
    //   966: aload_1
    //   967: astore 5
    //   969: aload 6
    //   971: ifnull +222 -> 1193
    //   974: aload_1
    //   975: astore 4
    //   977: aload_1
    //   978: aload 6
    //   980: putfield 241	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   983: aload_1
    //   984: astore 5
    //   986: goto +207 -> 1193
    //   989: aload_1
    //   990: astore 4
    //   992: aload 6
    //   994: ldc 243
    //   996: invokevirtual 89	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   999: istore_3
    //   1000: iload_3
    //   1001: ifeq +26 -> 1027
    //   1004: aload_1
    //   1005: astore 4
    //   1007: aload_1
    //   1008: aload 7
    //   1010: aconst_null
    //   1011: ldc 245
    //   1013: invokeinterface 22 3 0
    //   1018: putfield 247	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1021: aload_1
    //   1022: astore 5
    //   1024: goto +169 -> 1193
    //   1027: aload_1
    //   1028: astore 4
    //   1030: aload 6
    //   1032: ldc 249
    //   1034: invokevirtual 89	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1037: ifeq +104 -> 1141
    //   1040: aload_1
    //   1041: astore 4
    //   1043: new 251	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText
    //   1046: dup
    //   1047: invokespecial 252	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText:<init>	()V
    //   1050: astore 5
    //   1052: aload_1
    //   1053: astore 4
    //   1055: aload 5
    //   1057: aload 7
    //   1059: aconst_null
    //   1060: ldc 131
    //   1062: invokeinterface 22 3 0
    //   1067: putfield 253	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1070: aload_1
    //   1071: astore 4
    //   1073: aload 7
    //   1075: aconst_null
    //   1076: ldc 29
    //   1078: invokeinterface 22 3 0
    //   1083: astore 6
    //   1085: aload_1
    //   1086: astore 4
    //   1088: aload 5
    //   1090: aload 6
    //   1092: putfield 254	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1095: aload 6
    //   1097: ifnull +15 -> 1112
    //   1100: aload_1
    //   1101: astore 4
    //   1103: aload_1
    //   1104: aload 6
    //   1106: invokestatic 35	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1109: putfield 256	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_c_of_type_Int	I
    //   1112: aload_1
    //   1113: astore 4
    //   1115: aload 5
    //   1117: aload 7
    //   1119: aconst_null
    //   1120: ldc 245
    //   1122: invokeinterface 22 3 0
    //   1127: putfield 257	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1130: aload_1
    //   1131: astore 4
    //   1133: aload_1
    //   1134: aload 5
    //   1136: putfield 260	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText	Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText;
    //   1139: aload_1
    //   1140: areturn
    //   1141: aload_1
    //   1142: astore 5
    //   1144: aload_1
    //   1145: astore 4
    //   1147: ldc_w 262
    //   1150: aload 6
    //   1152: invokevirtual 89	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1155: ifeq +38 -> 1193
    //   1158: aload_1
    //   1159: astore 4
    //   1161: aload_1
    //   1162: aload 7
    //   1164: aconst_null
    //   1165: ldc 245
    //   1167: invokeinterface 22 3 0
    //   1172: putfield 264	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1175: aload_1
    //   1176: astore 5
    //   1178: goto +15 -> 1193
    //   1181: aload_1
    //   1182: astore 4
    //   1184: new 110	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData
    //   1187: dup
    //   1188: invokespecial 265	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:<init>	()V
    //   1191: astore 5
    //   1193: aload 5
    //   1195: astore 4
    //   1197: aload 7
    //   1199: invokeinterface 94 1 0
    //   1204: istore_2
    //   1205: aload 5
    //   1207: astore_1
    //   1208: goto -1165 -> 43
    //   1211: astore_1
    //   1212: goto +7 -> 1219
    //   1215: astore_1
    //   1216: aconst_null
    //   1217: astore 4
    //   1219: aload_1
    //   1220: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   1223: aload 4
    //   1225: areturn
    //   1226: astore 4
    //   1228: goto -893 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1231	0	this	MagicfaceActionDecoder
    //   0	1231	1	paramString	String
    //   40	1165	2	i	int
    //   88	913	3	bool	boolean
    //   3	1221	4	localObject1	Object
    //   1226	1	4	localException	Exception
    //   61	1145	5	localObject2	Object
    //   76	1075	6	str	String
    //   16	1182	7	localXmlPullParser	XmlPullParser
    // Exception table:
    //   from	to	target	type
    //   69	78	1211	java/lang/Exception
    //   81	89	1211	java/lang/Exception
    //   96	108	1211	java/lang/Exception
    //   111	119	1211	java/lang/Exception
    //   122	131	1211	java/lang/Exception
    //   134	146	1211	java/lang/Exception
    //   154	160	1211	java/lang/Exception
    //   167	172	1211	java/lang/Exception
    //   177	191	1211	java/lang/Exception
    //   194	206	1211	java/lang/Exception
    //   214	223	1211	java/lang/Exception
    //   226	238	1211	java/lang/Exception
    //   241	249	1211	java/lang/Exception
    //   252	258	1211	java/lang/Exception
    //   261	275	1211	java/lang/Exception
    //   278	290	1211	java/lang/Exception
    //   302	312	1211	java/lang/Exception
    //   315	323	1211	java/lang/Exception
    //   338	350	1211	java/lang/Exception
    //   358	367	1211	java/lang/Exception
    //   370	382	1211	java/lang/Exception
    //   390	399	1211	java/lang/Exception
    //   402	414	1211	java/lang/Exception
    //   422	431	1211	java/lang/Exception
    //   434	446	1211	java/lang/Exception
    //   454	463	1211	java/lang/Exception
    //   466	478	1211	java/lang/Exception
    //   486	495	1211	java/lang/Exception
    //   498	510	1211	java/lang/Exception
    //   518	527	1211	java/lang/Exception
    //   530	542	1211	java/lang/Exception
    //   550	559	1211	java/lang/Exception
    //   562	574	1211	java/lang/Exception
    //   582	591	1211	java/lang/Exception
    //   594	606	1211	java/lang/Exception
    //   614	623	1211	java/lang/Exception
    //   626	638	1211	java/lang/Exception
    //   646	655	1211	java/lang/Exception
    //   658	670	1211	java/lang/Exception
    //   682	692	1211	java/lang/Exception
    //   695	704	1211	java/lang/Exception
    //   707	715	1211	java/lang/Exception
    //   718	726	1211	java/lang/Exception
    //   729	736	1211	java/lang/Exception
    //   739	748	1211	java/lang/Exception
    //   751	763	1211	java/lang/Exception
    //   775	785	1211	java/lang/Exception
    //   788	797	1211	java/lang/Exception
    //   800	808	1211	java/lang/Exception
    //   811	819	1211	java/lang/Exception
    //   822	829	1211	java/lang/Exception
    //   832	841	1211	java/lang/Exception
    //   844	856	1211	java/lang/Exception
    //   868	878	1211	java/lang/Exception
    //   881	890	1211	java/lang/Exception
    //   893	901	1211	java/lang/Exception
    //   904	912	1211	java/lang/Exception
    //   915	922	1211	java/lang/Exception
    //   925	934	1211	java/lang/Exception
    //   937	951	1211	java/lang/Exception
    //   954	966	1211	java/lang/Exception
    //   977	983	1211	java/lang/Exception
    //   992	1000	1211	java/lang/Exception
    //   1007	1021	1211	java/lang/Exception
    //   1030	1040	1211	java/lang/Exception
    //   1043	1052	1211	java/lang/Exception
    //   1055	1070	1211	java/lang/Exception
    //   1073	1085	1211	java/lang/Exception
    //   1088	1095	1211	java/lang/Exception
    //   1103	1112	1211	java/lang/Exception
    //   1115	1130	1211	java/lang/Exception
    //   1133	1139	1211	java/lang/Exception
    //   1147	1158	1211	java/lang/Exception
    //   1161	1175	1211	java/lang/Exception
    //   1184	1193	1211	java/lang/Exception
    //   1197	1205	1211	java/lang/Exception
    //   0	41	1215	java/lang/Exception
    //   323	335	1226	java/lang/Exception
  }
  
  public List<Action> a(String paramString)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new StringReader(paramString));
        int i = localXmlPullParser.getEventType();
        paramString = null;
        localObject2 = paramString;
        if (i != 1)
        {
          if (i != 0) {
            if (i != 2)
            {
              if (i != 3)
              {
                localObject2 = paramString;
                continue;
              }
              localObject1 = paramString;
            }
          }
          String str;
          try
          {
            str = localXmlPullParser.getName();
            localObject1 = paramString;
            if (str.equalsIgnoreCase("action"))
            {
              localObject1 = paramString;
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction = null;
              localObject2 = paramString;
            }
            else
            {
              localObject1 = paramString;
              if (str.equalsIgnoreCase("process"))
              {
                localObject1 = paramString;
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess = null;
                localObject2 = paramString;
              }
              else
              {
                localObject2 = paramString;
                localObject1 = paramString;
                if (str.equalsIgnoreCase("playRes"))
                {
                  localObject1 = paramString;
                  this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = null;
                  localObject2 = paramString;
                  continue;
                  localObject1 = paramString;
                  str = localXmlPullParser.getName();
                  localObject1 = paramString;
                  if (!str.equalsIgnoreCase("action"))
                  {
                    localObject1 = paramString;
                    if (!str.equalsIgnoreCase("ActionDef"))
                    {
                      localObject1 = paramString;
                      if (str.equalsIgnoreCase("process"))
                      {
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess = new ActionProcess();
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(null, "type");
                        localObject2 = paramString;
                        continue;
                      }
                      localObject1 = paramString;
                      boolean bool = str.equalsIgnoreCase("gravity");
                      if (bool)
                      {
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_JavaLangString = "gravity";
                        localObject1 = paramString;
                        localObject2 = localXmlPullParser.getAttributeValue(null, "value");
                        if (localObject2 != null)
                        {
                          localObject1 = paramString;
                          this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int = Integer.parseInt((String)localObject2);
                        }
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "stopType");
                        localObject2 = paramString;
                        if (str == null) {
                          continue;
                        }
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString = str;
                        localObject2 = paramString;
                        continue;
                      }
                      localObject1 = paramString;
                      if ("mic".equalsIgnoreCase(str))
                      {
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_JavaLangString = "mic";
                        localObject1 = paramString;
                        localObject2 = localXmlPullParser.getAttributeValue(null, "value");
                        if (localObject2 != null)
                        {
                          localObject1 = paramString;
                          this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int = Integer.parseInt((String)localObject2);
                        }
                        localObject1 = paramString;
                        localObject2 = localXmlPullParser.getAttributeValue(null, "replacevalue");
                        if (localObject2 != null)
                        {
                          localObject1 = paramString;
                          this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int = Integer.parseInt((String)localObject2);
                        }
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "stopType");
                        localObject2 = paramString;
                        if (str == null) {
                          continue;
                        }
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString = str;
                        localObject2 = paramString;
                        continue;
                      }
                      localObject1 = paramString;
                      if ("touch".equalsIgnoreCase(str))
                      {
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_JavaLangString = "touch";
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "stopType");
                        localObject2 = paramString;
                        if (str == null) {
                          continue;
                        }
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_c_of_type_JavaLangString = str;
                        localObject2 = paramString;
                        continue;
                      }
                      localObject1 = paramString;
                      bool = str.equalsIgnoreCase("value");
                      if (bool)
                      {
                        localObject1 = paramString;
                        localObject2 = new RecordCondition();
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "min");
                        if (str != null)
                        {
                          localObject1 = paramString;
                          ((RecordCondition)localObject2).jdField_a_of_type_Int = Integer.parseInt(str);
                        }
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "max");
                        if (str != null)
                        {
                          localObject1 = paramString;
                          ((RecordCondition)localObject2).jdField_b_of_type_Int = Integer.parseInt(str);
                          localObject1 = paramString;
                          if (((RecordCondition)localObject2).jdField_b_of_type_Int == -1)
                          {
                            localObject1 = paramString;
                            ((RecordCondition)localObject2).jdField_b_of_type_Int = 2147483647;
                          }
                        }
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "sum");
                        if (str != null)
                        {
                          localObject1 = paramString;
                          ((RecordCondition)localObject2).jdField_c_of_type_Int = Integer.parseInt(str);
                        }
                        localObject1 = paramString;
                        this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_JavaUtilList.add(localObject2);
                        localObject2 = paramString;
                        continue;
                      }
                      localObject1 = paramString;
                      if (str.equalsIgnoreCase("text"))
                      {
                        localObject2 = paramString;
                        continue;
                      }
                      localObject1 = paramString;
                      if (!str.equalsIgnoreCase("playRes"))
                      {
                        localObject1 = paramString;
                        if (!str.equalsIgnoreCase("playResDef"))
                        {
                          localObject1 = paramString;
                          if (str.equalsIgnoreCase("video"))
                          {
                            localObject2 = paramString;
                            localObject1 = paramString;
                            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "src");
                            localObject1 = paramString;
                            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_JavaLangString = ((String)localObject2);
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "srcAlpha");
                            localObject1 = paramString;
                            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_JavaLangString = ((String)localObject2);
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "duration");
                            if (localObject2 != null)
                            {
                              localObject1 = paramString;
                              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_f_of_type_Int = Integer.parseInt((String)localObject2);
                            }
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "fps");
                            if (localObject2 != null)
                            {
                              localObject1 = paramString;
                              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_g_of_type_Int = Integer.parseInt((String)localObject2);
                            }
                            localObject1 = paramString;
                            str = localXmlPullParser.getAttributeValue(null, "repeat");
                            localObject2 = paramString;
                            if (str == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_Int = Integer.parseInt(str);
                            localObject2 = paramString;
                            continue;
                          }
                          localObject1 = paramString;
                          if ("sound".equalsIgnoreCase(str))
                          {
                            localObject2 = paramString;
                            localObject1 = paramString;
                            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "src");
                            localObject1 = paramString;
                            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString = ((String)localObject2);
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "duration");
                            if (localObject2 != null)
                            {
                              localObject1 = paramString;
                              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_d_of_type_Int = Integer.parseInt((String)localObject2);
                            }
                            localObject1 = paramString;
                            str = localXmlPullParser.getAttributeValue(null, "repeat");
                            localObject2 = paramString;
                            if (str == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_e_of_type_Int = Integer.parseInt(str);
                            localObject2 = paramString;
                            continue;
                          }
                          localObject1 = paramString;
                          if ("vibrator".equalsIgnoreCase(str))
                          {
                            localObject2 = paramString;
                            localObject1 = paramString;
                            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_Boolean = true;
                            localObject1 = paramString;
                            str = localXmlPullParser.getAttributeValue(null, "time");
                            localObject2 = paramString;
                            if (str == null) {
                              continue;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          catch (Exception paramString) {}
        }
      }
      catch (Exception paramString)
      {
        localObject1 = null;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.h = Integer.parseInt(str);
        localObject2 = paramString;
      }
      catch (Exception localException)
      {
        localObject2 = paramString;
        continue;
      }
      Object localObject1 = paramString;
      if ("swipeGesture".equalsIgnoreCase(str))
      {
        localObject2 = paramString;
        localObject1 = paramString;
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess != null)
        {
          localObject1 = paramString;
          str = localXmlPullParser.getAttributeValue(null, "direction");
          localObject1 = paramString;
          if ("up".equalsIgnoreCase(str))
          {
            localObject1 = paramString;
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 2;
            localObject2 = paramString;
          }
          else
          {
            localObject1 = paramString;
            if ("down".equalsIgnoreCase(str))
            {
              localObject1 = paramString;
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 3;
              localObject2 = paramString;
            }
            else
            {
              localObject1 = paramString;
              if ("left".equalsIgnoreCase(str))
              {
                localObject1 = paramString;
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 0;
                localObject2 = paramString;
              }
              else
              {
                localObject2 = paramString;
                localObject1 = paramString;
                if ("right".equalsIgnoreCase(str))
                {
                  localObject1 = paramString;
                  this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 1;
                  localObject2 = paramString;
                }
              }
            }
          }
        }
      }
      else
      {
        localObject1 = paramString;
        if ("dbTapGesture".equalsIgnoreCase(str))
        {
          localObject2 = paramString;
          localObject1 = paramString;
          if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess != null)
          {
            localObject1 = paramString;
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 5;
            localObject2 = paramString;
          }
        }
        else
        {
          localObject2 = paramString;
          localObject1 = paramString;
          if ("tapGesture".equalsIgnoreCase(str))
          {
            localObject2 = paramString;
            localObject1 = paramString;
            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess != null)
            {
              localObject1 = paramString;
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int = 4;
              localObject2 = paramString;
              continue;
              localObject1 = paramString;
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = new MagicfacePlayRes();
              localObject1 = paramString;
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
              localObject1 = paramString;
              localObject2 = localXmlPullParser.getAttributeValue(null, "min");
              if (localObject2 != null)
              {
                localObject1 = paramString;
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_Int = Integer.parseInt((String)localObject2);
              }
              localObject1 = paramString;
              str = localXmlPullParser.getAttributeValue(null, "max");
              localObject2 = paramString;
              if (str != null)
              {
                localObject1 = paramString;
                this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_Int = Integer.parseInt(str);
                localObject2 = paramString;
                localObject1 = paramString;
                if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_Int == -1)
                {
                  localObject1 = paramString;
                  this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_b_of_type_Int = 2147483647;
                  localObject2 = paramString;
                  continue;
                  localObject1 = paramString;
                  this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction = new Action();
                  localObject1 = paramString;
                  paramString.add(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction);
                  localObject1 = paramString;
                  a(localXmlPullParser, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction);
                  localObject1 = paramString;
                  str = localXmlPullParser.getAttributeValue(null, "willDo");
                  localObject2 = paramString;
                  if (str != null)
                  {
                    localObject2 = paramString;
                    localObject1 = paramString;
                    if ("send".equalsIgnoreCase(str.trim()))
                    {
                      localObject1 = paramString;
                      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.d = true;
                      localObject2 = paramString;
                      continue;
                      localObject1 = paramString;
                      localObject2 = new ArrayList();
                    }
                  }
                }
              }
            }
          }
        }
      }
      localObject1 = localObject2;
      i = localXmlPullParser.next();
      paramString = (String)localObject2;
      continue;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("e=");
        ((StringBuilder)localObject2).append(paramString.getMessage());
        QLog.d("MagicfaceActionDecoder", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder
 * JD-Core Version:    0.7.0.1
 */