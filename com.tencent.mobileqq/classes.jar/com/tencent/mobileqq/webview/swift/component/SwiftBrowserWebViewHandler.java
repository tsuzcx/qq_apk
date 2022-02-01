package com.tencent.mobileqq.webview.swift.component;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SwiftBrowserWebViewHandler
{
  static SwiftBrowserWebViewHandler c;
  final AtomicInteger a = new AtomicInteger(1);
  final CopyOnWriteArrayList<SwiftBrowserWebViewHandler.AsyncInitWebViewCallback> b = new CopyOnWriteArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserWebViewHandler
 * JD-Core Version:    0.7.0.1
 */