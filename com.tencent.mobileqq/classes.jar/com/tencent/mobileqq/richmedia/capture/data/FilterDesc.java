package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Bundle;
import java.io.File;
import java.util.ArrayList;

public class FilterDesc
{
  public Bundle bundle;
  public String display;
  public String iconMD5;
  public String iconurl;
  public int id;
  public String name;
  public int predownload;
  public String resMD5;
  public ArrayList<String> resNameList;
  public String resRootPath;
  public String respicname;
  public String resurl;
  public int subId;
  public int type;
  public int version;
  
  public FilterDesc() {}
  
  public FilterDesc(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt4)
  {
    this.id = paramInt1;
    this.subId = paramInt2;
    this.predownload = paramInt3;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
    this.type = paramInt4;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.id = paramInt1;
    this.predownload = paramInt2;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    this.id = paramInt1;
    this.predownload = paramInt2;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
    this.type = paramInt3;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4)
  {
    this.id = paramInt1;
    this.predownload = paramInt2;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
    this.type = paramInt3;
    this.version = paramInt4;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4, String paramString6)
  {
    this.id = paramInt1;
    this.predownload = paramInt2;
    this.resurl = paramString1;
    this.resMD5 = paramString2;
    this.iconurl = paramString3;
    this.iconMD5 = paramString4;
    this.name = paramString5;
    this.type = paramInt3;
    this.version = paramInt4;
    this.respicname = paramString6;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, String paramString6)
  {
    this(paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt3);
    this.resRootPath = paramString6;
  }
  
