package org.xwalk.core;

import android.os.AsyncTask;

class XWalkUpdater$BackgroundListener$1
  extends AsyncTask<Void, Void, Integer>
{
  XWalkUpdater$BackgroundListener$1(XWalkUpdater.BackgroundListener paramBackgroundListener) {}
  
  protected Integer doInBackground(Void... paramVarArgs)
  {
    return XWalkUpdater.onHandleFile(XWalkUpdater.BackgroundListener.access$100(this.this$1));
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    if (paramInteger.intValue() != 0)
    {
      XWalkUpdater.access$000(this.this$1.this$0).onXWalkUpdateFailed(paramInteger.intValue(), XWalkUpdater.BackgroundListener.access$100(this.this$1).scheduler);
      return;
    }
    XWalkUpdater.access$000(this.this$1.this$0).onXWalkUpdateCompleted(XWalkUpdater.BackgroundListener.access$100(this.this$1).scheduler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.BackgroundListener.1
 * JD-Core Version:    0.7.0.1
 */