package com.tencent.mobileqq.config;

import acaa;
import acab;
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
  public static HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      a(localHashMap, DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + paramString).getBytes())).getDocumentElement().getChildNodes());
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
    switch (paramInt)
    {
    case 3: 
    default: 
    case 4: 
      do
      {
        return;
        paramString = Config.a();
      } while (paramString == null);
      a(paramString.a, paramArrayOfByte);
      return;
    case 24: 
      Config.a.b();
      Config.a.a(false);
      a(Config.a, paramArrayOfByte, paramString);
      return;
    }
    Config.b.b();
    Config.b.a(false);
    a(Config.b, paramArrayOfByte);
  }
  
  private static void a(acaa paramacaa, byte[] paramArrayOfByte)
  {
    int i = PkgTools.a(paramArrayOfByte, 0);
    paramacaa.jdField_a_of_type_JavaLangString = PkgTools.a(paramArrayOfByte, 2, i);
    i += 2;
    paramacaa.jdField_a_of_type_Byte = paramArrayOfByte[i];
    i += 1;
    paramacaa.jdField_b_of_type_Byte = paramArrayOfByte[i];
    int j = i + 1;
    i = PkgTools.a(paramArrayOfByte, j);
    j += 2;
    paramacaa.jdField_b_of_type_JavaLangString = PkgTools.a(paramArrayOfByte, j, i);
  }
  
  private static void a(acab paramacab) {}
  
  private static void a(acab paramacab, String paramString)
  {
    int k = 2;
    int m = 0;
    int n = PkgTools.a(paramacab.jdField_a_of_type_ArrayOfByte, 0);
    int i = m;
    int j = k;
    if (QLog.isColorLevel())
    {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--itemNum = " + n);
      j = k;
      i = m;
    }
    while (i < n)
    {
      k = PkgTools.a(paramacab.jdField_a_of_type_ArrayOfByte, j);
      m = j + 2;
      j = PkgTools.a(paramacab.jdField_a_of_type_ArrayOfByte, m);
      m += 2;
      byte[] arrayOfByte = new byte[j];
      PkgTools.b(paramacab.jdField_a_of_type_ArrayOfByte, m, arrayOfByte, j);
      j = m + j;
      a(k, arrayOfByte, paramString);
      i += 1;
    }
    paramacab = Config.a();
    if (paramacab != null) {
      paramacab.c();
    }
  }
  
  private static void a(PicAndAdConf paramPicAndAdConf, byte[] paramArrayOfByte)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode---confighParse--buildItem_FlashLogo = ");
    }
    paramPicAndAdConf.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 0);
    paramPicAndAdConf.b = (PkgTools.a(paramArrayOfByte, 4) * 1000L);
    paramPicAndAdConf.c = (PkgTools.a(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    int m;
    int n;
    for (int j = 13; i < k; j = n + m)
    {
      long l = PkgTools.a(paramArrayOfByte, j);
      m = j + 4;
      j = paramArrayOfByte[m];
      n = m + 1 + 1;
      m = PkgTools.a(paramArrayOfByte, n);
      n += 2;
      String str1 = PkgTools.a(paramArrayOfByte, n, m);
      n += m;
      m = PkgTools.a(paramArrayOfByte, n);
      n += 2;
      String str2 = PkgTools.a(paramArrayOfByte, n, m);
      if (j == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShanPing", 2, "flashlogo desc= " + str1 + " src addr = " + str2);
        }
        str2 = paramPicAndAdConf.a(str1, (byte)3);
        paramPicAndAdConf.c(str2);
        paramPicAndAdConf.a(paramPicAndAdConf.a(l, str1, str2, null, ""));
      }
      i += 1;
    }
  }
  
  private static void a(PicAndAdConf paramPicAndAdConf, byte[] paramArrayOfByte, String paramString)
  {
    paramPicAndAdConf.jdField_a_of_type_Long = PkgTools.a(paramArrayOfByte, 0);
    paramPicAndAdConf.b = (PkgTools.a(paramArrayOfByte, 4) * 1000L);
    paramPicAndAdConf.c = (PkgTools.a(paramArrayOfByte, 8) * 1000L);
    int k = paramArrayOfByte[12];
    int j = 13;
    if (k > 0)
    {
      paramPicAndAdConf.c();
      BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + paramString, true).commit();
    }
    int i = 0;
    while (i < k)
    {
      long l1 = PkgTools.a(paramArrayOfByte, j);
      int m = j + 4;
      j = paramArrayOfByte[m];
      m = m + 1 + 1;
      long l2 = PkgTools.a(paramArrayOfByte, m);
      int n = m + 4;
      m = PkgTools.a(paramArrayOfByte, n);
      int i1 = n + 2;
      n = PkgTools.a(paramArrayOfByte, i1);
      i1 += 2;
      paramString = PkgTools.a(paramArrayOfByte, i1, n);
      i1 += n;
      n = PkgTools.a(paramArrayOfByte, i1);
      i1 += 2;
      String str2 = PkgTools.a(paramArrayOfByte, i1, n);
      i1 += n;
      n = PkgTools.a(paramArrayOfByte, i1);
      i1 += 2;
      String str1 = PkgTools.a(paramArrayOfByte, i1, n);
      if (j == 1)
      {
        str2 = paramPicAndAdConf.a(str2, (byte)3);
        if (!a(String.valueOf(l1))) {
          paramPicAndAdConf.c(str2);
        }
        paramPicAndAdConf.a(paramPicAndAdConf.a(l1, paramString, str2, str1, BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + l1, "" + l2, (short)m));
      }
      i += 1;
      j = n + i1;
    }
  }
  
  private static void a(HashMap paramHashMap, NodeList paramNodeList)
  {
    if ((paramNodeList == null) || (paramNodeList.getLength() == 0)) {
      return;
    }
    int i = 0;
    label16:
    Node localNode;
    if (i < paramNodeList.getLength())
    {
      localNode = paramNodeList.item(i);
      if (!(localNode instanceof Element)) {
        break label67;
      }
      if (localNode.hasChildNodes()) {
        a(paramHashMap, localNode.getChildNodes());
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label67:
      if (localNode.getParentNode() != null) {
        paramHashMap.put(localNode.getParentNode().getNodeName(), localNode.getNodeValue());
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, acab paramacab)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 11)) {}
    for (;;)
    {
      return;
      if (paramArrayOfByte[0] == 2)
      {
        paramacab.b = PkgTools.a(paramArrayOfByte, 1);
        paramacab.jdField_a_of_type_Short = PkgTools.a(paramArrayOfByte, 3);
        paramacab.jdField_a_of_type_Long = (PkgTools.a(paramArrayOfByte, 5) * 1000L);
        paramacab.jdField_a_of_type_Byte = paramArrayOfByte[9];
        int i = paramArrayOfByte.length - 10 - 1;
        if (paramacab.jdField_a_of_type_Byte == 0)
        {
          paramacab.jdField_a_of_type_ArrayOfByte = new byte[i];
          PkgTools.b(paramArrayOfByte, 10, paramacab.jdField_a_of_type_ArrayOfByte, i);
        }
        while (paramArrayOfByte.length != i + 10 + 1)
        {
          return;
          paramacab.jdField_a_of_type_JavaLangString = PkgTools.a(paramArrayOfByte, 10, i);
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic/" + paramString).exists();
  }
  
  public static boolean a(byte[] paramArrayOfByte, acab paramacab, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    do
    {
      do
      {
        return false;
        a(paramArrayOfByte, paramacab);
      } while (paramacab.b != 768);
      if (paramacab.jdField_a_of_type_Byte != 0)
      {
        a(paramacab);
        return false;
      }
    } while ((paramacab.jdField_a_of_type_ArrayOfByte == null) || (paramacab.jdField_a_of_type_ArrayOfByte.length == 0));
    a(paramacab, paramString);
    return true;
  }
  
  private static byte[] a()
  {
    String str = MD5.toMD5(Config.a() + AppSetting.a() + "E1D84CC825147ECD").substring(0, 16);
    try
    {
      byte[] arrayOfByte = str.getBytes("ISO8859_1");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return str.getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ConfigParser
 * JD-Core Version:    0.7.0.1
 */