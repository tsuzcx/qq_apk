package com.tencent.mobileqq.cmshow.brickengine.apollo;

class ApolloRenderDriver$2
  extends IApolloRunnableTask
{
  ApolloRenderDriver$2(ApolloRenderDriver paramApolloRenderDriver) {}
  
  public void run()
  {
    String str;
    if (this.this$0.g > 0)
    {
      double d1 = this.this$0.e;
      Double.isNaN(d1);
      d1 = 60.0D / d1;
      double d2 = this.this$0.e;
      Double.isNaN(d2);
      str = String.format("mainTicker.interval = %f;mainTicker.paused = false;renderTicker.paused = false;renderTicker.interval = %f;BK.Director.tickerResume();", new Object[] { Double.valueOf(d1), Double.valueOf(60.0D / d2) });
    }
    else
    {
      str = String.format("var tickerIntervar = %d; if(BK.Director.ticker){BK.Director.ticker.interval = tickerIntervar; BK.Director.ticker.paused = false; } if (\"undefined\" != typeof renderTicker){renderTicker.interval = tickerIntervar; renderTicker.paused = false; } BK.Director.tickerSetInterval(tickerIntervar); if(BK.Director.tickerResume){BK.Director.tickerResume(); }", new Object[] { Integer.valueOf(60 / this.this$0.e) });
    }
    this.this$0.b.execScriptString(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderDriver.2
 * JD-Core Version:    0.7.0.1
 */