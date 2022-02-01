package com.tencent.mqp.app.sec;

import android.os.Bundle;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SecCenterConfigParser
  implements IConfigParser
{
  private void a(Document paramDocument, Bundle paramBundle)
  {
    NodeList localNodeList = paramDocument.getElementsByTagName("ModifyPwdUrls");
    paramDocument = new Bundle();
    if ((localNodeList != null) && (localNodeList.getLength() >= 1))
    {
      int i = 0;
      localNodeList = localNodeList.item(0).getChildNodes();
      while (i < localNodeList.getLength())
      {
        Object localObject1 = localNodeList.item(i);
        if ((localObject1 instanceof Element))
        {
          Object localObject2 = (Element)localObject1;
          localObject1 = ((Element)localObject2).getAttribute("Name");
          localObject2 = ((Element)localObject2).getAttribute("Url");
          if ((localObject1 != null) && (localObject2 != null) && (!((String)localObject1).equals("")) && (!((String)localObject2).equals(""))) {
            paramDocument.putString((String)localObject1, (String)localObject2);
          }
        }
        i += 1;
      }
      paramBundle.putBundle("ModifyPwdUrls", paramDocument);
    }
  }
  
  public SecBaseConfig a(String paramString)
  {
    paramString = new File(paramString);
    Object localObject1 = DocumentBuilderFactory.newInstance();
    try
    {
      paramString = ((DocumentBuilderFactory)localObject1).newDocumentBuilder().parse(paramString);
      Object localObject2 = paramString.getDocumentElement();
      localObject1 = new Bundle();
      localObject2 = ((Element)localObject2).getAttribute("Version");
      int i = -1;
      try
      {
        int j = Integer.parseInt((String)localObject2);
        i = j;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      ((Bundle)localObject1).putInt("version", i);
      a(paramString, (Bundle)localObject1);
      paramString = new SecCenterConfig((Bundle)localObject1);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.SecCenterConfigParser
 * JD-Core Version:    0.7.0.1
 */