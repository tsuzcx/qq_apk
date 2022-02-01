package com.tencent.mobileqq.utils;

import com.tencent.biz.common.util.AppidConvert;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.AppShareIDConfigInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import msf.msgcomm.msg_comm.PluginInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import protocol.KQQConfig.GetResourceRespInfo;

public class AppShareIDUtil
{
  public static long a(long paramLong)
  {
    return a(b(paramLong));
  }
  
  public static long a(String paramString)
  {
    long l = Long.parseLong(paramString.substring(2), 16);
    Object localObject = ByteBuffer.allocate(8);
    ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
    ((ByteBuffer)localObject).putLong(l);
    ((ByteBuffer)localObject).flip();
    ((ByteBuffer)localObject).order(ByteOrder.BIG_ENDIAN);
    l = ((ByteBuffer)localObject).getLong();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" change to ShareID =");
      ((StringBuilder)localObject).append(l >>> 32);
      QLog.d("share_appid", 2, ((StringBuilder)localObject).toString());
    }
    return l >>> 32;
  }
  
  public static AppShareID a(msg_comm.PluginInfo paramPluginInfo)
  {
    AppShareID localAppShareID = new AppShareID();
    localAppShareID.uiResID = paramPluginInfo.res_id.get();
    localAppShareID.strPkgName = paramPluginInfo.pkg_name.get();
    localAppShareID.uiNewVer = paramPluginInfo.new_ver.get();
    localAppShareID.sResType = ((short)paramPluginInfo.res_type.get());
    localAppShareID.sLanType = ((short)paramPluginInfo.lan_type.get());
    localAppShareID.sPriority = ((short)paramPluginInfo.priority.get());
    localAppShareID.strResName = paramPluginInfo.res_name.get();
    localAppShareID.strResDesc = paramPluginInfo.res_desc.get();
    localAppShareID.strResURLBig = paramPluginInfo.res_url_big.get();
    localAppShareID.strResURLSmall = paramPluginInfo.res_url_small.get();
    paramPluginInfo = a(paramPluginInfo.res_conf.get());
    if (paramPluginInfo != null)
    {
      localAppShareID.officalwebsite = paramPluginInfo.officalwebsite;
      localAppShareID.appstorelink = paramPluginInfo.appstorelink;
      localAppShareID.messagetail = paramPluginInfo.messagetail;
      localAppShareID.bundleid = paramPluginInfo.bundleid;
      localAppShareID.sourceUrl = paramPluginInfo.sourceUrl;
    }
    localAppShareID.updateTime = System.currentTimeMillis();
    return localAppShareID;
  }
  
  public static AppShareID a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    AppShareID localAppShareID = new AppShareID();
    localAppShareID.uiResID = paramGetResourceRespInfo.uiResID;
    localAppShareID.strPkgName = paramGetResourceRespInfo.strPkgName;
    localAppShareID.uiNewVer = paramGetResourceRespInfo.uiNewVer;
    localAppShareID.sResType = paramGetResourceRespInfo.sResType;
    localAppShareID.sLanType = paramGetResourceRespInfo.sLanType;
    localAppShareID.sPriority = paramGetResourceRespInfo.sPriority;
    localAppShareID.strResName = paramGetResourceRespInfo.strResName;
    localAppShareID.strResDesc = paramGetResourceRespInfo.strResDesc;
    localAppShareID.strResURLBig = paramGetResourceRespInfo.strResURL_big;
    localAppShareID.strResURLSmall = paramGetResourceRespInfo.strResURL_small;
    paramGetResourceRespInfo = a(paramGetResourceRespInfo.strResConf);
    if (paramGetResourceRespInfo != null)
    {
      localAppShareID.officalwebsite = paramGetResourceRespInfo.officalwebsite;
      localAppShareID.appstorelink = paramGetResourceRespInfo.appstorelink;
      localAppShareID.messagetail = paramGetResourceRespInfo.messagetail;
      localAppShareID.bundleid = paramGetResourceRespInfo.bundleid;
      localAppShareID.sourceUrl = paramGetResourceRespInfo.sourceUrl;
    }
    localAppShareID.updateTime = System.currentTimeMillis();
    return localAppShareID;
  }
  
  public static AppShareIDConfigInfo a(String paramString)
  {
    if (paramString != null) {
      if ("".equals(paramString)) {
        return null;
      }
    }
    try
    {
      localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = ((DocumentBuilder)localObject1).parse(new ByteArrayInputStream(((StringBuilder)localObject2).toString().getBytes())).getDocumentElement().getChildNodes();
      localObject2 = new AppShareIDConfigInfo();
      int i = 0;
      while (i < ((NodeList)localObject1).getLength())
      {
        if (((NodeList)localObject1).item(i).getNodeType() == 1)
        {
          Node localNode1 = ((NodeList)localObject1).item(i);
          Node localNode2 = localNode1.getFirstChild();
          if (localNode2 != null) {
            if ("officalwebsite".equals(localNode1.getNodeName())) {
              ((AppShareIDConfigInfo)localObject2).officalwebsite = localNode2.getNodeValue();
            } else if ("androidlink".equals(localNode1.getNodeName())) {
              ((AppShareIDConfigInfo)localObject2).appstorelink = localNode2.getNodeValue();
            } else if ("messagetail".equals(localNode1.getNodeName())) {
              ((AppShareIDConfigInfo)localObject2).messagetail = localNode2.getNodeValue();
            } else if ("bundleid".equals(localNode1.getNodeName())) {
              ((AppShareIDConfigInfo)localObject2).bundleid = localNode2.getNodeValue();
            } else if ("sourceUrl".equals(localNode1.getNodeName())) {
              ((AppShareIDConfigInfo)localObject2).sourceUrl = localNode2.getNodeValue();
            }
          }
        }
        i += 1;
      }
      return localObject2;
    }
    catch (Exception localException)
    {
      Object localObject1;
      label287:
      break label287;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("parser from xml is error,xmlStr:");
    ((StringBuilder)localObject1).append(paramString);
    QLog.w("share_appid", 2, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public static String a(long paramLong)
  {
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
    ((ByteBuffer)localObject).putInt((int)paramLong);
    ((ByteBuffer)localObject).flip();
    ((ByteBuffer)localObject).order(ByteOrder.BIG_ENDIAN);
    localObject = new StringBuffer(Integer.toHexString(((ByteBuffer)localObject).getInt()));
    int j = ((StringBuffer)localObject).length();
    int i = 0;
    while (i < 8 - j)
    {
      ((StringBuffer)localObject).insert(0, "0");
      i += 1;
    }
    ((StringBuffer)localObject).insert(0, "QQ");
    return ((StringBuffer)localObject).toString().toUpperCase();
  }
  
  public static long b(long paramLong)
  {
    return b(a(paramLong));
  }
  
  public static long b(String paramString)
  {
    long l1 = Long.parseLong(paramString.substring(2), 16);
    long l2 = AppidConvert.b(l1);
    if (l2 != 0L) {
      l1 = l2;
    }
    return l1;
  }
  
  public static String b(long paramLong)
  {
    long l = AppidConvert.a(paramLong);
    if (l != 0L) {
      paramLong = l;
    }
    String str = Integer.toHexString((int)paramLong);
    StringBuffer localStringBuffer = new StringBuffer(str);
    int i = 0;
    while (i < 8 - str.length())
    {
      localStringBuffer.insert(0, "0");
      i += 1;
    }
    localStringBuffer.insert(0, "QQ");
    return localStringBuffer.toString().toUpperCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AppShareIDUtil
 * JD-Core Version:    0.7.0.1
 */