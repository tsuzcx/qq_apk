package mqq.app.api;

import mqq.app.AppRuntime;

public abstract interface IRuntimeService
{
  public abstract void onCreate(AppRuntime paramAppRuntime);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.api.IRuntimeService
 * JD-Core Version:    0.7.0.1
 */