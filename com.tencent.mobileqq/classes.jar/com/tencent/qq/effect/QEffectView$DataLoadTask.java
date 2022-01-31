package com.tencent.qq.effect;

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
      if (paramVarArgs.type != 3) {
        break label55;
      }
      BaseQEffectLoad.analyzeLottieData(paramVarArgs, paramVarArgs.src);
    }
    for (;;)
    {
      return paramVarArgs;
      label55:
      if (paramVarArgs.type == 7) {
        BaseQEffectLoad.analyzeGLSLData(paramVarArgs, paramVarArgs.src, paramVarArgs.src);
      }
    }
  }
  
  protected void onPostExecute(QEffectData paramQEffectData)
  {
    if (paramQEffectData != null)
    {
      QEffectEngine.getInstance().load(QEffectView.access$000(this.this$0), this.this$0, QEffectView.access$300(this.this$0), paramQEffectData);
      QEffectEngine.getInstance().onAttachedToWindow(QEffectView.access$300(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.QEffectView.DataLoadTask
 * JD-Core Version:    0.7.0.1
 */