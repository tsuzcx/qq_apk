package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import aswb;
import aswe;
import java.io.File;

public class MusicGeneWebViewPlugin$5
  implements Runnable
{
  public MusicGeneWebViewPlugin$5(aswe paramaswe, String paramString, int paramInt, File paramFile) {}
  
  public void run()
  {
    Object localObject1 = aswe.a(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {
      if (this.jdField_a_of_type_Int <= 0) {
        break label87;
      }
    }
    label87:
    for (int i = this.jdField_a_of_type_Int;; i = 5)
    {
      Object localObject2 = aswb.a((Bitmap)localObject1, 3, i, i);
      aswe.a(this.this$0, (Bitmap)localObject2);
      localObject1 = Message.obtain(aswe.a(this.this$0));
      ((Message)localObject1).obj = localObject2;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("BUNDLE_KEY_FILE_PATH", this.jdField_a_of_type_JavaIoFile.getPath());
      ((Message)localObject1).setData((Bundle)localObject2);
      ((Message)localObject1).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin.5
 * JD-Core Version:    0.7.0.1
 */