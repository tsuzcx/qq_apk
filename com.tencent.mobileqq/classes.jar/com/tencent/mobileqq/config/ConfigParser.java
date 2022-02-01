package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ConfigParser
{
  public static HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      DocumentBuilder localDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      localStringBuilder.append(paramString);
      a(localHashMap, localDocumentBuilder.parse(new ByteArrayInputStream(localStringBuilder.toString().getBytes())).getDocumentElement().getChildNodes());
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static void a(int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte = new Cryptor().decrypt(paramArrayOfByte, a());
    if (paramInt != 3)
    {
      if (paramInt != 4)
      {
        if (paramInt != 12)
        {
          if (paramInt != 24) {
            return;
          }
          Config.a.b();
          Config.a.a(false);
          a(Config.a, paramArrayOfByte, paramString);
          return;
        }
        Config.b.b();
        Config.b.a(false);
        a(Config.b, paramArrayOfByte);
        return;
      }
      paramString = Config.a();
      if (paramString != null) {
        a(paramString.a, paramArrayOfByte);
      }
    }
  }
  
  private static void a(ConfigManager.UpdateStruct paramUpdateStruct, byte[] paramArrayOfByte)
  {
    int i = PkgTools.getShortData(paramArrayOfByte, 0);
    paramUpdateStruct.jdField_a_of_type_JavaLangString = PkgTools.getUTFString(paramArrayOfByte, 2, i);
    i += 2;
    paramUpdateStruct.jdField_a_of_type_Byte = paramArrayOfByte[i];
    i += 1;
    paramUpdateStruct.jdField_b_of_type_Byte = paramArrayOfByte[i];
    i += 1;
    paramUpdateStruct.jdField_b_of_type_JavaLangString = PkgTools.getUTFString(paramArrayOfByte, i + 2, PkgTools.getShortData(paramArrayOfByte, i));
  }
  
  private static void a(ConfigRespStruct paramConfigRespStruct) {}
  
  private static void a(ConfigRespStruct paramConfigRespStruct, String paramString)
  {
    Object localObject = paramConfigRespStruct.jdField_a_of_type_ArrayOfByte;
    int i = 0;
    int k = PkgTools.getShortData((byte[])localObject, 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("config-huibao--decode---confighParse--itemNum = ");
      ((StringBuilder)localObject).append(k);
      QLog.d("ShanPing", 2, ((StringBuilder)localObject).toString());
    }
    int j = 2;
    while (i < k)
    {
      int m = PkgTools.getShortData(paramConfigRespStruct.jdField_a_of_type_ArrayOfByte, j);
      int n = j + 2;
      j = PkgTools.getShortData(paramConfigRespStruct.jdField_a_of_type_ArrayOfByte, n);
      n += 2;
      localObject = new byte[j];
      PkgTools.getBytesData(paramConfigRespStruct.jdField_a_of_type_ArrayOfByte, n, (byte[])localObject, j);
      j = n + j;
      a(m, (byte[])localObject, paramString);
      i += 1;
    }
    paramConfigRespStruct = Config.a();
    if (paramConfigRespStruct != null) {
      paramConfigRespStruct.c();
    }
  }
  
  private static void a(PicAndAdConf paramPicAndAdConf, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--buildItem_FlashLogo = ");
    }
    int i = 0;
    paramPicAndAdConf.jdField_a_of_type_Long = PkgTools.getLongData(paramArrayOfByte, 0);
    paramPicAndAdConf.b = (PkgTools.getLongData(paramArrayOfByte, 4) * 1000L);
    paramPicAndAdConf.c = (PkgTools.getLongData(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    int j = 13;
    while (i < k)
    {
      long l = PkgTools.getLongData(paramArrayOfByte, j);
      j += 4;
      int m = paramArrayOfByte[j];
      int n = j + 1 + 1;
      j = PkgTools.getShortData(paramArrayOfByte, n);
      n += 2;
      String str1 = PkgTools.getUTFString(paramArrayOfByte, n, j);
      n += j;
      j = PkgTools.getShortData(paramArrayOfByte, n);
      n += 2;
      String str2 = PkgTools.getUTFString(paramArrayOfByte, n, j);
      j = n + j;
      if (m == 1)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("flashlogo desc= ");
          localStringBuilder.append(str1);
          localStringBuilder.append(" src addr = ");
          localStringBuilder.append(str2);
          QLog.d("ShanPing", 2, localStringBuilder.toString());
        }
        str2 = paramPicAndAdConf.a(str1, (byte)3);
        paramPicAndAdConf.b(str2);
        paramPicAndAdConf.a(paramPicAndAdConf.a(l, str1, str2, null, ""));
      }
      i += 1;
    }
  }
  
  private static void a(PicAndAdConf paramPicAndAdConf, byte[] paramArrayOfByte, String paramString)
  {
    paramPicAndAdConf.jdField_a_of_type_Long = PkgTools.getLongData(paramArrayOfByte, 0);
    paramPicAndAdConf.b = (PkgTools.getLongData(paramArrayOfByte, 4) * 1000L);
    paramPicAndAdConf.c = (PkgTools.getLongData(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    Object localObject1;
    Object localObject2;
    if (k > 0)
    {
      paramPicAndAdConf.c();
      localObject1 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("push_banner_display");
      ((StringBuilder)localObject2).append(paramString);
      ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true).commit();
    }
    int j = 13;
    int i = 0;
    while (i < k)
    {
      long l1 = PkgTools.getLongData(paramArrayOfByte, j);
      int m = j + 4;
      j = paramArrayOfByte[m];
      m = m + 1 + 1;
      long l2 = PkgTools.getLongData(paramArrayOfByte, m);
      int n = m + 4;
      m = PkgTools.getShortData(paramArrayOfByte, n);
      int i1 = n + 2;
      n = PkgTools.getShortData(paramArrayOfByte, i1);
      i1 += 2;
      paramString = PkgTools.getUTFString(paramArrayOfByte, i1, n);
      i1 += n;
      n = PkgTools.getShortData(paramArrayOfByte, i1);
      i1 += 2;
      localObject2 = PkgTools.getUTFString(paramArrayOfByte, i1, n);
      i1 += n;
      n = PkgTools.getShortData(paramArrayOfByte, i1);
      i1 += 2;
      localObject1 = PkgTools.getUTFString(paramArrayOfByte, i1, n);
      if (j == 1)
      {
        localObject2 = paramPicAndAdConf.a((String)localObject2, (byte)3);
        if (!a(String.valueOf(l1))) {
          paramPicAndAdConf.b((String)localObject2);
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject3).append("/ADPic/");
        ((StringBuilder)localObject3).append(l1);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l2);
        paramPicAndAdConf.a(paramPicAndAdConf.a(l1, paramString, (String)localObject2, (String)localObject1, (String)localObject3, localStringBuilder.toString(), (short)m));
      }
      i += 1;
      j = i1 + n;
    }
  }
  
  private static void a(HashMap<String, String> paramHashMap, NodeList paramNodeList)
  {
    if (paramNodeList != null)
    {
      if (paramNodeList.getLength() == 0) {
        return;
      }
      int i = 0;
      while (i < paramNodeList.getLength())
      {
        Node localNode = paramNodeList.item(i);
        if ((localNode instanceof Element))
        {
          if (localNode.hasChildNodes()) {
            a(paramHashMap, localNode.getChildNodes());
          }
        }
        else if (localNode.getParentNode() != null) {
          paramHashMap.put(localNode.getParentNode().getNodeName(), localNode.getNodeValue());
        }
        i += 1;
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, ConfigRespStruct paramConfigRespStruct)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 11) {
        return;
      }
      if (paramArrayOfByte[0] != 2) {
        return;
      }
      paramConfigRespStruct.b = PkgTools.getShortData(paramArrayOfByte, 1);
      paramConfigRespStruct.jdField_a_of_type_Short = PkgTools.getShortData(paramArrayOfByte, 3);
      paramConfigRespStruct.jdField_a_of_type_Long = (PkgTools.getLongData(paramArrayOfByte, 5) * 1000L);
      paramConfigRespStruct.jdField_a_of_type_Byte = paramArrayOfByte[9];
      int i = paramArrayOfByte.length - 10 - 1;
      if (paramConfigRespStruct.jdField_a_of_type_Byte == 0)
      {
        paramConfigRespStruct.jdField_a_of_type_ArrayOfByte = new byte[i];
        PkgTools.getBytesData(paramArrayOfByte, 10, paramConfigRespStruct.jdField_a_of_type_ArrayOfByte, i);
      }
      else
      {
        paramConfigRespStruct.jdField_a_of_type_JavaLangString = PkgTools.getUTFString(paramArrayOfByte, 10, i);
      }
      i = paramArrayOfByte.length;
    }
  }
  
  public static boolean a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/ADPic/");
    localStringBuilder.append(paramString);
    return new File(localStringBuilder.toString()).exists();
  }
  
  public static boolean a(byte[] paramArrayOfByte, ConfigRespStruct paramConfigRespStruct, String paramString)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return false;
      }
      a(paramArrayOfByte, paramConfigRespStruct);
      if (paramConfigRespStruct.b != 768) {
        return false;
      }
      if (paramConfigRespStruct.jdField_a_of_type_Byte != 0)
      {
        a(paramConfigRespStruct);
        return false;
      }
      if (paramConfigRespStruct.jdField_a_of_type_ArrayOfByte != null)
      {
        if (paramConfigRespStruct.jdField_a_of_type_ArrayOfByte.length == 0) {
          return false;
        }
        a(paramConfigRespStruct, paramString);
        return true;
      }
    }
    return false;
  }
  
  private static byte[] a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Config.a());
    ((StringBuilder)localObject).append(AppSetting.d());
    ((StringBuilder)localObject).append("E1D84CC825147ECD");
    localObject = MD5.toMD5(((StringBuilder)localObject).toString()).substring(0, 16);
    try
    {
      byte[] arrayOfByte = ((String)localObject).getBytes("ISO8859_1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label56:
      break label56;
    }
    return ((String)localObject).getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.ConfigParser
 * JD-Core Version:    0.7.0.1
 */