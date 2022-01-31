package com.tencent.qapmsdk.socket.handler;

public class PathResolver
{
  public static final IPathResolver DEFAULT = new PathResolver.DefaultPathResolver(null);
  private static IPathResolver sPathResolver = DEFAULT;
  
  public static IPathResolver getPathResolver()
  {
    return sPathResolver;
  }
  
  public static void setPathResolver(IPathResolver paramIPathResolver)
  {
    sPathResolver = paramIPathResolver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.PathResolver
 * JD-Core Version:    0.7.0.1
 */