package com.tencent.mobileqq.openapi;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.openapi.sdk.ApiConstants.Provider;
import com.tencent.mobileqq.openapi.sdk.MessageItem;
import com.tencent.mobileqq.openapi.sdk.QQResult.QQRegResult;
import com.tencent.mobileqq.openapi.sdk.QQResult.QQStringResult;
import com.tencent.mobileqq.utils.StringUtil;
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
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Provider", 2, "openapi amazing at ", localThrowable);
      }
    }
  }
  
  private Cursor a(int paramInt)
  {
    MatrixCursor localMatrixCursor = new MatrixCursor(ApiConstants.Provider.a);
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
    paramArrayOfString1 = OpenApiManager.getInstance();
    if (!paramArrayOfString1.isSDKEnable()) {
      return a(-5);
    }
    paramString2 = paramUri.getQueryParameter("appid");
    String str1 = paramUri.getQueryParameter("pkgName");
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(str1)))
    {
      if (!paramArrayOfString1.verifyCallingPackage(this, str1)) {
        return a(-3);
      }
      int i = a.match(paramUri);
      paramString1 = null;
      long l1;
      label437:
      int j;
      String str2;
      int k;
      switch (i)
      {
      default: 
        if (!QLog.isColorLevel()) {
          break label2577;
        }
        paramUri = new StringBuilder();
        paramUri.append("error code = ");
        paramUri.append(i);
        QLog.d("OpenApi.Provider", 2, paramUri.toString());
        break;
      case 10: 
        paramArrayOfString2 = paramUri.getQueryParameter("msg_type");
        if (paramArrayOfString2 != null)
        {
          i = Integer.parseInt(paramArrayOfString2);
          paramArrayOfString1 = paramArrayOfString1.handlePayMsgReq(paramString2, str1, paramUri.getQueryParameter("permission"), i, paramUri.getQueryParameter("msgSummary"));
        }
        else
        {
          paramArrayOfString1 = paramArrayOfString1.handlePayMsgRsp(null);
        }
        paramUri = paramString1;
        if (paramArrayOfString1 == null) {
          break label2610;
        }
        paramUri = paramString1;
        if (paramArrayOfString1.size() <= 0) {
          break label2610;
        }
        paramString1 = new MatrixCursor(ApiConstants.Provider.l);
        paramArrayOfString1 = paramArrayOfString1.iterator();
        for (;;)
        {
          paramUri = paramString1;
          if (!paramArrayOfString1.hasNext()) {
            break;
          }
          paramUri = (QQResult.QQStringResult)paramArrayOfString1.next();
          paramString1.addRow(new Object[] { Integer.valueOf(paramUri.jdField_a_of_type_Int), Integer.valueOf(paramUri.b), paramUri.jdField_a_of_type_JavaLangString });
        }
      case 9: 
        try
        {
          l2 = Long.valueOf(paramUri.getQueryParameter("lastsessionkey")).longValue();
          try
          {
            l1 = Long.valueOf(paramUri.getQueryParameter("sessionkey")).longValue();
            l3 = l1;
          }
          catch (Exception paramUri)
          {
            l1 = l2;
          }
          if (!QLog.isColorLevel()) {
            break label437;
          }
        }
        catch (Exception paramUri)
        {
          l1 = 0L;
        }
        QLog.d("OpenApi.Provider", 2, "exchangeUin", paramUri);
        long l3 = 0L;
        long l2 = l1;
        if ((l2 != 0L) && (l3 != 0L) && (paramArrayOfString2 != null) && (paramArrayOfString2.length != 0))
        {
          paramString1 = paramArrayOfString1.exchangeUins(paramString2, str1, l2, l3, paramArrayOfString2);
          if (QLog.isColorLevel())
          {
            paramUri = new StringBuilder();
            paramUri.append("exchange uin, result = ");
            paramUri.append(paramString1[0].b);
            QLog.d("OpenApi.Provider", 2, paramUri.toString());
          }
          if (paramString1.length != paramArrayOfString2.length) {
            return a(paramString1[0].b);
          }
          paramArrayOfString1 = new MatrixCursor(ApiConstants.Provider.k);
          j = paramString1.length;
          i = 0;
          for (;;)
          {
            paramUri = paramArrayOfString1;
            if (i >= j) {
              break;
            }
            paramUri = paramString1[i];
            paramArrayOfString1.addRow(new Object[] { Integer.valueOf(paramUri.b), paramUri.jdField_a_of_type_JavaLangString });
            i += 1;
          }
        }
        return a(-6);
      case 8: 
        paramString1 = paramUri.getQueryParameter("uin");
        paramArrayOfString2 = paramUri.getQueryParameter("msgid");
        try
        {
          i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
        }
        catch (Exception paramUri)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Provider", 2, "downMedia", paramUri);
          }
          i = 0;
        }
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramArrayOfString2)) && (i != 0))
        {
          paramUri = paramArrayOfString1.downloadMedia(paramString2, str1, paramString1, i, paramArrayOfString2);
          if (((Integer)paramUri.first).intValue() != 0) {
            return a(((Integer)paramUri.first).intValue());
          }
          paramArrayOfString1 = new MatrixCursor(ApiConstants.Provider.j);
          paramArrayOfString1.addRow(new Object[] { paramUri.second });
          return paramArrayOfString1;
        }
        return a(-6);
      case 7: 
        paramString1 = paramUri.getQueryParameter("uin");
        try
        {
          i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
        }
        catch (Exception paramArrayOfString2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Provider", 2, "decodesilk", paramArrayOfString2);
          }
          i = 0;
        }
        paramArrayOfString2 = paramUri.getQueryParameter("msgid");
        str2 = paramUri.getQueryParameter("media_path");
        paramUri = paramUri.getQueryParameter("pcm_path");
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramArrayOfString2)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(paramUri)))
        {
          paramUri = paramArrayOfString1.decodePtt(paramString2, str1, paramString1, i, paramArrayOfString2, str2, paramUri);
          paramArrayOfString1 = new MatrixCursor(ApiConstants.Provider.i);
          paramArrayOfString1.addRow(new Object[] { paramUri.first, paramUri.second });
          return paramArrayOfString1;
        }
        return a(-6);
      case 6: 
        paramString1 = paramUri.getQueryParameter("uin");
        try
        {
          i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
          i = paramArrayOfString1.openAIO(paramString2, str1, paramString1, i);
          if (QLog.isColorLevel())
          {
            paramUri = new StringBuilder();
            paramUri.append("open aio, result = ");
            paramUri.append(i);
            QLog.d("OpenApi.Provider", 2, paramUri.toString());
          }
          paramUri = new MatrixCursor(ApiConstants.Provider.h);
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
      case 5: 
        paramString1 = paramUri.getQueryParameter("uin");
        str2 = paramUri.getQueryParameter("msgid");
        try
        {
          i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
          if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(str2)))
          {
            j = paramArrayOfString1.setMessageReaded(paramString2, str1, paramString1, i, str2);
            if (QLog.isColorLevel())
            {
              paramUri = new StringBuilder();
              paramUri.append("set readed, uin = ");
              paramUri.append(StringUtil.e(paramString1));
              paramUri.append(", uinType = ");
              paramUri.append(i);
              paramUri.append(", msgids = ");
              paramUri.append(paramArrayOfString2);
              paramUri.append(", rs = ");
              paramUri.append(j);
              QLog.d("OpenApi.Provider", 2, paramUri.toString());
            }
            paramUri = new MatrixCursor(ApiConstants.Provider.a);
            paramUri.addRow(new Object[] { Integer.valueOf(j) });
            return paramUri;
          }
          return a(-6);
        }
        catch (Exception paramUri)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Provider", 2, "set_readed", paramUri);
          }
          return a(-6);
        }
      case 4: 
        paramString1 = paramUri.getQueryParameter("uin");
        try
        {
          i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
          j = Integer.valueOf(paramUri.getQueryParameter("msg_type")).intValue();
          paramArrayOfString2 = paramUri.getQueryParameter("msgContent");
          paramUri = paramUri.getQueryParameter("media_path");
          if ((!TextUtils.isEmpty(paramString1)) && ((!TextUtils.isEmpty(paramArrayOfString2)) || (!TextUtils.isEmpty(paramUri))))
          {
            paramUri = paramArrayOfString1.sendMessage(paramString2, str1, paramString1, i, j, paramArrayOfString2, paramUri);
            if (QLog.isColorLevel())
            {
              paramArrayOfString1 = new StringBuilder();
              paramArrayOfString1.append("sendMsg, uin = ");
              paramArrayOfString1.append(paramString1);
              paramArrayOfString1.append("msgType = ");
              paramArrayOfString1.append(j);
              paramArrayOfString1.append(", result = ");
              paramArrayOfString1.append(paramUri.b);
              QLog.d("OpenApi.Provider", 2, paramArrayOfString1.toString());
            }
            if (paramUri.b != 0) {
              return a(paramUri.b);
            }
            paramArrayOfString1 = new MatrixCursor(ApiConstants.Provider.f);
            paramArrayOfString1.addRow(new Object[] { paramUri.jdField_a_of_type_JavaLangString });
            return paramArrayOfString1;
          }
          return a(-6);
        }
        catch (Exception paramUri)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Provider", 2, "send msg", paramUri);
          }
          return a(-6);
        }
      case 3: 
        try
        {
          k = Integer.valueOf(paramUri.getQueryParameter("op")).intValue();
          if (k == 1) {
            l1 = Long.valueOf(paramUri.getQueryParameter("sessionkey")).longValue();
          } else {
            l1 = 0L;
          }
          if (k == 1)
          {
            try
            {
              j = Integer.valueOf(paramUri.getQueryParameter("msg_filter")).intValue();
              i = Integer.valueOf(paramUri.getQueryParameter("uin_filter")).intValue();
              paramUri = paramUri.getQueryParameter("permission");
              if (TextUtils.isEmpty(paramUri)) {
                return a(-6);
              }
            }
            catch (Exception paramUri)
            {
              if (QLog.isColorLevel()) {
                QLog.d("OpenApi.Provider", 2, "reg_receiver", paramUri);
              }
              return a(-6);
            }
          }
          else
          {
            paramUri = null;
            j = 0;
            i = 0;
          }
          if (k == 1) {
            paramUri = paramArrayOfString1.registerThirdApp(paramString2, str1, l1, j, i, paramUri);
          } else {
            paramUri = new QQResult.QQRegResult(paramArrayOfString1.unregisterThirdApp(paramString2, str1), 0L, null);
          }
          if (QLog.isColorLevel())
          {
            paramArrayOfString1 = new StringBuilder();
            paramArrayOfString1.append("reg, op = ");
            paramArrayOfString1.append(k);
            paramArrayOfString1.append(", filter = ");
            paramArrayOfString1.append(j);
            paramArrayOfString1.append(", rs = ");
            paramArrayOfString1.append(paramUri.jdField_a_of_type_Int);
            paramArrayOfString1.append(", stamp = ");
            paramArrayOfString1.append(paramUri.jdField_a_of_type_Long);
            paramArrayOfString1.append(", uin = ");
            paramArrayOfString1.append(paramUri.jdField_a_of_type_JavaLangString);
            QLog.d("OpenApi.Provider", 2, paramArrayOfString1.toString());
          }
          paramArrayOfString1 = new MatrixCursor(ApiConstants.Provider.e);
          paramArrayOfString1.addRow(new Object[] { Integer.valueOf(paramUri.jdField_a_of_type_Int), Long.valueOf(paramUri.jdField_a_of_type_Long), paramUri.jdField_a_of_type_JavaLangString });
          return paramArrayOfString1;
        }
        catch (Exception paramUri)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Provider", 2, "reg_receiver", paramUri);
          }
          return a(-6);
        }
      case 2: 
        paramString1 = paramUri.getQueryParameter("uin");
        try
        {
          i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
          if (TextUtils.isEmpty(paramString1)) {
            return a(-6);
          }
          paramUri = paramArrayOfString1.getNickName(paramString2, str1, paramString1, i);
          if (QLog.isColorLevel())
          {
            paramArrayOfString1 = new StringBuilder(150);
            paramArrayOfString1.append("query nick, uin = ");
            paramArrayOfString1.append(StringUtil.e(paramString1));
            paramArrayOfString1.append(", type = ");
            paramArrayOfString1.append(i);
            paramArrayOfString1.append(", rs = ");
            paramArrayOfString1.append(paramUri.b);
            QLog.d("OpenApi.Provider", 2, paramArrayOfString1.toString());
          }
          if (paramUri.b != 0) {
            return a(paramUri.b);
          }
          paramArrayOfString1 = new MatrixCursor(ApiConstants.Provider.d);
          paramArrayOfString1.addRow(new Object[] { paramUri.jdField_a_of_type_JavaLangString });
          return paramArrayOfString1;
        }
        catch (Exception paramUri)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Provider", 2, "query_nick", paramUri);
          }
          return a(-6);
        }
      case 1: 
        paramString1 = paramUri.getQueryParameter("uin");
        try
        {
          i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
          if (TextUtils.isEmpty(paramString1)) {
            return a(-6);
          }
          paramUri = paramArrayOfString1.getAvatarPath(paramString2, str1, paramString1, i);
          if (QLog.isColorLevel())
          {
            paramArrayOfString1 = new StringBuilder(150);
            paramArrayOfString1.append("query face, uin = ");
            paramArrayOfString1.append(StringUtil.e(paramString1));
            paramArrayOfString1.append(", type = ");
            paramArrayOfString1.append(i);
            paramArrayOfString1.append(", rs = ");
            paramArrayOfString1.append(paramUri.b);
            paramArrayOfString1.append(", path = ");
            paramArrayOfString1.append(paramUri.jdField_a_of_type_JavaLangString);
            QLog.d("OpenApi.Provider", 2, paramArrayOfString1.toString());
          }
          if (paramUri.b != 0) {
            return a(paramUri.b);
          }
          paramArrayOfString1 = new MatrixCursor(ApiConstants.Provider.c);
          paramArrayOfString1.addRow(new Object[] { paramUri.jdField_a_of_type_JavaLangString });
          return paramArrayOfString1;
        }
        catch (Exception paramUri)
        {
          if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Provider", 2, "query_face", paramUri);
          }
          return a(-6);
        }
      }
      paramString1 = paramUri.getQueryParameter("uin");
      try
      {
        i = Integer.valueOf(paramUri.getQueryParameter("uin_type")).intValue();
        j = Integer.valueOf(paramUri.getQueryParameter("count")).intValue();
        if (!TextUtils.isEmpty(paramString1)) {
          if (j >= 0) {}
        }
      }
      catch (Exception paramUri)
      {
        boolean bool1;
        label2326:
        if (QLog.isColorLevel()) {
          QLog.d("OpenApi.Provider", 2, "query_msg", paramUri);
        }
        return a(-6);
      }
    }
    try
    {
      bool1 = Boolean.valueOf(paramUri.getQueryParameter("only_unread")).booleanValue();
    }
    catch (Exception paramArrayOfString2)
    {
      break label2326;
    }
    bool1 = true;
    try
    {
      bool2 = Boolean.valueOf(paramUri.getQueryParameter("only_recv")).booleanValue();
    }
    catch (Exception paramUri)
    {
      boolean bool2;
      label2347:
      break label2347;
    }
    bool2 = true;
    paramUri = new ArrayList(j);
    k = paramArrayOfString1.getLastMessages(paramUri, paramString2, str1, paramString1, i, j, bool2, bool1);
    if (QLog.isColorLevel())
    {
      paramArrayOfString1 = new StringBuilder(100);
      paramArrayOfString1.append("query msg, uin = ");
      paramArrayOfString1.append(StringUtil.e(paramString1));
      paramArrayOfString1.append(", type = ");
      paramArrayOfString1.append(i);
      paramArrayOfString1.append(", count = ");
      paramArrayOfString1.append(j);
      paramArrayOfString1.append(", rs = ");
      paramArrayOfString1.append(k);
      paramArrayOfString1.append(", rscount = ");
      paramArrayOfString1.append(paramUri.size());
      QLog.d("OpenApi.Provider", 2, paramArrayOfString1.toString());
    }
    if (k != 0) {
      return a(k);
    }
    paramArrayOfString1 = new MatrixCursor(ApiConstants.Provider.b);
    paramString1 = paramUri.iterator();
    for (;;)
    {
      paramUri = paramArrayOfString1;
      if (!paramString1.hasNext()) {
        break;
      }
      paramArrayOfString1.addRow(((MessageItem)paramString1.next()).a());
      continue;
      return a(-6);
    }
    label2577:
    paramUri = new MatrixCursor(new String[] { "rs_code" });
    paramUri.addRow(new Object[] { Integer.valueOf(-5) });
    label2610:
    return paramUri;
    return a(-6);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.OpenApiProvider
 * JD-Core Version:    0.7.0.1
 */