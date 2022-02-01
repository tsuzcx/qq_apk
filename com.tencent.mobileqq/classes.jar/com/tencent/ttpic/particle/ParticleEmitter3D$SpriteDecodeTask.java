package com.tencent.ttpic.particle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.io.File;

@Deprecated
class ParticleEmitter3D$SpriteDecodeTask
  extends AsyncTask<Void, Void, Void>
{
  String folder;
  ParticleConfig.ParticleEmitterConfigBean.Sprite sprite;
  
  public ParticleEmitter3D$SpriteDecodeTask(ParticleEmitter3D paramParticleEmitter3D, String paramString, ParticleConfig.ParticleEmitterConfigBean.Sprite paramSprite)
  {
    this.folder = paramString;
    this.sprite = paramSprite;
  }
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    String str;
    int i;
    if (this.sprite != null)
    {
      str = this.folder + File.separator + this.sprite.path;
      i = -1;
    }
    label128:
    label136:
    label220:
    do
    {
      for (;;)
      {
        try
        {
          paramVarArgs = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), str, 1);
          BitmapFactory.Options localOptions;
          int k;
          localThrowable1.printStackTrace();
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            localOptions = new BitmapFactory.Options();
            localOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, localOptions);
            j = localOptions.outWidth;
            k = localOptions.outHeight;
            j /= this.sprite.width;
            i = j;
            j = 0;
            if (j >= this.sprite.frameCount) {
              break label220;
            }
            if (!isCancelled()) {
              break label136;
            }
            return null;
          }
          catch (Throwable localThrowable3)
          {
            int j;
            break label128;
          }
          localThrowable1 = localThrowable1;
          paramVarArgs = null;
        }
        continue;
        try
        {
          Bitmap localBitmap = Bitmap.createBitmap(paramVarArgs, j % i * this.sprite.width, j / i * this.sprite.height, this.sprite.width, this.sprite.height);
          if (!BitmapUtils.isLegal(localBitmap)) {
            j += 1;
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localThrowable2.printStackTrace();
            Object localObject = null;
            continue;
            ParticleEmitter3D.access$000(this.this$0)[j] = localObject;
          }
        }
      }
    } while (paramVarArgs == null);
    paramVarArgs.recycle();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleEmitter3D.SpriteDecodeTask
 * JD-Core Version:    0.7.0.1
 */