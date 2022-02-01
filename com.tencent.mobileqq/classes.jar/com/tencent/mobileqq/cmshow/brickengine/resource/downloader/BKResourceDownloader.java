package com.tencent.mobileqq.cmshow.brickengine.resource.downloader;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.resource.downloader.AbsApolloResDownloader;

public class BKResourceDownloader
  extends AbsApolloResDownloader
{
  private IApolloResManager d;
  
  @NonNull
  public IApolloResManager a()
  {
    if (this.d == null) {
      this.d = ApolloResManagerFacade.a.a(EngineType.BK);
    }
    return this.d;
  }
  
  protected String b()
  {
    return "[cmshow][BKResourceDownloader]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.resource.downloader.BKResourceDownloader
 * JD-Core Version:    0.7.0.1
 */