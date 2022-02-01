package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.MySelfNormalItemRedPointInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class KandianMergeManager$37
  implements Runnable
{
  KandianMergeManager$37(KandianMergeManager paramKandianMergeManager, MySelfNormalItemRedPointInfo paramMySelfNormalItemRedPointInfo) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = RIJSPUtils.a(KandianMergeManager.c(this.this$0), true, false).edit();
    Object localObject = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream((OutputStream)localObject).writeObject(this.a);
      localObject = new String(Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 0));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("kandian_myself_red_point");
      localStringBuilder.append(this.a.itemId);
      localEditor.putString(localStringBuilder.toString(), (String)localObject);
      RIJSPUtils.a(localEditor, true);
      return;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("writeToSpMySelfRedPointInfo:");
        ((StringBuilder)localObject).append(localIOException.toString());
        QLog.e("KandianMergeManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.37
 * JD-Core Version:    0.7.0.1
 */