  /* Error */
  public static ArrayList<FilterDesc> parse(org.json.JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: new 69	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 70	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: iconst_0
    //   10: istore_1
    //   11: iload_1
    //   12: aload_0
    //   13: invokevirtual 76	org/json/JSONArray:length	()I
    //   16: if_icmpge +296 -> 312
    //   19: aload_0
    //   20: iload_1
    //   21: invokevirtual 80	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   24: astore 10
    //   26: iconst_0
    //   27: istore_2
    //   28: aload 10
    //   30: ldc 82
    //   32: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   35: ifeq +17 -> 52
    //   38: aload 10
    //   40: ldc 82
    //   42: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokestatic 98	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   48: invokevirtual 101	java/lang/Integer:intValue	()I
    //   51: istore_2
    //   52: aload 10
    //   54: ldc 102
    //   56: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   59: ifeq +230 -> 289
    //   62: aload 10
    //   64: ldc 102
    //   66: invokevirtual 92	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: invokestatic 98	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   72: invokevirtual 101	java/lang/Integer:intValue	()I
    //   75: istore_3
    //   76: iconst_0
    //   77: istore 4
    //   79: aload 10
    //   81: ldc 103
    //   83: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   86: ifeq +20 -> 106
    //   89: aload 10
    //   91: ldc 103
    //   93: ldc 105
    //   95: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   98: invokestatic 98	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   101: invokevirtual 101	java/lang/Integer:intValue	()I
    //   104: istore 4
    //   106: aload 10
    //   108: ldc 110
    //   110: ldc 112
    //   112: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   115: astore 6
    //   117: aload 10
    //   119: ldc 114
    //   121: ldc 112
    //   123: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 7
    //   128: aload 10
    //   130: ldc 116
    //   132: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   135: ifeq +25 -> 160
    //   138: aload 10
    //   140: ldc 116
    //   142: ldc 112
    //   144: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 6
    //   149: aload 10
    //   151: ldc 118
    //   153: ldc 112
    //   155: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 7
    //   160: aload 10
    //   162: ldc 120
    //   164: invokevirtual 122	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   167: astore 11
    //   169: aload 10
    //   171: ldc 124
    //   173: invokevirtual 122	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore 12
    //   178: aload 10
    //   180: ldc 125
    //   182: invokevirtual 122	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: astore 5
    //   187: aload 10
    //   189: ldc 127
    //   191: invokevirtual 88	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   194: ifeq +14 -> 208
    //   197: aload 10
    //   199: ldc 127
    //   201: ldc 112
    //   203: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 5
    //   208: aload 10
    //   210: ldc 128
    //   212: ldc 112
    //   214: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   217: astore 8
    //   219: aload 8
    //   221: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   224: ifeq +99 -> 323
    //   227: aload 5
    //   229: astore 8
    //   231: new 2	com/tencent/mobileqq/richmedia/capture/data/FilterDesc
    //   234: dup
    //   235: iload_2
    //   236: iload 4
    //   238: aload 6
    //   240: aload 7
    //   242: aload 11
    //   244: aload 12
    //   246: aload 5
    //   248: iload_3
    //   249: aload 10
    //   251: ldc 135
    //   253: iconst_0
    //   254: invokevirtual 139	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   257: aload 10
    //   259: ldc 140
    //   261: ldc 112
    //   263: invokevirtual 109	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   266: invokespecial 142	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:<init>	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
    //   269: astore 5
    //   271: aload 5
    //   273: aload 8
    //   275: putfield 144	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:display	Ljava/lang/String;
    //   278: aload 9
    //   280: aload 5
    //   282: invokevirtual 148	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   285: pop
    //   286: goto +40 -> 326
    //   289: iload_2
    //   290: invokestatic 154	com/tencent/av/opengl/filter/qqavimage/QQAVImageFilterConstants:getFilterType	(I)I
    //   293: istore_3
    //   294: goto -218 -> 76
    //   297: astore 5
    //   299: aload 5
    //   301: invokevirtual 157	org/json/JSONException:printStackTrace	()V
    //   304: goto +22 -> 326
    //   307: astore_0
    //   308: aload_0
    //   309: invokevirtual 157	org/json/JSONException:printStackTrace	()V
    //   312: aload 9
    //   314: areturn
    //   315: astore_0
    //   316: aload_0
    //   317: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   320: aload 9
    //   322: areturn
    //   323: goto -92 -> 231
    //   326: iload_1
    //   327: iconst_1
    //   328: iadd
    //   329: istore_1
    //   330: goto -319 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramJSONArray	org.json.JSONArray
    //   10	320	1	i	int
    //   27	263	2	j	int
    //   75	219	3	k	int
    //   77	160	4	m	int
    //   185	96	5	localObject1	Object
    //   297	3	5	localJSONException	org.json.JSONException
    //   115	124	6	str1	String
    //   126	115	7	str2	String
    //   217	57	8	localObject2	Object
    //   7	314	9	localArrayList	ArrayList
    //   24	234	10	localJSONObject	org.json.JSONObject
    //   167	76	11	str3	String
    //   176	69	12	str4	String
    // Exception table:
    //   from	to	target	type
    //   28	52	297	org/json/JSONException
    //   52	76	297	org/json/JSONException
    //   79	106	297	org/json/JSONException
    //   106	128	297	org/json/JSONException
    //   128	160	297	org/json/JSONException
    //   160	187	297	org/json/JSONException
    //   187	208	297	org/json/JSONException
    //   208	227	297	org/json/JSONException
    //   231	286	297	org/json/JSONException
    //   289	294	297	org/json/JSONException
    //   11	26	307	org/json/JSONException
    //   299	304	307	org/json/JSONException
    //   11	26	315	java/lang/Exception
    //   28	52	315	java/lang/Exception
    //   52	76	315	java/lang/Exception
    //   79	106	315	java/lang/Exception
    //   106	128	315	java/lang/Exception
    //   128	160	315	java/lang/Exception
    //   160	187	315	java/lang/Exception
    //   187	208	315	java/lang/Exception
    //   208	227	315	java/lang/Exception
    //   231	286	315	java/lang/Exception
    //   289	294	315	java/lang/Exception
    //   299	304	315	java/lang/Exception
  }
  
  public String getFileNameWithoutExtension(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    int i;
    int j;
    do
    {
      return paramString;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf(File.separator);
      if (j != -1) {
        break;
      }
    } while (i == -1);
    return paramString.substring(0, i);
    if (i == -1) {
      return paramString.substring(j + 1);
    }
    if (j < i) {}
    for (paramString = paramString.substring(j + 1, i);; paramString = paramString.substring(j + 1)) {
      return paramString;
    }
  }
  
  public String getIconFile(String paramString)
  {
    return paramString + this.name + ".png";
  }
  
  public String getResFold(String paramString)
  {
    if ((this.resurl == null) || (this.resurl.equals(""))) {
      return "";
    }
    String str = getFileNameWithoutExtension(this.resurl);
    return paramString + str + File.separator;
  }
  
  public boolean isEmptyFilter()
  {
    return (this.id == -1) || (this.id == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.FilterDesc
 * JD-Core Version:    0.7.0.1
 */