package com.tencent.qq.effect;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.engine.QEffectEngine;
import java.io.File;

class QEffectView$DataLoadTask
  extends AsyncTask<QEffectData, Void, QEffectData>
{
  QEffectView$DataLoadTask(QEffectView paramQEffectView) {}
  
  protected QEffectData doInBackground(QEffectData... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    if (paramVarArgs.resType == 1)
    {
      if (!new File(paramVarArgs.src).exists())
      {
        paramVarArgs.src = null;
        return null;
      }
      if (paramVarArgs.type == 3)
      {
        BaseQEffectLoad.analyzeLottieData(paramVarArgs, paramVarArgs.src);
        return paramVarArgs;
      }
      if (paramVarArgs.type == 7) {
        BaseQEffectLoad.analyzeGLSLData(paramVarArgs, paramVarArgs.src, paramVarArgs.src);
      }
    }
    return paramVarArgs;
  }
  
  protected void onPostExecute(QEffectData paramQEffectData)
  {
    if (paramQEffectData != null)
    {
      QEffectEngine localQEffectEngine = QEffectEngine.getInstance();
      Context localContext = QEffectView.access$000(this.this$0);
      QEffectView localQEffectView = this.this$0;
      localQEffectEngine.load(localContext, localQEffectView, QEffectView.access$300(localQEffectView), paramQEffectData);
      QEffectEngine.getInstance().onAttachedToWindow(QEffectView.access$300(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.QEffectView.DataLoadTask
 * JD-Core Version:    0.7.0.1
 */