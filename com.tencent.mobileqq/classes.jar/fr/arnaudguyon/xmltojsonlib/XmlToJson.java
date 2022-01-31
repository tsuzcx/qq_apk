package fr.arnaudguyon.xmltojsonlib;

import android.support.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlToJson
{
  private static final String DEFAULT_CONTENT_NAME = "content";
  private static final boolean DEFAULT_EMPTY_BOOLEAN = false;
  private static final double DEFAULT_EMPTY_DOUBLE = 0.0D;
  private static final int DEFAULT_EMPTY_INTEGER = 0;
  private static final long DEFAULT_EMPTY_LONG = 0L;
  private static final String DEFAULT_EMPTY_STRING = "";
  private static final String DEFAULT_ENCODING = "utf-8";
  private static final String DEFAULT_INDENTATION = "   ";
  private static final String TAG = "XmlToJson";
  private HashMap<String, String> mAttributeNameReplacements;
  private HashMap<String, String> mContentNameReplacements;
  private HashMap<String, Class> mForceClassForPath;
  private HashSet<String> mForceListPaths;
  private String mIndentationPattern = "   ";
  private String mInputEncoding;
  private InputStream mInputStreamSource;
  private JSONObject mJsonObject;
  private HashSet<String> mSkippedAttributes = new HashSet();
  private HashSet<String> mSkippedTags = new HashSet();
  private StringReader mStringSource;
  
  private XmlToJson(XmlToJson.Builder paramBuilder)
  {
    this.mStringSource = XmlToJson.Builder.access$100(paramBuilder);
    this.mInputStreamSource = XmlToJson.Builder.access$200(paramBuilder);
    this.mInputEncoding = XmlToJson.Builder.access$300(paramBuilder);
    this.mForceListPaths = XmlToJson.Builder.access$400(paramBuilder);
    this.mAttributeNameReplacements = XmlToJson.Builder.access$500(paramBuilder);
    this.mContentNameReplacements = XmlToJson.Builder.access$600(paramBuilder);
    this.mForceClassForPath = XmlToJson.Builder.access$700(paramBuilder);
    this.mSkippedAttributes = XmlToJson.Builder.access$800(paramBuilder);
    this.mSkippedTags = XmlToJson.Builder.access$900(paramBuilder);
    this.mJsonObject = convertToJSONObject();
  }
  
  private JSONObject convertTagToJson(Tag paramTag, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1;
    if (paramTag.getContent() != null)
    {
      localObject1 = paramTag.getPath();
      putContent((String)localObject1, localJSONObject, getContentNameReplacement((String)localObject1, "content"), paramTag.getContent());
    }
    for (;;)
    {
      try
      {
        paramTag = paramTag.getGroupedElements().values().iterator();
        if (!paramTag.hasNext()) {
          break;
        }
        localObject1 = (ArrayList)paramTag.next();
        if (((ArrayList)localObject1).size() != 1) {
          break label201;
        }
        localObject1 = (Tag)((ArrayList)localObject1).get(0);
        if (isForcedList((Tag)localObject1))
        {
          localObject2 = new JSONArray();
          ((JSONArray)localObject2).put(convertTagToJson((Tag)localObject1, true));
          localJSONObject.put(((Tag)localObject1).getName(), localObject2);
          continue;
        }
        if (!((Tag)localObject1).hasChildren()) {
          break label178;
        }
      }
      catch (JSONException paramTag)
      {
        paramTag.printStackTrace();
        return null;
      }
      Object localObject2 = convertTagToJson((Tag)localObject1, false);
      localJSONObject.put(((Tag)localObject1).getName(), localObject2);
      continue;
      label178:
      putContent(((Tag)localObject1).getPath(), localJSONObject, ((Tag)localObject1).getName(), ((Tag)localObject1).getContent());
      continue;
      label201:
      localObject2 = new JSONArray();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (localIterator.hasNext()) {
        ((JSONArray)localObject2).put(convertTagToJson((Tag)localIterator.next(), true));
      }
      localJSONObject.put(((Tag)((ArrayList)localObject1).get(0)).getName(), localObject2);
    }
    return localJSONObject;
  }
  
  @Nullable
  private JSONObject convertToJSONObject()
  {
    try
    {
      Object localObject1 = new Tag("", "xml");
      Object localObject2 = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject2).setNamespaceAware(false);
      localObject2 = ((XmlPullParserFactory)localObject2).newPullParser();
      setInput((XmlPullParser)localObject2);
      for (int i = ((XmlPullParser)localObject2).getEventType(); i != 0; i = ((XmlPullParser)localObject2).next()) {}
      readTags((Tag)localObject1, (XmlPullParser)localObject2);
      unsetInput();
      localObject1 = convertTagToJson((Tag)localObject1, false);
      return localObject1;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      localXmlPullParserException.printStackTrace();
      return null;
    }
    catch (IOException localIOException)
    {
      label72:
      break label72;
    }
  }
  
  private void format(JSONObject paramJSONObject, StringBuilder paramStringBuilder, String paramString)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      paramStringBuilder.append(paramString);
      paramStringBuilder.append(this.mIndentationPattern);
      paramStringBuilder.append("\"");
      paramStringBuilder.append((String)localObject);
      paramStringBuilder.append("\": ");
      localObject = paramJSONObject.opt((String)localObject);
      if ((localObject instanceof JSONObject))
      {
        localObject = (JSONObject)localObject;
        paramStringBuilder.append(paramString);
        paramStringBuilder.append("{\n");
        format((JSONObject)localObject, paramStringBuilder, paramString + this.mIndentationPattern);
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(this.mIndentationPattern);
        paramStringBuilder.append("}");
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label227;
        }
        paramStringBuilder.append(",\n");
        break;
        if ((localObject instanceof JSONArray)) {
          formatArray((JSONArray)localObject, paramStringBuilder, paramString + this.mIndentationPattern);
        } else {
          formatValue(localObject, paramStringBuilder);
        }
      }
      label227:
      paramStringBuilder.append("\n");
    }
  }
  
  private void formatArray(JSONArray paramJSONArray, StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append("[\n");
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.opt(i);
      if ((localObject instanceof JSONObject))
      {
        localObject = (JSONObject)localObject;
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(this.mIndentationPattern);
        paramStringBuilder.append("{\n");
        format((JSONObject)localObject, paramStringBuilder, paramString + this.mIndentationPattern);
        paramStringBuilder.append(paramString);
        paramStringBuilder.append(this.mIndentationPattern);
        paramStringBuilder.append("}");
      }
      for (;;)
      {
        if (i < paramJSONArray.length() - 1) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\n");
        i += 1;
        break;
        if ((localObject instanceof JSONArray)) {
          formatArray((JSONArray)localObject, paramStringBuilder, paramString + this.mIndentationPattern);
        } else {
          formatValue(localObject, paramStringBuilder);
        }
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append("]");
  }
  
  private void formatValue(Object paramObject, StringBuilder paramStringBuilder)
  {
    if ((paramObject instanceof String))
    {
      paramObject = ((String)paramObject).replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", Matcher.quoteReplacement("\\\"")).replaceAll("/", "\\\\/").replaceAll("\n", "\\\\n").replaceAll("\t", "\\\\t").replaceAll("\r", "\\\\r");
      paramStringBuilder.append("\"");
      paramStringBuilder.append(paramObject);
      paramStringBuilder.append("\"");
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramStringBuilder.append((Long)paramObject);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      paramStringBuilder.append((Integer)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramStringBuilder.append((Boolean)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramStringBuilder.append((Double)paramObject);
      return;
    }
    paramStringBuilder.append(paramObject.toString());
  }
  
  private String getAttributeNameReplacement(String paramString1, String paramString2)
  {
    paramString1 = (String)this.mAttributeNameReplacements.get(paramString1);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  private String getContentNameReplacement(String paramString1, String paramString2)
  {
    paramString1 = (String)this.mContentNameReplacements.get(paramString1);
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
  
  private boolean isForcedList(Tag paramTag)
  {
    paramTag = paramTag.getPath();
    return this.mForceListPaths.contains(paramTag);
  }
  
  private void putContent(String paramString1, JSONObject paramJSONObject, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = (Class)this.mForceClassForPath.get(paramString1);
      if (paramString1 == null)
      {
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        paramJSONObject.put(paramString2, paramString1);
        return;
      }
      if (paramString1 == Integer.class) {
        try
        {
          paramJSONObject.put(paramString2, Integer.valueOf(Integer.parseInt(paramString3)));
          return;
        }
        catch (NumberFormatException paramString1)
        {
          paramJSONObject.put(paramString2, 0);
          return;
        }
      }
      if (paramString1 == Long.class) {
        try
        {
          paramJSONObject.put(paramString2, Long.valueOf(Long.parseLong(paramString3)));
          return;
        }
        catch (NumberFormatException paramString1)
        {
          paramJSONObject.put(paramString2, 0L);
          return;
        }
      }
      if (paramString1 == Double.class) {
        try
        {
          paramJSONObject.put(paramString2, Double.valueOf(Double.parseDouble(paramString3)));
          return;
        }
        catch (NumberFormatException paramString1)
        {
          paramJSONObject.put(paramString2, 0.0D);
          return;
        }
      }
      if (paramString1 == Boolean.class)
      {
        if (paramString3 == null)
        {
          paramJSONObject.put(paramString2, false);
          return;
        }
        if (paramString3.equalsIgnoreCase("true"))
        {
          paramJSONObject.put(paramString2, true);
          return;
        }
        if (paramString3.equalsIgnoreCase("false"))
        {
          paramJSONObject.put(paramString2, false);
          return;
        }
        paramJSONObject.put(paramString2, false);
      }
      return;
    }
    catch (JSONException paramString1) {}
  }
  
  /* Error */
  private void readTags(Tag paramTag, XmlPullParser paramXmlPullParser)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 245 1 0
    //   6: istore 4
    //   8: iload 4
    //   10: iconst_2
    //   11: if_icmpne +221 -> 232
    //   14: aload_2
    //   15: invokeinterface 408 1 0
    //   20: astore 7
    //   22: new 265	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   29: aload_1
    //   30: invokevirtual 140	fr/arnaudguyon/xmltojsonlib/Tag:getPath	()Ljava/lang/String;
    //   33: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 327
    //   39: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload 7
    //   44: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 8
    //   52: aload_0
    //   53: getfield 66	fr/arnaudguyon/xmltojsonlib/XmlToJson:mSkippedTags	Ljava/util/HashSet;
    //   56: aload 8
    //   58: invokevirtual 359	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   61: istore 6
    //   63: new 133	fr/arnaudguyon/xmltojsonlib/Tag
    //   66: dup
    //   67: aload 8
    //   69: aload 7
    //   71: invokespecial 220	fr/arnaudguyon/xmltojsonlib/Tag:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: astore 7
    //   76: iload 6
    //   78: ifne +9 -> 87
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 412	fr/arnaudguyon/xmltojsonlib/Tag:addChild	(Lfr/arnaudguyon/xmltojsonlib/Tag;)V
    //   87: aload_2
    //   88: invokeinterface 415 1 0
    //   93: istore 5
    //   95: iconst_0
    //   96: istore_3
    //   97: iload_3
    //   98: iload 5
    //   100: if_icmpge +122 -> 222
    //   103: aload_2
    //   104: iload_3
    //   105: invokeinterface 419 2 0
    //   110: astore 9
    //   112: aload_2
    //   113: iload_3
    //   114: invokeinterface 422 2 0
    //   119: astore 8
    //   121: new 265	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   128: aload_1
    //   129: invokevirtual 140	fr/arnaudguyon/xmltojsonlib/Tag:getPath	()Ljava/lang/String;
    //   132: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 327
    //   138: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 7
    //   143: invokevirtual 200	fr/arnaudguyon/xmltojsonlib/Tag:getName	()Ljava/lang/String;
    //   146: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 327
    //   152: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 9
    //   157: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 10
    //   165: aload_0
    //   166: getfield 64	fr/arnaudguyon/xmltojsonlib/XmlToJson:mSkippedAttributes	Ljava/util/HashSet;
    //   169: aload 10
    //   171: invokevirtual 359	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   174: ifeq +6 -> 180
    //   177: goto +120 -> 297
    //   180: new 133	fr/arnaudguyon/xmltojsonlib/Tag
    //   183: dup
    //   184: aload 10
    //   186: aload_0
    //   187: aload 10
    //   189: aload 9
    //   191: invokespecial 424	fr/arnaudguyon/xmltojsonlib/XmlToJson:getAttributeNameReplacement	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   194: invokespecial 220	fr/arnaudguyon/xmltojsonlib/Tag:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: astore 9
    //   199: aload 9
    //   201: aload 8
    //   203: invokevirtual 428	fr/arnaudguyon/xmltojsonlib/Tag:setContent	(Ljava/lang/String;)V
    //   206: aload 7
    //   208: aload 9
    //   210: invokevirtual 412	fr/arnaudguyon/xmltojsonlib/Tag:addChild	(Lfr/arnaudguyon/xmltojsonlib/Tag;)V
    //   213: goto +84 -> 297
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 255	java/lang/Exception:printStackTrace	()V
    //   221: return
    //   222: aload_0
    //   223: aload 7
    //   225: aload_2
    //   226: invokespecial 249	fr/arnaudguyon/xmltojsonlib/XmlToJson:readTags	(Lfr/arnaudguyon/xmltojsonlib/Tag;Lorg/xmlpull/v1/XmlPullParser;)V
    //   229: goto +75 -> 304
    //   232: iload 4
    //   234: iconst_4
    //   235: if_icmpne +16 -> 251
    //   238: aload_1
    //   239: aload_2
    //   240: invokeinterface 431 1 0
    //   245: invokevirtual 428	fr/arnaudguyon/xmltojsonlib/Tag:setContent	(Ljava/lang/String;)V
    //   248: goto +56 -> 304
    //   251: iload 4
    //   253: iconst_3
    //   254: if_icmpeq -33 -> 221
    //   257: iload 4
    //   259: iconst_1
    //   260: if_icmpeq -39 -> 221
    //   263: ldc 33
    //   265: new 265	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 433
    //   275: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: iload 4
    //   280: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 442	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   289: pop
    //   290: goto +14 -> 304
    //   293: astore_1
    //   294: goto -77 -> 217
    //   297: iload_3
    //   298: iconst_1
    //   299: iadd
    //   300: istore_3
    //   301: goto -204 -> 97
    //   304: iload 4
    //   306: iconst_1
    //   307: if_icmpne -307 -> 0
    //   310: return
    //   311: astore_1
    //   312: goto -95 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	XmlToJson
    //   0	315	1	paramTag	Tag
    //   0	315	2	paramXmlPullParser	XmlPullParser
    //   96	205	3	i	int
    //   6	302	4	j	int
    //   93	8	5	k	int
    //   61	16	6	bool	boolean
    //   20	204	7	localObject1	Object
    //   50	152	8	str1	String
    //   110	99	9	localObject2	Object
    //   163	25	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	8	216	org/xmlpull/v1/XmlPullParserException
    //   14	76	216	org/xmlpull/v1/XmlPullParserException
    //   81	87	216	org/xmlpull/v1/XmlPullParserException
    //   87	95	216	org/xmlpull/v1/XmlPullParserException
    //   103	177	216	org/xmlpull/v1/XmlPullParserException
    //   180	213	216	org/xmlpull/v1/XmlPullParserException
    //   222	229	216	org/xmlpull/v1/XmlPullParserException
    //   238	248	216	org/xmlpull/v1/XmlPullParserException
    //   263	290	216	org/xmlpull/v1/XmlPullParserException
    //   0	8	293	java/lang/NullPointerException
    //   14	76	293	java/lang/NullPointerException
    //   81	87	293	java/lang/NullPointerException
    //   87	95	293	java/lang/NullPointerException
    //   103	177	293	java/lang/NullPointerException
    //   180	213	293	java/lang/NullPointerException
    //   222	229	293	java/lang/NullPointerException
    //   238	248	293	java/lang/NullPointerException
    //   263	290	293	java/lang/NullPointerException
    //   0	8	311	java/io/IOException
    //   14	76	311	java/io/IOException
    //   81	87	311	java/io/IOException
    //   87	95	311	java/io/IOException
    //   103	177	311	java/io/IOException
    //   180	213	311	java/io/IOException
    //   222	229	311	java/io/IOException
    //   238	248	311	java/io/IOException
    //   263	290	311	java/io/IOException
  }
  
  private void setInput(XmlPullParser paramXmlPullParser)
  {
    if (this.mStringSource != null) {
      try
      {
        paramXmlPullParser.setInput(this.mStringSource);
        return;
      }
      catch (XmlPullParserException paramXmlPullParser)
      {
        paramXmlPullParser.printStackTrace();
        return;
      }
    }
    try
    {
      paramXmlPullParser.setInput(this.mInputStreamSource, this.mInputEncoding);
      return;
    }
    catch (XmlPullParserException paramXmlPullParser)
    {
      paramXmlPullParser.printStackTrace();
    }
  }
  
  private void unsetInput()
  {
    if (this.mStringSource != null) {
      this.mStringSource.close();
    }
  }
  
  public String toFormattedString()
  {
    if (this.mJsonObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\n");
      format(this.mJsonObject, localStringBuilder, "");
      localStringBuilder.append("}\n");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public String toFormattedString(@Nullable String paramString)
  {
    if (paramString == null) {}
    for (this.mIndentationPattern = "   ";; this.mIndentationPattern = paramString) {
      return toFormattedString();
    }
  }
  
  @Nullable
  public JSONObject toJson()
  {
    return this.mJsonObject;
  }
  
  public String toString()
  {
    if (this.mJsonObject != null) {
      return this.mJsonObject.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     fr.arnaudguyon.xmltojsonlib.XmlToJson
 * JD-Core Version:    0.7.0.1
 */