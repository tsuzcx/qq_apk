package com.tencent.qqprotect.qsec;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.qqprotect.common.QPDirUtils;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class QSecDatabaseMgr
{
  private List<QSecDatabaseMgr.LibEntry> a;
  private int b = 1;
  
  public QSecDatabaseMgr()
  {
    Pair localPair = a(c(), 1);
    if (localPair != null)
    {
      this.b = ((Integer)localPair.first).intValue();
      this.a = ((List)localPair.second);
    }
    if (this.a == null) {
      this.a = new LinkedList();
    }
  }
  
  private int a(Element paramElement)
  {
    for (;;)
    {
      int i;
      try
      {
        paramElement = paramElement.getAttributes();
        if (paramElement != null) {
          break label85;
        }
        return 0;
      }
      catch (Exception paramElement)
      {
        Node localNode;
        String str;
        paramElement.printStackTrace();
        return 0;
      }
      if (i < paramElement.getLength())
      {
        localNode = paramElement.item(i);
        str = localNode.getNodeName();
        if ((str != null) && (str.equalsIgnoreCase("version")))
        {
          i = Integer.parseInt(localNode.getNodeValue());
          return i;
        }
        i += 1;
      }
      else
      {
        return 0;
        label85:
        i = 0;
      }
    }
  }
  
  private Bundle a(Node paramNode)
  {
    try
    {
      Bundle localBundle = new Bundle();
      paramNode = paramNode.getChildNodes();
      int j = paramNode.getLength();
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramNode.item(i);
        if (((Node)localObject1).getNodeType() == 1)
        {
          Object localObject2 = ((Node)localObject1).getAttributes();
          if (localObject2 != null)
          {
            localObject1 = ((NamedNodeMap)localObject2).getNamedItem("name");
            if ((localObject1 != null) && (((Node)localObject1).getNodeType() == 2))
            {
              localObject1 = ((Node)localObject1).getNodeValue();
              if (localObject1 != null)
              {
                localObject2 = ((NamedNodeMap)localObject2).getNamedItem("value");
                if ((localObject2 != null) && (((Node)localObject2).getNodeType() == 2))
                {
                  localObject2 = ((Node)localObject2).getNodeValue();
                  if (localObject2 != null) {
                    localBundle.putString((String)localObject1, (String)localObject2);
                  }
                }
              }
            }
          }
        }
        i += 1;
      }
      return localBundle;
    }
    catch (Exception paramNode)
    {
      paramNode.printStackTrace();
    }
    return null;
  }
  
  private Pair<Integer, List<QSecDatabaseMgr.LibEntry>> a(String paramString, int paramInt)
  {
    paramString = new QSecStoreUtil().a(paramString, null, 1);
    if (paramString != null) {
      return a(paramString, paramInt);
    }
    return null;
  }
  
  /* Error */
  private Pair<Integer, List<QSecDatabaseMgr.LibEntry>> a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 134	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 5
    //   5: aload 5
    //   7: invokevirtual 138	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   10: astore 6
    //   12: new 140	java/io/ByteArrayInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 143	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: astore 5
    //   22: aload 5
    //   24: astore_1
    //   25: aload 6
    //   27: aload 5
    //   29: invokevirtual 149	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   32: invokeinterface 155 1 0
    //   37: astore 7
    //   39: aload 5
    //   41: astore_1
    //   42: aload_0
    //   43: aload 7
    //   45: invokespecial 157	com/tencent/qqprotect/qsec/QSecDatabaseMgr:a	(Lorg/w3c/dom/Element;)I
    //   48: istore_3
    //   49: iload_3
    //   50: ifeq +187 -> 237
    //   53: iload_3
    //   54: iload_2
    //   55: if_icmple +6 -> 61
    //   58: goto +179 -> 237
    //   61: aload 5
    //   63: astore_1
    //   64: new 43	java/util/LinkedList
    //   67: dup
    //   68: invokespecial 44	java/util/LinkedList:<init>	()V
    //   71: astore 6
    //   73: aload 5
    //   75: astore_1
    //   76: aload 7
    //   78: invokeinterface 158 1 0
    //   83: astore 7
    //   85: aload 5
    //   87: astore_1
    //   88: aload 7
    //   90: invokeinterface 97 1 0
    //   95: istore 4
    //   97: iconst_0
    //   98: istore_2
    //   99: iload_2
    //   100: iload 4
    //   102: if_icmpge +101 -> 203
    //   105: aload 5
    //   107: astore_1
    //   108: aload 7
    //   110: iload_2
    //   111: invokeinterface 98 2 0
    //   116: astore 8
    //   118: aload 5
    //   120: astore_1
    //   121: aload 8
    //   123: invokeinterface 102 1 0
    //   128: iconst_1
    //   129: if_icmpeq +6 -> 135
    //   132: goto +209 -> 341
    //   135: aload 5
    //   137: astore_1
    //   138: aload 8
    //   140: invokeinterface 68 1 0
    //   145: astore 9
    //   147: aload 9
    //   149: ifnull +192 -> 341
    //   152: aload 5
    //   154: astore_1
    //   155: aload 9
    //   157: ldc 160
    //   159: invokevirtual 76	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   162: ifne +6 -> 168
    //   165: goto +176 -> 341
    //   168: aload 5
    //   170: astore_1
    //   171: aload_0
    //   172: aload 8
    //   174: invokespecial 163	com/tencent/qqprotect/qsec/QSecDatabaseMgr:b	(Lorg/w3c/dom/Node;)Lcom/tencent/qqprotect/qsec/QSecDatabaseMgr$LibEntry;
    //   177: astore 8
    //   179: aload 8
    //   181: ifnonnull +6 -> 187
    //   184: goto +157 -> 341
    //   187: aload 5
    //   189: astore_1
    //   190: aload 6
    //   192: aload 8
    //   194: invokeinterface 167 2 0
    //   199: pop
    //   200: goto +141 -> 341
    //   203: aload 5
    //   205: astore_1
    //   206: new 24	android/util/Pair
    //   209: dup
    //   210: iload_3
    //   211: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: aload 6
    //   216: invokespecial 174	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   219: astore 6
    //   221: aload 5
    //   223: invokevirtual 177	java/io/ByteArrayInputStream:close	()V
    //   226: aload 6
    //   228: areturn
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   234: aload 6
    //   236: areturn
    //   237: aload 5
    //   239: astore_1
    //   240: new 24	android/util/Pair
    //   243: dup
    //   244: iload_3
    //   245: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: aconst_null
    //   249: invokespecial 174	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   252: astore 6
    //   254: aload 5
    //   256: invokevirtual 177	java/io/ByteArrayInputStream:close	()V
    //   259: aload 6
    //   261: areturn
    //   262: astore_1
    //   263: aload_1
    //   264: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   267: aload 6
    //   269: areturn
    //   270: astore 6
    //   272: goto +15 -> 287
    //   275: astore 5
    //   277: aconst_null
    //   278: astore_1
    //   279: goto +37 -> 316
    //   282: astore 6
    //   284: aconst_null
    //   285: astore 5
    //   287: aload 5
    //   289: astore_1
    //   290: aload 6
    //   292: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   295: aload 5
    //   297: ifnull +15 -> 312
    //   300: aload 5
    //   302: invokevirtual 177	java/io/ByteArrayInputStream:close	()V
    //   305: aconst_null
    //   306: areturn
    //   307: astore_1
    //   308: aload_1
    //   309: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   312: aconst_null
    //   313: areturn
    //   314: astore 5
    //   316: aload_1
    //   317: ifnull +15 -> 332
    //   320: aload_1
    //   321: invokevirtual 177	java/io/ByteArrayInputStream:close	()V
    //   324: goto +8 -> 332
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   332: goto +6 -> 338
    //   335: aload 5
    //   337: athrow
    //   338: goto -3 -> 335
    //   341: iload_2
    //   342: iconst_1
    //   343: iadd
    //   344: istore_2
    //   345: goto -246 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	QSecDatabaseMgr
    //   0	348	1	paramArrayOfByte	byte[]
    //   0	348	2	paramInt	int
    //   48	197	3	i	int
    //   95	8	4	j	int
    //   3	252	5	localObject1	Object
    //   275	1	5	localObject2	Object
    //   285	16	5	localObject3	Object
    //   314	22	5	localObject4	Object
    //   10	258	6	localObject5	Object
    //   270	1	6	localException1	Exception
    //   282	9	6	localException2	Exception
    //   37	72	7	localObject6	Object
    //   116	77	8	localObject7	Object
    //   145	11	9	str	String
    // Exception table:
    //   from	to	target	type
    //   221	226	229	java/io/IOException
    //   254	259	262	java/io/IOException
    //   25	39	270	java/lang/Exception
    //   42	49	270	java/lang/Exception
    //   64	73	270	java/lang/Exception
    //   76	85	270	java/lang/Exception
    //   88	97	270	java/lang/Exception
    //   108	118	270	java/lang/Exception
    //   121	132	270	java/lang/Exception
    //   138	147	270	java/lang/Exception
    //   155	165	270	java/lang/Exception
    //   171	179	270	java/lang/Exception
    //   190	200	270	java/lang/Exception
    //   206	221	270	java/lang/Exception
    //   240	254	270	java/lang/Exception
    //   5	22	275	finally
    //   5	22	282	java/lang/Exception
    //   300	305	307	java/io/IOException
    //   25	39	314	finally
    //   42	49	314	finally
    //   64	73	314	finally
    //   76	85	314	finally
    //   88	97	314	finally
    //   108	118	314	finally
    //   121	132	314	finally
    //   138	147	314	finally
    //   155	165	314	finally
    //   171	179	314	finally
    //   190	200	314	finally
    //   206	221	314	finally
    //   240	254	314	finally
    //   290	295	314	finally
    //   320	324	327	java/io/IOException
  }
  
  private boolean a(String paramString, int paramInt, List<QSecDatabaseMgr.LibEntry> paramList)
  {
    paramList = a(paramInt, paramList);
    if (paramList == null) {
      return false;
    }
    return new QSecStoreUtil().a(paramString, paramList, null, 1);
  }
  
  /* Error */
  private byte[] a(int paramInt, List<QSecDatabaseMgr.LibEntry> paramList)
  {
    // Byte code:
    //   0: invokestatic 193	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   3: astore 5
    //   5: new 195	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 196	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload 5
    //   19: aload 4
    //   21: ldc 198
    //   23: invokeinterface 204 3 0
    //   28: aload 4
    //   30: astore_3
    //   31: aload 5
    //   33: aconst_null
    //   34: iconst_1
    //   35: invokestatic 209	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: invokeinterface 213 3 0
    //   43: aload 4
    //   45: astore_3
    //   46: aload 5
    //   48: aconst_null
    //   49: ldc 215
    //   51: invokeinterface 219 3 0
    //   56: pop
    //   57: aload 4
    //   59: astore_3
    //   60: aload 5
    //   62: aconst_null
    //   63: ldc 70
    //   65: iload_1
    //   66: invokestatic 223	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   69: invokeinterface 227 4 0
    //   74: pop
    //   75: aload 4
    //   77: astore_3
    //   78: aload_2
    //   79: invokeinterface 231 1 0
    //   84: astore_2
    //   85: aload 4
    //   87: astore_3
    //   88: aload_2
    //   89: invokeinterface 237 1 0
    //   94: ifeq +154 -> 248
    //   97: aload 4
    //   99: astore_3
    //   100: aload_2
    //   101: invokeinterface 241 1 0
    //   106: checkcast 243	com/tencent/qqprotect/qsec/QSecDatabaseMgr$LibEntry
    //   109: astore 6
    //   111: aload 4
    //   113: astore_3
    //   114: aload 5
    //   116: aconst_null
    //   117: ldc 160
    //   119: invokeinterface 219 3 0
    //   124: pop
    //   125: aload 4
    //   127: astore_3
    //   128: aload 5
    //   130: aconst_null
    //   131: ldc 245
    //   133: aload 6
    //   135: getfield 247	com/tencent/qqprotect/qsec/QSecDatabaseMgr$LibEntry:a	I
    //   138: invokestatic 223	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   141: invokeinterface 227 4 0
    //   146: pop
    //   147: aload 4
    //   149: astore_3
    //   150: aload 5
    //   152: aconst_null
    //   153: ldc 249
    //   155: aload 6
    //   157: getfield 250	com/tencent/qqprotect/qsec/QSecDatabaseMgr$LibEntry:b	I
    //   160: invokestatic 223	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   163: invokeinterface 227 4 0
    //   168: pop
    //   169: aload 4
    //   171: astore_3
    //   172: aload 5
    //   174: aconst_null
    //   175: ldc 252
    //   177: aload 6
    //   179: getfield 254	com/tencent/qqprotect/qsec/QSecDatabaseMgr$LibEntry:c	I
    //   182: invokestatic 223	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   185: invokeinterface 227 4 0
    //   190: pop
    //   191: aload 4
    //   193: astore_3
    //   194: aload 5
    //   196: aconst_null
    //   197: ldc_w 256
    //   200: aload 6
    //   202: getfield 260	com/tencent/qqprotect/qsec/QSecDatabaseMgr$LibEntry:d	Ljava/lang/String;
    //   205: invokeinterface 227 4 0
    //   210: pop
    //   211: aload 4
    //   213: astore_3
    //   214: aload 5
    //   216: aconst_null
    //   217: ldc_w 262
    //   220: aload 6
    //   222: getfield 265	com/tencent/qqprotect/qsec/QSecDatabaseMgr$LibEntry:e	Ljava/lang/String;
    //   225: invokeinterface 227 4 0
    //   230: pop
    //   231: aload 4
    //   233: astore_3
    //   234: aload 5
    //   236: aconst_null
    //   237: ldc 160
    //   239: invokeinterface 268 3 0
    //   244: pop
    //   245: goto -160 -> 85
    //   248: aload 4
    //   250: astore_3
    //   251: aload 5
    //   253: aconst_null
    //   254: ldc 215
    //   256: invokeinterface 268 3 0
    //   261: pop
    //   262: aload 4
    //   264: astore_3
    //   265: aload 5
    //   267: invokeinterface 271 1 0
    //   272: aload 4
    //   274: astore_3
    //   275: aload 4
    //   277: invokevirtual 275	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   280: astore_2
    //   281: aload 4
    //   283: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   286: aload_2
    //   287: areturn
    //   288: astore_3
    //   289: aload_3
    //   290: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   293: aload_2
    //   294: areturn
    //   295: astore_3
    //   296: aload 4
    //   298: astore_2
    //   299: aload_3
    //   300: astore 4
    //   302: goto +13 -> 315
    //   305: astore_2
    //   306: aconst_null
    //   307: astore_3
    //   308: goto +32 -> 340
    //   311: astore 4
    //   313: aconst_null
    //   314: astore_2
    //   315: aload_2
    //   316: astore_3
    //   317: aload 4
    //   319: invokevirtual 86	java/lang/Exception:printStackTrace	()V
    //   322: aload_2
    //   323: ifnull +14 -> 337
    //   326: aload_2
    //   327: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   330: aconst_null
    //   331: areturn
    //   332: astore_2
    //   333: aload_2
    //   334: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   337: aconst_null
    //   338: areturn
    //   339: astore_2
    //   340: aload_3
    //   341: ifnull +15 -> 356
    //   344: aload_3
    //   345: invokevirtual 276	java/io/ByteArrayOutputStream:close	()V
    //   348: goto +8 -> 356
    //   351: astore_3
    //   352: aload_3
    //   353: invokevirtual 178	java/io/IOException:printStackTrace	()V
    //   356: goto +5 -> 361
    //   359: aload_2
    //   360: athrow
    //   361: goto -2 -> 359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	QSecDatabaseMgr
    //   0	364	1	paramInt	int
    //   0	364	2	paramList	List<QSecDatabaseMgr.LibEntry>
    //   16	259	3	localObject1	Object
    //   288	2	3	localIOException1	java.io.IOException
    //   295	5	3	localException1	Exception
    //   307	38	3	localList	List<QSecDatabaseMgr.LibEntry>
    //   351	2	3	localIOException2	java.io.IOException
    //   12	289	4	localObject2	Object
    //   311	7	4	localException2	Exception
    //   3	263	5	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   109	112	6	localLibEntry	QSecDatabaseMgr.LibEntry
    // Exception table:
    //   from	to	target	type
    //   281	286	288	java/io/IOException
    //   17	28	295	java/lang/Exception
    //   31	43	295	java/lang/Exception
    //   46	57	295	java/lang/Exception
    //   60	75	295	java/lang/Exception
    //   78	85	295	java/lang/Exception
    //   88	97	295	java/lang/Exception
    //   100	111	295	java/lang/Exception
    //   114	125	295	java/lang/Exception
    //   128	147	295	java/lang/Exception
    //   150	169	295	java/lang/Exception
    //   172	191	295	java/lang/Exception
    //   194	211	295	java/lang/Exception
    //   214	231	295	java/lang/Exception
    //   234	245	295	java/lang/Exception
    //   251	262	295	java/lang/Exception
    //   265	272	295	java/lang/Exception
    //   275	281	295	java/lang/Exception
    //   0	14	305	finally
    //   0	14	311	java/lang/Exception
    //   326	330	332	java/io/IOException
    //   17	28	339	finally
    //   31	43	339	finally
    //   46	57	339	finally
    //   60	75	339	finally
    //   78	85	339	finally
    //   88	97	339	finally
    //   100	111	339	finally
    //   114	125	339	finally
    //   128	147	339	finally
    //   150	169	339	finally
    //   172	191	339	finally
    //   194	211	339	finally
    //   214	231	339	finally
    //   234	245	339	finally
    //   251	262	339	finally
    //   265	272	339	finally
    //   275	281	339	finally
    //   317	322	339	finally
    //   344	348	351	java/io/IOException
  }
  
  private QSecDatabaseMgr.LibEntry b(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      QSecDatabaseMgr.LibEntry localLibEntry = (QSecDatabaseMgr.LibEntry)localIterator.next();
      if (localLibEntry.a == paramInt) {
        return localLibEntry;
      }
    }
    return null;
  }
  
  private QSecDatabaseMgr.LibEntry b(Node paramNode)
  {
    int j;
    label246:
    do
    {
      for (;;)
      {
        int i;
        try
        {
          NamedNodeMap localNamedNodeMap = paramNode.getAttributes();
          if (localNamedNodeMap == null) {
            return null;
          }
          localLibEntry = new QSecDatabaseMgr.LibEntry();
          int m = localNamedNodeMap.getLength();
          i = 0;
          j = 0;
          if (i >= m) {
            break;
          }
          Object localObject = localNamedNodeMap.item(i);
          if (((Node)localObject).getNodeType() != 2)
          {
            k = j;
            break label246;
          }
          String str = ((Node)localObject).getNodeName();
          localObject = ((Node)localObject).getNodeValue();
          k = j;
          if (str == null) {
            break label246;
          }
          if (localObject == null)
          {
            k = j;
            break label246;
          }
          if (str.equalsIgnoreCase("id"))
          {
            localLibEntry.a = Integer.parseInt((String)localObject);
          }
          else if (str.equalsIgnoreCase("type"))
          {
            localLibEntry.b = Integer.parseInt((String)localObject);
          }
          else if (str.equalsIgnoreCase("flags"))
          {
            localLibEntry.c = Integer.parseInt((String)localObject);
          }
          else if (str.equalsIgnoreCase("path"))
          {
            localLibEntry.e = ((String)localObject);
          }
          else
          {
            k = j;
            if (!str.equalsIgnoreCase("ver")) {
              break label246;
            }
            localLibEntry.d = ((String)localObject);
          }
        }
        catch (Exception paramNode)
        {
          QSecDatabaseMgr.LibEntry localLibEntry;
          paramNode.printStackTrace();
          return null;
        }
        localLibEntry.f = a(paramNode);
        return localLibEntry;
        int k = j + 1;
        i += 1;
        j = k;
      }
    } while (j == 5);
    return null;
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QPDirUtils.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("QSec.dat");
    return localStringBuilder.toString();
  }
  
  private boolean c(int paramInt)
  {
    return b(paramInt) != null;
  }
  
  public QSecDatabaseMgr.LibEntry a(int paramInt)
  {
    return b(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    QSecDatabaseMgr.LibEntry localLibEntry = b(paramInt);
    if (localLibEntry == null) {
      return;
    }
    this.a.remove(localLibEntry);
    if (paramBoolean) {
      a(c(), this.b, this.a);
    }
  }
  
  public boolean a()
  {
    return a(c(), this.b, this.a);
  }
  
  public boolean a(QSecDatabaseMgr.LibEntry paramLibEntry, boolean paramBoolean)
  {
    if (c(paramLibEntry.a)) {
      return false;
    }
    this.a.add(paramLibEntry);
    if (paramBoolean) {
      return a();
    }
    return true;
  }
  
  public List<QSecDatabaseMgr.LibEntry> b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecDatabaseMgr
 * JD-Core Version:    0.7.0.1
 */