package com.tencent.xweb.xwalk.updater;

import com.tencent.xweb.internal.a.a;
import java.io.File;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkInitializer;

public class a
{
  static double a(Element paramElement, String paramString, double paramDouble)
  {
    if (paramElement == null) {
      return paramDouble;
    }
    paramElement = paramElement.getAttribute(paramString);
    if (paramElement != null)
    {
      if (paramElement.isEmpty()) {
        return paramDouble;
      }
      try
      {
        double d = Double.parseDouble(paramElement);
        return d;
      }
      catch (Exception paramElement)
      {
        paramString = new StringBuilder();
        paramString.append("safeGetDouble failed : ");
        paramString.append(paramElement.getMessage());
        Log.e("ConfigParser", paramString.toString());
      }
    }
    return paramDouble;
  }
  
  static float a(Element paramElement, String paramString, float paramFloat)
  {
    if (paramElement == null) {
      return paramFloat;
    }
    paramElement = paramElement.getAttribute(paramString);
    if (paramElement != null)
    {
      if (paramElement.isEmpty()) {
        return paramFloat;
      }
      try
      {
        float f = Float.parseFloat(paramElement);
        return f;
      }
      catch (Exception paramElement)
      {
        paramString = new StringBuilder();
        paramString.append("safeGetFloat failed : ");
        paramString.append(paramElement.getMessage());
        Log.e("ConfigParser", paramString.toString());
      }
    }
    return paramFloat;
  }
  
  static int a(Element paramElement, String paramString)
  {
    if (paramElement == null) {
      return 0;
    }
    paramElement = paramElement.getAttribute(paramString);
    if (paramElement != null)
    {
      if (paramElement.isEmpty()) {
        return 0;
      }
      try
      {
        int i = Integer.parseInt(paramElement);
        return i;
      }
      catch (Exception paramElement)
      {
        paramString = new StringBuilder();
        paramString.append("safeGetInt failed : ");
        paramString.append(paramElement.getMessage());
        Log.e("ConfigParser", paramString.toString());
      }
    }
    return 0;
  }
  
