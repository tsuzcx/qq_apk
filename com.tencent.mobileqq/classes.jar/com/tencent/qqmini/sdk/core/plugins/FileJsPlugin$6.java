package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdeu;
import bdfz;
import java.io.IOException;

class FileJsPlugin$6
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$6(FileJsPlugin paramFileJsPlugin, String paramString1, bdfz parambdfz, String paramString2, byte[] paramArrayOfByte, String paramString3) {}
  
  public String run()
  {
    if (!FileJsPlugin.access$300(this.this$0, this.val$encoding)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid encoding " + this.val$encoding);
    }
    if (bdeu.a().a(this.val$filePath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$filePath);
    }
    String str = bdeu.a().c(this.val$filePath);
    if (!TextUtils.isEmpty(str))
    {
      if (str.contains("miniprogramLog")) {
        return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      }
      try
      {
        if (FileJsPlugin.access$400(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str, true))
        {
          str = FileJsPlugin.access$200(this.this$0, this.val$req, null);
          return str;
        }
      }
      catch (IOException localIOException)
      {
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, localIOException.getMessage());
      }
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */