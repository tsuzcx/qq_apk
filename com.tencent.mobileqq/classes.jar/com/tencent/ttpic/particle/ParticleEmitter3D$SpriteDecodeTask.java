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
    if (this.sprite != null)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(this.folder);
      paramVarArgs.append(File.separator);
      paramVarArgs.append(this.sprite.path);
      String str = paramVarArgs.toString();
      int i = -1;
      try
      {
        paramVarArgs = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), str, 1);
        try
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(str, localOptions);
          j = localOptions.outWidth;
          int k = localOptions.outHeight;
          j /= this.sprite.width;
          i = j;
        }
        catch (Throwable localThrowable1) {}
        localThrowable2.printStackTrace();
      }
      catch (Throwable localThrowable2)
      {
        paramVarArgs = null;
      }
      int j = 0;
      while (j < this.sprite.frameCount)
      {
        if (isCancelled()) {
          return null;
        }
        Bitmap localBitmap2;
        try
        {
          Bitmap localBitmap1 = Bitmap.createBitmap(paramVarArgs, j % i * this.sprite.width, j / i * this.sprite.height, this.sprite.width, this.sprite.height);
        }
        catch (Throwable localThrowable3)
        {
          localThrowable3.printStackTrace();
          localBitmap2 = null;
        }
        if (BitmapUtils.isLegal(localBitmap2)) {
          ParticleEmitter3D.access$000(this.this$0)[j] = localBitmap2;
        }
        j += 1;
      }
      if (paramVarArgs != null) {
        paramVarArgs.recycle();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleEmitter3D.SpriteDecodeTask
 * JD-Core Version:    0.7.0.1
 */