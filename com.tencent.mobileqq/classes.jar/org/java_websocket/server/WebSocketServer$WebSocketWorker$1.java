package org.java_websocket.server;

import org.slf4j.Logger;

class WebSocketServer$WebSocketWorker$1
  implements Thread.UncaughtExceptionHandler
{
  WebSocketServer$WebSocketWorker$1(WebSocketServer.WebSocketWorker paramWebSocketWorker, WebSocketServer paramWebSocketServer) {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    WebSocketServer.access$000().error("Uncaught exception in thread {}: {}", paramThread.getName(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.server.WebSocketServer.WebSocketWorker.1
 * JD-Core Version:    0.7.0.1
 */