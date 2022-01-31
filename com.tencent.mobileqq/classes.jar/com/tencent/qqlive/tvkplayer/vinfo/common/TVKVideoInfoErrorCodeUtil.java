package com.tencent.qqlive.tvkplayer.vinfo.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.xmlpull.v1.XmlPullParserException;

public class TVKVideoInfoErrorCodeUtil
{
  public static int getErrCodeByThrowable(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      if ((paramThrowable instanceof SocketTimeoutException)) {}
      do
      {
        return 5;
        if ((paramThrowable instanceof UnknownHostException)) {
          return 2;
        }
        if ((paramThrowable instanceof FileNotFoundException)) {
          return 8;
        }
        if ((paramThrowable instanceof ConnectException))
        {
          if (paramThrowable.toString().contains("Network is unreachable")) {
            return 22;
          }
          return 3;
        }
        if ((paramThrowable instanceof SSLException)) {
          return 16;
        }
        if (paramThrowable.toString().contains("SSLHandshakeException")) {
          return 17;
        }
        if (paramThrowable.toString().contains("SSLKeyException")) {
          return 18;
        }
        if (paramThrowable.toString().contains("SSLPeerUnverifiedException")) {
          return 19;
        }
        if (paramThrowable.toString().contains("SSLProtocolException")) {
          return 20;
        }
        if ((paramThrowable instanceof SocketException)) {
          return 21;
        }
        if (!(paramThrowable instanceof IOException)) {
          break;
        }
        if (paramThrowable.toString().contains("UnknownHostException")) {
          return 2;
        }
      } while (paramThrowable.toString().contains("SocketTimeoutException"));
      if (paramThrowable.toString().contains("ConnectException")) {
        return 3;
      }
      if (paramThrowable.toString().contains("SSLException")) {
        return 16;
      }
      if (paramThrowable.toString().contains("SSLHandshakeException")) {
        return 17;
      }
      if (paramThrowable.toString().contains("SSLKeyException")) {
        return 18;
      }
      if (paramThrowable.toString().contains("SSLPeerUnverifiedException")) {
        return 19;
      }
      if (paramThrowable.toString().contains("SSLProtocolException")) {
        return 20;
      }
      if (paramThrowable.toString().contains("SocketException")) {
        return 21;
      }
      return 6;
      if ((paramThrowable instanceof XmlPullParserException)) {
        return 15;
      }
      if ((paramThrowable instanceof UnsupportedEncodingException)) {
        return 15;
      }
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoErrorCodeUtil
 * JD-Core Version:    0.7.0.1
 */