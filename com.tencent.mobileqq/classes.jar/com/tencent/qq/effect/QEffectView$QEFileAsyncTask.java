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
    label387:
    label414:
    label444:
    for (;;)
    {
      QEffectData localQEffectData;
      String str;
      try
      {
        if (!((File)localObject1).exists()) {
          return null;
        }
        if (((File)localObject1).isDirectory())
        {
          localObject1 = paramVarArgs + "/main.json";
          localObject1 = QEffectUtils.readFile((String)localObject1);
          localObject2 = QEffectEngine.getInstance().getJsonConvert();
          if (localObject2 == null) {
            return null;
          }
        }
        else
        {
          if ((((File)localObject1).isFile()) && (((File)localObject1).getName().equals("main.json")))
          {
            localObject2 = ((File)localObject1).getAbsolutePath().replace("/main.json", "");
            localObject1 = paramVarArgs;
            paramVarArgs = (String[])localObject2;
            continue;
          }
          paramVarArgs = (String)localObject2 + "/" + ((File)localObject1).getName();
          localObject2 = new File(paramVarArgs);
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdir();
          }
          QEffectUtils.upZipFile((File)localObject1, paramVarArgs);
          localObject1 = paramVarArgs + "/main.json";
          continue;
        }
        localObject1 = (QEffectProto)((QEffectEngine.JsonConvert)localObject2).parseObject((String)localObject1, QEffectProto.class);
        if ((((QEffectProto)localObject1).minVer < 1) || (((QEffectProto)localObject1).eles == null) || (((QEffectProto)localObject1).eles.size() == 0))
        {
          QEffectView.access$102(this.this$0, paramVarArgs + "/" + ((QEffectProto)localObject1).defImg);
          return null;
        }
        localObject2 = ((QEffectProto)localObject1).eles.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localQEffectData = (QEffectData)((Iterator)localObject2).next();
        if (localQEffectData.resType != 1) {
          break label387;
        }
        str = paramVarArgs + "/" + localQEffectData.src;
        if (!new File(str).exists())
        {
          localQEffectData.src = null;
          continue;
        }
        if (localQEffectData.type != 3) {
          break label414;
        }
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return null;
      }
      BaseQEffectLoad.analyzeLottieData(localQEffectData, str);
      for (;;)
      {
        if (!localQEffectData.gravity) {
          break label444;
        }
        QEffectEngine.getInstance().getGravitySensor().init(QEffectView.access$000(this.this$0));
        break;
        if (localQEffectData.type == 7) {
          BaseQEffectLoad.analyzeGLSLData(localQEffectData, paramVarArgs, str);
        } else {
          localQEffectData.src = str;
        }
      }
    }
    return ((QEffectProto)localObject1).eles;
  }
  
  protected void onPostExecute(List<QEffectData> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      QEffectView.access$200(this.this$0, paramList);
    }
    while (QEffectView.access$100(this.this$0) == null) {
      return;
    }
    this.this$0.setSrc(QEffectView.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.QEffectView.QEFileAsyncTask
 * JD-Core Version:    0.7.0.1
 */