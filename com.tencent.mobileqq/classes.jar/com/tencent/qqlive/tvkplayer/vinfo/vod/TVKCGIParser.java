package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.os.SystemClock;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class TVKCGIParser
{
  private int mCgiCode = 0;
  private int mCgiDetailCode = 0;
  private Document mDoc;
  private String mVinfoXml = "";
  
  public TVKCGIParser() {}
  
  public TVKCGIParser(String paramString)
  {
    this();
    this.mVinfoXml = paramString;
  }
  
  private void parseXMLError()
  {
    NodeList localNodeList1 = this.mDoc.getElementsByTagName("em");
    NodeList localNodeList2 = this.mDoc.getElementsByTagName("exem");
    if ((localNodeList1.getLength() > 0) && (localNodeList2.getLength() > 0))
    {
      this.mCgiCode = TVKUtils.optInt(localNodeList1.item(0).getFirstChild().getNodeValue(), 0);
      this.mCgiDetailCode = TVKUtils.optInt(localNodeList2.item(0).getFirstChild().getNodeValue(), 0);
    }
  }
  
  public int getCgiCode()
  {
    return this.mCgiCode;
  }
  
  public int getCgiDetailCode()
  {
    return this.mCgiDetailCode;
  }
  
  public Document getDocument()
  {
    return this.mDoc;
  }
  
  public String getXml()
  {
    return this.mVinfoXml;
  }
  
  public boolean init()
  {
    try
    {
      this.mDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(this.mVinfoXml)));
      parseXMLError();
      return true;
    }
    catch (Exception localException)
    {
      label37:
      break label37;
    }
    return false;
  }
  
  public boolean isXML85ErrorCode()
  {
    NodeList localNodeList1 = this.mDoc.getElementsByTagName("s");
    NodeList localNodeList2 = this.mDoc.getElementsByTagName("em");
    NodeList localNodeList3 = this.mDoc.getElementsByTagName("type");
    if ((localNodeList1.getLength() > 0) && (localNodeList2.getLength() > 0) && (localNodeList3.getLength() > 0) && (localNodeList1.item(0).getFirstChild().getNodeValue().equals("f")))
    {
      int i = TVKUtils.optInt(localNodeList2.item(0).getFirstChild().getNodeValue(), 0);
      int j = TVKUtils.optInt(localNodeList3.item(0).getFirstChild().getNodeValue(), 0);
      if ((i == 85) && (j == -3))
      {
        localNodeList1 = this.mDoc.getElementsByTagName("curTime");
        if (localNodeList1.getLength() > 0) {
          TVKVideoInfoCheckTime.mServerTime = TVKUtils.optInt(localNodeList1.item(0).getFirstChild().getNodeValue(), 0);
        }
        localNodeList1 = this.mDoc.getElementsByTagName("rand");
        if (localNodeList1.getLength() > 0) {
          TVKVideoInfoCheckTime.mRandKey = localNodeList1.item(0).getFirstChild().getNodeValue();
        }
        TVKVideoInfoCheckTime.mElapsedRealTime = SystemClock.elapsedRealtime();
        return true;
      }
    }
    return false;
  }
  
  public boolean isXMLHaveRetryNode()
  {
    NodeList localNodeList = this.mDoc.getElementsByTagName("retry");
    return (localNodeList.getLength() > 0) && (TVKUtils.optInt(localNodeList.item(0).getFirstChild().getNodeValue(), 0) > 0);
  }
  
  public boolean isXMLSuccess()
  {
    NodeList localNodeList = this.mDoc.getElementsByTagName("s");
    if (localNodeList.getLength() > 0) {
      return localNodeList.item(0).getFirstChild().getNodeValue().equals("o");
    }
    return false;
  }
  
  public TVKCGIVideoInfo parseVideoInfo()
  {
    if (isXMLSuccess())
    {
      TVKCGIVideoInfo localTVKCGIVideoInfo = new TVKCGIVideoInfoBuilder().parseVinfo(this.mDoc);
      if (localTVKCGIVideoInfo != null) {
        localTVKCGIVideoInfo.setVinfoXml(this.mVinfoXml);
      }
      return localTVKCGIVideoInfo;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIParser
 * JD-Core Version:    0.7.0.1
 */