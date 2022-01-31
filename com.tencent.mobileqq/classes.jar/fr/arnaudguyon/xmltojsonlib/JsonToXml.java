package fr.arnaudguyon.xmltojsonlib;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.Xml;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class JsonToXml
{
  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
  private static final int DEFAULT_INDENTATION = 3;
  private HashSet<String> mForcedAttributes;
  private HashSet<String> mForcedContent;
  private JSONObject mJson;
  
  private JsonToXml(@NonNull JSONObject paramJSONObject, @NonNull HashSet<String> paramHashSet1, HashSet<String> paramHashSet2)
  {
    this.mJson = paramJSONObject;
    this.mForcedAttributes = paramHashSet1;
    this.mForcedContent = paramHashSet2;
  }
  
  private boolean isAttribute(String paramString)
  {
    return this.mForcedAttributes.contains(paramString);
  }
  
  private boolean isContent(String paramString)
  {
    return this.mForcedContent.contains(paramString);
  }
  
  private String nodeToXML(Node paramNode)
  {
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    StringWriter localStringWriter = new StringWriter();
    try
    {
      localXmlSerializer.setOutput(localStringWriter);
      localXmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
      nodeToXml(localXmlSerializer, paramNode);
      localXmlSerializer.endDocument();
      paramNode = localStringWriter.toString();
      return paramNode;
    }
    catch (IOException paramNode)
    {
      throw new RuntimeException(paramNode);
    }
  }
  
  private void nodeToXml(XmlSerializer paramXmlSerializer, Node paramNode)
  {
    String str = paramNode.getName();
    if (str != null)
    {
      paramXmlSerializer.startTag("", str);
      Object localObject = paramNode.getAttributes().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Node.Attribute localAttribute = (Node.Attribute)((Iterator)localObject).next();
        paramXmlSerializer.attribute("", localAttribute.mKey, localAttribute.mValue);
      }
      localObject = paramNode.getContent();
      if (localObject != null) {
        paramXmlSerializer.text((String)localObject);
      }
    }
    paramNode = paramNode.getChildren().iterator();
    while (paramNode.hasNext()) {
      nodeToXml(paramXmlSerializer, (Node)paramNode.next());
    }
    if (str != null) {
      paramXmlSerializer.endTag("", str);
    }
  }
  
  private void prepareArray(Node paramNode, String paramString, JSONArray paramJSONArray)
  {
    int j = paramJSONArray.length();
    String str = paramNode.getPath() + "/" + paramString;
    int i = 0;
    if (i < j)
    {
      Node localNode = new Node(paramString, str);
      Object localObject = paramJSONArray.opt(i);
      if (localObject != null)
      {
        if (!(localObject instanceof JSONObject)) {
          break label103;
        }
        prepareObject(localNode, (JSONObject)localObject);
      }
      for (;;)
      {
        paramNode.addChild(localNode);
        i += 1;
        break;
        label103:
        if ((localObject instanceof JSONArray))
        {
          prepareArray(localNode, paramString, (JSONArray)localObject);
        }
        else
        {
          localObject = localObject.toString();
          localNode.setName(paramString);
          localNode.setContent((String)localObject);
        }
      }
    }
  }
  
  private void prepareObject(Node paramNode, JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      Object localObject1 = paramJSONObject.opt((String)localObject2);
      if (localObject1 != null) {
        if ((localObject1 instanceof JSONObject))
        {
          localObject1 = (JSONObject)localObject1;
          localObject2 = new Node((String)localObject2, paramNode.getPath() + "/" + (String)localObject2);
          paramNode.addChild((Node)localObject2);
          prepareObject((Node)localObject2, (JSONObject)localObject1);
        }
        else if ((localObject1 instanceof JSONArray))
        {
          prepareArray(paramNode, (String)localObject2, (JSONArray)localObject1);
        }
        else
        {
          String str = paramNode.getPath() + "/" + (String)localObject2;
          double d;
          if ((localObject1 instanceof Double))
          {
            d = ((Double)localObject1).doubleValue();
            if (d % 1.0D == 0.0D) {
              localObject1 = Long.toString(d);
            }
          }
          for (;;)
          {
            if (!isAttribute(str)) {
              break label254;
            }
            paramNode.addAttribute((String)localObject2, (String)localObject1);
            break;
            if (DECIMAL_FORMAT.getMaximumFractionDigits() == 0) {
              DECIMAL_FORMAT.setMaximumFractionDigits(20);
            }
            localObject1 = DECIMAL_FORMAT.format(d);
            continue;
            localObject1 = localObject1.toString();
          }
          label254:
          if (isContent(str))
          {
            paramNode.setContent((String)localObject1);
          }
          else
          {
            localObject2 = new Node((String)localObject2, paramNode.getPath());
            ((Node)localObject2).setContent((String)localObject1);
            paramNode.addChild((Node)localObject2);
          }
        }
      }
    }
  }
  
  public String toFormattedString()
  {
    return toFormattedString(3);
  }
  
  public String toFormattedString(@IntRange(from=0L) int paramInt)
  {
    Object localObject = toString();
    try
    {
      localObject = new StreamSource(new StringReader((String)localObject));
      StreamResult localStreamResult = new StreamResult(new StringWriter());
      Transformer localTransformer = TransformerFactory.newInstance().newTransformer();
      localTransformer.setOutputProperty("indent", "yes");
      localTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "" + paramInt);
      localTransformer.transform((Source)localObject, localStreamResult);
      localObject = localStreamResult.getWriter().toString();
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  public String toString()
  {
    Node localNode = new Node(null, "");
    prepareObject(localNode, this.mJson);
    return nodeToXML(localNode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     fr.arnaudguyon.xmltojsonlib.JsonToXml
 * JD-Core Version:    0.7.0.1
 */