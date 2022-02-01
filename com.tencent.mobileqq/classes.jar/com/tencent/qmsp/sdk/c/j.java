package com.tencent.qmsp.sdk.c;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.qmsp.sdk.a.b;
import com.tencent.qmsp.sdk.f.k;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class j
{
  private static final byte[][] c;
  private List<j.a> a;
  private int b = 1;
  
  static
  {
    byte[] arrayOfByte = { 43, 113, -66, 69 };
    c = new byte[][] { { 20, 67, -74, 67, 2, 50, 117, -18 }, { 51, 117, -95, 83, 39, 52, 121 }, { 9, 121, -79, 101, 32, 47, 101, -28 }, { 44, 116 }, { 49, 105, -93, 69 }, { 35, 124, -78, 71, 61 }, { 53, 113, -89, 72 }, arrayOfByte, { 51, 113, -65, 85, 43 }, { 51, 117, -95 }, { 20, 125, -96, 80, 96, 63, 118, -23 } };
  }
  
  public j()
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
          break label88;
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
        if ((str != null) && (str.equalsIgnoreCase(b(1))))
        {
          i = Integer.parseInt(localNode.getNodeValue());
          return i;
        }
        i += 1;
      }
      else
      {
        return 0;
        label88:
        i = 0;
      }
    }
  }
  
  private Pair<Integer, List<j.a>> a(String paramString, int paramInt)
  {
    paramString = new m().a(paramString, null, 1);
    if (paramString != null) {
      return a(paramString, paramInt);
    }
    return null;
  }
  
  /* Error */
  private Pair<Integer, List<j.a>> a(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 157	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aload 5
    //   10: invokevirtual 161	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   13: astore 7
    //   15: new 163	java/io/ByteArrayInputStream
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 166	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: astore 5
    //   25: aload 5
    //   27: astore_1
    //   28: aload 7
    //   30: aload 5
    //   32: invokevirtual 172	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   35: invokeinterface 178 1 0
    //   40: astore 7
    //   42: aload 5
    //   44: astore_1
    //   45: aload_0
    //   46: aload 7
    //   48: invokespecial 180	com/tencent/qmsp/sdk/c/j:a	(Lorg/w3c/dom/Element;)I
    //   51: istore_3
    //   52: iload_3
    //   53: ifeq +190 -> 243
    //   56: iload_3
    //   57: iload_2
    //   58: if_icmple +6 -> 64
    //   61: goto +182 -> 243
    //   64: aload 5
    //   66: astore_1
    //   67: new 95	java/util/LinkedList
    //   70: dup
    //   71: invokespecial 96	java/util/LinkedList:<init>	()V
    //   74: astore 6
    //   76: aload 5
    //   78: astore_1
    //   79: aload 7
    //   81: invokeinterface 184 1 0
    //   86: astore 7
    //   88: aload 5
    //   90: astore_1
    //   91: aload 7
    //   93: invokeinterface 187 1 0
    //   98: istore 4
    //   100: iconst_0
    //   101: istore_2
    //   102: iload_2
    //   103: iload 4
    //   105: if_icmpge +104 -> 209
    //   108: aload 5
    //   110: astore_1
    //   111: aload 7
    //   113: iload_2
    //   114: invokeinterface 188 2 0
    //   119: astore 8
    //   121: aload 5
    //   123: astore_1
    //   124: aload 8
    //   126: invokeinterface 192 1 0
    //   131: iconst_1
    //   132: if_icmpeq +6 -> 138
    //   135: goto +222 -> 357
    //   138: aload 5
    //   140: astore_1
    //   141: aload 8
    //   143: invokeinterface 119 1 0
    //   148: astore 9
    //   150: aload 9
    //   152: ifnull +205 -> 357
    //   155: aload 5
    //   157: astore_1
    //   158: aload 9
    //   160: aload_0
    //   161: iconst_2
    //   162: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   165: invokevirtual 128	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   168: ifne +6 -> 174
    //   171: goto +186 -> 357
    //   174: aload 5
    //   176: astore_1
    //   177: aload_0
    //   178: aload 8
    //   180: invokespecial 195	com/tencent/qmsp/sdk/c/j:a	(Lorg/w3c/dom/Node;)Lcom/tencent/qmsp/sdk/c/j$a;
    //   183: astore 8
    //   185: aload 8
    //   187: ifnonnull +6 -> 193
    //   190: goto +167 -> 357
    //   193: aload 5
    //   195: astore_1
    //   196: aload 6
    //   198: aload 8
    //   200: invokeinterface 199 2 0
    //   205: pop
    //   206: goto +151 -> 357
    //   209: aload 5
    //   211: astore_1
    //   212: new 76	android/util/Pair
    //   215: dup
    //   216: iload_3
    //   217: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   220: aload 6
    //   222: invokespecial 206	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   225: astore 6
    //   227: aload 5
    //   229: invokevirtual 209	java/io/ByteArrayInputStream:close	()V
    //   232: aload 6
    //   234: areturn
    //   235: astore_1
    //   236: aload_1
    //   237: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   240: aload 6
    //   242: areturn
    //   243: aload 5
    //   245: astore_1
    //   246: new 76	android/util/Pair
    //   249: dup
    //   250: iload_3
    //   251: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: aconst_null
    //   255: invokespecial 206	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   258: astore 6
    //   260: aload 5
    //   262: invokevirtual 209	java/io/ByteArrayInputStream:close	()V
    //   265: aload 6
    //   267: areturn
    //   268: astore_1
    //   269: aload_1
    //   270: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   273: aload 6
    //   275: areturn
    //   276: astore 6
    //   278: goto +16 -> 294
    //   281: astore_1
    //   282: aload 6
    //   284: astore 5
    //   286: goto +43 -> 329
    //   289: astore 6
    //   291: aconst_null
    //   292: astore 5
    //   294: aload 5
    //   296: astore_1
    //   297: aload 6
    //   299: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   302: aload 5
    //   304: ifnull +15 -> 319
    //   307: aload 5
    //   309: invokevirtual 209	java/io/ByteArrayInputStream:close	()V
    //   312: aconst_null
    //   313: areturn
    //   314: astore_1
    //   315: aload_1
    //   316: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   319: aconst_null
    //   320: areturn
    //   321: astore 6
    //   323: aload_1
    //   324: astore 5
    //   326: aload 6
    //   328: astore_1
    //   329: aload 5
    //   331: ifnull +18 -> 349
    //   334: aload 5
    //   336: invokevirtual 209	java/io/ByteArrayInputStream:close	()V
    //   339: goto +10 -> 349
    //   342: astore 5
    //   344: aload 5
    //   346: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   349: goto +5 -> 354
    //   352: aload_1
    //   353: athrow
    //   354: goto -2 -> 352
    //   357: iload_2
    //   358: iconst_1
    //   359: iadd
    //   360: istore_2
    //   361: goto -259 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	j
    //   0	364	1	paramArrayOfByte	byte[]
    //   0	364	2	paramInt	int
    //   51	200	3	i	int
    //   98	8	4	j	int
    //   3	332	5	localObject1	Object
    //   342	3	5	localIOException	java.io.IOException
    //   6	268	6	localObject2	Object
    //   276	7	6	localException1	Exception
    //   289	9	6	localException2	Exception
    //   321	6	6	localObject3	Object
    //   13	99	7	localObject4	Object
    //   119	80	8	localObject5	Object
    //   148	11	9	str	String
    // Exception table:
    //   from	to	target	type
    //   227	232	235	java/io/IOException
    //   260	265	268	java/io/IOException
    //   28	42	276	java/lang/Exception
    //   45	52	276	java/lang/Exception
    //   67	76	276	java/lang/Exception
    //   79	88	276	java/lang/Exception
    //   91	100	276	java/lang/Exception
    //   111	121	276	java/lang/Exception
    //   124	135	276	java/lang/Exception
    //   141	150	276	java/lang/Exception
    //   158	171	276	java/lang/Exception
    //   177	185	276	java/lang/Exception
    //   196	206	276	java/lang/Exception
    //   212	227	276	java/lang/Exception
    //   246	260	276	java/lang/Exception
    //   8	25	281	finally
    //   8	25	289	java/lang/Exception
    //   307	312	314	java/io/IOException
    //   28	42	321	finally
    //   45	52	321	finally
    //   67	76	321	finally
    //   79	88	321	finally
    //   91	100	321	finally
    //   111	121	321	finally
    //   124	135	321	finally
    //   141	150	321	finally
    //   158	171	321	finally
    //   177	185	321	finally
    //   196	206	321	finally
    //   212	227	321	finally
    //   246	260	321	finally
    //   297	302	321	finally
    //   334	339	342	java/io/IOException
  }
  
  private j.a a(Node paramNode)
  {
    int j;
    label257:
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
          locala = new j.a();
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
            break label257;
          }
          String str = ((Node)localObject).getNodeName();
          localObject = ((Node)localObject).getNodeValue();
          k = j;
          if (str == null) {
            break label257;
          }
          if (localObject == null)
          {
            k = j;
            break label257;
          }
          if (str.equalsIgnoreCase(b(3)))
          {
            locala.a = Integer.parseInt((String)localObject);
          }
          else if (str.equalsIgnoreCase(b(4)))
          {
            locala.b = Integer.parseInt((String)localObject);
          }
          else if (str.equalsIgnoreCase(b(5)))
          {
            locala.c = Integer.parseInt((String)localObject);
          }
          else if (str.equalsIgnoreCase(b(6)))
          {
            locala.e = ((String)localObject);
          }
          else
          {
            k = j;
            if (!str.equalsIgnoreCase(b(9))) {
              break label257;
            }
            locala.d = ((String)localObject);
          }
        }
        catch (Exception paramNode)
        {
          j.a locala;
          paramNode.printStackTrace();
          return null;
        }
        b(paramNode);
        return locala;
        int k = j + 1;
        i += 1;
        j = k;
      }
    } while (j == 5);
    return null;
  }
  
  private boolean a(String paramString, int paramInt, List<j.a> paramList)
  {
    paramList = a(paramInt, paramList);
    if (paramList == null) {
      return false;
    }
    return new m().a(paramString, paramList, null, 1);
  }
  
  /* Error */
  private byte[] a(int paramInt, List<j.a> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 244	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   5: astore 5
    //   7: new 246	java/io/ByteArrayOutputStream
    //   10: dup
    //   11: invokespecial 247	java/io/ByteArrayOutputStream:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: astore_3
    //   19: aload 5
    //   21: aload 4
    //   23: ldc 249
    //   25: invokeinterface 255 3 0
    //   30: aload 4
    //   32: astore_3
    //   33: aload 5
    //   35: aconst_null
    //   36: iconst_1
    //   37: invokestatic 260	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   40: invokeinterface 264 3 0
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: aconst_null
    //   51: aload_0
    //   52: iconst_0
    //   53: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   56: invokeinterface 268 3 0
    //   61: pop
    //   62: aload 4
    //   64: astore_3
    //   65: aload 5
    //   67: aconst_null
    //   68: aload_0
    //   69: iconst_1
    //   70: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   73: iload_1
    //   74: invokestatic 271	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   77: invokeinterface 275 4 0
    //   82: pop
    //   83: aload 4
    //   85: astore_3
    //   86: aload_2
    //   87: invokeinterface 279 1 0
    //   92: astore_2
    //   93: aload 4
    //   95: astore_3
    //   96: aload_2
    //   97: invokeinterface 285 1 0
    //   102: ifeq +175 -> 277
    //   105: aload 4
    //   107: astore_3
    //   108: aload_2
    //   109: invokeinterface 289 1 0
    //   114: checkcast 214	com/tencent/qmsp/sdk/c/j$a
    //   117: astore 6
    //   119: aload 4
    //   121: astore_3
    //   122: aload 5
    //   124: aconst_null
    //   125: aload_0
    //   126: iconst_2
    //   127: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   130: invokeinterface 268 3 0
    //   135: pop
    //   136: aload 4
    //   138: astore_3
    //   139: aload 5
    //   141: aconst_null
    //   142: aload_0
    //   143: iconst_3
    //   144: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   147: aload 6
    //   149: getfield 217	com/tencent/qmsp/sdk/c/j$a:a	I
    //   152: invokestatic 271	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   155: invokeinterface 275 4 0
    //   160: pop
    //   161: aload 4
    //   163: astore_3
    //   164: aload 5
    //   166: aconst_null
    //   167: aload_0
    //   168: iconst_4
    //   169: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   172: aload 6
    //   174: getfield 218	com/tencent/qmsp/sdk/c/j$a:b	I
    //   177: invokestatic 271	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   180: invokeinterface 275 4 0
    //   185: pop
    //   186: aload 4
    //   188: astore_3
    //   189: aload 5
    //   191: aconst_null
    //   192: aload_0
    //   193: iconst_5
    //   194: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   197: aload 6
    //   199: getfield 220	com/tencent/qmsp/sdk/c/j$a:c	I
    //   202: invokestatic 271	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   205: invokeinterface 275 4 0
    //   210: pop
    //   211: aload 4
    //   213: astore_3
    //   214: aload 5
    //   216: aconst_null
    //   217: aload_0
    //   218: bipush 9
    //   220: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   223: aload 6
    //   225: getfield 227	com/tencent/qmsp/sdk/c/j$a:d	Ljava/lang/String;
    //   228: invokeinterface 275 4 0
    //   233: pop
    //   234: aload 4
    //   236: astore_3
    //   237: aload 5
    //   239: aconst_null
    //   240: aload_0
    //   241: bipush 6
    //   243: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   246: aload 6
    //   248: getfield 224	com/tencent/qmsp/sdk/c/j$a:e	Ljava/lang/String;
    //   251: invokeinterface 275 4 0
    //   256: pop
    //   257: aload 4
    //   259: astore_3
    //   260: aload 5
    //   262: aconst_null
    //   263: aload_0
    //   264: iconst_2
    //   265: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   268: invokeinterface 292 3 0
    //   273: pop
    //   274: goto -181 -> 93
    //   277: aload 4
    //   279: astore_3
    //   280: aload 5
    //   282: aconst_null
    //   283: aload_0
    //   284: iconst_0
    //   285: invokespecial 122	com/tencent/qmsp/sdk/c/j:b	(I)Ljava/lang/String;
    //   288: invokeinterface 292 3 0
    //   293: pop
    //   294: aload 4
    //   296: astore_3
    //   297: aload 5
    //   299: invokeinterface 295 1 0
    //   304: aload 4
    //   306: astore_3
    //   307: aload 4
    //   309: invokevirtual 299	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   312: astore_2
    //   313: aload 4
    //   315: invokevirtual 300	java/io/ByteArrayOutputStream:close	()V
    //   318: aload_2
    //   319: areturn
    //   320: astore_3
    //   321: aload_3
    //   322: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   325: aload_2
    //   326: areturn
    //   327: astore_3
    //   328: aload 4
    //   330: astore_2
    //   331: aload_3
    //   332: astore 4
    //   334: goto +11 -> 345
    //   337: astore_2
    //   338: goto +32 -> 370
    //   341: astore 4
    //   343: aconst_null
    //   344: astore_2
    //   345: aload_2
    //   346: astore_3
    //   347: aload 4
    //   349: invokevirtual 138	java/lang/Exception:printStackTrace	()V
    //   352: aload_2
    //   353: ifnull +14 -> 367
    //   356: aload_2
    //   357: invokevirtual 300	java/io/ByteArrayOutputStream:close	()V
    //   360: aconst_null
    //   361: areturn
    //   362: astore_2
    //   363: aload_2
    //   364: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   367: aconst_null
    //   368: areturn
    //   369: astore_2
    //   370: aload_3
    //   371: ifnull +15 -> 386
    //   374: aload_3
    //   375: invokevirtual 300	java/io/ByteArrayOutputStream:close	()V
    //   378: goto +8 -> 386
    //   381: astore_3
    //   382: aload_3
    //   383: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   386: goto +5 -> 391
    //   389: aload_2
    //   390: athrow
    //   391: goto -2 -> 389
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	j
    //   0	394	1	paramInt	int
    //   0	394	2	paramList	List<j.a>
    //   1	306	3	localObject1	Object
    //   320	2	3	localIOException1	java.io.IOException
    //   327	5	3	localException1	Exception
    //   346	29	3	localList	List<j.a>
    //   381	2	3	localIOException2	java.io.IOException
    //   14	319	4	localObject2	Object
    //   341	7	4	localException2	Exception
    //   5	293	5	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   117	130	6	locala	j.a
    // Exception table:
    //   from	to	target	type
    //   313	318	320	java/io/IOException
    //   19	30	327	java/lang/Exception
    //   33	45	327	java/lang/Exception
    //   48	62	327	java/lang/Exception
    //   65	83	327	java/lang/Exception
    //   86	93	327	java/lang/Exception
    //   96	105	327	java/lang/Exception
    //   108	119	327	java/lang/Exception
    //   122	136	327	java/lang/Exception
    //   139	161	327	java/lang/Exception
    //   164	186	327	java/lang/Exception
    //   189	211	327	java/lang/Exception
    //   214	234	327	java/lang/Exception
    //   237	257	327	java/lang/Exception
    //   260	274	327	java/lang/Exception
    //   280	294	327	java/lang/Exception
    //   297	304	327	java/lang/Exception
    //   307	313	327	java/lang/Exception
    //   2	16	337	finally
    //   2	16	341	java/lang/Exception
    //   356	360	362	java/io/IOException
    //   19	30	369	finally
    //   33	45	369	finally
    //   48	62	369	finally
    //   65	83	369	finally
    //   86	93	369	finally
    //   96	105	369	finally
    //   108	119	369	finally
    //   122	136	369	finally
    //   139	161	369	finally
    //   164	186	369	finally
    //   189	211	369	finally
    //   214	234	369	finally
    //   237	257	369	finally
    //   260	274	369	finally
    //   280	294	369	finally
    //   297	304	369	finally
    //   307	313	369	finally
    //   347	352	369	finally
    //   374	378	381	java/io/IOException
  }
  
  private Bundle b(Node paramNode)
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
            localObject1 = ((NamedNodeMap)localObject2).getNamedItem(b(7));
            if ((localObject1 != null) && (((Node)localObject1).getNodeType() == 2))
            {
              localObject1 = ((Node)localObject1).getNodeValue();
              if (localObject1 != null)
              {
                localObject2 = ((NamedNodeMap)localObject2).getNamedItem(b(8));
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
  
  private String b(int paramInt)
  {
    return k.a(c[paramInt]);
  }
  
  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(b(10));
    return localStringBuilder.toString();
  }
  
  private boolean c(int paramInt)
  {
    return d(paramInt) != null;
  }
  
  private j.a d(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      j.a locala = (j.a)localIterator.next();
      if (locala.a == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  public j.a a(int paramInt)
  {
    return d(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    j.a locala = d(paramInt);
    if (locala == null) {
      return;
    }
    this.a.remove(locala);
    if (paramBoolean) {
      a(c(), this.b, this.a);
    }
  }
  
  public boolean a()
  {
    return a(c(), this.b, this.a);
  }
  
  public boolean a(j.a parama, boolean paramBoolean)
  {
    if (c(parama.a)) {
      return false;
    }
    this.a.add(parama);
    if (paramBoolean) {
      return a();
    }
    return true;
  }
  
  public List<j.a> b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.j
 * JD-Core Version:    0.7.0.1
 */