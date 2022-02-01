package com.tencent.widget;

import java.lang.reflect.Method;

public class TraceUtils
{
  public static final long TRACE_TAG_ACTIVITY_MANAGER = 64L;
  public static final long TRACE_TAG_ALWAYS = 1L;
  public static final long TRACE_TAG_APP = 4096L;
  public static final long TRACE_TAG_AUDIO = 256L;
  public static final long TRACE_TAG_CAMERA = 1024L;
  public static final long TRACE_TAG_DALVIK = 16384L;
  public static final long TRACE_TAG_GRAPHICS = 2L;
  public static final long TRACE_TAG_HAL = 2048L;
  public static final long TRACE_TAG_INPUT = 4L;
  public static final long TRACE_TAG_NEVER = 0L;
  private static final long TRACE_TAG_NOT_READY = -9223372036854775808L;
  public static final long TRACE_TAG_RESOURCES = 8192L;
  public static final long TRACE_TAG_RS = 32768L;
  public static final long TRACE_TAG_SYNC_MANAGER = 128L;
  public static final long TRACE_TAG_VIDEO = 512L;
  public static final long TRACE_TAG_VIEW = 8L;
  public static final long TRACE_TAG_WEBVIEW = 16L;
  public static final long TRACE_TAG_WINDOW_MANAGER = 32L;
  public static final boolean USE_TRACE = false;
  private static Method sAsyncTraceBegin;
  private static Method sAsyncTraceEnd;
  private static Method sMethodBegin;
  private static Method sMethodEnd;
  
  public static void asyncTraceBegin(long paramLong, String paramString, int paramInt) {}
  
  public static void asyncTraceEnd(long paramLong, String paramString, int paramInt) {}
  
  public static void traceBegin(String paramString) {}
  
  public static void traceEnd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.TraceUtils
 * JD-Core Version:    0.7.0.1
 */