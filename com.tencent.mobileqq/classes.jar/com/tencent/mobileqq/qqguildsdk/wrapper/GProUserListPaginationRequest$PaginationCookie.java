package com.tencent.mobileqq.qqguildsdk.wrapper;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

class GProUserListPaginationRequest$PaginationCookie
{
  private static final AtomicInteger a = new AtomicInteger(0);
  private String b;
  private String c;
  private byte[] d;
  
  static PaginationCookie a(String paramString, byte[] paramArrayOfByte)
  {
    PaginationCookie localPaginationCookie = new PaginationCookie();
    localPaginationCookie.b = String.format(Locale.getDefault(), "REQUEST-%08d", new Object[] { Integer.valueOf(a.incrementAndGet()) });
    localPaginationCookie.c = paramString;
    localPaginationCookie.d = paramArrayOfByte;
    return localPaginationCookie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListPaginationRequest.PaginationCookie
 * JD-Core Version:    0.7.0.1
 */