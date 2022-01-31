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
  public static final AppShareID a = new AppShareID();
  
  public static long a(long paramLong)
  {
    return a(b(paramLong));
  }
  
  public static long a(String paramString)
  {
    long l = Long.parseLong(paramString.substring(2), 16);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putLong(l);
    localByteBuffer.flip();
    localByteBuffer.order(ByteOrder.BIG_ENDIAN);
    l = localByteBuffer.getLong();
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, paramString + " change to ShareID =" + (l >>> 32));
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
    localAppShareID.strResURL_big = paramPluginInfo.res_url_big.get();
    localAppShareID.strResURL_small = paramPluginInfo.res_url_small.get();
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
    localAppShareID.strResURL_big = paramGetResourceRespInfo.strResURL_big;
    localAppShareID.strResURL_small = paramGetResourceRespInfo.strResURL_small;
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
    Object localObject;
    if ((paramString == null) || ("".equals(paramString)))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      AppShareIDConfigInfo localAppShareIDConfigInfo;
      int i;
      Node localNode;
      try
      {
        NodeList localNodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + paramString).getBytes())).getDocumentElement().getChildNodes();
        localAppShareIDConfigInfo = new AppShareIDConfigInfo();
        i = 0;
        localObject = localAppShareIDConfigInfo;
        if (i >= localNodeList.getLength()) {
          break;
        }
        if (localNodeList.item(i).getNodeType() != 1) {
          break label300;
        }
        localObject = localNodeList.item(i);
        localNode = ((Node)localObject).getFirstChild();
        if (localNode == null) {
          break label300;
        }
        if ("officalwebsite".equals(((Node)localObject).getNodeName())) {
          localAppShareIDConfigInfo.officalwebsite = localNode.getNodeValue();
        } else if ("androidlink".equals(((Node)localObject).getNodeName())) {
          localAppShareIDConfigInfo.appstorelink = localNode.getNodeValue();
        }
      }
      catch (Exception localException)
      {
        QLog.w("share_appid", 2, "parser from xml is error,xmlStr:" + paramString);
        return null;
      }
      if ("messagetail".equals(localException.getNodeName())) {
        localAppShareIDConfigInfo.messagetail = localNode.getNodeValue();
      } else if ("bundleid".equals(localException.getNodeName())) {
        localAppShareIDConfigInfo.bundleid = localNode.getNodeValue();
      } else if ("sourceUrl".equals(localException.getNodeName())) {
        localAppShareIDConfigInfo.sourceUrl = localNode.getNodeValue();
      }
      label300:
      i += 1;
    }
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
      return l2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AppShareIDUtil
 * JD-Core Version:    0.7.0.1
 */