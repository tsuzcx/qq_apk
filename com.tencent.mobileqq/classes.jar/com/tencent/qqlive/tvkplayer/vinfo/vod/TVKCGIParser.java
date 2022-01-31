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
    catch (Exception localException) {}
    return false;
  }
  
  public boolean isXML85ErrorCode()
  {
    boolean bool2 = false;
    NodeList localNodeList1 = this.mDoc.getElementsByTagName("s");
    NodeList localNodeList2 = this.mDoc.getElementsByTagName("em");
    NodeList localNodeList3 = this.mDoc.getElementsByTagName("type");
    boolean bool1 = bool2;
    if (localNodeList1.getLength() > 0)
    {
      bool1 = bool2;
      if (localNodeList2.getLength() > 0)
      {
        bool1 = bool2;
        if (localNodeList3.getLength() > 0)
        {
          bool1 = bool2;
          if (localNodeList1.item(0).getFirstChild().getNodeValue().equals("f"))
          {
            int i = TVKUtils.optInt(localNodeList2.item(0).getFirstChild().getNodeValue(), 0);
            int j = TVKUtils.optInt(localNodeList3.item(0).getFirstChild().getNodeValue(), 0);
            bool1 = bool2;
            if (i == 85)
            {
              bool1 = bool2;
              if (j == -3)
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
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isXMLHaveRetryNode()
  {
    boolean bool2 = false;
    NodeList localNodeList = this.mDoc.getElementsByTagName("retry");
    boolean bool1 = bool2;
    if (localNodeList.getLength() > 0)
    {
      bool1 = bool2;
      if (TVKUtils.optInt(localNodeList.item(0).getFirstChild().getNodeValue(), 0) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isXMLSuccess()
  {
    boolean bool = false;
    NodeList localNodeList = this.mDoc.getElementsByTagName("s");
    if (localNodeList.getLength() > 0) {
      bool = localNodeList.item(0).getFirstChild().getNodeValue().equals("o");
    }
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.vod.TVKCGIParser
 * JD-Core Version:    0.7.0.1
 */