  /* Error */
  public static a.b a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: invokestatic 85	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 4
    //   14: aconst_null
    //   15: astore_3
    //   16: new 87	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_0
    //   25: new 92	com/tencent/xweb/xwalk/updater/a$b
    //   28: dup
    //   29: invokespecial 93	com/tencent/xweb/xwalk/updater/a$b:<init>	()V
    //   32: astore_3
    //   33: aload 7
    //   35: invokevirtual 97	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   38: aload_0
    //   39: invokevirtual 103	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   42: invokeinterface 109 1 0
    //   47: astore 4
    //   49: aload 4
    //   51: ifnonnull +23 -> 74
    //   54: ldc 111
    //   56: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: invokevirtual 120	java/io/FileInputStream:close	()V
    //   63: aconst_null
    //   64: areturn
    //   65: ldc 44
    //   67: ldc 122
    //   69: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aconst_null
    //   73: areturn
    //   74: aload_3
    //   75: aload 4
    //   77: ldc 124
    //   79: invokeinterface 14 2 0
    //   84: putfield 127	com/tencent/xweb/xwalk/updater/a$b:a	Ljava/lang/String;
    //   87: aload_3
    //   88: aload 4
    //   90: ldc 129
    //   92: invokeinterface 14 2 0
    //   97: putfield 132	com/tencent/xweb/xwalk/updater/a$b:b	Ljava/lang/String;
    //   100: aload_3
    //   101: getfield 127	com/tencent/xweb/xwalk/updater/a$b:a	Ljava/lang/String;
    //   104: ifnull +477 -> 581
    //   107: aload_3
    //   108: getfield 127	com/tencent/xweb/xwalk/updater/a$b:a	Ljava/lang/String;
    //   111: aload_1
    //   112: invokevirtual 136	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   115: ifne +6 -> 121
    //   118: goto +463 -> 581
    //   121: aload_3
    //   122: getfield 127	com/tencent/xweb/xwalk/updater/a$b:a	Ljava/lang/String;
    //   125: aload_3
    //   126: getfield 132	com/tencent/xweb/xwalk/updater/a$b:b	Ljava/lang/String;
    //   129: ldc 138
    //   131: invokestatic 143	com/tencent/xweb/util/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   134: ifne +30 -> 164
    //   137: ldc2_w 144
    //   140: iconst_1
    //   141: invokestatic 150	com/tencent/xweb/util/h:a	(JI)V
    //   144: ldc 152
    //   146: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: invokevirtual 120	java/io/FileInputStream:close	()V
    //   153: aconst_null
    //   154: areturn
    //   155: ldc 44
    //   157: ldc 122
    //   159: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aconst_null
    //   163: areturn
    //   164: aload_3
    //   165: aload 4
    //   167: ldc 154
    //   169: invokeinterface 14 2 0
    //   174: putfield 157	com/tencent/xweb/xwalk/updater/a$b:c	Ljava/lang/String;
    //   177: aload_3
    //   178: aload 4
    //   180: invokestatic 160	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/xwalk/updater/a$b;Lorg/w3c/dom/Element;)V
    //   183: aload 4
    //   185: ldc 162
    //   187: invokeinterface 166 2 0
    //   192: astore_1
    //   193: aload_1
    //   194: ifnull +368 -> 562
    //   197: aload_1
    //   198: invokeinterface 172 1 0
    //   203: ifeq +359 -> 562
    //   206: aload_3
    //   207: aload_1
    //   208: invokeinterface 172 1 0
    //   213: anewarray 174	com/tencent/xweb/xwalk/updater/a$f
    //   216: putfield 178	com/tencent/xweb/xwalk/updater/a$b:d	[Lcom/tencent/xweb/xwalk/updater/a$f;
    //   219: iconst_0
    //   220: istore_2
    //   221: iload_2
    //   222: aload_1
    //   223: invokeinterface 172 1 0
    //   228: if_icmpge +334 -> 562
    //   231: new 174	com/tencent/xweb/xwalk/updater/a$f
    //   234: dup
    //   235: invokespecial 179	com/tencent/xweb/xwalk/updater/a$f:<init>	()V
    //   238: astore 4
    //   240: aload_1
    //   241: iload_2
    //   242: invokeinterface 183 2 0
    //   247: checkcast 10	org/w3c/dom/Element
    //   250: astore 5
    //   252: aload 4
    //   254: aload 5
    //   256: ldc 185
    //   258: invokeinterface 14 2 0
    //   263: putfield 187	com/tencent/xweb/xwalk/updater/a$f:d	Ljava/lang/String;
    //   266: aload 4
    //   268: aload 5
    //   270: ldc 189
    //   272: invokeinterface 14 2 0
    //   277: putfield 192	com/tencent/xweb/xwalk/updater/a$f:k	Ljava/lang/String;
    //   280: aload 4
    //   282: getfield 195	com/tencent/xweb/xwalk/updater/a$f:c	Lcom/tencent/xweb/internal/a$b;
    //   285: aload 5
    //   287: invokestatic 198	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   290: aload 4
    //   292: aload 5
    //   294: ldc 200
    //   296: invokestatic 202	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   299: putfield 206	com/tencent/xweb/xwalk/updater/a$f:j	I
    //   302: aload 4
    //   304: aload 5
    //   306: ldc 208
    //   308: invokestatic 202	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   311: putfield 210	com/tencent/xweb/xwalk/updater/a$f:a	I
    //   314: aload 4
    //   316: aload 5
    //   318: ldc 212
    //   320: invokestatic 215	com/tencent/xweb/xwalk/updater/a:c	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   323: putfield 219	com/tencent/xweb/xwalk/updater/a$f:l	Z
    //   326: aload 4
    //   328: aload 5
    //   330: ldc 221
    //   332: invokestatic 215	com/tencent/xweb/xwalk/updater/a:c	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   335: putfield 224	com/tencent/xweb/xwalk/updater/a$f:n	Z
    //   338: aload 4
    //   340: aload 5
    //   342: ldc 226
    //   344: invokestatic 215	com/tencent/xweb/xwalk/updater/a:c	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   347: putfield 229	com/tencent/xweb/xwalk/updater/a$f:m	Z
    //   350: aload 4
    //   352: aload 5
    //   354: ldc 231
    //   356: invokestatic 202	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   359: putfield 233	com/tencent/xweb/xwalk/updater/a$f:b	I
    //   362: aload 4
    //   364: aload 5
    //   366: ldc 235
    //   368: invokeinterface 14 2 0
    //   373: putfield 238	com/tencent/xweb/xwalk/updater/a$f:g	Ljava/lang/String;
    //   376: aload 4
    //   378: aload 5
    //   380: ldc 240
    //   382: invokeinterface 14 2 0
    //   387: putfield 243	com/tencent/xweb/xwalk/updater/a$f:h	Ljava/lang/String;
    //   390: aload 4
    //   392: aload 5
    //   394: ldc 245
    //   396: invokeinterface 14 2 0
    //   401: putfield 248	com/tencent/xweb/xwalk/updater/a$f:u	Ljava/lang/String;
    //   404: aload 4
    //   406: aload 5
    //   408: ldc 250
    //   410: invokeinterface 14 2 0
    //   415: putfield 253	com/tencent/xweb/xwalk/updater/a$f:o	Ljava/lang/String;
    //   418: aload 4
    //   420: aload 5
    //   422: ldc 255
    //   424: invokeinterface 14 2 0
    //   429: putfield 258	com/tencent/xweb/xwalk/updater/a$f:p	Ljava/lang/String;
    //   432: aload 4
    //   434: aload 5
    //   436: ldc_w 260
    //   439: invokeinterface 14 2 0
    //   444: putfield 263	com/tencent/xweb/xwalk/updater/a$f:q	Ljava/lang/String;
    //   447: aload 4
    //   449: aload 5
    //   451: ldc_w 265
    //   454: ldc_w 266
    //   457: invokestatic 268	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;F)F
    //   460: putfield 271	com/tencent/xweb/xwalk/updater/a$f:e	F
    //   463: aload 4
    //   465: aload 5
    //   467: ldc_w 273
    //   470: ldc_w 266
    //   473: invokestatic 268	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;F)F
    //   476: putfield 276	com/tencent/xweb/xwalk/updater/a$f:f	F
    //   479: aload 5
    //   481: ldc_w 278
    //   484: invokeinterface 14 2 0
    //   489: astore 6
    //   491: aload 6
    //   493: ifnull +21 -> 514
    //   496: aload 6
    //   498: invokevirtual 20	java/lang/String:isEmpty	()Z
    //   501: ifne +13 -> 514
    //   504: aload 4
    //   506: aload 6
    //   508: invokestatic 283	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   511: putfield 286	com/tencent/xweb/xwalk/updater/a$f:s	Z
    //   514: aload 4
    //   516: aload 5
    //   518: ldc_w 288
    //   521: invokestatic 215	com/tencent/xweb/xwalk/updater/a:c	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   524: putfield 291	com/tencent/xweb/xwalk/updater/a$f:t	Z
    //   527: aload 5
    //   529: aload 4
    //   531: getfield 295	com/tencent/xweb/xwalk/updater/a$f:r	Lcom/tencent/xweb/xwalk/updater/a$g;
    //   534: invokestatic 298	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Lcom/tencent/xweb/xwalk/updater/a$g;)V
    //   537: aload 4
    //   539: aload 5
    //   541: invokestatic 301	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   544: putfield 305	com/tencent/xweb/xwalk/updater/a$f:i	[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   547: aload_3
    //   548: getfield 178	com/tencent/xweb/xwalk/updater/a$b:d	[Lcom/tencent/xweb/xwalk/updater/a$f;
    //   551: iload_2
    //   552: aload 4
    //   554: aastore
    //   555: iload_2
    //   556: iconst_1
    //   557: iadd
    //   558: istore_2
    //   559: goto -338 -> 221
    //   562: aload_3
    //   563: astore 4
    //   565: aload_0
    //   566: invokevirtual 120	java/io/FileInputStream:close	()V
    //   569: aload_3
    //   570: areturn
    //   571: ldc 44
    //   573: ldc 122
    //   575: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload 4
    //   580: areturn
    //   581: ldc2_w 306
    //   584: iconst_1
    //   585: invokestatic 150	com/tencent/xweb/util/h:a	(JI)V
    //   588: ldc_w 309
    //   591: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   594: aload_0
    //   595: invokevirtual 120	java/io/FileInputStream:close	()V
    //   598: aconst_null
    //   599: areturn
    //   600: ldc 44
    //   602: ldc 122
    //   604: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: aconst_null
    //   608: areturn
    //   609: astore 4
    //   611: aload_3
    //   612: astore_1
    //   613: aload 4
    //   615: astore_3
    //   616: goto +29 -> 645
    //   619: astore_1
    //   620: aload_3
    //   621: astore 4
    //   623: aload_1
    //   624: astore_3
    //   625: goto +30 -> 655
    //   628: astore 4
    //   630: aload_3
    //   631: astore_1
    //   632: aload 4
    //   634: astore_3
    //   635: goto +34 -> 669
    //   638: astore_1
    //   639: goto +141 -> 780
    //   642: astore_3
    //   643: aconst_null
    //   644: astore_1
    //   645: aload_3
    //   646: astore 4
    //   648: goto +40 -> 688
    //   651: astore_3
    //   652: aconst_null
    //   653: astore 4
    //   655: aload_0
    //   656: astore_1
    //   657: aload 4
    //   659: astore_0
    //   660: aload_3
    //   661: astore 4
    //   663: goto +63 -> 726
    //   666: astore_3
    //   667: aconst_null
    //   668: astore_1
    //   669: aload_3
    //   670: astore 4
    //   672: goto +81 -> 753
    //   675: astore_1
    //   676: aload_3
    //   677: astore_0
    //   678: goto +102 -> 780
    //   681: astore 4
    //   683: aconst_null
    //   684: astore_1
    //   685: aload 5
    //   687: astore_0
    //   688: aload_0
    //   689: astore_3
    //   690: ldc 111
    //   692: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   695: aload_0
    //   696: astore_3
    //   697: aload 4
    //   699: invokevirtual 312	java/io/IOException:printStackTrace	()V
    //   702: aload_1
    //   703: astore_3
    //   704: aload_0
    //   705: ifnull +73 -> 778
    //   708: aload_0
    //   709: astore_3
    //   710: aload_1
    //   711: astore 4
    //   713: aload_3
    //   714: invokevirtual 120	java/io/FileInputStream:close	()V
    //   717: aload_1
    //   718: areturn
    //   719: astore 4
    //   721: aconst_null
    //   722: astore_0
    //   723: aload 6
    //   725: astore_1
    //   726: aload_1
    //   727: astore_3
    //   728: ldc 111
    //   730: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   733: aload_1
    //   734: astore_3
    //   735: aload 4
    //   737: invokevirtual 313	org/xml/sax/SAXException:printStackTrace	()V
    //   740: aload_0
    //   741: astore_3
    //   742: aload_1
    //   743: ifnull +35 -> 778
    //   746: aload_1
    //   747: astore_3
    //   748: aload_0
    //   749: astore_1
    //   750: goto -40 -> 710
    //   753: aload_0
    //   754: astore_3
    //   755: ldc 111
    //   757: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   760: aload_0
    //   761: astore_3
    //   762: aload 4
    //   764: invokevirtual 314	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   767: aload_1
    //   768: astore_3
    //   769: aload_0
    //   770: ifnull +8 -> 778
    //   773: aload_0
    //   774: astore_3
    //   775: goto -65 -> 710
    //   778: aload_3
    //   779: areturn
    //   780: aload_0
    //   781: ifnull +17 -> 798
    //   784: aload_0
    //   785: invokevirtual 120	java/io/FileInputStream:close	()V
    //   788: goto +10 -> 798
    //   791: ldc 44
    //   793: ldc 122
    //   795: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   798: goto +5 -> 803
    //   801: aload_1
    //   802: athrow
    //   803: goto -2 -> 801
    //   806: astore_0
    //   807: goto -742 -> 65
    //   810: astore_0
    //   811: goto -656 -> 155
    //   814: astore_0
    //   815: goto -244 -> 571
    //   818: astore_0
    //   819: goto -219 -> 600
    //   822: astore_0
    //   823: goto -32 -> 791
    //   826: astore_3
    //   827: aconst_null
    //   828: astore_1
    //   829: aload 4
    //   831: astore_0
    //   832: aload_3
    //   833: astore 4
    //   835: goto -82 -> 753
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	paramFile	File
    //   0	838	1	paramString	String
    //   220	339	2	i	int
    //   15	620	3	localObject1	Object
    //   642	4	3	localIOException1	java.io.IOException
    //   651	10	3	localSAXException1	org.xml.sax.SAXException
    //   666	11	3	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   689	90	3	localObject2	Object
    //   826	7	3	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   12	567	4	localObject3	Object
    //   609	5	4	localIOException2	java.io.IOException
    //   621	1	4	localObject4	Object
    //   628	5	4	localParserConfigurationException3	javax.xml.parsers.ParserConfigurationException
    //   646	25	4	localObject5	Object
    //   681	17	4	localIOException3	java.io.IOException
    //   711	1	4	str1	String
    //   719	111	4	localSAXException2	org.xml.sax.SAXException
    //   833	1	4	localObject6	Object
    //   6	680	5	localElement	Element
    //   9	715	6	str2	String
    //   3	31	7	localDocumentBuilderFactory	javax.xml.parsers.DocumentBuilderFactory
    // Exception table:
    //   from	to	target	type
    //   33	49	609	java/io/IOException
    //   54	59	609	java/io/IOException
    //   74	118	609	java/io/IOException
    //   121	149	609	java/io/IOException
    //   164	193	609	java/io/IOException
    //   197	219	609	java/io/IOException
    //   221	491	609	java/io/IOException
    //   496	514	609	java/io/IOException
    //   514	555	609	java/io/IOException
    //   581	594	609	java/io/IOException
    //   33	49	619	org/xml/sax/SAXException
    //   54	59	619	org/xml/sax/SAXException
    //   74	118	619	org/xml/sax/SAXException
    //   121	149	619	org/xml/sax/SAXException
    //   164	193	619	org/xml/sax/SAXException
    //   197	219	619	org/xml/sax/SAXException
    //   221	491	619	org/xml/sax/SAXException
    //   496	514	619	org/xml/sax/SAXException
    //   514	555	619	org/xml/sax/SAXException
    //   581	594	619	org/xml/sax/SAXException
    //   33	49	628	javax/xml/parsers/ParserConfigurationException
    //   54	59	628	javax/xml/parsers/ParserConfigurationException
    //   74	118	628	javax/xml/parsers/ParserConfigurationException
    //   121	149	628	javax/xml/parsers/ParserConfigurationException
    //   164	193	628	javax/xml/parsers/ParserConfigurationException
    //   197	219	628	javax/xml/parsers/ParserConfigurationException
    //   221	491	628	javax/xml/parsers/ParserConfigurationException
    //   496	514	628	javax/xml/parsers/ParserConfigurationException
    //   514	555	628	javax/xml/parsers/ParserConfigurationException
    //   581	594	628	javax/xml/parsers/ParserConfigurationException
    //   25	33	638	finally
    //   33	49	638	finally
    //   54	59	638	finally
    //   74	118	638	finally
    //   121	149	638	finally
    //   164	193	638	finally
    //   197	219	638	finally
    //   221	491	638	finally
    //   496	514	638	finally
    //   514	555	638	finally
    //   581	594	638	finally
    //   25	33	642	java/io/IOException
    //   25	33	651	org/xml/sax/SAXException
    //   25	33	666	javax/xml/parsers/ParserConfigurationException
    //   16	25	675	finally
    //   690	695	675	finally
    //   697	702	675	finally
    //   728	733	675	finally
    //   735	740	675	finally
    //   755	760	675	finally
    //   762	767	675	finally
    //   16	25	681	java/io/IOException
    //   16	25	719	org/xml/sax/SAXException
    //   59	63	806	java/lang/Exception
    //   149	153	810	java/lang/Exception
    //   565	569	814	java/lang/Exception
    //   713	717	814	java/lang/Exception
    //   594	598	818	java/lang/Exception
    //   784	788	822	java/lang/Exception
    //   16	25	826	javax/xml/parsers/ParserConfigurationException
  }
  
  public static a.b a(String paramString)
  {
    if (paramString == null)
    {
      XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
      return null;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
      return null;
    }
    return a(paramString, a(paramString, (int)paramString.length(), "<Versions>"));
  }
  
  /* Error */
  static String a(File paramFile, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iload_1
    //   1: newarray byte
    //   3: astore 4
    //   5: new 87	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore_0
    //   14: aload_0
    //   15: aload 4
    //   17: iconst_0
    //   18: aload 4
    //   20: arraylength
    //   21: invokevirtual 341	java/io/FileInputStream:read	([BII)I
    //   24: istore_1
    //   25: aload 4
    //   27: arraylength
    //   28: istore_3
    //   29: iload_1
    //   30: iload_3
    //   31: if_icmpeq +19 -> 50
    //   34: aload_0
    //   35: invokevirtual 120	java/io/FileInputStream:close	()V
    //   38: aconst_null
    //   39: areturn
    //   40: ldc 44
    //   42: ldc_w 343
    //   45: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aconst_null
    //   49: areturn
    //   50: new 16	java/lang/String
    //   53: dup
    //   54: aload 4
    //   56: iconst_0
    //   57: iload_1
    //   58: invokespecial 346	java/lang/String:<init>	([BII)V
    //   61: astore 4
    //   63: aload 4
    //   65: aload_2
    //   66: invokevirtual 349	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   69: istore_1
    //   70: iload_1
    //   71: ifge +19 -> 90
    //   74: aload_0
    //   75: invokevirtual 120	java/io/FileInputStream:close	()V
    //   78: aconst_null
    //   79: areturn
    //   80: ldc 44
    //   82: ldc_w 343
    //   85: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aconst_null
    //   89: areturn
    //   90: aload 4
    //   92: iload_1
    //   93: invokevirtual 353	java/lang/String:substring	(I)Ljava/lang/String;
    //   96: astore_2
    //   97: ldc_w 355
    //   100: invokestatic 361	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   103: aload_2
    //   104: invokevirtual 365	java/lang/String:getBytes	()[B
    //   107: invokevirtual 369	java/security/MessageDigest:digest	([B)[B
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +100 -> 212
    //   115: aload_2
    //   116: arraylength
    //   117: ifne +6 -> 123
    //   120: goto +92 -> 212
    //   123: new 28	java/lang/StringBuilder
    //   126: dup
    //   127: aload_2
    //   128: arraylength
    //   129: invokespecial 372	java/lang/StringBuilder:<init>	(I)V
    //   132: astore 4
    //   134: aload_2
    //   135: arraylength
    //   136: istore_3
    //   137: iconst_0
    //   138: istore_1
    //   139: iload_1
    //   140: iload_3
    //   141: if_icmpge +46 -> 187
    //   144: aload_2
    //   145: iload_1
    //   146: baload
    //   147: sipush 255
    //   150: iand
    //   151: invokestatic 375	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   154: astore 5
    //   156: aload 5
    //   158: invokevirtual 377	java/lang/String:length	()I
    //   161: iconst_1
    //   162: if_icmpne +10 -> 172
    //   165: aload 4
    //   167: iconst_0
    //   168: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 4
    //   174: aload 5
    //   176: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: iload_1
    //   181: iconst_1
    //   182: iadd
    //   183: istore_1
    //   184: goto -45 -> 139
    //   187: aload 4
    //   189: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokevirtual 383	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   195: astore_2
    //   196: aload_0
    //   197: invokevirtual 120	java/io/FileInputStream:close	()V
    //   200: aload_2
    //   201: areturn
    //   202: ldc 44
    //   204: ldc_w 343
    //   207: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload_2
    //   211: areturn
    //   212: aload_0
    //   213: invokevirtual 120	java/io/FileInputStream:close	()V
    //   216: aconst_null
    //   217: areturn
    //   218: ldc 44
    //   220: ldc_w 343
    //   223: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aconst_null
    //   227: areturn
    //   228: astore 4
    //   230: aload_0
    //   231: astore_2
    //   232: aload 4
    //   234: astore_0
    //   235: goto +6 -> 241
    //   238: astore_0
    //   239: aconst_null
    //   240: astore_2
    //   241: aload_2
    //   242: ifnull +18 -> 260
    //   245: aload_2
    //   246: invokevirtual 120	java/io/FileInputStream:close	()V
    //   249: goto +11 -> 260
    //   252: ldc 44
    //   254: ldc_w 343
    //   257: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_0
    //   261: athrow
    //   262: aconst_null
    //   263: astore_0
    //   264: aload_0
    //   265: ifnull +17 -> 282
    //   268: aload_0
    //   269: invokevirtual 120	java/io/FileInputStream:close	()V
    //   272: aconst_null
    //   273: areturn
    //   274: ldc 44
    //   276: ldc_w 343
    //   279: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aconst_null
    //   283: areturn
    //   284: astore_0
    //   285: goto -23 -> 262
    //   288: astore_2
    //   289: goto -25 -> 264
    //   292: astore_0
    //   293: goto -253 -> 40
    //   296: astore_0
    //   297: goto -217 -> 80
    //   300: astore_0
    //   301: goto -99 -> 202
    //   304: astore_0
    //   305: goto -87 -> 218
    //   308: astore_2
    //   309: goto -57 -> 252
    //   312: astore_0
    //   313: goto -39 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramFile	File
    //   0	316	1	paramInt	int
    //   0	316	2	paramString	String
    //   28	114	3	i	int
    //   3	185	4	localObject1	Object
    //   228	5	4	localObject2	Object
    //   154	21	5	str	String
    // Exception table:
    //   from	to	target	type
    //   14	29	228	finally
    //   50	70	228	finally
    //   90	111	228	finally
    //   115	120	228	finally
    //   123	137	228	finally
    //   144	172	228	finally
    //   172	180	228	finally
    //   187	196	228	finally
    //   0	14	238	finally
    //   0	14	284	java/lang/Exception
    //   14	29	288	java/lang/Exception
    //   50	70	288	java/lang/Exception
    //   90	111	288	java/lang/Exception
    //   115	120	288	java/lang/Exception
    //   123	137	288	java/lang/Exception
    //   144	172	288	java/lang/Exception
    //   172	180	288	java/lang/Exception
    //   187	196	288	java/lang/Exception
    //   34	38	292	java/lang/Exception
    //   74	78	296	java/lang/Exception
    //   196	200	300	java/lang/Exception
    //   212	216	304	java/lang/Exception
    //   245	249	308	java/lang/Exception
    //   268	272	312	java/lang/Exception
  }
  
  static void a(a.a parama, Element paramElement)
  {
    parama.b = paramElement.getAttribute("optype");
    parama.c = paramElement.getAttribute("opvalue");
    parama.d = paramElement.getAttribute("module");
    a(parama.a, paramElement);
  }
  
  static void a(com.tencent.xweb.internal.a.b paramb, Element paramElement)
  {
    paramb.c = a(paramElement, "apkMin");
    paramb.d = a(paramElement, "apkMax");
    paramb.e = a(paramElement, "preDownApkMin");
    paramb.f = a(paramElement, "preDownApkMax");
    paramb.a = a(paramElement, "sdkMin");
    paramb.b = a(paramElement, "sdkMax");
    paramb.g = a(paramElement, "apiMin");
    paramb.h = a(paramElement, "apiMax");
    paramb.i = a(paramElement, "targetApiMin");
    paramb.j = a(paramElement, "targetApiMax");
    paramb.k = paramElement.getAttribute("forbidDeviceRegex");
    paramb.l = paramElement.getAttribute("whiteDeviceRegex");
    paramb.v = paramElement.getAttribute("forbidAppRegex");
    paramb.w = paramElement.getAttribute("whiteAppRegex");
    paramb.m = a(paramElement, "grayMin");
    paramb.n = a(paramElement, "grayMax");
    paramb.o = a(paramElement, "dayGrayMin");
    paramb.p = a(paramElement, "dayGrayMax");
    paramb.q = a(paramElement, "chromeMin");
    paramb.r = a(paramElement, "chromeMax");
    paramb.s = a(paramElement, "usertype");
    paramb.x = a(paramElement, "x5sdkmin");
    paramb.y = a(paramElement, "x5sdkmax");
    paramb.z = a(paramElement, "x5coremin");
    paramb.A = a(paramElement, "x5coremax");
    paramb.t = a(paramElement, "hoursStart", -1.0D);
    paramb.u = a(paramElement, "hoursEnd", -1.0D);
    paramb.C = paramElement.getAttribute("runtimeAbis");
    paramb.E = paramElement.getAttribute("blackRuntimeAbis");
    paramb.B = paramElement.getAttribute("deviceAbis");
    paramb.D = paramElement.getAttribute("blackDeviceAbis");
    paramb.F = b(paramElement, "appClientVerMin");
    paramb.G = b(paramElement, "appClientVerMax");
    paramb.H = paramElement.getAttribute("appInfoWhiteList");
    paramb.I = paramElement.getAttribute("appInfoBlackList");
  }
  
  static void a(a.b paramb, Element paramElement)
  {
    if (paramb == null) {
      return;
    }
    paramb.e = b(paramElement);
  }
  
  static void a(Element paramElement, a.g paramg)
  {
    if (paramg == null) {
      return;
    }
    paramElement = paramElement.getElementsByTagName("Description");
    if ((paramElement != null) && (paramElement.getLength() != 0)) {
      paramg.a = ((Element)paramElement.item(0)).getAttribute("versionStr");
    }
  }
  
  static a.c[] a(Element paramElement)
  {
    paramElement = paramElement.getElementsByTagName("Patch");
    if ((paramElement != null) && (paramElement.getLength() != 0))
    {
      a.c[] arrayOfc = new a.c[paramElement.getLength()];
      int i = 0;
      while (i < paramElement.getLength())
      {
        a.c localc = new a.c();
        Element localElement = (Element)paramElement.item(i);
        localc.b = localElement.getAttribute("url");
        localc.a = a(localElement, "targetVersion");
        localc.c = localElement.getAttribute("md5");
        localc.d = c(localElement, "useCellular");
        localc.e = c(localElement, "useCdn");
        arrayOfc[i] = localc;
        i += 1;
      }
      return arrayOfc;
    }
    return null;
  }
  
  static int b(Element paramElement, String paramString)
  {
    if (paramElement == null) {
      return 0;
    }
    paramString = paramElement.getAttribute(paramString);
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return 0;
      }
      paramElement = paramString;
      if (paramString.contains("0x")) {
        paramElement = paramString.trim().substring(2);
      }
      try
      {
        int i = Integer.parseInt(paramElement, 16);
        return i;
      }
      catch (Exception paramElement)
      {
        paramString = new StringBuilder();
        paramString.append("safeGetIntFromHex failed");
        paramString.append(paramElement.getMessage());
        Log.e("ConfigParser", paramString.toString());
      }
    }
    return 0;
  }
  
  /* Error */
  private static a.d b(File paramFile, String paramString)
  {
    // Byte code:
    //   0: invokestatic 85	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 4
    //   14: aconst_null
    //   15: astore_3
    //   16: new 87	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_0
    //   25: new 599	com/tencent/xweb/xwalk/updater/a$d
    //   28: dup
    //   29: invokespecial 600	com/tencent/xweb/xwalk/updater/a$d:<init>	()V
    //   32: astore_3
    //   33: aload 7
    //   35: invokevirtual 97	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   38: aload_0
    //   39: invokevirtual 103	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   42: invokeinterface 109 1 0
    //   47: astore 4
    //   49: aload 4
    //   51: ifnonnull +25 -> 76
    //   54: ldc_w 602
    //   57: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: invokevirtual 120	java/io/FileInputStream:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: ldc 44
    //   68: ldc_w 604
    //   71: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aconst_null
    //   75: areturn
    //   76: aload_3
    //   77: aload 4
    //   79: ldc 124
    //   81: invokeinterface 14 2 0
    //   86: putfield 605	com/tencent/xweb/xwalk/updater/a$d:a	Ljava/lang/String;
    //   89: aload_3
    //   90: aload 4
    //   92: ldc 129
    //   94: invokeinterface 14 2 0
    //   99: putfield 606	com/tencent/xweb/xwalk/updater/a$d:b	Ljava/lang/String;
    //   102: aload_3
    //   103: getfield 605	com/tencent/xweb/xwalk/updater/a$d:a	Ljava/lang/String;
    //   106: ifnull +427 -> 533
    //   109: aload_3
    //   110: getfield 605	com/tencent/xweb/xwalk/updater/a$d:a	Ljava/lang/String;
    //   113: aload_1
    //   114: invokevirtual 136	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   117: ifne +6 -> 123
    //   120: goto +413 -> 533
    //   123: aload_3
    //   124: getfield 605	com/tencent/xweb/xwalk/updater/a$d:a	Ljava/lang/String;
    //   127: aload_3
    //   128: getfield 606	com/tencent/xweb/xwalk/updater/a$d:b	Ljava/lang/String;
    //   131: ldc 138
    //   133: invokestatic 143	com/tencent/xweb/util/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   136: ifne +32 -> 168
    //   139: ldc2_w 144
    //   142: iconst_1
    //   143: invokestatic 150	com/tencent/xweb/util/h:a	(JI)V
    //   146: ldc_w 608
    //   149: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: invokevirtual 120	java/io/FileInputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: ldc 44
    //   160: ldc_w 604
    //   163: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aconst_null
    //   167: areturn
    //   168: aload_3
    //   169: aload 4
    //   171: ldc 154
    //   173: invokeinterface 14 2 0
    //   178: putfield 609	com/tencent/xweb/xwalk/updater/a$d:c	Ljava/lang/String;
    //   181: aload_3
    //   182: aload 4
    //   184: invokestatic 556	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/a$a;
    //   187: putfield 610	com/tencent/xweb/xwalk/updater/a$d:e	[Lcom/tencent/xweb/internal/a$a;
    //   190: aload 4
    //   192: ldc_w 612
    //   195: invokeinterface 166 2 0
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +311 -> 513
    //   205: aload_1
    //   206: invokeinterface 172 1 0
    //   211: ifeq +302 -> 513
    //   214: aload_3
    //   215: aload_1
    //   216: invokeinterface 172 1 0
    //   221: anewarray 614	com/tencent/xweb/xwalk/updater/a$e
    //   224: putfield 617	com/tencent/xweb/xwalk/updater/a$d:d	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   227: iconst_0
    //   228: istore_2
    //   229: iload_2
    //   230: aload_1
    //   231: invokeinterface 172 1 0
    //   236: if_icmpge +277 -> 513
    //   239: aload_1
    //   240: iload_2
    //   241: invokeinterface 183 2 0
    //   246: checkcast 10	org/w3c/dom/Element
    //   249: astore 4
    //   251: new 614	com/tencent/xweb/xwalk/updater/a$e
    //   254: dup
    //   255: invokespecial 618	com/tencent/xweb/xwalk/updater/a$e:<init>	()V
    //   258: astore 5
    //   260: aload 5
    //   262: aload 4
    //   264: ldc_w 620
    //   267: invokeinterface 14 2 0
    //   272: putfield 622	com/tencent/xweb/xwalk/updater/a$e:r	Ljava/lang/String;
    //   275: aload 5
    //   277: aload 4
    //   279: ldc 208
    //   281: invokestatic 202	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   284: putfield 623	com/tencent/xweb/xwalk/updater/a$e:a	I
    //   287: aload 5
    //   289: aload 4
    //   291: ldc 185
    //   293: invokeinterface 14 2 0
    //   298: putfield 624	com/tencent/xweb/xwalk/updater/a$e:d	Ljava/lang/String;
    //   301: aload 5
    //   303: aload 4
    //   305: ldc 189
    //   307: invokeinterface 14 2 0
    //   312: putfield 625	com/tencent/xweb/xwalk/updater/a$e:k	Ljava/lang/String;
    //   315: aload 5
    //   317: aload 4
    //   319: ldc 212
    //   321: invokestatic 215	com/tencent/xweb/xwalk/updater/a:c	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   324: putfield 626	com/tencent/xweb/xwalk/updater/a$e:l	Z
    //   327: aload 5
    //   329: aload 4
    //   331: ldc 221
    //   333: invokestatic 215	com/tencent/xweb/xwalk/updater/a:c	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   336: putfield 627	com/tencent/xweb/xwalk/updater/a$e:n	Z
    //   339: aload 5
    //   341: aload 4
    //   343: ldc 226
    //   345: invokestatic 215	com/tencent/xweb/xwalk/updater/a:c	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   348: putfield 628	com/tencent/xweb/xwalk/updater/a$e:m	Z
    //   351: aload 5
    //   353: aload 4
    //   355: ldc 200
    //   357: invokestatic 202	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   360: putfield 629	com/tencent/xweb/xwalk/updater/a$e:j	I
    //   363: aload 5
    //   365: aload 4
    //   367: ldc 231
    //   369: invokestatic 202	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   372: putfield 630	com/tencent/xweb/xwalk/updater/a$e:b	I
    //   375: aload 5
    //   377: aload 4
    //   379: ldc 235
    //   381: invokeinterface 14 2 0
    //   386: putfield 631	com/tencent/xweb/xwalk/updater/a$e:g	Ljava/lang/String;
    //   389: aload 5
    //   391: aload 4
    //   393: ldc 240
    //   395: invokeinterface 14 2 0
    //   400: putfield 632	com/tencent/xweb/xwalk/updater/a$e:h	Ljava/lang/String;
    //   403: aload 5
    //   405: aload 4
    //   407: ldc 250
    //   409: invokeinterface 14 2 0
    //   414: putfield 633	com/tencent/xweb/xwalk/updater/a$e:o	Ljava/lang/String;
    //   417: aload 5
    //   419: aload 4
    //   421: ldc 255
    //   423: invokeinterface 14 2 0
    //   428: putfield 634	com/tencent/xweb/xwalk/updater/a$e:p	Ljava/lang/String;
    //   431: aload 5
    //   433: aload 4
    //   435: ldc_w 260
    //   438: invokeinterface 14 2 0
    //   443: putfield 635	com/tencent/xweb/xwalk/updater/a$e:q	Ljava/lang/String;
    //   446: aload 5
    //   448: aload 4
    //   450: ldc_w 265
    //   453: ldc_w 266
    //   456: invokestatic 268	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;F)F
    //   459: putfield 636	com/tencent/xweb/xwalk/updater/a$e:e	F
    //   462: aload 5
    //   464: aload 4
    //   466: ldc_w 273
    //   469: ldc_w 266
    //   472: invokestatic 268	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;F)F
    //   475: putfield 637	com/tencent/xweb/xwalk/updater/a$e:f	F
    //   478: aload 5
    //   480: getfield 638	com/tencent/xweb/xwalk/updater/a$e:c	Lcom/tencent/xweb/internal/a$b;
    //   483: aload 4
    //   485: invokestatic 198	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   488: aload 5
    //   490: aload 4
    //   492: invokestatic 301	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   495: putfield 639	com/tencent/xweb/xwalk/updater/a$e:i	[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   498: aload_3
    //   499: getfield 617	com/tencent/xweb/xwalk/updater/a$d:d	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   502: iload_2
    //   503: aload 5
    //   505: aastore
    //   506: iload_2
    //   507: iconst_1
    //   508: iadd
    //   509: istore_2
    //   510: goto -281 -> 229
    //   513: aload_3
    //   514: astore 4
    //   516: aload_0
    //   517: invokevirtual 120	java/io/FileInputStream:close	()V
    //   520: aload_3
    //   521: areturn
    //   522: ldc 44
    //   524: ldc_w 604
    //   527: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload 4
    //   532: areturn
    //   533: ldc_w 641
    //   536: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   539: aload_0
    //   540: invokevirtual 120	java/io/FileInputStream:close	()V
    //   543: aconst_null
    //   544: areturn
    //   545: ldc 44
    //   547: ldc_w 604
    //   550: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: aconst_null
    //   554: areturn
    //   555: astore 4
    //   557: aload_3
    //   558: astore_1
    //   559: aload 4
    //   561: astore_3
    //   562: goto +29 -> 591
    //   565: astore_1
    //   566: aload_3
    //   567: astore 4
    //   569: aload_1
    //   570: astore_3
    //   571: goto +30 -> 601
    //   574: astore 4
    //   576: aload_3
    //   577: astore_1
    //   578: aload 4
    //   580: astore_3
    //   581: goto +34 -> 615
    //   584: astore_1
    //   585: goto +144 -> 729
    //   588: astore_3
    //   589: aconst_null
    //   590: astore_1
    //   591: aload_3
    //   592: astore 4
    //   594: goto +40 -> 634
    //   597: astore_3
    //   598: aconst_null
    //   599: astore 4
    //   601: aload_0
    //   602: astore_1
    //   603: aload 4
    //   605: astore_0
    //   606: aload_3
    //   607: astore 4
    //   609: goto +64 -> 673
    //   612: astore_3
    //   613: aconst_null
    //   614: astore_1
    //   615: aload_3
    //   616: astore 4
    //   618: goto +83 -> 701
    //   621: astore_1
    //   622: aload_3
    //   623: astore_0
    //   624: goto +105 -> 729
    //   627: astore 4
    //   629: aconst_null
    //   630: astore_1
    //   631: aload 5
    //   633: astore_0
    //   634: aload_0
    //   635: astore_3
    //   636: ldc_w 643
    //   639: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   642: aload_0
    //   643: astore_3
    //   644: aload 4
    //   646: invokevirtual 312	java/io/IOException:printStackTrace	()V
    //   649: aload_1
    //   650: astore_3
    //   651: aload_0
    //   652: ifnull +75 -> 727
    //   655: aload_0
    //   656: astore_3
    //   657: aload_1
    //   658: astore 4
    //   660: aload_3
    //   661: invokevirtual 120	java/io/FileInputStream:close	()V
    //   664: aload_1
    //   665: areturn
    //   666: astore 4
    //   668: aconst_null
    //   669: astore_0
    //   670: aload 6
    //   672: astore_1
    //   673: aload_1
    //   674: astore_3
    //   675: ldc_w 645
    //   678: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   681: aload_1
    //   682: astore_3
    //   683: aload 4
    //   685: invokevirtual 313	org/xml/sax/SAXException:printStackTrace	()V
    //   688: aload_0
    //   689: astore_3
    //   690: aload_1
    //   691: ifnull +36 -> 727
    //   694: aload_1
    //   695: astore_3
    //   696: aload_0
    //   697: astore_1
    //   698: goto -41 -> 657
    //   701: aload_0
    //   702: astore_3
    //   703: ldc_w 647
    //   706: invokestatic 117	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   709: aload_0
    //   710: astore_3
    //   711: aload 4
    //   713: invokevirtual 314	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   716: aload_1
    //   717: astore_3
    //   718: aload_0
    //   719: ifnull +8 -> 727
    //   722: aload_0
    //   723: astore_3
    //   724: goto -67 -> 657
    //   727: aload_3
    //   728: areturn
    //   729: aload_0
    //   730: ifnull +18 -> 748
    //   733: aload_0
    //   734: invokevirtual 120	java/io/FileInputStream:close	()V
    //   737: goto +11 -> 748
    //   740: ldc 44
    //   742: ldc_w 604
    //   745: invokestatic 53	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: goto +5 -> 753
    //   751: aload_1
    //   752: athrow
    //   753: goto -2 -> 751
    //   756: astore_0
    //   757: goto -691 -> 66
    //   760: astore_0
    //   761: goto -603 -> 158
    //   764: astore_0
    //   765: goto -243 -> 522
    //   768: astore_0
    //   769: goto -224 -> 545
    //   772: astore_0
    //   773: goto -33 -> 740
    //   776: astore_3
    //   777: aconst_null
    //   778: astore_1
    //   779: aload 4
    //   781: astore_0
    //   782: aload_3
    //   783: astore 4
    //   785: goto -84 -> 701
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	paramFile	File
    //   0	788	1	paramString	String
    //   228	282	2	i	int
    //   15	566	3	localObject1	Object
    //   588	4	3	localIOException1	java.io.IOException
    //   597	10	3	localSAXException1	org.xml.sax.SAXException
    //   612	11	3	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   635	93	3	localObject2	Object
    //   776	7	3	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   12	519	4	localObject3	Object
    //   555	5	4	localIOException2	java.io.IOException
    //   567	1	4	localObject4	Object
    //   574	5	4	localParserConfigurationException3	javax.xml.parsers.ParserConfigurationException
    //   592	25	4	localObject5	Object
    //   627	18	4	localIOException3	java.io.IOException
    //   658	1	4	str	String
    //   666	114	4	localSAXException2	org.xml.sax.SAXException
    //   783	1	4	localObject6	Object
    //   6	626	5	locale	a.e
    //   9	662	6	localObject7	Object
    //   3	31	7	localDocumentBuilderFactory	javax.xml.parsers.DocumentBuilderFactory
    // Exception table:
    //   from	to	target	type
    //   33	49	555	java/io/IOException
    //   54	60	555	java/io/IOException
    //   76	120	555	java/io/IOException
    //   123	152	555	java/io/IOException
    //   168	201	555	java/io/IOException
    //   205	227	555	java/io/IOException
    //   229	506	555	java/io/IOException
    //   533	539	555	java/io/IOException
    //   33	49	565	org/xml/sax/SAXException
    //   54	60	565	org/xml/sax/SAXException
    //   76	120	565	org/xml/sax/SAXException
    //   123	152	565	org/xml/sax/SAXException
    //   168	201	565	org/xml/sax/SAXException
    //   205	227	565	org/xml/sax/SAXException
    //   229	506	565	org/xml/sax/SAXException
    //   533	539	565	org/xml/sax/SAXException
    //   33	49	574	javax/xml/parsers/ParserConfigurationException
    //   54	60	574	javax/xml/parsers/ParserConfigurationException
    //   76	120	574	javax/xml/parsers/ParserConfigurationException
    //   123	152	574	javax/xml/parsers/ParserConfigurationException
    //   168	201	574	javax/xml/parsers/ParserConfigurationException
    //   205	227	574	javax/xml/parsers/ParserConfigurationException
    //   229	506	574	javax/xml/parsers/ParserConfigurationException
    //   533	539	574	javax/xml/parsers/ParserConfigurationException
    //   25	33	584	finally
    //   33	49	584	finally
    //   54	60	584	finally
    //   76	120	584	finally
    //   123	152	584	finally
    //   168	201	584	finally
    //   205	227	584	finally
    //   229	506	584	finally
    //   533	539	584	finally
    //   25	33	588	java/io/IOException
    //   25	33	597	org/xml/sax/SAXException
    //   25	33	612	javax/xml/parsers/ParserConfigurationException
    //   16	25	621	finally
    //   636	642	621	finally
    //   644	649	621	finally
    //   675	681	621	finally
    //   683	688	621	finally
    //   703	709	621	finally
    //   711	716	621	finally
    //   16	25	627	java/io/IOException
    //   16	25	666	org/xml/sax/SAXException
    //   60	64	756	java/lang/Exception
    //   152	156	760	java/lang/Exception
    //   516	520	764	java/lang/Exception
    //   660	664	764	java/lang/Exception
    //   539	543	768	java/lang/Exception
    //   733	737	772	java/lang/Exception
    //   16	25	776	javax/xml/parsers/ParserConfigurationException
  }
  
  public static a.d b(String paramString)
  {
    if (paramString == null)
    {
      XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,path is empty");
      return null;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      XWalkInitializer.addXWalkInitializeLog("parse plugin config failed ,file not exist");
      return null;
    }
    return b(paramString, a(paramString, (int)paramString.length(), "<Plugins>"));
  }
  
  static a.a[] b(Element paramElement)
  {
    if (paramElement == null) {
      return null;
    }
    try
    {
      paramElement = paramElement.getElementsByTagName("command");
      if ((paramElement != null) && (paramElement.getLength() != 0))
      {
        localObject = new a.a[paramElement.getLength()];
        int i = 0;
        while (i < paramElement.getLength())
        {
          a.a locala = new a.a();
          a(locala, (Element)paramElement.item(i));
          localObject[i] = locala;
          i += 1;
        }
        return localObject;
      }
    }
    catch (Exception paramElement)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseCmds failed: ");
      ((StringBuilder)localObject).append(paramElement.getMessage());
      Log.e("ConfigParser", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  static boolean c(Element paramElement, String paramString)
  {
    if (paramElement == null) {
      return false;
    }
    paramElement = paramElement.getAttribute(paramString);
    if (paramElement != null)
    {
      if (paramElement.isEmpty()) {
        return false;
      }
      return Boolean.parseBoolean(paramElement);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.a
 * JD-Core Version:    0.7.0.1
 */