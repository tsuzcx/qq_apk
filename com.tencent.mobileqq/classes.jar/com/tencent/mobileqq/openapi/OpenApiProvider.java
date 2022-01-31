package com.tencent.mobileqq.openapi;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import auju;
import aujx;
import aujz;
import auka;
import bbkk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenApiProvider
  extends ContentProvider
{
  private static final UriMatcher a = new UriMatcher(-1);
  
  static
  {
    try
    {
      a.addURI("com.tencent.mobileqq.openapi.provider", "query_msg", 0);
      a.addURI("com.tencent.mobileqq.openapi.provider", "query_face", 1);
      a.addURI("com.tencent.mobileqq.openapi.provider", "query_nick", 2);
      a.addURI("com.tencent.mobileqq.openapi.provider", "reg_receiver", 3);
      a.addURI("com.tencent.mobileqq.openapi.provider", "send_msg", 4);
      a.addURI("com.tencent.mobileqq.openapi.provider", "set_readed", 5);
      a.addURI("com.tencent.mobileqq.openapi.provider", "openaio", 6);
      a.addURI("com.tencent.mobileqq.openapi.provider", "decodesilk", 7);
      a.addURI("com.tencent.mobileqq.openapi.provider", "download_media", 8);
      a.addURI("com.tencent.mobileqq.openapi.provider", "exchange_uin", 9);
      a.addURI("com.tencent.mobileqq.openapi.provider", "paycode_channel", 10);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("OpenApi.Provider", 2, "openapi amazing at ", localThrowable);
    }
  }
  
  private Cursor a(int paramInt)
  {
    MatrixCursor localMatrixCursor = new MatrixCursor(auju.a);
    localMatrixCursor.addRow(new Object[] { Integer.valueOf(paramInt) });
    return localMatrixCursor;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Provider", 2, "onCreate");
    }
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      paramUri = new MatrixCursor(new String[] { "rs_code" });
      paramUri.addRow(new Object[] { Integer.valueOf(-1000) });
      return paramUri;
    }
    paramString1 = OpenApiManager.getInstance();
    if (!paramString1.isSDKEnable()) {
      return a(-5);
    }
    paramString2 = paramUri.getQueryParameter("appid");
    String str1 = paramUri.getQueryParameter("pkgName");
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(str1))) {
      return a(-6);
    }
    if (!paramString1.verifyCallingPackage(this, str1)) {
      return a(-3);
    }
    int i = a.match(paramUri);
    boolean bool1;
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Provider", 2, "error code = " + i);
      }
      paramUri = new MatrixCursor(new String[] { "rs_code" });
      paramUri.addRow(new Object[] { Integer.valueOf(-5) });
      return paramUri;
    case 1: 
      paramArrayOfString1 = paramUri.getQueryParameter("uin");
      try
      {
        i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
        if (TextUtils.isEmpty(paramArrayOfString1)) {
          return a(-6);
        }
      }
      catch (Exception paramUri)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OpenApi.Provider", 2, "query_face", paramUri);
        }
        return a(-6);
      }
      paramUri = paramString1.getAvatarPath(paramString2, str1, paramArrayOfString1, i);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder(150);
        paramString1.append("query face, uin = ").append(bbkk.e(paramArrayOfString1));
        paramString1.append(", type = ").append(i);
        paramString1.append(", rs = ").append(paramUri.b);
        paramString1.append(", path = ").append(paramUri.jdField_a_of_type_JavaLangString);
        QLog.d("OpenApi.Provider", 2, paramString1.toString());
      }
      if (paramUri.b != 0) {
        return a(paramUri.b);
      }
      paramArrayOfString1 = new MatrixCursor(auju.c);
      paramArrayOfString1.addRow(new Object[] { paramUri.jdField_a_of_type_JavaLangString });
      return paramArrayOfString1;
    case 0: 
      paramArrayOfString1 = paramUri.getQueryParameter("uin");
      try
      {
        i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
        j = Integer.valueOf(paramUri.getQueryParameter("count")).intValue();
        if ((TextUtils.isEmpty(paramArrayOfString1)) || (j < 0)) {
          return a(-6);
        }
      }
      catch (Exception paramUri)
      {
        if (QLog.isColorLevel()) {
          QLog.d("OpenApi.Provider", 2, "query_msg", paramUri);
        }
        return a(-6);
      }
      bool1 = true;
    }
    try
    {
      bool2 = Boolean.valueOf(paramUri.getQueryParameter("only_unread")).booleanValue();
      bool1 = bool2;
    }
    catch (Exception paramArrayOfString2)
    {
      boolean bool2;
      label552:
      break label552;
    }
    bool2 = true;
    try
    {
      boolean bool3 = Boolean.valueOf(paramUri.getQueryParameter("only_recv")).booleanValue();
      bool2 = bool3;
    }
    catch (Exception paramUri)
    {
      label573:
      int k;
      long l1;
      String str2;
      long l4;
      break label573;
    }
    paramUri = new ArrayList(j);
    k = paramString1.getLastMessages(paramUri, paramString2, str1, paramArrayOfString1, i, j, bool2, bool1);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder(100);
      paramString1.append("query msg, uin = ").append(bbkk.e(paramArrayOfString1));
      paramString1.append(", type = ").append(i);
      paramString1.append(", count = ").append(j);
      paramString1.append(", rs = ").append(k);
      paramString1.append(", rscount = ").append(paramUri.size());
      QLog.d("OpenApi.Provider", 2, paramString1.toString());
    }
    if (k != 0) {
      return a(k);
    }
    paramArrayOfString1 = new MatrixCursor(auju.b);
    paramUri = paramUri.iterator();
    while (paramUri.hasNext()) {
      paramArrayOfString1.addRow(((aujx)paramUri.next()).a());
    }
    return paramArrayOfString1;
    paramArrayOfString1 = paramUri.getQueryParameter("uin");
    try
    {
      i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
      if (TextUtils.isEmpty(paramArrayOfString1)) {
        return a(-6);
      }
    }
    catch (Exception paramUri)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Provider", 2, "query_nick", paramUri);
      }
      return a(-6);
    }
    paramUri = paramString1.getNickName(paramString2, str1, paramArrayOfString1, i);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder(150);
      paramString1.append("query nick, uin = ").append(bbkk.e(paramArrayOfString1));
      paramString1.append(", type = ").append(i);
      paramString1.append(", rs = ").append(paramUri.b);
      QLog.d("OpenApi.Provider", 2, paramString1.toString());
    }
    if (paramUri.b != 0) {
      return a(paramUri.b);
    }
    paramArrayOfString1 = new MatrixCursor(auju.d);
    paramArrayOfString1.addRow(new Object[] { paramUri.jdField_a_of_type_JavaLangString });
    return paramArrayOfString1;
    i = 0;
    int j = 0;
    l1 = 0L;
    paramArrayOfString1 = null;
    try
    {
      k = Integer.valueOf(paramUri.getQueryParameter("op")).intValue();
      if (k == 1) {
        l1 = Long.valueOf(paramUri.getQueryParameter("sessionkey")).longValue();
      }
      if ((k != 1) || (k == 1)) {
        paramUri = paramString1.registerThirdApp(paramString2, str1, l1, i, j, paramArrayOfString1);
      }
    }
    catch (Exception paramUri)
    {
      try
      {
        i = Integer.valueOf(paramUri.getQueryParameter("msg_filter")).intValue();
        j = Integer.valueOf(paramUri.getQueryParameter("uin_filter")).intValue();
        paramUri = paramUri.getQueryParameter("permission");
        paramArrayOfString1 = paramUri;
        if (!TextUtils.isEmpty(paramUri)) {
          break label1090;
        }
        return a(-6);
      }
      catch (Exception paramUri)
      {
        if (!QLog.isColorLevel()) {
          break label1083;
        }
        QLog.d("OpenApi.Provider", 2, "reg_receiver", paramUri);
        return a(-6);
      }
      paramUri = paramUri;
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Provider", 2, "reg_receiver", paramUri);
      }
      return a(-6);
    }
    for (;;)
    {
      label1083:
      label1090:
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Provider", 2, "reg, op = " + k + ", filter = " + i + ", rs = " + paramUri.jdField_a_of_type_Int + ", stamp = " + paramUri.jdField_a_of_type_Long + ", uin = " + paramUri.jdField_a_of_type_JavaLangString);
      }
      paramArrayOfString1 = new MatrixCursor(auju.e);
      paramArrayOfString1.addRow(new Object[] { Integer.valueOf(paramUri.jdField_a_of_type_Int), Long.valueOf(paramUri.jdField_a_of_type_Long), paramUri.jdField_a_of_type_JavaLangString });
      return paramArrayOfString1;
      paramUri = new aujz(paramString1.unregisterThirdApp(paramString2, str1), 0L, null);
    }
    paramArrayOfString1 = paramUri.getQueryParameter("uin");
    try
    {
      i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
      j = Integer.valueOf(paramUri.getQueryParameter("msg_type")).intValue();
      paramArrayOfString2 = paramUri.getQueryParameter("msgContent");
      paramUri = paramUri.getQueryParameter("media_path");
      if ((TextUtils.isEmpty(paramArrayOfString1)) || ((TextUtils.isEmpty(paramArrayOfString2)) && (TextUtils.isEmpty(paramUri)))) {
        return a(-6);
      }
    }
    catch (Exception paramUri)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Provider", 2, "send msg", paramUri);
      }
      return a(-6);
    }
    paramUri = paramString1.sendMessage(paramString2, str1, paramArrayOfString1, i, j, paramArrayOfString2, paramUri);
    if (QLog.isColorLevel()) {
      QLog.d("OpenApi.Provider", 2, "sendMsg, uin = " + paramArrayOfString1 + "msgType = " + j + ", result = " + paramUri.b);
    }
    if (paramUri.b != 0) {
      return a(paramUri.b);
    }
    paramArrayOfString1 = new MatrixCursor(auju.f);
    paramArrayOfString1.addRow(new Object[] { paramUri.jdField_a_of_type_JavaLangString });
    return paramArrayOfString1;
    paramArrayOfString1 = paramUri.getQueryParameter("uin");
    str2 = paramUri.getQueryParameter("msgid");
    try
    {
      i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
      if ((TextUtils.isEmpty(paramArrayOfString1)) || (TextUtils.isEmpty(str2))) {
        return a(-6);
      }
    }
    catch (Exception paramUri)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Provider", 2, "set_readed", paramUri);
      }
      return a(-6);
    }
    j = paramString1.setMessageReaded(paramString2, str1, paramArrayOfString1, i, str2);
    if (QLog.isColorLevel())
    {
      paramUri = new StringBuilder();
      paramUri.append("set readed, uin = ").append(bbkk.e(paramArrayOfString1));
      paramUri.append(", uinType = ").append(i);
      paramUri.append(", msgids = ").append(paramArrayOfString2);
      paramUri.append(", rs = ").append(j);
      QLog.d("OpenApi.Provider", 2, paramUri.toString());
    }
    paramUri = new MatrixCursor(auju.a);
    paramUri.addRow(new Object[] { Integer.valueOf(j) });
    return paramUri;
    paramArrayOfString1 = paramUri.getQueryParameter("uin");
    try
    {
      i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
      i = paramString1.openAIO(paramString2, str1, paramArrayOfString1, i);
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Provider", 2, "open aio, result = " + i);
      }
      paramUri = new MatrixCursor(auju.h);
      paramUri.addRow(new Object[] { Integer.valueOf(i) });
      return paramUri;
    }
    catch (Exception paramUri)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Provider", 2, "openaio", paramUri);
      }
      return a(-6);
    }
    paramArrayOfString1 = paramUri.getQueryParameter("uin");
    j = 0;
    try
    {
      i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
      paramArrayOfString2 = paramUri.getQueryParameter("msgid");
      str2 = paramUri.getQueryParameter("media_path");
      paramUri = paramUri.getQueryParameter("pcm_path");
      if ((TextUtils.isEmpty(paramArrayOfString1)) || (TextUtils.isEmpty(paramArrayOfString2)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(paramUri))) {
        return a(-6);
      }
    }
    catch (Exception paramArrayOfString2)
    {
      for (;;)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("OpenApi.Provider", 2, "decodesilk", paramArrayOfString2);
          i = j;
        }
      }
      paramUri = paramString1.decodePtt(paramString2, str1, paramArrayOfString1, i, paramArrayOfString2, str2, paramUri);
      paramArrayOfString1 = new MatrixCursor(auju.i);
      paramArrayOfString1.addRow(new Object[] { paramUri.first, paramUri.second });
      return paramArrayOfString1;
    }
    paramArrayOfString1 = paramUri.getQueryParameter("uin");
    paramArrayOfString2 = paramUri.getQueryParameter("msgid");
    j = 0;
    try
    {
      i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
      if ((TextUtils.isEmpty(paramArrayOfString1)) || (TextUtils.isEmpty(paramArrayOfString2)) || (i == 0)) {
        return a(-6);
      }
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("OpenApi.Provider", 2, "downMedia", paramUri);
          i = j;
        }
      }
      paramUri = paramString1.downloadMedia(paramString2, str1, paramArrayOfString1, i, paramArrayOfString2);
      if (((Integer)paramUri.first).intValue() != 0) {
        return a(((Integer)paramUri.first).intValue());
      }
      paramArrayOfString1 = new MatrixCursor(auju.j);
      paramArrayOfString1.addRow(new Object[] { paramUri.second });
      return paramArrayOfString1;
    }
    l1 = 0L;
    l4 = 0L;
    try
    {
      l2 = Long.valueOf(paramUri.getQueryParameter("lastsessionkey")).longValue();
      l1 = l2;
      l3 = Long.valueOf(paramUri.getQueryParameter("sessionkey")).longValue();
    }
    catch (Exception paramUri)
    {
      long l2;
      long l3;
      for (;;)
      {
        l2 = l1;
        l3 = l4;
        if (QLog.isColorLevel())
        {
          QLog.d("OpenApi.Provider", 2, "exchangeUin", paramUri);
          l2 = l1;
          l3 = l4;
        }
      }
      paramString1 = paramString1.exchangeUins(paramString2, str1, l2, l3, paramArrayOfString2);
      if (!QLog.isColorLevel()) {
        break label2287;
      }
      QLog.d("OpenApi.Provider", 2, "exchange uin, result = " + paramString1[0].b);
      if (paramString1.length == paramArrayOfString2.length) {
        break label2306;
      }
      return a(paramString1[0].b);
      paramArrayOfString1 = new MatrixCursor(auju.k);
      j = paramString1.length;
      i = 0;
      paramUri = paramArrayOfString1;
    }
    if ((l2 == 0L) || (l3 == 0L) || (paramArrayOfString2 == null) || (paramArrayOfString2.length == 0)) {
      return a(-6);
    }
    label2287:
    while (i < j)
    {
      paramUri = paramString1[i];
      paramArrayOfString1.addRow(new Object[] { Integer.valueOf(paramUri.b), paramUri.jdField_a_of_type_JavaLangString });
      i += 1;
    }
    label2306:
    paramArrayOfString1 = paramUri.getQueryParameter("msg_type");
    if (paramArrayOfString1 != null)
    {
      i = Integer.parseInt(paramArrayOfString1);
      paramUri = paramString1.handlePayMsgReq(paramString2, str1, paramUri.getQueryParameter("permission"), i, paramUri.getQueryParameter("msgSummary"));
    }
    while ((paramUri != null) && (paramUri.size() > 0))
    {
      paramArrayOfString1 = new MatrixCursor(auju.l);
      paramUri = paramUri.iterator();
      for (;;)
      {
        if (paramUri.hasNext())
        {
          paramString1 = (auka)paramUri.next();
          paramArrayOfString1.addRow(new Object[] { Integer.valueOf(paramString1.jdField_a_of_type_Int), Integer.valueOf(paramString1.b), paramString1.jdField_a_of_type_JavaLangString });
          continue;
          paramUri = paramString1.handlePayMsgRsp(null);
          break;
        }
      }
      return paramArrayOfString1;
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiProvider
 * JD-Core Version:    0.7.0.1
 */