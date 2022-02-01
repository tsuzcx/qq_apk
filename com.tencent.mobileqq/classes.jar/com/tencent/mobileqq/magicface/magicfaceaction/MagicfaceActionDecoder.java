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
  private Action a;
  private ActionProcess b;
  private MagicfacePlayRes c;
  
  private void a(XmlPullParser paramXmlPullParser, Action paramAction)
  {
    paramAction.b = paramXmlPullParser.getAttributeValue(null, "name");
    String str = paramXmlPullParser.getAttributeValue(null, "timeout");
    if (str != null) {
      paramAction.e = Integer.parseInt(str);
    }
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "nextActionIfTimeout");
    if (paramXmlPullParser != null) {
      paramAction.h = Boolean.parseBoolean(paramXmlPullParser);
    }
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
              this.a = null;
              localObject2 = paramString;
            }
            else
            {
              localObject1 = paramString;
              if (str.equalsIgnoreCase("process"))
              {
                localObject1 = paramString;
                this.b = null;
                localObject2 = paramString;
              }
              else
              {
                localObject2 = paramString;
                localObject1 = paramString;
                if (str.equalsIgnoreCase("playRes"))
                {
                  localObject1 = paramString;
                  this.c = null;
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
                        this.b = new ActionProcess();
                        localObject1 = paramString;
                        this.a.i = this.b;
                        localObject1 = paramString;
                        this.b.a = localXmlPullParser.getAttributeValue(null, "type");
                        localObject2 = paramString;
                        continue;
                      }
                      localObject1 = paramString;
                      boolean bool = str.equalsIgnoreCase("gravity");
                      if (bool)
                      {
                        localObject1 = paramString;
                        this.b.b = "gravity";
                        localObject1 = paramString;
                        localObject2 = localXmlPullParser.getAttributeValue(null, "value");
                        if (localObject2 != null)
                        {
                          localObject1 = paramString;
                          this.b.d = Integer.parseInt((String)localObject2);
                        }
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "stopType");
                        localObject2 = paramString;
                        if (str == null) {
                          continue;
                        }
                        localObject1 = paramString;
                        this.b.c = str;
                        localObject2 = paramString;
                        continue;
                      }
                      localObject1 = paramString;
                      if ("mic".equalsIgnoreCase(str))
                      {
                        localObject1 = paramString;
                        this.b.b = "mic";
                        localObject1 = paramString;
                        localObject2 = localXmlPullParser.getAttributeValue(null, "value");
                        if (localObject2 != null)
                        {
                          localObject1 = paramString;
                          this.b.d = Integer.parseInt((String)localObject2);
                        }
                        localObject1 = paramString;
                        localObject2 = localXmlPullParser.getAttributeValue(null, "replacevalue");
                        if (localObject2 != null)
                        {
                          localObject1 = paramString;
                          this.b.d = Integer.parseInt((String)localObject2);
                        }
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "stopType");
                        localObject2 = paramString;
                        if (str == null) {
                          continue;
                        }
                        localObject1 = paramString;
                        this.b.c = str;
                        localObject2 = paramString;
                        continue;
                      }
                      localObject1 = paramString;
                      if ("touch".equalsIgnoreCase(str))
                      {
                        localObject1 = paramString;
                        this.b.b = "touch";
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "stopType");
                        localObject2 = paramString;
                        if (str == null) {
                          continue;
                        }
                        localObject1 = paramString;
                        this.b.c = str;
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
                          ((RecordCondition)localObject2).a = Integer.parseInt(str);
                        }
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "max");
                        if (str != null)
                        {
                          localObject1 = paramString;
                          ((RecordCondition)localObject2).b = Integer.parseInt(str);
                          localObject1 = paramString;
                          if (((RecordCondition)localObject2).b == -1)
                          {
                            localObject1 = paramString;
                            ((RecordCondition)localObject2).b = 2147483647;
                          }
                        }
                        localObject1 = paramString;
                        str = localXmlPullParser.getAttributeValue(null, "sum");
                        if (str != null)
                        {
                          localObject1 = paramString;
                          ((RecordCondition)localObject2).c = Integer.parseInt(str);
                        }
                        localObject1 = paramString;
                        this.b.f.add(localObject2);
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
                            if (this.c == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "src");
                            localObject1 = paramString;
                            this.c.c = ((String)localObject2);
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "srcAlpha");
                            localObject1 = paramString;
                            this.c.d = ((String)localObject2);
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "duration");
                            if (localObject2 != null)
                            {
                              localObject1 = paramString;
                              this.c.i = Integer.parseInt((String)localObject2);
                            }
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "fps");
                            if (localObject2 != null)
                            {
                              localObject1 = paramString;
                              this.c.j = Integer.parseInt((String)localObject2);
                            }
                            localObject1 = paramString;
                            str = localXmlPullParser.getAttributeValue(null, "repeat");
                            localObject2 = paramString;
                            if (str == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            this.c.e = Integer.parseInt(str);
                            localObject2 = paramString;
                            continue;
                          }
                          localObject1 = paramString;
                          if ("sound".equalsIgnoreCase(str))
                          {
                            localObject2 = paramString;
                            localObject1 = paramString;
                            if (this.c == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "src");
                            localObject1 = paramString;
                            this.c.f = ((String)localObject2);
                            localObject1 = paramString;
                            localObject2 = localXmlPullParser.getAttributeValue(null, "duration");
                            if (localObject2 != null)
                            {
                              localObject1 = paramString;
                              this.c.g = Integer.parseInt((String)localObject2);
                            }
                            localObject1 = paramString;
                            str = localXmlPullParser.getAttributeValue(null, "repeat");
                            localObject2 = paramString;
                            if (str == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            this.c.h = Integer.parseInt(str);
                            localObject2 = paramString;
                            continue;
                          }
                          localObject1 = paramString;
                          if ("vibrator".equalsIgnoreCase(str))
                          {
                            localObject2 = paramString;
                            localObject1 = paramString;
                            if (this.c == null) {
                              continue;
                            }
                            localObject1 = paramString;
                            this.c.k = true;
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
        this.c.l = Integer.parseInt(str);
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
        if (this.b != null)
        {
          localObject1 = paramString;
          str = localXmlPullParser.getAttributeValue(null, "direction");
          localObject1 = paramString;
          if ("up".equalsIgnoreCase(str))
          {
            localObject1 = paramString;
            this.b.e = 2;
            localObject2 = paramString;
          }
          else
          {
            localObject1 = paramString;
            if ("down".equalsIgnoreCase(str))
            {
              localObject1 = paramString;
              this.b.e = 3;
              localObject2 = paramString;
            }
            else
            {
              localObject1 = paramString;
              if ("left".equalsIgnoreCase(str))
              {
                localObject1 = paramString;
                this.b.e = 0;
                localObject2 = paramString;
              }
              else
              {
                localObject2 = paramString;
                localObject1 = paramString;
                if ("right".equalsIgnoreCase(str))
                {
                  localObject1 = paramString;
                  this.b.e = 1;
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
          if (this.b != null)
          {
            localObject1 = paramString;
            this.b.e = 5;
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
            if (this.b != null)
            {
              localObject1 = paramString;
              this.b.e = 4;
              localObject2 = paramString;
              continue;
              localObject1 = paramString;
              this.c = new MagicfacePlayRes();
              localObject1 = paramString;
              this.a.c.add(this.c);
              localObject1 = paramString;
              localObject2 = localXmlPullParser.getAttributeValue(null, "min");
              if (localObject2 != null)
              {
                localObject1 = paramString;
                this.c.a = Integer.parseInt((String)localObject2);
              }
              localObject1 = paramString;
              str = localXmlPullParser.getAttributeValue(null, "max");
              localObject2 = paramString;
              if (str != null)
              {
                localObject1 = paramString;
                this.c.b = Integer.parseInt(str);
                localObject2 = paramString;
                localObject1 = paramString;
                if (this.c.b == -1)
                {
                  localObject1 = paramString;
                  this.c.b = 2147483647;
                  localObject2 = paramString;
                  continue;
                  localObject1 = paramString;
                  this.a = new Action();
                  localObject1 = paramString;
                  paramString.add(this.a);
                  localObject1 = paramString;
                  a(localXmlPullParser, this.a);
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
                      this.a.n = true;
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
  
  /* Error */
  public ActionGlobalData b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 275	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   3: astore 4
    //   5: aload 4
    //   7: iconst_1
    //   8: invokevirtual 279	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
    //   11: aload 4
    //   13: invokevirtual 280	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   16: astore 7
    //   18: aload 7
    //   20: new 64	java/io/StringReader
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 67	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   28: invokeinterface 71 2 0
    //   33: aload 7
    //   35: invokeinterface 75 1 0
    //   40: istore_2
    //   41: aconst_null
    //   42: astore_1
    //   43: aload_1
    //   44: astore 4
    //   46: iload_2
    //   47: iconst_1
    //   48: if_icmpeq +1205 -> 1253
    //   51: iload_2
    //   52: ifeq +1159 -> 1211
    //   55: iload_2
    //   56: iconst_2
    //   57: if_icmpeq +9 -> 66
    //   60: aload_1
    //   61: astore 5
    //   63: goto +1160 -> 1223
    //   66: aload_1
    //   67: astore 4
    //   69: aload 7
    //   71: invokeinterface 79 1 0
    //   76: astore 6
    //   78: aload_1
    //   79: astore 4
    //   81: aload 6
    //   83: ldc_w 282
    //   86: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   89: istore_3
    //   90: iload_3
    //   91: ifeq +926 -> 1017
    //   94: aload_1
    //   95: astore 4
    //   97: aload 7
    //   99: aconst_null
    //   100: ldc_w 284
    //   103: invokeinterface 24 3 0
    //   108: astore 5
    //   110: aload_1
    //   111: astore 4
    //   113: aload 5
    //   115: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +15 -> 133
    //   121: aload_1
    //   122: astore 4
    //   124: aload_1
    //   125: aload 5
    //   127: invokestatic 49	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   130: putfield 294	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:e	Z
    //   133: aload_1
    //   134: astore 4
    //   136: aload 7
    //   138: aconst_null
    //   139: ldc 81
    //   141: invokeinterface 24 3 0
    //   146: astore 5
    //   148: aload 5
    //   150: ifnull +26 -> 176
    //   153: aload_1
    //   154: astore 4
    //   156: aload 5
    //   158: invokestatic 49	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   161: istore_3
    //   162: iload_3
    //   163: ifne +13 -> 176
    //   166: aload_1
    //   167: astore 4
    //   169: aload_1
    //   170: iload_3
    //   171: putfield 296	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:b	Z
    //   174: aload_1
    //   175: areturn
    //   176: aload_1
    //   177: astore 4
    //   179: aload_1
    //   180: aload 7
    //   182: aconst_null
    //   183: ldc_w 298
    //   186: invokeinterface 24 3 0
    //   191: putfield 300	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:h	Ljava/lang/String;
    //   194: aload_1
    //   195: astore 4
    //   197: aload 7
    //   199: aconst_null
    //   200: ldc_w 302
    //   203: invokeinterface 24 3 0
    //   208: astore 5
    //   210: aload 5
    //   212: ifnull +15 -> 227
    //   215: aload_1
    //   216: astore 4
    //   218: aload_1
    //   219: aload 5
    //   221: invokestatic 49	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   224: putfield 304	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:d	Z
    //   227: aload_1
    //   228: astore 4
    //   230: aload 7
    //   232: aconst_null
    //   233: ldc_w 306
    //   236: invokeinterface 24 3 0
    //   241: astore 5
    //   243: aload_1
    //   244: astore 4
    //   246: aload 5
    //   248: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifne +12 -> 263
    //   254: aload_1
    //   255: astore 4
    //   257: aload_1
    //   258: aload 5
    //   260: putfield 307	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:f	Ljava/lang/String;
    //   263: aload_1
    //   264: astore 4
    //   266: aload_1
    //   267: aload 7
    //   269: aconst_null
    //   270: ldc 106
    //   272: invokeinterface 24 3 0
    //   277: putfield 308	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:c	Ljava/lang/String;
    //   280: aload_1
    //   281: astore 4
    //   283: aload 7
    //   285: aconst_null
    //   286: ldc_w 310
    //   289: invokeinterface 24 3 0
    //   294: astore 6
    //   296: aload 6
    //   298: ifnull +44 -> 342
    //   301: aload 6
    //   303: astore 5
    //   305: aload_1
    //   306: astore 4
    //   308: aload 6
    //   310: ldc_w 312
    //   313: invokevirtual 315	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   316: ifeq +14 -> 330
    //   319: aload_1
    //   320: astore 4
    //   322: aload 6
    //   324: iconst_2
    //   325: invokevirtual 319	java/lang/String:substring	(I)Ljava/lang/String;
    //   328: astore 5
    //   330: aload_1
    //   331: aload 5
    //   333: bipush 16
    //   335: invokestatic 325	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   338: l2i
    //   339: putfield 326	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:g	I
    //   342: aload_1
    //   343: astore 4
    //   345: aload 7
    //   347: aconst_null
    //   348: ldc_w 328
    //   351: invokeinterface 24 3 0
    //   356: astore 5
    //   358: aload 5
    //   360: ifnull +15 -> 375
    //   363: aload_1
    //   364: astore 4
    //   366: aload_1
    //   367: aload 5
    //   369: invokestatic 37	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   372: putfield 331	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:q	I
    //   375: aload_1
    //   376: astore 4
    //   378: aload 7
    //   380: aconst_null
    //   381: ldc_w 333
    //   384: invokeinterface 24 3 0
    //   389: astore 5
    //   391: aload 5
    //   393: ifnull +15 -> 408
    //   396: aload_1
    //   397: astore 4
    //   399: aload_1
    //   400: aload 5
    //   402: invokestatic 37	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   405: putfield 336	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:r	I
    //   408: aload_1
    //   409: astore 4
    //   411: aload 7
    //   413: aconst_null
    //   414: ldc_w 338
    //   417: invokeinterface 24 3 0
    //   422: astore 5
    //   424: aload 5
    //   426: ifnull +15 -> 441
    //   429: aload_1
    //   430: astore 4
    //   432: aload_1
    //   433: aload 5
    //   435: invokestatic 37	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   438: putfield 341	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:s	I
    //   441: aload_1
    //   442: astore 4
    //   444: aload 7
    //   446: aconst_null
    //   447: ldc_w 343
    //   450: invokeinterface 24 3 0
    //   455: astore 5
    //   457: aload 5
    //   459: ifnull +15 -> 474
    //   462: aload_1
    //   463: astore 4
    //   465: aload_1
    //   466: aload 5
    //   468: invokestatic 37	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   471: putfield 346	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:t	I
    //   474: aload_1
    //   475: astore 4
    //   477: aload 7
    //   479: aconst_null
    //   480: ldc_w 348
    //   483: invokeinterface 24 3 0
    //   488: astore 5
    //   490: aload 5
    //   492: ifnull +15 -> 507
    //   495: aload_1
    //   496: astore 4
    //   498: aload_1
    //   499: aload 5
    //   501: invokestatic 49	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   504: putfield 351	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:u	Z
    //   507: aload_1
    //   508: astore 4
    //   510: aload 7
    //   512: aconst_null
    //   513: ldc_w 353
    //   516: invokeinterface 24 3 0
    //   521: astore 5
    //   523: aload 5
    //   525: ifnull +15 -> 540
    //   528: aload_1
    //   529: astore 4
    //   531: aload_1
    //   532: aload 5
    //   534: invokestatic 37	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   537: putfield 356	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:x	I
    //   540: aload_1
    //   541: astore 4
    //   543: aload 7
    //   545: aconst_null
    //   546: ldc_w 358
    //   549: invokeinterface 24 3 0
    //   554: astore 5
    //   556: aload 5
    //   558: ifnull +15 -> 573
    //   561: aload_1
    //   562: astore 4
    //   564: aload_1
    //   565: aload 5
    //   567: invokestatic 37	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   570: putfield 361	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:y	I
    //   573: aload_1
    //   574: astore 4
    //   576: aload 7
    //   578: aconst_null
    //   579: ldc_w 363
    //   582: invokeinterface 24 3 0
    //   587: astore 5
    //   589: aload 5
    //   591: ifnull +15 -> 606
    //   594: aload_1
    //   595: astore 4
    //   597: aload_1
    //   598: aload 5
    //   600: invokestatic 49	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   603: putfield 366	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:z	Z
    //   606: aload_1
    //   607: astore 4
    //   609: aload 7
    //   611: aconst_null
    //   612: ldc_w 368
    //   615: invokeinterface 24 3 0
    //   620: astore 5
    //   622: aload 5
    //   624: ifnull +15 -> 639
    //   627: aload_1
    //   628: astore 4
    //   630: aload_1
    //   631: aload 5
    //   633: invokestatic 37	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   636: putfield 371	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:A	I
    //   639: aload_1
    //   640: astore 4
    //   642: aload 7
    //   644: aconst_null
    //   645: ldc_w 373
    //   648: invokeinterface 24 3 0
    //   653: astore 5
    //   655: aload 5
    //   657: ifnull +15 -> 672
    //   660: aload_1
    //   661: astore 4
    //   663: aload_1
    //   664: aload 5
    //   666: invokestatic 49	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   669: putfield 376	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:B	Z
    //   672: aload_1
    //   673: astore 4
    //   675: aload 7
    //   677: aconst_null
    //   678: ldc_w 378
    //   681: invokeinterface 24 3 0
    //   686: astore 6
    //   688: aload 6
    //   690: ifnull +78 -> 768
    //   693: aload 6
    //   695: astore 5
    //   697: aload_1
    //   698: astore 4
    //   700: aload 6
    //   702: ldc_w 380
    //   705: invokevirtual 383	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   708: ifne +48 -> 756
    //   711: aload_1
    //   712: astore 4
    //   714: new 248	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   721: astore 5
    //   723: aload_1
    //   724: astore 4
    //   726: aload 5
    //   728: ldc_w 380
    //   731: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_1
    //   736: astore 4
    //   738: aload 5
    //   740: aload 6
    //   742: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload_1
    //   747: astore 4
    //   749: aload 5
    //   751: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: astore 5
    //   756: aload_1
    //   757: astore 4
    //   759: aload_1
    //   760: aload 5
    //   762: invokestatic 388	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   765: putfield 391	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:C	I
    //   768: aload_1
    //   769: astore 4
    //   771: aload 7
    //   773: aconst_null
    //   774: ldc_w 393
    //   777: invokeinterface 24 3 0
    //   782: astore 6
    //   784: aload 6
    //   786: ifnull +78 -> 864
    //   789: aload 6
    //   791: astore 5
    //   793: aload_1
    //   794: astore 4
    //   796: aload 6
    //   798: ldc_w 380
    //   801: invokevirtual 383	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   804: ifne +48 -> 852
    //   807: aload_1
    //   808: astore 4
    //   810: new 248	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   817: astore 5
    //   819: aload_1
    //   820: astore 4
    //   822: aload 5
    //   824: ldc_w 380
    //   827: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload_1
    //   832: astore 4
    //   834: aload 5
    //   836: aload 6
    //   838: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: pop
    //   842: aload_1
    //   843: astore 4
    //   845: aload 5
    //   847: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: astore 5
    //   852: aload_1
    //   853: astore 4
    //   855: aload_1
    //   856: aload 5
    //   858: invokestatic 388	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   861: putfield 396	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:D	I
    //   864: aload_1
    //   865: astore 4
    //   867: aload 7
    //   869: aconst_null
    //   870: ldc_w 398
    //   873: invokeinterface 24 3 0
    //   878: astore 6
    //   880: aload 6
    //   882: ifnull +78 -> 960
    //   885: aload 6
    //   887: astore 5
    //   889: aload_1
    //   890: astore 4
    //   892: aload 6
    //   894: ldc_w 380
    //   897: invokevirtual 383	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   900: ifne +48 -> 948
    //   903: aload_1
    //   904: astore 4
    //   906: new 248	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   913: astore 5
    //   915: aload_1
    //   916: astore 4
    //   918: aload 5
    //   920: ldc_w 380
    //   923: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: pop
    //   927: aload_1
    //   928: astore 4
    //   930: aload 5
    //   932: aload 6
    //   934: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: aload_1
    //   939: astore 4
    //   941: aload 5
    //   943: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: astore 5
    //   948: aload_1
    //   949: astore 4
    //   951: aload_1
    //   952: aload 5
    //   954: invokestatic 388	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   957: putfield 401	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:E	I
    //   960: aload_1
    //   961: astore 4
    //   963: aload_1
    //   964: aload 7
    //   966: aconst_null
    //   967: ldc_w 403
    //   970: invokeinterface 24 3 0
    //   975: putfield 406	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:F	Ljava/lang/String;
    //   978: aload_1
    //   979: astore 4
    //   981: aload 7
    //   983: aconst_null
    //   984: ldc_w 408
    //   987: invokeinterface 24 3 0
    //   992: astore 6
    //   994: aload_1
    //   995: astore 5
    //   997: aload 6
    //   999: ifnull +224 -> 1223
    //   1002: aload_1
    //   1003: astore 4
    //   1005: aload_1
    //   1006: aload 6
    //   1008: putfield 411	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:v	Ljava/lang/String;
    //   1011: aload_1
    //   1012: astore 5
    //   1014: goto +209 -> 1223
    //   1017: aload_1
    //   1018: astore 4
    //   1020: aload 6
    //   1022: ldc_w 413
    //   1025: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1028: istore_3
    //   1029: iload_3
    //   1030: ifeq +26 -> 1056
    //   1033: aload_1
    //   1034: astore 4
    //   1036: aload_1
    //   1037: aload 7
    //   1039: aconst_null
    //   1040: ldc 154
    //   1042: invokeinterface 24 3 0
    //   1047: putfield 415	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:j	Ljava/lang/String;
    //   1050: aload_1
    //   1051: astore 5
    //   1053: goto +170 -> 1223
    //   1056: aload_1
    //   1057: astore 4
    //   1059: aload 6
    //   1061: ldc_w 417
    //   1064: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1067: ifeq +104 -> 1171
    //   1070: aload_1
    //   1071: astore 4
    //   1073: new 419	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText
    //   1076: dup
    //   1077: invokespecial 420	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText:<init>	()V
    //   1080: astore 5
    //   1082: aload_1
    //   1083: astore 4
    //   1085: aload 5
    //   1087: aload 7
    //   1089: aconst_null
    //   1090: ldc 106
    //   1092: invokeinterface 24 3 0
    //   1097: putfield 421	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText:a	Ljava/lang/String;
    //   1100: aload_1
    //   1101: astore 4
    //   1103: aload 7
    //   1105: aconst_null
    //   1106: ldc 31
    //   1108: invokeinterface 24 3 0
    //   1113: astore 6
    //   1115: aload_1
    //   1116: astore 4
    //   1118: aload 5
    //   1120: aload 6
    //   1122: putfield 422	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText:b	Ljava/lang/String;
    //   1125: aload 6
    //   1127: ifnull +15 -> 1142
    //   1130: aload_1
    //   1131: astore 4
    //   1133: aload_1
    //   1134: aload 6
    //   1136: invokestatic 37	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1139: putfield 425	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:o	I
    //   1142: aload_1
    //   1143: astore 4
    //   1145: aload 5
    //   1147: aload 7
    //   1149: aconst_null
    //   1150: ldc 154
    //   1152: invokeinterface 24 3 0
    //   1157: putfield 426	com/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText:c	Ljava/lang/String;
    //   1160: aload_1
    //   1161: astore 4
    //   1163: aload_1
    //   1164: aload 5
    //   1166: putfield 430	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:m	Lcom/tencent/mobileqq/magicface/magicfaceaction/MagicfacebackText;
    //   1169: aload_1
    //   1170: areturn
    //   1171: aload_1
    //   1172: astore 5
    //   1174: aload_1
    //   1175: astore 4
    //   1177: ldc_w 432
    //   1180: aload 6
    //   1182: invokevirtual 86	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1185: ifeq +38 -> 1223
    //   1188: aload_1
    //   1189: astore 4
    //   1191: aload_1
    //   1192: aload 7
    //   1194: aconst_null
    //   1195: ldc 154
    //   1197: invokeinterface 24 3 0
    //   1202: putfield 434	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:l	Ljava/lang/String;
    //   1205: aload_1
    //   1206: astore 5
    //   1208: goto +15 -> 1223
    //   1211: aload_1
    //   1212: astore 4
    //   1214: new 292	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData
    //   1217: dup
    //   1218: invokespecial 435	com/tencent/mobileqq/magicface/magicfaceaction/ActionGlobalData:<init>	()V
    //   1221: astore 5
    //   1223: aload 5
    //   1225: astore 4
    //   1227: aload 7
    //   1229: invokeinterface 240 1 0
    //   1234: istore_2
    //   1235: aload 5
    //   1237: astore_1
    //   1238: goto -1195 -> 43
    //   1241: astore_1
    //   1242: goto +7 -> 1249
    //   1245: astore_1
    //   1246: aconst_null
    //   1247: astore 4
    //   1249: aload_1
    //   1250: invokevirtual 438	java/lang/Exception:printStackTrace	()V
    //   1253: aload 4
    //   1255: areturn
    //   1256: astore 4
    //   1258: goto -916 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1261	0	this	MagicfaceActionDecoder
    //   0	1261	1	paramString	String
    //   40	1195	2	i	int
    //   89	941	3	bool	boolean
    //   3	1251	4	localObject1	Object
    //   1256	1	4	localException	Exception
    //   61	1175	5	localObject2	Object
    //   76	1105	6	str	String
    //   16	1212	7	localXmlPullParser	XmlPullParser
    // Exception table:
    //   from	to	target	type
    //   69	78	1241	java/lang/Exception
    //   81	90	1241	java/lang/Exception
    //   97	110	1241	java/lang/Exception
    //   113	121	1241	java/lang/Exception
    //   124	133	1241	java/lang/Exception
    //   136	148	1241	java/lang/Exception
    //   156	162	1241	java/lang/Exception
    //   169	174	1241	java/lang/Exception
    //   179	194	1241	java/lang/Exception
    //   197	210	1241	java/lang/Exception
    //   218	227	1241	java/lang/Exception
    //   230	243	1241	java/lang/Exception
    //   246	254	1241	java/lang/Exception
    //   257	263	1241	java/lang/Exception
    //   266	280	1241	java/lang/Exception
    //   283	296	1241	java/lang/Exception
    //   308	319	1241	java/lang/Exception
    //   322	330	1241	java/lang/Exception
    //   345	358	1241	java/lang/Exception
    //   366	375	1241	java/lang/Exception
    //   378	391	1241	java/lang/Exception
    //   399	408	1241	java/lang/Exception
    //   411	424	1241	java/lang/Exception
    //   432	441	1241	java/lang/Exception
    //   444	457	1241	java/lang/Exception
    //   465	474	1241	java/lang/Exception
    //   477	490	1241	java/lang/Exception
    //   498	507	1241	java/lang/Exception
    //   510	523	1241	java/lang/Exception
    //   531	540	1241	java/lang/Exception
    //   543	556	1241	java/lang/Exception
    //   564	573	1241	java/lang/Exception
    //   576	589	1241	java/lang/Exception
    //   597	606	1241	java/lang/Exception
    //   609	622	1241	java/lang/Exception
    //   630	639	1241	java/lang/Exception
    //   642	655	1241	java/lang/Exception
    //   663	672	1241	java/lang/Exception
    //   675	688	1241	java/lang/Exception
    //   700	711	1241	java/lang/Exception
    //   714	723	1241	java/lang/Exception
    //   726	735	1241	java/lang/Exception
    //   738	746	1241	java/lang/Exception
    //   749	756	1241	java/lang/Exception
    //   759	768	1241	java/lang/Exception
    //   771	784	1241	java/lang/Exception
    //   796	807	1241	java/lang/Exception
    //   810	819	1241	java/lang/Exception
    //   822	831	1241	java/lang/Exception
    //   834	842	1241	java/lang/Exception
    //   845	852	1241	java/lang/Exception
    //   855	864	1241	java/lang/Exception
    //   867	880	1241	java/lang/Exception
    //   892	903	1241	java/lang/Exception
    //   906	915	1241	java/lang/Exception
    //   918	927	1241	java/lang/Exception
    //   930	938	1241	java/lang/Exception
    //   941	948	1241	java/lang/Exception
    //   951	960	1241	java/lang/Exception
    //   963	978	1241	java/lang/Exception
    //   981	994	1241	java/lang/Exception
    //   1005	1011	1241	java/lang/Exception
    //   1020	1029	1241	java/lang/Exception
    //   1036	1050	1241	java/lang/Exception
    //   1059	1070	1241	java/lang/Exception
    //   1073	1082	1241	java/lang/Exception
    //   1085	1100	1241	java/lang/Exception
    //   1103	1115	1241	java/lang/Exception
    //   1118	1125	1241	java/lang/Exception
    //   1133	1142	1241	java/lang/Exception
    //   1145	1160	1241	java/lang/Exception
    //   1163	1169	1241	java/lang/Exception
    //   1177	1188	1241	java/lang/Exception
    //   1191	1205	1241	java/lang/Exception
    //   1214	1223	1241	java/lang/Exception
    //   1227	1235	1241	java/lang/Exception
    //   0	41	1245	java/lang/Exception
    //   330	342	1256	java/lang/Exception
  }
  
  public int c(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder
 * JD-Core Version:    0.7.0.1
 */