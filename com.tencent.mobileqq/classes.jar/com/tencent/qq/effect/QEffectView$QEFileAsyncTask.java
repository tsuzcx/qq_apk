package com.tencent.qq.effect;

import android.os.AsyncTask;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.engine.QEffectEngine;
import com.tencent.qq.effect.engine.QEffectEngine.JsonConvert;
import com.tencent.qq.effect.engine.QEffectProto;
import com.tencent.qq.effect.sensor.GravitySensor;
import com.tencent.qq.effect.utils.QEffectUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class QEffectView$QEFileAsyncTask
  extends AsyncTask<String, Void, List<QEffectData>>
{
  QEffectView$QEFileAsyncTask(QEffectView paramQEffectView) {}
  
  protected List<QEffectData> doInBackground(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    Object localObject1 = new File(paramVarArgs);
    Object localObject2 = QEffectEngine.getInstance().getCacheFileDir(QEffectView.access$000(this.this$0));
    try
    {
      if (!((File)localObject1).exists()) {
        return null;
      }
      boolean bool = ((File)localObject1).isDirectory();
      if (bool)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramVarArgs);
        ((StringBuilder)localObject1).append("/main.json");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else if ((((File)localObject1).isFile()) && (((File)localObject1).getName().equals("main.json")))
      {
        localObject2 = ((File)localObject1).getAbsolutePath().replace("/main.json", "");
        localObject1 = paramVarArgs;
        paramVarArgs = (String[])localObject2;
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append((String)localObject2);
        paramVarArgs.append("/");
        paramVarArgs.append(((File)localObject1).getName());
        paramVarArgs = paramVarArgs.toString();
        localObject2 = new File(paramVarArgs);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdir();
        }
        QEffectUtils.upZipFile((File)localObject1, paramVarArgs);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramVarArgs);
        ((StringBuilder)localObject1).append("/main.json");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = QEffectUtils.readFile((String)localObject1);
      localObject2 = QEffectEngine.getInstance().getJsonConvert();
      if (localObject2 == null) {
        return null;
      }
      localObject1 = (QEffectProto)((QEffectEngine.JsonConvert)localObject2).parseObject((String)localObject1, QEffectProto.class);
      if ((((QEffectProto)localObject1).minVer >= 1) && (((QEffectProto)localObject1).eles != null) && (((QEffectProto)localObject1).eles.size() != 0))
      {
        localObject2 = ((QEffectProto)localObject1).eles.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (QEffectData)((Iterator)localObject2).next();
          if (((QEffectData)localObject3).resType == 1)
          {
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramVarArgs);
            ((StringBuilder)localObject4).append("/");
            ((StringBuilder)localObject4).append(((QEffectData)localObject3).src);
            localObject4 = ((StringBuilder)localObject4).toString();
            if (!new File((String)localObject4).exists())
            {
              ((QEffectData)localObject3).src = null;
              continue;
            }
            if (((QEffectData)localObject3).type == 3) {
              BaseQEffectLoad.analyzeLottieData((QEffectData)localObject3, (String)localObject4);
            } else if (((QEffectData)localObject3).type == 7) {
              BaseQEffectLoad.analyzeGLSLData((QEffectData)localObject3, paramVarArgs, (String)localObject4);
            } else {
              ((QEffectData)localObject3).src = ((String)localObject4);
            }
          }
          if (((QEffectData)localObject3).gravity) {
            QEffectEngine.getInstance().getGravitySensor().init(QEffectView.access$000(this.this$0));
          }
        }
        return ((QEffectProto)localObject1).eles;
      }
      localObject2 = this.this$0;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramVarArgs);
      ((StringBuilder)localObject3).append("/");
      ((StringBuilder)localObject3).append(((QEffectProto)localObject1).defImg);
      QEffectView.access$102((QEffectView)localObject2, ((StringBuilder)localObject3).toString());
      return null;
    }
    catch (IOException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return null;
  }
  
  protected void onPostExecute(List<QEffectData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      QEffectView.access$200(this.this$0, paramList);
      return;
    }
    if (QEffectView.access$100(this.this$0) != null)
    {
      paramList = this.this$0;
      paramList.setSrc(QEffectView.access$100(paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.QEffectView.QEFileAsyncTask
 * JD-Core Version:    0.7.0.1
 */